package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkNkgns;
import yuyu.def.db.entity.BM_ChkNkgns;
import yuyu.def.db.meta.QBM_ChkNkgns;

public class SortBM_ChkNkgns {

    public List<BM_ChkNkgns> OrderBM_ChkNkgnsByPkAsc(List<BM_ChkNkgns> pEntity) {
        List<SortCondition<BM_ChkNkgns>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNkgns()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNkgns()).hhkntonen, SortOrder.ASC));
        List<BM_ChkNkgns> copyList = new ArrayList<BM_ChkNkgns>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNkgns(orders));
        return copyList;
    }

    public List<BM_ChkNkgns> OrderBM_ChkNkgnsByPkDesc(List<BM_ChkNkgns> pEntity) {
        List<SortCondition<BM_ChkNkgns>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNkgns()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNkgns()).hhkntonen, SortOrder.DESC));
        List<BM_ChkNkgns> copyList = new ArrayList<BM_ChkNkgns>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNkgns(orders));
        return copyList;
    }
}
