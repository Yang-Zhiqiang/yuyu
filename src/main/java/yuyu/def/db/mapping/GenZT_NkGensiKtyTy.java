package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_NkGensiKtyTy;
import yuyu.def.db.id.PKZT_NkGensiKtyTy;
import yuyu.def.db.meta.GenQZT_NkGensiKtyTy;
import yuyu.def.db.meta.QZT_NkGensiKtyTy;

/**
 * 年金原資Ｆ期中報告用テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_NkGensiKtyTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkGensiKtyTy}</td><td colspan="3">年金原資Ｆ期中報告用テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_NkGensiKtyTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysystemcd ztysystemcd}</td><td>（中継用）システムコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyulfkbn ztyulfkbn}</td><td>（中継用）ＵＬＦ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordkihonkbn ztyrecordkihonkbn}</td><td>（中継用）レコード基本区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyousyono ztynksyousyono}</td><td>（中継用）年金証書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordkbn ztyrecordkbn}</td><td>（中継用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidouymd ztyidouymd}</td><td>（中継用）異動日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouin ztysyouin}</td><td>（中継用）消因</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikbn ztynksyuruikbn}</td><td>（中継用）年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkbn ztynenkinkbn}</td><td>（中継用）年金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinsyu ztynenkinsyu}</td><td>（中継用）年金種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkaisikbn ztynenkinkaisikbn}</td><td>（中継用）年金開始区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuymd ztykeiyakuymd}</td><td>（中継用）契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokainenkinsiharaiymd ztysyokainenkinsiharaiymd}</td><td>（中継用）初回年金支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknshry ztynknshry}</td><td>（中継用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinhosyoukikan ztynenkinhosyoukikan}</td><td>（中継用）年金保証期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhnnkgk ztykhnnkgk}</td><td>（中継用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaisyuukousinymd ztysaisyuukousinymd}</td><td>（中継用）最終更新日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisyuukousinsyoricd ztysaisyuukousinsyoricd}</td><td>（中継用）最終更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkihonctr ztynenkinkihonctr}</td><td>（中継用）年金基本ＣＴＲ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycurrentday ztycurrentday}</td><td>（中継用）現在日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycurrenttime ztycurrenttime}</td><td>（中継用）現在時刻</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykessanjibikinkbn ztykessanjibikinkbn}</td><td>（中継用）決算時備金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyoumetucd ztynksyoumetucd}</td><td>（中継用）年金消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyoumetuymd ztynksyoumetuymd}</td><td>（中継用）年金消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouryokuhasseiymd ztykouryokuhasseiymd}</td><td>（中継用）効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingakuzoukanaiyoukbn ztykingakuzoukanaiyoukbn}</td><td>（中継用）金額増加内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymotokeiyakusyouhinkbn ztymotokeiyakusyouhinkbn}</td><td>（中継用）元契約商品区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkigousedaikbn ztynenkinkigousedaikbn}</td><td>（中継用）年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrrthendounkyoteirrt ztyrrthendounkyoteirrt}</td><td>（中継用）利率変動年金予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyrrthendounksitihsyurrt ztyrrthendounksitihsyurrt}</td><td>（中継用）利率変動年金最低保証利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyhenkoumaekihonnenkingaku ztyhenkoumaekihonnenkingaku}</td><td>（中継用）変更前基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkingensino ztynenkingensino}</td><td>（中継用）年金原資番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkingensinaiyoukbn ztynenkingensinaiyoukbn}</td><td>（中継用）年金原資内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkkikingk ztynkkikingk}</td><td>（中継用）年金基金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygensinaiyoukihonnkgk ztygensinaiyoukihonnkgk}</td><td>（中継用）原資内容基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynewmoneygaku ztynewmoneygaku}</td><td>（中継用）ニューマネー額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkingensihasseiymd ztynenkingensihasseiymd}</td><td>（中継用）年金原資発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydkeisanyounenkingaku ztydkeisanyounenkingaku}</td><td>（中継用）Ｄ計算用年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykgynkyouzeiseitkkaksjgns ztykgynkyouzeiseitkkaksjgns}</td><td>（中継用）企業年金用税制適格開始時原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_NkGensiKtyTy
 * @see     PKZT_NkGensiKtyTy
 * @see     QZT_NkGensiKtyTy
 * @see     GenQZT_NkGensiKtyTy
 */
