package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkNensyuuBairitu;
import yuyu.def.db.entity.BM_ChkNensyuuBairitu;
import yuyu.def.db.meta.QBM_ChkNensyuuBairitu;

public class SortBM_ChkNensyuuBairitu {

    public List<BM_ChkNensyuuBairitu> OrderBM_ChkNensyuuBairituByPkAsc(List<BM_ChkNensyuuBairitu> pEntity) {
        List<SortCondition<BM_ChkNensyuuBairitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNensyuuBairitu()).nensyuukbn, SortOrder.ASC));
        List<BM_ChkNensyuuBairitu> copyList = new ArrayList<BM_ChkNensyuuBairitu>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNensyuuBairitu(orders));
        return copyList;
    }

    public List<BM_ChkNensyuuBairitu> OrderBM_ChkNensyuuBairituByPkDesc(List<BM_ChkNensyuuBairitu> pEntity) {
        List<SortCondition<BM_ChkNensyuuBairitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNensyuuBairitu()).nensyuukbn, SortOrder.DESC));
        List<BM_ChkNensyuuBairitu> copyList = new ArrayList<BM_ChkNensyuuBairitu>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNensyuuBairitu(orders));
        return copyList;
    }
}
