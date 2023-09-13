package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.meta.QIT_ItekiToukeiInfo;
import yuyu.def.hozen.comparator.OrderIT_ItekiToukeiInfo;

public class SortIT_ItekiToukeiInfo {

    public List<IT_ItekiToukeiInfo> OrderIT_ItekiToukeiInfoByPkAsc(List<IT_ItekiToukeiInfo> pEntity) {
        List<SortCondition<IT_ItekiToukeiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ItekiToukeiInfo()).syono, SortOrder.ASC));
        List<IT_ItekiToukeiInfo> copyList = new ArrayList<IT_ItekiToukeiInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_ItekiToukeiInfo(orders));
        return copyList;
    }

    public List<IT_ItekiToukeiInfo> OrderIT_ItekiToukeiInfoByPkDesc(List<IT_ItekiToukeiInfo> pEntity) {
        List<SortCondition<IT_ItekiToukeiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ItekiToukeiInfo()).syono, SortOrder.DESC));
        List<IT_ItekiToukeiInfo> copyList = new ArrayList<IT_ItekiToukeiInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_ItekiToukeiInfo(orders));
        return copyList;
    }
}
