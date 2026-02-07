package in.rajveer.blooms.repositories;

import in.rajveer.blooms.models.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubCategoryRepository extends MongoRepository<SubCategory,String> {

    List<SubCategory> findByCategoryId(String categoryId);
}
