package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.id.PKJT_BetukutiSateiInfo;
import yuyu.def.db.meta.GenQJT_BetukutiSateiInfo;
import yuyu.def.db.meta.QJT_BetukutiSateiInfo;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 別口査定情報テーブル テーブルのマッピング情報クラスで、 {@link JT_BetukutiSateiInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_BetukutiSateiInfo}</td><td colspan="3">別口査定情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_BetukutiSateiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_BetukutiSateiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_BetukutiSateiInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getBetusibouumukbn betusibouumukbn}</td><td>別口死亡有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getBetusiboucomment betusiboucomment}</td><td>別口死亡コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBetukdsgumukbn betukdsgumukbn}</td><td>別口高度障害有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getBetukdsgcomment betukdsgcomment}</td><td>別口高度障害コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBetusoukiumukbn betusoukiumukbn}</td><td>別口早期有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getBetusoukicomment betusoukicomment}</td><td>別口早期コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBetusymtkykumukbn betusymtkykumukbn}</td><td>別口消滅契約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getBetusymtkykcomment betusymtkykcomment}</td><td>別口消滅契約コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_BetukutiSateiInfo
 * @see     PKJT_BetukutiSateiInfo
 * @see     QJT_BetukutiSateiInfo
 * @see     GenQJT_BetukutiSateiInfo
 */
@MappedSuperclass
@Table(name=GenJT_BetukutiSateiInfo.TABLE_NAME)
@IdClass(value=PKJT_BetukutiSateiInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_NoinitUmuKbn", typeClass=UserType_C_NoinitUmuKbn.class)
})
public abstract class GenJT_BetukutiSateiInfo extends AbstractExDBEntity<JT_BetukutiSateiInfo, PKJT_BetukutiSateiInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_BetukutiSateiInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String BETUSIBOUUMUKBN          = "betusibouumukbn";
    public static final String BETUSIBOUCOMMENT         = "betusiboucomment";
    public static final String BETUKDSGUMUKBN           = "betukdsgumukbn";
    public static final String BETUKDSGCOMMENT          = "betukdsgcomment";
    public static final String BETUSOUKIUMUKBN          = "betusoukiumukbn";
    public static final String BETUSOUKICOMMENT         = "betusoukicomment";
    public static final String BETUSYMTKYKUMUKBN        = "betusymtkykumukbn";
    public static final String BETUSYMTKYKCOMMENT       = "betusymtkykcomment";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_BetukutiSateiInfo primaryKey;

    public GenJT_BetukutiSateiInfo() {
        primaryKey = new PKJT_BetukutiSateiInfo();
    }

    public GenJT_BetukutiSateiInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_BetukutiSateiInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_BetukutiSateiInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_BetukutiSateiInfo> getMetaClass() {
        return QJT_BetukutiSateiInfo.class;
    }

    @Id
    @Column(name=GenJT_BetukutiSateiInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_BetukutiSateiInfo.SYONO)
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
    @Column(name=GenJT_BetukutiSateiInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private C_NoinitUmuKbn betusibouumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_BetukutiSateiInfo.BETUSIBOUUMUKBN)
    public C_NoinitUmuKbn getBetusibouumukbn() {
        return betusibouumukbn;
    }

    public void setBetusibouumukbn(C_NoinitUmuKbn pBetusibouumukbn) {
        betusibouumukbn = pBetusibouumukbn;
    }

    private String betusiboucomment;

    @Column(name=GenJT_BetukutiSateiInfo.BETUSIBOUCOMMENT)
    @MultiByteStrings
    @MaxLength(max=40)
    @InvalidCharacter
    public String getBetusiboucomment() {
        return betusiboucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setBetusiboucomment(String pBetusiboucomment) {
        betusiboucomment = pBetusiboucomment;
    }

    private C_NoinitUmuKbn betukdsgumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_BetukutiSateiInfo.BETUKDSGUMUKBN)
    public C_NoinitUmuKbn getBetukdsgumukbn() {
        return betukdsgumukbn;
    }

    public void setBetukdsgumukbn(C_NoinitUmuKbn pBetukdsgumukbn) {
        betukdsgumukbn = pBetukdsgumukbn;
    }

    private String betukdsgcomment;

    @Column(name=GenJT_BetukutiSateiInfo.BETUKDSGCOMMENT)
    @MultiByteStrings
    @MaxLength(max=40)
    @InvalidCharacter
    public String getBetukdsgcomment() {
        return betukdsgcomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setBetukdsgcomment(String pBetukdsgcomment) {
        betukdsgcomment = pBetukdsgcomment;
    }

    private C_NoinitUmuKbn betusoukiumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_BetukutiSateiInfo.BETUSOUKIUMUKBN)
    public C_NoinitUmuKbn getBetusoukiumukbn() {
        return betusoukiumukbn;
    }

    public void setBetusoukiumukbn(C_NoinitUmuKbn pBetusoukiumukbn) {
        betusoukiumukbn = pBetusoukiumukbn;
    }

    private String betusoukicomment;

    @Column(name=GenJT_BetukutiSateiInfo.BETUSOUKICOMMENT)
    @MultiByteStrings
    @MaxLength(max=40)
    @InvalidCharacter
    public String getBetusoukicomment() {
        return betusoukicomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setBetusoukicomment(String pBetusoukicomment) {
        betusoukicomment = pBetusoukicomment;
    }

    private C_NoinitUmuKbn betusymtkykumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_BetukutiSateiInfo.BETUSYMTKYKUMUKBN)
    public C_NoinitUmuKbn getBetusymtkykumukbn() {
        return betusymtkykumukbn;
    }

    public void setBetusymtkykumukbn(C_NoinitUmuKbn pBetusymtkykumukbn) {
        betusymtkykumukbn = pBetusymtkykumukbn;
    }

    private String betusymtkykcomment;

    @Column(name=GenJT_BetukutiSateiInfo.BETUSYMTKYKCOMMENT)
    @MultiByteStrings
    @MaxLength(max=40)
    @InvalidCharacter
    public String getBetusymtkykcomment() {
        return betusymtkykcomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setBetusymtkykcomment(String pBetusymtkykcomment) {
        betusymtkykcomment = pBetusymtkykcomment;
    }

    private String kossyoricd;

    @Column(name=GenJT_BetukutiSateiInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_BetukutiSateiInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_BetukutiSateiInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_BetukutiSateiInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}