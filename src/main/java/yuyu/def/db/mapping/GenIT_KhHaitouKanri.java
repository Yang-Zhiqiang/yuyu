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
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.id.PKIT_KhHaitouKanri;
import yuyu.def.db.meta.GenQIT_KhHaitouKanri;
import yuyu.def.db.meta.QIT_KhHaitouKanri;
import yuyu.def.db.type.UserType_C_HaitoukinsksKbn;
import yuyu.def.db.type.UserType_C_HaitoumeisaiKbn;
import yuyu.def.db.type.UserType_C_NaiteiKakuteiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 配当管理テーブル テーブルのマッピング情報クラスで、 {@link IT_KhHaitouKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHaitouKanri}</td><td colspan="3">配当管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhHaitouKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhHaitouKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">{@link PKIT_KhHaitouKanri ○}</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_KhHaitouKanri ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHaitoukinskskbn haitoukinskskbn}</td><td>配当金作成区分</td><td align="center">{@link PKIT_KhHaitouKanri ○}</td><td align="center">V</td><td>{@link C_HaitoukinsksKbn}</td></tr>
 *  <tr><td>{@link #getHaitoumeisaikbn haitoumeisaikbn}</td><td>配当明細区分</td><td align="center">{@link PKIT_KhHaitouKanri ○}</td><td align="center">V</td><td>{@link C_HaitoumeisaiKbn}</td></tr>
 *  <tr><td>{@link #getFstkariwariatednendo fstkariwariatednendo}</td><td>初回仮割当Ｄ年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getTounendod tounendod}</td><td>当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNaiteikakuteikbn naiteikakuteikbn}</td><td>内定確定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>{@link #getKariwariatedshrymd kariwariatedshrymd}</td><td>仮割当Ｄ支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKariwariatedruigk kariwariatedruigk}</td><td>仮割当Ｄ累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedgngkkngk kariwariatedgngkkngk}</td><td>仮割当Ｄ減額金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedshrgk kariwariatedshrgk}</td><td>仮割当Ｄ支払額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHaitouKanri
 * @see     PKIT_KhHaitouKanri
 * @see     QIT_KhHaitouKanri
 * @see     GenQIT_KhHaitouKanri
 */
@MappedSuperclass
@Table(name=GenIT_KhHaitouKanri.TABLE_NAME)
@IdClass(value=PKIT_KhHaitouKanri.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class),
    @TypeDef(name="UserType_C_HaitoukinsksKbn", typeClass=UserType_C_HaitoukinsksKbn.class),
    @TypeDef(name="UserType_C_HaitoumeisaiKbn", typeClass=UserType_C_HaitoumeisaiKbn.class),
    @TypeDef(name="UserType_C_NaiteiKakuteiKbn", typeClass=UserType_C_NaiteiKakuteiKbn.class)
})
public abstract class GenIT_KhHaitouKanri extends AbstractExDBEntity<IT_KhHaitouKanri, PKIT_KhHaitouKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhHaitouKanri";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HAITOUNENDO              = "haitounendo";
    public static final String RENNO                    = "renno";
    public static final String HAITOUKINSKSKBN          = "haitoukinskskbn";
    public static final String HAITOUMEISAIKBN          = "haitoumeisaikbn";
    public static final String FSTKARIWARIATEDNENDO     = "fstkariwariatednendo";
    public static final String TOUNENDOD                = "tounendod";
    public static final String NAITEIKAKUTEIKBN         = "naiteikakuteikbn";
    public static final String KARIWARIATEDSHRYMD       = "kariwariatedshrymd";
    public static final String KARIWARIATEDRUIGK        = "kariwariatedruigk";
    public static final String KARIWARIATEDGNGKKNGK     = "kariwariatedgngkkngk";
    public static final String KARIWARIATEDSHRGK        = "kariwariatedshrgk";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhHaitouKanri primaryKey;

    public GenIT_KhHaitouKanri() {
        primaryKey = new PKIT_KhHaitouKanri();
    }

    public GenIT_KhHaitouKanri(
        String pKbnkey,
        String pSyono,
        BizDateY pHaitounendo,
        Integer pRenno,
        C_HaitoukinsksKbn pHaitoukinskskbn,
        C_HaitoumeisaiKbn pHaitoumeisaikbn
    ) {
        primaryKey = new PKIT_KhHaitouKanri(
            pKbnkey,
            pSyono,
            pHaitounendo,
            pRenno,
            pHaitoukinskskbn,
            pHaitoumeisaikbn
        );
    }

    @Transient
    @Override
    public PKIT_KhHaitouKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhHaitouKanri> getMetaClass() {
        return QIT_KhHaitouKanri.class;
    }

    @Id
    @Column(name=GenIT_KhHaitouKanri.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KhHaitouKanri.SYONO)
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
    @Type(type="BizDateYType")
    @Column(name=GenIT_KhHaitouKanri.HAITOUNENDO)
    public BizDateY getHaitounendo() {
        return getPrimaryKey().getHaitounendo();
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        getPrimaryKey().setHaitounendo(pHaitounendo);
    }

    @Id
    @Column(name=GenIT_KhHaitouKanri.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    @Id
    @Type(type="UserType_C_HaitoukinsksKbn")
    @Column(name=GenIT_KhHaitouKanri.HAITOUKINSKSKBN)
    public C_HaitoukinsksKbn getHaitoukinskskbn() {
        return getPrimaryKey().getHaitoukinskskbn();
    }

    public void setHaitoukinskskbn(C_HaitoukinsksKbn pHaitoukinskskbn) {
        getPrimaryKey().setHaitoukinskskbn(pHaitoukinskskbn);
    }

    @Id
    @Type(type="UserType_C_HaitoumeisaiKbn")
    @Column(name=GenIT_KhHaitouKanri.HAITOUMEISAIKBN)
    public C_HaitoumeisaiKbn getHaitoumeisaikbn() {
        return getPrimaryKey().getHaitoumeisaikbn();
    }

    public void setHaitoumeisaikbn(C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        getPrimaryKey().setHaitoumeisaikbn(pHaitoumeisaikbn);
    }

    private BizDateY fstkariwariatednendo;

    @Type(type="BizDateYType")
    @Column(name=GenIT_KhHaitouKanri.FSTKARIWARIATEDNENDO)
    public BizDateY getFstkariwariatednendo() {
        return fstkariwariatednendo;
    }

    public void setFstkariwariatednendo(BizDateY pFstkariwariatednendo) {
        fstkariwariatednendo = pFstkariwariatednendo;
    }

    private BizCurrency tounendod;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTounendod() {
        return tounendod;
    }

    public void setTounendod(BizCurrency pTounendod) {
        tounendod = pTounendod;
        tounendodValue = null;
        tounendodType  = null;
    }

    transient private BigDecimal tounendodValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUNENDOD, nullable=true)
    protected BigDecimal getTounendodValue() {
        if (tounendodValue == null && tounendod != null) {
            if (tounendod.isOptional()) return null;
            return tounendod.absolute();
        }
        return tounendodValue;
    }

    protected void setTounendodValue(BigDecimal value) {
        tounendodValue = value;
        tounendod = Optional.fromNullable(toCurrencyType(tounendodType))
            .transform(bizCurrencyTransformer(getTounendodValue()))
            .orNull();
    }

    transient private String tounendodType = null;

    @Column(name=TOUNENDOD + "$", nullable=true)
    protected String getTounendodType() {
        if (tounendodType == null && tounendod != null) return tounendod.getType().toString();
        if (tounendodType == null && getTounendodValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tounendod$' should not be NULL."));
        }
        return tounendodType;
    }

    protected void setTounendodType(String type) {
        tounendodType = type;
        tounendod = Optional.fromNullable(toCurrencyType(tounendodType))
            .transform(bizCurrencyTransformer(getTounendodValue()))
            .orNull();
    }

    private C_NaiteiKakuteiKbn naiteikakuteikbn;

    @Type(type="UserType_C_NaiteiKakuteiKbn")
    @Column(name=GenIT_KhHaitouKanri.NAITEIKAKUTEIKBN)
    public C_NaiteiKakuteiKbn getNaiteikakuteikbn() {
        return naiteikakuteikbn;
    }

    public void setNaiteikakuteikbn(C_NaiteiKakuteiKbn pNaiteikakuteikbn) {
        naiteikakuteikbn = pNaiteikakuteikbn;
    }

    private BizDate kariwariatedshrymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHaitouKanri.KARIWARIATEDSHRYMD)
    public BizDate getKariwariatedshrymd() {
        return kariwariatedshrymd;
    }

    public void setKariwariatedshrymd(BizDate pKariwariatedshrymd) {
        kariwariatedshrymd = pKariwariatedshrymd;
    }

    private BizCurrency kariwariatedruigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedruigk() {
        return kariwariatedruigk;
    }

    public void setKariwariatedruigk(BizCurrency pKariwariatedruigk) {
        kariwariatedruigk = pKariwariatedruigk;
        kariwariatedruigkValue = null;
        kariwariatedruigkType  = null;
    }

    transient private BigDecimal kariwariatedruigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDRUIGK, nullable=true)
    protected BigDecimal getKariwariatedruigkValue() {
        if (kariwariatedruigkValue == null && kariwariatedruigk != null) {
            if (kariwariatedruigk.isOptional()) return null;
            return kariwariatedruigk.absolute();
        }
        return kariwariatedruigkValue;
    }

    protected void setKariwariatedruigkValue(BigDecimal value) {
        kariwariatedruigkValue = value;
        kariwariatedruigk = Optional.fromNullable(toCurrencyType(kariwariatedruigkType))
            .transform(bizCurrencyTransformer(getKariwariatedruigkValue()))
            .orNull();
    }

    transient private String kariwariatedruigkType = null;

    @Column(name=KARIWARIATEDRUIGK + "$", nullable=true)
    protected String getKariwariatedruigkType() {
        if (kariwariatedruigkType == null && kariwariatedruigk != null) return kariwariatedruigk.getType().toString();
        if (kariwariatedruigkType == null && getKariwariatedruigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedruigk$' should not be NULL."));
        }
        return kariwariatedruigkType;
    }

    protected void setKariwariatedruigkType(String type) {
        kariwariatedruigkType = type;
        kariwariatedruigk = Optional.fromNullable(toCurrencyType(kariwariatedruigkType))
            .transform(bizCurrencyTransformer(getKariwariatedruigkValue()))
            .orNull();
    }

    private BizCurrency kariwariatedgngkkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedgngkkngk() {
        return kariwariatedgngkkngk;
    }

    public void setKariwariatedgngkkngk(BizCurrency pKariwariatedgngkkngk) {
        kariwariatedgngkkngk = pKariwariatedgngkkngk;
        kariwariatedgngkkngkValue = null;
        kariwariatedgngkkngkType  = null;
    }

    transient private BigDecimal kariwariatedgngkkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDGNGKKNGK, nullable=true)
    protected BigDecimal getKariwariatedgngkkngkValue() {
        if (kariwariatedgngkkngkValue == null && kariwariatedgngkkngk != null) {
            if (kariwariatedgngkkngk.isOptional()) return null;
            return kariwariatedgngkkngk.absolute();
        }
        return kariwariatedgngkkngkValue;
    }

    protected void setKariwariatedgngkkngkValue(BigDecimal value) {
        kariwariatedgngkkngkValue = value;
        kariwariatedgngkkngk = Optional.fromNullable(toCurrencyType(kariwariatedgngkkngkType))
            .transform(bizCurrencyTransformer(getKariwariatedgngkkngkValue()))
            .orNull();
    }

    transient private String kariwariatedgngkkngkType = null;

    @Column(name=KARIWARIATEDGNGKKNGK + "$", nullable=true)
    protected String getKariwariatedgngkkngkType() {
        if (kariwariatedgngkkngkType == null && kariwariatedgngkkngk != null) return kariwariatedgngkkngk.getType().toString();
        if (kariwariatedgngkkngkType == null && getKariwariatedgngkkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedgngkkngk$' should not be NULL."));
        }
        return kariwariatedgngkkngkType;
    }

    protected void setKariwariatedgngkkngkType(String type) {
        kariwariatedgngkkngkType = type;
        kariwariatedgngkkngk = Optional.fromNullable(toCurrencyType(kariwariatedgngkkngkType))
            .transform(bizCurrencyTransformer(getKariwariatedgngkkngkValue()))
            .orNull();
    }

    private BizCurrency kariwariatedshrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedshrgk() {
        return kariwariatedshrgk;
    }

    public void setKariwariatedshrgk(BizCurrency pKariwariatedshrgk) {
        kariwariatedshrgk = pKariwariatedshrgk;
        kariwariatedshrgkValue = null;
        kariwariatedshrgkType  = null;
    }

    transient private BigDecimal kariwariatedshrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDSHRGK, nullable=true)
    protected BigDecimal getKariwariatedshrgkValue() {
        if (kariwariatedshrgkValue == null && kariwariatedshrgk != null) {
            if (kariwariatedshrgk.isOptional()) return null;
            return kariwariatedshrgk.absolute();
        }
        return kariwariatedshrgkValue;
    }

    protected void setKariwariatedshrgkValue(BigDecimal value) {
        kariwariatedshrgkValue = value;
        kariwariatedshrgk = Optional.fromNullable(toCurrencyType(kariwariatedshrgkType))
            .transform(bizCurrencyTransformer(getKariwariatedshrgkValue()))
            .orNull();
    }

    transient private String kariwariatedshrgkType = null;

    @Column(name=KARIWARIATEDSHRGK + "$", nullable=true)
    protected String getKariwariatedshrgkType() {
        if (kariwariatedshrgkType == null && kariwariatedshrgk != null) return kariwariatedshrgk.getType().toString();
        if (kariwariatedshrgkType == null && getKariwariatedshrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedshrgk$' should not be NULL."));
        }
        return kariwariatedshrgkType;
    }

    protected void setKariwariatedshrgkType(String type) {
        kariwariatedshrgkType = type;
        kariwariatedshrgk = Optional.fromNullable(toCurrencyType(kariwariatedshrgkType))
            .transform(bizCurrencyTransformer(getKariwariatedshrgkValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhHaitouKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhHaitouKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhHaitouKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}