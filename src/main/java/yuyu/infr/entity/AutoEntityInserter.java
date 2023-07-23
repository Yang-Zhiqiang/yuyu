package yuyu.infr.entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.mapping.AbstractExDBEntity;

/**
 * 大量データ更新・一定件数自動フラッシュの実装クラスです。<br />
 * このクラスは、スレッド単位でのFlushマネジメントが行われません。<br />
 * swak-dbにて提供するEntityInserterへ差し替えてください。<br />
 */
@Deprecated
public class AutoEntityInserter<E extends AbstractExDBEntity<E,?>> extends AbstractAutoEntityUpdater<E>{

    private static final long serialVersionUID = 1L;

    public AutoEntityInserter() {
        super();
    }

    public AutoEntityInserter(int pMaxSize) {
        super(pMaxSize);
    }

    @Override
    protected void exec(){
        if (this.size() > 0) {
            BaseDomManager baseManager = SWAKInjector.getInstance(BaseDomManager.class);

            baseManager.insert(this.getEntityList());
            baseManager.flush();

            this.detach();
        }
    }

}
