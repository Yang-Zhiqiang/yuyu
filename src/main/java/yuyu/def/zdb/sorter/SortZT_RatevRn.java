package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RatevRn;
import yuyu.def.db.meta.QZT_RatevRn;
import yuyu.def.zdb.comparator.OrderZT_RatevRn;

public class SortZT_RatevRn {

    
    public List<ZT_RatevRn> OrderZT_RatevRnByPkAsc(List<ZT_RatevRn> pEntity) {
        List<SortCondition<ZT_RatevRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnhknsyuruikigousedaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnpmenkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnhrkkaisuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnsaimnkkykhyj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnphrkkikn, SortOrder.ASC));
        List<ZT_RatevRn> copyList = new ArrayList<ZT_RatevRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RatevRn(orders));
        return copyList;
    }

    
    public List<ZT_RatevRn> OrderZT_RatevRnByPkDesc(List<ZT_RatevRn> pEntity) {
        List<SortCondition<ZT_RatevRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnhknsyuruikigousedaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnpmenkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnhrkkaisuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnsaimnkkykhyj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatevRn()).zrnphrkkikn, SortOrder.DESC));
        List<ZT_RatevRn> copyList = new ArrayList<ZT_RatevRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RatevRn(orders));
        return copyList;
    }
}
