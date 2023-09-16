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
import yuyu.def.db.entity.ZT_KessanZennouFRn;
import yuyu.def.db.id.PKZT_KessanZennouFRn;
import yuyu.def.db.meta.GenQZT_KessanZennouFRn;
import yuyu.def.db.meta.QZT_KessanZennouFRn;

/**
 * 決算用前納Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KessanZennouFRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KessanZennouFRn}</td><td colspan="3">決算用前納Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KessanZennouFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentcd zrnkbnkeiriyousegmentcd}</td><td>（連携用）区分経理用セグメントコード</td><td align="center">{@link PKZT_KessanZennouFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoutoukeilistkbn zrnzennoutoukeilistkbn}</td><td>（連携用）前納統計リスト区分</td><td align="center">{@link PKZT_KessanZennouFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukbn zrnzennoukbn}</td><td>（連携用）前納区分</td><td align="center">{@link PKZT_KessanZennouFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukaisiymd zrnzennoukaisiymd}</td><td>（連携用）前納開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukaisijizndk zrnzennoukaisijizndk}</td><td>（連携用）前納開始時残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouwrbkrt zrnzennouwrbkrt}</td><td>（連携用）前納割引率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrthndzndk1 zrnrthndzndk1}</td><td>（連携用）利率変動時残高１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkyrt1 zrntkyrt1}</td><td>（連携用）適用利率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrthndymd1 zrnrthndymd1}</td><td>（連携用）利率変動年月日１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrthndzndk2 zrnrthndzndk2}</td><td>（連携用）利率変動時残高２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkyrt2 zrntkyrt2}</td><td>（連携用）適用利率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrthndymd2 zrnrthndymd2}</td><td>（連携用）利率変動年月日２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrthndzndk3 zrnrthndzndk3}</td><td>（連携用）利率変動時残高３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkyrt3 zrntkyrt3}</td><td>（連携用）適用利率３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrthndymd3 zrnrthndymd3}</td><td>（連携用）利率変動年月日３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrthndzndk4 zrnrthndzndk4}</td><td>（連携用）利率変動時残高４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkyrt4 zrntkyrt4}</td><td>（連携用）適用利率４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrthndymd4 zrnrthndymd4}</td><td>（連携用）利率変動年月日４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntndmatuzndk zrntndmatuzndk}</td><td>（連携用）当年度末残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntndmatutkyrt zrntndmatutkyrt}</td><td>（連携用）当年度末適用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzennounyuukinymd zrnzennounyuukinymd}</td><td>（連携用）前納入金年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntndzndkhikakukbn zrntndzndkhikakukbn}</td><td>（連携用）当年度残高比較区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukikan zrnzennoukikan}</td><td>（連携用）前納期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobi01xv1 zrnyobi01xv1}</td><td>（連携用）予備０１＿Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeitaikbn zrnbosyuukeitaikbn}</td><td>（連携用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobi02xv11 zrnyobi02xv11}</td><td>（連携用）予備０２＿Ｖ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngkdtznnhyj zrngkdtznnhyj}</td><td>（連携用）外貨建前納表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenkanyknhyj zrnyenkanyknhyj}</td><td>（連携用）円貨入金表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknjikawaserate zrnnyknjikawaserate}</td><td>（連携用）入金時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnnyknjikawaseratetkyuymd zrnnyknjikawaseratetkyuymd}</td><td>（連携用）入金時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnksnkisikawaserate zrnksnkisikawaserate}</td><td>（連携用）決算期始為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntndmatuzndkksnjkwsrate zrntndmatuzndkksnjkwsrate}</td><td>（連携用）当年度末残高計算時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzennounyuukinkgkgaika zrnzennounyuukinkgkgaika}</td><td>（連携用）前納入金額＿外貨</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennounyuukinkgktkmatu zrnzennounyuukinkgktkmatu}</td><td>（連携用）前納入金額＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennoukaisijizndktkmatu zrnzennoukaisijizndktkmatu}</td><td>（連携用）前納開始時残高＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrthndzndk1tkmatu zrnrthndzndk1tkmatu}</td><td>（連携用）利率変動時残高１＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrthndzndk2tkmatu zrnrthndzndk2tkmatu}</td><td>（連携用）利率変動時残高２＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrthndzndk3tkmatu zrnrthndzndk3tkmatu}</td><td>（連携用）利率変動時残高３＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrthndzndk4tkmatu zrnrthndzndk4tkmatu}</td><td>（連携用）利率変動時残高４＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntndmatuzndktkmatu zrntndmatuzndktkmatu}</td><td>（連携用）当年度末残高＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv22 zrnyobiv22}</td><td>（連携用）予備項目Ｖ２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KessanZennouFRn
 * @see     PKZT_KessanZennouFRn
 * @see     QZT_KessanZennouFRn
 * @see     GenQZT_KessanZennouFRn
 */
