package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.db.meta.QHT_HrkmNyknData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_HrkmNyknData;

public class SortHT_HrkmNyknData {

    
    public List<HT_HrkmNyknData> OrderHT_HrkmNyknDataByPkAsc(List<HT_HrkmNyknData> pEntity) {
        List<SortCondition<HT_HrkmNyknData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_HrkmNyknData()).densyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_HrkmNyknData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_HrkmNyknData()).itirenno, SortOrder.ASC));
        List<HT_HrkmNyknData> copyList = new ArrayList<HT_HrkmNyknData>(pEntity);
        Collections.sort(copyList, new OrderHT_HrkmNyknData(orders));
        return copyList;
    }

    
    public List<HT_HrkmNyknData> OrderHT_HrkmNyknDataByPkDesc(List<HT_HrkmNyknData> pEntity) {
        List<SortCondition<HT_HrkmNyknData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_HrkmNyknData()).densyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_HrkmNyknData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_HrkmNyknData()).itirenno, SortOrder.DESC));
        List<HT_HrkmNyknData> copyList = new ArrayList<HT_HrkmNyknData>(pEntity);
        Collections.sort(copyList, new OrderHT_HrkmNyknData(orders));
        return copyList;
    }

}

