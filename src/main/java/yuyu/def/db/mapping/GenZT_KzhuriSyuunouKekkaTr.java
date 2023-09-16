package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.id.PKZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.meta.GenQZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaTr;

/**
 * 口座振替収納結果Ｆテーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_KzhuriSyuunouKekkaTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KzhuriSyuunouKekkaTr}</td><td colspan="3">口座振替収納結果Ｆテーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrsyono ztrsyono}</td><td>（取込用）証券番号</td><td align="center">{@link PKZT_KzhuriSyuunouKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkzhurikaebankcd ztrkzhurikaebankcd}</td><td>（取込用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkzhurikaesitencd ztrkzhurikaesitencd}</td><td>（取込用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkzhurikaeyokinkbn ztrkzhurikaeyokinkbn}</td><td>（取込用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkzhurikaekouzano ztrkzhurikaekouzano}</td><td>（取込用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhurikaeymd ztrhurikaeymd}</td><td>（取込用）振替年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrsgaku ztrrsgaku}</td><td>（取込用）領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrjyuutouym ztrjyuutouym}</td><td>（取込用）充当年月</td><td align="center">{@link PKZT_KzhuriSyuunouKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrjyuutounensuu ztrjyuutounensuu}</td><td>（取込用）充当年数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrjyuutoutukisuu ztrjyuutoutukisuu}</td><td>（取込用）充当月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdantaikobetukbn ztrdantaikobetukbn}</td><td>（取込用）団体個別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrnyknaiyoukbn ztrnyknaiyoukbn}</td><td>（取込用）入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhrkkaisuukbn ztrhrkkaisuukbn}</td><td>（取込用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkzhurikaetkbtannaihyj ztrkzhurikaetkbtannaihyj}</td><td>（取込用）口座振替特別案内表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhurikaekekkakbn ztrhurikaekekkakbn}</td><td>（取込用）振替結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkzhurisyuudaikokbn ztrkzhurisyuudaikokbn}</td><td>（取込用）口座振替収納代行会社区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv13 ztryobiv13}</td><td>（取込用）予備項目Ｖ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KzhuriSyuunouKekkaTr
 * @see     PKZT_KzhuriSyuunouKekkaTr
 * @see     QZT_KzhuriSyuunouKekkaTr
 * @see     GenQZT_KzhuriSyuunouKekkaTr
 */
