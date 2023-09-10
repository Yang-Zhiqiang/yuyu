package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.meta.QHT_GaikaHrkmNyknData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_GaikaHrkmNyknData;

public class SortHT_GaikaHrkmNyknData {

    
    public List<HT_GaikaHrkmNyknData> OrderHT_GaikaHrkmNyknDataByPkAsc(List<HT_GaikaHrkmNyknData> pEntity) {
        List<SortCondition<HT_GaikaHrkmNyknData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_GaikaHrkmNyknData()).densyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GaikaHrkmNyknData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GaikaHrkmNyknData()).itirenno, SortOrder.ASC));
        List<HT_GaikaHrkmNyknData> copyList = new ArrayList<HT_GaikaHrkmNyknData>(pEntity);
        Collections.sort(copyList, new OrderHT_GaikaHrkmNyknData(orders));
        return copyList;
    }

    
    public List<HT_GaikaHrkmNyknData> OrderHT_GaikaHrkmNyknDataByPkDesc(List<HT_GaikaHrkmNyknData> pEntity) {
        List<SortCondition<HT_GaikaHrkmNyknData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_GaikaHrkmNyknData()).densyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GaikaHrkmNyknData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GaikaHrkmNyknData()).itirenno, SortOrder.DESC));
        List<HT_GaikaHrkmNyknData> copyList = new ArrayList<HT_GaikaHrkmNyknData>(pEntity);
        Collections.sort(copyList, new OrderHT_GaikaHrkmNyknData(orders));
        return copyList;
    }

}

