package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.id.PKJT_SibouSateiChkInfo;
import yuyu.def.db.meta.GenQJT_SibouSateiChkInfo;
import yuyu.def.db.meta.QJT_SibouSateiChkInfo;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.def.db.type.UserType_C_NoinitYouhiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 死亡査定チェック情報テーブル テーブルのマッピング情報クラスで、 {@link JT_SibouSateiChkInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SibouSateiChkInfo}</td><td colspan="3">死亡査定チェック情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SibouSateiChkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SibouSateiChkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SibouSateiChkInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getBengosikenkaiumukbn bengosikenkaiumukbn}</td><td>弁護士見解有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getKujyouumukbn kujyouumukbn}</td><td>苦情有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getJimumissumukbn jimumissumukbn}</td><td>事務ミス有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getKyhgksitukaisouyouhikbn kyhgksitukaisouyouhikbn}</td><td>給付金室回送要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitYouhiKbn}</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SibouSateiChkInfo
 * @see     PKJT_SibouSateiChkInfo
 * @see     QJT_SibouSateiChkInfo
 * @see     GenQJT_SibouSateiChkInfo
 */
@MappedSuperclass
@Table(name=GenJT_SibouSateiChkInfo.TABLE_NAME)
@IdClass(value=PKJT_SibouSateiChkInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_NoinitUmuKbn", typeClass=UserType_C_NoinitUmuKbn.class),
    @TypeDef(name="UserType_C_NoinitYouhiKbn", typeClass=UserType_C_NoinitYouhiKbn.class)
})
public abstract class GenJT_SibouSateiChkInfo extends AbstractExDBEntity<JT_SibouSateiChkInfo, PKJT_SibouSateiChkInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SibouSateiChkInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String BENGOSIKENKAIUMUKBN      = "bengosikenkaiumukbn";
    public static final String KUJYOUUMUKBN             = "kujyouumukbn";
    public static final String JIMUMISSUMUKBN           = "jimumissumukbn";
    public static final String KYHGKSITUKAISOUYOUHIKBN  = "kyhgksitukaisouyouhikbn";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SibouSateiChkInfo primaryKey;

    public GenJT_SibouSateiChkInfo() {
        primaryKey = new PKJT_SibouSateiChkInfo();
    }

    public GenJT_SibouSateiChkInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_SibouSateiChkInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_SibouSateiChkInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SibouSateiChkInfo> getMetaClass() {
        return QJT_SibouSateiChkInfo.class;
    }

    @Id
    @Column(name=GenJT_SibouSateiChkInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SibouSateiChkInfo.SYONO)
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
    @Column(name=GenJT_SibouSateiChkInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private C_NoinitUmuKbn bengosikenkaiumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_SibouSateiChkInfo.BENGOSIKENKAIUMUKBN)
    public C_NoinitUmuKbn getBengosikenkaiumukbn() {
        return bengosikenkaiumukbn;
    }

    public void setBengosikenkaiumukbn(C_NoinitUmuKbn pBengosikenkaiumukbn) {
        bengosikenkaiumukbn = pBengosikenkaiumukbn;
    }

    private C_NoinitUmuKbn kujyouumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_SibouSateiChkInfo.KUJYOUUMUKBN)
    public C_NoinitUmuKbn getKujyouumukbn() {
        return kujyouumukbn;
    }

    public void setKujyouumukbn(C_NoinitUmuKbn pKujyouumukbn) {
        kujyouumukbn = pKujyouumukbn;
    }

    private C_NoinitUmuKbn jimumissumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_SibouSateiChkInfo.JIMUMISSUMUKBN)
    public C_NoinitUmuKbn getJimumissumukbn() {
        return jimumissumukbn;
    }

    public void setJimumissumukbn(C_NoinitUmuKbn pJimumissumukbn) {
        jimumissumukbn = pJimumissumukbn;
    }

    private C_NoinitYouhiKbn kyhgksitukaisouyouhikbn;

    @Type(type="UserType_C_NoinitYouhiKbn")
    @Column(name=GenJT_SibouSateiChkInfo.KYHGKSITUKAISOUYOUHIKBN)
    public C_NoinitYouhiKbn getKyhgksitukaisouyouhikbn() {
        return kyhgksitukaisouyouhikbn;
    }

    public void setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn pKyhgksitukaisouyouhikbn) {
        kyhgksitukaisouyouhikbn = pKyhgksitukaisouyouhikbn;
    }

    private String kossyoricd;

    @Column(name=GenJT_SibouSateiChkInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SibouSateiChkInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SibouSateiChkInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SibouSateiChkInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}