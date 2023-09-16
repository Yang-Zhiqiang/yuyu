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
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.id.PKBM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.meta.GenQBM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.meta.QBM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 市場価格調整用利率マスタ２ テーブルのマッピング情報クラスで、 {@link BM_SjkkkTyouseiyouRiritu2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SjkkkTyouseiyouRiritu2}</td><td colspan="3">市場価格調整用利率マスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_SjkkkTyouseiyouRiritu2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSjkkktyouseiriritutkybr1 sjkkktyouseiriritutkybr1}</td><td>市場価格調整用利率適用分類１</td><td align="center">{@link PKBM_SjkkkTyouseiyouRiritu2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSjkkktyouseiriritutkybr2 sjkkktyouseiriritutkybr2}</td><td>市場価格調整用利率適用分類２</td><td align="center">{@link PKBM_SjkkkTyouseiyouRiritu2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKijyunfromymd kijyunfromymd}</td><td>基準日自</td><td align="center">{@link PKBM_SjkkkTyouseiyouRiritu2 ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKijyuntoymd kijyuntoymd}</td><td>基準日至</td><td align="center">{@link PKBM_SjkkkTyouseiyouRiritu2 ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSjkkktyouseiyouriritu sjkkktyouseiyouriritu}</td><td>市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_SjkkkTyouseiyouRiritu2
 * @see     PKBM_SjkkkTyouseiyouRiritu2
 * @see     QBM_SjkkkTyouseiyouRiritu2
 * @see     GenQBM_SjkkkTyouseiyouRiritu2
 */
@MappedSuperclass
@Table(name=GenBM_SjkkkTyouseiyouRiritu2.TABLE_NAME)
@IdClass(value=PKBM_SjkkkTyouseiyouRiritu2.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_SjkkkTyouseiyouRiritu2 extends AbstractExDBEntity<BM_SjkkkTyouseiyouRiritu2, PKBM_SjkkkTyouseiyouRiritu2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SjkkkTyouseiyouRiritu2";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SJKKKTYOUSEIRIRITUTKYBR1 = "sjkkktyouseiriritutkybr1";
    public static final String SJKKKTYOUSEIRIRITUTKYBR2 = "sjkkktyouseiriritutkybr2";
    public static final String KIJYUNFROMYMD            = "kijyunfromymd";
    public static final String KIJYUNTOYMD              = "kijyuntoymd";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String SJKKKTYOUSEIYOURIRITU    = "sjkkktyouseiyouriritu";

    private final PKBM_SjkkkTyouseiyouRiritu2 primaryKey;

    public GenBM_SjkkkTyouseiyouRiritu2() {
        primaryKey = new PKBM_SjkkkTyouseiyouRiritu2();
    }

    public GenBM_SjkkkTyouseiyouRiritu2(
        String pSyouhncd,
        String pSjkkktyouseiriritutkybr1,
        String pSjkkktyouseiriritutkybr2,
        BizDate pKijyunfromymd,
        BizDate pKijyuntoymd
    ) {
        primaryKey = new PKBM_SjkkkTyouseiyouRiritu2(
            pSyouhncd,
            pSjkkktyouseiriritutkybr1,
            pSjkkktyouseiriritutkybr2,
            pKijyunfromymd,
            pKijyuntoymd
        );
    }

    @Transient
    @Override
    public PKBM_SjkkkTyouseiyouRiritu2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SjkkkTyouseiyouRiritu2> getMetaClass() {
        return QBM_SjkkkTyouseiyouRiritu2.class;
    }

    @Id
    @Column(name=GenBM_SjkkkTyouseiyouRiritu2.SYOUHNCD)
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
    @Column(name=GenBM_SjkkkTyouseiyouRiritu2.SJKKKTYOUSEIRIRITUTKYBR1)
    public String getSjkkktyouseiriritutkybr1() {
        return getPrimaryKey().getSjkkktyouseiriritutkybr1();
    }

    public void setSjkkktyouseiriritutkybr1(String pSjkkktyouseiriritutkybr1) {
        getPrimaryKey().setSjkkktyouseiriritutkybr1(pSjkkktyouseiriritutkybr1);
    }

    @Id
    @Column(name=GenBM_SjkkkTyouseiyouRiritu2.SJKKKTYOUSEIRIRITUTKYBR2)
    public String getSjkkktyouseiriritutkybr2() {
        return getPrimaryKey().getSjkkktyouseiriritutkybr2();
    }

    public void setSjkkktyouseiriritutkybr2(String pSjkkktyouseiriritutkybr2) {
        getPrimaryKey().setSjkkktyouseiriritutkybr2(pSjkkktyouseiriritutkybr2);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_SjkkkTyouseiyouRiritu2.KIJYUNFROMYMD)
    public BizDate getKijyunfromymd() {
        return getPrimaryKey().getKijyunfromymd();
    }

    public void setKijyunfromymd(BizDate pKijyunfromymd) {
        getPrimaryKey().setKijyunfromymd(pKijyunfromymd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_SjkkkTyouseiyouRiritu2.KIJYUNTOYMD)
    public BizDate getKijyuntoymd() {
        return getPrimaryKey().getKijyuntoymd();
    }

    public void setKijyuntoymd(BizDate pKijyuntoymd) {
        getPrimaryKey().setKijyuntoymd(pKijyuntoymd);
    }

    private C_Tuukasyu tuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_SjkkkTyouseiyouRiritu2.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    private BizNumber sjkkktyouseiyouriritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SjkkkTyouseiyouRiritu2.SJKKKTYOUSEIYOURIRITU)
    public BizNumber getSjkkktyouseiyouriritu() {
        return sjkkktyouseiyouriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSjkkktyouseiyouriritu(BizNumber pSjkkktyouseiyouriritu) {
        sjkkktyouseiyouriritu = pSjkkktyouseiyouriritu;
    }
}