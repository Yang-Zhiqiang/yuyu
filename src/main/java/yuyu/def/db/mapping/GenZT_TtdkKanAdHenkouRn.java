package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_TtdkKanAdHenkouRn;
import yuyu.def.db.id.PKZT_TtdkKanAdHenkouRn;
import yuyu.def.db.meta.GenQZT_TtdkKanAdHenkouRn;
import yuyu.def.db.meta.QZT_TtdkKanAdHenkouRn;

/**
 * 手続完了（住所変更）Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TtdkKanAdHenkouRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanAdHenkouRn}</td><td colspan="3">手続完了（住所変更）Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_TtdkKanAdHenkouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_TtdkKanAdHenkouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyodouhuukbn zrnsyodouhuukbn}</td><td>（連携用）証券同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24 zrnyobiv24}</td><td>（連携用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoruicd2 zrnsyoruicd2}</td><td>（連携用）書類コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd2 zrntyouhyouymd2}</td><td>（連携用）帳票作成日２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn2 zrnhassoukbn2}</td><td>（連携用）発送区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyodouhuukbn2 zrnsyodouhuukbn2}</td><td>（連携用）証券同封区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">{@link PKZT_TtdkKanAdHenkouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv44 zrnyobiv44}</td><td>（連携用）予備項目Ｖ４４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskyno zrnshskyno}</td><td>（連携用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr1kj zrnshskadr1kj}</td><td>（連携用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr2kj zrnshskadr2kj}</td><td>（連携用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr3kj zrnshskadr3kj}</td><td>（連携用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshsnmkjttdk zrnshsnmkjttdk}</td><td>（連携用）送付先名（漢字）（手続完了）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv43 zrnyobiv43}</td><td>（連携用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawsosikikj zrntawsosikikj}</td><td>（連携用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawyno zrntawyno}</td><td>（連携用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr1kj zrntawadr1kj}</td><td>（連携用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr2kj zrntawadr2kj}</td><td>（連携用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr3kj zrntawadr3kj}</td><td>（連携用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawtelno zrntawtelno}</td><td>（連携用）問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou1 zrntawteluktkkanou1}</td><td>（連携用）問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou2 zrntawteluktkkanou2}</td><td>（連携用）問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tawsosikinmkj zrndai2tawsosikinmkj}</td><td>（連携用）第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tawtelno zrndai2tawtelno}</td><td>（連携用）第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsclatosyono zrnsclatosyono}</td><td>（連携用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakunm zrnsakunm}</td><td>（連携用）作成番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv66 zrnyobiv66}</td><td>（連携用）予備項目Ｖ６６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono3 zrnsyono3}</td><td>（連携用）証券番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntetudukisyunm zrntetudukisyunm}</td><td>（連携用）手続種類名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj zrnkyknmkj}</td><td>（連携用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv59 zrnyobiv59}</td><td>（連携用）予備項目Ｖ５９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanAdHenkouRn
 * @see     PKZT_TtdkKanAdHenkouRn
 * @see     QZT_TtdkKanAdHenkouRn
 * @see     GenQZT_TtdkKanAdHenkouRn
 */
