package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkSeirituRituRn;
import yuyu.def.db.meta.QZT_SkSeirituRituRn;
import yuyu.def.zdb.comparator.OrderZT_SkSeirituRituRn;

public class SortZT_SkSeirituRituRn {

    
    public List<ZT_SkSeirituRituRn> OrderZT_SkSeirituRituRnByPkAsc(List<ZT_SkSeirituRituRn> pEntity) {
        List<SortCondition<ZT_SkSeirituRituRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkSeirituRituRn()).zrneigyouhonbusisyacd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituRn()).zrnsosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituRn()).zrnatukaikojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituRn()).zrnmosno, SortOrder.ASC));
        List<ZT_SkSeirituRituRn> copyList = new ArrayList<ZT_SkSeirituRituRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkSeirituRituRn(orders));
        return copyList;
    }

    
    public List<ZT_SkSeirituRituRn> OrderZT_SkSeirituRituRnByPkDesc(List<ZT_SkSeirituRituRn> pEntity) {
        List<SortCondition<ZT_SkSeirituRituRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkSeirituRituRn()).zrneigyouhonbusisyacd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituRn()).zrnsosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituRn()).zrnatukaikojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituRn()).zrnmosno, SortOrder.DESC));
        List<ZT_SkSeirituRituRn> copyList = new ArrayList<ZT_SkSeirituRituRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkSeirituRituRn(orders));
        return copyList;
    }
}
