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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.id.PKIT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.GenQIT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 指数連動積増型年金積立金テーブル テーブルのマッピング情報クラスで、 {@link IT_KhSisuurendoTmttkn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhSisuurendoTmttkn}</td><td colspan="3">指数連動積増型年金積立金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhSisuurendoTmttkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhSisuurendoTmttkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTmttkntaisyouym tmttkntaisyouym}</td><td>積立金対象年月</td><td align="center">{@link PKIT_KhSisuurendoTmttkn ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_KhSisuurendoTmttkn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTmttknkouryokukaisiymd tmttknkouryokukaisiymd}</td><td>積立金効力開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTeiritutmttkngk teiritutmttkngk}</td><td>定率積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSisuurendoutmttkngk sisuurendoutmttkngk}</td><td>指数連動積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSisuuupritu sisuuupritu}</td><td>指数上昇率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTmttknzoukaritu tmttknzoukaritu}</td><td>積立金増加率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTmttknhaneitmmshanteiymd tmttknhaneitmmshanteiymd}</td><td>積立金反映時積増判定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTmttknhaneisisuu tmttknhaneisisuu}</td><td>積立金反映時指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getItenmaeteiritutmttkngk itenmaeteiritutmttkngk}</td><td>移転前定率積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getItenmaesisuurendoutmttkngk itenmaesisuurendoutmttkngk}</td><td>移転前指数連動積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_KhSisuurendoTmttkn
 * @see     PKIT_KhSisuurendoTmttkn
 * @see     QIT_KhSisuurendoTmttkn
 * @see     GenQIT_KhSisuurendoTmttkn
 */
