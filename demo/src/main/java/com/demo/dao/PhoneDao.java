package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

public class PhoneDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Phone> getAllPhones() {
        String sql = "SELECT * FROM phones";
        return jdbcTemplate.query(sql, new PhoneRowMapper());
    }

    public Phone getPhoneById(String id) {
        String sql = "SELECT * FROM phones WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PhoneRowMapper());
    }

    public void savePhone(Phone phone) {
        String sql = "INSERT INTO phones (id, name, size, chip_name, ram_size, storage_size, manufacturer, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, phone.getId(), phone.getName(), phone.getSize(), phone.getChipName(), phone.getRamSize(), phone.getStorageSize(), phone.getManufacturer(), phone.getPrice());
    }

    public void deletePhone(String id) {
        String sql = "DELETE FROM phones WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
