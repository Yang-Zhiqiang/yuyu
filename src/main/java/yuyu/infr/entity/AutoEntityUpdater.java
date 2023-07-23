package yuyu.infr.entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.mapping.AbstractExDBEntity;

/**
 * 大量データ更新・一定件数自動フラッシュの実装クラスです。<br />
 * このクラスは、スレッド単位でのFlushマネジメントが行われません。<br />
 * swak-dbにて提供するEntityInserterへ差し替えてください。<br />
 */
@Deprecated
public class AutoEntityUpdater<E extends AbstractExDBEntity<E,?>> extends AbstractAutoEntityUpdater<E>{

    private static final long serialVersionUID = 1L;

    public AutoEntityUpdater() {
        super();
    }

    public AutoEntityUpdater(int pMaxSize) {
        super(pMaxSize);
    }

    @Override
    protected void exec(){
        BaseDomManager baseManager = SWAKInjector.getInstance(BaseDomManager.class);
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for (E element : this.getEntityList()) {
            if (! em.getEntityManager().contains(element)) {
                baseManager.update(em.merge(element));
            }
        }
        baseManager.flush();
        baseManager.clear();
        this.clear();
    }
}
