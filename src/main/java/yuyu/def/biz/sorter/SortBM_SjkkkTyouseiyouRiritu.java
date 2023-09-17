package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.meta.QBM_SjkkkTyouseiyouRiritu;

public class SortBM_SjkkkTyouseiyouRiritu {

    public List<BM_SjkkkTyouseiyouRiritu> OrderBM_SjkkkTyouseiyouRirituByPkAsc(List<BM_SjkkkTyouseiyouRiritu> pEntity) {
        List<SortCondition<BM_SjkkkTyouseiyouRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu()).hhknnenkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu()).kykfromymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu()).kyktoymd, SortOrder.ASC));
        List<BM_SjkkkTyouseiyouRiritu> copyList = new ArrayList<BM_SjkkkTyouseiyouRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_SjkkkTyouseiyouRiritu(orders));
        return copyList;
    }

    public List<BM_SjkkkTyouseiyouRiritu> OrderBM_SjkkkTyouseiyouRirituByPkDesc(List<BM_SjkkkTyouseiyouRiritu> pEntity) {
        List<SortCondition<BM_SjkkkTyouseiyouRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu()).hhknnenkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu()).kykfromymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu()).kyktoymd, SortOrder.DESC));
        List<BM_SjkkkTyouseiyouRiritu> copyList = new ArrayList<BM_SjkkkTyouseiyouRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_SjkkkTyouseiyouRiritu(orders));
        return copyList;
    }

}

