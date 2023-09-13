package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.meta.QIT_KhDshrTuki;
import yuyu.def.hozen.comparator.OrderIT_KhDshrTuki;

public class SortIT_KhDshrTuki {

    public List<IT_KhDshrTuki> OrderIT_KhDshrTukiByPkAsc(List<IT_KhDshrTuki> pEntity) {
        List<SortCondition<IT_KhDshrTuki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhDshrTuki()).dshrtoukeisikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhDshrTuki()).syono, SortOrder.ASC));
        List<IT_KhDshrTuki> copyList = new ArrayList<IT_KhDshrTuki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhDshrTuki(orders));
        return copyList;
    }

    public List<IT_KhDshrTuki> OrderIT_KhDshrTukiByPkDesc(List<IT_KhDshrTuki> pEntity) {
        List<SortCondition<IT_KhDshrTuki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhDshrTuki()).dshrtoukeisikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhDshrTuki()).syono, SortOrder.DESC));
        List<IT_KhDshrTuki> copyList = new ArrayList<IT_KhDshrTuki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhDshrTuki(orders));
        return copyList;
    }
}
