package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.meta.QHT_SmbcStyKanri;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SmbcStyKanri;

public class SortHT_SmbcStyKanri {

    
    public List<HT_SmbcStyKanri> OrderHT_SmbcStyKanriByPkAsc(List<HT_SmbcStyKanri> pEntity) {
        List<SortCondition<HT_SmbcStyKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SmbcStyKanri()).datarenymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SmbcStyKanri()).datasakuseirenno, SortOrder.ASC));
        List<HT_SmbcStyKanri> copyList = new ArrayList<HT_SmbcStyKanri>(pEntity);
        Collections.sort(copyList, new OrderHT_SmbcStyKanri(orders));
        return copyList;
    }

    
    public List<HT_SmbcStyKanri> OrderHT_SmbcStyKanriByPkDesc(List<HT_SmbcStyKanri> pEntity) {
        List<SortCondition<HT_SmbcStyKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SmbcStyKanri()).datarenymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SmbcStyKanri()).datasakuseirenno, SortOrder.DESC));
        List<HT_SmbcStyKanri> copyList = new ArrayList<HT_SmbcStyKanri>(pEntity);
        Collections.sort(copyList, new OrderHT_SmbcStyKanri(orders));
        return copyList;
    }

}

