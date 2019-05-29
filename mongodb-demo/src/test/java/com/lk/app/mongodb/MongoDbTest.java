package com.lk.app.mongodb;

import com.lk.app.mongodb.util.MongoDbUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LK
 * @date 2019/4/23
 */
public class MongoDbTest {

    private static final String DB_NAME = "test1";

    private static final String COLLECTION_NAME = "books";

    /**
     * 创建collection
     */
    @Test
    public void test0() {
        MongoDatabase database = MongoDbUtil.getDefaultDb(DB_NAME);
        database.createCollection(COLLECTION_NAME);
    }
    
    /**
     * 获取collection
     */
    @Test
    public void test1() {
        MongoDatabase database = MongoDbUtil.getDefaultDb(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        Assert.assertNotNull(collection);
    }


    /**
     * 插入文档
     */
    @Test
    public void test2() {
        MongoDatabase database = MongoDbUtil.getDefaultDb(DB_NAME);
//        database.createCollection(COLLECTION_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        Document document1 = new Document();
        document1.append("title", "深入理解Java虚拟机").append("price", 50).append("author", "周志明");

        collection.insertOne(document1);

        Document document2 = new Document("title", "深入理解计算机系统").append("price", 70).append("author", "xxx");
        Document document3 = new Document("title", "设计模式").append("price", 50).append("author", "aaa");
        List<Document> documentList = new ArrayList<>();
        documentList.add(document2);
        documentList.add(document3);

        collection.insertMany(documentList);

    }

    /**
     * 获取文档
     */
    @Test
    public void test3() {
        MongoDatabase database = MongoDbUtil.getDefaultDb(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            System.out.println(document);
        }

    }

    /**
     * 条件查询文档
     */
    @Test
    public void test4() {
        MongoDatabase database = MongoDbUtil.getDefaultDb(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        Bson bson = Filters.eq("price", 70);

        FindIterable<Document> documents = collection.find(bson);
        for (Document document : documents) {
            System.out.println(document);
        }

    }

    /**
     * 更新文档
     */
    @Test
    public void test5() {
        MongoDatabase database = MongoDbUtil.getDefaultDb(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        collection.updateOne(Filters.eq("author", "aaa"), new Document("$set", new Document("author", "sss")));

        for (Document document : collection.find()) {
            System.out.println(document);
        }

        System.out.println("----------------------------------------------");

        collection.updateMany(Filters.lte("price", 50), new Document("$inc", new Document("price", 10)));

        for (Document document : collection.find()) {
            System.out.println(document);
        }
    }

    /**
     * 删除文档
     */
    @Test
    public void test6() {
        MongoDatabase database = MongoDbUtil.getDefaultDb(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        collection.deleteOne(Filters.eq("price", 70));

        for (Document document : collection.find()) {
            System.out.println(document);
        }

        System.out.println("----------------------------------------------");

        collection.deleteMany(Filters.eq("price", 60));

        for (Document document : collection.find()) {
            System.out.println(document);
        }
    }
}
