package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkNenkinSyurui;
import yuyu.def.db.entity.BM_ChkNenkinSyurui;
import yuyu.def.db.meta.QBM_ChkNenkinSyurui;

public class SortBM_ChkNenkinSyurui {

    public List<BM_ChkNenkinSyurui> OrderBM_ChkNenkinSyuruiByPkAsc(List<BM_ChkNenkinSyurui> pEntity) {
        List<SortCondition<BM_ChkNenkinSyurui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNenkinSyurui()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenkinSyurui()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenkinSyurui()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenkinSyurui()).sknenkinsyu, SortOrder.ASC));
        List<BM_ChkNenkinSyurui> copyList = new ArrayList<BM_ChkNenkinSyurui>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNenkinSyurui(orders));
        return copyList;
    }

    public List<BM_ChkNenkinSyurui> OrderBM_ChkNenkinSyuruiByPkDesc(List<BM_ChkNenkinSyurui> pEntity) {
        List<SortCondition<BM_ChkNenkinSyurui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNenkinSyurui()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenkinSyurui()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenkinSyurui()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenkinSyurui()).sknenkinsyu, SortOrder.DESC));
        List<BM_ChkNenkinSyurui> copyList = new ArrayList<BM_ChkNenkinSyurui>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNenkinSyurui(orders));
        return copyList;
    }

}

