package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_CreditHnknTuuti;
import yuyu.def.db.meta.QIT_BAK_CreditHnknTuuti;
import yuyu.def.hozen.comparator.OrderIT_BAK_CreditHnknTuuti;

public class SortIT_BAK_CreditHnknTuuti {

    public List<IT_BAK_CreditHnknTuuti> OrderIT_BAK_CreditHnknTuutiByPkAsc(List<IT_BAK_CreditHnknTuuti> pEntity) {
        List<SortCondition<IT_BAK_CreditHnknTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_CreditHnknTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditHnknTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditHnknTuuti()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditHnknTuuti()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditHnknTuuti()).edano, SortOrder.ASC));
        List<IT_BAK_CreditHnknTuuti> copyList = new ArrayList<IT_BAK_CreditHnknTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_CreditHnknTuuti(orders));
        return copyList;
    }

    public List<IT_BAK_CreditHnknTuuti> OrderIT_BAK_CreditHnknTuutiByPkDesc(List<IT_BAK_CreditHnknTuuti> pEntity) {
        List<SortCondition<IT_BAK_CreditHnknTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_CreditHnknTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditHnknTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditHnknTuuti()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditHnknTuuti()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditHnknTuuti()).edano, SortOrder.DESC));
        List<IT_BAK_CreditHnknTuuti> copyList = new ArrayList<IT_BAK_CreditHnknTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_CreditHnknTuuti(orders));
        return copyList;
    }
}
