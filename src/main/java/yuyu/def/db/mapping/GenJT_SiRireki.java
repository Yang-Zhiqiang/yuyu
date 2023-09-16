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
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.id.PKJT_SiRireki;
import yuyu.def.db.meta.GenQJT_SiRireki;
import yuyu.def.db.meta.QJT_SiRireki;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払履歴テーブル テーブルのマッピング情報クラスで、 {@link JT_SiRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiRireki}</td><td colspan="3">支払履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrsikibetukey shrsikibetukey}</td><td>支払識別キー</td><td align="center">{@link PKJT_SiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrkekkakbn shrkekkakbn}</td><td>支払結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrKekkaKbn}</td></tr>
 *  <tr><td>{@link #getShrsyoriymd shrsyoriymd}</td><td>支払処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTyakkinymd tyakkinymd}</td><td>着金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrgkkei shrgkkei}</td><td>支払額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZeitratkikbn zeitratkikbn}</td><td>税取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZeitratkiKbn}</td></tr>
 *  <tr><td>{@link #getTorikesiflg torikesiflg}</td><td>取消フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTorikesiymd torikesiymd}</td><td>取消日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiRireki
 * @see     PKJT_SiRireki
 * @see     QJT_SiRireki
 * @see     GenQJT_SiRireki
 */
@MappedSuperclass
@Table(name=GenJT_SiRireki.TABLE_NAME)
@IdClass(value=PKJT_SiRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_ShrKekkaKbn", typeClass=UserType_C_ShrKekkaKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_ZeitratkiKbn", typeClass=UserType_C_ZeitratkiKbn.class)
})
public abstract class GenJT_SiRireki extends AbstractExDBEntity<JT_SiRireki, PKJT_SiRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiRireki";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SHRSIKIBETUKEY           = "shrsikibetukey";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String SHRKEKKAKBN              = "shrkekkakbn";
    public static final String SHRSYORIYMD              = "shrsyoriymd";
    public static final String TYAKKINYMD               = "tyakkinymd";
    public static final String SHRGKKEI                 = "shrgkkei";
    public static final String ZEITRATKIKBN             = "zeitratkikbn";
    public static final String TORIKESIFLG              = "torikesiflg";
    public static final String TORIKESIYMD              = "torikesiymd";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiRireki primaryKey;

    public GenJT_SiRireki() {
        primaryKey = new PKJT_SiRireki();
    }

    public GenJT_SiRireki(
        String pSkno,
        String pSyono,
        String pShrsikibetukey
    ) {
        primaryKey = new PKJT_SiRireki(
            pSkno,
            pSyono,
            pShrsikibetukey
        );
    }

    @Transient
    @Override
    public PKJT_SiRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiRireki> getMetaClass() {
        return QJT_SiRireki.class;
    }

    @Id
    @Column(name=GenJT_SiRireki.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SiRireki.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenJT_SiRireki.SHRSIKIBETUKEY)
    public String getShrsikibetukey() {
        return getPrimaryKey().getShrsikibetukey();
    }

    public void setShrsikibetukey(String pShrsikibetukey) {
        getPrimaryKey().setShrsikibetukey(pShrsikibetukey);
    }

    private Integer seikyuurirekino;

    @Column(name=GenJT_SiRireki.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }

    private C_ShrKekkaKbn shrkekkakbn;

    @Type(type="UserType_C_ShrKekkaKbn")
    @Column(name=GenJT_SiRireki.SHRKEKKAKBN)
    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    private BizDate shrsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiRireki.SHRSYORIYMD)
    @ValidDate
    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    private BizDate tyakkinymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiRireki.TYAKKINYMD)
    @ValidDate
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private BizCurrency shrgkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
        shrgkkeiValue = null;
        shrgkkeiType  = null;
    }

    transient private BigDecimal shrgkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRGKKEI, nullable=true)
    protected BigDecimal getShrgkkeiValue() {
        if (shrgkkeiValue == null && shrgkkei != null) {
            if (shrgkkei.isOptional()) return null;
            return shrgkkei.absolute();
        }
        return shrgkkeiValue;
    }

    protected void setShrgkkeiValue(BigDecimal value) {
        shrgkkeiValue = value;
        shrgkkei = Optional.fromNullable(toCurrencyType(shrgkkeiType))
            .transform(bizCurrencyTransformer(getShrgkkeiValue()))
            .orNull();
    }

    transient private String shrgkkeiType = null;

    @Column(name=SHRGKKEI + "$", nullable=true)
    protected String getShrgkkeiType() {
        if (shrgkkeiType == null && shrgkkei != null) return shrgkkei.getType().toString();
        if (shrgkkeiType == null && getShrgkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrgkkei$' should not be NULL."));
        }
        return shrgkkeiType;
    }

    protected void setShrgkkeiType(String type) {
        shrgkkeiType = type;
        shrgkkei = Optional.fromNullable(toCurrencyType(shrgkkeiType))
            .transform(bizCurrencyTransformer(getShrgkkeiValue()))
            .orNull();
    }

    private C_ZeitratkiKbn zeitratkikbn;

    @Type(type="UserType_C_ZeitratkiKbn")
    @Column(name=GenJT_SiRireki.ZEITRATKIKBN)
    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }

    private C_UmuKbn torikesiflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiRireki.TORIKESIFLG)
    public C_UmuKbn getTorikesiflg() {
        return torikesiflg;
    }

    public void setTorikesiflg(C_UmuKbn pTorikesiflg) {
        torikesiflg = pTorikesiflg;
    }

    private BizDate torikesiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiRireki.TORIKESIYMD)
    public BizDate getTorikesiymd() {
        return torikesiymd;
    }

    @Trim("both")
    public void setTorikesiymd(BizDate pTorikesiymd) {
        torikesiymd = pTorikesiymd;
    }

    private String kossyoricd;

    @Column(name=GenJT_SiRireki.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SiRireki.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}