package com.lk.app;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LK
 * @date 2018/12/4
 */
public class InstanceDaoImpl implements InstanceDao {

	private String config = "mybatis-config.xml";

	@Override
	public void insert(TaskInstance instance) throws IOException {
		InputStream is = Resources.getResourceAsStream(config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		session.insert("instance.insert", instance);
		session.commit();
		session.close();
	}
}
