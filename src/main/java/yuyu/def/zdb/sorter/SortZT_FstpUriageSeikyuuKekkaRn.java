package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaRn;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuKekkaRn;
import yuyu.def.zdb.comparator.OrderZT_FstpUriageSeikyuuKekkaRn;

public class SortZT_FstpUriageSeikyuuKekkaRn {

    
    public List<ZT_FstpUriageSeikyuuKekkaRn> OrderZT_FstpUriageSeikyuuKekkaRnByPkAsc(List<ZT_FstpUriageSeikyuuKekkaRn> pEntity) {
        List<SortCondition<ZT_FstpUriageSeikyuuKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaRn()).zrnuriageymd6keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaRn()).zrncreditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaRn()).zrnrecordno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaRn()).zrnseikyuukngk, SortOrder.ASC));
        List<ZT_FstpUriageSeikyuuKekkaRn> copyList = new ArrayList<ZT_FstpUriageSeikyuuKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_FstpUriageSeikyuuKekkaRn(orders));
        return copyList;
    }

    
    public List<ZT_FstpUriageSeikyuuKekkaRn> OrderZT_FstpUriageSeikyuuKekkaRnByPkDesc(List<ZT_FstpUriageSeikyuuKekkaRn> pEntity) {
        List<SortCondition<ZT_FstpUriageSeikyuuKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaRn()).zrnuriageymd6keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaRn()).zrncreditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaRn()).zrnrecordno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuKekkaRn()).zrnseikyuukngk, SortOrder.DESC));
        List<ZT_FstpUriageSeikyuuKekkaRn> copyList = new ArrayList<ZT_FstpUriageSeikyuuKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_FstpUriageSeikyuuKekkaRn(orders));
        return copyList;
    }
}
