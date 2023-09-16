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
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.db.entity.IT_BAK_Kariukekin;
import yuyu.def.db.id.PKIT_BAK_Kariukekin;
import yuyu.def.db.meta.GenQIT_BAK_Kariukekin;
import yuyu.def.db.meta.QIT_BAK_Kariukekin;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_KrkriyuuKbn;
import yuyu.def.db.type.UserType_C_Krkseisanzumiflg;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 仮受金バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_Kariukekin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_Kariukekin}</td><td colspan="3">仮受金バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_Kariukekin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_Kariukekin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_Kariukekin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKrkno krkno}</td><td>仮受番号</td><td align="center">{@link PKIT_BAK_Kariukekin ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKrkkeijyoymd krkkeijyoymd}</td><td>仮受計上処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKrkgk krkgk}</td><td>仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHasseidenymd hasseidenymd}</td><td>発生伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeisandenymd seisandenymd}</td><td>精算伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKrkseisanzumiflg krkseisanzumiflg}</td><td>仮受精算済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Krkseisanzumiflg}</td></tr>
 *  <tr><td>{@link #getKrkriyuukbn krkriyuukbn}</td><td>仮受理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KrkriyuuKbn}</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getNykkeiro nykkeiro}</td><td>入金経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nykkeiro}</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_Kariukekin
 * @see     PKIT_BAK_Kariukekin
 * @see     QIT_BAK_Kariukekin
 * @see     GenQIT_BAK_Kariukekin
 */
@MappedSuperclass
@Table(name=GenIT_BAK_Kariukekin.TABLE_NAME)
@IdClass(value=PKIT_BAK_Kariukekin.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_KrkriyuuKbn", typeClass=UserType_C_KrkriyuuKbn.class),
    @TypeDef(name="UserType_C_Krkseisanzumiflg", typeClass=UserType_C_Krkseisanzumiflg.class),
    @TypeDef(name="UserType_C_Nykkeiro", typeClass=UserType_C_Nykkeiro.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class)
})
public abstract class GenIT_BAK_Kariukekin extends AbstractExDBEntity<IT_BAK_Kariukekin, PKIT_BAK_Kariukekin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_Kariukekin";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String KRKNO                    = "krkno";
    public static final String KRKKEIJYOYMD             = "krkkeijyoymd";
    public static final String KRKGK                    = "krkgk";
    public static final String HASSEIDENYMD             = "hasseidenymd";
    public static final String SEISANDENYMD             = "seisandenymd";
    public static final String KRKSEISANZUMIFLG         = "krkseisanzumiflg";
    public static final String KRKRIYUUKBN              = "krkriyuukbn";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String NYKKEIRO                 = "nykkeiro";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";

    private final PKIT_BAK_Kariukekin primaryKey;

    public GenIT_BAK_Kariukekin() {
        primaryKey = new PKIT_BAK_Kariukekin();
    }

    public GenIT_BAK_Kariukekin(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        Integer pKrkno
    ) {
        primaryKey = new PKIT_BAK_Kariukekin(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pKrkno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_Kariukekin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_Kariukekin> getMetaClass() {
        return QIT_BAK_Kariukekin.class;
    }

    @Id
    @Column(name=GenIT_BAK_Kariukekin.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_Kariukekin.SYONO)
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
    @Column(name=GenIT_BAK_Kariukekin.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_Kariukekin.KRKNO)
    @Range(min="0", max="99999")
    public Integer getKrkno() {
        return getPrimaryKey().getKrkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKrkno(Integer pKrkno) {
        getPrimaryKey().setKrkno(pKrkno);
    }

    private BizDate krkkeijyoymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_Kariukekin.KRKKEIJYOYMD)
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

    private BizDate hasseidenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_Kariukekin.HASSEIDENYMD)
    public BizDate getHasseidenymd() {
        return hasseidenymd;
    }

    @Trim("both")
    public void setHasseidenymd(BizDate pHasseidenymd) {
        hasseidenymd = pHasseidenymd;
    }

    private BizDate seisandenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_Kariukekin.SEISANDENYMD)
    public BizDate getSeisandenymd() {
        return seisandenymd;
    }

    public void setSeisandenymd(BizDate pSeisandenymd) {
        seisandenymd = pSeisandenymd;
    }

    private C_Krkseisanzumiflg krkseisanzumiflg;

    @Type(type="UserType_C_Krkseisanzumiflg")
    @Column(name=GenIT_BAK_Kariukekin.KRKSEISANZUMIFLG)
    public C_Krkseisanzumiflg getKrkseisanzumiflg() {
        return krkseisanzumiflg;
    }

    public void setKrkseisanzumiflg(C_Krkseisanzumiflg pKrkseisanzumiflg) {
        krkseisanzumiflg = pKrkseisanzumiflg;
    }

    private C_KrkriyuuKbn krkriyuukbn;

    @Type(type="UserType_C_KrkriyuuKbn")
    @Column(name=GenIT_BAK_Kariukekin.KRKRIYUUKBN)
    public C_KrkriyuuKbn getKrkriyuukbn() {
        return krkriyuukbn;
    }

    public void setKrkriyuukbn(C_KrkriyuuKbn pKrkriyuukbn) {
        krkriyuukbn = pKrkriyuukbn;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_BAK_Kariukekin.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private C_Nykkeiro nykkeiro;

    @Type(type="UserType_C_Nykkeiro")
    @Column(name=GenIT_BAK_Kariukekin.NYKKEIRO)
    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_Kariukekin.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_BAK_Kariukekin.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_BAK_Kariukekin.JYUTOUKAISUUM)
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
    @Column(name=GenIT_BAK_Kariukekin.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_BAK_Kariukekin.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_BAK_Kariukekin.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_Kariukekin.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_Kariukekin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_Kariukekin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String creditkessaiyouno;

    @Column(name=GenIT_BAK_Kariukekin.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }
}