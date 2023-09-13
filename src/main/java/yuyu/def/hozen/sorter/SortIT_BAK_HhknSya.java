package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HhknSya;
import yuyu.def.db.meta.QIT_BAK_HhknSya;
import yuyu.def.hozen.comparator.OrderIT_BAK_HhknSya;

public class SortIT_BAK_HhknSya {

    public List<IT_BAK_HhknSya> OrderIT_BAK_HhknSyaByPkAsc(List<IT_BAK_HhknSya> pEntity) {
        List<SortCondition<IT_BAK_HhknSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HhknSya()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HhknSya()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HhknSya()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_HhknSya> copyList = new ArrayList<IT_BAK_HhknSya>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HhknSya(orders));
        return copyList;
    }

    public List<IT_BAK_HhknSya> OrderIT_BAK_HhknSyaByPkDesc(List<IT_BAK_HhknSya> pEntity) {
        List<SortCondition<IT_BAK_HhknSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HhknSya()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HhknSya()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HhknSya()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_HhknSya> copyList = new ArrayList<IT_BAK_HhknSya>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HhknSya(orders));
        return copyList;
    }

}

