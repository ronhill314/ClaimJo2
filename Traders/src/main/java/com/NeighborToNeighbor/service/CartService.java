package com.NeighborToNeighbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NeighborToNeighbor.entity.Cart;
import com.NeighborToNeighbor.entity.Products;
import com.NeighborToNeighbor.repo.CartRepo;

@Service
public class CartService {


    @Autowired
    CartRepo cartRepo;
	
	public Cart save(Cart cart) {
		// Another predefined function, used to save your objects
		// Id will be autogenerated and will come back in the return after its saved

	    return cartRepo.save(cart);
	}
	
	public Cart update(Cart cart) throws Exception {
		// Another predefined function, used to save your objects
		// Id will be autogenerated and will come back in the return after its saved

        if(cart.getId() != null) {
	        return cartRepo.save(cart);
        }

        throw new Exception("Object does not exist! id not present");
	}
    
    public Cart findById(Integer cartId) throws Error {
        
    	// Find by is another predefined repo function, you can always find by the primary key
    	// when you use findById, its good practice to use the isPresent in an if check first
    	// It will tell you if a object was actually found, with true or false values, true if found, false is not
    	// It will always return an Optional Object, the cart will be there if found, null if not
    	// If found, give the object back with a .get() to grab it off the Optional object
    	
        if(cartRepo.findById(cartId).isPresent()) {
            return cartRepo.findById(cartId).get();
        }
        
        // if cart is not present, throw error so front end can handle it
        throw new Error("No cart id present, Cart not found, send an id billy, dumbass");
        
    }

	public List<Cart> findAll() {
		return cartRepo.findAll();
	}

    public void deleteById(Integer id) {
	    cartRepo.deleteById(id);
	}

	public Cart addProductToCart(Integer cartId, Products product) {

		Cart cart = findById(cartId);
		cart.getItemsInCart().add(product);
		return cartRepo.save(cart);

	}

	public Cart removeProductToCart(Integer cartId, Products product) {

		Cart cart = findById(cartId);
		for (int i = 0; i < cart.getItemsInCart().size(); i++) {
			if(cart.getItemsInCart().get(i).getId() == product.getId()) {
				cart.getItemsInCart().remove(i);
				break;
			}
		}
		return cartRepo.save(cart);

	}

    
}