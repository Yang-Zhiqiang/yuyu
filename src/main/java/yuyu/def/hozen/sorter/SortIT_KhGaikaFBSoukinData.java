package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.meta.QIT_KhGaikaFBSoukinData;
import yuyu.def.hozen.comparator.OrderIT_KhGaikaFBSoukinData;

public class SortIT_KhGaikaFBSoukinData {

    public List<IT_KhGaikaFBSoukinData> OrderIT_KhGaikaFBSoukinDataByPkAsc(List<IT_KhGaikaFBSoukinData> pEntity) {
        List<SortCondition<IT_KhGaikaFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhGaikaFBSoukinData()).fbsoukindatasikibetukey, SortOrder.ASC));
        List<IT_KhGaikaFBSoukinData> copyList = new ArrayList<IT_KhGaikaFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhGaikaFBSoukinData(orders));
        return copyList;
    }

    public List<IT_KhGaikaFBSoukinData> OrderIT_KhGaikaFBSoukinDataByPkDesc(List<IT_KhGaikaFBSoukinData> pEntity) {
        List<SortCondition<IT_KhGaikaFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhGaikaFBSoukinData()).fbsoukindatasikibetukey, SortOrder.DESC));
        List<IT_KhGaikaFBSoukinData> copyList = new ArrayList<IT_KhGaikaFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhGaikaFBSoukinData(orders));
        return copyList;
    }

}

