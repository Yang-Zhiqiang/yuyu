package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhFBSoukinData;
import yuyu.def.db.meta.QIT_BAK_KhFBSoukinData;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhFBSoukinData;

public class SortIT_BAK_KhFBSoukinData {

    public List<IT_BAK_KhFBSoukinData> OrderIT_BAK_KhFBSoukinDataByPkAsc(List<IT_BAK_KhFBSoukinData> pEntity) {
        List<SortCondition<IT_BAK_KhFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhFBSoukinData()).fbsoukindatasikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhFBSoukinData()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_KhFBSoukinData> copyList = new ArrayList<IT_BAK_KhFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhFBSoukinData(orders));
        return copyList;
    }

    public List<IT_BAK_KhFBSoukinData> OrderIT_BAK_KhFBSoukinDataByPkDesc(List<IT_BAK_KhFBSoukinData> pEntity) {
        List<SortCondition<IT_BAK_KhFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhFBSoukinData()).fbsoukindatasikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhFBSoukinData()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_KhFBSoukinData> copyList = new ArrayList<IT_BAK_KhFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhFBSoukinData(orders));
        return copyList;
    }

}

