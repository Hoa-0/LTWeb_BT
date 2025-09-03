package vn.iotstar.services;

import java.util.List;
import vn.iotstar.models.Category;

public interface CategoryService {
    void insert(Category cate);
    void update(Category cate);
    void delete(int cateId);
    Category findById(int cateId);

	List<Category> findAll();

	List<Category> findByUser(int userId);
}
