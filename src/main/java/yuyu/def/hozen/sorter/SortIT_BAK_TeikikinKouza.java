package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_TeikikinKouza;
import yuyu.def.db.meta.QIT_BAK_TeikikinKouza;
import yuyu.def.hozen.comparator.OrderIT_BAK_TeikikinKouza;

public class SortIT_BAK_TeikikinKouza {

    public List<IT_BAK_TeikikinKouza> OrderIT_BAK_TeikikinKouzaByPkAsc(List<IT_BAK_TeikikinKouza> pEntity) {
        List<SortCondition<IT_BAK_TeikikinKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_TeikikinKouza()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TeikikinKouza()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TeikikinKouza()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_TeikikinKouza> copyList = new ArrayList<IT_BAK_TeikikinKouza>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_TeikikinKouza(orders));
        return copyList;
    }

    public List<IT_BAK_TeikikinKouza> OrderIT_BAK_TeikikinKouzaByPkDesc(List<IT_BAK_TeikikinKouza> pEntity) {
        List<SortCondition<IT_BAK_TeikikinKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_TeikikinKouza()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TeikikinKouza()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TeikikinKouza()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_TeikikinKouza> copyList = new ArrayList<IT_BAK_TeikikinKouza>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_TeikikinKouza(orders));
        return copyList;
    }

}

