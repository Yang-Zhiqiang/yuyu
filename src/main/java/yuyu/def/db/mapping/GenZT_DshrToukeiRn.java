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
import yuyu.def.db.entity.ZT_DshrToukeiRn;
import yuyu.def.db.id.PKZT_DshrToukeiRn;
import yuyu.def.db.meta.GenQZT_DshrToukeiRn;
import yuyu.def.db.meta.QZT_DshrToukeiRn;

/**
 * Ｄ支払統計Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DshrToukeiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DshrToukeiRn}</td><td colspan="3">Ｄ支払統計Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_DshrToukeiRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisskbn zrnmisskbn}</td><td>（連携用）ミス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndshrym zrndshrym}</td><td>（連携用）Ｄ支払年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrsyoumetucd zrnsrsyoumetucd}</td><td>（連携用）数理用消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunendo zrnkeiyakunendo}</td><td>（連携用）契約年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaikigetu zrnannaikigetu}</td><td>（連携用）案内期月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrriyuukbn zrnshrriyuukbn}</td><td>（連携用）支払理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaikbn zrnannaikbn}</td><td>（連携用）案内区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduketorihouhoukbn zrnduketorihouhoukbn}</td><td>（連携用）Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikinhyj zrnbikinhyj}</td><td>（連携用）備金表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskskbn zrnskskbn}</td><td>（連携用）作成区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsegcd zrnsegcd}</td><td>（連携用）セグメントコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrkensuu zrnsrkensuu}</td><td>（連携用）数理用件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsrhsys zrnsrhsys}</td><td>（連携用）数理用保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoujigyounendod zrntoujigyounendod}</td><td>（連携用）当事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoujigyounendohasseidrsk zrntoujigyounendohasseidrsk}</td><td>（連携用）当事業年度発生Ｄ利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzenjigyounendomatudzndk zrnzenjigyounendomatudzndk}</td><td>（連携用）前事業年度末Ｄ残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyokujigyounendod zrnyokujigyounendod}</td><td>（連携用）翌事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhushrtoujigyounendod zrnhushrtoujigyounendod}</td><td>（連携用）不支払当事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakusyuruicdv2 zrnsyukeiyakusyuruicdv2}</td><td>（連携用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaihyouyoteiriritu zrndaihyouyoteiriritu}</td><td>（連携用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbn zrnharaikatakbn}</td><td>（連携用）払方区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DshrToukeiRn
 * @see     PKZT_DshrToukeiRn
 * @see     QZT_DshrToukeiRn
 * @see     GenQZT_DshrToukeiRn
 */
