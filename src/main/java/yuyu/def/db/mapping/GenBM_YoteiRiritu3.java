package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.id.PKBM_YoteiRiritu3;
import yuyu.def.db.meta.GenQBM_YoteiRiritu3;
import yuyu.def.db.meta.QBM_YoteiRiritu3;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 予定利率マスタ３ テーブルのマッピング情報クラスで、 {@link BM_YoteiRiritu3} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_YoteiRiritu3}</td><td colspan="3">予定利率マスタ３</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_YoteiRiritu3 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_YoteiRiritu3 ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getYoteiriritutkybr1 yoteiriritutkybr1}</td><td>予定利率適用分類１</td><td align="center">{@link PKBM_YoteiRiritu3 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYoteiriritutkybr2 yoteiriritutkybr2}</td><td>予定利率適用分類２</td><td align="center">{@link PKBM_YoteiRiritu3 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKijyunfromymd kijyunfromymd}</td><td>基準日自</td><td align="center">{@link PKBM_YoteiRiritu3 ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKijyuntoymd kijyuntoymd}</td><td>基準日至</td><td align="center">{@link PKBM_YoteiRiritu3 ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTumitateriritu tumitateriritu}</td><td>積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTmttknzoukaritujygn tmttknzoukaritujygn}</td><td>積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSetteibairitu setteibairitu}</td><td>設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getLoadinghnkgtumitateriritu loadinghnkgtumitateriritu}</td><td>ローディング変更後積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRendouritu rendouritu}</td><td>連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_YoteiRiritu3
 * @see     PKBM_YoteiRiritu3
 * @see     QBM_YoteiRiritu3
 * @see     GenQBM_YoteiRiritu3
 */
@MappedSuperclass
@Table(name=GenBM_YoteiRiritu3.TABLE_NAME)
@IdClass(value=PKBM_YoteiRiritu3.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_YoteiRiritu3 extends AbstractExDBEntity<BM_YoteiRiritu3, PKBM_YoteiRiritu3> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_YoteiRiritu3";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String YOTEIRIRITUTKYBR1        = "yoteiriritutkybr1";
    public static final String YOTEIRIRITUTKYBR2        = "yoteiriritutkybr2";
    public static final String KIJYUNFROMYMD            = "kijyunfromymd";
    public static final String KIJYUNTOYMD              = "kijyuntoymd";
    public static final String YOTEIRIRITU              = "yoteiriritu";
    public static final String TUMITATERIRITU           = "tumitateriritu";
    public static final String TMTTKNZOUKARITUJYGN      = "tmttknzoukaritujygn";
    public static final String SETTEIBAIRITU            = "setteibairitu";
    public static final String LOADINGHNKGTUMITATERIRITU = "loadinghnkgtumitateriritu";
    public static final String RENDOURITU               = "rendouritu";

    private final PKBM_YoteiRiritu3 primaryKey;

    public GenBM_YoteiRiritu3() {
        primaryKey = new PKBM_YoteiRiritu3();
    }

    public GenBM_YoteiRiritu3(
        String pSyouhncd,
        C_Tuukasyu pTuukasyu,
        String pYoteiriritutkybr1,
        String pYoteiriritutkybr2,
        BizDate pKijyunfromymd,
        BizDate pKijyuntoymd
    ) {
        primaryKey = new PKBM_YoteiRiritu3(
            pSyouhncd,
            pTuukasyu,
            pYoteiriritutkybr1,
            pYoteiriritutkybr2,
            pKijyunfromymd,
            pKijyuntoymd
        );
    }

    @Transient
    @Override
    public PKBM_YoteiRiritu3 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_YoteiRiritu3> getMetaClass() {
        return QBM_YoteiRiritu3.class;
    }

    @Id
    @Column(name=GenBM_YoteiRiritu3.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_YoteiRiritu3.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Column(name=GenBM_YoteiRiritu3.YOTEIRIRITUTKYBR1)
    public String getYoteiriritutkybr1() {
        return getPrimaryKey().getYoteiriritutkybr1();
    }

    public void setYoteiriritutkybr1(String pYoteiriritutkybr1) {
        getPrimaryKey().setYoteiriritutkybr1(pYoteiriritutkybr1);
    }

    @Id
    @Column(name=GenBM_YoteiRiritu3.YOTEIRIRITUTKYBR2)
    public String getYoteiriritutkybr2() {
        return getPrimaryKey().getYoteiriritutkybr2();
    }

    public void setYoteiriritutkybr2(String pYoteiriritutkybr2) {
        getPrimaryKey().setYoteiriritutkybr2(pYoteiriritutkybr2);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_YoteiRiritu3.KIJYUNFROMYMD)
    public BizDate getKijyunfromymd() {
        return getPrimaryKey().getKijyunfromymd();
    }

    public void setKijyunfromymd(BizDate pKijyunfromymd) {
        getPrimaryKey().setKijyunfromymd(pKijyunfromymd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_YoteiRiritu3.KIJYUNTOYMD)
    public BizDate getKijyuntoymd() {
        return getPrimaryKey().getKijyuntoymd();
    }

    public void setKijyuntoymd(BizDate pKijyuntoymd) {
        getPrimaryKey().setKijyuntoymd(pKijyuntoymd);
    }

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_YoteiRiritu3.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }

    private BizNumber tumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_YoteiRiritu3.TUMITATERIRITU)
    public BizNumber getTumitateriritu() {
        return tumitateriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTumitateriritu(BizNumber pTumitateriritu) {
        tumitateriritu = pTumitateriritu;
    }

    private BizNumber tmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenBM_YoteiRiritu3.TMTTKNZOUKARITUJYGN)
    public BizNumber getTmttknzoukaritujygn() {
        return tmttknzoukaritujygn;
    }

    public void setTmttknzoukaritujygn(BizNumber pTmttknzoukaritujygn) {
        tmttknzoukaritujygn = pTmttknzoukaritujygn;
    }

    private BizNumber setteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_YoteiRiritu3.SETTEIBAIRITU)
    public BizNumber getSetteibairitu() {
        return setteibairitu;
    }

    public void setSetteibairitu(BizNumber pSetteibairitu) {
        setteibairitu = pSetteibairitu;
    }

    private BizNumber loadinghnkgtumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_YoteiRiritu3.LOADINGHNKGTUMITATERIRITU)
    public BizNumber getLoadinghnkgtumitateriritu() {
        return loadinghnkgtumitateriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLoadinghnkgtumitateriritu(BizNumber pLoadinghnkgtumitateriritu) {
        loadinghnkgtumitateriritu = pLoadinghnkgtumitateriritu;
    }

    private BizNumber rendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_YoteiRiritu3.RENDOURITU)
    public BizNumber getRendouritu() {
        return rendouritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRendouritu(BizNumber pRendouritu) {
        rendouritu = pRendouritu;
    }
}