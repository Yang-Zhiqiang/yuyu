package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;

import com.google.common.base.Predicate;

/**
 * 案内収納履歴テーブルエンティティ用 Predicate<br/>
 *
 * 案内状況区分（一致）
 */
public class FilterAnsyuRirekiByAnnaijkkbn  implements Predicate<IT_AnsyuRireki> {

    C_AnnaijkKbn annaijkKbn;

    public FilterAnsyuRirekiByAnnaijkkbn(C_AnnaijkKbn pAnnaijkkbn) {
        super();
        annaijkKbn = pAnnaijkkbn;
    }

    @Override
    public boolean apply(IT_AnsyuRireki pAnsyuRireki) {
        if (annaijkKbn.eq(pAnsyuRireki.getAnnaijkkbn())) {
            return true;
        }
        return false;
    }
}
