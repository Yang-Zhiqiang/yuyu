package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RisaHitSyouhnyouRatedRn;
import yuyu.def.db.meta.QZT_RisaHitSyouhnyouRatedRn;
import yuyu.def.zdb.comparator.OrderZT_RisaHitSyouhnyouRatedRn;

public class SortZT_RisaHitSyouhnyouRatedRn {

    
    public List<ZT_RisaHitSyouhnyouRatedRn> OrderZT_RisaHitSyouhnyouRatedRnByPkAsc(List<ZT_RisaHitSyouhnyouRatedRn> pEntity) {
        List<SortCondition<ZT_RisaHitSyouhnyouRatedRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnhknsyuruikigousedaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnpmenkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnhrkkaisuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnsaimnkkykhyj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnphrkkikn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrndnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnnaiteikakuteikbn, SortOrder.ASC));
        List<ZT_RisaHitSyouhnyouRatedRn> copyList = new ArrayList<ZT_RisaHitSyouhnyouRatedRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaHitSyouhnyouRatedRn(orders));
        return copyList;
    }

    
    public List<ZT_RisaHitSyouhnyouRatedRn> OrderZT_RisaHitSyouhnyouRatedRnByPkDesc(List<ZT_RisaHitSyouhnyouRatedRn> pEntity) {
        List<SortCondition<ZT_RisaHitSyouhnyouRatedRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnhknsyuruikigousedaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnpmenkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnhrkkaisuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnsaimnkkykhyj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnphrkkikn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrndnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRatedRn()).zrnnaiteikakuteikbn, SortOrder.DESC));
        List<ZT_RisaHitSyouhnyouRatedRn> copyList = new ArrayList<ZT_RisaHitSyouhnyouRatedRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaHitSyouhnyouRatedRn(orders));
        return copyList;
    }
}
