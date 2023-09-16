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
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.id.PKZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.meta.GenQZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.meta.QZT_ZennouHoyuuIdouKykDtlRn;

/**
 * 前納保有異動契約明細Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_ZennouHoyuuIdouKykDtlRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_ZennouHoyuuIdouKykDtlRn}</td><td colspan="3">前納保有異動契約明細Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordkbn zrnrecordkbn}</td><td>（連携用）レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">{@link PKZT_ZennouHoyuuIdouKykDtlRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhenkousyoriymd zrnhenkousyoriymd}</td><td>（連携用）変更処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndenymd zrndenymd}</td><td>（連携用）伝票日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoucalckijyunymd zrnzennoucalckijyunymd}</td><td>（連携用）前納計算基準年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfksnctr zrnkykmfksnctr}</td><td>（連携用）契約ＭＦ更新ＣＴＲ</td><td align="center">{@link PKZT_ZennouHoyuuIdouKykDtlRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnzennoubikinkbn zrnzennoubikinkbn}</td><td>（連携用）前納備金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10 zrnyobiv10}</td><td>（連携用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">{@link PKZT_ZennouHoyuuIdouKykDtlRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakusyuruicdv2 zrnsyukeiyakusyuruicdv2}</td><td>（連携用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentcd zrnkbnkeiriyousegmentcd}</td><td>（連携用）区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoutoukeilistkbn zrnzennoutoukeilistkbn}</td><td>（連携用）前納統計リスト区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouwrbkrt zrnzennouwrbkrt}</td><td>（連携用）前納割引率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntkyrt1 zrntkyrt1}</td><td>（連携用）適用利率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntndzndkhikakukbn zrntndzndkhikakukbn}</td><td>（連携用）当年度残高比較区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5 zrnyobiv5}</td><td>（連携用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukaisiymd zrnzennoukaisiymd}</td><td>（連携用）前納開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukbn zrnzennoukbn}</td><td>（連携用）前納区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukikan zrnzennoukikan}</td><td>（連携用）前納期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennounyuukinymd zrnzennounyuukinymd}</td><td>（連携用）前納入金年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennounyuukinkgk zrnzennounyuukinkgk}</td><td>（連携用）前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv5x2 zrnyobiv5x2}</td><td>（連携用）予備項目Ｖ５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10 zrnansyuyouyobin10}</td><td>（連携用）案内収納用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x2 zrnyobiv10x2}</td><td>（連携用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukimatuzennouzndk zrntoukimatuzennouzndk}</td><td>（連携用）当期末前納残高金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukijyuutoup zrntoukijyuutoup}</td><td>（連携用）当期充当保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukizennouseisangk zrntoukizennouseisangk}</td><td>（連携用）当期前納精算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukizennounyuukinkgk zrntoukizennounyuukinkgk}</td><td>（連携用）当期前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyokukinenbaraip zrnyokukinenbaraip}</td><td>（連携用）翌期年払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnwrbkrttkyrttekiyouzndk zrnwrbkrttkyrttekiyouzndk}</td><td>（連携用）割引利率適用残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngkdtznnhyj zrngkdtznnhyj}</td><td>（連携用）外貨建前納表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenkanyknhyj zrnyenkanyknhyj}</td><td>（連携用）円貨入金表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknjikawaserate zrnnyknjikawaserate}</td><td>（連携用）入金時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnnyknjikawaseratetkyuymd zrnnyknjikawaseratetkyuymd}</td><td>（連携用）入金時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnksnkisikawaserate zrnksnkisikawaserate}</td><td>（連携用）決算期始為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnznncalckjynymdkwsrate zrnznncalckjynymdkwsrate}</td><td>（連携用）前納計算基準日時点為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnksnkimatukawaserate zrnksnkimatukawaserate}</td><td>（連携用）決算期末時点為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzennounyuukinkgktkmatu zrnzennounyuukinkgktkmatu}</td><td>（連携用）前納入金額＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkmatuznnzndktkmatu zrntkmatuznnzndktkmatu}</td><td>（連携用）当期末前納残高金額＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x5 zrnyobin11x5}</td><td>（連携用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x6 zrnyobin11x6}</td><td>（連携用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x7 zrnyobin11x7}</td><td>（連携用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x8 zrnyobin11x8}</td><td>（連携用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv23 zrnyobiv23}</td><td>（連携用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_ZennouHoyuuIdouKykDtlRn
 * @see     PKZT_ZennouHoyuuIdouKykDtlRn
 * @see     QZT_ZennouHoyuuIdouKykDtlRn
 * @see     GenQZT_ZennouHoyuuIdouKykDtlRn
 */
