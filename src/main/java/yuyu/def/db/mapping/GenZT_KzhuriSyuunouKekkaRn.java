package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.id.PKZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.meta.GenQZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaRn;

/**
 * 口座振替収納結果Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KzhuriSyuunouKekkaRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KzhuriSyuunouKekkaRn}</td><td colspan="3">口座振替収納結果Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KzhuriSyuunouKekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaebankcd zrnkzhurikaebankcd}</td><td>（連携用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaesitencd zrnkzhurikaesitencd}</td><td>（連携用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeyokinkbn zrnkzhurikaeyokinkbn}</td><td>（連携用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaekouzano zrnkzhurikaekouzano}</td><td>（連携用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeymd zrnhurikaeymd}</td><td>（連携用）振替年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrsgaku zrnrsgaku}</td><td>（連携用）領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyuutouym zrnjyuutouym}</td><td>（連携用）充当年月</td><td align="center">{@link PKZT_KzhuriSyuunouKekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuutounensuu zrnjyuutounensuu}</td><td>（連携用）充当年数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuutoutukisuu zrnjyuutoutukisuu}</td><td>（連携用）充当月数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndantaikobetukbn zrndantaikobetukbn}</td><td>（連携用）団体個別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknaiyoukbn zrnnyknaiyoukbn}</td><td>（連携用）入金内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaetkbtannaihyj zrnkzhurikaetkbtannaihyj}</td><td>（連携用）口座振替特別案内表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekekkakbn zrnhurikaekekkakbn}</td><td>（連携用）振替結果区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurisyuudaikokbn zrnkzhurisyuudaikokbn}</td><td>（連携用）口座振替収納代行会社区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv13 zrnyobiv13}</td><td>（連携用）予備項目Ｖ１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KzhuriSyuunouKekkaRn
 * @see     PKZT_KzhuriSyuunouKekkaRn
 * @see     QZT_KzhuriSyuunouKekkaRn
 * @see     GenQZT_KzhuriSyuunouKekkaRn
 */
