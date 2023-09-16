package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SeihoWebIdouListTy;
import yuyu.def.db.id.PKZT_SeihoWebIdouListTy;
import yuyu.def.db.meta.GenQZT_SeihoWebIdouListTy;
import yuyu.def.db.meta.QZT_SeihoWebIdouListTy;

/**
 * 生保Ｗｅｂ異動一覧抽出テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SeihoWebIdouListTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeihoWebIdouListTy}</td><td colspan="3">生保Ｗｅｂ異動一覧抽出テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysakuseiymd7keta ztysakuseiymd7keta}</td><td>（中継用）作成年月（７桁）</td><td align="center">{@link PKZT_SeihoWebIdouListTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">{@link PKZT_SeihoWebIdouListTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytntusycd ztytntusycd}</td><td>（中継用）担当者コード</td><td align="center">{@link PKZT_SeihoWebIdouListTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SeihoWebIdouListTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhasseiymd ztyhasseiymd}</td><td>（中継用）発生日</td><td align="center">{@link PKZT_SeihoWebIdouListTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidoukbn1 ztyidoukbn1}</td><td>（中継用）異動区分１</td><td align="center">{@link PKZT_SeihoWebIdouListTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkikbnkj ztykydatkikbnkj}</td><td>（中継用）共同扱区分（漢字）</td><td align="center">{@link PKZT_SeihoWebIdouListTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykyymm ztykykyymm}</td><td>（中継用）契約年月（西暦下２桁）</td><td align="center">{@link PKZT_SeihoWebIdouListTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">{@link PKZT_SeihoWebIdouListTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasikbn ztymidasikbn}</td><td>（中継用）見出し区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakinm ztyatesakinm}</td><td>（中継用）宛先名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassinka ztyhassinka}</td><td>（中継用）発信課</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyyymm ztybsyyymm}</td><td>（中継用）募集年月（西暦下２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytntusynm ztytntusynm}</td><td>（中継用）担当者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkjseihoweb ztykyknmkjseihoweb}</td><td>（中継用）契約者名（漢字）（生保ＷＥＢ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypjyuutouyymm ztypjyuutouyymm}</td><td>（中継用）保険料充当年月（西暦下２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukj ztyhrkkaisuukj}</td><td>（中継用）払込回数（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyp11keta ztyp11keta}</td><td>（中継用）保険料（１１桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirobtjhmidasi ztyhrkkeirobtjhmidasi}</td><td>（中継用）払込経路別情報見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirobtjh ztyhrkkeirobtjh}</td><td>（中継用）払込経路別情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytntusyjk ztytntusyjk}</td><td>（中継用）担当者状況</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokj ztyhrkkeirokj}</td><td>（中継用）払込経路（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruimei ztyhknsyuruimei}</td><td>（中継用）保険種類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidoukbn2 ztyidoukbn2}</td><td>（中継用）異動区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydbskyoteiymd7keta ztydbskyoteiymd7keta}</td><td>（中継用）ＤＢ削除予定年月（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakykhrkp ztygaikakykhrkp}</td><td>（中継用）外貨契約払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykyktuukasyukbn ztykyktuukasyukbn}</td><td>（中継用）契約通貨種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeihoWebIdouListTy
 * @see     PKZT_SeihoWebIdouListTy
 * @see     QZT_SeihoWebIdouListTy
 * @see     GenQZT_SeihoWebIdouListTy
 */
