package com.lk.app.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Name {

	@XmlAttribute(name = "id")
	private int id;

	/**
	 * Name节点的属性值，该变量名随意，不需要非得是value
	 */
	@XmlValue
	private String value;

	public Name() {
	}

	public Name(int id, String value) {
		this.id = id;
		this.value = value;
	}

}