@MappedSuperclass
@Table(name=GenZT_DshrToukeiRn.TABLE_NAME)
@IdClass(value=PKZT_DshrToukeiRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_DshrToukeiRn extends AbstractExDBEntityForZDB<ZT_DshrToukeiRn, PKZT_DshrToukeiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DshrToukeiRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNMISSKBN               = "zrnmisskbn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNDSHRYM                = "zrndshrym";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNSRSYOUMETUCD          = "zrnsrsyoumetucd";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNKEIYAKUNENDO          = "zrnkeiyakunendo";
    public static final String ZRNANNAIKIGETU           = "zrnannaikigetu";
    public static final String ZRNSHRRIYUUKBN           = "zrnshrriyuukbn";
    public static final String ZRNANNAIKBN              = "zrnannaikbn";
    public static final String ZRNDUKETORIHOUHOUKBN     = "zrnduketorihouhoukbn";
    public static final String ZRNBIKINHYJ              = "zrnbikinhyj";
    public static final String ZRNSKSKBN                = "zrnskskbn";
    public static final String ZRNSEGCD                 = "zrnsegcd";
    public static final String ZRNYOBIV3                = "zrnyobiv3";
    public static final String ZRNSRKENSUU              = "zrnsrkensuu";
    public static final String ZRNSRHSYS                = "zrnsrhsys";
    public static final String ZRNTOUJIGYOUNENDOD       = "zrntoujigyounendod";
    public static final String ZRNTOUJIGYOUNENDOHASSEIDRSK = "zrntoujigyounendohasseidrsk";
    public static final String ZRNZENJIGYOUNENDOMATUDZNDK = "zrnzenjigyounendomatudzndk";
    public static final String ZRNYOKUJIGYOUNENDOD      = "zrnyokujigyounendod";
    public static final String ZRNHUSHRTOUJIGYOUNENDOD  = "zrnhushrtoujigyounendod";
    public static final String ZRNSYUKEIYAKUSYURUICDV2  = "zrnsyukeiyakusyuruicdv2";
    public static final String ZRNDAIHYOUYOTEIRIRITU    = "zrndaihyouyoteiriritu";
    public static final String ZRNHARAIKATAKBN          = "zrnharaikatakbn";

    private final PKZT_DshrToukeiRn primaryKey;

    public GenZT_DshrToukeiRn() {
        primaryKey = new PKZT_DshrToukeiRn();
    }

    public GenZT_DshrToukeiRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_DshrToukeiRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_DshrToukeiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DshrToukeiRn> getMetaClass() {
        return QZT_DshrToukeiRn.class;
    }

    @Id
    @Column(name=GenZT_DshrToukeiRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_DshrToukeiRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_DshrToukeiRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrnmisskbn;

    @Column(name=GenZT_DshrToukeiRn.ZRNMISSKBN)
    public String getZrnmisskbn() {
        return zrnmisskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmisskbn(String pZrnmisskbn) {
        zrnmisskbn = pZrnmisskbn;
    }

    private String zrnsyono;

    @Column(name=GenZT_DshrToukeiRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrndshrym;

    @Column(name=GenZT_DshrToukeiRn.ZRNDSHRYM)
    public String getZrndshrym() {
        return zrndshrym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrndshrym(String pZrndshrym) {
        zrndshrym = pZrndshrym;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_DshrToukeiRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnsrsyoumetucd;

    @Column(name=GenZT_DshrToukeiRn.ZRNSRSYOUMETUCD)
    public String getZrnsrsyoumetucd() {
        return zrnsrsyoumetucd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsrsyoumetucd(String pZrnsrsyoumetucd) {
        zrnsrsyoumetucd = pZrnsrsyoumetucd;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_DshrToukeiRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    private String zrnkeiyakunendo;

    @Column(name=GenZT_DshrToukeiRn.ZRNKEIYAKUNENDO)
    public String getZrnkeiyakunendo() {
        return zrnkeiyakunendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkeiyakunendo(String pZrnkeiyakunendo) {
        zrnkeiyakunendo = pZrnkeiyakunendo;
    }

    private String zrnannaikigetu;

    @Column(name=GenZT_DshrToukeiRn.ZRNANNAIKIGETU)
    public String getZrnannaikigetu() {
        return zrnannaikigetu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnannaikigetu(String pZrnannaikigetu) {
        zrnannaikigetu = pZrnannaikigetu;
    }

    private String zrnshrriyuukbn;

    @Column(name=GenZT_DshrToukeiRn.ZRNSHRRIYUUKBN)
    public String getZrnshrriyuukbn() {
        return zrnshrriyuukbn;
    }

    public void setZrnshrriyuukbn(String pZrnshrriyuukbn) {
        zrnshrriyuukbn = pZrnshrriyuukbn;
    }

    private String zrnannaikbn;

    @Column(name=GenZT_DshrToukeiRn.ZRNANNAIKBN)
    public String getZrnannaikbn() {
        return zrnannaikbn;
    }

    public void setZrnannaikbn(String pZrnannaikbn) {
        zrnannaikbn = pZrnannaikbn;
    }

    private String zrnduketorihouhoukbn;

    @Column(name=GenZT_DshrToukeiRn.ZRNDUKETORIHOUHOUKBN)
    public String getZrnduketorihouhoukbn() {
        return zrnduketorihouhoukbn;
    }

    public void setZrnduketorihouhoukbn(String pZrnduketorihouhoukbn) {
        zrnduketorihouhoukbn = pZrnduketorihouhoukbn;
    }

    private String zrnbikinhyj;

    @Column(name=GenZT_DshrToukeiRn.ZRNBIKINHYJ)
    public String getZrnbikinhyj() {
        return zrnbikinhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbikinhyj(String pZrnbikinhyj) {
        zrnbikinhyj = pZrnbikinhyj;
    }

    private String zrnskskbn;

    @Column(name=GenZT_DshrToukeiRn.ZRNSKSKBN)
    public String getZrnskskbn() {
        return zrnskskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnskskbn(String pZrnskskbn) {
        zrnskskbn = pZrnskskbn;
    }

    private String zrnsegcd;

    @Column(name=GenZT_DshrToukeiRn.ZRNSEGCD)
    public String getZrnsegcd() {
        return zrnsegcd;
    }

    public void setZrnsegcd(String pZrnsegcd) {
        zrnsegcd = pZrnsegcd;
    }

    private String zrnyobiv3;

    @Column(name=GenZT_DshrToukeiRn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }

    private Integer zrnsrkensuu;

    @Column(name=GenZT_DshrToukeiRn.ZRNSRKENSUU)
    public Integer getZrnsrkensuu() {
        return zrnsrkensuu;
    }

    public void setZrnsrkensuu(Integer pZrnsrkensuu) {
        zrnsrkensuu = pZrnsrkensuu;
    }

    private Long zrnsrhsys;

    @Column(name=GenZT_DshrToukeiRn.ZRNSRHSYS)
    public Long getZrnsrhsys() {
        return zrnsrhsys;
    }

    public void setZrnsrhsys(Long pZrnsrhsys) {
        zrnsrhsys = pZrnsrhsys;
    }

    private Long zrntoujigyounendod;

    @Column(name=GenZT_DshrToukeiRn.ZRNTOUJIGYOUNENDOD)
    public Long getZrntoujigyounendod() {
        return zrntoujigyounendod;
    }

    public void setZrntoujigyounendod(Long pZrntoujigyounendod) {
        zrntoujigyounendod = pZrntoujigyounendod;
    }

    private Long zrntoujigyounendohasseidrsk;

    @Column(name=GenZT_DshrToukeiRn.ZRNTOUJIGYOUNENDOHASSEIDRSK)
    public Long getZrntoujigyounendohasseidrsk() {
        return zrntoujigyounendohasseidrsk;
    }

    public void setZrntoujigyounendohasseidrsk(Long pZrntoujigyounendohasseidrsk) {
        zrntoujigyounendohasseidrsk = pZrntoujigyounendohasseidrsk;
    }

    private Long zrnzenjigyounendomatudzndk;

    @Column(name=GenZT_DshrToukeiRn.ZRNZENJIGYOUNENDOMATUDZNDK)
    public Long getZrnzenjigyounendomatudzndk() {
        return zrnzenjigyounendomatudzndk;
    }

    public void setZrnzenjigyounendomatudzndk(Long pZrnzenjigyounendomatudzndk) {
        zrnzenjigyounendomatudzndk = pZrnzenjigyounendomatudzndk;
    }

    private Long zrnyokujigyounendod;

    @Column(name=GenZT_DshrToukeiRn.ZRNYOKUJIGYOUNENDOD)
    public Long getZrnyokujigyounendod() {
        return zrnyokujigyounendod;
    }

    public void setZrnyokujigyounendod(Long pZrnyokujigyounendod) {
        zrnyokujigyounendod = pZrnyokujigyounendod;
    }

    private Long zrnhushrtoujigyounendod;

    @Column(name=GenZT_DshrToukeiRn.ZRNHUSHRTOUJIGYOUNENDOD)
    public Long getZrnhushrtoujigyounendod() {
        return zrnhushrtoujigyounendod;
    }

    public void setZrnhushrtoujigyounendod(Long pZrnhushrtoujigyounendod) {
        zrnhushrtoujigyounendod = pZrnhushrtoujigyounendod;
    }

    private String zrnsyukeiyakusyuruicdv2;

    @Column(name=GenZT_DshrToukeiRn.ZRNSYUKEIYAKUSYURUICDV2)
    public String getZrnsyukeiyakusyuruicdv2() {
        return zrnsyukeiyakusyuruicdv2;
    }

    public void setZrnsyukeiyakusyuruicdv2(String pZrnsyukeiyakusyuruicdv2) {
        zrnsyukeiyakusyuruicdv2 = pZrnsyukeiyakusyuruicdv2;
    }

    private BizNumber zrndaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DshrToukeiRn.ZRNDAIHYOUYOTEIRIRITU)
    public BizNumber getZrndaihyouyoteiriritu() {
        return zrndaihyouyoteiriritu;
    }

    public void setZrndaihyouyoteiriritu(BizNumber pZrndaihyouyoteiriritu) {
        zrndaihyouyoteiriritu = pZrndaihyouyoteiriritu;
    }

    private String zrnharaikatakbn;

    @Column(name=GenZT_DshrToukeiRn.ZRNHARAIKATAKBN)
    public String getZrnharaikatakbn() {
        return zrnharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaikatakbn(String pZrnharaikatakbn) {
        zrnharaikatakbn = pZrnharaikatakbn;
    }
}