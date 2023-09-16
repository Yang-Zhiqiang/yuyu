package yuyu.def.hozen.comparator;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;

import jp.co.slcs.swak.util.string.CaseFormat;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhKzkPYokuJyuutouYoteiWk;

public class OrderIW_KhKzkPYokuJyuutouYoteiWk implements Comparator<IW_KhKzkPYokuJyuutouYoteiWk> {

    private List<SortCondition<IW_KhKzkPYokuJyuutouYoteiWk>> conditions;

    public OrderIW_KhKzkPYokuJyuutouYoteiWk(SortCondition<IW_KhKzkPYokuJyuutouYoteiWk> pCondition) {
        super();
        conditions.clear();
        conditions.add(pCondition);
        initConditions();
    }

    public OrderIW_KhKzkPYokuJyuutouYoteiWk(List<SortCondition<IW_KhKzkPYokuJyuutouYoteiWk>> pCondition) {
        super();
        conditions = pCondition;
        initConditions();
    }

    private void initConditions() {
        for (SortCondition<IW_KhKzkPYokuJyuutouYoteiWk> condition : conditions) {
            try {
                condition.setReadMethod(
                        IW_KhKzkPYokuJyuutouYoteiWk.class.getMethod(
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
    public int compare(IW_KhKzkPYokuJyuutouYoteiWk pEntity1, IW_KhKzkPYokuJyuutouYoteiWk pEntity2) {

        if(pEntity1 == null && pEntity2 == null){
            return 0;
        }else if(pEntity1 == null){
            return 1;
        }else if(pEntity2 == null){
            return -1;
        }

        int compare = 0;
        for (SortCondition<IW_KhKzkPYokuJyuutouYoteiWk> condition: conditions) {
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