/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DB.DataSourceMysql;
import Data.CupCakeDAO;
import Data.UserDAO;
import Mapper.UserMapper;

/**
 *
 * @author Obaydah Mohamad
 */
public class TEST {
    public static void main(String[] args) throws Exception {
        
        UserMapper.setDataSource(DataSourceMysql.getDataSource());
        
        System.out.println("GetUser: " + UserMapper.getUser("sne"));
        
    }
}