@MappedSuperclass
@Table(name=GenZT_ZennouHoyuuIdouKykDtlRn.TABLE_NAME)
@IdClass(value=PKZT_ZennouHoyuuIdouKykDtlRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_ZennouHoyuuIdouKykDtlRn extends AbstractExDBEntityForZDB<ZT_ZennouHoyuuIdouKykDtlRn, PKZT_ZennouHoyuuIdouKykDtlRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_ZennouHoyuuIdouKykDtlRn";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
    public static final String ZRNRECORDKBN             = "zrnrecordkbn";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNHENKOUSYORIYMD        = "zrnhenkousyoriymd";
    public static final String ZRNDENYMD                = "zrndenymd";
    public static final String ZRNZENNOUCALCKIJYUNYMD   = "zrnzennoucalckijyunymd";
    public static final String ZRNKYKMFKSNCTR           = "zrnkykmfksnctr";
    public static final String ZRNZENNOUBIKINKBN        = "zrnzennoubikinkbn";
    public static final String ZRNYOBIV10               = "zrnyobiv10";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNSYUKEIYAKUSYURUICDV2  = "zrnsyukeiyakusyuruicdv2";
    public static final String ZRNKBNKEIRIYOUSEGMENTCD  = "zrnkbnkeiriyousegmentcd";
    public static final String ZRNZENNOUTOUKEILISTKBN   = "zrnzennoutoukeilistkbn";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNZENNOUWRBKRT          = "zrnzennouwrbkrt";
    public static final String ZRNTKYRT1                = "zrntkyrt1";
    public static final String ZRNTNDZNDKHIKAKUKBN      = "zrntndzndkhikakukbn";
    public static final String ZRNYOBIV5                = "zrnyobiv5";
    public static final String ZRNZENNOUKAISIYMD        = "zrnzennoukaisiymd";
    public static final String ZRNZENNOUKBN             = "zrnzennoukbn";
    public static final String ZRNZENNOUKIKAN           = "zrnzennoukikan";
    public static final String ZRNZENNOUNYUUKINYMD      = "zrnzennounyuukinymd";
    public static final String ZRNZENNOUNYUUKINKGK      = "zrnzennounyuukinkgk";
    public static final String ZRNYOBIV5X2              = "zrnyobiv5x2";
    public static final String ZRNANSYUYOUYOBIN10       = "zrnansyuyouyobin10";
    public static final String ZRNYOBIV10X2             = "zrnyobiv10x2";
    public static final String ZRNTOUKIMATUZENNOUZNDK   = "zrntoukimatuzennouzndk";
    public static final String ZRNTOUKIJYUUTOUP         = "zrntoukijyuutoup";
    public static final String ZRNTOUKIZENNOUSEISANGK   = "zrntoukizennouseisangk";
    public static final String ZRNTOUKIZENNOUNYUUKINKGK = "zrntoukizennounyuukinkgk";
    public static final String ZRNYOKUKINENBARAIP       = "zrnyokukinenbaraip";
    public static final String ZRNWRBKRTTKYRTTEKIYOUZNDK = "zrnwrbkrttkyrttekiyouzndk";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNGKDTZNNHYJ            = "zrngkdtznnhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNYENKANYKNHYJ          = "zrnyenkanyknhyj";
    public static final String ZRNNYKNJIKAWASERATE      = "zrnnyknjikawaserate";
    public static final String ZRNNYKNJIKAWASERATETKYUYMD = "zrnnyknjikawaseratetkyuymd";
    public static final String ZRNKSNKISIKAWASERATE     = "zrnksnkisikawaserate";
    public static final String ZRNZNNCALCKJYNYMDKWSRATE = "zrnznncalckjynymdkwsrate";
    public static final String ZRNKSNKIMATUKAWASERATE   = "zrnksnkimatukawaserate";
    public static final String ZRNZENNOUNYUUKINKGKTKMATU = "zrnzennounyuukinkgktkmatu";
    public static final String ZRNTKMATUZNNZNDKTKMATU   = "zrntkmatuznnzndktkmatu";
    public static final String ZRNYOBIN11X5             = "zrnyobin11x5";
    public static final String ZRNYOBIN11X6             = "zrnyobin11x6";
    public static final String ZRNYOBIN11X7             = "zrnyobin11x7";
    public static final String ZRNYOBIN11X8             = "zrnyobin11x8";
    public static final String ZRNYOBIV23               = "zrnyobiv23";

    private final PKZT_ZennouHoyuuIdouKykDtlRn primaryKey;

    public GenZT_ZennouHoyuuIdouKykDtlRn() {
        primaryKey = new PKZT_ZennouHoyuuIdouKykDtlRn();
    }

    public GenZT_ZennouHoyuuIdouKykDtlRn(
        String pZrndatakanrino,
        String pZrnsyoricd,
        Integer pZrnkykmfksnctr
    ) {
        primaryKey = new PKZT_ZennouHoyuuIdouKykDtlRn(
            pZrndatakanrino,
            pZrnsyoricd,
            pZrnkykmfksnctr
        );
    }

    @Transient
    @Override
    public PKZT_ZennouHoyuuIdouKykDtlRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_ZennouHoyuuIdouKykDtlRn> getMetaClass() {
        return QZT_ZennouHoyuuIdouKykDtlRn.class;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrnyobiv9;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrnrecordkbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNRECORDKBN)
    public String getZrnrecordkbn() {
        return zrnrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrecordkbn(String pZrnrecordkbn) {
        zrnrecordkbn = pZrnrecordkbn;
    }

    private String zrnkeijyouym;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return zrnkeijyouym;
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        zrnkeijyouym = pZrnkeijyouym;
    }

    @Id
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return getPrimaryKey().getZrnsyoricd();
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        getPrimaryKey().setZrnsyoricd(pZrnsyoricd);
    }

    private String zrnhenkousyoriymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNHENKOUSYORIYMD)
    public String getZrnhenkousyoriymd() {
        return zrnhenkousyoriymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhenkousyoriymd(String pZrnhenkousyoriymd) {
        zrnhenkousyoriymd = pZrnhenkousyoriymd;
    }

    private String zrndenymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNDENYMD)
    public String getZrndenymd() {
        return zrndenymd;
    }

    public void setZrndenymd(String pZrndenymd) {
        zrndenymd = pZrndenymd;
    }

    private String zrnzennoucalckijyunymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZENNOUCALCKIJYUNYMD)
    public String getZrnzennoucalckijyunymd() {
        return zrnzennoucalckijyunymd;
    }

    public void setZrnzennoucalckijyunymd(String pZrnzennoucalckijyunymd) {
        zrnzennoucalckijyunymd = pZrnzennoucalckijyunymd;
    }

    @Id
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNKYKMFKSNCTR)
    public Integer getZrnkykmfksnctr() {
        return getPrimaryKey().getZrnkykmfksnctr();
    }

    public void setZrnkykmfksnctr(Integer pZrnkykmfksnctr) {
        getPrimaryKey().setZrnkykmfksnctr(pZrnkykmfksnctr);
    }

    private String zrnzennoubikinkbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZENNOUBIKINKBN)
    public String getZrnzennoubikinkbn() {
        return zrnzennoubikinkbn;
    }

    public void setZrnzennoubikinkbn(String pZrnzennoubikinkbn) {
        zrnzennoubikinkbn = pZrnzennoubikinkbn;
    }

    private String zrnyobiv10;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIV10)
    public String getZrnyobiv10() {
        return zrnyobiv10;
    }

    public void setZrnyobiv10(String pZrnyobiv10) {
        zrnyobiv10 = pZrnyobiv10;
    }

    @Id
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return getPrimaryKey().getZrndatakanrino();
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        getPrimaryKey().setZrndatakanrino(pZrndatakanrino);
    }

    private String zrnsyukeiyakusyuruicdv2;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNSYUKEIYAKUSYURUICDV2)
    public String getZrnsyukeiyakusyuruicdv2() {
        return zrnsyukeiyakusyuruicdv2;
    }

    public void setZrnsyukeiyakusyuruicdv2(String pZrnsyukeiyakusyuruicdv2) {
        zrnsyukeiyakusyuruicdv2 = pZrnsyukeiyakusyuruicdv2;
    }

    private String zrnkbnkeiriyousegmentcd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNKBNKEIRIYOUSEGMENTCD)
    public String getZrnkbnkeiriyousegmentcd() {
        return zrnkbnkeiriyousegmentcd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkbnkeiriyousegmentcd(String pZrnkbnkeiriyousegmentcd) {
        zrnkbnkeiriyousegmentcd = pZrnkbnkeiriyousegmentcd;
    }

    private String zrnzennoutoukeilistkbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZENNOUTOUKEILISTKBN)
    public String getZrnzennoutoukeilistkbn() {
        return zrnzennoutoukeilistkbn;
    }

    public void setZrnzennoutoukeilistkbn(String pZrnzennoutoukeilistkbn) {
        zrnzennoutoukeilistkbn = pZrnzennoutoukeilistkbn;
    }

    private String zrnkykymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private BizNumber zrnzennouwrbkrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZENNOUWRBKRT)
    public BizNumber getZrnzennouwrbkrt() {
        return zrnzennouwrbkrt;
    }

    public void setZrnzennouwrbkrt(BizNumber pZrnzennouwrbkrt) {
        zrnzennouwrbkrt = pZrnzennouwrbkrt;
    }

    private BizNumber zrntkyrt1;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNTKYRT1)
    public BizNumber getZrntkyrt1() {
        return zrntkyrt1;
    }

    public void setZrntkyrt1(BizNumber pZrntkyrt1) {
        zrntkyrt1 = pZrntkyrt1;
    }

    private String zrntndzndkhikakukbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNTNDZNDKHIKAKUKBN)
    public String getZrntndzndkhikakukbn() {
        return zrntndzndkhikakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntndzndkhikakukbn(String pZrntndzndkhikakukbn) {
        zrntndzndkhikakukbn = pZrntndzndkhikakukbn;
    }

    private String zrnyobiv5;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIV5)
    public String getZrnyobiv5() {
        return zrnyobiv5;
    }

    public void setZrnyobiv5(String pZrnyobiv5) {
        zrnyobiv5 = pZrnyobiv5;
    }

    private String zrnzennoukaisiymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZENNOUKAISIYMD)
    public String getZrnzennoukaisiymd() {
        return zrnzennoukaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzennoukaisiymd(String pZrnzennoukaisiymd) {
        zrnzennoukaisiymd = pZrnzennoukaisiymd;
    }

    private String zrnzennoukbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZENNOUKBN)
    public String getZrnzennoukbn() {
        return zrnzennoukbn;
    }

    public void setZrnzennoukbn(String pZrnzennoukbn) {
        zrnzennoukbn = pZrnzennoukbn;
    }

    private String zrnzennoukikan;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZENNOUKIKAN)
    public String getZrnzennoukikan() {
        return zrnzennoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnzennoukikan(String pZrnzennoukikan) {
        zrnzennoukikan = pZrnzennoukikan;
    }

    private String zrnzennounyuukinymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZENNOUNYUUKINYMD)
    public String getZrnzennounyuukinymd() {
        return zrnzennounyuukinymd;
    }

    public void setZrnzennounyuukinymd(String pZrnzennounyuukinymd) {
        zrnzennounyuukinymd = pZrnzennounyuukinymd;
    }

    private Long zrnzennounyuukinkgk;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZENNOUNYUUKINKGK)
    public Long getZrnzennounyuukinkgk() {
        return zrnzennounyuukinkgk;
    }

    public void setZrnzennounyuukinkgk(Long pZrnzennounyuukinkgk) {
        zrnzennounyuukinkgk = pZrnzennounyuukinkgk;
    }

    private String zrnyobiv5x2;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIV5X2)
    public String getZrnyobiv5x2() {
        return zrnyobiv5x2;
    }

    public void setZrnyobiv5x2(String pZrnyobiv5x2) {
        zrnyobiv5x2 = pZrnyobiv5x2;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnyobiv10x2;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIV10X2)
    public String getZrnyobiv10x2() {
        return zrnyobiv10x2;
    }

    public void setZrnyobiv10x2(String pZrnyobiv10x2) {
        zrnyobiv10x2 = pZrnyobiv10x2;
    }

    private Long zrntoukimatuzennouzndk;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNTOUKIMATUZENNOUZNDK)
    public Long getZrntoukimatuzennouzndk() {
        return zrntoukimatuzennouzndk;
    }

    public void setZrntoukimatuzennouzndk(Long pZrntoukimatuzennouzndk) {
        zrntoukimatuzennouzndk = pZrntoukimatuzennouzndk;
    }

    private Long zrntoukijyuutoup;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNTOUKIJYUUTOUP)
    public Long getZrntoukijyuutoup() {
        return zrntoukijyuutoup;
    }

    public void setZrntoukijyuutoup(Long pZrntoukijyuutoup) {
        zrntoukijyuutoup = pZrntoukijyuutoup;
    }

    private Long zrntoukizennouseisangk;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNTOUKIZENNOUSEISANGK)
    public Long getZrntoukizennouseisangk() {
        return zrntoukizennouseisangk;
    }

    public void setZrntoukizennouseisangk(Long pZrntoukizennouseisangk) {
        zrntoukizennouseisangk = pZrntoukizennouseisangk;
    }

    private Long zrntoukizennounyuukinkgk;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNTOUKIZENNOUNYUUKINKGK)
    public Long getZrntoukizennounyuukinkgk() {
        return zrntoukizennounyuukinkgk;
    }

    public void setZrntoukizennounyuukinkgk(Long pZrntoukizennounyuukinkgk) {
        zrntoukizennounyuukinkgk = pZrntoukizennounyuukinkgk;
    }

    private Long zrnyokukinenbaraip;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOKUKINENBARAIP)
    public Long getZrnyokukinenbaraip() {
        return zrnyokukinenbaraip;
    }

    public void setZrnyokukinenbaraip(Long pZrnyokukinenbaraip) {
        zrnyokukinenbaraip = pZrnyokukinenbaraip;
    }

    private Long zrnwrbkrttkyrttekiyouzndk;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNWRBKRTTKYRTTEKIYOUZNDK)
    public Long getZrnwrbkrttkyrttekiyouzndk() {
        return zrnwrbkrttkyrttekiyouzndk;
    }

    public void setZrnwrbkrttkyrttekiyouzndk(Long pZrnwrbkrttkyrttekiyouzndk) {
        zrnwrbkrttkyrttekiyouzndk = pZrnwrbkrttkyrttekiyouzndk;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private String zrngkdtznnhyj;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNGKDTZNNHYJ)
    public String getZrngkdtznnhyj() {
        return zrngkdtznnhyj;
    }

    public void setZrngkdtznnhyj(String pZrngkdtznnhyj) {
        zrngkdtznnhyj = pZrngkdtznnhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private String zrnyenkanyknhyj;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYENKANYKNHYJ)
    public String getZrnyenkanyknhyj() {
        return zrnyenkanyknhyj;
    }

    public void setZrnyenkanyknhyj(String pZrnyenkanyknhyj) {
        zrnyenkanyknhyj = pZrnyenkanyknhyj;
    }

    private BizNumber zrnnyknjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNNYKNJIKAWASERATE)
    public BizNumber getZrnnyknjikawaserate() {
        return zrnnyknjikawaserate;
    }

    public void setZrnnyknjikawaserate(BizNumber pZrnnyknjikawaserate) {
        zrnnyknjikawaserate = pZrnnyknjikawaserate;
    }

    private String zrnnyknjikawaseratetkyuymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNNYKNJIKAWASERATETKYUYMD)
    public String getZrnnyknjikawaseratetkyuymd() {
        return zrnnyknjikawaseratetkyuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnnyknjikawaseratetkyuymd(String pZrnnyknjikawaseratetkyuymd) {
        zrnnyknjikawaseratetkyuymd = pZrnnyknjikawaseratetkyuymd;
    }

    private BizNumber zrnksnkisikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNKSNKISIKAWASERATE)
    public BizNumber getZrnksnkisikawaserate() {
        return zrnksnkisikawaserate;
    }

    public void setZrnksnkisikawaserate(BizNumber pZrnksnkisikawaserate) {
        zrnksnkisikawaserate = pZrnksnkisikawaserate;
    }

    private BizNumber zrnznncalckjynymdkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZNNCALCKJYNYMDKWSRATE)
    public BizNumber getZrnznncalckjynymdkwsrate() {
        return zrnznncalckjynymdkwsrate;
    }

    public void setZrnznncalckjynymdkwsrate(BizNumber pZrnznncalckjynymdkwsrate) {
        zrnznncalckjynymdkwsrate = pZrnznncalckjynymdkwsrate;
    }

    private BizNumber zrnksnkimatukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNKSNKIMATUKAWASERATE)
    public BizNumber getZrnksnkimatukawaserate() {
        return zrnksnkimatukawaserate;
    }

    public void setZrnksnkimatukawaserate(BizNumber pZrnksnkimatukawaserate) {
        zrnksnkimatukawaserate = pZrnksnkimatukawaserate;
    }

    private Long zrnzennounyuukinkgktkmatu;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNZENNOUNYUUKINKGKTKMATU)
    public Long getZrnzennounyuukinkgktkmatu() {
        return zrnzennounyuukinkgktkmatu;
    }

    public void setZrnzennounyuukinkgktkmatu(Long pZrnzennounyuukinkgktkmatu) {
        zrnzennounyuukinkgktkmatu = pZrnzennounyuukinkgktkmatu;
    }

    private Long zrntkmatuznnzndktkmatu;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNTKMATUZNNZNDKTKMATU)
    public Long getZrntkmatuznnzndktkmatu() {
        return zrntkmatuznnzndktkmatu;
    }

    public void setZrntkmatuznnzndktkmatu(Long pZrntkmatuznnzndktkmatu) {
        zrntkmatuznnzndktkmatu = pZrntkmatuznnzndktkmatu;
    }

    private Long zrnyobin11x5;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIN11X5)
    public Long getZrnyobin11x5() {
        return zrnyobin11x5;
    }

    public void setZrnyobin11x5(Long pZrnyobin11x5) {
        zrnyobin11x5 = pZrnyobin11x5;
    }

    private Long zrnyobin11x6;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIN11X6)
    public Long getZrnyobin11x6() {
        return zrnyobin11x6;
    }

    public void setZrnyobin11x6(Long pZrnyobin11x6) {
        zrnyobin11x6 = pZrnyobin11x6;
    }

    private Long zrnyobin11x7;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIN11X7)
    public Long getZrnyobin11x7() {
        return zrnyobin11x7;
    }

    public void setZrnyobin11x7(Long pZrnyobin11x7) {
        zrnyobin11x7 = pZrnyobin11x7;
    }

    private Long zrnyobin11x8;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIN11X8)
    public Long getZrnyobin11x8() {
        return zrnyobin11x8;
    }

    public void setZrnyobin11x8(Long pZrnyobin11x8) {
        zrnyobin11x8 = pZrnyobin11x8;
    }

    private String zrnyobiv23;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlRn.ZRNYOBIV23)
    public String getZrnyobiv23() {
        return zrnyobiv23;
    }

    public void setZrnyobiv23(String pZrnyobiv23) {
        zrnyobiv23 = pZrnyobiv23;
    }
}