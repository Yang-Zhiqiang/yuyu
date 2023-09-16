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
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuriDenpyouKykTuukaKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KanjyoukmkgroupKbn;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.def.db.id.PKBT_SinkeiyakuHurikaeDen;
import yuyu.def.db.meta.GenQBT_SinkeiyakuHurikaeDen;
import yuyu.def.db.meta.QBT_SinkeiyakuHurikaeDen;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HuriDenpyouKykTuukaKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KanjyoukmkgroupKbn;
import yuyu.def.db.type.UserType_C_KeirisysKbn;
import yuyu.def.db.type.UserType_C_NaibuKeiyakuKbn;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TekiyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 新契約振替伝票作成用テーブル テーブルのマッピング情報クラスで、 {@link BT_SinkeiyakuHurikaeDen} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SinkeiyakuHurikaeDen}</td><td colspan="3">新契約振替伝票作成用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">{@link PKBT_SinkeiyakuHurikaeDen ○}</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">{@link PKBT_SinkeiyakuHurikaeDen ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">{@link PKBT_SinkeiyakuHurikaeDen ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTorihikino torihikino}</td><td>取引番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeirisyskbn keirisyskbn}</td><td>経理システム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KeirisysKbn}</td></tr>
 *  <tr><td>{@link #getKeirisyono keirisyono}</td><td>経理用証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHuridenatesakicd huridenatesakicd}</td><td>振替伝票宛先部課コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getDenkanjokamokucd denkanjokamokucd}</td><td>伝票用勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjyoukmkgroupkbn kanjyoukmkgroupkbn}</td><td>勘定科目グループ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KanjyoukmkgroupKbn}</td></tr>
 *  <tr><td>{@link #getSuitoubumoncd suitoubumoncd}</td><td>出納部門コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDenyenkagk denyenkagk}</td><td>伝票金額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNaibukeiyakukbn naibukeiyakukbn}</td><td>内部契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NaibuKeiyakuKbn}</td></tr>
 *  <tr><td>{@link #getTekiyoukbn tekiyoukbn}</td><td>摘要区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TekiyouKbn}</td></tr>
 *  <tr><td>{@link #getTekiyoucd tekiyoucd}</td><td>摘要コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHuridenpyoukyktuukakbn huridenpyoukyktuukakbn}</td><td>振替伝票用契約通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HuriDenpyouKykTuukaKbn}</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDengyoumucd dengyoumucd}</td><td>伝票用業務コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_SinkeiyakuHurikaeDen
 * @see     PKBT_SinkeiyakuHurikaeDen
 * @see     QBT_SinkeiyakuHurikaeDen
 * @see     GenQBT_SinkeiyakuHurikaeDen
 */
@MappedSuperclass
@Table(name=GenBT_SinkeiyakuHurikaeDen.TABLE_NAME)
@IdClass(value=PKBT_SinkeiyakuHurikaeDen.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DensysKbn", typeClass=UserType_C_DensysKbn.class),
    @TypeDef(name="UserType_C_HuriDenpyouKykTuukaKbn", typeClass=UserType_C_HuriDenpyouKykTuukaKbn.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_KanjyoukmkgroupKbn", typeClass=UserType_C_KanjyoukmkgroupKbn.class),
    @TypeDef(name="UserType_C_KeirisysKbn", typeClass=UserType_C_KeirisysKbn.class),
    @TypeDef(name="UserType_C_NaibuKeiyakuKbn", typeClass=UserType_C_NaibuKeiyakuKbn.class),
    @TypeDef(name="UserType_C_TaisyakuKbn", typeClass=UserType_C_TaisyakuKbn.class),
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class),
    @TypeDef(name="UserType_C_TekiyouKbn", typeClass=UserType_C_TekiyouKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBT_SinkeiyakuHurikaeDen extends AbstractExDBEntity<BT_SinkeiyakuHurikaeDen, PKBT_SinkeiyakuHurikaeDen> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_SinkeiyakuHurikaeDen";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String TORIHIKINO               = "torihikino";
    public static final String KEIRISYSKBN              = "keirisyskbn";
    public static final String KEIRISYONO               = "keirisyono";
    public static final String HURIDENATESAKICD         = "huridenatesakicd";
    public static final String TANTOCD                  = "tantocd";
    public static final String DENYMD                   = "denymd";
    public static final String TAISYAKUKBN              = "taisyakukbn";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String DENKANJOKAMOKUCD         = "denkanjokamokucd";
    public static final String KANJYOUKMKGROUPKBN       = "kanjyoukmkgroupkbn";
    public static final String SUITOUBUMONCD            = "suitoubumoncd";
    public static final String DENYENKAGK               = "denyenkagk";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String NAIBUKEIYAKUKBN          = "naibukeiyakukbn";
    public static final String TEKIYOUKBN               = "tekiyoukbn";
    public static final String TEKIYOUCD                = "tekiyoucd";
    public static final String HURIDENPYOUKYKTUUKAKBN   = "huridenpyoukyktuukakbn";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String DENGYOUMUCD              = "dengyoumucd";

    private final PKBT_SinkeiyakuHurikaeDen primaryKey;

    public GenBT_SinkeiyakuHurikaeDen() {
        primaryKey = new PKBT_SinkeiyakuHurikaeDen();
    }

    public GenBT_SinkeiyakuHurikaeDen(
        C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano
    ) {
        primaryKey = new PKBT_SinkeiyakuHurikaeDen(
            pDensyskbn,
            pDenrenno,
            pEdano
        );
    }

    @Transient
    @Override
    public PKBT_SinkeiyakuHurikaeDen getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_SinkeiyakuHurikaeDen> getMetaClass() {
        return QBT_SinkeiyakuHurikaeDen.class;
    }

    @Id
    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return getPrimaryKey().getDensyskbn();
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        getPrimaryKey().setDensyskbn(pDensyskbn);
    }

    @Id
    @Column(name=GenBT_SinkeiyakuHurikaeDen.DENRENNO)
    public String getDenrenno() {
        return getPrimaryKey().getDenrenno();
    }

    public void setDenrenno(String pDenrenno) {
        getPrimaryKey().setDenrenno(pDenrenno);
    }

    @Id
    @Column(name=GenBT_SinkeiyakuHurikaeDen.EDANO)
    public Integer getEdano() {
        return getPrimaryKey().getEdano();
    }

    public void setEdano(Integer pEdano) {
        getPrimaryKey().setEdano(pEdano);
    }

    private String torihikino;

    @Column(name=GenBT_SinkeiyakuHurikaeDen.TORIHIKINO)
    public String getTorihikino() {
        return torihikino;
    }

    public void setTorihikino(String pTorihikino) {
        torihikino = pTorihikino;
    }

    private C_KeirisysKbn keirisyskbn;

    @Type(type="UserType_C_KeirisysKbn")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.KEIRISYSKBN)
    public C_KeirisysKbn getKeirisyskbn() {
        return keirisyskbn;
    }

    public void setKeirisyskbn(C_KeirisysKbn pKeirisyskbn) {
        keirisyskbn = pKeirisyskbn;
    }

    private String keirisyono;

    @Column(name=GenBT_SinkeiyakuHurikaeDen.KEIRISYONO)
    public String getKeirisyono() {
        return keirisyono;
    }

    public void setKeirisyono(String pKeirisyono) {
        keirisyono = pKeirisyono;
    }

    private String huridenatesakicd;

    @Column(name=GenBT_SinkeiyakuHurikaeDen.HURIDENATESAKICD)
    public String getHuridenatesakicd() {
        return huridenatesakicd;
    }

    public void setHuridenatesakicd(String pHuridenatesakicd) {
        huridenatesakicd = pHuridenatesakicd;
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private C_TaisyakuKbn taisyakukbn;

    @Type(type="UserType_C_TaisyakuKbn")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    private String denkanjokamokucd;

    @Column(name=GenBT_SinkeiyakuHurikaeDen.DENKANJOKAMOKUCD)
    public String getDenkanjokamokucd() {
        return denkanjokamokucd;
    }

    public void setDenkanjokamokucd(String pDenkanjokamokucd) {
        denkanjokamokucd = pDenkanjokamokucd;
    }

    private C_KanjyoukmkgroupKbn kanjyoukmkgroupkbn;

    @Type(type="UserType_C_KanjyoukmkgroupKbn")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.KANJYOUKMKGROUPKBN)
    public C_KanjyoukmkgroupKbn getKanjyoukmkgroupkbn() {
        return kanjyoukmkgroupkbn;
    }

    public void setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn pKanjyoukmkgroupkbn) {
        kanjyoukmkgroupkbn = pKanjyoukmkgroupkbn;
    }

    private String suitoubumoncd;

    @Column(name=GenBT_SinkeiyakuHurikaeDen.SUITOUBUMONCD)
    public String getSuitoubumoncd() {
        return suitoubumoncd;
    }

    public void setSuitoubumoncd(String pSuitoubumoncd) {
        suitoubumoncd = pSuitoubumoncd;
    }

    private BizCurrency denyenkagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDenyenkagk() {
        return denyenkagk;
    }

    public void setDenyenkagk(BizCurrency pDenyenkagk) {
        denyenkagk = pDenyenkagk;
        denyenkagkValue = null;
        denyenkagkType  = null;
    }

    transient private BigDecimal denyenkagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DENYENKAGK, nullable=true)
    protected BigDecimal getDenyenkagkValue() {
        if (denyenkagkValue == null && denyenkagk != null) {
            if (denyenkagk.isOptional()) return null;
            return denyenkagk.absolute();
        }
        return denyenkagkValue;
    }

    protected void setDenyenkagkValue(BigDecimal value) {
        denyenkagkValue = value;
        denyenkagk = Optional.fromNullable(toCurrencyType(denyenkagkType))
            .transform(bizCurrencyTransformer(getDenyenkagkValue()))
            .orNull();
    }

    transient private String denyenkagkType = null;

    @Column(name=DENYENKAGK + "$", nullable=true)
    protected String getDenyenkagkType() {
        if (denyenkagkType == null && denyenkagk != null) return denyenkagk.getType().toString();
        if (denyenkagkType == null && getDenyenkagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'denyenkagk$' should not be NULL."));
        }
        return denyenkagkType;
    }

    protected void setDenyenkagkType(String type) {
        denyenkagkType = type;
        denyenkagk = Optional.fromNullable(toCurrencyType(denyenkagkType))
            .transform(bizCurrencyTransformer(getDenyenkagkValue()))
            .orNull();
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_NaibuKeiyakuKbn naibukeiyakukbn;

    @Type(type="UserType_C_NaibuKeiyakuKbn")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.NAIBUKEIYAKUKBN)
    public C_NaibuKeiyakuKbn getNaibukeiyakukbn() {
        return naibukeiyakukbn;
    }

    public void setNaibukeiyakukbn(C_NaibuKeiyakuKbn pNaibukeiyakukbn) {
        naibukeiyakukbn = pNaibukeiyakukbn;
    }

    private C_TekiyouKbn tekiyoukbn;

    @Type(type="UserType_C_TekiyouKbn")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.TEKIYOUKBN)
    public C_TekiyouKbn getTekiyoukbn() {
        return tekiyoukbn;
    }

    public void setTekiyoukbn(C_TekiyouKbn pTekiyoukbn) {
        tekiyoukbn = pTekiyoukbn;
    }

    private String tekiyoucd;

    @Column(name=GenBT_SinkeiyakuHurikaeDen.TEKIYOUCD)
    public String getTekiyoucd() {
        return tekiyoucd;
    }

    public void setTekiyoucd(String pTekiyoucd) {
        tekiyoucd = pTekiyoucd;
    }

    private C_HuriDenpyouKykTuukaKbn huridenpyoukyktuukakbn;

    @Type(type="UserType_C_HuriDenpyouKykTuukaKbn")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.HURIDENPYOUKYKTUUKAKBN)
    public C_HuriDenpyouKykTuukaKbn getHuridenpyoukyktuukakbn() {
        return huridenpyoukyktuukakbn;
    }

    public void setHuridenpyoukyktuukakbn(C_HuriDenpyouKykTuukaKbn pHuridenpyoukyktuukakbn) {
        huridenpyoukyktuukakbn = pHuridenpyoukyktuukakbn;
    }

    private C_Tuukasyu tuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_SinkeiyakuHurikaeDen.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_SinkeiyakuHurikaeDen.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_SinkeiyakuHurikaeDen.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String dengyoumucd;

    @Column(name=GenBT_SinkeiyakuHurikaeDen.DENGYOUMUCD)
    public String getDengyoumucd() {
        return dengyoumucd;
    }

    public void setDengyoumucd(String pDengyoumucd) {
        dengyoumucd = pDengyoumucd;
    }
}