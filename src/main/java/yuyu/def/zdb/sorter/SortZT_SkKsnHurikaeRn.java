package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKsnHurikaeRn;
import yuyu.def.db.meta.QZT_SkKsnHurikaeRn;
import yuyu.def.zdb.comparator.OrderZT_SkKsnHurikaeRn;

public class SortZT_SkKsnHurikaeRn {

    
    public List<ZT_SkKsnHurikaeRn> OrderZT_SkKsnHurikaeRnByPkAsc(List<ZT_SkKsnHurikaeRn> pEntity) {
        List<SortCondition<ZT_SkKsnHurikaeRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikibi, SortOrder.ASC));
        List<ZT_SkKsnHurikaeRn> copyList = new ArrayList<ZT_SkKsnHurikaeRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnHurikaeRn(orders));
        return copyList;
    }

    
    public List<ZT_SkKsnHurikaeRn> OrderZT_SkKsnHurikaeRnByPkDesc(List<ZT_SkKsnHurikaeRn> pEntity) {
        List<SortCondition<ZT_SkKsnHurikaeRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnHurikaeRn()).zrntorihikibi, SortOrder.DESC));
        List<ZT_SkKsnHurikaeRn> copyList = new ArrayList<ZT_SkKsnHurikaeRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnHurikaeRn(orders));
        return copyList;
    }
}
