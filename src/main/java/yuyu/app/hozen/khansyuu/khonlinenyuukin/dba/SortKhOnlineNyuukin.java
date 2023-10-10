package yuyu.app.hozen.khansyuu.khonlinenyuukin.dba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HrkeIraiInfo;
import yuyu.def.db.meta.QIT_HrkeIraiInfo;
import yuyu.def.hozen.comparator.OrderIT_HrkeIraiInfo;

import com.google.common.collect.Lists;

/**
 * オンライン入金処理 オンライン入金処理機能ソートクラスです。<br/>
 */
public class SortKhOnlineNyuukin {

    public List<IT_HrkeIraiInfo> OrderIT_HrkeIraiInfoByHrkkigenAsc (List<IT_HrkeIraiInfo> pHrkeIraiInfoLst) {

        List<SortCondition<IT_HrkeIraiInfo>>  orders = Lists.newArrayList();

        orders.add(new SortCondition<>((new QIT_HrkeIraiInfo()).hrkkigen, SortOrder.ASC));

        List<IT_HrkeIraiInfo> copyList = new ArrayList<IT_HrkeIraiInfo>(pHrkeIraiInfoLst);

        Collections.sort(copyList, new OrderIT_HrkeIraiInfo(orders));

        return copyList;
    }
}
