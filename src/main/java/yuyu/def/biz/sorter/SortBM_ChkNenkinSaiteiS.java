package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkNenkinSaiteiS;
import yuyu.def.db.entity.BM_ChkNenkinSaiteiS;
import yuyu.def.db.meta.QBM_ChkNenkinSaiteiS;

public class SortBM_ChkNenkinSaiteiS {

    public List<BM_ChkNenkinSaiteiS> OrderBM_ChkNenkinSaiteiSByPkAsc(List<BM_ChkNenkinSaiteiS> pEntity) {
        List<SortCondition<BM_ChkNenkinSaiteiS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNenkinSaiteiS()).nenkinkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenkinSaiteiS()).nenkinsyu, SortOrder.ASC));
        List<BM_ChkNenkinSaiteiS> copyList = new ArrayList<BM_ChkNenkinSaiteiS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNenkinSaiteiS(orders));
        return copyList;
    }

    public List<BM_ChkNenkinSaiteiS> OrderBM_ChkNenkinSaiteiSByPkDesc(List<BM_ChkNenkinSaiteiS> pEntity) {
        List<SortCondition<BM_ChkNenkinSaiteiS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNenkinSaiteiS()).nenkinkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenkinSaiteiS()).nenkinsyu, SortOrder.DESC));
        List<BM_ChkNenkinSaiteiS> copyList = new ArrayList<BM_ChkNenkinSaiteiS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNenkinSaiteiS(orders));
        return copyList;
    }

}

