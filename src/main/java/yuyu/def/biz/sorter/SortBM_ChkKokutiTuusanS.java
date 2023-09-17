package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkKokutiTuusanS;
import yuyu.def.db.entity.BM_ChkKokutiTuusanS;
import yuyu.def.db.meta.QBM_ChkKokutiTuusanS;

public class SortBM_ChkKokutiTuusanS {

    public List<BM_ChkKokutiTuusanS> OrderBM_ChkKokutiTuusanSByPkAsc(List<BM_ChkKokutiTuusanS> pEntity) {
        List<SortCondition<BM_ChkKokutiTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKokutiTuusanS()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiTuusanS()).hhkntonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiTuusanS()).kijikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiTuusanS()).iktkktkbnfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiTuusanS()).iktkktkbnto, SortOrder.ASC));
        List<BM_ChkKokutiTuusanS> copyList = new ArrayList<BM_ChkKokutiTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKokutiTuusanS(orders));
        return copyList;
    }

    public List<BM_ChkKokutiTuusanS> OrderBM_ChkKokutiTuusanSByPkDesc(List<BM_ChkKokutiTuusanS> pEntity) {
        List<SortCondition<BM_ChkKokutiTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKokutiTuusanS()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiTuusanS()).hhkntonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiTuusanS()).kijikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiTuusanS()).iktkktkbnfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiTuusanS()).iktkktkbnto, SortOrder.DESC));
        List<BM_ChkKokutiTuusanS> copyList = new ArrayList<BM_ChkKokutiTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKokutiTuusanS(orders));
        return copyList;
    }

}

