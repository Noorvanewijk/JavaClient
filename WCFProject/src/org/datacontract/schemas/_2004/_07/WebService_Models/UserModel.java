/**
 * UserModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.WebService_Models;

public class UserModel  implements java.io.Serializable {
    private java.math.BigDecimal funds;

    private java.lang.Integer id;

    private java.lang.String password;

    private java.lang.String username;

    public UserModel() {
    }

    public UserModel(
           java.math.BigDecimal funds,
           java.lang.Integer id,
           java.lang.String password,
           java.lang.String username) {
           this.funds = funds;
           this.id = id;
           this.password = password;
           this.username = username;
    }


    /**
     * Gets the funds value for this UserModel.
     * 
     * @return funds
     */
    public java.math.BigDecimal getFunds() {
        return funds;
    }


    /**
     * Sets the funds value for this UserModel.
     * 
     * @param funds
     */
    public void setFunds(java.math.BigDecimal funds) {
        this.funds = funds;
    }


    /**
     * Gets the id value for this UserModel.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this UserModel.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the password value for this UserModel.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this UserModel.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the username value for this UserModel.
     * 
     * @return username
     */
    public java.lang.String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this UserModel.
     * 
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserModel)) return false;
        UserModel other = (UserModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.funds==null && other.getFunds()==null) || 
             (this.funds!=null &&
              this.funds.equals(other.getFunds()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.username==null && other.getUsername()==null) || 
             (this.username!=null &&
              this.username.equals(other.getUsername())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFunds() != null) {
            _hashCode += getFunds().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "UserModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("funds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "Funds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "Password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "Username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
