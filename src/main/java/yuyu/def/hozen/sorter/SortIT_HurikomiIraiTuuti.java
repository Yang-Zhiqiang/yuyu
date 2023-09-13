package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HurikomiIraiTuuti;
import yuyu.def.db.meta.QIT_HurikomiIraiTuuti;
import yuyu.def.hozen.comparator.OrderIT_HurikomiIraiTuuti;

public class SortIT_HurikomiIraiTuuti {

    public List<IT_HurikomiIraiTuuti> OrderIT_HurikomiIraiTuutiByPkAsc(List<IT_HurikomiIraiTuuti> pEntity) {
        List<SortCondition<IT_HurikomiIraiTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HurikomiIraiTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HurikomiIraiTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HurikomiIraiTuuti()).tyouhyouymd, SortOrder.ASC));
        List<IT_HurikomiIraiTuuti> copyList = new ArrayList<IT_HurikomiIraiTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_HurikomiIraiTuuti(orders));
        return copyList;
    }

    public List<IT_HurikomiIraiTuuti> OrderIT_HurikomiIraiTuutiByPkDesc(List<IT_HurikomiIraiTuuti> pEntity) {
        List<SortCondition<IT_HurikomiIraiTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HurikomiIraiTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HurikomiIraiTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HurikomiIraiTuuti()).tyouhyouymd, SortOrder.DESC));
        List<IT_HurikomiIraiTuuti> copyList = new ArrayList<IT_HurikomiIraiTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_HurikomiIraiTuuti(orders));
        return copyList;
    }

}

