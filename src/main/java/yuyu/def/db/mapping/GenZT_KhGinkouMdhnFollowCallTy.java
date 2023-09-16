package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.id.PKZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.meta.GenQZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.meta.QZT_KhGinkouMdhnFollowCallTy;

/**
 * 銀行窓販フォローコール対象テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KhGinkouMdhnFollowCallTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KhGinkouMdhnFollowCallTy}</td><td colspan="3">銀行窓販フォローコール対象テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KhGinkouMdhnFollowCallTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorikbn ztysyorikbn}</td><td>（中継用）処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaip ztyannaip}</td><td>（中継用）案内保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuuym ztyminyuuym}</td><td>（中継用）未入年月</td><td align="center">{@link PKZT_KhGinkouMdhnFollowCallTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskymd ztyskymd}</td><td>（中継用）失効年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskhr ztyskhr}</td><td>（中継用）失効時返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyttkekin ztyttkekin}</td><td>（中継用）今期立替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyttkeganri ztyttkeganri}</td><td>（中継用）立替元利金合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyttkersk ztyttkersk}</td><td>（中継用）立替利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyttkeriritu ztyttkeriritu}</td><td>（中継用）立替利率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttkejyuutouym ztyttkejyuutouym}</td><td>（中継用）立替充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttkejyuutounen ztyttkejyuutounen}</td><td>（中継用）立替充当年数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttkejyuutoutuki ztyttkejyuutoutuki}</td><td>（中継用）立替充当月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x2 ztyyobiv8x2}</td><td>（中継用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv29 ztyyobiv29}</td><td>（中継用）予備項目Ｖ２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaskinmeino ztykyksyaskinmeino}</td><td>（中継用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseiymd ztykyksyaseiymd}</td><td>（中継用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmhnykkbn ztykyknmhnykkbn}</td><td>（中継用）契約者名翻訳結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm35keta ztykjkyknm35keta}</td><td>（中継用）漢字契約者名（３５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkyksyamei ztyknkyksyamei}</td><td>（中継用）カナ契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmhnykkbn ztyhhknnmhnykkbn}</td><td>（中継用）被保険者名翻訳結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei ztyknjhhknmei}</td><td>（中継用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknhhknmei ztyknhhknmei}</td><td>（中継用）カナ被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihontikucd ztykihontikucd}</td><td>（中継用）基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaadr ztykyksyaadr}</td><td>（中継用）契約者住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsintelno ztytsintelno}</td><td>（中継用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym ztyjikaipjyuutouym}</td><td>（中継用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyanniskcd ztyanniskcd}</td><td>（中継用）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknmeisyou15keta ztyhknmeisyou15keta}</td><td>（中継用）保険名称（１５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyujdrtencd1 ztybsyujdrtencd1}</td><td>（中継用）募集時代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyujbosyuucd1 ztybsyujbosyuucd1}</td><td>（中継用）募集時募集人コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyujdrtencd2 ztybsyujdrtencd2}</td><td>（中継用）募集時代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyujbosyuucd2 ztybsyujbosyuucd2}</td><td>（中継用）募集時募集人コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyujdrtencd3 ztybsyujdrtencd3}</td><td>（中継用）募集時代理店コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyujbosyuucd3 ztybsyujbosyuucd3}</td><td>（中継用）募集時募集人コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyujdrtencd4 ztybsyujdrtencd4}</td><td>（中継用）募集時代理店コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyujbosyuucd4 ztybsyujbosyuucd4}</td><td>（中継用）募集時募集人コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyujdrtencd5 ztybsyujdrtencd5}</td><td>（中継用）募集時代理店コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyujbosyuucd5 ztybsyujbosyuucd5}</td><td>（中継用）募集時募集人コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisindrtencd ztysaisindrtencd}</td><td>（中継用）最新代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisinbosyuucd ztysaisinbosyuucd}</td><td>（中継用）最新募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaebankcd ztykzhurikaebankcd}</td><td>（中継用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaesitencd ztykzhurikaesitencd}</td><td>（中継用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeyokinkbn ztykzhurikaeyokinkbn}</td><td>（中継用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaekouzano ztykzhurikaekouzano}</td><td>（中継用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnsyugkhmignnmei ztyhnsyugkhmignnmei}</td><td>（中継用）編集後口座振替名義人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv39 ztyyobiv39}</td><td>（中継用）予備項目Ｖ３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KhGinkouMdhnFollowCallTy
 * @see     PKZT_KhGinkouMdhnFollowCallTy
 * @see     QZT_KhGinkouMdhnFollowCallTy
 * @see     GenQZT_KhGinkouMdhnFollowCallTy
 */
