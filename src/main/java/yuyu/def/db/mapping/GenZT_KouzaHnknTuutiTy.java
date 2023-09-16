package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.ZT_KouzaHnknTuutiTy;
import yuyu.def.db.id.PKZT_KouzaHnknTuutiTy;
import yuyu.def.db.meta.GenQZT_KouzaHnknTuutiTy;
import yuyu.def.db.meta.QZT_KouzaHnknTuutiTy;

/**
 * 口座返金通知テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KouzaHnknTuutiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KouzaHnknTuutiTy}</td><td colspan="3">口座返金通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_KouzaHnknTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdkj ztytyouhyouymdkj}</td><td>（中継用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KouzaHnknTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">{@link PKZT_KouzaHnknTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv14 ztyyobiv14}</td><td>（中継用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZtytuutisakuseiymdV11 ztytuutisakuseiymdV11}</td><td>（中継用）通知作成年月日Ｖ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkymdmdkj ztyhrkymdmdkj}</td><td>（中継用）払込日（月日漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknaiyoumidasi ztynyknaiyoumidasi}</td><td>（中継用）入金内容見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyymdmidasi ztyymdmidasi}</td><td>（中継用）日付見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingakumidasi ztykingakumidasi}</td><td>（中継用）金額見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknymdseirekikj ztynyknymdseirekikj}</td><td>（中継用）入金日（西暦漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuukinngaku ztynyuukinngaku}</td><td>（中継用）入金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypjyuutouym ztypjyuutouym}</td><td>（中継用）保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv32 ztyyobiv32}</td><td>（中継用）予備項目Ｖ３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x4 ztyansyuyouyobin10x4}</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkmymdseireki ztyhrkmymdseireki}</td><td>（中継用）振込日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgk ztyshrgk}</td><td>（中継用）支払金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshririyuu1 ztyshririyuu1}</td><td>（中継用）支払理由１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshririyuu2 ztyshririyuu2}</td><td>（中継用）支払理由２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshririyuu3 ztyshririyuu3}</td><td>（中継用）支払理由３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteikouza1 ztysiteikouza1}</td><td>（中継用）指定口座１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteikouza2 ztysiteikouza2}</td><td>（中継用）指定口座２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteikouza3 ztysiteikouza3}</td><td>（中継用）指定口座３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteikouza4 ztysiteikouza4}</td><td>（中継用）指定口座４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteikouza5 ztysiteikouza5}</td><td>（中継用）指定口座５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyusyaku ztytyusyaku}</td><td>（中継用）注釈</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv160 ztyyobiv160}</td><td>（中継用）予備項目Ｖ１６０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x5 ztyansyuyouyobin10x5}</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KouzaHnknTuutiTy
 * @see     PKZT_KouzaHnknTuutiTy
 * @see     QZT_KouzaHnknTuutiTy
 * @see     GenQZT_KouzaHnknTuutiTy
 */
