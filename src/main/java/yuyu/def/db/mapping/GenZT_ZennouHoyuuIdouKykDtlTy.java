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
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.id.PKZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.meta.GenQZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.meta.QZT_ZennouHoyuuIdouKykDtlTy;

/**
 * 前納保有異動契約明細Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_ZennouHoyuuIdouKykDtlTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_ZennouHoyuuIdouKykDtlTy}</td><td colspan="3">前納保有異動契約明細Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordkbn ztyrecordkbn}</td><td>（中継用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">{@link PKZT_ZennouHoyuuIdouKykDtlTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhenkousyoriymd ztyhenkousyoriymd}</td><td>（中継用）変更処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenymd ztydenymd}</td><td>（中継用）伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoucalckijyunymd ztyzennoucalckijyunymd}</td><td>（中継用）前納計算基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfksnctr ztykykmfksnctr}</td><td>（中継用）契約ＭＦ更新ＣＴＲ</td><td align="center">{@link PKZT_ZennouHoyuuIdouKykDtlTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyzennoubikinkbn ztyzennoubikinkbn}</td><td>（中継用）前納備金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10 ztyyobiv10}</td><td>（中継用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">{@link PKZT_ZennouHoyuuIdouKykDtlTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusyuruicdv2 ztysyukeiyakusyuruicdv2}</td><td>（中継用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentcd ztykbnkeiriyousegmentcd}</td><td>（中継用）区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoutoukeilistkbn ztyzennoutoukeilistkbn}</td><td>（中継用）前納統計リスト区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouwrbkrt ztyzennouwrbkrt}</td><td>（中継用）前納割引率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytkyrt1 ztytkyrt1}</td><td>（中継用）適用利率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytndzndkhikakukbn ztytndzndkhikakukbn}</td><td>（中継用）当年度残高比較区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv5 ztyyobiv5}</td><td>（中継用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukaisiymd ztyzennoukaisiymd}</td><td>（中継用）前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukbn ztyzennoukbn}</td><td>（中継用）前納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukikan ztyzennoukikan}</td><td>（中継用）前納期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennounyuukinymd ztyzennounyuukinymd}</td><td>（中継用）前納入金年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennounyuukinkgk ztyzennounyuukinkgk}</td><td>（中継用）前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv5x2 ztyyobiv5x2}</td><td>（中継用）予備項目Ｖ５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10 ztyansyuyouyobin10}</td><td>（中継用）案内収納用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x2 ztyyobiv10x2}</td><td>（中継用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukimatuzennouzndk ztytoukimatuzennouzndk}</td><td>（中継用）当期末前納残高金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukijyuutoup ztytoukijyuutoup}</td><td>（中継用）当期充当保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukizennouseisangk ztytoukizennouseisangk}</td><td>（中継用）当期前納精算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukizennounyuukinkgk ztytoukizennounyuukinkgk}</td><td>（中継用）当期前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyokukinenbaraip ztyyokukinenbaraip}</td><td>（中継用）翌期年払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtywrbkrttkyrttekiyouzndk ztywrbkrttkyrttekiyouzndk}</td><td>（中継用）割引利率適用残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygkdtznnhyj ztygkdtznnhyj}</td><td>（中継用）外貨建前納表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenkanyknhyj ztyyenkanyknhyj}</td><td>（中継用）円貨入金表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknjikawaserate ztynyknjikawaserate}</td><td>（中継用）入金時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtynyknjikawaseratetkyuymd ztynyknjikawaseratetkyuymd}</td><td>（中継用）入金時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyksnkisikawaserate ztyksnkisikawaserate}</td><td>（中継用）決算期始為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyznncalckjynymdkwsrate ztyznncalckjynymdkwsrate}</td><td>（中継用）前納計算基準日時点為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyksnkimatukawaserate ztyksnkimatukawaserate}</td><td>（中継用）決算期末時点為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzennounyuukinkgktkmatu ztyzennounyuukinkgktkmatu}</td><td>（中継用）前納入金額＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkmatuznnzndktkmatu ztytkmatuznnzndktkmatu}</td><td>（中継用）当期末前納残高金額＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x5 ztyyobin11x5}</td><td>（中継用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x6 ztyyobin11x6}</td><td>（中継用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x7 ztyyobin11x7}</td><td>（中継用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x8 ztyyobin11x8}</td><td>（中継用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv23 ztyyobiv23}</td><td>（中継用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_ZennouHoyuuIdouKykDtlTy
 * @see     PKZT_ZennouHoyuuIdouKykDtlTy
 * @see     QZT_ZennouHoyuuIdouKykDtlTy
 * @see     GenQZT_ZennouHoyuuIdouKykDtlTy
 */
