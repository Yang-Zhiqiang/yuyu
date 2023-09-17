package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkKhnKyhKgBairitu;
import yuyu.def.db.entity.BM_ChkKhnKyhKgBairitu;
import yuyu.def.db.meta.QBM_ChkKhnKyhKgBairitu;

public class SortBM_ChkKhnKyhKgBairitu {

    public List<BM_ChkKhnKyhKgBairitu> OrderBM_ChkKhnKyhKgBairituByPkAsc(List<BM_ChkKhnKyhKgBairitu> pEntity) {
        List<SortCondition<BM_ChkKhnKyhKgBairitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKhnKyhKgBairitu()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKhnKyhKgBairitu()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKhnKyhKgBairitu()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKhnKyhKgBairitu()).khnkyhkgbairitukbn, SortOrder.ASC));
        List<BM_ChkKhnKyhKgBairitu> copyList = new ArrayList<BM_ChkKhnKyhKgBairitu>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKhnKyhKgBairitu(orders));
        return copyList;
    }

    public List<BM_ChkKhnKyhKgBairitu> OrderBM_ChkKhnKyhKgBairituByPkDesc(List<BM_ChkKhnKyhKgBairitu> pEntity) {
        List<SortCondition<BM_ChkKhnKyhKgBairitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKhnKyhKgBairitu()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKhnKyhKgBairitu()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKhnKyhKgBairitu()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKhnKyhKgBairitu()).khnkyhkgbairitukbn, SortOrder.DESC));
        List<BM_ChkKhnKyhKgBairitu> copyList = new ArrayList<BM_ChkKhnKyhKgBairitu>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKhnKyhKgBairitu(orders));
        return copyList;
    }

}

