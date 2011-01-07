/*******************************************************************************
 * Copyright (c) 1998, 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.testing.tests.unwrappedconnection;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

import oracle.jdbc.OracleConnection;

/**
 * This class provides a wrapper around a  real Oracle Connection to allow eclipselink
 * unwrap functionality to be tested.
 */

public class TestOracleConnection implements Connection{
    
    OracleConnection conn;
    public TestOracleConnection(OracleConnection connection){
        conn = connection;
    }

    public void clearWarnings() throws SQLException {
       conn.clearWarnings();
    }
    public void close() throws SQLException {
        conn.close();
    }
    public void commit() throws SQLException {
        conn.commit();
    }
    public Statement createStatement() throws SQLException {
        return new TestStatement(conn.createStatement());
    }
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return new TestStatement(conn.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability));
    }
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return new TestStatement(conn.createStatement(resultSetType, resultSetConcurrency));
    }
    public boolean getAutoCommit() throws SQLException {
        return conn.getAutoCommit();
    }
    public String getCatalog() throws SQLException {
        return conn.getCatalog();
    }
    public int getHoldability() throws SQLException {
        return conn.getHoldability();
        
    }
    public DatabaseMetaData getMetaData() throws SQLException {
        return conn.getMetaData();
    }
    public int getTransactionIsolation() throws SQLException {
        return conn.getTransactionIsolation();
    }
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return getTypeMap();
    }
    public SQLWarning getWarnings() throws SQLException {
        return conn.getWarnings();
    }
    public boolean isClosed() throws SQLException {
        return conn.isClosed();
    }
    public boolean isReadOnly() throws SQLException {
        return conn.isReadOnly();
    }
    public String nativeSQL(String sql) throws SQLException {
        return conn.nativeSQL(sql);
    }
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return conn.prepareCall(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
    }
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return conn.prepareCall(sql,resultSetType,resultSetConcurrency);
    }
    public CallableStatement prepareCall(String sql) throws SQLException {
        return conn.prepareCall(sql);
    }
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return new TestPreparedStatement(conn.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
    }
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return new TestPreparedStatement(conn.prepareStatement(sql, resultSetType, resultSetConcurrency));
    }
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return new TestPreparedStatement(conn.prepareStatement(sql, autoGeneratedKeys));
    }
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return new TestPreparedStatement(conn.prepareStatement(sql, columnIndexes));
    }
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return new TestPreparedStatement(conn.prepareStatement(sql, columnNames));
    }
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return new TestPreparedStatement(conn.prepareStatement(sql));
    }
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        conn.releaseSavepoint(savepoint);
    }
    public void rollback() throws SQLException {
        conn.rollback();
    }
    public void rollback(Savepoint savepoint) throws SQLException {
        conn.rollback(savepoint);
    }
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        conn.setAutoCommit(autoCommit);
    }
    public void setCatalog(String catalog) throws SQLException {
        conn.setCatalog(catalog);
    }
    public void setHoldability(int holdability) throws SQLException {
        conn.setHoldability(holdability);
    }
    public void setReadOnly(boolean readOnly) throws SQLException {
        conn.setReadOnly(readOnly);
    }
    public Savepoint setSavepoint() throws SQLException {
        return conn.setSavepoint();
    }

    public Savepoint setSavepoint(String name) throws SQLException {
        return conn.setSavepoint(name);
    }

    public void setTransactionIsolation(int level) throws SQLException {
        conn.setTransactionIsolation(level);
        
    }

    public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
        conn.setTypeMap(arg0);
    }
    
    public Connection getPhysicalConnection(){
        return conn;
    }
    
    // 236070: Methods introduced in JDK 1.6
    public Array createArrayOf(String typeName, Object[] elements) {
        return null;
    }

    public Blob createBlob() {
        return null;
    }

    public Clob createClob() {
        return null;
    }

    public NClob createNClob() {
        return null;
    }

    public SQLXML createSQLXML() {
        return null;
    }

    public Struct createStruct(String typeName, Object[] attributes) {
        return null;
    }

    public Properties getClientInfo() {
        return null;
    }

    public String getClientInfo(String name) {
        return null;
    }
    
    public boolean isValid(int timeout) {
        return false;
    }

    public void setClientInfo(String name, String value) {
    }

    public void setClientInfo(Properties properties) {
    }
    
    // From java.sql.Wrapper
    public boolean isWrapperFor(Class<?> iFace) throws SQLException{
        return false;
    }

    public <T>T unwrap(Class<T> iFace)  throws SQLException {
        return iFace.cast(this);
    }    
    
}
