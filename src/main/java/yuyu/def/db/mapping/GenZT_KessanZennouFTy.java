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
import yuyu.def.db.entity.ZT_KessanZennouFTy;
import yuyu.def.db.id.PKZT_KessanZennouFTy;
import yuyu.def.db.meta.GenQZT_KessanZennouFTy;
import yuyu.def.db.meta.QZT_KessanZennouFTy;

/**
 * 決算用前納Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KessanZennouFTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KessanZennouFTy}</td><td colspan="3">決算用前納Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KessanZennouFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentcd ztykbnkeiriyousegmentcd}</td><td>（中継用）区分経理用セグメントコード</td><td align="center">{@link PKZT_KessanZennouFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoutoukeilistkbn ztyzennoutoukeilistkbn}</td><td>（中継用）前納統計リスト区分</td><td align="center">{@link PKZT_KessanZennouFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukbn ztyzennoukbn}</td><td>（中継用）前納区分</td><td align="center">{@link PKZT_KessanZennouFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukaisiymd ztyzennoukaisiymd}</td><td>（中継用）前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukaisijizndk ztyzennoukaisijizndk}</td><td>（中継用）前納開始時残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouwrbkrt ztyzennouwrbkrt}</td><td>（中継用）前納割引率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrthndzndk1 ztyrthndzndk1}</td><td>（中継用）利率変動時残高１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkyrt1 ztytkyrt1}</td><td>（中継用）適用利率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrthndymd1 ztyrthndymd1}</td><td>（中継用）利率変動年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrthndzndk2 ztyrthndzndk2}</td><td>（中継用）利率変動時残高２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkyrt2 ztytkyrt2}</td><td>（中継用）適用利率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrthndymd2 ztyrthndymd2}</td><td>（中継用）利率変動年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrthndzndk3 ztyrthndzndk3}</td><td>（中継用）利率変動時残高３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkyrt3 ztytkyrt3}</td><td>（中継用）適用利率３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrthndymd3 ztyrthndymd3}</td><td>（中継用）利率変動年月日３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrthndzndk4 ztyrthndzndk4}</td><td>（中継用）利率変動時残高４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkyrt4 ztytkyrt4}</td><td>（中継用）適用利率４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrthndymd4 ztyrthndymd4}</td><td>（中継用）利率変動年月日４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytndmatuzndk ztytndmatuzndk}</td><td>（中継用）当年度末残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytndmatutkyrt ztytndmatutkyrt}</td><td>（中継用）当年度末適用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzennounyuukinymd ztyzennounyuukinymd}</td><td>（中継用）前納入金年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytndzndkhikakukbn ztytndzndkhikakukbn}</td><td>（中継用）当年度残高比較区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukikan ztyzennoukikan}</td><td>（中継用）前納期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobi01xv1 ztyyobi01xv1}</td><td>（中継用）予備０１＿Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeitaikbn ztybosyuukeitaikbn}</td><td>（中継用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobi02xv11 ztyyobi02xv11}</td><td>（中継用）予備０２＿Ｖ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygkdtznnhyj ztygkdtznnhyj}</td><td>（中継用）外貨建前納表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenkanyknhyj ztyyenkanyknhyj}</td><td>（中継用）円貨入金表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknjikawaserate ztynyknjikawaserate}</td><td>（中継用）入金時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtynyknjikawaseratetkyuymd ztynyknjikawaseratetkyuymd}</td><td>（中継用）入金時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyksnkisikawaserate ztyksnkisikawaserate}</td><td>（中継用）決算期始為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytndmatuzndkksnjkwsrate ztytndmatuzndkksnjkwsrate}</td><td>（中継用）当年度末残高計算時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzennounyuukinkgkgaika ztyzennounyuukinkgkgaika}</td><td>（中継用）前納入金額＿外貨</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennounyuukinkgktkmatu ztyzennounyuukinkgktkmatu}</td><td>（中継用）前納入金額＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennoukaisijizndktkmatu ztyzennoukaisijizndktkmatu}</td><td>（中継用）前納開始時残高＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrthndzndk1tkmatu ztyrthndzndk1tkmatu}</td><td>（中継用）利率変動時残高１＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrthndzndk2tkmatu ztyrthndzndk2tkmatu}</td><td>（中継用）利率変動時残高２＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrthndzndk3tkmatu ztyrthndzndk3tkmatu}</td><td>（中継用）利率変動時残高３＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrthndzndk4tkmatu ztyrthndzndk4tkmatu}</td><td>（中継用）利率変動時残高４＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytndmatuzndktkmatu ztytndmatuzndktkmatu}</td><td>（中継用）当年度末残高＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv22 ztyyobiv22}</td><td>（中継用）予備項目Ｖ２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KessanZennouFTy
 * @see     PKZT_KessanZennouFTy
 * @see     QZT_KessanZennouFTy
 * @see     GenQZT_KessanZennouFTy
 */
