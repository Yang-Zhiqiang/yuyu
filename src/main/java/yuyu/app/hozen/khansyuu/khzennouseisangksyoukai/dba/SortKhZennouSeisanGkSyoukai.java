package yuyu.app.hozen.khansyuu.khzennouseisangksyoukai.dba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_Zennou;
import yuyu.def.hozen.comparator.OrderIT_Zennou;

import com.google.common.collect.Lists;

/**
 * 前納精算額照会 前納精算額照会機能ソートクラスです。<br/>
 */
public class SortKhZennouSeisanGkSyoukai {

    public List<IT_Zennou> OrderIT_ZennouByRyosyuymdDesc (List<IT_Zennou> pZennouLst) {

        List<SortCondition<IT_Zennou>>  orders = Lists.newArrayList();

        orders.add(new SortCondition<>((new QIT_Zennou()).ryosyuymd, SortOrder.DESC));

        List<IT_Zennou> copyList = new ArrayList<IT_Zennou>(pZennouLst);

        Collections.sort(copyList, new OrderIT_Zennou(orders));

        return copyList;
    }
}
