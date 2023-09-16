package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingTy;
import yuyu.def.db.id.PKZT_DshrToukeiLoadingTy;
import yuyu.def.db.meta.GenQZT_DshrToukeiLoadingTy;
import yuyu.def.db.meta.QZT_DshrToukeiLoadingTy;

/**
 * Ｄ支払統計ローディングＦテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DshrToukeiLoadingTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DshrToukeiLoadingTy}</td><td colspan="3">Ｄ支払統計ローディングＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_DshrToukeiLoadingTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydshrym ztydshrym}</td><td>（中継用）Ｄ支払年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaikigetu ztyannaikigetu}</td><td>（中継用）案内期月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyruikbn ztyhknsyruikbn}</td><td>（中継用）保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysegcd ztysegcd}</td><td>（中継用）セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrriyuukbn ztyshrriyuukbn}</td><td>（中継用）支払理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaikbn ztyannaikbn}</td><td>（中継用）案内区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduketorihouhoukbn ztyduketorihouhoukbn}</td><td>（中継用）Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumetukbn ztysyoumetukbn}</td><td>（中継用）消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikinhyj ztybikinhyj}</td><td>（中継用）備金表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskskbn ztyskskbn}</td><td>（中継用）作成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrkensuu ztysrkensuu}</td><td>（中継用）数理用件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysrhsys ztysrhsys}</td><td>（中継用）数理用保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoujigyounendod ztytoujigyounendod}</td><td>（中継用）当事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoujigyounendohasseidrsk ztytoujigyounendohasseidrsk}</td><td>（中継用）当事業年度発生Ｄ利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzenjigyounendomatudzndk ztyzenjigyounendomatudzndk}</td><td>（中継用）前事業年度末Ｄ残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyokujigyounendod ztyyokujigyounendod}</td><td>（中継用）翌事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhushrtoujigyounendod ztyhushrtoujigyounendod}</td><td>（中継用）不支払当事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_DshrToukeiLoadingTy
 * @see     PKZT_DshrToukeiLoadingTy
 * @see     QZT_DshrToukeiLoadingTy
 * @see     GenQZT_DshrToukeiLoadingTy
 */
