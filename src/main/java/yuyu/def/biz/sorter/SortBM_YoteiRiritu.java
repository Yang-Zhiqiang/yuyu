package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_YoteiRiritu;
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.def.db.meta.QBM_YoteiRiritu;

public class SortBM_YoteiRiritu {

    public List<BM_YoteiRiritu> OrderBM_YoteiRirituByPkAsc(List<BM_YoteiRiritu> pEntity) {
        List<SortCondition<BM_YoteiRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).hhknnenkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).kykfromymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).kyktoymd, SortOrder.ASC));
        List<BM_YoteiRiritu> copyList = new ArrayList<BM_YoteiRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_YoteiRiritu(orders));
        return copyList;
    }

    public List<BM_YoteiRiritu> OrderBM_YoteiRirituByPkDesc(List<BM_YoteiRiritu> pEntity) {
        List<SortCondition<BM_YoteiRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).hhknnenkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).kykfromymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).kyktoymd, SortOrder.DESC));
        List<BM_YoteiRiritu> copyList = new ArrayList<BM_YoteiRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_YoteiRiritu(orders));
        return copyList;
    }
    public List<BM_YoteiRiritu> OrderBM_YoteiRirituByKykfromymdDesc(List<BM_YoteiRiritu> pEntity) {
        List<SortCondition<BM_YoteiRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_YoteiRiritu()).kykfromymd, SortOrder.DESC));
        List<BM_YoteiRiritu> copyList = new ArrayList<BM_YoteiRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_YoteiRiritu(orders));
        return copyList;
    }


}

