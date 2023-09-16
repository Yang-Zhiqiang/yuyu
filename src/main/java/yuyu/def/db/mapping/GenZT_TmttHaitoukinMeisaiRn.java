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
import yuyu.def.db.entity.ZT_TmttHaitoukinMeisaiRn;
import yuyu.def.db.id.PKZT_TmttHaitoukinMeisaiRn;
import yuyu.def.db.meta.GenQZT_TmttHaitoukinMeisaiRn;
import yuyu.def.db.meta.QZT_TmttHaitoukinMeisaiRn;

/**
 * 積立配当金明細Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TmttHaitoukinMeisaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TmttHaitoukinMeisaiRn}</td><td colspan="3">積立配当金明細Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_TmttHaitoukinMeisaiRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennendokurikosid zrnzennendokurikosid}</td><td>（連携用）前年度繰越Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntounendod zrntounendod}</td><td>（連携用）当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntounendomatutumitated zrntounendomatutumitated}</td><td>（連携用）当年度末積立Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntumitaterisoku zrntumitaterisoku}</td><td>（連携用）積立利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhsys zrnhsys}</td><td>（連携用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyuruicd1 zrnsyuruicd1}</td><td>（連携用）種類コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuruicd3 zrnsyuruicd3}</td><td>（連携用）種類コード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrutiwake zrnsrutiwake}</td><td>（連携用）数理用内訳</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrkijyunym zrnsrkijyunym}</td><td>（連携用）数理用基準年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuruicd2 zrnsyuruicd2}</td><td>（連携用）種類コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmankitouraiym zrnmankitouraiym}</td><td>（連携用）満期到来年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakusyuruicdv2 zrnsyukeiyakusyuruicdv2}</td><td>（連携用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunendo zrnkeiyakunendo}</td><td>（連携用）契約年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaihyouyoteiriritu zrndaihyouyoteiriritu}</td><td>（連携用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbn zrnharaikatakbn}</td><td>（連携用）払方区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv20 zrnyobiv20}</td><td>（連携用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TmttHaitoukinMeisaiRn
 * @see     PKZT_TmttHaitoukinMeisaiRn
 * @see     QZT_TmttHaitoukinMeisaiRn
 * @see     GenQZT_TmttHaitoukinMeisaiRn
 */
