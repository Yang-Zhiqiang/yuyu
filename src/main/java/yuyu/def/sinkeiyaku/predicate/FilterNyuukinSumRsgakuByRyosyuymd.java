package yuyu.def.sinkeiyaku.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 入金テーブル用 Predicate<br/>
 * 入金テーブル.領収日 ≦ I．領収日
 */
public class FilterNyuukinSumRsgakuByRyosyuymd implements Predicate<HT_Nyuukin> {

    BizDate ryosyuymd;

    public FilterNyuukinSumRsgakuByRyosyuymd(BizDate pRyosyuymd) {
        super();

        ryosyuymd = pRyosyuymd;
    }

    @Override
    public boolean apply(HT_Nyuukin pNyuukin) {
        if (pNyuukin.getRyosyuymd() != null
            && pNyuukin.getRyosyuymd().compareTo(ryosyuymd) <= 0) {
            return true;
        }
        return false;
    }

}
