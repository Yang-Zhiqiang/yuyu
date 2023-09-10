package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkLincSousinData;
import yuyu.def.db.meta.QHT_SkLincSousinData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkLincSousinData;

public class SortHT_SkLincSousinData {

    
    public List<HT_SkLincSousinData> OrderHT_SkLincSousinDataByPkAsc(List<HT_SkLincSousinData> pEntity) {
        List<SortCondition<HT_SkLincSousinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincSousinData()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincSousinData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincSousinData()).renno, SortOrder.ASC));
        List<HT_SkLincSousinData> copyList = new ArrayList<HT_SkLincSousinData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincSousinData(orders));
        return copyList;
    }

    
    public List<HT_SkLincSousinData> OrderHT_SkLincSousinDataByPkDesc(List<HT_SkLincSousinData> pEntity) {
        List<SortCondition<HT_SkLincSousinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincSousinData()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincSousinData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincSousinData()).renno, SortOrder.DESC));
        List<HT_SkLincSousinData> copyList = new ArrayList<HT_SkLincSousinData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincSousinData(orders));
        return copyList;
    }
}
