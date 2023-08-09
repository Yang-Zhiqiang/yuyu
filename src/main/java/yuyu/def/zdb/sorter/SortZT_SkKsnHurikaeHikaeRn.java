package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKsnHurikaeHikaeRn;
import yuyu.def.db.meta.QZT_SkKsnHurikaeHikaeRn;
import yuyu.def.zdb.comparator.OrderZT_SkKsnHurikaeHikaeRn;

public class SortZT_SkKsnHurikaeHikaeRn {

    
    public List<ZT_SkKsnHurikaeHikaeRn> OrderZT_SkKsnHurikaeHikaeRnByPkAsc(List<ZT_SkKsnHurikaeHikaeRn> pEntity) {
        List<SortCondition<ZT_SkKsnHurikaeHikaeRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikibi, SortOrder.ASC));
        List<ZT_SkKsnHurikaeHikaeRn> copyList = new ArrayList<ZT_SkKsnHurikaeHikaeRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnHurikaeHikaeRn(orders));
        return copyList;
    }

    
    public List<ZT_SkKsnHurikaeHikaeRn> OrderZT_SkKsnHurikaeHikaeRnByPkDesc(List<ZT_SkKsnHurikaeHikaeRn> pEntity) {
        List<SortCondition<ZT_SkKsnHurikaeHikaeRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeHikaeRn()).zrntorihikibi, SortOrder.DESC));
        List<ZT_SkKsnHurikaeHikaeRn> copyList = new ArrayList<ZT_SkKsnHurikaeHikaeRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnHurikaeHikaeRn(orders));
        return copyList;
    }
}
