package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KouzaHnknTuuti;
import yuyu.def.db.meta.QIT_BAK_KouzaHnknTuuti;
import yuyu.def.hozen.comparator.OrderIT_BAK_KouzaHnknTuuti;

public class SortIT_BAK_KouzaHnknTuuti {

    public List<IT_BAK_KouzaHnknTuuti> OrderIT_BAK_KouzaHnknTuutiByPkAsc(List<IT_BAK_KouzaHnknTuuti> pEntity) {
        List<SortCondition<IT_BAK_KouzaHnknTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHnknTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHnknTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHnknTuuti()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHnknTuuti()).edano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHnknTuuti()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_KouzaHnknTuuti> copyList = new ArrayList<IT_BAK_KouzaHnknTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KouzaHnknTuuti(orders));
        return copyList;
    }

    public List<IT_BAK_KouzaHnknTuuti> OrderIT_BAK_KouzaHnknTuutiByPkDesc(List<IT_BAK_KouzaHnknTuuti> pEntity) {
        List<SortCondition<IT_BAK_KouzaHnknTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHnknTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHnknTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHnknTuuti()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHnknTuuti()).edano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHnknTuuti()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_KouzaHnknTuuti> copyList = new ArrayList<IT_BAK_KouzaHnknTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KouzaHnknTuuti(orders));
        return copyList;
    }
}
