package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.id.PKZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.meta.GenQZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.meta.QZT_KhGinkouMdhnFollowCallRn;

/**
 * 銀行窓販フォローコール対象テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KhGinkouMdhnFollowCallRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KhGinkouMdhnFollowCallRn}</td><td colspan="3">銀行窓販フォローコール対象テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KhGinkouMdhnFollowCallRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorikbn zrnsyorikbn}</td><td>（連携用）処理区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaip zrnannaip}</td><td>（連携用）案内保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuuym zrnminyuuym}</td><td>（連携用）未入年月</td><td align="center">{@link PKZT_KhGinkouMdhnFollowCallRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskymd zrnskymd}</td><td>（連携用）失効年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskhr zrnskhr}</td><td>（連携用）失効時返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnttkekin zrnttkekin}</td><td>（連携用）今期立替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnttkeganri zrnttkeganri}</td><td>（連携用）立替元利金合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnttkersk zrnttkersk}</td><td>（連携用）立替利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnttkeriritu zrnttkeriritu}</td><td>（連携用）立替利率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttkejyuutouym zrnttkejyuutouym}</td><td>（連携用）立替充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttkejyuutounen zrnttkejyuutounen}</td><td>（連携用）立替充当年数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttkejyuutoutuki zrnttkejyuutoutuki}</td><td>（連携用）立替充当月数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x2 zrnyobiv8x2}</td><td>（連携用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv29 zrnyobiv29}</td><td>（連携用）予備項目Ｖ２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaskinmeino zrnkyksyaskinmeino}</td><td>（連携用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseiymd zrnkyksyaseiymd}</td><td>（連携用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmhnykkbn zrnkyknmhnykkbn}</td><td>（連携用）契約者名翻訳結果区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm35keta zrnkjkyknm35keta}</td><td>（連携用）漢字契約者名（３５桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkyksyamei zrnknkyksyamei}</td><td>（連携用）カナ契約者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmhnykkbn zrnhhknnmhnykkbn}</td><td>（連携用）被保険者名翻訳結果区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei zrnknjhhknmei}</td><td>（連携用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknhhknmei zrnknhhknmei}</td><td>（連携用）カナ被保険者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseiymd zrnhhknseiymd}</td><td>（連携用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihontikucd zrnkihontikucd}</td><td>（連携用）基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaadr zrnkyksyaadr}</td><td>（連携用）契約者住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsintelno zrntsintelno}</td><td>（連携用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikaipjyuutouym zrnjikaipjyuutouym}</td><td>（連携用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnanniskcd zrnanniskcd}</td><td>（連携用）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknmeisyou15keta zrnhknmeisyou15keta}</td><td>（連携用）保険名称（１５桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyujdrtencd1 zrnbsyujdrtencd1}</td><td>（連携用）募集時代理店コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyujbosyuucd1 zrnbsyujbosyuucd1}</td><td>（連携用）募集時募集人コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyujdrtencd2 zrnbsyujdrtencd2}</td><td>（連携用）募集時代理店コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyujbosyuucd2 zrnbsyujbosyuucd2}</td><td>（連携用）募集時募集人コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyujdrtencd3 zrnbsyujdrtencd3}</td><td>（連携用）募集時代理店コード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyujbosyuucd3 zrnbsyujbosyuucd3}</td><td>（連携用）募集時募集人コード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyujdrtencd4 zrnbsyujdrtencd4}</td><td>（連携用）募集時代理店コード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyujbosyuucd4 zrnbsyujbosyuucd4}</td><td>（連携用）募集時募集人コード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyujdrtencd5 zrnbsyujdrtencd5}</td><td>（連携用）募集時代理店コード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyujbosyuucd5 zrnbsyujbosyuucd5}</td><td>（連携用）募集時募集人コード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisindrtencd zrnsaisindrtencd}</td><td>（連携用）最新代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisinbosyuucd zrnsaisinbosyuucd}</td><td>（連携用）最新募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaebankcd zrnkzhurikaebankcd}</td><td>（連携用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaesitencd zrnkzhurikaesitencd}</td><td>（連携用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeyokinkbn zrnkzhurikaeyokinkbn}</td><td>（連携用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaekouzano zrnkzhurikaekouzano}</td><td>（連携用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnsyugkhmignnmei zrnhnsyugkhmignnmei}</td><td>（連携用）編集後口座振替名義人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv39 zrnyobiv39}</td><td>（連携用）予備項目Ｖ３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KhGinkouMdhnFollowCallRn
 * @see     PKZT_KhGinkouMdhnFollowCallRn
 * @see     QZT_KhGinkouMdhnFollowCallRn
 * @see     GenQZT_KhGinkouMdhnFollowCallRn
 */
