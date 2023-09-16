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
import yuyu.def.db.entity.ZT_KariwariateHtkinMeisaiRn;
import yuyu.def.db.id.PKZT_KariwariateHtkinMeisaiRn;
import yuyu.def.db.meta.GenQZT_KariwariateHtkinMeisaiRn;
import yuyu.def.db.meta.QZT_KariwariateHtkinMeisaiRn;

/**
 * 仮割当配当金明細Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KariwariateHtkinMeisaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KariwariateHtkinMeisaiRn}</td><td colspan="3">仮割当配当金明細Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_KariwariateHtkinMeisaiRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnznnndkrkskrwratdruigk zrnznnndkrkskrwratdruigk}</td><td>（連携用）前年度繰越仮割当Ｄ累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntounendokariwariated zrntounendokariwariated}</td><td>（連携用）当年度仮割当Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntndmatukrkskrwratdruigk zrntndmatukrkskrwratdruigk}</td><td>（連携用）当年度末仮割当Ｄ累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkariwariatedrisoku zrnkariwariatedrisoku}</td><td>（連携用）仮割当Ｄ利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhsys zrnhsys}</td><td>（連携用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrutiwake zrnsrutiwake}</td><td>（連携用）数理用内訳</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrkijyunym zrnsrkijyunym}</td><td>（連携用）数理用基準年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisikiwariatenendohyj zrnseisikiwariatenendohyj}</td><td>（連携用）正式割当年度表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmankitouraiym zrnmankitouraiym}</td><td>（連携用）満期到来年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakusyuruicdv2 zrnsyukeiyakusyuruicdv2}</td><td>（連携用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunendo zrnkeiyakunendo}</td><td>（連携用）契約年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaihyouyoteiriritu zrndaihyouyoteiriritu}</td><td>（連携用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbn zrnharaikatakbn}</td><td>（連携用）払方区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv20 zrnyobiv20}</td><td>（連携用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KariwariateHtkinMeisaiRn
 * @see     PKZT_KariwariateHtkinMeisaiRn
 * @see     QZT_KariwariateHtkinMeisaiRn
 * @see     GenQZT_KariwariateHtkinMeisaiRn
 */
