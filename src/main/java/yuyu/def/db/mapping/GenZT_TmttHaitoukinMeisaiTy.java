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
import yuyu.def.db.entity.ZT_TmttHaitoukinMeisaiTy;
import yuyu.def.db.id.PKZT_TmttHaitoukinMeisaiTy;
import yuyu.def.db.meta.GenQZT_TmttHaitoukinMeisaiTy;
import yuyu.def.db.meta.QZT_TmttHaitoukinMeisaiTy;

/**
 * 積立配当金明細Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_TmttHaitoukinMeisaiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TmttHaitoukinMeisaiTy}</td><td colspan="3">積立配当金明細Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_TmttHaitoukinMeisaiTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennendokurikosid ztyzennendokurikosid}</td><td>（中継用）前年度繰越Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytounendod ztytounendod}</td><td>（中継用）当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytounendomatutumitated ztytounendomatutumitated}</td><td>（中継用）当年度末積立Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytumitaterisoku ztytumitaterisoku}</td><td>（中継用）積立利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhsys ztyhsys}</td><td>（中継用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuruicd1 ztysyuruicd1}</td><td>（中継用）種類コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuruicd3 ztysyuruicd3}</td><td>（中継用）種類コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrutiwake ztysrutiwake}</td><td>（中継用）数理用内訳</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrkijyunym ztysrkijyunym}</td><td>（中継用）数理用基準年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuruicd2 ztysyuruicd2}</td><td>（中継用）種類コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymankitouraiym ztymankitouraiym}</td><td>（中継用）満期到来年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusyuruicdv2 ztysyukeiyakusyuruicdv2}</td><td>（中継用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaihyouyoteiriritu ztydaihyouyoteiriritu}</td><td>（中継用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbn ztyharaikatakbn}</td><td>（中継用）払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TmttHaitoukinMeisaiTy
 * @see     PKZT_TmttHaitoukinMeisaiTy
 * @see     QZT_TmttHaitoukinMeisaiTy
 * @see     GenQZT_TmttHaitoukinMeisaiTy
 */
