package yuyu.infr.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import jp.co.slcs.swak.core.lang.Closeable;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.db.mapping.AbstractExDBEntity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * 大量データ更新時、一定件数で自動的な処理を行うための抽象クラスです。<br />
 * このクラスは将来的な破棄を予定していますので、使わないでください。<br /?
 */
@Deprecated
public abstract class AbstractAutoEntityUpdater<E extends AbstractExDBEntity<E,?>> implements Serializable, Closeable {

    private int maxSize = YuyuBaseConfig.getInstance().getMaxSize();

    private static final long serialVersionUID = 1L;

    private List<E> entityList = Lists.newArrayList();

    public AbstractAutoEntityUpdater(){
        super();
    }

    public AbstractAutoEntityUpdater(int pMaxSize) {
        super();
        if (pMaxSize <= 0) {
            throw new IllegalArgumentException("件数は1件以上を指定してください。");
        }
        this.maxSize = pMaxSize;
    }

    public void add(E pEntity){
        entityList.add(pEntity);
        if(this.size() >= maxSize){
            exec();
        }
    }

    public void addAll(Collection<? extends E> pEntity){
        entityList.addAll(pEntity);
        if(this.size() >= maxSize){
            exec();
        }
    }

    @Override
    public void close(){
        exec();
    }

    protected int size() {
        return entityList.size();
    }

    protected List<E> getEntityList() {
        return ImmutableList.copyOf(entityList);
    }

    protected void detach() {
        for (E entity: this.getEntityList()) {
            entity.detach();
        }
        this.clear();
    }

    protected void clear() {
        entityList.clear();
    }

    protected abstract void exec();

}
