package com.dodo.model;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestDao {
    private BasicDataSource dataSource;
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<GuestVo> selectAll() throws Exception {
        List<GuestVo> list = new ArrayList<>();
        String sql = "SELECT * FROM GUEST";
        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new GuestVo(
                        rs.getInt("sabun")
                        , rs.getString("name")
                        , rs.getDate("nalja")
                        , rs.getInt("pay")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }

        return list;
    }
}
