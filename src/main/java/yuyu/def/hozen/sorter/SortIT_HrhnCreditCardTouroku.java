package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HrhnCreditCardTouroku;
import yuyu.def.db.meta.QIT_HrhnCreditCardTouroku;
import yuyu.def.hozen.comparator.OrderIT_HrhnCreditCardTouroku;

public class SortIT_HrhnCreditCardTouroku {

    public List<IT_HrhnCreditCardTouroku> OrderIT_HrhnCreditCardTourokuByPkAsc(List<IT_HrhnCreditCardTouroku> pEntity) {
        List<SortCondition<IT_HrhnCreditCardTouroku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HrhnCreditCardTouroku()).creditkessaiyouno, SortOrder.ASC));
        List<IT_HrhnCreditCardTouroku> copyList = new ArrayList<IT_HrhnCreditCardTouroku>(pEntity);
        Collections.sort(copyList, new OrderIT_HrhnCreditCardTouroku(orders));
        return copyList;
    }

    public List<IT_HrhnCreditCardTouroku> OrderIT_HrhnCreditCardTourokuByPkDesc(List<IT_HrhnCreditCardTouroku> pEntity) {
        List<SortCondition<IT_HrhnCreditCardTouroku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HrhnCreditCardTouroku()).creditkessaiyouno, SortOrder.DESC));
        List<IT_HrhnCreditCardTouroku> copyList = new ArrayList<IT_HrhnCreditCardTouroku>(pEntity);
        Collections.sort(copyList, new OrderIT_HrhnCreditCardTouroku(orders));
        return copyList;
    }
}
