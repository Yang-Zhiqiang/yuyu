package yuyu.def.db.dao;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.core.inject.annotation.ThreadScoped;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_Batch;
/**
 * バッチマスタテーブル(AM_Batch) テーブルアクセス用の DAO クラスです。
 *
 */
@ThreadScoped
public class AM_BatchDao extends AbstractDao<AM_Batch> {

    @Inject
    BaseDomManager domManager;

    public AM_BatchDao() {
        super(AM_Batch.class);
    }

    public List<AM_Batch> getBatchBySubSystem(final String pSubSystemId) {
        return batchIdOrder.sortedCopy(
            Iterables.filter(
                selectAll(),
                new Predicate<AM_Batch>() {
                    @Override
                    public boolean apply(AM_Batch batch) {
                        return Strings.isNullOrEmpty(pSubSystemId)
                            ? true
                            : batch.getKinou().getSubSystem().getSubSystemId().equals(pSubSystemId);
                    }
                }
            )
        );
    }

    private static final Ordering<AM_Batch> batchIdOrder = new Ordering<AM_Batch>() {
        @Override
        public int compare(AM_Batch left, AM_Batch right) {
            return left.getKinouId().compareTo(right.getKinouId());
        }
    };

    public AM_Batch getAM_Batch(String pKinouId) {
        return selectOne(new AM_Batch(pKinouId));
    }

    private List<AM_Batch> batches = null;

    @Override
    public List<AM_Batch> selectAll() {
        if (batches == null) {
            domManager.getAllKinous();
            batches = new LinkedList<>(new LinkedHashSet<>(super.selectAll()));
        }
        return batches;
    }
}
