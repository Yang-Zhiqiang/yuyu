package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataRn;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuDataRn;
import yuyu.def.zdb.comparator.OrderZT_FstpUriageSeikyuuDataRn;

public class SortZT_FstpUriageSeikyuuDataRn {

    
    public List<ZT_FstpUriageSeikyuuDataRn> OrderZT_FstpUriageSeikyuuDataRnByPkAsc(List<ZT_FstpUriageSeikyuuDataRn> pEntity) {
        List<SortCondition<ZT_FstpUriageSeikyuuDataRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataRn()).zrnuriageymd6keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataRn()).zrncreditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataRn()).zrnrecordno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataRn()).zrnseikyuukngk11keta, SortOrder.ASC));
        List<ZT_FstpUriageSeikyuuDataRn> copyList = new ArrayList<ZT_FstpUriageSeikyuuDataRn>(pEntity);
        Collections.sort(copyList, new OrderZT_FstpUriageSeikyuuDataRn(orders));
        return copyList;
    }

    
    public List<ZT_FstpUriageSeikyuuDataRn> OrderZT_FstpUriageSeikyuuDataRnByPkDesc(List<ZT_FstpUriageSeikyuuDataRn> pEntity) {
        List<SortCondition<ZT_FstpUriageSeikyuuDataRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataRn()).zrnuriageymd6keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataRn()).zrncreditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataRn()).zrnrecordno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataRn()).zrnseikyuukngk11keta, SortOrder.DESC));
        List<ZT_FstpUriageSeikyuuDataRn> copyList = new ArrayList<ZT_FstpUriageSeikyuuDataRn>(pEntity);
        Collections.sort(copyList, new OrderZT_FstpUriageSeikyuuDataRn(orders));
        return copyList;
    }
}
