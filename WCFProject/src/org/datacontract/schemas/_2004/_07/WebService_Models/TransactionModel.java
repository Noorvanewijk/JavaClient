/**
 * TransactionModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.WebService_Models;

public class TransactionModel  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.WebService_Models.UserModel buyer;

    private java.lang.Integer id;

    private org.datacontract.schemas._2004._07.WebService_Models.TransactionRowModel[] purchasedProducts;

    private java.math.BigDecimal totalPrice;

    public TransactionModel() {
    }

    public TransactionModel(
           org.datacontract.schemas._2004._07.WebService_Models.UserModel buyer,
           java.lang.Integer id,
           org.datacontract.schemas._2004._07.WebService_Models.TransactionRowModel[] purchasedProducts,
           java.math.BigDecimal totalPrice) {
           this.buyer = buyer;
           this.id = id;
           this.purchasedProducts = purchasedProducts;
           this.totalPrice = totalPrice;
    }


    /**
     * Gets the buyer value for this TransactionModel.
     * 
     * @return buyer
     */
    public org.datacontract.schemas._2004._07.WebService_Models.UserModel getBuyer() {
        return buyer;
    }


    /**
     * Sets the buyer value for this TransactionModel.
     * 
     * @param buyer
     */
    public void setBuyer(org.datacontract.schemas._2004._07.WebService_Models.UserModel buyer) {
        this.buyer = buyer;
    }


    /**
     * Gets the id value for this TransactionModel.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this TransactionModel.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the purchasedProducts value for this TransactionModel.
     * 
     * @return purchasedProducts
     */
    public org.datacontract.schemas._2004._07.WebService_Models.TransactionRowModel[] getPurchasedProducts() {
        return purchasedProducts;
    }


    /**
     * Sets the purchasedProducts value for this TransactionModel.
     * 
     * @param purchasedProducts
     */
    public void setPurchasedProducts(org.datacontract.schemas._2004._07.WebService_Models.TransactionRowModel[] purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }


    /**
     * Gets the totalPrice value for this TransactionModel.
     * 
     * @return totalPrice
     */
    public java.math.BigDecimal getTotalPrice() {
        return totalPrice;
    }


    /**
     * Sets the totalPrice value for this TransactionModel.
     * 
     * @param totalPrice
     */
    public void setTotalPrice(java.math.BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransactionModel)) return false;
        TransactionModel other = (TransactionModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.buyer==null && other.getBuyer()==null) || 
             (this.buyer!=null &&
              this.buyer.equals(other.getBuyer()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.purchasedProducts==null && other.getPurchasedProducts()==null) || 
             (this.purchasedProducts!=null &&
              java.util.Arrays.equals(this.purchasedProducts, other.getPurchasedProducts()))) &&
            ((this.totalPrice==null && other.getTotalPrice()==null) || 
             (this.totalPrice!=null &&
              this.totalPrice.equals(other.getTotalPrice())));
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
        if (getBuyer() != null) {
            _hashCode += getBuyer().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getPurchasedProducts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPurchasedProducts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPurchasedProducts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTotalPrice() != null) {
            _hashCode += getTotalPrice().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransactionModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "TransactionModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("buyer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "Buyer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "UserModel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("purchasedProducts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "PurchasedProducts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "TransactionRowModel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "TransactionRowModel"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WebService.Models", "TotalPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
