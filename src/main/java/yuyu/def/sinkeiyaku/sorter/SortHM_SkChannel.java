package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SkChannel;
import yuyu.def.db.meta.QHM_SkChannel;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SkChannel;

public class SortHM_SkChannel {

    
    public List<HM_SkChannel> OrderHM_SkChannelByPkAsc(List<HM_SkChannel> pEntity) {
        List<SortCondition<HM_SkChannel>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkChannel()).channelcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_SkChannel()).oyadrtencd, SortOrder.ASC));
        List<HM_SkChannel> copyList = new ArrayList<HM_SkChannel>(pEntity);
        Collections.sort(copyList, new OrderHM_SkChannel(orders));
        return copyList;
    }

    
    public List<HM_SkChannel> OrderHM_SkChannelByPkDesc(List<HM_SkChannel> pEntity) {
        List<SortCondition<HM_SkChannel>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkChannel()).channelcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_SkChannel()).oyadrtencd, SortOrder.DESC));
        List<HM_SkChannel> copyList = new ArrayList<HM_SkChannel>(pEntity);
        Collections.sort(copyList, new OrderHM_SkChannel(orders));
        return copyList;
    }

}

