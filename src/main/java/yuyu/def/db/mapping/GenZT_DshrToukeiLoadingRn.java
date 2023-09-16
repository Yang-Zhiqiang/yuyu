package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingRn;
import yuyu.def.db.id.PKZT_DshrToukeiLoadingRn;
import yuyu.def.db.meta.GenQZT_DshrToukeiLoadingRn;
import yuyu.def.db.meta.QZT_DshrToukeiLoadingRn;

/**
 * Ｄ支払統計ローディングＦテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DshrToukeiLoadingRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DshrToukeiLoadingRn}</td><td colspan="3">Ｄ支払統計ローディングＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_DshrToukeiLoadingRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndshrym zrndshrym}</td><td>（連携用）Ｄ支払年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunendo zrnkeiyakunendo}</td><td>（連携用）契約年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaikigetu zrnannaikigetu}</td><td>（連携用）案内期月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyruikbn zrnhknsyruikbn}</td><td>（連携用）保険種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsegcd zrnsegcd}</td><td>（連携用）セグメントコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrriyuukbn zrnshrriyuukbn}</td><td>（連携用）支払理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaikbn zrnannaikbn}</td><td>（連携用）案内区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduketorihouhoukbn zrnduketorihouhoukbn}</td><td>（連携用）Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumetukbn zrnsyoumetukbn}</td><td>（連携用）消滅区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikinhyj zrnbikinhyj}</td><td>（連携用）備金表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskskbn zrnskskbn}</td><td>（連携用）作成区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrkensuu zrnsrkensuu}</td><td>（連携用）数理用件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsrhsys zrnsrhsys}</td><td>（連携用）数理用保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoujigyounendod zrntoujigyounendod}</td><td>（連携用）当事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoujigyounendohasseidrsk zrntoujigyounendohasseidrsk}</td><td>（連携用）当事業年度発生Ｄ利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzenjigyounendomatudzndk zrnzenjigyounendomatudzndk}</td><td>（連携用）前事業年度末Ｄ残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyokujigyounendod zrnyokujigyounendod}</td><td>（連携用）翌事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhushrtoujigyounendod zrnhushrtoujigyounendod}</td><td>（連携用）不支払当事業年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_DshrToukeiLoadingRn
 * @see     PKZT_DshrToukeiLoadingRn
 * @see     QZT_DshrToukeiLoadingRn
 * @see     GenQZT_DshrToukeiLoadingRn
 */
