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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_NyknJissekiRireki;
import yuyu.def.db.id.PKIT_BAK_NyknJissekiRireki;
import yuyu.def.db.meta.GenQIT_BAK_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_BAK_NyknJissekiRireki;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_Nyktrksflg;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 入金実績履歴バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_NyknJissekiRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_NyknJissekiRireki}</td><td colspan="3">入金実績履歴バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_NyknJissekiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_NyknJissekiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_NyknJissekiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyutoustartym jyutoustartym}</td><td>充当開始年月</td><td align="center">{@link PKIT_BAK_NyknJissekiRireki ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_BAK_NyknJissekiRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutouendym jyutouendym}</td><td>充当終了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getRyosyukwsratekjymd ryosyukwsratekjymd}</td><td>領収為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRyosyukwsrate ryosyukwsrate}</td><td>領収為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getIktwaribikikgk iktwaribikikgk}</td><td>一括割引料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNykdenno nykdenno}</td><td>入金伝票番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNykdenymd nykdenymd}</td><td>入金伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNykkeiro nykkeiro}</td><td>入金経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nykkeiro}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getIkkatuyoupkaisuu ikkatuyoupkaisuu}</td><td>一括要Ｐ回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getIktnyuukinnumu iktnyuukinnumu}</td><td>一括入金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNyktrksflg nyktrksflg}</td><td>入金取消フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nyktrksflg}</td></tr>
 *  <tr><td>{@link #getNyktrksymd nyktrksymd}</td><td>入金取消処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyktrksdenno nyktrksdenno}</td><td>入金取消伝票番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyktrksdenymd nyktrksdenymd}</td><td>入金取消伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYenkansannyknkingk yenkansannyknkingk}</td><td>円換算入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrateymd yenkansantkykwsrateymd}</td><td>円換算適用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrate yenkansantkykwsrate}</td><td>円換算適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_NyknJissekiRireki
 * @see     PKIT_BAK_NyknJissekiRireki
 * @see     QIT_BAK_NyknJissekiRireki
 * @see     GenQIT_BAK_NyknJissekiRireki
 */
@MappedSuperclass
@Table(name=GenIT_BAK_NyknJissekiRireki.TABLE_NAME)
@IdClass(value=PKIT_BAK_NyknJissekiRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Nykkeiro", typeClass=UserType_C_Nykkeiro.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_Nyktrksflg", typeClass=UserType_C_Nyktrksflg.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_BAK_NyknJissekiRireki extends AbstractExDBEntity<IT_BAK_NyknJissekiRireki, PKIT_BAK_NyknJissekiRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_NyknJissekiRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String JYUTOUSTARTYM            = "jyutoustartym";
    public static final String RENNO                    = "renno";
    public static final String JYUTOUENDYM              = "jyutouendym";
    public static final String RSGAKU                   = "rsgaku";
    public static final String RSTUUKASYU               = "rstuukasyu";
    public static final String RYOSYUKWSRATEKJYMD       = "ryosyukwsratekjymd";
    public static final String RYOSYUKWSRATE            = "ryosyukwsrate";
    public static final String HRKP                     = "hrkp";
    public static final String IKTWARIBIKIKGK           = "iktwaribikikgk";
    public static final String NYKSYORIYMD              = "nyksyoriymd";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String NYKDENNO                 = "nykdenno";
    public static final String NYKDENYMD                = "nykdenymd";
    public static final String NYKKEIRO                 = "nykkeiro";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String IKKATUYOUPKAISUU         = "ikkatuyoupkaisuu";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String IKTNYUUKINNUMU           = "iktnyuukinnumu";
    public static final String NYKTRKSFLG               = "nyktrksflg";
    public static final String NYKTRKSYMD               = "nyktrksymd";
    public static final String NYKTRKSDENNO             = "nyktrksdenno";
    public static final String NYKTRKSDENYMD            = "nyktrksdenymd";
    public static final String YENKANSANNYKNKINGK       = "yenkansannyknkingk";
    public static final String YENKANSANTKYKWSRATEYMD   = "yenkansantkykwsrateymd";
    public static final String YENKANSANTKYKWSRATE      = "yenkansantkykwsrate";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";

    private final PKIT_BAK_NyknJissekiRireki primaryKey;

    public GenIT_BAK_NyknJissekiRireki() {
        primaryKey = new PKIT_BAK_NyknJissekiRireki();
    }

    public GenIT_BAK_NyknJissekiRireki(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDateYM pJyutoustartym,
        Integer pRenno
    ) {
        primaryKey = new PKIT_BAK_NyknJissekiRireki(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pJyutoustartym,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_NyknJissekiRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_NyknJissekiRireki> getMetaClass() {
        return QIT_BAK_NyknJissekiRireki.class;
    }

    @Id
    @Column(name=GenIT_BAK_NyknJissekiRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_NyknJissekiRireki.SYONO)
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
    @Column(name=GenIT_BAK_NyknJissekiRireki.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.JYUTOUSTARTYM)
    public BizDateYM getJyutoustartym() {
        return getPrimaryKey().getJyutoustartym();
    }

    public void setJyutoustartym(BizDateYM pJyutoustartym) {
        getPrimaryKey().setJyutoustartym(pJyutoustartym);
    }

    @Id
    @Column(name=GenIT_BAK_NyknJissekiRireki.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDateYM jyutouendym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.JYUTOUENDYM)
    public BizDateYM getJyutouendym() {
        return jyutouendym;
    }

    public void setJyutouendym(BizDateYM pJyutouendym) {
        jyutouendym = pJyutouendym;
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

    private C_Tuukasyu rstuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_NyknJissekiRireki.RSTUUKASYU)
    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    private BizDate ryosyukwsratekjymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.RYOSYUKWSRATEKJYMD)
    public BizDate getRyosyukwsratekjymd() {
        return ryosyukwsratekjymd;
    }

    public void setRyosyukwsratekjymd(BizDate pRyosyukwsratekjymd) {
        ryosyukwsratekjymd = pRyosyukwsratekjymd;
    }

    private BizNumber ryosyukwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.RYOSYUKWSRATE)
    public BizNumber getRyosyukwsrate() {
        return ryosyukwsrate;
    }

    public void setRyosyukwsrate(BizNumber pRyosyukwsrate) {
        ryosyukwsrate = pRyosyukwsrate;
    }

    private BizCurrency hrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
        hrkpValue = null;
        hrkpType  = null;
    }

    transient private BigDecimal hrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKP, nullable=true)
    protected BigDecimal getHrkpValue() {
        if (hrkpValue == null && hrkp != null) {
            if (hrkp.isOptional()) return null;
            return hrkp.absolute();
        }
        return hrkpValue;
    }

    protected void setHrkpValue(BigDecimal value) {
        hrkpValue = value;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    transient private String hrkpType = null;

    @Column(name=HRKP + "$", nullable=true)
    protected String getHrkpType() {
        if (hrkpType == null && hrkp != null) return hrkp.getType().toString();
        if (hrkpType == null && getHrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkp$' should not be NULL."));
        }
        return hrkpType;
    }

    protected void setHrkpType(String type) {
        hrkpType = type;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    private BizCurrency iktwaribikikgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getIktwaribikikgk() {
        return iktwaribikikgk;
    }

    public void setIktwaribikikgk(BizCurrency pIktwaribikikgk) {
        iktwaribikikgk = pIktwaribikikgk;
        iktwaribikikgkValue = null;
        iktwaribikikgkType  = null;
    }

    transient private BigDecimal iktwaribikikgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IKTWARIBIKIKGK, nullable=true)
    protected BigDecimal getIktwaribikikgkValue() {
        if (iktwaribikikgkValue == null && iktwaribikikgk != null) {
            if (iktwaribikikgk.isOptional()) return null;
            return iktwaribikikgk.absolute();
        }
        return iktwaribikikgkValue;
    }

    protected void setIktwaribikikgkValue(BigDecimal value) {
        iktwaribikikgkValue = value;
        iktwaribikikgk = Optional.fromNullable(toCurrencyType(iktwaribikikgkType))
            .transform(bizCurrencyTransformer(getIktwaribikikgkValue()))
            .orNull();
    }

    transient private String iktwaribikikgkType = null;

    @Column(name=IKTWARIBIKIKGK + "$", nullable=true)
    protected String getIktwaribikikgkType() {
        if (iktwaribikikgkType == null && iktwaribikikgk != null) return iktwaribikikgk.getType().toString();
        if (iktwaribikikgkType == null && getIktwaribikikgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'iktwaribikikgk$' should not be NULL."));
        }
        return iktwaribikikgkType;
    }

    protected void setIktwaribikikgkType(String type) {
        iktwaribikikgkType = type;
        iktwaribikikgk = Optional.fromNullable(toCurrencyType(iktwaribikikgkType))
            .transform(bizCurrencyTransformer(getIktwaribikikgkValue()))
            .orNull();
    }

    private BizDate nyksyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.NYKSYORIYMD)
    public BizDate getNyksyoriymd() {
        return nyksyoriymd;
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        nyksyoriymd = pNyksyoriymd;
    }

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private String nykdenno;

    @Column(name=GenIT_BAK_NyknJissekiRireki.NYKDENNO)
    public String getNykdenno() {
        return nykdenno;
    }

    public void setNykdenno(String pNykdenno) {
        nykdenno = pNykdenno;
    }

    private BizDate nykdenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.NYKDENYMD)
    public BizDate getNykdenymd() {
        return nykdenymd;
    }

    public void setNykdenymd(BizDate pNykdenymd) {
        nykdenymd = pNykdenymd;
    }

    private C_Nykkeiro nykkeiro;

    @Type(type="UserType_C_Nykkeiro")
    @Column(name=GenIT_BAK_NyknJissekiRireki.NYKKEIRO)
    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_BAK_NyknJissekiRireki.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_BAK_NyknJissekiRireki.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private Integer ikkatuyoupkaisuu;

    @Column(name=GenIT_BAK_NyknJissekiRireki.IKKATUYOUPKAISUU)
    public Integer getIkkatuyoupkaisuu() {
        return ikkatuyoupkaisuu;
    }

    public void setIkkatuyoupkaisuu(Integer pIkkatuyoupkaisuu) {
        ikkatuyoupkaisuu = pIkkatuyoupkaisuu;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_BAK_NyknJissekiRireki.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_BAK_NyknJissekiRireki.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_BAK_NyknJissekiRireki.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private C_UmuKbn iktnyuukinnumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_NyknJissekiRireki.IKTNYUUKINNUMU)
    public C_UmuKbn getIktnyuukinnumu() {
        return iktnyuukinnumu;
    }

    public void setIktnyuukinnumu(C_UmuKbn pIktnyuukinnumu) {
        iktnyuukinnumu = pIktnyuukinnumu;
    }

    private C_Nyktrksflg nyktrksflg;

    @Type(type="UserType_C_Nyktrksflg")
    @Column(name=GenIT_BAK_NyknJissekiRireki.NYKTRKSFLG)
    public C_Nyktrksflg getNyktrksflg() {
        return nyktrksflg;
    }

    public void setNyktrksflg(C_Nyktrksflg pNyktrksflg) {
        nyktrksflg = pNyktrksflg;
    }

    private BizDate nyktrksymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.NYKTRKSYMD)
    public BizDate getNyktrksymd() {
        return nyktrksymd;
    }

    public void setNyktrksymd(BizDate pNyktrksymd) {
        nyktrksymd = pNyktrksymd;
    }

    private String nyktrksdenno;

    @Column(name=GenIT_BAK_NyknJissekiRireki.NYKTRKSDENNO)
    public String getNyktrksdenno() {
        return nyktrksdenno;
    }

    public void setNyktrksdenno(String pNyktrksdenno) {
        nyktrksdenno = pNyktrksdenno;
    }

    private BizDate nyktrksdenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.NYKTRKSDENYMD)
    public BizDate getNyktrksdenymd() {
        return nyktrksdenymd;
    }

    public void setNyktrksdenymd(BizDate pNyktrksdenymd) {
        nyktrksdenymd = pNyktrksdenymd;
    }

    private BizCurrency yenkansannyknkingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansannyknkingk() {
        return yenkansannyknkingk;
    }

    public void setYenkansannyknkingk(BizCurrency pYenkansannyknkingk) {
        yenkansannyknkingk = pYenkansannyknkingk;
        yenkansannyknkingkValue = null;
        yenkansannyknkingkType  = null;
    }

    transient private BigDecimal yenkansannyknkingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANNYKNKINGK, nullable=true)
    protected BigDecimal getYenkansannyknkingkValue() {
        if (yenkansannyknkingkValue == null && yenkansannyknkingk != null) {
            if (yenkansannyknkingk.isOptional()) return null;
            return yenkansannyknkingk.absolute();
        }
        return yenkansannyknkingkValue;
    }

    protected void setYenkansannyknkingkValue(BigDecimal value) {
        yenkansannyknkingkValue = value;
        yenkansannyknkingk = Optional.fromNullable(toCurrencyType(yenkansannyknkingkType))
            .transform(bizCurrencyTransformer(getYenkansannyknkingkValue()))
            .orNull();
    }

    transient private String yenkansannyknkingkType = null;

    @Column(name=YENKANSANNYKNKINGK + "$", nullable=true)
    protected String getYenkansannyknkingkType() {
        if (yenkansannyknkingkType == null && yenkansannyknkingk != null) return yenkansannyknkingk.getType().toString();
        if (yenkansannyknkingkType == null && getYenkansannyknkingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansannyknkingk$' should not be NULL."));
        }
        return yenkansannyknkingkType;
    }

    protected void setYenkansannyknkingkType(String type) {
        yenkansannyknkingkType = type;
        yenkansannyknkingk = Optional.fromNullable(toCurrencyType(yenkansannyknkingkType))
            .transform(bizCurrencyTransformer(getYenkansannyknkingkValue()))
            .orNull();
    }

    private BizDate yenkansantkykwsrateymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.YENKANSANTKYKWSRATEYMD)
    public BizDate getYenkansantkykwsrateymd() {
        return yenkansantkykwsrateymd;
    }

    public void setYenkansantkykwsrateymd(BizDate pYenkansantkykwsrateymd) {
        yenkansantkykwsrateymd = pYenkansantkykwsrateymd;
    }

    private BizNumber yenkansantkykwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_NyknJissekiRireki.YENKANSANTKYKWSRATE)
    public BizNumber getYenkansantkykwsrate() {
        return yenkansantkykwsrate;
    }

    public void setYenkansantkykwsrate(BizNumber pYenkansantkykwsrate) {
        yenkansantkykwsrate = pYenkansantkykwsrate;
    }

    private String henkousikibetukey;

    @Column(name=GenIT_BAK_NyknJissekiRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_NyknJissekiRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_NyknJissekiRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_NyknJissekiRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String creditkessaiyouno;

    @Column(name=GenIT_BAK_NyknJissekiRireki.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }
}