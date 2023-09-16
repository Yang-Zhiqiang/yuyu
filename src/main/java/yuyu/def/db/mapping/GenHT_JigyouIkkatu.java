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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_JiketteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.id.PKHT_JigyouIkkatu;
import yuyu.def.db.meta.GenQHT_JigyouIkkatu;
import yuyu.def.db.meta.QHT_JigyouIkkatu;
import yuyu.def.db.type.UserType_C_JiketteiKbn;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 事業一括テーブル テーブルのマッピング情報クラスで、 {@link HT_JigyouIkkatu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_JigyouIkkatu}</td><td colspan="3">事業一括テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDaimosno daimosno}</td><td>代表申込番号</td><td align="center">{@link PKHT_JigyouIkkatu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosnrkumu mosnrkumu}</td><td>申込書入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKktnrkumu kktnrkumu}</td><td>告知書入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHjynrkumu hjynrkumu}</td><td>報状入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNyknnrkumu nyknnrkumu}</td><td>入金入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNyknwarinrkumu nyknwarinrkumu}</td><td>入金割当入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getItijiketnrkumu itijiketnrkumu}</td><td>１次決定入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJiketteikbn jiketteikbn}</td><td>事業一括決定状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_JiketteiKbn}</td></tr>
 *  <tr><td>{@link #getJgyiktsrkbn jgyiktsrkbn}</td><td>事業一括成立区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeirituKbn}</td></tr>
 *  <tr><td>{@link #getJgyiktsrymd jgyiktsrymd}</td><td>事業一括成立日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_JigyouIkkatu
 * @see     PKHT_JigyouIkkatu
 * @see     QHT_JigyouIkkatu
 * @see     GenQHT_JigyouIkkatu
 */
@MappedSuperclass
@Table(name=GenHT_JigyouIkkatu.TABLE_NAME)
@IdClass(value=PKHT_JigyouIkkatu.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_JiketteiKbn", typeClass=UserType_C_JiketteiKbn.class),
    @TypeDef(name="UserType_C_SeirituKbn", typeClass=UserType_C_SeirituKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenHT_JigyouIkkatu extends AbstractExDBEntity<HT_JigyouIkkatu, PKHT_JigyouIkkatu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_JigyouIkkatu";
    public static final String DAIMOSNO                 = "daimosno";
    public static final String MOSNRKUMU                = "mosnrkumu";
    public static final String KKTNRKUMU                = "kktnrkumu";
    public static final String HJYNRKUMU                = "hjynrkumu";
    public static final String NYKNNRKUMU               = "nyknnrkumu";
    public static final String NYKNWARINRKUMU           = "nyknwarinrkumu";
    public static final String ITIJIKETNRKUMU           = "itijiketnrkumu";
    public static final String JIKETTEIKBN              = "jiketteikbn";
    public static final String JGYIKTSRKBN              = "jgyiktsrkbn";
    public static final String JGYIKTSRYMD              = "jgyiktsrymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_JigyouIkkatu primaryKey;

    public GenHT_JigyouIkkatu() {
        primaryKey = new PKHT_JigyouIkkatu();
    }

    public GenHT_JigyouIkkatu(String pDaimosno) {
        primaryKey = new PKHT_JigyouIkkatu(pDaimosno);
    }

    @Transient
    @Override
    public PKHT_JigyouIkkatu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_JigyouIkkatu> getMetaClass() {
        return QHT_JigyouIkkatu.class;
    }

    @Id
    @Column(name=GenHT_JigyouIkkatu.DAIMOSNO)
    @MousikomiNo
    public String getDaimosno() {
        return getPrimaryKey().getDaimosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDaimosno(String pDaimosno) {
        getPrimaryKey().setDaimosno(pDaimosno);
    }

    private C_UmuKbn mosnrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_JigyouIkkatu.MOSNRKUMU)
    public C_UmuKbn getMosnrkumu() {
        return mosnrkumu;
    }

    public void setMosnrkumu(C_UmuKbn pMosnrkumu) {
        mosnrkumu = pMosnrkumu;
    }

    private C_UmuKbn kktnrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_JigyouIkkatu.KKTNRKUMU)
    public C_UmuKbn getKktnrkumu() {
        return kktnrkumu;
    }

    public void setKktnrkumu(C_UmuKbn pKktnrkumu) {
        kktnrkumu = pKktnrkumu;
    }

    private C_UmuKbn hjynrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_JigyouIkkatu.HJYNRKUMU)
    public C_UmuKbn getHjynrkumu() {
        return hjynrkumu;
    }

    public void setHjynrkumu(C_UmuKbn pHjynrkumu) {
        hjynrkumu = pHjynrkumu;
    }

    private C_UmuKbn nyknnrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_JigyouIkkatu.NYKNNRKUMU)
    public C_UmuKbn getNyknnrkumu() {
        return nyknnrkumu;
    }

    public void setNyknnrkumu(C_UmuKbn pNyknnrkumu) {
        nyknnrkumu = pNyknnrkumu;
    }

    private C_UmuKbn nyknwarinrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_JigyouIkkatu.NYKNWARINRKUMU)
    public C_UmuKbn getNyknwarinrkumu() {
        return nyknwarinrkumu;
    }

    public void setNyknwarinrkumu(C_UmuKbn pNyknwarinrkumu) {
        nyknwarinrkumu = pNyknwarinrkumu;
    }

    private C_UmuKbn itijiketnrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_JigyouIkkatu.ITIJIKETNRKUMU)
    public C_UmuKbn getItijiketnrkumu() {
        return itijiketnrkumu;
    }

    public void setItijiketnrkumu(C_UmuKbn pItijiketnrkumu) {
        itijiketnrkumu = pItijiketnrkumu;
    }

    private C_JiketteiKbn jiketteikbn;

    @Type(type="UserType_C_JiketteiKbn")
    @Column(name=GenHT_JigyouIkkatu.JIKETTEIKBN)
    public C_JiketteiKbn getJiketteikbn() {
        return jiketteikbn;
    }

    public void setJiketteikbn(C_JiketteiKbn pJiketteikbn) {
        jiketteikbn = pJiketteikbn;
    }

    private C_SeirituKbn jgyiktsrkbn;

    @Type(type="UserType_C_SeirituKbn")
    @Column(name=GenHT_JigyouIkkatu.JGYIKTSRKBN)
    public C_SeirituKbn getJgyiktsrkbn() {
        return jgyiktsrkbn;
    }

    public void setJgyiktsrkbn(C_SeirituKbn pJgyiktsrkbn) {
        jgyiktsrkbn = pJgyiktsrkbn;
    }

    private BizDate jgyiktsrymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_JigyouIkkatu.JGYIKTSRYMD)
    public BizDate getJgyiktsrymd() {
        return jgyiktsrymd;
    }

    public void setJgyiktsrymd(BizDate pJgyiktsrymd) {
        jgyiktsrymd = pJgyiktsrymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_JigyouIkkatu.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_JigyouIkkatu.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}