@MappedSuperclass
@Table(name=GenZT_KariwariateHtkinMeisaiRn.TABLE_NAME)
@IdClass(value=PKZT_KariwariateHtkinMeisaiRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KariwariateHtkinMeisaiRn extends AbstractExDBEntityForZDB<ZT_KariwariateHtkinMeisaiRn, PKZT_KariwariateHtkinMeisaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KariwariateHtkinMeisaiRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNZNNNDKRKSKRWRATDRUIGK = "zrnznnndkrkskrwratdruigk";
    public static final String ZRNTOUNENDOKARIWARIATED  = "zrntounendokariwariated";
    public static final String ZRNTNDMATUKRKSKRWRATDRUIGK = "zrntndmatukrkskrwratdruigk";
    public static final String ZRNKARIWARIATEDRISOKU    = "zrnkariwariatedrisoku";
    public static final String ZRNHSYS                  = "zrnhsys";
    public static final String ZRNYOBIV3                = "zrnyobiv3";
    public static final String ZRNSRUTIWAKE             = "zrnsrutiwake";
    public static final String ZRNSRKIJYUNYM            = "zrnsrkijyunym";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNSEISIKIWARIATENENDOHYJ = "zrnseisikiwariatenendohyj";
    public static final String ZRNMANKITOURAIYM         = "zrnmankitouraiym";
    public static final String ZRNSYUKEIYAKUSYURUICDV2  = "zrnsyukeiyakusyuruicdv2";
    public static final String ZRNKEIYAKUNENDO          = "zrnkeiyakunendo";
    public static final String ZRNDAIHYOUYOTEIRIRITU    = "zrndaihyouyoteiriritu";
    public static final String ZRNHARAIKATAKBN          = "zrnharaikatakbn";
    public static final String ZRNYOBIV20               = "zrnyobiv20";

    private final PKZT_KariwariateHtkinMeisaiRn primaryKey;

    public GenZT_KariwariateHtkinMeisaiRn() {
        primaryKey = new PKZT_KariwariateHtkinMeisaiRn();
    }

    public GenZT_KariwariateHtkinMeisaiRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_KariwariateHtkinMeisaiRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_KariwariateHtkinMeisaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KariwariateHtkinMeisaiRn> getMetaClass() {
        return QZT_KariwariateHtkinMeisaiRn.class;
    }

    @Id
    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrnsyono;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private Long zrnznnndkrkskrwratdruigk;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNZNNNDKRKSKRWRATDRUIGK)
    public Long getZrnznnndkrkskrwratdruigk() {
        return zrnznnndkrkskrwratdruigk;
    }

    public void setZrnznnndkrkskrwratdruigk(Long pZrnznnndkrkskrwratdruigk) {
        zrnznnndkrkskrwratdruigk = pZrnznnndkrkskrwratdruigk;
    }

    private Long zrntounendokariwariated;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNTOUNENDOKARIWARIATED)
    public Long getZrntounendokariwariated() {
        return zrntounendokariwariated;
    }

    public void setZrntounendokariwariated(Long pZrntounendokariwariated) {
        zrntounendokariwariated = pZrntounendokariwariated;
    }

    private Long zrntndmatukrkskrwratdruigk;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNTNDMATUKRKSKRWRATDRUIGK)
    public Long getZrntndmatukrkskrwratdruigk() {
        return zrntndmatukrkskrwratdruigk;
    }

    public void setZrntndmatukrkskrwratdruigk(Long pZrntndmatukrkskrwratdruigk) {
        zrntndmatukrkskrwratdruigk = pZrntndmatukrkskrwratdruigk;
    }

    private Long zrnkariwariatedrisoku;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNKARIWARIATEDRISOKU)
    public Long getZrnkariwariatedrisoku() {
        return zrnkariwariatedrisoku;
    }

    public void setZrnkariwariatedrisoku(Long pZrnkariwariatedrisoku) {
        zrnkariwariatedrisoku = pZrnkariwariatedrisoku;
    }

    private Long zrnhsys;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNHSYS)
    public Long getZrnhsys() {
        return zrnhsys;
    }

    public void setZrnhsys(Long pZrnhsys) {
        zrnhsys = pZrnhsys;
    }

    private String zrnyobiv3;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }

    private String zrnsrutiwake;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNSRUTIWAKE)
    public String getZrnsrutiwake() {
        return zrnsrutiwake;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrutiwake(String pZrnsrutiwake) {
        zrnsrutiwake = pZrnsrutiwake;
    }

    private String zrnsrkijyunym;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNSRKIJYUNYM)
    public String getZrnsrkijyunym() {
        return zrnsrkijyunym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsrkijyunym(String pZrnsrkijyunym) {
        zrnsrkijyunym = pZrnsrkijyunym;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnseisikiwariatenendohyj;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNSEISIKIWARIATENENDOHYJ)
    public String getZrnseisikiwariatenendohyj() {
        return zrnseisikiwariatenendohyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnseisikiwariatenendohyj(String pZrnseisikiwariatenendohyj) {
        zrnseisikiwariatenendohyj = pZrnseisikiwariatenendohyj;
    }

    private String zrnmankitouraiym;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNMANKITOURAIYM)
    public String getZrnmankitouraiym() {
        return zrnmankitouraiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnmankitouraiym(String pZrnmankitouraiym) {
        zrnmankitouraiym = pZrnmankitouraiym;
    }

    private String zrnsyukeiyakusyuruicdv2;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNSYUKEIYAKUSYURUICDV2)
    public String getZrnsyukeiyakusyuruicdv2() {
        return zrnsyukeiyakusyuruicdv2;
    }

    public void setZrnsyukeiyakusyuruicdv2(String pZrnsyukeiyakusyuruicdv2) {
        zrnsyukeiyakusyuruicdv2 = pZrnsyukeiyakusyuruicdv2;
    }

    private String zrnkeiyakunendo;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNKEIYAKUNENDO)
    public String getZrnkeiyakunendo() {
        return zrnkeiyakunendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkeiyakunendo(String pZrnkeiyakunendo) {
        zrnkeiyakunendo = pZrnkeiyakunendo;
    }

    private BizNumber zrndaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNDAIHYOUYOTEIRIRITU)
    public BizNumber getZrndaihyouyoteiriritu() {
        return zrndaihyouyoteiriritu;
    }

    public void setZrndaihyouyoteiriritu(BizNumber pZrndaihyouyoteiriritu) {
        zrndaihyouyoteiriritu = pZrndaihyouyoteiriritu;
    }

    private String zrnharaikatakbn;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNHARAIKATAKBN)
    public String getZrnharaikatakbn() {
        return zrnharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaikatakbn(String pZrnharaikatakbn) {
        zrnharaikatakbn = pZrnharaikatakbn;
    }

    private String zrnyobiv20;

    @Column(name=GenZT_KariwariateHtkinMeisaiRn.ZRNYOBIV20)
    public String getZrnyobiv20() {
        return zrnyobiv20;
    }

    public void setZrnyobiv20(String pZrnyobiv20) {
        zrnyobiv20 = pZrnyobiv20;
    }
}