@MappedSuperclass
@Table(name=GenZT_KhGinkouMdhnFollowCallRn.TABLE_NAME)
@IdClass(value=PKZT_KhGinkouMdhnFollowCallRn.class)
public abstract class GenZT_KhGinkouMdhnFollowCallRn extends AbstractExDBEntityForZDB<ZT_KhGinkouMdhnFollowCallRn, PKZT_KhGinkouMdhnFollowCallRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KhGinkouMdhnFollowCallRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNSYORIKBN              = "zrnsyorikbn";
    public static final String ZRNANNAIP                = "zrnannaip";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNMINYUUYM              = "zrnminyuuym";
    public static final String ZRNSKYMD                 = "zrnskymd";
    public static final String ZRNSKHR                  = "zrnskhr";
    public static final String ZRNTTKEKIN               = "zrnttkekin";
    public static final String ZRNTTKEGANRI             = "zrnttkeganri";
    public static final String ZRNTTKERSK               = "zrnttkersk";
    public static final String ZRNTTKERIRITU            = "zrnttkeriritu";
    public static final String ZRNTTKEJYUUTOUYM         = "zrnttkejyuutouym";
    public static final String ZRNTTKEJYUUTOUNEN        = "zrnttkejyuutounen";
    public static final String ZRNTTKEJYUUTOUTUKI       = "zrnttkejyuutoutuki";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIV8X2              = "zrnyobiv8x2";
    public static final String ZRNYOBIV29               = "zrnyobiv29";
    public static final String ZRNKYKSYASKINMEINO       = "zrnkyksyaskinmeino";
    public static final String ZRNKYKSYASEIYMD          = "zrnkyksyaseiymd";
    public static final String ZRNKYKNMHNYKKBN          = "zrnkyknmhnykkbn";
    public static final String ZRNKJKYKNM35KETA         = "zrnkjkyknm35keta";
    public static final String ZRNKNKYKSYAMEI           = "zrnknkyksyamei";
    public static final String ZRNHHKNNMHNYKKBN         = "zrnhhknnmhnykkbn";
    public static final String ZRNKNJHHKNMEI            = "zrnknjhhknmei";
    public static final String ZRNKNHHKNMEI             = "zrnknhhknmei";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHHKNSEIYMD            = "zrnhhknseiymd";
    public static final String ZRNKIHONTIKUCD           = "zrnkihontikucd";
    public static final String ZRNKYKSYAADR             = "zrnkyksyaadr";
    public static final String ZRNTSINTELNO             = "zrntsintelno";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNJIKAIPJYUUTOUYM       = "zrnjikaipjyuutouym";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNANNISKCD              = "zrnanniskcd";
    public static final String ZRNHKNMEISYOU15KETA      = "zrnhknmeisyou15keta";
    public static final String ZRNBSYUJDRTENCD1         = "zrnbsyujdrtencd1";
    public static final String ZRNBSYUJBOSYUUCD1        = "zrnbsyujbosyuucd1";
    public static final String ZRNBSYUJDRTENCD2         = "zrnbsyujdrtencd2";
    public static final String ZRNBSYUJBOSYUUCD2        = "zrnbsyujbosyuucd2";
    public static final String ZRNBSYUJDRTENCD3         = "zrnbsyujdrtencd3";
    public static final String ZRNBSYUJBOSYUUCD3        = "zrnbsyujbosyuucd3";
    public static final String ZRNBSYUJDRTENCD4         = "zrnbsyujdrtencd4";
    public static final String ZRNBSYUJBOSYUUCD4        = "zrnbsyujbosyuucd4";
    public static final String ZRNBSYUJDRTENCD5         = "zrnbsyujdrtencd5";
    public static final String ZRNBSYUJBOSYUUCD5        = "zrnbsyujbosyuucd5";
    public static final String ZRNSAISINDRTENCD         = "zrnsaisindrtencd";
    public static final String ZRNSAISINBOSYUUCD        = "zrnsaisinbosyuucd";
    public static final String ZRNKZHURIKAEBANKCD       = "zrnkzhurikaebankcd";
    public static final String ZRNKZHURIKAESITENCD      = "zrnkzhurikaesitencd";
    public static final String ZRNKZHURIKAEYOKINKBN     = "zrnkzhurikaeyokinkbn";
    public static final String ZRNKZHURIKAEKOUZANO      = "zrnkzhurikaekouzano";
    public static final String ZRNHNSYUGKHMIGNNMEI      = "zrnhnsyugkhmignnmei";
    public static final String ZRNYOBIV39               = "zrnyobiv39";

    private final PKZT_KhGinkouMdhnFollowCallRn primaryKey;

    public GenZT_KhGinkouMdhnFollowCallRn() {
        primaryKey = new PKZT_KhGinkouMdhnFollowCallRn();
    }

    public GenZT_KhGinkouMdhnFollowCallRn(String pZrnsyono, String pZrnminyuuym) {
        primaryKey = new PKZT_KhGinkouMdhnFollowCallRn(pZrnsyono, pZrnminyuuym);
    }

    @Transient
    @Override
    public PKZT_KhGinkouMdhnFollowCallRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KhGinkouMdhnFollowCallRn> getMetaClass() {
        return QZT_KhGinkouMdhnFollowCallRn.class;
    }

    @Id
    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnsyorikbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNSYORIKBN)
    public String getZrnsyorikbn() {
        return zrnsyorikbn;
    }

    public void setZrnsyorikbn(String pZrnsyorikbn) {
        zrnsyorikbn = pZrnsyorikbn;
    }

    private Long zrnannaip;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNANNAIP)
    public Long getZrnannaip() {
        return zrnannaip;
    }

    public void setZrnannaip(Long pZrnannaip) {
        zrnannaip = pZrnannaip;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    @Id
    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNMINYUUYM)
    public String getZrnminyuuym() {
        return getPrimaryKey().getZrnminyuuym();
    }

    public void setZrnminyuuym(String pZrnminyuuym) {
        getPrimaryKey().setZrnminyuuym(pZrnminyuuym);
    }

    private String zrnskymd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNSKYMD)
    public String getZrnskymd() {
        return zrnskymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnskymd(String pZrnskymd) {
        zrnskymd = pZrnskymd;
    }

    private Long zrnskhr;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNSKHR)
    public Long getZrnskhr() {
        return zrnskhr;
    }

    public void setZrnskhr(Long pZrnskhr) {
        zrnskhr = pZrnskhr;
    }

    private Long zrnttkekin;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNTTKEKIN)
    public Long getZrnttkekin() {
        return zrnttkekin;
    }

    public void setZrnttkekin(Long pZrnttkekin) {
        zrnttkekin = pZrnttkekin;
    }

    private Long zrnttkeganri;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNTTKEGANRI)
    public Long getZrnttkeganri() {
        return zrnttkeganri;
    }

    public void setZrnttkeganri(Long pZrnttkeganri) {
        zrnttkeganri = pZrnttkeganri;
    }

    private Long zrnttkersk;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNTTKERSK)
    public Long getZrnttkersk() {
        return zrnttkersk;
    }

    public void setZrnttkersk(Long pZrnttkersk) {
        zrnttkersk = pZrnttkersk;
    }

    private String zrnttkeriritu;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNTTKERIRITU)
    public String getZrnttkeriritu() {
        return zrnttkeriritu;
    }

    public void setZrnttkeriritu(String pZrnttkeriritu) {
        zrnttkeriritu = pZrnttkeriritu;
    }

    private String zrnttkejyuutouym;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNTTKEJYUUTOUYM)
    public String getZrnttkejyuutouym() {
        return zrnttkejyuutouym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnttkejyuutouym(String pZrnttkejyuutouym) {
        zrnttkejyuutouym = pZrnttkejyuutouym;
    }

    private String zrnttkejyuutounen;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNTTKEJYUUTOUNEN)
    public String getZrnttkejyuutounen() {
        return zrnttkejyuutounen;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnttkejyuutounen(String pZrnttkejyuutounen) {
        zrnttkejyuutounen = pZrnttkejyuutounen;
    }

    private String zrnttkejyuutoutuki;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNTTKEJYUUTOUTUKI)
    public String getZrnttkejyuutoutuki() {
        return zrnttkejyuutoutuki;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnttkejyuutoutuki(String pZrnttkejyuutoutuki) {
        zrnttkejyuutoutuki = pZrnttkejyuutoutuki;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private String zrnyobiv8x2;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNYOBIV8X2)
    public String getZrnyobiv8x2() {
        return zrnyobiv8x2;
    }

    public void setZrnyobiv8x2(String pZrnyobiv8x2) {
        zrnyobiv8x2 = pZrnyobiv8x2;
    }

    private String zrnyobiv29;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNYOBIV29)
    public String getZrnyobiv29() {
        return zrnyobiv29;
    }

    public void setZrnyobiv29(String pZrnyobiv29) {
        zrnyobiv29 = pZrnyobiv29;
    }

    private String zrnkyksyaskinmeino;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKYKSYASKINMEINO)
    public String getZrnkyksyaskinmeino() {
        return zrnkyksyaskinmeino;
    }

    public void setZrnkyksyaskinmeino(String pZrnkyksyaskinmeino) {
        zrnkyksyaskinmeino = pZrnkyksyaskinmeino;
    }

    private String zrnkyksyaseiymd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKYKSYASEIYMD)
    public String getZrnkyksyaseiymd() {
        return zrnkyksyaseiymd;
    }

    public void setZrnkyksyaseiymd(String pZrnkyksyaseiymd) {
        zrnkyksyaseiymd = pZrnkyksyaseiymd;
    }

    private String zrnkyknmhnykkbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKYKNMHNYKKBN)
    public String getZrnkyknmhnykkbn() {
        return zrnkyknmhnykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkyknmhnykkbn(String pZrnkyknmhnykkbn) {
        zrnkyknmhnykkbn = pZrnkyknmhnykkbn;
    }

    private String zrnkjkyknm35keta;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKJKYKNM35KETA)
    public String getZrnkjkyknm35keta() {
        return zrnkjkyknm35keta;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm35keta(String pZrnkjkyknm35keta) {
        zrnkjkyknm35keta = pZrnkjkyknm35keta;
    }

    private String zrnknkyksyamei;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKNKYKSYAMEI)
    public String getZrnknkyksyamei() {
        return zrnknkyksyamei;
    }

    public void setZrnknkyksyamei(String pZrnknkyksyamei) {
        zrnknkyksyamei = pZrnknkyksyamei;
    }

    private String zrnhhknnmhnykkbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNHHKNNMHNYKKBN)
    public String getZrnhhknnmhnykkbn() {
        return zrnhhknnmhnykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhhknnmhnykkbn(String pZrnhhknnmhnykkbn) {
        zrnhhknnmhnykkbn = pZrnhhknnmhnykkbn;
    }

    private String zrnknjhhknmei;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKNJHHKNMEI)
    public String getZrnknjhhknmei() {
        return zrnknjhhknmei;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei(String pZrnknjhhknmei) {
        zrnknjhhknmei = pZrnknjhhknmei;
    }

    private String zrnknhhknmei;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKNHHKNMEI)
    public String getZrnknhhknmei() {
        return zrnknhhknmei;
    }

    public void setZrnknhhknmei(String pZrnknhhknmei) {
        zrnknhhknmei = pZrnknhhknmei;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrnkihontikucd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKIHONTIKUCD)
    public String getZrnkihontikucd() {
        return zrnkihontikucd;
    }

    public void setZrnkihontikucd(String pZrnkihontikucd) {
        zrnkihontikucd = pZrnkihontikucd;
    }

    private String zrnkyksyaadr;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKYKSYAADR)
    public String getZrnkyksyaadr() {
        return zrnkyksyaadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyksyaadr(String pZrnkyksyaadr) {
        zrnkyksyaadr = pZrnkyksyaadr;
    }

    private String zrntsintelno;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNTSINTELNO)
    public String getZrntsintelno() {
        return zrntsintelno;
    }

    public void setZrntsintelno(String pZrntsintelno) {
        zrntsintelno = pZrntsintelno;
    }

    private String zrnkykymd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnjikaipjyuutouym;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNJIKAIPJYUUTOUYM)
    public String getZrnjikaipjyuutouym() {
        return zrnjikaipjyuutouym;
    }

    public void setZrnjikaipjyuutouym(String pZrnjikaipjyuutouym) {
        zrnjikaipjyuutouym = pZrnjikaipjyuutouym;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnanniskcd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNANNISKCD)
    public String getZrnanniskcd() {
        return zrnanniskcd;
    }

    public void setZrnanniskcd(String pZrnanniskcd) {
        zrnanniskcd = pZrnanniskcd;
    }

    private String zrnhknmeisyou15keta;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNHKNMEISYOU15KETA)
    public String getZrnhknmeisyou15keta() {
        return zrnhknmeisyou15keta;
    }

    @DataConvert("toMultiByte")
    public void setZrnhknmeisyou15keta(String pZrnhknmeisyou15keta) {
        zrnhknmeisyou15keta = pZrnhknmeisyou15keta;
    }

    private String zrnbsyujdrtencd1;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNBSYUJDRTENCD1)
    public String getZrnbsyujdrtencd1() {
        return zrnbsyujdrtencd1;
    }

    public void setZrnbsyujdrtencd1(String pZrnbsyujdrtencd1) {
        zrnbsyujdrtencd1 = pZrnbsyujdrtencd1;
    }

    private String zrnbsyujbosyuucd1;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNBSYUJBOSYUUCD1)
    public String getZrnbsyujbosyuucd1() {
        return zrnbsyujbosyuucd1;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnbsyujbosyuucd1(String pZrnbsyujbosyuucd1) {
        zrnbsyujbosyuucd1 = pZrnbsyujbosyuucd1;
    }

    private String zrnbsyujdrtencd2;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNBSYUJDRTENCD2)
    public String getZrnbsyujdrtencd2() {
        return zrnbsyujdrtencd2;
    }

    public void setZrnbsyujdrtencd2(String pZrnbsyujdrtencd2) {
        zrnbsyujdrtencd2 = pZrnbsyujdrtencd2;
    }

    private String zrnbsyujbosyuucd2;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNBSYUJBOSYUUCD2)
    public String getZrnbsyujbosyuucd2() {
        return zrnbsyujbosyuucd2;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnbsyujbosyuucd2(String pZrnbsyujbosyuucd2) {
        zrnbsyujbosyuucd2 = pZrnbsyujbosyuucd2;
    }

    private String zrnbsyujdrtencd3;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNBSYUJDRTENCD3)
    public String getZrnbsyujdrtencd3() {
        return zrnbsyujdrtencd3;
    }

    public void setZrnbsyujdrtencd3(String pZrnbsyujdrtencd3) {
        zrnbsyujdrtencd3 = pZrnbsyujdrtencd3;
    }

    private String zrnbsyujbosyuucd3;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNBSYUJBOSYUUCD3)
    public String getZrnbsyujbosyuucd3() {
        return zrnbsyujbosyuucd3;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnbsyujbosyuucd3(String pZrnbsyujbosyuucd3) {
        zrnbsyujbosyuucd3 = pZrnbsyujbosyuucd3;
    }

    private String zrnbsyujdrtencd4;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNBSYUJDRTENCD4)
    public String getZrnbsyujdrtencd4() {
        return zrnbsyujdrtencd4;
    }

    public void setZrnbsyujdrtencd4(String pZrnbsyujdrtencd4) {
        zrnbsyujdrtencd4 = pZrnbsyujdrtencd4;
    }

    private String zrnbsyujbosyuucd4;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNBSYUJBOSYUUCD4)
    public String getZrnbsyujbosyuucd4() {
        return zrnbsyujbosyuucd4;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnbsyujbosyuucd4(String pZrnbsyujbosyuucd4) {
        zrnbsyujbosyuucd4 = pZrnbsyujbosyuucd4;
    }

    private String zrnbsyujdrtencd5;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNBSYUJDRTENCD5)
    public String getZrnbsyujdrtencd5() {
        return zrnbsyujdrtencd5;
    }

    public void setZrnbsyujdrtencd5(String pZrnbsyujdrtencd5) {
        zrnbsyujdrtencd5 = pZrnbsyujdrtencd5;
    }

    private String zrnbsyujbosyuucd5;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNBSYUJBOSYUUCD5)
    public String getZrnbsyujbosyuucd5() {
        return zrnbsyujbosyuucd5;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnbsyujbosyuucd5(String pZrnbsyujbosyuucd5) {
        zrnbsyujbosyuucd5 = pZrnbsyujbosyuucd5;
    }

    private String zrnsaisindrtencd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNSAISINDRTENCD)
    public String getZrnsaisindrtencd() {
        return zrnsaisindrtencd;
    }

    public void setZrnsaisindrtencd(String pZrnsaisindrtencd) {
        zrnsaisindrtencd = pZrnsaisindrtencd;
    }

    private String zrnsaisinbosyuucd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNSAISINBOSYUUCD)
    public String getZrnsaisinbosyuucd() {
        return zrnsaisinbosyuucd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsaisinbosyuucd(String pZrnsaisinbosyuucd) {
        zrnsaisinbosyuucd = pZrnsaisinbosyuucd;
    }

    private String zrnkzhurikaebankcd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKZHURIKAEBANKCD)
    public String getZrnkzhurikaebankcd() {
        return zrnkzhurikaebankcd;
    }

    public void setZrnkzhurikaebankcd(String pZrnkzhurikaebankcd) {
        zrnkzhurikaebankcd = pZrnkzhurikaebankcd;
    }

    private String zrnkzhurikaesitencd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKZHURIKAESITENCD)
    public String getZrnkzhurikaesitencd() {
        return zrnkzhurikaesitencd;
    }

    public void setZrnkzhurikaesitencd(String pZrnkzhurikaesitencd) {
        zrnkzhurikaesitencd = pZrnkzhurikaesitencd;
    }

    private String zrnkzhurikaeyokinkbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKZHURIKAEYOKINKBN)
    public String getZrnkzhurikaeyokinkbn() {
        return zrnkzhurikaeyokinkbn;
    }

    public void setZrnkzhurikaeyokinkbn(String pZrnkzhurikaeyokinkbn) {
        zrnkzhurikaeyokinkbn = pZrnkzhurikaeyokinkbn;
    }

    private String zrnkzhurikaekouzano;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNKZHURIKAEKOUZANO)
    public String getZrnkzhurikaekouzano() {
        return zrnkzhurikaekouzano;
    }

    public void setZrnkzhurikaekouzano(String pZrnkzhurikaekouzano) {
        zrnkzhurikaekouzano = pZrnkzhurikaekouzano;
    }

    private String zrnhnsyugkhmignnmei;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNHNSYUGKHMIGNNMEI)
    public String getZrnhnsyugkhmignnmei() {
        return zrnhnsyugkhmignnmei;
    }

    public void setZrnhnsyugkhmignnmei(String pZrnhnsyugkhmignnmei) {
        zrnhnsyugkhmignnmei = pZrnhnsyugkhmignnmei;
    }

    private String zrnyobiv39;

    @Column(name=GenZT_KhGinkouMdhnFollowCallRn.ZRNYOBIV39)
    public String getZrnyobiv39() {
        return zrnyobiv39;
    }

    public void setZrnyobiv39(String pZrnyobiv39) {
        zrnyobiv39 = pZrnyobiv39;
    }
}