package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.meta.QHT_SkTtdkTyuui;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkTtdkTyuui;

public class SortHT_SkTtdkTyuui {

    
    public List<HT_SkTtdkTyuui> OrderHT_SkTtdkTyuuiByPkAsc(List<HT_SkTtdkTyuui> pEntity) {
        List<SortCondition<HT_SkTtdkTyuui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkTtdkTyuui()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkTtdkTyuui()).skeittdkrenrakukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkTtdkTyuui()).datarenno, SortOrder.ASC));
        List<HT_SkTtdkTyuui> copyList = new ArrayList<HT_SkTtdkTyuui>(pEntity);
        Collections.sort(copyList, new OrderHT_SkTtdkTyuui(orders));
        return copyList;
    }

    
    public List<HT_SkTtdkTyuui> OrderHT_SkTtdkTyuuiByPkDesc(List<HT_SkTtdkTyuui> pEntity) {
        List<SortCondition<HT_SkTtdkTyuui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkTtdkTyuui()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkTtdkTyuui()).skeittdkrenrakukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkTtdkTyuui()).datarenno, SortOrder.DESC));
        List<HT_SkTtdkTyuui> copyList = new ArrayList<HT_SkTtdkTyuui>(pEntity);
        Collections.sort(copyList, new OrderHT_SkTtdkTyuui(orders));
        return copyList;
    }

    
    public List<HT_SkTtdkTyuui> OrderHT_SkTtdkTyuuiByTrkymdDatarennoAsc(List<HT_SkTtdkTyuui> pEntity) {
        List<SortCondition<HT_SkTtdkTyuui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkTtdkTyuui()).trkymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkTtdkTyuui()).datarenno, SortOrder.ASC));
        List<HT_SkTtdkTyuui> copyList = new ArrayList<HT_SkTtdkTyuui>(pEntity);
        Collections.sort(copyList, new OrderHT_SkTtdkTyuui(orders));
        return copyList;
    }

}

