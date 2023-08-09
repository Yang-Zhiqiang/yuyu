package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KariwariateHtkinMeisaiRn;
import yuyu.def.db.meta.QZT_KariwariateHtkinMeisaiRn;
import yuyu.def.zdb.comparator.OrderZT_KariwariateHtkinMeisaiRn;

public class SortZT_KariwariateHtkinMeisaiRn {

    
    public List<ZT_KariwariateHtkinMeisaiRn> OrderZT_KariwariateHtkinMeisaiRnByPkAsc(List<ZT_KariwariateHtkinMeisaiRn> pEntity) {
        List<SortCondition<ZT_KariwariateHtkinMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KariwariateHtkinMeisaiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_KariwariateHtkinMeisaiRn> copyList = new ArrayList<ZT_KariwariateHtkinMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KariwariateHtkinMeisaiRn(orders));
        return copyList;
    }

    
    public List<ZT_KariwariateHtkinMeisaiRn> OrderZT_KariwariateHtkinMeisaiRnByPkDesc(List<ZT_KariwariateHtkinMeisaiRn> pEntity) {
        List<SortCondition<ZT_KariwariateHtkinMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KariwariateHtkinMeisaiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_KariwariateHtkinMeisaiRn> copyList = new ArrayList<ZT_KariwariateHtkinMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KariwariateHtkinMeisaiRn(orders));
        return copyList;
    }
}
