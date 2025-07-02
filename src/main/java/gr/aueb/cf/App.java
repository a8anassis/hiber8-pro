package gr.aueb.cf;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("school8PU");
    private final static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        // CRUD

    }
}
