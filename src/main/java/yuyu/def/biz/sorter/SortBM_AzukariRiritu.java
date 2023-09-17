package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_AzukariRiritu;
import yuyu.def.db.entity.BM_AzukariRiritu;
import yuyu.def.db.meta.QBM_AzukariRiritu;

public class SortBM_AzukariRiritu {

    public List<BM_AzukariRiritu> OrderBM_AzukariRirituByPkAsc(List<BM_AzukariRiritu> pEntity) {
        List<SortCondition<BM_AzukariRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_AzukariRiritu()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_AzukariRiritu()).tkyfromymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_AzukariRiritu()).tkytoymd, SortOrder.ASC));
        List<BM_AzukariRiritu> copyList = new ArrayList<BM_AzukariRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_AzukariRiritu(orders));
        return copyList;
    }

    public List<BM_AzukariRiritu> OrderBM_AzukariRirituByPkDesc(List<BM_AzukariRiritu> pEntity) {
        List<SortCondition<BM_AzukariRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_AzukariRiritu()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_AzukariRiritu()).tkyfromymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_AzukariRiritu()).tkytoymd, SortOrder.DESC));
        List<BM_AzukariRiritu> copyList = new ArrayList<BM_AzukariRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_AzukariRiritu(orders));
        return copyList;
    }
}
