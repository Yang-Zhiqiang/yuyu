package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_OnlineGknyknmeisaiRn;
import yuyu.def.db.meta.QZT_OnlineGknyknmeisaiRn;
import yuyu.def.zdb.comparator.OrderZT_OnlineGknyknmeisaiRn;

public class SortZT_OnlineGknyknmeisaiRn {

    
    public List<ZT_OnlineGknyknmeisaiRn> OrderZT_OnlineGknyknmeisaiRnByPkAsc(List<ZT_OnlineGknyknmeisaiRn> pEntity) {
        List<SortCondition<ZT_OnlineGknyknmeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnsakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnrenrakuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnrenrakukaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnbankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnshitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnyokinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnkouzano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnzndktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnsyorino1, SortOrder.ASC));
        List<ZT_OnlineGknyknmeisaiRn> copyList = new ArrayList<ZT_OnlineGknyknmeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_OnlineGknyknmeisaiRn(orders));
        return copyList;
    }

    
    public List<ZT_OnlineGknyknmeisaiRn> OrderZT_OnlineGknyknmeisaiRnByPkDesc(List<ZT_OnlineGknyknmeisaiRn> pEntity) {
        List<SortCondition<ZT_OnlineGknyknmeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnsakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnrenrakuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnrenrakukaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnbankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnshitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnyokinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnkouzano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnzndktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiRn()).zrnsyorino1, SortOrder.DESC));
        List<ZT_OnlineGknyknmeisaiRn> copyList = new ArrayList<ZT_OnlineGknyknmeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_OnlineGknyknmeisaiRn(orders));
        return copyList;
    }
}
