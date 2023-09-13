package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BunrimaeAuthoriKekka;
import yuyu.def.db.meta.QIT_BunrimaeAuthoriKekka;
import yuyu.def.hozen.comparator.OrderIT_BunrimaeAuthoriKekka;

public class SortIT_BunrimaeAuthoriKekka {

    public List<IT_BunrimaeAuthoriKekka> OrderIT_BunrimaeAuthoriKekkaByPkAsc(List<IT_BunrimaeAuthoriKekka> pEntity) {
        List<SortCondition<IT_BunrimaeAuthoriKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BunrimaeAuthoriKekka()).creditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BunrimaeAuthoriKekka()).datajyusinymd, SortOrder.ASC));
        List<IT_BunrimaeAuthoriKekka> copyList = new ArrayList<IT_BunrimaeAuthoriKekka>(pEntity);
        Collections.sort(copyList, new OrderIT_BunrimaeAuthoriKekka(orders));
        return copyList;
    }

    public List<IT_BunrimaeAuthoriKekka> OrderIT_BunrimaeAuthoriKekkaByPkDesc(List<IT_BunrimaeAuthoriKekka> pEntity) {
        List<SortCondition<IT_BunrimaeAuthoriKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BunrimaeAuthoriKekka()).creditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BunrimaeAuthoriKekka()).datajyusinymd, SortOrder.DESC));
        List<IT_BunrimaeAuthoriKekka> copyList = new ArrayList<IT_BunrimaeAuthoriKekka>(pEntity);
        Collections.sort(copyList, new OrderIT_BunrimaeAuthoriKekka(orders));
        return copyList;
    }
}
