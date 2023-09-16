package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.id.PKZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.meta.GenQZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.meta.QZT_KzhuriAnnaiUlfRn;

/**
 * 口座振替案内ＵＬＦテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KzhuriAnnaiUlfRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KzhuriAnnaiUlfRn}</td><td colspan="3">口座振替案内ＵＬＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KzhuriAnnaiUlfRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndantaicd zrndantaicd}</td><td>（連携用）団体コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaebankcd zrnkzhurikaebankcd}</td><td>（連携用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaesitencd zrnkzhurikaesitencd}</td><td>（連携用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeyokinkbn zrnkzhurikaeyokinkbn}</td><td>（連携用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaekouzano zrnkzhurikaekouzano}</td><td>（連携用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeannaikbn zrnkzhurikaeannaikbn}</td><td>（連携用）口座振替案内区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeymd zrnhurikaeymd}</td><td>（連携用）振替年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrsgaku zrnrsgaku}</td><td>（連携用）領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyuutouym zrnjyuutouym}</td><td>（連携用）充当年月</td><td align="center">{@link PKZT_KzhuriAnnaiUlfRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuutounensuu zrnjyuutounensuu}</td><td>（連携用）充当年数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuutoutukisuu zrnjyuutoutukisuu}</td><td>（連携用）充当月数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndantaikobetukbn zrndantaikobetukbn}</td><td>（連携用）団体個別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknaiyou zrnnyknaiyou}</td><td>（連携用）入金内容</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaetkbtannaihyj zrnkzhurikaetkbtannaihyj}</td><td>（連携用）口座振替特別案内表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkgk zrnhrkgk}</td><td>（連携用）払込額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntsnsknewyno zrntsnsknewyno}</td><td>（連携用）通信先新郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsnsknewtikucd zrntsnsknewtikucd}</td><td>（連携用）通信先新地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaikojincd zrnaatukaikojincd}</td><td>（連携用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikeisyouhinhyj zrnteikeisyouhinhyj}</td><td>（連携用）提携商品表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzmeiginmei zrnkzmeiginmei}</td><td>（連携用）口座名義人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeizokup zrnkeizokup}</td><td>（連携用）継続保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrniktwaribikikgk zrniktwaribikikgk}</td><td>（連携用）一括割引額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeizokupnaiyoukbn zrnkeizokupnaiyoukbn}</td><td>（連携用）継続Ｐ内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhisaijiannaitsghyj zrnhisaijiannaitsghyj}</td><td>（連携用）被災時案内対象外表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaisyono zrndaisyono}</td><td>（連携用）代表証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurisyuudaikokbn zrnkzhurisyuudaikokbn}</td><td>（連携用）口座振替収納代行会社区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv17 zrnyobiv17}</td><td>（連携用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KzhuriAnnaiUlfRn
 * @see     PKZT_KzhuriAnnaiUlfRn
 * @see     QZT_KzhuriAnnaiUlfRn
 * @see     GenQZT_KzhuriAnnaiUlfRn
 */