@MappedSuperclass
@Table(name=GenZT_KessanZennouFTy.TABLE_NAME)
@IdClass(value=PKZT_KessanZennouFTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KessanZennouFTy extends AbstractExDBEntity<ZT_KessanZennouFTy, PKZT_KessanZennouFTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KessanZennouFTy";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYKBNKEIRIYOUSEGMENTCD  = "ztykbnkeiriyousegmentcd";
    public static final String ZTYZENNOUTOUKEILISTKBN   = "ztyzennoutoukeilistkbn";
    public static final String ZTYZENNOUKBN             = "ztyzennoukbn";
    public static final String ZTYZENNOUKAISIYMD        = "ztyzennoukaisiymd";
    public static final String ZTYZENNOUKAISIJIZNDK     = "ztyzennoukaisijizndk";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYZENNOUWRBKRT          = "ztyzennouwrbkrt";
    public static final String ZTYRTHNDZNDK1            = "ztyrthndzndk1";
    public static final String ZTYTKYRT1                = "ztytkyrt1";
    public static final String ZTYRTHNDYMD1             = "ztyrthndymd1";
    public static final String ZTYRTHNDZNDK2            = "ztyrthndzndk2";
    public static final String ZTYTKYRT2                = "ztytkyrt2";
    public static final String ZTYRTHNDYMD2             = "ztyrthndymd2";
    public static final String ZTYRTHNDZNDK3            = "ztyrthndzndk3";
    public static final String ZTYTKYRT3                = "ztytkyrt3";
    public static final String ZTYRTHNDYMD3             = "ztyrthndymd3";
    public static final String ZTYRTHNDZNDK4            = "ztyrthndzndk4";
    public static final String ZTYTKYRT4                = "ztytkyrt4";
    public static final String ZTYRTHNDYMD4             = "ztyrthndymd4";
    public static final String ZTYTNDMATUZNDK           = "ztytndmatuzndk";
    public static final String ZTYTNDMATUTKYRT          = "ztytndmatutkyrt";
    public static final String ZTYZENNOUNYUUKINYMD      = "ztyzennounyuukinymd";
    public static final String ZTYTNDZNDKHIKAKUKBN      = "ztytndzndkhikakukbn";
    public static final String ZTYZENNOUKIKAN           = "ztyzennoukikan";
    public static final String ZTYYOBI01XV1             = "ztyyobi01xv1";
    public static final String ZTYBOSYUUKEITAIKBN       = "ztybosyuukeitaikbn";
    public static final String ZTYYOBI02XV11            = "ztyyobi02xv11";
    public static final String ZTYGKDTZNNHYJ            = "ztygkdtznnhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYYENKANYKNHYJ          = "ztyyenkanyknhyj";
    public static final String ZTYNYKNJIKAWASERATE      = "ztynyknjikawaserate";
    public static final String ZTYNYKNJIKAWASERATETKYUYMD = "ztynyknjikawaseratetkyuymd";
    public static final String ZTYKSNKISIKAWASERATE     = "ztyksnkisikawaserate";
    public static final String ZTYTNDMATUZNDKKSNJKWSRATE = "ztytndmatuzndkksnjkwsrate";
    public static final String ZTYZENNOUNYUUKINKGKGAIKA = "ztyzennounyuukinkgkgaika";
    public static final String ZTYZENNOUNYUUKINKGKTKMATU = "ztyzennounyuukinkgktkmatu";
    public static final String ZTYZENNOUKAISIJIZNDKTKMATU = "ztyzennoukaisijizndktkmatu";
    public static final String ZTYRTHNDZNDK1TKMATU      = "ztyrthndzndk1tkmatu";
    public static final String ZTYRTHNDZNDK2TKMATU      = "ztyrthndzndk2tkmatu";
    public static final String ZTYRTHNDZNDK3TKMATU      = "ztyrthndzndk3tkmatu";
    public static final String ZTYRTHNDZNDK4TKMATU      = "ztyrthndzndk4tkmatu";
    public static final String ZTYTNDMATUZNDKTKMATU     = "ztytndmatuzndktkmatu";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYYOBIV22               = "ztyyobiv22";

    private final PKZT_KessanZennouFTy primaryKey;

    public GenZT_KessanZennouFTy() {
        primaryKey = new PKZT_KessanZennouFTy();
    }

    public GenZT_KessanZennouFTy(
        String pZtysyono,
        String pZtykbnkeiriyousegmentcd,
        String pZtyzennoutoukeilistkbn,
        String pZtyzennoukbn
    ) {
        primaryKey = new PKZT_KessanZennouFTy(
            pZtysyono,
            pZtykbnkeiriyousegmentcd,
            pZtyzennoutoukeilistkbn,
            pZtyzennoukbn
        );
    }

    @Transient
    @Override
    public PKZT_KessanZennouFTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KessanZennouFTy> getMetaClass() {
        return QZT_KessanZennouFTy.class;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_KessanZennouFTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztyyobiv9;

    @Column(name=GenZT_KessanZennouFTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    @Id
    @Column(name=GenZT_KessanZennouFTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_KessanZennouFTy.ZTYKBNKEIRIYOUSEGMENTCD)
    public String getZtykbnkeiriyousegmentcd() {
        return getPrimaryKey().getZtykbnkeiriyousegmentcd();
    }

    public void setZtykbnkeiriyousegmentcd(String pZtykbnkeiriyousegmentcd) {
        getPrimaryKey().setZtykbnkeiriyousegmentcd(pZtykbnkeiriyousegmentcd);
    }

    @Id
    @Column(name=GenZT_KessanZennouFTy.ZTYZENNOUTOUKEILISTKBN)
    public String getZtyzennoutoukeilistkbn() {
        return getPrimaryKey().getZtyzennoutoukeilistkbn();
    }

    public void setZtyzennoutoukeilistkbn(String pZtyzennoutoukeilistkbn) {
        getPrimaryKey().setZtyzennoutoukeilistkbn(pZtyzennoutoukeilistkbn);
    }

    @Id
    @Column(name=GenZT_KessanZennouFTy.ZTYZENNOUKBN)
    public String getZtyzennoukbn() {
        return getPrimaryKey().getZtyzennoukbn();
    }

    public void setZtyzennoukbn(String pZtyzennoukbn) {
        getPrimaryKey().setZtyzennoukbn(pZtyzennoukbn);
    }

    private String ztyzennoukaisiymd;

    @Column(name=GenZT_KessanZennouFTy.ZTYZENNOUKAISIYMD)
    public String getZtyzennoukaisiymd() {
        return ztyzennoukaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyzennoukaisiymd(String pZtyzennoukaisiymd) {
        ztyzennoukaisiymd = pZtyzennoukaisiymd;
    }

    private Long ztyzennoukaisijizndk;

    @Column(name=GenZT_KessanZennouFTy.ZTYZENNOUKAISIJIZNDK)
    public Long getZtyzennoukaisijizndk() {
        return ztyzennoukaisijizndk;
    }

    public void setZtyzennoukaisijizndk(Long pZtyzennoukaisijizndk) {
        ztyzennoukaisijizndk = pZtyzennoukaisijizndk;
    }

    private String ztykykymd;

    @Column(name=GenZT_KessanZennouFTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private BizNumber ztyzennouwrbkrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFTy.ZTYZENNOUWRBKRT)
    public BizNumber getZtyzennouwrbkrt() {
        return ztyzennouwrbkrt;
    }

    public void setZtyzennouwrbkrt(BizNumber pZtyzennouwrbkrt) {
        ztyzennouwrbkrt = pZtyzennouwrbkrt;
    }

    private Long ztyrthndzndk1;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDZNDK1)
    public Long getZtyrthndzndk1() {
        return ztyrthndzndk1;
    }

    public void setZtyrthndzndk1(Long pZtyrthndzndk1) {
        ztyrthndzndk1 = pZtyrthndzndk1;
    }

    private BizNumber ztytkyrt1;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFTy.ZTYTKYRT1)
    public BizNumber getZtytkyrt1() {
        return ztytkyrt1;
    }

    public void setZtytkyrt1(BizNumber pZtytkyrt1) {
        ztytkyrt1 = pZtytkyrt1;
    }

    private String ztyrthndymd1;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDYMD1)
    public String getZtyrthndymd1() {
        return ztyrthndymd1;
    }

    public void setZtyrthndymd1(String pZtyrthndymd1) {
        ztyrthndymd1 = pZtyrthndymd1;
    }

    private Long ztyrthndzndk2;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDZNDK2)
    public Long getZtyrthndzndk2() {
        return ztyrthndzndk2;
    }

    public void setZtyrthndzndk2(Long pZtyrthndzndk2) {
        ztyrthndzndk2 = pZtyrthndzndk2;
    }

    private BizNumber ztytkyrt2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFTy.ZTYTKYRT2)
    public BizNumber getZtytkyrt2() {
        return ztytkyrt2;
    }

    public void setZtytkyrt2(BizNumber pZtytkyrt2) {
        ztytkyrt2 = pZtytkyrt2;
    }

    private String ztyrthndymd2;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDYMD2)
    public String getZtyrthndymd2() {
        return ztyrthndymd2;
    }

    public void setZtyrthndymd2(String pZtyrthndymd2) {
        ztyrthndymd2 = pZtyrthndymd2;
    }

    private Long ztyrthndzndk3;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDZNDK3)
    public Long getZtyrthndzndk3() {
        return ztyrthndzndk3;
    }

    public void setZtyrthndzndk3(Long pZtyrthndzndk3) {
        ztyrthndzndk3 = pZtyrthndzndk3;
    }

    private BizNumber ztytkyrt3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFTy.ZTYTKYRT3)
    public BizNumber getZtytkyrt3() {
        return ztytkyrt3;
    }

    public void setZtytkyrt3(BizNumber pZtytkyrt3) {
        ztytkyrt3 = pZtytkyrt3;
    }

    private String ztyrthndymd3;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDYMD3)
    public String getZtyrthndymd3() {
        return ztyrthndymd3;
    }

    public void setZtyrthndymd3(String pZtyrthndymd3) {
        ztyrthndymd3 = pZtyrthndymd3;
    }

    private Long ztyrthndzndk4;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDZNDK4)
    public Long getZtyrthndzndk4() {
        return ztyrthndzndk4;
    }

    public void setZtyrthndzndk4(Long pZtyrthndzndk4) {
        ztyrthndzndk4 = pZtyrthndzndk4;
    }

    private BizNumber ztytkyrt4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFTy.ZTYTKYRT4)
    public BizNumber getZtytkyrt4() {
        return ztytkyrt4;
    }

    public void setZtytkyrt4(BizNumber pZtytkyrt4) {
        ztytkyrt4 = pZtytkyrt4;
    }

    private String ztyrthndymd4;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDYMD4)
    public String getZtyrthndymd4() {
        return ztyrthndymd4;
    }

    public void setZtyrthndymd4(String pZtyrthndymd4) {
        ztyrthndymd4 = pZtyrthndymd4;
    }

    private Long ztytndmatuzndk;

    @Column(name=GenZT_KessanZennouFTy.ZTYTNDMATUZNDK)
    public Long getZtytndmatuzndk() {
        return ztytndmatuzndk;
    }

    public void setZtytndmatuzndk(Long pZtytndmatuzndk) {
        ztytndmatuzndk = pZtytndmatuzndk;
    }

    private BizNumber ztytndmatutkyrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFTy.ZTYTNDMATUTKYRT)
    public BizNumber getZtytndmatutkyrt() {
        return ztytndmatutkyrt;
    }

    public void setZtytndmatutkyrt(BizNumber pZtytndmatutkyrt) {
        ztytndmatutkyrt = pZtytndmatutkyrt;
    }

    private String ztyzennounyuukinymd;

    @Column(name=GenZT_KessanZennouFTy.ZTYZENNOUNYUUKINYMD)
    public String getZtyzennounyuukinymd() {
        return ztyzennounyuukinymd;
    }

    public void setZtyzennounyuukinymd(String pZtyzennounyuukinymd) {
        ztyzennounyuukinymd = pZtyzennounyuukinymd;
    }

    private String ztytndzndkhikakukbn;

    @Column(name=GenZT_KessanZennouFTy.ZTYTNDZNDKHIKAKUKBN)
    public String getZtytndzndkhikakukbn() {
        return ztytndzndkhikakukbn;
    }

    public void setZtytndzndkhikakukbn(String pZtytndzndkhikakukbn) {
        ztytndzndkhikakukbn = pZtytndzndkhikakukbn;
    }

    private String ztyzennoukikan;

    @Column(name=GenZT_KessanZennouFTy.ZTYZENNOUKIKAN)
    public String getZtyzennoukikan() {
        return ztyzennoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyzennoukikan(String pZtyzennoukikan) {
        ztyzennoukikan = pZtyzennoukikan;
    }

    private String ztyyobi01xv1;

    @Column(name=GenZT_KessanZennouFTy.ZTYYOBI01XV1)
    public String getZtyyobi01xv1() {
        return ztyyobi01xv1;
    }

    public void setZtyyobi01xv1(String pZtyyobi01xv1) {
        ztyyobi01xv1 = pZtyyobi01xv1;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenZT_KessanZennouFTy.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztyyobi02xv11;

    @Column(name=GenZT_KessanZennouFTy.ZTYYOBI02XV11)
    public String getZtyyobi02xv11() {
        return ztyyobi02xv11;
    }

    public void setZtyyobi02xv11(String pZtyyobi02xv11) {
        ztyyobi02xv11 = pZtyyobi02xv11;
    }

    private String ztygkdtznnhyj;

    @Column(name=GenZT_KessanZennouFTy.ZTYGKDTZNNHYJ)
    public String getZtygkdtznnhyj() {
        return ztygkdtznnhyj;
    }

    public void setZtygkdtznnhyj(String pZtygkdtznnhyj) {
        ztygkdtznnhyj = pZtygkdtznnhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_KessanZennouFTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private String ztyyenkanyknhyj;

    @Column(name=GenZT_KessanZennouFTy.ZTYYENKANYKNHYJ)
    public String getZtyyenkanyknhyj() {
        return ztyyenkanyknhyj;
    }

    public void setZtyyenkanyknhyj(String pZtyyenkanyknhyj) {
        ztyyenkanyknhyj = pZtyyenkanyknhyj;
    }

    private BizNumber ztynyknjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFTy.ZTYNYKNJIKAWASERATE)
    public BizNumber getZtynyknjikawaserate() {
        return ztynyknjikawaserate;
    }

    public void setZtynyknjikawaserate(BizNumber pZtynyknjikawaserate) {
        ztynyknjikawaserate = pZtynyknjikawaserate;
    }

    private String ztynyknjikawaseratetkyuymd;

    @Column(name=GenZT_KessanZennouFTy.ZTYNYKNJIKAWASERATETKYUYMD)
    public String getZtynyknjikawaseratetkyuymd() {
        return ztynyknjikawaseratetkyuymd;
    }

    public void setZtynyknjikawaseratetkyuymd(String pZtynyknjikawaseratetkyuymd) {
        ztynyknjikawaseratetkyuymd = pZtynyknjikawaseratetkyuymd;
    }

    private BizNumber ztyksnkisikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFTy.ZTYKSNKISIKAWASERATE)
    public BizNumber getZtyksnkisikawaserate() {
        return ztyksnkisikawaserate;
    }

    public void setZtyksnkisikawaserate(BizNumber pZtyksnkisikawaserate) {
        ztyksnkisikawaserate = pZtyksnkisikawaserate;
    }

    private BizNumber ztytndmatuzndkksnjkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFTy.ZTYTNDMATUZNDKKSNJKWSRATE)
    public BizNumber getZtytndmatuzndkksnjkwsrate() {
        return ztytndmatuzndkksnjkwsrate;
    }

    public void setZtytndmatuzndkksnjkwsrate(BizNumber pZtytndmatuzndkksnjkwsrate) {
        ztytndmatuzndkksnjkwsrate = pZtytndmatuzndkksnjkwsrate;
    }

    private Long ztyzennounyuukinkgkgaika;

    @Column(name=GenZT_KessanZennouFTy.ZTYZENNOUNYUUKINKGKGAIKA)
    public Long getZtyzennounyuukinkgkgaika() {
        return ztyzennounyuukinkgkgaika;
    }

    public void setZtyzennounyuukinkgkgaika(Long pZtyzennounyuukinkgkgaika) {
        ztyzennounyuukinkgkgaika = pZtyzennounyuukinkgkgaika;
    }

    private Long ztyzennounyuukinkgktkmatu;

    @Column(name=GenZT_KessanZennouFTy.ZTYZENNOUNYUUKINKGKTKMATU)
    public Long getZtyzennounyuukinkgktkmatu() {
        return ztyzennounyuukinkgktkmatu;
    }

    public void setZtyzennounyuukinkgktkmatu(Long pZtyzennounyuukinkgktkmatu) {
        ztyzennounyuukinkgktkmatu = pZtyzennounyuukinkgktkmatu;
    }

    private Long ztyzennoukaisijizndktkmatu;

    @Column(name=GenZT_KessanZennouFTy.ZTYZENNOUKAISIJIZNDKTKMATU)
    public Long getZtyzennoukaisijizndktkmatu() {
        return ztyzennoukaisijizndktkmatu;
    }

    public void setZtyzennoukaisijizndktkmatu(Long pZtyzennoukaisijizndktkmatu) {
        ztyzennoukaisijizndktkmatu = pZtyzennoukaisijizndktkmatu;
    }

    private Long ztyrthndzndk1tkmatu;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDZNDK1TKMATU)
    public Long getZtyrthndzndk1tkmatu() {
        return ztyrthndzndk1tkmatu;
    }

    public void setZtyrthndzndk1tkmatu(Long pZtyrthndzndk1tkmatu) {
        ztyrthndzndk1tkmatu = pZtyrthndzndk1tkmatu;
    }

    private Long ztyrthndzndk2tkmatu;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDZNDK2TKMATU)
    public Long getZtyrthndzndk2tkmatu() {
        return ztyrthndzndk2tkmatu;
    }

    public void setZtyrthndzndk2tkmatu(Long pZtyrthndzndk2tkmatu) {
        ztyrthndzndk2tkmatu = pZtyrthndzndk2tkmatu;
    }

    private Long ztyrthndzndk3tkmatu;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDZNDK3TKMATU)
    public Long getZtyrthndzndk3tkmatu() {
        return ztyrthndzndk3tkmatu;
    }

    public void setZtyrthndzndk3tkmatu(Long pZtyrthndzndk3tkmatu) {
        ztyrthndzndk3tkmatu = pZtyrthndzndk3tkmatu;
    }

    private Long ztyrthndzndk4tkmatu;

    @Column(name=GenZT_KessanZennouFTy.ZTYRTHNDZNDK4TKMATU)
    public Long getZtyrthndzndk4tkmatu() {
        return ztyrthndzndk4tkmatu;
    }

    public void setZtyrthndzndk4tkmatu(Long pZtyrthndzndk4tkmatu) {
        ztyrthndzndk4tkmatu = pZtyrthndzndk4tkmatu;
    }

    private Long ztytndmatuzndktkmatu;

    @Column(name=GenZT_KessanZennouFTy.ZTYTNDMATUZNDKTKMATU)
    public Long getZtytndmatuzndktkmatu() {
        return ztytndmatuzndktkmatu;
    }

    public void setZtytndmatuzndktkmatu(Long pZtytndmatuzndktkmatu) {
        ztytndmatuzndktkmatu = pZtytndmatuzndktkmatu;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_KessanZennouFTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_KessanZennouFTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_KessanZennouFTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_KessanZennouFTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private String ztyyobiv22;

    @Column(name=GenZT_KessanZennouFTy.ZTYYOBIV22)
    public String getZtyyobiv22() {
        return ztyyobiv22;
    }

    public void setZtyyobiv22(String pZtyyobiv22) {
        ztyyobiv22 = pZtyyobiv22;
    }
}