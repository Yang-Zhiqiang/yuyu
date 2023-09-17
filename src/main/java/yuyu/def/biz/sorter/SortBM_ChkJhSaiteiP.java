package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkJhSaiteiP;
import yuyu.def.db.entity.BM_ChkJhSaiteiP;
import yuyu.def.db.meta.QBM_ChkJhSaiteiP;

public class SortBM_ChkJhSaiteiP {

    public List<BM_ChkJhSaiteiP> OrderBM_ChkJhSaiteiPByPkAsc(List<BM_ChkJhSaiteiP> pEntity) {
        List<SortCondition<BM_ChkJhSaiteiP>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).hrkkaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).hrkkknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).hrkkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).channelcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).syouhinbetukey1, SortOrder.ASC));
        List<BM_ChkJhSaiteiP> copyList = new ArrayList<BM_ChkJhSaiteiP>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhSaiteiP(orders));
        return copyList;
    }

    public List<BM_ChkJhSaiteiP> OrderBM_ChkJhSaiteiPByPkDesc(List<BM_ChkJhSaiteiP> pEntity) {
        List<SortCondition<BM_ChkJhSaiteiP>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).hrkkaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).hrkkknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).hrkkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).channelcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiP()).syouhinbetukey1, SortOrder.DESC));
        List<BM_ChkJhSaiteiP> copyList = new ArrayList<BM_ChkJhSaiteiP>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhSaiteiP(orders));
        return copyList;
    }
}
