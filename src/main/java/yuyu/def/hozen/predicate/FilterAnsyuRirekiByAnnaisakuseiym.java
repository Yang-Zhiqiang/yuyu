package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_AnsyuRireki;

import com.google.common.base.Predicate;

/**
 * 案内収納履歴テーブル用 Predicate<br/>
 * I．案内作成日（年月）≦案内作成日（年月）<br/>
 */
public class FilterAnsyuRirekiByAnnaisakuseiym implements Predicate<IT_AnsyuRireki> {

    BizDateYM annaisakuseiym;

    public FilterAnsyuRirekiByAnnaisakuseiym(BizDateYM pAnnaisakuseiym) {
        super();
        annaisakuseiym = pAnnaisakuseiym;
    }

    @Override
    public boolean apply(IT_AnsyuRireki ansyuRireki) {
        if (ansyuRireki.getAnnaisakuseiymd() != null &&
            annaisakuseiym.compareTo(ansyuRireki.getAnnaisakuseiymd().getBizDateYM()) <= 0) {
            return true;
        }
        return false;
    }
}