package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HrkeIraiInfo;
import yuyu.def.db.meta.QIT_BAK_HrkeIraiInfo;
import yuyu.def.hozen.comparator.OrderIT_BAK_HrkeIraiInfo;

public class SortIT_BAK_HrkeIraiInfo {

    public List<IT_BAK_HrkeIraiInfo> OrderIT_BAK_HrkeIraiInfoByPkAsc(List<IT_BAK_HrkeIraiInfo> pEntity) {
        List<SortCondition<IT_BAK_HrkeIraiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HrkeIraiInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HrkeIraiInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HrkeIraiInfo()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HrkeIraiInfo()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_HrkeIraiInfo> copyList = new ArrayList<IT_BAK_HrkeIraiInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HrkeIraiInfo(orders));
        return copyList;
    }

    public List<IT_BAK_HrkeIraiInfo> OrderIT_BAK_HrkeIraiInfoByPkDesc(List<IT_BAK_HrkeIraiInfo> pEntity) {
        List<SortCondition<IT_BAK_HrkeIraiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HrkeIraiInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HrkeIraiInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HrkeIraiInfo()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HrkeIraiInfo()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_HrkeIraiInfo> copyList = new ArrayList<IT_BAK_HrkeIraiInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HrkeIraiInfo(orders));
        return copyList;
    }
}
