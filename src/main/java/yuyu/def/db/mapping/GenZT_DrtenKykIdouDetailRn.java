package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailRn;
import yuyu.def.db.id.PKZT_DrtenKykIdouDetailRn;
import yuyu.def.db.meta.GenQZT_DrtenKykIdouDetailRn;
import yuyu.def.db.meta.QZT_DrtenKykIdouDetailRn;

/**
 * 代理店契約異動明細テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DrtenKykIdouDetailRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenKykIdouDetailRn}</td><td colspan="3">代理店契約異動明細テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkinyuukikancd zrnkinyuukikancd}</td><td>（連携用）金融機関コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkinyuukikansitencd zrnkinyuukikansitencd}</td><td>（連携用）金融機関支店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">{@link PKZT_DrtenKykIdouDetailRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">{@link PKZT_DrtenKykIdouDetailRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_DrtenKykIdouDetailRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidouhasseiymd zrnidouhasseiymd}</td><td>（連携用）異動発生年月日</td><td align="center">{@link PKZT_DrtenKykIdouDetailRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfksnctrlkh zrnkykmfksnctrlkh}</td><td>（連携用）契約ＭＦ更新ＣＴＲ（保全）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidoukbn zrnidoukbn}</td><td>（連携用）異動区分</td><td align="center">{@link PKZT_DrtenKykIdouDetailRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkikbn zrnkydatkikbn}</td><td>（連携用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikaipjyuutouym zrnjikaipjyuutouym}</td><td>（連携用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnanniskcd zrnanniskcd}</td><td>（連携用）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntcd zrndntcd}</td><td>（連携用）団体コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikomip zrnharaikomip}</td><td>（連携用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkjsyagaihknnm zrnkjsyagaihknnm}</td><td>（連携用）漢字社外向け保険名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntelno zrntelno}</td><td>（連携用）電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhensyuubosyuudrtennm zrnhensyuubosyuudrtennm}</td><td>（連携用）編集後漢字募集代理店名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkjdirtnkykido zrnkyknmkjdirtnkykido}</td><td>（連携用）契約者名（漢字）（代理店契約異動明細）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjdntnm zrnkjdntnm}</td><td>（連携用）漢字団体名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaebankcd zrnkzhurikaebankcd}</td><td>（連携用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaesitencd zrnkzhurikaesitencd}</td><td>（連携用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeyokinkbn zrnkzhurikaeyokinkbn}</td><td>（連携用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaekouzano zrnkzhurikaekouzano}</td><td>（連携用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnoyabosyuudairitencd zrnoyabosyuudairitencd}</td><td>（連携用）親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtenkanrisosikicd zrnbsydrtenkanrisosikicd}</td><td>（連携用）募集代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuudairitengyousyukbn zrnbosyuudairitengyousyukbn}</td><td>（連携用）募集代理店業種区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuudrtennmkj zrnbosyuudrtennmkj}</td><td>（連携用）募集代理店名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndoujitusyoricount zrndoujitusyoricount}</td><td>（連携用）同日処理回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnkykhyj zrnhjnkykhyj}</td><td>（連携用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnnmkj zrnhjnnmkj}</td><td>（連携用）法人名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuhrkkaisuukbn zrnsyuhrkkaisuukbn}</td><td>（連携用）表示用主契約払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikbn zrnikkatubaraikbn}</td><td>（連携用）一括払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikaisuu zrnikkatubaraikaisuu}</td><td>（連携用）一括払回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv103 zrnyobiv103}</td><td>（連携用）予備項目Ｖ１０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenKykIdouDetailRn
 * @see     PKZT_DrtenKykIdouDetailRn
 * @see     QZT_DrtenKykIdouDetailRn
 * @see     GenQZT_DrtenKykIdouDetailRn
 */
