package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KoujyoSyoumeiTy;
import yuyu.def.db.meta.QZT_KoujyoSyoumeiTy;
import yuyu.def.zdb.comparator.OrderZT_KoujyoSyoumeiTy;

public class SortZT_KoujyoSyoumeiTy {

    
    public List<ZT_KoujyoSyoumeiTy> OrderZT_KoujyoSyoumeiTyByPkAsc(List<ZT_KoujyoSyoumeiTy> pEntity) {
        List<SortCondition<ZT_KoujyoSyoumeiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiTy()).ztysakunm15keta, SortOrder.ASC));
        List<ZT_KoujyoSyoumeiTy> copyList = new ArrayList<ZT_KoujyoSyoumeiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KoujyoSyoumeiTy(orders));
        return copyList;
    }

    
    public List<ZT_KoujyoSyoumeiTy> OrderZT_KoujyoSyoumeiTyByPkDesc(List<ZT_KoujyoSyoumeiTy> pEntity) {
        List<SortCondition<ZT_KoujyoSyoumeiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiTy()).ztysakunm15keta, SortOrder.DESC));
        List<ZT_KoujyoSyoumeiTy> copyList = new ArrayList<ZT_KoujyoSyoumeiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KoujyoSyoumeiTy(orders));
        return copyList;
    }
}
