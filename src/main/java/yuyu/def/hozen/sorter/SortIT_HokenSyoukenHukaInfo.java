package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HokenSyoukenHukaInfo;
import yuyu.def.db.meta.QIT_HokenSyoukenHukaInfo;
import yuyu.def.hozen.comparator.OrderIT_HokenSyoukenHukaInfo;

public class SortIT_HokenSyoukenHukaInfo {

    public List<IT_HokenSyoukenHukaInfo> OrderIT_HokenSyoukenHukaInfoByPkAsc(List<IT_HokenSyoukenHukaInfo> pEntity) {
        List<SortCondition<IT_HokenSyoukenHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HokenSyoukenHukaInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HokenSyoukenHukaInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HokenSyoukenHukaInfo()).tyouhyouymd, SortOrder.ASC));
        List<IT_HokenSyoukenHukaInfo> copyList = new ArrayList<IT_HokenSyoukenHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_HokenSyoukenHukaInfo(orders));
        return copyList;
    }

    public List<IT_HokenSyoukenHukaInfo> OrderIT_HokenSyoukenHukaInfoByPkDesc(List<IT_HokenSyoukenHukaInfo> pEntity) {
        List<SortCondition<IT_HokenSyoukenHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HokenSyoukenHukaInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HokenSyoukenHukaInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HokenSyoukenHukaInfo()).tyouhyouymd, SortOrder.DESC));
        List<IT_HokenSyoukenHukaInfo> copyList = new ArrayList<IT_HokenSyoukenHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_HokenSyoukenHukaInfo(orders));
        return copyList;
    }
}
