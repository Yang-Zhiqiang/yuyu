package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_DattaiTuutiKzhuriTy;
import yuyu.def.db.id.PKZT_DattaiTuutiKzhuriTy;
import yuyu.def.db.meta.GenQZT_DattaiTuutiKzhuriTy;
import yuyu.def.db.meta.QZT_DattaiTuutiKzhuriTy;

/**
 * 脱退通知（口座振替）テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DattaiTuutiKzhuriTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DattaiTuutiKzhuriTy}</td><td colspan="3">脱退通知（口座振替）テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_DattaiTuutiKzhuriTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdkj ztytyouhyouymdkj}</td><td>（中継用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_DattaiTuutiKzhuriTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10 ztyansyuyouyobin10}</td><td>（中継用）案内収納用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskyno ztyshskyno}</td><td>（中継用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr1kj ztyshskadr1kj}</td><td>（中継用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr2kj ztyshskadr2kj}</td><td>（中継用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr3kj ztyshskadr3kj}</td><td>（中継用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshsnmkj ztyshsnmkj}</td><td>（中継用）送付先名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv43 ztyyobiv43}</td><td>（中継用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x2 ztyansyuyouyobin10x2}</td><td>（中継用）案内収納用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawsosikikj ztytawsosikikj}</td><td>（中継用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawyno ztytawyno}</td><td>（中継用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr1kj ztytawadr1kj}</td><td>（中継用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr2kj ztytawadr2kj}</td><td>（中継用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr3kj ztytawadr3kj}</td><td>（中継用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawtelnov14 ztytawtelnov14}</td><td>（中継用）問合せ先電話番号Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou1 ztytawteluktkkanou1}</td><td>（中継用）問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou2 ztytawteluktkkanou2}</td><td>（中継用）問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tawsosikinmkj ztydai2tawsosikinmkj}</td><td>（中継用）第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tawtelno ztydai2tawtelno}</td><td>（中継用）第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysclatosyono ztysclatosyono}</td><td>（中継用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakunm15keta ztysakunm15keta}</td><td>（中継用）作成番号（１５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv62 ztyyobiv62}</td><td>（中継用）予備項目Ｖ６２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x3 ztyansyuyouyobin10x3}</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon1 ztyosirasemongon1}</td><td>（中継用）お知らせ文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon2 ztyosirasemongon2}</td><td>（中継用）お知らせ文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon3 ztyosirasemongon3}</td><td>（中継用）お知らせ文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon4 ztyosirasemongon4}</td><td>（中継用）お知らせ文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon5 ztyosirasemongon5}</td><td>（中継用）お知らせ文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon6 ztyosirasemongon6}</td><td>（中継用）お知らせ文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon7 ztyosirasemongon7}</td><td>（中継用）お知らせ文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon8 ztyosirasemongon8}</td><td>（中継用）お知らせ文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon9 ztyosirasemongon9}</td><td>（中継用）お知らせ文言９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv181 ztyyobiv181}</td><td>（中継用）予備項目Ｖ１８１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x4 ztyansyuyouyobin10x4}</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo30keta1 ztykzinfo30keta1}</td><td>（中継用）口座情報（３０桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo30keta2 ztykzinfo30keta2}</td><td>（中継用）口座情報（３０桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo30keta3 ztykzinfo30keta3}</td><td>（中継用）口座情報（３０桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzamaskingmsg ztykouzamaskingmsg}</td><td>（中継用）口座マスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv50 ztyyobiv50}</td><td>（中継用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x5 ztyansyuyouyobin10x5}</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DattaiTuutiKzhuriTy
 * @see     PKZT_DattaiTuutiKzhuriTy
 * @see     QZT_DattaiTuutiKzhuriTy
 * @see     GenQZT_DattaiTuutiKzhuriTy
 */
