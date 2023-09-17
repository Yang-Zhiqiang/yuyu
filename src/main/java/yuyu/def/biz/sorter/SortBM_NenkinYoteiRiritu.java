package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_NenkinYoteiRiritu;
import yuyu.def.db.entity.BM_NenkinYoteiRiritu;
import yuyu.def.db.meta.QBM_NenkinYoteiRiritu;

public class SortBM_NenkinYoteiRiritu {

    public List<BM_NenkinYoteiRiritu> OrderBM_NenkinYoteiRirituByPkAsc(List<BM_NenkinYoteiRiritu> pEntity) {
        List<SortCondition<BM_NenkinYoteiRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_NenkinYoteiRiritu()).nenkinsyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_NenkinYoteiRiritu()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_NenkinYoteiRiritu()).kykfromymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_NenkinYoteiRiritu()).kyktoymd, SortOrder.ASC));
        List<BM_NenkinYoteiRiritu> copyList = new ArrayList<BM_NenkinYoteiRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_NenkinYoteiRiritu(orders));
        return copyList;
    }

    public List<BM_NenkinYoteiRiritu> OrderBM_NenkinYoteiRirituByPkDesc(List<BM_NenkinYoteiRiritu> pEntity) {
        List<SortCondition<BM_NenkinYoteiRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_NenkinYoteiRiritu()).nenkinsyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_NenkinYoteiRiritu()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_NenkinYoteiRiritu()).kykfromymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_NenkinYoteiRiritu()).kyktoymd, SortOrder.DESC));
        List<BM_NenkinYoteiRiritu> copyList = new ArrayList<BM_NenkinYoteiRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_NenkinYoteiRiritu(orders));
        return copyList;
    }

}

