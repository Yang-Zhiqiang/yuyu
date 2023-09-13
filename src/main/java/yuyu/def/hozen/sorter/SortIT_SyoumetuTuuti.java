package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SyoumetuTuuti;
import yuyu.def.db.meta.QIT_SyoumetuTuuti;
import yuyu.def.hozen.comparator.OrderIT_SyoumetuTuuti;

public class SortIT_SyoumetuTuuti {

    public List<IT_SyoumetuTuuti> OrderIT_SyoumetuTuutiByPkAsc(List<IT_SyoumetuTuuti> pEntity) {
        List<SortCondition<IT_SyoumetuTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SyoumetuTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyoumetuTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyoumetuTuuti()).tyouhyouymd, SortOrder.ASC));
        List<IT_SyoumetuTuuti> copyList = new ArrayList<IT_SyoumetuTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_SyoumetuTuuti(orders));
        return copyList;
    }

    public List<IT_SyoumetuTuuti> OrderIT_SyoumetuTuutiByPkDesc(List<IT_SyoumetuTuuti> pEntity) {
        List<SortCondition<IT_SyoumetuTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SyoumetuTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyoumetuTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyoumetuTuuti()).tyouhyouymd, SortOrder.DESC));
        List<IT_SyoumetuTuuti> copyList = new ArrayList<IT_SyoumetuTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_SyoumetuTuuti(orders));
        return copyList;
    }
}
