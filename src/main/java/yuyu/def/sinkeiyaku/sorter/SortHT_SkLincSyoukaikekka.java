package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkLincSyoukaikekka;
import yuyu.def.db.meta.QHT_SkLincSyoukaikekka;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkLincSyoukaikekka;

public class SortHT_SkLincSyoukaikekka {

    
    public List<HT_SkLincSyoukaikekka> OrderHT_SkLincSyoukaikekkaByPkAsc(List<HT_SkLincSyoukaikekka> pEntity) {
        List<SortCondition<HT_SkLincSyoukaikekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincSyoukaikekka()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincSyoukaikekka()).lincjyusintrrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincSyoukaikekka()).renno, SortOrder.ASC));
        List<HT_SkLincSyoukaikekka> copyList = new ArrayList<HT_SkLincSyoukaikekka>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincSyoukaikekka(orders));
        return copyList;
    }

    
    public List<HT_SkLincSyoukaikekka> OrderHT_SkLincSyoukaikekkaByPkDesc(List<HT_SkLincSyoukaikekka> pEntity) {
        List<SortCondition<HT_SkLincSyoukaikekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincSyoukaikekka()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincSyoukaikekka()).lincjyusintrrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincSyoukaikekka()).renno, SortOrder.DESC));
        List<HT_SkLincSyoukaikekka> copyList = new ArrayList<HT_SkLincSyoukaikekka>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincSyoukaikekka(orders));
        return copyList;
    }
}
