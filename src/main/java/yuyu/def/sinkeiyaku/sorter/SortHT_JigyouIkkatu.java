package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.meta.QHT_JigyouIkkatu;
import yuyu.def.sinkeiyaku.comparator.OrderHT_JigyouIkkatu;

public class SortHT_JigyouIkkatu {

    
    public List<HT_JigyouIkkatu> OrderHT_JigyouIkkatuByPkAsc(List<HT_JigyouIkkatu> pEntity) {
        List<SortCondition<HT_JigyouIkkatu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_JigyouIkkatu()).daimosno, SortOrder.ASC));
        List<HT_JigyouIkkatu> copyList = new ArrayList<HT_JigyouIkkatu>(pEntity);
        Collections.sort(copyList, new OrderHT_JigyouIkkatu(orders));
        return copyList;
    }

    
    public List<HT_JigyouIkkatu> OrderHT_JigyouIkkatuByPkDesc(List<HT_JigyouIkkatu> pEntity) {
        List<SortCondition<HT_JigyouIkkatu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_JigyouIkkatu()).daimosno, SortOrder.DESC));
        List<HT_JigyouIkkatu> copyList = new ArrayList<HT_JigyouIkkatu>(pEntity);
        Collections.sort(copyList, new OrderHT_JigyouIkkatu(orders));
        return copyList;
    }

}

