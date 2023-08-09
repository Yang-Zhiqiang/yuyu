package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.zdb.comparator.OrderZT_SkFurikaeDenpyouHikaeTy;

public class SortZT_SkFurikaeDenpyouHikaeTy {

    
    public List<ZT_SkFurikaeDenpyouHikaeTy> OrderZT_SkFurikaeDenpyouHikaeTyByPkAsc(List<ZT_SkFurikaeDenpyouHikaeTy> pEntity) {
        List<SortCondition<ZT_SkFurikaeDenpyouHikaeTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikibi, SortOrder.ASC));
        List<ZT_SkFurikaeDenpyouHikaeTy> copyList = new ArrayList<ZT_SkFurikaeDenpyouHikaeTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkFurikaeDenpyouHikaeTy(orders));
        return copyList;
    }

    
    public List<ZT_SkFurikaeDenpyouHikaeTy> OrderZT_SkFurikaeDenpyouHikaeTyByPkDesc(List<ZT_SkFurikaeDenpyouHikaeTy> pEntity) {
        List<SortCondition<ZT_SkFurikaeDenpyouHikaeTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeTy()).ztytorihikibi, SortOrder.DESC));
        List<ZT_SkFurikaeDenpyouHikaeTy> copyList = new ArrayList<ZT_SkFurikaeDenpyouHikaeTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkFurikaeDenpyouHikaeTy(orders));
        return copyList;
    }
}
