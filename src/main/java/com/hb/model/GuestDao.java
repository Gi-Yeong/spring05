package com.hb.model;

import com.dodo.model.GuestVo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GuestDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<GuestVo> selectAll() {
        String sql = "SELECT * FROM GUEST ORDER BY SABUN";
        RowMapper<GuestVo> rowMapper = new RowMapper<GuestVo>() {
            @Override
            public GuestVo mapRow(ResultSet resultSet, int i) throws SQLException {
                GuestVo bean = new GuestVo(
                        resultSet.getInt("sabun")
                        , resultSet.getString("name")
                        , resultSet.getDate("nalja")
                        , resultSet.getInt("pay")
                );
                return bean;
            }
        };
        List list = jdbcTemplate.query(sql, rowMapper);

        return list;
    }

    public int insertOne(GuestVo bean) {
        String sql = "INSERT INTO GUEST VALUES (?, ?, sysdate, ?)";
        Object[] obj = {bean.getSabun(), bean.getName(), bean.getPay()};
        return jdbcTemplate.update(sql, obj);
    }

    public int updateOne(GuestVo bean) {
        String sql = "UPDATE GUEST SET NAME = ?, PAY = ? WHERE SABUN = ?";
        Object[] obj = {bean.getName(), bean.getPay(), bean.getSabun()};
        return jdbcTemplate.update(sql, obj);
    }

    public int deleteOne(int sabun) {
        String sql = "DELETE FROM GUEST WHERE SABUN = ?";
        Object[] obj = {sabun};
        return jdbcTemplate.update(sql, obj);
    }
}