@MappedSuperclass
@Table(name=GenZT_TmttHaitoukinMeisaiTy.TABLE_NAME)
@IdClass(value=PKZT_TmttHaitoukinMeisaiTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_TmttHaitoukinMeisaiTy extends AbstractExDBEntity<ZT_TmttHaitoukinMeisaiTy, PKZT_TmttHaitoukinMeisaiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TmttHaitoukinMeisaiTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYZENNENDOKURIKOSID     = "ztyzennendokurikosid";
    public static final String ZTYTOUNENDOD             = "ztytounendod";
    public static final String ZTYTOUNENDOMATUTUMITATED = "ztytounendomatutumitated";
    public static final String ZTYTUMITATERISOKU        = "ztytumitaterisoku";
    public static final String ZTYHSYS                  = "ztyhsys";
    public static final String ZTYSYURUICD1             = "ztysyuruicd1";
    public static final String ZTYSYURUICD3             = "ztysyuruicd3";
    public static final String ZTYSRUTIWAKE             = "ztysrutiwake";
    public static final String ZTYSRKIJYUNYM            = "ztysrkijyunym";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYSYURUICD2             = "ztysyuruicd2";
    public static final String ZTYMANKITOURAIYM         = "ztymankitouraiym";
    public static final String ZTYSYUKEIYAKUSYURUICDV2  = "ztysyukeiyakusyuruicdv2";
    public static final String ZTYKEIYAKUNENDO          = "ztykeiyakunendo";
    public static final String ZTYDAIHYOUYOTEIRIRITU    = "ztydaihyouyoteiriritu";
    public static final String ZTYHARAIKATAKBN          = "ztyharaikatakbn";
    public static final String ZTYYOBIV20               = "ztyyobiv20";

    private final PKZT_TmttHaitoukinMeisaiTy primaryKey;

    public GenZT_TmttHaitoukinMeisaiTy() {
        primaryKey = new PKZT_TmttHaitoukinMeisaiTy();
    }

    public GenZT_TmttHaitoukinMeisaiTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_TmttHaitoukinMeisaiTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_TmttHaitoukinMeisaiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TmttHaitoukinMeisaiTy> getMetaClass() {
        return QZT_TmttHaitoukinMeisaiTy.class;
    }

    @Id
    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztysyono;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private Long ztyzennendokurikosid;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYZENNENDOKURIKOSID)
    public Long getZtyzennendokurikosid() {
        return ztyzennendokurikosid;
    }

    public void setZtyzennendokurikosid(Long pZtyzennendokurikosid) {
        ztyzennendokurikosid = pZtyzennendokurikosid;
    }

    private Long ztytounendod;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYTOUNENDOD)
    public Long getZtytounendod() {
        return ztytounendod;
    }

    public void setZtytounendod(Long pZtytounendod) {
        ztytounendod = pZtytounendod;
    }

    private Long ztytounendomatutumitated;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYTOUNENDOMATUTUMITATED)
    public Long getZtytounendomatutumitated() {
        return ztytounendomatutumitated;
    }

    public void setZtytounendomatutumitated(Long pZtytounendomatutumitated) {
        ztytounendomatutumitated = pZtytounendomatutumitated;
    }

    private Long ztytumitaterisoku;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYTUMITATERISOKU)
    public Long getZtytumitaterisoku() {
        return ztytumitaterisoku;
    }

    public void setZtytumitaterisoku(Long pZtytumitaterisoku) {
        ztytumitaterisoku = pZtytumitaterisoku;
    }

    private Long ztyhsys;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYHSYS)
    public Long getZtyhsys() {
        return ztyhsys;
    }

    public void setZtyhsys(Long pZtyhsys) {
        ztyhsys = pZtyhsys;
    }

    private String ztysyuruicd1;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYSYURUICD1)
    public String getZtysyuruicd1() {
        return ztysyuruicd1;
    }

    public void setZtysyuruicd1(String pZtysyuruicd1) {
        ztysyuruicd1 = pZtysyuruicd1;
    }

    private String ztysyuruicd3;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYSYURUICD3)
    public String getZtysyuruicd3() {
        return ztysyuruicd3;
    }

    public void setZtysyuruicd3(String pZtysyuruicd3) {
        ztysyuruicd3 = pZtysyuruicd3;
    }

    private String ztysrutiwake;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYSRUTIWAKE)
    public String getZtysrutiwake() {
        return ztysrutiwake;
    }

    public void setZtysrutiwake(String pZtysrutiwake) {
        ztysrutiwake = pZtysrutiwake;
    }

    private String ztysrkijyunym;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYSRKIJYUNYM)
    public String getZtysrkijyunym() {
        return ztysrkijyunym;
    }

    public void setZtysrkijyunym(String pZtysrkijyunym) {
        ztysrkijyunym = pZtysrkijyunym;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztysyuruicd2;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYSYURUICD2)
    public String getZtysyuruicd2() {
        return ztysyuruicd2;
    }

    public void setZtysyuruicd2(String pZtysyuruicd2) {
        ztysyuruicd2 = pZtysyuruicd2;
    }

    private String ztymankitouraiym;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYMANKITOURAIYM)
    public String getZtymankitouraiym() {
        return ztymankitouraiym;
    }

    public void setZtymankitouraiym(String pZtymankitouraiym) {
        ztymankitouraiym = pZtymankitouraiym;
    }

    private String ztysyukeiyakusyuruicdv2;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYSYUKEIYAKUSYURUICDV2)
    public String getZtysyukeiyakusyuruicdv2() {
        return ztysyukeiyakusyuruicdv2;
    }

    public void setZtysyukeiyakusyuruicdv2(String pZtysyukeiyakusyuruicdv2) {
        ztysyukeiyakusyuruicdv2 = pZtysyukeiyakusyuruicdv2;
    }

    private String ztykeiyakunendo;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }

    private BizNumber ztydaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYDAIHYOUYOTEIRIRITU)
    public BizNumber getZtydaihyouyoteiriritu() {
        return ztydaihyouyoteiriritu;
    }

    public void setZtydaihyouyoteiriritu(BizNumber pZtydaihyouyoteiriritu) {
        ztydaihyouyoteiriritu = pZtydaihyouyoteiriritu;
    }

    private String ztyharaikatakbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_TmttHaitoukinMeisaiTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }
}