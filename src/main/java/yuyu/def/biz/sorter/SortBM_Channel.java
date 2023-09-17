package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Channel;
import yuyu.def.db.entity.BM_Channel;
import yuyu.def.db.meta.QBM_Channel;

public class SortBM_Channel {

    public List<BM_Channel> OrderBM_ChannelByPkAsc(List<BM_Channel> pEntity) {
        List<SortCondition<BM_Channel>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Channel()).channelcd, SortOrder.ASC));
        List<BM_Channel> copyList = new ArrayList<BM_Channel>(pEntity);
        Collections.sort(copyList, new OrderBM_Channel(orders));
        return copyList;
    }

    public List<BM_Channel> OrderBM_ChannelByPkDesc(List<BM_Channel> pEntity) {
        List<SortCondition<BM_Channel>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Channel()).channelcd, SortOrder.DESC));
        List<BM_Channel> copyList = new ArrayList<BM_Channel>(pEntity);
        Collections.sort(copyList, new OrderBM_Channel(orders));
        return copyList;
    }

}

