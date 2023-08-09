package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SisuuRendouRn;
import yuyu.def.db.meta.QZT_SisuuRendouRn;
import yuyu.def.zdb.comparator.OrderZT_SisuuRendouRn;

public class SortZT_SisuuRendouRn {

    
    public List<ZT_SisuuRendouRn> OrderZT_SisuuRendouRnByPkAsc(List<ZT_SisuuRendouRn> pEntity) {
        List<SortCondition<ZT_SisuuRendouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SisuuRendouRn()).zrntorikomiyousisuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SisuuRendouRn()).zrnsisuukouhyouymd, SortOrder.ASC));
        List<ZT_SisuuRendouRn> copyList = new ArrayList<ZT_SisuuRendouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SisuuRendouRn(orders));
        return copyList;
    }

    
    public List<ZT_SisuuRendouRn> OrderZT_SisuuRendouRnByPkDesc(List<ZT_SisuuRendouRn> pEntity) {
        List<SortCondition<ZT_SisuuRendouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SisuuRendouRn()).zrntorikomiyousisuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SisuuRendouRn()).zrnsisuukouhyouymd, SortOrder.DESC));
        List<ZT_SisuuRendouRn> copyList = new ArrayList<ZT_SisuuRendouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SisuuRendouRn(orders));
        return copyList;
    }
}