@MappedSuperclass
@Table(name=GenZT_KzhuriAnnaiUlfRn.TABLE_NAME)
@IdClass(value=PKZT_KzhuriAnnaiUlfRn.class)
public abstract class GenZT_KzhuriAnnaiUlfRn extends AbstractExDBEntityForZDB<ZT_KzhuriAnnaiUlfRn, PKZT_KzhuriAnnaiUlfRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KzhuriAnnaiUlfRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNDANTAICD              = "zrndantaicd";
    public static final String ZRNKZHURIKAEBANKCD       = "zrnkzhurikaebankcd";
    public static final String ZRNKZHURIKAESITENCD      = "zrnkzhurikaesitencd";
    public static final String ZRNKZHURIKAEYOKINKBN     = "zrnkzhurikaeyokinkbn";
    public static final String ZRNKZHURIKAEKOUZANO      = "zrnkzhurikaekouzano";
    public static final String ZRNKZHURIKAEANNAIKBN     = "zrnkzhurikaeannaikbn";
    public static final String ZRNHURIKAEYMD            = "zrnhurikaeymd";
    public static final String ZRNRSGAKU                = "zrnrsgaku";
    public static final String ZRNJYUUTOUYM             = "zrnjyuutouym";
    public static final String ZRNJYUUTOUNENSUU         = "zrnjyuutounensuu";
    public static final String ZRNJYUUTOUTUKISUU        = "zrnjyuutoutukisuu";
    public static final String ZRNDANTAIKOBETUKBN       = "zrndantaikobetukbn";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNNYKNAIYOU             = "zrnnyknaiyou";
    public static final String ZRNAATUKAISOSIKICD       = "zrnaatukaisosikicd";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNKZHURIKAETKBTANNAIHYJ = "zrnkzhurikaetkbtannaihyj";
    public static final String ZRNHRKGK                 = "zrnhrkgk";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNTSNSKNEWYNO           = "zrntsnsknewyno";
    public static final String ZRNTSNSKNEWTIKUCD        = "zrntsnsknewtikucd";
    public static final String ZRNAATUKAIKOJINCD        = "zrnaatukaikojincd";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNTEIKEISYOUHINHYJ      = "zrnteikeisyouhinhyj";
    public static final String ZRNKZMEIGINMEI           = "zrnkzmeiginmei";
    public static final String ZRNKEIZOKUP              = "zrnkeizokup";
    public static final String ZRNIKTWARIBIKIKGK        = "zrniktwaribikikgk";
    public static final String ZRNKEIZOKUPNAIYOUKBN     = "zrnkeizokupnaiyoukbn";
    public static final String ZRNHISAIJIANNAITSGHYJ    = "zrnhisaijiannaitsghyj";
    public static final String ZRNDAISYONO              = "zrndaisyono";
    public static final String ZRNKZHURISYUUDAIKOKBN    = "zrnkzhurisyuudaikokbn";
    public static final String ZRNYOBIV17               = "zrnyobiv17";

    private final PKZT_KzhuriAnnaiUlfRn primaryKey;

    public GenZT_KzhuriAnnaiUlfRn() {
        primaryKey = new PKZT_KzhuriAnnaiUlfRn();
    }

    public GenZT_KzhuriAnnaiUlfRn(String pZrnsyono, String pZrnjyuutouym) {
        primaryKey = new PKZT_KzhuriAnnaiUlfRn(pZrnsyono, pZrnjyuutouym);
    }

    @Transient
    @Override
    public PKZT_KzhuriAnnaiUlfRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KzhuriAnnaiUlfRn> getMetaClass() {
        return QZT_KzhuriAnnaiUlfRn.class;
    }

    @Id
    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrndantaicd;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNDANTAICD)
    public String getZrndantaicd() {
        return zrndantaicd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrndantaicd(String pZrndantaicd) {
        zrndantaicd = pZrndantaicd;
    }

    private String zrnkzhurikaebankcd;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKZHURIKAEBANKCD)
    public String getZrnkzhurikaebankcd() {
        return zrnkzhurikaebankcd;
    }

    public void setZrnkzhurikaebankcd(String pZrnkzhurikaebankcd) {
        zrnkzhurikaebankcd = pZrnkzhurikaebankcd;
    }

    private String zrnkzhurikaesitencd;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKZHURIKAESITENCD)
    public String getZrnkzhurikaesitencd() {
        return zrnkzhurikaesitencd;
    }

    public void setZrnkzhurikaesitencd(String pZrnkzhurikaesitencd) {
        zrnkzhurikaesitencd = pZrnkzhurikaesitencd;
    }

    private String zrnkzhurikaeyokinkbn;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKZHURIKAEYOKINKBN)
    public String getZrnkzhurikaeyokinkbn() {
        return zrnkzhurikaeyokinkbn;
    }

    public void setZrnkzhurikaeyokinkbn(String pZrnkzhurikaeyokinkbn) {
        zrnkzhurikaeyokinkbn = pZrnkzhurikaeyokinkbn;
    }

    private String zrnkzhurikaekouzano;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKZHURIKAEKOUZANO)
    public String getZrnkzhurikaekouzano() {
        return zrnkzhurikaekouzano;
    }

    public void setZrnkzhurikaekouzano(String pZrnkzhurikaekouzano) {
        zrnkzhurikaekouzano = pZrnkzhurikaekouzano;
    }

    private String zrnkzhurikaeannaikbn;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKZHURIKAEANNAIKBN)
    public String getZrnkzhurikaeannaikbn() {
        return zrnkzhurikaeannaikbn;
    }

    public void setZrnkzhurikaeannaikbn(String pZrnkzhurikaeannaikbn) {
        zrnkzhurikaeannaikbn = pZrnkzhurikaeannaikbn;
    }

    private String zrnhurikaeymd;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNHURIKAEYMD)
    public String getZrnhurikaeymd() {
        return zrnhurikaeymd;
    }

    public void setZrnhurikaeymd(String pZrnhurikaeymd) {
        zrnhurikaeymd = pZrnhurikaeymd;
    }

    private Long zrnrsgaku;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNRSGAKU)
    public Long getZrnrsgaku() {
        return zrnrsgaku;
    }

    public void setZrnrsgaku(Long pZrnrsgaku) {
        zrnrsgaku = pZrnrsgaku;
    }

    @Id
    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNJYUUTOUYM)
    public String getZrnjyuutouym() {
        return getPrimaryKey().getZrnjyuutouym();
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnjyuutouym(String pZrnjyuutouym) {
        getPrimaryKey().setZrnjyuutouym(pZrnjyuutouym);
    }

    private String zrnjyuutounensuu;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNJYUUTOUNENSUU)
    public String getZrnjyuutounensuu() {
        return zrnjyuutounensuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuutounensuu(String pZrnjyuutounensuu) {
        zrnjyuutounensuu = pZrnjyuutounensuu;
    }

    private String zrnjyuutoutukisuu;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNJYUUTOUTUKISUU)
    public String getZrnjyuutoutukisuu() {
        return zrnjyuutoutukisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuutoutukisuu(String pZrnjyuutoutukisuu) {
        zrnjyuutoutukisuu = pZrnjyuutoutukisuu;
    }

    private String zrndantaikobetukbn;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNDANTAIKOBETUKBN)
    public String getZrndantaikobetukbn() {
        return zrndantaikobetukbn;
    }

    public void setZrndantaikobetukbn(String pZrndantaikobetukbn) {
        zrndantaikobetukbn = pZrndantaikobetukbn;
    }

    private String zrnkykymd;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnnyknaiyou;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNNYKNAIYOU)
    public String getZrnnyknaiyou() {
        return zrnnyknaiyou;
    }

    public void setZrnnyknaiyou(String pZrnnyknaiyou) {
        zrnnyknaiyou = pZrnnyknaiyou;
    }

    private String zrnaatukaisosikicd;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNAATUKAISOSIKICD)
    public String getZrnaatukaisosikicd() {
        return zrnaatukaisosikicd;
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnkzhurikaetkbtannaihyj;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKZHURIKAETKBTANNAIHYJ)
    public String getZrnkzhurikaetkbtannaihyj() {
        return zrnkzhurikaetkbtannaihyj;
    }

    public void setZrnkzhurikaetkbtannaihyj(String pZrnkzhurikaetkbtannaihyj) {
        zrnkzhurikaetkbtannaihyj = pZrnkzhurikaetkbtannaihyj;
    }

    private Long zrnhrkgk;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNHRKGK)
    public Long getZrnhrkgk() {
        return zrnhrkgk;
    }

    public void setZrnhrkgk(Long pZrnhrkgk) {
        zrnhrkgk = pZrnhrkgk;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private String zrntsnsknewyno;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNTSNSKNEWYNO)
    public String getZrntsnsknewyno() {
        return zrntsnsknewyno;
    }

    public void setZrntsnsknewyno(String pZrntsnsknewyno) {
        zrntsnsknewyno = pZrntsnsknewyno;
    }

    private String zrntsnsknewtikucd;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNTSNSKNEWTIKUCD)
    public String getZrntsnsknewtikucd() {
        return zrntsnsknewtikucd;
    }

    public void setZrntsnsknewtikucd(String pZrntsnsknewtikucd) {
        zrntsnsknewtikucd = pZrntsnsknewtikucd;
    }

    private String zrnaatukaikojincd;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNAATUKAIKOJINCD)
    public String getZrnaatukaikojincd() {
        return zrnaatukaikojincd;
    }

    public void setZrnaatukaikojincd(String pZrnaatukaikojincd) {
        zrnaatukaikojincd = pZrnaatukaikojincd;
    }

    private String zrnbsyym;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnteikeisyouhinhyj;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNTEIKEISYOUHINHYJ)
    public String getZrnteikeisyouhinhyj() {
        return zrnteikeisyouhinhyj;
    }

    public void setZrnteikeisyouhinhyj(String pZrnteikeisyouhinhyj) {
        zrnteikeisyouhinhyj = pZrnteikeisyouhinhyj;
    }

    private String zrnkzmeiginmei;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKZMEIGINMEI)
    public String getZrnkzmeiginmei() {
        return zrnkzmeiginmei;
    }

    @DataConvert("toSingleByte")
    public void setZrnkzmeiginmei(String pZrnkzmeiginmei) {
        zrnkzmeiginmei = pZrnkzmeiginmei;
    }

    private Long zrnkeizokup;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKEIZOKUP)
    public Long getZrnkeizokup() {
        return zrnkeizokup;
    }

    public void setZrnkeizokup(Long pZrnkeizokup) {
        zrnkeizokup = pZrnkeizokup;
    }

    private Long zrniktwaribikikgk;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNIKTWARIBIKIKGK)
    public Long getZrniktwaribikikgk() {
        return zrniktwaribikikgk;
    }

    public void setZrniktwaribikikgk(Long pZrniktwaribikikgk) {
        zrniktwaribikikgk = pZrniktwaribikikgk;
    }

    private String zrnkeizokupnaiyoukbn;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKEIZOKUPNAIYOUKBN)
    public String getZrnkeizokupnaiyoukbn() {
        return zrnkeizokupnaiyoukbn;
    }

    public void setZrnkeizokupnaiyoukbn(String pZrnkeizokupnaiyoukbn) {
        zrnkeizokupnaiyoukbn = pZrnkeizokupnaiyoukbn;
    }

    private String zrnhisaijiannaitsghyj;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNHISAIJIANNAITSGHYJ)
    public String getZrnhisaijiannaitsghyj() {
        return zrnhisaijiannaitsghyj;
    }

    public void setZrnhisaijiannaitsghyj(String pZrnhisaijiannaitsghyj) {
        zrnhisaijiannaitsghyj = pZrnhisaijiannaitsghyj;
    }

    private String zrndaisyono;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNDAISYONO)
    public String getZrndaisyono() {
        return zrndaisyono;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrndaisyono(String pZrndaisyono) {
        zrndaisyono = pZrndaisyono;
    }

    private String zrnkzhurisyuudaikokbn;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNKZHURISYUUDAIKOKBN)
    public String getZrnkzhurisyuudaikokbn() {
        return zrnkzhurisyuudaikokbn;
    }

    public void setZrnkzhurisyuudaikokbn(String pZrnkzhurisyuudaikokbn) {
        zrnkzhurisyuudaikokbn = pZrnkzhurisyuudaikokbn;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_KzhuriAnnaiUlfRn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }
}