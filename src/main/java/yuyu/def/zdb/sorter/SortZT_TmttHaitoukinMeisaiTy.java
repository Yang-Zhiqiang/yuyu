package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TmttHaitoukinMeisaiTy;
import yuyu.def.db.meta.QZT_TmttHaitoukinMeisaiTy;
import yuyu.def.zdb.comparator.OrderZT_TmttHaitoukinMeisaiTy;

public class SortZT_TmttHaitoukinMeisaiTy {

    
    public List<ZT_TmttHaitoukinMeisaiTy> OrderZT_TmttHaitoukinMeisaiTyByPkAsc(List<ZT_TmttHaitoukinMeisaiTy> pEntity) {
        List<SortCondition<ZT_TmttHaitoukinMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TmttHaitoukinMeisaiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_TmttHaitoukinMeisaiTy> copyList = new ArrayList<ZT_TmttHaitoukinMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TmttHaitoukinMeisaiTy(orders));
        return copyList;
    }

    
    public List<ZT_TmttHaitoukinMeisaiTy> OrderZT_TmttHaitoukinMeisaiTyByPkDesc(List<ZT_TmttHaitoukinMeisaiTy> pEntity) {
        List<SortCondition<ZT_TmttHaitoukinMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TmttHaitoukinMeisaiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_TmttHaitoukinMeisaiTy> copyList = new ArrayList<ZT_TmttHaitoukinMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TmttHaitoukinMeisaiTy(orders));
        return copyList;
    }
}
