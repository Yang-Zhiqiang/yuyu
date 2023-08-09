package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouHikaeRn;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouHikaeRn;
import yuyu.def.zdb.comparator.OrderZT_SkFurikaeDenpyouHikaeRn;

public class SortZT_SkFurikaeDenpyouHikaeRn {

    
    public List<ZT_SkFurikaeDenpyouHikaeRn> OrderZT_SkFurikaeDenpyouHikaeRnByPkAsc(List<ZT_SkFurikaeDenpyouHikaeRn> pEntity) {
        List<SortCondition<ZT_SkFurikaeDenpyouHikaeRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikibi, SortOrder.ASC));
        List<ZT_SkFurikaeDenpyouHikaeRn> copyList = new ArrayList<ZT_SkFurikaeDenpyouHikaeRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkFurikaeDenpyouHikaeRn(orders));
        return copyList;
    }

    
    public List<ZT_SkFurikaeDenpyouHikaeRn> OrderZT_SkFurikaeDenpyouHikaeRnByPkDesc(List<ZT_SkFurikaeDenpyouHikaeRn> pEntity) {
        List<SortCondition<ZT_SkFurikaeDenpyouHikaeRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouHikaeRn()).zrntorihikibi, SortOrder.DESC));
        List<ZT_SkFurikaeDenpyouHikaeRn> copyList = new ArrayList<ZT_SkFurikaeDenpyouHikaeRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkFurikaeDenpyouHikaeRn(orders));
        return copyList;
    }
}
