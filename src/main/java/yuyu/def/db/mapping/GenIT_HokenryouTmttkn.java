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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.id.PKIT_HokenryouTmttkn;
import yuyu.def.db.meta.GenQIT_HokenryouTmttkn;
import yuyu.def.db.meta.QIT_HokenryouTmttkn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険料積立金テーブル テーブルのマッピング情報クラスで、 {@link IT_HokenryouTmttkn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HokenryouTmttkn}</td><td colspan="3">保険料積立金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_HokenryouTmttkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_HokenryouTmttkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTmttkntaisyouym tmttkntaisyouym}</td><td>積立金対象年月</td><td align="center">{@link PKIT_HokenryouTmttkn ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_HokenryouTmttkn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPtmttkngk ptmttkngk}</td><td>保険料積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihrkmpstgk kihrkmpstgk}</td><td>既払込保険料相当額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTyouseimaeptmttkngk tyouseimaeptmttkngk}</td><td>調整前保険料積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HokenryouTmttkn
 * @see     PKIT_HokenryouTmttkn
 * @see     QIT_HokenryouTmttkn
 * @see     GenQIT_HokenryouTmttkn
 */
@MappedSuperclass
@Table(name=GenIT_HokenryouTmttkn.TABLE_NAME)
@IdClass(value=PKIT_HokenryouTmttkn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class)
})
public abstract class GenIT_HokenryouTmttkn extends AbstractExDBEntity<IT_HokenryouTmttkn, PKIT_HokenryouTmttkn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_HokenryouTmttkn";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TMTTKNTAISYOUYM          = "tmttkntaisyouym";
    public static final String RENNO                    = "renno";
    public static final String PTMTTKNGK                = "ptmttkngk";
    public static final String KIHRKMPSTGK              = "kihrkmpstgk";
    public static final String TYOUSEIMAEPTMTTKNGK      = "tyouseimaeptmttkngk";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_HokenryouTmttkn primaryKey;

    public GenIT_HokenryouTmttkn() {
        primaryKey = new PKIT_HokenryouTmttkn();
    }

    public GenIT_HokenryouTmttkn(
        String pKbnkey,
        String pSyono,
        BizDateYM pTmttkntaisyouym,
        Integer pRenno
    ) {
        primaryKey = new PKIT_HokenryouTmttkn(
            pKbnkey,
            pSyono,
            pTmttkntaisyouym,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_HokenryouTmttkn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_HokenryouTmttkn> getMetaClass() {
        return QIT_HokenryouTmttkn.class;
    }

    @Id
    @Column(name=GenIT_HokenryouTmttkn.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_HokenryouTmttkn.SYONO)
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
    @Type(type="BizDateYMType")
    @Column(name=GenIT_HokenryouTmttkn.TMTTKNTAISYOUYM)
    public BizDateYM getTmttkntaisyouym() {
        return getPrimaryKey().getTmttkntaisyouym();
    }

    public void setTmttkntaisyouym(BizDateYM pTmttkntaisyouym) {
        getPrimaryKey().setTmttkntaisyouym(pTmttkntaisyouym);
    }

    @Id
    @Column(name=GenIT_HokenryouTmttkn.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizCurrency ptmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getPtmttkngk() {
        return ptmttkngk;
    }

    public void setPtmttkngk(BizCurrency pPtmttkngk) {
        ptmttkngk = pPtmttkngk;
        ptmttkngkValue = null;
        ptmttkngkType  = null;
    }

    transient private BigDecimal ptmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=PTMTTKNGK, nullable=true)
    protected BigDecimal getPtmttkngkValue() {
        if (ptmttkngkValue == null && ptmttkngk != null) {
            if (ptmttkngk.isOptional()) return null;
            return ptmttkngk.absolute();
        }
        return ptmttkngkValue;
    }

    protected void setPtmttkngkValue(BigDecimal value) {
        ptmttkngkValue = value;
        ptmttkngk = Optional.fromNullable(toCurrencyType(ptmttkngkType))
            .transform(bizCurrencyTransformer(getPtmttkngkValue()))
            .orNull();
    }

    transient private String ptmttkngkType = null;

    @Column(name=PTMTTKNGK + "$", nullable=true)
    protected String getPtmttkngkType() {
        if (ptmttkngkType == null && ptmttkngk != null) return ptmttkngk.getType().toString();
        if (ptmttkngkType == null && getPtmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'ptmttkngk$' should not be NULL."));
        }
        return ptmttkngkType;
    }

    protected void setPtmttkngkType(String type) {
        ptmttkngkType = type;
        ptmttkngk = Optional.fromNullable(toCurrencyType(ptmttkngkType))
            .transform(bizCurrencyTransformer(getPtmttkngkValue()))
            .orNull();
    }

    private BizCurrency kihrkmpstgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihrkmpstgk() {
        return kihrkmpstgk;
    }

    public void setKihrkmpstgk(BizCurrency pKihrkmpstgk) {
        kihrkmpstgk = pKihrkmpstgk;
        kihrkmpstgkValue = null;
        kihrkmpstgkType  = null;
    }

    transient private BigDecimal kihrkmpstgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHRKMPSTGK, nullable=true)
    protected BigDecimal getKihrkmpstgkValue() {
        if (kihrkmpstgkValue == null && kihrkmpstgk != null) {
            if (kihrkmpstgk.isOptional()) return null;
            return kihrkmpstgk.absolute();
        }
        return kihrkmpstgkValue;
    }

    protected void setKihrkmpstgkValue(BigDecimal value) {
        kihrkmpstgkValue = value;
        kihrkmpstgk = Optional.fromNullable(toCurrencyType(kihrkmpstgkType))
            .transform(bizCurrencyTransformer(getKihrkmpstgkValue()))
            .orNull();
    }

    transient private String kihrkmpstgkType = null;

    @Column(name=KIHRKMPSTGK + "$", nullable=true)
    protected String getKihrkmpstgkType() {
        if (kihrkmpstgkType == null && kihrkmpstgk != null) return kihrkmpstgk.getType().toString();
        if (kihrkmpstgkType == null && getKihrkmpstgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihrkmpstgk$' should not be NULL."));
        }
        return kihrkmpstgkType;
    }

    protected void setKihrkmpstgkType(String type) {
        kihrkmpstgkType = type;
        kihrkmpstgk = Optional.fromNullable(toCurrencyType(kihrkmpstgkType))
            .transform(bizCurrencyTransformer(getKihrkmpstgkValue()))
            .orNull();
    }

    private BizCurrency tyouseimaeptmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTyouseimaeptmttkngk() {
        return tyouseimaeptmttkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouseimaeptmttkngk(BizCurrency pTyouseimaeptmttkngk) {
        tyouseimaeptmttkngk = pTyouseimaeptmttkngk;
        tyouseimaeptmttkngkValue = null;
        tyouseimaeptmttkngkType  = null;
    }

    transient private BigDecimal tyouseimaeptmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TYOUSEIMAEPTMTTKNGK, nullable=true)
    protected BigDecimal getTyouseimaeptmttkngkValue() {
        if (tyouseimaeptmttkngkValue == null && tyouseimaeptmttkngk != null) {
            if (tyouseimaeptmttkngk.isOptional()) return null;
            return tyouseimaeptmttkngk.absolute();
        }
        return tyouseimaeptmttkngkValue;
    }

    protected void setTyouseimaeptmttkngkValue(BigDecimal value) {
        tyouseimaeptmttkngkValue = value;
        tyouseimaeptmttkngk = Optional.fromNullable(toCurrencyType(tyouseimaeptmttkngkType))
            .transform(bizCurrencyTransformer(getTyouseimaeptmttkngkValue()))
            .orNull();
    }

    transient private String tyouseimaeptmttkngkType = null;

    @Column(name=TYOUSEIMAEPTMTTKNGK + "$", nullable=true)
    protected String getTyouseimaeptmttkngkType() {
        if (tyouseimaeptmttkngkType == null && tyouseimaeptmttkngk != null) return tyouseimaeptmttkngk.getType().toString();
        if (tyouseimaeptmttkngkType == null && getTyouseimaeptmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tyouseimaeptmttkngk$' should not be NULL."));
        }
        return tyouseimaeptmttkngkType;
    }

    protected void setTyouseimaeptmttkngkType(String type) {
        tyouseimaeptmttkngkType = type;
        tyouseimaeptmttkngk = Optional.fromNullable(toCurrencyType(tyouseimaeptmttkngkType))
            .transform(bizCurrencyTransformer(getTyouseimaeptmttkngkValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_HokenryouTmttkn.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_HokenryouTmttkn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_HokenryouTmttkn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}