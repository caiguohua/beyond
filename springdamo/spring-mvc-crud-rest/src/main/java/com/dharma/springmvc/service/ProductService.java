package com.dharma.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dharma.springmvc.model.Product;

@Service()
@Transactional
public class ProductService implements IProductService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<Product> products;

	static {
		products= initData();
	}

	public List<Product> getProducts() {
		return products;
	}

	public Product getProductById(long id) {
		for(Product p : products){
			if(p.getId() == id){
				return p;
			}
		}
		return null;
	}

	public Product getProductByName(String name) {
		for(Product p : products){
			if(p.getName().equalsIgnoreCase(name)){
				return p;
			}
		}
		return null;
	}

	public void addProduct(Product p) {
		p.setId(counter.incrementAndGet());
		products.add(p);
	}

	public void updateProduct(Product p) {
		int index = products.indexOf(p);
		products.set(index, p);
	}

	public void deleteProductById(long id) {

		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext(); ) {
		    Product p = iterator.next();
		    if (p.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isProductExist(Product p) {
		return getProductByName(p.getName())!=null;
	}

	private static List<Product> initData(){
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(counter.incrementAndGet(),"Smartian",8848.0, 70000));
		products.add(new Product(counter.incrementAndGet(),"iPhoneX",9999.0, 50000));
		products.add(new Product(counter.incrementAndGet(),"Mix2S",4999, 30000));
		products.add(new Product(counter.incrementAndGet(),"P20",6999, 40000));
		return products;
	}

	public void deleteAllProducts() {
		products.clear();
	}

}