@MappedSuperclass
@Table(name=GenZT_KzhuriSyuunouKekkaTr.TABLE_NAME)
@IdClass(value=PKZT_KzhuriSyuunouKekkaTr.class)
public abstract class GenZT_KzhuriSyuunouKekkaTr extends AbstractExDBEntity<ZT_KzhuriSyuunouKekkaTr, PKZT_KzhuriSyuunouKekkaTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KzhuriSyuunouKekkaTr";
    public static final String ZTRSYONO                 = "ztrsyono";
    public static final String ZTRKZHURIKAEBANKCD       = "ztrkzhurikaebankcd";
    public static final String ZTRKZHURIKAESITENCD      = "ztrkzhurikaesitencd";
    public static final String ZTRKZHURIKAEYOKINKBN     = "ztrkzhurikaeyokinkbn";
    public static final String ZTRKZHURIKAEKOUZANO      = "ztrkzhurikaekouzano";
    public static final String ZTRHURIKAEYMD            = "ztrhurikaeymd";
    public static final String ZTRRSGAKU                = "ztrrsgaku";
    public static final String ZTRJYUUTOUYM             = "ztrjyuutouym";
    public static final String ZTRJYUUTOUNENSUU         = "ztrjyuutounensuu";
    public static final String ZTRJYUUTOUTUKISUU        = "ztrjyuutoutukisuu";
    public static final String ZTRDANTAIKOBETUKBN       = "ztrdantaikobetukbn";
    public static final String ZTRNYKNAIYOUKBN          = "ztrnyknaiyoukbn";
    public static final String ZTRHRKKAISUUKBN          = "ztrhrkkaisuukbn";
    public static final String ZTRKZHURIKAETKBTANNAIHYJ = "ztrkzhurikaetkbtannaihyj";
    public static final String ZTRHURIKAEKEKKAKBN       = "ztrhurikaekekkakbn";
    public static final String ZTRKZHURISYUUDAIKOKBN    = "ztrkzhurisyuudaikokbn";
    public static final String ZTRYOBIV13               = "ztryobiv13";

    private final PKZT_KzhuriSyuunouKekkaTr primaryKey;

    public GenZT_KzhuriSyuunouKekkaTr() {
        primaryKey = new PKZT_KzhuriSyuunouKekkaTr();
    }

    public GenZT_KzhuriSyuunouKekkaTr(String pZtrsyono, String pZtrjyuutouym) {
        primaryKey = new PKZT_KzhuriSyuunouKekkaTr(pZtrsyono, pZtrjyuutouym);
    }

    @Transient
    @Override
    public PKZT_KzhuriSyuunouKekkaTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KzhuriSyuunouKekkaTr> getMetaClass() {
        return QZT_KzhuriSyuunouKekkaTr.class;
    }

    @Id
    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRSYONO)
    public String getZtrsyono() {
        return getPrimaryKey().getZtrsyono();
    }

    public void setZtrsyono(String pZtrsyono) {
        getPrimaryKey().setZtrsyono(pZtrsyono);
    }

    private String ztrkzhurikaebankcd;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRKZHURIKAEBANKCD)
    public String getZtrkzhurikaebankcd() {
        return ztrkzhurikaebankcd;
    }

    public void setZtrkzhurikaebankcd(String pZtrkzhurikaebankcd) {
        ztrkzhurikaebankcd = pZtrkzhurikaebankcd;
    }

    private String ztrkzhurikaesitencd;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRKZHURIKAESITENCD)
    public String getZtrkzhurikaesitencd() {
        return ztrkzhurikaesitencd;
    }

    public void setZtrkzhurikaesitencd(String pZtrkzhurikaesitencd) {
        ztrkzhurikaesitencd = pZtrkzhurikaesitencd;
    }

    private String ztrkzhurikaeyokinkbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRKZHURIKAEYOKINKBN)
    public String getZtrkzhurikaeyokinkbn() {
        return ztrkzhurikaeyokinkbn;
    }

    public void setZtrkzhurikaeyokinkbn(String pZtrkzhurikaeyokinkbn) {
        ztrkzhurikaeyokinkbn = pZtrkzhurikaeyokinkbn;
    }

    private String ztrkzhurikaekouzano;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRKZHURIKAEKOUZANO)
    public String getZtrkzhurikaekouzano() {
        return ztrkzhurikaekouzano;
    }

    public void setZtrkzhurikaekouzano(String pZtrkzhurikaekouzano) {
        ztrkzhurikaekouzano = pZtrkzhurikaekouzano;
    }

    private String ztrhurikaeymd;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRHURIKAEYMD)
    public String getZtrhurikaeymd() {
        return ztrhurikaeymd;
    }

    public void setZtrhurikaeymd(String pZtrhurikaeymd) {
        ztrhurikaeymd = pZtrhurikaeymd;
    }

    private Long ztrrsgaku;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRRSGAKU)
    public Long getZtrrsgaku() {
        return ztrrsgaku;
    }

    public void setZtrrsgaku(Long pZtrrsgaku) {
        ztrrsgaku = pZtrrsgaku;
    }

    @Id
    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRJYUUTOUYM)
    public String getZtrjyuutouym() {
        return getPrimaryKey().getZtrjyuutouym();
    }

    public void setZtrjyuutouym(String pZtrjyuutouym) {
        getPrimaryKey().setZtrjyuutouym(pZtrjyuutouym);
    }

    private String ztrjyuutounensuu;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRJYUUTOUNENSUU)
    public String getZtrjyuutounensuu() {
        return ztrjyuutounensuu;
    }

    public void setZtrjyuutounensuu(String pZtrjyuutounensuu) {
        ztrjyuutounensuu = pZtrjyuutounensuu;
    }

    private String ztrjyuutoutukisuu;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRJYUUTOUTUKISUU)
    public String getZtrjyuutoutukisuu() {
        return ztrjyuutoutukisuu;
    }

    public void setZtrjyuutoutukisuu(String pZtrjyuutoutukisuu) {
        ztrjyuutoutukisuu = pZtrjyuutoutukisuu;
    }

    private String ztrdantaikobetukbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRDANTAIKOBETUKBN)
    public String getZtrdantaikobetukbn() {
        return ztrdantaikobetukbn;
    }

    public void setZtrdantaikobetukbn(String pZtrdantaikobetukbn) {
        ztrdantaikobetukbn = pZtrdantaikobetukbn;
    }

    private String ztrnyknaiyoukbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRNYKNAIYOUKBN)
    public String getZtrnyknaiyoukbn() {
        return ztrnyknaiyoukbn;
    }

    public void setZtrnyknaiyoukbn(String pZtrnyknaiyoukbn) {
        ztrnyknaiyoukbn = pZtrnyknaiyoukbn;
    }

    private String ztrhrkkaisuukbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRHRKKAISUUKBN)
    public String getZtrhrkkaisuukbn() {
        return ztrhrkkaisuukbn;
    }

    public void setZtrhrkkaisuukbn(String pZtrhrkkaisuukbn) {
        ztrhrkkaisuukbn = pZtrhrkkaisuukbn;
    }

    private String ztrkzhurikaetkbtannaihyj;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRKZHURIKAETKBTANNAIHYJ)
    public String getZtrkzhurikaetkbtannaihyj() {
        return ztrkzhurikaetkbtannaihyj;
    }

    public void setZtrkzhurikaetkbtannaihyj(String pZtrkzhurikaetkbtannaihyj) {
        ztrkzhurikaetkbtannaihyj = pZtrkzhurikaetkbtannaihyj;
    }

    private String ztrhurikaekekkakbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRHURIKAEKEKKAKBN)
    public String getZtrhurikaekekkakbn() {
        return ztrhurikaekekkakbn;
    }

    public void setZtrhurikaekekkakbn(String pZtrhurikaekekkakbn) {
        ztrhurikaekekkakbn = pZtrhurikaekekkakbn;
    }

    private String ztrkzhurisyuudaikokbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRKZHURISYUUDAIKOKBN)
    public String getZtrkzhurisyuudaikokbn() {
        return ztrkzhurisyuudaikokbn;
    }

    public void setZtrkzhurisyuudaikokbn(String pZtrkzhurisyuudaikokbn) {
        ztrkzhurisyuudaikokbn = pZtrkzhurisyuudaikokbn;
    }

    private String ztryobiv13;

    @Column(name=GenZT_KzhuriSyuunouKekkaTr.ZTRYOBIV13)
    public String getZtryobiv13() {
        return ztryobiv13;
    }

    public void setZtryobiv13(String pZtryobiv13) {
        ztryobiv13 = pZtryobiv13;
    }
}