package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.zdb.comparator.OrderZT_FstpUriageSeikyuuKekkaTr;

public class SortZT_FstpUriageSeikyuuKekkaTr {

    
    public List<ZT_FstpUriageSeikyuuKekkaTr> OrderZT_FstpUriageSeikyuuKekkaTrByPkAsc(List<ZT_FstpUriageSeikyuuKekkaTr> pEntity) {
        List<SortCondition<ZT_FstpUriageSeikyuuKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaTr()).ztruriageymd6keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaTr()).ztrcreditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaTr()).ztrsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaTr()).ztrrecordno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaTr()).ztrseikyuukngk, SortOrder.ASC));
        List<ZT_FstpUriageSeikyuuKekkaTr> copyList = new ArrayList<ZT_FstpUriageSeikyuuKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_FstpUriageSeikyuuKekkaTr(orders));
        return copyList;
    }

    
    public List<ZT_FstpUriageSeikyuuKekkaTr> OrderZT_FstpUriageSeikyuuKekkaTrByPkDesc(List<ZT_FstpUriageSeikyuuKekkaTr> pEntity) {
        List<SortCondition<ZT_FstpUriageSeikyuuKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaTr()).ztruriageymd6keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaTr()).ztrcreditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaTr()).ztrsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaTr()).ztrrecordno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaTr()).ztrseikyuukngk, SortOrder.DESC));
        List<ZT_FstpUriageSeikyuuKekkaTr> copyList = new ArrayList<ZT_FstpUriageSeikyuuKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_FstpUriageSeikyuuKekkaTr(orders));
        return copyList;
    }
}
