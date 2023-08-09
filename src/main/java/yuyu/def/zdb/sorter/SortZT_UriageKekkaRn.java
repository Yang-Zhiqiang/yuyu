package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_UriageKekkaRn;
import yuyu.def.db.meta.QZT_UriageKekkaRn;
import yuyu.def.zdb.comparator.OrderZT_UriageKekkaRn;

public class SortZT_UriageKekkaRn {

    
    public List<ZT_UriageKekkaRn> OrderZT_UriageKekkaRnByPkAsc(List<ZT_UriageKekkaRn> pEntity) {
        List<SortCondition<ZT_UriageKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_UriageKekkaRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaRn()).zrncreditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaRn()).zrnuriageymd6keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaRn()).zrnrecordno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaRn()).zrnseikyuukngk, SortOrder.ASC));
        List<ZT_UriageKekkaRn> copyList = new ArrayList<ZT_UriageKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_UriageKekkaRn(orders));
        return copyList;
    }

    
    public List<ZT_UriageKekkaRn> OrderZT_UriageKekkaRnByPkDesc(List<ZT_UriageKekkaRn> pEntity) {
        List<SortCondition<ZT_UriageKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_UriageKekkaRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaRn()).zrncreditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaRn()).zrnuriageymd6keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaRn()).zrnrecordno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageKekkaRn()).zrnseikyuukngk, SortOrder.DESC));
        List<ZT_UriageKekkaRn> copyList = new ArrayList<ZT_UriageKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_UriageKekkaRn(orders));
        return copyList;
    }
}
