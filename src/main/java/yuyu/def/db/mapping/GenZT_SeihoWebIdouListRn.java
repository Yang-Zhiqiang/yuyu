package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SeihoWebIdouListRn;
import yuyu.def.db.id.PKZT_SeihoWebIdouListRn;
import yuyu.def.db.meta.GenQZT_SeihoWebIdouListRn;
import yuyu.def.db.meta.QZT_SeihoWebIdouListRn;

/**
 * 生保Ｗｅｂ異動一覧抽出テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SeihoWebIdouListRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeihoWebIdouListRn}</td><td colspan="3">生保Ｗｅｂ異動一覧抽出テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsakuseiymd7keta zrnsakuseiymd7keta}</td><td>（連携用）作成年月（７桁）</td><td align="center">{@link PKZT_SeihoWebIdouListRn ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">{@link PKZT_SeihoWebIdouListRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntntusycd zrntntusycd}</td><td>（連携用）担当者コード</td><td align="center">{@link PKZT_SeihoWebIdouListRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SeihoWebIdouListRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhasseiymd zrnhasseiymd}</td><td>（連携用）発生日</td><td align="center">{@link PKZT_SeihoWebIdouListRn ○}</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidoukbn1 zrnidoukbn1}</td><td>（連携用）異動区分１</td><td align="center">{@link PKZT_SeihoWebIdouListRn ○}</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkikbnkj zrnkydatkikbnkj}</td><td>（連携用）共同扱区分（漢字）</td><td align="center">{@link PKZT_SeihoWebIdouListRn ○}</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykyymm zrnkykyymm}</td><td>（連携用）契約年月（西暦下２桁）</td><td align="center">{@link PKZT_SeihoWebIdouListRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">{@link PKZT_SeihoWebIdouListRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasikbn zrnmidasikbn}</td><td>（連携用）見出し区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakinm zrnatesakinm}</td><td>（連携用）宛先名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassinka zrnhassinka}</td><td>（連携用）発信課</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyyymm zrnbsyyymm}</td><td>（連携用）募集年月（西暦下２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntntusynm zrntntusynm}</td><td>（連携用）担当者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkjseihoweb zrnkyknmkjseihoweb}</td><td>（連携用）契約者名（漢字）（生保ＷＥＢ）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpjyuutouyymm zrnpjyuutouyymm}</td><td>（連携用）保険料充当年月（西暦下２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukj zrnhrkkaisuukj}</td><td>（連携用）払込回数（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnp11keta zrnp11keta}</td><td>（連携用）保険料（１１桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirobtjhmidasi zrnhrkkeirobtjhmidasi}</td><td>（連携用）払込経路別情報見出し</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirobtjh zrnhrkkeirobtjh}</td><td>（連携用）払込経路別情報</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntntusyjk zrntntusyjk}</td><td>（連携用）担当者状況</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokj zrnhrkkeirokj}</td><td>（連携用）払込経路（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruimei zrnhknsyuruimei}</td><td>（連携用）保険種類名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidoukbn2 zrnidoukbn2}</td><td>（連携用）異動区分２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndbskyoteiymd7keta zrndbskyoteiymd7keta}</td><td>（連携用）ＤＢ削除予定年月（７桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikakykhrkp zrngaikakykhrkp}</td><td>（連携用）外貨契約払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkyktuukasyukbn zrnkyktuukasyukbn}</td><td>（連携用）契約通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeihoWebIdouListRn
 * @see     PKZT_SeihoWebIdouListRn
 * @see     QZT_SeihoWebIdouListRn
 * @see     GenQZT_SeihoWebIdouListRn
 */
