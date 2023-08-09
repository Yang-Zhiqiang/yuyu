package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_GknyknmeisaiRn;
import yuyu.def.db.meta.QZT_GknyknmeisaiRn;
import yuyu.def.zdb.comparator.OrderZT_GknyknmeisaiRn;

public class SortZT_GknyknmeisaiRn {

    
    public List<ZT_GknyknmeisaiRn> OrderZT_GknyknmeisaiRnByPkAsc(List<ZT_GknyknmeisaiRn> pEntity) {
        List<SortCondition<ZT_GknyknmeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnsakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnrenrakuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnrenrakukaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnbankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnshitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnyokinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnkouzano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnzndktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnsyorino1, SortOrder.ASC));
        List<ZT_GknyknmeisaiRn> copyList = new ArrayList<ZT_GknyknmeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_GknyknmeisaiRn(orders));
        return copyList;
    }

    
    public List<ZT_GknyknmeisaiRn> OrderZT_GknyknmeisaiRnByPkDesc(List<ZT_GknyknmeisaiRn> pEntity) {
        List<SortCondition<ZT_GknyknmeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnsakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnrenrakuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnrenrakukaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnbankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnshitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnyokinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnkouzano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnzndktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiRn()).zrnsyorino1, SortOrder.DESC));
        List<ZT_GknyknmeisaiRn> copyList = new ArrayList<ZT_GknyknmeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_GknyknmeisaiRn(orders));
        return copyList;
    }
}
