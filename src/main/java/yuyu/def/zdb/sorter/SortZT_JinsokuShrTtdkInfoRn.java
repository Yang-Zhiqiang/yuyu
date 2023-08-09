package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.meta.QZT_JinsokuShrTtdkInfoRn;
import yuyu.def.zdb.comparator.OrderZT_JinsokuShrTtdkInfoRn;

public class SortZT_JinsokuShrTtdkInfoRn {

    
    public List<ZT_JinsokuShrTtdkInfoRn> OrderZT_JinsokuShrTtdkInfoRnByPkAsc(List<ZT_JinsokuShrTtdkInfoRn> pEntity) {
        List<SortCondition<ZT_JinsokuShrTtdkInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnsyorisosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnsyoricd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnhknknshrsntkno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnsyoruiukeymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnsyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrndenymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnsyono, SortOrder.ASC));
        List<ZT_JinsokuShrTtdkInfoRn> copyList = new ArrayList<ZT_JinsokuShrTtdkInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_JinsokuShrTtdkInfoRn(orders));
        return copyList;
    }

    
    public List<ZT_JinsokuShrTtdkInfoRn> OrderZT_JinsokuShrTtdkInfoRnByPkDesc(List<ZT_JinsokuShrTtdkInfoRn> pEntity) {
        List<SortCondition<ZT_JinsokuShrTtdkInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnsyorisosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnsyoricd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnhknknshrsntkno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnsyoruiukeymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnsyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrndenymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_JinsokuShrTtdkInfoRn()).zrnsyono, SortOrder.DESC));
        List<ZT_JinsokuShrTtdkInfoRn> copyList = new ArrayList<ZT_JinsokuShrTtdkInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_JinsokuShrTtdkInfoRn(orders));
        return copyList;
    }
}
