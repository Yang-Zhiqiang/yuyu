package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.id.PKZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.meta.GenQZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.meta.QZT_DrtenMisyuSkInfoDataTy;

/**
 * 代理店未収・失効情報連動データＦテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DrtenMisyuSkInfoDataTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenMisyuSkInfoDataTy}</td><td colspan="3">代理店未収・失効情報連動データＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_DrtenMisyuSkInfoDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">{@link PKZT_DrtenMisyuSkInfoDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnsyugknjkyksynm ztyhnsyugknjkyksynm}</td><td>（中継用）編集後漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei ztyknjhhknmei}</td><td>（中継用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjyutikbn ztykykjyutikbn}</td><td>（中継用）契約状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinkihontikucd ztytsinkihontikucd}</td><td>（中継用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjitsinkaiadr ztykanjitsinkaiadr}</td><td>（中継用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsintelno ztytsintelno}</td><td>（中継用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tsintelno ztydai2tsintelno}</td><td>（中継用）第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaebankcd ztykzhurikaebankcd}</td><td>（中継用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaesitencd ztykzhurikaesitencd}</td><td>（中継用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeyokinkbn ztykzhurikaeyokinkbn}</td><td>（中継用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaekouzano ztykzhurikaekouzano}</td><td>（中継用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaemeiginm ztykzhurikaemeiginm}</td><td>（中継用）口座振替名義人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6x5 ztyyobiv6x5}</td><td>（中継用）予備項目Ｖ６＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZty1kaip zty1kaip}</td><td>（中継用）１回分保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynexthurikaeyoteigk ztynexthurikaeyoteigk}</td><td>（中継用）次回振替予定金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhrkyykknmnryymd ztyhrkyykknmnryymd}</td><td>（中継用）払込猶予期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskymd ztyskymd}</td><td>（中継用）失効年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjhurikstkkahikbn ztyjhurikstkkahikbn}</td><td>（中継用）自動振替貸付可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhukkatumoskahikbn ztyhukkatumoskahikbn}</td><td>（中継用）復活申込可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdkkigenymd ztyttdkkigenymd}</td><td>（中継用）手続き期限年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhukkatukanoukknmnryymd ztyhukkatukanoukknmnryymd}</td><td>（中継用）復活可能期間満了年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikatukisuu3keta ztykeikatukisuu3keta}</td><td>（中継用）経過月数（３桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyuuhasseiym ztymisyuuhasseiym}</td><td>（中継用）未収発生年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyuujiyuu ztymisyuujiyuu}</td><td>（中継用）未収事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhanteiymd ztyhanteiymd}</td><td>（中継用）判定年月日</td><td align="center">{@link PKZT_DrtenMisyuSkInfoDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynexthurikaeymd ztynexthurikaeymd}</td><td>（中継用）次回振替年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x3 ztyyobiv8x3}</td><td>（中継用）予備項目Ｖ８＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikbn ztyikkatubaraikbn}</td><td>（中継用）一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikaisuu ztyikkatubaraikaisuu}</td><td>（中継用）一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv55 ztyyobiv55}</td><td>（中継用）予備項目Ｖ５５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenMisyuSkInfoDataTy
 * @see     PKZT_DrtenMisyuSkInfoDataTy
 * @see     QZT_DrtenMisyuSkInfoDataTy
 * @see     GenQZT_DrtenMisyuSkInfoDataTy
 */
