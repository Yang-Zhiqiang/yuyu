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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_MisyuupRendo;
import yuyu.def.db.id.PKJT_MisyuupRendo;
import yuyu.def.db.meta.GenQJT_MisyuupRendo;
import yuyu.def.db.meta.QJT_MisyuupRendo;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 未収Ｐ連動テーブル テーブルのマッピング情報クラスで、 {@link JT_MisyuupRendo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_MisyuupRendo}</td><td colspan="3">未収Ｐ連動テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_MisyuupRendo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">{@link PKJT_MisyuupRendo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNykkeiro nykkeiro}</td><td>入金経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nykkeiro}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getIktnyuukinnumu iktnyuukinnumu}</td><td>一括入金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMisyuupjyuutouym misyuupjyuutouym}</td><td>未収保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMisyuupjyuutoukaisuuy misyuupjyuutoukaisuuy}</td><td>未収保険料充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMisyuupjyuutoukaisuum misyuupjyuutoukaisuum}</td><td>未収保険料充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMisyuup misyuup}</td><td>未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getNyknkwsratekijyunymd nyknkwsratekijyunymd}</td><td>入金用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_MisyuupRendo
 * @see     PKJT_MisyuupRendo
 * @see     QJT_MisyuupRendo
 * @see     GenQJT_MisyuupRendo
 */
@MappedSuperclass
@Table(name=GenJT_MisyuupRendo.TABLE_NAME)
@IdClass(value=PKJT_MisyuupRendo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Nykkeiro", typeClass=UserType_C_Nykkeiro.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_MisyuupRendo extends AbstractExDBEntity<JT_MisyuupRendo, PKJT_MisyuupRendo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_MisyuupRendo";
    public static final String SYONO                    = "syono";
    public static final String DATARENNO                = "datarenno";
    public static final String NYKKEIRO                 = "nykkeiro";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String IKTNYUUKINNUMU           = "iktnyuukinnumu";
    public static final String MISYUUPJYUUTOUYM         = "misyuupjyuutouym";
    public static final String MISYUUPJYUUTOUKAISUUY    = "misyuupjyuutoukaisuuy";
    public static final String MISYUUPJYUUTOUKAISUUM    = "misyuupjyuutoukaisuum";
    public static final String MISYUUP                  = "misyuup";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String DENYMD                   = "denymd";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String NYKNKWSRATEKIJYUNYMD     = "nyknkwsratekijyunymd";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_MisyuupRendo primaryKey;

    public GenJT_MisyuupRendo() {
        primaryKey = new PKJT_MisyuupRendo();
    }

    public GenJT_MisyuupRendo(String pSyono, Integer pDatarenno) {
        primaryKey = new PKJT_MisyuupRendo(pSyono, pDatarenno);
    }

    @Transient
    @Override
    public PKJT_MisyuupRendo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_MisyuupRendo> getMetaClass() {
        return QJT_MisyuupRendo.class;
    }

    @Id
    @Column(name=GenJT_MisyuupRendo.SYONO)
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
    @Column(name=GenJT_MisyuupRendo.DATARENNO)
    public Integer getDatarenno() {
        return getPrimaryKey().getDatarenno();
    }

    public void setDatarenno(Integer pDatarenno) {
        getPrimaryKey().setDatarenno(pDatarenno);
    }

    private C_Nykkeiro nykkeiro;

    @Type(type="UserType_C_Nykkeiro")
    @Column(name=GenJT_MisyuupRendo.NYKKEIRO)
    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenJT_MisyuupRendo.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenJT_MisyuupRendo.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private C_UmuKbn iktnyuukinnumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_MisyuupRendo.IKTNYUUKINNUMU)
    public C_UmuKbn getIktnyuukinnumu() {
        return iktnyuukinnumu;
    }

    public void setIktnyuukinnumu(C_UmuKbn pIktnyuukinnumu) {
        iktnyuukinnumu = pIktnyuukinnumu;
    }

    private BizDateYM misyuupjyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_MisyuupRendo.MISYUUPJYUUTOUYM)
    public BizDateYM getMisyuupjyuutouym() {
        return misyuupjyuutouym;
    }

    public void setMisyuupjyuutouym(BizDateYM pMisyuupjyuutouym) {
        misyuupjyuutouym = pMisyuupjyuutouym;
    }

    private Integer misyuupjyuutoukaisuuy;

    @Column(name=GenJT_MisyuupRendo.MISYUUPJYUUTOUKAISUUY)
    public Integer getMisyuupjyuutoukaisuuy() {
        return misyuupjyuutoukaisuuy;
    }

    public void setMisyuupjyuutoukaisuuy(Integer pMisyuupjyuutoukaisuuy) {
        misyuupjyuutoukaisuuy = pMisyuupjyuutoukaisuuy;
    }

    private Integer misyuupjyuutoukaisuum;

    @Column(name=GenJT_MisyuupRendo.MISYUUPJYUUTOUKAISUUM)
    public Integer getMisyuupjyuutoukaisuum() {
        return misyuupjyuutoukaisuum;
    }

    public void setMisyuupjyuutoukaisuum(Integer pMisyuupjyuutoukaisuum) {
        misyuupjyuutoukaisuum = pMisyuupjyuutoukaisuum;
    }

    private BizCurrency misyuup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
        misyuupValue = null;
        misyuupType  = null;
    }

    transient private BigDecimal misyuupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MISYUUP, nullable=true)
    protected BigDecimal getMisyuupValue() {
        if (misyuupValue == null && misyuup != null) {
            if (misyuup.isOptional()) return null;
            return misyuup.absolute();
        }
        return misyuupValue;
    }

    protected void setMisyuupValue(BigDecimal value) {
        misyuupValue = value;
        misyuup = Optional.fromNullable(toCurrencyType(misyuupType))
            .transform(bizCurrencyTransformer(getMisyuupValue()))
            .orNull();
    }

    transient private String misyuupType = null;

    @Column(name=MISYUUP + "$", nullable=true)
    protected String getMisyuupType() {
        if (misyuupType == null && misyuup != null) return misyuup.getType().toString();
        if (misyuupType == null && getMisyuupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'misyuup$' should not be NULL."));
        }
        return misyuupType;
    }

    protected void setMisyuupType(String type) {
        misyuupType = type;
        misyuup = Optional.fromNullable(toCurrencyType(misyuupType))
            .transform(bizCurrencyTransformer(getMisyuupValue()))
            .orNull();
    }

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_MisyuupRendo.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_MisyuupRendo.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenJT_MisyuupRendo.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenJT_MisyuupRendo.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizDate nyknkwsratekijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_MisyuupRendo.NYKNKWSRATEKIJYUNYMD)
    public BizDate getNyknkwsratekijyunymd() {
        return nyknkwsratekijyunymd;
    }

    public void setNyknkwsratekijyunymd(BizDate pNyknkwsratekijyunymd) {
        nyknkwsratekijyunymd = pNyknkwsratekijyunymd;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenJT_MisyuupRendo.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String kossyoricd;

    @Column(name=GenJT_MisyuupRendo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_MisyuupRendo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_MisyuupRendo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_MisyuupRendo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}