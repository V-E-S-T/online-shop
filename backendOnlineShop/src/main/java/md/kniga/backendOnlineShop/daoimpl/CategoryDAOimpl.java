package md.kniga.backendOnlineShop.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import md.kniga.backendOnlineShop.dao.CategoryDAO;
import md.kniga.backendOnlineShop.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		//first category
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Some description for Television");
		category.setImageURL("Category_1.png");
		
		categories.add(category);
		
		//second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Some description for Mobile");
		category.setImageURL("Category_2.png");
		
		categories.add(category);
		
		//third category
		category = new Category();
		category.setId(3);
		category.setName("LapTop");
		category.setDescription("Some description for LapTop");
		category.setImageURL("Category_3.png");
		
		categories.add(category);
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
