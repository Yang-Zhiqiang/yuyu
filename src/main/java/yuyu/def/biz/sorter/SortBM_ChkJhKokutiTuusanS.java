package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkJhKokutiTuusanS;
import yuyu.def.db.entity.BM_ChkJhKokutiTuusanS;
import yuyu.def.db.meta.QBM_ChkJhKokutiTuusanS;

public class SortBM_ChkJhKokutiTuusanS {

    public List<BM_ChkJhKokutiTuusanS> OrderBM_ChkJhKokutiTuusanSByPkAsc(List<BM_ChkJhKokutiTuusanS> pEntity) {
        List<SortCondition<BM_ChkJhKokutiTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhKokutiTuusanS()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhKokutiTuusanS()).hhkntonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhKokutiTuusanS()).kijikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhKokutiTuusanS()).iktkktkbnfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhKokutiTuusanS()).iktkktkbnto, SortOrder.ASC));
        List<BM_ChkJhKokutiTuusanS> copyList = new ArrayList<BM_ChkJhKokutiTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhKokutiTuusanS(orders));
        return copyList;
    }

    public List<BM_ChkJhKokutiTuusanS> OrderBM_ChkJhKokutiTuusanSByPkDesc(List<BM_ChkJhKokutiTuusanS> pEntity) {
        List<SortCondition<BM_ChkJhKokutiTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhKokutiTuusanS()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhKokutiTuusanS()).hhkntonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhKokutiTuusanS()).kijikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhKokutiTuusanS()).iktkktkbnfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhKokutiTuusanS()).iktkktkbnto, SortOrder.DESC));
        List<BM_ChkJhKokutiTuusanS> copyList = new ArrayList<BM_ChkJhKokutiTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhKokutiTuusanS(orders));
        return copyList;
    }

}