@MappedSuperclass
@Table(name=GenZT_TtdkKanAdHenkouRn.TABLE_NAME)
@IdClass(value=PKZT_TtdkKanAdHenkouRn.class)
public abstract class GenZT_TtdkKanAdHenkouRn extends AbstractExDBEntityForZDB<ZT_TtdkKanAdHenkouRn, PKZT_TtdkKanAdHenkouRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TtdkKanAdHenkouRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNSYODOUHUUKBN          = "zrnsyodouhuukbn";
    public static final String ZRNYOBIV24               = "zrnyobiv24";
    public static final String ZRNSYORUICD2             = "zrnsyoruicd2";
    public static final String ZRNTYOUHYOUYMD2          = "zrntyouhyouymd2";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNHASSOUKBN2            = "zrnhassoukbn2";
    public static final String ZRNSYODOUHUUKBN2         = "zrnsyodouhuukbn2";
    public static final String ZRNSIKIBETUNO            = "zrnsikibetuno";
    public static final String ZRNYOBIV44               = "zrnyobiv44";
    public static final String ZRNSHSKYNO               = "zrnshskyno";
    public static final String ZRNSHSKADR1KJ            = "zrnshskadr1kj";
    public static final String ZRNSHSKADR2KJ            = "zrnshskadr2kj";
    public static final String ZRNSHSKADR3KJ            = "zrnshskadr3kj";
    public static final String ZRNSHSNMKJTTDK           = "zrnshsnmkjttdk";
    public static final String ZRNYOBIV43               = "zrnyobiv43";
    public static final String ZRNTAWSOSIKIKJ           = "zrntawsosikikj";
    public static final String ZRNTAWYNO                = "zrntawyno";
    public static final String ZRNTAWADR1KJ             = "zrntawadr1kj";
    public static final String ZRNTAWADR2KJ             = "zrntawadr2kj";
    public static final String ZRNTAWADR3KJ             = "zrntawadr3kj";
    public static final String ZRNTAWTELNO              = "zrntawtelno";
    public static final String ZRNTAWTELUKTKKANOU1      = "zrntawteluktkkanou1";
    public static final String ZRNTAWTELUKTKKANOU2      = "zrntawteluktkkanou2";
    public static final String ZRNDAI2TAWSOSIKINMKJ     = "zrndai2tawsosikinmkj";
    public static final String ZRNDAI2TAWTELNO          = "zrndai2tawtelno";
    public static final String ZRNSCLATOSYONO           = "zrnsclatosyono";
    public static final String ZRNSAKUNM                = "zrnsakunm";
    public static final String ZRNYOBIV66               = "zrnyobiv66";
    public static final String ZRNSYONO3                = "zrnsyono3";
    public static final String ZRNTETUDUKISYUNM         = "zrntetudukisyunm";
    public static final String ZRNKYKNMKJ               = "zrnkyknmkj";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNYOBIV59               = "zrnyobiv59";

    private final PKZT_TtdkKanAdHenkouRn primaryKey;

    public GenZT_TtdkKanAdHenkouRn() {
        primaryKey = new PKZT_TtdkKanAdHenkouRn();
    }

    public GenZT_TtdkKanAdHenkouRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsikibetuno
    ) {
        primaryKey = new PKZT_TtdkKanAdHenkouRn(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_TtdkKanAdHenkouRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TtdkKanAdHenkouRn> getMetaClass() {
        return QZT_TtdkKanAdHenkouRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    @Id
    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrnsyodouhuukbn;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSYODOUHUUKBN)
    public String getZrnsyodouhuukbn() {
        return zrnsyodouhuukbn;
    }

    public void setZrnsyodouhuukbn(String pZrnsyodouhuukbn) {
        zrnsyodouhuukbn = pZrnsyodouhuukbn;
    }

    private String zrnyobiv24;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNYOBIV24)
    public String getZrnyobiv24() {
        return zrnyobiv24;
    }

    public void setZrnyobiv24(String pZrnyobiv24) {
        zrnyobiv24 = pZrnyobiv24;
    }

    private String zrnsyoruicd2;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSYORUICD2)
    public String getZrnsyoruicd2() {
        return zrnsyoruicd2;
    }

    public void setZrnsyoruicd2(String pZrnsyoruicd2) {
        zrnsyoruicd2 = pZrnsyoruicd2;
    }

    private String zrntyouhyouymd2;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTYOUHYOUYMD2)
    public String getZrntyouhyouymd2() {
        return zrntyouhyouymd2;
    }

    public void setZrntyouhyouymd2(String pZrntyouhyouymd2) {
        zrntyouhyouymd2 = pZrntyouhyouymd2;
    }

    private String zrnsyono2;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnhassoukbn2;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNHASSOUKBN2)
    public String getZrnhassoukbn2() {
        return zrnhassoukbn2;
    }

    public void setZrnhassoukbn2(String pZrnhassoukbn2) {
        zrnhassoukbn2 = pZrnhassoukbn2;
    }

    private String zrnsyodouhuukbn2;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSYODOUHUUKBN2)
    public String getZrnsyodouhuukbn2() {
        return zrnsyodouhuukbn2;
    }

    public void setZrnsyodouhuukbn2(String pZrnsyodouhuukbn2) {
        zrnsyodouhuukbn2 = pZrnsyodouhuukbn2;
    }

    @Id
    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSIKIBETUNO)
    public String getZrnsikibetuno() {
        return getPrimaryKey().getZrnsikibetuno();
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        getPrimaryKey().setZrnsikibetuno(pZrnsikibetuno);
    }

    private String zrnyobiv44;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNYOBIV44)
    public String getZrnyobiv44() {
        return zrnyobiv44;
    }

    public void setZrnyobiv44(String pZrnyobiv44) {
        zrnyobiv44 = pZrnyobiv44;
    }

    private String zrnshskyno;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkjttdk;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSHSNMKJTTDK)
    public String getZrnshsnmkjttdk() {
        return zrnshsnmkjttdk;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkjttdk(String pZrnshsnmkjttdk) {
        zrnshsnmkjttdk = pZrnshsnmkjttdk;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelno;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTAWTELNO)
    public String getZrntawtelno() {
        return zrntawtelno;
    }

    public void setZrntawtelno(String pZrntawtelno) {
        zrntawtelno = pZrntawtelno;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnsakunm;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSAKUNM)
    public String getZrnsakunm() {
        return zrnsakunm;
    }

    public void setZrnsakunm(String pZrnsakunm) {
        zrnsakunm = pZrnsakunm;
    }

    private String zrnyobiv66;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNYOBIV66)
    public String getZrnyobiv66() {
        return zrnyobiv66;
    }

    public void setZrnyobiv66(String pZrnyobiv66) {
        zrnyobiv66 = pZrnyobiv66;
    }

    private String zrnsyono3;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNSYONO3)
    public String getZrnsyono3() {
        return zrnsyono3;
    }

    public void setZrnsyono3(String pZrnsyono3) {
        zrnsyono3 = pZrnsyono3;
    }

    private String zrntetudukisyunm;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNTETUDUKISYUNM)
    public String getZrntetudukisyunm() {
        return zrntetudukisyunm;
    }

    @DataConvert("toMultiByte")
    public void setZrntetudukisyunm(String pZrntetudukisyunm) {
        zrntetudukisyunm = pZrntetudukisyunm;
    }

    private String zrnkyknmkj;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNKYKNMKJ)
    public String getZrnkyknmkj() {
        return zrnkyknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj(String pZrnkyknmkj) {
        zrnkyknmkj = pZrnkyknmkj;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnyobiv59;

    @Column(name=GenZT_TtdkKanAdHenkouRn.ZRNYOBIV59)
    public String getZrnyobiv59() {
        return zrnyobiv59;
    }

    public void setZrnyobiv59(String pZrnyobiv59) {
        zrnyobiv59 = pZrnyobiv59;
    }
}