@MappedSuperclass
@Table(name=GenZT_SeihoWebIdouListTy.TABLE_NAME)
@IdClass(value=PKZT_SeihoWebIdouListTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SeihoWebIdouListTy extends AbstractExDBEntity<ZT_SeihoWebIdouListTy, PKZT_SeihoWebIdouListTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SeihoWebIdouListTy";
    public static final String ZTYSAKUSEIYMD7KETA       = "ztysakuseiymd7keta";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYTNTUSYCD              = "ztytntusycd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHASSEIYMD             = "ztyhasseiymd";
    public static final String ZTYIDOUKBN1              = "ztyidoukbn1";
    public static final String ZTYKYDATKIKBNKJ          = "ztykydatkikbnkj";
    public static final String ZTYKYKYYMM               = "ztykykyymm";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYMIDASIKBN             = "ztymidasikbn";
    public static final String ZTYATESAKINM             = "ztyatesakinm";
    public static final String ZTYHASSINKA              = "ztyhassinka";
    public static final String ZTYBSYYYMM               = "ztybsyyymm";
    public static final String ZTYTNTUSYNM              = "ztytntusynm";
    public static final String ZTYKYKNMKJSEIHOWEB       = "ztykyknmkjseihoweb";
    public static final String ZTYPJYUUTOUYYMM          = "ztypjyuutouyymm";
    public static final String ZTYHRKKAISUUKJ           = "ztyhrkkaisuukj";
    public static final String ZTYP11KETA               = "ztyp11keta";
    public static final String ZTYHRKKEIROBTJHMIDASI    = "ztyhrkkeirobtjhmidasi";
    public static final String ZTYHRKKEIROBTJH          = "ztyhrkkeirobtjh";
    public static final String ZTYTNTUSYJK              = "ztytntusyjk";
    public static final String ZTYHRKKEIROKJ            = "ztyhrkkeirokj";
    public static final String ZTYHKNSYURUIMEI          = "ztyhknsyuruimei";
    public static final String ZTYIDOUKBN2              = "ztyidoukbn2";
    public static final String ZTYDBSKYOTEIYMD7KETA     = "ztydbskyoteiymd7keta";
    public static final String ZTYGAIKAKYKHRKP          = "ztygaikakykhrkp";
    public static final String ZTYKYKTUUKASYUKBN        = "ztykyktuukasyukbn";

    private final PKZT_SeihoWebIdouListTy primaryKey;

    public GenZT_SeihoWebIdouListTy() {
        primaryKey = new PKZT_SeihoWebIdouListTy();
    }

    public GenZT_SeihoWebIdouListTy(
        String pZtysakuseiymd7keta,
        String pZtybsydrtencd,
        String pZtytntusycd,
        String pZtysyono,
        String pZtyhasseiymd,
        String pZtyidoukbn1,
        String pZtykydatkikbnkj,
        String pZtykykyymm,
        String pZtycifcd
    ) {
        primaryKey = new PKZT_SeihoWebIdouListTy(
            pZtysakuseiymd7keta,
            pZtybsydrtencd,
            pZtytntusycd,
            pZtysyono,
            pZtyhasseiymd,
            pZtyidoukbn1,
            pZtykydatkikbnkj,
            pZtykykyymm,
            pZtycifcd
        );
    }

    @Transient
    @Override
    public PKZT_SeihoWebIdouListTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SeihoWebIdouListTy> getMetaClass() {
        return QZT_SeihoWebIdouListTy.class;
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListTy.ZTYSAKUSEIYMD7KETA)
    public String getZtysakuseiymd7keta() {
        return getPrimaryKey().getZtysakuseiymd7keta();
    }

    public void setZtysakuseiymd7keta(String pZtysakuseiymd7keta) {
        getPrimaryKey().setZtysakuseiymd7keta(pZtysakuseiymd7keta);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return getPrimaryKey().getZtybsydrtencd();
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        getPrimaryKey().setZtybsydrtencd(pZtybsydrtencd);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListTy.ZTYTNTUSYCD)
    public String getZtytntusycd() {
        return getPrimaryKey().getZtytntusycd();
    }

    public void setZtytntusycd(String pZtytntusycd) {
        getPrimaryKey().setZtytntusycd(pZtytntusycd);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListTy.ZTYHASSEIYMD)
    public String getZtyhasseiymd() {
        return getPrimaryKey().getZtyhasseiymd();
    }

    public void setZtyhasseiymd(String pZtyhasseiymd) {
        getPrimaryKey().setZtyhasseiymd(pZtyhasseiymd);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListTy.ZTYIDOUKBN1)
    public String getZtyidoukbn1() {
        return getPrimaryKey().getZtyidoukbn1();
    }

    public void setZtyidoukbn1(String pZtyidoukbn1) {
        getPrimaryKey().setZtyidoukbn1(pZtyidoukbn1);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListTy.ZTYKYDATKIKBNKJ)
    public String getZtykydatkikbnkj() {
        return getPrimaryKey().getZtykydatkikbnkj();
    }

    public void setZtykydatkikbnkj(String pZtykydatkikbnkj) {
        getPrimaryKey().setZtykydatkikbnkj(pZtykydatkikbnkj);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListTy.ZTYKYKYYMM)
    public String getZtykykyymm() {
        return getPrimaryKey().getZtykykyymm();
    }

    public void setZtykykyymm(String pZtykykyymm) {
        getPrimaryKey().setZtykykyymm(pZtykykyymm);
    }

    @Id
    @Column(name=GenZT_SeihoWebIdouListTy.ZTYCIFCD)
    public String getZtycifcd() {
        return getPrimaryKey().getZtycifcd();
    }

    public void setZtycifcd(String pZtycifcd) {
        getPrimaryKey().setZtycifcd(pZtycifcd);
    }

    private String ztymidasikbn;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYMIDASIKBN)
    public String getZtymidasikbn() {
        return ztymidasikbn;
    }

    public void setZtymidasikbn(String pZtymidasikbn) {
        ztymidasikbn = pZtymidasikbn;
    }

    private String ztyatesakinm;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYATESAKINM)
    public String getZtyatesakinm() {
        return ztyatesakinm;
    }

    public void setZtyatesakinm(String pZtyatesakinm) {
        ztyatesakinm = pZtyatesakinm;
    }

    private String ztyhassinka;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYHASSINKA)
    public String getZtyhassinka() {
        return ztyhassinka;
    }

    public void setZtyhassinka(String pZtyhassinka) {
        ztyhassinka = pZtyhassinka;
    }

    private String ztybsyyymm;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYBSYYYMM)
    public String getZtybsyyymm() {
        return ztybsyyymm;
    }

    public void setZtybsyyymm(String pZtybsyyymm) {
        ztybsyyymm = pZtybsyyymm;
    }

    private String ztytntusynm;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYTNTUSYNM)
    public String getZtytntusynm() {
        return ztytntusynm;
    }

    public void setZtytntusynm(String pZtytntusynm) {
        ztytntusynm = pZtytntusynm;
    }

    private String ztykyknmkjseihoweb;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYKYKNMKJSEIHOWEB)
    public String getZtykyknmkjseihoweb() {
        return ztykyknmkjseihoweb;
    }

    public void setZtykyknmkjseihoweb(String pZtykyknmkjseihoweb) {
        ztykyknmkjseihoweb = pZtykyknmkjseihoweb;
    }

    private String ztypjyuutouyymm;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYPJYUUTOUYYMM)
    public String getZtypjyuutouyymm() {
        return ztypjyuutouyymm;
    }

    public void setZtypjyuutouyymm(String pZtypjyuutouyymm) {
        ztypjyuutouyymm = pZtypjyuutouyymm;
    }

    private String ztyhrkkaisuukj;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYHRKKAISUUKJ)
    public String getZtyhrkkaisuukj() {
        return ztyhrkkaisuukj;
    }

    public void setZtyhrkkaisuukj(String pZtyhrkkaisuukj) {
        ztyhrkkaisuukj = pZtyhrkkaisuukj;
    }

    private Long ztyp11keta;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYP11KETA)
    public Long getZtyp11keta() {
        return ztyp11keta;
    }

    public void setZtyp11keta(Long pZtyp11keta) {
        ztyp11keta = pZtyp11keta;
    }

    private String ztyhrkkeirobtjhmidasi;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYHRKKEIROBTJHMIDASI)
    public String getZtyhrkkeirobtjhmidasi() {
        return ztyhrkkeirobtjhmidasi;
    }

    public void setZtyhrkkeirobtjhmidasi(String pZtyhrkkeirobtjhmidasi) {
        ztyhrkkeirobtjhmidasi = pZtyhrkkeirobtjhmidasi;
    }

    private String ztyhrkkeirobtjh;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYHRKKEIROBTJH)
    public String getZtyhrkkeirobtjh() {
        return ztyhrkkeirobtjh;
    }

    public void setZtyhrkkeirobtjh(String pZtyhrkkeirobtjh) {
        ztyhrkkeirobtjh = pZtyhrkkeirobtjh;
    }

    private String ztytntusyjk;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYTNTUSYJK)
    public String getZtytntusyjk() {
        return ztytntusyjk;
    }

    public void setZtytntusyjk(String pZtytntusyjk) {
        ztytntusyjk = pZtytntusyjk;
    }

    private String ztyhrkkeirokj;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYHRKKEIROKJ)
    public String getZtyhrkkeirokj() {
        return ztyhrkkeirokj;
    }

    public void setZtyhrkkeirokj(String pZtyhrkkeirokj) {
        ztyhrkkeirokj = pZtyhrkkeirokj;
    }

    private String ztyhknsyuruimei;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYHKNSYURUIMEI)
    public String getZtyhknsyuruimei() {
        return ztyhknsyuruimei;
    }

    public void setZtyhknsyuruimei(String pZtyhknsyuruimei) {
        ztyhknsyuruimei = pZtyhknsyuruimei;
    }

    private String ztyidoukbn2;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYIDOUKBN2)
    public String getZtyidoukbn2() {
        return ztyidoukbn2;
    }

    public void setZtyidoukbn2(String pZtyidoukbn2) {
        ztyidoukbn2 = pZtyidoukbn2;
    }

    private String ztydbskyoteiymd7keta;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYDBSKYOTEIYMD7KETA)
    public String getZtydbskyoteiymd7keta() {
        return ztydbskyoteiymd7keta;
    }

    public void setZtydbskyoteiymd7keta(String pZtydbskyoteiymd7keta) {
        ztydbskyoteiymd7keta = pZtydbskyoteiymd7keta;
    }

    private BizNumber ztygaikakykhrkp;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeihoWebIdouListTy.ZTYGAIKAKYKHRKP)
    public BizNumber getZtygaikakykhrkp() {
        return ztygaikakykhrkp;
    }

    public void setZtygaikakykhrkp(BizNumber pZtygaikakykhrkp) {
        ztygaikakykhrkp = pZtygaikakykhrkp;
    }

    private String ztykyktuukasyukbn;

    @Column(name=GenZT_SeihoWebIdouListTy.ZTYKYKTUUKASYUKBN)
    public String getZtykyktuukasyukbn() {
        return ztykyktuukasyukbn;
    }

    public void setZtykyktuukasyukbn(String pZtykyktuukasyukbn) {
        ztykyktuukasyukbn = pZtykyktuukasyukbn;
    }
}