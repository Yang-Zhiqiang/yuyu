package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkSueokiKikan;
import yuyu.def.db.entity.BM_ChkSueokiKikan;
import yuyu.def.db.meta.QBM_ChkSueokiKikan;

public class SortBM_ChkSueokiKikan {

    public List<BM_ChkSueokiKikan> OrderBM_ChkSueokiKikanByPkAsc(List<BM_ChkSueokiKikan> pEntity) {
        List<SortCondition<BM_ChkSueokiKikan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).channelcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).sueokikkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).sueokikknsmnkbn, SortOrder.ASC));
        List<BM_ChkSueokiKikan> copyList = new ArrayList<BM_ChkSueokiKikan>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSueokiKikan(orders));
        return copyList;
    }

    public List<BM_ChkSueokiKikan> OrderBM_ChkSueokiKikanByPkDesc(List<BM_ChkSueokiKikan> pEntity) {
        List<SortCondition<BM_ChkSueokiKikan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).channelcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).sueokikkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSueokiKikan()).sueokikknsmnkbn, SortOrder.DESC));
        List<BM_ChkSueokiKikan> copyList = new ArrayList<BM_ChkSueokiKikan>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSueokiKikan(orders));
        return copyList;
    }
}
