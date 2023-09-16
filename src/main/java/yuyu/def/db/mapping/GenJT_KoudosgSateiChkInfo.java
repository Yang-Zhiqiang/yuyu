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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.classification.C_ShrsakiSeikyuusyaKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_KoudosgSateiChkInfo;
import yuyu.def.db.id.PKJT_KoudosgSateiChkInfo;
import yuyu.def.db.meta.GenQJT_KoudosgSateiChkInfo;
import yuyu.def.db.meta.QJT_KoudosgSateiChkInfo;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.def.db.type.UserType_C_NoinitYouhiKbn;
import yuyu.def.db.type.UserType_C_ShrsakiSeikyuusyaKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 高度障害査定チェック情報テーブル テーブルのマッピング情報クラスで、 {@link JT_KoudosgSateiChkInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_KoudosgSateiChkInfo}</td><td colspan="3">高度障害査定チェック情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_KoudosgSateiChkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_KoudosgSateiChkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_KoudosgSateiChkInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGengkumukbn gengkumukbn}</td><td>減額有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getGengkymd gengkymd}</td><td>減額日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGengkcomment gengkcomment}</td><td>減額コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkisinouryokuumukbn skisinouryokuumukbn}</td><td>請求意思能力有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getSkisinouryokuttdktyuuikbn skisinouryokuttdktyuuikbn}</td><td>請求意思能力手続注意区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitYouhiKbn}</td></tr>
 *  <tr><td>{@link #getSkisinouryokucomment skisinouryokucomment}</td><td>請求意思能力コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrsakiseikyuusyakbn shrsakiseikyuusyakbn}</td><td>支払先請求者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrsakiSeikyuusyaKbn}</td></tr>
 *  <tr><td>{@link #getShrsakicomment shrsakicomment}</td><td>支払先コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyhkaisyuuyouhiikbn kyhkaisyuuyouhiikbn}</td><td>給付金回収要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getKyhkaisyuuyouhiicomment kyhkaisyuuyouhiicomment}</td><td>給付金回収コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDanpozaikeiumukbn danpozaikeiumukbn}</td><td>団保財形有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getDanpozaikeicomment danpozaikeicomment}</td><td>団保財形コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBengosikenkaiumukbn bengosikenkaiumukbn}</td><td>弁護士見解有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getKujyouumukbn kujyouumukbn}</td><td>苦情有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getJimumissumukbn jimumissumukbn}</td><td>事務ミス有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getKyhgksitukaisouyouhikbn kyhgksitukaisouyouhikbn}</td><td>給付金室回送要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitYouhiKbn}</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_KoudosgSateiChkInfo
 * @see     PKJT_KoudosgSateiChkInfo
 * @see     QJT_KoudosgSateiChkInfo
 * @see     GenQJT_KoudosgSateiChkInfo
 */
@MappedSuperclass
@Table(name=GenJT_KoudosgSateiChkInfo.TABLE_NAME)
@IdClass(value=PKJT_KoudosgSateiChkInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_NoinitUmuKbn", typeClass=UserType_C_NoinitUmuKbn.class),
    @TypeDef(name="UserType_C_NoinitYouhiKbn", typeClass=UserType_C_NoinitYouhiKbn.class),
    @TypeDef(name="UserType_C_ShrsakiSeikyuusyaKbn", typeClass=UserType_C_ShrsakiSeikyuusyaKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class)
})
public abstract class GenJT_KoudosgSateiChkInfo extends AbstractExDBEntity<JT_KoudosgSateiChkInfo, PKJT_KoudosgSateiChkInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_KoudosgSateiChkInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String GENGKUMUKBN              = "gengkumukbn";
    public static final String GENGKYMD                 = "gengkymd";
    public static final String GENGKCOMMENT             = "gengkcomment";
    public static final String SKISINOURYOKUUMUKBN      = "skisinouryokuumukbn";
    public static final String SKISINOURYOKUTTDKTYUUIKBN = "skisinouryokuttdktyuuikbn";
    public static final String SKISINOURYOKUCOMMENT     = "skisinouryokucomment";
    public static final String SHRSAKISEIKYUUSYAKBN     = "shrsakiseikyuusyakbn";
    public static final String SHRSAKICOMMENT           = "shrsakicomment";
    public static final String KYHKAISYUUYOUHIIKBN      = "kyhkaisyuuyouhiikbn";
    public static final String KYHKAISYUUYOUHIICOMMENT  = "kyhkaisyuuyouhiicomment";
    public static final String DANPOZAIKEIUMUKBN        = "danpozaikeiumukbn";
    public static final String DANPOZAIKEICOMMENT       = "danpozaikeicomment";
    public static final String BENGOSIKENKAIUMUKBN      = "bengosikenkaiumukbn";
    public static final String KUJYOUUMUKBN             = "kujyouumukbn";
    public static final String JIMUMISSUMUKBN           = "jimumissumukbn";
    public static final String KYHGKSITUKAISOUYOUHIKBN  = "kyhgksitukaisouyouhikbn";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_KoudosgSateiChkInfo primaryKey;

    public GenJT_KoudosgSateiChkInfo() {
        primaryKey = new PKJT_KoudosgSateiChkInfo();
    }

    public GenJT_KoudosgSateiChkInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_KoudosgSateiChkInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_KoudosgSateiChkInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_KoudosgSateiChkInfo> getMetaClass() {
        return QJT_KoudosgSateiChkInfo.class;
    }

    @Id
    @Column(name=GenJT_KoudosgSateiChkInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_KoudosgSateiChkInfo.SYONO)
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
    @Column(name=GenJT_KoudosgSateiChkInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private C_NoinitUmuKbn gengkumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_KoudosgSateiChkInfo.GENGKUMUKBN)
    public C_NoinitUmuKbn getGengkumukbn() {
        return gengkumukbn;
    }

    public void setGengkumukbn(C_NoinitUmuKbn pGengkumukbn) {
        gengkumukbn = pGengkumukbn;
    }

    private BizDate gengkymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_KoudosgSateiChkInfo.GENGKYMD)
    @ValidDate
    public BizDate getGengkymd() {
        return gengkymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGengkymd(BizDate pGengkymd) {
        gengkymd = pGengkymd;
    }

    private String gengkcomment;

    @Column(name=GenJT_KoudosgSateiChkInfo.GENGKCOMMENT)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getGengkcomment() {
        return gengkcomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setGengkcomment(String pGengkcomment) {
        gengkcomment = pGengkcomment;
    }

    private C_NoinitUmuKbn skisinouryokuumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_KoudosgSateiChkInfo.SKISINOURYOKUUMUKBN)
    public C_NoinitUmuKbn getSkisinouryokuumukbn() {
        return skisinouryokuumukbn;
    }

    public void setSkisinouryokuumukbn(C_NoinitUmuKbn pSkisinouryokuumukbn) {
        skisinouryokuumukbn = pSkisinouryokuumukbn;
    }

    private C_NoinitYouhiKbn skisinouryokuttdktyuuikbn;

    @Type(type="UserType_C_NoinitYouhiKbn")
    @Column(name=GenJT_KoudosgSateiChkInfo.SKISINOURYOKUTTDKTYUUIKBN)
    public C_NoinitYouhiKbn getSkisinouryokuttdktyuuikbn() {
        return skisinouryokuttdktyuuikbn;
    }

    public void setSkisinouryokuttdktyuuikbn(C_NoinitYouhiKbn pSkisinouryokuttdktyuuikbn) {
        skisinouryokuttdktyuuikbn = pSkisinouryokuttdktyuuikbn;
    }

    private String skisinouryokucomment;

    @Column(name=GenJT_KoudosgSateiChkInfo.SKISINOURYOKUCOMMENT)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSkisinouryokucomment() {
        return skisinouryokucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSkisinouryokucomment(String pSkisinouryokucomment) {
        skisinouryokucomment = pSkisinouryokucomment;
    }

    private C_ShrsakiSeikyuusyaKbn shrsakiseikyuusyakbn;

    @Type(type="UserType_C_ShrsakiSeikyuusyaKbn")
    @Column(name=GenJT_KoudosgSateiChkInfo.SHRSAKISEIKYUUSYAKBN)
    public C_ShrsakiSeikyuusyaKbn getShrsakiseikyuusyakbn() {
        return shrsakiseikyuusyakbn;
    }

    public void setShrsakiseikyuusyakbn(C_ShrsakiSeikyuusyaKbn pShrsakiseikyuusyakbn) {
        shrsakiseikyuusyakbn = pShrsakiseikyuusyakbn;
    }

    private String shrsakicomment;

    @Column(name=GenJT_KoudosgSateiChkInfo.SHRSAKICOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getShrsakicomment() {
        return shrsakicomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setShrsakicomment(String pShrsakicomment) {
        shrsakicomment = pShrsakicomment;
    }

    private C_YouhiKbn kyhkaisyuuyouhiikbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenJT_KoudosgSateiChkInfo.KYHKAISYUUYOUHIIKBN)
    public C_YouhiKbn getKyhkaisyuuyouhiikbn() {
        return kyhkaisyuuyouhiikbn;
    }

    public void setKyhkaisyuuyouhiikbn(C_YouhiKbn pKyhkaisyuuyouhiikbn) {
        kyhkaisyuuyouhiikbn = pKyhkaisyuuyouhiikbn;
    }

    private String kyhkaisyuuyouhiicomment;

    @Column(name=GenJT_KoudosgSateiChkInfo.KYHKAISYUUYOUHIICOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyhkaisyuuyouhiicomment() {
        return kyhkaisyuuyouhiicomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKyhkaisyuuyouhiicomment(String pKyhkaisyuuyouhiicomment) {
        kyhkaisyuuyouhiicomment = pKyhkaisyuuyouhiicomment;
    }

    private C_NoinitUmuKbn danpozaikeiumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_KoudosgSateiChkInfo.DANPOZAIKEIUMUKBN)
    public C_NoinitUmuKbn getDanpozaikeiumukbn() {
        return danpozaikeiumukbn;
    }

    public void setDanpozaikeiumukbn(C_NoinitUmuKbn pDanpozaikeiumukbn) {
        danpozaikeiumukbn = pDanpozaikeiumukbn;
    }

    private String danpozaikeicomment;

    @Column(name=GenJT_KoudosgSateiChkInfo.DANPOZAIKEICOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getDanpozaikeicomment() {
        return danpozaikeicomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDanpozaikeicomment(String pDanpozaikeicomment) {
        danpozaikeicomment = pDanpozaikeicomment;
    }

    private C_NoinitUmuKbn bengosikenkaiumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_KoudosgSateiChkInfo.BENGOSIKENKAIUMUKBN)
    public C_NoinitUmuKbn getBengosikenkaiumukbn() {
        return bengosikenkaiumukbn;
    }

    public void setBengosikenkaiumukbn(C_NoinitUmuKbn pBengosikenkaiumukbn) {
        bengosikenkaiumukbn = pBengosikenkaiumukbn;
    }

    private C_NoinitUmuKbn kujyouumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_KoudosgSateiChkInfo.KUJYOUUMUKBN)
    public C_NoinitUmuKbn getKujyouumukbn() {
        return kujyouumukbn;
    }

    public void setKujyouumukbn(C_NoinitUmuKbn pKujyouumukbn) {
        kujyouumukbn = pKujyouumukbn;
    }

    private C_NoinitUmuKbn jimumissumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_KoudosgSateiChkInfo.JIMUMISSUMUKBN)
    public C_NoinitUmuKbn getJimumissumukbn() {
        return jimumissumukbn;
    }

    public void setJimumissumukbn(C_NoinitUmuKbn pJimumissumukbn) {
        jimumissumukbn = pJimumissumukbn;
    }

    private C_NoinitYouhiKbn kyhgksitukaisouyouhikbn;

    @Type(type="UserType_C_NoinitYouhiKbn")
    @Column(name=GenJT_KoudosgSateiChkInfo.KYHGKSITUKAISOUYOUHIKBN)
    public C_NoinitYouhiKbn getKyhgksitukaisouyouhikbn() {
        return kyhgksitukaisouyouhikbn;
    }

    public void setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn pKyhgksitukaisouyouhikbn) {
        kyhgksitukaisouyouhikbn = pKyhgksitukaisouyouhikbn;
    }

    private String kossyoricd;

    @Column(name=GenJT_KoudosgSateiChkInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_KoudosgSateiChkInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_KoudosgSateiChkInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_KoudosgSateiChkInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}