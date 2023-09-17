package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_DairitenSyougou;
import yuyu.def.db.entity.BM_DairitenSyougou;
import yuyu.def.db.meta.QBM_DairitenSyougou;

public class SortBM_DairitenSyougou {

    public List<BM_DairitenSyougou> OrderBM_DairitenSyougouByPkAsc(List<BM_DairitenSyougou> pEntity) {
        List<SortCondition<BM_DairitenSyougou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_DairitenSyougou()).drtencd, SortOrder.ASC));
        List<BM_DairitenSyougou> copyList = new ArrayList<BM_DairitenSyougou>(pEntity);
        Collections.sort(copyList, new OrderBM_DairitenSyougou(orders));
        return copyList;
    }

    public List<BM_DairitenSyougou> OrderBM_DairitenSyougouByPkDesc(List<BM_DairitenSyougou> pEntity) {
        List<SortCondition<BM_DairitenSyougou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_DairitenSyougou()).drtencd, SortOrder.DESC));
        List<BM_DairitenSyougou> copyList = new ArrayList<BM_DairitenSyougou>(pEntity);
        Collections.sort(copyList, new OrderBM_DairitenSyougou(orders));
        return copyList;
    }

}

