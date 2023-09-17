package yuyu.def.base.manager;

import java.util.Map;

import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBPrimaryKey;

import org.slf4j.Logger;

import yuyu.def.db.mapping.AbstractExDBEntity;

/**
 * 基底DOMマネージャー 実装クラス
 */
public abstract class AbstractDomManager implements DomManager {

    @Inject
    protected ExDBEntityManager em;

    @Inject
    private static Logger logger = LoggerFactory.getLogger(AbstractDomManager.class);

    @Override
    public <E extends ExDBEntity<E, ?>> void insert(E entity) {
        em.persist(entity);
    }

    @Override
    public <E extends ExDBEntity<E, ?>> void insert(Iterable<E> entities) {
        em.persist(entities);
    }

    @Override
    public <E extends AbstractExDBEntity<E, ?>> void update(E entity) {
        if (! em.getTransaction().isActive()) {
            throw new IllegalStateException("Transaction is not active.");
        }
        if (! em.getEntityManager().contains(entity)) {
            if(entity != null && entity.isLoaded()){
                throw new org.hibernate.OptimisticLockException("The entity was deleted by other thread.");
            }
            throw new IllegalStateException("The entity is detached. " + entity);
        }

        entity.setKousinTime(BizDate.getSysDateTimeMilli());
    }

    @Override
    public <E extends AbstractExDBEntity<E, ?>> void update(Iterable<E> entities) {
        if (! em.getTransaction().isActive()) {
            throw new IllegalStateException("Transaction is not active.");
        }
        for (E entity : entities) {
            if (! em.getEntityManager().contains(entity)) {
                if(entity != null && entity.isLoaded()){
                    throw new org.hibernate.OptimisticLockException("The entity was deleted by other thread.");
                }
                throw new IllegalStateException("The entity is detached. " + entity);
            }

            entity.setKousinTime(BizDate.getSysDateTimeMilli());
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

    @Override
    public <E extends ExDBEntity<E, ?>> void refresh(E entity){

        try{
            em.refresh(entity);
        } catch (PersistenceException e) {
            throw new OptimisticLockException(e);
        }
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

    public void paramLogging(Map<String, Object> pParamMap){

        logger.trace("◇ ");
        boolean first = true;
        for (String key : pParamMap.keySet()) {
            if(first){
                logger.trace("｜ 【DOMパラメータ設定内容】 ");
                first = false;
            }
            logger.trace("｜ " + key + " = " + pParamMap.get(key));
        }

        logger.trace("◇ ");
    }
}
