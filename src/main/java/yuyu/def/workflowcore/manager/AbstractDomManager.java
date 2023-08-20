package yuyu.def.workflowcore.manager;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBPrimaryKey;

/**
 * 基底DOMマネージャ 実装クラス
 */
public abstract class AbstractDomManager implements DomManager {

    @Inject
    protected ExDBEntityManager em;

    @Override
    public <E extends ExDBEntity<E, ?>> void insert(E entity) {
        em.persist(entity);
    }

    @Override
    public <E extends ExDBEntity<E, ?>> void insert(Iterable<E> entities) {
        em.persist(entities);
    }

    @Override
    public <E extends ExDBEntity<E, ?>> void update(E entity) {
        if (! em.getTransaction().isActive()) {
            throw new IllegalStateException("Transaction is not active.");
        }
        if (! em.getEntityManager().contains(entity)) {
            throw new IllegalStateException("The entity is detached. " + entity);
        }
    }

    @Override
    public <E extends ExDBEntity<E, ?>> void update(Iterable<E> entities) {
        if (! em.getTransaction().isActive()) {
            throw new IllegalStateException("Transaction is not active.");
        }
        for (E entity : entities) {
            if (! em.getEntityManager().contains(entity)) {
                throw new IllegalStateException("The entity is detached. " + entity);
            }
        }
    }

    @Override
    public <E extends ExDBEntity<E, ?>> void delete(E entity) {
        em.remove(entity);
    }

    @Override
    public <E extends ExDBEntity<E, PK>, PK extends ExDBPrimaryKey<E,PK>> void delete(PK primaryKey) {
        em.remove(primaryKey);
    }

    @Override
    public <E extends ExDBEntity<E, ?>> void delete(Iterable<E> entities) {
        em.remove(entities);
    }

    @Override
    public <E extends ExDBEntity<E, ?>> boolean isManaged(E entity) {
        return em.getEntityManager().contains(entity);
    }

    @Deprecated
    @Override
    public void commit() {
        em.flush();
    }

    @Deprecated
    @Override
    public void rollback() {
        em.clear();
    }

    @Override
    public void flush() {
        em.flush();
    }

    @Override
    public void clear() {
        em.clear();
    }
}
