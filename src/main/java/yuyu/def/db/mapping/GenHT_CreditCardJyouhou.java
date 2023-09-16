package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.id.PKHT_CreditCardJyouhou;
import yuyu.def.db.meta.GenQHT_CreditCardJyouhou;
import yuyu.def.db.meta.QHT_CreditCardJyouhou;
import yuyu.def.db.type.UserType_C_CardBrandKbn;
import yuyu.def.db.type.UserType_C_CreditTrkhouKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * クレジットカード情報テーブル テーブルのマッピング情報クラスで、 {@link HT_CreditCardJyouhou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_CreditCardJyouhou}</td><td colspan="3">クレジットカード情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_CreditCardJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardbrandkbn cardbrandkbn}</td><td>カードブランド区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CardBrandKbn}</td></tr>
 *  <tr><td>{@link #getCredittrkhoukbn credittrkhoukbn}</td><td>クレジットカード登録方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditTrkhouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_CreditCardJyouhou
 * @see     PKHT_CreditCardJyouhou
 * @see     QHT_CreditCardJyouhou
 * @see     GenQHT_CreditCardJyouhou
 */
@MappedSuperclass
@Table(name=GenHT_CreditCardJyouhou.TABLE_NAME)
@IdClass(value=PKHT_CreditCardJyouhou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_CardBrandKbn", typeClass=UserType_C_CardBrandKbn.class),
    @TypeDef(name="UserType_C_CreditTrkhouKbn", typeClass=UserType_C_CreditTrkhouKbn.class)
})
public abstract class GenHT_CreditCardJyouhou extends AbstractExDBEntity<HT_CreditCardJyouhou, PKHT_CreditCardJyouhou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_CreditCardJyouhou";
    public static final String MOSNO                    = "mosno";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String CARDBRANDKBN             = "cardbrandkbn";
    public static final String CREDITTRKHOUKBN          = "credittrkhoukbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_CreditCardJyouhou primaryKey;

    public GenHT_CreditCardJyouhou() {
        primaryKey = new PKHT_CreditCardJyouhou();
    }

    public GenHT_CreditCardJyouhou(String pMosno) {
        primaryKey = new PKHT_CreditCardJyouhou(pMosno);
    }

    @Transient
    @Override
    public PKHT_CreditCardJyouhou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_CreditCardJyouhou> getMetaClass() {
        return QHT_CreditCardJyouhou.class;
    }

    @Id
    @Column(name=GenHT_CreditCardJyouhou.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private String creditkessaiyouno;

    @Column(name=GenHT_CreditCardJyouhou.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    private C_CardBrandKbn cardbrandkbn;

    @Type(type="UserType_C_CardBrandKbn")
    @Column(name=GenHT_CreditCardJyouhou.CARDBRANDKBN)
    public C_CardBrandKbn getCardbrandkbn() {
        return cardbrandkbn;
    }

    public void setCardbrandkbn(C_CardBrandKbn pCardbrandkbn) {
        cardbrandkbn = pCardbrandkbn;
    }

    private C_CreditTrkhouKbn credittrkhoukbn;

    @Type(type="UserType_C_CreditTrkhouKbn")
    @Column(name=GenHT_CreditCardJyouhou.CREDITTRKHOUKBN)
    public C_CreditTrkhouKbn getCredittrkhoukbn() {
        return credittrkhoukbn;
    }

    public void setCredittrkhoukbn(C_CreditTrkhouKbn pCredittrkhoukbn) {
        credittrkhoukbn = pCredittrkhoukbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_CreditCardJyouhou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_CreditCardJyouhou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}