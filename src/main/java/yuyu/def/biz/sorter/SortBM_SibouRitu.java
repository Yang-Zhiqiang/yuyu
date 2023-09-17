package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SibouRitu;
import yuyu.def.db.entity.BM_SibouRitu;
import yuyu.def.db.meta.QBM_SibouRitu;

public class SortBM_SibouRitu {

    public List<BM_SibouRitu> OrderBM_SibouRituByPkAsc(List<BM_SibouRitu> pEntity) {
        List<SortCondition<BM_SibouRitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SibouRitu()).ryouritusdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SibouRitu()).seibetu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SibouRitu()).nenrei, SortOrder.ASC));
        List<BM_SibouRitu> copyList = new ArrayList<BM_SibouRitu>(pEntity);
        Collections.sort(copyList, new OrderBM_SibouRitu(orders));
        return copyList;
    }

    public List<BM_SibouRitu> OrderBM_SibouRituByPkDesc(List<BM_SibouRitu> pEntity) {
        List<SortCondition<BM_SibouRitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SibouRitu()).ryouritusdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SibouRitu()).seibetu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SibouRitu()).nenrei, SortOrder.DESC));
        List<BM_SibouRitu> copyList = new ArrayList<BM_SibouRitu>(pEntity);
        Collections.sort(copyList, new OrderBM_SibouRitu(orders));
        return copyList;
    }
}
