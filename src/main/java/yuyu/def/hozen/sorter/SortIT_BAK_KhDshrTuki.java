package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhDshrTuki;
import yuyu.def.db.meta.QIT_BAK_KhDshrTuki;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhDshrTuki;

public class SortIT_BAK_KhDshrTuki {

    public List<IT_BAK_KhDshrTuki> OrderIT_BAK_KhDshrTukiByPkAsc(List<IT_BAK_KhDshrTuki> pEntity) {
        List<SortCondition<IT_BAK_KhDshrTuki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhDshrTuki()).dshrtoukeisikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhDshrTuki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhDshrTuki()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_KhDshrTuki> copyList = new ArrayList<IT_BAK_KhDshrTuki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhDshrTuki(orders));
        return copyList;
    }

    public List<IT_BAK_KhDshrTuki> OrderIT_BAK_KhDshrTukiByPkDesc(List<IT_BAK_KhDshrTuki> pEntity) {
        List<SortCondition<IT_BAK_KhDshrTuki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhDshrTuki()).dshrtoukeisikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhDshrTuki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhDshrTuki()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_KhDshrTuki> copyList = new ArrayList<IT_BAK_KhDshrTuki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhDshrTuki(orders));
        return copyList;
    }
}
