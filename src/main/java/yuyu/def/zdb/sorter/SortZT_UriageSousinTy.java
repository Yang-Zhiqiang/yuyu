package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_UriageSousinTy;
import yuyu.def.db.meta.QZT_UriageSousinTy;
import yuyu.def.zdb.comparator.OrderZT_UriageSousinTy;

public class SortZT_UriageSousinTy {

    
    public List<ZT_UriageSousinTy> OrderZT_UriageSousinTyByPkAsc(List<ZT_UriageSousinTy> pEntity) {
        List<SortCondition<ZT_UriageSousinTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_UriageSousinTy()).ztycreditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageSousinTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageSousinTy()).ztyuriageseikyuuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageSousinTy()).ztyrsgaku, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_UriageSousinTy()).ztyrecordno, SortOrder.ASC));
        List<ZT_UriageSousinTy> copyList = new ArrayList<ZT_UriageSousinTy>(pEntity);
        Collections.sort(copyList, new OrderZT_UriageSousinTy(orders));
        return copyList;
    }

    
    public List<ZT_UriageSousinTy> OrderZT_UriageSousinTyByPkDesc(List<ZT_UriageSousinTy> pEntity) {
        List<SortCondition<ZT_UriageSousinTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_UriageSousinTy()).ztycreditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageSousinTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageSousinTy()).ztyuriageseikyuuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageSousinTy()).ztyrsgaku, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_UriageSousinTy()).ztyrecordno, SortOrder.DESC));
        List<ZT_UriageSousinTy> copyList = new ArrayList<ZT_UriageSousinTy>(pEntity);
        Collections.sort(copyList, new OrderZT_UriageSousinTy(orders));
        return copyList;
    }
}
