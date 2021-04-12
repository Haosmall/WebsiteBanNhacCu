package com.websitenhaccu.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.websitenhaccu.entity.Ads;
import com.websitenhaccu.entity.Attribute;
import com.websitenhaccu.entity.AttributeValue;
import com.websitenhaccu.entity.Brand;
import com.websitenhaccu.entity.Category;
import com.websitenhaccu.entity.Comment;
import com.websitenhaccu.entity.Contact;
import com.websitenhaccu.entity.Discount;
import com.websitenhaccu.entity.District;
import com.websitenhaccu.entity.Gender;
import com.websitenhaccu.entity.Order;
import com.websitenhaccu.entity.OrderDetail;
import com.websitenhaccu.entity.OrderDetail_PK;
import com.websitenhaccu.entity.Product;
import com.websitenhaccu.entity.ProductLine;
import com.websitenhaccu.entity.Province;
import com.websitenhaccu.entity.Supplier;
import com.websitenhaccu.entity.User;
import com.websitenhaccu.entity.Ward;

public class HibernateUtil {

	private static HibernateUtil instance = null;
	private static SessionFactory sessionFactory;

	private HibernateUtil() {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Ads.class)
                .addAnnotatedClass(Attribute.class)
                .addAnnotatedClass(AttributeValue.class)
                .addAnnotatedClass(AttributeValue.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Contact.class)
                .addAnnotatedClass(Discount.class)
                .addAnnotatedClass(Gender.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .addAnnotatedClass(OrderDetail_PK.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(ProductLine.class)
                .addAnnotatedClass(Supplier.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Province.class)
                .addAnnotatedClass(District.class)
                .addAnnotatedClass(Ward.class)
				.getMetadataBuilder()
				.build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();

	}

	public synchronized static HibernateUtil getInstance() {
		if (instance == null)
			instance = new HibernateUtil();
		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		new HibernateUtil();
	}
}
