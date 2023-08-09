package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.meta.QZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.zdb.comparator.OrderZT_ZitkAzukarikinSrRendouTy;

public class SortZT_ZitkAzukarikinSrRendouTy {

    public List<ZT_ZitkAzukarikinSrRendouTy> OrderZT_ZitkAzukarikinSrRendouTyByPkAsc(List<ZT_ZitkAzukarikinSrRendouTy> pEntity) {
        List<SortCondition<ZT_ZitkAzukarikinSrRendouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_ZitkAzukarikinSrRendouTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_ZitkAzukarikinSrRendouTy> copyList = new ArrayList<ZT_ZitkAzukarikinSrRendouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_ZitkAzukarikinSrRendouTy(orders));
        return copyList;
    }

    public List<ZT_ZitkAzukarikinSrRendouTy> OrderZT_ZitkAzukarikinSrRendouTyByPkDesc(List<ZT_ZitkAzukarikinSrRendouTy> pEntity) {
        List<SortCondition<ZT_ZitkAzukarikinSrRendouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_ZitkAzukarikinSrRendouTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_ZitkAzukarikinSrRendouTy> copyList = new ArrayList<ZT_ZitkAzukarikinSrRendouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_ZitkAzukarikinSrRendouTy(orders));
        return copyList;
    }
}
