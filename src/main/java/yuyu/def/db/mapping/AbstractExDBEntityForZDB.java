package yuyu.def.db.mapping;

import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBPrimaryKey;

/**
 * ZDBサブシステムのテーブルマッピングBeanの親クラスです。<br />
 * @param <E>  Entity クラス
 * @param <PK> PrimaryKey クラス
 */
@MappedSuperclass
public abstract class AbstractExDBEntityForZDB<E extends ExDBEntity<E, PK>, PK extends ExDBPrimaryKey<E, PK>>
extends jp.co.slcs.swak.db.typesafe.AbstractExDBEntity<E, PK> {

    private static final long serialVersionUID = 281L;

    protected AbstractExDBEntityForZDB() {
    }

    @PrePersist
    protected void prePersist() {
        // Do Nothing
    }

    @PreUpdate
    protected void preUpdate() {
        // Do Nothing
    }

    private boolean loaded = false;

    @PostLoad
    private void setLoaded(){
        loaded = true;
    }

    @Transient
    public boolean isLoaded(){
        return loaded;
    }

    private boolean removed = false;

    @PostRemove
    private void setRemoved(){
        removed = true;
    }

    @Transient
    public boolean isRemoved(){
        return removed;
    }
}
