package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BAK_SkDenpyoData;
import yuyu.def.db.meta.QHT_BAK_SkDenpyoData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BAK_SkDenpyoData;

public class SortHT_BAK_SkDenpyoData {

    
    public List<HT_BAK_SkDenpyoData> OrderHT_BAK_SkDenpyoDataByPkAsc(List<HT_BAK_SkDenpyoData> pEntity) {
        List<SortCondition<HT_BAK_SkDenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BAK_SkDenpyoData()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BAK_SkDenpyoData()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BAK_SkDenpyoData()).edano, SortOrder.ASC));
        List<HT_BAK_SkDenpyoData> copyList = new ArrayList<HT_BAK_SkDenpyoData>(pEntity);
        Collections.sort(copyList, new OrderHT_BAK_SkDenpyoData(orders));
        return copyList;
    }

    
    public List<HT_BAK_SkDenpyoData> OrderHT_BAK_SkDenpyoDataByPkDesc(List<HT_BAK_SkDenpyoData> pEntity) {
        List<SortCondition<HT_BAK_SkDenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BAK_SkDenpyoData()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BAK_SkDenpyoData()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BAK_SkDenpyoData()).edano, SortOrder.DESC));
        List<HT_BAK_SkDenpyoData> copyList = new ArrayList<HT_BAK_SkDenpyoData>(pEntity);
        Collections.sort(copyList, new OrderHT_BAK_SkDenpyoData(orders));
        return copyList;
    }

}

