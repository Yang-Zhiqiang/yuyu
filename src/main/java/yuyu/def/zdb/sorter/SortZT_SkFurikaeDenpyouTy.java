package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouTy;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouTy;
import yuyu.def.zdb.comparator.OrderZT_SkFurikaeDenpyouTy;

public class SortZT_SkFurikaeDenpyouTy {

    
    public List<ZT_SkFurikaeDenpyouTy> OrderZT_SkFurikaeDenpyouTyByPkAsc(List<ZT_SkFurikaeDenpyouTy> pEntity) {
        List<SortCondition<ZT_SkFurikaeDenpyouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikibi, SortOrder.ASC));
        List<ZT_SkFurikaeDenpyouTy> copyList = new ArrayList<ZT_SkFurikaeDenpyouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkFurikaeDenpyouTy(orders));
        return copyList;
    }

    
    public List<ZT_SkFurikaeDenpyouTy> OrderZT_SkFurikaeDenpyouTyByPkDesc(List<ZT_SkFurikaeDenpyouTy> pEntity) {
        List<SortCondition<ZT_SkFurikaeDenpyouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouTy()).ztytorihikibi, SortOrder.DESC));
        List<ZT_SkFurikaeDenpyouTy> copyList = new ArrayList<ZT_SkFurikaeDenpyouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkFurikaeDenpyouTy(orders));
        return copyList;
    }
}