@MappedSuperclass
@Table(name=GenZT_DrtenKykIdouDetailRn.TABLE_NAME)
@IdClass(value=PKZT_DrtenKykIdouDetailRn.class)
public abstract class GenZT_DrtenKykIdouDetailRn extends AbstractExDBEntityForZDB<ZT_DrtenKykIdouDetailRn, PKZT_DrtenKykIdouDetailRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenKykIdouDetailRn";
    public static final String ZRNKINYUUKIKANCD         = "zrnkinyuukikancd";
    public static final String ZRNKINYUUKIKANSITENCD    = "zrnkinyuukikansitencd";
    public static final String ZRNBSYDRTENCD            = "zrnbsydrtencd";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNBOSYUUNINCD           = "zrnbosyuunincd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNIDOUHASSEIYMD         = "zrnidouhasseiymd";
    public static final String ZRNKYKMFKSNCTRLKH        = "zrnkykmfksnctrlkh";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNIDOUKBN               = "zrnidoukbn";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNKYDATKIKBN            = "zrnkydatkikbn";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNJIKAIPJYUUTOUYM       = "zrnjikaipjyuutouym";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNANNISKCD              = "zrnanniskcd";
    public static final String ZRNDNTCD                 = "zrndntcd";
    public static final String ZRNHARAIKOMIP            = "zrnharaikomip";
    public static final String ZRNKJSYAGAIHKNNM         = "zrnkjsyagaihknnm";
    public static final String ZRNTELNO                 = "zrntelno";
    public static final String ZRNHENSYUUBOSYUUDRTENNM  = "zrnhensyuubosyuudrtennm";
    public static final String ZRNKYKNMKJDIRTNKYKIDO    = "zrnkyknmkjdirtnkykido";
    public static final String ZRNKJDNTNM               = "zrnkjdntnm";
    public static final String ZRNKZHURIKAEBANKCD       = "zrnkzhurikaebankcd";
    public static final String ZRNKZHURIKAESITENCD      = "zrnkzhurikaesitencd";
    public static final String ZRNKZHURIKAEYOKINKBN     = "zrnkzhurikaeyokinkbn";
    public static final String ZRNKZHURIKAEKOUZANO      = "zrnkzhurikaekouzano";
    public static final String ZRNOYABOSYUUDAIRITENCD   = "zrnoyabosyuudairitencd";
    public static final String ZRNBSYDRTENKANRISOSIKICD = "zrnbsydrtenkanrisosikicd";
    public static final String ZRNBOSYUUDAIRITENGYOUSYUKBN = "zrnbosyuudairitengyousyukbn";
    public static final String ZRNBOSYUUDRTENNMKJ       = "zrnbosyuudrtennmkj";
    public static final String ZRNDOUJITUSYORICOUNT     = "zrndoujitusyoricount";
    public static final String ZRNHJNKYKHYJ             = "zrnhjnkykhyj";
    public static final String ZRNHJNNMKJ               = "zrnhjnnmkj";
    public static final String ZRNSYUHRKKAISUUKBN       = "zrnsyuhrkkaisuukbn";
    public static final String ZRNIKKATUBARAIKBN        = "zrnikkatubaraikbn";
    public static final String ZRNIKKATUBARAIKAISUU     = "zrnikkatubaraikaisuu";
    public static final String ZRNYOBIV103              = "zrnyobiv103";

    private final PKZT_DrtenKykIdouDetailRn primaryKey;

    public GenZT_DrtenKykIdouDetailRn() {
        primaryKey = new PKZT_DrtenKykIdouDetailRn();
    }

    public GenZT_DrtenKykIdouDetailRn(
        String pZrnbsydrtencd,
        String pZrnbosyuunincd,
        String pZrnsyono,
        String pZrnidouhasseiymd,
        String pZrnidoukbn
    ) {
        primaryKey = new PKZT_DrtenKykIdouDetailRn(
            pZrnbsydrtencd,
            pZrnbosyuunincd,
            pZrnsyono,
            pZrnidouhasseiymd,
            pZrnidoukbn
        );
    }

    @Transient
    @Override
    public PKZT_DrtenKykIdouDetailRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenKykIdouDetailRn> getMetaClass() {
        return QZT_DrtenKykIdouDetailRn.class;
    }

    private String zrnkinyuukikancd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKINYUUKIKANCD)
    public String getZrnkinyuukikancd() {
        return zrnkinyuukikancd;
    }

    public void setZrnkinyuukikancd(String pZrnkinyuukikancd) {
        zrnkinyuukikancd = pZrnkinyuukikancd;
    }

    private String zrnkinyuukikansitencd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKINYUUKIKANSITENCD)
    public String getZrnkinyuukikansitencd() {
        return zrnkinyuukikansitencd;
    }

    public void setZrnkinyuukikansitencd(String pZrnkinyuukikansitencd) {
        zrnkinyuukikansitencd = pZrnkinyuukikansitencd;
    }

    @Id
    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNBSYDRTENCD)
    public String getZrnbsydrtencd() {
        return getPrimaryKey().getZrnbsydrtencd();
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        getPrimaryKey().setZrnbsydrtencd(pZrnbsydrtencd);
    }

    private String zrncifcd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    @Id
    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNBOSYUUNINCD)
    public String getZrnbosyuunincd() {
        return getPrimaryKey().getZrnbosyuunincd();
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        getPrimaryKey().setZrnbosyuunincd(pZrnbosyuunincd);
    }

    @Id
    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNIDOUHASSEIYMD)
    public String getZrnidouhasseiymd() {
        return getPrimaryKey().getZrnidouhasseiymd();
    }

    public void setZrnidouhasseiymd(String pZrnidouhasseiymd) {
        getPrimaryKey().setZrnidouhasseiymd(pZrnidouhasseiymd);
    }

    private Long zrnkykmfksnctrlkh;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKYKMFKSNCTRLKH)
    public Long getZrnkykmfksnctrlkh() {
        return zrnkykmfksnctrlkh;
    }

    public void setZrnkykmfksnctrlkh(Long pZrnkykmfksnctrlkh) {
        zrnkykmfksnctrlkh = pZrnkykmfksnctrlkh;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    @Id
    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNIDOUKBN)
    public String getZrnidoukbn() {
        return getPrimaryKey().getZrnidoukbn();
    }

    public void setZrnidoukbn(String pZrnidoukbn) {
        getPrimaryKey().setZrnidoukbn(pZrnidoukbn);
    }

    private String zrnbsyym;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnkydatkikbn;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKYDATKIKBN)
    public String getZrnkydatkikbn() {
        return zrnkydatkikbn;
    }

    public void setZrnkydatkikbn(String pZrnkydatkikbn) {
        zrnkydatkikbn = pZrnkydatkikbn;
    }

    private String zrnkykymd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnjikaipjyuutouym;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNJIKAIPJYUUTOUYM)
    public String getZrnjikaipjyuutouym() {
        return zrnjikaipjyuutouym;
    }

    public void setZrnjikaipjyuutouym(String pZrnjikaipjyuutouym) {
        zrnjikaipjyuutouym = pZrnjikaipjyuutouym;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnanniskcd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNANNISKCD)
    public String getZrnanniskcd() {
        return zrnanniskcd;
    }

    public void setZrnanniskcd(String pZrnanniskcd) {
        zrnanniskcd = pZrnanniskcd;
    }

    private String zrndntcd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNDNTCD)
    public String getZrndntcd() {
        return zrndntcd;
    }

    public void setZrndntcd(String pZrndntcd) {
        zrndntcd = pZrndntcd;
    }

    private Long zrnharaikomip;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNHARAIKOMIP)
    public Long getZrnharaikomip() {
        return zrnharaikomip;
    }

    public void setZrnharaikomip(Long pZrnharaikomip) {
        zrnharaikomip = pZrnharaikomip;
    }

    private String zrnkjsyagaihknnm;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKJSYAGAIHKNNM)
    public String getZrnkjsyagaihknnm() {
        return zrnkjsyagaihknnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsyagaihknnm(String pZrnkjsyagaihknnm) {
        zrnkjsyagaihknnm = pZrnkjsyagaihknnm;
    }

    private String zrntelno;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNTELNO)
    public String getZrntelno() {
        return zrntelno;
    }

    public void setZrntelno(String pZrntelno) {
        zrntelno = pZrntelno;
    }

    private String zrnhensyuubosyuudrtennm;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNHENSYUUBOSYUUDRTENNM)
    public String getZrnhensyuubosyuudrtennm() {
        return zrnhensyuubosyuudrtennm;
    }

    @DataConvert("toMultiByte")
    public void setZrnhensyuubosyuudrtennm(String pZrnhensyuubosyuudrtennm) {
        zrnhensyuubosyuudrtennm = pZrnhensyuubosyuudrtennm;
    }

    private String zrnkyknmkjdirtnkykido;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKYKNMKJDIRTNKYKIDO)
    public String getZrnkyknmkjdirtnkykido() {
        return zrnkyknmkjdirtnkykido;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkjdirtnkykido(String pZrnkyknmkjdirtnkykido) {
        zrnkyknmkjdirtnkykido = pZrnkyknmkjdirtnkykido;
    }

    private String zrnkjdntnm;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKJDNTNM)
    public String getZrnkjdntnm() {
        return zrnkjdntnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjdntnm(String pZrnkjdntnm) {
        zrnkjdntnm = pZrnkjdntnm;
    }

    private String zrnkzhurikaebankcd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKZHURIKAEBANKCD)
    public String getZrnkzhurikaebankcd() {
        return zrnkzhurikaebankcd;
    }

    public void setZrnkzhurikaebankcd(String pZrnkzhurikaebankcd) {
        zrnkzhurikaebankcd = pZrnkzhurikaebankcd;
    }

    private String zrnkzhurikaesitencd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKZHURIKAESITENCD)
    public String getZrnkzhurikaesitencd() {
        return zrnkzhurikaesitencd;
    }

    public void setZrnkzhurikaesitencd(String pZrnkzhurikaesitencd) {
        zrnkzhurikaesitencd = pZrnkzhurikaesitencd;
    }

    private String zrnkzhurikaeyokinkbn;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKZHURIKAEYOKINKBN)
    public String getZrnkzhurikaeyokinkbn() {
        return zrnkzhurikaeyokinkbn;
    }

    public void setZrnkzhurikaeyokinkbn(String pZrnkzhurikaeyokinkbn) {
        zrnkzhurikaeyokinkbn = pZrnkzhurikaeyokinkbn;
    }

    private String zrnkzhurikaekouzano;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNKZHURIKAEKOUZANO)
    public String getZrnkzhurikaekouzano() {
        return zrnkzhurikaekouzano;
    }

    public void setZrnkzhurikaekouzano(String pZrnkzhurikaekouzano) {
        zrnkzhurikaekouzano = pZrnkzhurikaekouzano;
    }

    private String zrnoyabosyuudairitencd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNOYABOSYUUDAIRITENCD)
    public String getZrnoyabosyuudairitencd() {
        return zrnoyabosyuudairitencd;
    }

    public void setZrnoyabosyuudairitencd(String pZrnoyabosyuudairitencd) {
        zrnoyabosyuudairitencd = pZrnoyabosyuudairitencd;
    }

    private String zrnbsydrtenkanrisosikicd;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNBSYDRTENKANRISOSIKICD)
    public String getZrnbsydrtenkanrisosikicd() {
        return zrnbsydrtenkanrisosikicd;
    }

    public void setZrnbsydrtenkanrisosikicd(String pZrnbsydrtenkanrisosikicd) {
        zrnbsydrtenkanrisosikicd = pZrnbsydrtenkanrisosikicd;
    }

    private String zrnbosyuudairitengyousyukbn;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNBOSYUUDAIRITENGYOUSYUKBN)
    public String getZrnbosyuudairitengyousyukbn() {
        return zrnbosyuudairitengyousyukbn;
    }

    public void setZrnbosyuudairitengyousyukbn(String pZrnbosyuudairitengyousyukbn) {
        zrnbosyuudairitengyousyukbn = pZrnbosyuudairitengyousyukbn;
    }

    private String zrnbosyuudrtennmkj;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNBOSYUUDRTENNMKJ)
    public String getZrnbosyuudrtennmkj() {
        return zrnbosyuudrtennmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnbosyuudrtennmkj(String pZrnbosyuudrtennmkj) {
        zrnbosyuudrtennmkj = pZrnbosyuudrtennmkj;
    }

    private String zrndoujitusyoricount;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNDOUJITUSYORICOUNT)
    public String getZrndoujitusyoricount() {
        return zrndoujitusyoricount;
    }

    public void setZrndoujitusyoricount(String pZrndoujitusyoricount) {
        zrndoujitusyoricount = pZrndoujitusyoricount;
    }

    private String zrnhjnkykhyj;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNHJNKYKHYJ)
    public String getZrnhjnkykhyj() {
        return zrnhjnkykhyj;
    }

    public void setZrnhjnkykhyj(String pZrnhjnkykhyj) {
        zrnhjnkykhyj = pZrnhjnkykhyj;
    }

    private String zrnhjnnmkj;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNHJNNMKJ)
    public String getZrnhjnnmkj() {
        return zrnhjnnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhjnnmkj(String pZrnhjnnmkj) {
        zrnhjnnmkj = pZrnhjnnmkj;
    }

    private String zrnsyuhrkkaisuukbn;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNSYUHRKKAISUUKBN)
    public String getZrnsyuhrkkaisuukbn() {
        return zrnsyuhrkkaisuukbn;
    }

    public void setZrnsyuhrkkaisuukbn(String pZrnsyuhrkkaisuukbn) {
        zrnsyuhrkkaisuukbn = pZrnsyuhrkkaisuukbn;
    }

    private String zrnikkatubaraikbn;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNIKKATUBARAIKBN)
    public String getZrnikkatubaraikbn() {
        return zrnikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnikkatubaraikbn(String pZrnikkatubaraikbn) {
        zrnikkatubaraikbn = pZrnikkatubaraikbn;
    }

    private String zrnikkatubaraikaisuu;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNIKKATUBARAIKAISUU)
    public String getZrnikkatubaraikaisuu() {
        return zrnikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnikkatubaraikaisuu(String pZrnikkatubaraikaisuu) {
        zrnikkatubaraikaisuu = pZrnikkatubaraikaisuu;
    }

    private String zrnyobiv103;

    @Column(name=GenZT_DrtenKykIdouDetailRn.ZRNYOBIV103)
    public String getZrnyobiv103() {
        return zrnyobiv103;
    }

    public void setZrnyobiv103(String pZrnyobiv103) {
        zrnyobiv103 = pZrnyobiv103;
    }
}