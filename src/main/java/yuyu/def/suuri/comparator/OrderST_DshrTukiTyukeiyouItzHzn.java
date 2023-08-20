package yuyu.def.suuri.comparator;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;

import jp.co.slcs.swak.util.string.CaseFormat;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_DshrTukiTyukeiyouItzHzn;

public class OrderST_DshrTukiTyukeiyouItzHzn implements Comparator<ST_DshrTukiTyukeiyouItzHzn> {

    private List<SortCondition<ST_DshrTukiTyukeiyouItzHzn>> conditions;

    public OrderST_DshrTukiTyukeiyouItzHzn(SortCondition<ST_DshrTukiTyukeiyouItzHzn> pCondition) {
        super();
        conditions.clear();
        conditions.add(pCondition);
        initConditions();
    }

    public OrderST_DshrTukiTyukeiyouItzHzn(List<SortCondition<ST_DshrTukiTyukeiyouItzHzn>> pCondition) {
        super();
        conditions = pCondition;
        initConditions();
    }

    private void initConditions() {
        for (SortCondition<ST_DshrTukiTyukeiyouItzHzn> condition : conditions) {
            try {
                condition.setReadMethod(
                        ST_DshrTukiTyukeiyouItzHzn.class.getMethod(
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
    public int compare(ST_DshrTukiTyukeiyouItzHzn pEntity1, ST_DshrTukiTyukeiyouItzHzn pEntity2) {

        
        if(pEntity1 == null && pEntity2 == null){
            return 0;
        }else if(pEntity1 == null){
            return 1;
        }else if(pEntity2 == null){
            return -1;
        }

        int compare = 0;
        for (SortCondition<ST_DshrTukiTyukeiyouItzHzn> condition: conditions) {
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
