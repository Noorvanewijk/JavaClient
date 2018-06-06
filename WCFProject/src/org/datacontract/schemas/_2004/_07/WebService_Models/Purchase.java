package org.datacontract.schemas._2004._07.WebService_Models;

public class Purchase {
    private int ProductId;
    private String Name;
    private int Amount;

    public Purchase(int id, String name, int amount)
    {
        this.ProductId = id;
        this.Name = name;
        this.Amount = amount;
    }

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
