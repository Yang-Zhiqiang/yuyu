package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.id.PKZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.meta.GenQZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.meta.QZT_GinkouMdhnMisyuuInfoFRn;

/**
 * 銀行窓販未収情報Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_GinkouMdhnMisyuuInfoFRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GinkouMdhnMisyuuInfoFRn}</td><td colspan="3">銀行窓販未収情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">{@link PKZT_GinkouMdhnMisyuuInfoFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv63 zrnyobiv63}</td><td>（連携用）予備項目Ｖ６３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakbn zrndatakbn}</td><td>（連携用）データ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatasakuseiymd zrndatasakuseiymd}</td><td>（連携用）データ作成日</td><td align="center">{@link PKZT_GinkouMdhnMisyuuInfoFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkaisyacd zrnhknkaisyacd}</td><td>（連携用）保険会社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruicd zrnhknsyuruicd}</td><td>（連携用）保険種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyonosyuban zrnsyonosyuban}</td><td>（連携用）証券番号主番</td><td align="center">{@link PKZT_GinkouMdhnMisyuuInfoFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyonoedaban zrnsyonoedaban}</td><td>（連携用）証券番号枝番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyuutatekaekbn zrnmisyuutatekaekbn}</td><td>（連携用）未収立替区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyuutatekaeym zrnmisyuutatekaeym}</td><td>（連携用）未収立替発生年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyuukg zrnmisyuukg}</td><td>（連携用）未収金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnkaisuu zrnbnkaisuu}</td><td>（連携用）分割回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyuujiyuu zrnmisyuujiyuu}</td><td>（連携用）未収事由</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikaidatakousinymd zrnjikaidatakousinymd}</td><td>（連携用）次回データ更新日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikbn zrnikkatubaraikbn}</td><td>（連携用）一括払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikaisuu zrnikkatubaraikaisuu}</td><td>（連携用）一括払回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv28 zrnyobiv28}</td><td>（連携用）予備項目Ｖ２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkosyaareav40 zrnkosyaareav40}</td><td>（連携用）個社領域Ｖ４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_GinkouMdhnMisyuuInfoFRn
 * @see     PKZT_GinkouMdhnMisyuuInfoFRn
 * @see     QZT_GinkouMdhnMisyuuInfoFRn
 * @see     GenQZT_GinkouMdhnMisyuuInfoFRn
 */
