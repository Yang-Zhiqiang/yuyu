package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.meta.QZT_MosJkItiranSyoukaiTy;
import yuyu.def.zdb.comparator.OrderZT_MosJkItiranSyoukaiTy;

public class SortZT_MosJkItiranSyoukaiTy {

    
    public List<ZT_MosJkItiranSyoukaiTy> OrderZT_MosJkItiranSyoukaiTyByPkAsc(List<ZT_MosJkItiranSyoukaiTy> pEntity) {
        List<SortCondition<ZT_MosJkItiranSyoukaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiTy()).ztymosym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiTy()).ztymosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiTy()).ztybsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiTy()).ztyatukaikojincd, SortOrder.ASC));
        List<ZT_MosJkItiranSyoukaiTy> copyList = new ArrayList<ZT_MosJkItiranSyoukaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_MosJkItiranSyoukaiTy(orders));
        return copyList;
    }

    
    public List<ZT_MosJkItiranSyoukaiTy> OrderZT_MosJkItiranSyoukaiTyByPkDesc(List<ZT_MosJkItiranSyoukaiTy> pEntity) {
        List<SortCondition<ZT_MosJkItiranSyoukaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiTy()).ztymosym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiTy()).ztymosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiTy()).ztybsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiTy()).ztyatukaikojincd, SortOrder.DESC));
        List<ZT_MosJkItiranSyoukaiTy> copyList = new ArrayList<ZT_MosJkItiranSyoukaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_MosJkItiranSyoukaiTy(orders));
        return copyList;
    }
}
