package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KouzaHrkmTuuti;
import yuyu.def.db.meta.QIT_KouzaHrkmTuuti;
import yuyu.def.hozen.comparator.OrderIT_KouzaHrkmTuuti;

public class SortIT_KouzaHrkmTuuti {

    public List<IT_KouzaHrkmTuuti> OrderIT_KouzaHrkmTuutiByPkAsc(List<IT_KouzaHrkmTuuti> pEntity) {
        List<SortCondition<IT_KouzaHrkmTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KouzaHrkmTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KouzaHrkmTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KouzaHrkmTuuti()).krkno, SortOrder.ASC));
        List<IT_KouzaHrkmTuuti> copyList = new ArrayList<IT_KouzaHrkmTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_KouzaHrkmTuuti(orders));
        return copyList;
    }

    public List<IT_KouzaHrkmTuuti> OrderIT_KouzaHrkmTuutiByPkDesc(List<IT_KouzaHrkmTuuti> pEntity) {
        List<SortCondition<IT_KouzaHrkmTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KouzaHrkmTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KouzaHrkmTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KouzaHrkmTuuti()).krkno, SortOrder.DESC));
        List<IT_KouzaHrkmTuuti> copyList = new ArrayList<IT_KouzaHrkmTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_KouzaHrkmTuuti(orders));
        return copyList;
    }
}