@MappedSuperclass
@Table(name=GenZT_DrtenMisyuSkInfoDataTy.TABLE_NAME)
@IdClass(value=PKZT_DrtenMisyuSkInfoDataTy.class)
public abstract class GenZT_DrtenMisyuSkInfoDataTy extends AbstractExDBEntity<ZT_DrtenMisyuSkInfoDataTy, PKZT_DrtenMisyuSkInfoDataTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenMisyuSkInfoDataTy";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHNSYUGKNJKYKSYNM      = "ztyhnsyugknjkyksynm";
    public static final String ZTYKNJHHKNMEI            = "ztyknjhhknmei";
    public static final String ZTYKYKJYUTIKBN           = "ztykykjyutikbn";
    public static final String ZTYTSINKIHONTIKUCD       = "ztytsinkihontikucd";
    public static final String ZTYKANJITSINKAIADR       = "ztykanjitsinkaiadr";
    public static final String ZTYTSINTELNO             = "ztytsintelno";
    public static final String ZTYDAI2TSINTELNO         = "ztydai2tsintelno";
    public static final String ZTYKZHURIKAEBANKCD       = "ztykzhurikaebankcd";
    public static final String ZTYKZHURIKAESITENCD      = "ztykzhurikaesitencd";
    public static final String ZTYKZHURIKAEYOKINKBN     = "ztykzhurikaeyokinkbn";
    public static final String ZTYKZHURIKAEKOUZANO      = "ztykzhurikaekouzano";
    public static final String ZTYKZHURIKAEMEIGINM      = "ztykzhurikaemeiginm";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYYOBIV6X5              = "ztyyobiv6x5";
    public static final String ZTY1KAIP                 = "zty1kaip";
    public static final String ZTYNEXTHURIKAEYOTEIGK    = "ztynexthurikaeyoteigk";
    public static final String ZTYHRKYYKKNMNRYYMD       = "ztyhrkyykknmnryymd";
    public static final String ZTYSKYMD                 = "ztyskymd";
    public static final String ZTYJHURIKSTKKAHIKBN      = "ztyjhurikstkkahikbn";
    public static final String ZTYHUKKATUMOSKAHIKBN     = "ztyhukkatumoskahikbn";
    public static final String ZTYTTDKKIGENYMD          = "ztyttdkkigenymd";
    public static final String ZTYHUKKATUKANOUKKNMNRYYMD = "ztyhukkatukanoukknmnryymd";
    public static final String ZTYKEIKATUKISUU3KETA     = "ztykeikatukisuu3keta";
    public static final String ZTYMISYUUHASSEIYM        = "ztymisyuuhasseiym";
    public static final String ZTYMISYUUJIYUU           = "ztymisyuujiyuu";
    public static final String ZTYHANTEIYMD             = "ztyhanteiymd";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYNEXTHURIKAEYMD        = "ztynexthurikaeymd";
    public static final String ZTYYOBIV8X3              = "ztyyobiv8x3";
    public static final String ZTYIKKATUBARAIKBN        = "ztyikkatubaraikbn";
    public static final String ZTYIKKATUBARAIKAISUU     = "ztyikkatubaraikaisuu";
    public static final String ZTYYOBIV55               = "ztyyobiv55";

    private final PKZT_DrtenMisyuSkInfoDataTy primaryKey;

    public GenZT_DrtenMisyuSkInfoDataTy() {
        primaryKey = new PKZT_DrtenMisyuSkInfoDataTy();
    }

    public GenZT_DrtenMisyuSkInfoDataTy(
        String pZtysyono,
        String pZtybsydrtencd,
        String pZtyhanteiymd
    ) {
        primaryKey = new PKZT_DrtenMisyuSkInfoDataTy(
            pZtysyono,
            pZtybsydrtencd,
            pZtyhanteiymd
        );
    }

    @Transient
    @Override
    public PKZT_DrtenMisyuSkInfoDataTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenMisyuSkInfoDataTy> getMetaClass() {
        return QZT_DrtenMisyuSkInfoDataTy.class;
    }

    @Id
    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return getPrimaryKey().getZtybsydrtencd();
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        getPrimaryKey().setZtybsydrtencd(pZtybsydrtencd);
    }

    private String ztykykymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhnsyugknjkyksynm;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYHNSYUGKNJKYKSYNM)
    public String getZtyhnsyugknjkyksynm() {
        return ztyhnsyugknjkyksynm;
    }

    public void setZtyhnsyugknjkyksynm(String pZtyhnsyugknjkyksynm) {
        ztyhnsyugknjkyksynm = pZtyhnsyugknjkyksynm;
    }

    private String ztyknjhhknmei;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYKNJHHKNMEI)
    public String getZtyknjhhknmei() {
        return ztyknjhhknmei;
    }

    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        ztyknjhhknmei = pZtyknjhhknmei;
    }

    private String ztykykjyutikbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYKYKJYUTIKBN)
    public String getZtykykjyutikbn() {
        return ztykykjyutikbn;
    }

    public void setZtykykjyutikbn(String pZtykykjyutikbn) {
        ztykykjyutikbn = pZtykykjyutikbn;
    }

    private String ztytsinkihontikucd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYTSINKIHONTIKUCD)
    public String getZtytsinkihontikucd() {
        return ztytsinkihontikucd;
    }

    public void setZtytsinkihontikucd(String pZtytsinkihontikucd) {
        ztytsinkihontikucd = pZtytsinkihontikucd;
    }

    private String ztykanjitsinkaiadr;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYKANJITSINKAIADR)
    public String getZtykanjitsinkaiadr() {
        return ztykanjitsinkaiadr;
    }

    public void setZtykanjitsinkaiadr(String pZtykanjitsinkaiadr) {
        ztykanjitsinkaiadr = pZtykanjitsinkaiadr;
    }

    private String ztytsintelno;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYTSINTELNO)
    public String getZtytsintelno() {
        return ztytsintelno;
    }

    public void setZtytsintelno(String pZtytsintelno) {
        ztytsintelno = pZtytsintelno;
    }

    private String ztydai2tsintelno;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYDAI2TSINTELNO)
    public String getZtydai2tsintelno() {
        return ztydai2tsintelno;
    }

    public void setZtydai2tsintelno(String pZtydai2tsintelno) {
        ztydai2tsintelno = pZtydai2tsintelno;
    }

    private String ztykzhurikaebankcd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYKZHURIKAEBANKCD)
    public String getZtykzhurikaebankcd() {
        return ztykzhurikaebankcd;
    }

    public void setZtykzhurikaebankcd(String pZtykzhurikaebankcd) {
        ztykzhurikaebankcd = pZtykzhurikaebankcd;
    }

    private String ztykzhurikaesitencd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYKZHURIKAESITENCD)
    public String getZtykzhurikaesitencd() {
        return ztykzhurikaesitencd;
    }

    public void setZtykzhurikaesitencd(String pZtykzhurikaesitencd) {
        ztykzhurikaesitencd = pZtykzhurikaesitencd;
    }

    private String ztykzhurikaeyokinkbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYKZHURIKAEYOKINKBN)
    public String getZtykzhurikaeyokinkbn() {
        return ztykzhurikaeyokinkbn;
    }

    public void setZtykzhurikaeyokinkbn(String pZtykzhurikaeyokinkbn) {
        ztykzhurikaeyokinkbn = pZtykzhurikaeyokinkbn;
    }

    private String ztykzhurikaekouzano;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYKZHURIKAEKOUZANO)
    public String getZtykzhurikaekouzano() {
        return ztykzhurikaekouzano;
    }

    public void setZtykzhurikaekouzano(String pZtykzhurikaekouzano) {
        ztykzhurikaekouzano = pZtykzhurikaekouzano;
    }

    private String ztykzhurikaemeiginm;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYKZHURIKAEMEIGINM)
    public String getZtykzhurikaemeiginm() {
        return ztykzhurikaemeiginm;
    }

    public void setZtykzhurikaemeiginm(String pZtykzhurikaemeiginm) {
        ztykzhurikaemeiginm = pZtykzhurikaemeiginm;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyyobiv6x5;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYYOBIV6X5)
    public String getZtyyobiv6x5() {
        return ztyyobiv6x5;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtyyobiv6x5(String pZtyyobiv6x5) {
        ztyyobiv6x5 = pZtyyobiv6x5;
    }

    private Long zty1kaip;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTY1KAIP)
    public Long getZty1kaip() {
        return zty1kaip;
    }

    public void setZty1kaip(Long pZty1kaip) {
        zty1kaip = pZty1kaip;
    }

    private Long ztynexthurikaeyoteigk;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYNEXTHURIKAEYOTEIGK)
    public Long getZtynexthurikaeyoteigk() {
        return ztynexthurikaeyoteigk;
    }

    public void setZtynexthurikaeyoteigk(Long pZtynexthurikaeyoteigk) {
        ztynexthurikaeyoteigk = pZtynexthurikaeyoteigk;
    }

    private String ztyhrkyykknmnryymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYHRKYYKKNMNRYYMD)
    public String getZtyhrkyykknmnryymd() {
        return ztyhrkyykknmnryymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhrkyykknmnryymd(String pZtyhrkyykknmnryymd) {
        ztyhrkyykknmnryymd = pZtyhrkyykknmnryymd;
    }

    private String ztyskymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYSKYMD)
    public String getZtyskymd() {
        return ztyskymd;
    }

    public void setZtyskymd(String pZtyskymd) {
        ztyskymd = pZtyskymd;
    }

    private String ztyjhurikstkkahikbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYJHURIKSTKKAHIKBN)
    public String getZtyjhurikstkkahikbn() {
        return ztyjhurikstkkahikbn;
    }

    public void setZtyjhurikstkkahikbn(String pZtyjhurikstkkahikbn) {
        ztyjhurikstkkahikbn = pZtyjhurikstkkahikbn;
    }

    private String ztyhukkatumoskahikbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYHUKKATUMOSKAHIKBN)
    public String getZtyhukkatumoskahikbn() {
        return ztyhukkatumoskahikbn;
    }

    public void setZtyhukkatumoskahikbn(String pZtyhukkatumoskahikbn) {
        ztyhukkatumoskahikbn = pZtyhukkatumoskahikbn;
    }

    private String ztyttdkkigenymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYTTDKKIGENYMD)
    public String getZtyttdkkigenymd() {
        return ztyttdkkigenymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyttdkkigenymd(String pZtyttdkkigenymd) {
        ztyttdkkigenymd = pZtyttdkkigenymd;
    }

    private String ztyhukkatukanoukknmnryymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYHUKKATUKANOUKKNMNRYYMD)
    public String getZtyhukkatukanoukknmnryymd() {
        return ztyhukkatukanoukknmnryymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhukkatukanoukknmnryymd(String pZtyhukkatukanoukknmnryymd) {
        ztyhukkatukanoukknmnryymd = pZtyhukkatukanoukknmnryymd;
    }

    private String ztykeikatukisuu3keta;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYKEIKATUKISUU3KETA)
    public String getZtykeikatukisuu3keta() {
        return ztykeikatukisuu3keta;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtykeikatukisuu3keta(String pZtykeikatukisuu3keta) {
        ztykeikatukisuu3keta = pZtykeikatukisuu3keta;
    }

    private String ztymisyuuhasseiym;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYMISYUUHASSEIYM)
    public String getZtymisyuuhasseiym() {
        return ztymisyuuhasseiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtymisyuuhasseiym(String pZtymisyuuhasseiym) {
        ztymisyuuhasseiym = pZtymisyuuhasseiym;
    }

    private String ztymisyuujiyuu;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYMISYUUJIYUU)
    public String getZtymisyuujiyuu() {
        return ztymisyuujiyuu;
    }

    public void setZtymisyuujiyuu(String pZtymisyuujiyuu) {
        ztymisyuujiyuu = pZtymisyuujiyuu;
    }

    @Id
    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYHANTEIYMD)
    public String getZtyhanteiymd() {
        return getPrimaryKey().getZtyhanteiymd();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhanteiymd(String pZtyhanteiymd) {
        getPrimaryKey().setZtyhanteiymd(pZtyhanteiymd);
    }

    private Long ztyyobin11;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private String ztynexthurikaeymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYNEXTHURIKAEYMD)
    public String getZtynexthurikaeymd() {
        return ztynexthurikaeymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtynexthurikaeymd(String pZtynexthurikaeymd) {
        ztynexthurikaeymd = pZtynexthurikaeymd;
    }

    private String ztyyobiv8x3;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYYOBIV8X3)
    public String getZtyyobiv8x3() {
        return ztyyobiv8x3;
    }

    public void setZtyyobiv8x3(String pZtyyobiv8x3) {
        ztyyobiv8x3 = pZtyyobiv8x3;
    }

    private String ztyikkatubaraikbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYIKKATUBARAIKBN)
    public String getZtyikkatubaraikbn() {
        return ztyikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyikkatubaraikbn(String pZtyikkatubaraikbn) {
        ztyikkatubaraikbn = pZtyikkatubaraikbn;
    }

    private String ztyikkatubaraikaisuu;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYIKKATUBARAIKAISUU)
    public String getZtyikkatubaraikaisuu() {
        return ztyikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyikkatubaraikaisuu(String pZtyikkatubaraikaisuu) {
        ztyikkatubaraikaisuu = pZtyikkatubaraikaisuu;
    }

    private String ztyyobiv55;

    @Column(name=GenZT_DrtenMisyuSkInfoDataTy.ZTYYOBIV55)
    public String getZtyyobiv55() {
        return ztyyobiv55;
    }

    public void setZtyyobiv55(String pZtyyobiv55) {
        ztyyobiv55 = pZtyyobiv55;
    }
}