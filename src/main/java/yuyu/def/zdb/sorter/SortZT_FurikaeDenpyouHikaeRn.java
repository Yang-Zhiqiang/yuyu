package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_FurikaeDenpyouHikaeRn;
import yuyu.def.db.meta.QZT_FurikaeDenpyouHikaeRn;
import yuyu.def.zdb.comparator.OrderZT_FurikaeDenpyouHikaeRn;

public class SortZT_FurikaeDenpyouHikaeRn {

    
    public List<ZT_FurikaeDenpyouHikaeRn> OrderZT_FurikaeDenpyouHikaeRnByPkAsc(List<ZT_FurikaeDenpyouHikaeRn> pEntity) {
        List<SortCondition<ZT_FurikaeDenpyouHikaeRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikibi, SortOrder.ASC));
        List<ZT_FurikaeDenpyouHikaeRn> copyList = new ArrayList<ZT_FurikaeDenpyouHikaeRn>(pEntity);
        Collections.sort(copyList, new OrderZT_FurikaeDenpyouHikaeRn(orders));
        return copyList;
    }

    
    public List<ZT_FurikaeDenpyouHikaeRn> OrderZT_FurikaeDenpyouHikaeRnByPkDesc(List<ZT_FurikaeDenpyouHikaeRn> pEntity) {
        List<SortCondition<ZT_FurikaeDenpyouHikaeRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouHikaeRn()).zrntorihikibi, SortOrder.DESC));
        List<ZT_FurikaeDenpyouHikaeRn> copyList = new ArrayList<ZT_FurikaeDenpyouHikaeRn>(pEntity);
        Collections.sort(copyList, new OrderZT_FurikaeDenpyouHikaeRn(orders));
        return copyList;
    }
}
