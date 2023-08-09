package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Ratev2Rn;
import yuyu.def.db.meta.QZT_Ratev2Rn;
import yuyu.def.zdb.comparator.OrderZT_Ratev2Rn;

public class SortZT_Ratev2Rn {

    
    public List<ZT_Ratev2Rn> OrderZT_Ratev2RnByPkAsc(List<ZT_Ratev2Rn> pEntity) {
        List<SortCondition<ZT_Ratev2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnhknsyuruikigousedaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnpmenkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnhrkkaisuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnsaimnkkykhyj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnphrkkikn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnannaifuyouriyuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrntuukasyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrndai1hknkkn, SortOrder.ASC));
        List<ZT_Ratev2Rn> copyList = new ArrayList<ZT_Ratev2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Ratev2Rn(orders));
        return copyList;
    }

    
    public List<ZT_Ratev2Rn> OrderZT_Ratev2RnByPkDesc(List<ZT_Ratev2Rn> pEntity) {
        List<SortCondition<ZT_Ratev2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnhknsyuruikigousedaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnpmenkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnhrkkaisuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnsaimnkkykhyj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnphrkkikn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrnannaifuyouriyuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrntuukasyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_Ratev2Rn()).zrndai1hknkkn, SortOrder.DESC));
        List<ZT_Ratev2Rn> copyList = new ArrayList<ZT_Ratev2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Ratev2Rn(orders));
        return copyList;
    }
}
