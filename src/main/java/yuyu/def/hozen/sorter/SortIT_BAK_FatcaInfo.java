package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_FatcaInfo;
import yuyu.def.db.meta.QIT_BAK_FatcaInfo;
import yuyu.def.hozen.comparator.OrderIT_BAK_FatcaInfo;

public class SortIT_BAK_FatcaInfo {

    public List<IT_BAK_FatcaInfo> OrderIT_BAK_FatcaInfoByPkAsc(List<IT_BAK_FatcaInfo> pEntity) {
        List<SortCondition<IT_BAK_FatcaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_FatcaInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_FatcaInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_FatcaInfo()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_FatcaInfo()).renno, SortOrder.ASC));
        List<IT_BAK_FatcaInfo> copyList = new ArrayList<IT_BAK_FatcaInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_FatcaInfo(orders));
        return copyList;
    }

    public List<IT_BAK_FatcaInfo> OrderIT_BAK_FatcaInfoByPkDesc(List<IT_BAK_FatcaInfo> pEntity) {
        List<SortCondition<IT_BAK_FatcaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_FatcaInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_FatcaInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_FatcaInfo()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_FatcaInfo()).renno, SortOrder.DESC));
        List<IT_BAK_FatcaInfo> copyList = new ArrayList<IT_BAK_FatcaInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_FatcaInfo(orders));
        return copyList;
    }

}

