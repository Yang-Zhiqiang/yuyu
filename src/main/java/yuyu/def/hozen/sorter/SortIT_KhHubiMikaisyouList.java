package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import yuyu.def.db.meta.QIT_KhHubiMikaisyouList;
import yuyu.def.hozen.comparator.OrderIT_KhHubiMikaisyouList;

public class SortIT_KhHubiMikaisyouList {

    public List<IT_KhHubiMikaisyouList> OrderIT_KhHubiMikaisyouListByPkAsc(List<IT_KhHubiMikaisyouList> pEntity) {
        List<SortCondition<IT_KhHubiMikaisyouList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHubiMikaisyouList()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHubiMikaisyouList()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHubiMikaisyouList()).hassinsakikbn, SortOrder.ASC));
        List<IT_KhHubiMikaisyouList> copyList = new ArrayList<IT_KhHubiMikaisyouList>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHubiMikaisyouList(orders));
        return copyList;
    }

    public List<IT_KhHubiMikaisyouList> OrderIT_KhHubiMikaisyouListByPkDesc(List<IT_KhHubiMikaisyouList> pEntity) {
        List<SortCondition<IT_KhHubiMikaisyouList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHubiMikaisyouList()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHubiMikaisyouList()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHubiMikaisyouList()).hassinsakikbn, SortOrder.DESC));
        List<IT_KhHubiMikaisyouList> copyList = new ArrayList<IT_KhHubiMikaisyouList>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHubiMikaisyouList(orders));
        return copyList;
    }

    public List<IT_KhHubiMikaisyouList> OrderIT_KhHubiMikaisyouListByJimutetuzukicdLasthubbihasinymdSyonoHassinsakikbnAsc(List<IT_KhHubiMikaisyouList> pEntity) {
        List<SortCondition<IT_KhHubiMikaisyouList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHubiMikaisyouList()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHubiMikaisyouList()).lasthubbihasinymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHubiMikaisyouList()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHubiMikaisyouList()).hassinsakikbn, SortOrder.ASC));
        List<IT_KhHubiMikaisyouList> copyList = new ArrayList<IT_KhHubiMikaisyouList>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHubiMikaisyouList(orders));
        return copyList;
    }
}