@MappedSuperclass
@Table(name=GenZT_KessanZennouFRn.TABLE_NAME)
@IdClass(value=PKZT_KessanZennouFRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KessanZennouFRn extends AbstractExDBEntityForZDB<ZT_KessanZennouFRn, PKZT_KessanZennouFRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KessanZennouFRn";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNKBNKEIRIYOUSEGMENTCD  = "zrnkbnkeiriyousegmentcd";
    public static final String ZRNZENNOUTOUKEILISTKBN   = "zrnzennoutoukeilistkbn";
    public static final String ZRNZENNOUKBN             = "zrnzennoukbn";
    public static final String ZRNZENNOUKAISIYMD        = "zrnzennoukaisiymd";
    public static final String ZRNZENNOUKAISIJIZNDK     = "zrnzennoukaisijizndk";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNZENNOUWRBKRT          = "zrnzennouwrbkrt";
    public static final String ZRNRTHNDZNDK1            = "zrnrthndzndk1";
    public static final String ZRNTKYRT1                = "zrntkyrt1";
    public static final String ZRNRTHNDYMD1             = "zrnrthndymd1";
    public static final String ZRNRTHNDZNDK2            = "zrnrthndzndk2";
    public static final String ZRNTKYRT2                = "zrntkyrt2";
    public static final String ZRNRTHNDYMD2             = "zrnrthndymd2";
    public static final String ZRNRTHNDZNDK3            = "zrnrthndzndk3";
    public static final String ZRNTKYRT3                = "zrntkyrt3";
    public static final String ZRNRTHNDYMD3             = "zrnrthndymd3";
    public static final String ZRNRTHNDZNDK4            = "zrnrthndzndk4";
    public static final String ZRNTKYRT4                = "zrntkyrt4";
    public static final String ZRNRTHNDYMD4             = "zrnrthndymd4";
    public static final String ZRNTNDMATUZNDK           = "zrntndmatuzndk";
    public static final String ZRNTNDMATUTKYRT          = "zrntndmatutkyrt";
    public static final String ZRNZENNOUNYUUKINYMD      = "zrnzennounyuukinymd";
    public static final String ZRNTNDZNDKHIKAKUKBN      = "zrntndzndkhikakukbn";
    public static final String ZRNZENNOUKIKAN           = "zrnzennoukikan";
    public static final String ZRNYOBI01XV1             = "zrnyobi01xv1";
    public static final String ZRNBOSYUUKEITAIKBN       = "zrnbosyuukeitaikbn";
    public static final String ZRNYOBI02XV11            = "zrnyobi02xv11";
    public static final String ZRNGKDTZNNHYJ            = "zrngkdtznnhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNYENKANYKNHYJ          = "zrnyenkanyknhyj";
    public static final String ZRNNYKNJIKAWASERATE      = "zrnnyknjikawaserate";
    public static final String ZRNNYKNJIKAWASERATETKYUYMD = "zrnnyknjikawaseratetkyuymd";
    public static final String ZRNKSNKISIKAWASERATE     = "zrnksnkisikawaserate";
    public static final String ZRNTNDMATUZNDKKSNJKWSRATE = "zrntndmatuzndkksnjkwsrate";
    public static final String ZRNZENNOUNYUUKINKGKGAIKA = "zrnzennounyuukinkgkgaika";
    public static final String ZRNZENNOUNYUUKINKGKTKMATU = "zrnzennounyuukinkgktkmatu";
    public static final String ZRNZENNOUKAISIJIZNDKTKMATU = "zrnzennoukaisijizndktkmatu";
    public static final String ZRNRTHNDZNDK1TKMATU      = "zrnrthndzndk1tkmatu";
    public static final String ZRNRTHNDZNDK2TKMATU      = "zrnrthndzndk2tkmatu";
    public static final String ZRNRTHNDZNDK3TKMATU      = "zrnrthndzndk3tkmatu";
    public static final String ZRNRTHNDZNDK4TKMATU      = "zrnrthndzndk4tkmatu";
    public static final String ZRNTNDMATUZNDKTKMATU     = "zrntndmatuzndktkmatu";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNYOBIV22               = "zrnyobiv22";

    private final PKZT_KessanZennouFRn primaryKey;

    public GenZT_KessanZennouFRn() {
        primaryKey = new PKZT_KessanZennouFRn();
    }

    public GenZT_KessanZennouFRn(
        String pZrnsyono,
        String pZrnkbnkeiriyousegmentcd,
        String pZrnzennoutoukeilistkbn,
        String pZrnzennoukbn
    ) {
        primaryKey = new PKZT_KessanZennouFRn(
            pZrnsyono,
            pZrnkbnkeiriyousegmentcd,
            pZrnzennoutoukeilistkbn,
            pZrnzennoukbn
        );
    }

    @Transient
    @Override
    public PKZT_KessanZennouFRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KessanZennouFRn> getMetaClass() {
        return QZT_KessanZennouFRn.class;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_KessanZennouFRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrnyobiv9;

    @Column(name=GenZT_KessanZennouFRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    @Id
    @Column(name=GenZT_KessanZennouFRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_KessanZennouFRn.ZRNKBNKEIRIYOUSEGMENTCD)
    public String getZrnkbnkeiriyousegmentcd() {
        return getPrimaryKey().getZrnkbnkeiriyousegmentcd();
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkbnkeiriyousegmentcd(String pZrnkbnkeiriyousegmentcd) {
        getPrimaryKey().setZrnkbnkeiriyousegmentcd(pZrnkbnkeiriyousegmentcd);
    }

    @Id
    @Column(name=GenZT_KessanZennouFRn.ZRNZENNOUTOUKEILISTKBN)
    public String getZrnzennoutoukeilistkbn() {
        return getPrimaryKey().getZrnzennoutoukeilistkbn();
    }

    public void setZrnzennoutoukeilistkbn(String pZrnzennoutoukeilistkbn) {
        getPrimaryKey().setZrnzennoutoukeilistkbn(pZrnzennoutoukeilistkbn);
    }

    @Id
    @Column(name=GenZT_KessanZennouFRn.ZRNZENNOUKBN)
    public String getZrnzennoukbn() {
        return getPrimaryKey().getZrnzennoukbn();
    }

    public void setZrnzennoukbn(String pZrnzennoukbn) {
        getPrimaryKey().setZrnzennoukbn(pZrnzennoukbn);
    }

    private String zrnzennoukaisiymd;

    @Column(name=GenZT_KessanZennouFRn.ZRNZENNOUKAISIYMD)
    public String getZrnzennoukaisiymd() {
        return zrnzennoukaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzennoukaisiymd(String pZrnzennoukaisiymd) {
        zrnzennoukaisiymd = pZrnzennoukaisiymd;
    }

    private Long zrnzennoukaisijizndk;

    @Column(name=GenZT_KessanZennouFRn.ZRNZENNOUKAISIJIZNDK)
    public Long getZrnzennoukaisijizndk() {
        return zrnzennoukaisijizndk;
    }

    public void setZrnzennoukaisijizndk(Long pZrnzennoukaisijizndk) {
        zrnzennoukaisijizndk = pZrnzennoukaisijizndk;
    }

    private String zrnkykymd;

    @Column(name=GenZT_KessanZennouFRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private BizNumber zrnzennouwrbkrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFRn.ZRNZENNOUWRBKRT)
    public BizNumber getZrnzennouwrbkrt() {
        return zrnzennouwrbkrt;
    }

    public void setZrnzennouwrbkrt(BizNumber pZrnzennouwrbkrt) {
        zrnzennouwrbkrt = pZrnzennouwrbkrt;
    }

    private Long zrnrthndzndk1;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDZNDK1)
    public Long getZrnrthndzndk1() {
        return zrnrthndzndk1;
    }

    public void setZrnrthndzndk1(Long pZrnrthndzndk1) {
        zrnrthndzndk1 = pZrnrthndzndk1;
    }

    private BizNumber zrntkyrt1;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFRn.ZRNTKYRT1)
    public BizNumber getZrntkyrt1() {
        return zrntkyrt1;
    }

    public void setZrntkyrt1(BizNumber pZrntkyrt1) {
        zrntkyrt1 = pZrntkyrt1;
    }

    private String zrnrthndymd1;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDYMD1)
    public String getZrnrthndymd1() {
        return zrnrthndymd1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnrthndymd1(String pZrnrthndymd1) {
        zrnrthndymd1 = pZrnrthndymd1;
    }

    private Long zrnrthndzndk2;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDZNDK2)
    public Long getZrnrthndzndk2() {
        return zrnrthndzndk2;
    }

    public void setZrnrthndzndk2(Long pZrnrthndzndk2) {
        zrnrthndzndk2 = pZrnrthndzndk2;
    }

    private BizNumber zrntkyrt2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFRn.ZRNTKYRT2)
    public BizNumber getZrntkyrt2() {
        return zrntkyrt2;
    }

    public void setZrntkyrt2(BizNumber pZrntkyrt2) {
        zrntkyrt2 = pZrntkyrt2;
    }

    private String zrnrthndymd2;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDYMD2)
    public String getZrnrthndymd2() {
        return zrnrthndymd2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnrthndymd2(String pZrnrthndymd2) {
        zrnrthndymd2 = pZrnrthndymd2;
    }

    private Long zrnrthndzndk3;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDZNDK3)
    public Long getZrnrthndzndk3() {
        return zrnrthndzndk3;
    }

    public void setZrnrthndzndk3(Long pZrnrthndzndk3) {
        zrnrthndzndk3 = pZrnrthndzndk3;
    }

    private BizNumber zrntkyrt3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFRn.ZRNTKYRT3)
    public BizNumber getZrntkyrt3() {
        return zrntkyrt3;
    }

    public void setZrntkyrt3(BizNumber pZrntkyrt3) {
        zrntkyrt3 = pZrntkyrt3;
    }

    private String zrnrthndymd3;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDYMD3)
    public String getZrnrthndymd3() {
        return zrnrthndymd3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnrthndymd3(String pZrnrthndymd3) {
        zrnrthndymd3 = pZrnrthndymd3;
    }

    private Long zrnrthndzndk4;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDZNDK4)
    public Long getZrnrthndzndk4() {
        return zrnrthndzndk4;
    }

    public void setZrnrthndzndk4(Long pZrnrthndzndk4) {
        zrnrthndzndk4 = pZrnrthndzndk4;
    }

    private BizNumber zrntkyrt4;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFRn.ZRNTKYRT4)
    public BizNumber getZrntkyrt4() {
        return zrntkyrt4;
    }

    public void setZrntkyrt4(BizNumber pZrntkyrt4) {
        zrntkyrt4 = pZrntkyrt4;
    }

    private String zrnrthndymd4;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDYMD4)
    public String getZrnrthndymd4() {
        return zrnrthndymd4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnrthndymd4(String pZrnrthndymd4) {
        zrnrthndymd4 = pZrnrthndymd4;
    }

    private Long zrntndmatuzndk;

    @Column(name=GenZT_KessanZennouFRn.ZRNTNDMATUZNDK)
    public Long getZrntndmatuzndk() {
        return zrntndmatuzndk;
    }

    public void setZrntndmatuzndk(Long pZrntndmatuzndk) {
        zrntndmatuzndk = pZrntndmatuzndk;
    }

    private BizNumber zrntndmatutkyrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFRn.ZRNTNDMATUTKYRT)
    public BizNumber getZrntndmatutkyrt() {
        return zrntndmatutkyrt;
    }

    public void setZrntndmatutkyrt(BizNumber pZrntndmatutkyrt) {
        zrntndmatutkyrt = pZrntndmatutkyrt;
    }

    private String zrnzennounyuukinymd;

    @Column(name=GenZT_KessanZennouFRn.ZRNZENNOUNYUUKINYMD)
    public String getZrnzennounyuukinymd() {
        return zrnzennounyuukinymd;
    }

    public void setZrnzennounyuukinymd(String pZrnzennounyuukinymd) {
        zrnzennounyuukinymd = pZrnzennounyuukinymd;
    }

    private String zrntndzndkhikakukbn;

    @Column(name=GenZT_KessanZennouFRn.ZRNTNDZNDKHIKAKUKBN)
    public String getZrntndzndkhikakukbn() {
        return zrntndzndkhikakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntndzndkhikakukbn(String pZrntndzndkhikakukbn) {
        zrntndzndkhikakukbn = pZrntndzndkhikakukbn;
    }

    private String zrnzennoukikan;

    @Column(name=GenZT_KessanZennouFRn.ZRNZENNOUKIKAN)
    public String getZrnzennoukikan() {
        return zrnzennoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnzennoukikan(String pZrnzennoukikan) {
        zrnzennoukikan = pZrnzennoukikan;
    }

    private String zrnyobi01xv1;

    @Column(name=GenZT_KessanZennouFRn.ZRNYOBI01XV1)
    public String getZrnyobi01xv1() {
        return zrnyobi01xv1;
    }

    public void setZrnyobi01xv1(String pZrnyobi01xv1) {
        zrnyobi01xv1 = pZrnyobi01xv1;
    }

    private String zrnbosyuukeitaikbn;

    @Column(name=GenZT_KessanZennouFRn.ZRNBOSYUUKEITAIKBN)
    public String getZrnbosyuukeitaikbn() {
        return zrnbosyuukeitaikbn;
    }

    public void setZrnbosyuukeitaikbn(String pZrnbosyuukeitaikbn) {
        zrnbosyuukeitaikbn = pZrnbosyuukeitaikbn;
    }

    private String zrnyobi02xv11;

    @Column(name=GenZT_KessanZennouFRn.ZRNYOBI02XV11)
    public String getZrnyobi02xv11() {
        return zrnyobi02xv11;
    }

    public void setZrnyobi02xv11(String pZrnyobi02xv11) {
        zrnyobi02xv11 = pZrnyobi02xv11;
    }

    private String zrngkdtznnhyj;

    @Column(name=GenZT_KessanZennouFRn.ZRNGKDTZNNHYJ)
    public String getZrngkdtznnhyj() {
        return zrngkdtznnhyj;
    }

    public void setZrngkdtznnhyj(String pZrngkdtznnhyj) {
        zrngkdtznnhyj = pZrngkdtznnhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_KessanZennouFRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private String zrnyenkanyknhyj;

    @Column(name=GenZT_KessanZennouFRn.ZRNYENKANYKNHYJ)
    public String getZrnyenkanyknhyj() {
        return zrnyenkanyknhyj;
    }

    public void setZrnyenkanyknhyj(String pZrnyenkanyknhyj) {
        zrnyenkanyknhyj = pZrnyenkanyknhyj;
    }

    private BizNumber zrnnyknjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFRn.ZRNNYKNJIKAWASERATE)
    public BizNumber getZrnnyknjikawaserate() {
        return zrnnyknjikawaserate;
    }

    public void setZrnnyknjikawaserate(BizNumber pZrnnyknjikawaserate) {
        zrnnyknjikawaserate = pZrnnyknjikawaserate;
    }

    private String zrnnyknjikawaseratetkyuymd;

    @Column(name=GenZT_KessanZennouFRn.ZRNNYKNJIKAWASERATETKYUYMD)
    public String getZrnnyknjikawaseratetkyuymd() {
        return zrnnyknjikawaseratetkyuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnnyknjikawaseratetkyuymd(String pZrnnyknjikawaseratetkyuymd) {
        zrnnyknjikawaseratetkyuymd = pZrnnyknjikawaseratetkyuymd;
    }

    private BizNumber zrnksnkisikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFRn.ZRNKSNKISIKAWASERATE)
    public BizNumber getZrnksnkisikawaserate() {
        return zrnksnkisikawaserate;
    }

    public void setZrnksnkisikawaserate(BizNumber pZrnksnkisikawaserate) {
        zrnksnkisikawaserate = pZrnksnkisikawaserate;
    }

    private BizNumber zrntndmatuzndkksnjkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KessanZennouFRn.ZRNTNDMATUZNDKKSNJKWSRATE)
    public BizNumber getZrntndmatuzndkksnjkwsrate() {
        return zrntndmatuzndkksnjkwsrate;
    }

    public void setZrntndmatuzndkksnjkwsrate(BizNumber pZrntndmatuzndkksnjkwsrate) {
        zrntndmatuzndkksnjkwsrate = pZrntndmatuzndkksnjkwsrate;
    }

    private Long zrnzennounyuukinkgkgaika;

    @Column(name=GenZT_KessanZennouFRn.ZRNZENNOUNYUUKINKGKGAIKA)
    public Long getZrnzennounyuukinkgkgaika() {
        return zrnzennounyuukinkgkgaika;
    }

    public void setZrnzennounyuukinkgkgaika(Long pZrnzennounyuukinkgkgaika) {
        zrnzennounyuukinkgkgaika = pZrnzennounyuukinkgkgaika;
    }

    private Long zrnzennounyuukinkgktkmatu;

    @Column(name=GenZT_KessanZennouFRn.ZRNZENNOUNYUUKINKGKTKMATU)
    public Long getZrnzennounyuukinkgktkmatu() {
        return zrnzennounyuukinkgktkmatu;
    }

    public void setZrnzennounyuukinkgktkmatu(Long pZrnzennounyuukinkgktkmatu) {
        zrnzennounyuukinkgktkmatu = pZrnzennounyuukinkgktkmatu;
    }

    private Long zrnzennoukaisijizndktkmatu;

    @Column(name=GenZT_KessanZennouFRn.ZRNZENNOUKAISIJIZNDKTKMATU)
    public Long getZrnzennoukaisijizndktkmatu() {
        return zrnzennoukaisijizndktkmatu;
    }

    public void setZrnzennoukaisijizndktkmatu(Long pZrnzennoukaisijizndktkmatu) {
        zrnzennoukaisijizndktkmatu = pZrnzennoukaisijizndktkmatu;
    }

    private Long zrnrthndzndk1tkmatu;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDZNDK1TKMATU)
    public Long getZrnrthndzndk1tkmatu() {
        return zrnrthndzndk1tkmatu;
    }

    public void setZrnrthndzndk1tkmatu(Long pZrnrthndzndk1tkmatu) {
        zrnrthndzndk1tkmatu = pZrnrthndzndk1tkmatu;
    }

    private Long zrnrthndzndk2tkmatu;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDZNDK2TKMATU)
    public Long getZrnrthndzndk2tkmatu() {
        return zrnrthndzndk2tkmatu;
    }

    public void setZrnrthndzndk2tkmatu(Long pZrnrthndzndk2tkmatu) {
        zrnrthndzndk2tkmatu = pZrnrthndzndk2tkmatu;
    }

    private Long zrnrthndzndk3tkmatu;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDZNDK3TKMATU)
    public Long getZrnrthndzndk3tkmatu() {
        return zrnrthndzndk3tkmatu;
    }

    public void setZrnrthndzndk3tkmatu(Long pZrnrthndzndk3tkmatu) {
        zrnrthndzndk3tkmatu = pZrnrthndzndk3tkmatu;
    }

    private Long zrnrthndzndk4tkmatu;

    @Column(name=GenZT_KessanZennouFRn.ZRNRTHNDZNDK4TKMATU)
    public Long getZrnrthndzndk4tkmatu() {
        return zrnrthndzndk4tkmatu;
    }

    public void setZrnrthndzndk4tkmatu(Long pZrnrthndzndk4tkmatu) {
        zrnrthndzndk4tkmatu = pZrnrthndzndk4tkmatu;
    }

    private Long zrntndmatuzndktkmatu;

    @Column(name=GenZT_KessanZennouFRn.ZRNTNDMATUZNDKTKMATU)
    public Long getZrntndmatuzndktkmatu() {
        return zrntndmatuzndktkmatu;
    }

    public void setZrntndmatuzndktkmatu(Long pZrntndmatuzndktkmatu) {
        zrntndmatuzndktkmatu = pZrntndmatuzndktkmatu;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_KessanZennouFRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_KessanZennouFRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_KessanZennouFRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_KessanZennouFRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private String zrnyobiv22;

    @Column(name=GenZT_KessanZennouFRn.ZRNYOBIV22)
    public String getZrnyobiv22() {
        return zrnyobiv22;
    }

    public void setZrnyobiv22(String pZrnyobiv22) {
        zrnyobiv22 = pZrnyobiv22;
    }
}