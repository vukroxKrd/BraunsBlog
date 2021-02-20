package net.braun.blog.service.impl;

import net.braun.blog.dao.SqlDAO;
import net.braun.blog.entity.Category;
import net.braun.blog.exception.ApplicationException;
import net.braun.blog.service.BusinessService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

class BusinessServiceImpl implements BusinessService {

    private final DataSource dataSource;
    private final SqlDAO sql;

    BusinessServiceImpl(ServiceManager serviceManager) {
        super();
        this.dataSource = serviceManager.dataSource;
        this.sql = new SqlDAO();
    }

    @Override
    public Map<Integer, Category> mapCategories() {
        try (Connection c = dataSource.getConnection()) {
            return sql.mapCategories(c);
        } catch (SQLException throwables) {
            throw new ApplicationException("Can't execute db (Mapping Categories) command: " + throwables.getMessage());
        }
    }
}
