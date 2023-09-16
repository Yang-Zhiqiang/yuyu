package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_AcsAdrNmRn;
import yuyu.def.db.id.PKZT_AcsAdrNmRn;
import yuyu.def.db.meta.GenQZT_AcsAdrNmRn;
import yuyu.def.db.meta.QZT_AcsAdrNmRn;

/**
 * ＡＣＳ住所名ＤＢ用Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_AcsAdrNmRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AcsAdrNmRn}</td><td colspan="3">ＡＣＳ住所名ＤＢ用Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkihontikucd zrnkihontikucd}</td><td>（連携用）基本地区コード</td><td align="center">{@link PKZT_AcsAdrNmRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihontikucdsyoumetukbn zrnkihontikucdsyoumetukbn}</td><td>（連携用）基本地区コード消滅理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjadr zrnkjadr}</td><td>（連携用）漢字住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtodouhukennmketasuu zrnkjtodouhukennmketasuu}</td><td>（連携用）漢字都道府県名桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsikugunnmketasuu zrnkjsikugunnmketasuu}</td><td>（連携用）漢字市区郡名桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsikutyousonnmketasuu zrnkjsikutyousonnmketasuu}</td><td>（連携用）漢字市区町村名桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtyousonnmketasuu zrnkjtyousonnmketasuu}</td><td>（連携用）漢字町村名桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyoutotuusyounmketasuu zrnkjkyoutotuusyounmketasuu}</td><td>（連携用）漢字京都市内通称町名桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjadrketasuu zrnkjadrketasuu}</td><td>（連携用）漢字住所桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknadr zrnknadr}</td><td>（連携用）カナ住所</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkntodouhukennmketasuu zrnkntodouhukennmketasuu}</td><td>（連携用）カナ都道府県名桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknsikugunnmketasuu zrnknsikugunnmketasuu}</td><td>（連携用）カナ市区郡名桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknsikutyousonnmketasuu zrnknsikutyousonnmketasuu}</td><td>（連携用）カナ市区町村名桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkntyousonnmketasuu zrnkntyousonnmketasuu}</td><td>（連携用）カナ町村名桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkyoutotuusyounmketasuu zrnknkyoutotuusyounmketasuu}</td><td>（連携用）カナ京都市内通称町名桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknadrketasuu zrnknadrketasuu}</td><td>（連携用）カナ住所桁数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntodouhukencd zrntodouhukencd}</td><td>（連携用）都道府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngyouseikukakucd zrngyouseikukakucd}</td><td>（連携用）行政区画コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikoumaekihontikucd zrnikoumaekihontikucd}</td><td>（連携用）移行前基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewynohyouji zrnnewynohyouji}</td><td>（連携用）新郵便番号表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv14 zrnyobiv14}</td><td>（連携用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_AcsAdrNmRn
 * @see     PKZT_AcsAdrNmRn
 * @see     QZT_AcsAdrNmRn
 * @see     GenQZT_AcsAdrNmRn
 */
