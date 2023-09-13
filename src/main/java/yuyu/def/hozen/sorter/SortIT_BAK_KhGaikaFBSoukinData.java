package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhGaikaFBSoukinData;
import yuyu.def.db.meta.QIT_BAK_KhGaikaFBSoukinData;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhGaikaFBSoukinData;

public class SortIT_BAK_KhGaikaFBSoukinData {

    public List<IT_BAK_KhGaikaFBSoukinData> OrderIT_BAK_KhGaikaFBSoukinDataByPkAsc(List<IT_BAK_KhGaikaFBSoukinData> pEntity) {
        List<SortCondition<IT_BAK_KhGaikaFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhGaikaFBSoukinData()).fbsoukindatasikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhGaikaFBSoukinData()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_KhGaikaFBSoukinData> copyList = new ArrayList<IT_BAK_KhGaikaFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhGaikaFBSoukinData(orders));
        return copyList;
    }

    public List<IT_BAK_KhGaikaFBSoukinData> OrderIT_BAK_KhGaikaFBSoukinDataByPkDesc(List<IT_BAK_KhGaikaFBSoukinData> pEntity) {
        List<SortCondition<IT_BAK_KhGaikaFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhGaikaFBSoukinData()).fbsoukindatasikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhGaikaFBSoukinData()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_KhGaikaFBSoukinData> copyList = new ArrayList<IT_BAK_KhGaikaFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhGaikaFBSoukinData(orders));
        return copyList;
    }

}

