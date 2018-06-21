package br.com.sal.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sal.Model.ClienteModel;

public class ClienteDAO {

	private static ClienteDAO instance;
	protected EntityManager entityManager;

	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}

		return instance;
	}

	private ClienteDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public ClienteModel getById(final int id) {
		return entityManager.find(ClienteModel.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ClienteModel> findAll() {
		return entityManager.createQuery("FROM " + ClienteModel.class.getName()).getResultList();
	}

	public void persist(ClienteModel ClienteModel) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(ClienteModel);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(ClienteModel ClienteModel) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(ClienteModel);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(ClienteModel ClienteModel) {
		try {
			entityManager.getTransaction().begin();
			ClienteModel = entityManager.find(ClienteModel.class, ClienteModel.getId());
			entityManager.remove(ClienteModel);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			ClienteModel ClienteModel = getById(id);
			remove(ClienteModel);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
