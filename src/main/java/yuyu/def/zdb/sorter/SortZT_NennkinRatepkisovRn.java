package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NennkinRatepkisovRn;
import yuyu.def.db.meta.QZT_NennkinRatepkisovRn;
import yuyu.def.zdb.comparator.OrderZT_NennkinRatepkisovRn;

public class SortZT_NennkinRatepkisovRn {

    
    public List<ZT_NennkinRatepkisovRn> OrderZT_NennkinRatepkisovRnByPkAsc(List<ZT_NennkinRatepkisovRn> pEntity) {
        List<SortCondition<ZT_NennkinRatepkisovRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnenkinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnenkinsyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnenkinkigousedaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnknshry, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnkkaisigoyoteiriritukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnenkinjimutesuuryoukbn, SortOrder.ASC));
        List<ZT_NennkinRatepkisovRn> copyList = new ArrayList<ZT_NennkinRatepkisovRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NennkinRatepkisovRn(orders));
        return copyList;
    }

    
    public List<ZT_NennkinRatepkisovRn> OrderZT_NennkinRatepkisovRnByPkDesc(List<ZT_NennkinRatepkisovRn> pEntity) {
        List<SortCondition<ZT_NennkinRatepkisovRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnenkinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnenkinsyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnenkinkigousedaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnknshry, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnkkaisigoyoteiriritukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatepkisovRn()).zrnnenkinjimutesuuryoukbn, SortOrder.DESC));
        List<ZT_NennkinRatepkisovRn> copyList = new ArrayList<ZT_NennkinRatepkisovRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NennkinRatepkisovRn(orders));
        return copyList;
    }
}
