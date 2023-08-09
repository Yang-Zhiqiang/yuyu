package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouRn;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouRn;
import yuyu.def.zdb.comparator.OrderZT_SkFurikaeDenpyouRn;

public class SortZT_SkFurikaeDenpyouRn {

    
    public List<ZT_SkFurikaeDenpyouRn> OrderZT_SkFurikaeDenpyouRnByPkAsc(List<ZT_SkFurikaeDenpyouRn> pEntity) {
        List<SortCondition<ZT_SkFurikaeDenpyouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikibi, SortOrder.ASC));
        List<ZT_SkFurikaeDenpyouRn> copyList = new ArrayList<ZT_SkFurikaeDenpyouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkFurikaeDenpyouRn(orders));
        return copyList;
    }

    
    public List<ZT_SkFurikaeDenpyouRn> OrderZT_SkFurikaeDenpyouRnByPkDesc(List<ZT_SkFurikaeDenpyouRn> pEntity) {
        List<SortCondition<ZT_SkFurikaeDenpyouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkFurikaeDenpyouRn()).zrntorihikibi, SortOrder.DESC));
        List<ZT_SkFurikaeDenpyouRn> copyList = new ArrayList<ZT_SkFurikaeDenpyouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkFurikaeDenpyouRn(orders));
        return copyList;
    }
}
