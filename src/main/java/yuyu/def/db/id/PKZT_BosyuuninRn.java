package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_BosyuuninRn;
import yuyu.def.db.mapping.GenZT_BosyuuninRn;
import yuyu.def.db.meta.GenQZT_BosyuuninRn;
import yuyu.def.db.meta.QZT_BosyuuninRn;

/**
 * 募集人ＰＲＴ用連動Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_BosyuuninRn}</td><td colspan="3">募集人ＰＲＴ用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuuninnm</td><td>（連携用）募集人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjibosyuuninnm</td><td>（連携用）漢字募集人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnitakuymd</td><td>（連携用）委託年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitencd1</td><td>（連携用）代理店コード（１）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitencd2</td><td>（連携用）代理店コード（２）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitencd3</td><td>（連携用）代理店コード（３）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkanrisskcd1</td><td>（連携用）代理店管理組織コード（１）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkanrisskcd2</td><td>（連携用）代理店管理組織コード（２）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkanrisskcd3</td><td>（連携用）代理店管理組織コード（３）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuukbn</td><td>（連携用）募集人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunintourokuymd</td><td>（連携用）募集人登録年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuuninkahikbn</td><td>（連携用）募集可否区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuuningyouhaiymd</td><td>（連携用）募集人業廃年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhengakutourokuymd</td><td>（連携用）変額保険資格登録年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhengakumassyouymd</td><td>（連携用）変額保険資格登録抹消年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuuseiymd</td><td>（連携用）募集人生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitakukaiyakuymd</td><td>（連携用）委託解約日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndaihyoubosyuunincd</td><td>（連携用）代表募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuutourokuno</td><td>（連携用）募集人登録番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv5</td><td>（連携用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_BosyuuninRn
 * @see     GenZT_BosyuuninRn
 * @see     QZT_BosyuuninRn
 * @see     GenQZT_BosyuuninRn
 */
public class PKZT_BosyuuninRn extends AbstractExDBPrimaryKey<ZT_BosyuuninRn, PKZT_BosyuuninRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_BosyuuninRn() {
    }

    public PKZT_BosyuuninRn(String pZrnbosyuunincd) {
        zrnbosyuunincd = pZrnbosyuunincd;
    }

    @Transient
    @Override
    public Class<ZT_BosyuuninRn> getEntityClass() {
        return ZT_BosyuuninRn.class;
    }

    private String zrnbosyuunincd;

    public String getZrnbosyuunincd() {
        return zrnbosyuunincd;
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        zrnbosyuunincd = pZrnbosyuunincd;
    }

}