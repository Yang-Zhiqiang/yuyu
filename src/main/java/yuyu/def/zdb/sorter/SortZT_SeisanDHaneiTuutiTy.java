package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.meta.QZT_SeisanDHaneiTuutiTy;
import yuyu.def.zdb.comparator.OrderZT_SeisanDHaneiTuutiTy;

public class SortZT_SeisanDHaneiTuutiTy {

    
    public List<ZT_SeisanDHaneiTuutiTy> OrderZT_SeisanDHaneiTuutiTyByPkAsc(List<ZT_SeisanDHaneiTuutiTy> pEntity) {
        List<SortCondition<ZT_SeisanDHaneiTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeisanDHaneiTuutiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeisanDHaneiTuutiTy()).ztykeysyono, SortOrder.ASC));
        List<ZT_SeisanDHaneiTuutiTy> copyList = new ArrayList<ZT_SeisanDHaneiTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SeisanDHaneiTuutiTy(orders));
        return copyList;
    }

    
    public List<ZT_SeisanDHaneiTuutiTy> OrderZT_SeisanDHaneiTuutiTyByPkDesc(List<ZT_SeisanDHaneiTuutiTy> pEntity) {
        List<SortCondition<ZT_SeisanDHaneiTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeisanDHaneiTuutiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeisanDHaneiTuutiTy()).ztykeysyono, SortOrder.DESC));
        List<ZT_SeisanDHaneiTuutiTy> copyList = new ArrayList<ZT_SeisanDHaneiTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SeisanDHaneiTuutiTy(orders));
        return copyList;
    }
}
