package yuyu.def.siharai.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.JT_SiRireki;

import com.google.common.base.Predicate;

/**
 * 支払履歴テーブル用 Predicate<br/>
 */
public class FilterSiRirekiByShrsyoriymd implements Predicate<JT_SiRireki> {

    BizDate kijyunymd;

    public FilterSiRirekiByShrsyoriymd(BizDate pkijyunymd) {
        super();
        kijyunymd = pkijyunymd;
    }

    @Override
    public boolean apply(JT_SiRireki pSiRireki) {

        if (pSiRireki.getShrsyoriymd() != null
            && kijyunymd.compareTo(pSiRireki.getShrsyoriymd()) < 0) {

            return true;
        }

        return false;
    }
}
