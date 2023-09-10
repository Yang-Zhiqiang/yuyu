package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import yuyu.def.db.meta.QJT_SiGaikaFBSoukinData;
import yuyu.def.siharai.comparator.OrderJT_SiGaikaFBSoukinData;

public class SortJT_SiGaikaFBSoukinData {

    
    public List<JT_SiGaikaFBSoukinData> OrderJT_SiGaikaFBSoukinDataByPkAsc(List<JT_SiGaikaFBSoukinData> pEntity) {
        List<SortCondition<JT_SiGaikaFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiGaikaFBSoukinData()).fbsoukindatasikibetukey, SortOrder.ASC));
        List<JT_SiGaikaFBSoukinData> copyList = new ArrayList<JT_SiGaikaFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderJT_SiGaikaFBSoukinData(orders));
        return copyList;
    }

    
    public List<JT_SiGaikaFBSoukinData> OrderJT_SiGaikaFBSoukinDataByPkDesc(List<JT_SiGaikaFBSoukinData> pEntity) {
        List<SortCondition<JT_SiGaikaFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiGaikaFBSoukinData()).fbsoukindatasikibetukey, SortOrder.DESC));
        List<JT_SiGaikaFBSoukinData> copyList = new ArrayList<JT_SiGaikaFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderJT_SiGaikaFBSoukinData(orders));
        return copyList;
    }

}