@MappedSuperclass
@Table(name=GenZT_SeihoWebIdouListRn.TABLE_NAME)
@IdClass(value=PKZT_SeihoWebIdouListRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SeihoWebIdouListRn extends AbstractExDBEntityForZDB<ZT_SeihoWebIdouListRn, PKZT_SeihoWebIdouListRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SeihoWebIdouListRn";
    public static final String ZRNSAKUSEIYMD7KETA       = "zrnsakuseiymd7keta";
    public static final String ZRNBSYDRTENCD            = "zrnbsydrtencd";
    public static final String ZRNTNTUSYCD              = "zrntntusycd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHASSEIYMD             = "zrnhasseiymd";
    public static final String ZRNIDOUKBN1              = "zrnidoukbn1";
    public static final String ZRNKYDATKIKBNKJ          = "zrnkydatkikbnkj";
    public static final String ZRNKYKYYMM               = "zrnkykyymm";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNMIDASIKBN             = "zrnmidasikbn";
    public static final String ZRNATESAKINM             = "zrnatesakinm";
    public static final String ZRNHASSINKA              = "zrnhassinka";
    public static final String ZRNBSYYYMM               = "zrnbsyyymm";
    public static final String ZRNTNTUSYNM              = "zrntntusynm";
    public static final String ZRNKYKNMKJSEIHOWEB       = "zrnkyknmkjseihoweb";
    public static final String ZRNPJYUUTOUYYMM          = "zrnpjyuutouyymm";
    public static final String ZRNHRKKAISUUKJ           = "zrnhrkkaisuukj";
    public static final String ZRNP11KETA               = "zrnp11keta";
    public static final String ZRNHRKKEIROBTJHMIDASI    = "zrnhrkkeirobtjhmidasi";
    public static final String ZRNHRKKEIROBTJH          = "zrnhrkkeirobtjh";
    public static final String ZRNTNTUSYJK              = "zrntntusyjk";
    public static final String ZRNHRKKEIROKJ            = "zrnhrkkeirokj";
    public static final String ZRNHKNSYURUIMEI          = "zrnhknsyuruimei";
    public static final String ZRNIDOUKBN2              = "zrnidoukbn2";
    public static final String ZRNDBSKYOTEIYMD7KETA     = "zrndbskyoteiymd7keta";
    public static final String ZRNGAIKAKYKHRKP          = "zrngaikakykhrkp";
    public static final String ZRNKYKTUUKASYUKBN        = "zrnkyktuukasyukbn";

    private final PKZT_SeihoWebIdouListRn primaryKey;

    public GenZT_SeihoWebIdouListRn() {
        primaryKey = new PKZT_SeihoWebIdouListRn();
    }

    public GenZT_SeihoWebIdouListRn(
        Long pZrnsakuseiymd7keta,
        String pZrnbsydrtencd,
        String pZrntntusycd,
        String pZrnsyono,
        String pZrnhasseiymd,
        String pZrnidoukbn1,
        String pZrnkydatkikbnkj,
        String pZrnkykyymm,
        String pZrncifcd
    ) {
        primaryKey = new PKZT_SeihoWebIdouListRn(
            pZrnsakuseiymd7keta,
            pZrnbsydrtencd,
            pZrntntusycd,
            pZrnsyono,
            pZrnhasseiymd,
            pZrnidoukbn1,
            pZrnkydatkikbnkj,
            pZrnkykyymm,
            pZrncifcd
        );
    }

    @Transient
    @Override
    public PKZT_SeihoWebIdouListRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SeihoWebIdouListRn> getMetaClass() {
        return QZT_SeihoWebIdouListRn.class;
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListRn.ZRNSAKUSEIYMD7KETA)
    public Long getZrnsakuseiymd7keta() {
        return getPrimaryKey().getZrnsakuseiymd7keta();
    }

    public void setZrnsakuseiymd7keta(Long pZrnsakuseiymd7keta) {
        getPrimaryKey().setZrnsakuseiymd7keta(pZrnsakuseiymd7keta);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListRn.ZRNBSYDRTENCD)
    public String getZrnbsydrtencd() {
        return getPrimaryKey().getZrnbsydrtencd();
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        getPrimaryKey().setZrnbsydrtencd(pZrnbsydrtencd);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListRn.ZRNTNTUSYCD)
    public String getZrntntusycd() {
        return getPrimaryKey().getZrntntusycd();
    }

    public void setZrntntusycd(String pZrntntusycd) {
        getPrimaryKey().setZrntntusycd(pZrntntusycd);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListRn.ZRNHASSEIYMD)
    public String getZrnhasseiymd() {
        return getPrimaryKey().getZrnhasseiymd();
    }

    @DataConvert("toMultiByte")
    public void setZrnhasseiymd(String pZrnhasseiymd) {
        getPrimaryKey().setZrnhasseiymd(pZrnhasseiymd);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListRn.ZRNIDOUKBN1)
    public String getZrnidoukbn1() {
        return getPrimaryKey().getZrnidoukbn1();
    }

    @DataConvert("toMultiByte")
    public void setZrnidoukbn1(String pZrnidoukbn1) {
        getPrimaryKey().setZrnidoukbn1(pZrnidoukbn1);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListRn.ZRNKYDATKIKBNKJ)
    public String getZrnkydatkikbnkj() {
        return getPrimaryKey().getZrnkydatkikbnkj();
    }

    @DataConvert("toMultiByte")
    public void setZrnkydatkikbnkj(String pZrnkydatkikbnkj) {
        getPrimaryKey().setZrnkydatkikbnkj(pZrnkydatkikbnkj);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListRn.ZRNKYKYYMM)
    public String getZrnkykyymm() {
        return getPrimaryKey().getZrnkykyymm();
    }

    public void setZrnkykyymm(String pZrnkykyymm) {
        getPrimaryKey().setZrnkykyymm(pZrnkykyymm);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListRn.ZRNCIFCD)
    public String getZrncifcd() {
        return getPrimaryKey().getZrncifcd();
    }

    public void setZrncifcd(String pZrncifcd) {
        getPrimaryKey().setZrncifcd(pZrncifcd);
    }

    private String zrnmidasikbn;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNMIDASIKBN)
    public String getZrnmidasikbn() {
        return zrnmidasikbn;
    }

    public void setZrnmidasikbn(String pZrnmidasikbn) {
        zrnmidasikbn = pZrnmidasikbn;
    }

    private String zrnatesakinm;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNATESAKINM)
    public String getZrnatesakinm() {
        return zrnatesakinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakinm(String pZrnatesakinm) {
        zrnatesakinm = pZrnatesakinm;
    }

    private String zrnhassinka;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNHASSINKA)
    public String getZrnhassinka() {
        return zrnhassinka;
    }

    @DataConvert("toMultiByte")
    public void setZrnhassinka(String pZrnhassinka) {
        zrnhassinka = pZrnhassinka;
    }

    private String zrnbsyyymm;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNBSYYYMM)
    public String getZrnbsyyymm() {
        return zrnbsyyymm;
    }

    public void setZrnbsyyymm(String pZrnbsyyymm) {
        zrnbsyyymm = pZrnbsyyymm;
    }

    private String zrntntusynm;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNTNTUSYNM)
    public String getZrntntusynm() {
        return zrntntusynm;
    }

    @DataConvert("toMultiByte")
    public void setZrntntusynm(String pZrntntusynm) {
        zrntntusynm = pZrntntusynm;
    }

    private String zrnkyknmkjseihoweb;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNKYKNMKJSEIHOWEB)
    public String getZrnkyknmkjseihoweb() {
        return zrnkyknmkjseihoweb;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkjseihoweb(String pZrnkyknmkjseihoweb) {
        zrnkyknmkjseihoweb = pZrnkyknmkjseihoweb;
    }

    private String zrnpjyuutouyymm;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNPJYUUTOUYYMM)
    public String getZrnpjyuutouyymm() {
        return zrnpjyuutouyymm;
    }

    public void setZrnpjyuutouyymm(String pZrnpjyuutouyymm) {
        zrnpjyuutouyymm = pZrnpjyuutouyymm;
    }

    private String zrnhrkkaisuukj;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNHRKKAISUUKJ)
    public String getZrnhrkkaisuukj() {
        return zrnhrkkaisuukj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkkaisuukj(String pZrnhrkkaisuukj) {
        zrnhrkkaisuukj = pZrnhrkkaisuukj;
    }

    private Long zrnp11keta;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNP11KETA)
    public Long getZrnp11keta() {
        return zrnp11keta;
    }

    public void setZrnp11keta(Long pZrnp11keta) {
        zrnp11keta = pZrnp11keta;
    }

    private String zrnhrkkeirobtjhmidasi;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNHRKKEIROBTJHMIDASI)
    public String getZrnhrkkeirobtjhmidasi() {
        return zrnhrkkeirobtjhmidasi;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkkeirobtjhmidasi(String pZrnhrkkeirobtjhmidasi) {
        zrnhrkkeirobtjhmidasi = pZrnhrkkeirobtjhmidasi;
    }

    private String zrnhrkkeirobtjh;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNHRKKEIROBTJH)
    public String getZrnhrkkeirobtjh() {
        return zrnhrkkeirobtjh;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkkeirobtjh(String pZrnhrkkeirobtjh) {
        zrnhrkkeirobtjh = pZrnhrkkeirobtjh;
    }

    private String zrntntusyjk;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNTNTUSYJK)
    public String getZrntntusyjk() {
        return zrntntusyjk;
    }

    @DataConvert("toMultiByte")
    public void setZrntntusyjk(String pZrntntusyjk) {
        zrntntusyjk = pZrntntusyjk;
    }

    private String zrnhrkkeirokj;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNHRKKEIROKJ)
    public String getZrnhrkkeirokj() {
        return zrnhrkkeirokj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkkeirokj(String pZrnhrkkeirokj) {
        zrnhrkkeirokj = pZrnhrkkeirokj;
    }

    private String zrnhknsyuruimei;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNHKNSYURUIMEI)
    public String getZrnhknsyuruimei() {
        return zrnhknsyuruimei;
    }

    @DataConvert("toMultiByte")
    public void setZrnhknsyuruimei(String pZrnhknsyuruimei) {
        zrnhknsyuruimei = pZrnhknsyuruimei;
    }

    private String zrnidoukbn2;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNIDOUKBN2)
    public String getZrnidoukbn2() {
        return zrnidoukbn2;
    }

    @DataConvert("toMultiByte")
    public void setZrnidoukbn2(String pZrnidoukbn2) {
        zrnidoukbn2 = pZrnidoukbn2;
    }

    private Long zrndbskyoteiymd7keta;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNDBSKYOTEIYMD7KETA)
    public Long getZrndbskyoteiymd7keta() {
        return zrndbskyoteiymd7keta;
    }

    public void setZrndbskyoteiymd7keta(Long pZrndbskyoteiymd7keta) {
        zrndbskyoteiymd7keta = pZrndbskyoteiymd7keta;
    }

    private BizNumber zrngaikakykhrkp;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeihoWebIdouListRn.ZRNGAIKAKYKHRKP)
    public BizNumber getZrngaikakykhrkp() {
        return zrngaikakykhrkp;
    }

    public void setZrngaikakykhrkp(BizNumber pZrngaikakykhrkp) {
        zrngaikakykhrkp = pZrngaikakykhrkp;
    }

    private String zrnkyktuukasyukbn;

    @Column(name=GenZT_SeihoWebIdouListRn.ZRNKYKTUUKASYUKBN)
    public String getZrnkyktuukasyukbn() {
        return zrnkyktuukasyukbn;
    }

    public void setZrnkyktuukasyukbn(String pZrnkyktuukasyukbn) {
        zrnkyktuukasyukbn = pZrnkyktuukasyukbn;
    }
}