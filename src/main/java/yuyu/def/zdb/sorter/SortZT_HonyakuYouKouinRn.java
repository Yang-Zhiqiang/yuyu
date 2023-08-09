package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HonyakuYouKouinRn;
import yuyu.def.db.meta.QZT_HonyakuYouKouinRn;
import yuyu.def.zdb.comparator.OrderZT_HonyakuYouKouinRn;

public class SortZT_HonyakuYouKouinRn {

    
    public List<ZT_HonyakuYouKouinRn> OrderZT_HonyakuYouKouinRnByPkAsc(List<ZT_HonyakuYouKouinRn> pEntity) {
        List<SortCondition<ZT_HonyakuYouKouinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HonyakuYouKouinRn()).zrnkinyuukikancd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HonyakuYouKouinRn()).zrnkouincd, SortOrder.ASC));
        List<ZT_HonyakuYouKouinRn> copyList = new ArrayList<ZT_HonyakuYouKouinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HonyakuYouKouinRn(orders));
        return copyList;
    }

    
    public List<ZT_HonyakuYouKouinRn> OrderZT_HonyakuYouKouinRnByPkDesc(List<ZT_HonyakuYouKouinRn> pEntity) {
        List<SortCondition<ZT_HonyakuYouKouinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HonyakuYouKouinRn()).zrnkinyuukikancd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HonyakuYouKouinRn()).zrnkouincd, SortOrder.DESC));
        List<ZT_HonyakuYouKouinRn> copyList = new ArrayList<ZT_HonyakuYouKouinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HonyakuYouKouinRn(orders));
        return copyList;
    }
}
