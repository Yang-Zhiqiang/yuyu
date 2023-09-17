package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_TienrisokuRiritu;
import yuyu.def.db.entity.BM_TienrisokuRiritu;
import yuyu.def.db.meta.QBM_TienrisokuRiritu;

public class SortBM_TienrisokuRiritu {

    public List<BM_TienrisokuRiritu> OrderBM_TienrisokuRirituByPkAsc(List<BM_TienrisokuRiritu> pEntity) {
        List<SortCondition<BM_TienrisokuRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TienrisokuRiritu()).tekiyoukknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_TienrisokuRiritu()).tekiyoukknkto, SortOrder.ASC));
        List<BM_TienrisokuRiritu> copyList = new ArrayList<BM_TienrisokuRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_TienrisokuRiritu(orders));
        return copyList;
    }

    public List<BM_TienrisokuRiritu> OrderBM_TienrisokuRirituByPkDesc(List<BM_TienrisokuRiritu> pEntity) {
        List<SortCondition<BM_TienrisokuRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TienrisokuRiritu()).tekiyoukknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_TienrisokuRiritu()).tekiyoukknkto, SortOrder.DESC));
        List<BM_TienrisokuRiritu> copyList = new ArrayList<BM_TienrisokuRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_TienrisokuRiritu(orders));
        return copyList;
    }
}
