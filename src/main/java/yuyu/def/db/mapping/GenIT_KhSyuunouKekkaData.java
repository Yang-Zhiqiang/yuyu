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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KhSyuunouKekkaData;
import yuyu.def.db.id.PKIT_KhSyuunouKekkaData;
import yuyu.def.db.meta.GenQIT_KhSyuunouKekkaData;
import yuyu.def.db.meta.QIT_KhSyuunouKekkaData;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 収納結果データテーブル テーブルのマッピング情報クラスで、 {@link IT_KhSyuunouKekkaData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhSyuunouKekkaData}</td><td colspan="3">収納結果データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhSyuunouKekkaData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">{@link PKIT_KhSyuunouKekkaData ○}</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_KhSyuunouKekkaData ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhSyuunouKekkaData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaeymd hurikaeymd}</td><td>振替日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">{@link PKIT_KhSyuunouKekkaData ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDantaikobetukbn dantaikobetukbn}</td><td>団体個別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getKzhurikaetkbtannaihyj kzhurikaetkbtannaihyj}</td><td>口座振替特別案内表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurihunokbn hurihunokbn}</td><td>振替不能理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HurihunoKbn}</td></tr>
 *  <tr><td>{@link #getSyuudaikocd syuudaikocd}</td><td>収納代行社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syuudaikocd}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhSyuunouKekkaData
 * @see     PKIT_KhSyuunouKekkaData
 * @see     QIT_KhSyuunouKekkaData
 * @see     GenQIT_KhSyuunouKekkaData
 */
@MappedSuperclass
@Table(name=GenIT_KhSyuunouKekkaData.TABLE_NAME)
@IdClass(value=PKIT_KhSyuunouKekkaData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AnsyuusysKbn", typeClass=UserType_C_AnsyuusysKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_HurihunoKbn", typeClass=UserType_C_HurihunoKbn.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_Syuudaikocd", typeClass=UserType_C_Syuudaikocd.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_KhSyuunouKekkaData extends AbstractExDBEntity<IT_KhSyuunouKekkaData, PKIT_KhSyuunouKekkaData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhSyuunouKekkaData";
    public static final String KBNKEY                   = "kbnkey";
    public static final String ANSYUUSYSKBN             = "ansyuusyskbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYONO                    = "syono";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String HURIKAEYMD               = "hurikaeymd";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String RSGAKU                   = "rsgaku";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String DANTAIKOBETUKBN          = "dantaikobetukbn";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String KZHURIKAETKBTANNAIHYJ    = "kzhurikaetkbtannaihyj";
    public static final String HURIHUNOKBN              = "hurihunokbn";
    public static final String SYUUDAIKOCD              = "syuudaikocd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhSyuunouKekkaData primaryKey;

    public GenIT_KhSyuunouKekkaData() {
        primaryKey = new PKIT_KhSyuunouKekkaData();
    }

    public GenIT_KhSyuunouKekkaData(
        String pKbnkey,
        C_AnsyuusysKbn pAnsyuusyskbn,
        BizDate pSyoriYmd,
        String pSyono,
        BizDateYM pJyuutouym
    ) {
        primaryKey = new PKIT_KhSyuunouKekkaData(
            pKbnkey,
            pAnsyuusyskbn,
            pSyoriYmd,
            pSyono,
            pJyuutouym
        );
    }

    @Transient
    @Override
    public PKIT_KhSyuunouKekkaData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhSyuunouKekkaData> getMetaClass() {
        return QIT_KhSyuunouKekkaData.class;
    }

    @Id
    @Column(name=GenIT_KhSyuunouKekkaData.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Type(type="UserType_C_AnsyuusysKbn")
    @Column(name=GenIT_KhSyuunouKekkaData.ANSYUUSYSKBN)
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return getPrimaryKey().getAnsyuusyskbn();
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        getPrimaryKey().setAnsyuusyskbn(pAnsyuusyskbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_KhSyuunouKekkaData.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Column(name=GenIT_KhSyuunouKekkaData.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String bankcd;

    @Column(name=GenIT_KhSyuunouKekkaData.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd;

    @Column(name=GenIT_KhSyuunouKekkaData.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenIT_KhSyuunouKekkaData.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_KhSyuunouKekkaData.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private BizDate hurikaeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhSyuunouKekkaData.HURIKAEYMD)
    public BizDate getHurikaeymd() {
        return hurikaeymd;
    }

    public void setHurikaeymd(BizDate pHurikaeymd) {
        hurikaeymd = pHurikaeymd;
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenIT_KhSyuunouKekkaData.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return getPrimaryKey().getJyuutouym();
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        getPrimaryKey().setJyuutouym(pJyuutouym);
    }

    private BizCurrency rsgaku;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getRsgaku() {
        return rsgaku;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRsgaku(BizCurrency pRsgaku) {
        rsgaku = pRsgaku;
        rsgakuValue = null;
        rsgakuType  = null;
    }

    transient private BigDecimal rsgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RSGAKU, nullable=true)
    protected BigDecimal getRsgakuValue() {
        if (rsgakuValue == null && rsgaku != null) {
            if (rsgaku.isOptional()) return null;
            return rsgaku.absolute();
        }
        return rsgakuValue;
    }

    protected void setRsgakuValue(BigDecimal value) {
        rsgakuValue = value;
        rsgaku = Optional.fromNullable(toCurrencyType(rsgakuType))
            .transform(bizCurrencyTransformer(getRsgakuValue()))
            .orNull();
    }

    transient private String rsgakuType = null;

    @Column(name=RSGAKU + "$", nullable=true)
    protected String getRsgakuType() {
        if (rsgakuType == null && rsgaku != null) return rsgaku.getType().toString();
        if (rsgakuType == null && getRsgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rsgaku$' should not be NULL."));
        }
        return rsgakuType;
    }

    protected void setRsgakuType(String type) {
        rsgakuType = type;
        rsgaku = Optional.fromNullable(toCurrencyType(rsgakuType))
            .transform(bizCurrencyTransformer(getRsgakuValue()))
            .orNull();
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_KhSyuunouKekkaData.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_KhSyuunouKekkaData.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private String dantaikobetukbn;

    @Column(name=GenIT_KhSyuunouKekkaData.DANTAIKOBETUKBN)
    public String getDantaikobetukbn() {
        return dantaikobetukbn;
    }

    public void setDantaikobetukbn(String pDantaikobetukbn) {
        dantaikobetukbn = pDantaikobetukbn;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_KhSyuunouKekkaData.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_KhSyuunouKekkaData.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private String kzhurikaetkbtannaihyj;

    @Column(name=GenIT_KhSyuunouKekkaData.KZHURIKAETKBTANNAIHYJ)
    public String getKzhurikaetkbtannaihyj() {
        return kzhurikaetkbtannaihyj;
    }

    public void setKzhurikaetkbtannaihyj(String pKzhurikaetkbtannaihyj) {
        kzhurikaetkbtannaihyj = pKzhurikaetkbtannaihyj;
    }

    private C_HurihunoKbn hurihunokbn;

    @Type(type="UserType_C_HurihunoKbn")
    @Column(name=GenIT_KhSyuunouKekkaData.HURIHUNOKBN)
    public C_HurihunoKbn getHurihunokbn() {
        return hurihunokbn;
    }

    public void setHurihunokbn(C_HurihunoKbn pHurihunokbn) {
        hurihunokbn = pHurihunokbn;
    }

    private C_Syuudaikocd syuudaikocd;

    @Type(type="UserType_C_Syuudaikocd")
    @Column(name=GenIT_KhSyuunouKekkaData.SYUUDAIKOCD)
    public C_Syuudaikocd getSyuudaikocd() {
        return syuudaikocd;
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikocd = pSyuudaikocd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhSyuunouKekkaData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhSyuunouKekkaData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhSyuunouKekkaData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}