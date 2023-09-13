package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_NyuukinKakusyouData;
import yuyu.def.db.meta.QIT_BAK_NyuukinKakusyouData;
import yuyu.def.hozen.comparator.OrderIT_BAK_NyuukinKakusyouData;

public class SortIT_BAK_NyuukinKakusyouData {

    public List<IT_BAK_NyuukinKakusyouData> OrderIT_BAK_NyuukinKakusyouDataByPkAsc(List<IT_BAK_NyuukinKakusyouData> pEntity) {
        List<SortCondition<IT_BAK_NyuukinKakusyouData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_NyuukinKakusyouData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_NyuukinKakusyouData()).nyuukinkakusyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_NyuukinKakusyouData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_NyuukinKakusyouData()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_NyuukinKakusyouData> copyList = new ArrayList<IT_BAK_NyuukinKakusyouData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_NyuukinKakusyouData(orders));
        return copyList;
    }

    public List<IT_BAK_NyuukinKakusyouData> OrderIT_BAK_NyuukinKakusyouDataByPkDesc(List<IT_BAK_NyuukinKakusyouData> pEntity) {
        List<SortCondition<IT_BAK_NyuukinKakusyouData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_NyuukinKakusyouData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_NyuukinKakusyouData()).nyuukinkakusyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_NyuukinKakusyouData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_NyuukinKakusyouData()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_NyuukinKakusyouData> copyList = new ArrayList<IT_BAK_NyuukinKakusyouData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_NyuukinKakusyouData(orders));
        return copyList;
    }
}
