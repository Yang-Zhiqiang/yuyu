package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_Houjyou;
import yuyu.def.db.meta.QHT_Houjyou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_Houjyou;

public class SortHT_Houjyou {

    
    public List<HT_Houjyou> OrderHT_HoujyouByPkAsc(List<HT_Houjyou> pEntity) {
        List<SortCondition<HT_Houjyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Houjyou()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_Houjyou()).syosaikbn, SortOrder.ASC));
        List<HT_Houjyou> copyList = new ArrayList<HT_Houjyou>(pEntity);
        Collections.sort(copyList, new OrderHT_Houjyou(orders));
        return copyList;
    }

    
    public List<HT_Houjyou> OrderHT_HoujyouByPkDesc(List<HT_Houjyou> pEntity) {
        List<SortCondition<HT_Houjyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Houjyou()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_Houjyou()).syosaikbn, SortOrder.DESC));
        List<HT_Houjyou> copyList = new ArrayList<HT_Houjyou>(pEntity);
        Collections.sort(copyList, new OrderHT_Houjyou(orders));
        return copyList;
    }

}