@MappedSuperclass
@Table(name=GenIT_KhSisuurendoTmttkn.TABLE_NAME)
@IdClass(value=PKIT_KhSisuurendoTmttkn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenIT_KhSisuurendoTmttkn extends AbstractExDBEntity<IT_KhSisuurendoTmttkn, PKIT_KhSisuurendoTmttkn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhSisuurendoTmttkn";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TMTTKNTAISYOUYM          = "tmttkntaisyouym";
    public static final String RENNO                    = "renno";
    public static final String TMTTKNKOURYOKUKAISIYMD   = "tmttknkouryokukaisiymd";
    public static final String TEIRITUTMTTKNGK          = "teiritutmttkngk";
    public static final String SISUURENDOUTMTTKNGK      = "sisuurendoutmttkngk";
    public static final String SISUUUPRITU              = "sisuuupritu";
    public static final String TMTTKNZOUKARITU          = "tmttknzoukaritu";
    public static final String TMTTKNHANEITMMSHANTEIYMD = "tmttknhaneitmmshanteiymd";
    public static final String TMTTKNHANEISISUU         = "tmttknhaneisisuu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String ITENMAETEIRITUTMTTKNGK   = "itenmaeteiritutmttkngk";
    public static final String ITENMAESISUURENDOUTMTTKNGK = "itenmaesisuurendoutmttkngk";

    private final PKIT_KhSisuurendoTmttkn primaryKey;

    public GenIT_KhSisuurendoTmttkn() {
        primaryKey = new PKIT_KhSisuurendoTmttkn();
    }

    public GenIT_KhSisuurendoTmttkn(
        String pKbnkey,
        String pSyono,
        BizDateYM pTmttkntaisyouym,
        Integer pRenno
    ) {
        primaryKey = new PKIT_KhSisuurendoTmttkn(
            pKbnkey,
            pSyono,
            pTmttkntaisyouym,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_KhSisuurendoTmttkn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhSisuurendoTmttkn> getMetaClass() {
        return QIT_KhSisuurendoTmttkn.class;
    }

    @Id
    @Column(name=GenIT_KhSisuurendoTmttkn.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KhSisuurendoTmttkn.SYONO)
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
    @Column(name=GenIT_KhSisuurendoTmttkn.TMTTKNTAISYOUYM)
    public BizDateYM getTmttkntaisyouym() {
        return getPrimaryKey().getTmttkntaisyouym();
    }

    public void setTmttkntaisyouym(BizDateYM pTmttkntaisyouym) {
        getPrimaryKey().setTmttkntaisyouym(pTmttkntaisyouym);
    }

    @Id
    @Column(name=GenIT_KhSisuurendoTmttkn.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate tmttknkouryokukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhSisuurendoTmttkn.TMTTKNKOURYOKUKAISIYMD)
    public BizDate getTmttknkouryokukaisiymd() {
        return tmttknkouryokukaisiymd;
    }

    public void setTmttknkouryokukaisiymd(BizDate pTmttknkouryokukaisiymd) {
        tmttknkouryokukaisiymd = pTmttknkouryokukaisiymd;
    }

    private BizCurrency teiritutmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeiritutmttkngk() {
        return teiritutmttkngk;
    }

    public void setTeiritutmttkngk(BizCurrency pTeiritutmttkngk) {
        teiritutmttkngk = pTeiritutmttkngk;
        teiritutmttkngkValue = null;
        teiritutmttkngkType  = null;
    }

    transient private BigDecimal teiritutmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIRITUTMTTKNGK, nullable=true)
    protected BigDecimal getTeiritutmttkngkValue() {
        if (teiritutmttkngkValue == null && teiritutmttkngk != null) {
            if (teiritutmttkngk.isOptional()) return null;
            return teiritutmttkngk.absolute();
        }
        return teiritutmttkngkValue;
    }

    protected void setTeiritutmttkngkValue(BigDecimal value) {
        teiritutmttkngkValue = value;
        teiritutmttkngk = Optional.fromNullable(toCurrencyType(teiritutmttkngkType))
            .transform(bizCurrencyTransformer(getTeiritutmttkngkValue()))
            .orNull();
    }

    transient private String teiritutmttkngkType = null;

    @Column(name=TEIRITUTMTTKNGK + "$", nullable=true)
    protected String getTeiritutmttkngkType() {
        if (teiritutmttkngkType == null && teiritutmttkngk != null) return teiritutmttkngk.getType().toString();
        if (teiritutmttkngkType == null && getTeiritutmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teiritutmttkngk$' should not be NULL."));
        }
        return teiritutmttkngkType;
    }

    protected void setTeiritutmttkngkType(String type) {
        teiritutmttkngkType = type;
        teiritutmttkngk = Optional.fromNullable(toCurrencyType(teiritutmttkngkType))
            .transform(bizCurrencyTransformer(getTeiritutmttkngkValue()))
            .orNull();
    }

    private BizCurrency sisuurendoutmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSisuurendoutmttkngk() {
        return sisuurendoutmttkngk;
    }

    public void setSisuurendoutmttkngk(BizCurrency pSisuurendoutmttkngk) {
        sisuurendoutmttkngk = pSisuurendoutmttkngk;
        sisuurendoutmttkngkValue = null;
        sisuurendoutmttkngkType  = null;
    }

    transient private BigDecimal sisuurendoutmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SISUURENDOUTMTTKNGK, nullable=true)
    protected BigDecimal getSisuurendoutmttkngkValue() {
        if (sisuurendoutmttkngkValue == null && sisuurendoutmttkngk != null) {
            if (sisuurendoutmttkngk.isOptional()) return null;
            return sisuurendoutmttkngk.absolute();
        }
        return sisuurendoutmttkngkValue;
    }

    protected void setSisuurendoutmttkngkValue(BigDecimal value) {
        sisuurendoutmttkngkValue = value;
        sisuurendoutmttkngk = Optional.fromNullable(toCurrencyType(sisuurendoutmttkngkType))
            .transform(bizCurrencyTransformer(getSisuurendoutmttkngkValue()))
            .orNull();
    }

    transient private String sisuurendoutmttkngkType = null;

    @Column(name=SISUURENDOUTMTTKNGK + "$", nullable=true)
    protected String getSisuurendoutmttkngkType() {
        if (sisuurendoutmttkngkType == null && sisuurendoutmttkngk != null) return sisuurendoutmttkngk.getType().toString();
        if (sisuurendoutmttkngkType == null && getSisuurendoutmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sisuurendoutmttkngk$' should not be NULL."));
        }
        return sisuurendoutmttkngkType;
    }

    protected void setSisuurendoutmttkngkType(String type) {
        sisuurendoutmttkngkType = type;
        sisuurendoutmttkngk = Optional.fromNullable(toCurrencyType(sisuurendoutmttkngkType))
            .transform(bizCurrencyTransformer(getSisuurendoutmttkngkValue()))
            .orNull();
    }

    private BizNumber sisuuupritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KhSisuurendoTmttkn.SISUUUPRITU)
    public BizNumber getSisuuupritu() {
        return sisuuupritu;
    }

    public void setSisuuupritu(BizNumber pSisuuupritu) {
        sisuuupritu = pSisuuupritu;
    }

    private BizNumber tmttknzoukaritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KhSisuurendoTmttkn.TMTTKNZOUKARITU)
    public BizNumber getTmttknzoukaritu() {
        return tmttknzoukaritu;
    }

    public void setTmttknzoukaritu(BizNumber pTmttknzoukaritu) {
        tmttknzoukaritu = pTmttknzoukaritu;
    }

    private BizDate tmttknhaneitmmshanteiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhSisuurendoTmttkn.TMTTKNHANEITMMSHANTEIYMD)
    public BizDate getTmttknhaneitmmshanteiymd() {
        return tmttknhaneitmmshanteiymd;
    }

    public void setTmttknhaneitmmshanteiymd(BizDate pTmttknhaneitmmshanteiymd) {
        tmttknhaneitmmshanteiymd = pTmttknhaneitmmshanteiymd;
    }

    private BizNumber tmttknhaneisisuu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KhSisuurendoTmttkn.TMTTKNHANEISISUU)
    public BizNumber getTmttknhaneisisuu() {
        return tmttknhaneisisuu;
    }

    public void setTmttknhaneisisuu(BizNumber pTmttknhaneisisuu) {
        tmttknhaneisisuu = pTmttknhaneisisuu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhSisuurendoTmttkn.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhSisuurendoTmttkn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhSisuurendoTmttkn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizCurrency itenmaeteiritutmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getItenmaeteiritutmttkngk() {
        return itenmaeteiritutmttkngk;
    }

    public void setItenmaeteiritutmttkngk(BizCurrency pItenmaeteiritutmttkngk) {
        itenmaeteiritutmttkngk = pItenmaeteiritutmttkngk;
        itenmaeteiritutmttkngkValue = null;
        itenmaeteiritutmttkngkType  = null;
    }

    transient private BigDecimal itenmaeteiritutmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ITENMAETEIRITUTMTTKNGK, nullable=true)
    protected BigDecimal getItenmaeteiritutmttkngkValue() {
        if (itenmaeteiritutmttkngkValue == null && itenmaeteiritutmttkngk != null) {
            if (itenmaeteiritutmttkngk.isOptional()) return null;
            return itenmaeteiritutmttkngk.absolute();
        }
        return itenmaeteiritutmttkngkValue;
    }

    protected void setItenmaeteiritutmttkngkValue(BigDecimal value) {
        itenmaeteiritutmttkngkValue = value;
        itenmaeteiritutmttkngk = Optional.fromNullable(toCurrencyType(itenmaeteiritutmttkngkType))
            .transform(bizCurrencyTransformer(getItenmaeteiritutmttkngkValue()))
            .orNull();
    }

    transient private String itenmaeteiritutmttkngkType = null;

    @Column(name=ITENMAETEIRITUTMTTKNGK + "$", nullable=true)
    protected String getItenmaeteiritutmttkngkType() {
        if (itenmaeteiritutmttkngkType == null && itenmaeteiritutmttkngk != null) return itenmaeteiritutmttkngk.getType().toString();
        if (itenmaeteiritutmttkngkType == null && getItenmaeteiritutmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'itenmaeteiritutmttkngk$' should not be NULL."));
        }
        return itenmaeteiritutmttkngkType;
    }

    protected void setItenmaeteiritutmttkngkType(String type) {
        itenmaeteiritutmttkngkType = type;
        itenmaeteiritutmttkngk = Optional.fromNullable(toCurrencyType(itenmaeteiritutmttkngkType))
            .transform(bizCurrencyTransformer(getItenmaeteiritutmttkngkValue()))
            .orNull();
    }

    private BizCurrency itenmaesisuurendoutmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getItenmaesisuurendoutmttkngk() {
        return itenmaesisuurendoutmttkngk;
    }

    public void setItenmaesisuurendoutmttkngk(BizCurrency pItenmaesisuurendoutmttkngk) {
        itenmaesisuurendoutmttkngk = pItenmaesisuurendoutmttkngk;
        itenmaesisuurendoutmttkngkValue = null;
        itenmaesisuurendoutmttkngkType  = null;
    }

    transient private BigDecimal itenmaesisuurendoutmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ITENMAESISUURENDOUTMTTKNGK, nullable=true)
    protected BigDecimal getItenmaesisuurendoutmttkngkValue() {
        if (itenmaesisuurendoutmttkngkValue == null && itenmaesisuurendoutmttkngk != null) {
            if (itenmaesisuurendoutmttkngk.isOptional()) return null;
            return itenmaesisuurendoutmttkngk.absolute();
        }
        return itenmaesisuurendoutmttkngkValue;
    }

    protected void setItenmaesisuurendoutmttkngkValue(BigDecimal value) {
        itenmaesisuurendoutmttkngkValue = value;
        itenmaesisuurendoutmttkngk = Optional.fromNullable(toCurrencyType(itenmaesisuurendoutmttkngkType))
            .transform(bizCurrencyTransformer(getItenmaesisuurendoutmttkngkValue()))
            .orNull();
    }

    transient private String itenmaesisuurendoutmttkngkType = null;

    @Column(name=ITENMAESISUURENDOUTMTTKNGK + "$", nullable=true)
    protected String getItenmaesisuurendoutmttkngkType() {
        if (itenmaesisuurendoutmttkngkType == null && itenmaesisuurendoutmttkngk != null) return itenmaesisuurendoutmttkngk.getType().toString();
        if (itenmaesisuurendoutmttkngkType == null && getItenmaesisuurendoutmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'itenmaesisuurendoutmttkngk$' should not be NULL."));
        }
        return itenmaesisuurendoutmttkngkType;
    }

    protected void setItenmaesisuurendoutmttkngkType(String type) {
        itenmaesisuurendoutmttkngkType = type;
        itenmaesisuurendoutmttkngk = Optional.fromNullable(toCurrencyType(itenmaesisuurendoutmttkngkType))
            .transform(bizCurrencyTransformer(getItenmaesisuurendoutmttkngkValue()))
            .orNull();
    }
}