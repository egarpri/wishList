package com.wishList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wishes")
public class WishController {

	private static final List<Wish> wishList = new ArrayList<Wish>();
	
	static {
		wishList.add(new Wish("First Wish"));
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<Wish> getWishes() {
		return wishList;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public void addWish(@RequestBody @Valid Wish wish) {
		wishList.add(wish);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public void deleteWish(@RequestBody @Valid Wish wish) {
		Iterator<Wish> wishListIterator = wishList.iterator();
		Wish wishIterator;
		while (wishListIterator.hasNext()) {
			wishIterator = wishListIterator.next();
			if(wishIterator.getTitle().equalsIgnoreCase(wish.getTitle())) {
				wishListIterator.remove();
			}
		}
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public Wish searchWish(@RequestBody @Valid Wish wish) {
		Iterator<Wish> wishListIterator = wishList.iterator();
		Wish wishIterator = null;
		while (wishListIterator.hasNext()) {
			wishIterator = wishListIterator.next();
			if(wishIterator.getTitle().indexOf(wish.getTitle()) > 0 ) {
				wishIterator = wish;
			}
		}
		return wishIterator;
	}
	
}