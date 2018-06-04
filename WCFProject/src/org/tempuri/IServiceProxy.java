package org.tempuri;

public class IServiceProxy implements org.tempuri.IService {
  private String _endpoint = null;
  private org.tempuri.IService iService = null;
  
  public IServiceProxy() {
    _initIServiceProxy();
  }
  
  public IServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIServiceProxy();
  }
  
  private void _initIServiceProxy() {
    try {
      iService = (new org.tempuri.ServiceLocator()).getBasicHttpBinding_IService();
      if (iService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iService != null)
      ((javax.xml.rpc.Stub)iService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.IService getIService() {
    if (iService == null)
      _initIServiceProxy();
    return iService;
  }
  
  public org.datacontract.schemas._2004._07.WebService_Models.ProductModel[] getAllProducts() throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.getAllProducts();
  }
  
  public org.datacontract.schemas._2004._07.WebService_Models.ProductModel getProductById(java.lang.Integer id) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.getProductById(id);
  }
  
  public org.datacontract.schemas._2004._07.WebService_Models.UserModel[] getAll() throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.getAll();
  }
  
  public org.datacontract.schemas._2004._07.WebService_Models.UserModel getUserById(java.lang.Integer id) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.getUserById(id);
  }
  
  public org.datacontract.schemas._2004._07.WebService_Models.UserModel registerUser(java.lang.String username) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.registerUser(username);
  }
  
  public org.datacontract.schemas._2004._07.WebService_Models.UserModel loginUser(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.loginUser(username, password);
  }
  
  public org.datacontract.schemas._2004._07.WebService_Models.TransactionModel[] getAllTransactions() throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.getAllTransactions();
  }
  
  public org.datacontract.schemas._2004._07.WebService_Models.TransactionModel getTransactionById(java.lang.Integer id) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.getTransactionById(id);
  }
  
  public org.datacontract.schemas._2004._07.WebService_Models.TransactionModel createNewTransaction(java.lang.Integer userId, int[] productIds, int[] productAmounts) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.createNewTransaction(userId, productIds, productAmounts);
  }
  
  
}