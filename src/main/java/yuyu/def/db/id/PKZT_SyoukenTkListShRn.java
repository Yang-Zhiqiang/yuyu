package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyoukenTkListShRn;
import yuyu.def.db.mapping.GenZT_SyoukenTkListShRn;
import yuyu.def.db.meta.GenQZT_SyoukenTkListShRn;
import yuyu.def.db.meta.QZT_SyoukenTkListShRn;

/**
 * 証券特殊処理明細リスト（再発行）Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoukenTkListShRn}</td><td colspan="3">証券特殊処理明細リスト（再発行）Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsyoruicd</td><td>（連携用）書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn</td><td>（連携用）発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatesakitantnm</td><td>（連携用）宛先担当室名(組織名)</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhozonkkn</td><td>（連携用）保存期間</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntyouhyouymdwa</td><td>（連携用）帳票作成日（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv26</td><td>（連携用）予備項目Ｖ２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj</td><td>（連携用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj</td><td>（連携用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyorinm</td><td>（連携用）処理名(機能名)</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyorisyouninsyacd</td><td>（連携用）処理承認者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorisyouninsyanm</td><td>（連携用）処理承認者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo1</td><td>（連携用）事後作業内容１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo2</td><td>（連携用）事後作業内容２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo3</td><td>（連携用）事後作業内容３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo4</td><td>（連携用）事後作業内容４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo5</td><td>（連携用）事後作業内容５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo6</td><td>（連携用）事後作業内容６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo7</td><td>（連携用）事後作業内容７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo8</td><td>（連携用）事後作業内容８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo9</td><td>（連携用）事後作業内容９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo10</td><td>（連携用）事後作業内容１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo11</td><td>（連携用）事後作業内容１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo12</td><td>（連携用）事後作業内容１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo13</td><td>（連携用）事後作業内容１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo14</td><td>（連携用）事後作業内容１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo15</td><td>（連携用）事後作業内容１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjigosagyounaiyo16</td><td>（連携用）事後作業内容１６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv31</td><td>（連携用）予備項目Ｖ３１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoukenTkListShRn
 * @see     GenZT_SyoukenTkListShRn
 * @see     QZT_SyoukenTkListShRn
 * @see     GenQZT_SyoukenTkListShRn
 */
public class PKZT_SyoukenTkListShRn extends AbstractExDBPrimaryKey<ZT_SyoukenTkListShRn, PKZT_SyoukenTkListShRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyoukenTkListShRn() {
    }

    public PKZT_SyoukenTkListShRn(String pZrntyouhyouymd, String pZrnsyono) {
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_SyoukenTkListShRn> getEntityClass() {
        return ZT_SyoukenTkListShRn.class;
    }

    private String zrntyouhyouymd;

    public String getZrntyouhyouymd() {
        return zrntyouhyouymd;
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        zrntyouhyouymd = pZrntyouhyouymd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}