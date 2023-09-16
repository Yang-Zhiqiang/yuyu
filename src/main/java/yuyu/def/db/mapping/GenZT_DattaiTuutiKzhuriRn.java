package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DattaiTuutiKzhuriRn;
import yuyu.def.db.id.PKZT_DattaiTuutiKzhuriRn;
import yuyu.def.db.meta.GenQZT_DattaiTuutiKzhuriRn;
import yuyu.def.db.meta.QZT_DattaiTuutiKzhuriRn;

/**
 * 脱退通知（口座振替）テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DattaiTuutiKzhuriRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DattaiTuutiKzhuriRn}</td><td colspan="3">脱退通知（口座振替）テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_DattaiTuutiKzhuriRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdkj zrntyouhyouymdkj}</td><td>（連携用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_DattaiTuutiKzhuriRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10 zrnansyuyouyobin10}</td><td>（連携用）案内収納用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskyno zrnshskyno}</td><td>（連携用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr1kj zrnshskadr1kj}</td><td>（連携用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr2kj zrnshskadr2kj}</td><td>（連携用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr3kj zrnshskadr3kj}</td><td>（連携用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshsnmkj zrnshsnmkj}</td><td>（連携用）送付先名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv43 zrnyobiv43}</td><td>（連携用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x2 zrnansyuyouyobin10x2}</td><td>（連携用）案内収納用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawsosikikj zrntawsosikikj}</td><td>（連携用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawyno zrntawyno}</td><td>（連携用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr1kj zrntawadr1kj}</td><td>（連携用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr2kj zrntawadr2kj}</td><td>（連携用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr3kj zrntawadr3kj}</td><td>（連携用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawtelnov14 zrntawtelnov14}</td><td>（連携用）問合せ先電話番号Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou1 zrntawteluktkkanou1}</td><td>（連携用）問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou2 zrntawteluktkkanou2}</td><td>（連携用）問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tawsosikinmkj zrndai2tawsosikinmkj}</td><td>（連携用）第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tawtelno zrndai2tawtelno}</td><td>（連携用）第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsclatosyono zrnsclatosyono}</td><td>（連携用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakunm15keta zrnsakunm15keta}</td><td>（連携用）作成番号（１５桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv62 zrnyobiv62}</td><td>（連携用）予備項目Ｖ６２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x3 zrnansyuyouyobin10x3}</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon1 zrnosirasemongon1}</td><td>（連携用）お知らせ文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon2 zrnosirasemongon2}</td><td>（連携用）お知らせ文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon3 zrnosirasemongon3}</td><td>（連携用）お知らせ文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon4 zrnosirasemongon4}</td><td>（連携用）お知らせ文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon5 zrnosirasemongon5}</td><td>（連携用）お知らせ文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon6 zrnosirasemongon6}</td><td>（連携用）お知らせ文言６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon7 zrnosirasemongon7}</td><td>（連携用）お知らせ文言７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon8 zrnosirasemongon8}</td><td>（連携用）お知らせ文言８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon9 zrnosirasemongon9}</td><td>（連携用）お知らせ文言９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv181 zrnyobiv181}</td><td>（連携用）予備項目Ｖ１８１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x4 zrnansyuyouyobin10x4}</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo30keta1 zrnkzinfo30keta1}</td><td>（連携用）口座情報（３０桁）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo30keta2 zrnkzinfo30keta2}</td><td>（連携用）口座情報（３０桁）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo30keta3 zrnkzinfo30keta3}</td><td>（連携用）口座情報（３０桁）３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzamaskingmsg zrnkouzamaskingmsg}</td><td>（連携用）口座マスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv50 zrnyobiv50}</td><td>（連携用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x5 zrnansyuyouyobin10x5}</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DattaiTuutiKzhuriRn
 * @see     PKZT_DattaiTuutiKzhuriRn
 * @see     QZT_DattaiTuutiKzhuriRn
 * @see     GenQZT_DattaiTuutiKzhuriRn
 */
