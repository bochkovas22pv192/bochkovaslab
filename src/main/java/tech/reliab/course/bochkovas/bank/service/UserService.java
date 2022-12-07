package tech.reliab.course.bochkovas.bank.service;

import tech.reliab.course.bochkovas.bank.entity.Bank;
import tech.reliab.course.bochkovas.bank.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @param bank - банк
     * @return - возвращает созданный объект клиент
     */
    User create(String firstName, String lastName, LocalDate birthDate, String job, Bank bank);
    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param patronymic - отчество
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @param bank - банк
     * @return - возвращает созданный объект клиент
     */
    User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job, Bank bank);

    /**
     *
     * @return список пользователей
     */
    List<User> findAll();

    /**
     * добавляет пользователя в коллекцию
     * @param user - пользователь
     */
    void addUser(User user);

    /**
     *
     * @param id - id пользователя
     * @return пользователя с данным id
     */
    User getUserById(Long id);

    /**
     * удаляет пользователя с данным id
     * @param id - id пользователя
     */
    void delUserById(Long id);

    /**
     * выводит на экран информацию о пользователе
     * @param id - id пользователя
     */
    void outputUserInfo(Long id);
}
