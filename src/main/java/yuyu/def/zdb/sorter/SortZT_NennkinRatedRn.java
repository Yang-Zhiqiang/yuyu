package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NennkinRatedRn;
import yuyu.def.db.meta.QZT_NennkinRatedRn;
import yuyu.def.zdb.comparator.OrderZT_NennkinRatedRn;

public class SortZT_NennkinRatedRn {

    
    public List<ZT_NennkinRatedRn> OrderZT_NennkinRatedRnByPkAsc(List<ZT_NennkinRatedRn> pEntity) {
        List<SortCondition<ZT_NennkinRatedRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnenkinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnenkinsyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnenkinkigousedaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnknshry, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnkkaisigoyoteiriritukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnenkinjimutesuuryoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrndnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnaiteikakuteikbn, SortOrder.ASC));
        List<ZT_NennkinRatedRn> copyList = new ArrayList<ZT_NennkinRatedRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NennkinRatedRn(orders));
        return copyList;
    }

    
    public List<ZT_NennkinRatedRn> OrderZT_NennkinRatedRnByPkDesc(List<ZT_NennkinRatedRn> pEntity) {
        List<SortCondition<ZT_NennkinRatedRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnenkinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnenkinsyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnenkinkigousedaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnknshry, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnkkaisigoyoteiriritukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnenkinjimutesuuryoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrndnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NennkinRatedRn()).zrnnaiteikakuteikbn, SortOrder.DESC));
        List<ZT_NennkinRatedRn> copyList = new ArrayList<ZT_NennkinRatedRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NennkinRatedRn(orders));
        return copyList;
    }
}
