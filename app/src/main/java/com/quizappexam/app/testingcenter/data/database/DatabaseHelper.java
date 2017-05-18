package com.quizappexam.app.testingcenter.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.quizappexam.app.testingcenter.R;
import com.quizappexam.app.testingcenter.models.Answer;
import com.quizappexam.app.testingcenter.models.Question;

import java.sql.SQLException;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {


    private static final String DATABASE_NAME = "testCenter2.db";

    private static final int DATABASE_VERSION = 1;

    private Dao<Question,Integer> questionDao =  null;
    private RuntimeExceptionDao<Question,Integer> questionRuntimeDao=null;

    private Dao<Answer,Integer> answerDao =  null;
    private RuntimeExceptionDao<Answer,Integer> answerRuntimeDao=null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Question.class);
            TableUtils.createTableIfNotExists(connectionSource, Answer.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,Question.class,true);
            TableUtils.dropTable(connectionSource, Answer.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Dao<Question,Integer> getQuestionDao() throws SQLException {
        if(questionDao==null) {
            questionDao = getDao(Question.class);
        }
        return questionDao;
    }
    public RuntimeExceptionDao<Question,Integer> getQuestionRuntimeDao() throws SQLException {
        if(questionRuntimeDao==null) {
            questionRuntimeDao = getRuntimeExceptionDao(Question.class);
        }
        return questionRuntimeDao;
    }


    public Dao<Answer,Integer> getAnswerDao() throws SQLException {
        if(answerDao==null) {
            answerDao = getDao(Answer.class);
        }
        return answerDao;
    }

    public RuntimeExceptionDao<Answer,Integer> getAnswerRuntimeCollectionDao() throws SQLException {
        if(answerRuntimeDao==null) {
            answerRuntimeDao = getRuntimeExceptionDao(Answer.class);
        }
        return answerRuntimeDao;
    }
}
