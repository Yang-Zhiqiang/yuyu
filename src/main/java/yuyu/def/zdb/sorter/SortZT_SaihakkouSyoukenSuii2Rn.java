package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuii2Rn;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuii2Rn;
import yuyu.def.zdb.comparator.OrderZT_SaihakkouSyoukenSuii2Rn;

public class SortZT_SaihakkouSyoukenSuii2Rn {

    
    public List<ZT_SaihakkouSyoukenSuii2Rn> OrderZT_SaihakkouSyoukenSuii2RnByPkAsc(List<ZT_SaihakkouSyoukenSuii2Rn> pEntity) {
        List<SortCondition<ZT_SaihakkouSyoukenSuii2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Rn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Rn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Rn()).zrnsuiihyouptn, SortOrder.ASC));
        List<ZT_SaihakkouSyoukenSuii2Rn> copyList = new ArrayList<ZT_SaihakkouSyoukenSuii2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouSyoukenSuii2Rn(orders));
        return copyList;
    }

    
    public List<ZT_SaihakkouSyoukenSuii2Rn> OrderZT_SaihakkouSyoukenSuii2RnByPkDesc(List<ZT_SaihakkouSyoukenSuii2Rn> pEntity) {
        List<SortCondition<ZT_SaihakkouSyoukenSuii2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Rn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Rn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Rn()).zrnsuiihyouptn, SortOrder.DESC));
        List<ZT_SaihakkouSyoukenSuii2Rn> copyList = new ArrayList<ZT_SaihakkouSyoukenSuii2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouSyoukenSuii2Rn(orders));
        return copyList;
    }
}
