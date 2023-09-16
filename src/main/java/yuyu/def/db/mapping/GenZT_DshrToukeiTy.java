package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_DshrToukeiTy;
import yuyu.def.db.id.PKZT_DshrToukeiTy;
import yuyu.def.db.meta.GenQZT_DshrToukeiTy;
import yuyu.def.db.meta.QZT_DshrToukeiTy;

/**
 * Ｄ支払統計Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DshrToukeiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DshrToukeiTy}</td><td colspan="3">Ｄ支払統計Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_DshrToukeiTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisskbn ztymisskbn}</td><td>（中継用）ミス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydshrym ztydshrym}</td><td>（中継用）Ｄ支払年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrsyoumetucd ztysrsyoumetucd}</td><td>（中継用）数理用消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaikigetu ztyannaikigetu}</td><td>（中継用）案内期月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrriyuukbn ztyshrriyuukbn}</td><td>（中継用）支払理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaikbn ztyannaikbn}</td><td>（中継用）案内区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduketorihouhoukbn ztyduketorihouhoukbn}</td><td>（中継用）Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikinhyj ztybikinhyj}</td><td>（中継用）備金表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskskbn ztyskskbn}</td><td>（中継用）作成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysegcd ztysegcd}</td><td>（中継用）セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrkensuu ztysrkensuu}</td><td>（中継用）数理用件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysrhsys ztysrhsys}</td><td>（中継用）数理用保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoujigyounendod ztytoujigyounendod}</td><td>（中継用）当事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoujigyounendohasseidrsk ztytoujigyounendohasseidrsk}</td><td>（中継用）当事業年度発生Ｄ利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzenjigyounendomatudzndk ztyzenjigyounendomatudzndk}</td><td>（中継用）前事業年度末Ｄ残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyokujigyounendod ztyyokujigyounendod}</td><td>（中継用）翌事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhushrtoujigyounendod ztyhushrtoujigyounendod}</td><td>（中継用）不支払当事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusyuruicdv2 ztysyukeiyakusyuruicdv2}</td><td>（中継用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaihyouyoteiriritu ztydaihyouyoteiriritu}</td><td>（中継用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbn ztyharaikatakbn}</td><td>（中継用）払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DshrToukeiTy
 * @see     PKZT_DshrToukeiTy
 * @see     QZT_DshrToukeiTy
 * @see     GenQZT_DshrToukeiTy
 */
