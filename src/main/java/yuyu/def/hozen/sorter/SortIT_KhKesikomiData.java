package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhKesikomiData;
import yuyu.def.db.meta.QIT_KhKesikomiData;
import yuyu.def.hozen.comparator.OrderIT_KhKesikomiData;

public class SortIT_KhKesikomiData {

    public List<IT_KhKesikomiData> OrderIT_KhKesikomiDataByPkAsc(List<IT_KhKesikomiData> pEntity) {
        List<SortCondition<IT_KhKesikomiData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhKesikomiData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhKesikomiData()).nyuukinkakusyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhKesikomiData()).syono, SortOrder.ASC));
        List<IT_KhKesikomiData> copyList = new ArrayList<IT_KhKesikomiData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhKesikomiData(orders));
        return copyList;
    }

    public List<IT_KhKesikomiData> OrderIT_KhKesikomiDataByPkDesc(List<IT_KhKesikomiData> pEntity) {
        List<SortCondition<IT_KhKesikomiData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhKesikomiData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhKesikomiData()).nyuukinkakusyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhKesikomiData()).syono, SortOrder.DESC));
        List<IT_KhKesikomiData> copyList = new ArrayList<IT_KhKesikomiData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhKesikomiData(orders));
        return copyList;
    }
}
