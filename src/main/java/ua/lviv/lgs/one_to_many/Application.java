package ua.lviv.lgs.one_to_many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {
	public static void main(String[] args) {		

		Configuration configuration = new Configuration();
		configuration.configure("/META-INF/hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Comment comment = new Comment();
		comment.setAuthorName("Pavel Globa");
			
			Post post1 = new Post();
			post1.setTitle("it is ok");
			post1.setComments(comment);
			
			Post post2 = new Post();
			post2.setTitle("it is very good");
			post2.setComments(comment);
			
			Set<Post> setPost = new HashSet<>();
			setPost.add(post1);
			setPost.add(post2);
			
			comment.setPosts(setPost);
			

			
		//save DB
		session.save(comment);	
		transaction.commit();
		
		//read DB
		Comment commentRead = (Comment)session.get(Comment.class, 1);
		System.out.println(commentRead + "------>" + commentRead.getPosts());
		
		Post postRead1 = (Post)session.get(Post.class, 1);
		System.out.println( postRead1 + "------>" + postRead1.getComments());	
		
		Post postRead2 = (Post)session.get(Post.class, 2);
		System.out.println( postRead2 + "------>" + postRead2.getComments());
		
		session.close();

	}
}
