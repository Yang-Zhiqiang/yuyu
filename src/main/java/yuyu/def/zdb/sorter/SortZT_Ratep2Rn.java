package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Ratep2Rn;
import yuyu.def.db.meta.QZT_Ratep2Rn;
import yuyu.def.zdb.comparator.OrderZT_Ratep2Rn;

public class SortZT_Ratep2Rn {

    
    public List<ZT_Ratep2Rn> OrderZT_Ratep2RnByPkAsc(List<ZT_Ratep2Rn> pEntity) {
        List<SortCondition<ZT_Ratep2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnhknsyuruikigousedaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnpmenkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnhrkkaisuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnsaimnkkykhyj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnphrkkikn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnannaifuyouriyuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrntuukasyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrndai1hknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnryouritukbn, SortOrder.ASC));
        List<ZT_Ratep2Rn> copyList = new ArrayList<ZT_Ratep2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Ratep2Rn(orders));
        return copyList;
    }

    
    public List<ZT_Ratep2Rn> OrderZT_Ratep2RnByPkDesc(List<ZT_Ratep2Rn> pEntity) {
        List<SortCondition<ZT_Ratep2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnhknsyuruikigousedaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnpmenkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnhrkkaisuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnsaimnkkykhyj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnphrkkikn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnannaifuyouriyuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrntuukasyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrndai1hknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratep2Rn()).zrnryouritukbn, SortOrder.DESC));
        List<ZT_Ratep2Rn> copyList = new ArrayList<ZT_Ratep2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Ratep2Rn(orders));
        return copyList;
    }
}
