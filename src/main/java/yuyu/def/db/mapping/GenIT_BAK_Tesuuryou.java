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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Boskykjyoutai;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_Tesuuryou;
import yuyu.def.db.id.PKIT_BAK_Tesuuryou;
import yuyu.def.db.meta.GenQIT_BAK_Tesuuryou;
import yuyu.def.db.meta.QIT_BAK_Tesuuryou;
import yuyu.def.db.type.UserType_C_Boskykjyoutai;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_TsrysyoriKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 手数料情報バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_Tesuuryou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_Tesuuryou}</td><td colspan="3">手数料情報バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_Tesuuryou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_Tesuuryou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_Tesuuryou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsrysyorikbn tsrysyorikbn}</td><td>手数料処理区分</td><td align="center">{@link PKIT_BAK_Tesuuryou ○}</td><td align="center">V</td><td>{@link C_TsrysyoriKbn}</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_BAK_Tesuuryou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiym kouryokuhasseiym}</td><td>効力発生年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getNyknkaisuuy nyknkaisuuy}</td><td>入金回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNyknkaisuum nyknkaisuum}</td><td>入金回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMikeikapariflg mikeikapariflg}</td><td>未経過Ｐ有フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMisyuupariflg misyuupariflg}</td><td>未収Ｐ有フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMikeikap mikeikap}</td><td>未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSeisekiym seisekiym}</td><td>成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getIktp iktp}</td><td>一括払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbckanriid smbckanriid}</td><td>ＳＭＢＣ受付管理ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBoskykjyoutai boskykjyoutai}</td><td>募集契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Boskykjyoutai}</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getNyknymd nyknymd}</td><td>入金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrate yenkansantkykwsrate}</td><td>円換算適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrateymd yenkansantkykwsrateymd}</td><td>円換算適用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_Tesuuryou
 * @see     PKIT_BAK_Tesuuryou
 * @see     QIT_BAK_Tesuuryou
 * @see     GenQIT_BAK_Tesuuryou
 */
