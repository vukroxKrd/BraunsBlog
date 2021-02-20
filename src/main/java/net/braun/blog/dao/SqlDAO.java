package net.braun.blog.dao;

import net.braun.blog.dao.mapper.MapCategoryMapper;
import net.braun.blog.entity.Category;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public final class SqlDAO {
    private final QueryRunner sql = new QueryRunner();

    public Map<Integer, Category> mapCategories(Connection connection) throws SQLException {
        return sql.query(connection, "select * from category", new MapCategoryMapper());
    }
}
