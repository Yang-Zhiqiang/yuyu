package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_ImusateiTokujyou;
import yuyu.def.db.meta.QHT_ImusateiTokujyou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_ImusateiTokujyou;

public class SortHT_ImusateiTokujyou {

    
    public List<HT_ImusateiTokujyou> OrderHT_ImusateiTokujyouByPkAsc(List<HT_ImusateiTokujyou> pEntity) {
        List<SortCondition<HT_ImusateiTokujyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_ImusateiTokujyou()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_ImusateiTokujyou()).renno, SortOrder.ASC));
        List<HT_ImusateiTokujyou> copyList = new ArrayList<HT_ImusateiTokujyou>(pEntity);
        Collections.sort(copyList, new OrderHT_ImusateiTokujyou(orders));
        return copyList;
    }

    
    public List<HT_ImusateiTokujyou> OrderHT_ImusateiTokujyouByPkDesc(List<HT_ImusateiTokujyou> pEntity) {
        List<SortCondition<HT_ImusateiTokujyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_ImusateiTokujyou()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_ImusateiTokujyou()).renno, SortOrder.DESC));
        List<HT_ImusateiTokujyou> copyList = new ArrayList<HT_ImusateiTokujyou>(pEntity);
        Collections.sort(copyList, new OrderHT_ImusateiTokujyou(orders));
        return copyList;
    }

}

