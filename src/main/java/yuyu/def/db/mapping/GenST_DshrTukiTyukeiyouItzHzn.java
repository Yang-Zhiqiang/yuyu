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
import yuyu.def.db.entity.ST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.id.PKST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.meta.GenQST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.meta.QST_DshrTukiTyukeiyouItzHzn;

/**
 * Ｄ支払統計中継用一時保存テーブル テーブルのマッピング情報クラスで、 {@link ST_DshrTukiTyukeiyouItzHzn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_DshrTukiTyukeiyouItzHzn}</td><td colspan="3">Ｄ支払統計中継用一時保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKST_DshrTukiTyukeiyouItzHzn ○}</td><td align="center">N</td><td>Integer</td></tr>
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
 *  <tr><td>{@link #getZtyhknsyruikbn ztyhknsyruikbn}</td><td>（中継用）保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumetukbn ztysyoumetukbn}</td><td>（中継用）消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_DshrTukiTyukeiyouItzHzn
 * @see     PKST_DshrTukiTyukeiyouItzHzn
 * @see     QST_DshrTukiTyukeiyouItzHzn
 * @see     GenQST_DshrTukiTyukeiyouItzHzn
 */
@MappedSuperclass
@Table(name=GenST_DshrTukiTyukeiyouItzHzn.TABLE_NAME)
@IdClass(value=PKST_DshrTukiTyukeiyouItzHzn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenST_DshrTukiTyukeiyouItzHzn extends AbstractExDBEntity<ST_DshrTukiTyukeiyouItzHzn, PKST_DshrTukiTyukeiyouItzHzn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_DshrTukiTyukeiyouItzHzn";
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
    public static final String ZTYHKNSYRUIKBN           = "ztyhknsyruikbn";
    public static final String ZTYSYOUMETUKBN           = "ztysyoumetukbn";

    private final PKST_DshrTukiTyukeiyouItzHzn primaryKey;

    public GenST_DshrTukiTyukeiyouItzHzn() {
        primaryKey = new PKST_DshrTukiTyukeiyouItzHzn();
    }

    public GenST_DshrTukiTyukeiyouItzHzn(Integer pZtysequenceno) {
        primaryKey = new PKST_DshrTukiTyukeiyouItzHzn(pZtysequenceno);
    }

    @Transient
    @Override
    public PKST_DshrTukiTyukeiyouItzHzn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_DshrTukiTyukeiyouItzHzn> getMetaClass() {
        return QST_DshrTukiTyukeiyouItzHzn.class;
    }

    @Id
    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztymisskbn;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYMISSKBN)
    public String getZtymisskbn() {
        return ztymisskbn;
    }

    public void setZtymisskbn(String pZtymisskbn) {
        ztymisskbn = pZtymisskbn;
    }

    private String ztysyono;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztydshrym;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYDSHRYM)
    public String getZtydshrym() {
        return ztydshrym;
    }

    public void setZtydshrym(String pZtydshrym) {
        ztydshrym = pZtydshrym;
    }

    private String ztyhknsyukigou;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztysrsyoumetucd;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSRSYOUMETUCD)
    public String getZtysrsyoumetucd() {
        return ztysrsyoumetucd;
    }

    public void setZtysrsyoumetucd(String pZtysrsyoumetucd) {
        ztysrsyoumetucd = pZtysrsyoumetucd;
    }

    private String ztysyoricd;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztykeiyakunendo;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }

    private String ztyannaikigetu;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYANNAIKIGETU)
    public String getZtyannaikigetu() {
        return ztyannaikigetu;
    }

    public void setZtyannaikigetu(String pZtyannaikigetu) {
        ztyannaikigetu = pZtyannaikigetu;
    }

    private String ztyshrriyuukbn;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSHRRIYUUKBN)
    public String getZtyshrriyuukbn() {
        return ztyshrriyuukbn;
    }

    public void setZtyshrriyuukbn(String pZtyshrriyuukbn) {
        ztyshrriyuukbn = pZtyshrriyuukbn;
    }

    private String ztyannaikbn;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYANNAIKBN)
    public String getZtyannaikbn() {
        return ztyannaikbn;
    }

    public void setZtyannaikbn(String pZtyannaikbn) {
        ztyannaikbn = pZtyannaikbn;
    }

    private String ztyduketorihouhoukbn;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYDUKETORIHOUHOUKBN)
    public String getZtyduketorihouhoukbn() {
        return ztyduketorihouhoukbn;
    }

    public void setZtyduketorihouhoukbn(String pZtyduketorihouhoukbn) {
        ztyduketorihouhoukbn = pZtyduketorihouhoukbn;
    }

    private String ztybikinhyj;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYBIKINHYJ)
    public String getZtybikinhyj() {
        return ztybikinhyj;
    }

    public void setZtybikinhyj(String pZtybikinhyj) {
        ztybikinhyj = pZtybikinhyj;
    }

    private String ztyskskbn;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSKSKBN)
    public String getZtyskskbn() {
        return ztyskskbn;
    }

    public void setZtyskskbn(String pZtyskskbn) {
        ztyskskbn = pZtyskskbn;
    }

    private String ztysegcd;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSEGCD)
    public String getZtysegcd() {
        return ztysegcd;
    }

    public void setZtysegcd(String pZtysegcd) {
        ztysegcd = pZtysegcd;
    }

    private String ztyyobiv3;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private Integer ztysrkensuu;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSRKENSUU)
    public Integer getZtysrkensuu() {
        return ztysrkensuu;
    }

    public void setZtysrkensuu(Integer pZtysrkensuu) {
        ztysrkensuu = pZtysrkensuu;
    }

    private Long ztysrhsys;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSRHSYS)
    public Long getZtysrhsys() {
        return ztysrhsys;
    }

    public void setZtysrhsys(Long pZtysrhsys) {
        ztysrhsys = pZtysrhsys;
    }

    private Long ztytoujigyounendod;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYTOUJIGYOUNENDOD)
    public Long getZtytoujigyounendod() {
        return ztytoujigyounendod;
    }

    public void setZtytoujigyounendod(Long pZtytoujigyounendod) {
        ztytoujigyounendod = pZtytoujigyounendod;
    }

    private Long ztytoujigyounendohasseidrsk;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYTOUJIGYOUNENDOHASSEIDRSK)
    public Long getZtytoujigyounendohasseidrsk() {
        return ztytoujigyounendohasseidrsk;
    }

    public void setZtytoujigyounendohasseidrsk(Long pZtytoujigyounendohasseidrsk) {
        ztytoujigyounendohasseidrsk = pZtytoujigyounendohasseidrsk;
    }

    private Long ztyzenjigyounendomatudzndk;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYZENJIGYOUNENDOMATUDZNDK)
    public Long getZtyzenjigyounendomatudzndk() {
        return ztyzenjigyounendomatudzndk;
    }

    public void setZtyzenjigyounendomatudzndk(Long pZtyzenjigyounendomatudzndk) {
        ztyzenjigyounendomatudzndk = pZtyzenjigyounendomatudzndk;
    }

    private Long ztyyokujigyounendod;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYYOKUJIGYOUNENDOD)
    public Long getZtyyokujigyounendod() {
        return ztyyokujigyounendod;
    }

    public void setZtyyokujigyounendod(Long pZtyyokujigyounendod) {
        ztyyokujigyounendod = pZtyyokujigyounendod;
    }

    private Long ztyhushrtoujigyounendod;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYHUSHRTOUJIGYOUNENDOD)
    public Long getZtyhushrtoujigyounendod() {
        return ztyhushrtoujigyounendod;
    }

    public void setZtyhushrtoujigyounendod(Long pZtyhushrtoujigyounendod) {
        ztyhushrtoujigyounendod = pZtyhushrtoujigyounendod;
    }

    private String ztysyukeiyakusyuruicdv2;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSYUKEIYAKUSYURUICDV2)
    public String getZtysyukeiyakusyuruicdv2() {
        return ztysyukeiyakusyuruicdv2;
    }

    public void setZtysyukeiyakusyuruicdv2(String pZtysyukeiyakusyuruicdv2) {
        ztysyukeiyakusyuruicdv2 = pZtysyukeiyakusyuruicdv2;
    }

    private BizNumber ztydaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYDAIHYOUYOTEIRIRITU)
    public BizNumber getZtydaihyouyoteiriritu() {
        return ztydaihyouyoteiriritu;
    }

    public void setZtydaihyouyoteiriritu(BizNumber pZtydaihyouyoteiriritu) {
        ztydaihyouyoteiriritu = pZtydaihyouyoteiriritu;
    }

    private String ztyharaikatakbn;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private String ztyhknsyruikbn;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYHKNSYRUIKBN)
    public String getZtyhknsyruikbn() {
        return ztyhknsyruikbn;
    }

    public void setZtyhknsyruikbn(String pZtyhknsyruikbn) {
        ztyhknsyruikbn = pZtyhknsyruikbn;
    }

    private String ztysyoumetukbn;

    @Column(name=GenST_DshrTukiTyukeiyouItzHzn.ZTYSYOUMETUKBN)
    public String getZtysyoumetukbn() {
        return ztysyoumetukbn;
    }

    public void setZtysyoumetukbn(String pZtysyoumetukbn) {
        ztysyoumetukbn = pZtysyoumetukbn;
    }
}