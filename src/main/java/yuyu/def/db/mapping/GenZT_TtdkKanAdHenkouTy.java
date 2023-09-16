package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_TtdkKanAdHenkouTy;
import yuyu.def.db.id.PKZT_TtdkKanAdHenkouTy;
import yuyu.def.db.meta.GenQZT_TtdkKanAdHenkouTy;
import yuyu.def.db.meta.QZT_TtdkKanAdHenkouTy;

/**
 * 手続完了（住所変更）Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_TtdkKanAdHenkouTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanAdHenkouTy}</td><td colspan="3">手続完了（住所変更）Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_TtdkKanAdHenkouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_TtdkKanAdHenkouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyodouhuukbn ztysyodouhuukbn}</td><td>（中継用）証券同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24 ztyyobiv24}</td><td>（中継用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoruicd2 ztysyoruicd2}</td><td>（中継用）書類コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd2 ztytyouhyouymd2}</td><td>（中継用）帳票作成日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn2 ztyhassoukbn2}</td><td>（中継用）発送区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyodouhuukbn2 ztysyodouhuukbn2}</td><td>（中継用）証券同封区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">{@link PKZT_TtdkKanAdHenkouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv44 ztyyobiv44}</td><td>（中継用）予備項目Ｖ４４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskyno ztyshskyno}</td><td>（中継用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr1kj ztyshskadr1kj}</td><td>（中継用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr2kj ztyshskadr2kj}</td><td>（中継用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr3kj ztyshskadr3kj}</td><td>（中継用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshsnmkjttdk ztyshsnmkjttdk}</td><td>（中継用）送付先名（漢字）（手続完了）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv43 ztyyobiv43}</td><td>（中継用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawsosikikj ztytawsosikikj}</td><td>（中継用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawyno ztytawyno}</td><td>（中継用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr1kj ztytawadr1kj}</td><td>（中継用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr2kj ztytawadr2kj}</td><td>（中継用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr3kj ztytawadr3kj}</td><td>（中継用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawtelno ztytawtelno}</td><td>（中継用）問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou1 ztytawteluktkkanou1}</td><td>（中継用）問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou2 ztytawteluktkkanou2}</td><td>（中継用）問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tawsosikinmkj ztydai2tawsosikinmkj}</td><td>（中継用）第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tawtelno ztydai2tawtelno}</td><td>（中継用）第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysclatosyono ztysclatosyono}</td><td>（中継用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakunm ztysakunm}</td><td>（中継用）作成番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv66 ztyyobiv66}</td><td>（中継用）予備項目Ｖ６６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono3 ztysyono3}</td><td>（中継用）証券番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytetudukisyunm ztytetudukisyunm}</td><td>（中継用）手続種類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj ztykyknmkj}</td><td>（中継用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv59 ztyyobiv59}</td><td>（中継用）予備項目Ｖ５９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanAdHenkouTy
 * @see     PKZT_TtdkKanAdHenkouTy
 * @see     QZT_TtdkKanAdHenkouTy
 * @see     GenQZT_TtdkKanAdHenkouTy
 */