@MappedSuperclass
@Table(name=GenZT_KouzaHnknTuutiTy.TABLE_NAME)
@IdClass(value=PKZT_KouzaHnknTuutiTy.class)
public abstract class GenZT_KouzaHnknTuutiTy extends AbstractExDBEntity<ZT_KouzaHnknTuutiTy, PKZT_KouzaHnknTuutiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KouzaHnknTuutiTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYTYOUHYOUYMDKJ         = "ztytyouhyouymdkj";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYSIKIBETUNO            = "ztysikibetuno";
    public static final String ZTYYOBIV14               = "ztyyobiv14";
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
    public static final String ZTYTUUTISAKUSEIYMDV11    = "ztytuutisakuseiymdV11";
    public static final String ZTYHRKYMDMDKJ            = "ztyhrkymdmdkj";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYNYKNAIYOUMIDASI       = "ztynyknaiyoumidasi";
    public static final String ZTYYMDMIDASI             = "ztyymdmidasi";
    public static final String ZTYKINGAKUMIDASI         = "ztykingakumidasi";
    public static final String ZTYNYKNYMDSEIREKIKJ      = "ztynyknymdseirekikj";
    public static final String ZTYNYUUKINNGAKU          = "ztynyuukinngaku";
    public static final String ZTYPJYUUTOUYM            = "ztypjyuutouym";
    public static final String ZTYYOBIV32               = "ztyyobiv32";
    public static final String ZTYANSYUYOUYOBIN10X4     = "ztyansyuyouyobin10x4";
    public static final String ZTYHRKMYMDSEIREKI        = "ztyhrkmymdseireki";
    public static final String ZTYSHRGK                 = "ztyshrgk";
    public static final String ZTYSHRIRIYUU1            = "ztyshririyuu1";
    public static final String ZTYSHRIRIYUU2            = "ztyshririyuu2";
    public static final String ZTYSHRIRIYUU3            = "ztyshririyuu3";
    public static final String ZTYSITEIKOUZA1           = "ztysiteikouza1";
    public static final String ZTYSITEIKOUZA2           = "ztysiteikouza2";
    public static final String ZTYSITEIKOUZA3           = "ztysiteikouza3";
    public static final String ZTYSITEIKOUZA4           = "ztysiteikouza4";
    public static final String ZTYSITEIKOUZA5           = "ztysiteikouza5";
    public static final String ZTYTYUSYAKU              = "ztytyusyaku";
    public static final String ZTYYOBIV160              = "ztyyobiv160";
    public static final String ZTYANSYUYOUYOBIN10X5     = "ztyansyuyouyobin10x5";

    private final PKZT_KouzaHnknTuutiTy primaryKey;

    public GenZT_KouzaHnknTuutiTy() {
        primaryKey = new PKZT_KouzaHnknTuutiTy();
    }

    public GenZT_KouzaHnknTuutiTy(
        String pZtysyono,
        String pZtytyouhyouymd,
        String pZtysikibetuno
    ) {
        primaryKey = new PKZT_KouzaHnknTuutiTy(
            pZtysyono,
            pZtytyouhyouymd,
            pZtysikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_KouzaHnknTuutiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KouzaHnknTuutiTy> getMetaClass() {
        return QZT_KouzaHnknTuutiTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    @Id
    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztytyouhyouymdkj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTYOUHYOUYMDKJ)
    public String getZtytyouhyouymdkj() {
        return ztytyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZtytyouhyouymdkj(String pZtytyouhyouymdkj) {
        ztytyouhyouymdkj = pZtytyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSIKIBETUNO)
    public String getZtysikibetuno() {
        return getPrimaryKey().getZtysikibetuno();
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        getPrimaryKey().setZtysikibetuno(pZtysikibetuno);
    }

    private String ztyyobiv14;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYYOBIV14)
    public String getZtyyobiv14() {
        return ztyyobiv14;
    }

    public void setZtyyobiv14(String pZtyyobiv14) {
        ztyyobiv14 = pZtyyobiv14;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyshskyno;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztyansyuyouyobin10x2;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYANSYUYOUYOBIN10X2)
    public String getZtyansyuyouyobin10x2() {
        return ztyansyuyouyobin10x2;
    }

    public void setZtyansyuyouyobin10x2(String pZtyansyuyouyobin10x2) {
        ztyansyuyouyobin10x2 = pZtyansyuyouyobin10x2;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztysakunm15keta;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSAKUNM15KETA)
    public String getZtysakunm15keta() {
        return ztysakunm15keta;
    }

    public void setZtysakunm15keta(String pZtysakunm15keta) {
        ztysakunm15keta = pZtysakunm15keta;
    }

    private String ztyyobiv62;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYYOBIV62)
    public String getZtyyobiv62() {
        return ztyyobiv62;
    }

    public void setZtyyobiv62(String pZtyyobiv62) {
        ztyyobiv62 = pZtyyobiv62;
    }

    private String ztyansyuyouyobin10x3;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYANSYUYOUYOBIN10X3)
    public String getZtyansyuyouyobin10x3() {
        return ztyansyuyouyobin10x3;
    }

    public void setZtyansyuyouyobin10x3(String pZtyansyuyouyobin10x3) {
        ztyansyuyouyobin10x3 = pZtyansyuyouyobin10x3;
    }

    private String ztytuutisakuseiymdV11;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTUUTISAKUSEIYMDV11)
    public String getZtytuutisakuseiymdV11() {
        return ztytuutisakuseiymdV11;
    }

    public void setZtytuutisakuseiymdV11(String pZtytuutisakuseiymdV11) {
        ztytuutisakuseiymdV11 = pZtytuutisakuseiymdV11;
    }

    private String ztyhrkymdmdkj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYHRKYMDMDKJ)
    public String getZtyhrkymdmdkj() {
        return ztyhrkymdmdkj;
    }

    @DataConvert("toMultiByte")
    public void setZtyhrkymdmdkj(String pZtyhrkymdmdkj) {
        ztyhrkymdmdkj = pZtyhrkymdmdkj;
    }

    private String ztysyono2;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztynyknaiyoumidasi;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYNYKNAIYOUMIDASI)
    public String getZtynyknaiyoumidasi() {
        return ztynyknaiyoumidasi;
    }

    @DataConvert("toMultiByte")
    public void setZtynyknaiyoumidasi(String pZtynyknaiyoumidasi) {
        ztynyknaiyoumidasi = pZtynyknaiyoumidasi;
    }

    private String ztyymdmidasi;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYYMDMIDASI)
    public String getZtyymdmidasi() {
        return ztyymdmidasi;
    }

    @DataConvert("toMultiByte")
    public void setZtyymdmidasi(String pZtyymdmidasi) {
        ztyymdmidasi = pZtyymdmidasi;
    }

    private String ztykingakumidasi;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYKINGAKUMIDASI)
    public String getZtykingakumidasi() {
        return ztykingakumidasi;
    }

    @DataConvert("toMultiByte")
    public void setZtykingakumidasi(String pZtykingakumidasi) {
        ztykingakumidasi = pZtykingakumidasi;
    }

    private String ztynyknymdseirekikj;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYNYKNYMDSEIREKIKJ)
    public String getZtynyknymdseirekikj() {
        return ztynyknymdseirekikj;
    }

    @DataConvert("toMultiByte")
    public void setZtynyknymdseirekikj(String pZtynyknymdseirekikj) {
        ztynyknymdseirekikj = pZtynyknymdseirekikj;
    }

    private String ztynyuukinngaku;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYNYUUKINNGAKU)
    public String getZtynyuukinngaku() {
        return ztynyuukinngaku;
    }

    public void setZtynyuukinngaku(String pZtynyuukinngaku) {
        ztynyuukinngaku = pZtynyuukinngaku;
    }

    private String ztypjyuutouym;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYPJYUUTOUYM)
    public String getZtypjyuutouym() {
        return ztypjyuutouym;
    }

    @DataConvert("toMultiByte")
    public void setZtypjyuutouym(String pZtypjyuutouym) {
        ztypjyuutouym = pZtypjyuutouym;
    }

    private String ztyyobiv32;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYYOBIV32)
    public String getZtyyobiv32() {
        return ztyyobiv32;
    }

    public void setZtyyobiv32(String pZtyyobiv32) {
        ztyyobiv32 = pZtyyobiv32;
    }

    private String ztyansyuyouyobin10x4;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYANSYUYOUYOBIN10X4)
    public String getZtyansyuyouyobin10x4() {
        return ztyansyuyouyobin10x4;
    }

    public void setZtyansyuyouyobin10x4(String pZtyansyuyouyobin10x4) {
        ztyansyuyouyobin10x4 = pZtyansyuyouyobin10x4;
    }

    private String ztyhrkmymdseireki;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYHRKMYMDSEIREKI)
    public String getZtyhrkmymdseireki() {
        return ztyhrkmymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZtyhrkmymdseireki(String pZtyhrkmymdseireki) {
        ztyhrkmymdseireki = pZtyhrkmymdseireki;
    }

    private String ztyshrgk;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSHRGK)
    public String getZtyshrgk() {
        return ztyshrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZtyshrgk(String pZtyshrgk) {
        ztyshrgk = pZtyshrgk;
    }

    private String ztyshririyuu1;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSHRIRIYUU1)
    public String getZtyshririyuu1() {
        return ztyshririyuu1;
    }

    public void setZtyshririyuu1(String pZtyshririyuu1) {
        ztyshririyuu1 = pZtyshririyuu1;
    }

    private String ztyshririyuu2;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSHRIRIYUU2)
    public String getZtyshririyuu2() {
        return ztyshririyuu2;
    }

    public void setZtyshririyuu2(String pZtyshririyuu2) {
        ztyshririyuu2 = pZtyshririyuu2;
    }

    private String ztyshririyuu3;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSHRIRIYUU3)
    public String getZtyshririyuu3() {
        return ztyshririyuu3;
    }

    public void setZtyshririyuu3(String pZtyshririyuu3) {
        ztyshririyuu3 = pZtyshririyuu3;
    }

    private String ztysiteikouza1;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSITEIKOUZA1)
    public String getZtysiteikouza1() {
        return ztysiteikouza1;
    }

    public void setZtysiteikouza1(String pZtysiteikouza1) {
        ztysiteikouza1 = pZtysiteikouza1;
    }

    private String ztysiteikouza2;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSITEIKOUZA2)
    public String getZtysiteikouza2() {
        return ztysiteikouza2;
    }

    public void setZtysiteikouza2(String pZtysiteikouza2) {
        ztysiteikouza2 = pZtysiteikouza2;
    }

    private String ztysiteikouza3;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSITEIKOUZA3)
    public String getZtysiteikouza3() {
        return ztysiteikouza3;
    }

    public void setZtysiteikouza3(String pZtysiteikouza3) {
        ztysiteikouza3 = pZtysiteikouza3;
    }

    private String ztysiteikouza4;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSITEIKOUZA4)
    public String getZtysiteikouza4() {
        return ztysiteikouza4;
    }

    public void setZtysiteikouza4(String pZtysiteikouza4) {
        ztysiteikouza4 = pZtysiteikouza4;
    }

    private String ztysiteikouza5;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYSITEIKOUZA5)
    public String getZtysiteikouza5() {
        return ztysiteikouza5;
    }

    public void setZtysiteikouza5(String pZtysiteikouza5) {
        ztysiteikouza5 = pZtysiteikouza5;
    }

    private String ztytyusyaku;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYTYUSYAKU)
    public String getZtytyusyaku() {
        return ztytyusyaku;
    }

    @DataConvert("toMultiByte")
    public void setZtytyusyaku(String pZtytyusyaku) {
        ztytyusyaku = pZtytyusyaku;
    }

    private String ztyyobiv160;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYYOBIV160)
    public String getZtyyobiv160() {
        return ztyyobiv160;
    }

    public void setZtyyobiv160(String pZtyyobiv160) {
        ztyyobiv160 = pZtyyobiv160;
    }

    private String ztyansyuyouyobin10x5;

    @Column(name=GenZT_KouzaHnknTuutiTy.ZTYANSYUYOUYOBIN10X5)
    public String getZtyansyuyouyobin10x5() {
        return ztyansyuyouyobin10x5;
    }

    public void setZtyansyuyouyobin10x5(String pZtyansyuyouyobin10x5) {
        ztyansyuyouyobin10x5 = pZtyansyuyouyobin10x5;
    }
}