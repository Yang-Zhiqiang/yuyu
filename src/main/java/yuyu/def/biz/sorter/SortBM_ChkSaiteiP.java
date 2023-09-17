package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkSaiteiP;
import yuyu.def.db.entity.BM_ChkSaiteiP;
import yuyu.def.db.meta.QBM_ChkSaiteiP;

public class SortBM_ChkSaiteiP {

    public List<BM_ChkSaiteiP> OrderBM_ChkSaiteiPByPkAsc(List<BM_ChkSaiteiP> pEntity) {
        List<SortCondition<BM_ChkSaiteiP>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).hrkkaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).hrkkknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).hrkkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).channelcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).syouhinbetukey1, SortOrder.ASC));
        List<BM_ChkSaiteiP> copyList = new ArrayList<BM_ChkSaiteiP>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSaiteiP(orders));
        return copyList;
    }

    public List<BM_ChkSaiteiP> OrderBM_ChkSaiteiPByPkDesc(List<BM_ChkSaiteiP> pEntity) {
        List<SortCondition<BM_ChkSaiteiP>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).hrkkaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).hrkkknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).hrkkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).channelcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiP()).syouhinbetukey1, SortOrder.DESC));
        List<BM_ChkSaiteiP> copyList = new ArrayList<BM_ChkSaiteiP>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSaiteiP(orders));
        return copyList;
    }
}
