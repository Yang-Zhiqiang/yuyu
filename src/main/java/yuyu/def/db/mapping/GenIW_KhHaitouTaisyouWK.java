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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoujyoutaiHanteiKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IW_KhHaitouTaisyouWK;
import yuyu.def.db.id.PKIW_KhHaitouTaisyouWK;
import yuyu.def.db.meta.GenQIW_KhHaitouTaisyouWK;
import yuyu.def.db.meta.QIW_KhHaitouTaisyouWK;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HaitoujyoutaiHanteiKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_HaitoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 配当金算出対象抽出ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhHaitouTaisyouWK} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhHaitouTaisyouWK}</td><td colspan="3">配当金算出対象抽出ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIW_KhHaitouTaisyouWK ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIW_KhHaitouTaisyouWK ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIW_KhHaitouTaisyouWK ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">{@link PKIW_KhHaitouTaisyouWK ○}</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getHaitoumeisaikbn haitoumeisaikbn}</td><td>配当明細区分</td><td align="center">{@link PKIW_KhHaitouTaisyouWK ○}</td><td align="center">V</td><td>{@link C_HaitoumeisaiKbn}</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIW_KhHaitouTaisyouWK ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHaitoujyoutaihanteikbn haitoujyoutaihanteikbn}</td><td>配当状態判定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoujyoutaiHanteiKbn}</td></tr>
 *  <tr><td>{@link #getHaitoushrkijyunymd haitoushrkijyunymd}</td><td>配当支払基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHaitoukbn haitoukbn}</td><td>配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitouKbn}</td></tr>
 *  <tr><td>{@link #getKihons kihons}</td><td>基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHaitoukaisuu haitoukaisuu}</td><td>配当回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn hknkknsmnkbn}</td><td>保険期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkkn hknkkn}</td><td>保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn hrkkkn}</td><td>払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDratenendo dratenendo}</td><td>Ｄレート年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getKeisandnendo keisandnendo}</td><td>計算Ｄ年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykjyoutai kykjyoutai}</td><td>契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykjyoutai}</td></tr>
 *  <tr><td>{@link #getDai1hknkkn dai1hknkkn}</td><td>第１保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn hrkkknsmnkbn}</td><td>払込期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 * </table>
 * @see     IW_KhHaitouTaisyouWK
 * @see     PKIW_KhHaitouTaisyouWK
 * @see     QIW_KhHaitouTaisyouWK
 * @see     GenQIW_KhHaitouTaisyouWK
 */
@MappedSuperclass
@Table(name=GenIW_KhHaitouTaisyouWK.TABLE_NAME)
@IdClass(value=PKIW_KhHaitouTaisyouWK.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HaitouKbn", typeClass=UserType_C_HaitouKbn.class),
    @TypeDef(name="UserType_C_HaitoujyoutaiHanteiKbn", typeClass=UserType_C_HaitoujyoutaiHanteiKbn.class),
    @TypeDef(name="UserType_C_HaitoukinuketorihouKbn", typeClass=UserType_C_HaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_HaitoumeisaiKbn", typeClass=UserType_C_HaitoumeisaiKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HknkknsmnKbn", typeClass=UserType_C_HknkknsmnKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_HrkkknsmnKbn", typeClass=UserType_C_HrkkknsmnKbn.class),
    @TypeDef(name="UserType_C_Kykjyoutai", typeClass=UserType_C_Kykjyoutai.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenIW_KhHaitouTaisyouWK extends AbstractExDBEntity<IW_KhHaitouTaisyouWK, PKIW_KhHaitouTaisyouWK> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhHaitouTaisyouWK";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String HAITOUKINUKETORIHOUKBN   = "haitoukinuketorihoukbn";
    public static final String HAITOUMEISAIKBN          = "haitoumeisaikbn";
    public static final String RENNO                    = "renno";
    public static final String HAITOUJYOUTAIHANTEIKBN   = "haitoujyoutaihanteikbn";
    public static final String HAITOUSHRKIJYUNYMD       = "haitoushrkijyunymd";
    public static final String HAITOUKBN                = "haitoukbn";
    public static final String KIHONS                   = "kihons";
    public static final String HAITOUKAISUU             = "haitoukaisuu";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String YOTEIRIRITU              = "yoteiriritu";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HKNKKNSMNKBN             = "hknkknsmnkbn";
    public static final String HKNKKN                   = "hknkkn";
    public static final String HRKKKN                   = "hrkkkn";
    public static final String DRATENENDO               = "dratenendo";
    public static final String KEISANDNENDO             = "keisandnendo";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String KYKYMD                   = "kykymd";
    public static final String KYKJYOUTAI               = "kykjyoutai";
    public static final String DAI1HKNKKN               = "dai1hknkkn";
    public static final String HRKKKNSMNKBN             = "hrkkknsmnkbn";

    private final PKIW_KhHaitouTaisyouWK primaryKey;

    public GenIW_KhHaitouTaisyouWK() {
        primaryKey = new PKIW_KhHaitouTaisyouWK();
    }

    public GenIW_KhHaitouTaisyouWK(
        String pKbnkey,
        String pSyono,
        BizDate pSyoriYmd,
        C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn,
        C_HaitoumeisaiKbn pHaitoumeisaikbn,
        Integer pRenno
    ) {
        primaryKey = new PKIW_KhHaitouTaisyouWK(
            pKbnkey,
            pSyono,
            pSyoriYmd,
            pHaitoukinuketorihoukbn,
            pHaitoumeisaikbn,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIW_KhHaitouTaisyouWK getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhHaitouTaisyouWK> getMetaClass() {
        return QIW_KhHaitouTaisyouWK.class;
    }

    @Id
    @Column(name=GenIW_KhHaitouTaisyouWK.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIW_KhHaitouTaisyouWK.SYONO)
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
    @Type(type="BizDateType")
    @Column(name=GenIW_KhHaitouTaisyouWK.SYORIYMD)
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
    @Type(type="UserType_C_HaitoukinuketorihouKbn")
    @Column(name=GenIW_KhHaitouTaisyouWK.HAITOUKINUKETORIHOUKBN)
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return getPrimaryKey().getHaitoukinuketorihoukbn();
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        getPrimaryKey().setHaitoukinuketorihoukbn(pHaitoukinuketorihoukbn);
    }

    @Id
    @Type(type="UserType_C_HaitoumeisaiKbn")
    @Column(name=GenIW_KhHaitouTaisyouWK.HAITOUMEISAIKBN)
    public C_HaitoumeisaiKbn getHaitoumeisaikbn() {
        return getPrimaryKey().getHaitoumeisaikbn();
    }

    public void setHaitoumeisaikbn(C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        getPrimaryKey().setHaitoumeisaikbn(pHaitoumeisaikbn);
    }

    @Id
    @Column(name=GenIW_KhHaitouTaisyouWK.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_HaitoujyoutaiHanteiKbn haitoujyoutaihanteikbn;

    @Type(type="UserType_C_HaitoujyoutaiHanteiKbn")
    @Column(name=GenIW_KhHaitouTaisyouWK.HAITOUJYOUTAIHANTEIKBN)
    public C_HaitoujyoutaiHanteiKbn getHaitoujyoutaihanteikbn() {
        return haitoujyoutaihanteikbn;
    }

    public void setHaitoujyoutaihanteikbn(C_HaitoujyoutaiHanteiKbn pHaitoujyoutaihanteikbn) {
        haitoujyoutaihanteikbn = pHaitoujyoutaihanteikbn;
    }

    private BizDate haitoushrkijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhHaitouTaisyouWK.HAITOUSHRKIJYUNYMD)
    public BizDate getHaitoushrkijyunymd() {
        return haitoushrkijyunymd;
    }

    public void setHaitoushrkijyunymd(BizDate pHaitoushrkijyunymd) {
        haitoushrkijyunymd = pHaitoushrkijyunymd;
    }

    private C_HaitouKbn haitoukbn;

    @Type(type="UserType_C_HaitouKbn")
    @Column(name=GenIW_KhHaitouTaisyouWK.HAITOUKBN)
    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    private BizCurrency kihons;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getKihons() {
        return kihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons(BizCurrency pKihons) {
        kihons = pKihons;
        kihonsValue = null;
        kihonsType  = null;
    }

    transient private BigDecimal kihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS, nullable=true)
    protected BigDecimal getKihonsValue() {
        if (kihonsValue == null && kihons != null) {
            if (kihons.isOptional()) return null;
            return kihons.absolute();
        }
        return kihonsValue;
    }

    protected void setKihonsValue(BigDecimal value) {
        kihonsValue = value;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    transient private String kihonsType = null;

    @Column(name=KIHONS + "$", nullable=true)
    protected String getKihonsType() {
        if (kihonsType == null && kihons != null) return kihons.getType().toString();
        if (kihonsType == null && getKihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons$' should not be NULL."));
        }
        return kihonsType;
    }

    protected void setKihonsType(String type) {
        kihonsType = type;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    private Integer haitoukaisuu;

    @Column(name=GenIW_KhHaitouTaisyouWK.HAITOUKAISUU)
    public Integer getHaitoukaisuu() {
        return haitoukaisuu;
    }

    public void setHaitoukaisuu(Integer pHaitoukaisuu) {
        haitoukaisuu = pHaitoukaisuu;
    }

    private String syouhncd;

    @Column(name=GenIW_KhHaitouTaisyouWK.SYOUHNCD)
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

    private String ryouritusdno;

    @Column(name=GenIW_KhHaitouTaisyouWK.RYOURITUSDNO)
    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIW_KhHaitouTaisyouWK.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIW_KhHaitouTaisyouWK.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenIW_KhHaitouTaisyouWK.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private Integer hhknnen;

    @Column(name=GenIW_KhHaitouTaisyouWK.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_HknkknsmnKbn hknkknsmnkbn;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIW_KhHaitouTaisyouWK.HKNKKNSMNKBN)
    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    private Integer hknkkn;

    @Column(name=GenIW_KhHaitouTaisyouWK.HKNKKN)
    @Range(min="0", max="99")
    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    private Integer hrkkkn;

    @Column(name=GenIW_KhHaitouTaisyouWK.HRKKKN)
    @Range(min="0", max="99")
    public Integer getHrkkkn() {
        return hrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    private BizDateY dratenendo;

    @Type(type="BizDateYType")
    @Column(name=GenIW_KhHaitouTaisyouWK.DRATENENDO)
    public BizDateY getDratenendo() {
        return dratenendo;
    }

    public void setDratenendo(BizDateY pDratenendo) {
        dratenendo = pDratenendo;
    }

    private BizDateY keisandnendo;

    @Type(type="BizDateYType")
    @Column(name=GenIW_KhHaitouTaisyouWK.KEISANDNENDO)
    public BizDateY getKeisandnendo() {
        return keisandnendo;
    }

    public void setKeisandnendo(BizDateY pKeisandnendo) {
        keisandnendo = pKeisandnendo;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIW_KhHaitouTaisyouWK.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhHaitouTaisyouWK.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhHaitouTaisyouWK.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhHaitouTaisyouWK.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhHaitouTaisyouWK.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_Kykjyoutai kykjyoutai;

    @Type(type="UserType_C_Kykjyoutai")
    @Column(name=GenIW_KhHaitouTaisyouWK.KYKJYOUTAI)
    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    private Integer dai1hknkkn;

    @Column(name=GenIW_KhHaitouTaisyouWK.DAI1HKNKKN)
    @Range(min="0", max="99")
    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIW_KhHaitouTaisyouWK.HRKKKNSMNKBN)
    public C_HrkkknsmnKbn getHrkkknsmnkbn() {
        return hrkkknsmnkbn;
    }

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }
}