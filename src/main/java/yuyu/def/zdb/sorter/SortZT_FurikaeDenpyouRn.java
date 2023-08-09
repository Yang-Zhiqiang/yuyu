package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_FurikaeDenpyouRn;
import yuyu.def.db.meta.QZT_FurikaeDenpyouRn;
import yuyu.def.zdb.comparator.OrderZT_FurikaeDenpyouRn;

public class SortZT_FurikaeDenpyouRn {

    
    public List<ZT_FurikaeDenpyouRn> OrderZT_FurikaeDenpyouRnByPkAsc(List<ZT_FurikaeDenpyouRn> pEntity) {
        List<SortCondition<ZT_FurikaeDenpyouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikinoc8, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikinoedano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikiymdgengokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikinen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikituki, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikibi, SortOrder.ASC));
        List<ZT_FurikaeDenpyouRn> copyList = new ArrayList<ZT_FurikaeDenpyouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_FurikaeDenpyouRn(orders));
        return copyList;
    }

    
    public List<ZT_FurikaeDenpyouRn> OrderZT_FurikaeDenpyouRnByPkDesc(List<ZT_FurikaeDenpyouRn> pEntity) {
        List<SortCondition<ZT_FurikaeDenpyouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikinoc8, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikinoedano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikiymdgengokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikinen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikituki, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_FurikaeDenpyouRn()).zrntorihikibi, SortOrder.DESC));
        List<ZT_FurikaeDenpyouRn> copyList = new ArrayList<ZT_FurikaeDenpyouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_FurikaeDenpyouRn(orders));
        return copyList;
    }
}
