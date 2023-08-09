package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKsnHurikaeTy;
import yuyu.def.db.meta.QZT_SkKsnHurikaeTy;
import yuyu.def.zdb.comparator.OrderZT_SkKsnHurikaeTy;

public class SortZT_SkKsnHurikaeTy {

    
    public List<ZT_SkKsnHurikaeTy> OrderZT_SkKsnHurikaeTyByPkAsc(List<ZT_SkKsnHurikaeTy> pEntity) {
        List<SortCondition<ZT_SkKsnHurikaeTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikibi, SortOrder.ASC));
        List<ZT_SkKsnHurikaeTy> copyList = new ArrayList<ZT_SkKsnHurikaeTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnHurikaeTy(orders));
        return copyList;
    }

    
    public List<ZT_SkKsnHurikaeTy> OrderZT_SkKsnHurikaeTyByPkDesc(List<ZT_SkKsnHurikaeTy> pEntity) {
        List<SortCondition<ZT_SkKsnHurikaeTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeTy()).ztytorihikibi, SortOrder.DESC));
        List<ZT_SkKsnHurikaeTy> copyList = new ArrayList<ZT_SkKsnHurikaeTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnHurikaeTy(orders));
        return copyList;
    }
}
