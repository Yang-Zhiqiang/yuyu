package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_FurikaeDenpyouHikaeTy;
import yuyu.def.db.meta.QZT_FurikaeDenpyouHikaeTy;
import yuyu.def.zdb.comparator.OrderZT_FurikaeDenpyouHikaeTy;

public class SortZT_FurikaeDenpyouHikaeTy {

    
    public List<ZT_FurikaeDenpyouHikaeTy> OrderZT_FurikaeDenpyouHikaeTyByPkAsc(List<ZT_FurikaeDenpyouHikaeTy> pEntity) {
        List<SortCondition<ZT_FurikaeDenpyouHikaeTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikibi, SortOrder.ASC));
        List<ZT_FurikaeDenpyouHikaeTy> copyList = new ArrayList<ZT_FurikaeDenpyouHikaeTy>(pEntity);
        Collections.sort(copyList, new OrderZT_FurikaeDenpyouHikaeTy(orders));
        return copyList;
    }

    
    public List<ZT_FurikaeDenpyouHikaeTy> OrderZT_FurikaeDenpyouHikaeTyByPkDesc(List<ZT_FurikaeDenpyouHikaeTy> pEntity) {
        List<SortCondition<ZT_FurikaeDenpyouHikaeTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeTy()).ztytorihikibi, SortOrder.DESC));
        List<ZT_FurikaeDenpyouHikaeTy> copyList = new ArrayList<ZT_FurikaeDenpyouHikaeTy>(pEntity);
        Collections.sort(copyList, new OrderZT_FurikaeDenpyouHikaeTy(orders));
        return copyList;
    }
}
