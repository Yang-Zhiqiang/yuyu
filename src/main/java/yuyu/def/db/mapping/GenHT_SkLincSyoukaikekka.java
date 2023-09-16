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
import yuyu.def.classification.C_AnkenJyoutaiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykSyubetuKbn;
import yuyu.def.classification.C_LincSyoukaiSyubetuKbn;
import yuyu.def.classification.C_LinchhknseiKbn;
import yuyu.def.db.entity.HT_SkLincSyoukaikekka;
import yuyu.def.db.id.PKHT_SkLincSyoukaikekka;
import yuyu.def.db.meta.GenQHT_SkLincSyoukaikekka;
import yuyu.def.db.meta.QHT_SkLincSyoukaikekka;
import yuyu.def.db.type.UserType_C_AnkenJyoutaiKbn;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_KykSyubetuKbn;
import yuyu.def.db.type.UserType_C_LincSyoukaiSyubetuKbn;
import yuyu.def.db.type.UserType_C_LinchhknseiKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約ＬＩＮＣ他社照会結果テーブル テーブルのマッピング情報クラスで、 {@link HT_SkLincSyoukaikekka} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkLincSyoukaikekka}</td><td colspan="3">新契約ＬＩＮＣ他社照会結果テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SkLincSyoukaikekka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLincjyusintrrenno lincjyusintrrenno}</td><td>ＬＩＮＣ受信ＴＲ連番</td><td align="center">{@link PKHT_SkLincSyoukaikekka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_SkLincSyoukaikekka ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getAnkenjyoutai ankenjyoutai}</td><td>案件状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AnkenJyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getKyksyubetu kyksyubetu}</td><td>契約種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykSyubetuKbn}</td></tr>
 *  <tr><td>{@link #getLincsousinmotokaisya lincsousinmotokaisya}</td><td>ＬＩＮＣ＿送信元会社</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykkbn kykkbn}</td><td>契約者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykKbn}</td></tr>
 *  <tr><td>{@link #getKyknmlinckn kyknmlinckn}</td><td>契約者名（ＬＩＮＣ用カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmlinckj kyknmlinckj}</td><td>契約者名（ＬＩＮＣ用漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmlinckn hhknnmlinckn}</td><td>被保険者名（ＬＩＮＣ用カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmlinckj hhknnmlinckj}</td><td>被保険者名（ＬＩＮＣ用漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinchhknseikbn linchhknseikbn}</td><td>ＬＩＮＣ用被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LinchhknseiKbn}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknadrlinckn30 hhknadrlinckn30}</td><td>被保険者住所（ＬＩＮＣ用カナ）３０桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeiyakuymd keiyakuymd}</td><td>契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkmousideymd trkmousideymd}</td><td>登録申出年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSgnyung sgnyung}</td><td>災害入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSipnyung sipnyung}</td><td>疾病入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSjnyung sjnyung}</td><td>成人病入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotanyuinng sonotanyuinng}</td><td>その他入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHutuusb hutuusb}</td><td>普通死亡保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSgsbksns sgsbksns}</td><td>災害死亡時加算保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKanyuusyano kanyuusyano}</td><td>加入者番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getLinckykkanrino linckykkanrino}</td><td>ＬＩＮＣ＿契約管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLincsyoukaisyubetu lincsyoukaisyubetu}</td><td>ＬＩＮＣ照会種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LincSyoukaiSyubetuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkLincSyoukaikekka
 * @see     PKHT_SkLincSyoukaikekka
 * @see     QHT_SkLincSyoukaikekka
 * @see     GenQHT_SkLincSyoukaikekka
 */
@MappedSuperclass
@Table(name=GenHT_SkLincSyoukaikekka.TABLE_NAME)
@IdClass(value=PKHT_SkLincSyoukaikekka.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_AnkenJyoutaiKbn", typeClass=UserType_C_AnkenJyoutaiKbn.class),
    @TypeDef(name="UserType_C_KykKbn", typeClass=UserType_C_KykKbn.class),
    @TypeDef(name="UserType_C_KykSyubetuKbn", typeClass=UserType_C_KykSyubetuKbn.class),
    @TypeDef(name="UserType_C_LincSyoukaiSyubetuKbn", typeClass=UserType_C_LincSyoukaiSyubetuKbn.class),
    @TypeDef(name="UserType_C_LinchhknseiKbn", typeClass=UserType_C_LinchhknseiKbn.class)
})
public abstract class GenHT_SkLincSyoukaikekka extends AbstractExDBEntity<HT_SkLincSyoukaikekka, PKHT_SkLincSyoukaikekka> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkLincSyoukaikekka";
    public static final String MOSNO                    = "mosno";
    public static final String LINCJYUSINTRRENNO        = "lincjyusintrrenno";
    public static final String RENNO                    = "renno";
    public static final String ANKENJYOUTAI             = "ankenjyoutai";
    public static final String KYKSYUBETU               = "kyksyubetu";
    public static final String LINCSOUSINMOTOKAISYA     = "lincsousinmotokaisya";
    public static final String KYKKBN                   = "kykkbn";
    public static final String KYKNMLINCKN              = "kyknmlinckn";
    public static final String KYKNMLINCKJ              = "kyknmlinckj";
    public static final String HHKNNMLINCKN             = "hhknnmlinckn";
    public static final String HHKNNMLINCKJ             = "hhknnmlinckj";
    public static final String LINCHHKNSEIKBN           = "linchhknseikbn";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNADRLINCKN30          = "hhknadrlinckn30";
    public static final String KEIYAKUYMD               = "keiyakuymd";
    public static final String TRKMOUSIDEYMD            = "trkmousideymd";
    public static final String SGNYUNG                  = "sgnyung";
    public static final String SIPNYUNG                 = "sipnyung";
    public static final String SJNYUNG                  = "sjnyung";
    public static final String SONOTANYUINNG            = "sonotanyuinng";
    public static final String HUTUUSB                  = "hutuusb";
    public static final String SGSBKSNS                 = "sgsbksns";
    public static final String KANYUUSYANO              = "kanyuusyano";
    public static final String LINCKYKKANRINO           = "linckykkanrino";
    public static final String LINCSYOUKAISYUBETU       = "lincsyoukaisyubetu";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkLincSyoukaikekka primaryKey;

    public GenHT_SkLincSyoukaikekka() {
        primaryKey = new PKHT_SkLincSyoukaikekka();
    }

    public GenHT_SkLincSyoukaikekka(
        String pMosno,
        String pLincjyusintrrenno,
        Integer pRenno
    ) {
        primaryKey = new PKHT_SkLincSyoukaikekka(
            pMosno,
            pLincjyusintrrenno,
            pRenno
        );
    }

    @Transient
    @Override
    public PKHT_SkLincSyoukaikekka getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkLincSyoukaikekka> getMetaClass() {
        return QHT_SkLincSyoukaikekka.class;
    }

    @Id
    @Column(name=GenHT_SkLincSyoukaikekka.MOSNO)
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
    @Column(name=GenHT_SkLincSyoukaikekka.LINCJYUSINTRRENNO)
    public String getLincjyusintrrenno() {
        return getPrimaryKey().getLincjyusintrrenno();
    }

    public void setLincjyusintrrenno(String pLincjyusintrrenno) {
        getPrimaryKey().setLincjyusintrrenno(pLincjyusintrrenno);
    }

    @Id
    @Column(name=GenHT_SkLincSyoukaikekka.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_AnkenJyoutaiKbn ankenjyoutai;

    @Type(type="UserType_C_AnkenJyoutaiKbn")
    @Column(name=GenHT_SkLincSyoukaikekka.ANKENJYOUTAI)
    public C_AnkenJyoutaiKbn getAnkenjyoutai() {
        return ankenjyoutai;
    }

    public void setAnkenjyoutai(C_AnkenJyoutaiKbn pAnkenjyoutai) {
        ankenjyoutai = pAnkenjyoutai;
    }

    private C_KykSyubetuKbn kyksyubetu;

    @Type(type="UserType_C_KykSyubetuKbn")
    @Column(name=GenHT_SkLincSyoukaikekka.KYKSYUBETU)
    public C_KykSyubetuKbn getKyksyubetu() {
        return kyksyubetu;
    }

    public void setKyksyubetu(C_KykSyubetuKbn pKyksyubetu) {
        kyksyubetu = pKyksyubetu;
    }

    private String lincsousinmotokaisya;

    @Column(name=GenHT_SkLincSyoukaikekka.LINCSOUSINMOTOKAISYA)
    public String getLincsousinmotokaisya() {
        return lincsousinmotokaisya;
    }

    public void setLincsousinmotokaisya(String pLincsousinmotokaisya) {
        lincsousinmotokaisya = pLincsousinmotokaisya;
    }

    private C_KykKbn kykkbn;

    @Type(type="UserType_C_KykKbn")
    @Column(name=GenHT_SkLincSyoukaikekka.KYKKBN)
    public C_KykKbn getKykkbn() {
        return kykkbn;
    }

    public void setKykkbn(C_KykKbn pKykkbn) {
        kykkbn = pKykkbn;
    }

    private String kyknmlinckn;

    @Column(name=GenHT_SkLincSyoukaikekka.KYKNMLINCKN)
    public String getKyknmlinckn() {
        return kyknmlinckn;
    }

    public void setKyknmlinckn(String pKyknmlinckn) {
        kyknmlinckn = pKyknmlinckn;
    }

    private String kyknmlinckj;

    @Column(name=GenHT_SkLincSyoukaikekka.KYKNMLINCKJ)
    public String getKyknmlinckj() {
        return kyknmlinckj;
    }

    public void setKyknmlinckj(String pKyknmlinckj) {
        kyknmlinckj = pKyknmlinckj;
    }

    private String hhknnmlinckn;

    @Column(name=GenHT_SkLincSyoukaikekka.HHKNNMLINCKN)
    public String getHhknnmlinckn() {
        return hhknnmlinckn;
    }

    public void setHhknnmlinckn(String pHhknnmlinckn) {
        hhknnmlinckn = pHhknnmlinckn;
    }

    private String hhknnmlinckj;

    @Column(name=GenHT_SkLincSyoukaikekka.HHKNNMLINCKJ)
    public String getHhknnmlinckj() {
        return hhknnmlinckj;
    }

    public void setHhknnmlinckj(String pHhknnmlinckj) {
        hhknnmlinckj = pHhknnmlinckj;
    }

    private C_LinchhknseiKbn linchhknseikbn;

    @Type(type="UserType_C_LinchhknseiKbn")
    @Column(name=GenHT_SkLincSyoukaikekka.LINCHHKNSEIKBN)
    public C_LinchhknseiKbn getLinchhknseikbn() {
        return linchhknseikbn;
    }

    public void setLinchhknseikbn(C_LinchhknseiKbn pLinchhknseikbn) {
        linchhknseikbn = pLinchhknseikbn;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincSyoukaikekka.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private String hhknadrlinckn30;

    @Column(name=GenHT_SkLincSyoukaikekka.HHKNADRLINCKN30)
    public String getHhknadrlinckn30() {
        return hhknadrlinckn30;
    }

    public void setHhknadrlinckn30(String pHhknadrlinckn30) {
        hhknadrlinckn30 = pHhknadrlinckn30;
    }

    private BizDate keiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincSyoukaikekka.KEIYAKUYMD)
    public BizDate getKeiyakuymd() {
        return keiyakuymd;
    }

    public void setKeiyakuymd(BizDate pKeiyakuymd) {
        keiyakuymd = pKeiyakuymd;
    }

    private BizDate trkmousideymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincSyoukaikekka.TRKMOUSIDEYMD)
    public BizDate getTrkmousideymd() {
        return trkmousideymd;
    }

    public void setTrkmousideymd(BizDate pTrkmousideymd) {
        trkmousideymd = pTrkmousideymd;
    }

    private BizCurrency sgnyung;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSgnyung() {
        return sgnyung;
    }

    public void setSgnyung(BizCurrency pSgnyung) {
        sgnyung = pSgnyung;
        sgnyungValue = null;
        sgnyungType  = null;
    }

    transient private BigDecimal sgnyungValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SGNYUNG, nullable=true)
    protected BigDecimal getSgnyungValue() {
        if (sgnyungValue == null && sgnyung != null) {
            if (sgnyung.isOptional()) return null;
            return sgnyung.absolute();
        }
        return sgnyungValue;
    }

    protected void setSgnyungValue(BigDecimal value) {
        sgnyungValue = value;
        sgnyung = Optional.fromNullable(toCurrencyType(sgnyungType))
            .transform(bizCurrencyTransformer(getSgnyungValue()))
            .orNull();
    }

    transient private String sgnyungType = null;

    @Column(name=SGNYUNG + "$", nullable=true)
    protected String getSgnyungType() {
        if (sgnyungType == null && sgnyung != null) return sgnyung.getType().toString();
        if (sgnyungType == null && getSgnyungValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sgnyung$' should not be NULL."));
        }
        return sgnyungType;
    }

    protected void setSgnyungType(String type) {
        sgnyungType = type;
        sgnyung = Optional.fromNullable(toCurrencyType(sgnyungType))
            .transform(bizCurrencyTransformer(getSgnyungValue()))
            .orNull();
    }

    private BizCurrency sipnyung;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSipnyung() {
        return sipnyung;
    }

    public void setSipnyung(BizCurrency pSipnyung) {
        sipnyung = pSipnyung;
        sipnyungValue = null;
        sipnyungType  = null;
    }

    transient private BigDecimal sipnyungValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIPNYUNG, nullable=true)
    protected BigDecimal getSipnyungValue() {
        if (sipnyungValue == null && sipnyung != null) {
            if (sipnyung.isOptional()) return null;
            return sipnyung.absolute();
        }
        return sipnyungValue;
    }

    protected void setSipnyungValue(BigDecimal value) {
        sipnyungValue = value;
        sipnyung = Optional.fromNullable(toCurrencyType(sipnyungType))
            .transform(bizCurrencyTransformer(getSipnyungValue()))
            .orNull();
    }

    transient private String sipnyungType = null;

    @Column(name=SIPNYUNG + "$", nullable=true)
    protected String getSipnyungType() {
        if (sipnyungType == null && sipnyung != null) return sipnyung.getType().toString();
        if (sipnyungType == null && getSipnyungValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sipnyung$' should not be NULL."));
        }
        return sipnyungType;
    }

    protected void setSipnyungType(String type) {
        sipnyungType = type;
        sipnyung = Optional.fromNullable(toCurrencyType(sipnyungType))
            .transform(bizCurrencyTransformer(getSipnyungValue()))
            .orNull();
    }

    private BizCurrency sjnyung;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSjnyung() {
        return sjnyung;
    }

    public void setSjnyung(BizCurrency pSjnyung) {
        sjnyung = pSjnyung;
        sjnyungValue = null;
        sjnyungType  = null;
    }

    transient private BigDecimal sjnyungValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SJNYUNG, nullable=true)
    protected BigDecimal getSjnyungValue() {
        if (sjnyungValue == null && sjnyung != null) {
            if (sjnyung.isOptional()) return null;
            return sjnyung.absolute();
        }
        return sjnyungValue;
    }

    protected void setSjnyungValue(BigDecimal value) {
        sjnyungValue = value;
        sjnyung = Optional.fromNullable(toCurrencyType(sjnyungType))
            .transform(bizCurrencyTransformer(getSjnyungValue()))
            .orNull();
    }

    transient private String sjnyungType = null;

    @Column(name=SJNYUNG + "$", nullable=true)
    protected String getSjnyungType() {
        if (sjnyungType == null && sjnyung != null) return sjnyung.getType().toString();
        if (sjnyungType == null && getSjnyungValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sjnyung$' should not be NULL."));
        }
        return sjnyungType;
    }

    protected void setSjnyungType(String type) {
        sjnyungType = type;
        sjnyung = Optional.fromNullable(toCurrencyType(sjnyungType))
            .transform(bizCurrencyTransformer(getSjnyungValue()))
            .orNull();
    }

    private BizCurrency sonotanyuinng;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotanyuinng() {
        return sonotanyuinng;
    }

    public void setSonotanyuinng(BizCurrency pSonotanyuinng) {
        sonotanyuinng = pSonotanyuinng;
        sonotanyuinngValue = null;
        sonotanyuinngType  = null;
    }

    transient private BigDecimal sonotanyuinngValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTANYUINNG, nullable=true)
    protected BigDecimal getSonotanyuinngValue() {
        if (sonotanyuinngValue == null && sonotanyuinng != null) {
            if (sonotanyuinng.isOptional()) return null;
            return sonotanyuinng.absolute();
        }
        return sonotanyuinngValue;
    }

    protected void setSonotanyuinngValue(BigDecimal value) {
        sonotanyuinngValue = value;
        sonotanyuinng = Optional.fromNullable(toCurrencyType(sonotanyuinngType))
            .transform(bizCurrencyTransformer(getSonotanyuinngValue()))
            .orNull();
    }

    transient private String sonotanyuinngType = null;

    @Column(name=SONOTANYUINNG + "$", nullable=true)
    protected String getSonotanyuinngType() {
        if (sonotanyuinngType == null && sonotanyuinng != null) return sonotanyuinng.getType().toString();
        if (sonotanyuinngType == null && getSonotanyuinngValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotanyuinng$' should not be NULL."));
        }
        return sonotanyuinngType;
    }

    protected void setSonotanyuinngType(String type) {
        sonotanyuinngType = type;
        sonotanyuinng = Optional.fromNullable(toCurrencyType(sonotanyuinngType))
            .transform(bizCurrencyTransformer(getSonotanyuinngValue()))
            .orNull();
    }

    private BizCurrency hutuusb;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHutuusb() {
        return hutuusb;
    }

    public void setHutuusb(BizCurrency pHutuusb) {
        hutuusb = pHutuusb;
        hutuusbValue = null;
        hutuusbType  = null;
    }

    transient private BigDecimal hutuusbValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HUTUUSB, nullable=true)
    protected BigDecimal getHutuusbValue() {
        if (hutuusbValue == null && hutuusb != null) {
            if (hutuusb.isOptional()) return null;
            return hutuusb.absolute();
        }
        return hutuusbValue;
    }

    protected void setHutuusbValue(BigDecimal value) {
        hutuusbValue = value;
        hutuusb = Optional.fromNullable(toCurrencyType(hutuusbType))
            .transform(bizCurrencyTransformer(getHutuusbValue()))
            .orNull();
    }

    transient private String hutuusbType = null;

    @Column(name=HUTUUSB + "$", nullable=true)
    protected String getHutuusbType() {
        if (hutuusbType == null && hutuusb != null) return hutuusb.getType().toString();
        if (hutuusbType == null && getHutuusbValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hutuusb$' should not be NULL."));
        }
        return hutuusbType;
    }

    protected void setHutuusbType(String type) {
        hutuusbType = type;
        hutuusb = Optional.fromNullable(toCurrencyType(hutuusbType))
            .transform(bizCurrencyTransformer(getHutuusbValue()))
            .orNull();
    }

    private BizCurrency sgsbksns;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSgsbksns() {
        return sgsbksns;
    }

    public void setSgsbksns(BizCurrency pSgsbksns) {
        sgsbksns = pSgsbksns;
        sgsbksnsValue = null;
        sgsbksnsType  = null;
    }

    transient private BigDecimal sgsbksnsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SGSBKSNS, nullable=true)
    protected BigDecimal getSgsbksnsValue() {
        if (sgsbksnsValue == null && sgsbksns != null) {
            if (sgsbksns.isOptional()) return null;
            return sgsbksns.absolute();
        }
        return sgsbksnsValue;
    }

    protected void setSgsbksnsValue(BigDecimal value) {
        sgsbksnsValue = value;
        sgsbksns = Optional.fromNullable(toCurrencyType(sgsbksnsType))
            .transform(bizCurrencyTransformer(getSgsbksnsValue()))
            .orNull();
    }

    transient private String sgsbksnsType = null;

    @Column(name=SGSBKSNS + "$", nullable=true)
    protected String getSgsbksnsType() {
        if (sgsbksnsType == null && sgsbksns != null) return sgsbksns.getType().toString();
        if (sgsbksnsType == null && getSgsbksnsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sgsbksns$' should not be NULL."));
        }
        return sgsbksnsType;
    }

    protected void setSgsbksnsType(String type) {
        sgsbksnsType = type;
        sgsbksns = Optional.fromNullable(toCurrencyType(sgsbksnsType))
            .transform(bizCurrencyTransformer(getSgsbksnsValue()))
            .orNull();
    }

    private Long kanyuusyano;

    @Column(name=GenHT_SkLincSyoukaikekka.KANYUUSYANO)
    public Long getKanyuusyano() {
        return kanyuusyano;
    }

    public void setKanyuusyano(Long pKanyuusyano) {
        kanyuusyano = pKanyuusyano;
    }

    private String linckykkanrino;

    @Column(name=GenHT_SkLincSyoukaikekka.LINCKYKKANRINO)
    public String getLinckykkanrino() {
        return linckykkanrino;
    }

    public void setLinckykkanrino(String pLinckykkanrino) {
        linckykkanrino = pLinckykkanrino;
    }

    private C_LincSyoukaiSyubetuKbn lincsyoukaisyubetu;

    @Type(type="UserType_C_LincSyoukaiSyubetuKbn")
    @Column(name=GenHT_SkLincSyoukaikekka.LINCSYOUKAISYUBETU)
    public C_LincSyoukaiSyubetuKbn getLincsyoukaisyubetu() {
        return lincsyoukaisyubetu;
    }

    public void setLincsyoukaisyubetu(C_LincSyoukaiSyubetuKbn pLincsyoukaisyubetu) {
        lincsyoukaisyubetu = pLincsyoukaisyubetu;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkLincSyoukaikekka.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkLincSyoukaikekka.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}