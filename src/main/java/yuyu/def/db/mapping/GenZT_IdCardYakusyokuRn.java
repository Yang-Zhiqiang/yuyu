package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_IdCardYakusyokuRn;
import yuyu.def.db.id.PKZT_IdCardYakusyokuRn;
import yuyu.def.db.meta.GenQZT_IdCardYakusyokuRn;
import yuyu.def.db.meta.QZT_IdCardYakusyokuRn;

/**
 * ＩＤカードＦ役職テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_IdCardYakusyokuRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IdCardYakusyokuRn}</td><td colspan="3">ＩＤカードＦ役職テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnidkbn zrnidkbn}</td><td>（連携用）ＩＤ区分</td><td align="center">{@link PKZT_IdCardYakusyokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidcd zrnidcd}</td><td>（連携用）ＩＤコード</td><td align="center">{@link PKZT_IdCardYakusyokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakusyokuhatureiymd zrnyakusyokuhatureiymd}</td><td>（連携用）役職発令年月日</td><td align="center">{@link PKZT_IdCardYakusyokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakusyokuhatureino zrnyakusyokuhatureino}</td><td>（連携用）役職発令番号</td><td align="center">{@link PKZT_IdCardYakusyokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakusyokuhatureisosikicd zrnyakusyokuhatureisosikicd}</td><td>（連携用）役職発令組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakusyokucd zrnyakusyokucd}</td><td>（連携用）役職コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_IdCardYakusyokuRn
 * @see     PKZT_IdCardYakusyokuRn
 * @see     QZT_IdCardYakusyokuRn
 * @see     GenQZT_IdCardYakusyokuRn
 */
@MappedSuperclass
@Table(name=GenZT_IdCardYakusyokuRn.TABLE_NAME)
@IdClass(value=PKZT_IdCardYakusyokuRn.class)
public abstract class GenZT_IdCardYakusyokuRn extends AbstractExDBEntityForZDB<ZT_IdCardYakusyokuRn, PKZT_IdCardYakusyokuRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_IdCardYakusyokuRn";
    public static final String ZRNIDKBN                 = "zrnidkbn";
    public static final String ZRNIDCD                  = "zrnidcd";
    public static final String ZRNYAKUSYOKUHATUREIYMD   = "zrnyakusyokuhatureiymd";
    public static final String ZRNYAKUSYOKUHATUREINO    = "zrnyakusyokuhatureino";
    public static final String ZRNYAKUSYOKUHATUREISOSIKICD = "zrnyakusyokuhatureisosikicd";
    public static final String ZRNYAKUSYOKUCD           = "zrnyakusyokucd";

    private final PKZT_IdCardYakusyokuRn primaryKey;

    public GenZT_IdCardYakusyokuRn() {
        primaryKey = new PKZT_IdCardYakusyokuRn();
    }

    public GenZT_IdCardYakusyokuRn(
        String pZrnidkbn,
        String pZrnidcd,
        String pZrnyakusyokuhatureiymd,
        String pZrnyakusyokuhatureino
    ) {
        primaryKey = new PKZT_IdCardYakusyokuRn(
            pZrnidkbn,
            pZrnidcd,
            pZrnyakusyokuhatureiymd,
            pZrnyakusyokuhatureino
        );
    }

    @Transient
    @Override
    public PKZT_IdCardYakusyokuRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_IdCardYakusyokuRn> getMetaClass() {
        return QZT_IdCardYakusyokuRn.class;
    }

    @Id
    @Column(name=GenZT_IdCardYakusyokuRn.ZRNIDKBN)
    public String getZrnidkbn() {
        return getPrimaryKey().getZrnidkbn();
    }

    public void setZrnidkbn(String pZrnidkbn) {
        getPrimaryKey().setZrnidkbn(pZrnidkbn);
    }

    @Id
    @Column(name=GenZT_IdCardYakusyokuRn.ZRNIDCD)
    public String getZrnidcd() {
        return getPrimaryKey().getZrnidcd();
    }

    public void setZrnidcd(String pZrnidcd) {
        getPrimaryKey().setZrnidcd(pZrnidcd);
    }

    @Id
    @Column(name=GenZT_IdCardYakusyokuRn.ZRNYAKUSYOKUHATUREIYMD)
    public String getZrnyakusyokuhatureiymd() {
        return getPrimaryKey().getZrnyakusyokuhatureiymd();
    }

    public void setZrnyakusyokuhatureiymd(String pZrnyakusyokuhatureiymd) {
        getPrimaryKey().setZrnyakusyokuhatureiymd(pZrnyakusyokuhatureiymd);
    }

    @Id
    @Column(name=GenZT_IdCardYakusyokuRn.ZRNYAKUSYOKUHATUREINO)
    public String getZrnyakusyokuhatureino() {
        return getPrimaryKey().getZrnyakusyokuhatureino();
    }

    public void setZrnyakusyokuhatureino(String pZrnyakusyokuhatureino) {
        getPrimaryKey().setZrnyakusyokuhatureino(pZrnyakusyokuhatureino);
    }

    private String zrnyakusyokuhatureisosikicd;

    @Column(name=GenZT_IdCardYakusyokuRn.ZRNYAKUSYOKUHATUREISOSIKICD)
    public String getZrnyakusyokuhatureisosikicd() {
        return zrnyakusyokuhatureisosikicd;
    }

    public void setZrnyakusyokuhatureisosikicd(String pZrnyakusyokuhatureisosikicd) {
        zrnyakusyokuhatureisosikicd = pZrnyakusyokuhatureisosikicd;
    }

    private String zrnyakusyokucd;

    @Column(name=GenZT_IdCardYakusyokuRn.ZRNYAKUSYOKUCD)
    public String getZrnyakusyokucd() {
        return zrnyakusyokucd;
    }

    public void setZrnyakusyokucd(String pZrnyakusyokucd) {
        zrnyakusyokucd = pZrnyakusyokucd;
    }
}