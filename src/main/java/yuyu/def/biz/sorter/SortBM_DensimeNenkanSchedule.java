package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_DensimeNenkanSchedule;
import yuyu.def.db.entity.BM_DensimeNenkanSchedule;
import yuyu.def.db.meta.QBM_DensimeNenkanSchedule;

public class SortBM_DensimeNenkanSchedule {

    public List<BM_DensimeNenkanSchedule> OrderBM_DensimeNenkanScheduleByPkAsc(List<BM_DensimeNenkanSchedule> pEntity) {
        List<SortCondition<BM_DensimeNenkanSchedule>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_DensimeNenkanSchedule()).syoriym, SortOrder.ASC));
        List<BM_DensimeNenkanSchedule> copyList = new ArrayList<BM_DensimeNenkanSchedule>(pEntity);
        Collections.sort(copyList, new OrderBM_DensimeNenkanSchedule(orders));
        return copyList;
    }

    public List<BM_DensimeNenkanSchedule> OrderBM_DensimeNenkanScheduleByPkDesc(List<BM_DensimeNenkanSchedule> pEntity) {
        List<SortCondition<BM_DensimeNenkanSchedule>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_DensimeNenkanSchedule()).syoriym, SortOrder.DESC));
        List<BM_DensimeNenkanSchedule> copyList = new ArrayList<BM_DensimeNenkanSchedule>(pEntity);
        Collections.sort(copyList, new OrderBM_DensimeNenkanSchedule(orders));
        return copyList;
    }

}

