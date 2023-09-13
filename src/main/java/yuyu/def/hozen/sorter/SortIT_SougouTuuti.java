package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SougouTuuti;
import yuyu.def.db.meta.QIT_SougouTuuti;
import yuyu.def.hozen.comparator.OrderIT_SougouTuuti;

public class SortIT_SougouTuuti {

    public List<IT_SougouTuuti> OrderIT_SougouTuutiByPkAsc(List<IT_SougouTuuti> pEntity) {
        List<SortCondition<IT_SougouTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SougouTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SougouTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SougouTuuti()).tyouhyouymd, SortOrder.ASC));
        List<IT_SougouTuuti> copyList = new ArrayList<IT_SougouTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_SougouTuuti(orders));
        return copyList;
    }

    public List<IT_SougouTuuti> OrderIT_SougouTuutiByPkDesc(List<IT_SougouTuuti> pEntity) {
        List<SortCondition<IT_SougouTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SougouTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SougouTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SougouTuuti()).tyouhyouymd, SortOrder.DESC));
        List<IT_SougouTuuti> copyList = new ArrayList<IT_SougouTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_SougouTuuti(orders));
        return copyList;
    }

}

