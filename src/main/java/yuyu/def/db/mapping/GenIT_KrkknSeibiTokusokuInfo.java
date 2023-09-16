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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KrkknSeibiTokusokuInfo;
import yuyu.def.db.id.PKIT_KrkknSeibiTokusokuInfo;
import yuyu.def.db.meta.GenQIT_KrkknSeibiTokusokuInfo;
import yuyu.def.db.meta.QIT_KrkknSeibiTokusokuInfo;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_KrkriyuuKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 仮受金整備督促情報テーブル テーブルのマッピング情報クラスで、 {@link IT_KrkknSeibiTokusokuInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KrkknSeibiTokusokuInfo}</td><td colspan="3">仮受金整備督促情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KrkknSeibiTokusokuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKrkno krkno}</td><td>仮受番号</td><td align="center">{@link PKIT_KrkknSeibiTokusokuInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getAtesakisosikicd atesakisosikicd}</td><td>宛先組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAtesakibusitucd atesakibusitucd}</td><td>宛先部・室コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyoukimiseibikrkumu tyoukimiseibikrkumu}</td><td>長期未整備仮受金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHukusuukrkumu hukusuukrkumu}</td><td>複数仮受金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKrkkeijyoymd krkkeijyoymd}</td><td>仮受計上処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKrkgk krkgk}</td><td>仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKrkriyuukbn krkriyuukbn}</td><td>仮受理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KrkriyuuKbn}</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getNykkeiro nykkeiro}</td><td>入金経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nykkeiro}</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKrkjhrkkaisuu krkjhrkkaisuu}</td><td>仮受時払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KrkknSeibiTokusokuInfo
 * @see     PKIT_KrkknSeibiTokusokuInfo
 * @see     QIT_KrkknSeibiTokusokuInfo
 * @see     GenQIT_KrkknSeibiTokusokuInfo
 */
