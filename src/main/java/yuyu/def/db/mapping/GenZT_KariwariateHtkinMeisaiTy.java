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
import yuyu.def.db.entity.ZT_KariwariateHtkinMeisaiTy;
import yuyu.def.db.id.PKZT_KariwariateHtkinMeisaiTy;
import yuyu.def.db.meta.GenQZT_KariwariateHtkinMeisaiTy;
import yuyu.def.db.meta.QZT_KariwariateHtkinMeisaiTy;

/**
 * 仮割当配当金明細Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KariwariateHtkinMeisaiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KariwariateHtkinMeisaiTy}</td><td colspan="3">仮割当配当金明細Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_KariwariateHtkinMeisaiTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyznnndkrkskrwratdruigk ztyznnndkrkskrwratdruigk}</td><td>（中継用）前年度繰越仮割当Ｄ累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytounendokariwariated ztytounendokariwariated}</td><td>（中継用）当年度仮割当Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytndmatukrkskrwratdruigk ztytndmatukrkskrwratdruigk}</td><td>（中継用）当年度末仮割当Ｄ累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykariwariatedrisoku ztykariwariatedrisoku}</td><td>（中継用）仮割当Ｄ利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhsys ztyhsys}</td><td>（中継用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrutiwake ztysrutiwake}</td><td>（中継用）数理用内訳</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrkijyunym ztysrkijyunym}</td><td>（中継用）数理用基準年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisikiwariatenendohyj ztyseisikiwariatenendohyj}</td><td>（中継用）正式割当年度表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymankitouraiym ztymankitouraiym}</td><td>（中継用）満期到来年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusyuruicdv2 ztysyukeiyakusyuruicdv2}</td><td>（中継用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaihyouyoteiriritu ztydaihyouyoteiriritu}</td><td>（中継用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbn ztyharaikatakbn}</td><td>（中継用）払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KariwariateHtkinMeisaiTy
 * @see     PKZT_KariwariateHtkinMeisaiTy
 * @see     QZT_KariwariateHtkinMeisaiTy
 * @see     GenQZT_KariwariateHtkinMeisaiTy
 */
