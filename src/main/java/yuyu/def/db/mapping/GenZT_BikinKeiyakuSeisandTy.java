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
import yuyu.def.db.entity.ZT_BikinKeiyakuSeisandTy;
import yuyu.def.db.id.PKZT_BikinKeiyakuSeisandTy;
import yuyu.def.db.meta.GenQZT_BikinKeiyakuSeisandTy;
import yuyu.def.db.meta.QZT_BikinKeiyakuSeisandTy;

/**
 * 備金契約精算ＤＦテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_BikinKeiyakuSeisandTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_BikinKeiyakuSeisandTy}</td><td colspan="3">備金契約精算ＤＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_BikinKeiyakuSeisandTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikinkbn ztybikinkbn}</td><td>（中継用）備金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikinnendokbn ztybikinnendokbn}</td><td>（中継用）備金年度区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisand ztyseisand}</td><td>（中継用）精算Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytumitaterisoku ztytumitaterisoku}</td><td>（中継用）積立利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuruicd1 ztysyuruicd1}</td><td>（中継用）種類コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuruicd3 ztysyuruicd3}</td><td>（中継用）種類コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrkijyunym ztysrkijyunym}</td><td>（中継用）数理用基準年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuruicd2 ztysyuruicd2}</td><td>（中継用）種類コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykariwariatedganrikin ztykariwariatedganrikin}</td><td>（中継用）仮割当Ｄ元利金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykariwariatedrisoku ztykariwariatedrisoku}</td><td>（中継用）仮割当Ｄ利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusyuruicdv2 ztysyukeiyakusyuruicdv2}</td><td>（中継用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaihyouyoteiriritu ztydaihyouyoteiriritu}</td><td>（中継用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbn ztyharaikatakbn}</td><td>（中継用）払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv32 ztyyobiv32}</td><td>（中継用）予備項目Ｖ３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_BikinKeiyakuSeisandTy
 * @see     PKZT_BikinKeiyakuSeisandTy
 * @see     QZT_BikinKeiyakuSeisandTy
 * @see     GenQZT_BikinKeiyakuSeisandTy
 */
