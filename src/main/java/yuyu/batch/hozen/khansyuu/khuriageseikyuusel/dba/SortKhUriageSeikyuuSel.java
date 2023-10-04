package yuyu.batch.hozen.khansyuu.khuriageseikyuusel.dba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.hozen.comparator.OrderIT_AnsyuRireki;

/**
 * Sorterクラス
 *
 */
public class SortKhUriageSeikyuuSel {

    public List<IT_AnsyuRireki> OrderIT_AnsyuRirekiByAnnainoDesc(List<IT_AnsyuRireki> pEntity) {
        List<SortCondition<IT_AnsyuRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).annaino, SortOrder.DESC));
        List<IT_AnsyuRireki> copyList = new ArrayList<IT_AnsyuRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuRireki(orders));
        return copyList;
    }
}
