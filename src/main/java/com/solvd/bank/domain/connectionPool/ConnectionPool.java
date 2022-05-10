package com.solvd.bank.domain.connectionPool;

import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private final static ConnectionPool INSTANCE = new ConnectionPool();
    private BlockingQueue<Object> connections;

    private ConnectionPool(){

    }

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    public Object getConnection() {
        return connections.remove();
    }

    public void retriveConnection(Object connection) {
        connections.add(connection);
    }

}
