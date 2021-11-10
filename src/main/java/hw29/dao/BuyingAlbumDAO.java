package hw29.dao;

import hw29.entity.BuyingAlbum;
import hw29.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class BuyingAlbumDAO {
    public void save(BuyingAlbum buyingAlbum) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(buyingAlbum);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void update(BuyingAlbum buyingAlbum) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(buyingAlbum);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            BuyingAlbum buyingAlbum = session.get(BuyingAlbum.class, id);
            if (buyingAlbum != null) {
                String hql = "DELETE FROM BuyingAlbum WHERE id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                int result = query.executeUpdate();
                System.out.println("Rows is delete: " + result);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void insertBuyingAlbum() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "INSERT INTO BuyingAlbum (album) "
                    + "SELECT album FROM BuyingAlbum";
            Query query = session.createQuery(hql);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public BuyingAlbum getById(int id) {
        Transaction transaction = null;
        BuyingAlbum buyingAlbum = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM BuyingAlbum b WHERE b.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            List results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                buyingAlbum = (BuyingAlbum) results.get(0);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return buyingAlbum;
    }

    public void loadById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            BuyingAlbum buyingAlbum = session.load(BuyingAlbum.class, id);
            System.out.println(buyingAlbum);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<BuyingAlbum> getAllBuyingAlbum() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM BuyingAlbum", BuyingAlbum.class).list();
        }
    }
}