@MappedSuperclass
@Table(name=GenZT_DshrToukeiLoadingRn.TABLE_NAME)
@IdClass(value=PKZT_DshrToukeiLoadingRn.class)
public abstract class GenZT_DshrToukeiLoadingRn extends AbstractExDBEntityForZDB<ZT_DshrToukeiLoadingRn, PKZT_DshrToukeiLoadingRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DshrToukeiLoadingRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNDSHRYM                = "zrndshrym";
    public static final String ZRNKEIYAKUNENDO          = "zrnkeiyakunendo";
    public static final String ZRNANNAIKIGETU           = "zrnannaikigetu";
    public static final String ZRNHKNSYRUIKBN           = "zrnhknsyruikbn";
    public static final String ZRNSEGCD                 = "zrnsegcd";
    public static final String ZRNSHRRIYUUKBN           = "zrnshrriyuukbn";
    public static final String ZRNANNAIKBN              = "zrnannaikbn";
    public static final String ZRNDUKETORIHOUHOUKBN     = "zrnduketorihouhoukbn";
    public static final String ZRNSYOUMETUKBN           = "zrnsyoumetukbn";
    public static final String ZRNBIKINHYJ              = "zrnbikinhyj";
    public static final String ZRNSKSKBN                = "zrnskskbn";
    public static final String ZRNSRKENSUU              = "zrnsrkensuu";
    public static final String ZRNSRHSYS                = "zrnsrhsys";
    public static final String ZRNTOUJIGYOUNENDOD       = "zrntoujigyounendod";
    public static final String ZRNTOUJIGYOUNENDOHASSEIDRSK = "zrntoujigyounendohasseidrsk";
    public static final String ZRNZENJIGYOUNENDOMATUDZNDK = "zrnzenjigyounendomatudzndk";
    public static final String ZRNYOKUJIGYOUNENDOD      = "zrnyokujigyounendod";
    public static final String ZRNHUSHRTOUJIGYOUNENDOD  = "zrnhushrtoujigyounendod";

    private final PKZT_DshrToukeiLoadingRn primaryKey;

    public GenZT_DshrToukeiLoadingRn() {
        primaryKey = new PKZT_DshrToukeiLoadingRn();
    }

    public GenZT_DshrToukeiLoadingRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_DshrToukeiLoadingRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_DshrToukeiLoadingRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DshrToukeiLoadingRn> getMetaClass() {
        return QZT_DshrToukeiLoadingRn.class;
    }

    @Id
    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrndshrym;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNDSHRYM)
    public String getZrndshrym() {
        return zrndshrym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrndshrym(String pZrndshrym) {
        zrndshrym = pZrndshrym;
    }

    private String zrnkeiyakunendo;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNKEIYAKUNENDO)
    public String getZrnkeiyakunendo() {
        return zrnkeiyakunendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkeiyakunendo(String pZrnkeiyakunendo) {
        zrnkeiyakunendo = pZrnkeiyakunendo;
    }

    private String zrnannaikigetu;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNANNAIKIGETU)
    public String getZrnannaikigetu() {
        return zrnannaikigetu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnannaikigetu(String pZrnannaikigetu) {
        zrnannaikigetu = pZrnannaikigetu;
    }

    private String zrnhknsyruikbn;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNHKNSYRUIKBN)
    public String getZrnhknsyruikbn() {
        return zrnhknsyruikbn;
    }

    public void setZrnhknsyruikbn(String pZrnhknsyruikbn) {
        zrnhknsyruikbn = pZrnhknsyruikbn;
    }

    private String zrnsegcd;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNSEGCD)
    public String getZrnsegcd() {
        return zrnsegcd;
    }

    public void setZrnsegcd(String pZrnsegcd) {
        zrnsegcd = pZrnsegcd;
    }

    private String zrnshrriyuukbn;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNSHRRIYUUKBN)
    public String getZrnshrriyuukbn() {
        return zrnshrriyuukbn;
    }

    public void setZrnshrriyuukbn(String pZrnshrriyuukbn) {
        zrnshrriyuukbn = pZrnshrriyuukbn;
    }

    private String zrnannaikbn;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNANNAIKBN)
    public String getZrnannaikbn() {
        return zrnannaikbn;
    }

    public void setZrnannaikbn(String pZrnannaikbn) {
        zrnannaikbn = pZrnannaikbn;
    }

    private String zrnduketorihouhoukbn;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNDUKETORIHOUHOUKBN)
    public String getZrnduketorihouhoukbn() {
        return zrnduketorihouhoukbn;
    }

    public void setZrnduketorihouhoukbn(String pZrnduketorihouhoukbn) {
        zrnduketorihouhoukbn = pZrnduketorihouhoukbn;
    }

    private String zrnsyoumetukbn;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNSYOUMETUKBN)
    public String getZrnsyoumetukbn() {
        return zrnsyoumetukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyoumetukbn(String pZrnsyoumetukbn) {
        zrnsyoumetukbn = pZrnsyoumetukbn;
    }

    private String zrnbikinhyj;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNBIKINHYJ)
    public String getZrnbikinhyj() {
        return zrnbikinhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbikinhyj(String pZrnbikinhyj) {
        zrnbikinhyj = pZrnbikinhyj;
    }

    private String zrnskskbn;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNSKSKBN)
    public String getZrnskskbn() {
        return zrnskskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnskskbn(String pZrnskskbn) {
        zrnskskbn = pZrnskskbn;
    }

    private Integer zrnsrkensuu;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNSRKENSUU)
    public Integer getZrnsrkensuu() {
        return zrnsrkensuu;
    }

    public void setZrnsrkensuu(Integer pZrnsrkensuu) {
        zrnsrkensuu = pZrnsrkensuu;
    }

    private Long zrnsrhsys;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNSRHSYS)
    public Long getZrnsrhsys() {
        return zrnsrhsys;
    }

    public void setZrnsrhsys(Long pZrnsrhsys) {
        zrnsrhsys = pZrnsrhsys;
    }

    private Long zrntoujigyounendod;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNTOUJIGYOUNENDOD)
    public Long getZrntoujigyounendod() {
        return zrntoujigyounendod;
    }

    public void setZrntoujigyounendod(Long pZrntoujigyounendod) {
        zrntoujigyounendod = pZrntoujigyounendod;
    }

    private Long zrntoujigyounendohasseidrsk;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNTOUJIGYOUNENDOHASSEIDRSK)
    public Long getZrntoujigyounendohasseidrsk() {
        return zrntoujigyounendohasseidrsk;
    }

    public void setZrntoujigyounendohasseidrsk(Long pZrntoujigyounendohasseidrsk) {
        zrntoujigyounendohasseidrsk = pZrntoujigyounendohasseidrsk;
    }

    private Long zrnzenjigyounendomatudzndk;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNZENJIGYOUNENDOMATUDZNDK)
    public Long getZrnzenjigyounendomatudzndk() {
        return zrnzenjigyounendomatudzndk;
    }

    public void setZrnzenjigyounendomatudzndk(Long pZrnzenjigyounendomatudzndk) {
        zrnzenjigyounendomatudzndk = pZrnzenjigyounendomatudzndk;
    }

    private Long zrnyokujigyounendod;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNYOKUJIGYOUNENDOD)
    public Long getZrnyokujigyounendod() {
        return zrnyokujigyounendod;
    }

    public void setZrnyokujigyounendod(Long pZrnyokujigyounendod) {
        zrnyokujigyounendod = pZrnyokujigyounendod;
    }

    private Long zrnhushrtoujigyounendod;

    @Column(name=GenZT_DshrToukeiLoadingRn.ZRNHUSHRTOUJIGYOUNENDOD)
    public Long getZrnhushrtoujigyounendod() {
        return zrnhushrtoujigyounendod;
    }

    public void setZrnhushrtoujigyounendod(Long pZrnhushrtoujigyounendod) {
        zrnhushrtoujigyounendod = pZrnhushrtoujigyounendod;
    }
}