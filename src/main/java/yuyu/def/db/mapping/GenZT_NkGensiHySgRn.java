package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_NkGensiHySgRn;
import yuyu.def.db.id.PKZT_NkGensiHySgRn;
import yuyu.def.db.meta.GenQZT_NkGensiHySgRn;
import yuyu.def.db.meta.QZT_NkGensiHySgRn;

/**
 * 年金原資Ｆ保有照合用テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_NkGensiHySgRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkGensiHySgRn}</td><td colspan="3">年金原資Ｆ保有照合用テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_NkGensiHySgRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsystemcd zrnsystemcd}</td><td>（連携用）システムコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnulfkbn zrnulfkbn}</td><td>（連携用）ＵＬＦ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordkihonkbn zrnrecordkihonkbn}</td><td>（連携用）レコード基本区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyousyono zrnnksyousyono}</td><td>（連携用）年金証書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordkbn zrnrecordkbn}</td><td>（連携用）レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidouymd zrnidouymd}</td><td>（連携用）異動日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouin zrnsyouin}</td><td>（連携用）消因</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikbn zrnnksyuruikbn}</td><td>（連携用）年金種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkbn zrnnenkinkbn}</td><td>（連携用）年金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsyu zrnnenkinsyu}</td><td>（連携用）年金種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisikbn zrnnenkinkaisikbn}</td><td>（連携用）年金開始区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuymd zrnkeiyakuymd}</td><td>（連携用）契約日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokainenkinsiharaiymd zrnsyokainenkinsiharaiymd}</td><td>（連携用）初回年金支払日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinhosyoukikan zrnnenkinhosyoukikan}</td><td>（連携用）年金保証期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhnnkgk zrnkhnnkgk}</td><td>（連携用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaisyuukousinymd zrnsaisyuukousinymd}</td><td>（連携用）最終更新日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisyuukousinsyoricd zrnsaisyuukousinsyoricd}</td><td>（連携用）最終更新処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkihonctr zrnnenkinkihonctr}</td><td>（連携用）年金基本ＣＴＲ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncurrentday zrncurrentday}</td><td>（連携用）現在日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncurrenttime zrncurrenttime}</td><td>（連携用）現在時刻</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkessanjibikinkbn zrnkessanjibikinkbn}</td><td>（連携用）決算時備金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyoumetucd zrnnksyoumetucd}</td><td>（連携用）年金消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyoumetuymd zrnnksyoumetuymd}</td><td>（連携用）年金消滅日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouryokuhasseiymd zrnkouryokuhasseiymd}</td><td>（連携用）効力発生日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingakuzoukanaiyoukbn zrnkingakuzoukanaiyoukbn}</td><td>（連携用）金額増加内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmotokeiyakusyouhinkbn zrnmotokeiyakusyouhinkbn}</td><td>（連携用）元契約商品区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkigousedaikbn zrnnenkinkigousedaikbn}</td><td>（連携用）年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrrthendounkyoteirrt zrnrrthendounkyoteirrt}</td><td>（連携用）利率変動年金予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrrthendounksitihsyurrt zrnrrthendounksitihsyurrt}</td><td>（連携用）利率変動年金最低保証利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhenkoumaekihonnenkingaku zrnhenkoumaekihonnenkingaku}</td><td>（連携用）変更前基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkingensino zrnnenkingensino}</td><td>（連携用）年金原資番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkingensinaiyoukbn zrnnenkingensinaiyoukbn}</td><td>（連携用）年金原資内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkikingk zrnnkkikingk}</td><td>（連携用）年金基金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngensinaiyoukihonnkgk zrngensinaiyoukihonnkgk}</td><td>（連携用）原資内容基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnewmoneygaku zrnnewmoneygaku}</td><td>（連携用）ニューマネー額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkingensihasseiymd zrnnenkingensihasseiymd}</td><td>（連携用）年金原資発生日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndkeisanyounenkingaku zrndkeisanyounenkingaku}</td><td>（連携用）Ｄ計算用年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkgynkyouzeiseitkkaksjgns zrnkgynkyouzeiseitkkaksjgns}</td><td>（連携用）企業年金用税制適格開始時原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_NkGensiHySgRn
 * @see     PKZT_NkGensiHySgRn
 * @see     QZT_NkGensiHySgRn
 * @see     GenQZT_NkGensiHySgRn
 */
