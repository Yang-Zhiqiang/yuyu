package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailTy;
import yuyu.def.db.id.PKZT_DrtenKykIdouDetailTy;
import yuyu.def.db.meta.GenQZT_DrtenKykIdouDetailTy;
import yuyu.def.db.meta.QZT_DrtenKykIdouDetailTy;

/**
 * 代理店契約異動明細テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DrtenKykIdouDetailTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenKykIdouDetailTy}</td><td colspan="3">代理店契約異動明細テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtykinyuukikancd ztykinyuukikancd}</td><td>（中継用）金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykinyuukikansitencd ztykinyuukikansitencd}</td><td>（中継用）金融機関支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">{@link PKZT_DrtenKykIdouDetailTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunincd ztybosyuunincd}</td><td>（中継用）募集人コード</td><td align="center">{@link PKZT_DrtenKykIdouDetailTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_DrtenKykIdouDetailTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidouhasseiymd ztyidouhasseiymd}</td><td>（中継用）異動発生年月日</td><td align="center">{@link PKZT_DrtenKykIdouDetailTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfksnctrlkh ztykykmfksnctrlkh}</td><td>（中継用）契約ＭＦ更新ＣＴＲ（保全）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidoukbn ztyidoukbn}</td><td>（中継用）異動区分</td><td align="center">{@link PKZT_DrtenKykIdouDetailTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkikbn ztykydatkikbn}</td><td>（中継用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym ztyjikaipjyuutouym}</td><td>（中継用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyanniskcd ztyanniskcd}</td><td>（中継用）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntcd ztydntcd}</td><td>（中継用）団体コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikomip ztyharaikomip}</td><td>（中継用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykjsyagaihknnm ztykjsyagaihknnm}</td><td>（中継用）漢字社外向け保険名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytelno ztytelno}</td><td>（中継用）電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhensyuubosyuudrtennm ztyhensyuubosyuudrtennm}</td><td>（中継用）編集後漢字募集代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkjdirtnkykido ztykyknmkjdirtnkykido}</td><td>（中継用）契約者名（漢字）（代理店契約異動明細）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjdntnm ztykjdntnm}</td><td>（中継用）漢字団体名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaebankcd ztykzhurikaebankcd}</td><td>（中継用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaesitencd ztykzhurikaesitencd}</td><td>（中継用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeyokinkbn ztykzhurikaeyokinkbn}</td><td>（中継用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaekouzano ztykzhurikaekouzano}</td><td>（中継用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyoyabosyuudairitencd ztyoyabosyuudairitencd}</td><td>（中継用）親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtenkanrisosikicd ztybsydrtenkanrisosikicd}</td><td>（中継用）募集代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuudairitengyousyukbn ztybosyuudairitengyousyukbn}</td><td>（中継用）募集代理店業種区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuudrtennmkj ztybosyuudrtennmkj}</td><td>（中継用）募集代理店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydoujitusyoricount ztydoujitusyoricount}</td><td>（中継用）同日処理回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnkykhyj ztyhjnkykhyj}</td><td>（中継用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnnmkj ztyhjnnmkj}</td><td>（中継用）法人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuhrkkaisuukbn ztysyuhrkkaisuukbn}</td><td>（中継用）表示用主契約払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikbn ztyikkatubaraikbn}</td><td>（中継用）一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikaisuu ztyikkatubaraikaisuu}</td><td>（中継用）一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv103 ztyyobiv103}</td><td>（中継用）予備項目Ｖ１０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenKykIdouDetailTy
 * @see     PKZT_DrtenKykIdouDetailTy
 * @see     QZT_DrtenKykIdouDetailTy
 * @see     GenQZT_DrtenKykIdouDetailTy
 */
