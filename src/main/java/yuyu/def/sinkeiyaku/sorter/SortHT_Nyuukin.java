package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.def.sinkeiyaku.comparator.OrderHT_Nyuukin;

public class SortHT_Nyuukin {

    
    public List<HT_Nyuukin> OrderHT_NyuukinByPkAsc(List<HT_Nyuukin> pEntity) {
        List<SortCondition<HT_Nyuukin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Nyuukin()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_Nyuukin()).renno, SortOrder.ASC));
        List<HT_Nyuukin> copyList = new ArrayList<HT_Nyuukin>(pEntity);
        Collections.sort(copyList, new OrderHT_Nyuukin(orders));
        return copyList;
    }

    
    public List<HT_Nyuukin> OrderHT_NyuukinByPkDesc(List<HT_Nyuukin> pEntity) {
        List<SortCondition<HT_Nyuukin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Nyuukin()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_Nyuukin()).renno, SortOrder.DESC));
        List<HT_Nyuukin> copyList = new ArrayList<HT_Nyuukin>(pEntity);
        Collections.sort(copyList, new OrderHT_Nyuukin(orders));
        return copyList;
    }
    
    public List<HT_Nyuukin> OrderHT_NyuukinByRyosyuymdAsc(List<HT_Nyuukin> pEntity) {
        List<SortCondition<HT_Nyuukin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Nyuukin()).ryosyuymd, SortOrder.ASC));
        List<HT_Nyuukin> copyList = new ArrayList<HT_Nyuukin>(pEntity);
        Collections.sort(copyList, new OrderHT_Nyuukin(orders));
        return copyList;
    }
    
    public List<HT_Nyuukin> OrderHT_NyuukinByRyosyuymdDesc(List<HT_Nyuukin> pEntity) {
        List<SortCondition<HT_Nyuukin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Nyuukin()).ryosyuymd, SortOrder.DESC));
        List<HT_Nyuukin> copyList = new ArrayList<HT_Nyuukin>(pEntity);
        Collections.sort(copyList, new OrderHT_Nyuukin(orders));
        return copyList;
    }
    
    public List<HT_Nyuukin> OrderHT_NyuukinByNyksyoriymdDesc(List<HT_Nyuukin> pEntity) {
        List<SortCondition<HT_Nyuukin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Nyuukin()).nyksyoriymd, SortOrder.DESC));
        List<HT_Nyuukin> copyList = new ArrayList<HT_Nyuukin>(pEntity);
        Collections.sort(copyList, new OrderHT_Nyuukin(orders));
        return copyList;
    }

    
    public List<HT_Nyuukin> OrderHT_NyuukinByRyosyuymdRennoAsc(List<HT_Nyuukin> pEntity) {
        List<SortCondition<HT_Nyuukin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Nyuukin()).nyksyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_Nyuukin()).renno, SortOrder.ASC));
        List<HT_Nyuukin> copyList = new ArrayList<HT_Nyuukin>(pEntity);
        Collections.sort(copyList, new OrderHT_Nyuukin(orders));
        return copyList;
    }


}

