package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_AcsAdrNmRn;
import yuyu.def.db.mapping.GenZT_AcsAdrNmRn;
import yuyu.def.db.meta.GenQZT_AcsAdrNmRn;
import yuyu.def.db.meta.QZT_AcsAdrNmRn;

/**
 * ＡＣＳ住所名ＤＢ用Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AcsAdrNmRn}</td><td colspan="3">ＡＣＳ住所名ＤＢ用Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkihontikucd zrnkihontikucd}</td><td>（連携用）基本地区コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihontikucdsyoumetukbn</td><td>（連携用）基本地区コード消滅理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjadr</td><td>（連携用）漢字住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjtodouhukennmketasuu</td><td>（連携用）漢字都道府県名桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjsikugunnmketasuu</td><td>（連携用）漢字市区郡名桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjsikutyousonnmketasuu</td><td>（連携用）漢字市区町村名桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjtyousonnmketasuu</td><td>（連携用）漢字町村名桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkyoutotuusyounmketasuu</td><td>（連携用）漢字京都市内通称町名桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjadrketasuu</td><td>（連携用）漢字住所桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknadr</td><td>（連携用）カナ住所</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkntodouhukennmketasuu</td><td>（連携用）カナ都道府県名桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknsikugunnmketasuu</td><td>（連携用）カナ市区郡名桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknsikutyousonnmketasuu</td><td>（連携用）カナ市区町村名桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkntyousonnmketasuu</td><td>（連携用）カナ町村名桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknkyoutotuusyounmketasuu</td><td>（連携用）カナ京都市内通称町名桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknadrketasuu</td><td>（連携用）カナ住所桁数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntodouhukencd</td><td>（連携用）都道府県コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngyouseikukakucd</td><td>（連携用）行政区画コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikoumaekihontikucd</td><td>（連携用）移行前基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnewynohyouji</td><td>（連携用）新郵便番号表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv14</td><td>（連携用）予備項目Ｖ１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_AcsAdrNmRn
 * @see     GenZT_AcsAdrNmRn
 * @see     QZT_AcsAdrNmRn
 * @see     GenQZT_AcsAdrNmRn
 */
public class PKZT_AcsAdrNmRn extends AbstractExDBPrimaryKey<ZT_AcsAdrNmRn, PKZT_AcsAdrNmRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_AcsAdrNmRn() {
    }

    public PKZT_AcsAdrNmRn(String pZrnkihontikucd) {
        zrnkihontikucd = pZrnkihontikucd;
    }

    @Transient
    @Override
    public Class<ZT_AcsAdrNmRn> getEntityClass() {
        return ZT_AcsAdrNmRn.class;
    }

    private String zrnkihontikucd;

    public String getZrnkihontikucd() {
        return zrnkihontikucd;
    }

    public void setZrnkihontikucd(String pZrnkihontikucd) {
        zrnkihontikucd = pZrnkihontikucd;
    }

}