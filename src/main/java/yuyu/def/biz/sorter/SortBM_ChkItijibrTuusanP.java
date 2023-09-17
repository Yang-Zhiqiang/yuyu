package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkItijibrTuusanP;
import yuyu.def.db.entity.BM_ChkItijibrTuusanP;
import yuyu.def.db.meta.QBM_ChkItijibrTuusanP;

public class SortBM_ChkItijibrTuusanP {

    public List<BM_ChkItijibrTuusanP> OrderBM_ChkItijibrTuusanPByPkAsc(List<BM_ChkItijibrTuusanP> pEntity) {
        List<SortCondition<BM_ChkItijibrTuusanP>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkItijibrTuusanP()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkItijibrTuusanP()).hhkntonen, SortOrder.ASC));
        List<BM_ChkItijibrTuusanP> copyList = new ArrayList<BM_ChkItijibrTuusanP>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkItijibrTuusanP(orders));
        return copyList;
    }

    public List<BM_ChkItijibrTuusanP> OrderBM_ChkItijibrTuusanPByPkDesc(List<BM_ChkItijibrTuusanP> pEntity) {
        List<SortCondition<BM_ChkItijibrTuusanP>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkItijibrTuusanP()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkItijibrTuusanP()).hhkntonen, SortOrder.DESC));
        List<BM_ChkItijibrTuusanP> copyList = new ArrayList<BM_ChkItijibrTuusanP>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkItijibrTuusanP(orders));
        return copyList;
    }
}
