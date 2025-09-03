package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.models.Category;
import vn.iotstar.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao dao = new CategoryDaoImpl();

	@Override
	public void insert(Category cate) {
		dao.insert(cate);
	}

	@Override
	public void update(Category cate) {
		dao.update(cate);
	}

	@Override
	public void delete(int cateId) {
		dao.delete(cateId);
	}

	@Override
	public Category findById(int cateId) {
		return dao.findById(cateId);
	}

	@Override
	public List<Category> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Category> findByUser(int userId) {
		return dao.findByUser(userId);
	}
}
