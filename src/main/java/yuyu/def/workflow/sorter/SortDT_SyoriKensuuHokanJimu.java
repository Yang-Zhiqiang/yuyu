package yuyu.def.workflow.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import yuyu.def.db.meta.QDT_SyoriKensuuHokanJimu;
import yuyu.def.workflow.comparator.OrderDT_SyoriKensuuHokanJimu;

public class SortDT_SyoriKensuuHokanJimu {

    public List<DT_SyoriKensuuHokanJimu> OrderDT_SyoriKensuuHokanJimuByPkAsc(List<DT_SyoriKensuuHokanJimu> pEntity) {
        List<SortCondition<DT_SyoriKensuuHokanJimu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanJimu()).kensuuHokanYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanJimu()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanJimu()).accountId, SortOrder.ASC));
        List<DT_SyoriKensuuHokanJimu> copyList = new ArrayList<DT_SyoriKensuuHokanJimu>(pEntity);
        Collections.sort(copyList, new OrderDT_SyoriKensuuHokanJimu(orders));
        return copyList;
    }

    public List<DT_SyoriKensuuHokanJimu> OrderDT_SyoriKensuuHokanJimuByPkDesc(List<DT_SyoriKensuuHokanJimu> pEntity) {
        List<SortCondition<DT_SyoriKensuuHokanJimu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanJimu()).kensuuHokanYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanJimu()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanJimu()).accountId, SortOrder.DESC));
        List<DT_SyoriKensuuHokanJimu> copyList = new ArrayList<DT_SyoriKensuuHokanJimu>(pEntity);
        Collections.sort(copyList, new OrderDT_SyoriKensuuHokanJimu(orders));
        return copyList;
    }
}
