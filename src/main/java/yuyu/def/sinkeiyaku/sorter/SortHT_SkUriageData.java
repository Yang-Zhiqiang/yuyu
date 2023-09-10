package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.meta.QHT_SkUriageData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkUriageData;

public class SortHT_SkUriageData {

    
    public List<HT_SkUriageData> OrderHT_SkUriageDataByPkAsc(List<HT_SkUriageData> pEntity) {
        List<SortCondition<HT_SkUriageData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkUriageData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkUriageData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkUriageData()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkUriageData()).authorikaisuu, SortOrder.ASC));
        List<HT_SkUriageData> copyList = new ArrayList<HT_SkUriageData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkUriageData(orders));
        return copyList;
    }

    
    public List<HT_SkUriageData> OrderHT_SkUriageDataByPkDesc(List<HT_SkUriageData> pEntity) {
        List<SortCondition<HT_SkUriageData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkUriageData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkUriageData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkUriageData()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkUriageData()).authorikaisuu, SortOrder.DESC));
        List<HT_SkUriageData> copyList = new ArrayList<HT_SkUriageData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkUriageData(orders));
        return copyList;
    }

}

