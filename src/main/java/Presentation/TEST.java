/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.UserDAO;

/**
 *
 * @author Obaydah Mohamad
 */
public class TEST {
    public static void main(String[] args) {
        UserDAO DAO = new UserDAO();
        System.out.println(DAO.getUser("sne").getBalance());
        DAO.insertUser("John", "JohnJohn", 1000000);
        System.out.println(DAO.getUser("John").getBalance());
    }
}
