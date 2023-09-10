package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.meta.QHT_SkFBSoukinData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkFBSoukinData;

public class SortHT_SkFBSoukinData {

    
    public List<HT_SkFBSoukinData> OrderHT_SkFBSoukinDataByPkAsc(List<HT_SkFBSoukinData> pEntity) {
        List<SortCondition<HT_SkFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkFBSoukinData()).fbsoukindatasikibetukey, SortOrder.ASC));
        List<HT_SkFBSoukinData> copyList = new ArrayList<HT_SkFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkFBSoukinData(orders));
        return copyList;
    }

    
    public List<HT_SkFBSoukinData> OrderHT_SkFBSoukinDataByPkDesc(List<HT_SkFBSoukinData> pEntity) {
        List<SortCondition<HT_SkFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkFBSoukinData()).fbsoukindatasikibetukey, SortOrder.DESC));
        List<HT_SkFBSoukinData> copyList = new ArrayList<HT_SkFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkFBSoukinData(orders));
        return copyList;
    }

}

