package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.meta.QHT_NayoseKekka;
import yuyu.def.sinkeiyaku.comparator.OrderHT_NayoseKekka;

public class SortHT_NayoseKekka {

    
    public List<HT_NayoseKekka> OrderHT_NayoseKekkaByPkAsc(List<HT_NayoseKekka> pEntity) {
        List<SortCondition<HT_NayoseKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_NayoseKekka()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_NayoseKekka()).sntkinfotaisyousyakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_NayoseKekka()).edano, SortOrder.ASC));
        List<HT_NayoseKekka> copyList = new ArrayList<HT_NayoseKekka>(pEntity);
        Collections.sort(copyList, new OrderHT_NayoseKekka(orders));
        return copyList;
    }

    
    public List<HT_NayoseKekka> OrderHT_NayoseKekkaByPkDesc(List<HT_NayoseKekka> pEntity) {
        List<SortCondition<HT_NayoseKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_NayoseKekka()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_NayoseKekka()).sntkinfotaisyousyakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_NayoseKekka()).edano, SortOrder.DESC));
        List<HT_NayoseKekka> copyList = new ArrayList<HT_NayoseKekka>(pEntity);
        Collections.sort(copyList, new OrderHT_NayoseKekka(orders));
        return copyList;
    }

}

