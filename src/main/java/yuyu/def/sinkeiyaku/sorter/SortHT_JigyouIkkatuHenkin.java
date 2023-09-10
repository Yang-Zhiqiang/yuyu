package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_JigyouIkkatuHenkin;
import yuyu.def.db.meta.QHT_JigyouIkkatuHenkin;
import yuyu.def.sinkeiyaku.comparator.OrderHT_JigyouIkkatuHenkin;

public class SortHT_JigyouIkkatuHenkin {

    
    public List<HT_JigyouIkkatuHenkin> OrderHT_JigyouIkkatuHenkinByPkAsc(List<HT_JigyouIkkatuHenkin> pEntity) {
        List<SortCondition<HT_JigyouIkkatuHenkin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_JigyouIkkatuHenkin()).daimosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_JigyouIkkatuHenkin()).renno, SortOrder.ASC));
        List<HT_JigyouIkkatuHenkin> copyList = new ArrayList<HT_JigyouIkkatuHenkin>(pEntity);
        Collections.sort(copyList, new OrderHT_JigyouIkkatuHenkin(orders));
        return copyList;
    }

    
    public List<HT_JigyouIkkatuHenkin> OrderHT_JigyouIkkatuHenkinByPkDesc(List<HT_JigyouIkkatuHenkin> pEntity) {
        List<SortCondition<HT_JigyouIkkatuHenkin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_JigyouIkkatuHenkin()).daimosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_JigyouIkkatuHenkin()).renno, SortOrder.DESC));
        List<HT_JigyouIkkatuHenkin> copyList = new ArrayList<HT_JigyouIkkatuHenkin>(pEntity);
        Collections.sort(copyList, new OrderHT_JigyouIkkatuHenkin(orders));
        return copyList;
    }

}

