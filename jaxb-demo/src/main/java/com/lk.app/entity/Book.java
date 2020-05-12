package com.lk.app.entity;

import com.lk.app.formatter.JaxbDateFormatter;
import com.lk.app.util.XMLSchemaDict;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * 注解 @XmlAccessorType 的参数：
 * 1、XmlAccessType.PROPERTY 会绑定类中所有的getter/setter方法，而且每个成员变量的getter和setter方法都必须存在。
 * 2、XmlAccessType.FIELD 会绑定类中所有的非静态和没有@XmlTransient注解的成员变量。
 * 3、XmlAccessType.PUBLIC_MEMBER 会绑定类中所有的getter/setter方法和public修饰的成员变量，但是@XmlTransient注解的除外。
 * 4、XmlAccessType.NONE 没有任何变量和方法会被绑定，但是使用@XmlElement和@XmlAttribute的变量和方法还是会被绑定。
 *
 * 注：以上的4中参数中，除了NONE外其他的都会自动绑定成员变量 或者 是getter/setter方法，
 * 这里需要注意，PROPERTY和PUBLIC_MEMBER参数会自动绑定getter/setter方法，而在成员变量上再使用@XmlElement会报错说“类的两个属性具有相同名称”，
 * 同样的，FIELD参数绑定了成员变量，而在getter/setter方法上使用@XmlElement也会报错说“类的两个属性具有相同名称”。
 * NONE参数虽然不指定任何绑定，但是如果同时在成员变量和getter/setter方法上使用@XmlElement也会报错。
 * 即：不能对同一个变量使用两次绑定。
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

	/**
	 * 注解 @XmlElement ：
	 * 该注解用于绑定类中的元素为xml的节点，可用在属性和方法上。
	 * 1、name参数，如果指明name参数，会使用该参数的值作为节点名称，如果不用则会自动将变量名作为节点名称。
	 * 2、namespace参数，用于指定该节点的命名空间。
	 *
	 */
	@XmlElement(name = "Name",namespace = XMLSchemaDict.NAMESPACE_S2)
	private Name name;

	@XmlElement(namespace = XMLSchemaDict.NAMESPACE_S2)
	private double price;

	@XmlElement(namespace = XMLSchemaDict.NAMESPACE_S2)
	private int num;

	@XmlElement
	@XmlJavaTypeAdapter(JaxbDateFormatter.MillisecondDateFormatter.class)
	private Date publishDate;

	public Book() {
	}

	public Book(Name name, double price, int num, Date publishDate) {
		this.name = name;
		this.price = price;
		this.num = num;
		this.publishDate = publishDate;
	}

}
