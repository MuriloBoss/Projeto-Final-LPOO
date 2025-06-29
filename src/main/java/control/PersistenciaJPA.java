/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author muril
 */
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import model.Carta;
import model.Jogador;
import model.Time;

public class PersistenciaJPA implements InterfaceBD {

    private EntityManager entity;
    private EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("pu-lpoo-torneios");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        return entity != null && entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return getEntityManager().find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o);
            }
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao persistir: " + o.getClass().getSimpleName(), e);
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o);
            }
            entity.remove(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao remover: " + o.getClass().getSimpleName(), e);
            throw e;
        }
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    // 🔄 Método para listar todas as Cartas
    public List<Carta> getCartas() {
        entity = getEntityManager();
        try {
            TypedQuery<Carta> query = entity.createQuery("SELECT c FROM Carta c", Carta.class);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar cartas", e);
            return null;
        }
    }
    
    public List<Jogador> getJogador(){
    entity = getEntityManager();
        try {
            TypedQuery<Jogador> query = entity.createQuery("SELECT c FROM Jogador c", Jogador.class);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar jogadores", e);
            return null;
        }
    }
    
    public List<Time> getTimes() {
    entity = getEntityManager();
    try {
        TypedQuery<Time> query = entity.createQuery("SELECT t FROM Time t", Time.class);
        return query.getResultList();
    } catch (Exception e) {
        Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar times", e);
        return null;
    }
}
}