@MappedSuperclass
@Table(name=GenZT_DshrToukeiTy.TABLE_NAME)
@IdClass(value=PKZT_DshrToukeiTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_DshrToukeiTy extends AbstractExDBEntity<ZT_DshrToukeiTy, PKZT_DshrToukeiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DshrToukeiTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYMISSKBN               = "ztymisskbn";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYDSHRYM                = "ztydshrym";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYSRSYOUMETUCD          = "ztysrsyoumetucd";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYKEIYAKUNENDO          = "ztykeiyakunendo";
    public static final String ZTYANNAIKIGETU           = "ztyannaikigetu";
    public static final String ZTYSHRRIYUUKBN           = "ztyshrriyuukbn";
    public static final String ZTYANNAIKBN              = "ztyannaikbn";
    public static final String ZTYDUKETORIHOUHOUKBN     = "ztyduketorihouhoukbn";
    public static final String ZTYBIKINHYJ              = "ztybikinhyj";
    public static final String ZTYSKSKBN                = "ztyskskbn";
    public static final String ZTYSEGCD                 = "ztysegcd";
    public static final String ZTYYOBIV3                = "ztyyobiv3";
    public static final String ZTYSRKENSUU              = "ztysrkensuu";
    public static final String ZTYSRHSYS                = "ztysrhsys";
    public static final String ZTYTOUJIGYOUNENDOD       = "ztytoujigyounendod";
    public static final String ZTYTOUJIGYOUNENDOHASSEIDRSK = "ztytoujigyounendohasseidrsk";
    public static final String ZTYZENJIGYOUNENDOMATUDZNDK = "ztyzenjigyounendomatudzndk";
    public static final String ZTYYOKUJIGYOUNENDOD      = "ztyyokujigyounendod";
    public static final String ZTYHUSHRTOUJIGYOUNENDOD  = "ztyhushrtoujigyounendod";
    public static final String ZTYSYUKEIYAKUSYURUICDV2  = "ztysyukeiyakusyuruicdv2";
    public static final String ZTYDAIHYOUYOTEIRIRITU    = "ztydaihyouyoteiriritu";
    public static final String ZTYHARAIKATAKBN          = "ztyharaikatakbn";

    private final PKZT_DshrToukeiTy primaryKey;

    public GenZT_DshrToukeiTy() {
        primaryKey = new PKZT_DshrToukeiTy();
    }

    public GenZT_DshrToukeiTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_DshrToukeiTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_DshrToukeiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DshrToukeiTy> getMetaClass() {
        return QZT_DshrToukeiTy.class;
    }

    @Id
    @Column(name=GenZT_DshrToukeiTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_DshrToukeiTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_DshrToukeiTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztymisskbn;

    @Column(name=GenZT_DshrToukeiTy.ZTYMISSKBN)
    public String getZtymisskbn() {
        return ztymisskbn;
    }

    public void setZtymisskbn(String pZtymisskbn) {
        ztymisskbn = pZtymisskbn;
    }

    private String ztysyono;

    @Column(name=GenZT_DshrToukeiTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztydshrym;

    @Column(name=GenZT_DshrToukeiTy.ZTYDSHRYM)
    public String getZtydshrym() {
        return ztydshrym;
    }

    public void setZtydshrym(String pZtydshrym) {
        ztydshrym = pZtydshrym;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_DshrToukeiTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztysrsyoumetucd;

    @Column(name=GenZT_DshrToukeiTy.ZTYSRSYOUMETUCD)
    public String getZtysrsyoumetucd() {
        return ztysrsyoumetucd;
    }

    public void setZtysrsyoumetucd(String pZtysrsyoumetucd) {
        ztysrsyoumetucd = pZtysrsyoumetucd;
    }

    private String ztysyoricd;

    @Column(name=GenZT_DshrToukeiTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztykeiyakunendo;

    @Column(name=GenZT_DshrToukeiTy.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }

    private String ztyannaikigetu;

    @Column(name=GenZT_DshrToukeiTy.ZTYANNAIKIGETU)
    public String getZtyannaikigetu() {
        return ztyannaikigetu;
    }

    public void setZtyannaikigetu(String pZtyannaikigetu) {
        ztyannaikigetu = pZtyannaikigetu;
    }

    private String ztyshrriyuukbn;

    @Column(name=GenZT_DshrToukeiTy.ZTYSHRRIYUUKBN)
    public String getZtyshrriyuukbn() {
        return ztyshrriyuukbn;
    }

    public void setZtyshrriyuukbn(String pZtyshrriyuukbn) {
        ztyshrriyuukbn = pZtyshrriyuukbn;
    }

    private String ztyannaikbn;

    @Column(name=GenZT_DshrToukeiTy.ZTYANNAIKBN)
    public String getZtyannaikbn() {
        return ztyannaikbn;
    }

    public void setZtyannaikbn(String pZtyannaikbn) {
        ztyannaikbn = pZtyannaikbn;
    }

    private String ztyduketorihouhoukbn;

    @Column(name=GenZT_DshrToukeiTy.ZTYDUKETORIHOUHOUKBN)
    public String getZtyduketorihouhoukbn() {
        return ztyduketorihouhoukbn;
    }

    public void setZtyduketorihouhoukbn(String pZtyduketorihouhoukbn) {
        ztyduketorihouhoukbn = pZtyduketorihouhoukbn;
    }

    private String ztybikinhyj;

    @Column(name=GenZT_DshrToukeiTy.ZTYBIKINHYJ)
    public String getZtybikinhyj() {
        return ztybikinhyj;
    }

    public void setZtybikinhyj(String pZtybikinhyj) {
        ztybikinhyj = pZtybikinhyj;
    }

    private String ztyskskbn;

    @Column(name=GenZT_DshrToukeiTy.ZTYSKSKBN)
    public String getZtyskskbn() {
        return ztyskskbn;
    }

    public void setZtyskskbn(String pZtyskskbn) {
        ztyskskbn = pZtyskskbn;
    }

    private String ztysegcd;

    @Column(name=GenZT_DshrToukeiTy.ZTYSEGCD)
    public String getZtysegcd() {
        return ztysegcd;
    }

    public void setZtysegcd(String pZtysegcd) {
        ztysegcd = pZtysegcd;
    }

    private String ztyyobiv3;

    @Column(name=GenZT_DshrToukeiTy.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private Integer ztysrkensuu;

    @Column(name=GenZT_DshrToukeiTy.ZTYSRKENSUU)
    public Integer getZtysrkensuu() {
        return ztysrkensuu;
    }

    public void setZtysrkensuu(Integer pZtysrkensuu) {
        ztysrkensuu = pZtysrkensuu;
    }

    private Long ztysrhsys;

    @Column(name=GenZT_DshrToukeiTy.ZTYSRHSYS)
    public Long getZtysrhsys() {
        return ztysrhsys;
    }

    public void setZtysrhsys(Long pZtysrhsys) {
        ztysrhsys = pZtysrhsys;
    }

    private Long ztytoujigyounendod;

    @Column(name=GenZT_DshrToukeiTy.ZTYTOUJIGYOUNENDOD)
    public Long getZtytoujigyounendod() {
        return ztytoujigyounendod;
    }

    public void setZtytoujigyounendod(Long pZtytoujigyounendod) {
        ztytoujigyounendod = pZtytoujigyounendod;
    }

    private Long ztytoujigyounendohasseidrsk;

    @Column(name=GenZT_DshrToukeiTy.ZTYTOUJIGYOUNENDOHASSEIDRSK)
    public Long getZtytoujigyounendohasseidrsk() {
        return ztytoujigyounendohasseidrsk;
    }

    public void setZtytoujigyounendohasseidrsk(Long pZtytoujigyounendohasseidrsk) {
        ztytoujigyounendohasseidrsk = pZtytoujigyounendohasseidrsk;
    }

    private Long ztyzenjigyounendomatudzndk;

    @Column(name=GenZT_DshrToukeiTy.ZTYZENJIGYOUNENDOMATUDZNDK)
    public Long getZtyzenjigyounendomatudzndk() {
        return ztyzenjigyounendomatudzndk;
    }

    public void setZtyzenjigyounendomatudzndk(Long pZtyzenjigyounendomatudzndk) {
        ztyzenjigyounendomatudzndk = pZtyzenjigyounendomatudzndk;
    }

    private Long ztyyokujigyounendod;

    @Column(name=GenZT_DshrToukeiTy.ZTYYOKUJIGYOUNENDOD)
    public Long getZtyyokujigyounendod() {
        return ztyyokujigyounendod;
    }

    public void setZtyyokujigyounendod(Long pZtyyokujigyounendod) {
        ztyyokujigyounendod = pZtyyokujigyounendod;
    }

    private Long ztyhushrtoujigyounendod;

    @Column(name=GenZT_DshrToukeiTy.ZTYHUSHRTOUJIGYOUNENDOD)
    public Long getZtyhushrtoujigyounendod() {
        return ztyhushrtoujigyounendod;
    }

    public void setZtyhushrtoujigyounendod(Long pZtyhushrtoujigyounendod) {
        ztyhushrtoujigyounendod = pZtyhushrtoujigyounendod;
    }

    private String ztysyukeiyakusyuruicdv2;

    @Column(name=GenZT_DshrToukeiTy.ZTYSYUKEIYAKUSYURUICDV2)
    public String getZtysyukeiyakusyuruicdv2() {
        return ztysyukeiyakusyuruicdv2;
    }

    public void setZtysyukeiyakusyuruicdv2(String pZtysyukeiyakusyuruicdv2) {
        ztysyukeiyakusyuruicdv2 = pZtysyukeiyakusyuruicdv2;
    }

    private BizNumber ztydaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DshrToukeiTy.ZTYDAIHYOUYOTEIRIRITU)
    public BizNumber getZtydaihyouyoteiriritu() {
        return ztydaihyouyoteiriritu;
    }

    public void setZtydaihyouyoteiriritu(BizNumber pZtydaihyouyoteiriritu) {
        ztydaihyouyoteiriritu = pZtydaihyouyoteiriritu;
    }

    private String ztyharaikatakbn;

    @Column(name=GenZT_DshrToukeiTy.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }
}