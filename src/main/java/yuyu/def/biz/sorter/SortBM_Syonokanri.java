package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Syonokanri;
import yuyu.def.db.entity.BM_Syonokanri;
import yuyu.def.db.meta.QBM_Syonokanri;

public class SortBM_Syonokanri {

    public List<BM_Syonokanri> OrderBM_SyonokanriByPkAsc(List<BM_Syonokanri> pEntity) {
        List<SortCondition<BM_Syonokanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Syonokanri()).seirekinen2keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_Syonokanri()).bosyuusosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_Syonokanri()).syonorenno, SortOrder.ASC));
        List<BM_Syonokanri> copyList = new ArrayList<BM_Syonokanri>(pEntity);
        Collections.sort(copyList, new OrderBM_Syonokanri(orders));
        return copyList;
    }

    public List<BM_Syonokanri> OrderBM_SyonokanriByPkDesc(List<BM_Syonokanri> pEntity) {
        List<SortCondition<BM_Syonokanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Syonokanri()).seirekinen2keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_Syonokanri()).bosyuusosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_Syonokanri()).syonorenno, SortOrder.DESC));
        List<BM_Syonokanri> copyList = new ArrayList<BM_Syonokanri>(pEntity);
        Collections.sort(copyList, new OrderBM_Syonokanri(orders));
        return copyList;
    }

}

