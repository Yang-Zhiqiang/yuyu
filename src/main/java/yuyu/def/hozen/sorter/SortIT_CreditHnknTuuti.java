package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_CreditHnknTuuti;
import yuyu.def.db.meta.QIT_CreditHnknTuuti;
import yuyu.def.hozen.comparator.OrderIT_CreditHnknTuuti;

public class SortIT_CreditHnknTuuti {

    public List<IT_CreditHnknTuuti> OrderIT_CreditHnknTuutiByPkAsc(List<IT_CreditHnknTuuti> pEntity) {
        List<SortCondition<IT_CreditHnknTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_CreditHnknTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_CreditHnknTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_CreditHnknTuuti()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_CreditHnknTuuti()).edano, SortOrder.ASC));
        List<IT_CreditHnknTuuti> copyList = new ArrayList<IT_CreditHnknTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_CreditHnknTuuti(orders));
        return copyList;
    }

    public List<IT_CreditHnknTuuti> OrderIT_CreditHnknTuutiByPkDesc(List<IT_CreditHnknTuuti> pEntity) {
        List<SortCondition<IT_CreditHnknTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_CreditHnknTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_CreditHnknTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_CreditHnknTuuti()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_CreditHnknTuuti()).edano, SortOrder.DESC));
        List<IT_CreditHnknTuuti> copyList = new ArrayList<IT_CreditHnknTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_CreditHnknTuuti(orders));
        return copyList;
    }
}
