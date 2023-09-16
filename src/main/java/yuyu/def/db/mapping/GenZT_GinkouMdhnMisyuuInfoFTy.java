package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.id.PKZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.meta.GenQZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.meta.QZT_GinkouMdhnMisyuuInfoFTy;

/**
 * 銀行窓販未収情報Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_GinkouMdhnMisyuuInfoFTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GinkouMdhnMisyuuInfoFTy}</td><td colspan="3">銀行窓販未収情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">{@link PKZT_GinkouMdhnMisyuuInfoFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv63 ztyyobiv63}</td><td>（中継用）予備項目Ｖ６３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakbn ztydatakbn}</td><td>（中継用）データ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatasakuseiymd ztydatasakuseiymd}</td><td>（中継用）データ作成日</td><td align="center">{@link PKZT_GinkouMdhnMisyuuInfoFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkaisyacd ztyhknkaisyacd}</td><td>（中継用）保険会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruicd ztyhknsyuruicd}</td><td>（中継用）保険種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyonosyuban ztysyonosyuban}</td><td>（中継用）証券番号主番</td><td align="center">{@link PKZT_GinkouMdhnMisyuuInfoFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyonoedaban ztysyonoedaban}</td><td>（中継用）証券番号枝番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyuutatekaekbn ztymisyuutatekaekbn}</td><td>（中継用）未収立替区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyuutatekaeym ztymisyuutatekaeym}</td><td>（中継用）未収立替発生年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyuukg ztymisyuukg}</td><td>（中継用）未収金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnkaisuu ztybnkaisuu}</td><td>（中継用）分割回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyuujiyuu ztymisyuujiyuu}</td><td>（中継用）未収事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaidatakousinymd ztyjikaidatakousinymd}</td><td>（中継用）次回データ更新日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikbn ztyikkatubaraikbn}</td><td>（中継用）一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikaisuu ztyikkatubaraikaisuu}</td><td>（中継用）一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv28 ztyyobiv28}</td><td>（中継用）予備項目Ｖ２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykosyaareav40 ztykosyaareav40}</td><td>（中継用）個社領域Ｖ４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_GinkouMdhnMisyuuInfoFTy
 * @see     PKZT_GinkouMdhnMisyuuInfoFTy
 * @see     QZT_GinkouMdhnMisyuuInfoFTy
 * @see     GenQZT_GinkouMdhnMisyuuInfoFTy
 */
