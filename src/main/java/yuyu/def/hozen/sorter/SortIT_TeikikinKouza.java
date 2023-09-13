package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TeikikinKouza;
import yuyu.def.db.meta.QIT_TeikikinKouza;
import yuyu.def.hozen.comparator.OrderIT_TeikikinKouza;

public class SortIT_TeikikinKouza {

    public List<IT_TeikikinKouza> OrderIT_TeikikinKouzaByPkAsc(List<IT_TeikikinKouza> pEntity) {
        List<SortCondition<IT_TeikikinKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TeikikinKouza()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TeikikinKouza()).syono, SortOrder.ASC));
        List<IT_TeikikinKouza> copyList = new ArrayList<IT_TeikikinKouza>(pEntity);
        Collections.sort(copyList, new OrderIT_TeikikinKouza(orders));
        return copyList;
    }

    public List<IT_TeikikinKouza> OrderIT_TeikikinKouzaByPkDesc(List<IT_TeikikinKouza> pEntity) {
        List<SortCondition<IT_TeikikinKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TeikikinKouza()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TeikikinKouza()).syono, SortOrder.DESC));
        List<IT_TeikikinKouza> copyList = new ArrayList<IT_TeikikinKouza>(pEntity);
        Collections.sort(copyList, new OrderIT_TeikikinKouza(orders));
        return copyList;
    }

}