@MappedSuperclass
@Table(name=GenIT_KrkknSeibiTokusokuInfo.TABLE_NAME)
@IdClass(value=PKIT_KrkknSeibiTokusokuInfo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_KrkriyuuKbn", typeClass=UserType_C_KrkriyuuKbn.class),
    @TypeDef(name="UserType_C_Nykkeiro", typeClass=UserType_C_Nykkeiro.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_KrkknSeibiTokusokuInfo extends AbstractExDBEntity<IT_KrkknSeibiTokusokuInfo, PKIT_KrkknSeibiTokusokuInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KrkknSeibiTokusokuInfo";
    public static final String SYONO                    = "syono";
    public static final String KRKNO                    = "krkno";
    public static final String ATESAKISOSIKICD          = "atesakisosikicd";
    public static final String ATESAKIBUSITUCD          = "atesakibusitucd";
    public static final String TANTOCD                  = "tantocd";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String TYOUKIMISEIBIKRKUMU      = "tyoukimiseibikrkumu";
    public static final String HUKUSUUKRKUMU            = "hukusuukrkumu";
    public static final String KRKKEIJYOYMD             = "krkkeijyoymd";
    public static final String KRKGK                    = "krkgk";
    public static final String KRKRIYUUKBN              = "krkriyuukbn";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String NYKKEIRO                 = "nykkeiro";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String KRKJHRKKAISUU            = "krkjhrkkaisuu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KrkknSeibiTokusokuInfo primaryKey;

    public GenIT_KrkknSeibiTokusokuInfo() {
        primaryKey = new PKIT_KrkknSeibiTokusokuInfo();
    }

    public GenIT_KrkknSeibiTokusokuInfo(String pSyono, Integer pKrkno) {
        primaryKey = new PKIT_KrkknSeibiTokusokuInfo(pSyono, pKrkno);
    }

    @Transient
    @Override
    public PKIT_KrkknSeibiTokusokuInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KrkknSeibiTokusokuInfo> getMetaClass() {
        return QIT_KrkknSeibiTokusokuInfo.class;
    }

    @Id
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.SYONO)
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
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.KRKNO)
    @Range(min="0", max="99999")
    public Integer getKrkno() {
        return getPrimaryKey().getKrkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKrkno(Integer pKrkno) {
        getPrimaryKey().setKrkno(pKrkno);
    }

    private String atesakisosikicd;

    @Column(name=GenIT_KrkknSeibiTokusokuInfo.ATESAKISOSIKICD)
    public String getAtesakisosikicd() {
        return atesakisosikicd;
    }

    public void setAtesakisosikicd(String pAtesakisosikicd) {
        atesakisosikicd = pAtesakisosikicd;
    }

    private String atesakibusitucd;

    @Column(name=GenIT_KrkknSeibiTokusokuInfo.ATESAKIBUSITUCD)
    public String getAtesakibusitucd() {
        return atesakibusitucd;
    }

    public void setAtesakibusitucd(String pAtesakibusitucd) {
        atesakibusitucd = pAtesakibusitucd;
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private String kyknmkj;

    @Column(name=GenIT_KrkknSeibiTokusokuInfo.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private C_UmuKbn tyoukimiseibikrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.TYOUKIMISEIBIKRKUMU)
    public C_UmuKbn getTyoukimiseibikrkumu() {
        return tyoukimiseibikrkumu;
    }

    public void setTyoukimiseibikrkumu(C_UmuKbn pTyoukimiseibikrkumu) {
        tyoukimiseibikrkumu = pTyoukimiseibikrkumu;
    }

    private C_UmuKbn hukusuukrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.HUKUSUUKRKUMU)
    public C_UmuKbn getHukusuukrkumu() {
        return hukusuukrkumu;
    }

    public void setHukusuukrkumu(C_UmuKbn pHukusuukrkumu) {
        hukusuukrkumu = pHukusuukrkumu;
    }

    private BizDate krkkeijyoymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.KRKKEIJYOYMD)
    public BizDate getKrkkeijyoymd() {
        return krkkeijyoymd;
    }

    @Trim("both")
    public void setKrkkeijyoymd(BizDate pKrkkeijyoymd) {
        krkkeijyoymd = pKrkkeijyoymd;
    }

    private BizCurrency krkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKrkgk() {
        return krkgk;
    }

    public void setKrkgk(BizCurrency pKrkgk) {
        krkgk = pKrkgk;
        krkgkValue = null;
        krkgkType  = null;
    }

    transient private BigDecimal krkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KRKGK, nullable=true)
    protected BigDecimal getKrkgkValue() {
        if (krkgkValue == null && krkgk != null) {
            if (krkgk.isOptional()) return null;
            return krkgk.absolute();
        }
        return krkgkValue;
    }

    protected void setKrkgkValue(BigDecimal value) {
        krkgkValue = value;
        krkgk = Optional.fromNullable(toCurrencyType(krkgkType))
            .transform(bizCurrencyTransformer(getKrkgkValue()))
            .orNull();
    }

    transient private String krkgkType = null;

    @Column(name=KRKGK + "$", nullable=true)
    protected String getKrkgkType() {
        if (krkgkType == null && krkgk != null) return krkgk.getType().toString();
        if (krkgkType == null && getKrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'krkgk$' should not be NULL."));
        }
        return krkgkType;
    }

    protected void setKrkgkType(String type) {
        krkgkType = type;
        krkgk = Optional.fromNullable(toCurrencyType(krkgkType))
            .transform(bizCurrencyTransformer(getKrkgkValue()))
            .orNull();
    }

    private C_KrkriyuuKbn krkriyuukbn;

    @Type(type="UserType_C_KrkriyuuKbn")
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.KRKRIYUUKBN)
    public C_KrkriyuuKbn getKrkriyuukbn() {
        return krkriyuukbn;
    }

    public void setKrkriyuukbn(C_KrkriyuuKbn pKrkriyuukbn) {
        krkriyuukbn = pKrkriyuukbn;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private C_Nykkeiro nykkeiro;

    @Type(type="UserType_C_Nykkeiro")
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.NYKKEIRO)
    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_KrkknSeibiTokusokuInfo.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_KrkknSeibiTokusokuInfo.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private C_Hrkkaisuu krkjhrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_KrkknSeibiTokusokuInfo.KRKJHRKKAISUU)
    public C_Hrkkaisuu getKrkjhrkkaisuu() {
        return krkjhrkkaisuu;
    }

    public void setKrkjhrkkaisuu(C_Hrkkaisuu pKrkjhrkkaisuu) {
        krkjhrkkaisuu = pKrkjhrkkaisuu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KrkknSeibiTokusokuInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KrkknSeibiTokusokuInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KrkknSeibiTokusokuInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}