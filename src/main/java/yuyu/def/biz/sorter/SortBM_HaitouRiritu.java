package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_HaitouRiritu;
import yuyu.def.db.entity.BM_HaitouRiritu;
import yuyu.def.db.meta.QBM_HaitouRiritu;

public class SortBM_HaitouRiritu {

    public List<BM_HaitouRiritu> OrderBM_HaitouRirituByPkAsc(List<BM_HaitouRiritu> pEntity) {
        List<SortCondition<BM_HaitouRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_HaitouRiritu()).kijyunfromymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_HaitouRiritu()).kijyuntoymd, SortOrder.ASC));
        List<BM_HaitouRiritu> copyList = new ArrayList<BM_HaitouRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_HaitouRiritu(orders));
        return copyList;
    }

    public List<BM_HaitouRiritu> OrderBM_HaitouRirituByPkDesc(List<BM_HaitouRiritu> pEntity) {
        List<SortCondition<BM_HaitouRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_HaitouRiritu()).kijyunfromymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_HaitouRiritu()).kijyuntoymd, SortOrder.DESC));
        List<BM_HaitouRiritu> copyList = new ArrayList<BM_HaitouRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_HaitouRiritu(orders));
        return copyList;
    }
}
