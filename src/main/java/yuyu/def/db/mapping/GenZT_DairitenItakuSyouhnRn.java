package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_DairitenItakuSyouhnRn;
import yuyu.def.db.id.PKZT_DairitenItakuSyouhnRn;
import yuyu.def.db.meta.GenQZT_DairitenItakuSyouhnRn;
import yuyu.def.db.meta.QZT_DairitenItakuSyouhnRn;

/**
 * 代理店委託商品情報用連動Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DairitenItakuSyouhnRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenItakuSyouhnRn}</td><td colspan="3">代理店委託商品情報用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">{@link PKZT_DairitenItakuSyouhnRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtsyouhinsikibetukbnstr zrndrtsyouhinsikibetukbnstr}</td><td>（連携用）代理店商品識別区分（文字列）</td><td align="center">{@link PKZT_DairitenItakuSyouhnRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrthrkhouhoukbn zrndrthrkhouhoukbn}</td><td>（連携用）代理店払込方法区分</td><td align="center">{@link PKZT_DairitenItakuSyouhnRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtplannmkbn zrndrtplannmkbn}</td><td>（連携用）代理店プラン名区分</td><td align="center">{@link PKZT_DairitenItakuSyouhnRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakuhknhnbkaisiymd zrnitakuhknhnbkaisiymd}</td><td>（連携用）委託保険販売開始年月日</td><td align="center">{@link PKZT_DairitenItakuSyouhnRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakuhknhnbsyuuryouymd zrnitakuhknhnbsyuuryouymd}</td><td>（連携用）委託保険販売終了年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22 zrnyobiv22}</td><td>（連携用）予備項目Ｖ２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenItakuSyouhnRn
 * @see     PKZT_DairitenItakuSyouhnRn
 * @see     QZT_DairitenItakuSyouhnRn
 * @see     GenQZT_DairitenItakuSyouhnRn
 */
@MappedSuperclass
@Table(name=GenZT_DairitenItakuSyouhnRn.TABLE_NAME)
@IdClass(value=PKZT_DairitenItakuSyouhnRn.class)
public abstract class GenZT_DairitenItakuSyouhnRn extends AbstractExDBEntityForZDB<ZT_DairitenItakuSyouhnRn, PKZT_DairitenItakuSyouhnRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DairitenItakuSyouhnRn";
    public static final String ZRNDAIRITENCD            = "zrndairitencd";
    public static final String ZRNDRTSYOUHINSIKIBETUKBNSTR = "zrndrtsyouhinsikibetukbnstr";
    public static final String ZRNDRTHRKHOUHOUKBN       = "zrndrthrkhouhoukbn";
    public static final String ZRNDRTPLANNMKBN          = "zrndrtplannmkbn";
    public static final String ZRNITAKUHKNHNBKAISIYMD   = "zrnitakuhknhnbkaisiymd";
    public static final String ZRNITAKUHKNHNBSYUURYOUYMD = "zrnitakuhknhnbsyuuryouymd";
    public static final String ZRNYOBIV22               = "zrnyobiv22";

    private final PKZT_DairitenItakuSyouhnRn primaryKey;

    public GenZT_DairitenItakuSyouhnRn() {
        primaryKey = new PKZT_DairitenItakuSyouhnRn();
    }

    public GenZT_DairitenItakuSyouhnRn(
        String pZrndairitencd,
        String pZrndrtsyouhinsikibetukbnstr,
        String pZrndrthrkhouhoukbn,
        String pZrndrtplannmkbn,
        String pZrnitakuhknhnbkaisiymd
    ) {
        primaryKey = new PKZT_DairitenItakuSyouhnRn(
            pZrndairitencd,
            pZrndrtsyouhinsikibetukbnstr,
            pZrndrthrkhouhoukbn,
            pZrndrtplannmkbn,
            pZrnitakuhknhnbkaisiymd
        );
    }

    @Transient
    @Override
    public PKZT_DairitenItakuSyouhnRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DairitenItakuSyouhnRn> getMetaClass() {
        return QZT_DairitenItakuSyouhnRn.class;
    }

    @Id
    @Column(name=GenZT_DairitenItakuSyouhnRn.ZRNDAIRITENCD)
    public String getZrndairitencd() {
        return getPrimaryKey().getZrndairitencd();
    }

    public void setZrndairitencd(String pZrndairitencd) {
        getPrimaryKey().setZrndairitencd(pZrndairitencd);
    }

    @Id
    @Column(name=GenZT_DairitenItakuSyouhnRn.ZRNDRTSYOUHINSIKIBETUKBNSTR)
    public String getZrndrtsyouhinsikibetukbnstr() {
        return getPrimaryKey().getZrndrtsyouhinsikibetukbnstr();
    }

    public void setZrndrtsyouhinsikibetukbnstr(String pZrndrtsyouhinsikibetukbnstr) {
        getPrimaryKey().setZrndrtsyouhinsikibetukbnstr(pZrndrtsyouhinsikibetukbnstr);
    }

    @Id
    @Column(name=GenZT_DairitenItakuSyouhnRn.ZRNDRTHRKHOUHOUKBN)
    public String getZrndrthrkhouhoukbn() {
        return getPrimaryKey().getZrndrthrkhouhoukbn();
    }

    public void setZrndrthrkhouhoukbn(String pZrndrthrkhouhoukbn) {
        getPrimaryKey().setZrndrthrkhouhoukbn(pZrndrthrkhouhoukbn);
    }

    @Id
    @Column(name=GenZT_DairitenItakuSyouhnRn.ZRNDRTPLANNMKBN)
    public String getZrndrtplannmkbn() {
        return getPrimaryKey().getZrndrtplannmkbn();
    }

    public void setZrndrtplannmkbn(String pZrndrtplannmkbn) {
        getPrimaryKey().setZrndrtplannmkbn(pZrndrtplannmkbn);
    }

    @Id
    @Column(name=GenZT_DairitenItakuSyouhnRn.ZRNITAKUHKNHNBKAISIYMD)
    public String getZrnitakuhknhnbkaisiymd() {
        return getPrimaryKey().getZrnitakuhknhnbkaisiymd();
    }

    public void setZrnitakuhknhnbkaisiymd(String pZrnitakuhknhnbkaisiymd) {
        getPrimaryKey().setZrnitakuhknhnbkaisiymd(pZrnitakuhknhnbkaisiymd);
    }

    private String zrnitakuhknhnbsyuuryouymd;

    @Column(name=GenZT_DairitenItakuSyouhnRn.ZRNITAKUHKNHNBSYUURYOUYMD)
    public String getZrnitakuhknhnbsyuuryouymd() {
        return zrnitakuhknhnbsyuuryouymd;
    }

    public void setZrnitakuhknhnbsyuuryouymd(String pZrnitakuhknhnbsyuuryouymd) {
        zrnitakuhknhnbsyuuryouymd = pZrnitakuhknhnbsyuuryouymd;
    }

    private String zrnyobiv22;

    @Column(name=GenZT_DairitenItakuSyouhnRn.ZRNYOBIV22)
    public String getZrnyobiv22() {
        return zrnyobiv22;
    }

    public void setZrnyobiv22(String pZrnyobiv22) {
        zrnyobiv22 = pZrnyobiv22;
    }
}