package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SyouhnbetuSegment;
import yuyu.def.db.entity.BM_SyouhnbetuSegment;
import yuyu.def.db.meta.QBM_SyouhnbetuSegment;

public class SortBM_SyouhnbetuSegment {

    public List<BM_SyouhnbetuSegment> OrderBM_SyouhnbetuSegmentByPkAsc(List<BM_SyouhnbetuSegment> pEntity) {
        List<SortCondition<BM_SyouhnbetuSegment>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SyouhnbetuSegment()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SyouhnbetuSegment()).kyktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SyouhnbetuSegment()).segbunrui1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SyouhnbetuSegment()).segbunrui2, SortOrder.ASC));
        List<BM_SyouhnbetuSegment> copyList = new ArrayList<BM_SyouhnbetuSegment>(pEntity);
        Collections.sort(copyList, new OrderBM_SyouhnbetuSegment(orders));
        return copyList;
    }

    public List<BM_SyouhnbetuSegment> OrderBM_SyouhnbetuSegmentByPkDesc(List<BM_SyouhnbetuSegment> pEntity) {
        List<SortCondition<BM_SyouhnbetuSegment>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SyouhnbetuSegment()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SyouhnbetuSegment()).kyktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SyouhnbetuSegment()).segbunrui1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SyouhnbetuSegment()).segbunrui2, SortOrder.DESC));
        List<BM_SyouhnbetuSegment> copyList = new ArrayList<BM_SyouhnbetuSegment>(pEntity);
        Collections.sort(copyList, new OrderBM_SyouhnbetuSegment(orders));
        return copyList;
    }
}
