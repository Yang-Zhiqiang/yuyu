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
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.id.PKBM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.meta.GenQBM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.meta.QBM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.type.UserType_C_HhknNenKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 市場価格調整用利率マスタ テーブルのマッピング情報クラスで、 {@link BM_SjkkkTyouseiyouRiritu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SjkkkTyouseiyouRiritu}</td><td colspan="3">市場価格調整用利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_SjkkkTyouseiyouRiritu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_SjkkkTyouseiyouRiritu ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHhknnenkbn hhknnenkbn}</td><td>被保険者年齢区分</td><td align="center">{@link PKBM_SjkkkTyouseiyouRiritu ○}</td><td align="center">V</td><td>{@link C_HhknNenKbn}</td></tr>
 *  <tr><td>{@link #getKykfromymd kykfromymd}</td><td>契約日自</td><td align="center">{@link PKBM_SjkkkTyouseiyouRiritu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyktoymd kyktoymd}</td><td>契約日至</td><td align="center">{@link PKBM_SjkkkTyouseiyouRiritu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSjkkktyouseiyouriritu sjkkktyouseiyouriritu}</td><td>市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_SjkkkTyouseiyouRiritu
 * @see     PKBM_SjkkkTyouseiyouRiritu
 * @see     QBM_SjkkkTyouseiyouRiritu
 * @see     GenQBM_SjkkkTyouseiyouRiritu
 */
@MappedSuperclass
@Table(name=GenBM_SjkkkTyouseiyouRiritu.TABLE_NAME)
@IdClass(value=PKBM_SjkkkTyouseiyouRiritu.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HhknNenKbn", typeClass=UserType_C_HhknNenKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_SjkkkTyouseiyouRiritu extends AbstractExDBEntity<BM_SjkkkTyouseiyouRiritu, PKBM_SjkkkTyouseiyouRiritu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SjkkkTyouseiyouRiritu";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String HHKNNENKBN               = "hhknnenkbn";
    public static final String KYKFROMYMD               = "kykfromymd";
    public static final String KYKTOYMD                 = "kyktoymd";
    public static final String SJKKKTYOUSEIYOURIRITU    = "sjkkktyouseiyouriritu";

    private final PKBM_SjkkkTyouseiyouRiritu primaryKey;

    public GenBM_SjkkkTyouseiyouRiritu() {
        primaryKey = new PKBM_SjkkkTyouseiyouRiritu();
    }

    public GenBM_SjkkkTyouseiyouRiritu(
        String pSyouhncd,
        C_Tuukasyu pTuukasyu,
        C_HhknNenKbn pHhknnenkbn,
        BizDate pKykfromymd,
        BizDate pKyktoymd
    ) {
        primaryKey = new PKBM_SjkkkTyouseiyouRiritu(
            pSyouhncd,
            pTuukasyu,
            pHhknnenkbn,
            pKykfromymd,
            pKyktoymd
        );
    }

    @Transient
    @Override
    public PKBM_SjkkkTyouseiyouRiritu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SjkkkTyouseiyouRiritu> getMetaClass() {
        return QBM_SjkkkTyouseiyouRiritu.class;
    }

    @Id
    @Column(name=GenBM_SjkkkTyouseiyouRiritu.SYOUHNCD)
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
    @Column(name=GenBM_SjkkkTyouseiyouRiritu.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Type(type="UserType_C_HhknNenKbn")
    @Column(name=GenBM_SjkkkTyouseiyouRiritu.HHKNNENKBN)
    public C_HhknNenKbn getHhknnenkbn() {
        return getPrimaryKey().getHhknnenkbn();
    }

    public void setHhknnenkbn(C_HhknNenKbn pHhknnenkbn) {
        getPrimaryKey().setHhknnenkbn(pHhknnenkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_SjkkkTyouseiyouRiritu.KYKFROMYMD)
    public BizDate getKykfromymd() {
        return getPrimaryKey().getKykfromymd();
    }

    public void setKykfromymd(BizDate pKykfromymd) {
        getPrimaryKey().setKykfromymd(pKykfromymd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_SjkkkTyouseiyouRiritu.KYKTOYMD)
    public BizDate getKyktoymd() {
        return getPrimaryKey().getKyktoymd();
    }

    public void setKyktoymd(BizDate pKyktoymd) {
        getPrimaryKey().setKyktoymd(pKyktoymd);
    }

    private BizNumber sjkkktyouseiyouriritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SjkkkTyouseiyouRiritu.SJKKKTYOUSEIYOURIRITU)
    public BizNumber getSjkkktyouseiyouriritu() {
        return sjkkktyouseiyouriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSjkkktyouseiyouriritu(BizNumber pSjkkktyouseiyouriritu) {
        sjkkktyouseiyouriritu = pSjkkktyouseiyouriritu;
    }
}
