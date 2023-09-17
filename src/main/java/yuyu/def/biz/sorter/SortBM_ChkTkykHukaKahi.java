package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkTkykHukaKahi;
import yuyu.def.db.entity.BM_ChkTkykHukaKahi;
import yuyu.def.db.meta.QBM_ChkTkykHukaKahi;

public class SortBM_ChkTkykHukaKahi {

    public List<BM_ChkTkykHukaKahi> OrderBM_ChkTkykHukaKahiByPkAsc(List<BM_ChkTkykHukaKahi> pEntity) {
        List<SortCondition<BM_ChkTkykHukaKahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaKahi()).tksyouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaKahi()).syusyouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaKahi()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaKahi()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaKahi()).channelcd, SortOrder.ASC));
        List<BM_ChkTkykHukaKahi> copyList = new ArrayList<BM_ChkTkykHukaKahi>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkTkykHukaKahi(orders));
        return copyList;
    }

    public List<BM_ChkTkykHukaKahi> OrderBM_ChkTkykHukaKahiByPkDesc(List<BM_ChkTkykHukaKahi> pEntity) {
        List<SortCondition<BM_ChkTkykHukaKahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaKahi()).tksyouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaKahi()).syusyouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaKahi()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaKahi()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaKahi()).channelcd, SortOrder.DESC));
        List<BM_ChkTkykHukaKahi> copyList = new ArrayList<BM_ChkTkykHukaKahi>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkTkykHukaKahi(orders));
        return copyList;
    }

}