@MappedSuperclass
@Table(name=GenZT_KariwariateHtkinMeisaiTy.TABLE_NAME)
@IdClass(value=PKZT_KariwariateHtkinMeisaiTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KariwariateHtkinMeisaiTy extends AbstractExDBEntity<ZT_KariwariateHtkinMeisaiTy, PKZT_KariwariateHtkinMeisaiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KariwariateHtkinMeisaiTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYZNNNDKRKSKRWRATDRUIGK = "ztyznnndkrkskrwratdruigk";
    public static final String ZTYTOUNENDOKARIWARIATED  = "ztytounendokariwariated";
    public static final String ZTYTNDMATUKRKSKRWRATDRUIGK = "ztytndmatukrkskrwratdruigk";
    public static final String ZTYKARIWARIATEDRISOKU    = "ztykariwariatedrisoku";
    public static final String ZTYHSYS                  = "ztyhsys";
    public static final String ZTYYOBIV3                = "ztyyobiv3";
    public static final String ZTYSRUTIWAKE             = "ztysrutiwake";
    public static final String ZTYSRKIJYUNYM            = "ztysrkijyunym";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYSEISIKIWARIATENENDOHYJ = "ztyseisikiwariatenendohyj";
    public static final String ZTYMANKITOURAIYM         = "ztymankitouraiym";
    public static final String ZTYSYUKEIYAKUSYURUICDV2  = "ztysyukeiyakusyuruicdv2";
    public static final String ZTYKEIYAKUNENDO          = "ztykeiyakunendo";
    public static final String ZTYDAIHYOUYOTEIRIRITU    = "ztydaihyouyoteiriritu";
    public static final String ZTYHARAIKATAKBN          = "ztyharaikatakbn";
    public static final String ZTYYOBIV20               = "ztyyobiv20";

    private final PKZT_KariwariateHtkinMeisaiTy primaryKey;

    public GenZT_KariwariateHtkinMeisaiTy() {
        primaryKey = new PKZT_KariwariateHtkinMeisaiTy();
    }

    public GenZT_KariwariateHtkinMeisaiTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_KariwariateHtkinMeisaiTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_KariwariateHtkinMeisaiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KariwariateHtkinMeisaiTy> getMetaClass() {
        return QZT_KariwariateHtkinMeisaiTy.class;
    }

    @Id
    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztysyono;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private Long ztyznnndkrkskrwratdruigk;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYZNNNDKRKSKRWRATDRUIGK)
    public Long getZtyznnndkrkskrwratdruigk() {
        return ztyznnndkrkskrwratdruigk;
    }

    public void setZtyznnndkrkskrwratdruigk(Long pZtyznnndkrkskrwratdruigk) {
        ztyznnndkrkskrwratdruigk = pZtyznnndkrkskrwratdruigk;
    }

    private Long ztytounendokariwariated;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYTOUNENDOKARIWARIATED)
    public Long getZtytounendokariwariated() {
        return ztytounendokariwariated;
    }

    public void setZtytounendokariwariated(Long pZtytounendokariwariated) {
        ztytounendokariwariated = pZtytounendokariwariated;
    }

    private Long ztytndmatukrkskrwratdruigk;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYTNDMATUKRKSKRWRATDRUIGK)
    public Long getZtytndmatukrkskrwratdruigk() {
        return ztytndmatukrkskrwratdruigk;
    }

    public void setZtytndmatukrkskrwratdruigk(Long pZtytndmatukrkskrwratdruigk) {
        ztytndmatukrkskrwratdruigk = pZtytndmatukrkskrwratdruigk;
    }

    private Long ztykariwariatedrisoku;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYKARIWARIATEDRISOKU)
    public Long getZtykariwariatedrisoku() {
        return ztykariwariatedrisoku;
    }

    public void setZtykariwariatedrisoku(Long pZtykariwariatedrisoku) {
        ztykariwariatedrisoku = pZtykariwariatedrisoku;
    }

    private Long ztyhsys;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYHSYS)
    public Long getZtyhsys() {
        return ztyhsys;
    }

    public void setZtyhsys(Long pZtyhsys) {
        ztyhsys = pZtyhsys;
    }

    private String ztyyobiv3;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private String ztysrutiwake;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYSRUTIWAKE)
    public String getZtysrutiwake() {
        return ztysrutiwake;
    }

    public void setZtysrutiwake(String pZtysrutiwake) {
        ztysrutiwake = pZtysrutiwake;
    }

    private String ztysrkijyunym;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYSRKIJYUNYM)
    public String getZtysrkijyunym() {
        return ztysrkijyunym;
    }

    public void setZtysrkijyunym(String pZtysrkijyunym) {
        ztysrkijyunym = pZtysrkijyunym;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztyseisikiwariatenendohyj;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYSEISIKIWARIATENENDOHYJ)
    public String getZtyseisikiwariatenendohyj() {
        return ztyseisikiwariatenendohyj;
    }

    public void setZtyseisikiwariatenendohyj(String pZtyseisikiwariatenendohyj) {
        ztyseisikiwariatenendohyj = pZtyseisikiwariatenendohyj;
    }

    private String ztymankitouraiym;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYMANKITOURAIYM)
    public String getZtymankitouraiym() {
        return ztymankitouraiym;
    }

    public void setZtymankitouraiym(String pZtymankitouraiym) {
        ztymankitouraiym = pZtymankitouraiym;
    }

    private String ztysyukeiyakusyuruicdv2;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYSYUKEIYAKUSYURUICDV2)
    public String getZtysyukeiyakusyuruicdv2() {
        return ztysyukeiyakusyuruicdv2;
    }

    public void setZtysyukeiyakusyuruicdv2(String pZtysyukeiyakusyuruicdv2) {
        ztysyukeiyakusyuruicdv2 = pZtysyukeiyakusyuruicdv2;
    }

    private String ztykeiyakunendo;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }

    private BizNumber ztydaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYDAIHYOUYOTEIRIRITU)
    public BizNumber getZtydaihyouyoteiriritu() {
        return ztydaihyouyoteiriritu;
    }

    public void setZtydaihyouyoteiriritu(BizNumber pZtydaihyouyoteiriritu) {
        ztydaihyouyoteiriritu = pZtydaihyouyoteiriritu;
    }

    private String ztyharaikatakbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_KariwariateHtkinMeisaiTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }
}