@MappedSuperclass
@Table(name=GenIT_BAK_Tesuuryou.TABLE_NAME)
@IdClass(value=PKIT_BAK_Tesuuryou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Boskykjyoutai", typeClass=UserType_C_Boskykjyoutai.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_TsrysyoriKbn", typeClass=UserType_C_TsrysyoriKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_BAK_Tesuuryou extends AbstractExDBEntity<IT_BAK_Tesuuryou, PKIT_BAK_Tesuuryou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_Tesuuryou";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String TSRYSYORIKBN             = "tsrysyorikbn";
    public static final String RENNO                    = "renno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String KOURYOKUHASSEIYM         = "kouryokuhasseiym";
    public static final String NYKNKAISUUY              = "nyknkaisuuy";
    public static final String NYKNKAISUUM              = "nyknkaisuum";
    public static final String MIKEIKAPARIFLG           = "mikeikapariflg";
    public static final String MISYUUPARIFLG            = "misyuupariflg";
    public static final String MIKEIKAP                 = "mikeikap";
    public static final String SEISEKIYM                = "seisekiym";
    public static final String IKTP                     = "iktp";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String HRKP                     = "hrkp";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String HAITOUNENDO              = "haitounendo";
    public static final String CIFCD                    = "cifcd";
    public static final String SMBCKANRIID              = "smbckanriid";
    public static final String BOSKYKJYOUTAI            = "boskykjyoutai";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String NYKNYMD                  = "nyknymd";
    public static final String YENKANSANTKYKWSRATE      = "yenkansantkykwsrate";
    public static final String YENKANSANTKYKWSRATEYMD   = "yenkansantkykwsrateymd";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_Tesuuryou primaryKey;

    public GenIT_BAK_Tesuuryou() {
        primaryKey = new PKIT_BAK_Tesuuryou();
    }

    public GenIT_BAK_Tesuuryou(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        C_TsrysyoriKbn pTsrysyorikbn,
        Integer pRenno
    ) {
        primaryKey = new PKIT_BAK_Tesuuryou(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pTsrysyorikbn,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_Tesuuryou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_Tesuuryou> getMetaClass() {
        return QIT_BAK_Tesuuryou.class;
    }

    @Id
    @Column(name=GenIT_BAK_Tesuuryou.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_Tesuuryou.SYONO)
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
    @Column(name=GenIT_BAK_Tesuuryou.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Type(type="UserType_C_TsrysyoriKbn")
    @Column(name=GenIT_BAK_Tesuuryou.TSRYSYORIKBN)
    public C_TsrysyoriKbn getTsrysyorikbn() {
        return getPrimaryKey().getTsrysyorikbn();
    }

    public void setTsrysyorikbn(C_TsrysyoriKbn pTsrysyorikbn) {
        getPrimaryKey().setTsrysyorikbn(pTsrysyorikbn);
    }

    @Id
    @Column(name=GenIT_BAK_Tesuuryou.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_Tesuuryou.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private BizDateYM kouryokuhasseiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_Tesuuryou.KOURYOKUHASSEIYM)
    public BizDateYM getKouryokuhasseiym() {
        return kouryokuhasseiym;
    }

    public void setKouryokuhasseiym(BizDateYM pKouryokuhasseiym) {
        kouryokuhasseiym = pKouryokuhasseiym;
    }

    private Integer nyknkaisuuy;

    @Column(name=GenIT_BAK_Tesuuryou.NYKNKAISUUY)
    public Integer getNyknkaisuuy() {
        return nyknkaisuuy;
    }

    public void setNyknkaisuuy(Integer pNyknkaisuuy) {
        nyknkaisuuy = pNyknkaisuuy;
    }

    private Integer nyknkaisuum;

    @Column(name=GenIT_BAK_Tesuuryou.NYKNKAISUUM)
    public Integer getNyknkaisuum() {
        return nyknkaisuum;
    }

    public void setNyknkaisuum(Integer pNyknkaisuum) {
        nyknkaisuum = pNyknkaisuum;
    }

    private C_UmuKbn mikeikapariflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_Tesuuryou.MIKEIKAPARIFLG)
    public C_UmuKbn getMikeikapariflg() {
        return mikeikapariflg;
    }

    public void setMikeikapariflg(C_UmuKbn pMikeikapariflg) {
        mikeikapariflg = pMikeikapariflg;
    }

    private C_UmuKbn misyuupariflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_Tesuuryou.MISYUUPARIFLG)
    public C_UmuKbn getMisyuupariflg() {
        return misyuupariflg;
    }

    public void setMisyuupariflg(C_UmuKbn pMisyuupariflg) {
        misyuupariflg = pMisyuupariflg;
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

    private BizDateYM seisekiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_Tesuuryou.SEISEKIYM)
    public BizDateYM getSeisekiym() {
        return seisekiym;
    }

    @Trim("both")
    public void setSeisekiym(BizDateYM pSeisekiym) {
        seisekiym = pSeisekiym;
    }

    private BizCurrency iktp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getIktp() {
        return iktp;
    }

    public void setIktp(BizCurrency pIktp) {
        iktp = pIktp;
        iktpValue = null;
        iktpType  = null;
    }

    transient private BigDecimal iktpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IKTP, nullable=true)
    protected BigDecimal getIktpValue() {
        if (iktpValue == null && iktp != null) {
            if (iktp.isOptional()) return null;
            return iktp.absolute();
        }
        return iktpValue;
    }

    protected void setIktpValue(BigDecimal value) {
        iktpValue = value;
        iktp = Optional.fromNullable(toCurrencyType(iktpType))
            .transform(bizCurrencyTransformer(getIktpValue()))
            .orNull();
    }

    transient private String iktpType = null;

    @Column(name=IKTP + "$", nullable=true)
    protected String getIktpType() {
        if (iktpType == null && iktp != null) return iktp.getType().toString();
        if (iktpType == null && getIktpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'iktp$' should not be NULL."));
        }
        return iktpType;
    }

    protected void setIktpType(String type) {
        iktpType = type;
        iktp = Optional.fromNullable(toCurrencyType(iktpType))
            .transform(bizCurrencyTransformer(getIktpValue()))
            .orNull();
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_BAK_Tesuuryou.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_BAK_Tesuuryou.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
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

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_Tesuuryou.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private BizDateY haitounendo;

    @Type(type="BizDateYType")
    @Column(name=GenIT_BAK_Tesuuryou.HAITOUNENDO)
    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }

    private String cifcd;

    @Column(name=GenIT_BAK_Tesuuryou.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private String smbckanriid;

    @Column(name=GenIT_BAK_Tesuuryou.SMBCKANRIID)
    public String getSmbckanriid() {
        return smbckanriid;
    }

    public void setSmbckanriid(String pSmbckanriid) {
        smbckanriid = pSmbckanriid;
    }

    private C_Boskykjyoutai boskykjyoutai;

    @Type(type="UserType_C_Boskykjyoutai")
    @Column(name=GenIT_BAK_Tesuuryou.BOSKYKJYOUTAI)
    public C_Boskykjyoutai getBoskykjyoutai() {
        return boskykjyoutai;
    }

    public void setBoskykjyoutai(C_Boskykjyoutai pBoskykjyoutai) {
        boskykjyoutai = pBoskykjyoutai;
    }

    private String kyknmkj;

    @Column(name=GenIT_BAK_Tesuuryou.KYKNMKJ)
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

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_Tesuuryou.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private BizDate nyknymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_Tesuuryou.NYKNYMD)
    public BizDate getNyknymd() {
        return nyknymd;
    }

    public void setNyknymd(BizDate pNyknymd) {
        nyknymd = pNyknymd;
    }

    private BizNumber yenkansantkykwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_Tesuuryou.YENKANSANTKYKWSRATE)
    public BizNumber getYenkansantkykwsrate() {
        return yenkansantkykwsrate;
    }

    public void setYenkansantkykwsrate(BizNumber pYenkansantkykwsrate) {
        yenkansantkykwsrate = pYenkansantkykwsrate;
    }

    private BizDate yenkansantkykwsrateymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_Tesuuryou.YENKANSANTKYKWSRATEYMD)
    public BizDate getYenkansantkykwsrateymd() {
        return yenkansantkykwsrateymd;
    }

    public void setYenkansantkykwsrateymd(BizDate pYenkansantkykwsrateymd) {
        yenkansantkykwsrateymd = pYenkansantkykwsrateymd;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_BAK_Tesuuryou.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_Tesuuryou.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_Tesuuryou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_Tesuuryou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}