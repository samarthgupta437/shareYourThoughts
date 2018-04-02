package com.lifeisbeautiful.shareyourthoughts.biz.mongo;

import com.lifeisbeautiful.shareyourthoughts.api.UserAlreadyExistsException;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.IUser;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.User;
import com.lifeisbeautiful.shareyourthoughts.data.mongo.UserDao;
import com.lifeisbeautiful.shareyourthoughts.util.MongoUtil;
import org.bson.types.ObjectId;

/**
 * @author samarth.gupta .
 */
public class UserImpl implements IUser {

    UserDao userDao = new UserDao(User.class, MongoUtil.getDatastore());

    @Override
    public String add(User user) throws UserAlreadyExistsException {
        String userId = new ObjectId().toString();
        user.setId(userId);
        userDao.save(user);
        return userId;
    }
}
