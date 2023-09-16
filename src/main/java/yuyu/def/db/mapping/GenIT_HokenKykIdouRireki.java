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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KykIdouHaraikataKbn;
import yuyu.def.classification.C_TumitatekinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZfiIdoujiyuuKbn;
import yuyu.def.classification.C_ZougenKbn;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.id.PKIT_HokenKykIdouRireki;
import yuyu.def.db.meta.GenQIT_HokenKykIdouRireki;
import yuyu.def.db.meta.QIT_HokenKykIdouRireki;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_KykIdouHaraikataKbn;
import yuyu.def.db.type.UserType_C_TumitatekinKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_ZfiIdoujiyuuKbn;
import yuyu.def.db.type.UserType_C_ZougenKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険契約異動情報履歴テーブル テーブルのマッピング情報クラスで、 {@link IT_HokenKykIdouRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HokenKykIdouRireki}</td><td colspan="3">保険契約異動情報履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_HokenKykIdouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_HokenKykIdouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_HokenKykIdouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getIdouymd idouymd}</td><td>異動日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getIdoujiyuukbn idoujiyuukbn}</td><td>異動事由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZfiIdoujiyuuKbn}</td></tr>
 *  <tr><td>{@link #getTtdkrenno ttdkrenno}</td><td>手続連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisyoumeikbn aisyoumeikbn}</td><td>愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AisyoumeiKbn}</td></tr>
 *  <tr><td>{@link #getZougenkbn zougenkbn}</td><td>増減区分</td><td align="center">{@link PKIT_HokenKykIdouRireki ○}</td><td align="center">V</td><td>{@link C_ZougenKbn}</td></tr>
 *  <tr><td>{@link #getHokenkngk hokenkngk}</td><td>保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHokenryou hokenryou}</td><td>保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getPtumitatekin ptumitatekin}</td><td>保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakuhrgoukei kaiyakuhrgoukei}</td><td>解約返戻金合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakuhr kaiyakuhr}</td><td>解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMikeikap mikeikap}</td><td>未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennouseisankgk zennouseisankgk}</td><td>前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getIdouhokenkngk idouhokenkngk}</td><td>異動保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getIdoup idoup}</td><td>異動保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getIdouptumitatekin idouptumitatekin}</td><td>異動保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getIdoukiykhnrikn idoukiykhnrikn}</td><td>異動解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHknkkn hknkkn}</td><td>保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTumitatekinkbn tumitatekinkbn}</td><td>積立金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TumitatekinKbn}</td></tr>
 *  <tr><td>{@link #getKykidouharaikatakbn kykidouharaikatakbn}</td><td>保険契約異動情報払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykIdouHaraikataKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HokenKykIdouRireki
 * @see     PKIT_HokenKykIdouRireki
 * @see     QIT_HokenKykIdouRireki
 * @see     GenQIT_HokenKykIdouRireki
 */
@MappedSuperclass
@Table(name=GenIT_HokenKykIdouRireki.TABLE_NAME)
@IdClass(value=PKIT_HokenKykIdouRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_AisyoumeiKbn", typeClass=UserType_C_AisyoumeiKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_KykIdouHaraikataKbn", typeClass=UserType_C_KykIdouHaraikataKbn.class),
    @TypeDef(name="UserType_C_TumitatekinKbn", typeClass=UserType_C_TumitatekinKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_ZfiIdoujiyuuKbn", typeClass=UserType_C_ZfiIdoujiyuuKbn.class),
    @TypeDef(name="UserType_C_ZougenKbn", typeClass=UserType_C_ZougenKbn.class)
})
public abstract class GenIT_HokenKykIdouRireki extends AbstractExDBEntity<IT_HokenKykIdouRireki, PKIT_HokenKykIdouRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_HokenKykIdouRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String IDOUYMD                  = "idouymd";
    public static final String IDOUJIYUUKBN             = "idoujiyuukbn";
    public static final String TTDKRENNO                = "ttdkrenno";
    public static final String KYKYMD                   = "kykymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String AISYOUMEIKBN             = "aisyoumeikbn";
    public static final String ZOUGENKBN                = "zougenkbn";
    public static final String HOKENKNGK                = "hokenkngk";
    public static final String HOKENRYOU                = "hokenryou";
    public static final String PTUMITATEKIN             = "ptumitatekin";
    public static final String KAIYAKUHRGOUKEI          = "kaiyakuhrgoukei";
    public static final String KAIYAKUHR                = "kaiyakuhr";
    public static final String MIKEIKAP                 = "mikeikap";
    public static final String ZENNOUSEISANKGK          = "zennouseisankgk";
    public static final String IDOUHOKENKNGK            = "idouhokenkngk";
    public static final String IDOUP                    = "idoup";
    public static final String IDOUPTUMITATEKIN         = "idouptumitatekin";
    public static final String IDOUKIYKHNRIKN           = "idoukiykhnrikn";
    public static final String HKNKKN                   = "hknkkn";
    public static final String YOTEIRIRITU              = "yoteiriritu";
    public static final String TUMITATEKINKBN           = "tumitatekinkbn";
    public static final String KYKIDOUHARAIKATAKBN      = "kykidouharaikatakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_HokenKykIdouRireki primaryKey;

    public GenIT_HokenKykIdouRireki() {
        primaryKey = new PKIT_HokenKykIdouRireki();
    }

    public GenIT_HokenKykIdouRireki(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey,
        C_ZougenKbn pZougenkbn
    ) {
        primaryKey = new PKIT_HokenKykIdouRireki(
            pKbnkey,
            pSyono,
            pHenkousikibetukey,
            pZougenkbn
        );
    }

    @Transient
    @Override
    public PKIT_HokenKykIdouRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_HokenKykIdouRireki> getMetaClass() {
        return QIT_HokenKykIdouRireki.class;
    }

    @Id
    @Column(name=GenIT_HokenKykIdouRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_HokenKykIdouRireki.SYONO)
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
    @Column(name=GenIT_HokenKykIdouRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_HokenKykIdouRireki.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizDate idouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HokenKykIdouRireki.IDOUYMD)
    public BizDate getIdouymd() {
        return idouymd;
    }

    @Trim("both")
    public void setIdouymd(BizDate pIdouymd) {
        idouymd = pIdouymd;
    }

    private C_ZfiIdoujiyuuKbn idoujiyuukbn;

    @Type(type="UserType_C_ZfiIdoujiyuuKbn")
    @Column(name=GenIT_HokenKykIdouRireki.IDOUJIYUUKBN)
    public C_ZfiIdoujiyuuKbn getIdoujiyuukbn() {
        return idoujiyuukbn;
    }

    public void setIdoujiyuukbn(C_ZfiIdoujiyuuKbn pIdoujiyuukbn) {
        idoujiyuukbn = pIdoujiyuukbn;
    }

    private Integer ttdkrenno;

    @Column(name=GenIT_HokenKykIdouRireki.TTDKRENNO)
    public Integer getTtdkrenno() {
        return ttdkrenno;
    }

    public void setTtdkrenno(Integer pTtdkrenno) {
        ttdkrenno = pTtdkrenno;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HokenKykIdouRireki.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private Integer hhknnen;

    @Column(name=GenIT_HokenKykIdouRireki.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenIT_HokenKykIdouRireki.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hknsyukigou;

    @Column(name=GenIT_HokenKykIdouRireki.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private C_AisyoumeiKbn aisyoumeikbn;

    @Type(type="UserType_C_AisyoumeiKbn")
    @Column(name=GenIT_HokenKykIdouRireki.AISYOUMEIKBN)
    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        aisyoumeikbn = pAisyoumeikbn;
    }

    @Id
    @Type(type="UserType_C_ZougenKbn")
    @Column(name=GenIT_HokenKykIdouRireki.ZOUGENKBN)
    public C_ZougenKbn getZougenkbn() {
        return getPrimaryKey().getZougenkbn();
    }

    public void setZougenkbn(C_ZougenKbn pZougenkbn) {
        getPrimaryKey().setZougenkbn(pZougenkbn);
    }

    private BizCurrency hokenkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHokenkngk() {
        return hokenkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngk(BizCurrency pHokenkngk) {
        hokenkngk = pHokenkngk;
        hokenkngkValue = null;
        hokenkngkType  = null;
    }

    transient private BigDecimal hokenkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HOKENKNGK, nullable=true)
    protected BigDecimal getHokenkngkValue() {
        if (hokenkngkValue == null && hokenkngk != null) {
            if (hokenkngk.isOptional()) return null;
            return hokenkngk.absolute();
        }
        return hokenkngkValue;
    }

    protected void setHokenkngkValue(BigDecimal value) {
        hokenkngkValue = value;
        hokenkngk = Optional.fromNullable(toCurrencyType(hokenkngkType))
            .transform(bizCurrencyTransformer(getHokenkngkValue()))
            .orNull();
    }

    transient private String hokenkngkType = null;

    @Column(name=HOKENKNGK + "$", nullable=true)
    protected String getHokenkngkType() {
        if (hokenkngkType == null && hokenkngk != null) return hokenkngk.getType().toString();
        if (hokenkngkType == null && getHokenkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hokenkngk$' should not be NULL."));
        }
        return hokenkngkType;
    }

    protected void setHokenkngkType(String type) {
        hokenkngkType = type;
        hokenkngk = Optional.fromNullable(toCurrencyType(hokenkngkType))
            .transform(bizCurrencyTransformer(getHokenkngkValue()))
            .orNull();
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

    private BizCurrency ptumitatekin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getPtumitatekin() {
        return ptumitatekin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPtumitatekin(BizCurrency pPtumitatekin) {
        ptumitatekin = pPtumitatekin;
        ptumitatekinValue = null;
        ptumitatekinType  = null;
    }

    transient private BigDecimal ptumitatekinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=PTUMITATEKIN, nullable=true)
    protected BigDecimal getPtumitatekinValue() {
        if (ptumitatekinValue == null && ptumitatekin != null) {
            if (ptumitatekin.isOptional()) return null;
            return ptumitatekin.absolute();
        }
        return ptumitatekinValue;
    }

    protected void setPtumitatekinValue(BigDecimal value) {
        ptumitatekinValue = value;
        ptumitatekin = Optional.fromNullable(toCurrencyType(ptumitatekinType))
            .transform(bizCurrencyTransformer(getPtumitatekinValue()))
            .orNull();
    }

    transient private String ptumitatekinType = null;

    @Column(name=PTUMITATEKIN + "$", nullable=true)
    protected String getPtumitatekinType() {
        if (ptumitatekinType == null && ptumitatekin != null) return ptumitatekin.getType().toString();
        if (ptumitatekinType == null && getPtumitatekinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'ptumitatekin$' should not be NULL."));
        }
        return ptumitatekinType;
    }

    protected void setPtumitatekinType(String type) {
        ptumitatekinType = type;
        ptumitatekin = Optional.fromNullable(toCurrencyType(ptumitatekinType))
            .transform(bizCurrencyTransformer(getPtumitatekinValue()))
            .orNull();
    }

    private BizCurrency kaiyakuhrgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhrgoukei() {
        return kaiyakuhrgoukei;
    }

    public void setKaiyakuhrgoukei(BizCurrency pKaiyakuhrgoukei) {
        kaiyakuhrgoukei = pKaiyakuhrgoukei;
        kaiyakuhrgoukeiValue = null;
        kaiyakuhrgoukeiType  = null;
    }

    transient private BigDecimal kaiyakuhrgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHRGOUKEI, nullable=true)
    protected BigDecimal getKaiyakuhrgoukeiValue() {
        if (kaiyakuhrgoukeiValue == null && kaiyakuhrgoukei != null) {
            if (kaiyakuhrgoukei.isOptional()) return null;
            return kaiyakuhrgoukei.absolute();
        }
        return kaiyakuhrgoukeiValue;
    }

    protected void setKaiyakuhrgoukeiValue(BigDecimal value) {
        kaiyakuhrgoukeiValue = value;
        kaiyakuhrgoukei = Optional.fromNullable(toCurrencyType(kaiyakuhrgoukeiType))
            .transform(bizCurrencyTransformer(getKaiyakuhrgoukeiValue()))
            .orNull();
    }

    transient private String kaiyakuhrgoukeiType = null;

    @Column(name=KAIYAKUHRGOUKEI + "$", nullable=true)
    protected String getKaiyakuhrgoukeiType() {
        if (kaiyakuhrgoukeiType == null && kaiyakuhrgoukei != null) return kaiyakuhrgoukei.getType().toString();
        if (kaiyakuhrgoukeiType == null && getKaiyakuhrgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhrgoukei$' should not be NULL."));
        }
        return kaiyakuhrgoukeiType;
    }

    protected void setKaiyakuhrgoukeiType(String type) {
        kaiyakuhrgoukeiType = type;
        kaiyakuhrgoukei = Optional.fromNullable(toCurrencyType(kaiyakuhrgoukeiType))
            .transform(bizCurrencyTransformer(getKaiyakuhrgoukeiValue()))
            .orNull();
    }

    private BizCurrency kaiyakuhr;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhr() {
        return kaiyakuhr;
    }

    public void setKaiyakuhr(BizCurrency pKaiyakuhr) {
        kaiyakuhr = pKaiyakuhr;
        kaiyakuhrValue = null;
        kaiyakuhrType  = null;
    }

    transient private BigDecimal kaiyakuhrValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHR, nullable=true)
    protected BigDecimal getKaiyakuhrValue() {
        if (kaiyakuhrValue == null && kaiyakuhr != null) {
            if (kaiyakuhr.isOptional()) return null;
            return kaiyakuhr.absolute();
        }
        return kaiyakuhrValue;
    }

    protected void setKaiyakuhrValue(BigDecimal value) {
        kaiyakuhrValue = value;
        kaiyakuhr = Optional.fromNullable(toCurrencyType(kaiyakuhrType))
            .transform(bizCurrencyTransformer(getKaiyakuhrValue()))
            .orNull();
    }

    transient private String kaiyakuhrType = null;

    @Column(name=KAIYAKUHR + "$", nullable=true)
    protected String getKaiyakuhrType() {
        if (kaiyakuhrType == null && kaiyakuhr != null) return kaiyakuhr.getType().toString();
        if (kaiyakuhrType == null && getKaiyakuhrValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhr$' should not be NULL."));
        }
        return kaiyakuhrType;
    }

    protected void setKaiyakuhrType(String type) {
        kaiyakuhrType = type;
        kaiyakuhr = Optional.fromNullable(toCurrencyType(kaiyakuhrType))
            .transform(bizCurrencyTransformer(getKaiyakuhrValue()))
            .orNull();
    }

    private BizCurrency mikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
        mikeikapValue = null;
        mikeikapType  = null;
    }

    transient private BigDecimal mikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MIKEIKAP, nullable=true)
    protected BigDecimal getMikeikapValue() {
        if (mikeikapValue == null && mikeikap != null) {
            if (mikeikap.isOptional()) return null;
            return mikeikap.absolute();
        }
        return mikeikapValue;
    }

    protected void setMikeikapValue(BigDecimal value) {
        mikeikapValue = value;
        mikeikap = Optional.fromNullable(toCurrencyType(mikeikapType))
            .transform(bizCurrencyTransformer(getMikeikapValue()))
            .orNull();
    }

    transient private String mikeikapType = null;

    @Column(name=MIKEIKAP + "$", nullable=true)
    protected String getMikeikapType() {
        if (mikeikapType == null && mikeikap != null) return mikeikap.getType().toString();
        if (mikeikapType == null && getMikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mikeikap$' should not be NULL."));
        }
        return mikeikapType;
    }

    protected void setMikeikapType(String type) {
        mikeikapType = type;
        mikeikap = Optional.fromNullable(toCurrencyType(mikeikapType))
            .transform(bizCurrencyTransformer(getMikeikapValue()))
            .orNull();
    }

    private BizCurrency zennouseisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency pZennouseisankgk) {
        zennouseisankgk = pZennouseisankgk;
        zennouseisankgkValue = null;
        zennouseisankgkType  = null;
    }

    transient private BigDecimal zennouseisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUSEISANKGK, nullable=true)
    protected BigDecimal getZennouseisankgkValue() {
        if (zennouseisankgkValue == null && zennouseisankgk != null) {
            if (zennouseisankgk.isOptional()) return null;
            return zennouseisankgk.absolute();
        }
        return zennouseisankgkValue;
    }

    protected void setZennouseisankgkValue(BigDecimal value) {
        zennouseisankgkValue = value;
        zennouseisankgk = Optional.fromNullable(toCurrencyType(zennouseisankgkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkValue()))
            .orNull();
    }

    transient private String zennouseisankgkType = null;

    @Column(name=ZENNOUSEISANKGK + "$", nullable=true)
    protected String getZennouseisankgkType() {
        if (zennouseisankgkType == null && zennouseisankgk != null) return zennouseisankgk.getType().toString();
        if (zennouseisankgkType == null && getZennouseisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouseisankgk$' should not be NULL."));
        }
        return zennouseisankgkType;
    }

    protected void setZennouseisankgkType(String type) {
        zennouseisankgkType = type;
        zennouseisankgk = Optional.fromNullable(toCurrencyType(zennouseisankgkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkValue()))
            .orNull();
    }

    private BizCurrency idouhokenkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getIdouhokenkngk() {
        return idouhokenkngk;
    }

    public void setIdouhokenkngk(BizCurrency pIdouhokenkngk) {
        idouhokenkngk = pIdouhokenkngk;
        idouhokenkngkValue = null;
        idouhokenkngkType  = null;
    }

    transient private BigDecimal idouhokenkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IDOUHOKENKNGK, nullable=true)
    protected BigDecimal getIdouhokenkngkValue() {
        if (idouhokenkngkValue == null && idouhokenkngk != null) {
            if (idouhokenkngk.isOptional()) return null;
            return idouhokenkngk.absolute();
        }
        return idouhokenkngkValue;
    }

    protected void setIdouhokenkngkValue(BigDecimal value) {
        idouhokenkngkValue = value;
        idouhokenkngk = Optional.fromNullable(toCurrencyType(idouhokenkngkType))
            .transform(bizCurrencyTransformer(getIdouhokenkngkValue()))
            .orNull();
    }

    transient private String idouhokenkngkType = null;

    @Column(name=IDOUHOKENKNGK + "$", nullable=true)
    protected String getIdouhokenkngkType() {
        if (idouhokenkngkType == null && idouhokenkngk != null) return idouhokenkngk.getType().toString();
        if (idouhokenkngkType == null && getIdouhokenkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'idouhokenkngk$' should not be NULL."));
        }
        return idouhokenkngkType;
    }

    protected void setIdouhokenkngkType(String type) {
        idouhokenkngkType = type;
        idouhokenkngk = Optional.fromNullable(toCurrencyType(idouhokenkngkType))
            .transform(bizCurrencyTransformer(getIdouhokenkngkValue()))
            .orNull();
    }

    private BizCurrency idoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getIdoup() {
        return idoup;
    }

    public void setIdoup(BizCurrency pIdoup) {
        idoup = pIdoup;
        idoupValue = null;
        idoupType  = null;
    }

    transient private BigDecimal idoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IDOUP, nullable=true)
    protected BigDecimal getIdoupValue() {
        if (idoupValue == null && idoup != null) {
            if (idoup.isOptional()) return null;
            return idoup.absolute();
        }
        return idoupValue;
    }

    protected void setIdoupValue(BigDecimal value) {
        idoupValue = value;
        idoup = Optional.fromNullable(toCurrencyType(idoupType))
            .transform(bizCurrencyTransformer(getIdoupValue()))
            .orNull();
    }

    transient private String idoupType = null;

    @Column(name=IDOUP + "$", nullable=true)
    protected String getIdoupType() {
        if (idoupType == null && idoup != null) return idoup.getType().toString();
        if (idoupType == null && getIdoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'idoup$' should not be NULL."));
        }
        return idoupType;
    }

    protected void setIdoupType(String type) {
        idoupType = type;
        idoup = Optional.fromNullable(toCurrencyType(idoupType))
            .transform(bizCurrencyTransformer(getIdoupValue()))
            .orNull();
    }

    private BizCurrency idouptumitatekin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getIdouptumitatekin() {
        return idouptumitatekin;
    }

    public void setIdouptumitatekin(BizCurrency pIdouptumitatekin) {
        idouptumitatekin = pIdouptumitatekin;
        idouptumitatekinValue = null;
        idouptumitatekinType  = null;
    }

    transient private BigDecimal idouptumitatekinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IDOUPTUMITATEKIN, nullable=true)
    protected BigDecimal getIdouptumitatekinValue() {
        if (idouptumitatekinValue == null && idouptumitatekin != null) {
            if (idouptumitatekin.isOptional()) return null;
            return idouptumitatekin.absolute();
        }
        return idouptumitatekinValue;
    }

    protected void setIdouptumitatekinValue(BigDecimal value) {
        idouptumitatekinValue = value;
        idouptumitatekin = Optional.fromNullable(toCurrencyType(idouptumitatekinType))
            .transform(bizCurrencyTransformer(getIdouptumitatekinValue()))
            .orNull();
    }

    transient private String idouptumitatekinType = null;

    @Column(name=IDOUPTUMITATEKIN + "$", nullable=true)
    protected String getIdouptumitatekinType() {
        if (idouptumitatekinType == null && idouptumitatekin != null) return idouptumitatekin.getType().toString();
        if (idouptumitatekinType == null && getIdouptumitatekinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'idouptumitatekin$' should not be NULL."));
        }
        return idouptumitatekinType;
    }

    protected void setIdouptumitatekinType(String type) {
        idouptumitatekinType = type;
        idouptumitatekin = Optional.fromNullable(toCurrencyType(idouptumitatekinType))
            .transform(bizCurrencyTransformer(getIdouptumitatekinValue()))
            .orNull();
    }

    private BizCurrency idoukiykhnrikn;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getIdoukiykhnrikn() {
        return idoukiykhnrikn;
    }

    public void setIdoukiykhnrikn(BizCurrency pIdoukiykhnrikn) {
        idoukiykhnrikn = pIdoukiykhnrikn;
        idoukiykhnriknValue = null;
        idoukiykhnriknType  = null;
    }

    transient private BigDecimal idoukiykhnriknValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IDOUKIYKHNRIKN, nullable=true)
    protected BigDecimal getIdoukiykhnriknValue() {
        if (idoukiykhnriknValue == null && idoukiykhnrikn != null) {
            if (idoukiykhnrikn.isOptional()) return null;
            return idoukiykhnrikn.absolute();
        }
        return idoukiykhnriknValue;
    }

    protected void setIdoukiykhnriknValue(BigDecimal value) {
        idoukiykhnriknValue = value;
        idoukiykhnrikn = Optional.fromNullable(toCurrencyType(idoukiykhnriknType))
            .transform(bizCurrencyTransformer(getIdoukiykhnriknValue()))
            .orNull();
    }

    transient private String idoukiykhnriknType = null;

    @Column(name=IDOUKIYKHNRIKN + "$", nullable=true)
    protected String getIdoukiykhnriknType() {
        if (idoukiykhnriknType == null && idoukiykhnrikn != null) return idoukiykhnrikn.getType().toString();
        if (idoukiykhnriknType == null && getIdoukiykhnriknValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'idoukiykhnrikn$' should not be NULL."));
        }
        return idoukiykhnriknType;
    }

    protected void setIdoukiykhnriknType(String type) {
        idoukiykhnriknType = type;
        idoukiykhnrikn = Optional.fromNullable(toCurrencyType(idoukiykhnriknType))
            .transform(bizCurrencyTransformer(getIdoukiykhnriknValue()))
            .orNull();
    }

    private Integer hknkkn;

    @Column(name=GenIT_HokenKykIdouRireki.HKNKKN)
    @Range(min="0", max="99")
    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_HokenKykIdouRireki.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }

    private C_TumitatekinKbn tumitatekinkbn;

    @Type(type="UserType_C_TumitatekinKbn")
    @Column(name=GenIT_HokenKykIdouRireki.TUMITATEKINKBN)
    public C_TumitatekinKbn getTumitatekinkbn() {
        return tumitatekinkbn;
    }

    public void setTumitatekinkbn(C_TumitatekinKbn pTumitatekinkbn) {
        tumitatekinkbn = pTumitatekinkbn;
    }

    private C_KykIdouHaraikataKbn kykidouharaikatakbn;

    @Type(type="UserType_C_KykIdouHaraikataKbn")
    @Column(name=GenIT_HokenKykIdouRireki.KYKIDOUHARAIKATAKBN)
    public C_KykIdouHaraikataKbn getKykidouharaikatakbn() {
        return kykidouharaikatakbn;
    }

    public void setKykidouharaikatakbn(C_KykIdouHaraikataKbn pKykidouharaikatakbn) {
        kykidouharaikatakbn = pKykidouharaikatakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_HokenKykIdouRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_HokenKykIdouRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_HokenKykIdouRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}