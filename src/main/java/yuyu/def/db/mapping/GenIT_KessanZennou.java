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
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.IT_KessanZennou;
import yuyu.def.db.id.PKIT_KessanZennou;
import yuyu.def.db.meta.GenQIT_KessanZennou;
import yuyu.def.db.meta.QIT_KessanZennou;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 決算用前納テーブル テーブルのマッピング情報クラスで、 {@link IT_KessanZennou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KessanZennou}</td><td colspan="3">決算用前納テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KessanZennou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KessanZennou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">{@link PKIT_KessanZennou ○}</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getZennoukbn zennoukbn}</td><td>前納区分</td><td align="center">{@link PKIT_KessanZennou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennoutoukeilistkbn zennoutoukeilistkbn}</td><td>前納統計リスト区分</td><td align="center">{@link PKIT_KessanZennou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennoustartym zennoustartym}</td><td>前納開始年月</td><td align="center">{@link PKIT_KessanZennou ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getZennoukaisiymd zennoukaisiymd}</td><td>前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennoukaisijizndk zennoukaisijizndk}</td><td>前納開始時残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKeiyakuymd keiyakuymd}</td><td>契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennouwrbkrt zennouwrbkrt}</td><td>前納割引率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRthndzndk1 rthndzndk1}</td><td>利率変動時残高１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTkyrt1 tkyrt1}</td><td>適用利率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRthndymd1 rthndymd1}</td><td>利率変動年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRthndzndk2 rthndzndk2}</td><td>利率変動時残高２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTkyrt2 tkyrt2}</td><td>適用利率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRthndymd2 rthndymd2}</td><td>利率変動年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRthndzndk3 rthndzndk3}</td><td>利率変動時残高３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTkyrt3 tkyrt3}</td><td>適用利率３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRthndymd3 rthndymd3}</td><td>利率変動年月日３</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRthndzndk4 rthndzndk4}</td><td>利率変動時残高４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTkyrt4 tkyrt4}</td><td>適用利率４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRthndymd4 rthndymd4}</td><td>利率変動年月日４</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTndmatuzndk tndmatuzndk}</td><td>当年度末残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTndmatutkyrt tndmatutkyrt}</td><td>当年度末適用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZennounyuukinymd zennounyuukinymd}</td><td>前納入金年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTndzndkhikakukbn tndzndkhikakukbn}</td><td>当年度残高比較区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennoukikan zennoukikan}</td><td>前納期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYobi01xv1 yobi01xv1}</td><td>予備０１＿Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuukeitaikbn bosyuukeitaikbn}</td><td>募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYobi02xv11 yobi02xv11}</td><td>予備０２＿Ｖ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KessanZennou
 * @see     PKIT_KessanZennou
 * @see     QIT_KessanZennou
 * @see     GenQIT_KessanZennou
 */
