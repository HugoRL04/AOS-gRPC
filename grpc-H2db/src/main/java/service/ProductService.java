package service;

import com.grpc.ej5.*;
import db.H2Database;
import io.grpc.stub.StreamObserver;

import java.sql.*;

public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    // 1. UNARY
    @Override
    public void getProductById(ProductIdRequest req,
                               StreamObserver<ProductResponse> obs) {

        System.out.println("[SERVER](UNARY) Recibido ID del cliente = " + req.getId());

        try (Connection conn = H2Database.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(
                    "SELECT id, name, price FROM productos WHERE id = ?");
            ps.setInt(1, req.getId());

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                obs.onError(new RuntimeException("Producto no encontrado"));
                return;
            }

            ProductResponse resp = ProductResponse.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .setPrice(rs.getDouble("price"))
                    .build();

            System.out.println("[SERVER](UNARY) Enviando producto → " + resp.getName());

            obs.onNext(resp);
            obs.onCompleted();

        } catch (Exception e) {
            obs.onError(e);
        }
    }


    // 2. SERVER STREAMING
    @Override
    public void streamCheaperProducts(PriceRequest req,
                                      StreamObserver<ProductResponse> obs) {

        System.out.println("[SERVER](SERVERSTREAMING) Recibido maxPrice = " + req.getMaxPrice());

        try (Connection conn = H2Database.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(
                    "SELECT id, name, price FROM productos WHERE price <= ?");
            ps.setDouble(1, req.getMaxPrice());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ProductResponse p = ProductResponse.newBuilder()
                        .setId(rs.getInt("id"))
                        .setName(rs.getString("name"))
                        .setPrice(rs.getDouble("price"))
                        .build();

                System.out.println("[SERVER](SERVERSTREAMING) Enviando → " + p.getName());

                obs.onNext(p);
            }

            obs.onCompleted();

        } catch (Exception e) {
            obs.onError(e);
        }
    }


    // 3. CLIENT STREAMING
    @Override
    public StreamObserver<NewProductRequest> insertProducts(
            StreamObserver<InsertSummary> obs) {

        return new StreamObserver<>() {

            int count = 0;

            @Override
            public void onNext(NewProductRequest req) {
                System.out.println("[SERVER](CLIENTSTREAMING) Recibido producto → " + req.getName());

                try (Connection conn = H2Database.getConnection()) {

                    PreparedStatement ps = conn.prepareStatement(
                            "INSERT INTO productos (name, price) VALUES (?, ?)");
                    ps.setString(1, req.getName());
                    ps.setDouble(2, req.getPrice());
                    ps.executeUpdate();

                    System.out.println("[SERVER](CLIENTSTREAMING) Insertado en BD");
                    count++;

                } catch (Exception e) {
                    obs.onError(e);
                }
            }

            @Override
            public void onCompleted() {
                System.out.println("[SERVER](CLIENTSTREAMING) Finalizando stream → total insertados = " + count);

                InsertSummary summary = InsertSummary.newBuilder()
                        .setInsertedCount(count)
                        .build();

                obs.onNext(summary);
                obs.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("[SERVER](CLIENTSTREAMING) Error → " + t.getMessage());
            }
        };
    }


    // 4. BIDI STREAMING
    @Override
    public StreamObserver<PriceRequest> livePriceQuery(
            StreamObserver<ProductResponse> obs) {

        return new StreamObserver<>() {

            @Override
            public void onNext(PriceRequest req) {
                System.out.println("[SERVER](BIDIRECTIONAL) Recibido maxPrice → " + req.getMaxPrice());

                try (Connection conn = H2Database.getConnection()) {

                    PreparedStatement ps = conn.prepareStatement(
                            "SELECT id, name, price FROM productos WHERE price <= ?");
                    ps.setDouble(1, req.getMaxPrice());

                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {

                        ProductResponse p = ProductResponse.newBuilder()
                                .setId(rs.getInt("id"))
                                .setName(rs.getString("name"))
                                .setPrice(rs.getDouble("price"))
                                .build();

                        System.out.println("[SERVER](BIDIRECTIONAL) Enviando → " + p.getName());

                        obs.onNext(p);
                    }

                } catch (Exception e) {
                    obs.onError(e);
                }
            }

            @Override
            public void onCompleted() {
                System.out.println("[SERVER](BIDIRECTIONAL) Cliente finalizó stream.");
                obs.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("[SERVER](BIDIRECTIONAL) Error → " + t.getMessage());
            }
        };
    }
}
