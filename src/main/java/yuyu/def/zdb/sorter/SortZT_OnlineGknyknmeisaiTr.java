package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_OnlineGknyknmeisaiTr;
import yuyu.def.db.meta.QZT_OnlineGknyknmeisaiTr;
import yuyu.def.zdb.comparator.OrderZT_OnlineGknyknmeisaiTr;

public class SortZT_OnlineGknyknmeisaiTr {

    
    public List<ZT_OnlineGknyknmeisaiTr> OrderZT_OnlineGknyknmeisaiTrByPkAsc(List<ZT_OnlineGknyknmeisaiTr> pEntity) {
        List<SortCondition<ZT_OnlineGknyknmeisaiTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrsakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrrenrakuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrrenrakukaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrbankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrshitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztryokinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrkouzano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrzndktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrsyorino1, SortOrder.ASC));
        List<ZT_OnlineGknyknmeisaiTr> copyList = new ArrayList<ZT_OnlineGknyknmeisaiTr>(pEntity);
        Collections.sort(copyList, new OrderZT_OnlineGknyknmeisaiTr(orders));
        return copyList;
    }

    
    public List<ZT_OnlineGknyknmeisaiTr> OrderZT_OnlineGknyknmeisaiTrByPkDesc(List<ZT_OnlineGknyknmeisaiTr> pEntity) {
        List<SortCondition<ZT_OnlineGknyknmeisaiTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrsakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrrenrakuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrrenrakukaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrbankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrshitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztryokinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrkouzano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrzndktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineGknyknmeisaiTr()).ztrsyorino1, SortOrder.DESC));
        List<ZT_OnlineGknyknmeisaiTr> copyList = new ArrayList<ZT_OnlineGknyknmeisaiTr>(pEntity);
        Collections.sort(copyList, new OrderZT_OnlineGknyknmeisaiTr(orders));
        return copyList;
    }
}
