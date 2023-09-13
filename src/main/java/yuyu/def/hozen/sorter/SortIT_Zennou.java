package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_Zennou;
import yuyu.def.hozen.comparator.OrderIT_Zennou;

public class SortIT_Zennou {

    public List<IT_Zennou> OrderIT_ZennouByPkAsc(List<IT_Zennou> pEntity) {
        List<SortCondition<IT_Zennou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Zennou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Zennou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Zennou()).zennoukaisiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Zennou()).renno, SortOrder.ASC));
        List<IT_Zennou> copyList = new ArrayList<IT_Zennou>(pEntity);
        Collections.sort(copyList, new OrderIT_Zennou(orders));
        return copyList;
    }

    public List<IT_Zennou> OrderIT_ZennouByPkDesc(List<IT_Zennou> pEntity) {
        List<SortCondition<IT_Zennou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Zennou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Zennou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Zennou()).zennoukaisiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Zennou()).renno, SortOrder.DESC));
        List<IT_Zennou> copyList = new ArrayList<IT_Zennou>(pEntity);
        Collections.sort(copyList, new OrderIT_Zennou(orders));
        return copyList;
    }
}
