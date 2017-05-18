package com.quizappexam.app.testingcenter.data.database;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.quizappexam.app.testingcenter.models.Answer;
import com.quizappexam.app.testingcenter.models.Question;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//just a stub for now

public class DatabaseImpl implements Database {

    private static Database mDatabase;
    private DatabaseHelper databaseHelper;
    private static Context mContext;
    private Dao<Question, Integer> mQuestionDao;
    private Dao<Answer, Integer> mAnswerDao ;

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(mContext,DatabaseHelper.class);
        }
        return databaseHelper;
    }

    private DatabaseImpl() {
        getHelper();
    }

    public static Database getInstance(Context context) {
        if(mDatabase ==null) {
            mContext = context;
            mDatabase = new DatabaseImpl();

        }
        return mDatabase;
    }
    @Override
    public List<Question> getQuestions()  {

        List<Question> questions1= new ArrayList<>();
        try {
            mQuestionDao = getHelper().getQuestionRuntimeDao();
            mAnswerDao = getHelper().getAnswerRuntimeCollectionDao();



      /* run 1 time just to fill up the database
      for (int j = 0; j < 20; j++) {
           Log.d("jjj", String.valueOf(j));
            Question q1 = new Question();
            q1.setStatement("This is the " + j + " fake question for now");
            mQuestionDao.create(q1);

            for (int i = 0; i < 4; i++) {
                Answer a1 = new Answer();
                a1.setStatement("This is the " + i + " fake answer for now for Q "+j);
                a1.setCorrect(true);
                a1.setQuestion(q1);
                mAnswerDao.create(a1);
            }
        }*/
          questions1 = mQuestionDao.queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions1;
    }
}
