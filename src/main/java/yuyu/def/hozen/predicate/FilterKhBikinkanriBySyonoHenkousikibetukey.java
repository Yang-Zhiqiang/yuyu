package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;

import com.google.common.base.Predicate;

/**
 * 契約保全備金管理テーブルエンティティ用 Predicate<br/>
 * 契約保全備金管理テーブル．証券番号 ＝ I．証券番号 かつ
 * 契約保全備金管理テーブル．変更識別キー ＝ I．変更識別キー かつ
 * 契約保全備金管理テーブル．備金時効区分 ＝ ＜備金時効区分＞新備 かつ
 * （契約保全備金管理テーブル．備金例外区分 ＝ ＜備金例外区分＞ブランク または
 *   契約保全備金管理テーブル．備金例外区分 ＝ ＜備金例外区分＞備金追加）
 */
public class FilterKhBikinkanriBySyonoHenkousikibetukey implements Predicate<IT_KhBikinkanri> {

    String syono;
    String henkousikibetukey;

    public FilterKhBikinkanriBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {
        super();
        syono = pSyono;
        henkousikibetukey = pHenkousikibetukey;
    }

    @Override
    public boolean apply(IT_KhBikinkanri pKhBikinkanri) {
        if (syono.equals(pKhBikinkanri.getSyono()) && henkousikibetukey.equals(pKhBikinkanri.getHenkousikibetukey()) &&
                C_BknJkuKbn.SINBI.eq(pKhBikinkanri.getBknjkukbn()) &&
                (C_BknrigiKbn.BLNK.eq(pKhBikinkanri.getBknrigikbn()) ||
                        C_BknrigiKbn.ADD.eq(pKhBikinkanri.getBknrigikbn()))) {
            return true;
        }
        return false;
    }
}