package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkJhTuusanS;
import yuyu.def.db.entity.BM_ChkJhTuusanS;
import yuyu.def.db.meta.QBM_ChkJhTuusanS;

public class SortBM_ChkJhTuusanS {

    public List<BM_ChkJhTuusanS> OrderBM_ChkJhTuusanSByPkAsc(List<BM_ChkJhTuusanS> pEntity) {
        List<SortCondition<BM_ChkJhTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhTuusanS()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhTuusanS()).hhkntonen, SortOrder.ASC));
        List<BM_ChkJhTuusanS> copyList = new ArrayList<BM_ChkJhTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhTuusanS(orders));
        return copyList;
    }

    public List<BM_ChkJhTuusanS> OrderBM_ChkJhTuusanSByPkDesc(List<BM_ChkJhTuusanS> pEntity) {
        List<SortCondition<BM_ChkJhTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhTuusanS()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhTuusanS()).hhkntonen, SortOrder.DESC));
        List<BM_ChkJhTuusanS> copyList = new ArrayList<BM_ChkJhTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhTuusanS(orders));
        return copyList;
    }

}

