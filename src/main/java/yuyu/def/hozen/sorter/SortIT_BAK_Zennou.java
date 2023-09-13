package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_Zennou;
import yuyu.def.db.meta.QIT_BAK_Zennou;
import yuyu.def.hozen.comparator.OrderIT_BAK_Zennou;

public class SortIT_BAK_Zennou {

    public List<IT_BAK_Zennou> OrderIT_BAK_ZennouByPkAsc(List<IT_BAK_Zennou> pEntity) {
        List<SortCondition<IT_BAK_Zennou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Zennou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Zennou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Zennou()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Zennou()).zennoukaisiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Zennou()).renno, SortOrder.ASC));
        List<IT_BAK_Zennou> copyList = new ArrayList<IT_BAK_Zennou>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Zennou(orders));
        return copyList;
    }

    public List<IT_BAK_Zennou> OrderIT_BAK_ZennouByPkDesc(List<IT_BAK_Zennou> pEntity) {
        List<SortCondition<IT_BAK_Zennou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Zennou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Zennou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Zennou()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Zennou()).zennoukaisiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Zennou()).renno, SortOrder.DESC));
        List<IT_BAK_Zennou> copyList = new ArrayList<IT_BAK_Zennou>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Zennou(orders));
        return copyList;
    }
}
