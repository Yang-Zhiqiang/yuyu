package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KariwariateHtkinMeisaiTy;
import yuyu.def.db.meta.QZT_KariwariateHtkinMeisaiTy;
import yuyu.def.zdb.comparator.OrderZT_KariwariateHtkinMeisaiTy;

public class SortZT_KariwariateHtkinMeisaiTy {

    
    public List<ZT_KariwariateHtkinMeisaiTy> OrderZT_KariwariateHtkinMeisaiTyByPkAsc(List<ZT_KariwariateHtkinMeisaiTy> pEntity) {
        List<SortCondition<ZT_KariwariateHtkinMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KariwariateHtkinMeisaiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_KariwariateHtkinMeisaiTy> copyList = new ArrayList<ZT_KariwariateHtkinMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KariwariateHtkinMeisaiTy(orders));
        return copyList;
    }

    
    public List<ZT_KariwariateHtkinMeisaiTy> OrderZT_KariwariateHtkinMeisaiTyByPkDesc(List<ZT_KariwariateHtkinMeisaiTy> pEntity) {
        List<SortCondition<ZT_KariwariateHtkinMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KariwariateHtkinMeisaiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_KariwariateHtkinMeisaiTy> copyList = new ArrayList<ZT_KariwariateHtkinMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KariwariateHtkinMeisaiTy(orders));
        return copyList;
    }
}
