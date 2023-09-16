package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_IdCardYakusyokuRn;
import yuyu.def.db.mapping.GenZT_IdCardYakusyokuRn;
import yuyu.def.db.meta.GenQZT_IdCardYakusyokuRn;
import yuyu.def.db.meta.QZT_IdCardYakusyokuRn;

/**
 * ＩＤカードＦ役職テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IdCardYakusyokuRn}</td><td colspan="3">ＩＤカードＦ役職テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnidkbn zrnidkbn}</td><td>（連携用）ＩＤ区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnidcd zrnidcd}</td><td>（連携用）ＩＤコード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnyakusyokuhatureiymd zrnyakusyokuhatureiymd}</td><td>（連携用）役職発令年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnyakusyokuhatureino zrnyakusyokuhatureino}</td><td>（連携用）役職発令番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyakusyokuhatureisosikicd</td><td>（連携用）役職発令組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyakusyokucd</td><td>（連携用）役職コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_IdCardYakusyokuRn
 * @see     GenZT_IdCardYakusyokuRn
 * @see     QZT_IdCardYakusyokuRn
 * @see     GenQZT_IdCardYakusyokuRn
 */
public class PKZT_IdCardYakusyokuRn extends AbstractExDBPrimaryKey<ZT_IdCardYakusyokuRn, PKZT_IdCardYakusyokuRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_IdCardYakusyokuRn() {
    }

    public PKZT_IdCardYakusyokuRn(
        String pZrnidkbn,
        String pZrnidcd,
        String pZrnyakusyokuhatureiymd,
        String pZrnyakusyokuhatureino
    ) {
        zrnidkbn = pZrnidkbn;
        zrnidcd = pZrnidcd;
        zrnyakusyokuhatureiymd = pZrnyakusyokuhatureiymd;
        zrnyakusyokuhatureino = pZrnyakusyokuhatureino;
    }

    @Transient
    @Override
    public Class<ZT_IdCardYakusyokuRn> getEntityClass() {
        return ZT_IdCardYakusyokuRn.class;
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
    private String zrnyakusyokuhatureiymd;

    public String getZrnyakusyokuhatureiymd() {
        return zrnyakusyokuhatureiymd;
    }

    public void setZrnyakusyokuhatureiymd(String pZrnyakusyokuhatureiymd) {
        zrnyakusyokuhatureiymd = pZrnyakusyokuhatureiymd;
    }
    private String zrnyakusyokuhatureino;

    public String getZrnyakusyokuhatureino() {
        return zrnyakusyokuhatureino;
    }

    public void setZrnyakusyokuhatureino(String pZrnyakusyokuhatureino) {
        zrnyakusyokuhatureino = pZrnyakusyokuhatureino;
    }

}