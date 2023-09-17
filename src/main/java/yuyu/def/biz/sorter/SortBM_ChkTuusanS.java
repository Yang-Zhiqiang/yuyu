package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkTuusanS;
import yuyu.def.db.entity.BM_ChkTuusanS;
import yuyu.def.db.meta.QBM_ChkTuusanS;

public class SortBM_ChkTuusanS {

    public List<BM_ChkTuusanS> OrderBM_ChkTuusanSByPkAsc(List<BM_ChkTuusanS> pEntity) {
        List<SortCondition<BM_ChkTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkTuusanS()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTuusanS()).hhkntonen, SortOrder.ASC));
        List<BM_ChkTuusanS> copyList = new ArrayList<BM_ChkTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkTuusanS(orders));
        return copyList;
    }

    public List<BM_ChkTuusanS> OrderBM_ChkTuusanSByPkDesc(List<BM_ChkTuusanS> pEntity) {
        List<SortCondition<BM_ChkTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkTuusanS()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTuusanS()).hhkntonen, SortOrder.DESC));
        List<BM_ChkTuusanS> copyList = new ArrayList<BM_ChkTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkTuusanS(orders));
        return copyList;
    }

}

