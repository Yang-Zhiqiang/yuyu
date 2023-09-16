package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.id.PKZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.meta.GenQZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.meta.QZT_ZitkAzukarikinSrRendouTy;

/**
 * 税適預り金数理連動Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_ZitkAzukarikinSrRendouTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_ZitkAzukarikinSrRendouTy}</td><td colspan="3">税適預り金数理連動Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_ZitkAzukarikinSrRendouTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjynbknkbn ztyjynbknkbn}</td><td>（中継用）準備金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentcd ztykbnkeiriyousegmentcd}</td><td>（中継用）区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytndmatuzndk ztytndmatuzndk}</td><td>（中継用）当年度末残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyoteirisoku ztyyoteirisoku}</td><td>（中継用）予定利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin4 ztysuuriyouyobin4}</td><td>（中継用）数理用予備項目Ｎ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8 ztysuuriyouyobin8}</td><td>（中継用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv93 ztyyobiv93}</td><td>（中継用）予備項目Ｖ９３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytndmatuzndkgaika ztytndmatuzndkgaika}</td><td>（中継用）当年度末残高（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_ZitkAzukarikinSrRendouTy
 * @see     PKZT_ZitkAzukarikinSrRendouTy
 * @see     QZT_ZitkAzukarikinSrRendouTy
 * @see     GenQZT_ZitkAzukarikinSrRendouTy
 */
@MappedSuperclass
@Table(name=GenZT_ZitkAzukarikinSrRendouTy.TABLE_NAME)
@IdClass(value=PKZT_ZitkAzukarikinSrRendouTy.class)
public abstract class GenZT_ZitkAzukarikinSrRendouTy extends AbstractExDBEntity<ZT_ZitkAzukarikinSrRendouTy, PKZT_ZitkAzukarikinSrRendouTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_ZitkAzukarikinSrRendouTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYJYNBKNKBN             = "ztyjynbknkbn";
    public static final String ZTYKBNKEIRIYOUSEGMENTCD  = "ztykbnkeiriyousegmentcd";
    public static final String ZTYTNDMATUZNDK           = "ztytndmatuzndk";
    public static final String ZTYYOTEIRISOKU           = "ztyyoteirisoku";
    public static final String ZTYKEIYAKUNENDO          = "ztykeiyakunendo";
    public static final String ZTYSUURIYOUYOBIN4        = "ztysuuriyouyobin4";
    public static final String ZTYSUURIYOUYOBIN8        = "ztysuuriyouyobin8";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIV93               = "ztyyobiv93";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYTNDMATUZNDKGAIKA      = "ztytndmatuzndkgaika";
    public static final String ZTYYOBIV3                = "ztyyobiv3";

    private final PKZT_ZitkAzukarikinSrRendouTy primaryKey;

    public GenZT_ZitkAzukarikinSrRendouTy() {
        primaryKey = new PKZT_ZitkAzukarikinSrRendouTy();
    }

    public GenZT_ZitkAzukarikinSrRendouTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_ZitkAzukarikinSrRendouTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_ZitkAzukarikinSrRendouTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_ZitkAzukarikinSrRendouTy> getMetaClass() {
        return QZT_ZitkAzukarikinSrRendouTy.class;
    }

    @Id
    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztysyono;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyjynbknkbn;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYJYNBKNKBN)
    public String getZtyjynbknkbn() {
        return ztyjynbknkbn;
    }

    public void setZtyjynbknkbn(String pZtyjynbknkbn) {
        ztyjynbknkbn = pZtyjynbknkbn;
    }

    private String ztykbnkeiriyousegmentcd;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYKBNKEIRIYOUSEGMENTCD)
    public String getZtykbnkeiriyousegmentcd() {
        return ztykbnkeiriyousegmentcd;
    }

    public void setZtykbnkeiriyousegmentcd(String pZtykbnkeiriyousegmentcd) {
        ztykbnkeiriyousegmentcd = pZtykbnkeiriyousegmentcd;
    }

    private Long ztytndmatuzndk;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYTNDMATUZNDK)
    public Long getZtytndmatuzndk() {
        return ztytndmatuzndk;
    }

    public void setZtytndmatuzndk(Long pZtytndmatuzndk) {
        ztytndmatuzndk = pZtytndmatuzndk;
    }

    private Long ztyyoteirisoku;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYYOTEIRISOKU)
    public Long getZtyyoteirisoku() {
        return ztyyoteirisoku;
    }

    public void setZtyyoteirisoku(Long pZtyyoteirisoku) {
        ztyyoteirisoku = pZtyyoteirisoku;
    }

    private String ztykeiyakunendo;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }

    private String ztysuuriyouyobin4;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYSUURIYOUYOBIN4)
    public String getZtysuuriyouyobin4() {
        return ztysuuriyouyobin4;
    }

    public void setZtysuuriyouyobin4(String pZtysuuriyouyobin4) {
        ztysuuriyouyobin4 = pZtysuuriyouyobin4;
    }

    private String ztysuuriyouyobin8;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYSUURIYOUYOBIN8)
    public String getZtysuuriyouyobin8() {
        return ztysuuriyouyobin8;
    }

    public void setZtysuuriyouyobin8(String pZtysuuriyouyobin8) {
        ztysuuriyouyobin8 = pZtysuuriyouyobin8;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private String ztyyobiv93;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYYOBIV93)
    public String getZtyyobiv93() {
        return ztyyobiv93;
    }

    public void setZtyyobiv93(String pZtyyobiv93) {
        ztyyobiv93 = pZtyyobiv93;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private Long ztytndmatuzndkgaika;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYTNDMATUZNDKGAIKA)
    public Long getZtytndmatuzndkgaika() {
        return ztytndmatuzndkgaika;
    }

    public void setZtytndmatuzndkgaika(Long pZtytndmatuzndkgaika) {
        ztytndmatuzndkgaika = pZtytndmatuzndkgaika;
    }

    private String ztyyobiv3;

    @Column(name=GenZT_ZitkAzukarikinSrRendouTy.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }
}