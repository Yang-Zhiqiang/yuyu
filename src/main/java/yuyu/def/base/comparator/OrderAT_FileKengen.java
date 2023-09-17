package yuyu.def.base.comparator;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;

import jp.co.slcs.swak.util.string.CaseFormat;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_FileKengen;

public class OrderAT_FileKengen implements Comparator<AT_FileKengen> {

    private List<SortCondition<AT_FileKengen>> conditions;

    public OrderAT_FileKengen(SortCondition<AT_FileKengen> pCondition) {
        super();
        conditions.clear();
        conditions.add(pCondition);
        initConditions();
    }

    public OrderAT_FileKengen(List<SortCondition<AT_FileKengen>> pCondition) {
        super();
        conditions = pCondition;
        initConditions();
    }

    private void initConditions() {
        for (SortCondition<AT_FileKengen> condition : conditions) {
            try {
                condition.setReadMethod(
                    AT_FileKengen.class.getMethod(
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
    public int compare(AT_FileKengen pEntity1, AT_FileKengen pEntity2) {


        if(pEntity1 == null && pEntity2 == null){
            return 0;
        }else if(pEntity1 == null){
            return 1;
        }else if(pEntity2 == null){
            return -1;
        }

        int compare = 0;
        for (SortCondition<AT_FileKengen> condition: conditions) {
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
