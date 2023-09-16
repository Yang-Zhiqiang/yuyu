package yuyu.def.db.mapping;

import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBPrimaryKey;

import org.slf4j.Logger;

import com.google.common.collect.Lists;

/**
 * 全てのテーブルマッピングBeanの親クラスです。<br />
 * 全テーブル固定の項目を提供します。
 * @param <E>  Entity クラス
 * @param <PK> PrimaryKey クラス
 */
@MappedSuperclass
public abstract class AbstractExDBEntityForJBPM<E extends ExDBEntity<E, PK>, PK extends ExDBPrimaryKey<E, PK>>
extends jp.co.slcs.swak.db.typesafe.AbstractExDBEntity<E, PK> {

    private static final long serialVersionUID = 281L;

    protected AbstractExDBEntityForJBPM() {
    }

    @Transient
    protected <C extends AbstractExDBEntityForJBPM<C, ?>> List<C> readyChildEntityList(List<C> children) {
        if (children != null) {
            if (children.size() > 0) {
                Logger logger = LoggerFactory.getLogger(getClass());
                logger.trace(
                        String.format(
                                "◇ [%s(%s)] の子要素 [%s] を %d 件取得しました。",
                                getClass().getSimpleName(),
                                getPrimaryKey(),
                                children.get(0).getClass().getSimpleName(),
                                Integer.valueOf(children.size())
                                )
                        );
            }
            return children;
        }

        if (loaded == false){
            return Lists.newLinkedList();
        }

        throw new RuntimeException("エンティティクラスが想定外の状態（マネージドかつ子要素がNULL）の状態になりました。");
    }

    @PrePersist
    protected void prePersist() {
        setSystemProperties(false);
    }

    @PreUpdate
    protected void preUpdate() {
        setSystemProperties(true);
    }

    private void setSystemProperties(boolean forceUpdateKousinsyaId) {
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