@MappedSuperclass
@Table(name=GenZT_KzhuriSyuunouKekkaRn.TABLE_NAME)
@IdClass(value=PKZT_KzhuriSyuunouKekkaRn.class)
public abstract class GenZT_KzhuriSyuunouKekkaRn extends AbstractExDBEntityForZDB<ZT_KzhuriSyuunouKekkaRn, PKZT_KzhuriSyuunouKekkaRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KzhuriSyuunouKekkaRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNKZHURIKAEBANKCD       = "zrnkzhurikaebankcd";
    public static final String ZRNKZHURIKAESITENCD      = "zrnkzhurikaesitencd";
    public static final String ZRNKZHURIKAEYOKINKBN     = "zrnkzhurikaeyokinkbn";
    public static final String ZRNKZHURIKAEKOUZANO      = "zrnkzhurikaekouzano";
    public static final String ZRNHURIKAEYMD            = "zrnhurikaeymd";
    public static final String ZRNRSGAKU                = "zrnrsgaku";
    public static final String ZRNJYUUTOUYM             = "zrnjyuutouym";
    public static final String ZRNJYUUTOUNENSUU         = "zrnjyuutounensuu";
    public static final String ZRNJYUUTOUTUKISUU        = "zrnjyuutoutukisuu";
    public static final String ZRNDANTAIKOBETUKBN       = "zrndantaikobetukbn";
    public static final String ZRNNYKNAIYOUKBN          = "zrnnyknaiyoukbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNKZHURIKAETKBTANNAIHYJ = "zrnkzhurikaetkbtannaihyj";
    public static final String ZRNHURIKAEKEKKAKBN       = "zrnhurikaekekkakbn";
    public static final String ZRNKZHURISYUUDAIKOKBN    = "zrnkzhurisyuudaikokbn";
    public static final String ZRNYOBIV13               = "zrnyobiv13";

    private final PKZT_KzhuriSyuunouKekkaRn primaryKey;

    public GenZT_KzhuriSyuunouKekkaRn() {
        primaryKey = new PKZT_KzhuriSyuunouKekkaRn();
    }

    public GenZT_KzhuriSyuunouKekkaRn(String pZrnsyono, String pZrnjyuutouym) {
        primaryKey = new PKZT_KzhuriSyuunouKekkaRn(pZrnsyono, pZrnjyuutouym);
    }

    @Transient
    @Override
    public PKZT_KzhuriSyuunouKekkaRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KzhuriSyuunouKekkaRn> getMetaClass() {
        return QZT_KzhuriSyuunouKekkaRn.class;
    }

    @Id
    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnkzhurikaebankcd;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNKZHURIKAEBANKCD)
    public String getZrnkzhurikaebankcd() {
        return zrnkzhurikaebankcd;
    }

    public void setZrnkzhurikaebankcd(String pZrnkzhurikaebankcd) {
        zrnkzhurikaebankcd = pZrnkzhurikaebankcd;
    }

    private String zrnkzhurikaesitencd;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNKZHURIKAESITENCD)
    public String getZrnkzhurikaesitencd() {
        return zrnkzhurikaesitencd;
    }

    public void setZrnkzhurikaesitencd(String pZrnkzhurikaesitencd) {
        zrnkzhurikaesitencd = pZrnkzhurikaesitencd;
    }

    private String zrnkzhurikaeyokinkbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNKZHURIKAEYOKINKBN)
    public String getZrnkzhurikaeyokinkbn() {
        return zrnkzhurikaeyokinkbn;
    }

    public void setZrnkzhurikaeyokinkbn(String pZrnkzhurikaeyokinkbn) {
        zrnkzhurikaeyokinkbn = pZrnkzhurikaeyokinkbn;
    }

    private String zrnkzhurikaekouzano;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNKZHURIKAEKOUZANO)
    public String getZrnkzhurikaekouzano() {
        return zrnkzhurikaekouzano;
    }

    public void setZrnkzhurikaekouzano(String pZrnkzhurikaekouzano) {
        zrnkzhurikaekouzano = pZrnkzhurikaekouzano;
    }

    private String zrnhurikaeymd;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNHURIKAEYMD)
    public String getZrnhurikaeymd() {
        return zrnhurikaeymd;
    }

    public void setZrnhurikaeymd(String pZrnhurikaeymd) {
        zrnhurikaeymd = pZrnhurikaeymd;
    }

    private Long zrnrsgaku;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNRSGAKU)
    public Long getZrnrsgaku() {
        return zrnrsgaku;
    }

    public void setZrnrsgaku(Long pZrnrsgaku) {
        zrnrsgaku = pZrnrsgaku;
    }

    @Id
    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNJYUUTOUYM)
    public String getZrnjyuutouym() {
        return getPrimaryKey().getZrnjyuutouym();
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnjyuutouym(String pZrnjyuutouym) {
        getPrimaryKey().setZrnjyuutouym(pZrnjyuutouym);
    }

    private String zrnjyuutounensuu;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNJYUUTOUNENSUU)
    public String getZrnjyuutounensuu() {
        return zrnjyuutounensuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuutounensuu(String pZrnjyuutounensuu) {
        zrnjyuutounensuu = pZrnjyuutounensuu;
    }

    private String zrnjyuutoutukisuu;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNJYUUTOUTUKISUU)
    public String getZrnjyuutoutukisuu() {
        return zrnjyuutoutukisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyuutoutukisuu(String pZrnjyuutoutukisuu) {
        zrnjyuutoutukisuu = pZrnjyuutoutukisuu;
    }

    private String zrndantaikobetukbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNDANTAIKOBETUKBN)
    public String getZrndantaikobetukbn() {
        return zrndantaikobetukbn;
    }

    public void setZrndantaikobetukbn(String pZrndantaikobetukbn) {
        zrndantaikobetukbn = pZrndantaikobetukbn;
    }

    private String zrnnyknaiyoukbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNNYKNAIYOUKBN)
    public String getZrnnyknaiyoukbn() {
        return zrnnyknaiyoukbn;
    }

    public void setZrnnyknaiyoukbn(String pZrnnyknaiyoukbn) {
        zrnnyknaiyoukbn = pZrnnyknaiyoukbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnkzhurikaetkbtannaihyj;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNKZHURIKAETKBTANNAIHYJ)
    public String getZrnkzhurikaetkbtannaihyj() {
        return zrnkzhurikaetkbtannaihyj;
    }

    public void setZrnkzhurikaetkbtannaihyj(String pZrnkzhurikaetkbtannaihyj) {
        zrnkzhurikaetkbtannaihyj = pZrnkzhurikaetkbtannaihyj;
    }

    private String zrnhurikaekekkakbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNHURIKAEKEKKAKBN)
    public String getZrnhurikaekekkakbn() {
        return zrnhurikaekekkakbn;
    }

    public void setZrnhurikaekekkakbn(String pZrnhurikaekekkakbn) {
        zrnhurikaekekkakbn = pZrnhurikaekekkakbn;
    }

    private String zrnkzhurisyuudaikokbn;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNKZHURISYUUDAIKOKBN)
    public String getZrnkzhurisyuudaikokbn() {
        return zrnkzhurisyuudaikokbn;
    }

    public void setZrnkzhurisyuudaikokbn(String pZrnkzhurisyuudaikokbn) {
        zrnkzhurisyuudaikokbn = pZrnkzhurisyuudaikokbn;
    }

    private String zrnyobiv13;

    @Column(name=GenZT_KzhuriSyuunouKekkaRn.ZRNYOBIV13)
    public String getZrnyobiv13() {
        return zrnyobiv13;
    }

    public void setZrnyobiv13(String pZrnyobiv13) {
        zrnyobiv13 = pZrnyobiv13;
    }
}