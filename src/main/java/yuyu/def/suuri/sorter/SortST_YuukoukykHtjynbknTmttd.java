package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknTmttd;
import yuyu.def.suuri.comparator.OrderST_YuukoukykHtjynbknTmttd;

public class SortST_YuukoukykHtjynbknTmttd {

    
    public List<ST_YuukoukykHtjynbknTmttd> OrderST_YuukoukykHtjynbknTmttdByPkAsc(List<ST_YuukoukykHtjynbknTmttd> pEntity) {
        List<SortCondition<ST_YuukoukykHtjynbknTmttd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknTmttd()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknTmttd()).kakutyoujobcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknTmttd()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknTmttd()).srkijyunym, SortOrder.ASC));
        List<ST_YuukoukykHtjynbknTmttd> copyList = new ArrayList<ST_YuukoukykHtjynbknTmttd>(pEntity);
        Collections.sort(copyList, new OrderST_YuukoukykHtjynbknTmttd(orders));
        return copyList;
    }

    
    public List<ST_YuukoukykHtjynbknTmttd> OrderST_YuukoukykHtjynbknTmttdByPkDesc(List<ST_YuukoukykHtjynbknTmttd> pEntity) {
        List<SortCondition<ST_YuukoukykHtjynbknTmttd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknTmttd()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknTmttd()).kakutyoujobcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknTmttd()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_YuukoukykHtjynbknTmttd()).srkijyunym, SortOrder.DESC));
        List<ST_YuukoukykHtjynbknTmttd> copyList = new ArrayList<ST_YuukoukykHtjynbknTmttd>(pEntity);
        Collections.sort(copyList, new OrderST_YuukoukykHtjynbknTmttd(orders));
        return copyList;
    }
}
