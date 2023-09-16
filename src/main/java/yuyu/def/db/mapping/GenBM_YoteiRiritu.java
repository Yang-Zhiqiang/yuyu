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
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.def.db.id.PKBM_YoteiRiritu;
import yuyu.def.db.meta.GenQBM_YoteiRiritu;
import yuyu.def.db.meta.QBM_YoteiRiritu;
import yuyu.def.db.type.UserType_C_HhknNenKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 予定利率マスタ テーブルのマッピング情報クラスで、 {@link BM_YoteiRiritu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_YoteiRiritu}</td><td colspan="3">予定利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_YoteiRiritu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_YoteiRiritu ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHhknnenkbn hhknnenkbn}</td><td>被保険者年齢区分</td><td align="center">{@link PKBM_YoteiRiritu ○}</td><td align="center">V</td><td>{@link C_HhknNenKbn}</td></tr>
 *  <tr><td>{@link #getKykfromymd kykfromymd}</td><td>契約日自</td><td align="center">{@link PKBM_YoteiRiritu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyktoymd kyktoymd}</td><td>契約日至</td><td align="center">{@link PKBM_YoteiRiritu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_YoteiRiritu
 * @see     PKBM_YoteiRiritu
 * @see     QBM_YoteiRiritu
 * @see     GenQBM_YoteiRiritu
 */
@MappedSuperclass
@Table(name=GenBM_YoteiRiritu.TABLE_NAME)
@IdClass(value=PKBM_YoteiRiritu.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HhknNenKbn", typeClass=UserType_C_HhknNenKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_YoteiRiritu extends AbstractExDBEntity<BM_YoteiRiritu, PKBM_YoteiRiritu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_YoteiRiritu";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String HHKNNENKBN               = "hhknnenkbn";
    public static final String KYKFROMYMD               = "kykfromymd";
    public static final String KYKTOYMD                 = "kyktoymd";
    public static final String YOTEIRIRITU              = "yoteiriritu";

    private final PKBM_YoteiRiritu primaryKey;

    public GenBM_YoteiRiritu() {
        primaryKey = new PKBM_YoteiRiritu();
    }

    public GenBM_YoteiRiritu(
        String pSyouhncd,
        C_Tuukasyu pTuukasyu,
        C_HhknNenKbn pHhknnenkbn,
        BizDate pKykfromymd,
        BizDate pKyktoymd
    ) {
        primaryKey = new PKBM_YoteiRiritu(
            pSyouhncd,
            pTuukasyu,
            pHhknnenkbn,
            pKykfromymd,
            pKyktoymd
        );
    }

    @Transient
    @Override
    public PKBM_YoteiRiritu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_YoteiRiritu> getMetaClass() {
        return QBM_YoteiRiritu.class;
    }

    @Id
    @Column(name=GenBM_YoteiRiritu.SYOUHNCD)
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
    @Column(name=GenBM_YoteiRiritu.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Type(type="UserType_C_HhknNenKbn")
    @Column(name=GenBM_YoteiRiritu.HHKNNENKBN)
    public C_HhknNenKbn getHhknnenkbn() {
        return getPrimaryKey().getHhknnenkbn();
    }

    public void setHhknnenkbn(C_HhknNenKbn pHhknnenkbn) {
        getPrimaryKey().setHhknnenkbn(pHhknnenkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_YoteiRiritu.KYKFROMYMD)
    public BizDate getKykfromymd() {
        return getPrimaryKey().getKykfromymd();
    }

    public void setKykfromymd(BizDate pKykfromymd) {
        getPrimaryKey().setKykfromymd(pKykfromymd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_YoteiRiritu.KYKTOYMD)
    public BizDate getKyktoymd() {
        return getPrimaryKey().getKyktoymd();
    }

    public void setKyktoymd(BizDate pKyktoymd) {
        getPrimaryKey().setKyktoymd(pKyktoymd);
    }

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_YoteiRiritu.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }
}
