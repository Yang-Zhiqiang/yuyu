package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TuukabetuKyuusibiRn;
import yuyu.def.db.meta.QZT_TuukabetuKyuusibiRn;
import yuyu.def.zdb.comparator.OrderZT_TuukabetuKyuusibiRn;

public class SortZT_TuukabetuKyuusibiRn {

    
    public List<ZT_TuukabetuKyuusibiRn> OrderZT_TuukabetuKyuusibiRnByPkAsc(List<ZT_TuukabetuKyuusibiRn> pEntity) {
        List<SortCondition<ZT_TuukabetuKyuusibiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TuukabetuKyuusibiRn()).zrntekiyouymd, SortOrder.ASC));
        List<ZT_TuukabetuKyuusibiRn> copyList = new ArrayList<ZT_TuukabetuKyuusibiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TuukabetuKyuusibiRn(orders));
        return copyList;
    }

    
    public List<ZT_TuukabetuKyuusibiRn> OrderZT_TuukabetuKyuusibiRnByPkDesc(List<ZT_TuukabetuKyuusibiRn> pEntity) {
        List<SortCondition<ZT_TuukabetuKyuusibiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TuukabetuKyuusibiRn()).zrntekiyouymd, SortOrder.DESC));
        List<ZT_TuukabetuKyuusibiRn> copyList = new ArrayList<ZT_TuukabetuKyuusibiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TuukabetuKyuusibiRn(orders));
        return copyList;
    }
}