@MappedSuperclass
@Table(name=GenZT_TtdkKanAdHenkouTy.TABLE_NAME)
@IdClass(value=PKZT_TtdkKanAdHenkouTy.class)
public abstract class GenZT_TtdkKanAdHenkouTy extends AbstractExDBEntity<ZT_TtdkKanAdHenkouTy, PKZT_TtdkKanAdHenkouTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TtdkKanAdHenkouTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYSYODOUHUUKBN          = "ztysyodouhuukbn";
    public static final String ZTYYOBIV24               = "ztyyobiv24";
    public static final String ZTYSYORUICD2             = "ztysyoruicd2";
    public static final String ZTYTYOUHYOUYMD2          = "ztytyouhyouymd2";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYHASSOUKBN2            = "ztyhassoukbn2";
    public static final String ZTYSYODOUHUUKBN2         = "ztysyodouhuukbn2";
    public static final String ZTYSIKIBETUNO            = "ztysikibetuno";
    public static final String ZTYYOBIV44               = "ztyyobiv44";
    public static final String ZTYSHSKYNO               = "ztyshskyno";
    public static final String ZTYSHSKADR1KJ            = "ztyshskadr1kj";
    public static final String ZTYSHSKADR2KJ            = "ztyshskadr2kj";
    public static final String ZTYSHSKADR3KJ            = "ztyshskadr3kj";
    public static final String ZTYSHSNMKJTTDK           = "ztyshsnmkjttdk";
    public static final String ZTYYOBIV43               = "ztyyobiv43";
    public static final String ZTYTAWSOSIKIKJ           = "ztytawsosikikj";
    public static final String ZTYTAWYNO                = "ztytawyno";
    public static final String ZTYTAWADR1KJ             = "ztytawadr1kj";
    public static final String ZTYTAWADR2KJ             = "ztytawadr2kj";
    public static final String ZTYTAWADR3KJ             = "ztytawadr3kj";
    public static final String ZTYTAWTELNO              = "ztytawtelno";
    public static final String ZTYTAWTELUKTKKANOU1      = "ztytawteluktkkanou1";
    public static final String ZTYTAWTELUKTKKANOU2      = "ztytawteluktkkanou2";
    public static final String ZTYDAI2TAWSOSIKINMKJ     = "ztydai2tawsosikinmkj";
    public static final String ZTYDAI2TAWTELNO          = "ztydai2tawtelno";
    public static final String ZTYSCLATOSYONO           = "ztysclatosyono";
    public static final String ZTYSAKUNM                = "ztysakunm";
    public static final String ZTYYOBIV66               = "ztyyobiv66";
    public static final String ZTYSYONO3                = "ztysyono3";
    public static final String ZTYTETUDUKISYUNM         = "ztytetudukisyunm";
    public static final String ZTYKYKNMKJ               = "ztykyknmkj";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYYOBIV59               = "ztyyobiv59";

    private final PKZT_TtdkKanAdHenkouTy primaryKey;

    public GenZT_TtdkKanAdHenkouTy() {
        primaryKey = new PKZT_TtdkKanAdHenkouTy();
    }

    public GenZT_TtdkKanAdHenkouTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        primaryKey = new PKZT_TtdkKanAdHenkouTy(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_TtdkKanAdHenkouTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TtdkKanAdHenkouTy> getMetaClass() {
        return QZT_TtdkKanAdHenkouTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    @Id
    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztysyodouhuukbn;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSYODOUHUUKBN)
    public String getZtysyodouhuukbn() {
        return ztysyodouhuukbn;
    }

    public void setZtysyodouhuukbn(String pZtysyodouhuukbn) {
        ztysyodouhuukbn = pZtysyodouhuukbn;
    }

    private String ztyyobiv24;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYYOBIV24)
    public String getZtyyobiv24() {
        return ztyyobiv24;
    }

    public void setZtyyobiv24(String pZtyyobiv24) {
        ztyyobiv24 = pZtyyobiv24;
    }

    private String ztysyoruicd2;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSYORUICD2)
    public String getZtysyoruicd2() {
        return ztysyoruicd2;
    }

    public void setZtysyoruicd2(String pZtysyoruicd2) {
        ztysyoruicd2 = pZtysyoruicd2;
    }

    private String ztytyouhyouymd2;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTYOUHYOUYMD2)
    public String getZtytyouhyouymd2() {
        return ztytyouhyouymd2;
    }

    public void setZtytyouhyouymd2(String pZtytyouhyouymd2) {
        ztytyouhyouymd2 = pZtytyouhyouymd2;
    }

    private String ztysyono2;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztyhassoukbn2;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYHASSOUKBN2)
    public String getZtyhassoukbn2() {
        return ztyhassoukbn2;
    }

    public void setZtyhassoukbn2(String pZtyhassoukbn2) {
        ztyhassoukbn2 = pZtyhassoukbn2;
    }

    private String ztysyodouhuukbn2;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSYODOUHUUKBN2)
    public String getZtysyodouhuukbn2() {
        return ztysyodouhuukbn2;
    }

    public void setZtysyodouhuukbn2(String pZtysyodouhuukbn2) {
        ztysyodouhuukbn2 = pZtysyodouhuukbn2;
    }

    @Id
    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSIKIBETUNO)
    public String getZtysikibetuno() {
        return getPrimaryKey().getZtysikibetuno();
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        getPrimaryKey().setZtysikibetuno(pZtysikibetuno);
    }

    private String ztyyobiv44;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYYOBIV44)
    public String getZtyyobiv44() {
        return ztyyobiv44;
    }

    public void setZtyyobiv44(String pZtyyobiv44) {
        ztyyobiv44 = pZtyyobiv44;
    }

    private String ztyshskyno;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkjttdk;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSHSNMKJTTDK)
    public String getZtyshsnmkjttdk() {
        return ztyshsnmkjttdk;
    }

    public void setZtyshsnmkjttdk(String pZtyshsnmkjttdk) {
        ztyshsnmkjttdk = pZtyshsnmkjttdk;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelno;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTAWTELNO)
    public String getZtytawtelno() {
        return ztytawtelno;
    }

    public void setZtytawtelno(String pZtytawtelno) {
        ztytawtelno = pZtytawtelno;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztysakunm;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSAKUNM)
    public String getZtysakunm() {
        return ztysakunm;
    }

    public void setZtysakunm(String pZtysakunm) {
        ztysakunm = pZtysakunm;
    }

    private String ztyyobiv66;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYYOBIV66)
    public String getZtyyobiv66() {
        return ztyyobiv66;
    }

    public void setZtyyobiv66(String pZtyyobiv66) {
        ztyyobiv66 = pZtyyobiv66;
    }

    private String ztysyono3;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYSYONO3)
    public String getZtysyono3() {
        return ztysyono3;
    }

    public void setZtysyono3(String pZtysyono3) {
        ztysyono3 = pZtysyono3;
    }

    private String ztytetudukisyunm;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYTETUDUKISYUNM)
    public String getZtytetudukisyunm() {
        return ztytetudukisyunm;
    }

    public void setZtytetudukisyunm(String pZtytetudukisyunm) {
        ztytetudukisyunm = pZtytetudukisyunm;
    }

    private String ztykyknmkj;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYKYKNMKJ)
    public String getZtykyknmkj() {
        return ztykyknmkj;
    }

    public void setZtykyknmkj(String pZtykyknmkj) {
        ztykyknmkj = pZtykyknmkj;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztyyobiv59;

    @Column(name=GenZT_TtdkKanAdHenkouTy.ZTYYOBIV59)
    public String getZtyyobiv59() {
        return ztyyobiv59;
    }

    public void setZtyyobiv59(String pZtyyobiv59) {
        ztyyobiv59 = pZtyyobiv59;
    }
}
