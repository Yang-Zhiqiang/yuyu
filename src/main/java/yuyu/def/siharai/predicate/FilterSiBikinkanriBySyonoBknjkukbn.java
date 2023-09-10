package yuyu.def.siharai.predicate;

import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;

import com.google.common.base.Predicate;

/**
 * 保険金給付金備金管理テーブルエンティティ用 Predicate<br/>
 * 保険金給付金備金管理テーブル．証券番号 ＝ I．証券番号 かつ
 * 保険金給付金備金管理テーブル．備金時効区分 ＝ ＜備金時効区分＞新備 かつ
 * （保険金給付金備金管理テーブル．備金例外区分 ＝ ＜備金例外区分＞ブランク または
 *   保険金給付金備金管理テーブル．備金例外区分 ＝ ＜備金例外区分＞備金追加）
 */
public class FilterSiBikinkanriBySyonoBknjkukbn implements Predicate<JT_SiBikinkanri> {

    String syono;

    public FilterSiBikinkanriBySyonoBknjkukbn(String pSyono) {
        super();
        syono = pSyono;
    }

    @Override
    public boolean apply(JT_SiBikinkanri pSiBikinkanri) {
        if (syono.equals(pSiBikinkanri.getSyono()) &&
            C_BknJkuKbn.SINBI.eq(pSiBikinkanri.getBknjkukbn()) &&
            (C_BknrigiKbn.BLNK.eq(pSiBikinkanri.getBknrigikbn()) ||
                C_BknrigiKbn.ADD.eq(pSiBikinkanri.getBknrigikbn()))) {
            return true;
        }
        return false;
    }
}