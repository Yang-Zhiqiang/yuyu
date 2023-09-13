package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_YuukouseiNgTuuti;
import yuyu.def.db.meta.QIT_YuukouseiNgTuuti;
import yuyu.def.hozen.comparator.OrderIT_YuukouseiNgTuuti;

public class SortIT_YuukouseiNgTuuti {

    public List<IT_YuukouseiNgTuuti> OrderIT_YuukouseiNgTuutiByPkAsc(List<IT_YuukouseiNgTuuti> pEntity) {
        List<SortCondition<IT_YuukouseiNgTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YuukouseiNgTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YuukouseiNgTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YuukouseiNgTuuti()).tyouhyouymd, SortOrder.ASC));
        List<IT_YuukouseiNgTuuti> copyList = new ArrayList<IT_YuukouseiNgTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_YuukouseiNgTuuti(orders));
        return copyList;
    }

    public List<IT_YuukouseiNgTuuti> OrderIT_YuukouseiNgTuutiByPkDesc(List<IT_YuukouseiNgTuuti> pEntity) {
        List<SortCondition<IT_YuukouseiNgTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YuukouseiNgTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YuukouseiNgTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YuukouseiNgTuuti()).tyouhyouymd, SortOrder.DESC));
        List<IT_YuukouseiNgTuuti> copyList = new ArrayList<IT_YuukouseiNgTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_YuukouseiNgTuuti(orders));
        return copyList;
    }
}
