package com.lk.app.mongodb.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LK
 * @date 2019/4/23
 */
public class MongoDbUtil {

    /**
     * 服务地址
     */
    private static final String HOST = "127.0.0.1";

    /**
     * mongodb服务端口
     */
    private static final int PORT = 27017;

    /**
     * 获取默认服务下的数据库
     * @param dbName
     * @return
     */
    public static MongoDatabase getDefaultDb(String dbName) {
        return new MongoClient(HOST, PORT).getDatabase(dbName);
    }

    /**
     * 获取指定用户下的数据库
     * @param username
     * @param password
     * @param dbName
     * @return
     */
    public static MongoDatabase getDb(String username, String password, String dbName) {
        ServerAddress serverAddress = new ServerAddress(HOST, PORT);
        List<ServerAddress> addressList = new ArrayList<>();
        addressList.add(serverAddress);

        MongoCredential credential = MongoCredential.createScramSha1Credential(username, dbName, password.toCharArray());
        List<MongoCredential> credentialList = new ArrayList<>();
        credentialList.add(credential);

        MongoClient client = new MongoClient(addressList, credentialList);

        return client.getDatabase(dbName);
    }
}
