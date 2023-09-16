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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HuridenpageKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.def.db.id.PKST_SkOikmTyouseiDenpyou;
import yuyu.def.db.meta.GenQST_SkOikmTyouseiDenpyou;
import yuyu.def.db.meta.QST_SkOikmTyouseiDenpyou;
import yuyu.def.db.type.UserType_C_HuridenpageKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_NaibuKeiyakuKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TekiyouKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約追込調整伝票データテーブル テーブルのマッピング情報クラスで、 {@link ST_SkOikmTyouseiDenpyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_SkOikmTyouseiDenpyou}</td><td colspan="3">新契約追込調整伝票データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKST_SkOikmTyouseiDenpyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">{@link PKST_SkOikmTyouseiDenpyou ○}</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">{@link PKST_SkOikmTyouseiDenpyou ○}</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>{@link #getNaibukeiyakukbn naibukeiyakukbn}</td><td>内部契約区分</td><td align="center">{@link PKST_SkOikmTyouseiDenpyou ○}</td><td align="center">V</td><td>{@link C_NaibuKeiyakuKbn}</td></tr>
 *  <tr><td>{@link #getTekiyoukbn tekiyoukbn}</td><td>摘要区分</td><td align="center">{@link PKST_SkOikmTyouseiDenpyou ○}</td><td align="center">V</td><td>{@link C_TekiyouKbn}</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">{@link PKST_SkOikmTyouseiDenpyou ○}</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getHuridenatesakicd huridenatesakicd}</td><td>振替伝票宛先部課コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>{@link #getDenkanjokamokucd denkanjokamokucd}</td><td>伝票用勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyoucd tekiyoucd}</td><td>摘要コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSuitoubumoncd suitoubumoncd}</td><td>出納部門コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDenyenkagk denyenkagk}</td><td>伝票金額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHuridenpagekbn huridenpagekbn}</td><td>振替伝票ページ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HuridenpageKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_SkOikmTyouseiDenpyou
 * @see     PKST_SkOikmTyouseiDenpyou
 * @see     QST_SkOikmTyouseiDenpyou
 * @see     GenQST_SkOikmTyouseiDenpyou
 */
@MappedSuperclass
@Table(name=GenST_SkOikmTyouseiDenpyou.TABLE_NAME)
@IdClass(value=PKST_SkOikmTyouseiDenpyou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="UserType_C_HuridenpageKbn", typeClass=UserType_C_HuridenpageKbn.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_NaibuKeiyakuKbn", typeClass=UserType_C_NaibuKeiyakuKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_TaisyakuKbn", typeClass=UserType_C_TaisyakuKbn.class),
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class),
    @TypeDef(name="UserType_C_TekiyouKbn", typeClass=UserType_C_TekiyouKbn.class)
})
public abstract class GenST_SkOikmTyouseiDenpyou extends AbstractExDBEntity<ST_SkOikmTyouseiDenpyou, PKST_SkOikmTyouseiDenpyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_SkOikmTyouseiDenpyou";
    public static final String MOSNO                    = "mosno";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String TAISYAKUKBN              = "taisyakukbn";
    public static final String NAIBUKEIYAKUKBN          = "naibukeiyakukbn";
    public static final String TEKIYOUKBN               = "tekiyoukbn";
    public static final String SEG1CD                   = "seg1cd";
    public static final String HURIDENATESAKICD         = "huridenatesakicd";
    public static final String TANTOCD                  = "tantocd";
    public static final String DENKANJOKAMOKUCD         = "denkanjokamokucd";
    public static final String TEKIYOUCD                = "tekiyoucd";
    public static final String SUITOUBUMONCD            = "suitoubumoncd";
    public static final String DENYENKAGK               = "denyenkagk";
    public static final String HURIDENPAGEKBN           = "huridenpagekbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKST_SkOikmTyouseiDenpyou primaryKey;

    public GenST_SkOikmTyouseiDenpyou() {
        primaryKey = new PKST_SkOikmTyouseiDenpyou();
    }

    public GenST_SkOikmTyouseiDenpyou(
        String pMosno,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        C_TaisyakuKbn pTaisyakukbn,
        C_NaibuKeiyakuKbn pNaibukeiyakukbn,
        C_TekiyouKbn pTekiyoukbn,
        C_Segcd pSeg1cd
    ) {
        primaryKey = new PKST_SkOikmTyouseiDenpyou(
            pMosno,
            pKanjyoukmkcd,
            pTaisyakukbn,
            pNaibukeiyakukbn,
            pTekiyoukbn,
            pSeg1cd
        );
    }

    @Transient
    @Override
    public PKST_SkOikmTyouseiDenpyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_SkOikmTyouseiDenpyou> getMetaClass() {
        return QST_SkOikmTyouseiDenpyou.class;
    }

    @Id
    @Column(name=GenST_SkOikmTyouseiDenpyou.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenST_SkOikmTyouseiDenpyou.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return getPrimaryKey().getKanjyoukmkcd();
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        getPrimaryKey().setKanjyoukmkcd(pKanjyoukmkcd);
    }

    @Id
    @Type(type="UserType_C_TaisyakuKbn")
    @Column(name=GenST_SkOikmTyouseiDenpyou.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return getPrimaryKey().getTaisyakukbn();
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        getPrimaryKey().setTaisyakukbn(pTaisyakukbn);
    }

    @Id
    @Type(type="UserType_C_NaibuKeiyakuKbn")
    @Column(name=GenST_SkOikmTyouseiDenpyou.NAIBUKEIYAKUKBN)
    public C_NaibuKeiyakuKbn getNaibukeiyakukbn() {
        return getPrimaryKey().getNaibukeiyakukbn();
    }

    public void setNaibukeiyakukbn(C_NaibuKeiyakuKbn pNaibukeiyakukbn) {
        getPrimaryKey().setNaibukeiyakukbn(pNaibukeiyakukbn);
    }

    @Id
    @Type(type="UserType_C_TekiyouKbn")
    @Column(name=GenST_SkOikmTyouseiDenpyou.TEKIYOUKBN)
    public C_TekiyouKbn getTekiyoukbn() {
        return getPrimaryKey().getTekiyoukbn();
    }

    public void setTekiyoukbn(C_TekiyouKbn pTekiyoukbn) {
        getPrimaryKey().setTekiyoukbn(pTekiyoukbn);
    }

    @Id
    @Type(type="UserType_C_Segcd")
    @Column(name=GenST_SkOikmTyouseiDenpyou.SEG1CD)
    public C_Segcd getSeg1cd() {
        return getPrimaryKey().getSeg1cd();
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        getPrimaryKey().setSeg1cd(pSeg1cd);
    }

    private String huridenatesakicd;

    @Column(name=GenST_SkOikmTyouseiDenpyou.HURIDENATESAKICD)
    public String getHuridenatesakicd() {
        return huridenatesakicd;
    }

    public void setHuridenatesakicd(String pHuridenatesakicd) {
        huridenatesakicd = pHuridenatesakicd;
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenST_SkOikmTyouseiDenpyou.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private String denkanjokamokucd;

    @Column(name=GenST_SkOikmTyouseiDenpyou.DENKANJOKAMOKUCD)
    public String getDenkanjokamokucd() {
        return denkanjokamokucd;
    }

    public void setDenkanjokamokucd(String pDenkanjokamokucd) {
        denkanjokamokucd = pDenkanjokamokucd;
    }

    private String tekiyoucd;

    @Column(name=GenST_SkOikmTyouseiDenpyou.TEKIYOUCD)
    public String getTekiyoucd() {
        return tekiyoucd;
    }

    public void setTekiyoucd(String pTekiyoucd) {
        tekiyoucd = pTekiyoucd;
    }

    private String suitoubumoncd;

    @Column(name=GenST_SkOikmTyouseiDenpyou.SUITOUBUMONCD)
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

    private C_HuridenpageKbn huridenpagekbn;

    @Type(type="UserType_C_HuridenpageKbn")
    @Column(name=GenST_SkOikmTyouseiDenpyou.HURIDENPAGEKBN)
    public C_HuridenpageKbn getHuridenpagekbn() {
        return huridenpagekbn;
    }

    public void setHuridenpagekbn(C_HuridenpageKbn pHuridenpagekbn) {
        huridenpagekbn = pHuridenpagekbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenST_SkOikmTyouseiDenpyou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenST_SkOikmTyouseiDenpyou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}