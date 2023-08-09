package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_GknyknmeisaiTr;
import yuyu.def.db.meta.QZT_GknyknmeisaiTr;
import yuyu.def.zdb.comparator.OrderZT_GknyknmeisaiTr;

public class SortZT_GknyknmeisaiTr {

    
    public List<ZT_GknyknmeisaiTr> OrderZT_GknyknmeisaiTrByPkAsc(List<ZT_GknyknmeisaiTr> pEntity) {
        List<SortCondition<ZT_GknyknmeisaiTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrsakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrrenrakuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrrenrakukaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrbankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrshitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztryokinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrkouzano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrzndktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrsyorino1, SortOrder.ASC));
        List<ZT_GknyknmeisaiTr> copyList = new ArrayList<ZT_GknyknmeisaiTr>(pEntity);
        Collections.sort(copyList, new OrderZT_GknyknmeisaiTr(orders));
        return copyList;
    }

    
    public List<ZT_GknyknmeisaiTr> OrderZT_GknyknmeisaiTrByPkDesc(List<ZT_GknyknmeisaiTr> pEntity) {
        List<SortCondition<ZT_GknyknmeisaiTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrsakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrrenrakuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrrenrakukaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrbankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrshitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztryokinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrkouzano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrzndktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GknyknmeisaiTr()).ztrsyorino1, SortOrder.DESC));
        List<ZT_GknyknmeisaiTr> copyList = new ArrayList<ZT_GknyknmeisaiTr>(pEntity);
        Collections.sort(copyList, new OrderZT_GknyknmeisaiTr(orders));
        return copyList;
    }
}
