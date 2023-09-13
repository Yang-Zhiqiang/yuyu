package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KouzaHnknTuuti;
import yuyu.def.db.meta.QIT_KouzaHnknTuuti;
import yuyu.def.hozen.comparator.OrderIT_KouzaHnknTuuti;

public class SortIT_KouzaHnknTuuti {

    public List<IT_KouzaHnknTuuti> OrderIT_KouzaHnknTuutiByPkAsc(List<IT_KouzaHnknTuuti> pEntity) {
        List<SortCondition<IT_KouzaHnknTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KouzaHnknTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KouzaHnknTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KouzaHnknTuuti()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KouzaHnknTuuti()).edano, SortOrder.ASC));
        List<IT_KouzaHnknTuuti> copyList = new ArrayList<IT_KouzaHnknTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_KouzaHnknTuuti(orders));
        return copyList;
    }

    public List<IT_KouzaHnknTuuti> OrderIT_KouzaHnknTuutiByPkDesc(List<IT_KouzaHnknTuuti> pEntity) {
        List<SortCondition<IT_KouzaHnknTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KouzaHnknTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KouzaHnknTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KouzaHnknTuuti()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KouzaHnknTuuti()).edano, SortOrder.DESC));
        List<IT_KouzaHnknTuuti> copyList = new ArrayList<IT_KouzaHnknTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_KouzaHnknTuuti(orders));
        return copyList;
    }
}
