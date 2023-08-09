package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RatedRn;
import yuyu.def.db.meta.QZT_RatedRn;
import yuyu.def.zdb.comparator.OrderZT_RatedRn;

public class SortZT_RatedRn {

    
    public List<ZT_RatedRn> OrderZT_RatedRnByPkAsc(List<ZT_RatedRn> pEntity) {
        List<SortCondition<ZT_RatedRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnhknsyuruikigousedaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnpmenkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnhrkkaisuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnsaimnkkykhyj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnphrkkikn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrndnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnnaiteikakuteikbn, SortOrder.ASC));
        List<ZT_RatedRn> copyList = new ArrayList<ZT_RatedRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RatedRn(orders));
        return copyList;
    }

    
    public List<ZT_RatedRn> OrderZT_RatedRnByPkDesc(List<ZT_RatedRn> pEntity) {
        List<SortCondition<ZT_RatedRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnhknsyuruikigousedaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnpmenkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnhrkkaisuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnsaimnkkykhyj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnphrkkikn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrndnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RatedRn()).zrnnaiteikakuteikbn, SortOrder.DESC));
        List<ZT_RatedRn> copyList = new ArrayList<ZT_RatedRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RatedRn(orders));
        return copyList;
    }
}
