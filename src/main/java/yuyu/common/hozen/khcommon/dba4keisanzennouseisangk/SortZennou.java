package yuyu.common.hozen.khcommon.dba4keisanzennouseisangk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_Zennou;
import yuyu.def.hozen.comparator.OrderIT_Zennou;

/**
 * 前納テーブルのソートクラス
 */
public class SortZennou {

    public List<IT_Zennou> OrderIT_ZennouByZennoukaisiymdRennoDesc(List<IT_Zennou> pZennouList) {

        List<SortCondition<IT_Zennou>> sortConditionZennouList = new ArrayList<>();

        sortConditionZennouList.add(new SortCondition<>((new QIT_Zennou()).zennoukaisiymd, SortOrder.DESC));

        sortConditionZennouList.add(new SortCondition<>((new QIT_Zennou()).renno, SortOrder.DESC));

        List<IT_Zennou> zennouTmpList = new ArrayList<IT_Zennou>(pZennouList);

        Collections.sort(zennouTmpList, new OrderIT_Zennou(sortConditionZennouList));

        return zennouTmpList;

    }
}
