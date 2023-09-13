package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SikkouTuuti;
import yuyu.def.db.meta.QIT_SikkouTuuti;
import yuyu.def.hozen.comparator.OrderIT_SikkouTuuti;

public class SortIT_SikkouTuuti {

    public List<IT_SikkouTuuti> OrderIT_SikkouTuutiByPkAsc(List<IT_SikkouTuuti> pEntity) {
        List<SortCondition<IT_SikkouTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SikkouTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SikkouTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SikkouTuuti()).tyouhyouymd, SortOrder.ASC));
        List<IT_SikkouTuuti> copyList = new ArrayList<IT_SikkouTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_SikkouTuuti(orders));
        return copyList;
    }

    public List<IT_SikkouTuuti> OrderIT_SikkouTuutiByPkDesc(List<IT_SikkouTuuti> pEntity) {
        List<SortCondition<IT_SikkouTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SikkouTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SikkouTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SikkouTuuti()).tyouhyouymd, SortOrder.DESC));
        List<IT_SikkouTuuti> copyList = new ArrayList<IT_SikkouTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_SikkouTuuti(orders));
        return copyList;
    }

}

