package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.db.id.PKIW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.db.meta.GenQIW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.db.meta.QIW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 継続Ｐ翌月充当予定ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhKzkPYokuJyuutouYoteiWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhKzkPYokuJyuutouYoteiWk}</td><td colspan="3">継続Ｐ翌月充当予定ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIW_KhKzkPYokuJyuutouYoteiWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIW_KhKzkPYokuJyuutouYoteiWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKykym kykym}</td><td>契約年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHknkkn hknkkn}</td><td>保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHokenryou hokenryou}</td><td>保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IW_KhKzkPYokuJyuutouYoteiWk
 * @see     PKIW_KhKzkPYokuJyuutouYoteiWk
 * @see     QIW_KhKzkPYokuJyuutouYoteiWk
 * @see     GenQIW_KhKzkPYokuJyuutouYoteiWk
 */
@MappedSuperclass
@Table(name=GenIW_KhKzkPYokuJyuutouYoteiWk.TABLE_NAME)
@IdClass(value=PKIW_KhKzkPYokuJyuutouYoteiWk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenIW_KhKzkPYokuJyuutouYoteiWk extends AbstractExDBEntity<IW_KhKzkPYokuJyuutouYoteiWk, PKIW_KhKzkPYokuJyuutouYoteiWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhKzkPYokuJyuutouYoteiWk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String KYKYM                    = "kykym";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String HKNKKN                   = "hknkkn";
    public static final String HOKENRYOU                = "hokenryou";

    private final PKIW_KhKzkPYokuJyuutouYoteiWk primaryKey;

    public GenIW_KhKzkPYokuJyuutouYoteiWk() {
        primaryKey = new PKIW_KhKzkPYokuJyuutouYoteiWk();
    }

    public GenIW_KhKzkPYokuJyuutouYoteiWk(String pKbnkey, String pSyono) {
        primaryKey = new PKIW_KhKzkPYokuJyuutouYoteiWk(pKbnkey, pSyono);
    }

    @Transient
    @Override
    public PKIW_KhKzkPYokuJyuutouYoteiWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhKzkPYokuJyuutouYoteiWk> getMetaClass() {
        return QIW_KhKzkPYokuJyuutouYoteiWk.class;
    }

    @Id
    @Column(name=GenIW_KhKzkPYokuJyuutouYoteiWk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIW_KhKzkPYokuJyuutouYoteiWk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String syouhncd;

    @Column(name=GenIW_KhKzkPYokuJyuutouYoteiWk.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIW_KhKzkPYokuJyuutouYoteiWk.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizDateYM kykym;

    @Type(type="BizDateYMType")
    @Column(name=GenIW_KhKzkPYokuJyuutouYoteiWk.KYKYM)
    @ValidDateYm
    public BizDateYM getKykym() {
        return kykym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykym(BizDateYM pKykym) {
        kykym = pKykym;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIW_KhKzkPYokuJyuutouYoteiWk.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer hknkkn;

    @Column(name=GenIW_KhKzkPYokuJyuutouYoteiWk.HKNKKN)
    @Range(min="0", max="99")
    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    private BizCurrency hokenryou;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
        hokenryouValue = null;
        hokenryouType  = null;
    }

    transient private BigDecimal hokenryouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HOKENRYOU, nullable=true)
    protected BigDecimal getHokenryouValue() {
        if (hokenryouValue == null && hokenryou != null) {
            if (hokenryou.isOptional()) return null;
            return hokenryou.absolute();
        }
        return hokenryouValue;
    }

    protected void setHokenryouValue(BigDecimal value) {
        hokenryouValue = value;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    transient private String hokenryouType = null;

    @Column(name=HOKENRYOU + "$", nullable=true)
    protected String getHokenryouType() {
        if (hokenryouType == null && hokenryou != null) return hokenryou.getType().toString();
        if (hokenryouType == null && getHokenryouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hokenryou$' should not be NULL."));
        }
        return hokenryouType;
    }

    protected void setHokenryouType(String type) {
        hokenryouType = type;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }
}