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
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_KzkkijiKbn;
import yuyu.def.db.entity.HT_BosKokutisyo;
import yuyu.def.db.id.PKHT_BosKokutisyo;
import yuyu.def.db.meta.GenQHT_BosKokutisyo;
import yuyu.def.db.meta.QHT_BosKokutisyo;
import yuyu.def.db.type.UserType_C_KijiKbn;
import yuyu.def.db.type.UserType_C_KituenKbn;
import yuyu.def.db.type.UserType_C_KzkkijiKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 募集告知書テーブル テーブルのマッピング情報クラスで、 {@link HT_BosKokutisyo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_BosKokutisyo}</td><td colspan="3">募集告知書テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_BosKokutisyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKktymd kktymd}</td><td>告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSintyou sintyou}</td><td>身長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTaijyuu taijyuu}</td><td>体重</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKituenkbn kituenkbn}</td><td>喫煙区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KituenKbn}</td></tr>
 *  <tr><td>{@link #getKituenhon kituenhon}</td><td>喫煙本数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKijikbn kijikbn}</td><td>記事区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KijiKbn}</td></tr>
 *  <tr><td>{@link #getKzkkijikbn kzkkijikbn}</td><td>家族記事区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzkkijiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_BosKokutisyo
 * @see     PKHT_BosKokutisyo
 * @see     QHT_BosKokutisyo
 * @see     GenQHT_BosKokutisyo
 */
@MappedSuperclass
@Table(name=GenHT_BosKokutisyo.TABLE_NAME)
@IdClass(value=PKHT_BosKokutisyo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KijiKbn", typeClass=UserType_C_KijiKbn.class),
    @TypeDef(name="UserType_C_KituenKbn", typeClass=UserType_C_KituenKbn.class),
    @TypeDef(name="UserType_C_KzkkijiKbn", typeClass=UserType_C_KzkkijiKbn.class)
})
public abstract class GenHT_BosKokutisyo extends AbstractExDBEntity<HT_BosKokutisyo, PKHT_BosKokutisyo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_BosKokutisyo";
    public static final String MOSNO                    = "mosno";
    public static final String KKTYMD                   = "kktymd";
    public static final String SINTYOU                  = "sintyou";
    public static final String TAIJYUU                  = "taijyuu";
    public static final String KITUENKBN                = "kituenkbn";
    public static final String KITUENHON                = "kituenhon";
    public static final String KIJIKBN                  = "kijikbn";
    public static final String KZKKIJIKBN               = "kzkkijikbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_BosKokutisyo primaryKey;

    public GenHT_BosKokutisyo() {
        primaryKey = new PKHT_BosKokutisyo();
    }

    public GenHT_BosKokutisyo(String pMosno) {
        primaryKey = new PKHT_BosKokutisyo(pMosno);
    }

    @Transient
    @Override
    public PKHT_BosKokutisyo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_BosKokutisyo> getMetaClass() {
        return QHT_BosKokutisyo.class;
    }

    @Id
    @Column(name=GenHT_BosKokutisyo.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private BizDate kktymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_BosKokutisyo.KKTYMD)
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

    @Column(name=GenHT_BosKokutisyo.SINTYOU)
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

    @Column(name=GenHT_BosKokutisyo.TAIJYUU)
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
    @Column(name=GenHT_BosKokutisyo.KITUENKBN)
    public C_KituenKbn getKituenkbn() {
        return kituenkbn;
    }

    public void setKituenkbn(C_KituenKbn pKituenkbn) {
        kituenkbn = pKituenkbn;
    }

    private Integer kituenhon;

    @Column(name=GenHT_BosKokutisyo.KITUENHON)
    @Range(min="0", max="99")
    public Integer getKituenhon() {
        return kituenhon;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKituenhon(Integer pKituenhon) {
        kituenhon = pKituenhon;
    }

    private C_KijiKbn kijikbn;

    @Type(type="UserType_C_KijiKbn")
    @Column(name=GenHT_BosKokutisyo.KIJIKBN)
    public C_KijiKbn getKijikbn() {
        return kijikbn;
    }

    public void setKijikbn(C_KijiKbn pKijikbn) {
        kijikbn = pKijikbn;
    }

    private C_KzkkijiKbn kzkkijikbn;

    @Type(type="UserType_C_KzkkijiKbn")
    @Column(name=GenHT_BosKokutisyo.KZKKIJIKBN)
    public C_KzkkijiKbn getKzkkijikbn() {
        return kzkkijikbn;
    }

    public void setKzkkijikbn(C_KzkkijiKbn pKzkkijikbn) {
        kzkkijikbn = pKzkkijikbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_BosKokutisyo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_BosKokutisyo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}