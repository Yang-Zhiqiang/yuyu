package yuyu.def.sinkeiyaku.comparator;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;

import jp.co.slcs.swak.util.string.CaseFormat;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_GrossNykn;

public class OrderHT_GrossNykn implements Comparator<HT_GrossNykn> {

    private List<SortCondition<HT_GrossNykn>> conditions;

    public OrderHT_GrossNykn(SortCondition<HT_GrossNykn> pCondition) {
        super();
        conditions.clear();
        conditions.add(pCondition);
        initConditions();
    }

    public OrderHT_GrossNykn(List<SortCondition<HT_GrossNykn>> pCondition) {
        super();
        conditions = pCondition;
        initConditions();
    }

    private void initConditions() {
        for (SortCondition<HT_GrossNykn> condition : conditions) {
            try {
                condition.setReadMethod(
                    HT_GrossNykn.class.getMethod(
                        "get" +
                            CaseFormat.LOWER_CAMEL.to(
                                CaseFormat.UPPER_CAMEL,
                                condition.getSortKey().getName()
                                )
                        )
                    );
            } catch (NoSuchMethodException | SecurityException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public int compare(HT_GrossNykn pEntity1, HT_GrossNykn pEntity2) {

        
        if (pEntity1 == null && pEntity2 == null) {
            return 0;
        } else if (pEntity1 == null) {
            return 1;
        } else if (pEntity2 == null) {
            return -1;
        }

        int compare = 0;
        for (SortCondition<HT_GrossNykn> condition : conditions) {
            try {
                Comparable value1 = (Comparable) condition.getReadMethod().invoke(pEntity1);
                Comparable value2 = (Comparable) condition.getReadMethod().invoke(pEntity2);
                if (value1 == null) {
                    compare = (value2 == null) ? 0 : 1;
                } else {
                    compare = (value2 == null) ? -1 : value1.compareTo(value2);
                }
                if (compare != 0) {
                    return compare * (condition.getOrder().equals(SortOrder.ASC) ? 1 : -1);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return compare;
    }
}
