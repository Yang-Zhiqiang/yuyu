package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.hozen.comparator.OrderIT_HhknSya;

public class SortIT_HhknSya {

    public List<IT_HhknSya> OrderIT_HhknSyaByPkAsc(List<IT_HhknSya> pEntity) {
        List<SortCondition<IT_HhknSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HhknSya()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HhknSya()).syono, SortOrder.ASC));
        List<IT_HhknSya> copyList = new ArrayList<IT_HhknSya>(pEntity);
        Collections.sort(copyList, new OrderIT_HhknSya(orders));
        return copyList;
    }

    public List<IT_HhknSya> OrderIT_HhknSyaByPkDesc(List<IT_HhknSya> pEntity) {
        List<SortCondition<IT_HhknSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HhknSya()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HhknSya()).syono, SortOrder.DESC));
        List<IT_HhknSya> copyList = new ArrayList<IT_HhknSya>(pEntity);
        Collections.sort(copyList, new OrderIT_HhknSya(orders));
        return copyList;
    }

}

