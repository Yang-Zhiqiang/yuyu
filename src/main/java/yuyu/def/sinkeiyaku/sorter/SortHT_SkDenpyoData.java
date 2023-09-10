package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.meta.QHT_SkDenpyoData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkDenpyoData;

public class SortHT_SkDenpyoData {

    
    public List<HT_SkDenpyoData> OrderHT_SkDenpyoDataByPkAsc(List<HT_SkDenpyoData> pEntity) {
        List<SortCondition<HT_SkDenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkDenpyoData()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkDenpyoData()).edano, SortOrder.ASC));
        List<HT_SkDenpyoData> copyList = new ArrayList<HT_SkDenpyoData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkDenpyoData(orders));
        return copyList;
    }

    
    public List<HT_SkDenpyoData> OrderHT_SkDenpyoDataByPkDesc(List<HT_SkDenpyoData> pEntity) {
        List<SortCondition<HT_SkDenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkDenpyoData()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkDenpyoData()).edano, SortOrder.DESC));
        List<HT_SkDenpyoData> copyList = new ArrayList<HT_SkDenpyoData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkDenpyoData(orders));
        return copyList;
    }

}

