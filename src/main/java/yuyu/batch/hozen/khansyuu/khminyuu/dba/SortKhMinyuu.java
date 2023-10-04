package yuyu.batch.hozen.khansyuu.khminyuu.dba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.hozen.comparator.OrderIT_AnsyuRireki;
import yuyu.def.hozen.comparator.OrderIT_KykDairiten;

/**
 * 未入処理 のソートクラス
 */
public class SortKhMinyuu {

    public List<IT_KykDairiten> OrderIT_KykDairitenByDrtenrennoAsc(List<IT_KykDairiten> pKykDairitenLst) {

        List<SortCondition<IT_KykDairiten>> sortConditionKykDairitenLst = new ArrayList<>();

        sortConditionKykDairitenLst.add(new SortCondition<>((new QIT_KykDairiten()).drtenrenno, SortOrder.ASC));

        List<IT_KykDairiten> kykDairitenLst = new ArrayList<IT_KykDairiten>(pKykDairitenLst);

        Collections.sort(kykDairitenLst, new OrderIT_KykDairiten(sortConditionKykDairitenLst));

        return kykDairitenLst;
    }

    public List<IT_AnsyuRireki> OrderIT_AnsyuRirekiByJyuutouymAsc(List<IT_AnsyuRireki> pAnsyuRireki) {

        List<SortCondition<IT_AnsyuRireki>> sortConditionAnsyuRirekiLst = new ArrayList<>();

        sortConditionAnsyuRirekiLst.add(new SortCondition<>((new QIT_AnsyuRireki()).jyuutouym, SortOrder.ASC));

        List<IT_AnsyuRireki> kykAnsyuRireki = new ArrayList<IT_AnsyuRireki>(pAnsyuRireki);

        Collections.sort(kykAnsyuRireki, new OrderIT_AnsyuRireki(sortConditionAnsyuRirekiLst));

        return kykAnsyuRireki;
    }
}
