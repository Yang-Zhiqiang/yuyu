package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuDataTy;
import yuyu.def.zdb.comparator.OrderZT_FstpUriageSeikyuuDataTy;

public class SortZT_FstpUriageSeikyuuDataTy {

    
    public List<ZT_FstpUriageSeikyuuDataTy> OrderZT_FstpUriageSeikyuuDataTyByPkAsc(List<ZT_FstpUriageSeikyuuDataTy> pEntity) {
        List<SortCondition<ZT_FstpUriageSeikyuuDataTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataTy()).ztyuriageymd6keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataTy()).ztycreditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataTy()).ztyrecordno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataTy()).ztyseikyuukngk11keta, SortOrder.ASC));
        List<ZT_FstpUriageSeikyuuDataTy> copyList = new ArrayList<ZT_FstpUriageSeikyuuDataTy>(pEntity);
        Collections.sort(copyList, new OrderZT_FstpUriageSeikyuuDataTy(orders));
        return copyList;
    }

    
    public List<ZT_FstpUriageSeikyuuDataTy> OrderZT_FstpUriageSeikyuuDataTyByPkDesc(List<ZT_FstpUriageSeikyuuDataTy> pEntity) {
        List<SortCondition<ZT_FstpUriageSeikyuuDataTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataTy()).ztyuriageymd6keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataTy()).ztycreditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataTy()).ztyrecordno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FstpUriageSeikyuuDataTy()).ztyseikyuukngk11keta, SortOrder.DESC));
        List<ZT_FstpUriageSeikyuuDataTy> copyList = new ArrayList<ZT_FstpUriageSeikyuuDataTy>(pEntity);
        Collections.sort(copyList, new OrderZT_FstpUriageSeikyuuDataTy(orders));
        return copyList;
    }
}
