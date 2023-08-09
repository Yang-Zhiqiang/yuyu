package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RatepRn;
import yuyu.def.db.meta.QZT_RatepRn;
import yuyu.def.zdb.comparator.OrderZT_RatepRn;

public class SortZT_RatepRn {

    
    public List<ZT_RatepRn> OrderZT_RatepRnByPkAsc(List<ZT_RatepRn> pEntity) {
        List<SortCondition<ZT_RatepRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnhknsyuruikigousedaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnpmenkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnhrkkaisuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnsaimnkkykhyj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnphrkkikn, SortOrder.ASC));
        List<ZT_RatepRn> copyList = new ArrayList<ZT_RatepRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RatepRn(orders));
        return copyList;
    }

    
    public List<ZT_RatepRn> OrderZT_RatepRnByPkDesc(List<ZT_RatepRn> pEntity) {
        List<SortCondition<ZT_RatepRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnhknsyuruikigousedaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnpmenkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnhrkkaisuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnsaimnkkykhyj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatepRn()).zrnphrkkikn, SortOrder.DESC));
        List<ZT_RatepRn> copyList = new ArrayList<ZT_RatepRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RatepRn(orders));
        return copyList;
    }
}