@MappedSuperclass
@Table(name=GenZT_DattaiTuutiKzhuriRn.TABLE_NAME)
@IdClass(value=PKZT_DattaiTuutiKzhuriRn.class)
public abstract class GenZT_DattaiTuutiKzhuriRn extends AbstractExDBEntityForZDB<ZT_DattaiTuutiKzhuriRn, PKZT_DattaiTuutiKzhuriRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DattaiTuutiKzhuriRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNTYOUHYOUYMDKJ         = "zrntyouhyouymdkj";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
    public static final String ZRNANSYUYOUYOBIN10       = "zrnansyuyouyobin10";
    public static final String ZRNSHSKYNO               = "zrnshskyno";
    public static final String ZRNSHSKADR1KJ            = "zrnshskadr1kj";
    public static final String ZRNSHSKADR2KJ            = "zrnshskadr2kj";
    public static final String ZRNSHSKADR3KJ            = "zrnshskadr3kj";
    public static final String ZRNSHSNMKJ               = "zrnshsnmkj";
    public static final String ZRNYOBIV43               = "zrnyobiv43";
    public static final String ZRNANSYUYOUYOBIN10X2     = "zrnansyuyouyobin10x2";
    public static final String ZRNTAWSOSIKIKJ           = "zrntawsosikikj";
    public static final String ZRNTAWYNO                = "zrntawyno";
    public static final String ZRNTAWADR1KJ             = "zrntawadr1kj";
    public static final String ZRNTAWADR2KJ             = "zrntawadr2kj";
    public static final String ZRNTAWADR3KJ             = "zrntawadr3kj";
    public static final String ZRNTAWTELNOV14           = "zrntawtelnov14";
    public static final String ZRNTAWTELUKTKKANOU1      = "zrntawteluktkkanou1";
    public static final String ZRNTAWTELUKTKKANOU2      = "zrntawteluktkkanou2";
    public static final String ZRNDAI2TAWSOSIKINMKJ     = "zrndai2tawsosikinmkj";
    public static final String ZRNDAI2TAWTELNO          = "zrndai2tawtelno";
    public static final String ZRNSCLATOSYONO           = "zrnsclatosyono";
    public static final String ZRNSAKUNM15KETA          = "zrnsakunm15keta";
    public static final String ZRNYOBIV62               = "zrnyobiv62";
    public static final String ZRNANSYUYOUYOBIN10X3     = "zrnansyuyouyobin10x3";
    public static final String ZRNOSIRASEMONGON1        = "zrnosirasemongon1";
    public static final String ZRNOSIRASEMONGON2        = "zrnosirasemongon2";
    public static final String ZRNOSIRASEMONGON3        = "zrnosirasemongon3";
    public static final String ZRNOSIRASEMONGON4        = "zrnosirasemongon4";
    public static final String ZRNOSIRASEMONGON5        = "zrnosirasemongon5";
    public static final String ZRNOSIRASEMONGON6        = "zrnosirasemongon6";
    public static final String ZRNOSIRASEMONGON7        = "zrnosirasemongon7";
    public static final String ZRNOSIRASEMONGON8        = "zrnosirasemongon8";
    public static final String ZRNOSIRASEMONGON9        = "zrnosirasemongon9";
    public static final String ZRNYOBIV181              = "zrnyobiv181";
    public static final String ZRNANSYUYOUYOBIN10X4     = "zrnansyuyouyobin10x4";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNKZINFO30KETA1         = "zrnkzinfo30keta1";
    public static final String ZRNKZINFO30KETA2         = "zrnkzinfo30keta2";
    public static final String ZRNKZINFO30KETA3         = "zrnkzinfo30keta3";
    public static final String ZRNKOUZAMASKINGMSG       = "zrnkouzamaskingmsg";
    public static final String ZRNYOBIV50               = "zrnyobiv50";
    public static final String ZRNANSYUYOUYOBIN10X5     = "zrnansyuyouyobin10x5";

    private final PKZT_DattaiTuutiKzhuriRn primaryKey;

    public GenZT_DattaiTuutiKzhuriRn() {
        primaryKey = new PKZT_DattaiTuutiKzhuriRn();
    }

    public GenZT_DattaiTuutiKzhuriRn(String pZrntyouhyouymd, String pZrnsyono) {
        primaryKey = new PKZT_DattaiTuutiKzhuriRn(pZrntyouhyouymd, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_DattaiTuutiKzhuriRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DattaiTuutiKzhuriRn> getMetaClass() {
        return QZT_DattaiTuutiKzhuriRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    @Id
    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrntyouhyouymdkj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNTYOUHYOUYMDKJ)
    public String getZrntyouhyouymdkj() {
        return zrntyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdkj(String pZrntyouhyouymdkj) {
        zrntyouhyouymdkj = pZrntyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnyobiv9;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnshskyno;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrnansyuyouyobin10x2;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNANSYUYOUYOBIN10X2)
    public String getZrnansyuyouyobin10x2() {
        return zrnansyuyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x2(String pZrnansyuyouyobin10x2) {
        zrnansyuyouyobin10x2 = pZrnansyuyouyobin10x2;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnsakunm15keta;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNSAKUNM15KETA)
    public String getZrnsakunm15keta() {
        return zrnsakunm15keta;
    }

    public void setZrnsakunm15keta(String pZrnsakunm15keta) {
        zrnsakunm15keta = pZrnsakunm15keta;
    }

    private String zrnyobiv62;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNYOBIV62)
    public String getZrnyobiv62() {
        return zrnyobiv62;
    }

    public void setZrnyobiv62(String pZrnyobiv62) {
        zrnyobiv62 = pZrnyobiv62;
    }

    private String zrnansyuyouyobin10x3;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNANSYUYOUYOBIN10X3)
    public String getZrnansyuyouyobin10x3() {
        return zrnansyuyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x3(String pZrnansyuyouyobin10x3) {
        zrnansyuyouyobin10x3 = pZrnansyuyouyobin10x3;
    }

    private String zrnosirasemongon1;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNOSIRASEMONGON1)
    public String getZrnosirasemongon1() {
        return zrnosirasemongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon1(String pZrnosirasemongon1) {
        zrnosirasemongon1 = pZrnosirasemongon1;
    }

    private String zrnosirasemongon2;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNOSIRASEMONGON2)
    public String getZrnosirasemongon2() {
        return zrnosirasemongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon2(String pZrnosirasemongon2) {
        zrnosirasemongon2 = pZrnosirasemongon2;
    }

    private String zrnosirasemongon3;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNOSIRASEMONGON3)
    public String getZrnosirasemongon3() {
        return zrnosirasemongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon3(String pZrnosirasemongon3) {
        zrnosirasemongon3 = pZrnosirasemongon3;
    }

    private String zrnosirasemongon4;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNOSIRASEMONGON4)
    public String getZrnosirasemongon4() {
        return zrnosirasemongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon4(String pZrnosirasemongon4) {
        zrnosirasemongon4 = pZrnosirasemongon4;
    }

    private String zrnosirasemongon5;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNOSIRASEMONGON5)
    public String getZrnosirasemongon5() {
        return zrnosirasemongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon5(String pZrnosirasemongon5) {
        zrnosirasemongon5 = pZrnosirasemongon5;
    }

    private String zrnosirasemongon6;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNOSIRASEMONGON6)
    public String getZrnosirasemongon6() {
        return zrnosirasemongon6;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon6(String pZrnosirasemongon6) {
        zrnosirasemongon6 = pZrnosirasemongon6;
    }

    private String zrnosirasemongon7;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNOSIRASEMONGON7)
    public String getZrnosirasemongon7() {
        return zrnosirasemongon7;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon7(String pZrnosirasemongon7) {
        zrnosirasemongon7 = pZrnosirasemongon7;
    }

    private String zrnosirasemongon8;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNOSIRASEMONGON8)
    public String getZrnosirasemongon8() {
        return zrnosirasemongon8;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon8(String pZrnosirasemongon8) {
        zrnosirasemongon8 = pZrnosirasemongon8;
    }

    private String zrnosirasemongon9;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNOSIRASEMONGON9)
    public String getZrnosirasemongon9() {
        return zrnosirasemongon9;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon9(String pZrnosirasemongon9) {
        zrnosirasemongon9 = pZrnosirasemongon9;
    }

    private String zrnyobiv181;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNYOBIV181)
    public String getZrnyobiv181() {
        return zrnyobiv181;
    }

    public void setZrnyobiv181(String pZrnyobiv181) {
        zrnyobiv181 = pZrnyobiv181;
    }

    private String zrnansyuyouyobin10x4;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNANSYUYOUYOBIN10X4)
    public String getZrnansyuyouyobin10x4() {
        return zrnansyuyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x4(String pZrnansyuyouyobin10x4) {
        zrnansyuyouyobin10x4 = pZrnansyuyouyobin10x4;
    }

    private String zrnsyono2;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnkzinfo30keta1;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNKZINFO30KETA1)
    public String getZrnkzinfo30keta1() {
        return zrnkzinfo30keta1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo30keta1(String pZrnkzinfo30keta1) {
        zrnkzinfo30keta1 = pZrnkzinfo30keta1;
    }

    private String zrnkzinfo30keta2;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNKZINFO30KETA2)
    public String getZrnkzinfo30keta2() {
        return zrnkzinfo30keta2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo30keta2(String pZrnkzinfo30keta2) {
        zrnkzinfo30keta2 = pZrnkzinfo30keta2;
    }

    private String zrnkzinfo30keta3;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNKZINFO30KETA3)
    public String getZrnkzinfo30keta3() {
        return zrnkzinfo30keta3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo30keta3(String pZrnkzinfo30keta3) {
        zrnkzinfo30keta3 = pZrnkzinfo30keta3;
    }

    private String zrnkouzamaskingmsg;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNKOUZAMASKINGMSG)
    public String getZrnkouzamaskingmsg() {
        return zrnkouzamaskingmsg;
    }

    @DataConvert("toMultiByte")
    public void setZrnkouzamaskingmsg(String pZrnkouzamaskingmsg) {
        zrnkouzamaskingmsg = pZrnkouzamaskingmsg;
    }

    private String zrnyobiv50;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNYOBIV50)
    public String getZrnyobiv50() {
        return zrnyobiv50;
    }

    public void setZrnyobiv50(String pZrnyobiv50) {
        zrnyobiv50 = pZrnyobiv50;
    }

    private String zrnansyuyouyobin10x5;

    @Column(name=GenZT_DattaiTuutiKzhuriRn.ZRNANSYUYOUYOBIN10X5)
    public String getZrnansyuyouyobin10x5() {
        return zrnansyuyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x5(String pZrnansyuyouyobin10x5) {
        zrnansyuyouyobin10x5 = pZrnansyuyouyobin10x5;
    }
}