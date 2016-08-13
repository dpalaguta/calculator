package com.example.dmitry.calculator;

/**
 * Created by Dmitry on 10.08.2016.
 */
public interface IDatabaseHelper {
/*    void deleteAll(); // удаление всех записей из БД
    boolean isContain(String login); //есть ли данный логин в бд
    boolean isCorrectPassword(String login, String password); // проверка пароля*/
    boolean isIdentify(String login, String password);
    long addUser(UserData userData);



}
