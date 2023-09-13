package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.meta.QIT_NyuukinKakusyouData;
import yuyu.def.hozen.comparator.OrderIT_NyuukinKakusyouData;

public class SortIT_NyuukinKakusyouData {

    public List<IT_NyuukinKakusyouData> OrderIT_NyuukinKakusyouDataByPkAsc(List<IT_NyuukinKakusyouData> pEntity) {
        List<SortCondition<IT_NyuukinKakusyouData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_NyuukinKakusyouData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_NyuukinKakusyouData()).nyuukinkakusyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_NyuukinKakusyouData()).syono, SortOrder.ASC));
        List<IT_NyuukinKakusyouData> copyList = new ArrayList<IT_NyuukinKakusyouData>(pEntity);
        Collections.sort(copyList, new OrderIT_NyuukinKakusyouData(orders));
        return copyList;
    }

    public List<IT_NyuukinKakusyouData> OrderIT_NyuukinKakusyouDataByPkDesc(List<IT_NyuukinKakusyouData> pEntity) {
        List<SortCondition<IT_NyuukinKakusyouData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_NyuukinKakusyouData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_NyuukinKakusyouData()).nyuukinkakusyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_NyuukinKakusyouData()).syono, SortOrder.DESC));
        List<IT_NyuukinKakusyouData> copyList = new ArrayList<IT_NyuukinKakusyouData>(pEntity);
        Collections.sort(copyList, new OrderIT_NyuukinKakusyouData(orders));
        return copyList;
    }
}
