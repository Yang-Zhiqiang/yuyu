package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.id.PKZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.meta.GenQZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.meta.QZT_ZitkAzukarikinSrRendouRn;

/**
 * 税適預り金数理連動Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_ZitkAzukarikinSrRendouRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_ZitkAzukarikinSrRendouRn}</td><td colspan="3">税適預り金数理連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_ZitkAzukarikinSrRendouRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjynbknkbn zrnjynbknkbn}</td><td>（連携用）準備金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentcd zrnkbnkeiriyousegmentcd}</td><td>（連携用）区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntndmatuzndk zrntndmatuzndk}</td><td>（連携用）当年度末残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyoteirisoku zrnyoteirisoku}</td><td>（連携用）予定利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunendo zrnkeiyakunendo}</td><td>（連携用）契約年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin4 zrnsuuriyouyobin4}</td><td>（連携用）数理用予備項目Ｎ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8 zrnsuuriyouyobin8}</td><td>（連携用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv93 zrnyobiv93}</td><td>（連携用）予備項目Ｖ９３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntndmatuzndkgaika zrntndmatuzndkgaika}</td><td>（連携用）当年度末残高（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_ZitkAzukarikinSrRendouRn
 * @see     PKZT_ZitkAzukarikinSrRendouRn
 * @see     QZT_ZitkAzukarikinSrRendouRn
 * @see     GenQZT_ZitkAzukarikinSrRendouRn
 */
@MappedSuperclass
@Table(name=GenZT_ZitkAzukarikinSrRendouRn.TABLE_NAME)
@IdClass(value=PKZT_ZitkAzukarikinSrRendouRn.class)
public abstract class GenZT_ZitkAzukarikinSrRendouRn extends AbstractExDBEntityForZDB<ZT_ZitkAzukarikinSrRendouRn, PKZT_ZitkAzukarikinSrRendouRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_ZitkAzukarikinSrRendouRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNJYNBKNKBN             = "zrnjynbknkbn";
    public static final String ZRNKBNKEIRIYOUSEGMENTCD  = "zrnkbnkeiriyousegmentcd";
    public static final String ZRNTNDMATUZNDK           = "zrntndmatuzndk";
    public static final String ZRNYOTEIRISOKU           = "zrnyoteirisoku";
    public static final String ZRNKEIYAKUNENDO          = "zrnkeiyakunendo";
    public static final String ZRNSUURIYOUYOBIN4        = "zrnsuuriyouyobin4";
    public static final String ZRNSUURIYOUYOBIN8        = "zrnsuuriyouyobin8";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIV93               = "zrnyobiv93";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNTNDMATUZNDKGAIKA      = "zrntndmatuzndkgaika";
    public static final String ZRNYOBIV3                = "zrnyobiv3";

    private final PKZT_ZitkAzukarikinSrRendouRn primaryKey;

    public GenZT_ZitkAzukarikinSrRendouRn() {
        primaryKey = new PKZT_ZitkAzukarikinSrRendouRn();
    }

    public GenZT_ZitkAzukarikinSrRendouRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_ZitkAzukarikinSrRendouRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_ZitkAzukarikinSrRendouRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_ZitkAzukarikinSrRendouRn> getMetaClass() {
        return QZT_ZitkAzukarikinSrRendouRn.class;
    }

    @Id
    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrnsyono;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnjynbknkbn;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNJYNBKNKBN)
    public String getZrnjynbknkbn() {
        return zrnjynbknkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjynbknkbn(String pZrnjynbknkbn) {
        zrnjynbknkbn = pZrnjynbknkbn;
    }

    private String zrnkbnkeiriyousegmentcd;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNKBNKEIRIYOUSEGMENTCD)
    public String getZrnkbnkeiriyousegmentcd() {
        return zrnkbnkeiriyousegmentcd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkbnkeiriyousegmentcd(String pZrnkbnkeiriyousegmentcd) {
        zrnkbnkeiriyousegmentcd = pZrnkbnkeiriyousegmentcd;
    }

    private Long zrntndmatuzndk;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNTNDMATUZNDK)
    public Long getZrntndmatuzndk() {
        return zrntndmatuzndk;
    }

    public void setZrntndmatuzndk(Long pZrntndmatuzndk) {
        zrntndmatuzndk = pZrntndmatuzndk;
    }

    private Long zrnyoteirisoku;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNYOTEIRISOKU)
    public Long getZrnyoteirisoku() {
        return zrnyoteirisoku;
    }

    public void setZrnyoteirisoku(Long pZrnyoteirisoku) {
        zrnyoteirisoku = pZrnyoteirisoku;
    }

    private String zrnkeiyakunendo;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNKEIYAKUNENDO)
    public String getZrnkeiyakunendo() {
        return zrnkeiyakunendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkeiyakunendo(String pZrnkeiyakunendo) {
        zrnkeiyakunendo = pZrnkeiyakunendo;
    }

    private String zrnsuuriyouyobin4;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNSUURIYOUYOBIN4)
    public String getZrnsuuriyouyobin4() {
        return zrnsuuriyouyobin4;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsuuriyouyobin4(String pZrnsuuriyouyobin4) {
        zrnsuuriyouyobin4 = pZrnsuuriyouyobin4;
    }

    private String zrnsuuriyouyobin8;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNSUURIYOUYOBIN8)
    public String getZrnsuuriyouyobin8() {
        return zrnsuuriyouyobin8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8(String pZrnsuuriyouyobin8) {
        zrnsuuriyouyobin8 = pZrnsuuriyouyobin8;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private String zrnyobiv93;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNYOBIV93)
    public String getZrnyobiv93() {
        return zrnyobiv93;
    }

    public void setZrnyobiv93(String pZrnyobiv93) {
        zrnyobiv93 = pZrnyobiv93;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private Long zrntndmatuzndkgaika;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNTNDMATUZNDKGAIKA)
    public Long getZrntndmatuzndkgaika() {
        return zrntndmatuzndkgaika;
    }

    public void setZrntndmatuzndkgaika(Long pZrntndmatuzndkgaika) {
        zrntndmatuzndkgaika = pZrntndmatuzndkgaika;
    }

    private String zrnyobiv3;

    @Column(name=GenZT_ZitkAzukarikinSrRendouRn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }
}