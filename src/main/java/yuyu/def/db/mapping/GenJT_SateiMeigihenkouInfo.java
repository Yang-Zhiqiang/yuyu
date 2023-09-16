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
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.id.PKJT_SateiMeigihenkouInfo;
import yuyu.def.db.meta.GenQJT_SateiMeigihenkouInfo;
import yuyu.def.db.meta.QJT_SateiMeigihenkouInfo;
import yuyu.def.db.type.UserType_C_MeihenUktKbn;
import yuyu.def.db.type.UserType_C_MeihenYuukouMukouKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定名義変更情報テーブル テーブルのマッピング情報クラスで、 {@link JT_SateiMeigihenkouInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiMeigihenkouInfo}</td><td colspan="3">査定名義変更情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SateiMeigihenkouInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SateiMeigihenkouInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SateiMeigihenkouInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMeihenyuukoumukoukbn meihenyuukoumukoukbn}</td><td>名義変更有効無効区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MeihenYuukouMukouKbn}</td></tr>
 *  <tr><td>{@link #getMeihenuktkbn meihenuktkbn}</td><td>名義変更受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MeihenUktKbn}</td></tr>
 *  <tr><td>{@link #getMeihenuktnm meihenuktnm}</td><td>名義変更受取人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiMeigihenkouInfo
 * @see     PKJT_SateiMeigihenkouInfo
 * @see     QJT_SateiMeigihenkouInfo
 * @see     GenQJT_SateiMeigihenkouInfo
 */
@MappedSuperclass
@Table(name=GenJT_SateiMeigihenkouInfo.TABLE_NAME)
@IdClass(value=PKJT_SateiMeigihenkouInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_MeihenUktKbn", typeClass=UserType_C_MeihenUktKbn.class),
    @TypeDef(name="UserType_C_MeihenYuukouMukouKbn", typeClass=UserType_C_MeihenYuukouMukouKbn.class)
})
public abstract class GenJT_SateiMeigihenkouInfo extends AbstractExDBEntity<JT_SateiMeigihenkouInfo, PKJT_SateiMeigihenkouInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SateiMeigihenkouInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String MEIHENYUUKOUMUKOUKBN     = "meihenyuukoumukoukbn";
    public static final String MEIHENUKTKBN             = "meihenuktkbn";
    public static final String MEIHENUKTNM              = "meihenuktnm";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SateiMeigihenkouInfo primaryKey;

    public GenJT_SateiMeigihenkouInfo() {
        primaryKey = new PKJT_SateiMeigihenkouInfo();
    }

    public GenJT_SateiMeigihenkouInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_SateiMeigihenkouInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_SateiMeigihenkouInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SateiMeigihenkouInfo> getMetaClass() {
        return QJT_SateiMeigihenkouInfo.class;
    }

    @Id
    @Column(name=GenJT_SateiMeigihenkouInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SateiMeigihenkouInfo.SYONO)
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
    @Column(name=GenJT_SateiMeigihenkouInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private C_MeihenYuukouMukouKbn meihenyuukoumukoukbn;

    @Type(type="UserType_C_MeihenYuukouMukouKbn")
    @Column(name=GenJT_SateiMeigihenkouInfo.MEIHENYUUKOUMUKOUKBN)
    public C_MeihenYuukouMukouKbn getMeihenyuukoumukoukbn() {
        return meihenyuukoumukoukbn;
    }

    public void setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn pMeihenyuukoumukoukbn) {
        meihenyuukoumukoukbn = pMeihenyuukoumukoukbn;
    }

    private C_MeihenUktKbn meihenuktkbn;

    @Type(type="UserType_C_MeihenUktKbn")
    @Column(name=GenJT_SateiMeigihenkouInfo.MEIHENUKTKBN)
    public C_MeihenUktKbn getMeihenuktkbn() {
        return meihenuktkbn;
    }

    public void setMeihenuktkbn(C_MeihenUktKbn pMeihenuktkbn) {
        meihenuktkbn = pMeihenuktkbn;
    }

    private String meihenuktnm;

    @Column(name=GenJT_SateiMeigihenkouInfo.MEIHENUKTNM)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getMeihenuktnm() {
        return meihenuktnm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setMeihenuktnm(String pMeihenuktnm) {
        meihenuktnm = pMeihenuktnm;
    }

    private String kossyoricd;

    @Column(name=GenJT_SateiMeigihenkouInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SateiMeigihenkouInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SateiMeigihenkouInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SateiMeigihenkouInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}