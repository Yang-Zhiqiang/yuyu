package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.db.meta.QZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.zdb.comparator.OrderZT_RisaHitSyouhnyouRated2Rn;

public class SortZT_RisaHitSyouhnyouRated2Rn {

    
    public List<ZT_RisaHitSyouhnyouRated2Rn> OrderZT_RisaHitSyouhnyouRated2RnByPkAsc(List<ZT_RisaHitSyouhnyouRated2Rn> pEntity) {
        List<SortCondition<ZT_RisaHitSyouhnyouRated2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnhknsyuruikigousedaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnpmenkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnhrkkaisuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnsaimnkkykhyj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnphrkkikn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnannaifuyouriyuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrntuukasyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrndai1hknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrndnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnnaiteikakuteikbn, SortOrder.ASC));
        List<ZT_RisaHitSyouhnyouRated2Rn> copyList = new ArrayList<ZT_RisaHitSyouhnyouRated2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaHitSyouhnyouRated2Rn(orders));
        return copyList;
    }

    
    public List<ZT_RisaHitSyouhnyouRated2Rn> OrderZT_RisaHitSyouhnyouRated2RnByPkDesc(List<ZT_RisaHitSyouhnyouRated2Rn> pEntity) {
        List<SortCondition<ZT_RisaHitSyouhnyouRated2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnhknsyuruikigousedaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnpmenkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnhrkkaisuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnsaimnkkykhyj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnphrkkikn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnannaifuyouriyuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrntuukasyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrndai1hknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrndnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_RisaHitSyouhnyouRated2Rn()).zrnnaiteikakuteikbn, SortOrder.DESC));
        List<ZT_RisaHitSyouhnyouRated2Rn> copyList = new ArrayList<ZT_RisaHitSyouhnyouRated2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaHitSyouhnyouRated2Rn(orders));
        return copyList;
    }
}
