package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SeisanDHaneiTuuti;
import yuyu.def.db.meta.QIT_SeisanDHaneiTuuti;
import yuyu.def.hozen.comparator.OrderIT_SeisanDHaneiTuuti;

public class SortIT_SeisanDHaneiTuuti {

    public List<IT_SeisanDHaneiTuuti> OrderIT_SeisanDHaneiTuutiByPkAsc(List<IT_SeisanDHaneiTuuti> pEntity) {
        List<SortCondition<IT_SeisanDHaneiTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SeisanDHaneiTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SeisanDHaneiTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SeisanDHaneiTuuti()).haitounendo, SortOrder.ASC));
        List<IT_SeisanDHaneiTuuti> copyList = new ArrayList<IT_SeisanDHaneiTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_SeisanDHaneiTuuti(orders));
        return copyList;
    }

    public List<IT_SeisanDHaneiTuuti> OrderIT_SeisanDHaneiTuutiByPkDesc(List<IT_SeisanDHaneiTuuti> pEntity) {
        List<SortCondition<IT_SeisanDHaneiTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SeisanDHaneiTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SeisanDHaneiTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SeisanDHaneiTuuti()).haitounendo, SortOrder.DESC));
        List<IT_SeisanDHaneiTuuti> copyList = new ArrayList<IT_SeisanDHaneiTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_SeisanDHaneiTuuti(orders));
        return copyList;
    }
}
