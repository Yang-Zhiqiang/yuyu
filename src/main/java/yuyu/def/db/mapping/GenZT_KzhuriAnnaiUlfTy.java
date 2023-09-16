package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.id.PKZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.meta.GenQZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.meta.QZT_KzhuriAnnaiUlfTy;

/**
 * 口座振替案内ＵＬＦテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KzhuriAnnaiUlfTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KzhuriAnnaiUlfTy}</td><td colspan="3">口座振替案内ＵＬＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KzhuriAnnaiUlfTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydantaicd ztydantaicd}</td><td>（中継用）団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaebankcd ztykzhurikaebankcd}</td><td>（中継用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaesitencd ztykzhurikaesitencd}</td><td>（中継用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeyokinkbn ztykzhurikaeyokinkbn}</td><td>（中継用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaekouzano ztykzhurikaekouzano}</td><td>（中継用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeannaikbn ztykzhurikaeannaikbn}</td><td>（中継用）口座振替案内区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeymd ztyhurikaeymd}</td><td>（中継用）振替年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrsgaku ztyrsgaku}</td><td>（中継用）領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyuutouym ztyjyuutouym}</td><td>（中継用）充当年月</td><td align="center">{@link PKZT_KzhuriAnnaiUlfTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuutounensuu ztyjyuutounensuu}</td><td>（中継用）充当年数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuutoutukisuu ztyjyuutoutukisuu}</td><td>（中継用）充当月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydantaikobetukbn ztydantaikobetukbn}</td><td>（中継用）団体個別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknaiyou ztynyknaiyou}</td><td>（中継用）入金内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaetkbtannaihyj ztykzhurikaetkbtannaihyj}</td><td>（中継用）口座振替特別案内表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkgk ztyhrkgk}</td><td>（中継用）払込額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytsnsknewyno ztytsnsknewyno}</td><td>（中継用）通信先新郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsnsknewtikucd ztytsnsknewtikucd}</td><td>（中継用）通信先新地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaikojincd ztyaatukaikojincd}</td><td>（中継用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikeisyouhinhyj ztyteikeisyouhinhyj}</td><td>（中継用）提携商品表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzmeiginmei ztykzmeiginmei}</td><td>（中継用）口座名義人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeizokup ztykeizokup}</td><td>（中継用）継続保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyiktwaribikikgk ztyiktwaribikikgk}</td><td>（中継用）一括割引額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeizokupnaiyoukbn ztykeizokupnaiyoukbn}</td><td>（中継用）継続Ｐ内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhisaijiannaitsghyj ztyhisaijiannaitsghyj}</td><td>（中継用）被災時案内対象外表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaisyono ztydaisyono}</td><td>（中継用）代表証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurisyuudaikokbn ztykzhurisyuudaikokbn}</td><td>（中継用）口座振替収納代行会社区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv17 ztyyobiv17}</td><td>（中継用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KzhuriAnnaiUlfTy
 * @see     PKZT_KzhuriAnnaiUlfTy
 * @see     QZT_KzhuriAnnaiUlfTy
 * @see     GenQZT_KzhuriAnnaiUlfTy
 */
