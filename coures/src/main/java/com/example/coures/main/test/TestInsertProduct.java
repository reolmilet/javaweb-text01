package com.example.coures.main.test;

import com.example.coures.main.factory.DAOFactory;
import com.example.coures.main.pojo.Product;


public class TestInsertProduct {
	public static void main(String[] args){
		Product product = null;
		try{
			/*for(int i=0;i<5;i++){
				product = new Product();
				product.setProduct_id("400115001221"+i);
				product.setProduct_name("一班"+i);
				product.setPrice(100+i);
				product.setInfo("这是一个精美的杯子"+i);
				DAOFactory.getIEmpDAOInstance().addProduct(product);
			}*/
			//DAOFactory.getIEmpDAOInstance().findAll("水杯1");
			//DAOFactory.getIEmpDAOInstance().findAll(null);
			//DAOFactory.getIEmpDAOInstance().findAll("");


		}catch(Exception e){
			e.printStackTrace();
			e.printStackTrace();
		}
	}
}
