package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.meta.QHT_KmTsRireki;
import yuyu.def.sinkeiyaku.comparator.OrderHT_KmTsRireki;

public class SortHT_KmTsRireki {

    
    public List<HT_KmTsRireki> OrderHT_KmTsRirekiByPkAsc(List<HT_KmTsRireki> pEntity) {
        List<SortCondition<HT_KmTsRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KmTsRireki()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_KmTsRireki()).syoriTime, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_KmTsRireki()).renno3keta, SortOrder.ASC));
        List<HT_KmTsRireki> copyList = new ArrayList<HT_KmTsRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_KmTsRireki(orders));
        return copyList;
    }

    
    public List<HT_KmTsRireki> OrderHT_KmTsRirekiByPkDesc(List<HT_KmTsRireki> pEntity) {
        List<SortCondition<HT_KmTsRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KmTsRireki()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_KmTsRireki()).syoriTime, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_KmTsRireki()).renno3keta, SortOrder.DESC));
        List<HT_KmTsRireki> copyList = new ArrayList<HT_KmTsRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_KmTsRireki(orders));
        return copyList;
    }

}

