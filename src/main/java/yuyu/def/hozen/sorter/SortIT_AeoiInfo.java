package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_AeoiInfo;
import yuyu.def.db.meta.QIT_AeoiInfo;
import yuyu.def.hozen.comparator.OrderIT_AeoiInfo;

public class SortIT_AeoiInfo {

    public List<IT_AeoiInfo> OrderIT_AeoiInfoByPkAsc(List<IT_AeoiInfo> pEntity) {
        List<SortCondition<IT_AeoiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AeoiInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AeoiInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AeoiInfo()).renno, SortOrder.ASC));
        List<IT_AeoiInfo> copyList = new ArrayList<IT_AeoiInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_AeoiInfo(orders));
        return copyList;
    }

    public List<IT_AeoiInfo> OrderIT_AeoiInfoByPkDesc(List<IT_AeoiInfo> pEntity) {
        List<SortCondition<IT_AeoiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AeoiInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AeoiInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AeoiInfo()).renno, SortOrder.DESC));
        List<IT_AeoiInfo> copyList = new ArrayList<IT_AeoiInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_AeoiInfo(orders));
        return copyList;
    }
}