@MappedSuperclass
@Table(name=GenZT_DattaiTuutiKzhuriTy.TABLE_NAME)
@IdClass(value=PKZT_DattaiTuutiKzhuriTy.class)
public abstract class GenZT_DattaiTuutiKzhuriTy extends AbstractExDBEntity<ZT_DattaiTuutiKzhuriTy, PKZT_DattaiTuutiKzhuriTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DattaiTuutiKzhuriTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYTYOUHYOUYMDKJ         = "ztytyouhyouymdkj";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
    public static final String ZTYANSYUYOUYOBIN10       = "ztyansyuyouyobin10";
    public static final String ZTYSHSKYNO               = "ztyshskyno";
    public static final String ZTYSHSKADR1KJ            = "ztyshskadr1kj";
    public static final String ZTYSHSKADR2KJ            = "ztyshskadr2kj";
    public static final String ZTYSHSKADR3KJ            = "ztyshskadr3kj";
    public static final String ZTYSHSNMKJ               = "ztyshsnmkj";
    public static final String ZTYYOBIV43               = "ztyyobiv43";
    public static final String ZTYANSYUYOUYOBIN10X2     = "ztyansyuyouyobin10x2";
    public static final String ZTYTAWSOSIKIKJ           = "ztytawsosikikj";
    public static final String ZTYTAWYNO                = "ztytawyno";
    public static final String ZTYTAWADR1KJ             = "ztytawadr1kj";
    public static final String ZTYTAWADR2KJ             = "ztytawadr2kj";
    public static final String ZTYTAWADR3KJ             = "ztytawadr3kj";
    public static final String ZTYTAWTELNOV14           = "ztytawtelnov14";
    public static final String ZTYTAWTELUKTKKANOU1      = "ztytawteluktkkanou1";
    public static final String ZTYTAWTELUKTKKANOU2      = "ztytawteluktkkanou2";
    public static final String ZTYDAI2TAWSOSIKINMKJ     = "ztydai2tawsosikinmkj";
    public static final String ZTYDAI2TAWTELNO          = "ztydai2tawtelno";
    public static final String ZTYSCLATOSYONO           = "ztysclatosyono";
    public static final String ZTYSAKUNM15KETA          = "ztysakunm15keta";
    public static final String ZTYYOBIV62               = "ztyyobiv62";
    public static final String ZTYANSYUYOUYOBIN10X3     = "ztyansyuyouyobin10x3";
    public static final String ZTYOSIRASEMONGON1        = "ztyosirasemongon1";
    public static final String ZTYOSIRASEMONGON2        = "ztyosirasemongon2";
    public static final String ZTYOSIRASEMONGON3        = "ztyosirasemongon3";
    public static final String ZTYOSIRASEMONGON4        = "ztyosirasemongon4";
    public static final String ZTYOSIRASEMONGON5        = "ztyosirasemongon5";
    public static final String ZTYOSIRASEMONGON6        = "ztyosirasemongon6";
    public static final String ZTYOSIRASEMONGON7        = "ztyosirasemongon7";
    public static final String ZTYOSIRASEMONGON8        = "ztyosirasemongon8";
    public static final String ZTYOSIRASEMONGON9        = "ztyosirasemongon9";
    public static final String ZTYYOBIV181              = "ztyyobiv181";
    public static final String ZTYANSYUYOUYOBIN10X4     = "ztyansyuyouyobin10x4";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYKZINFO30KETA1         = "ztykzinfo30keta1";
    public static final String ZTYKZINFO30KETA2         = "ztykzinfo30keta2";
    public static final String ZTYKZINFO30KETA3         = "ztykzinfo30keta3";
    public static final String ZTYKOUZAMASKINGMSG       = "ztykouzamaskingmsg";
    public static final String ZTYYOBIV50               = "ztyyobiv50";
    public static final String ZTYANSYUYOUYOBIN10X5     = "ztyansyuyouyobin10x5";

    private final PKZT_DattaiTuutiKzhuriTy primaryKey;

    public GenZT_DattaiTuutiKzhuriTy() {
        primaryKey = new PKZT_DattaiTuutiKzhuriTy();
    }

    public GenZT_DattaiTuutiKzhuriTy(String pZtytyouhyouymd, String pZtysyono) {
        primaryKey = new PKZT_DattaiTuutiKzhuriTy(pZtytyouhyouymd, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_DattaiTuutiKzhuriTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DattaiTuutiKzhuriTy> getMetaClass() {
        return QZT_DattaiTuutiKzhuriTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    @Id
    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztytyouhyouymdkj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYTYOUHYOUYMDKJ)
    public String getZtytyouhyouymdkj() {
        return ztytyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZtytyouhyouymdkj(String pZtytyouhyouymdkj) {
        ztytyouhyouymdkj = pZtytyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyyobiv9;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyshskyno;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztyansyuyouyobin10x2;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYANSYUYOUYOBIN10X2)
    public String getZtyansyuyouyobin10x2() {
        return ztyansyuyouyobin10x2;
    }

    public void setZtyansyuyouyobin10x2(String pZtyansyuyouyobin10x2) {
        ztyansyuyouyobin10x2 = pZtyansyuyouyobin10x2;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztysakunm15keta;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYSAKUNM15KETA)
    public String getZtysakunm15keta() {
        return ztysakunm15keta;
    }

    public void setZtysakunm15keta(String pZtysakunm15keta) {
        ztysakunm15keta = pZtysakunm15keta;
    }

    private String ztyyobiv62;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYYOBIV62)
    public String getZtyyobiv62() {
        return ztyyobiv62;
    }

    public void setZtyyobiv62(String pZtyyobiv62) {
        ztyyobiv62 = pZtyyobiv62;
    }

    private String ztyansyuyouyobin10x3;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYANSYUYOUYOBIN10X3)
    public String getZtyansyuyouyobin10x3() {
        return ztyansyuyouyobin10x3;
    }

    public void setZtyansyuyouyobin10x3(String pZtyansyuyouyobin10x3) {
        ztyansyuyouyobin10x3 = pZtyansyuyouyobin10x3;
    }

    private String ztyosirasemongon1;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYOSIRASEMONGON1)
    public String getZtyosirasemongon1() {
        return ztyosirasemongon1;
    }

    public void setZtyosirasemongon1(String pZtyosirasemongon1) {
        ztyosirasemongon1 = pZtyosirasemongon1;
    }

    private String ztyosirasemongon2;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYOSIRASEMONGON2)
    public String getZtyosirasemongon2() {
        return ztyosirasemongon2;
    }

    public void setZtyosirasemongon2(String pZtyosirasemongon2) {
        ztyosirasemongon2 = pZtyosirasemongon2;
    }

    private String ztyosirasemongon3;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYOSIRASEMONGON3)
    public String getZtyosirasemongon3() {
        return ztyosirasemongon3;
    }

    public void setZtyosirasemongon3(String pZtyosirasemongon3) {
        ztyosirasemongon3 = pZtyosirasemongon3;
    }

    private String ztyosirasemongon4;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYOSIRASEMONGON4)
    public String getZtyosirasemongon4() {
        return ztyosirasemongon4;
    }

    public void setZtyosirasemongon4(String pZtyosirasemongon4) {
        ztyosirasemongon4 = pZtyosirasemongon4;
    }

    private String ztyosirasemongon5;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYOSIRASEMONGON5)
    public String getZtyosirasemongon5() {
        return ztyosirasemongon5;
    }

    public void setZtyosirasemongon5(String pZtyosirasemongon5) {
        ztyosirasemongon5 = pZtyosirasemongon5;
    }

    private String ztyosirasemongon6;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYOSIRASEMONGON6)
    public String getZtyosirasemongon6() {
        return ztyosirasemongon6;
    }

    public void setZtyosirasemongon6(String pZtyosirasemongon6) {
        ztyosirasemongon6 = pZtyosirasemongon6;
    }

    private String ztyosirasemongon7;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYOSIRASEMONGON7)
    public String getZtyosirasemongon7() {
        return ztyosirasemongon7;
    }

    public void setZtyosirasemongon7(String pZtyosirasemongon7) {
        ztyosirasemongon7 = pZtyosirasemongon7;
    }

    private String ztyosirasemongon8;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYOSIRASEMONGON8)
    public String getZtyosirasemongon8() {
        return ztyosirasemongon8;
    }

    public void setZtyosirasemongon8(String pZtyosirasemongon8) {
        ztyosirasemongon8 = pZtyosirasemongon8;
    }

    private String ztyosirasemongon9;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYOSIRASEMONGON9)
    public String getZtyosirasemongon9() {
        return ztyosirasemongon9;
    }

    public void setZtyosirasemongon9(String pZtyosirasemongon9) {
        ztyosirasemongon9 = pZtyosirasemongon9;
    }

    private String ztyyobiv181;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYYOBIV181)
    public String getZtyyobiv181() {
        return ztyyobiv181;
    }

    public void setZtyyobiv181(String pZtyyobiv181) {
        ztyyobiv181 = pZtyyobiv181;
    }

    private String ztyansyuyouyobin10x4;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYANSYUYOUYOBIN10X4)
    public String getZtyansyuyouyobin10x4() {
        return ztyansyuyouyobin10x4;
    }

    public void setZtyansyuyouyobin10x4(String pZtyansyuyouyobin10x4) {
        ztyansyuyouyobin10x4 = pZtyansyuyouyobin10x4;
    }

    private String ztysyono2;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztykzinfo30keta1;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYKZINFO30KETA1)
    public String getZtykzinfo30keta1() {
        return ztykzinfo30keta1;
    }

    public void setZtykzinfo30keta1(String pZtykzinfo30keta1) {
        ztykzinfo30keta1 = pZtykzinfo30keta1;
    }

    private String ztykzinfo30keta2;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYKZINFO30KETA2)
    public String getZtykzinfo30keta2() {
        return ztykzinfo30keta2;
    }

    public void setZtykzinfo30keta2(String pZtykzinfo30keta2) {
        ztykzinfo30keta2 = pZtykzinfo30keta2;
    }

    private String ztykzinfo30keta3;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYKZINFO30KETA3)
    public String getZtykzinfo30keta3() {
        return ztykzinfo30keta3;
    }

    public void setZtykzinfo30keta3(String pZtykzinfo30keta3) {
        ztykzinfo30keta3 = pZtykzinfo30keta3;
    }

    private String ztykouzamaskingmsg;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYKOUZAMASKINGMSG)
    public String getZtykouzamaskingmsg() {
        return ztykouzamaskingmsg;
    }

    public void setZtykouzamaskingmsg(String pZtykouzamaskingmsg) {
        ztykouzamaskingmsg = pZtykouzamaskingmsg;
    }

    private String ztyyobiv50;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYYOBIV50)
    public String getZtyyobiv50() {
        return ztyyobiv50;
    }

    public void setZtyyobiv50(String pZtyyobiv50) {
        ztyyobiv50 = pZtyyobiv50;
    }

    private String ztyansyuyouyobin10x5;

    @Column(name=GenZT_DattaiTuutiKzhuriTy.ZTYANSYUYOUYOBIN10X5)
    public String getZtyansyuyouyobin10x5() {
        return ztyansyuyouyobin10x5;
    }

    public void setZtyansyuyouyobin10x5(String pZtyansyuyouyobin10x5) {
        ztyansyuyouyobin10x5 = pZtyansyuyouyobin10x5;
    }
}