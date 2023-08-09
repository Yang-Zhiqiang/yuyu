package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_FurikaeDenpyouTy;
import yuyu.def.db.meta.QZT_FurikaeDenpyouTy;
import yuyu.def.zdb.comparator.OrderZT_FurikaeDenpyouTy;

public class SortZT_FurikaeDenpyouTy {

    
    public List<ZT_FurikaeDenpyouTy> OrderZT_FurikaeDenpyouTyByPkAsc(List<ZT_FurikaeDenpyouTy> pEntity) {
        List<SortCondition<ZT_FurikaeDenpyouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikibi, SortOrder.ASC));
        List<ZT_FurikaeDenpyouTy> copyList = new ArrayList<ZT_FurikaeDenpyouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_FurikaeDenpyouTy(orders));
        return copyList;
    }

    
    public List<ZT_FurikaeDenpyouTy> OrderZT_FurikaeDenpyouTyByPkDesc(List<ZT_FurikaeDenpyouTy> pEntity) {
        List<SortCondition<ZT_FurikaeDenpyouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouTy()).ztytorihikibi, SortOrder.DESC));
        List<ZT_FurikaeDenpyouTy> copyList = new ArrayList<ZT_FurikaeDenpyouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_FurikaeDenpyouTy(orders));
        return copyList;
    }
}
