package com.lk.app.entity;

import com.lk.app.util.XMLSchemaDict;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "BookStore",namespace = XMLSchemaDict.NAMESPACE_S1)
@XmlAccessorType(XmlAccessType.FIELD)
public class BookStore {

	/**
	 * 注解 @XmlElementWrapper ：
	 * 该注解可用于为Collection或数组的变量声明出一个父节点
	 */
	@XmlElementWrapper(name = "books",namespace = XMLSchemaDict.NAMESPACE_S1)
	@XmlElement(name = "book",namespace = XMLSchemaDict.NAMESPACE_S1)
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
