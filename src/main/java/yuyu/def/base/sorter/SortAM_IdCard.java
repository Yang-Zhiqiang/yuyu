package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAM_IdCard;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AM_IdCard;
import yuyu.def.db.meta.QAM_IdCard;

public class SortAM_IdCard {

    public List<AM_IdCard> OrderAM_IdCardByPkAsc(List<AM_IdCard> pEntity) {
        List<SortCondition<AM_IdCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_IdCard()).idkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAM_IdCard()).idcd, SortOrder.ASC));
        List<AM_IdCard> copyList = new ArrayList<AM_IdCard>(pEntity);
        Collections.sort(copyList, new OrderAM_IdCard(orders));
        return copyList;
    }

    public List<AM_IdCard> OrderAM_IdCardByPkDesc(List<AM_IdCard> pEntity) {
        List<SortCondition<AM_IdCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_IdCard()).idkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAM_IdCard()).idcd, SortOrder.DESC));
        List<AM_IdCard> copyList = new ArrayList<AM_IdCard>(pEntity);
        Collections.sort(copyList, new OrderAM_IdCard(orders));
        return copyList;
    }
}
