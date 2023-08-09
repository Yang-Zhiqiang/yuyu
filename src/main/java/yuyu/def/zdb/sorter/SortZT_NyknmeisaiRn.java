package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NyknmeisaiRn;
import yuyu.def.db.meta.QZT_NyknmeisaiRn;
import yuyu.def.zdb.comparator.OrderZT_NyknmeisaiRn;

public class SortZT_NyknmeisaiRn {

    
    public List<ZT_NyknmeisaiRn> OrderZT_NyknmeisaiRnByPkAsc(List<ZT_NyknmeisaiRn> pEntity) {
        List<SortCondition<ZT_NyknmeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnsakuseiymd6keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnbankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnshitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnyokinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnkouzano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnsyoukaino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnrenno8, SortOrder.ASC));
        List<ZT_NyknmeisaiRn> copyList = new ArrayList<ZT_NyknmeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NyknmeisaiRn(orders));
        return copyList;
    }

    
    public List<ZT_NyknmeisaiRn> OrderZT_NyknmeisaiRnByPkDesc(List<ZT_NyknmeisaiRn> pEntity) {
        List<SortCondition<ZT_NyknmeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnsakuseiymd6keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnbankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnshitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnyokinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnkouzano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnsyoukaino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NyknmeisaiRn()).zrnrenno8, SortOrder.DESC));
        List<ZT_NyknmeisaiRn> copyList = new ArrayList<ZT_NyknmeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NyknmeisaiRn(orders));
        return copyList;
    }
}
