package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HrkeIraiInfo;
import yuyu.def.db.meta.QIT_HrkeIraiInfo;
import yuyu.def.hozen.comparator.OrderIT_HrkeIraiInfo;

public class SortIT_HrkeIraiInfo {

    public List<IT_HrkeIraiInfo> OrderIT_HrkeIraiInfoByPkAsc(List<IT_HrkeIraiInfo> pEntity) {
        List<SortCondition<IT_HrkeIraiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HrkeIraiInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HrkeIraiInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HrkeIraiInfo()).henkousikibetukey, SortOrder.ASC));
        List<IT_HrkeIraiInfo> copyList = new ArrayList<IT_HrkeIraiInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_HrkeIraiInfo(orders));
        return copyList;
    }

    public List<IT_HrkeIraiInfo> OrderIT_HrkeIraiInfoByPkDesc(List<IT_HrkeIraiInfo> pEntity) {
        List<SortCondition<IT_HrkeIraiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HrkeIraiInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HrkeIraiInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HrkeIraiInfo()).henkousikibetukey, SortOrder.DESC));
        List<IT_HrkeIraiInfo> copyList = new ArrayList<IT_HrkeIraiInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_HrkeIraiInfo(orders));
        return copyList;
    }
}
