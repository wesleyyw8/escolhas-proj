package br.com.helloworld.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import br.com.helloworld.hibernate.HibernateUtil;
import br.com.helloworld.model.Livro;
import br.com.helloworld.model.User;

@Component
public class DAO<T> {

	private Session session;

	public DAO() {
	}

	public T save(T entity) {
		try {
			getSession().beginTransaction();
			getSession().save(entity);
			getSession().getTransaction().commit();
			getSession().close();
			return entity;
		} catch (Exception e) {
			System.out.print("erro na hora de salvar dao\n");
			System.out.print(e);
			getSession().getTransaction().rollback();
			getSession().close();
			return null;
		}
	}

	public T update(T entity) {
		try {
			getSession().beginTransaction();
			getSession().merge(entity);
			getSession().getTransaction().commit();
			getSession().close();
			return entity;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			getSession().close();
			return null;
		}
	}

	public void delete(T entity) {
		try {
			getSession().beginTransaction();
			getSession().delete(entity);
			getSession().getTransaction().commit();
		} catch (Exception e) {
			getSession().getTransaction().rollback();
		} finally {
			getSession().close();
		}
	}

	public List<User> selectAll(){
		try{
			getSession().beginTransaction();
			//Criteria criteria = session.createCriteria(User.class);
			List<User> list = session.createCriteria(User.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
		} finally {
			getSession().close();
		}
		return null;
	}
	
	public List<Livro> selectAllLivros(){
		try{
			getSession().beginTransaction();			
			List<Livro> list = session.createCriteria(Livro.class).list();
			session.getTransaction().commit();
			return list;
		}catch(Exception e){
			System.out.print(e);
			getSession().getTransaction().rollback();
		}
		finally{
			getSession().close();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T searchModel(DetachedCriteria query) {
		T model = (T) query.getExecutableCriteria(getSession()).uniqueResult();
		return model;
	}

	@SuppressWarnings("unchecked")
	public List<T> searchModels(DetachedCriteria query) {
		List<T> models = query.getExecutableCriteria(getSession()).list();
		return models;
	}

	private Session getSession() {
		if (session == null || !session.isOpen()) session = HibernateUtil.getSessionFactory().openSession();
		return session;
	}

}