@MappedSuperclass
@Table(name=GenZT_DrtenKykIdouDetailTy.TABLE_NAME)
@IdClass(value=PKZT_DrtenKykIdouDetailTy.class)
public abstract class GenZT_DrtenKykIdouDetailTy extends AbstractExDBEntity<ZT_DrtenKykIdouDetailTy, PKZT_DrtenKykIdouDetailTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenKykIdouDetailTy";
    public static final String ZTYKINYUUKIKANCD         = "ztykinyuukikancd";
    public static final String ZTYKINYUUKIKANSITENCD    = "ztykinyuukikansitencd";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYBOSYUUNINCD           = "ztybosyuunincd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYIDOUHASSEIYMD         = "ztyidouhasseiymd";
    public static final String ZTYKYKMFKSNCTRLKH        = "ztykykmfksnctrlkh";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYIDOUKBN               = "ztyidoukbn";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYKYDATKIKBN            = "ztykydatkikbn";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYJIKAIPJYUUTOUYM       = "ztyjikaipjyuutouym";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYANNISKCD              = "ztyanniskcd";
    public static final String ZTYDNTCD                 = "ztydntcd";
    public static final String ZTYHARAIKOMIP            = "ztyharaikomip";
    public static final String ZTYKJSYAGAIHKNNM         = "ztykjsyagaihknnm";
    public static final String ZTYTELNO                 = "ztytelno";
    public static final String ZTYHENSYUUBOSYUUDRTENNM  = "ztyhensyuubosyuudrtennm";
    public static final String ZTYKYKNMKJDIRTNKYKIDO    = "ztykyknmkjdirtnkykido";
    public static final String ZTYKJDNTNM               = "ztykjdntnm";
    public static final String ZTYKZHURIKAEBANKCD       = "ztykzhurikaebankcd";
    public static final String ZTYKZHURIKAESITENCD      = "ztykzhurikaesitencd";
    public static final String ZTYKZHURIKAEYOKINKBN     = "ztykzhurikaeyokinkbn";
    public static final String ZTYKZHURIKAEKOUZANO      = "ztykzhurikaekouzano";
    public static final String ZTYOYABOSYUUDAIRITENCD   = "ztyoyabosyuudairitencd";
    public static final String ZTYBSYDRTENKANRISOSIKICD = "ztybsydrtenkanrisosikicd";
    public static final String ZTYBOSYUUDAIRITENGYOUSYUKBN = "ztybosyuudairitengyousyukbn";
    public static final String ZTYBOSYUUDRTENNMKJ       = "ztybosyuudrtennmkj";
    public static final String ZTYDOUJITUSYORICOUNT     = "ztydoujitusyoricount";
    public static final String ZTYHJNKYKHYJ             = "ztyhjnkykhyj";
    public static final String ZTYHJNNMKJ               = "ztyhjnnmkj";
    public static final String ZTYSYUHRKKAISUUKBN       = "ztysyuhrkkaisuukbn";
    public static final String ZTYIKKATUBARAIKBN        = "ztyikkatubaraikbn";
    public static final String ZTYIKKATUBARAIKAISUU     = "ztyikkatubaraikaisuu";
    public static final String ZTYYOBIV103              = "ztyyobiv103";

    private final PKZT_DrtenKykIdouDetailTy primaryKey;

    public GenZT_DrtenKykIdouDetailTy() {
        primaryKey = new PKZT_DrtenKykIdouDetailTy();
    }

    public GenZT_DrtenKykIdouDetailTy(
        String pZtybsydrtencd,
        String pZtybosyuunincd,
        String pZtysyono,
        String pZtyidouhasseiymd,
        String pZtyidoukbn
    ) {
        primaryKey = new PKZT_DrtenKykIdouDetailTy(
            pZtybsydrtencd,
            pZtybosyuunincd,
            pZtysyono,
            pZtyidouhasseiymd,
            pZtyidoukbn
        );
    }

    @Transient
    @Override
    public PKZT_DrtenKykIdouDetailTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenKykIdouDetailTy> getMetaClass() {
        return QZT_DrtenKykIdouDetailTy.class;
    }

    private String ztykinyuukikancd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKINYUUKIKANCD)
    public String getZtykinyuukikancd() {
        return ztykinyuukikancd;
    }

    public void setZtykinyuukikancd(String pZtykinyuukikancd) {
        ztykinyuukikancd = pZtykinyuukikancd;
    }

    private String ztykinyuukikansitencd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKINYUUKIKANSITENCD)
    public String getZtykinyuukikansitencd() {
        return ztykinyuukikansitencd;
    }

    public void setZtykinyuukikansitencd(String pZtykinyuukikansitencd) {
        ztykinyuukikansitencd = pZtykinyuukikansitencd;
    }

    @Id
    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return getPrimaryKey().getZtybsydrtencd();
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        getPrimaryKey().setZtybsydrtencd(pZtybsydrtencd);
    }

    private String ztycifcd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    @Id
    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYBOSYUUNINCD)
    public String getZtybosyuunincd() {
        return getPrimaryKey().getZtybosyuunincd();
    }

    public void setZtybosyuunincd(String pZtybosyuunincd) {
        getPrimaryKey().setZtybosyuunincd(pZtybosyuunincd);
    }

    @Id
    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYIDOUHASSEIYMD)
    public String getZtyidouhasseiymd() {
        return getPrimaryKey().getZtyidouhasseiymd();
    }

    public void setZtyidouhasseiymd(String pZtyidouhasseiymd) {
        getPrimaryKey().setZtyidouhasseiymd(pZtyidouhasseiymd);
    }

    private Long ztykykmfksnctrlkh;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKYKMFKSNCTRLKH)
    public Long getZtykykmfksnctrlkh() {
        return ztykykmfksnctrlkh;
    }

    public void setZtykykmfksnctrlkh(Long pZtykykmfksnctrlkh) {
        ztykykmfksnctrlkh = pZtykykmfksnctrlkh;
    }

    private String ztysyoricd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    @Id
    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYIDOUKBN)
    public String getZtyidoukbn() {
        return getPrimaryKey().getZtyidoukbn();
    }

    public void setZtyidoukbn(String pZtyidoukbn) {
        getPrimaryKey().setZtyidoukbn(pZtyidoukbn);
    }

    private String ztybsyym;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztykydatkikbn;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKYDATKIKBN)
    public String getZtykydatkikbn() {
        return ztykydatkikbn;
    }

    public void setZtykydatkikbn(String pZtykydatkikbn) {
        ztykydatkikbn = pZtykydatkikbn;
    }

    private String ztykykymd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyjikaipjyuutouym;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYJIKAIPJYUUTOUYM)
    public String getZtyjikaipjyuutouym() {
        return ztyjikaipjyuutouym;
    }

    public void setZtyjikaipjyuutouym(String pZtyjikaipjyuutouym) {
        ztyjikaipjyuutouym = pZtyjikaipjyuutouym;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyanniskcd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private String ztydntcd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYDNTCD)
    public String getZtydntcd() {
        return ztydntcd;
    }

    public void setZtydntcd(String pZtydntcd) {
        ztydntcd = pZtydntcd;
    }

    private Long ztyharaikomip;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYHARAIKOMIP)
    public Long getZtyharaikomip() {
        return ztyharaikomip;
    }

    public void setZtyharaikomip(Long pZtyharaikomip) {
        ztyharaikomip = pZtyharaikomip;
    }

    private String ztykjsyagaihknnm;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKJSYAGAIHKNNM)
    public String getZtykjsyagaihknnm() {
        return ztykjsyagaihknnm;
    }

    public void setZtykjsyagaihknnm(String pZtykjsyagaihknnm) {
        ztykjsyagaihknnm = pZtykjsyagaihknnm;
    }

    private String ztytelno;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYTELNO)
    public String getZtytelno() {
        return ztytelno;
    }

    public void setZtytelno(String pZtytelno) {
        ztytelno = pZtytelno;
    }

    private String ztyhensyuubosyuudrtennm;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYHENSYUUBOSYUUDRTENNM)
    public String getZtyhensyuubosyuudrtennm() {
        return ztyhensyuubosyuudrtennm;
    }

    public void setZtyhensyuubosyuudrtennm(String pZtyhensyuubosyuudrtennm) {
        ztyhensyuubosyuudrtennm = pZtyhensyuubosyuudrtennm;
    }

    private String ztykyknmkjdirtnkykido;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKYKNMKJDIRTNKYKIDO)
    public String getZtykyknmkjdirtnkykido() {
        return ztykyknmkjdirtnkykido;
    }

    public void setZtykyknmkjdirtnkykido(String pZtykyknmkjdirtnkykido) {
        ztykyknmkjdirtnkykido = pZtykyknmkjdirtnkykido;
    }

    private String ztykjdntnm;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKJDNTNM)
    public String getZtykjdntnm() {
        return ztykjdntnm;
    }

    public void setZtykjdntnm(String pZtykjdntnm) {
        ztykjdntnm = pZtykjdntnm;
    }

    private String ztykzhurikaebankcd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKZHURIKAEBANKCD)
    public String getZtykzhurikaebankcd() {
        return ztykzhurikaebankcd;
    }

    public void setZtykzhurikaebankcd(String pZtykzhurikaebankcd) {
        ztykzhurikaebankcd = pZtykzhurikaebankcd;
    }

    private String ztykzhurikaesitencd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKZHURIKAESITENCD)
    public String getZtykzhurikaesitencd() {
        return ztykzhurikaesitencd;
    }

    public void setZtykzhurikaesitencd(String pZtykzhurikaesitencd) {
        ztykzhurikaesitencd = pZtykzhurikaesitencd;
    }

    private String ztykzhurikaeyokinkbn;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKZHURIKAEYOKINKBN)
    public String getZtykzhurikaeyokinkbn() {
        return ztykzhurikaeyokinkbn;
    }

    public void setZtykzhurikaeyokinkbn(String pZtykzhurikaeyokinkbn) {
        ztykzhurikaeyokinkbn = pZtykzhurikaeyokinkbn;
    }

    private String ztykzhurikaekouzano;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYKZHURIKAEKOUZANO)
    public String getZtykzhurikaekouzano() {
        return ztykzhurikaekouzano;
    }

    public void setZtykzhurikaekouzano(String pZtykzhurikaekouzano) {
        ztykzhurikaekouzano = pZtykzhurikaekouzano;
    }

    private String ztyoyabosyuudairitencd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYOYABOSYUUDAIRITENCD)
    public String getZtyoyabosyuudairitencd() {
        return ztyoyabosyuudairitencd;
    }

    public void setZtyoyabosyuudairitencd(String pZtyoyabosyuudairitencd) {
        ztyoyabosyuudairitencd = pZtyoyabosyuudairitencd;
    }

    private String ztybsydrtenkanrisosikicd;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYBSYDRTENKANRISOSIKICD)
    public String getZtybsydrtenkanrisosikicd() {
        return ztybsydrtenkanrisosikicd;
    }

    public void setZtybsydrtenkanrisosikicd(String pZtybsydrtenkanrisosikicd) {
        ztybsydrtenkanrisosikicd = pZtybsydrtenkanrisosikicd;
    }

    private String ztybosyuudairitengyousyukbn;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYBOSYUUDAIRITENGYOUSYUKBN)
    public String getZtybosyuudairitengyousyukbn() {
        return ztybosyuudairitengyousyukbn;
    }

    public void setZtybosyuudairitengyousyukbn(String pZtybosyuudairitengyousyukbn) {
        ztybosyuudairitengyousyukbn = pZtybosyuudairitengyousyukbn;
    }

    private String ztybosyuudrtennmkj;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYBOSYUUDRTENNMKJ)
    public String getZtybosyuudrtennmkj() {
        return ztybosyuudrtennmkj;
    }

    public void setZtybosyuudrtennmkj(String pZtybosyuudrtennmkj) {
        ztybosyuudrtennmkj = pZtybosyuudrtennmkj;
    }

    private String ztydoujitusyoricount;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYDOUJITUSYORICOUNT)
    public String getZtydoujitusyoricount() {
        return ztydoujitusyoricount;
    }

    public void setZtydoujitusyoricount(String pZtydoujitusyoricount) {
        ztydoujitusyoricount = pZtydoujitusyoricount;
    }

    private String ztyhjnkykhyj;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYHJNKYKHYJ)
    public String getZtyhjnkykhyj() {
        return ztyhjnkykhyj;
    }

    public void setZtyhjnkykhyj(String pZtyhjnkykhyj) {
        ztyhjnkykhyj = pZtyhjnkykhyj;
    }

    private String ztyhjnnmkj;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYHJNNMKJ)
    public String getZtyhjnnmkj() {
        return ztyhjnnmkj;
    }

    public void setZtyhjnnmkj(String pZtyhjnnmkj) {
        ztyhjnnmkj = pZtyhjnnmkj;
    }

    private String ztysyuhrkkaisuukbn;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYSYUHRKKAISUUKBN)
    public String getZtysyuhrkkaisuukbn() {
        return ztysyuhrkkaisuukbn;
    }

    public void setZtysyuhrkkaisuukbn(String pZtysyuhrkkaisuukbn) {
        ztysyuhrkkaisuukbn = pZtysyuhrkkaisuukbn;
    }

    private String ztyikkatubaraikbn;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYIKKATUBARAIKBN)
    public String getZtyikkatubaraikbn() {
        return ztyikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyikkatubaraikbn(String pZtyikkatubaraikbn) {
        ztyikkatubaraikbn = pZtyikkatubaraikbn;
    }

    private String ztyikkatubaraikaisuu;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYIKKATUBARAIKAISUU)
    public String getZtyikkatubaraikaisuu() {
        return ztyikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyikkatubaraikaisuu(String pZtyikkatubaraikaisuu) {
        ztyikkatubaraikaisuu = pZtyikkatubaraikaisuu;
    }

    private String ztyyobiv103;

    @Column(name=GenZT_DrtenKykIdouDetailTy.ZTYYOBIV103)
    public String getZtyyobiv103() {
        return ztyyobiv103;
    }

    public void setZtyyobiv103(String pZtyyobiv103) {
        ztyyobiv103 = pZtyyobiv103;
    }
}