package yuyu.batch.hozen.khansyuu.khzennoujyuutoumanryou.dba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.hozen.comparator.OrderIT_NyknJissekiRireki;

/**
 * 前納充当・満了処理 のソートクラス
 */
public class SortKhZennouJyuutouManryou {

    public List<IT_NyknJissekiRireki> OrderIT_NyknJissekiRirekiByRennoDesc(List<IT_NyknJissekiRireki> pNyknJissekiRirekiList){

        List<SortCondition<IT_NyknJissekiRireki>> sortConditionNyknJissekiRirekiList = new ArrayList<>();

        sortConditionNyknJissekiRirekiList.add(new SortCondition<>((new QIT_NyknJissekiRireki()).renno, SortOrder.DESC));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiTmpList = new ArrayList<IT_NyknJissekiRireki>(pNyknJissekiRirekiList);

        Collections.sort(nyknJissekiRirekiTmpList, new OrderIT_NyknJissekiRireki(sortConditionNyknJissekiRirekiList));

        return nyknJissekiRirekiTmpList;
    }
}
