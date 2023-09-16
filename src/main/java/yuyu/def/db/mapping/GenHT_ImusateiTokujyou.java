package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.db.entity.HT_ImusateiTokujyou;
import yuyu.def.db.id.PKHT_ImusateiTokujyou;
import yuyu.def.db.meta.GenQHT_ImusateiTokujyou;
import yuyu.def.db.meta.QHT_ImusateiTokujyou;
import yuyu.def.db.type.UserType_C_Htnpkkn;
import yuyu.def.db.type.UserType_C_Tkjyhyouten;
import yuyu.def.db.type.UserType_C_Tkjyskgnkkn;
import yuyu.def.db.type.UserType_C_TokkoudosghtnpKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 医務査定特条テーブル テーブルのマッピング情報クラスで、 {@link HT_ImusateiTokujyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_ImusateiTokujyou}</td><td colspan="3">医務査定特条テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_ImusateiTokujyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_ImusateiTokujyou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTkjyhyouten tkjyhyouten}</td><td>特条標点</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkjyhyouten}</td></tr>
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
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_ImusateiTokujyou
 * @see     PKHT_ImusateiTokujyou
 * @see     QHT_ImusateiTokujyou
 * @see     GenQHT_ImusateiTokujyou
 */
@MappedSuperclass
@Table(name=GenHT_ImusateiTokujyou.TABLE_NAME)
@IdClass(value=PKHT_ImusateiTokujyou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Htnpkkn", typeClass=UserType_C_Htnpkkn.class),
    @TypeDef(name="UserType_C_Tkjyhyouten", typeClass=UserType_C_Tkjyhyouten.class),
    @TypeDef(name="UserType_C_Tkjyskgnkkn", typeClass=UserType_C_Tkjyskgnkkn.class),
    @TypeDef(name="UserType_C_TokkoudosghtnpKbn", typeClass=UserType_C_TokkoudosghtnpKbn.class)
})
public abstract class GenHT_ImusateiTokujyou extends AbstractExDBEntity<HT_ImusateiTokujyou, PKHT_ImusateiTokujyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_ImusateiTokujyou";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO                    = "renno";
    public static final String TKJYHYOUTEN              = "tkjyhyouten";
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
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_ImusateiTokujyou primaryKey;

    public GenHT_ImusateiTokujyou() {
        primaryKey = new PKHT_ImusateiTokujyou();
    }

    public GenHT_ImusateiTokujyou(String pMosno, Integer pRenno) {
        primaryKey = new PKHT_ImusateiTokujyou(pMosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_ImusateiTokujyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_ImusateiTokujyou> getMetaClass() {
        return QHT_ImusateiTokujyou.class;
    }

    @Id
    @Column(name=GenHT_ImusateiTokujyou.MOSNO)
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
    @Column(name=GenHT_ImusateiTokujyou.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_Tkjyhyouten tkjyhyouten;

    @Type(type="UserType_C_Tkjyhyouten")
    @Column(name=GenHT_ImusateiTokujyou.TKJYHYOUTEN)
    public C_Tkjyhyouten getTkjyhyouten() {
        return tkjyhyouten;
    }

    public void setTkjyhyouten(C_Tkjyhyouten pTkjyhyouten) {
        tkjyhyouten = pTkjyhyouten;
    }

    private C_Tkjyskgnkkn tkjyskgnkkn;

    @Type(type="UserType_C_Tkjyskgnkkn")
    @Column(name=GenHT_ImusateiTokujyou.TKJYSKGNKKN)
    public C_Tkjyskgnkkn getTkjyskgnkkn() {
        return tkjyskgnkkn;
    }

    public void setTkjyskgnkkn(C_Tkjyskgnkkn pTkjyskgnkkn) {
        tkjyskgnkkn = pTkjyskgnkkn;
    }

    private String htnpbuicd1;

    @Column(name=GenHT_ImusateiTokujyou.HTNPBUICD1)
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
    @Column(name=GenHT_ImusateiTokujyou.HTNPKKN1)
    public C_Htnpkkn getHtnpkkn1() {
        return htnpkkn1;
    }

    public void setHtnpkkn1(C_Htnpkkn pHtnpkkn1) {
        htnpkkn1 = pHtnpkkn1;
    }

    private String htnpbuicd2;

    @Column(name=GenHT_ImusateiTokujyou.HTNPBUICD2)
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
    @Column(name=GenHT_ImusateiTokujyou.HTNPKKN2)
    public C_Htnpkkn getHtnpkkn2() {
        return htnpkkn2;
    }

    public void setHtnpkkn2(C_Htnpkkn pHtnpkkn2) {
        htnpkkn2 = pHtnpkkn2;
    }

    private String htnpbuicd3;

    @Column(name=GenHT_ImusateiTokujyou.HTNPBUICD3)
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
    @Column(name=GenHT_ImusateiTokujyou.HTNPKKN3)
    public C_Htnpkkn getHtnpkkn3() {
        return htnpkkn3;
    }

    public void setHtnpkkn3(C_Htnpkkn pHtnpkkn3) {
        htnpkkn3 = pHtnpkkn3;
    }

    private String htnpbuicd4;

    @Column(name=GenHT_ImusateiTokujyou.HTNPBUICD4)
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
    @Column(name=GenHT_ImusateiTokujyou.HTNPKKN4)
    public C_Htnpkkn getHtnpkkn4() {
        return htnpkkn4;
    }

    public void setHtnpkkn4(C_Htnpkkn pHtnpkkn4) {
        htnpkkn4 = pHtnpkkn4;
    }

    private C_TokkoudosghtnpKbn tokkoudosghtnpkbn;

    @Type(type="UserType_C_TokkoudosghtnpKbn")
    @Column(name=GenHT_ImusateiTokujyou.TOKKOUDOSGHTNPKBN)
    public C_TokkoudosghtnpKbn getTokkoudosghtnpkbn() {
        return tokkoudosghtnpkbn;
    }

    public void setTokkoudosghtnpkbn(C_TokkoudosghtnpKbn pTokkoudosghtnpkbn) {
        tokkoudosghtnpkbn = pTokkoudosghtnpkbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_ImusateiTokujyou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_ImusateiTokujyou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}