@MappedSuperclass
@Table(name=GenZT_BikinKeiyakuSeisandTy.TABLE_NAME)
@IdClass(value=PKZT_BikinKeiyakuSeisandTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_BikinKeiyakuSeisandTy extends AbstractExDBEntity<ZT_BikinKeiyakuSeisandTy, PKZT_BikinKeiyakuSeisandTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_BikinKeiyakuSeisandTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYBIKINKBN              = "ztybikinkbn";
    public static final String ZTYBIKINNENDOKBN         = "ztybikinnendokbn";
    public static final String ZTYSEISAND               = "ztyseisand";
    public static final String ZTYTUMITATERISOKU        = "ztytumitaterisoku";
    public static final String ZTYSYURUICD1             = "ztysyuruicd1";
    public static final String ZTYSYURUICD3             = "ztysyuruicd3";
    public static final String ZTYSRKIJYUNYM            = "ztysrkijyunym";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYSYURUICD2             = "ztysyuruicd2";
    public static final String ZTYKARIWARIATEDGANRIKIN  = "ztykariwariatedganrikin";
    public static final String ZTYKARIWARIATEDRISOKU    = "ztykariwariatedrisoku";
    public static final String ZTYSYUKEIYAKUSYURUICDV2  = "ztysyukeiyakusyuruicdv2";
    public static final String ZTYKEIYAKUNENDO          = "ztykeiyakunendo";
    public static final String ZTYDAIHYOUYOTEIRIRITU    = "ztydaihyouyoteiriritu";
    public static final String ZTYHARAIKATAKBN          = "ztyharaikatakbn";
    public static final String ZTYYOBIV32               = "ztyyobiv32";

    private final PKZT_BikinKeiyakuSeisandTy primaryKey;

    public GenZT_BikinKeiyakuSeisandTy() {
        primaryKey = new PKZT_BikinKeiyakuSeisandTy();
    }

    public GenZT_BikinKeiyakuSeisandTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_BikinKeiyakuSeisandTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_BikinKeiyakuSeisandTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_BikinKeiyakuSeisandTy> getMetaClass() {
        return QZT_BikinKeiyakuSeisandTy.class;
    }

    @Id
    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztysyono;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztybikinkbn;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYBIKINKBN)
    public String getZtybikinkbn() {
        return ztybikinkbn;
    }

    public void setZtybikinkbn(String pZtybikinkbn) {
        ztybikinkbn = pZtybikinkbn;
    }

    private String ztybikinnendokbn;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYBIKINNENDOKBN)
    public String getZtybikinnendokbn() {
        return ztybikinnendokbn;
    }

    public void setZtybikinnendokbn(String pZtybikinnendokbn) {
        ztybikinnendokbn = pZtybikinnendokbn;
    }

    private Long ztyseisand;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYSEISAND)
    public Long getZtyseisand() {
        return ztyseisand;
    }

    public void setZtyseisand(Long pZtyseisand) {
        ztyseisand = pZtyseisand;
    }

    private Long ztytumitaterisoku;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYTUMITATERISOKU)
    public Long getZtytumitaterisoku() {
        return ztytumitaterisoku;
    }

    public void setZtytumitaterisoku(Long pZtytumitaterisoku) {
        ztytumitaterisoku = pZtytumitaterisoku;
    }

    private String ztysyuruicd1;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYSYURUICD1)
    public String getZtysyuruicd1() {
        return ztysyuruicd1;
    }

    public void setZtysyuruicd1(String pZtysyuruicd1) {
        ztysyuruicd1 = pZtysyuruicd1;
    }

    private String ztysyuruicd3;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYSYURUICD3)
    public String getZtysyuruicd3() {
        return ztysyuruicd3;
    }

    public void setZtysyuruicd3(String pZtysyuruicd3) {
        ztysyuruicd3 = pZtysyuruicd3;
    }

    private String ztysrkijyunym;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYSRKIJYUNYM)
    public String getZtysrkijyunym() {
        return ztysrkijyunym;
    }

    public void setZtysrkijyunym(String pZtysrkijyunym) {
        ztysrkijyunym = pZtysrkijyunym;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztysyuruicd2;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYSYURUICD2)
    public String getZtysyuruicd2() {
        return ztysyuruicd2;
    }

    public void setZtysyuruicd2(String pZtysyuruicd2) {
        ztysyuruicd2 = pZtysyuruicd2;
    }

    private Long ztykariwariatedganrikin;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYKARIWARIATEDGANRIKIN)
    public Long getZtykariwariatedganrikin() {
        return ztykariwariatedganrikin;
    }

    public void setZtykariwariatedganrikin(Long pZtykariwariatedganrikin) {
        ztykariwariatedganrikin = pZtykariwariatedganrikin;
    }

    private Long ztykariwariatedrisoku;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYKARIWARIATEDRISOKU)
    public Long getZtykariwariatedrisoku() {
        return ztykariwariatedrisoku;
    }

    public void setZtykariwariatedrisoku(Long pZtykariwariatedrisoku) {
        ztykariwariatedrisoku = pZtykariwariatedrisoku;
    }

    private String ztysyukeiyakusyuruicdv2;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYSYUKEIYAKUSYURUICDV2)
    public String getZtysyukeiyakusyuruicdv2() {
        return ztysyukeiyakusyuruicdv2;
    }

    public void setZtysyukeiyakusyuruicdv2(String pZtysyukeiyakusyuruicdv2) {
        ztysyukeiyakusyuruicdv2 = pZtysyukeiyakusyuruicdv2;
    }

    private String ztykeiyakunendo;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }

    private BizNumber ztydaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYDAIHYOUYOTEIRIRITU)
    public BizNumber getZtydaihyouyoteiriritu() {
        return ztydaihyouyoteiriritu;
    }

    public void setZtydaihyouyoteiriritu(BizNumber pZtydaihyouyoteiriritu) {
        ztydaihyouyoteiriritu = pZtydaihyouyoteiriritu;
    }

    private String ztyharaikatakbn;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private String ztyyobiv32;

    @Column(name=GenZT_BikinKeiyakuSeisandTy.ZTYYOBIV32)
    public String getZtyyobiv32() {
        return ztyyobiv32;
    }

    public void setZtyyobiv32(String pZtyyobiv32) {
        ztyyobiv32 = pZtyyobiv32;
    }
}