@MappedSuperclass
@Table(name=GenZT_NkGensiHySgRn.TABLE_NAME)
@IdClass(value=PKZT_NkGensiHySgRn.class)
public abstract class GenZT_NkGensiHySgRn extends AbstractExDBEntityForZDB<ZT_NkGensiHySgRn, PKZT_NkGensiHySgRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NkGensiHySgRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNSYSTEMCD              = "zrnsystemcd";
    public static final String ZRNULFKBN                = "zrnulfkbn";
    public static final String ZRNRECORDKIHONKBN        = "zrnrecordkihonkbn";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNNKSYOUSYONO           = "zrnnksyousyono";
    public static final String ZRNRECORDKBN             = "zrnrecordkbn";
    public static final String ZRNIDOUYMD               = "zrnidouymd";
    public static final String ZRNSYOUIN                = "zrnsyouin";
    public static final String ZRNNKSYURUIKBN           = "zrnnksyuruikbn";
    public static final String ZRNNENKINKBN             = "zrnnenkinkbn";
    public static final String ZRNNENKINSYU             = "zrnnenkinsyu";
    public static final String ZRNNENKINKAISIKBN        = "zrnnenkinkaisikbn";
    public static final String ZRNKEIYAKUYMD            = "zrnkeiyakuymd";
    public static final String ZRNSYOKAINENKINSIHARAIYMD = "zrnsyokainenkinsiharaiymd";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNNENKINHOSYOUKIKAN     = "zrnnenkinhosyoukikan";
    public static final String ZRNKHNNKGK               = "zrnkhnnkgk";
    public static final String ZRNSAISYUUKOUSINYMD      = "zrnsaisyuukousinymd";
    public static final String ZRNSAISYUUKOUSINSYORICD  = "zrnsaisyuukousinsyoricd";
    public static final String ZRNNENKINKIHONCTR        = "zrnnenkinkihonctr";
    public static final String ZRNCURRENTDAY            = "zrncurrentday";
    public static final String ZRNCURRENTTIME           = "zrncurrenttime";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNKESSANJIBIKINKBN      = "zrnkessanjibikinkbn";
    public static final String ZRNNKSYOUMETUCD          = "zrnnksyoumetucd";
    public static final String ZRNNKSYOUMETUYMD         = "zrnnksyoumetuymd";
    public static final String ZRNKOURYOKUHASSEIYMD     = "zrnkouryokuhasseiymd";
    public static final String ZRNKINGAKUZOUKANAIYOUKBN = "zrnkingakuzoukanaiyoukbn";
    public static final String ZRNMOTOKEIYAKUSYOUHINKBN = "zrnmotokeiyakusyouhinkbn";
    public static final String ZRNNENKINKIGOUSEDAIKBN   = "zrnnenkinkigousedaikbn";
    public static final String ZRNRRTHENDOUNKYOTEIRRT   = "zrnrrthendounkyoteirrt";
    public static final String ZRNRRTHENDOUNKSITIHSYURRT = "zrnrrthendounksitihsyurrt";
    public static final String ZRNHENKOUMAEKIHONNENKINGAKU = "zrnhenkoumaekihonnenkingaku";
    public static final String ZRNNENKINGENSINO         = "zrnnenkingensino";
    public static final String ZRNNENKINGENSINAIYOUKBN  = "zrnnenkingensinaiyoukbn";
    public static final String ZRNNKKIKINGK             = "zrnnkkikingk";
    public static final String ZRNGENSINAIYOUKIHONNKGK  = "zrngensinaiyoukihonnkgk";
    public static final String ZRNNEWMONEYGAKU          = "zrnnewmoneygaku";
    public static final String ZRNNENKINGENSIHASSEIYMD  = "zrnnenkingensihasseiymd";
    public static final String ZRNDKEISANYOUNENKINGAKU  = "zrndkeisanyounenkingaku";
    public static final String ZRNKGYNKYOUZEISEITKKAKSJGNS = "zrnkgynkyouzeiseitkkaksjgns";

    private final PKZT_NkGensiHySgRn primaryKey;

    public GenZT_NkGensiHySgRn() {
        primaryKey = new PKZT_NkGensiHySgRn();
    }

    public GenZT_NkGensiHySgRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_NkGensiHySgRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_NkGensiHySgRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NkGensiHySgRn> getMetaClass() {
        return QZT_NkGensiHySgRn.class;
    }

    @Id
    @Column(name=GenZT_NkGensiHySgRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnsystemcd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNSYSTEMCD)
    public String getZrnsystemcd() {
        return zrnsystemcd;
    }

    public void setZrnsystemcd(String pZrnsystemcd) {
        zrnsystemcd = pZrnsystemcd;
    }

    private String zrnulfkbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNULFKBN)
    public String getZrnulfkbn() {
        return zrnulfkbn;
    }

    public void setZrnulfkbn(String pZrnulfkbn) {
        zrnulfkbn = pZrnulfkbn;
    }

    private String zrnrecordkihonkbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNRECORDKIHONKBN)
    public String getZrnrecordkihonkbn() {
        return zrnrecordkihonkbn;
    }

    public void setZrnrecordkihonkbn(String pZrnrecordkihonkbn) {
        zrnrecordkihonkbn = pZrnrecordkihonkbn;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_NkGensiHySgRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private String zrnnksyousyono;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNKSYOUSYONO)
    public String getZrnnksyousyono() {
        return zrnnksyousyono;
    }

    public void setZrnnksyousyono(String pZrnnksyousyono) {
        zrnnksyousyono = pZrnnksyousyono;
    }

    private String zrnrecordkbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNRECORDKBN)
    public String getZrnrecordkbn() {
        return zrnrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrecordkbn(String pZrnrecordkbn) {
        zrnrecordkbn = pZrnrecordkbn;
    }

    private String zrnidouymd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNIDOUYMD)
    public String getZrnidouymd() {
        return zrnidouymd;
    }

    public void setZrnidouymd(String pZrnidouymd) {
        zrnidouymd = pZrnidouymd;
    }

    private String zrnsyouin;

    @Column(name=GenZT_NkGensiHySgRn.ZRNSYOUIN)
    public String getZrnsyouin() {
        return zrnsyouin;
    }

    public void setZrnsyouin(String pZrnsyouin) {
        zrnsyouin = pZrnsyouin;
    }

    private String zrnnksyuruikbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNKSYURUIKBN)
    public String getZrnnksyuruikbn() {
        return zrnnksyuruikbn;
    }

    public void setZrnnksyuruikbn(String pZrnnksyuruikbn) {
        zrnnksyuruikbn = pZrnnksyuruikbn;
    }

    private String zrnnenkinkbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNENKINKBN)
    public String getZrnnenkinkbn() {
        return zrnnenkinkbn;
    }

    public void setZrnnenkinkbn(String pZrnnenkinkbn) {
        zrnnenkinkbn = pZrnnenkinkbn;
    }

    private String zrnnenkinsyu;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNENKINSYU)
    public String getZrnnenkinsyu() {
        return zrnnenkinsyu;
    }

    public void setZrnnenkinsyu(String pZrnnenkinsyu) {
        zrnnenkinsyu = pZrnnenkinsyu;
    }

    private String zrnnenkinkaisikbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNENKINKAISIKBN)
    public String getZrnnenkinkaisikbn() {
        return zrnnenkinkaisikbn;
    }

    public void setZrnnenkinkaisikbn(String pZrnnenkinkaisikbn) {
        zrnnenkinkaisikbn = pZrnnenkinkaisikbn;
    }

    private String zrnkeiyakuymd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNKEIYAKUYMD)
    public String getZrnkeiyakuymd() {
        return zrnkeiyakuymd;
    }

    public void setZrnkeiyakuymd(String pZrnkeiyakuymd) {
        zrnkeiyakuymd = pZrnkeiyakuymd;
    }

    private String zrnsyokainenkinsiharaiymd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNSYOKAINENKINSIHARAIYMD)
    public String getZrnsyokainenkinsiharaiymd() {
        return zrnsyokainenkinsiharaiymd;
    }

    public void setZrnsyokainenkinsiharaiymd(String pZrnsyokainenkinsiharaiymd) {
        zrnsyokainenkinsiharaiymd = pZrnsyokainenkinsiharaiymd;
    }

    private String zrnnknshry;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return zrnnknshry;
    }

    public void setZrnnknshry(String pZrnnknshry) {
        zrnnknshry = pZrnnknshry;
    }

    private String zrnnenkinhosyoukikan;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNENKINHOSYOUKIKAN)
    public String getZrnnenkinhosyoukikan() {
        return zrnnenkinhosyoukikan;
    }

    public void setZrnnenkinhosyoukikan(String pZrnnenkinhosyoukikan) {
        zrnnenkinhosyoukikan = pZrnnenkinhosyoukikan;
    }

    private Long zrnkhnnkgk;

    @Column(name=GenZT_NkGensiHySgRn.ZRNKHNNKGK)
    public Long getZrnkhnnkgk() {
        return zrnkhnnkgk;
    }

    public void setZrnkhnnkgk(Long pZrnkhnnkgk) {
        zrnkhnnkgk = pZrnkhnnkgk;
    }

    private String zrnsaisyuukousinymd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNSAISYUUKOUSINYMD)
    public String getZrnsaisyuukousinymd() {
        return zrnsaisyuukousinymd;
    }

    public void setZrnsaisyuukousinymd(String pZrnsaisyuukousinymd) {
        zrnsaisyuukousinymd = pZrnsaisyuukousinymd;
    }

    private String zrnsaisyuukousinsyoricd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNSAISYUUKOUSINSYORICD)
    public String getZrnsaisyuukousinsyoricd() {
        return zrnsaisyuukousinsyoricd;
    }

    public void setZrnsaisyuukousinsyoricd(String pZrnsaisyuukousinsyoricd) {
        zrnsaisyuukousinsyoricd = pZrnsaisyuukousinsyoricd;
    }

    private Long zrnnenkinkihonctr;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNENKINKIHONCTR)
    public Long getZrnnenkinkihonctr() {
        return zrnnenkinkihonctr;
    }

    public void setZrnnenkinkihonctr(Long pZrnnenkinkihonctr) {
        zrnnenkinkihonctr = pZrnnenkinkihonctr;
    }

    private String zrncurrentday;

    @Column(name=GenZT_NkGensiHySgRn.ZRNCURRENTDAY)
    public String getZrncurrentday() {
        return zrncurrentday;
    }

    public void setZrncurrentday(String pZrncurrentday) {
        zrncurrentday = pZrncurrentday;
    }

    private String zrncurrenttime;

    @Column(name=GenZT_NkGensiHySgRn.ZRNCURRENTTIME)
    public String getZrncurrenttime() {
        return zrncurrenttime;
    }

    public void setZrncurrenttime(String pZrncurrenttime) {
        zrncurrenttime = pZrncurrenttime;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    private String zrnkessanjibikinkbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNKESSANJIBIKINKBN)
    public String getZrnkessanjibikinkbn() {
        return zrnkessanjibikinkbn;
    }

    public void setZrnkessanjibikinkbn(String pZrnkessanjibikinkbn) {
        zrnkessanjibikinkbn = pZrnkessanjibikinkbn;
    }

    private String zrnnksyoumetucd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNKSYOUMETUCD)
    public String getZrnnksyoumetucd() {
        return zrnnksyoumetucd;
    }

    public void setZrnnksyoumetucd(String pZrnnksyoumetucd) {
        zrnnksyoumetucd = pZrnnksyoumetucd;
    }

    private String zrnnksyoumetuymd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNKSYOUMETUYMD)
    public String getZrnnksyoumetuymd() {
        return zrnnksyoumetuymd;
    }

    public void setZrnnksyoumetuymd(String pZrnnksyoumetuymd) {
        zrnnksyoumetuymd = pZrnnksyoumetuymd;
    }

    private String zrnkouryokuhasseiymd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNKOURYOKUHASSEIYMD)
    public String getZrnkouryokuhasseiymd() {
        return zrnkouryokuhasseiymd;
    }

    public void setZrnkouryokuhasseiymd(String pZrnkouryokuhasseiymd) {
        zrnkouryokuhasseiymd = pZrnkouryokuhasseiymd;
    }

    private String zrnkingakuzoukanaiyoukbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNKINGAKUZOUKANAIYOUKBN)
    public String getZrnkingakuzoukanaiyoukbn() {
        return zrnkingakuzoukanaiyoukbn;
    }

    public void setZrnkingakuzoukanaiyoukbn(String pZrnkingakuzoukanaiyoukbn) {
        zrnkingakuzoukanaiyoukbn = pZrnkingakuzoukanaiyoukbn;
    }

    private String zrnmotokeiyakusyouhinkbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNMOTOKEIYAKUSYOUHINKBN)
    public String getZrnmotokeiyakusyouhinkbn() {
        return zrnmotokeiyakusyouhinkbn;
    }

    public void setZrnmotokeiyakusyouhinkbn(String pZrnmotokeiyakusyouhinkbn) {
        zrnmotokeiyakusyouhinkbn = pZrnmotokeiyakusyouhinkbn;
    }

    private String zrnnenkinkigousedaikbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNENKINKIGOUSEDAIKBN)
    public String getZrnnenkinkigousedaikbn() {
        return zrnnenkinkigousedaikbn;
    }

    public void setZrnnenkinkigousedaikbn(String pZrnnenkinkigousedaikbn) {
        zrnnenkinkigousedaikbn = pZrnnenkinkigousedaikbn;
    }

    private Double zrnrrthendounkyoteirrt;

    @Column(name=GenZT_NkGensiHySgRn.ZRNRRTHENDOUNKYOTEIRRT)
    public Double getZrnrrthendounkyoteirrt() {
        return zrnrrthendounkyoteirrt;
    }

    public void setZrnrrthendounkyoteirrt(Double pZrnrrthendounkyoteirrt) {
        zrnrrthendounkyoteirrt = pZrnrrthendounkyoteirrt;
    }

    private Double zrnrrthendounksitihsyurrt;

    @Column(name=GenZT_NkGensiHySgRn.ZRNRRTHENDOUNKSITIHSYURRT)
    public Double getZrnrrthendounksitihsyurrt() {
        return zrnrrthendounksitihsyurrt;
    }

    public void setZrnrrthendounksitihsyurrt(Double pZrnrrthendounksitihsyurrt) {
        zrnrrthendounksitihsyurrt = pZrnrrthendounksitihsyurrt;
    }

    private Long zrnhenkoumaekihonnenkingaku;

    @Column(name=GenZT_NkGensiHySgRn.ZRNHENKOUMAEKIHONNENKINGAKU)
    public Long getZrnhenkoumaekihonnenkingaku() {
        return zrnhenkoumaekihonnenkingaku;
    }

    public void setZrnhenkoumaekihonnenkingaku(Long pZrnhenkoumaekihonnenkingaku) {
        zrnhenkoumaekihonnenkingaku = pZrnhenkoumaekihonnenkingaku;
    }

    private String zrnnenkingensino;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNENKINGENSINO)
    public String getZrnnenkingensino() {
        return zrnnenkingensino;
    }

    public void setZrnnenkingensino(String pZrnnenkingensino) {
        zrnnenkingensino = pZrnnenkingensino;
    }

    private String zrnnenkingensinaiyoukbn;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNENKINGENSINAIYOUKBN)
    public String getZrnnenkingensinaiyoukbn() {
        return zrnnenkingensinaiyoukbn;
    }

    public void setZrnnenkingensinaiyoukbn(String pZrnnenkingensinaiyoukbn) {
        zrnnenkingensinaiyoukbn = pZrnnenkingensinaiyoukbn;
    }

    private Long zrnnkkikingk;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNKKIKINGK)
    public Long getZrnnkkikingk() {
        return zrnnkkikingk;
    }

    public void setZrnnkkikingk(Long pZrnnkkikingk) {
        zrnnkkikingk = pZrnnkkikingk;
    }

    private Long zrngensinaiyoukihonnkgk;

    @Column(name=GenZT_NkGensiHySgRn.ZRNGENSINAIYOUKIHONNKGK)
    public Long getZrngensinaiyoukihonnkgk() {
        return zrngensinaiyoukihonnkgk;
    }

    public void setZrngensinaiyoukihonnkgk(Long pZrngensinaiyoukihonnkgk) {
        zrngensinaiyoukihonnkgk = pZrngensinaiyoukihonnkgk;
    }

    private Long zrnnewmoneygaku;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNEWMONEYGAKU)
    public Long getZrnnewmoneygaku() {
        return zrnnewmoneygaku;
    }

    public void setZrnnewmoneygaku(Long pZrnnewmoneygaku) {
        zrnnewmoneygaku = pZrnnewmoneygaku;
    }

    private String zrnnenkingensihasseiymd;

    @Column(name=GenZT_NkGensiHySgRn.ZRNNENKINGENSIHASSEIYMD)
    public String getZrnnenkingensihasseiymd() {
        return zrnnenkingensihasseiymd;
    }

    public void setZrnnenkingensihasseiymd(String pZrnnenkingensihasseiymd) {
        zrnnenkingensihasseiymd = pZrnnenkingensihasseiymd;
    }

    private Long zrndkeisanyounenkingaku;

    @Column(name=GenZT_NkGensiHySgRn.ZRNDKEISANYOUNENKINGAKU)
    public Long getZrndkeisanyounenkingaku() {
        return zrndkeisanyounenkingaku;
    }

    public void setZrndkeisanyounenkingaku(Long pZrndkeisanyounenkingaku) {
        zrndkeisanyounenkingaku = pZrndkeisanyounenkingaku;
    }

    private Long zrnkgynkyouzeiseitkkaksjgns;

    @Column(name=GenZT_NkGensiHySgRn.ZRNKGYNKYOUZEISEITKKAKSJGNS)
    public Long getZrnkgynkyouzeiseitkkaksjgns() {
        return zrnkgynkyouzeiseitkkaksjgns;
    }

    public void setZrnkgynkyouzeiseitkkaksjgns(Long pZrnkgynkyouzeiseitkkaksjgns) {
        zrnkgynkyouzeiseitkkaksjgns = pZrnkgynkyouzeiseitkkaksjgns;
    }
}