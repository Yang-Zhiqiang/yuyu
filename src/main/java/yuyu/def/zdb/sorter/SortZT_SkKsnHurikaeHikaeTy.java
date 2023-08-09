package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKsnHurikaeHikaeTy;
import yuyu.def.db.meta.QZT_SkKsnHurikaeHikaeTy;
import yuyu.def.zdb.comparator.OrderZT_SkKsnHurikaeHikaeTy;

public class SortZT_SkKsnHurikaeHikaeTy {

    
    public List<ZT_SkKsnHurikaeHikaeTy> OrderZT_SkKsnHurikaeHikaeTyByPkAsc(List<ZT_SkKsnHurikaeHikaeTy> pEntity) {
        List<SortCondition<ZT_SkKsnHurikaeHikaeTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikibi, SortOrder.ASC));
        List<ZT_SkKsnHurikaeHikaeTy> copyList = new ArrayList<ZT_SkKsnHurikaeHikaeTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnHurikaeHikaeTy(orders));
        return copyList;
    }

    
    public List<ZT_SkKsnHurikaeHikaeTy> OrderZT_SkKsnHurikaeHikaeTyByPkDesc(List<ZT_SkKsnHurikaeHikaeTy> pEntity) {
        List<SortCondition<ZT_SkKsnHurikaeHikaeTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeTy()).ztytorihikibi, SortOrder.DESC));
        List<ZT_SkKsnHurikaeHikaeTy> copyList = new ArrayList<ZT_SkKsnHurikaeHikaeTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnHurikaeHikaeTy(orders));
        return copyList;
    }
}