@MappedSuperclass
@Table(name=GenZT_KhGinkouMdhnFollowCallTy.TABLE_NAME)
@IdClass(value=PKZT_KhGinkouMdhnFollowCallTy.class)
public abstract class GenZT_KhGinkouMdhnFollowCallTy extends AbstractExDBEntity<ZT_KhGinkouMdhnFollowCallTy, PKZT_KhGinkouMdhnFollowCallTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KhGinkouMdhnFollowCallTy";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYSYORIKBN              = "ztysyorikbn";
    public static final String ZTYANNAIP                = "ztyannaip";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYMINYUUYM              = "ztyminyuuym";
    public static final String ZTYSKYMD                 = "ztyskymd";
    public static final String ZTYSKHR                  = "ztyskhr";
    public static final String ZTYTTKEKIN               = "ztyttkekin";
    public static final String ZTYTTKEGANRI             = "ztyttkeganri";
    public static final String ZTYTTKERSK               = "ztyttkersk";
    public static final String ZTYTTKERIRITU            = "ztyttkeriritu";
    public static final String ZTYTTKEJYUUTOUYM         = "ztyttkejyuutouym";
    public static final String ZTYTTKEJYUUTOUNEN        = "ztyttkejyuutounen";
    public static final String ZTYTTKEJYUUTOUTUKI       = "ztyttkejyuutoutuki";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIV8X2              = "ztyyobiv8x2";
    public static final String ZTYYOBIV29               = "ztyyobiv29";
    public static final String ZTYKYKSYASKINMEINO       = "ztykyksyaskinmeino";
    public static final String ZTYKYKSYASEIYMD          = "ztykyksyaseiymd";
    public static final String ZTYKYKNMHNYKKBN          = "ztykyknmhnykkbn";
    public static final String ZTYKJKYKNM35KETA         = "ztykjkyknm35keta";
    public static final String ZTYKNKYKSYAMEI           = "ztyknkyksyamei";
    public static final String ZTYHHKNNMHNYKKBN         = "ztyhhknnmhnykkbn";
    public static final String ZTYKNJHHKNMEI            = "ztyknjhhknmei";
    public static final String ZTYKNHHKNMEI             = "ztyknhhknmei";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYKIHONTIKUCD           = "ztykihontikucd";
    public static final String ZTYKYKSYAADR             = "ztykyksyaadr";
    public static final String ZTYTSINTELNO             = "ztytsintelno";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYJIKAIPJYUUTOUYM       = "ztyjikaipjyuutouym";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYANNISKCD              = "ztyanniskcd";
    public static final String ZTYHKNMEISYOU15KETA      = "ztyhknmeisyou15keta";
    public static final String ZTYBSYUJDRTENCD1         = "ztybsyujdrtencd1";
    public static final String ZTYBSYUJBOSYUUCD1        = "ztybsyujbosyuucd1";
    public static final String ZTYBSYUJDRTENCD2         = "ztybsyujdrtencd2";
    public static final String ZTYBSYUJBOSYUUCD2        = "ztybsyujbosyuucd2";
    public static final String ZTYBSYUJDRTENCD3         = "ztybsyujdrtencd3";
    public static final String ZTYBSYUJBOSYUUCD3        = "ztybsyujbosyuucd3";
    public static final String ZTYBSYUJDRTENCD4         = "ztybsyujdrtencd4";
    public static final String ZTYBSYUJBOSYUUCD4        = "ztybsyujbosyuucd4";
    public static final String ZTYBSYUJDRTENCD5         = "ztybsyujdrtencd5";
    public static final String ZTYBSYUJBOSYUUCD5        = "ztybsyujbosyuucd5";
    public static final String ZTYSAISINDRTENCD         = "ztysaisindrtencd";
    public static final String ZTYSAISINBOSYUUCD        = "ztysaisinbosyuucd";
    public static final String ZTYKZHURIKAEBANKCD       = "ztykzhurikaebankcd";
    public static final String ZTYKZHURIKAESITENCD      = "ztykzhurikaesitencd";
    public static final String ZTYKZHURIKAEYOKINKBN     = "ztykzhurikaeyokinkbn";
    public static final String ZTYKZHURIKAEKOUZANO      = "ztykzhurikaekouzano";
    public static final String ZTYHNSYUGKHMIGNNMEI      = "ztyhnsyugkhmignnmei";
    public static final String ZTYYOBIV39               = "ztyyobiv39";

    private final PKZT_KhGinkouMdhnFollowCallTy primaryKey;

    public GenZT_KhGinkouMdhnFollowCallTy() {
        primaryKey = new PKZT_KhGinkouMdhnFollowCallTy();
    }

    public GenZT_KhGinkouMdhnFollowCallTy(String pZtysyono, String pZtyminyuuym) {
        primaryKey = new PKZT_KhGinkouMdhnFollowCallTy(pZtysyono, pZtyminyuuym);
    }

    @Transient
    @Override
    public PKZT_KhGinkouMdhnFollowCallTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KhGinkouMdhnFollowCallTy> getMetaClass() {
        return QZT_KhGinkouMdhnFollowCallTy.class;
    }

    @Id
    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztysyorikbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYSYORIKBN)
    public String getZtysyorikbn() {
        return ztysyorikbn;
    }

    public void setZtysyorikbn(String pZtysyorikbn) {
        ztysyorikbn = pZtysyorikbn;
    }

    private Long ztyannaip;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYANNAIP)
    public Long getZtyannaip() {
        return ztyannaip;
    }

    public void setZtyannaip(Long pZtyannaip) {
        ztyannaip = pZtyannaip;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    @Id
    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYMINYUUYM)
    public String getZtyminyuuym() {
        return getPrimaryKey().getZtyminyuuym();
    }

    public void setZtyminyuuym(String pZtyminyuuym) {
        getPrimaryKey().setZtyminyuuym(pZtyminyuuym);
    }

    private String ztyskymd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYSKYMD)
    public String getZtyskymd() {
        return ztyskymd;
    }

    public void setZtyskymd(String pZtyskymd) {
        ztyskymd = pZtyskymd;
    }

    private Long ztyskhr;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYSKHR)
    public Long getZtyskhr() {
        return ztyskhr;
    }

    public void setZtyskhr(Long pZtyskhr) {
        ztyskhr = pZtyskhr;
    }

    private Long ztyttkekin;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYTTKEKIN)
    public Long getZtyttkekin() {
        return ztyttkekin;
    }

    public void setZtyttkekin(Long pZtyttkekin) {
        ztyttkekin = pZtyttkekin;
    }

    private Long ztyttkeganri;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYTTKEGANRI)
    public Long getZtyttkeganri() {
        return ztyttkeganri;
    }

    public void setZtyttkeganri(Long pZtyttkeganri) {
        ztyttkeganri = pZtyttkeganri;
    }

    private Long ztyttkersk;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYTTKERSK)
    public Long getZtyttkersk() {
        return ztyttkersk;
    }

    public void setZtyttkersk(Long pZtyttkersk) {
        ztyttkersk = pZtyttkersk;
    }

    private String ztyttkeriritu;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYTTKERIRITU)
    public String getZtyttkeriritu() {
        return ztyttkeriritu;
    }

    public void setZtyttkeriritu(String pZtyttkeriritu) {
        ztyttkeriritu = pZtyttkeriritu;
    }

    private String ztyttkejyuutouym;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYTTKEJYUUTOUYM)
    public String getZtyttkejyuutouym() {
        return ztyttkejyuutouym;
    }

    public void setZtyttkejyuutouym(String pZtyttkejyuutouym) {
        ztyttkejyuutouym = pZtyttkejyuutouym;
    }

    private String ztyttkejyuutounen;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYTTKEJYUUTOUNEN)
    public String getZtyttkejyuutounen() {
        return ztyttkejyuutounen;
    }

    public void setZtyttkejyuutounen(String pZtyttkejyuutounen) {
        ztyttkejyuutounen = pZtyttkejyuutounen;
    }

    private String ztyttkejyuutoutuki;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYTTKEJYUUTOUTUKI)
    public String getZtyttkejyuutoutuki() {
        return ztyttkejyuutoutuki;
    }

    public void setZtyttkejyuutoutuki(String pZtyttkejyuutoutuki) {
        ztyttkejyuutoutuki = pZtyttkejyuutoutuki;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private String ztyyobiv8x2;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYYOBIV8X2)
    public String getZtyyobiv8x2() {
        return ztyyobiv8x2;
    }

    public void setZtyyobiv8x2(String pZtyyobiv8x2) {
        ztyyobiv8x2 = pZtyyobiv8x2;
    }

    private String ztyyobiv29;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYYOBIV29)
    public String getZtyyobiv29() {
        return ztyyobiv29;
    }

    public void setZtyyobiv29(String pZtyyobiv29) {
        ztyyobiv29 = pZtyyobiv29;
    }

    private String ztykyksyaskinmeino;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKYKSYASKINMEINO)
    public String getZtykyksyaskinmeino() {
        return ztykyksyaskinmeino;
    }

    public void setZtykyksyaskinmeino(String pZtykyksyaskinmeino) {
        ztykyksyaskinmeino = pZtykyksyaskinmeino;
    }

    private String ztykyksyaseiymd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKYKSYASEIYMD)
    public String getZtykyksyaseiymd() {
        return ztykyksyaseiymd;
    }

    public void setZtykyksyaseiymd(String pZtykyksyaseiymd) {
        ztykyksyaseiymd = pZtykyksyaseiymd;
    }

    private String ztykyknmhnykkbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKYKNMHNYKKBN)
    public String getZtykyknmhnykkbn() {
        return ztykyknmhnykkbn;
    }

    public void setZtykyknmhnykkbn(String pZtykyknmhnykkbn) {
        ztykyknmhnykkbn = pZtykyknmhnykkbn;
    }

    private String ztykjkyknm35keta;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKJKYKNM35KETA)
    public String getZtykjkyknm35keta() {
        return ztykjkyknm35keta;
    }

    public void setZtykjkyknm35keta(String pZtykjkyknm35keta) {
        ztykjkyknm35keta = pZtykjkyknm35keta;
    }

    private String ztyknkyksyamei;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKNKYKSYAMEI)
    public String getZtyknkyksyamei() {
        return ztyknkyksyamei;
    }

    public void setZtyknkyksyamei(String pZtyknkyksyamei) {
        ztyknkyksyamei = pZtyknkyksyamei;
    }

    private String ztyhhknnmhnykkbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYHHKNNMHNYKKBN)
    public String getZtyhhknnmhnykkbn() {
        return ztyhhknnmhnykkbn;
    }

    public void setZtyhhknnmhnykkbn(String pZtyhhknnmhnykkbn) {
        ztyhhknnmhnykkbn = pZtyhhknnmhnykkbn;
    }

    private String ztyknjhhknmei;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKNJHHKNMEI)
    public String getZtyknjhhknmei() {
        return ztyknjhhknmei;
    }

    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        ztyknjhhknmei = pZtyknjhhknmei;
    }

    private String ztyknhhknmei;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKNHHKNMEI)
    public String getZtyknhhknmei() {
        return ztyknhhknmei;
    }

    public void setZtyknhhknmei(String pZtyknhhknmei) {
        ztyknhhknmei = pZtyknhhknmei;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztykihontikucd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKIHONTIKUCD)
    public String getZtykihontikucd() {
        return ztykihontikucd;
    }

    public void setZtykihontikucd(String pZtykihontikucd) {
        ztykihontikucd = pZtykihontikucd;
    }

    private String ztykyksyaadr;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKYKSYAADR)
    public String getZtykyksyaadr() {
        return ztykyksyaadr;
    }

    public void setZtykyksyaadr(String pZtykyksyaadr) {
        ztykyksyaadr = pZtykyksyaadr;
    }

    private String ztytsintelno;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYTSINTELNO)
    public String getZtytsintelno() {
        return ztytsintelno;
    }

    public void setZtytsintelno(String pZtytsintelno) {
        ztytsintelno = pZtytsintelno;
    }

    private String ztykykymd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyjikaipjyuutouym;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYJIKAIPJYUUTOUYM)
    public String getZtyjikaipjyuutouym() {
        return ztyjikaipjyuutouym;
    }

    public void setZtyjikaipjyuutouym(String pZtyjikaipjyuutouym) {
        ztyjikaipjyuutouym = pZtyjikaipjyuutouym;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyanniskcd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private String ztyhknmeisyou15keta;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYHKNMEISYOU15KETA)
    public String getZtyhknmeisyou15keta() {
        return ztyhknmeisyou15keta;
    }

    public void setZtyhknmeisyou15keta(String pZtyhknmeisyou15keta) {
        ztyhknmeisyou15keta = pZtyhknmeisyou15keta;
    }

    private String ztybsyujdrtencd1;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYBSYUJDRTENCD1)
    public String getZtybsyujdrtencd1() {
        return ztybsyujdrtencd1;
    }

    public void setZtybsyujdrtencd1(String pZtybsyujdrtencd1) {
        ztybsyujdrtencd1 = pZtybsyujdrtencd1;
    }

    private String ztybsyujbosyuucd1;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYBSYUJBOSYUUCD1)
    public String getZtybsyujbosyuucd1() {
        return ztybsyujbosyuucd1;
    }

    public void setZtybsyujbosyuucd1(String pZtybsyujbosyuucd1) {
        ztybsyujbosyuucd1 = pZtybsyujbosyuucd1;
    }

    private String ztybsyujdrtencd2;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYBSYUJDRTENCD2)
    public String getZtybsyujdrtencd2() {
        return ztybsyujdrtencd2;
    }

    public void setZtybsyujdrtencd2(String pZtybsyujdrtencd2) {
        ztybsyujdrtencd2 = pZtybsyujdrtencd2;
    }

    private String ztybsyujbosyuucd2;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYBSYUJBOSYUUCD2)
    public String getZtybsyujbosyuucd2() {
        return ztybsyujbosyuucd2;
    }

    public void setZtybsyujbosyuucd2(String pZtybsyujbosyuucd2) {
        ztybsyujbosyuucd2 = pZtybsyujbosyuucd2;
    }

    private String ztybsyujdrtencd3;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYBSYUJDRTENCD3)
    public String getZtybsyujdrtencd3() {
        return ztybsyujdrtencd3;
    }

    public void setZtybsyujdrtencd3(String pZtybsyujdrtencd3) {
        ztybsyujdrtencd3 = pZtybsyujdrtencd3;
    }

    private String ztybsyujbosyuucd3;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYBSYUJBOSYUUCD3)
    public String getZtybsyujbosyuucd3() {
        return ztybsyujbosyuucd3;
    }

    public void setZtybsyujbosyuucd3(String pZtybsyujbosyuucd3) {
        ztybsyujbosyuucd3 = pZtybsyujbosyuucd3;
    }

    private String ztybsyujdrtencd4;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYBSYUJDRTENCD4)
    public String getZtybsyujdrtencd4() {
        return ztybsyujdrtencd4;
    }

    public void setZtybsyujdrtencd4(String pZtybsyujdrtencd4) {
        ztybsyujdrtencd4 = pZtybsyujdrtencd4;
    }

    private String ztybsyujbosyuucd4;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYBSYUJBOSYUUCD4)
    public String getZtybsyujbosyuucd4() {
        return ztybsyujbosyuucd4;
    }

    public void setZtybsyujbosyuucd4(String pZtybsyujbosyuucd4) {
        ztybsyujbosyuucd4 = pZtybsyujbosyuucd4;
    }

    private String ztybsyujdrtencd5;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYBSYUJDRTENCD5)
    public String getZtybsyujdrtencd5() {
        return ztybsyujdrtencd5;
    }

    public void setZtybsyujdrtencd5(String pZtybsyujdrtencd5) {
        ztybsyujdrtencd5 = pZtybsyujdrtencd5;
    }

    private String ztybsyujbosyuucd5;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYBSYUJBOSYUUCD5)
    public String getZtybsyujbosyuucd5() {
        return ztybsyujbosyuucd5;
    }

    public void setZtybsyujbosyuucd5(String pZtybsyujbosyuucd5) {
        ztybsyujbosyuucd5 = pZtybsyujbosyuucd5;
    }

    private String ztysaisindrtencd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYSAISINDRTENCD)
    public String getZtysaisindrtencd() {
        return ztysaisindrtencd;
    }

    public void setZtysaisindrtencd(String pZtysaisindrtencd) {
        ztysaisindrtencd = pZtysaisindrtencd;
    }

    private String ztysaisinbosyuucd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYSAISINBOSYUUCD)
    public String getZtysaisinbosyuucd() {
        return ztysaisinbosyuucd;
    }

    public void setZtysaisinbosyuucd(String pZtysaisinbosyuucd) {
        ztysaisinbosyuucd = pZtysaisinbosyuucd;
    }

    private String ztykzhurikaebankcd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKZHURIKAEBANKCD)
    public String getZtykzhurikaebankcd() {
        return ztykzhurikaebankcd;
    }

    public void setZtykzhurikaebankcd(String pZtykzhurikaebankcd) {
        ztykzhurikaebankcd = pZtykzhurikaebankcd;
    }

    private String ztykzhurikaesitencd;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKZHURIKAESITENCD)
    public String getZtykzhurikaesitencd() {
        return ztykzhurikaesitencd;
    }

    public void setZtykzhurikaesitencd(String pZtykzhurikaesitencd) {
        ztykzhurikaesitencd = pZtykzhurikaesitencd;
    }

    private String ztykzhurikaeyokinkbn;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKZHURIKAEYOKINKBN)
    public String getZtykzhurikaeyokinkbn() {
        return ztykzhurikaeyokinkbn;
    }

    public void setZtykzhurikaeyokinkbn(String pZtykzhurikaeyokinkbn) {
        ztykzhurikaeyokinkbn = pZtykzhurikaeyokinkbn;
    }

    private String ztykzhurikaekouzano;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYKZHURIKAEKOUZANO)
    public String getZtykzhurikaekouzano() {
        return ztykzhurikaekouzano;
    }

    public void setZtykzhurikaekouzano(String pZtykzhurikaekouzano) {
        ztykzhurikaekouzano = pZtykzhurikaekouzano;
    }

    private String ztyhnsyugkhmignnmei;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYHNSYUGKHMIGNNMEI)
    public String getZtyhnsyugkhmignnmei() {
        return ztyhnsyugkhmignnmei;
    }

    public void setZtyhnsyugkhmignnmei(String pZtyhnsyugkhmignnmei) {
        ztyhnsyugkhmignnmei = pZtyhnsyugkhmignnmei;
    }

    private String ztyyobiv39;

    @Column(name=GenZT_KhGinkouMdhnFollowCallTy.ZTYYOBIV39)
    public String getZtyyobiv39() {
        return ztyyobiv39;
    }

    public void setZtyyobiv39(String pZtyyobiv39) {
        ztyyobiv39 = pZtyyobiv39;
    }
}