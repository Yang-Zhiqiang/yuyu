package yuyu.def.workflow.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.DT_SyoriKensuuHokanTask;
import yuyu.def.db.meta.QDT_SyoriKensuuHokanTask;
import yuyu.def.workflow.comparator.OrderDT_SyoriKensuuHokanTask;

public class SortDT_SyoriKensuuHokanTask {

    public List<DT_SyoriKensuuHokanTask> OrderDT_SyoriKensuuHokanTaskByPkAsc(List<DT_SyoriKensuuHokanTask> pEntity) {
        List<SortCondition<DT_SyoriKensuuHokanTask>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanTask()).kensuuHokanYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanTask()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanTask()).tskid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanTask()).accountId, SortOrder.ASC));
        List<DT_SyoriKensuuHokanTask> copyList = new ArrayList<DT_SyoriKensuuHokanTask>(pEntity);
        Collections.sort(copyList, new OrderDT_SyoriKensuuHokanTask(orders));
        return copyList;
    }

    public List<DT_SyoriKensuuHokanTask> OrderDT_SyoriKensuuHokanTaskByPkDesc(List<DT_SyoriKensuuHokanTask> pEntity) {
        List<SortCondition<DT_SyoriKensuuHokanTask>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanTask()).kensuuHokanYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanTask()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanTask()).tskid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDT_SyoriKensuuHokanTask()).accountId, SortOrder.DESC));
        List<DT_SyoriKensuuHokanTask> copyList = new ArrayList<DT_SyoriKensuuHokanTask>(pEntity);
        Collections.sort(copyList, new OrderDT_SyoriKensuuHokanTask(orders));
        return copyList;
    }
}
