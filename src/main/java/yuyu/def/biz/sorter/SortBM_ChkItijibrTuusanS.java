package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkItijibrTuusanS;
import yuyu.def.db.entity.BM_ChkItijibrTuusanS;
import yuyu.def.db.meta.QBM_ChkItijibrTuusanS;

public class SortBM_ChkItijibrTuusanS {

    public List<BM_ChkItijibrTuusanS> OrderBM_ChkItijibrTuusanSByPkAsc(List<BM_ChkItijibrTuusanS> pEntity) {
        List<SortCondition<BM_ChkItijibrTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkItijibrTuusanS()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkItijibrTuusanS()).hhkntonen, SortOrder.ASC));
        List<BM_ChkItijibrTuusanS> copyList = new ArrayList<BM_ChkItijibrTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkItijibrTuusanS(orders));
        return copyList;
    }

    public List<BM_ChkItijibrTuusanS> OrderBM_ChkItijibrTuusanSByPkDesc(List<BM_ChkItijibrTuusanS> pEntity) {
        List<SortCondition<BM_ChkItijibrTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkItijibrTuusanS()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkItijibrTuusanS()).hhkntonen, SortOrder.DESC));
        List<BM_ChkItijibrTuusanS> copyList = new ArrayList<BM_ChkItijibrTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkItijibrTuusanS(orders));
        return copyList;
    }
}
