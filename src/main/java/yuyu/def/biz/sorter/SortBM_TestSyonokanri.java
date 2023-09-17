package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_TestSyonokanri;
import yuyu.def.db.entity.BM_TestSyonokanri;
import yuyu.def.db.meta.QBM_TestSyonokanri;

public class SortBM_TestSyonokanri {

    public List<BM_TestSyonokanri> OrderBM_TestSyonokanriByPkAsc(List<BM_TestSyonokanri> pEntity) {
        List<SortCondition<BM_TestSyonokanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TestSyonokanri()).seirekinen2keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_TestSyonokanri()).bosyuusosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_TestSyonokanri()).syonorenno, SortOrder.ASC));
        List<BM_TestSyonokanri> copyList = new ArrayList<BM_TestSyonokanri>(pEntity);
        Collections.sort(copyList, new OrderBM_TestSyonokanri(orders));
        return copyList;
    }

    public List<BM_TestSyonokanri> OrderBM_TestSyonokanriByPkDesc(List<BM_TestSyonokanri> pEntity) {
        List<SortCondition<BM_TestSyonokanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TestSyonokanri()).seirekinen2keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_TestSyonokanri()).bosyuusosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_TestSyonokanri()).syonorenno, SortOrder.DESC));
        List<BM_TestSyonokanri> copyList = new ArrayList<BM_TestSyonokanri>(pEntity);
        Collections.sort(copyList, new OrderBM_TestSyonokanri(orders));
        return copyList;
    }
}