@MappedSuperclass
@Table(name=GenZT_KzhuriAnnaiUlfTy.TABLE_NAME)
@IdClass(value=PKZT_KzhuriAnnaiUlfTy.class)
public abstract class GenZT_KzhuriAnnaiUlfTy extends AbstractExDBEntity<ZT_KzhuriAnnaiUlfTy, PKZT_KzhuriAnnaiUlfTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KzhuriAnnaiUlfTy";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYDANTAICD              = "ztydantaicd";
    public static final String ZTYKZHURIKAEBANKCD       = "ztykzhurikaebankcd";
    public static final String ZTYKZHURIKAESITENCD      = "ztykzhurikaesitencd";
    public static final String ZTYKZHURIKAEYOKINKBN     = "ztykzhurikaeyokinkbn";
    public static final String ZTYKZHURIKAEKOUZANO      = "ztykzhurikaekouzano";
    public static final String ZTYKZHURIKAEANNAIKBN     = "ztykzhurikaeannaikbn";
    public static final String ZTYHURIKAEYMD            = "ztyhurikaeymd";
    public static final String ZTYRSGAKU                = "ztyrsgaku";
    public static final String ZTYJYUUTOUYM             = "ztyjyuutouym";
    public static final String ZTYJYUUTOUNENSUU         = "ztyjyuutounensuu";
    public static final String ZTYJYUUTOUTUKISUU        = "ztyjyuutoutukisuu";
    public static final String ZTYDANTAIKOBETUKBN       = "ztydantaikobetukbn";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYNYKNAIYOU             = "ztynyknaiyou";
    public static final String ZTYAATUKAISOSIKICD       = "ztyaatukaisosikicd";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYKZHURIKAETKBTANNAIHYJ = "ztykzhurikaetkbtannaihyj";
    public static final String ZTYHRKGK                 = "ztyhrkgk";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYTSNSKNEWYNO           = "ztytsnsknewyno";
    public static final String ZTYTSNSKNEWTIKUCD        = "ztytsnsknewtikucd";
    public static final String ZTYAATUKAIKOJINCD        = "ztyaatukaikojincd";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYTEIKEISYOUHINHYJ      = "ztyteikeisyouhinhyj";
    public static final String ZTYKZMEIGINMEI           = "ztykzmeiginmei";
    public static final String ZTYKEIZOKUP              = "ztykeizokup";
    public static final String ZTYIKTWARIBIKIKGK        = "ztyiktwaribikikgk";
    public static final String ZTYKEIZOKUPNAIYOUKBN     = "ztykeizokupnaiyoukbn";
    public static final String ZTYHISAIJIANNAITSGHYJ    = "ztyhisaijiannaitsghyj";
    public static final String ZTYDAISYONO              = "ztydaisyono";
    public static final String ZTYKZHURISYUUDAIKOKBN    = "ztykzhurisyuudaikokbn";
    public static final String ZTYYOBIV17               = "ztyyobiv17";

    private final PKZT_KzhuriAnnaiUlfTy primaryKey;

    public GenZT_KzhuriAnnaiUlfTy() {
        primaryKey = new PKZT_KzhuriAnnaiUlfTy();
    }

    public GenZT_KzhuriAnnaiUlfTy(String pZtysyono, String pZtyjyuutouym) {
        primaryKey = new PKZT_KzhuriAnnaiUlfTy(pZtysyono, pZtyjyuutouym);
    }

    @Transient
    @Override
    public PKZT_KzhuriAnnaiUlfTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KzhuriAnnaiUlfTy> getMetaClass() {
        return QZT_KzhuriAnnaiUlfTy.class;
    }

    @Id
    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztydantaicd;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYDANTAICD)
    public String getZtydantaicd() {
        return ztydantaicd;
    }

    public void setZtydantaicd(String pZtydantaicd) {
        ztydantaicd = pZtydantaicd;
    }

    private String ztykzhurikaebankcd;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKZHURIKAEBANKCD)
    public String getZtykzhurikaebankcd() {
        return ztykzhurikaebankcd;
    }

    public void setZtykzhurikaebankcd(String pZtykzhurikaebankcd) {
        ztykzhurikaebankcd = pZtykzhurikaebankcd;
    }

    private String ztykzhurikaesitencd;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKZHURIKAESITENCD)
    public String getZtykzhurikaesitencd() {
        return ztykzhurikaesitencd;
    }

    public void setZtykzhurikaesitencd(String pZtykzhurikaesitencd) {
        ztykzhurikaesitencd = pZtykzhurikaesitencd;
    }

    private String ztykzhurikaeyokinkbn;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKZHURIKAEYOKINKBN)
    public String getZtykzhurikaeyokinkbn() {
        return ztykzhurikaeyokinkbn;
    }

    public void setZtykzhurikaeyokinkbn(String pZtykzhurikaeyokinkbn) {
        ztykzhurikaeyokinkbn = pZtykzhurikaeyokinkbn;
    }

    private String ztykzhurikaekouzano;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKZHURIKAEKOUZANO)
    public String getZtykzhurikaekouzano() {
        return ztykzhurikaekouzano;
    }

    public void setZtykzhurikaekouzano(String pZtykzhurikaekouzano) {
        ztykzhurikaekouzano = pZtykzhurikaekouzano;
    }

    private String ztykzhurikaeannaikbn;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKZHURIKAEANNAIKBN)
    public String getZtykzhurikaeannaikbn() {
        return ztykzhurikaeannaikbn;
    }

    public void setZtykzhurikaeannaikbn(String pZtykzhurikaeannaikbn) {
        ztykzhurikaeannaikbn = pZtykzhurikaeannaikbn;
    }

    private String ztyhurikaeymd;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYHURIKAEYMD)
    public String getZtyhurikaeymd() {
        return ztyhurikaeymd;
    }

    public void setZtyhurikaeymd(String pZtyhurikaeymd) {
        ztyhurikaeymd = pZtyhurikaeymd;
    }

    private Long ztyrsgaku;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYRSGAKU)
    public Long getZtyrsgaku() {
        return ztyrsgaku;
    }

    public void setZtyrsgaku(Long pZtyrsgaku) {
        ztyrsgaku = pZtyrsgaku;
    }

    @Id
    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYJYUUTOUYM)
    public String getZtyjyuutouym() {
        return getPrimaryKey().getZtyjyuutouym();
    }

    public void setZtyjyuutouym(String pZtyjyuutouym) {
        getPrimaryKey().setZtyjyuutouym(pZtyjyuutouym);
    }

    private String ztyjyuutounensuu;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYJYUUTOUNENSUU)
    public String getZtyjyuutounensuu() {
        return ztyjyuutounensuu;
    }

    public void setZtyjyuutounensuu(String pZtyjyuutounensuu) {
        ztyjyuutounensuu = pZtyjyuutounensuu;
    }

    private String ztyjyuutoutukisuu;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYJYUUTOUTUKISUU)
    public String getZtyjyuutoutukisuu() {
        return ztyjyuutoutukisuu;
    }

    public void setZtyjyuutoutukisuu(String pZtyjyuutoutukisuu) {
        ztyjyuutoutukisuu = pZtyjyuutoutukisuu;
    }

    private String ztydantaikobetukbn;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYDANTAIKOBETUKBN)
    public String getZtydantaikobetukbn() {
        return ztydantaikobetukbn;
    }

    public void setZtydantaikobetukbn(String pZtydantaikobetukbn) {
        ztydantaikobetukbn = pZtydantaikobetukbn;
    }

    private String ztykykymd;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztynyknaiyou;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYNYKNAIYOU)
    public String getZtynyknaiyou() {
        return ztynyknaiyou;
    }

    public void setZtynyknaiyou(String pZtynyknaiyou) {
        ztynyknaiyou = pZtynyknaiyou;
    }

    private String ztyaatukaisosikicd;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztykzhurikaetkbtannaihyj;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKZHURIKAETKBTANNAIHYJ)
    public String getZtykzhurikaetkbtannaihyj() {
        return ztykzhurikaetkbtannaihyj;
    }

    public void setZtykzhurikaetkbtannaihyj(String pZtykzhurikaetkbtannaihyj) {
        ztykzhurikaetkbtannaihyj = pZtykzhurikaetkbtannaihyj;
    }

    private Long ztyhrkgk;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYHRKGK)
    public Long getZtyhrkgk() {
        return ztyhrkgk;
    }

    public void setZtyhrkgk(Long pZtyhrkgk) {
        ztyhrkgk = pZtyhrkgk;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private String ztytsnsknewyno;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYTSNSKNEWYNO)
    public String getZtytsnsknewyno() {
        return ztytsnsknewyno;
    }

    public void setZtytsnsknewyno(String pZtytsnsknewyno) {
        ztytsnsknewyno = pZtytsnsknewyno;
    }

    private String ztytsnsknewtikucd;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYTSNSKNEWTIKUCD)
    public String getZtytsnsknewtikucd() {
        return ztytsnsknewtikucd;
    }

    public void setZtytsnsknewtikucd(String pZtytsnsknewtikucd) {
        ztytsnsknewtikucd = pZtytsnsknewtikucd;
    }

    private String ztyaatukaikojincd;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYAATUKAIKOJINCD)
    public String getZtyaatukaikojincd() {
        return ztyaatukaikojincd;
    }

    public void setZtyaatukaikojincd(String pZtyaatukaikojincd) {
        ztyaatukaikojincd = pZtyaatukaikojincd;
    }

    private String ztybsyym;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztyteikeisyouhinhyj;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYTEIKEISYOUHINHYJ)
    public String getZtyteikeisyouhinhyj() {
        return ztyteikeisyouhinhyj;
    }

    public void setZtyteikeisyouhinhyj(String pZtyteikeisyouhinhyj) {
        ztyteikeisyouhinhyj = pZtyteikeisyouhinhyj;
    }

    private String ztykzmeiginmei;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKZMEIGINMEI)
    public String getZtykzmeiginmei() {
        return ztykzmeiginmei;
    }

    public void setZtykzmeiginmei(String pZtykzmeiginmei) {
        ztykzmeiginmei = pZtykzmeiginmei;
    }

    private Long ztykeizokup;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKEIZOKUP)
    public Long getZtykeizokup() {
        return ztykeizokup;
    }

    public void setZtykeizokup(Long pZtykeizokup) {
        ztykeizokup = pZtykeizokup;
    }

    private Long ztyiktwaribikikgk;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYIKTWARIBIKIKGK)
    public Long getZtyiktwaribikikgk() {
        return ztyiktwaribikikgk;
    }

    public void setZtyiktwaribikikgk(Long pZtyiktwaribikikgk) {
        ztyiktwaribikikgk = pZtyiktwaribikikgk;
    }

    private String ztykeizokupnaiyoukbn;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKEIZOKUPNAIYOUKBN)
    public String getZtykeizokupnaiyoukbn() {
        return ztykeizokupnaiyoukbn;
    }

    public void setZtykeizokupnaiyoukbn(String pZtykeizokupnaiyoukbn) {
        ztykeizokupnaiyoukbn = pZtykeizokupnaiyoukbn;
    }

    private String ztyhisaijiannaitsghyj;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYHISAIJIANNAITSGHYJ)
    public String getZtyhisaijiannaitsghyj() {
        return ztyhisaijiannaitsghyj;
    }

    public void setZtyhisaijiannaitsghyj(String pZtyhisaijiannaitsghyj) {
        ztyhisaijiannaitsghyj = pZtyhisaijiannaitsghyj;
    }

    private String ztydaisyono;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYDAISYONO)
    public String getZtydaisyono() {
        return ztydaisyono;
    }

    public void setZtydaisyono(String pZtydaisyono) {
        ztydaisyono = pZtydaisyono;
    }

    private String ztykzhurisyuudaikokbn;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYKZHURISYUUDAIKOKBN)
    public String getZtykzhurisyuudaikokbn() {
        return ztykzhurisyuudaikokbn;
    }

    public void setZtykzhurisyuudaikokbn(String pZtykzhurisyuudaikokbn) {
        ztykzhurisyuudaikokbn = pZtykzhurisyuudaikokbn;
    }

    private String ztyyobiv17;

    @Column(name=GenZT_KzhuriAnnaiUlfTy.ZTYYOBIV17)
    public String getZtyyobiv17() {
        return ztyyobiv17;
    }

    public void setZtyyobiv17(String pZtyyobiv17) {
        ztyyobiv17 = pZtyyobiv17;
    }
}