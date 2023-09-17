package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Syoritanto;
import yuyu.def.db.entity.BM_Syoritanto;
import yuyu.def.db.meta.QBM_Syoritanto;

public class SortBM_Syoritanto {

    public List<BM_Syoritanto> OrderBM_SyoritantoByPkAsc(List<BM_Syoritanto> pEntity) {
        List<SortCondition<BM_Syoritanto>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Syoritanto()).syoricd, SortOrder.ASC));
        List<BM_Syoritanto> copyList = new ArrayList<BM_Syoritanto>(pEntity);
        Collections.sort(copyList, new OrderBM_Syoritanto(orders));
        return copyList;
    }

    public List<BM_Syoritanto> OrderBM_SyoritantoByPkDesc(List<BM_Syoritanto> pEntity) {
        List<SortCondition<BM_Syoritanto>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Syoritanto()).syoricd, SortOrder.DESC));
        List<BM_Syoritanto> copyList = new ArrayList<BM_Syoritanto>(pEntity);
        Collections.sort(copyList, new OrderBM_Syoritanto(orders));
        return copyList;
    }
}