@MappedSuperclass
@Table(name=GenZT_AcsAdrNmRn.TABLE_NAME)
@IdClass(value=PKZT_AcsAdrNmRn.class)
public abstract class GenZT_AcsAdrNmRn extends AbstractExDBEntityForZDB<ZT_AcsAdrNmRn, PKZT_AcsAdrNmRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_AcsAdrNmRn";
    public static final String ZRNKIHONTIKUCD           = "zrnkihontikucd";
    public static final String ZRNKIHONTIKUCDSYOUMETUKBN = "zrnkihontikucdsyoumetukbn";
    public static final String ZRNKJADR                 = "zrnkjadr";
    public static final String ZRNKJTODOUHUKENNMKETASUU = "zrnkjtodouhukennmketasuu";
    public static final String ZRNKJSIKUGUNNMKETASUU    = "zrnkjsikugunnmketasuu";
    public static final String ZRNKJSIKUTYOUSONNMKETASUU = "zrnkjsikutyousonnmketasuu";
    public static final String ZRNKJTYOUSONNMKETASUU    = "zrnkjtyousonnmketasuu";
    public static final String ZRNKJKYOUTOTUUSYOUNMKETASUU = "zrnkjkyoutotuusyounmketasuu";
    public static final String ZRNKJADRKETASUU          = "zrnkjadrketasuu";
    public static final String ZRNKNADR                 = "zrnknadr";
    public static final String ZRNKNTODOUHUKENNMKETASUU = "zrnkntodouhukennmketasuu";
    public static final String ZRNKNSIKUGUNNMKETASUU    = "zrnknsikugunnmketasuu";
    public static final String ZRNKNSIKUTYOUSONNMKETASUU = "zrnknsikutyousonnmketasuu";
    public static final String ZRNKNTYOUSONNMKETASUU    = "zrnkntyousonnmketasuu";
    public static final String ZRNKNKYOUTOTUUSYOUNMKETASUU = "zrnknkyoutotuusyounmketasuu";
    public static final String ZRNKNADRKETASUU          = "zrnknadrketasuu";
    public static final String ZRNTODOUHUKENCD          = "zrntodouhukencd";
    public static final String ZRNGYOUSEIKUKAKUCD       = "zrngyouseikukakucd";
    public static final String ZRNIKOUMAEKIHONTIKUCD    = "zrnikoumaekihontikucd";
    public static final String ZRNNEWYNOHYOUJI          = "zrnnewynohyouji";
    public static final String ZRNYOBIV14               = "zrnyobiv14";

    private final PKZT_AcsAdrNmRn primaryKey;

    public GenZT_AcsAdrNmRn() {
        primaryKey = new PKZT_AcsAdrNmRn();
    }

    public GenZT_AcsAdrNmRn(String pZrnkihontikucd) {
        primaryKey = new PKZT_AcsAdrNmRn(pZrnkihontikucd);
    }

    @Transient
    @Override
    public PKZT_AcsAdrNmRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_AcsAdrNmRn> getMetaClass() {
        return QZT_AcsAdrNmRn.class;
    }

    @Id
    @Column(name=GenZT_AcsAdrNmRn.ZRNKIHONTIKUCD)
    public String getZrnkihontikucd() {
        return getPrimaryKey().getZrnkihontikucd();
    }

    public void setZrnkihontikucd(String pZrnkihontikucd) {
        getPrimaryKey().setZrnkihontikucd(pZrnkihontikucd);
    }

    private String zrnkihontikucdsyoumetukbn;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKIHONTIKUCDSYOUMETUKBN)
    public String getZrnkihontikucdsyoumetukbn() {
        return zrnkihontikucdsyoumetukbn;
    }

    public void setZrnkihontikucdsyoumetukbn(String pZrnkihontikucdsyoumetukbn) {
        zrnkihontikucdsyoumetukbn = pZrnkihontikucdsyoumetukbn;
    }

    private String zrnkjadr;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKJADR)
    public String getZrnkjadr() {
        return zrnkjadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjadr(String pZrnkjadr) {
        zrnkjadr = pZrnkjadr;
    }

    private String zrnkjtodouhukennmketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKJTODOUHUKENNMKETASUU)
    public String getZrnkjtodouhukennmketasuu() {
        return zrnkjtodouhukennmketasuu;
    }

    public void setZrnkjtodouhukennmketasuu(String pZrnkjtodouhukennmketasuu) {
        zrnkjtodouhukennmketasuu = pZrnkjtodouhukennmketasuu;
    }

    private String zrnkjsikugunnmketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKJSIKUGUNNMKETASUU)
    public String getZrnkjsikugunnmketasuu() {
        return zrnkjsikugunnmketasuu;
    }

    public void setZrnkjsikugunnmketasuu(String pZrnkjsikugunnmketasuu) {
        zrnkjsikugunnmketasuu = pZrnkjsikugunnmketasuu;
    }

    private String zrnkjsikutyousonnmketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKJSIKUTYOUSONNMKETASUU)
    public String getZrnkjsikutyousonnmketasuu() {
        return zrnkjsikutyousonnmketasuu;
    }

    public void setZrnkjsikutyousonnmketasuu(String pZrnkjsikutyousonnmketasuu) {
        zrnkjsikutyousonnmketasuu = pZrnkjsikutyousonnmketasuu;
    }

    private String zrnkjtyousonnmketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKJTYOUSONNMKETASUU)
    public String getZrnkjtyousonnmketasuu() {
        return zrnkjtyousonnmketasuu;
    }

    public void setZrnkjtyousonnmketasuu(String pZrnkjtyousonnmketasuu) {
        zrnkjtyousonnmketasuu = pZrnkjtyousonnmketasuu;
    }

    private String zrnkjkyoutotuusyounmketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKJKYOUTOTUUSYOUNMKETASUU)
    public String getZrnkjkyoutotuusyounmketasuu() {
        return zrnkjkyoutotuusyounmketasuu;
    }

    public void setZrnkjkyoutotuusyounmketasuu(String pZrnkjkyoutotuusyounmketasuu) {
        zrnkjkyoutotuusyounmketasuu = pZrnkjkyoutotuusyounmketasuu;
    }

    private String zrnkjadrketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKJADRKETASUU)
    public String getZrnkjadrketasuu() {
        return zrnkjadrketasuu;
    }

    public void setZrnkjadrketasuu(String pZrnkjadrketasuu) {
        zrnkjadrketasuu = pZrnkjadrketasuu;
    }

    private String zrnknadr;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKNADR)
    public String getZrnknadr() {
        return zrnknadr;
    }

    public void setZrnknadr(String pZrnknadr) {
        zrnknadr = pZrnknadr;
    }

    private String zrnkntodouhukennmketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKNTODOUHUKENNMKETASUU)
    public String getZrnkntodouhukennmketasuu() {
        return zrnkntodouhukennmketasuu;
    }

    public void setZrnkntodouhukennmketasuu(String pZrnkntodouhukennmketasuu) {
        zrnkntodouhukennmketasuu = pZrnkntodouhukennmketasuu;
    }

    private String zrnknsikugunnmketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKNSIKUGUNNMKETASUU)
    public String getZrnknsikugunnmketasuu() {
        return zrnknsikugunnmketasuu;
    }

    public void setZrnknsikugunnmketasuu(String pZrnknsikugunnmketasuu) {
        zrnknsikugunnmketasuu = pZrnknsikugunnmketasuu;
    }

    private String zrnknsikutyousonnmketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKNSIKUTYOUSONNMKETASUU)
    public String getZrnknsikutyousonnmketasuu() {
        return zrnknsikutyousonnmketasuu;
    }

    public void setZrnknsikutyousonnmketasuu(String pZrnknsikutyousonnmketasuu) {
        zrnknsikutyousonnmketasuu = pZrnknsikutyousonnmketasuu;
    }

    private String zrnkntyousonnmketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKNTYOUSONNMKETASUU)
    public String getZrnkntyousonnmketasuu() {
        return zrnkntyousonnmketasuu;
    }

    public void setZrnkntyousonnmketasuu(String pZrnkntyousonnmketasuu) {
        zrnkntyousonnmketasuu = pZrnkntyousonnmketasuu;
    }

    private String zrnknkyoutotuusyounmketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKNKYOUTOTUUSYOUNMKETASUU)
    public String getZrnknkyoutotuusyounmketasuu() {
        return zrnknkyoutotuusyounmketasuu;
    }

    public void setZrnknkyoutotuusyounmketasuu(String pZrnknkyoutotuusyounmketasuu) {
        zrnknkyoutotuusyounmketasuu = pZrnknkyoutotuusyounmketasuu;
    }

    private String zrnknadrketasuu;

    @Column(name=GenZT_AcsAdrNmRn.ZRNKNADRKETASUU)
    public String getZrnknadrketasuu() {
        return zrnknadrketasuu;
    }

    public void setZrnknadrketasuu(String pZrnknadrketasuu) {
        zrnknadrketasuu = pZrnknadrketasuu;
    }

    private String zrntodouhukencd;

    @Column(name=GenZT_AcsAdrNmRn.ZRNTODOUHUKENCD)
    public String getZrntodouhukencd() {
        return zrntodouhukencd;
    }

    public void setZrntodouhukencd(String pZrntodouhukencd) {
        zrntodouhukencd = pZrntodouhukencd;
    }

    private String zrngyouseikukakucd;

    @Column(name=GenZT_AcsAdrNmRn.ZRNGYOUSEIKUKAKUCD)
    public String getZrngyouseikukakucd() {
        return zrngyouseikukakucd;
    }

    public void setZrngyouseikukakucd(String pZrngyouseikukakucd) {
        zrngyouseikukakucd = pZrngyouseikukakucd;
    }

    private String zrnikoumaekihontikucd;

    @Column(name=GenZT_AcsAdrNmRn.ZRNIKOUMAEKIHONTIKUCD)
    public String getZrnikoumaekihontikucd() {
        return zrnikoumaekihontikucd;
    }

    public void setZrnikoumaekihontikucd(String pZrnikoumaekihontikucd) {
        zrnikoumaekihontikucd = pZrnikoumaekihontikucd;
    }

    private String zrnnewynohyouji;

    @Column(name=GenZT_AcsAdrNmRn.ZRNNEWYNOHYOUJI)
    public String getZrnnewynohyouji() {
        return zrnnewynohyouji;
    }

    public void setZrnnewynohyouji(String pZrnnewynohyouji) {
        zrnnewynohyouji = pZrnnewynohyouji;
    }

    private String zrnyobiv14;

    @Column(name=GenZT_AcsAdrNmRn.ZRNYOBIV14)
    public String getZrnyobiv14() {
        return zrnyobiv14;
    }

    public void setZrnyobiv14(String pZrnyobiv14) {
        zrnyobiv14 = pZrnyobiv14;
    }
}