@MappedSuperclass
@Table(name=GenZT_NkGensiKtyTy.TABLE_NAME)
@IdClass(value=PKZT_NkGensiKtyTy.class)
public abstract class GenZT_NkGensiKtyTy extends AbstractExDBEntity<ZT_NkGensiKtyTy, PKZT_NkGensiKtyTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NkGensiKtyTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYSYSTEMCD              = "ztysystemcd";
    public static final String ZTYULFKBN                = "ztyulfkbn";
    public static final String ZTYRECORDKIHONKBN        = "ztyrecordkihonkbn";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYNKSYOUSYONO           = "ztynksyousyono";
    public static final String ZTYRECORDKBN             = "ztyrecordkbn";
    public static final String ZTYIDOUYMD               = "ztyidouymd";
    public static final String ZTYSYOUIN                = "ztysyouin";
    public static final String ZTYNKSYURUIKBN           = "ztynksyuruikbn";
    public static final String ZTYNENKINKBN             = "ztynenkinkbn";
    public static final String ZTYNENKINSYU             = "ztynenkinsyu";
    public static final String ZTYNENKINKAISIKBN        = "ztynenkinkaisikbn";
    public static final String ZTYKEIYAKUYMD            = "ztykeiyakuymd";
    public static final String ZTYSYOKAINENKINSIHARAIYMD = "ztysyokainenkinsiharaiymd";
    public static final String ZTYNKNSHRY               = "ztynknshry";
    public static final String ZTYNENKINHOSYOUKIKAN     = "ztynenkinhosyoukikan";
    public static final String ZTYKHNNKGK               = "ztykhnnkgk";
    public static final String ZTYSAISYUUKOUSINYMD      = "ztysaisyuukousinymd";
    public static final String ZTYSAISYUUKOUSINSYORICD  = "ztysaisyuukousinsyoricd";
    public static final String ZTYNENKINKIHONCTR        = "ztynenkinkihonctr";
    public static final String ZTYCURRENTDAY            = "ztycurrentday";
    public static final String ZTYCURRENTTIME           = "ztycurrenttime";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYKESSANJIBIKINKBN      = "ztykessanjibikinkbn";
    public static final String ZTYNKSYOUMETUCD          = "ztynksyoumetucd";
    public static final String ZTYNKSYOUMETUYMD         = "ztynksyoumetuymd";
    public static final String ZTYKOURYOKUHASSEIYMD     = "ztykouryokuhasseiymd";
    public static final String ZTYKINGAKUZOUKANAIYOUKBN = "ztykingakuzoukanaiyoukbn";
    public static final String ZTYMOTOKEIYAKUSYOUHINKBN = "ztymotokeiyakusyouhinkbn";
    public static final String ZTYNENKINKIGOUSEDAIKBN   = "ztynenkinkigousedaikbn";
    public static final String ZTYRRTHENDOUNKYOTEIRRT   = "ztyrrthendounkyoteirrt";
    public static final String ZTYRRTHENDOUNKSITIHSYURRT = "ztyrrthendounksitihsyurrt";
    public static final String ZTYHENKOUMAEKIHONNENKINGAKU = "ztyhenkoumaekihonnenkingaku";
    public static final String ZTYNENKINGENSINO         = "ztynenkingensino";
    public static final String ZTYNENKINGENSINAIYOUKBN  = "ztynenkingensinaiyoukbn";
    public static final String ZTYNKKIKINGK             = "ztynkkikingk";
    public static final String ZTYGENSINAIYOUKIHONNKGK  = "ztygensinaiyoukihonnkgk";
    public static final String ZTYNEWMONEYGAKU          = "ztynewmoneygaku";
    public static final String ZTYNENKINGENSIHASSEIYMD  = "ztynenkingensihasseiymd";
    public static final String ZTYDKEISANYOUNENKINGAKU  = "ztydkeisanyounenkingaku";
    public static final String ZTYKGYNKYOUZEISEITKKAKSJGNS = "ztykgynkyouzeiseitkkaksjgns";

    private final PKZT_NkGensiKtyTy primaryKey;

    public GenZT_NkGensiKtyTy() {
        primaryKey = new PKZT_NkGensiKtyTy();
    }

    public GenZT_NkGensiKtyTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_NkGensiKtyTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_NkGensiKtyTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NkGensiKtyTy> getMetaClass() {
        return QZT_NkGensiKtyTy.class;
    }

    @Id
    @Column(name=GenZT_NkGensiKtyTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztysystemcd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYSYSTEMCD)
    public String getZtysystemcd() {
        return ztysystemcd;
    }

    public void setZtysystemcd(String pZtysystemcd) {
        ztysystemcd = pZtysystemcd;
    }

    private String ztyulfkbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYULFKBN)
    public String getZtyulfkbn() {
        return ztyulfkbn;
    }

    public void setZtyulfkbn(String pZtyulfkbn) {
        ztyulfkbn = pZtyulfkbn;
    }

    private String ztyrecordkihonkbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYRECORDKIHONKBN)
    public String getZtyrecordkihonkbn() {
        return ztyrecordkihonkbn;
    }

    public void setZtyrecordkihonkbn(String pZtyrecordkihonkbn) {
        ztyrecordkihonkbn = pZtyrecordkihonkbn;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_NkGensiKtyTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztynksyousyono;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNKSYOUSYONO)
    public String getZtynksyousyono() {
        return ztynksyousyono;
    }

    public void setZtynksyousyono(String pZtynksyousyono) {
        ztynksyousyono = pZtynksyousyono;
    }

    private String ztyrecordkbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYRECORDKBN)
    public String getZtyrecordkbn() {
        return ztyrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyrecordkbn(String pZtyrecordkbn) {
        ztyrecordkbn = pZtyrecordkbn;
    }

    private String ztyidouymd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYIDOUYMD)
    public String getZtyidouymd() {
        return ztyidouymd;
    }

    public void setZtyidouymd(String pZtyidouymd) {
        ztyidouymd = pZtyidouymd;
    }

    private String ztysyouin;

    @Column(name=GenZT_NkGensiKtyTy.ZTYSYOUIN)
    public String getZtysyouin() {
        return ztysyouin;
    }

    public void setZtysyouin(String pZtysyouin) {
        ztysyouin = pZtysyouin;
    }

    private String ztynksyuruikbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNKSYURUIKBN)
    public String getZtynksyuruikbn() {
        return ztynksyuruikbn;
    }

    public void setZtynksyuruikbn(String pZtynksyuruikbn) {
        ztynksyuruikbn = pZtynksyuruikbn;
    }

    private String ztynenkinkbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNENKINKBN)
    public String getZtynenkinkbn() {
        return ztynenkinkbn;
    }

    public void setZtynenkinkbn(String pZtynenkinkbn) {
        ztynenkinkbn = pZtynenkinkbn;
    }

    private String ztynenkinsyu;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNENKINSYU)
    public String getZtynenkinsyu() {
        return ztynenkinsyu;
    }

    public void setZtynenkinsyu(String pZtynenkinsyu) {
        ztynenkinsyu = pZtynenkinsyu;
    }

    private String ztynenkinkaisikbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNENKINKAISIKBN)
    public String getZtynenkinkaisikbn() {
        return ztynenkinkaisikbn;
    }

    public void setZtynenkinkaisikbn(String pZtynenkinkaisikbn) {
        ztynenkinkaisikbn = pZtynenkinkaisikbn;
    }

    private String ztykeiyakuymd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYKEIYAKUYMD)
    public String getZtykeiyakuymd() {
        return ztykeiyakuymd;
    }

    public void setZtykeiyakuymd(String pZtykeiyakuymd) {
        ztykeiyakuymd = pZtykeiyakuymd;
    }

    private String ztysyokainenkinsiharaiymd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYSYOKAINENKINSIHARAIYMD)
    public String getZtysyokainenkinsiharaiymd() {
        return ztysyokainenkinsiharaiymd;
    }

    public void setZtysyokainenkinsiharaiymd(String pZtysyokainenkinsiharaiymd) {
        ztysyokainenkinsiharaiymd = pZtysyokainenkinsiharaiymd;
    }

    private String ztynknshry;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNKNSHRY)
    public String getZtynknshry() {
        return ztynknshry;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtynknshry(String pZtynknshry) {
        ztynknshry = pZtynknshry;
    }

    private String ztynenkinhosyoukikan;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNENKINHOSYOUKIKAN)
    public String getZtynenkinhosyoukikan() {
        return ztynenkinhosyoukikan;
    }

    public void setZtynenkinhosyoukikan(String pZtynenkinhosyoukikan) {
        ztynenkinhosyoukikan = pZtynenkinhosyoukikan;
    }

    private Long ztykhnnkgk;

    @Column(name=GenZT_NkGensiKtyTy.ZTYKHNNKGK)
    public Long getZtykhnnkgk() {
        return ztykhnnkgk;
    }

    public void setZtykhnnkgk(Long pZtykhnnkgk) {
        ztykhnnkgk = pZtykhnnkgk;
    }

    private String ztysaisyuukousinymd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYSAISYUUKOUSINYMD)
    public String getZtysaisyuukousinymd() {
        return ztysaisyuukousinymd;
    }

    public void setZtysaisyuukousinymd(String pZtysaisyuukousinymd) {
        ztysaisyuukousinymd = pZtysaisyuukousinymd;
    }

    private String ztysaisyuukousinsyoricd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYSAISYUUKOUSINSYORICD)
    public String getZtysaisyuukousinsyoricd() {
        return ztysaisyuukousinsyoricd;
    }

    public void setZtysaisyuukousinsyoricd(String pZtysaisyuukousinsyoricd) {
        ztysaisyuukousinsyoricd = pZtysaisyuukousinsyoricd;
    }

    private Long ztynenkinkihonctr;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNENKINKIHONCTR)
    public Long getZtynenkinkihonctr() {
        return ztynenkinkihonctr;
    }

    public void setZtynenkinkihonctr(Long pZtynenkinkihonctr) {
        ztynenkinkihonctr = pZtynenkinkihonctr;
    }

    private String ztycurrentday;

    @Column(name=GenZT_NkGensiKtyTy.ZTYCURRENTDAY)
    public String getZtycurrentday() {
        return ztycurrentday;
    }

    public void setZtycurrentday(String pZtycurrentday) {
        ztycurrentday = pZtycurrentday;
    }

    private String ztycurrenttime;

    @Column(name=GenZT_NkGensiKtyTy.ZTYCURRENTTIME)
    public String getZtycurrenttime() {
        return ztycurrenttime;
    }

    public void setZtycurrenttime(String pZtycurrenttime) {
        ztycurrenttime = pZtycurrenttime;
    }

    private String ztysyoricd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztykessanjibikinkbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYKESSANJIBIKINKBN)
    public String getZtykessanjibikinkbn() {
        return ztykessanjibikinkbn;
    }

    public void setZtykessanjibikinkbn(String pZtykessanjibikinkbn) {
        ztykessanjibikinkbn = pZtykessanjibikinkbn;
    }

    private String ztynksyoumetucd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNKSYOUMETUCD)
    public String getZtynksyoumetucd() {
        return ztynksyoumetucd;
    }

    public void setZtynksyoumetucd(String pZtynksyoumetucd) {
        ztynksyoumetucd = pZtynksyoumetucd;
    }

    private String ztynksyoumetuymd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNKSYOUMETUYMD)
    public String getZtynksyoumetuymd() {
        return ztynksyoumetuymd;
    }

    public void setZtynksyoumetuymd(String pZtynksyoumetuymd) {
        ztynksyoumetuymd = pZtynksyoumetuymd;
    }

    private String ztykouryokuhasseiymd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYKOURYOKUHASSEIYMD)
    public String getZtykouryokuhasseiymd() {
        return ztykouryokuhasseiymd;
    }

    public void setZtykouryokuhasseiymd(String pZtykouryokuhasseiymd) {
        ztykouryokuhasseiymd = pZtykouryokuhasseiymd;
    }

    private String ztykingakuzoukanaiyoukbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYKINGAKUZOUKANAIYOUKBN)
    public String getZtykingakuzoukanaiyoukbn() {
        return ztykingakuzoukanaiyoukbn;
    }

    public void setZtykingakuzoukanaiyoukbn(String pZtykingakuzoukanaiyoukbn) {
        ztykingakuzoukanaiyoukbn = pZtykingakuzoukanaiyoukbn;
    }

    private String ztymotokeiyakusyouhinkbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYMOTOKEIYAKUSYOUHINKBN)
    public String getZtymotokeiyakusyouhinkbn() {
        return ztymotokeiyakusyouhinkbn;
    }

    public void setZtymotokeiyakusyouhinkbn(String pZtymotokeiyakusyouhinkbn) {
        ztymotokeiyakusyouhinkbn = pZtymotokeiyakusyouhinkbn;
    }

    private String ztynenkinkigousedaikbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNENKINKIGOUSEDAIKBN)
    public String getZtynenkinkigousedaikbn() {
        return ztynenkinkigousedaikbn;
    }

    public void setZtynenkinkigousedaikbn(String pZtynenkinkigousedaikbn) {
        ztynenkinkigousedaikbn = pZtynenkinkigousedaikbn;
    }

    private Double ztyrrthendounkyoteirrt;

    @Column(name=GenZT_NkGensiKtyTy.ZTYRRTHENDOUNKYOTEIRRT)
    public Double getZtyrrthendounkyoteirrt() {
        return ztyrrthendounkyoteirrt;
    }

    public void setZtyrrthendounkyoteirrt(Double pZtyrrthendounkyoteirrt) {
        ztyrrthendounkyoteirrt = pZtyrrthendounkyoteirrt;
    }

    private Double ztyrrthendounksitihsyurrt;

    @Column(name=GenZT_NkGensiKtyTy.ZTYRRTHENDOUNKSITIHSYURRT)
    public Double getZtyrrthendounksitihsyurrt() {
        return ztyrrthendounksitihsyurrt;
    }

    public void setZtyrrthendounksitihsyurrt(Double pZtyrrthendounksitihsyurrt) {
        ztyrrthendounksitihsyurrt = pZtyrrthendounksitihsyurrt;
    }

    private Long ztyhenkoumaekihonnenkingaku;

    @Column(name=GenZT_NkGensiKtyTy.ZTYHENKOUMAEKIHONNENKINGAKU)
    public Long getZtyhenkoumaekihonnenkingaku() {
        return ztyhenkoumaekihonnenkingaku;
    }

    public void setZtyhenkoumaekihonnenkingaku(Long pZtyhenkoumaekihonnenkingaku) {
        ztyhenkoumaekihonnenkingaku = pZtyhenkoumaekihonnenkingaku;
    }

    private String ztynenkingensino;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNENKINGENSINO)
    public String getZtynenkingensino() {
        return ztynenkingensino;
    }

    public void setZtynenkingensino(String pZtynenkingensino) {
        ztynenkingensino = pZtynenkingensino;
    }

    private String ztynenkingensinaiyoukbn;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNENKINGENSINAIYOUKBN)
    public String getZtynenkingensinaiyoukbn() {
        return ztynenkingensinaiyoukbn;
    }

    public void setZtynenkingensinaiyoukbn(String pZtynenkingensinaiyoukbn) {
        ztynenkingensinaiyoukbn = pZtynenkingensinaiyoukbn;
    }

    private Long ztynkkikingk;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNKKIKINGK)
    public Long getZtynkkikingk() {
        return ztynkkikingk;
    }

    public void setZtynkkikingk(Long pZtynkkikingk) {
        ztynkkikingk = pZtynkkikingk;
    }

    private Long ztygensinaiyoukihonnkgk;

    @Column(name=GenZT_NkGensiKtyTy.ZTYGENSINAIYOUKIHONNKGK)
    public Long getZtygensinaiyoukihonnkgk() {
        return ztygensinaiyoukihonnkgk;
    }

    public void setZtygensinaiyoukihonnkgk(Long pZtygensinaiyoukihonnkgk) {
        ztygensinaiyoukihonnkgk = pZtygensinaiyoukihonnkgk;
    }

    private Long ztynewmoneygaku;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNEWMONEYGAKU)
    public Long getZtynewmoneygaku() {
        return ztynewmoneygaku;
    }

    public void setZtynewmoneygaku(Long pZtynewmoneygaku) {
        ztynewmoneygaku = pZtynewmoneygaku;
    }

    private String ztynenkingensihasseiymd;

    @Column(name=GenZT_NkGensiKtyTy.ZTYNENKINGENSIHASSEIYMD)
    public String getZtynenkingensihasseiymd() {
        return ztynenkingensihasseiymd;
    }

    public void setZtynenkingensihasseiymd(String pZtynenkingensihasseiymd) {
        ztynenkingensihasseiymd = pZtynenkingensihasseiymd;
    }

    private Long ztydkeisanyounenkingaku;

    @Column(name=GenZT_NkGensiKtyTy.ZTYDKEISANYOUNENKINGAKU)
    public Long getZtydkeisanyounenkingaku() {
        return ztydkeisanyounenkingaku;
    }

    public void setZtydkeisanyounenkingaku(Long pZtydkeisanyounenkingaku) {
        ztydkeisanyounenkingaku = pZtydkeisanyounenkingaku;
    }

    private Long ztykgynkyouzeiseitkkaksjgns;

    @Column(name=GenZT_NkGensiKtyTy.ZTYKGYNKYOUZEISEITKKAKSJGNS)
    public Long getZtykgynkyouzeiseitkkaksjgns() {
        return ztykgynkyouzeiseitkkaksjgns;
    }

    public void setZtykgynkyouzeiseitkkaksjgns(Long pZtykgynkyouzeiseitkkaksjgns) {
        ztykgynkyouzeiseitkkaksjgns = pZtykgynkyouzeiseitkkaksjgns;
    }
}
