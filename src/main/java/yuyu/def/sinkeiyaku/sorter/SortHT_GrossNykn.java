package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_GrossNykn;
import yuyu.def.db.meta.QHT_GrossNykn;
import yuyu.def.sinkeiyaku.comparator.OrderHT_GrossNykn;

public class SortHT_GrossNykn {

    
    public List<HT_GrossNykn> OrderHT_GrossNyknByPkAsc(List<HT_GrossNykn> pEntity) {
        List<SortCondition<HT_GrossNykn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_GrossNykn()).ryosyuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GrossNykn()).oyadrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GrossNykn()).renno, SortOrder.ASC));
        List<HT_GrossNykn> copyList = new ArrayList<HT_GrossNykn>(pEntity);
        Collections.sort(copyList, new OrderHT_GrossNykn(orders));
        return copyList;
    }

    
    public List<HT_GrossNykn> OrderHT_GrossNyknByPkDesc(List<HT_GrossNykn> pEntity) {
        List<SortCondition<HT_GrossNykn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_GrossNykn()).ryosyuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GrossNykn()).oyadrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GrossNykn()).renno, SortOrder.DESC));
        List<HT_GrossNykn> copyList = new ArrayList<HT_GrossNykn>(pEntity);
        Collections.sort(copyList, new OrderHT_GrossNykn(orders));
        return copyList;
    }
}
