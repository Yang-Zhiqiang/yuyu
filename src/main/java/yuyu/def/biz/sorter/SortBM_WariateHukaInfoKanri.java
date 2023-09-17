package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_WariateHukaInfoKanri;
import yuyu.def.db.entity.BM_WariateHukaInfoKanri;
import yuyu.def.db.meta.QBM_WariateHukaInfoKanri;

public class SortBM_WariateHukaInfoKanri {

    public List<BM_WariateHukaInfoKanri> OrderBM_WariateHukaInfoKanriByPkAsc(List<BM_WariateHukaInfoKanri> pEntity) {
        List<SortCondition<BM_WariateHukaInfoKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_WariateHukaInfoKanri()).subSystemId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_WariateHukaInfoKanri()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_WariateHukaInfoKanri()).currenttskid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_WariateHukaInfoKanri()).renno, SortOrder.ASC));
        List<BM_WariateHukaInfoKanri> copyList = new ArrayList<BM_WariateHukaInfoKanri>(pEntity);
        Collections.sort(copyList, new OrderBM_WariateHukaInfoKanri(orders));
        return copyList;
    }

    public List<BM_WariateHukaInfoKanri> OrderBM_WariateHukaInfoKanriByPkDesc(List<BM_WariateHukaInfoKanri> pEntity) {
        List<SortCondition<BM_WariateHukaInfoKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_WariateHukaInfoKanri()).subSystemId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_WariateHukaInfoKanri()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_WariateHukaInfoKanri()).currenttskid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_WariateHukaInfoKanri()).renno, SortOrder.DESC));
        List<BM_WariateHukaInfoKanri> copyList = new ArrayList<BM_WariateHukaInfoKanri>(pEntity);
        Collections.sort(copyList, new OrderBM_WariateHukaInfoKanri(orders));
        return copyList;
    }

}

