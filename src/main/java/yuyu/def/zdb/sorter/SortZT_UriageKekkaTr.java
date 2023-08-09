package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_UriageKekkaTr;
import yuyu.def.db.meta.QZT_UriageKekkaTr;
import yuyu.def.zdb.comparator.OrderZT_UriageKekkaTr;

public class SortZT_UriageKekkaTr {

    
    public List<ZT_UriageKekkaTr> OrderZT_UriageKekkaTrByPkAsc(List<ZT_UriageKekkaTr> pEntity) {
        List<SortCondition<ZT_UriageKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_UriageKekkaTr()).ztrsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaTr()).ztrcreditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaTr()).ztruriageymd6keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaTr()).ztrrecordno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaTr()).ztrseikyuukngk, SortOrder.ASC));
        List<ZT_UriageKekkaTr> copyList = new ArrayList<ZT_UriageKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_UriageKekkaTr(orders));
        return copyList;
    }

    
    public List<ZT_UriageKekkaTr> OrderZT_UriageKekkaTrByPkDesc(List<ZT_UriageKekkaTr> pEntity) {
        List<SortCondition<ZT_UriageKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_UriageKekkaTr()).ztrsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaTr()).ztrcreditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaTr()).ztruriageymd6keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaTr()).ztrrecordno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaTr()).ztrseikyuukngk, SortOrder.DESC));
        List<ZT_UriageKekkaTr> copyList = new ArrayList<ZT_UriageKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_UriageKekkaTr(orders));
        return copyList;
    }
}
