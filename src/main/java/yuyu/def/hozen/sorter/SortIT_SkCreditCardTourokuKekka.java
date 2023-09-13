package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SkCreditCardTourokuKekka;
import yuyu.def.db.meta.QIT_SkCreditCardTourokuKekka;
import yuyu.def.hozen.comparator.OrderIT_SkCreditCardTourokuKekka;

public class SortIT_SkCreditCardTourokuKekka {

    public List<IT_SkCreditCardTourokuKekka> OrderIT_SkCreditCardTourokuKekkaByPkAsc(List<IT_SkCreditCardTourokuKekka> pEntity) {
        List<SortCondition<IT_SkCreditCardTourokuKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SkCreditCardTourokuKekka()).creditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SkCreditCardTourokuKekka()).datajyusinymd, SortOrder.ASC));
        List<IT_SkCreditCardTourokuKekka> copyList = new ArrayList<IT_SkCreditCardTourokuKekka>(pEntity);
        Collections.sort(copyList, new OrderIT_SkCreditCardTourokuKekka(orders));
        return copyList;
    }

    public List<IT_SkCreditCardTourokuKekka> OrderIT_SkCreditCardTourokuKekkaByPkDesc(List<IT_SkCreditCardTourokuKekka> pEntity) {
        List<SortCondition<IT_SkCreditCardTourokuKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SkCreditCardTourokuKekka()).creditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SkCreditCardTourokuKekka()).datajyusinymd, SortOrder.DESC));
        List<IT_SkCreditCardTourokuKekka> copyList = new ArrayList<IT_SkCreditCardTourokuKekka>(pEntity);
        Collections.sort(copyList, new OrderIT_SkCreditCardTourokuKekka(orders));
        return copyList;
    }
}
