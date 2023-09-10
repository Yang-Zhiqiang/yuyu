package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.def.db.meta.QHT_HrkmNyknSakujyo;
import yuyu.def.sinkeiyaku.comparator.OrderHT_HrkmNyknSakujyo;

public class SortHT_HrkmNyknSakujyo {

    
    public List<HT_HrkmNyknSakujyo> OrderHT_HrkmNyknSakujyoByPkAsc(List<HT_HrkmNyknSakujyo> pEntity) {
        List<SortCondition<HT_HrkmNyknSakujyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_HrkmNyknSakujyo()).hrkmdeldataskbtkey, SortOrder.ASC));
        List<HT_HrkmNyknSakujyo> copyList = new ArrayList<HT_HrkmNyknSakujyo>(pEntity);
        Collections.sort(copyList, new OrderHT_HrkmNyknSakujyo(orders));
        return copyList;
    }

    
    public List<HT_HrkmNyknSakujyo> OrderHT_HrkmNyknSakujyoByPkDesc(List<HT_HrkmNyknSakujyo> pEntity) {
        List<SortCondition<HT_HrkmNyknSakujyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_HrkmNyknSakujyo()).hrkmdeldataskbtkey, SortOrder.DESC));
        List<HT_HrkmNyknSakujyo> copyList = new ArrayList<HT_HrkmNyknSakujyo>(pEntity);
        Collections.sort(copyList, new OrderHT_HrkmNyknSakujyo(orders));
        return copyList;
    }

    
    public List<HT_HrkmNyknSakujyo> OrderHT_HrkmNyknSakujyoByGyoumuKousinTimeDesc(List<HT_HrkmNyknSakujyo> pEntity) {
        List<SortCondition<HT_HrkmNyknSakujyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_HrkmNyknSakujyo()).gyoumuKousinTime, SortOrder.DESC));
        List<HT_HrkmNyknSakujyo> copyList = new ArrayList<HT_HrkmNyknSakujyo>(pEntity);
        Collections.sort(copyList, new OrderHT_HrkmNyknSakujyo(orders));
        return copyList;
    }


}

