package yuyu.def.base.manager;

import javax.transaction.Transactional;

import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBPrimaryKey;
import yuyu.def.db.mapping.AbstractExDBEntity;

/**
 * 基底DOMマネージャー インターフェース<br />
 */
public interface DomManager {

    <E extends ExDBEntity<E, ?>> void insert(E entity);

    <E extends ExDBEntity<E, ?>> void insert(Iterable<E> entities);

    <E extends AbstractExDBEntity<E, ?>> void update(E entity);

    <E extends AbstractExDBEntity<E, ?>> void update(Iterable<E> entities);

    <E extends ExDBEntity<E, PK>, PK extends ExDBPrimaryKey<E,PK>> void delete(PK primaryKey);

    <E extends ExDBEntity<E, ?>> void delete(E entity);

    <E extends ExDBEntity<E, ?>> void delete(Iterable<E> entities);

    <E extends ExDBEntity<E, ?>> boolean isManaged(E entity);

    @Deprecated
    void commit();

    @Deprecated
    void rollback();

    void flush();

    <E extends ExDBEntity<E, ?>> void refresh(E entity);

    void clear();

}
