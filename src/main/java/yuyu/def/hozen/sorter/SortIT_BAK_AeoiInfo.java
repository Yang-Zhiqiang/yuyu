package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_AeoiInfo;
import yuyu.def.db.meta.QIT_BAK_AeoiInfo;
import yuyu.def.hozen.comparator.OrderIT_BAK_AeoiInfo;

public class SortIT_BAK_AeoiInfo {

    public List<IT_BAK_AeoiInfo> OrderIT_BAK_AeoiInfoByPkAsc(List<IT_BAK_AeoiInfo> pEntity) {
        List<SortCondition<IT_BAK_AeoiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_AeoiInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AeoiInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AeoiInfo()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AeoiInfo()).renno, SortOrder.ASC));
        List<IT_BAK_AeoiInfo> copyList = new ArrayList<IT_BAK_AeoiInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_AeoiInfo(orders));
        return copyList;
    }

    public List<IT_BAK_AeoiInfo> OrderIT_BAK_AeoiInfoByPkDesc(List<IT_BAK_AeoiInfo> pEntity) {
        List<SortCondition<IT_BAK_AeoiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_AeoiInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AeoiInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AeoiInfo()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AeoiInfo()).renno, SortOrder.DESC));
        List<IT_BAK_AeoiInfo> copyList = new ArrayList<IT_BAK_AeoiInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_AeoiInfo(orders));
        return copyList;
    }
}
