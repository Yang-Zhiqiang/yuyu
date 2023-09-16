package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KouzaHnknTuutiRn;
import yuyu.def.db.id.PKZT_KouzaHnknTuutiRn;
import yuyu.def.db.meta.GenQZT_KouzaHnknTuutiRn;
import yuyu.def.db.meta.QZT_KouzaHnknTuutiRn;

/**
 * 口座返金通知テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KouzaHnknTuutiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KouzaHnknTuutiRn}</td><td colspan="3">口座返金通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_KouzaHnknTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdkj zrntyouhyouymdkj}</td><td>（連携用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KouzaHnknTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">{@link PKZT_KouzaHnknTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv14 zrnyobiv14}</td><td>（連携用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZrntuutisakuseiymdV11 zrntuutisakuseiymdV11}</td><td>（連携用）通知作成年月日Ｖ１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkymdmdkj zrnhrkymdmdkj}</td><td>（連携用）払込日（月日漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknaiyoumidasi zrnnyknaiyoumidasi}</td><td>（連携用）入金内容見出し</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnymdmidasi zrnymdmidasi}</td><td>（連携用）日付見出し</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingakumidasi zrnkingakumidasi}</td><td>（連携用）金額見出し</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknymdseirekikj zrnnyknymdseirekikj}</td><td>（連携用）入金日（西暦漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuukinngaku zrnnyuukinngaku}</td><td>（連携用）入金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpjyuutouym zrnpjyuutouym}</td><td>（連携用）保険料充当年月</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv32 zrnyobiv32}</td><td>（連携用）予備項目Ｖ３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x4 zrnansyuyouyobin10x4}</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkmymdseireki zrnhrkmymdseireki}</td><td>（連携用）振込日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgk zrnshrgk}</td><td>（連携用）支払金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshririyuu1 zrnshririyuu1}</td><td>（連携用）支払理由１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshririyuu2 zrnshririyuu2}</td><td>（連携用）支払理由２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshririyuu3 zrnshririyuu3}</td><td>（連携用）支払理由３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteikouza1 zrnsiteikouza1}</td><td>（連携用）指定口座１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteikouza2 zrnsiteikouza2}</td><td>（連携用）指定口座２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteikouza3 zrnsiteikouza3}</td><td>（連携用）指定口座３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteikouza4 zrnsiteikouza4}</td><td>（連携用）指定口座４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteikouza5 zrnsiteikouza5}</td><td>（連携用）指定口座５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyusyaku zrntyusyaku}</td><td>（連携用）注釈</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv160 zrnyobiv160}</td><td>（連携用）予備項目Ｖ１６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x5 zrnansyuyouyobin10x5}</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KouzaHnknTuutiRn
 * @see     PKZT_KouzaHnknTuutiRn
 * @see     QZT_KouzaHnknTuutiRn
 * @see     GenQZT_KouzaHnknTuutiRn
 */
