package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.def.db.meta.QHT_SmbcStyKanriSsRireki;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SmbcStyKanriSsRireki;

public class SortHT_SmbcStyKanriSsRireki {

    
    public List<HT_SmbcStyKanriSsRireki> OrderHT_SmbcStyKanriSsRirekiByPkAsc(List<HT_SmbcStyKanriSsRireki> pEntity) {
        List<SortCondition<HT_SmbcStyKanriSsRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SmbcStyKanriSsRireki()).syono, SortOrder.ASC));
        List<HT_SmbcStyKanriSsRireki> copyList = new ArrayList<HT_SmbcStyKanriSsRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_SmbcStyKanriSsRireki(orders));
        return copyList;
    }

    
    public List<HT_SmbcStyKanriSsRireki> OrderHT_SmbcStyKanriSsRirekiByPkDesc(List<HT_SmbcStyKanriSsRireki> pEntity) {
        List<SortCondition<HT_SmbcStyKanriSsRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SmbcStyKanriSsRireki()).syono, SortOrder.DESC));
        List<HT_SmbcStyKanriSsRireki> copyList = new ArrayList<HT_SmbcStyKanriSsRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_SmbcStyKanriSsRireki(orders));
        return copyList;
    }

}

