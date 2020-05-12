package com.lk.app;

import com.lk.app.entity.Book;
import com.lk.app.entity.BookStore;
import com.lk.app.entity.Name;
import com.lk.app.util.XMLUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestJaxb {
	@Test
	public void test1() throws Exception {
		BookStore bookStore = new BookStore();
		List<Book> list = new ArrayList<>();

		Name name1 = new Name(1, "Java");
		Book book1 = new Book(name1, 50, 20, new Date());

		Name name2 = new Name(2, "HTML");
		Book book2 = new Book(name2, 40, 10, new Date());

		list.add(book1);
		list.add(book2);

		bookStore.setBooks(list);

		String s = XMLUtils.objToXML(bookStore);
		XMLUtils.generatorFile(s, "/books.xml");
	}
}