@MappedSuperclass
@Table(name=GenZT_KouzaHnknTuutiRn.TABLE_NAME)
@IdClass(value=PKZT_KouzaHnknTuutiRn.class)
public abstract class GenZT_KouzaHnknTuutiRn extends AbstractExDBEntityForZDB<ZT_KouzaHnknTuutiRn, PKZT_KouzaHnknTuutiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KouzaHnknTuutiRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNTYOUHYOUYMDKJ         = "zrntyouhyouymdkj";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNSIKIBETUNO            = "zrnsikibetuno";
    public static final String ZRNYOBIV14               = "zrnyobiv14";
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
    public static final String ZRNTUUTISAKUSEIYMDV11    = "zrntuutisakuseiymdV11";
    public static final String ZRNHRKYMDMDKJ            = "zrnhrkymdmdkj";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNNYKNAIYOUMIDASI       = "zrnnyknaiyoumidasi";
    public static final String ZRNYMDMIDASI             = "zrnymdmidasi";
    public static final String ZRNKINGAKUMIDASI         = "zrnkingakumidasi";
    public static final String ZRNNYKNYMDSEIREKIKJ      = "zrnnyknymdseirekikj";
    public static final String ZRNNYUUKINNGAKU          = "zrnnyuukinngaku";
    public static final String ZRNPJYUUTOUYM            = "zrnpjyuutouym";
    public static final String ZRNYOBIV32               = "zrnyobiv32";
    public static final String ZRNANSYUYOUYOBIN10X4     = "zrnansyuyouyobin10x4";
    public static final String ZRNHRKMYMDSEIREKI        = "zrnhrkmymdseireki";
    public static final String ZRNSHRGK                 = "zrnshrgk";
    public static final String ZRNSHRIRIYUU1            = "zrnshririyuu1";
    public static final String ZRNSHRIRIYUU2            = "zrnshririyuu2";
    public static final String ZRNSHRIRIYUU3            = "zrnshririyuu3";
    public static final String ZRNSITEIKOUZA1           = "zrnsiteikouza1";
    public static final String ZRNSITEIKOUZA2           = "zrnsiteikouza2";
    public static final String ZRNSITEIKOUZA3           = "zrnsiteikouza3";
    public static final String ZRNSITEIKOUZA4           = "zrnsiteikouza4";
    public static final String ZRNSITEIKOUZA5           = "zrnsiteikouza5";
    public static final String ZRNTYUSYAKU              = "zrntyusyaku";
    public static final String ZRNYOBIV160              = "zrnyobiv160";
    public static final String ZRNANSYUYOUYOBIN10X5     = "zrnansyuyouyobin10x5";

    private final PKZT_KouzaHnknTuutiRn primaryKey;

    public GenZT_KouzaHnknTuutiRn() {
        primaryKey = new PKZT_KouzaHnknTuutiRn();
    }

    public GenZT_KouzaHnknTuutiRn(
        String pZrnsyono,
        String pZrntyouhyouymd,
        String pZrnsikibetuno
    ) {
        primaryKey = new PKZT_KouzaHnknTuutiRn(
            pZrnsyono,
            pZrntyouhyouymd,
            pZrnsikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_KouzaHnknTuutiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KouzaHnknTuutiRn> getMetaClass() {
        return QZT_KouzaHnknTuutiRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    @Id
    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrntyouhyouymdkj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTYOUHYOUYMDKJ)
    public String getZrntyouhyouymdkj() {
        return zrntyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdkj(String pZrntyouhyouymdkj) {
        zrntyouhyouymdkj = pZrntyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSIKIBETUNO)
    public String getZrnsikibetuno() {
        return getPrimaryKey().getZrnsikibetuno();
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        getPrimaryKey().setZrnsikibetuno(pZrnsikibetuno);
    }

    private String zrnyobiv14;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNYOBIV14)
    public String getZrnyobiv14() {
        return zrnyobiv14;
    }

    public void setZrnyobiv14(String pZrnyobiv14) {
        zrnyobiv14 = pZrnyobiv14;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnshskyno;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrnansyuyouyobin10x2;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNANSYUYOUYOBIN10X2)
    public String getZrnansyuyouyobin10x2() {
        return zrnansyuyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x2(String pZrnansyuyouyobin10x2) {
        zrnansyuyouyobin10x2 = pZrnansyuyouyobin10x2;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnsakunm15keta;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSAKUNM15KETA)
    public String getZrnsakunm15keta() {
        return zrnsakunm15keta;
    }

    public void setZrnsakunm15keta(String pZrnsakunm15keta) {
        zrnsakunm15keta = pZrnsakunm15keta;
    }

    private String zrnyobiv62;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNYOBIV62)
    public String getZrnyobiv62() {
        return zrnyobiv62;
    }

    public void setZrnyobiv62(String pZrnyobiv62) {
        zrnyobiv62 = pZrnyobiv62;
    }

    private String zrnansyuyouyobin10x3;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNANSYUYOUYOBIN10X3)
    public String getZrnansyuyouyobin10x3() {
        return zrnansyuyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x3(String pZrnansyuyouyobin10x3) {
        zrnansyuyouyobin10x3 = pZrnansyuyouyobin10x3;
    }

    private String zrntuutisakuseiymdV11;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTUUTISAKUSEIYMDV11)
    public String getZrntuutisakuseiymdV11() {
        return zrntuutisakuseiymdV11;
    }

    @DataConvert("toMultiByte")
    public void setZrntuutisakuseiymdV11(String pZrntuutisakuseiymdV11) {
        zrntuutisakuseiymdV11 = pZrntuutisakuseiymdV11;
    }

    private String zrnhrkymdmdkj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNHRKYMDMDKJ)
    public String getZrnhrkymdmdkj() {
        return zrnhrkymdmdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkymdmdkj(String pZrnhrkymdmdkj) {
        zrnhrkymdmdkj = pZrnhrkymdmdkj;
    }

    private String zrnsyono2;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnnyknaiyoumidasi;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNNYKNAIYOUMIDASI)
    public String getZrnnyknaiyoumidasi() {
        return zrnnyknaiyoumidasi;
    }

    @DataConvert("toMultiByte")
    public void setZrnnyknaiyoumidasi(String pZrnnyknaiyoumidasi) {
        zrnnyknaiyoumidasi = pZrnnyknaiyoumidasi;
    }

    private String zrnymdmidasi;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNYMDMIDASI)
    public String getZrnymdmidasi() {
        return zrnymdmidasi;
    }

    @DataConvert("toMultiByte")
    public void setZrnymdmidasi(String pZrnymdmidasi) {
        zrnymdmidasi = pZrnymdmidasi;
    }

    private String zrnkingakumidasi;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNKINGAKUMIDASI)
    public String getZrnkingakumidasi() {
        return zrnkingakumidasi;
    }

    @DataConvert("toMultiByte")
    public void setZrnkingakumidasi(String pZrnkingakumidasi) {
        zrnkingakumidasi = pZrnkingakumidasi;
    }

    private String zrnnyknymdseirekikj;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNNYKNYMDSEIREKIKJ)
    public String getZrnnyknymdseirekikj() {
        return zrnnyknymdseirekikj;
    }

    @DataConvert("toMultiByte")
    public void setZrnnyknymdseirekikj(String pZrnnyknymdseirekikj) {
        zrnnyknymdseirekikj = pZrnnyknymdseirekikj;
    }

    private String zrnnyuukinngaku;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNNYUUKINNGAKU)
    public String getZrnnyuukinngaku() {
        return zrnnyuukinngaku;
    }

    @Padding(mode = "left", padChar = '0', length = 13)
    public void setZrnnyuukinngaku(String pZrnnyuukinngaku) {
        zrnnyuukinngaku = pZrnnyuukinngaku;
    }

    private String zrnpjyuutouym;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNPJYUUTOUYM)
    public String getZrnpjyuutouym() {
        return zrnpjyuutouym;
    }

    @DataConvert("toMultiByte")
    public void setZrnpjyuutouym(String pZrnpjyuutouym) {
        zrnpjyuutouym = pZrnpjyuutouym;
    }

    private String zrnyobiv32;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNYOBIV32)
    public String getZrnyobiv32() {
        return zrnyobiv32;
    }

    public void setZrnyobiv32(String pZrnyobiv32) {
        zrnyobiv32 = pZrnyobiv32;
    }

    private String zrnansyuyouyobin10x4;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNANSYUYOUYOBIN10X4)
    public String getZrnansyuyouyobin10x4() {
        return zrnansyuyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x4(String pZrnansyuyouyobin10x4) {
        zrnansyuyouyobin10x4 = pZrnansyuyouyobin10x4;
    }

    private String zrnhrkmymdseireki;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNHRKMYMDSEIREKI)
    public String getZrnhrkmymdseireki() {
        return zrnhrkmymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkmymdseireki(String pZrnhrkmymdseireki) {
        zrnhrkmymdseireki = pZrnhrkmymdseireki;
    }

    private String zrnshrgk;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSHRGK)
    public String getZrnshrgk() {
        return zrnshrgk;
    }

    @Padding(mode = "left", padChar = '0', length = 13)
    public void setZrnshrgk(String pZrnshrgk) {
        zrnshrgk = pZrnshrgk;
    }

    private String zrnshririyuu1;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSHRIRIYUU1)
    public String getZrnshririyuu1() {
        return zrnshririyuu1;
    }

    @DataConvert("toMultiByte")
    public void setZrnshririyuu1(String pZrnshririyuu1) {
        zrnshririyuu1 = pZrnshririyuu1;
    }

    private String zrnshririyuu2;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSHRIRIYUU2)
    public String getZrnshririyuu2() {
        return zrnshririyuu2;
    }

    @DataConvert("toMultiByte")
    public void setZrnshririyuu2(String pZrnshririyuu2) {
        zrnshririyuu2 = pZrnshririyuu2;
    }

    private String zrnshririyuu3;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSHRIRIYUU3)
    public String getZrnshririyuu3() {
        return zrnshririyuu3;
    }

    @DataConvert("toMultiByte")
    public void setZrnshririyuu3(String pZrnshririyuu3) {
        zrnshririyuu3 = pZrnshririyuu3;
    }

    private String zrnsiteikouza1;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSITEIKOUZA1)
    public String getZrnsiteikouza1() {
        return zrnsiteikouza1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsiteikouza1(String pZrnsiteikouza1) {
        zrnsiteikouza1 = pZrnsiteikouza1;
    }

    private String zrnsiteikouza2;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSITEIKOUZA2)
    public String getZrnsiteikouza2() {
        return zrnsiteikouza2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsiteikouza2(String pZrnsiteikouza2) {
        zrnsiteikouza2 = pZrnsiteikouza2;
    }

    private String zrnsiteikouza3;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSITEIKOUZA3)
    public String getZrnsiteikouza3() {
        return zrnsiteikouza3;
    }

    @DataConvert("toMultiByte")
    public void setZrnsiteikouza3(String pZrnsiteikouza3) {
        zrnsiteikouza3 = pZrnsiteikouza3;
    }

    private String zrnsiteikouza4;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSITEIKOUZA4)
    public String getZrnsiteikouza4() {
        return zrnsiteikouza4;
    }

    @DataConvert("toMultiByte")
    public void setZrnsiteikouza4(String pZrnsiteikouza4) {
        zrnsiteikouza4 = pZrnsiteikouza4;
    }

    private String zrnsiteikouza5;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNSITEIKOUZA5)
    public String getZrnsiteikouza5() {
        return zrnsiteikouza5;
    }

    @DataConvert("toMultiByte")
    public void setZrnsiteikouza5(String pZrnsiteikouza5) {
        zrnsiteikouza5 = pZrnsiteikouza5;
    }

    private String zrntyusyaku;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNTYUSYAKU)
    public String getZrntyusyaku() {
        return zrntyusyaku;
    }

    @DataConvert("toMultiByte")
    public void setZrntyusyaku(String pZrntyusyaku) {
        zrntyusyaku = pZrntyusyaku;
    }

    private String zrnyobiv160;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNYOBIV160)
    public String getZrnyobiv160() {
        return zrnyobiv160;
    }

    public void setZrnyobiv160(String pZrnyobiv160) {
        zrnyobiv160 = pZrnyobiv160;
    }

    private String zrnansyuyouyobin10x5;

    @Column(name=GenZT_KouzaHnknTuutiRn.ZRNANSYUYOUYOBIN10X5)
    public String getZrnansyuyouyobin10x5() {
        return zrnansyuyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x5(String pZrnansyuyouyobin10x5) {
        zrnansyuyouyobin10x5 = pZrnansyuyouyobin10x5;
    }
}