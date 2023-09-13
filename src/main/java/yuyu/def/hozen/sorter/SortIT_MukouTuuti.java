package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_MukouTuuti;
import yuyu.def.db.meta.QIT_MukouTuuti;
import yuyu.def.hozen.comparator.OrderIT_MukouTuuti;

public class SortIT_MukouTuuti {

    public List<IT_MukouTuuti> OrderIT_MukouTuutiByPkAsc(List<IT_MukouTuuti> pEntity) {
        List<SortCondition<IT_MukouTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_MukouTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_MukouTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_MukouTuuti()).tyouhyouymd, SortOrder.ASC));
        List<IT_MukouTuuti> copyList = new ArrayList<IT_MukouTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_MukouTuuti(orders));
        return copyList;
    }

    public List<IT_MukouTuuti> OrderIT_MukouTuutiByPkDesc(List<IT_MukouTuuti> pEntity) {
        List<SortCondition<IT_MukouTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_MukouTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_MukouTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_MukouTuuti()).tyouhyouymd, SortOrder.DESC));
        List<IT_MukouTuuti> copyList = new ArrayList<IT_MukouTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_MukouTuuti(orders));
        return copyList;
    }

}

