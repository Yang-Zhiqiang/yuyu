package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SisyaToukeiHokan;
import yuyu.def.db.meta.QHT_SisyaToukeiHokan;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SisyaToukeiHokan;

public class SortHT_SisyaToukeiHokan {

    
    public List<HT_SisyaToukeiHokan> OrderHT_SisyaToukeiHokanByPkAsc(List<HT_SisyaToukeiHokan> pEntity) {
        List<SortCondition<HT_SisyaToukeiHokan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SisyaToukeiHokan()).sstmosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SisyaToukeiHokan()).renno, SortOrder.ASC));
        List<HT_SisyaToukeiHokan> copyList = new ArrayList<HT_SisyaToukeiHokan>(pEntity);
        Collections.sort(copyList, new OrderHT_SisyaToukeiHokan(orders));
        return copyList;
    }

    
    public List<HT_SisyaToukeiHokan> OrderHT_SisyaToukeiHokanByPkDesc(List<HT_SisyaToukeiHokan> pEntity) {
        List<SortCondition<HT_SisyaToukeiHokan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SisyaToukeiHokan()).sstmosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SisyaToukeiHokan()).renno, SortOrder.DESC));
        List<HT_SisyaToukeiHokan> copyList = new ArrayList<HT_SisyaToukeiHokan>(pEntity);
        Collections.sort(copyList, new OrderHT_SisyaToukeiHokan(orders));
        return copyList;
    }
}
