package com.prog.repository;

import com.mongodb.BasicDBObject;
import com.prog.repository.mongo.client.MongoClientUtils;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public boolean count(String username, String password) {
        BasicDBObject query = new BasicDBObject();
        query.append("Username", username);
        query.append("Password", password);
        return MongoClientUtils.getCollection("collection", "User1").countDocuments(query) > 0;
    }
}
