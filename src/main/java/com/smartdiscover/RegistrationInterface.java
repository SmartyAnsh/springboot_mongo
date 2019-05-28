package com.smartdiscover;

/**
 * Registration APIs to register and update user
 *
 * @param <ID>                  - String/long
 * @param <USER>                - User
 * @author anshulbansal
 */
public interface RegistrationInterface<ID, USER> {

    /**
     * Register User (validate and store) and returns the user object
     *
     * @param user
     * @return user
     * @throws Exception
     */
    USER registerUser(USER user) throws Exception;

    /**
     * Fetch user record using userId
     *
     * @param userId
     * @return user
     * @throws Exception
     */
    USER getUserData(ID userId) throws Exception;

    /**
     * Delete User record
     *
     * @param userId
     * @throws Exception
     */
    void deleteUser(ID userId) throws Exception;

}
