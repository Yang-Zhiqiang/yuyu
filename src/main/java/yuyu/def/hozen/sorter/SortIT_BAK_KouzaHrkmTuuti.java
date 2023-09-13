package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KouzaHrkmTuuti;
import yuyu.def.db.meta.QIT_BAK_KouzaHrkmTuuti;
import yuyu.def.hozen.comparator.OrderIT_BAK_KouzaHrkmTuuti;

public class SortIT_BAK_KouzaHrkmTuuti {

    public List<IT_BAK_KouzaHrkmTuuti> OrderIT_BAK_KouzaHrkmTuutiByPkAsc(List<IT_BAK_KouzaHrkmTuuti> pEntity) {
        List<SortCondition<IT_BAK_KouzaHrkmTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHrkmTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHrkmTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHrkmTuuti()).krkno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHrkmTuuti()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_KouzaHrkmTuuti> copyList = new ArrayList<IT_BAK_KouzaHrkmTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KouzaHrkmTuuti(orders));
        return copyList;
    }

    public List<IT_BAK_KouzaHrkmTuuti> OrderIT_BAK_KouzaHrkmTuutiByPkDesc(List<IT_BAK_KouzaHrkmTuuti> pEntity) {
        List<SortCondition<IT_BAK_KouzaHrkmTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHrkmTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHrkmTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHrkmTuuti()).krkno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KouzaHrkmTuuti()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_KouzaHrkmTuuti> copyList = new ArrayList<IT_BAK_KouzaHrkmTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KouzaHrkmTuuti(orders));
        return copyList;
    }
}
