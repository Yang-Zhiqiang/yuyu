package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_JigyouIkkatuNyuukin;
import yuyu.def.db.meta.QHT_JigyouIkkatuNyuukin;
import yuyu.def.sinkeiyaku.comparator.OrderHT_JigyouIkkatuNyuukin;

public class SortHT_JigyouIkkatuNyuukin {

    
    public List<HT_JigyouIkkatuNyuukin> OrderHT_JigyouIkkatuNyuukinByPkAsc(List<HT_JigyouIkkatuNyuukin> pEntity) {
        List<SortCondition<HT_JigyouIkkatuNyuukin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_JigyouIkkatuNyuukin()).daimosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_JigyouIkkatuNyuukin()).renno, SortOrder.ASC));
        List<HT_JigyouIkkatuNyuukin> copyList = new ArrayList<HT_JigyouIkkatuNyuukin>(pEntity);
        Collections.sort(copyList, new OrderHT_JigyouIkkatuNyuukin(orders));
        return copyList;
    }

    
    public List<HT_JigyouIkkatuNyuukin> OrderHT_JigyouIkkatuNyuukinByPkDesc(List<HT_JigyouIkkatuNyuukin> pEntity) {
        List<SortCondition<HT_JigyouIkkatuNyuukin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_JigyouIkkatuNyuukin()).daimosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_JigyouIkkatuNyuukin()).renno, SortOrder.DESC));
        List<HT_JigyouIkkatuNyuukin> copyList = new ArrayList<HT_JigyouIkkatuNyuukin>(pEntity);
        Collections.sort(copyList, new OrderHT_JigyouIkkatuNyuukin(orders));
        return copyList;
    }

}