@MappedSuperclass
@Table(name=GenIT_KessanZennou.TABLE_NAME)
@IdClass(value=PKIT_KessanZennou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class)
})
public abstract class GenIT_KessanZennou extends AbstractExDBEntity<IT_KessanZennou, PKIT_KessanZennou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KessanZennou";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String KBNKEIRISEGCD            = "kbnkeirisegcd";
    public static final String ZENNOUKBN                = "zennoukbn";
    public static final String ZENNOUTOUKEILISTKBN      = "zennoutoukeilistkbn";
    public static final String ZENNOUSTARTYM            = "zennoustartym";
    public static final String ZENNOUKAISIYMD           = "zennoukaisiymd";
    public static final String ZENNOUKAISIJIZNDK        = "zennoukaisijizndk";
    public static final String KEIYAKUYMD               = "keiyakuymd";
    public static final String ZENNOUWRBKRT             = "zennouwrbkrt";
    public static final String RTHNDZNDK1               = "rthndzndk1";
    public static final String TKYRT1                   = "tkyrt1";
    public static final String RTHNDYMD1                = "rthndymd1";
    public static final String RTHNDZNDK2               = "rthndzndk2";
    public static final String TKYRT2                   = "tkyrt2";
    public static final String RTHNDYMD2                = "rthndymd2";
    public static final String RTHNDZNDK3               = "rthndzndk3";
    public static final String TKYRT3                   = "tkyrt3";
    public static final String RTHNDYMD3                = "rthndymd3";
    public static final String RTHNDZNDK4               = "rthndzndk4";
    public static final String TKYRT4                   = "tkyrt4";
    public static final String RTHNDYMD4                = "rthndymd4";
    public static final String TNDMATUZNDK              = "tndmatuzndk";
    public static final String TNDMATUTKYRT             = "tndmatutkyrt";
    public static final String ZENNOUNYUUKINYMD         = "zennounyuukinymd";
    public static final String TNDZNDKHIKAKUKBN         = "tndzndkhikakukbn";
    public static final String ZENNOUKIKAN              = "zennoukikan";
    public static final String YOBI01XV1                = "yobi01xv1";
    public static final String BOSYUUKEITAIKBN          = "bosyuukeitaikbn";
    public static final String YOBI02XV11               = "yobi02xv11";

    private final PKIT_KessanZennou primaryKey;

    public GenIT_KessanZennou() {
        primaryKey = new PKIT_KessanZennou();
    }

    public GenIT_KessanZennou(
        String pKbnkey,
        String pSyono,
        C_Segcd pKbnkeirisegcd,
        String pZennoukbn,
        String pZennoutoukeilistkbn,
        BizDateYM pZennoustartym
    ) {
        primaryKey = new PKIT_KessanZennou(
            pKbnkey,
            pSyono,
            pKbnkeirisegcd,
            pZennoukbn,
            pZennoutoukeilistkbn,
            pZennoustartym
        );
    }

    @Transient
    @Override
    public PKIT_KessanZennou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KessanZennou> getMetaClass() {
        return QIT_KessanZennou.class;
    }

    @Id
    @Column(name=GenIT_KessanZennou.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KessanZennou.SYONO)
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
    @Type(type="UserType_C_Segcd")
    @Column(name=GenIT_KessanZennou.KBNKEIRISEGCD)
    public C_Segcd getKbnkeirisegcd() {
        return getPrimaryKey().getKbnkeirisegcd();
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        getPrimaryKey().setKbnkeirisegcd(pKbnkeirisegcd);
    }

    @Id
    @Column(name=GenIT_KessanZennou.ZENNOUKBN)
    public String getZennoukbn() {
        return getPrimaryKey().getZennoukbn();
    }

    public void setZennoukbn(String pZennoukbn) {
        getPrimaryKey().setZennoukbn(pZennoukbn);
    }

    @Id
    @Column(name=GenIT_KessanZennou.ZENNOUTOUKEILISTKBN)
    public String getZennoutoukeilistkbn() {
        return getPrimaryKey().getZennoutoukeilistkbn();
    }

    public void setZennoutoukeilistkbn(String pZennoutoukeilistkbn) {
        getPrimaryKey().setZennoutoukeilistkbn(pZennoutoukeilistkbn);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenIT_KessanZennou.ZENNOUSTARTYM)
    public BizDateYM getZennoustartym() {
        return getPrimaryKey().getZennoustartym();
    }

    public void setZennoustartym(BizDateYM pZennoustartym) {
        getPrimaryKey().setZennoustartym(pZennoustartym);
    }

    private BizDate zennoukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanZennou.ZENNOUKAISIYMD)
    public BizDate getZennoukaisiymd() {
        return zennoukaisiymd;
    }

    public void setZennoukaisiymd(BizDate pZennoukaisiymd) {
        zennoukaisiymd = pZennoukaisiymd;
    }

    private BizCurrency zennoukaisijizndk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennoukaisijizndk() {
        return zennoukaisijizndk;
    }

    public void setZennoukaisijizndk(BizCurrency pZennoukaisijizndk) {
        zennoukaisijizndk = pZennoukaisijizndk;
        zennoukaisijizndkValue = null;
        zennoukaisijizndkType  = null;
    }

    transient private BigDecimal zennoukaisijizndkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUKAISIJIZNDK, nullable=true)
    protected BigDecimal getZennoukaisijizndkValue() {
        if (zennoukaisijizndkValue == null && zennoukaisijizndk != null) {
            if (zennoukaisijizndk.isOptional()) return null;
            return zennoukaisijizndk.absolute();
        }
        return zennoukaisijizndkValue;
    }

    protected void setZennoukaisijizndkValue(BigDecimal value) {
        zennoukaisijizndkValue = value;
        zennoukaisijizndk = Optional.fromNullable(toCurrencyType(zennoukaisijizndkType))
            .transform(bizCurrencyTransformer(getZennoukaisijizndkValue()))
            .orNull();
    }

    transient private String zennoukaisijizndkType = null;

    @Column(name=ZENNOUKAISIJIZNDK + "$", nullable=true)
    protected String getZennoukaisijizndkType() {
        if (zennoukaisijizndkType == null && zennoukaisijizndk != null) return zennoukaisijizndk.getType().toString();
        if (zennoukaisijizndkType == null && getZennoukaisijizndkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennoukaisijizndk$' should not be NULL."));
        }
        return zennoukaisijizndkType;
    }

    protected void setZennoukaisijizndkType(String type) {
        zennoukaisijizndkType = type;
        zennoukaisijizndk = Optional.fromNullable(toCurrencyType(zennoukaisijizndkType))
            .transform(bizCurrencyTransformer(getZennoukaisijizndkValue()))
            .orNull();
    }

    private BizDate keiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanZennou.KEIYAKUYMD)
    public BizDate getKeiyakuymd() {
        return keiyakuymd;
    }

    public void setKeiyakuymd(BizDate pKeiyakuymd) {
        keiyakuymd = pKeiyakuymd;
    }

    private BizNumber zennouwrbkrt;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KessanZennou.ZENNOUWRBKRT)
    public BizNumber getZennouwrbkrt() {
        return zennouwrbkrt;
    }

    public void setZennouwrbkrt(BizNumber pZennouwrbkrt) {
        zennouwrbkrt = pZennouwrbkrt;
    }

    private BizCurrency rthndzndk1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRthndzndk1() {
        return rthndzndk1;
    }

    public void setRthndzndk1(BizCurrency pRthndzndk1) {
        rthndzndk1 = pRthndzndk1;
        rthndzndk1Value = null;
        rthndzndk1Type  = null;
    }

    transient private BigDecimal rthndzndk1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=RTHNDZNDK1, nullable=true)
    protected BigDecimal getRthndzndk1Value() {
        if (rthndzndk1Value == null && rthndzndk1 != null) {
            if (rthndzndk1.isOptional()) return null;
            return rthndzndk1.absolute();
        }
        return rthndzndk1Value;
    }

    protected void setRthndzndk1Value(BigDecimal value) {
        rthndzndk1Value = value;
        rthndzndk1 = Optional.fromNullable(toCurrencyType(rthndzndk1Type))
            .transform(bizCurrencyTransformer(getRthndzndk1Value()))
            .orNull();
    }

    transient private String rthndzndk1Type = null;

    @Column(name=RTHNDZNDK1 + "$", nullable=true)
    protected String getRthndzndk1Type() {
        if (rthndzndk1Type == null && rthndzndk1 != null) return rthndzndk1.getType().toString();
        if (rthndzndk1Type == null && getRthndzndk1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rthndzndk1$' should not be NULL."));
        }
        return rthndzndk1Type;
    }

    protected void setRthndzndk1Type(String type) {
        rthndzndk1Type = type;
        rthndzndk1 = Optional.fromNullable(toCurrencyType(rthndzndk1Type))
            .transform(bizCurrencyTransformer(getRthndzndk1Value()))
            .orNull();
    }

    private BizNumber tkyrt1;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KessanZennou.TKYRT1)
    public BizNumber getTkyrt1() {
        return tkyrt1;
    }

    public void setTkyrt1(BizNumber pTkyrt1) {
        tkyrt1 = pTkyrt1;
    }

    private BizDate rthndymd1;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanZennou.RTHNDYMD1)
    public BizDate getRthndymd1() {
        return rthndymd1;
    }

    public void setRthndymd1(BizDate pRthndymd1) {
        rthndymd1 = pRthndymd1;
    }

    private BizCurrency rthndzndk2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRthndzndk2() {
        return rthndzndk2;
    }

    public void setRthndzndk2(BizCurrency pRthndzndk2) {
        rthndzndk2 = pRthndzndk2;
        rthndzndk2Value = null;
        rthndzndk2Type  = null;
    }

    transient private BigDecimal rthndzndk2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=RTHNDZNDK2, nullable=true)
    protected BigDecimal getRthndzndk2Value() {
        if (rthndzndk2Value == null && rthndzndk2 != null) {
            if (rthndzndk2.isOptional()) return null;
            return rthndzndk2.absolute();
        }
        return rthndzndk2Value;
    }

    protected void setRthndzndk2Value(BigDecimal value) {
        rthndzndk2Value = value;
        rthndzndk2 = Optional.fromNullable(toCurrencyType(rthndzndk2Type))
            .transform(bizCurrencyTransformer(getRthndzndk2Value()))
            .orNull();
    }

    transient private String rthndzndk2Type = null;

    @Column(name=RTHNDZNDK2 + "$", nullable=true)
    protected String getRthndzndk2Type() {
        if (rthndzndk2Type == null && rthndzndk2 != null) return rthndzndk2.getType().toString();
        if (rthndzndk2Type == null && getRthndzndk2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rthndzndk2$' should not be NULL."));
        }
        return rthndzndk2Type;
    }

    protected void setRthndzndk2Type(String type) {
        rthndzndk2Type = type;
        rthndzndk2 = Optional.fromNullable(toCurrencyType(rthndzndk2Type))
            .transform(bizCurrencyTransformer(getRthndzndk2Value()))
            .orNull();
    }

    private BizNumber tkyrt2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KessanZennou.TKYRT2)
    public BizNumber getTkyrt2() {
        return tkyrt2;
    }

    public void setTkyrt2(BizNumber pTkyrt2) {
        tkyrt2 = pTkyrt2;
    }

    private BizDate rthndymd2;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanZennou.RTHNDYMD2)
    public BizDate getRthndymd2() {
        return rthndymd2;
    }

    public void setRthndymd2(BizDate pRthndymd2) {
        rthndymd2 = pRthndymd2;
    }

    private BizCurrency rthndzndk3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRthndzndk3() {
        return rthndzndk3;
    }

    public void setRthndzndk3(BizCurrency pRthndzndk3) {
        rthndzndk3 = pRthndzndk3;
        rthndzndk3Value = null;
        rthndzndk3Type  = null;
    }

    transient private BigDecimal rthndzndk3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=RTHNDZNDK3, nullable=true)
    protected BigDecimal getRthndzndk3Value() {
        if (rthndzndk3Value == null && rthndzndk3 != null) {
            if (rthndzndk3.isOptional()) return null;
            return rthndzndk3.absolute();
        }
        return rthndzndk3Value;
    }

    protected void setRthndzndk3Value(BigDecimal value) {
        rthndzndk3Value = value;
        rthndzndk3 = Optional.fromNullable(toCurrencyType(rthndzndk3Type))
            .transform(bizCurrencyTransformer(getRthndzndk3Value()))
            .orNull();
    }

    transient private String rthndzndk3Type = null;

    @Column(name=RTHNDZNDK3 + "$", nullable=true)
    protected String getRthndzndk3Type() {
        if (rthndzndk3Type == null && rthndzndk3 != null) return rthndzndk3.getType().toString();
        if (rthndzndk3Type == null && getRthndzndk3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rthndzndk3$' should not be NULL."));
        }
        return rthndzndk3Type;
    }

    protected void setRthndzndk3Type(String type) {
        rthndzndk3Type = type;
        rthndzndk3 = Optional.fromNullable(toCurrencyType(rthndzndk3Type))
            .transform(bizCurrencyTransformer(getRthndzndk3Value()))
            .orNull();
    }

    private BizNumber tkyrt3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KessanZennou.TKYRT3)
    public BizNumber getTkyrt3() {
        return tkyrt3;
    }

    public void setTkyrt3(BizNumber pTkyrt3) {
        tkyrt3 = pTkyrt3;
    }

    private BizDate rthndymd3;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanZennou.RTHNDYMD3)
    public BizDate getRthndymd3() {
        return rthndymd3;
    }

    public void setRthndymd3(BizDate pRthndymd3) {
        rthndymd3 = pRthndymd3;
    }

    private BizCurrency rthndzndk4;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRthndzndk4() {
        return rthndzndk4;
    }

    public void setRthndzndk4(BizCurrency pRthndzndk4) {
        rthndzndk4 = pRthndzndk4;
        rthndzndk4Value = null;
        rthndzndk4Type  = null;
    }

    transient private BigDecimal rthndzndk4Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=RTHNDZNDK4, nullable=true)
    protected BigDecimal getRthndzndk4Value() {
        if (rthndzndk4Value == null && rthndzndk4 != null) {
            if (rthndzndk4.isOptional()) return null;
            return rthndzndk4.absolute();
        }
        return rthndzndk4Value;
    }

    protected void setRthndzndk4Value(BigDecimal value) {
        rthndzndk4Value = value;
        rthndzndk4 = Optional.fromNullable(toCurrencyType(rthndzndk4Type))
            .transform(bizCurrencyTransformer(getRthndzndk4Value()))
            .orNull();
    }

    transient private String rthndzndk4Type = null;

    @Column(name=RTHNDZNDK4 + "$", nullable=true)
    protected String getRthndzndk4Type() {
        if (rthndzndk4Type == null && rthndzndk4 != null) return rthndzndk4.getType().toString();
        if (rthndzndk4Type == null && getRthndzndk4Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rthndzndk4$' should not be NULL."));
        }
        return rthndzndk4Type;
    }

    protected void setRthndzndk4Type(String type) {
        rthndzndk4Type = type;
        rthndzndk4 = Optional.fromNullable(toCurrencyType(rthndzndk4Type))
            .transform(bizCurrencyTransformer(getRthndzndk4Value()))
            .orNull();
    }

    private BizNumber tkyrt4;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KessanZennou.TKYRT4)
    public BizNumber getTkyrt4() {
        return tkyrt4;
    }

    public void setTkyrt4(BizNumber pTkyrt4) {
        tkyrt4 = pTkyrt4;
    }

    private BizDate rthndymd4;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanZennou.RTHNDYMD4)
    public BizDate getRthndymd4() {
        return rthndymd4;
    }

    public void setRthndymd4(BizDate pRthndymd4) {
        rthndymd4 = pRthndymd4;
    }

    private BizCurrency tndmatuzndk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTndmatuzndk() {
        return tndmatuzndk;
    }

    public void setTndmatuzndk(BizCurrency pTndmatuzndk) {
        tndmatuzndk = pTndmatuzndk;
        tndmatuzndkValue = null;
        tndmatuzndkType  = null;
    }

    transient private BigDecimal tndmatuzndkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TNDMATUZNDK, nullable=true)
    protected BigDecimal getTndmatuzndkValue() {
        if (tndmatuzndkValue == null && tndmatuzndk != null) {
            if (tndmatuzndk.isOptional()) return null;
            return tndmatuzndk.absolute();
        }
        return tndmatuzndkValue;
    }

    protected void setTndmatuzndkValue(BigDecimal value) {
        tndmatuzndkValue = value;
        tndmatuzndk = Optional.fromNullable(toCurrencyType(tndmatuzndkType))
            .transform(bizCurrencyTransformer(getTndmatuzndkValue()))
            .orNull();
    }

    transient private String tndmatuzndkType = null;

    @Column(name=TNDMATUZNDK + "$", nullable=true)
    protected String getTndmatuzndkType() {
        if (tndmatuzndkType == null && tndmatuzndk != null) return tndmatuzndk.getType().toString();
        if (tndmatuzndkType == null && getTndmatuzndkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tndmatuzndk$' should not be NULL."));
        }
        return tndmatuzndkType;
    }

    protected void setTndmatuzndkType(String type) {
        tndmatuzndkType = type;
        tndmatuzndk = Optional.fromNullable(toCurrencyType(tndmatuzndkType))
            .transform(bizCurrencyTransformer(getTndmatuzndkValue()))
            .orNull();
    }

    private BizNumber tndmatutkyrt;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KessanZennou.TNDMATUTKYRT)
    public BizNumber getTndmatutkyrt() {
        return tndmatutkyrt;
    }

    public void setTndmatutkyrt(BizNumber pTndmatutkyrt) {
        tndmatutkyrt = pTndmatutkyrt;
    }

    private BizDate zennounyuukinymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KessanZennou.ZENNOUNYUUKINYMD)
    public BizDate getZennounyuukinymd() {
        return zennounyuukinymd;
    }

    public void setZennounyuukinymd(BizDate pZennounyuukinymd) {
        zennounyuukinymd = pZennounyuukinymd;
    }

    private String tndzndkhikakukbn;

    @Column(name=GenIT_KessanZennou.TNDZNDKHIKAKUKBN)
    public String getTndzndkhikakukbn() {
        return tndzndkhikakukbn;
    }

    public void setTndzndkhikakukbn(String pTndzndkhikakukbn) {
        tndzndkhikakukbn = pTndzndkhikakukbn;
    }

    private String zennoukikan;

    @Column(name=GenIT_KessanZennou.ZENNOUKIKAN)
    public String getZennoukikan() {
        return zennoukikan;
    }

    public void setZennoukikan(String pZennoukikan) {
        zennoukikan = pZennoukikan;
    }

    private String yobi01xv1;

    @Column(name=GenIT_KessanZennou.YOBI01XV1)
    public String getYobi01xv1() {
        return yobi01xv1;
    }

    public void setYobi01xv1(String pYobi01xv1) {
        yobi01xv1 = pYobi01xv1;
    }

    private String bosyuukeitaikbn;

    @Column(name=GenIT_KessanZennou.BOSYUUKEITAIKBN)
    public String getBosyuukeitaikbn() {
        return bosyuukeitaikbn;
    }

    public void setBosyuukeitaikbn(String pBosyuukeitaikbn) {
        bosyuukeitaikbn = pBosyuukeitaikbn;
    }

    private String yobi02xv11;

    @Column(name=GenIT_KessanZennou.YOBI02XV11)
    public String getYobi02xv11() {
        return yobi02xv11;
    }

    public void setYobi02xv11(String pYobi02xv11) {
        yobi02xv11 = pYobi02xv11;
    }
}