@MappedSuperclass
@Table(name=GenZT_TmttHaitoukinMeisaiRn.TABLE_NAME)
@IdClass(value=PKZT_TmttHaitoukinMeisaiRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_TmttHaitoukinMeisaiRn extends AbstractExDBEntityForZDB<ZT_TmttHaitoukinMeisaiRn, PKZT_TmttHaitoukinMeisaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TmttHaitoukinMeisaiRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNZENNENDOKURIKOSID     = "zrnzennendokurikosid";
    public static final String ZRNTOUNENDOD             = "zrntounendod";
    public static final String ZRNTOUNENDOMATUTUMITATED = "zrntounendomatutumitated";
    public static final String ZRNTUMITATERISOKU        = "zrntumitaterisoku";
    public static final String ZRNHSYS                  = "zrnhsys";
    public static final String ZRNSYURUICD1             = "zrnsyuruicd1";
    public static final String ZRNSYURUICD3             = "zrnsyuruicd3";
    public static final String ZRNSRUTIWAKE             = "zrnsrutiwake";
    public static final String ZRNSRKIJYUNYM            = "zrnsrkijyunym";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNSYURUICD2             = "zrnsyuruicd2";
    public static final String ZRNMANKITOURAIYM         = "zrnmankitouraiym";
    public static final String ZRNSYUKEIYAKUSYURUICDV2  = "zrnsyukeiyakusyuruicdv2";
    public static final String ZRNKEIYAKUNENDO          = "zrnkeiyakunendo";
    public static final String ZRNDAIHYOUYOTEIRIRITU    = "zrndaihyouyoteiriritu";
    public static final String ZRNHARAIKATAKBN          = "zrnharaikatakbn";
    public static final String ZRNYOBIV20               = "zrnyobiv20";

    private final PKZT_TmttHaitoukinMeisaiRn primaryKey;

    public GenZT_TmttHaitoukinMeisaiRn() {
        primaryKey = new PKZT_TmttHaitoukinMeisaiRn();
    }

    public GenZT_TmttHaitoukinMeisaiRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_TmttHaitoukinMeisaiRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_TmttHaitoukinMeisaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TmttHaitoukinMeisaiRn> getMetaClass() {
        return QZT_TmttHaitoukinMeisaiRn.class;
    }

    @Id
    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrnsyono;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private Long zrnzennendokurikosid;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNZENNENDOKURIKOSID)
    public Long getZrnzennendokurikosid() {
        return zrnzennendokurikosid;
    }

    public void setZrnzennendokurikosid(Long pZrnzennendokurikosid) {
        zrnzennendokurikosid = pZrnzennendokurikosid;
    }

    private Long zrntounendod;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNTOUNENDOD)
    public Long getZrntounendod() {
        return zrntounendod;
    }

    public void setZrntounendod(Long pZrntounendod) {
        zrntounendod = pZrntounendod;
    }

    private Long zrntounendomatutumitated;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNTOUNENDOMATUTUMITATED)
    public Long getZrntounendomatutumitated() {
        return zrntounendomatutumitated;
    }

    public void setZrntounendomatutumitated(Long pZrntounendomatutumitated) {
        zrntounendomatutumitated = pZrntounendomatutumitated;
    }

    private Long zrntumitaterisoku;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNTUMITATERISOKU)
    public Long getZrntumitaterisoku() {
        return zrntumitaterisoku;
    }

    public void setZrntumitaterisoku(Long pZrntumitaterisoku) {
        zrntumitaterisoku = pZrntumitaterisoku;
    }

    private Long zrnhsys;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNHSYS)
    public Long getZrnhsys() {
        return zrnhsys;
    }

    public void setZrnhsys(Long pZrnhsys) {
        zrnhsys = pZrnhsys;
    }

    private String zrnsyuruicd1;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNSYURUICD1)
    public String getZrnsyuruicd1() {
        return zrnsyuruicd1;
    }

    public void setZrnsyuruicd1(String pZrnsyuruicd1) {
        zrnsyuruicd1 = pZrnsyuruicd1;
    }

    private String zrnsyuruicd3;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNSYURUICD3)
    public String getZrnsyuruicd3() {
        return zrnsyuruicd3;
    }

    public void setZrnsyuruicd3(String pZrnsyuruicd3) {
        zrnsyuruicd3 = pZrnsyuruicd3;
    }

    private String zrnsrutiwake;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNSRUTIWAKE)
    public String getZrnsrutiwake() {
        return zrnsrutiwake;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrutiwake(String pZrnsrutiwake) {
        zrnsrutiwake = pZrnsrutiwake;
    }

    private String zrnsrkijyunym;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNSRKIJYUNYM)
    public String getZrnsrkijyunym() {
        return zrnsrkijyunym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsrkijyunym(String pZrnsrkijyunym) {
        zrnsrkijyunym = pZrnsrkijyunym;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnsyuruicd2;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNSYURUICD2)
    public String getZrnsyuruicd2() {
        return zrnsyuruicd2;
    }

    public void setZrnsyuruicd2(String pZrnsyuruicd2) {
        zrnsyuruicd2 = pZrnsyuruicd2;
    }

    private String zrnmankitouraiym;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNMANKITOURAIYM)
    public String getZrnmankitouraiym() {
        return zrnmankitouraiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnmankitouraiym(String pZrnmankitouraiym) {
        zrnmankitouraiym = pZrnmankitouraiym;
    }

    private String zrnsyukeiyakusyuruicdv2;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNSYUKEIYAKUSYURUICDV2)
    public String getZrnsyukeiyakusyuruicdv2() {
        return zrnsyukeiyakusyuruicdv2;
    }

    public void setZrnsyukeiyakusyuruicdv2(String pZrnsyukeiyakusyuruicdv2) {
        zrnsyukeiyakusyuruicdv2 = pZrnsyukeiyakusyuruicdv2;
    }

    private String zrnkeiyakunendo;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNKEIYAKUNENDO)
    public String getZrnkeiyakunendo() {
        return zrnkeiyakunendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkeiyakunendo(String pZrnkeiyakunendo) {
        zrnkeiyakunendo = pZrnkeiyakunendo;
    }

    private BizNumber zrndaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNDAIHYOUYOTEIRIRITU)
    public BizNumber getZrndaihyouyoteiriritu() {
        return zrndaihyouyoteiriritu;
    }

    public void setZrndaihyouyoteiriritu(BizNumber pZrndaihyouyoteiriritu) {
        zrndaihyouyoteiriritu = pZrndaihyouyoteiriritu;
    }

    private String zrnharaikatakbn;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNHARAIKATAKBN)
    public String getZrnharaikatakbn() {
        return zrnharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaikatakbn(String pZrnharaikatakbn) {
        zrnharaikatakbn = pZrnharaikatakbn;
    }

    private String zrnyobiv20;

    @Column(name=GenZT_TmttHaitoukinMeisaiRn.ZRNYOBIV20)
    public String getZrnyobiv20() {
        return zrnyobiv20;
    }

    public void setZrnyobiv20(String pZrnyobiv20) {
        zrnyobiv20 = pZrnyobiv20;
    }
}