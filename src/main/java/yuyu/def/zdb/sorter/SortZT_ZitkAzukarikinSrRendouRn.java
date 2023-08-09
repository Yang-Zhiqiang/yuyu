package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.meta.QZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.zdb.comparator.OrderZT_ZitkAzukarikinSrRendouRn;

public class SortZT_ZitkAzukarikinSrRendouRn {

    
    public List<ZT_ZitkAzukarikinSrRendouRn> OrderZT_ZitkAzukarikinSrRendouRnByPkAsc(List<ZT_ZitkAzukarikinSrRendouRn> pEntity) {
        List<SortCondition<ZT_ZitkAzukarikinSrRendouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_ZitkAzukarikinSrRendouRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_ZitkAzukarikinSrRendouRn> copyList = new ArrayList<ZT_ZitkAzukarikinSrRendouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_ZitkAzukarikinSrRendouRn(orders));
        return copyList;
    }

    
    public List<ZT_ZitkAzukarikinSrRendouRn> OrderZT_ZitkAzukarikinSrRendouRnByPkDesc(List<ZT_ZitkAzukarikinSrRendouRn> pEntity) {
        List<SortCondition<ZT_ZitkAzukarikinSrRendouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_ZitkAzukarikinSrRendouRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_ZitkAzukarikinSrRendouRn> copyList = new ArrayList<ZT_ZitkAzukarikinSrRendouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_ZitkAzukarikinSrRendouRn(orders));
        return copyList;
    }
}
