package com.ps.repository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionManager {
    static DataSource getDBConnection()throws NamingException{
        Context context=new InitialContext();
        return (DataSource)context.lookup("java:comp/env/jdbc/udemy_clone");
    }
}
