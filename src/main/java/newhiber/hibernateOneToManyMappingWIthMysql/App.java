package newhiber.hibernateOneToManyMappingWIthMysql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
    	Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		

		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java .");
		
		Answer answer= new Answer();
		answer.setAnswer_id(243);
		answer.setAnswer("Java is programming language ");
		answer.setQuestion(q1);


		Answer answer1= new Answer();
		answer1.setAnswer_id(246);
		answer1.setAnswer("Java is Oops ");
		answer1.setQuestion(q1);


		Answer answer2= new Answer();
		answer2.setAnswer_id(245);
		answer2.setAnswer("Java is Oops ");
		answer2.setQuestion(q1);

		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		q1.setAnswer(list);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
	
		s.persist(q1);
		s.persist(answer);
		s.persist(answer1);
		s.persist(answer2);

		

		tx.commit();

		
//		Question newQ = s.get(Question.class, 1212);
//		System.out.println(newQ.getQuestion());
//		
		s.close();
		
		
		factory.close();

    
        
    }
}