@MappedSuperclass
@Table(name=GenZT_ZennouHoyuuIdouKykDtlTy.TABLE_NAME)
@IdClass(value=PKZT_ZennouHoyuuIdouKykDtlTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_ZennouHoyuuIdouKykDtlTy extends AbstractExDBEntity<ZT_ZennouHoyuuIdouKykDtlTy, PKZT_ZennouHoyuuIdouKykDtlTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_ZennouHoyuuIdouKykDtlTy";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
    public static final String ZTYRECORDKBN             = "ztyrecordkbn";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYHENKOUSYORIYMD        = "ztyhenkousyoriymd";
    public static final String ZTYDENYMD                = "ztydenymd";
    public static final String ZTYZENNOUCALCKIJYUNYMD   = "ztyzennoucalckijyunymd";
    public static final String ZTYKYKMFKSNCTR           = "ztykykmfksnctr";
    public static final String ZTYZENNOUBIKINKBN        = "ztyzennoubikinkbn";
    public static final String ZTYYOBIV10               = "ztyyobiv10";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYSYUKEIYAKUSYURUICDV2  = "ztysyukeiyakusyuruicdv2";
    public static final String ZTYKBNKEIRIYOUSEGMENTCD  = "ztykbnkeiriyousegmentcd";
    public static final String ZTYZENNOUTOUKEILISTKBN   = "ztyzennoutoukeilistkbn";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYZENNOUWRBKRT          = "ztyzennouwrbkrt";
    public static final String ZTYTKYRT1                = "ztytkyrt1";
    public static final String ZTYTNDZNDKHIKAKUKBN      = "ztytndzndkhikakukbn";
    public static final String ZTYYOBIV5                = "ztyyobiv5";
    public static final String ZTYZENNOUKAISIYMD        = "ztyzennoukaisiymd";
    public static final String ZTYZENNOUKBN             = "ztyzennoukbn";
    public static final String ZTYZENNOUKIKAN           = "ztyzennoukikan";
    public static final String ZTYZENNOUNYUUKINYMD      = "ztyzennounyuukinymd";
    public static final String ZTYZENNOUNYUUKINKGK      = "ztyzennounyuukinkgk";
    public static final String ZTYYOBIV5X2              = "ztyyobiv5x2";
    public static final String ZTYANSYUYOUYOBIN10       = "ztyansyuyouyobin10";
    public static final String ZTYYOBIV10X2             = "ztyyobiv10x2";
    public static final String ZTYTOUKIMATUZENNOUZNDK   = "ztytoukimatuzennouzndk";
    public static final String ZTYTOUKIJYUUTOUP         = "ztytoukijyuutoup";
    public static final String ZTYTOUKIZENNOUSEISANGK   = "ztytoukizennouseisangk";
    public static final String ZTYTOUKIZENNOUNYUUKINKGK = "ztytoukizennounyuukinkgk";
    public static final String ZTYYOKUKINENBARAIP       = "ztyyokukinenbaraip";
    public static final String ZTYWRBKRTTKYRTTEKIYOUZNDK = "ztywrbkrttkyrttekiyouzndk";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYGKDTZNNHYJ            = "ztygkdtznnhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYYENKANYKNHYJ          = "ztyyenkanyknhyj";
    public static final String ZTYNYKNJIKAWASERATE      = "ztynyknjikawaserate";
    public static final String ZTYNYKNJIKAWASERATETKYUYMD = "ztynyknjikawaseratetkyuymd";
    public static final String ZTYKSNKISIKAWASERATE     = "ztyksnkisikawaserate";
    public static final String ZTYZNNCALCKJYNYMDKWSRATE = "ztyznncalckjynymdkwsrate";
    public static final String ZTYKSNKIMATUKAWASERATE   = "ztyksnkimatukawaserate";
    public static final String ZTYZENNOUNYUUKINKGKTKMATU = "ztyzennounyuukinkgktkmatu";
    public static final String ZTYTKMATUZNNZNDKTKMATU   = "ztytkmatuznnzndktkmatu";
    public static final String ZTYYOBIN11X5             = "ztyyobin11x5";
    public static final String ZTYYOBIN11X6             = "ztyyobin11x6";
    public static final String ZTYYOBIN11X7             = "ztyyobin11x7";
    public static final String ZTYYOBIN11X8             = "ztyyobin11x8";
    public static final String ZTYYOBIV23               = "ztyyobiv23";

    private final PKZT_ZennouHoyuuIdouKykDtlTy primaryKey;

    public GenZT_ZennouHoyuuIdouKykDtlTy() {
        primaryKey = new PKZT_ZennouHoyuuIdouKykDtlTy();
    }

    public GenZT_ZennouHoyuuIdouKykDtlTy(
        String pZtydatakanrino,
        String pZtysyoricd,
        Integer pZtykykmfksnctr
    ) {
        primaryKey = new PKZT_ZennouHoyuuIdouKykDtlTy(
            pZtydatakanrino,
            pZtysyoricd,
            pZtykykmfksnctr
        );
    }

    @Transient
    @Override
    public PKZT_ZennouHoyuuIdouKykDtlTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_ZennouHoyuuIdouKykDtlTy> getMetaClass() {
        return QZT_ZennouHoyuuIdouKykDtlTy.class;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztyyobiv9;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztyrecordkbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYRECORDKBN)
    public String getZtyrecordkbn() {
        return ztyrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyrecordkbn(String pZtyrecordkbn) {
        ztyrecordkbn = pZtyrecordkbn;
    }

    private String ztykeijyouym;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    @Id
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return getPrimaryKey().getZtysyoricd();
    }

    public void setZtysyoricd(String pZtysyoricd) {
        getPrimaryKey().setZtysyoricd(pZtysyoricd);
    }

    private String ztyhenkousyoriymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYHENKOUSYORIYMD)
    public String getZtyhenkousyoriymd() {
        return ztyhenkousyoriymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhenkousyoriymd(String pZtyhenkousyoriymd) {
        ztyhenkousyoriymd = pZtyhenkousyoriymd;
    }

    private String ztydenymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYDENYMD)
    public String getZtydenymd() {
        return ztydenymd;
    }

    public void setZtydenymd(String pZtydenymd) {
        ztydenymd = pZtydenymd;
    }

    private String ztyzennoucalckijyunymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZENNOUCALCKIJYUNYMD)
    public String getZtyzennoucalckijyunymd() {
        return ztyzennoucalckijyunymd;
    }

    public void setZtyzennoucalckijyunymd(String pZtyzennoucalckijyunymd) {
        ztyzennoucalckijyunymd = pZtyzennoucalckijyunymd;
    }

    @Id
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYKYKMFKSNCTR)
    public Integer getZtykykmfksnctr() {
        return getPrimaryKey().getZtykykmfksnctr();
    }

    public void setZtykykmfksnctr(Integer pZtykykmfksnctr) {
        getPrimaryKey().setZtykykmfksnctr(pZtykykmfksnctr);
    }

    private String ztyzennoubikinkbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZENNOUBIKINKBN)
    public String getZtyzennoubikinkbn() {
        return ztyzennoubikinkbn;
    }

    public void setZtyzennoubikinkbn(String pZtyzennoubikinkbn) {
        ztyzennoubikinkbn = pZtyzennoubikinkbn;
    }

    private String ztyyobiv10;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIV10)
    public String getZtyyobiv10() {
        return ztyyobiv10;
    }

    public void setZtyyobiv10(String pZtyyobiv10) {
        ztyyobiv10 = pZtyyobiv10;
    }

    @Id
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return getPrimaryKey().getZtydatakanrino();
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        getPrimaryKey().setZtydatakanrino(pZtydatakanrino);
    }

    private String ztysyukeiyakusyuruicdv2;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYSYUKEIYAKUSYURUICDV2)
    public String getZtysyukeiyakusyuruicdv2() {
        return ztysyukeiyakusyuruicdv2;
    }

    public void setZtysyukeiyakusyuruicdv2(String pZtysyukeiyakusyuruicdv2) {
        ztysyukeiyakusyuruicdv2 = pZtysyukeiyakusyuruicdv2;
    }

    private String ztykbnkeiriyousegmentcd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYKBNKEIRIYOUSEGMENTCD)
    public String getZtykbnkeiriyousegmentcd() {
        return ztykbnkeiriyousegmentcd;
    }

    public void setZtykbnkeiriyousegmentcd(String pZtykbnkeiriyousegmentcd) {
        ztykbnkeiriyousegmentcd = pZtykbnkeiriyousegmentcd;
    }

    private String ztyzennoutoukeilistkbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZENNOUTOUKEILISTKBN)
    public String getZtyzennoutoukeilistkbn() {
        return ztyzennoutoukeilistkbn;
    }

    public void setZtyzennoutoukeilistkbn(String pZtyzennoutoukeilistkbn) {
        ztyzennoutoukeilistkbn = pZtyzennoutoukeilistkbn;
    }

    private String ztykykymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private BizNumber ztyzennouwrbkrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZENNOUWRBKRT)
    public BizNumber getZtyzennouwrbkrt() {
        return ztyzennouwrbkrt;
    }

    public void setZtyzennouwrbkrt(BizNumber pZtyzennouwrbkrt) {
        ztyzennouwrbkrt = pZtyzennouwrbkrt;
    }

    private BizNumber ztytkyrt1;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYTKYRT1)
    public BizNumber getZtytkyrt1() {
        return ztytkyrt1;
    }

    public void setZtytkyrt1(BizNumber pZtytkyrt1) {
        ztytkyrt1 = pZtytkyrt1;
    }

    private String ztytndzndkhikakukbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYTNDZNDKHIKAKUKBN)
    public String getZtytndzndkhikakukbn() {
        return ztytndzndkhikakukbn;
    }

    public void setZtytndzndkhikakukbn(String pZtytndzndkhikakukbn) {
        ztytndzndkhikakukbn = pZtytndzndkhikakukbn;
    }

    private String ztyyobiv5;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIV5)
    public String getZtyyobiv5() {
        return ztyyobiv5;
    }

    public void setZtyyobiv5(String pZtyyobiv5) {
        ztyyobiv5 = pZtyyobiv5;
    }

    private String ztyzennoukaisiymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZENNOUKAISIYMD)
    public String getZtyzennoukaisiymd() {
        return ztyzennoukaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyzennoukaisiymd(String pZtyzennoukaisiymd) {
        ztyzennoukaisiymd = pZtyzennoukaisiymd;
    }

    private String ztyzennoukbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZENNOUKBN)
    public String getZtyzennoukbn() {
        return ztyzennoukbn;
    }

    public void setZtyzennoukbn(String pZtyzennoukbn) {
        ztyzennoukbn = pZtyzennoukbn;
    }

    private String ztyzennoukikan;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZENNOUKIKAN)
    public String getZtyzennoukikan() {
        return ztyzennoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyzennoukikan(String pZtyzennoukikan) {
        ztyzennoukikan = pZtyzennoukikan;
    }

    private String ztyzennounyuukinymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZENNOUNYUUKINYMD)
    public String getZtyzennounyuukinymd() {
        return ztyzennounyuukinymd;
    }

    public void setZtyzennounyuukinymd(String pZtyzennounyuukinymd) {
        ztyzennounyuukinymd = pZtyzennounyuukinymd;
    }

    private Long ztyzennounyuukinkgk;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZENNOUNYUUKINKGK)
    public Long getZtyzennounyuukinkgk() {
        return ztyzennounyuukinkgk;
    }

    public void setZtyzennounyuukinkgk(Long pZtyzennounyuukinkgk) {
        ztyzennounyuukinkgk = pZtyzennounyuukinkgk;
    }

    private String ztyyobiv5x2;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIV5X2)
    public String getZtyyobiv5x2() {
        return ztyyobiv5x2;
    }

    public void setZtyyobiv5x2(String pZtyyobiv5x2) {
        ztyyobiv5x2 = pZtyyobiv5x2;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyyobiv10x2;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIV10X2)
    public String getZtyyobiv10x2() {
        return ztyyobiv10x2;
    }

    public void setZtyyobiv10x2(String pZtyyobiv10x2) {
        ztyyobiv10x2 = pZtyyobiv10x2;
    }

    private Long ztytoukimatuzennouzndk;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYTOUKIMATUZENNOUZNDK)
    public Long getZtytoukimatuzennouzndk() {
        return ztytoukimatuzennouzndk;
    }

    public void setZtytoukimatuzennouzndk(Long pZtytoukimatuzennouzndk) {
        ztytoukimatuzennouzndk = pZtytoukimatuzennouzndk;
    }

    private Long ztytoukijyuutoup;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYTOUKIJYUUTOUP)
    public Long getZtytoukijyuutoup() {
        return ztytoukijyuutoup;
    }

    public void setZtytoukijyuutoup(Long pZtytoukijyuutoup) {
        ztytoukijyuutoup = pZtytoukijyuutoup;
    }

    private Long ztytoukizennouseisangk;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYTOUKIZENNOUSEISANGK)
    public Long getZtytoukizennouseisangk() {
        return ztytoukizennouseisangk;
    }

    public void setZtytoukizennouseisangk(Long pZtytoukizennouseisangk) {
        ztytoukizennouseisangk = pZtytoukizennouseisangk;
    }

    private Long ztytoukizennounyuukinkgk;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYTOUKIZENNOUNYUUKINKGK)
    public Long getZtytoukizennounyuukinkgk() {
        return ztytoukizennounyuukinkgk;
    }

    public void setZtytoukizennounyuukinkgk(Long pZtytoukizennounyuukinkgk) {
        ztytoukizennounyuukinkgk = pZtytoukizennounyuukinkgk;
    }

    private Long ztyyokukinenbaraip;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOKUKINENBARAIP)
    public Long getZtyyokukinenbaraip() {
        return ztyyokukinenbaraip;
    }

    public void setZtyyokukinenbaraip(Long pZtyyokukinenbaraip) {
        ztyyokukinenbaraip = pZtyyokukinenbaraip;
    }

    private Long ztywrbkrttkyrttekiyouzndk;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYWRBKRTTKYRTTEKIYOUZNDK)
    public Long getZtywrbkrttkyrttekiyouzndk() {
        return ztywrbkrttkyrttekiyouzndk;
    }

    public void setZtywrbkrttkyrttekiyouzndk(Long pZtywrbkrttkyrttekiyouzndk) {
        ztywrbkrttkyrttekiyouzndk = pZtywrbkrttkyrttekiyouzndk;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private String ztygkdtznnhyj;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYGKDTZNNHYJ)
    public String getZtygkdtznnhyj() {
        return ztygkdtznnhyj;
    }

    public void setZtygkdtznnhyj(String pZtygkdtznnhyj) {
        ztygkdtznnhyj = pZtygkdtznnhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private String ztyyenkanyknhyj;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYENKANYKNHYJ)
    public String getZtyyenkanyknhyj() {
        return ztyyenkanyknhyj;
    }

    public void setZtyyenkanyknhyj(String pZtyyenkanyknhyj) {
        ztyyenkanyknhyj = pZtyyenkanyknhyj;
    }

    private BizNumber ztynyknjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYNYKNJIKAWASERATE)
    public BizNumber getZtynyknjikawaserate() {
        return ztynyknjikawaserate;
    }

    public void setZtynyknjikawaserate(BizNumber pZtynyknjikawaserate) {
        ztynyknjikawaserate = pZtynyknjikawaserate;
    }

    private String ztynyknjikawaseratetkyuymd;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYNYKNJIKAWASERATETKYUYMD)
    public String getZtynyknjikawaseratetkyuymd() {
        return ztynyknjikawaseratetkyuymd;
    }

    public void setZtynyknjikawaseratetkyuymd(String pZtynyknjikawaseratetkyuymd) {
        ztynyknjikawaseratetkyuymd = pZtynyknjikawaseratetkyuymd;
    }

    private BizNumber ztyksnkisikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYKSNKISIKAWASERATE)
    public BizNumber getZtyksnkisikawaserate() {
        return ztyksnkisikawaserate;
    }

    public void setZtyksnkisikawaserate(BizNumber pZtyksnkisikawaserate) {
        ztyksnkisikawaserate = pZtyksnkisikawaserate;
    }

    private BizNumber ztyznncalckjynymdkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZNNCALCKJYNYMDKWSRATE)
    public BizNumber getZtyznncalckjynymdkwsrate() {
        return ztyznncalckjynymdkwsrate;
    }

    public void setZtyznncalckjynymdkwsrate(BizNumber pZtyznncalckjynymdkwsrate) {
        ztyznncalckjynymdkwsrate = pZtyznncalckjynymdkwsrate;
    }

    private BizNumber ztyksnkimatukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYKSNKIMATUKAWASERATE)
    public BizNumber getZtyksnkimatukawaserate() {
        return ztyksnkimatukawaserate;
    }

    public void setZtyksnkimatukawaserate(BizNumber pZtyksnkimatukawaserate) {
        ztyksnkimatukawaserate = pZtyksnkimatukawaserate;
    }

    private Long ztyzennounyuukinkgktkmatu;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYZENNOUNYUUKINKGKTKMATU)
    public Long getZtyzennounyuukinkgktkmatu() {
        return ztyzennounyuukinkgktkmatu;
    }

    public void setZtyzennounyuukinkgktkmatu(Long pZtyzennounyuukinkgktkmatu) {
        ztyzennounyuukinkgktkmatu = pZtyzennounyuukinkgktkmatu;
    }

    private Long ztytkmatuznnzndktkmatu;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYTKMATUZNNZNDKTKMATU)
    public Long getZtytkmatuznnzndktkmatu() {
        return ztytkmatuznnzndktkmatu;
    }

    public void setZtytkmatuznnzndktkmatu(Long pZtytkmatuznnzndktkmatu) {
        ztytkmatuznnzndktkmatu = pZtytkmatuznnzndktkmatu;
    }

    private Long ztyyobin11x5;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private Long ztyyobin11x6;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }

    private Long ztyyobin11x7;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIN11X7)
    public Long getZtyyobin11x7() {
        return ztyyobin11x7;
    }

    public void setZtyyobin11x7(Long pZtyyobin11x7) {
        ztyyobin11x7 = pZtyyobin11x7;
    }

    private Long ztyyobin11x8;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIN11X8)
    public Long getZtyyobin11x8() {
        return ztyyobin11x8;
    }

    public void setZtyyobin11x8(Long pZtyyobin11x8) {
        ztyyobin11x8 = pZtyyobin11x8;
    }

    private String ztyyobiv23;

    @Column(name=GenZT_ZennouHoyuuIdouKykDtlTy.ZTYYOBIV23)
    public String getZtyyobiv23() {
        return ztyyobiv23;
    }

    public void setZtyyobiv23(String pZtyyobiv23) {
        ztyyobiv23 = pZtyyobiv23;
    }
}