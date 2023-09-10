package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.db.meta.QJT_SiDenpyoData;
import yuyu.def.siharai.comparator.OrderJT_SiDenpyoData;

public class SortJT_SiDenpyoData {

    
    public List<JT_SiDenpyoData> OrderJT_SiDenpyoDataByPkAsc(List<JT_SiDenpyoData> pEntity) {
        List<SortCondition<JT_SiDenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiDenpyoData()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDenpyoData()).edano, SortOrder.ASC));
        List<JT_SiDenpyoData> copyList = new ArrayList<JT_SiDenpyoData>(pEntity);
        Collections.sort(copyList, new OrderJT_SiDenpyoData(orders));
        return copyList;
    }

    
    public List<JT_SiDenpyoData> OrderJT_SiDenpyoDataByPkDesc(List<JT_SiDenpyoData> pEntity) {
        List<SortCondition<JT_SiDenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiDenpyoData()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDenpyoData()).edano, SortOrder.DESC));
        List<JT_SiDenpyoData> copyList = new ArrayList<JT_SiDenpyoData>(pEntity);
        Collections.sort(copyList, new OrderJT_SiDenpyoData(orders));
        return copyList;
    }

}

