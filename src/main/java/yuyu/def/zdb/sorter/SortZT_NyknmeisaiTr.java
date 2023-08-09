package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NyknmeisaiTr;
import yuyu.def.db.meta.QZT_NyknmeisaiTr;
import yuyu.def.zdb.comparator.OrderZT_NyknmeisaiTr;

public class SortZT_NyknmeisaiTr {

    
    public List<ZT_NyknmeisaiTr> OrderZT_NyknmeisaiTrByPkAsc(List<ZT_NyknmeisaiTr> pEntity) {
        List<SortCondition<ZT_NyknmeisaiTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrsakuseiymd6keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrbankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrshitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztryokinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrkouzano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrsyoukaino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrrenno8, SortOrder.ASC));
        List<ZT_NyknmeisaiTr> copyList = new ArrayList<ZT_NyknmeisaiTr>(pEntity);
        Collections.sort(copyList, new OrderZT_NyknmeisaiTr(orders));
        return copyList;
    }

    
    public List<ZT_NyknmeisaiTr> OrderZT_NyknmeisaiTrByPkDesc(List<ZT_NyknmeisaiTr> pEntity) {
        List<SortCondition<ZT_NyknmeisaiTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrsakuseiymd6keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrbankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrshitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztryokinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrkouzano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrsyoukaino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiTr()).ztrrenno8, SortOrder.DESC));
        List<ZT_NyknmeisaiTr> copyList = new ArrayList<ZT_NyknmeisaiTr>(pEntity);
        Collections.sort(copyList, new OrderZT_NyknmeisaiTr(orders));
        return copyList;
    }
}
