package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.def.db.meta.QHT_SkGaikaFBSoukinData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkGaikaFBSoukinData;

public class SortHT_SkGaikaFBSoukinData {

    
    public List<HT_SkGaikaFBSoukinData> OrderHT_SkGaikaFBSoukinDataByPkAsc(List<HT_SkGaikaFBSoukinData> pEntity) {
        List<SortCondition<HT_SkGaikaFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkGaikaFBSoukinData()).fbsoukindatasikibetukey, SortOrder.ASC));
        List<HT_SkGaikaFBSoukinData> copyList = new ArrayList<HT_SkGaikaFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkGaikaFBSoukinData(orders));
        return copyList;
    }

    
    public List<HT_SkGaikaFBSoukinData> OrderHT_SkGaikaFBSoukinDataByPkDesc(List<HT_SkGaikaFBSoukinData> pEntity) {
        List<SortCondition<HT_SkGaikaFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkGaikaFBSoukinData()).fbsoukindatasikibetukey, SortOrder.DESC));
        List<HT_SkGaikaFBSoukinData> copyList = new ArrayList<HT_SkGaikaFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkGaikaFBSoukinData(orders));
        return copyList;
    }

}

