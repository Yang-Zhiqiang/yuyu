package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkSeirituRituTy;
import yuyu.def.db.meta.QZT_SkSeirituRituTy;
import yuyu.def.zdb.comparator.OrderZT_SkSeirituRituTy;

public class SortZT_SkSeirituRituTy {

    
    public List<ZT_SkSeirituRituTy> OrderZT_SkSeirituRituTyByPkAsc(List<ZT_SkSeirituRituTy> pEntity) {
        List<SortCondition<ZT_SkSeirituRituTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkSeirituRituTy()).ztyeigyouhonbusisyacd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituTy()).ztysosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituTy()).ztyatukaikojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituTy()).ztymosno, SortOrder.ASC));
        List<ZT_SkSeirituRituTy> copyList = new ArrayList<ZT_SkSeirituRituTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkSeirituRituTy(orders));
        return copyList;
    }

    
    public List<ZT_SkSeirituRituTy> OrderZT_SkSeirituRituTyByPkDesc(List<ZT_SkSeirituRituTy> pEntity) {
        List<SortCondition<ZT_SkSeirituRituTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkSeirituRituTy()).ztyeigyouhonbusisyacd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituTy()).ztysosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituTy()).ztyatukaikojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkSeirituRituTy()).ztymosno, SortOrder.DESC));
        List<ZT_SkSeirituRituTy> copyList = new ArrayList<ZT_SkSeirituRituTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkSeirituRituTy(orders));
        return copyList;
    }
}
