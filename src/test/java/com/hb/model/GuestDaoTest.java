package com.hb.model;

import com.dodo.model.GuestVo;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class GuestDaoTest {
    private static GuestDao dao;
    private static JdbcTemplate jdbcTemplate;

    @BeforeClass
    public static void testBefore() {
//      <bean id = "dataSource"
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("scott");
        dataSource.setPassword("tiger");
        dataSource.setMaxActive(50);

//      <bean id = "jdbcTemplate
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

//      <bean id = "dao2"
        dao = new GuestDao();
        dao.setJdbcTemplate(jdbcTemplate);
    }

    @Test
    public void testCRUD(){
        GuestVo bean = new GuestVo(9999, "test", null, 9000);
        int result = dao.insertOne(bean);
        assertFalse(result == 0);
        assertSame(1, result);
        bean.setName("edit");
        bean.setPay(9090);
        result = dao.updateOne(bean);
        assertFalse(result == 0);
        result = dao.deleteOne(9999);
        assertFalse(result == 0);
        try {
            selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void selectAll() throws Exception {
        List<GuestVo> list = dao.selectAll();
        assertNotNull(list);
        assertTrue(list.size() > 0);
        for (GuestVo bean :
                list) {
            System.out.println(bean);
        }
    }


    public void insertOne() throws Exception {
        ((BasicDataSource) jdbcTemplate.getDataSource()).setDefaultAutoCommit(false);
        int result = dao.insertOne(new GuestVo(9999, "test", null, 9000));
        assertFalse(result == 0);
        assertSame(1, result);
        ((BasicDataSource) jdbcTemplate.getDataSource()).setDefaultAutoCommit(true);
    }


    public void updateOne() throws Exception {
        GuestVo bean = new GuestVo(9999, "test", null, 9000);
        dao.insertOne(bean);
        bean.setName("edit");
        bean.setPay(9090);
        int result = dao.updateOne(bean);
        assertFalse(result == 0);
        dao.deleteOne(bean.getSabun());
    }

    public void deleteOne() throws Exception {
        GuestVo bean = new GuestVo(9999, "test", null, 9000);
        dao.insertOne(bean);
        int result = dao.deleteOne(9999);
        assertFalse(result == 0);
    }

}
