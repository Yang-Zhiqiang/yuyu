package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BAK_SmbcStyKanri;
import yuyu.def.db.meta.QHT_BAK_SmbcStyKanri;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BAK_SmbcStyKanri;

public class SortHT_BAK_SmbcStyKanri {

    
    public List<HT_BAK_SmbcStyKanri> OrderHT_BAK_SmbcStyKanriByPkAsc(List<HT_BAK_SmbcStyKanri> pEntity) {
        List<SortCondition<HT_BAK_SmbcStyKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BAK_SmbcStyKanri()).datarenymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BAK_SmbcStyKanri()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BAK_SmbcStyKanri()).datasakuseirenno, SortOrder.ASC));
        List<HT_BAK_SmbcStyKanri> copyList = new ArrayList<HT_BAK_SmbcStyKanri>(pEntity);
        Collections.sort(copyList, new OrderHT_BAK_SmbcStyKanri(orders));
        return copyList;
    }

    
    public List<HT_BAK_SmbcStyKanri> OrderHT_BAK_SmbcStyKanriByPkDesc(List<HT_BAK_SmbcStyKanri> pEntity) {
        List<SortCondition<HT_BAK_SmbcStyKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BAK_SmbcStyKanri()).datarenymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BAK_SmbcStyKanri()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BAK_SmbcStyKanri()).datasakuseirenno, SortOrder.DESC));
        List<HT_BAK_SmbcStyKanri> copyList = new ArrayList<HT_BAK_SmbcStyKanri>(pEntity);
        Collections.sort(copyList, new OrderHT_BAK_SmbcStyKanri(orders));
        return copyList;
    }

}

