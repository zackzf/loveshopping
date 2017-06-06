package com.fbart.eshop.loveshopping.dao.nosql;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.fbart.eshop.loveshopping.model.nosql.PersonN;

public class PersonNDAO {
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<PersonN> findAll() {
		return getMongoTemplate().find(new Query(), PersonN.class);

	}

	public void findAndModify(String id) {
		// new Query(Criteria.where("id").is(id)), new Update().inc("age", 3)
		getMongoTemplate().updateFirst(new Query(Criteria.where("id").is(id)), new Update().inc("age", 3),PersonN.class);

	}

	public List<PersonN> findByRegex(String regex) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Criteria criteria = new Criteria("name").regex(pattern.toString());
		return getMongoTemplate().find(new Query(criteria), PersonN.class);

	}

	public PersonN findOne(String id) {
		return getMongoTemplate().findOne(new Query(Criteria.where("id").is(id)), PersonN.class);

	}

	public void insert(PersonN PersonN) {
		getMongoTemplate().insert(PersonN);
	}

	public void removeAll() {
		List<PersonN> list = this.findAll();
		if (list != null) {
			for (PersonN PersonN : list) {
				getMongoTemplate().remove(PersonN);
			}
		}

	}

	public void removeOne(String id) {
		Criteria criteria = Criteria.where("id").in(id);
		if (criteria == null) {
			Query query = new Query(criteria);
			if (query != null && getMongoTemplate().findOne(query, PersonN.class) != null)
				getMongoTemplate().remove(getMongoTemplate().findOne(query, PersonN.class));
		}

	}

}
