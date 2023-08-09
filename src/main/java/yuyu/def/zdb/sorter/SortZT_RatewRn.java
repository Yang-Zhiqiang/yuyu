package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RatewRn;
import yuyu.def.db.meta.QZT_RatewRn;
import yuyu.def.zdb.comparator.OrderZT_RatewRn;

public class SortZT_RatewRn {

    
    public List<ZT_RatewRn> OrderZT_RatewRnByPkAsc(List<ZT_RatewRn> pEntity) {
        List<SortCondition<ZT_RatewRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnhknsyuruikigousedaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnpmenkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnhrkkaisuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnsaimnkkykhyj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnphrkkikn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnannaifuyouriyuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrntuukasyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrndai1hknkkn, SortOrder.ASC));
        List<ZT_RatewRn> copyList = new ArrayList<ZT_RatewRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RatewRn(orders));
        return copyList;
    }

    
    public List<ZT_RatewRn> OrderZT_RatewRnByPkDesc(List<ZT_RatewRn> pEntity) {
        List<SortCondition<ZT_RatewRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnhknsyuruikigousedaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnpmenkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnhrkkaisuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnsaimnkkykhyj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnphrkkikn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrnannaifuyouriyuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrntuukasyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatewRn()).zrndai1hknkkn, SortOrder.DESC));
        List<ZT_RatewRn> copyList = new ArrayList<ZT_RatewRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RatewRn(orders));
        return copyList;
    }
}
