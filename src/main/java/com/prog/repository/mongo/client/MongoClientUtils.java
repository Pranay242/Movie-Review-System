package com.prog.repository.mongo.client;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoClientUtils {
    public static MongoCollection<Document> getCollection(String collectionName, String dbName) {
        return MongoClientUtils.getMongoClient().getDatabase(dbName).getCollection(collectionName);
    }
    public static MongoClient  getMongoClient() {

        // Connection string to your MongoDB server
        String connectionString = "mongodb://localhost:27017/user1";

        // Create MongoClientSettings
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .build();

        // Create MongoClient using the factory method
        MongoClient mongoClient = MongoClients.create(settings);

        return mongoClient;
    }

}
