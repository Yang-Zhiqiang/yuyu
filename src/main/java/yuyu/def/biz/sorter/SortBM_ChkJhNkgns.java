package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkJhNkgns;
import yuyu.def.db.entity.BM_ChkJhNkgns;
import yuyu.def.db.meta.QBM_ChkJhNkgns;

public class SortBM_ChkJhNkgns {

    public List<BM_ChkJhNkgns> OrderBM_ChkJhNkgnsByPkAsc(List<BM_ChkJhNkgns> pEntity) {
        List<SortCondition<BM_ChkJhNkgns>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhNkgns()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNkgns()).hhkntonen, SortOrder.ASC));
        List<BM_ChkJhNkgns> copyList = new ArrayList<BM_ChkJhNkgns>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhNkgns(orders));
        return copyList;
    }

    public List<BM_ChkJhNkgns> OrderBM_ChkJhNkgnsByPkDesc(List<BM_ChkJhNkgns> pEntity) {
        List<SortCondition<BM_ChkJhNkgns>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhNkgns()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNkgns()).hhkntonen, SortOrder.DESC));
        List<BM_ChkJhNkgns> copyList = new ArrayList<BM_ChkJhNkgns>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhNkgns(orders));
        return copyList;
    }
}
