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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.id.PKIT_SyouhnTokujou;
import yuyu.def.db.meta.GenQIT_SyouhnTokujou;
import yuyu.def.db.meta.QIT_SyouhnTokujou;
import yuyu.def.db.type.UserType_C_Htnpkkn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tkjyhyouten;
import yuyu.def.db.type.UserType_C_Tkjyskgnkkn;
import yuyu.def.db.type.UserType_C_TokkoudosghtnpKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 商品特条テーブル テーブルのマッピング情報クラスで、 {@link IT_SyouhnTokujou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SyouhnTokujou}</td><td colspan="3">商品特条テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_SyouhnTokujou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_SyouhnTokujou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">{@link PKIT_SyouhnTokujou ○}</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKIT_SyouhnTokujou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKIT_SyouhnTokujou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">{@link PKIT_SyouhnTokujou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTkjyhyouten tkjyhyouten}</td><td>特条標点</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkjyhyouten}</td></tr>
 *  <tr><td>{@link #getTkjyp tkjyp}</td><td>特条保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTkjyskgnkkn tkjyskgnkkn}</td><td>特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkjyskgnkkn}</td></tr>
 *  <tr><td>{@link #getHtnpbuicd1 htnpbuicd1}</td><td>不担保部位コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn1 htnpkkn1}</td><td>不担保期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getHtnpbuicd2 htnpbuicd2}</td><td>不担保部位コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn2 htnpkkn2}</td><td>不担保期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getHtnpbuicd3 htnpbuicd3}</td><td>不担保部位コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn3 htnpkkn3}</td><td>不担保期間３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getHtnpbuicd4 htnpbuicd4}</td><td>不担保部位コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn4 htnpkkn4}</td><td>不担保期間４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getTokkoudosghtnpkbn tokkoudosghtnpkbn}</td><td>特定高度障害不担保区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokkoudosghtnpKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SyouhnTokujou
 * @see     PKIT_SyouhnTokujou
 * @see     QIT_SyouhnTokujou
 * @see     GenQIT_SyouhnTokujou
 */
@MappedSuperclass
@Table(name=GenIT_SyouhnTokujou.TABLE_NAME)
@IdClass(value=PKIT_SyouhnTokujou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="UserType_C_Htnpkkn", typeClass=UserType_C_Htnpkkn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_Tkjyhyouten", typeClass=UserType_C_Tkjyhyouten.class),
    @TypeDef(name="UserType_C_Tkjyskgnkkn", typeClass=UserType_C_Tkjyskgnkkn.class),
    @TypeDef(name="UserType_C_TokkoudosghtnpKbn", typeClass=UserType_C_TokkoudosghtnpKbn.class)
})
public abstract class GenIT_SyouhnTokujou extends AbstractExDBEntity<IT_SyouhnTokujou, PKIT_SyouhnTokujou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_SyouhnTokujou";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKSYOUHNRENNO           = "kyksyouhnrenno";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String TKJYHYOUTEN              = "tkjyhyouten";
    public static final String TKJYP                    = "tkjyp";
    public static final String TKJYSKGNKKN              = "tkjyskgnkkn";
    public static final String HTNPBUICD1               = "htnpbuicd1";
    public static final String HTNPKKN1                 = "htnpkkn1";
    public static final String HTNPBUICD2               = "htnpbuicd2";
    public static final String HTNPKKN2                 = "htnpkkn2";
    public static final String HTNPBUICD3               = "htnpbuicd3";
    public static final String HTNPKKN3                 = "htnpkkn3";
    public static final String HTNPBUICD4               = "htnpbuicd4";
    public static final String HTNPKKN4                 = "htnpkkn4";
    public static final String TOKKOUDOSGHTNPKBN        = "tokkoudosghtnpkbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_SyouhnTokujou primaryKey;

    public GenIT_SyouhnTokujou() {
        primaryKey = new PKIT_SyouhnTokujou();
    }

    public GenIT_SyouhnTokujou(
        String pKbnkey,
        String pSyono,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno
    ) {
        primaryKey = new PKIT_SyouhnTokujou(
            pKbnkey,
            pSyono,
            pSyutkkbn,
            pSyouhncd,
            pSyouhnsdno,
            pKyksyouhnrenno
        );
    }

    @Transient
    @Override
    public PKIT_SyouhnTokujou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_SyouhnTokujou> getMetaClass() {
        return QIT_SyouhnTokujou.class;
    }

    @Id
    @Column(name=GenIT_SyouhnTokujou.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_SyouhnTokujou.SYONO)
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
    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SyouhnTokujou.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return getPrimaryKey().getSyutkkbn();
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        getPrimaryKey().setSyutkkbn(pSyutkkbn);
    }

    @Id
    @Column(name=GenIT_SyouhnTokujou.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenIT_SyouhnTokujou.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenIT_SyouhnTokujou.KYKSYOUHNRENNO)
    public Integer getKyksyouhnrenno() {
        return getPrimaryKey().getKyksyouhnrenno();
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        getPrimaryKey().setKyksyouhnrenno(pKyksyouhnrenno);
    }

    private String henkousikibetukey;

    @Column(name=GenIT_SyouhnTokujou.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private C_Tkjyhyouten tkjyhyouten;

    @Type(type="UserType_C_Tkjyhyouten")
    @Column(name=GenIT_SyouhnTokujou.TKJYHYOUTEN)
    public C_Tkjyhyouten getTkjyhyouten() {
        return tkjyhyouten;
    }

    public void setTkjyhyouten(C_Tkjyhyouten pTkjyhyouten) {
        tkjyhyouten = pTkjyhyouten;
    }

    private BizCurrency tkjyp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTkjyp() {
        return tkjyp;
    }

    public void setTkjyp(BizCurrency pTkjyp) {
        tkjyp = pTkjyp;
        tkjypValue = null;
        tkjypType  = null;
    }

    transient private BigDecimal tkjypValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TKJYP, nullable=true)
    protected BigDecimal getTkjypValue() {
        if (tkjypValue == null && tkjyp != null) {
            if (tkjyp.isOptional()) return null;
            return tkjyp.absolute();
        }
        return tkjypValue;
    }

    protected void setTkjypValue(BigDecimal value) {
        tkjypValue = value;
        tkjyp = Optional.fromNullable(toCurrencyType(tkjypType))
            .transform(bizCurrencyTransformer(getTkjypValue()))
            .orNull();
    }

    transient private String tkjypType = null;

    @Column(name=TKJYP + "$", nullable=true)
    protected String getTkjypType() {
        if (tkjypType == null && tkjyp != null) return tkjyp.getType().toString();
        if (tkjypType == null && getTkjypValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tkjyp$' should not be NULL."));
        }
        return tkjypType;
    }

    protected void setTkjypType(String type) {
        tkjypType = type;
        tkjyp = Optional.fromNullable(toCurrencyType(tkjypType))
            .transform(bizCurrencyTransformer(getTkjypValue()))
            .orNull();
    }

    private C_Tkjyskgnkkn tkjyskgnkkn;

    @Type(type="UserType_C_Tkjyskgnkkn")
    @Column(name=GenIT_SyouhnTokujou.TKJYSKGNKKN)
    public C_Tkjyskgnkkn getTkjyskgnkkn() {
        return tkjyskgnkkn;
    }

    public void setTkjyskgnkkn(C_Tkjyskgnkkn pTkjyskgnkkn) {
        tkjyskgnkkn = pTkjyskgnkkn;
    }

    private String htnpbuicd1;

    @Column(name=GenIT_SyouhnTokujou.HTNPBUICD1)
    @MaxLength(max=3)
    @AlphaDigit
    public String getHtnpbuicd1() {
        return htnpbuicd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtnpbuicd1(String pHtnpbuicd1) {
        htnpbuicd1 = pHtnpbuicd1;
    }

    private C_Htnpkkn htnpkkn1;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_SyouhnTokujou.HTNPKKN1)
    public C_Htnpkkn getHtnpkkn1() {
        return htnpkkn1;
    }

    public void setHtnpkkn1(C_Htnpkkn pHtnpkkn1) {
        htnpkkn1 = pHtnpkkn1;
    }

    private String htnpbuicd2;

    @Column(name=GenIT_SyouhnTokujou.HTNPBUICD2)
    @MaxLength(max=3)
    @AlphaDigit
    public String getHtnpbuicd2() {
        return htnpbuicd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtnpbuicd2(String pHtnpbuicd2) {
        htnpbuicd2 = pHtnpbuicd2;
    }

    private C_Htnpkkn htnpkkn2;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_SyouhnTokujou.HTNPKKN2)
    public C_Htnpkkn getHtnpkkn2() {
        return htnpkkn2;
    }

    public void setHtnpkkn2(C_Htnpkkn pHtnpkkn2) {
        htnpkkn2 = pHtnpkkn2;
    }

    private String htnpbuicd3;

    @Column(name=GenIT_SyouhnTokujou.HTNPBUICD3)
    @MaxLength(max=3)
    @AlphaDigit
    public String getHtnpbuicd3() {
        return htnpbuicd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtnpbuicd3(String pHtnpbuicd3) {
        htnpbuicd3 = pHtnpbuicd3;
    }

    private C_Htnpkkn htnpkkn3;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_SyouhnTokujou.HTNPKKN3)
    public C_Htnpkkn getHtnpkkn3() {
        return htnpkkn3;
    }

    public void setHtnpkkn3(C_Htnpkkn pHtnpkkn3) {
        htnpkkn3 = pHtnpkkn3;
    }

    private String htnpbuicd4;

    @Column(name=GenIT_SyouhnTokujou.HTNPBUICD4)
    @MaxLength(max=3)
    @AlphaDigit
    public String getHtnpbuicd4() {
        return htnpbuicd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtnpbuicd4(String pHtnpbuicd4) {
        htnpbuicd4 = pHtnpbuicd4;
    }

    private C_Htnpkkn htnpkkn4;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_SyouhnTokujou.HTNPKKN4)
    public C_Htnpkkn getHtnpkkn4() {
        return htnpkkn4;
    }

    public void setHtnpkkn4(C_Htnpkkn pHtnpkkn4) {
        htnpkkn4 = pHtnpkkn4;
    }

    private C_TokkoudosghtnpKbn tokkoudosghtnpkbn;

    @Type(type="UserType_C_TokkoudosghtnpKbn")
    @Column(name=GenIT_SyouhnTokujou.TOKKOUDOSGHTNPKBN)
    public C_TokkoudosghtnpKbn getTokkoudosghtnpkbn() {
        return tokkoudosghtnpkbn;
    }

    public void setTokkoudosghtnpkbn(C_TokkoudosghtnpKbn pTokkoudosghtnpkbn) {
        tokkoudosghtnpkbn = pTokkoudosghtnpkbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_SyouhnTokujou.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_SyouhnTokujou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_SyouhnTokujou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}