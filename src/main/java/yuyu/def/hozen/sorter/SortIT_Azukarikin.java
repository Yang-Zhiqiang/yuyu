package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.meta.QIT_Azukarikin;
import yuyu.def.hozen.comparator.OrderIT_Azukarikin;

public class SortIT_Azukarikin {

    public List<IT_Azukarikin> OrderIT_AzukarikinByPkAsc(List<IT_Azukarikin> pEntity) {
        List<SortCondition<IT_Azukarikin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Azukarikin()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Azukarikin()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Azukarikin()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Azukarikin()).tuukasyu, SortOrder.ASC));
        List<IT_Azukarikin> copyList = new ArrayList<IT_Azukarikin>(pEntity);
        Collections.sort(copyList, new OrderIT_Azukarikin(orders));
        return copyList;
    }

    public List<IT_Azukarikin> OrderIT_AzukarikinByPkDesc(List<IT_Azukarikin> pEntity) {
        List<SortCondition<IT_Azukarikin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Azukarikin()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Azukarikin()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Azukarikin()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Azukarikin()).tuukasyu, SortOrder.DESC));
        List<IT_Azukarikin> copyList = new ArrayList<IT_Azukarikin>(pEntity);
        Collections.sort(copyList, new OrderIT_Azukarikin(orders));
        return copyList;
    }
}
