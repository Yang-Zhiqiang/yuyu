package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.meta.QHT_CreditCardJyouhou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_CreditCardJyouhou;

public class SortHT_CreditCardJyouhou {

    
    public List<HT_CreditCardJyouhou> OrderHT_CreditCardJyouhouByPkAsc(List<HT_CreditCardJyouhou> pEntity) {
        List<SortCondition<HT_CreditCardJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_CreditCardJyouhou()).mosno, SortOrder.ASC));
        List<HT_CreditCardJyouhou> copyList = new ArrayList<HT_CreditCardJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_CreditCardJyouhou(orders));
        return copyList;
    }

    
    public List<HT_CreditCardJyouhou> OrderHT_CreditCardJyouhouByPkDesc(List<HT_CreditCardJyouhou> pEntity) {
        List<SortCondition<HT_CreditCardJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_CreditCardJyouhou()).mosno, SortOrder.DESC));
        List<HT_CreditCardJyouhou> copyList = new ArrayList<HT_CreditCardJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_CreditCardJyouhou(orders));
        return copyList;
    }

}