@MappedSuperclass
@Table(name=GenZT_GinkouMdhnMisyuuInfoFRn.TABLE_NAME)
@IdClass(value=PKZT_GinkouMdhnMisyuuInfoFRn.class)
public abstract class GenZT_GinkouMdhnMisyuuInfoFRn extends AbstractExDBEntityForZDB<ZT_GinkouMdhnMisyuuInfoFRn, PKZT_GinkouMdhnMisyuuInfoFRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_GinkouMdhnMisyuuInfoFRn";
    public static final String ZRNBSYDRTENCD            = "zrnbsydrtencd";
    public static final String ZRNYOBIV63               = "zrnyobiv63";
    public static final String ZRNDATAKBN               = "zrndatakbn";
    public static final String ZRNDATASAKUSEIYMD        = "zrndatasakuseiymd";
    public static final String ZRNHKNKAISYACD           = "zrnhknkaisyacd";
    public static final String ZRNHKNSYURUICD           = "zrnhknsyuruicd";
    public static final String ZRNSYONOSYUBAN           = "zrnsyonosyuban";
    public static final String ZRNSYONOEDABAN           = "zrnsyonoedaban";
    public static final String ZRNMISYUUTATEKAEKBN      = "zrnmisyuutatekaekbn";
    public static final String ZRNMISYUUTATEKAEYM       = "zrnmisyuutatekaeym";
    public static final String ZRNMISYUUKG              = "zrnmisyuukg";
    public static final String ZRNBNKAISUU              = "zrnbnkaisuu";
    public static final String ZRNMISYUUJIYUU           = "zrnmisyuujiyuu";
    public static final String ZRNJIKAIDATAKOUSINYMD    = "zrnjikaidatakousinymd";
    public static final String ZRNIKKATUBARAIKBN        = "zrnikkatubaraikbn";
    public static final String ZRNIKKATUBARAIKAISUU     = "zrnikkatubaraikaisuu";
    public static final String ZRNYOBIV28               = "zrnyobiv28";
    public static final String ZRNKOSYAAREAV40          = "zrnkosyaareav40";

    private final PKZT_GinkouMdhnMisyuuInfoFRn primaryKey;

    public GenZT_GinkouMdhnMisyuuInfoFRn() {
        primaryKey = new PKZT_GinkouMdhnMisyuuInfoFRn();
    }

    public GenZT_GinkouMdhnMisyuuInfoFRn(
        String pZrnbsydrtencd,
        String pZrndatasakuseiymd,
        String pZrnsyonosyuban
    ) {
        primaryKey = new PKZT_GinkouMdhnMisyuuInfoFRn(
            pZrnbsydrtencd,
            pZrndatasakuseiymd,
            pZrnsyonosyuban
        );
    }

    @Transient
    @Override
    public PKZT_GinkouMdhnMisyuuInfoFRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_GinkouMdhnMisyuuInfoFRn> getMetaClass() {
        return QZT_GinkouMdhnMisyuuInfoFRn.class;
    }

    @Id
    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNBSYDRTENCD)
    public String getZrnbsydrtencd() {
        return getPrimaryKey().getZrnbsydrtencd();
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        getPrimaryKey().setZrnbsydrtencd(pZrnbsydrtencd);
    }

    private String zrnyobiv63;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNYOBIV63)
    public String getZrnyobiv63() {
        return zrnyobiv63;
    }

    public void setZrnyobiv63(String pZrnyobiv63) {
        zrnyobiv63 = pZrnyobiv63;
    }

    private String zrndatakbn;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNDATAKBN)
    public String getZrndatakbn() {
        return zrndatakbn;
    }

    public void setZrndatakbn(String pZrndatakbn) {
        zrndatakbn = pZrndatakbn;
    }

    @Id
    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNDATASAKUSEIYMD)
    public String getZrndatasakuseiymd() {
        return getPrimaryKey().getZrndatasakuseiymd();
    }

    public void setZrndatasakuseiymd(String pZrndatasakuseiymd) {
        getPrimaryKey().setZrndatasakuseiymd(pZrndatasakuseiymd);
    }

    private String zrnhknkaisyacd;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNHKNKAISYACD)
    public String getZrnhknkaisyacd() {
        return zrnhknkaisyacd;
    }

    public void setZrnhknkaisyacd(String pZrnhknkaisyacd) {
        zrnhknkaisyacd = pZrnhknkaisyacd;
    }

    private String zrnhknsyuruicd;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNHKNSYURUICD)
    public String getZrnhknsyuruicd() {
        return zrnhknsyuruicd;
    }

    public void setZrnhknsyuruicd(String pZrnhknsyuruicd) {
        zrnhknsyuruicd = pZrnhknsyuruicd;
    }

    @Id
    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNSYONOSYUBAN)
    public String getZrnsyonosyuban() {
        return getPrimaryKey().getZrnsyonosyuban();
    }

    public void setZrnsyonosyuban(String pZrnsyonosyuban) {
        getPrimaryKey().setZrnsyonosyuban(pZrnsyonosyuban);
    }

    private String zrnsyonoedaban;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNSYONOEDABAN)
    public String getZrnsyonoedaban() {
        return zrnsyonoedaban;
    }

    public void setZrnsyonoedaban(String pZrnsyonoedaban) {
        zrnsyonoedaban = pZrnsyonoedaban;
    }

    private String zrnmisyuutatekaekbn;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNMISYUUTATEKAEKBN)
    public String getZrnmisyuutatekaekbn() {
        return zrnmisyuutatekaekbn;
    }

    public void setZrnmisyuutatekaekbn(String pZrnmisyuutatekaekbn) {
        zrnmisyuutatekaekbn = pZrnmisyuutatekaekbn;
    }

    private String zrnmisyuutatekaeym;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNMISYUUTATEKAEYM)
    public String getZrnmisyuutatekaeym() {
        return zrnmisyuutatekaeym;
    }

    public void setZrnmisyuutatekaeym(String pZrnmisyuutatekaeym) {
        zrnmisyuutatekaeym = pZrnmisyuutatekaeym;
    }

    private String zrnmisyuukg;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNMISYUUKG)
    public String getZrnmisyuukg() {
        return zrnmisyuukg;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnmisyuukg(String pZrnmisyuukg) {
        zrnmisyuukg = pZrnmisyuukg;
    }

    private String zrnbnkaisuu;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNBNKAISUU)
    public String getZrnbnkaisuu() {
        return zrnbnkaisuu;
    }

    public void setZrnbnkaisuu(String pZrnbnkaisuu) {
        zrnbnkaisuu = pZrnbnkaisuu;
    }

    private String zrnmisyuujiyuu;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNMISYUUJIYUU)
    public String getZrnmisyuujiyuu() {
        return zrnmisyuujiyuu;
    }

    public void setZrnmisyuujiyuu(String pZrnmisyuujiyuu) {
        zrnmisyuujiyuu = pZrnmisyuujiyuu;
    }

    private String zrnjikaidatakousinymd;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNJIKAIDATAKOUSINYMD)
    public String getZrnjikaidatakousinymd() {
        return zrnjikaidatakousinymd;
    }

    public void setZrnjikaidatakousinymd(String pZrnjikaidatakousinymd) {
        zrnjikaidatakousinymd = pZrnjikaidatakousinymd;
    }

    private String zrnikkatubaraikbn;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNIKKATUBARAIKBN)
    public String getZrnikkatubaraikbn() {
        return zrnikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnikkatubaraikbn(String pZrnikkatubaraikbn) {
        zrnikkatubaraikbn = pZrnikkatubaraikbn;
    }

    private String zrnikkatubaraikaisuu;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNIKKATUBARAIKAISUU)
    public String getZrnikkatubaraikaisuu() {
        return zrnikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnikkatubaraikaisuu(String pZrnikkatubaraikaisuu) {
        zrnikkatubaraikaisuu = pZrnikkatubaraikaisuu;
    }

    private String zrnyobiv28;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNYOBIV28)
    public String getZrnyobiv28() {
        return zrnyobiv28;
    }

    public void setZrnyobiv28(String pZrnyobiv28) {
        zrnyobiv28 = pZrnyobiv28;
    }

    private String zrnkosyaareav40;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFRn.ZRNKOSYAAREAV40)
    public String getZrnkosyaareav40() {
        return zrnkosyaareav40;
    }

    public void setZrnkosyaareav40(String pZrnkosyaareav40) {
        zrnkosyaareav40 = pZrnkosyaareav40;
    }
}