package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HokenSyoukenHukaInfo;
import yuyu.def.db.meta.QIT_BAK_HokenSyoukenHukaInfo;
import yuyu.def.hozen.comparator.OrderIT_BAK_HokenSyoukenHukaInfo;

public class SortIT_BAK_HokenSyoukenHukaInfo {

    public List<IT_BAK_HokenSyoukenHukaInfo> OrderIT_BAK_HokenSyoukenHukaInfoByPkAsc(List<IT_BAK_HokenSyoukenHukaInfo> pEntity) {
        List<SortCondition<IT_BAK_HokenSyoukenHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyoukenHukaInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyoukenHukaInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyoukenHukaInfo()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyoukenHukaInfo()).tyouhyouymd, SortOrder.ASC));
        List<IT_BAK_HokenSyoukenHukaInfo> copyList = new ArrayList<IT_BAK_HokenSyoukenHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HokenSyoukenHukaInfo(orders));
        return copyList;
    }

    public List<IT_BAK_HokenSyoukenHukaInfo> OrderIT_BAK_HokenSyoukenHukaInfoByPkDesc(List<IT_BAK_HokenSyoukenHukaInfo> pEntity) {
        List<SortCondition<IT_BAK_HokenSyoukenHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyoukenHukaInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyoukenHukaInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyoukenHukaInfo()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyoukenHukaInfo()).tyouhyouymd, SortOrder.DESC));
        List<IT_BAK_HokenSyoukenHukaInfo> copyList = new ArrayList<IT_BAK_HokenSyoukenHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HokenSyoukenHukaInfo(orders));
        return copyList;
    }
}
