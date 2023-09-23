package yuyu.def.base.comparator;

import java.lang.reflect.Method;

import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBField;
import lombok.Getter;
import lombok.Setter;

/**
 * Comparator 検索条件保持クラス(タイプセーフ版)<br />
 */
public class SortCondition<E extends ExDBEntity<E, ?>> {

    /**
     * ソート順指定の列挙型です。
     */
    public enum SortOrder {
        ASC,
        DESC
    }

    @Getter @Setter
    private ExDBField<E, ?> sortKey;

    @Getter @Setter
    private SortOrder order;

    @Getter @Setter
    private Method readMethod;

    public SortCondition(ExDBField<E, ?> pSortKey, SortOrder pOrder) {
        sortKey    = pSortKey;
        order      = pOrder;
        readMethod = null;
    }

}
