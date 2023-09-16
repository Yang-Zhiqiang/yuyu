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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_AzukariRiritu;
import yuyu.def.db.id.PKBM_AzukariRiritu;
import yuyu.def.db.meta.GenQBM_AzukariRiritu;
import yuyu.def.db.meta.QBM_AzukariRiritu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 預り利率マスタ テーブルのマッピング情報クラスで、 {@link BM_AzukariRiritu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_AzukariRiritu}</td><td colspan="3">預り利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_AzukariRiritu ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTkyfromymd tkyfromymd}</td><td>適用日自</td><td align="center">{@link PKBM_AzukariRiritu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTkytoymd tkytoymd}</td><td>適用日至</td><td align="center">{@link PKBM_AzukariRiritu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAzukaririritu azukaririritu}</td><td>預り利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_AzukariRiritu
 * @see     PKBM_AzukariRiritu
 * @see     QBM_AzukariRiritu
 * @see     GenQBM_AzukariRiritu
 */
@MappedSuperclass
@Table(name=GenBM_AzukariRiritu.TABLE_NAME)
@IdClass(value=PKBM_AzukariRiritu.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_AzukariRiritu extends AbstractExDBEntity<BM_AzukariRiritu, PKBM_AzukariRiritu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_AzukariRiritu";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String TKYFROMYMD               = "tkyfromymd";
    public static final String TKYTOYMD                 = "tkytoymd";
    public static final String AZUKARIRIRITU            = "azukaririritu";

    private final PKBM_AzukariRiritu primaryKey;

    public GenBM_AzukariRiritu() {
        primaryKey = new PKBM_AzukariRiritu();
    }

    public GenBM_AzukariRiritu(
        C_Tuukasyu pTuukasyu,
        BizDate pTkyfromymd,
        BizDate pTkytoymd
    ) {
        primaryKey = new PKBM_AzukariRiritu(
            pTuukasyu,
            pTkyfromymd,
            pTkytoymd
        );
    }

    @Transient
    @Override
    public PKBM_AzukariRiritu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_AzukariRiritu> getMetaClass() {
        return QBM_AzukariRiritu.class;
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_AzukariRiritu.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_AzukariRiritu.TKYFROMYMD)
    @ValidDate
    public BizDate getTkyfromymd() {
        return getPrimaryKey().getTkyfromymd();
    }

    @Trim("both")
    public void setTkyfromymd(BizDate pTkyfromymd) {
        getPrimaryKey().setTkyfromymd(pTkyfromymd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_AzukariRiritu.TKYTOYMD)
    @ValidDate
    public BizDate getTkytoymd() {
        return getPrimaryKey().getTkytoymd();
    }

    @Trim("both")
    public void setTkytoymd(BizDate pTkytoymd) {
        getPrimaryKey().setTkytoymd(pTkytoymd);
    }

    private BizNumber azukaririritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_AzukariRiritu.AZUKARIRIRITU)
    public BizNumber getAzukaririritu() {
        return azukaririritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAzukaririritu(BizNumber pAzukaririritu) {
        azukaririritu = pAzukaririritu;
    }
}