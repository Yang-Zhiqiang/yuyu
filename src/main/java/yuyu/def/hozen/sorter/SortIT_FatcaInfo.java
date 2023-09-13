package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.meta.QIT_FatcaInfo;
import yuyu.def.hozen.comparator.OrderIT_FatcaInfo;

public class SortIT_FatcaInfo {

    public List<IT_FatcaInfo> OrderIT_FatcaInfoByPkAsc(List<IT_FatcaInfo> pEntity) {
        List<SortCondition<IT_FatcaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_FatcaInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_FatcaInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_FatcaInfo()).renno, SortOrder.ASC));
        List<IT_FatcaInfo> copyList = new ArrayList<IT_FatcaInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_FatcaInfo(orders));
        return copyList;
    }

    public List<IT_FatcaInfo> OrderIT_FatcaInfoByPkDesc(List<IT_FatcaInfo> pEntity) {
        List<SortCondition<IT_FatcaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_FatcaInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_FatcaInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_FatcaInfo()).renno, SortOrder.DESC));
        List<IT_FatcaInfo> copyList = new ArrayList<IT_FatcaInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_FatcaInfo(orders));
        return copyList;
    }

}

