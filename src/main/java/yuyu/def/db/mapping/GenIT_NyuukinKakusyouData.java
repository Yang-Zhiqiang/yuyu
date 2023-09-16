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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
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
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyuuryokuKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.id.PKIT_NyuukinKakusyouData;
import yuyu.def.db.meta.GenQIT_NyuukinKakusyouData;
import yuyu.def.db.meta.QIT_NyuukinKakusyouData;
import yuyu.def.db.type.UserType_C_CreditUriageSeikyuuKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.db.type.UserType_C_NykhouhouKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_NyuuryokuKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 入金確証データテーブル テーブルのマッピング情報クラスで、 {@link IT_NyuukinKakusyouData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_NyuukinKakusyouData}</td><td colspan="3">入金確証データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_NyuukinKakusyouData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinkakusyouno nyuukinkakusyouno}</td><td>入金確証番号</td><td align="center">{@link PKIT_NyuukinKakusyouData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_NyuukinKakusyouData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyuukinkakusyounrkymd nyuukinkakusyounrkymd}</td><td>入金確証入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNykkeiro nykkeiro}</td><td>入金経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nykkeiro}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getIktnyuukinnumu iktnyuukinnumu}</td><td>一括入金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSuitoubumoncd suitoubumoncd}</td><td>出納部門コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNykhouhoukbn nykhouhoukbn}</td><td>入金方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NykhouhouKbn}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getNykdenymd nykdenymd}</td><td>入金伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTabakarikanjyono tabakarikanjyono}</td><td>束仮勘定番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinkakusyounrkno nyuukinkakusyounrkno}</td><td>入金確証入力番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuuryokukbn nyuuryokukbn}</td><td>入力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyuuryokuKbn}</td></tr>
 *  <tr><td>{@link #getSuitono suitono}</td><td>出納番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmyousinkkbn hrkmyousinkkbn}</td><td>振込用紙入金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KrkPayEasyHrkmyousiNkKbn}</td></tr>
 *  <tr><td>{@link #getSuitososhikicd suitososhikicd}</td><td>出納組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaebankcd kzhurikaebankcd}</td><td>口座振替銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzhurikaesitencd kzhurikaesitencd}</td><td>口座振替支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUketuketencd uketuketencd}</td><td>受付店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCvscd cvscd}</td><td>ＣＶＳコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyousyuuhm ryousyuuhm}</td><td>領収時分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikomiyousiokyksmno hurikomiyousiokyksmno}</td><td>振込用紙お客さま番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikomiyousikakuninno hurikomiyousikakuninno}</td><td>振込用紙確認番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinyuukikankbn kinyuukikankbn}</td><td>金融機関区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyuudaikocd syuudaikocd}</td><td>収納代行社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syuudaikocd}</td></tr>
 *  <tr><td>{@link #getCredituriageseikyuukbn credituriageseikyuukbn}</td><td>クレジットカード売上請求区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditUriageSeikyuuKbn}</td></tr>
 * </table>
 * @see     IT_NyuukinKakusyouData
 * @see     PKIT_NyuukinKakusyouData
 * @see     QIT_NyuukinKakusyouData
 * @see     GenQIT_NyuukinKakusyouData
 */
@MappedSuperclass
@Table(name=GenIT_NyuukinKakusyouData.TABLE_NAME)
@IdClass(value=PKIT_NyuukinKakusyouData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_CreditUriageSeikyuuKbn", typeClass=UserType_C_CreditUriageSeikyuuKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_KrkPayEasyHrkmyousiNkKbn", typeClass=UserType_C_KrkPayEasyHrkmyousiNkKbn.class),
    @TypeDef(name="UserType_C_NykhouhouKbn", typeClass=UserType_C_NykhouhouKbn.class),
    @TypeDef(name="UserType_C_Nykkeiro", typeClass=UserType_C_Nykkeiro.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_NyuuryokuKbn", typeClass=UserType_C_NyuuryokuKbn.class),
    @TypeDef(name="UserType_C_Syuudaikocd", typeClass=UserType_C_Syuudaikocd.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_NyuukinKakusyouData extends AbstractExDBEntity<IT_NyuukinKakusyouData, PKIT_NyuukinKakusyouData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_NyuukinKakusyouData";
    public static final String KBNKEY                   = "kbnkey";
    public static final String NYUUKINKAKUSYOUNO        = "nyuukinkakusyouno";
    public static final String SYONO                    = "syono";
    public static final String NYKSYORIYMD              = "nyksyoriymd";
    public static final String NYUUKINKAKUSYOUNRKYMD    = "nyuukinkakusyounrkymd";
    public static final String NYKKEIRO                 = "nykkeiro";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String IKTNYUUKINNUMU           = "iktnyuukinnumu";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String RSGAKU                   = "rsgaku";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String SUITOUBUMONCD            = "suitoubumoncd";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String NYKHOUHOUKBN             = "nykhouhoukbn";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String NYKDENYMD                = "nykdenymd";
    public static final String TABAKARIKANJYONO         = "tabakarikanjyono";
    public static final String NYUUKINKAKUSYOUNRKNO     = "nyuukinkakusyounrkno";
    public static final String NYUURYOKUKBN             = "nyuuryokukbn";
    public static final String SUITONO                  = "suitono";
    public static final String HRKMYOUSINKKBN           = "hrkmyousinkkbn";
    public static final String SUITOSOSHIKICD           = "suitososhikicd";
    public static final String KZHURIKAEBANKCD          = "kzhurikaebankcd";
    public static final String KZHURIKAESITENCD         = "kzhurikaesitencd";
    public static final String UKETUKETENCD             = "uketuketencd";
    public static final String CVSCD                    = "cvscd";
    public static final String RYOUSYUUHM               = "ryousyuuhm";
    public static final String HURIKOMIYOUSIOKYKSMNO    = "hurikomiyousiokyksmno";
    public static final String HURIKOMIYOUSIKAKUNINNO   = "hurikomiyousikakuninno";
    public static final String KINYUUKIKANKBN           = "kinyuukikankbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String SYUUDAIKOCD              = "syuudaikocd";
    public static final String CREDITURIAGESEIKYUUKBN   = "credituriageseikyuukbn";

    private final PKIT_NyuukinKakusyouData primaryKey;

    public GenIT_NyuukinKakusyouData() {
        primaryKey = new PKIT_NyuukinKakusyouData();
    }

    public GenIT_NyuukinKakusyouData(
        String pKbnkey,
        String pNyuukinkakusyouno,
        String pSyono
    ) {
        primaryKey = new PKIT_NyuukinKakusyouData(
            pKbnkey,
            pNyuukinkakusyouno,
            pSyono
        );
    }

    @Transient
    @Override
    public PKIT_NyuukinKakusyouData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_NyuukinKakusyouData> getMetaClass() {
        return QIT_NyuukinKakusyouData.class;
    }

    @Id
    @Column(name=GenIT_NyuukinKakusyouData.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_NyuukinKakusyouData.NYUUKINKAKUSYOUNO)
    public String getNyuukinkakusyouno() {
        return getPrimaryKey().getNyuukinkakusyouno();
    }

    public void setNyuukinkakusyouno(String pNyuukinkakusyouno) {
        getPrimaryKey().setNyuukinkakusyouno(pNyuukinkakusyouno);
    }

    @Id
    @Column(name=GenIT_NyuukinKakusyouData.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private BizDate nyksyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_NyuukinKakusyouData.NYKSYORIYMD)
    public BizDate getNyksyoriymd() {
        return nyksyoriymd;
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        nyksyoriymd = pNyksyoriymd;
    }

    private BizDate nyuukinkakusyounrkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_NyuukinKakusyouData.NYUUKINKAKUSYOUNRKYMD)
    public BizDate getNyuukinkakusyounrkymd() {
        return nyuukinkakusyounrkymd;
    }

    public void setNyuukinkakusyounrkymd(BizDate pNyuukinkakusyounrkymd) {
        nyuukinkakusyounrkymd = pNyuukinkakusyounrkymd;
    }

    private C_Nykkeiro nykkeiro;

    @Type(type="UserType_C_Nykkeiro")
    @Column(name=GenIT_NyuukinKakusyouData.NYKKEIRO)
    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_NyuukinKakusyouData.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_NyuukinKakusyouData.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private C_UmuKbn iktnyuukinnumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_NyuukinKakusyouData.IKTNYUUKINNUMU)
    public C_UmuKbn getIktnyuukinnumu() {
        return iktnyuukinnumu;
    }

    public void setIktnyuukinnumu(C_UmuKbn pIktnyuukinnumu) {
        iktnyuukinnumu = pIktnyuukinnumu;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_NyuukinKakusyouData.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_NyuukinKakusyouData.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_NyuukinKakusyouData.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
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

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_NyuukinKakusyouData.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private String denrenno;

    @Column(name=GenIT_NyuukinKakusyouData.DENRENNO)
    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    private Integer edano;

    @Column(name=GenIT_NyuukinKakusyouData.EDANO)
    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

    private String suitoubumoncd;

    @Column(name=GenIT_NyuukinKakusyouData.SUITOUBUMONCD)
    public String getSuitoubumoncd() {
        return suitoubumoncd;
    }

    public void setSuitoubumoncd(String pSuitoubumoncd) {
        suitoubumoncd = pSuitoubumoncd;
    }

    private String henkousikibetukey;

    @Column(name=GenIT_NyuukinKakusyouData.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private C_NykhouhouKbn nykhouhoukbn;

    @Type(type="UserType_C_NykhouhouKbn")
    @Column(name=GenIT_NyuukinKakusyouData.NYKHOUHOUKBN)
    public C_NykhouhouKbn getNykhouhoukbn() {
        return nykhouhoukbn;
    }

    public void setNykhouhoukbn(C_NykhouhouKbn pNykhouhoukbn) {
        nykhouhoukbn = pNykhouhoukbn;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_NyuukinKakusyouData.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private BizDate nykdenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_NyuukinKakusyouData.NYKDENYMD)
    public BizDate getNykdenymd() {
        return nykdenymd;
    }

    public void setNykdenymd(BizDate pNykdenymd) {
        nykdenymd = pNykdenymd;
    }

    private String tabakarikanjyono;

    @Column(name=GenIT_NyuukinKakusyouData.TABAKARIKANJYONO)
    @Length(length=2)
    @Digit
    public String getTabakarikanjyono() {
        return tabakarikanjyono;
    }

    public void setTabakarikanjyono(String pTabakarikanjyono) {
        tabakarikanjyono = pTabakarikanjyono;
    }

    private String nyuukinkakusyounrkno;

    @Column(name=GenIT_NyuukinKakusyouData.NYUUKINKAKUSYOUNRKNO)
    public String getNyuukinkakusyounrkno() {
        return nyuukinkakusyounrkno;
    }

    public void setNyuukinkakusyounrkno(String pNyuukinkakusyounrkno) {
        nyuukinkakusyounrkno = pNyuukinkakusyounrkno;
    }

    private C_NyuuryokuKbn nyuuryokukbn;

    @Type(type="UserType_C_NyuuryokuKbn")
    @Column(name=GenIT_NyuukinKakusyouData.NYUURYOKUKBN)
    public C_NyuuryokuKbn getNyuuryokukbn() {
        return nyuuryokukbn;
    }

    public void setNyuuryokukbn(C_NyuuryokuKbn pNyuuryokukbn) {
        nyuuryokukbn = pNyuuryokukbn;
    }

    private String suitono;

    @Column(name=GenIT_NyuukinKakusyouData.SUITONO)
    @Length(length=2)
    @Digit
    public String getSuitono() {
        return suitono;
    }

    public void setSuitono(String pSuitono) {
        suitono = pSuitono;
    }

    private C_KrkPayEasyHrkmyousiNkKbn hrkmyousinkkbn;

    @Type(type="UserType_C_KrkPayEasyHrkmyousiNkKbn")
    @Column(name=GenIT_NyuukinKakusyouData.HRKMYOUSINKKBN)
    public C_KrkPayEasyHrkmyousiNkKbn getHrkmyousinkkbn() {
        return hrkmyousinkkbn;
    }

    public void setHrkmyousinkkbn(C_KrkPayEasyHrkmyousiNkKbn pHrkmyousinkkbn) {
        hrkmyousinkkbn = pHrkmyousinkkbn;
    }

    private String suitososhikicd;

    @Column(name=GenIT_NyuukinKakusyouData.SUITOSOSHIKICD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getSuitososhikicd() {
        return suitososhikicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSuitososhikicd(String pSuitososhikicd) {
        suitososhikicd = pSuitososhikicd;
    }

    private String kzhurikaebankcd;

    @Column(name=GenIT_NyuukinKakusyouData.KZHURIKAEBANKCD)
    @Length(length=4)
    @Digit
    public String getKzhurikaebankcd() {
        return kzhurikaebankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKzhurikaebankcd(String pKzhurikaebankcd) {
        kzhurikaebankcd = pKzhurikaebankcd;
    }

    private String kzhurikaesitencd;

    @Column(name=GenIT_NyuukinKakusyouData.KZHURIKAESITENCD)
    public String getKzhurikaesitencd() {
        return kzhurikaesitencd;
    }

    public void setKzhurikaesitencd(String pKzhurikaesitencd) {
        kzhurikaesitencd = pKzhurikaesitencd;
    }

    private String uketuketencd;

    @Column(name=GenIT_NyuukinKakusyouData.UKETUKETENCD)
    public String getUketuketencd() {
        return uketuketencd;
    }

    public void setUketuketencd(String pUketuketencd) {
        uketuketencd = pUketuketencd;
    }

    private String cvscd;

    @Column(name=GenIT_NyuukinKakusyouData.CVSCD)
    public String getCvscd() {
        return cvscd;
    }

    public void setCvscd(String pCvscd) {
        cvscd = pCvscd;
    }

    private String ryousyuuhm;

    @Column(name=GenIT_NyuukinKakusyouData.RYOUSYUUHM)
    public String getRyousyuuhm() {
        return ryousyuuhm;
    }

    public void setRyousyuuhm(String pRyousyuuhm) {
        ryousyuuhm = pRyousyuuhm;
    }

    private String hurikomiyousiokyksmno;

    @Column(name=GenIT_NyuukinKakusyouData.HURIKOMIYOUSIOKYKSMNO)
    public String getHurikomiyousiokyksmno() {
        return hurikomiyousiokyksmno;
    }

    public void setHurikomiyousiokyksmno(String pHurikomiyousiokyksmno) {
        hurikomiyousiokyksmno = pHurikomiyousiokyksmno;
    }

    private String hurikomiyousikakuninno;

    @Column(name=GenIT_NyuukinKakusyouData.HURIKOMIYOUSIKAKUNINNO)
    public String getHurikomiyousikakuninno() {
        return hurikomiyousikakuninno;
    }

    public void setHurikomiyousikakuninno(String pHurikomiyousikakuninno) {
        hurikomiyousikakuninno = pHurikomiyousikakuninno;
    }

    private String kinyuukikankbn;

    @Column(name=GenIT_NyuukinKakusyouData.KINYUUKIKANKBN)
    public String getKinyuukikankbn() {
        return kinyuukikankbn;
    }

    public void setKinyuukikankbn(String pKinyuukikankbn) {
        kinyuukikankbn = pKinyuukikankbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_NyuukinKakusyouData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_NyuukinKakusyouData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_NyuukinKakusyouData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String creditkessaiyouno;

    @Column(name=GenIT_NyuukinKakusyouData.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    private C_Syuudaikocd syuudaikocd;

    @Type(type="UserType_C_Syuudaikocd")
    @Column(name=GenIT_NyuukinKakusyouData.SYUUDAIKOCD)
    public C_Syuudaikocd getSyuudaikocd() {
        return syuudaikocd;
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikocd = pSyuudaikocd;
    }

    private C_CreditUriageSeikyuuKbn credituriageseikyuukbn;

    @Type(type="UserType_C_CreditUriageSeikyuuKbn")
    @Column(name=GenIT_NyuukinKakusyouData.CREDITURIAGESEIKYUUKBN)
    public C_CreditUriageSeikyuuKbn getCredituriageseikyuukbn() {
        return credituriageseikyuukbn;
    }

    public void setCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn pCredituriageseikyuukbn) {
        credituriageseikyuukbn = pCredituriageseikyuukbn;
    }
}