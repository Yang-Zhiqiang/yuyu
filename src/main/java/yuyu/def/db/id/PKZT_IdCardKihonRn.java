package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_IdCardKihonRn;
import yuyu.def.db.mapping.GenZT_IdCardKihonRn;
import yuyu.def.db.meta.GenQZT_IdCardKihonRn;
import yuyu.def.db.meta.QZT_IdCardKihonRn;

/**
 * ＩＤカードＦ基本テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IdCardKihonRn}</td><td colspan="3">ＩＤカードＦ基本テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnidkbn zrnidkbn}</td><td>（連携用）ＩＤ区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnidcd zrnidcd}</td><td>（連携用）ＩＤコード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8</td><td>（連携用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10</td><td>（連携用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntanmatusiyoukbn</td><td>（連携用）端末使用区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaccesskbn</td><td>（連携用）アクセス区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnidnyuuryokusyanm</td><td>（連携用）ＩＤ入力者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjiidnyuuryokusyanm</td><td>（連携用）漢字ＩＤ入力者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnidnyuuryokusyaseiymd</td><td>（連携用）ＩＤ入力者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnidnyuuryokusyanyuusyaymd</td><td>（連携用）ＩＤ入力者入社年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyozokusosikicd</td><td>（連携用）所属組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyozokusisyacd</td><td>（連携用）所属支社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyozokusibucd</td><td>（連携用）所属支部コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnidnyuuryokusyasikakucd</td><td>（連携用）ＩＤ入力者資格コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv2</td><td>（連携用）予備項目Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnidsdpsouhuhyouji</td><td>（連携用）ＩＤＳＤＰ送付表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x2</td><td>（連携用）予備項目Ｖ１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x3</td><td>（連携用）予備項目Ｖ１＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv2x2</td><td>（連携用）予備項目Ｖ２＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv2x3</td><td>（連携用）予備項目Ｖ２＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv26</td><td>（連携用）予備項目Ｖ２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x2</td><td>（連携用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnidcardsaisyuukousinymd</td><td>（連携用）ＩＤカード最終更新年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnidcardmukouymd</td><td>（連携用）ＩＤカード無効年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaikeitantousyakbn</td><td>（連携用）会計担当者区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyanaiyokintantousyakbn</td><td>（連携用）社内預金担当者区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjinjimynosyoukaihyj</td><td>（連携用）人事・マイナンバー照会可能表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrneisyokumynosyoukaihyj</td><td>（連携用）営職・マイナンバー照会可能表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhudousanmynosyoukaihyj</td><td>（連携用）不動産・マイナンバー照会可能表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkohomynosyoukaihyj</td><td>（連携用）個保・マイナンバー照会可能表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihomynosyoukaihyj</td><td>（連携用）企保・マイナンバー照会可能表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkikantantoukbn</td><td>（連携用）機関担当区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv32</td><td>（連携用）予備項目Ｖ３２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_IdCardKihonRn
 * @see     GenZT_IdCardKihonRn
 * @see     QZT_IdCardKihonRn
 * @see     GenQZT_IdCardKihonRn
 */
public class PKZT_IdCardKihonRn extends AbstractExDBPrimaryKey<ZT_IdCardKihonRn, PKZT_IdCardKihonRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_IdCardKihonRn() {
    }

    public PKZT_IdCardKihonRn(String pZrnidkbn, String pZrnidcd) {
        zrnidkbn = pZrnidkbn;
        zrnidcd = pZrnidcd;
    }

    @Transient
    @Override
    public Class<ZT_IdCardKihonRn> getEntityClass() {
        return ZT_IdCardKihonRn.class;
    }

    private String zrnidkbn;

    public String getZrnidkbn() {
        return zrnidkbn;
    }

    public void setZrnidkbn(String pZrnidkbn) {
        zrnidkbn = pZrnidkbn;
    }
    private String zrnidcd;

    public String getZrnidcd() {
        return zrnidcd;
    }

    public void setZrnidcd(String pZrnidcd) {
        zrnidcd = pZrnidcd;
    }

}