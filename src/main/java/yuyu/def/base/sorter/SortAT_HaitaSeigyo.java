package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_HaitaSeigyo;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_HaitaSeigyo;
import yuyu.def.db.meta.QAT_HaitaSeigyo;

public class SortAT_HaitaSeigyo {

    public List<AT_HaitaSeigyo> OrderAT_HaitaSeigyoByPkAsc(List<AT_HaitaSeigyo> pEntity) {
        List<SortCondition<AT_HaitaSeigyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_HaitaSeigyo()).haitaSyuruiCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_HaitaSeigyo()).haitaKey, SortOrder.ASC));
        List<AT_HaitaSeigyo> copyList = new ArrayList<AT_HaitaSeigyo>(pEntity);
        Collections.sort(copyList, new OrderAT_HaitaSeigyo(orders));
        return copyList;
    }

    public List<AT_HaitaSeigyo> OrderAT_HaitaSeigyoByPkDesc(List<AT_HaitaSeigyo> pEntity) {
        List<SortCondition<AT_HaitaSeigyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_HaitaSeigyo()).haitaSyuruiCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_HaitaSeigyo()).haitaKey, SortOrder.DESC));
        List<AT_HaitaSeigyo> copyList = new ArrayList<AT_HaitaSeigyo>(pEntity);
        Collections.sort(copyList, new OrderAT_HaitaSeigyo(orders));
        return copyList;
    }
}
