package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HW_SyuHukugouSikkanZhkWk;
import yuyu.def.db.meta.QHW_SyuHukugouSikkanZhkWk;
import yuyu.def.sinkeiyaku.comparator.OrderHW_SyuHukugouSikkanZhkWk;

public class SortHW_SyuHukugouSikkanZhkWk {

    
    public List<HW_SyuHukugouSikkanZhkWk> OrderHW_SyuHukugouSikkanZhkWkByPkAsc(List<HW_SyuHukugouSikkanZhkWk> pEntity) {
        List<SortCondition<HW_SyuHukugouSikkanZhkWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_SyuHukugouSikkanZhkWk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHW_SyuHukugouSikkanZhkWk()).hknnendo, SortOrder.ASC));
        List<HW_SyuHukugouSikkanZhkWk> copyList = new ArrayList<HW_SyuHukugouSikkanZhkWk>(pEntity);
        Collections.sort(copyList, new OrderHW_SyuHukugouSikkanZhkWk(orders));
        return copyList;
    }

    
    public List<HW_SyuHukugouSikkanZhkWk> OrderHW_SyuHukugouSikkanZhkWkByPkDesc(List<HW_SyuHukugouSikkanZhkWk> pEntity) {
        List<SortCondition<HW_SyuHukugouSikkanZhkWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_SyuHukugouSikkanZhkWk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHW_SyuHukugouSikkanZhkWk()).hknnendo, SortOrder.DESC));
        List<HW_SyuHukugouSikkanZhkWk> copyList = new ArrayList<HW_SyuHukugouSikkanZhkWk>(pEntity);
        Collections.sort(copyList, new OrderHW_SyuHukugouSikkanZhkWk(orders));
        return copyList;
    }
}
