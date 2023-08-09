package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_UriageSousinRn;
import yuyu.def.db.meta.QZT_UriageSousinRn;
import yuyu.def.zdb.comparator.OrderZT_UriageSousinRn;

public class SortZT_UriageSousinRn {

    
    public List<ZT_UriageSousinRn> OrderZT_UriageSousinRnByPkAsc(List<ZT_UriageSousinRn> pEntity) {
        List<SortCondition<ZT_UriageSousinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_UriageSousinRn()).zrncreditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageSousinRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageSousinRn()).zrnuriageseikyuuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageSousinRn()).zrnrsgaku, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageSousinRn()).zrnrecordno, SortOrder.ASC));
        List<ZT_UriageSousinRn> copyList = new ArrayList<ZT_UriageSousinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_UriageSousinRn(orders));
        return copyList;
    }

    
    public List<ZT_UriageSousinRn> OrderZT_UriageSousinRnByPkDesc(List<ZT_UriageSousinRn> pEntity) {
        List<SortCondition<ZT_UriageSousinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_UriageSousinRn()).zrncreditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageSousinRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageSousinRn()).zrnuriageseikyuuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageSousinRn()).zrnrsgaku, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageSousinRn()).zrnrecordno, SortOrder.DESC));
        List<ZT_UriageSousinRn> copyList = new ArrayList<ZT_UriageSousinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_UriageSousinRn(orders));
        return copyList;
    }
}
