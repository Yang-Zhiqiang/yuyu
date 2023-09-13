package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_Azukarikin;
import yuyu.def.db.meta.QIT_BAK_Azukarikin;
import yuyu.def.hozen.comparator.OrderIT_BAK_Azukarikin;

public class SortIT_BAK_Azukarikin {

    public List<IT_BAK_Azukarikin> OrderIT_BAK_AzukarikinByPkAsc(List<IT_BAK_Azukarikin> pEntity) {
        List<SortCondition<IT_BAK_Azukarikin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Azukarikin()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Azukarikin()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Azukarikin()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Azukarikin()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Azukarikin()).tuukasyu, SortOrder.ASC));
        List<IT_BAK_Azukarikin> copyList = new ArrayList<IT_BAK_Azukarikin>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Azukarikin(orders));
        return copyList;
    }

    public List<IT_BAK_Azukarikin> OrderIT_BAK_AzukarikinByPkDesc(List<IT_BAK_Azukarikin> pEntity) {
        List<SortCondition<IT_BAK_Azukarikin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Azukarikin()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Azukarikin()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Azukarikin()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Azukarikin()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Azukarikin()).tuukasyu, SortOrder.DESC));
        List<IT_BAK_Azukarikin> copyList = new ArrayList<IT_BAK_Azukarikin>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Azukarikin(orders));
        return copyList;
    }
}
