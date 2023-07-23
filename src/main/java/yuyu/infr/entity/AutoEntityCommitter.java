package yuyu.infr.entity;

import java.util.List;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;
import yuyu.def.db.mapping.AbstractExDBEntity;

/**
 * 大量データ更新・一定件数自動フラッシュの実装クラスです。<br />
 * このクラスは将来的な破棄が予定されていますので、使わないでください。<br />
 */
@Deprecated
public class AutoEntityCommitter<E extends AbstractExDBEntity<E,?>> extends AbstractAutoEntityUpdater<E>{

    private static final long serialVersionUID = 1L;

    public AutoEntityCommitter() {
        super();
    }

    public AutoEntityCommitter(int pMaxSize) {
        super(pMaxSize);
    }

    @Override
    protected void exec(){
        final List<E> entities = this.getEntityList();
        ExDBTransactional.run(
            new TransactionalCode() {
                @Override
                public void accept(ExDBEntityManager entityManager) {
                    entityManager.persist(entities);
                }
            }
            );
        this.clear();
    }
}
