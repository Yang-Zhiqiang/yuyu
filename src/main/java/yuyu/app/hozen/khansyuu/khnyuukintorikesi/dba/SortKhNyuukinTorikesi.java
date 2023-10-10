package yuyu.app.hozen.khansyuu.khnyuukintorikesi.dba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.hozen.comparator.OrderIT_KykSyouhn;

import com.google.common.collect.Lists;

/**
 * 入金取消 入金取消機能ソートクラスです。<br/>
 */
public class SortKhNyuukinTorikesi {

    public List<IT_KykSyouhn> OrderIT_KykSyouhnByKouryokuhasseiymdDesc (List<IT_KykSyouhn> pKykSyouhnLst) {

        List<SortCondition<IT_KykSyouhn>>  orders = Lists.newArrayList();

        orders.add(new SortCondition<>((new QIT_KykSyouhn()).kouryokuhasseiymd, SortOrder.DESC));

        List<IT_KykSyouhn> copyList = new ArrayList<IT_KykSyouhn>(pKykSyouhnLst);

        Collections.sort(copyList, new OrderIT_KykSyouhn(orders));

        return copyList;
    }
}
