package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.meta.QJT_SiFBSoukinData;
import yuyu.def.siharai.comparator.OrderJT_SiFBSoukinData;

public class SortJT_SiFBSoukinData {

    
    public List<JT_SiFBSoukinData> OrderJT_SiFBSoukinDataByPkAsc(List<JT_SiFBSoukinData> pEntity) {
        List<SortCondition<JT_SiFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiFBSoukinData()).fbsoukindatasikibetukey, SortOrder.ASC));
        List<JT_SiFBSoukinData> copyList = new ArrayList<JT_SiFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderJT_SiFBSoukinData(orders));
        return copyList;
    }

    
    public List<JT_SiFBSoukinData> OrderJT_SiFBSoukinDataByPkDesc(List<JT_SiFBSoukinData> pEntity) {
        List<SortCondition<JT_SiFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiFBSoukinData()).fbsoukindatasikibetukey, SortOrder.DESC));
        List<JT_SiFBSoukinData> copyList = new ArrayList<JT_SiFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderJT_SiFBSoukinData(orders));
        return copyList;
    }

}

