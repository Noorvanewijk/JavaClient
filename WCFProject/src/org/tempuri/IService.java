/**
 * IService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface IService extends java.rmi.Remote {
    public org.datacontract.schemas._2004._07.WebService_Models.ProductModel[] getAllProducts() throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.WebService_Models.ProductModel getProductById(java.lang.Integer id) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.WebService_Models.UserModel[] getAll() throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.WebService_Models.UserModel getUserById(java.lang.Integer id) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.WebService_Models.UserModel registerUser(java.lang.String username) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.WebService_Models.UserModel loginUser(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.WebService_Models.TransactionModel[] getAllTransactions() throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.WebService_Models.TransactionModel getTransactionById(java.lang.Integer id) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.WebService_Models.TransactionModel createNewTransaction(java.lang.Integer userId, int[] productIds, int[] productAmounts) throws java.rmi.RemoteException;
}
