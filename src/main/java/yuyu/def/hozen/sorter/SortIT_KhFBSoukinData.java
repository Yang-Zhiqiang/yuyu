package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.meta.QIT_KhFBSoukinData;
import yuyu.def.hozen.comparator.OrderIT_KhFBSoukinData;

public class SortIT_KhFBSoukinData {

    public List<IT_KhFBSoukinData> OrderIT_KhFBSoukinDataByPkAsc(List<IT_KhFBSoukinData> pEntity) {
        List<SortCondition<IT_KhFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhFBSoukinData()).fbsoukindatasikibetukey, SortOrder.ASC));
        List<IT_KhFBSoukinData> copyList = new ArrayList<IT_KhFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhFBSoukinData(orders));
        return copyList;
    }

    public List<IT_KhFBSoukinData> OrderIT_KhFBSoukinDataByPkDesc(List<IT_KhFBSoukinData> pEntity) {
        List<SortCondition<IT_KhFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhFBSoukinData()).fbsoukindatasikibetukey, SortOrder.DESC));
        List<IT_KhFBSoukinData> copyList = new ArrayList<IT_KhFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhFBSoukinData(orders));
        return copyList;
    }

}