@MappedSuperclass
@Table(name=GenZT_GinkouMdhnMisyuuInfoFTy.TABLE_NAME)
@IdClass(value=PKZT_GinkouMdhnMisyuuInfoFTy.class)
public abstract class GenZT_GinkouMdhnMisyuuInfoFTy extends AbstractExDBEntity<ZT_GinkouMdhnMisyuuInfoFTy, PKZT_GinkouMdhnMisyuuInfoFTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_GinkouMdhnMisyuuInfoFTy";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYYOBIV63               = "ztyyobiv63";
    public static final String ZTYDATAKBN               = "ztydatakbn";
    public static final String ZTYDATASAKUSEIYMD        = "ztydatasakuseiymd";
    public static final String ZTYHKNKAISYACD           = "ztyhknkaisyacd";
    public static final String ZTYHKNSYURUICD           = "ztyhknsyuruicd";
    public static final String ZTYSYONOSYUBAN           = "ztysyonosyuban";
    public static final String ZTYSYONOEDABAN           = "ztysyonoedaban";
    public static final String ZTYMISYUUTATEKAEKBN      = "ztymisyuutatekaekbn";
    public static final String ZTYMISYUUTATEKAEYM       = "ztymisyuutatekaeym";
    public static final String ZTYMISYUUKG              = "ztymisyuukg";
    public static final String ZTYBNKAISUU              = "ztybnkaisuu";
    public static final String ZTYMISYUUJIYUU           = "ztymisyuujiyuu";
    public static final String ZTYJIKAIDATAKOUSINYMD    = "ztyjikaidatakousinymd";
    public static final String ZTYIKKATUBARAIKBN        = "ztyikkatubaraikbn";
    public static final String ZTYIKKATUBARAIKAISUU     = "ztyikkatubaraikaisuu";
    public static final String ZTYYOBIV28               = "ztyyobiv28";
    public static final String ZTYKOSYAAREAV40          = "ztykosyaareav40";

    private final PKZT_GinkouMdhnMisyuuInfoFTy primaryKey;

    public GenZT_GinkouMdhnMisyuuInfoFTy() {
        primaryKey = new PKZT_GinkouMdhnMisyuuInfoFTy();
    }

    public GenZT_GinkouMdhnMisyuuInfoFTy(
        String pZtybsydrtencd,
        String pZtydatasakuseiymd,
        String pZtysyonosyuban
    ) {
        primaryKey = new PKZT_GinkouMdhnMisyuuInfoFTy(
            pZtybsydrtencd,
            pZtydatasakuseiymd,
            pZtysyonosyuban
        );
    }

    @Transient
    @Override
    public PKZT_GinkouMdhnMisyuuInfoFTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_GinkouMdhnMisyuuInfoFTy> getMetaClass() {
        return QZT_GinkouMdhnMisyuuInfoFTy.class;
    }

    @Id
    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return getPrimaryKey().getZtybsydrtencd();
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        getPrimaryKey().setZtybsydrtencd(pZtybsydrtencd);
    }

    private String ztyyobiv63;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYYOBIV63)
    public String getZtyyobiv63() {
        return ztyyobiv63;
    }

    public void setZtyyobiv63(String pZtyyobiv63) {
        ztyyobiv63 = pZtyyobiv63;
    }

    private String ztydatakbn;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYDATAKBN)
    public String getZtydatakbn() {
        return ztydatakbn;
    }

    public void setZtydatakbn(String pZtydatakbn) {
        ztydatakbn = pZtydatakbn;
    }

    @Id
    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYDATASAKUSEIYMD)
    public String getZtydatasakuseiymd() {
        return getPrimaryKey().getZtydatasakuseiymd();
    }

    public void setZtydatasakuseiymd(String pZtydatasakuseiymd) {
        getPrimaryKey().setZtydatasakuseiymd(pZtydatasakuseiymd);
    }

    private String ztyhknkaisyacd;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYHKNKAISYACD)
    public String getZtyhknkaisyacd() {
        return ztyhknkaisyacd;
    }

    public void setZtyhknkaisyacd(String pZtyhknkaisyacd) {
        ztyhknkaisyacd = pZtyhknkaisyacd;
    }

    private String ztyhknsyuruicd;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYHKNSYURUICD)
    public String getZtyhknsyuruicd() {
        return ztyhknsyuruicd;
    }

    public void setZtyhknsyuruicd(String pZtyhknsyuruicd) {
        ztyhknsyuruicd = pZtyhknsyuruicd;
    }

    @Id
    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYSYONOSYUBAN)
    public String getZtysyonosyuban() {
        return getPrimaryKey().getZtysyonosyuban();
    }

    public void setZtysyonosyuban(String pZtysyonosyuban) {
        getPrimaryKey().setZtysyonosyuban(pZtysyonosyuban);
    }

    private String ztysyonoedaban;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYSYONOEDABAN)
    public String getZtysyonoedaban() {
        return ztysyonoedaban;
    }

    public void setZtysyonoedaban(String pZtysyonoedaban) {
        ztysyonoedaban = pZtysyonoedaban;
    }

    private String ztymisyuutatekaekbn;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYMISYUUTATEKAEKBN)
    public String getZtymisyuutatekaekbn() {
        return ztymisyuutatekaekbn;
    }

    public void setZtymisyuutatekaekbn(String pZtymisyuutatekaekbn) {
        ztymisyuutatekaekbn = pZtymisyuutatekaekbn;
    }

    private String ztymisyuutatekaeym;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYMISYUUTATEKAEYM)
    public String getZtymisyuutatekaeym() {
        return ztymisyuutatekaeym;
    }

    public void setZtymisyuutatekaeym(String pZtymisyuutatekaeym) {
        ztymisyuutatekaeym = pZtymisyuutatekaeym;
    }

    private String ztymisyuukg;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYMISYUUKG)
    public String getZtymisyuukg() {
        return ztymisyuukg;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZtymisyuukg(String pZtymisyuukg) {
        ztymisyuukg = pZtymisyuukg;
    }

    private String ztybnkaisuu;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYBNKAISUU)
    public String getZtybnkaisuu() {
        return ztybnkaisuu;
    }

    public void setZtybnkaisuu(String pZtybnkaisuu) {
        ztybnkaisuu = pZtybnkaisuu;
    }

    private String ztymisyuujiyuu;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYMISYUUJIYUU)
    public String getZtymisyuujiyuu() {
        return ztymisyuujiyuu;
    }

    public void setZtymisyuujiyuu(String pZtymisyuujiyuu) {
        ztymisyuujiyuu = pZtymisyuujiyuu;
    }

    private String ztyjikaidatakousinymd;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYJIKAIDATAKOUSINYMD)
    public String getZtyjikaidatakousinymd() {
        return ztyjikaidatakousinymd;
    }

    public void setZtyjikaidatakousinymd(String pZtyjikaidatakousinymd) {
        ztyjikaidatakousinymd = pZtyjikaidatakousinymd;
    }

    private String ztyikkatubaraikbn;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYIKKATUBARAIKBN)
    public String getZtyikkatubaraikbn() {
        return ztyikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyikkatubaraikbn(String pZtyikkatubaraikbn) {
        ztyikkatubaraikbn = pZtyikkatubaraikbn;
    }

    private String ztyikkatubaraikaisuu;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYIKKATUBARAIKAISUU)
    public String getZtyikkatubaraikaisuu() {
        return ztyikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyikkatubaraikaisuu(String pZtyikkatubaraikaisuu) {
        ztyikkatubaraikaisuu = pZtyikkatubaraikaisuu;
    }

    private String ztyyobiv28;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYYOBIV28)
    public String getZtyyobiv28() {
        return ztyyobiv28;
    }

    public void setZtyyobiv28(String pZtyyobiv28) {
        ztyyobiv28 = pZtyyobiv28;
    }

    private String ztykosyaareav40;

    @Column(name=GenZT_GinkouMdhnMisyuuInfoFTy.ZTYKOSYAAREAV40)
    public String getZtykosyaareav40() {
        return ztykosyaareav40;
    }

    public void setZtykosyaareav40(String pZtykosyaareav40) {
        ztykosyaareav40 = pZtykosyaareav40;
    }
}