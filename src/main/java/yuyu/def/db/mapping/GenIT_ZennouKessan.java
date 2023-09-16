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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.IT_ZennouKessan;
import yuyu.def.db.id.PKIT_ZennouKessan;
import yuyu.def.db.meta.GenQIT_ZennouKessan;
import yuyu.def.db.meta.QIT_ZennouKessan;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_ZennouKbn;
import yuyu.def.db.type.UserType_C_ZennouToukeiListKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 前納決算テーブル テーブルのマッピング情報クラスで、 {@link IT_ZennouKessan} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_ZennouKessan}</td><td colspan="3">前納決算テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_ZennouKessan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_ZennouKessan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSakuseiymd sakuseiymd}</td><td>作成年月日</td><td align="center">{@link PKIT_ZennouKessan ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">{@link PKIT_ZennouKessan ○}</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getZennoukbn zennoukbn}</td><td>前納区分</td><td align="center">{@link PKIT_ZennouKessan ○}</td><td align="center">V</td><td>{@link C_ZennouKbn}</td></tr>
 *  <tr><td>{@link #getZennoutoukeilistkbn zennoutoukeilistkbn}</td><td>前納統計リスト区分</td><td align="center">{@link PKIT_ZennouKessan ○}</td><td align="center">V</td><td>{@link C_ZennouToukeiListKbn}</td></tr>
 *  <tr><td>{@link #getZennoustartym zennoustartym}</td><td>前納開始年月</td><td align="center">{@link PKIT_ZennouKessan ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
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
 *  <tr><td>{@link #getGkdtznnhyj gkdtznnhyj}</td><td>外貨建前納表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZnngaikakbn znngaikakbn}</td><td>前納外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYenkanyknhyj yenkanyknhyj}</td><td>円貨入金表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZnnnyknjikawaserate znnnyknjikawaserate}</td><td>前納入金時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZnnnyknjikawaseratetkyuymd znnnyknjikawaseratetkyuymd}</td><td>前納入金時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKsnkisikawaserate ksnkisikawaserate}</td><td>決算期始為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTndmatuzndkksnjkwsrate tndmatuzndkksnjkwsrate}</td><td>当年度末残高計算時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZennounyuukinkgkgaika zennounyuukinkgkgaika}</td><td>前納入金額＿外貨</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennounyuukinkgktkmatu zennounyuukinkgktkmatu}</td><td>前納入金額＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennoukaisijizndktkmatu zennoukaisijizndktkmatu}</td><td>前納開始時残高＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRthndzndk1tkmatu rthndzndk1tkmatu}</td><td>利率変動時残高１＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRthndzndk2tkmatu rthndzndk2tkmatu}</td><td>利率変動時残高２＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRthndzndk3tkmatu rthndzndk3tkmatu}</td><td>利率変動時残高３＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRthndzndk4tkmatu rthndzndk4tkmatu}</td><td>利率変動時残高４＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTndmatuzndktkmatu tndmatuzndktkmatu}</td><td>当年度末残高＿当期末</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_ZennouKessan
 * @see     PKIT_ZennouKessan
 * @see     QIT_ZennouKessan
 * @see     GenQIT_ZennouKessan
 */
@MappedSuperclass
@Table(name=GenIT_ZennouKessan.TABLE_NAME)
@IdClass(value=PKIT_ZennouKessan.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_ZennouKbn", typeClass=UserType_C_ZennouKbn.class),
    @TypeDef(name="UserType_C_ZennouToukeiListKbn", typeClass=UserType_C_ZennouToukeiListKbn.class)
})
public abstract class GenIT_ZennouKessan extends AbstractExDBEntity<IT_ZennouKessan, PKIT_ZennouKessan> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_ZennouKessan";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SAKUSEIYMD               = "sakuseiymd";
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
    public static final String GKDTZNNHYJ               = "gkdtznnhyj";
    public static final String ZNNGAIKAKBN              = "znngaikakbn";
    public static final String YENKANYKNHYJ             = "yenkanyknhyj";
    public static final String ZNNNYKNJIKAWASERATE      = "znnnyknjikawaserate";
    public static final String ZNNNYKNJIKAWASERATETKYUYMD = "znnnyknjikawaseratetkyuymd";
    public static final String KSNKISIKAWASERATE        = "ksnkisikawaserate";
    public static final String TNDMATUZNDKKSNJKWSRATE   = "tndmatuzndkksnjkwsrate";
    public static final String ZENNOUNYUUKINKGKGAIKA    = "zennounyuukinkgkgaika";
    public static final String ZENNOUNYUUKINKGKTKMATU   = "zennounyuukinkgktkmatu";
    public static final String ZENNOUKAISIJIZNDKTKMATU  = "zennoukaisijizndktkmatu";
    public static final String RTHNDZNDK1TKMATU         = "rthndzndk1tkmatu";
    public static final String RTHNDZNDK2TKMATU         = "rthndzndk2tkmatu";
    public static final String RTHNDZNDK3TKMATU         = "rthndzndk3tkmatu";
    public static final String RTHNDZNDK4TKMATU         = "rthndzndk4tkmatu";
    public static final String TNDMATUZNDKTKMATU        = "tndmatuzndktkmatu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_ZennouKessan primaryKey;

    public GenIT_ZennouKessan() {
        primaryKey = new PKIT_ZennouKessan();
    }

    public GenIT_ZennouKessan(
        String pKbnkey,
        String pSyono,
        BizDate pSakuseiymd,
        C_Segcd pKbnkeirisegcd,
        C_ZennouKbn pZennoukbn,
        C_ZennouToukeiListKbn pZennoutoukeilistkbn,
        BizDateYM pZennoustartym
    ) {
        primaryKey = new PKIT_ZennouKessan(
            pKbnkey,
            pSyono,
            pSakuseiymd,
            pKbnkeirisegcd,
            pZennoukbn,
            pZennoutoukeilistkbn,
            pZennoustartym
        );
    }

    @Transient
    @Override
    public PKIT_ZennouKessan getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_ZennouKessan> getMetaClass() {
        return QIT_ZennouKessan.class;
    }

    @Id
    @Column(name=GenIT_ZennouKessan.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_ZennouKessan.SYONO)
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
    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouKessan.SAKUSEIYMD)
    @ValidDate
    public BizDate getSakuseiymd() {
        return getPrimaryKey().getSakuseiymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSakuseiymd(BizDate pSakuseiymd) {
        getPrimaryKey().setSakuseiymd(pSakuseiymd);
    }

    @Id
    @Type(type="UserType_C_Segcd")
    @Column(name=GenIT_ZennouKessan.KBNKEIRISEGCD)
    public C_Segcd getKbnkeirisegcd() {
        return getPrimaryKey().getKbnkeirisegcd();
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        getPrimaryKey().setKbnkeirisegcd(pKbnkeirisegcd);
    }

    @Id
    @Type(type="UserType_C_ZennouKbn")
    @Column(name=GenIT_ZennouKessan.ZENNOUKBN)
    public C_ZennouKbn getZennoukbn() {
        return getPrimaryKey().getZennoukbn();
    }

    public void setZennoukbn(C_ZennouKbn pZennoukbn) {
        getPrimaryKey().setZennoukbn(pZennoukbn);
    }

    @Id
    @Type(type="UserType_C_ZennouToukeiListKbn")
    @Column(name=GenIT_ZennouKessan.ZENNOUTOUKEILISTKBN)
    public C_ZennouToukeiListKbn getZennoutoukeilistkbn() {
        return getPrimaryKey().getZennoutoukeilistkbn();
    }

    public void setZennoutoukeilistkbn(C_ZennouToukeiListKbn pZennoutoukeilistkbn) {
        getPrimaryKey().setZennoutoukeilistkbn(pZennoutoukeilistkbn);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenIT_ZennouKessan.ZENNOUSTARTYM)
    public BizDateYM getZennoustartym() {
        return getPrimaryKey().getZennoustartym();
    }

    public void setZennoustartym(BizDateYM pZennoustartym) {
        getPrimaryKey().setZennoustartym(pZennoustartym);
    }

    private BizDate zennoukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouKessan.ZENNOUKAISIYMD)
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
    @Column(name=GenIT_ZennouKessan.KEIYAKUYMD)
    public BizDate getKeiyakuymd() {
        return keiyakuymd;
    }

    public void setKeiyakuymd(BizDate pKeiyakuymd) {
        keiyakuymd = pKeiyakuymd;
    }

    private BizNumber zennouwrbkrt;

    @Type(type="BizNumberType")
    @Column(name=GenIT_ZennouKessan.ZENNOUWRBKRT)
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
    @Column(name=GenIT_ZennouKessan.TKYRT1)
    public BizNumber getTkyrt1() {
        return tkyrt1;
    }

    public void setTkyrt1(BizNumber pTkyrt1) {
        tkyrt1 = pTkyrt1;
    }

    private BizDate rthndymd1;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouKessan.RTHNDYMD1)
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
    @Column(name=GenIT_ZennouKessan.TKYRT2)
    public BizNumber getTkyrt2() {
        return tkyrt2;
    }

    public void setTkyrt2(BizNumber pTkyrt2) {
        tkyrt2 = pTkyrt2;
    }

    private BizDate rthndymd2;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouKessan.RTHNDYMD2)
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
    @Column(name=GenIT_ZennouKessan.TKYRT3)
    public BizNumber getTkyrt3() {
        return tkyrt3;
    }

    public void setTkyrt3(BizNumber pTkyrt3) {
        tkyrt3 = pTkyrt3;
    }

    private BizDate rthndymd3;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouKessan.RTHNDYMD3)
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
    @Column(name=GenIT_ZennouKessan.TKYRT4)
    public BizNumber getTkyrt4() {
        return tkyrt4;
    }

    public void setTkyrt4(BizNumber pTkyrt4) {
        tkyrt4 = pTkyrt4;
    }

    private BizDate rthndymd4;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouKessan.RTHNDYMD4)
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
    @Column(name=GenIT_ZennouKessan.TNDMATUTKYRT)
    public BizNumber getTndmatutkyrt() {
        return tndmatutkyrt;
    }

    public void setTndmatutkyrt(BizNumber pTndmatutkyrt) {
        tndmatutkyrt = pTndmatutkyrt;
    }

    private BizDate zennounyuukinymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouKessan.ZENNOUNYUUKINYMD)
    public BizDate getZennounyuukinymd() {
        return zennounyuukinymd;
    }

    public void setZennounyuukinymd(BizDate pZennounyuukinymd) {
        zennounyuukinymd = pZennounyuukinymd;
    }

    private String tndzndkhikakukbn;

    @Column(name=GenIT_ZennouKessan.TNDZNDKHIKAKUKBN)
    public String getTndzndkhikakukbn() {
        return tndzndkhikakukbn;
    }

    public void setTndzndkhikakukbn(String pTndzndkhikakukbn) {
        tndzndkhikakukbn = pTndzndkhikakukbn;
    }

    private String zennoukikan;

    @Column(name=GenIT_ZennouKessan.ZENNOUKIKAN)
    public String getZennoukikan() {
        return zennoukikan;
    }

    public void setZennoukikan(String pZennoukikan) {
        zennoukikan = pZennoukikan;
    }

    private String yobi01xv1;

    @Column(name=GenIT_ZennouKessan.YOBI01XV1)
    public String getYobi01xv1() {
        return yobi01xv1;
    }

    public void setYobi01xv1(String pYobi01xv1) {
        yobi01xv1 = pYobi01xv1;
    }

    private String bosyuukeitaikbn;

    @Column(name=GenIT_ZennouKessan.BOSYUUKEITAIKBN)
    public String getBosyuukeitaikbn() {
        return bosyuukeitaikbn;
    }

    public void setBosyuukeitaikbn(String pBosyuukeitaikbn) {
        bosyuukeitaikbn = pBosyuukeitaikbn;
    }

    private String yobi02xv11;

    @Column(name=GenIT_ZennouKessan.YOBI02XV11)
    public String getYobi02xv11() {
        return yobi02xv11;
    }

    public void setYobi02xv11(String pYobi02xv11) {
        yobi02xv11 = pYobi02xv11;
    }

    private String gkdtznnhyj;

    @Column(name=GenIT_ZennouKessan.GKDTZNNHYJ)
    public String getGkdtznnhyj() {
        return gkdtznnhyj;
    }

    public void setGkdtznnhyj(String pGkdtznnhyj) {
        gkdtznnhyj = pGkdtznnhyj;
    }

    private String znngaikakbn;

    @Column(name=GenIT_ZennouKessan.ZNNGAIKAKBN)
    public String getZnngaikakbn() {
        return znngaikakbn;
    }

    public void setZnngaikakbn(String pZnngaikakbn) {
        znngaikakbn = pZnngaikakbn;
    }

    private String yenkanyknhyj;

    @Column(name=GenIT_ZennouKessan.YENKANYKNHYJ)
    public String getYenkanyknhyj() {
        return yenkanyknhyj;
    }

    public void setYenkanyknhyj(String pYenkanyknhyj) {
        yenkanyknhyj = pYenkanyknhyj;
    }

    private BizNumber znnnyknjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_ZennouKessan.ZNNNYKNJIKAWASERATE)
    public BizNumber getZnnnyknjikawaserate() {
        return znnnyknjikawaserate;
    }

    public void setZnnnyknjikawaserate(BizNumber pZnnnyknjikawaserate) {
        znnnyknjikawaserate = pZnnnyknjikawaserate;
    }

    private BizDate znnnyknjikawaseratetkyuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouKessan.ZNNNYKNJIKAWASERATETKYUYMD)
    public BizDate getZnnnyknjikawaseratetkyuymd() {
        return znnnyknjikawaseratetkyuymd;
    }

    public void setZnnnyknjikawaseratetkyuymd(BizDate pZnnnyknjikawaseratetkyuymd) {
        znnnyknjikawaseratetkyuymd = pZnnnyknjikawaseratetkyuymd;
    }

    private BizNumber ksnkisikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_ZennouKessan.KSNKISIKAWASERATE)
    public BizNumber getKsnkisikawaserate() {
        return ksnkisikawaserate;
    }

    public void setKsnkisikawaserate(BizNumber pKsnkisikawaserate) {
        ksnkisikawaserate = pKsnkisikawaserate;
    }

    private BizNumber tndmatuzndkksnjkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_ZennouKessan.TNDMATUZNDKKSNJKWSRATE)
    public BizNumber getTndmatuzndkksnjkwsrate() {
        return tndmatuzndkksnjkwsrate;
    }

    public void setTndmatuzndkksnjkwsrate(BizNumber pTndmatuzndkksnjkwsrate) {
        tndmatuzndkksnjkwsrate = pTndmatuzndkksnjkwsrate;
    }

    private BizCurrency zennounyuukinkgkgaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennounyuukinkgkgaika() {
        return zennounyuukinkgkgaika;
    }

    public void setZennounyuukinkgkgaika(BizCurrency pZennounyuukinkgkgaika) {
        zennounyuukinkgkgaika = pZennounyuukinkgkgaika;
        zennounyuukinkgkgaikaValue = null;
        zennounyuukinkgkgaikaType  = null;
    }

    transient private BigDecimal zennounyuukinkgkgaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUNYUUKINKGKGAIKA, nullable=true)
    protected BigDecimal getZennounyuukinkgkgaikaValue() {
        if (zennounyuukinkgkgaikaValue == null && zennounyuukinkgkgaika != null) {
            if (zennounyuukinkgkgaika.isOptional()) return null;
            return zennounyuukinkgkgaika.absolute();
        }
        return zennounyuukinkgkgaikaValue;
    }

    protected void setZennounyuukinkgkgaikaValue(BigDecimal value) {
        zennounyuukinkgkgaikaValue = value;
        zennounyuukinkgkgaika = Optional.fromNullable(toCurrencyType(zennounyuukinkgkgaikaType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgkgaikaValue()))
            .orNull();
    }

    transient private String zennounyuukinkgkgaikaType = null;

    @Column(name=ZENNOUNYUUKINKGKGAIKA + "$", nullable=true)
    protected String getZennounyuukinkgkgaikaType() {
        if (zennounyuukinkgkgaikaType == null && zennounyuukinkgkgaika != null) return zennounyuukinkgkgaika.getType().toString();
        if (zennounyuukinkgkgaikaType == null && getZennounyuukinkgkgaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennounyuukinkgkgaika$' should not be NULL."));
        }
        return zennounyuukinkgkgaikaType;
    }

    protected void setZennounyuukinkgkgaikaType(String type) {
        zennounyuukinkgkgaikaType = type;
        zennounyuukinkgkgaika = Optional.fromNullable(toCurrencyType(zennounyuukinkgkgaikaType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgkgaikaValue()))
            .orNull();
    }

    private BizCurrency zennounyuukinkgktkmatu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennounyuukinkgktkmatu() {
        return zennounyuukinkgktkmatu;
    }

    public void setZennounyuukinkgktkmatu(BizCurrency pZennounyuukinkgktkmatu) {
        zennounyuukinkgktkmatu = pZennounyuukinkgktkmatu;
        zennounyuukinkgktkmatuValue = null;
        zennounyuukinkgktkmatuType  = null;
    }

    transient private BigDecimal zennounyuukinkgktkmatuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUNYUUKINKGKTKMATU, nullable=true)
    protected BigDecimal getZennounyuukinkgktkmatuValue() {
        if (zennounyuukinkgktkmatuValue == null && zennounyuukinkgktkmatu != null) {
            if (zennounyuukinkgktkmatu.isOptional()) return null;
            return zennounyuukinkgktkmatu.absolute();
        }
        return zennounyuukinkgktkmatuValue;
    }

    protected void setZennounyuukinkgktkmatuValue(BigDecimal value) {
        zennounyuukinkgktkmatuValue = value;
        zennounyuukinkgktkmatu = Optional.fromNullable(toCurrencyType(zennounyuukinkgktkmatuType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgktkmatuValue()))
            .orNull();
    }

    transient private String zennounyuukinkgktkmatuType = null;

    @Column(name=ZENNOUNYUUKINKGKTKMATU + "$", nullable=true)
    protected String getZennounyuukinkgktkmatuType() {
        if (zennounyuukinkgktkmatuType == null && zennounyuukinkgktkmatu != null) return zennounyuukinkgktkmatu.getType().toString();
        if (zennounyuukinkgktkmatuType == null && getZennounyuukinkgktkmatuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennounyuukinkgktkmatu$' should not be NULL."));
        }
        return zennounyuukinkgktkmatuType;
    }

    protected void setZennounyuukinkgktkmatuType(String type) {
        zennounyuukinkgktkmatuType = type;
        zennounyuukinkgktkmatu = Optional.fromNullable(toCurrencyType(zennounyuukinkgktkmatuType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgktkmatuValue()))
            .orNull();
    }

    private BizCurrency zennoukaisijizndktkmatu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennoukaisijizndktkmatu() {
        return zennoukaisijizndktkmatu;
    }

    public void setZennoukaisijizndktkmatu(BizCurrency pZennoukaisijizndktkmatu) {
        zennoukaisijizndktkmatu = pZennoukaisijizndktkmatu;
        zennoukaisijizndktkmatuValue = null;
        zennoukaisijizndktkmatuType  = null;
    }

    transient private BigDecimal zennoukaisijizndktkmatuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUKAISIJIZNDKTKMATU, nullable=true)
    protected BigDecimal getZennoukaisijizndktkmatuValue() {
        if (zennoukaisijizndktkmatuValue == null && zennoukaisijizndktkmatu != null) {
            if (zennoukaisijizndktkmatu.isOptional()) return null;
            return zennoukaisijizndktkmatu.absolute();
        }
        return zennoukaisijizndktkmatuValue;
    }

    protected void setZennoukaisijizndktkmatuValue(BigDecimal value) {
        zennoukaisijizndktkmatuValue = value;
        zennoukaisijizndktkmatu = Optional.fromNullable(toCurrencyType(zennoukaisijizndktkmatuType))
            .transform(bizCurrencyTransformer(getZennoukaisijizndktkmatuValue()))
            .orNull();
    }

    transient private String zennoukaisijizndktkmatuType = null;

    @Column(name=ZENNOUKAISIJIZNDKTKMATU + "$", nullable=true)
    protected String getZennoukaisijizndktkmatuType() {
        if (zennoukaisijizndktkmatuType == null && zennoukaisijizndktkmatu != null) return zennoukaisijizndktkmatu.getType().toString();
        if (zennoukaisijizndktkmatuType == null && getZennoukaisijizndktkmatuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennoukaisijizndktkmatu$' should not be NULL."));
        }
        return zennoukaisijizndktkmatuType;
    }

    protected void setZennoukaisijizndktkmatuType(String type) {
        zennoukaisijizndktkmatuType = type;
        zennoukaisijizndktkmatu = Optional.fromNullable(toCurrencyType(zennoukaisijizndktkmatuType))
            .transform(bizCurrencyTransformer(getZennoukaisijizndktkmatuValue()))
            .orNull();
    }

    private BizCurrency rthndzndk1tkmatu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRthndzndk1tkmatu() {
        return rthndzndk1tkmatu;
    }

    public void setRthndzndk1tkmatu(BizCurrency pRthndzndk1tkmatu) {
        rthndzndk1tkmatu = pRthndzndk1tkmatu;
        rthndzndk1tkmatuValue = null;
        rthndzndk1tkmatuType  = null;
    }

    transient private BigDecimal rthndzndk1tkmatuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RTHNDZNDK1TKMATU, nullable=true)
    protected BigDecimal getRthndzndk1tkmatuValue() {
        if (rthndzndk1tkmatuValue == null && rthndzndk1tkmatu != null) {
            if (rthndzndk1tkmatu.isOptional()) return null;
            return rthndzndk1tkmatu.absolute();
        }
        return rthndzndk1tkmatuValue;
    }

    protected void setRthndzndk1tkmatuValue(BigDecimal value) {
        rthndzndk1tkmatuValue = value;
        rthndzndk1tkmatu = Optional.fromNullable(toCurrencyType(rthndzndk1tkmatuType))
            .transform(bizCurrencyTransformer(getRthndzndk1tkmatuValue()))
            .orNull();
    }

    transient private String rthndzndk1tkmatuType = null;

    @Column(name=RTHNDZNDK1TKMATU + "$", nullable=true)
    protected String getRthndzndk1tkmatuType() {
        if (rthndzndk1tkmatuType == null && rthndzndk1tkmatu != null) return rthndzndk1tkmatu.getType().toString();
        if (rthndzndk1tkmatuType == null && getRthndzndk1tkmatuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rthndzndk1tkmatu$' should not be NULL."));
        }
        return rthndzndk1tkmatuType;
    }

    protected void setRthndzndk1tkmatuType(String type) {
        rthndzndk1tkmatuType = type;
        rthndzndk1tkmatu = Optional.fromNullable(toCurrencyType(rthndzndk1tkmatuType))
            .transform(bizCurrencyTransformer(getRthndzndk1tkmatuValue()))
            .orNull();
    }

    private BizCurrency rthndzndk2tkmatu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRthndzndk2tkmatu() {
        return rthndzndk2tkmatu;
    }

    public void setRthndzndk2tkmatu(BizCurrency pRthndzndk2tkmatu) {
        rthndzndk2tkmatu = pRthndzndk2tkmatu;
        rthndzndk2tkmatuValue = null;
        rthndzndk2tkmatuType  = null;
    }

    transient private BigDecimal rthndzndk2tkmatuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RTHNDZNDK2TKMATU, nullable=true)
    protected BigDecimal getRthndzndk2tkmatuValue() {
        if (rthndzndk2tkmatuValue == null && rthndzndk2tkmatu != null) {
            if (rthndzndk2tkmatu.isOptional()) return null;
            return rthndzndk2tkmatu.absolute();
        }
        return rthndzndk2tkmatuValue;
    }

    protected void setRthndzndk2tkmatuValue(BigDecimal value) {
        rthndzndk2tkmatuValue = value;
        rthndzndk2tkmatu = Optional.fromNullable(toCurrencyType(rthndzndk2tkmatuType))
            .transform(bizCurrencyTransformer(getRthndzndk2tkmatuValue()))
            .orNull();
    }

    transient private String rthndzndk2tkmatuType = null;

    @Column(name=RTHNDZNDK2TKMATU + "$", nullable=true)
    protected String getRthndzndk2tkmatuType() {
        if (rthndzndk2tkmatuType == null && rthndzndk2tkmatu != null) return rthndzndk2tkmatu.getType().toString();
        if (rthndzndk2tkmatuType == null && getRthndzndk2tkmatuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rthndzndk2tkmatu$' should not be NULL."));
        }
        return rthndzndk2tkmatuType;
    }

    protected void setRthndzndk2tkmatuType(String type) {
        rthndzndk2tkmatuType = type;
        rthndzndk2tkmatu = Optional.fromNullable(toCurrencyType(rthndzndk2tkmatuType))
            .transform(bizCurrencyTransformer(getRthndzndk2tkmatuValue()))
            .orNull();
    }

    private BizCurrency rthndzndk3tkmatu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRthndzndk3tkmatu() {
        return rthndzndk3tkmatu;
    }

    public void setRthndzndk3tkmatu(BizCurrency pRthndzndk3tkmatu) {
        rthndzndk3tkmatu = pRthndzndk3tkmatu;
        rthndzndk3tkmatuValue = null;
        rthndzndk3tkmatuType  = null;
    }

    transient private BigDecimal rthndzndk3tkmatuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RTHNDZNDK3TKMATU, nullable=true)
    protected BigDecimal getRthndzndk3tkmatuValue() {
        if (rthndzndk3tkmatuValue == null && rthndzndk3tkmatu != null) {
            if (rthndzndk3tkmatu.isOptional()) return null;
            return rthndzndk3tkmatu.absolute();
        }
        return rthndzndk3tkmatuValue;
    }

    protected void setRthndzndk3tkmatuValue(BigDecimal value) {
        rthndzndk3tkmatuValue = value;
        rthndzndk3tkmatu = Optional.fromNullable(toCurrencyType(rthndzndk3tkmatuType))
            .transform(bizCurrencyTransformer(getRthndzndk3tkmatuValue()))
            .orNull();
    }

    transient private String rthndzndk3tkmatuType = null;

    @Column(name=RTHNDZNDK3TKMATU + "$", nullable=true)
    protected String getRthndzndk3tkmatuType() {
        if (rthndzndk3tkmatuType == null && rthndzndk3tkmatu != null) return rthndzndk3tkmatu.getType().toString();
        if (rthndzndk3tkmatuType == null && getRthndzndk3tkmatuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rthndzndk3tkmatu$' should not be NULL."));
        }
        return rthndzndk3tkmatuType;
    }

    protected void setRthndzndk3tkmatuType(String type) {
        rthndzndk3tkmatuType = type;
        rthndzndk3tkmatu = Optional.fromNullable(toCurrencyType(rthndzndk3tkmatuType))
            .transform(bizCurrencyTransformer(getRthndzndk3tkmatuValue()))
            .orNull();
    }

    private BizCurrency rthndzndk4tkmatu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRthndzndk4tkmatu() {
        return rthndzndk4tkmatu;
    }

    public void setRthndzndk4tkmatu(BizCurrency pRthndzndk4tkmatu) {
        rthndzndk4tkmatu = pRthndzndk4tkmatu;
        rthndzndk4tkmatuValue = null;
        rthndzndk4tkmatuType  = null;
    }

    transient private BigDecimal rthndzndk4tkmatuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RTHNDZNDK4TKMATU, nullable=true)
    protected BigDecimal getRthndzndk4tkmatuValue() {
        if (rthndzndk4tkmatuValue == null && rthndzndk4tkmatu != null) {
            if (rthndzndk4tkmatu.isOptional()) return null;
            return rthndzndk4tkmatu.absolute();
        }
        return rthndzndk4tkmatuValue;
    }

    protected void setRthndzndk4tkmatuValue(BigDecimal value) {
        rthndzndk4tkmatuValue = value;
        rthndzndk4tkmatu = Optional.fromNullable(toCurrencyType(rthndzndk4tkmatuType))
            .transform(bizCurrencyTransformer(getRthndzndk4tkmatuValue()))
            .orNull();
    }

    transient private String rthndzndk4tkmatuType = null;

    @Column(name=RTHNDZNDK4TKMATU + "$", nullable=true)
    protected String getRthndzndk4tkmatuType() {
        if (rthndzndk4tkmatuType == null && rthndzndk4tkmatu != null) return rthndzndk4tkmatu.getType().toString();
        if (rthndzndk4tkmatuType == null && getRthndzndk4tkmatuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rthndzndk4tkmatu$' should not be NULL."));
        }
        return rthndzndk4tkmatuType;
    }

    protected void setRthndzndk4tkmatuType(String type) {
        rthndzndk4tkmatuType = type;
        rthndzndk4tkmatu = Optional.fromNullable(toCurrencyType(rthndzndk4tkmatuType))
            .transform(bizCurrencyTransformer(getRthndzndk4tkmatuValue()))
            .orNull();
    }

    private BizCurrency tndmatuzndktkmatu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTndmatuzndktkmatu() {
        return tndmatuzndktkmatu;
    }

    public void setTndmatuzndktkmatu(BizCurrency pTndmatuzndktkmatu) {
        tndmatuzndktkmatu = pTndmatuzndktkmatu;
        tndmatuzndktkmatuValue = null;
        tndmatuzndktkmatuType  = null;
    }

    transient private BigDecimal tndmatuzndktkmatuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TNDMATUZNDKTKMATU, nullable=true)
    protected BigDecimal getTndmatuzndktkmatuValue() {
        if (tndmatuzndktkmatuValue == null && tndmatuzndktkmatu != null) {
            if (tndmatuzndktkmatu.isOptional()) return null;
            return tndmatuzndktkmatu.absolute();
        }
        return tndmatuzndktkmatuValue;
    }

    protected void setTndmatuzndktkmatuValue(BigDecimal value) {
        tndmatuzndktkmatuValue = value;
        tndmatuzndktkmatu = Optional.fromNullable(toCurrencyType(tndmatuzndktkmatuType))
            .transform(bizCurrencyTransformer(getTndmatuzndktkmatuValue()))
            .orNull();
    }

    transient private String tndmatuzndktkmatuType = null;

    @Column(name=TNDMATUZNDKTKMATU + "$", nullable=true)
    protected String getTndmatuzndktkmatuType() {
        if (tndmatuzndktkmatuType == null && tndmatuzndktkmatu != null) return tndmatuzndktkmatu.getType().toString();
        if (tndmatuzndktkmatuType == null && getTndmatuzndktkmatuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tndmatuzndktkmatu$' should not be NULL."));
        }
        return tndmatuzndktkmatuType;
    }

    protected void setTndmatuzndktkmatuType(String type) {
        tndmatuzndktkmatuType = type;
        tndmatuzndktkmatu = Optional.fromNullable(toCurrencyType(tndmatuzndktkmatuType))
            .transform(bizCurrencyTransformer(getTndmatuzndktkmatuValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_ZennouKessan.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_ZennouKessan.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_ZennouKessan.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}