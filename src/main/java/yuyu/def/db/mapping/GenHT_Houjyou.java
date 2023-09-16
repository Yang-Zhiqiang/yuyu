package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_SinsaKbn;
import yuyu.def.classification.C_SinsabaKbn;
import yuyu.def.classification.C_Sinsatime;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.classification.C_TakuouKbn;
import yuyu.def.db.entity.HT_Houjyou;
import yuyu.def.db.id.PKHT_Houjyou;
import yuyu.def.db.meta.GenQHT_Houjyou;
import yuyu.def.db.meta.QHT_Houjyou;
import yuyu.def.db.type.UserType_C_KituenKbn;
import yuyu.def.db.type.UserType_C_SinsaKbn;
import yuyu.def.db.type.UserType_C_SinsabaKbn;
import yuyu.def.db.type.UserType_C_Sinsatime;
import yuyu.def.db.type.UserType_C_SyosaiKbn;
import yuyu.def.db.type.UserType_C_TakuouKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 報状テーブル テーブルのマッピング情報クラスで、 {@link HT_Houjyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_Houjyou}</td><td colspan="3">報状テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_Houjyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyosaikbn syosaikbn}</td><td>初診再診区分</td><td align="center">{@link PKHT_Houjyou ○}</td><td align="center">V</td><td>{@link C_SyosaiKbn}</td></tr>
 *  <tr><td>{@link #getSinsakbn sinsakbn}</td><td>診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinsaKbn}</td></tr>
 *  <tr><td>{@link #getKktymd kktymd}</td><td>告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSintyou sintyou}</td><td>身長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTaijyuu taijyuu}</td><td>体重</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKituenkbn kituenkbn}</td><td>喫煙区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KituenKbn}</td></tr>
 *  <tr><td>{@link #getKituenhon kituenhon}</td><td>喫煙本数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSinsaicd sinsaicd}</td><td>診査医コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSinsaymd sinsaymd}</td><td>診査日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSinsatime sinsatime}</td><td>診査時刻</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sinsatime}</td></tr>
 *  <tr><td>{@link #getTakuoukbn takuoukbn}</td><td>宅診往診区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TakuouKbn}</td></tr>
 *  <tr><td>{@link #getSinsabakbn sinsabakbn}</td><td>診査場所区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinsabaKbn}</td></tr>
 *  <tr><td>{@link #getHbcmnt hbcmnt}</td><td>不備コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_Houjyou
 * @see     PKHT_Houjyou
 * @see     QHT_Houjyou
 * @see     GenQHT_Houjyou
 */
@MappedSuperclass
@Table(name=GenHT_Houjyou.TABLE_NAME)
@IdClass(value=PKHT_Houjyou.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KituenKbn", typeClass=UserType_C_KituenKbn.class),
    @TypeDef(name="UserType_C_SinsaKbn", typeClass=UserType_C_SinsaKbn.class),
    @TypeDef(name="UserType_C_SinsabaKbn", typeClass=UserType_C_SinsabaKbn.class),
    @TypeDef(name="UserType_C_Sinsatime", typeClass=UserType_C_Sinsatime.class),
    @TypeDef(name="UserType_C_SyosaiKbn", typeClass=UserType_C_SyosaiKbn.class),
    @TypeDef(name="UserType_C_TakuouKbn", typeClass=UserType_C_TakuouKbn.class)
})
public abstract class GenHT_Houjyou extends AbstractExDBEntity<HT_Houjyou, PKHT_Houjyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_Houjyou";
    public static final String MOSNO                    = "mosno";
    public static final String SYOSAIKBN                = "syosaikbn";
    public static final String SINSAKBN                 = "sinsakbn";
    public static final String KKTYMD                   = "kktymd";
    public static final String SINTYOU                  = "sintyou";
    public static final String TAIJYUU                  = "taijyuu";
    public static final String KITUENKBN                = "kituenkbn";
    public static final String KITUENHON                = "kituenhon";
    public static final String SINSAICD                 = "sinsaicd";
    public static final String SINSAYMD                 = "sinsaymd";
    public static final String SINSATIME                = "sinsatime";
    public static final String TAKUOUKBN                = "takuoukbn";
    public static final String SINSABAKBN               = "sinsabakbn";
    public static final String HBCMNT                   = "hbcmnt";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_Houjyou primaryKey;

    public GenHT_Houjyou() {
        primaryKey = new PKHT_Houjyou();
    }

    public GenHT_Houjyou(String pMosno, C_SyosaiKbn pSyosaikbn) {
        primaryKey = new PKHT_Houjyou(pMosno, pSyosaikbn);
    }

    @Transient
    @Override
    public PKHT_Houjyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_Houjyou> getMetaClass() {
        return QHT_Houjyou.class;
    }

    @Id
    @Column(name=GenHT_Houjyou.MOSNO)
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
    @Type(type="UserType_C_SyosaiKbn")
    @Column(name=GenHT_Houjyou.SYOSAIKBN)
    public C_SyosaiKbn getSyosaikbn() {
        return getPrimaryKey().getSyosaikbn();
    }

    public void setSyosaikbn(C_SyosaiKbn pSyosaikbn) {
        getPrimaryKey().setSyosaikbn(pSyosaikbn);
    }

    private C_SinsaKbn sinsakbn;

    @Type(type="UserType_C_SinsaKbn")
    @Column(name=GenHT_Houjyou.SINSAKBN)
    public C_SinsaKbn getSinsakbn() {
        return sinsakbn;
    }

    public void setSinsakbn(C_SinsaKbn pSinsakbn) {
        sinsakbn = pSinsakbn;
    }

    private BizDate kktymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_Houjyou.KKTYMD)
    @ValidDate
    public BizDate getKktymd() {
        return kktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktymd(BizDate pKktymd) {
        kktymd = pKktymd;
    }

    private Integer sintyou;

    @Column(name=GenHT_Houjyou.SINTYOU)
    @Range(min="0", max="999")
    public Integer getSintyou() {
        return sintyou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSintyou(Integer pSintyou) {
        sintyou = pSintyou;
    }

    private Integer taijyuu;

    @Column(name=GenHT_Houjyou.TAIJYUU)
    @Range(min="0", max="999")
    public Integer getTaijyuu() {
        return taijyuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTaijyuu(Integer pTaijyuu) {
        taijyuu = pTaijyuu;
    }

    private C_KituenKbn kituenkbn;

    @Type(type="UserType_C_KituenKbn")
    @Column(name=GenHT_Houjyou.KITUENKBN)
    public C_KituenKbn getKituenkbn() {
        return kituenkbn;
    }

    public void setKituenkbn(C_KituenKbn pKituenkbn) {
        kituenkbn = pKituenkbn;
    }

    private Integer kituenhon;

    @Column(name=GenHT_Houjyou.KITUENHON)
    @Range(min="0", max="99")
    public Integer getKituenhon() {
        return kituenhon;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKituenhon(Integer pKituenhon) {
        kituenhon = pKituenhon;
    }

    private String sinsaicd;

    @Column(name=GenHT_Houjyou.SINSAICD)
    @MaxLength(max=12)
    @AlphaDigit
    public String getSinsaicd() {
        return sinsaicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSinsaicd(String pSinsaicd) {
        sinsaicd = pSinsaicd;
    }

    private BizDate sinsaymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_Houjyou.SINSAYMD)
    @ValidDate
    public BizDate getSinsaymd() {
        return sinsaymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSinsaymd(BizDate pSinsaymd) {
        sinsaymd = pSinsaymd;
    }

    private C_Sinsatime sinsatime;

    @Type(type="UserType_C_Sinsatime")
    @Column(name=GenHT_Houjyou.SINSATIME)
    public C_Sinsatime getSinsatime() {
        return sinsatime;
    }

    public void setSinsatime(C_Sinsatime pSinsatime) {
        sinsatime = pSinsatime;
    }

    private C_TakuouKbn takuoukbn;

    @Type(type="UserType_C_TakuouKbn")
    @Column(name=GenHT_Houjyou.TAKUOUKBN)
    public C_TakuouKbn getTakuoukbn() {
        return takuoukbn;
    }

    public void setTakuoukbn(C_TakuouKbn pTakuoukbn) {
        takuoukbn = pTakuoukbn;
    }

    private C_SinsabaKbn sinsabakbn;

    @Type(type="UserType_C_SinsabaKbn")
    @Column(name=GenHT_Houjyou.SINSABAKBN)
    public C_SinsabaKbn getSinsabakbn() {
        return sinsabakbn;
    }

    public void setSinsabakbn(C_SinsabaKbn pSinsabakbn) {
        sinsabakbn = pSinsabakbn;
    }

    private String hbcmnt;

    @Column(name=GenHT_Houjyou.HBCMNT)
    public String getHbcmnt() {
        return hbcmnt;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHbcmnt(String pHbcmnt) {
        hbcmnt = pHbcmnt;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_Houjyou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_Houjyou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}