@MappedSuperclass
@Table(name=GenZT_DshrToukeiLoadingTy.TABLE_NAME)
@IdClass(value=PKZT_DshrToukeiLoadingTy.class)
public abstract class GenZT_DshrToukeiLoadingTy extends AbstractExDBEntity<ZT_DshrToukeiLoadingTy, PKZT_DshrToukeiLoadingTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DshrToukeiLoadingTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYDSHRYM                = "ztydshrym";
    public static final String ZTYKEIYAKUNENDO          = "ztykeiyakunendo";
    public static final String ZTYANNAIKIGETU           = "ztyannaikigetu";
    public static final String ZTYHKNSYRUIKBN           = "ztyhknsyruikbn";
    public static final String ZTYSEGCD                 = "ztysegcd";
    public static final String ZTYSHRRIYUUKBN           = "ztyshrriyuukbn";
    public static final String ZTYANNAIKBN              = "ztyannaikbn";
    public static final String ZTYDUKETORIHOUHOUKBN     = "ztyduketorihouhoukbn";
    public static final String ZTYSYOUMETUKBN           = "ztysyoumetukbn";
    public static final String ZTYBIKINHYJ              = "ztybikinhyj";
    public static final String ZTYSKSKBN                = "ztyskskbn";
    public static final String ZTYSRKENSUU              = "ztysrkensuu";
    public static final String ZTYSRHSYS                = "ztysrhsys";
    public static final String ZTYTOUJIGYOUNENDOD       = "ztytoujigyounendod";
    public static final String ZTYTOUJIGYOUNENDOHASSEIDRSK = "ztytoujigyounendohasseidrsk";
    public static final String ZTYZENJIGYOUNENDOMATUDZNDK = "ztyzenjigyounendomatudzndk";
    public static final String ZTYYOKUJIGYOUNENDOD      = "ztyyokujigyounendod";
    public static final String ZTYHUSHRTOUJIGYOUNENDOD  = "ztyhushrtoujigyounendod";

    private final PKZT_DshrToukeiLoadingTy primaryKey;

    public GenZT_DshrToukeiLoadingTy() {
        primaryKey = new PKZT_DshrToukeiLoadingTy();
    }

    public GenZT_DshrToukeiLoadingTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_DshrToukeiLoadingTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_DshrToukeiLoadingTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DshrToukeiLoadingTy> getMetaClass() {
        return QZT_DshrToukeiLoadingTy.class;
    }

    @Id
    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztydshrym;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYDSHRYM)
    public String getZtydshrym() {
        return ztydshrym;
    }

    public void setZtydshrym(String pZtydshrym) {
        ztydshrym = pZtydshrym;
    }

    private String ztykeiyakunendo;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }

    private String ztyannaikigetu;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYANNAIKIGETU)
    public String getZtyannaikigetu() {
        return ztyannaikigetu;
    }

    public void setZtyannaikigetu(String pZtyannaikigetu) {
        ztyannaikigetu = pZtyannaikigetu;
    }

    private String ztyhknsyruikbn;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYHKNSYRUIKBN)
    public String getZtyhknsyruikbn() {
        return ztyhknsyruikbn;
    }

    public void setZtyhknsyruikbn(String pZtyhknsyruikbn) {
        ztyhknsyruikbn = pZtyhknsyruikbn;
    }

    private String ztysegcd;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYSEGCD)
    public String getZtysegcd() {
        return ztysegcd;
    }

    public void setZtysegcd(String pZtysegcd) {
        ztysegcd = pZtysegcd;
    }

    private String ztyshrriyuukbn;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYSHRRIYUUKBN)
    public String getZtyshrriyuukbn() {
        return ztyshrriyuukbn;
    }

    public void setZtyshrriyuukbn(String pZtyshrriyuukbn) {
        ztyshrriyuukbn = pZtyshrriyuukbn;
    }

    private String ztyannaikbn;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYANNAIKBN)
    public String getZtyannaikbn() {
        return ztyannaikbn;
    }

    public void setZtyannaikbn(String pZtyannaikbn) {
        ztyannaikbn = pZtyannaikbn;
    }

    private String ztyduketorihouhoukbn;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYDUKETORIHOUHOUKBN)
    public String getZtyduketorihouhoukbn() {
        return ztyduketorihouhoukbn;
    }

    public void setZtyduketorihouhoukbn(String pZtyduketorihouhoukbn) {
        ztyduketorihouhoukbn = pZtyduketorihouhoukbn;
    }

    private String ztysyoumetukbn;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYSYOUMETUKBN)
    public String getZtysyoumetukbn() {
        return ztysyoumetukbn;
    }

    public void setZtysyoumetukbn(String pZtysyoumetukbn) {
        ztysyoumetukbn = pZtysyoumetukbn;
    }

    private String ztybikinhyj;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYBIKINHYJ)
    public String getZtybikinhyj() {
        return ztybikinhyj;
    }

    public void setZtybikinhyj(String pZtybikinhyj) {
        ztybikinhyj = pZtybikinhyj;
    }

    private String ztyskskbn;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYSKSKBN)
    public String getZtyskskbn() {
        return ztyskskbn;
    }

    public void setZtyskskbn(String pZtyskskbn) {
        ztyskskbn = pZtyskskbn;
    }

    private Integer ztysrkensuu;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYSRKENSUU)
    public Integer getZtysrkensuu() {
        return ztysrkensuu;
    }

    public void setZtysrkensuu(Integer pZtysrkensuu) {
        ztysrkensuu = pZtysrkensuu;
    }

    private Long ztysrhsys;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYSRHSYS)
    public Long getZtysrhsys() {
        return ztysrhsys;
    }

    public void setZtysrhsys(Long pZtysrhsys) {
        ztysrhsys = pZtysrhsys;
    }

    private Long ztytoujigyounendod;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYTOUJIGYOUNENDOD)
    public Long getZtytoujigyounendod() {
        return ztytoujigyounendod;
    }

    public void setZtytoujigyounendod(Long pZtytoujigyounendod) {
        ztytoujigyounendod = pZtytoujigyounendod;
    }

    private Long ztytoujigyounendohasseidrsk;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYTOUJIGYOUNENDOHASSEIDRSK)
    public Long getZtytoujigyounendohasseidrsk() {
        return ztytoujigyounendohasseidrsk;
    }

    public void setZtytoujigyounendohasseidrsk(Long pZtytoujigyounendohasseidrsk) {
        ztytoujigyounendohasseidrsk = pZtytoujigyounendohasseidrsk;
    }

    private Long ztyzenjigyounendomatudzndk;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYZENJIGYOUNENDOMATUDZNDK)
    public Long getZtyzenjigyounendomatudzndk() {
        return ztyzenjigyounendomatudzndk;
    }

    public void setZtyzenjigyounendomatudzndk(Long pZtyzenjigyounendomatudzndk) {
        ztyzenjigyounendomatudzndk = pZtyzenjigyounendomatudzndk;
    }

    private Long ztyyokujigyounendod;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYYOKUJIGYOUNENDOD)
    public Long getZtyyokujigyounendod() {
        return ztyyokujigyounendod;
    }

    public void setZtyyokujigyounendod(Long pZtyyokujigyounendod) {
        ztyyokujigyounendod = pZtyyokujigyounendod;
    }

    private Long ztyhushrtoujigyounendod;

    @Column(name=GenZT_DshrToukeiLoadingTy.ZTYHUSHRTOUJIGYOUNENDOD)
    public Long getZtyhushrtoujigyounendod() {
        return ztyhushrtoujigyounendod;
    }

    public void setZtyhushrtoujigyounendod(Long pZtyhushrtoujigyounendod) {
        ztyhushrtoujigyounendod = pZtyhushrtoujigyounendod;
    }
}