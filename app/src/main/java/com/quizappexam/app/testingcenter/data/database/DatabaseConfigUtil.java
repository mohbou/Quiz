package com.quizappexam.app.testingcenter.data.database;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.quizappexam.app.testingcenter.models.Answer;
import com.quizappexam.app.testingcenter.models.Question;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DatabaseConfigUtil extends OrmLiteConfigUtil{

    private static final Class<?>[] classes = new Class[]{Answer.class,Question.class};

    public static void main(String[] args) throws IOException, SQLException {
        String currDirectory = "user.dir";
        String configPath = "/res/raw/ormlite_config.txt";
        String projectRoot = System.getProperty(currDirectory);
        System.out.println("projectRoot "+projectRoot);
        String fullConfigPath = projectRoot + configPath;
        System.out.println("fullConfigPath "+fullConfigPath);
        File configFile = new File("C:\\androidDev3\\TestingCenter\\app\\src\\main\\res\\raw\\ormlite_config.txt");
        if(configFile.exists()) {


            configFile.delete();


            configFile = new File("C:\\androidDev3\\TestingCenter\\app\\src\\main\\res\\raw\\ormlite_config.txt");


        }
        writeConfigFile(configFile,classes);

    }
}
