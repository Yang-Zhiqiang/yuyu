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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import yuyu.def.db.id.PKIT_KhHubiMikaisyouList;
import yuyu.def.db.meta.GenQIT_KhHubiMikaisyouList;
import yuyu.def.db.meta.QIT_KhHubiMikaisyouList;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全不備未解消リストテーブル テーブルのマッピング情報クラスで、 {@link IT_KhHubiMikaisyouList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHubiMikaisyouList}</td><td colspan="3">契約保全不備未解消リストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">{@link PKIT_KhHubiMikaisyouList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhHubiMikaisyouList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHassinsakikbn hassinsakikbn}</td><td>発信先区分</td><td align="center">{@link PKIT_KhHubiMikaisyouList ○}</td><td align="center">V</td><td>{@link C_HassinsakiKbn}</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSksreadymd sksreadymd}</td><td>請求書読込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGenponhnkykumu genponhnkykumu}</td><td>原本返却有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHubitourokuktntnm hubitourokuktntnm}</td><td>不備登録担当者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubisyouninktntnm hubisyouninktntnm}</td><td>不備承認担当者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHassinkaisuu hassinkaisuu}</td><td>発信回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getFsthubbihasinymd fsthubbihasinymd}</td><td>初回不備発信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLasthubbihasinymd lasthubbihasinymd}</td><td>最終不備発信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHubiMikaisyouList
 * @see     PKIT_KhHubiMikaisyouList
 * @see     QIT_KhHubiMikaisyouList
 * @see     GenQIT_KhHubiMikaisyouList
 */
@MappedSuperclass
@Table(name=GenIT_KhHubiMikaisyouList.TABLE_NAME)
@IdClass(value=PKIT_KhHubiMikaisyouList.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassinsakiKbn", typeClass=UserType_C_HassinsakiKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_KhHubiMikaisyouList extends AbstractExDBEntity<IT_KhHubiMikaisyouList, PKIT_KhHubiMikaisyouList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhHubiMikaisyouList";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String SYONO                    = "syono";
    public static final String HASSINSAKIKBN            = "hassinsakikbn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String SKSREADYMD               = "sksreadymd";
    public static final String GENPONHNKYKUMU           = "genponhnkykumu";
    public static final String HUBITOUROKUKTNTNM        = "hubitourokuktntnm";
    public static final String HUBISYOUNINKTNTNM        = "hubisyouninktntnm";
    public static final String HASSINKAISUU             = "hassinkaisuu";
    public static final String FSTHUBBIHASINYMD         = "fsthubbihasinymd";
    public static final String LASTHUBBIHASINYMD        = "lasthubbihasinymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhHubiMikaisyouList primaryKey;

    public GenIT_KhHubiMikaisyouList() {
        primaryKey = new PKIT_KhHubiMikaisyouList();
    }

    public GenIT_KhHubiMikaisyouList(
        String pJimutetuzukicd,
        String pSyono,
        C_HassinsakiKbn pHassinsakikbn
    ) {
        primaryKey = new PKIT_KhHubiMikaisyouList(
            pJimutetuzukicd,
            pSyono,
            pHassinsakikbn
        );
    }

    @Transient
    @Override
    public PKIT_KhHubiMikaisyouList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhHubiMikaisyouList> getMetaClass() {
        return QIT_KhHubiMikaisyouList.class;
    }

    @Id
    @Column(name=GenIT_KhHubiMikaisyouList.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return getPrimaryKey().getJimutetuzukicd();
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        getPrimaryKey().setJimutetuzukicd(pJimutetuzukicd);
    }

    @Id
    @Column(name=GenIT_KhHubiMikaisyouList.SYONO)
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
    @Type(type="UserType_C_HassinsakiKbn")
    @Column(name=GenIT_KhHubiMikaisyouList.HASSINSAKIKBN)
    public C_HassinsakiKbn getHassinsakikbn() {
        return getPrimaryKey().getHassinsakikbn();
    }

    public void setHassinsakikbn(C_HassinsakiKbn pHassinsakikbn) {
        getPrimaryKey().setHassinsakikbn(pHassinsakikbn);
    }

    private String kyknmkj;

    @Column(name=GenIT_KhHubiMikaisyouList.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private BizDate sksreadymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHubiMikaisyouList.SKSREADYMD)
    public BizDate getSksreadymd() {
        return sksreadymd;
    }

    public void setSksreadymd(BizDate pSksreadymd) {
        sksreadymd = pSksreadymd;
    }

    private C_UmuKbn genponhnkykumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KhHubiMikaisyouList.GENPONHNKYKUMU)
    public C_UmuKbn getGenponhnkykumu() {
        return genponhnkykumu;
    }

    public void setGenponhnkykumu(C_UmuKbn pGenponhnkykumu) {
        genponhnkykumu = pGenponhnkykumu;
    }

    private String hubitourokuktntnm;

    @Column(name=GenIT_KhHubiMikaisyouList.HUBITOUROKUKTNTNM)
    @InvalidCharacter
    public String getHubitourokuktntnm() {
        return hubitourokuktntnm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHubitourokuktntnm(String pHubitourokuktntnm) {
        hubitourokuktntnm = pHubitourokuktntnm;
    }

    private String hubisyouninktntnm;

    @Column(name=GenIT_KhHubiMikaisyouList.HUBISYOUNINKTNTNM)
    @InvalidCharacter
    public String getHubisyouninktntnm() {
        return hubisyouninktntnm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHubisyouninktntnm(String pHubisyouninktntnm) {
        hubisyouninktntnm = pHubisyouninktntnm;
    }

    private Integer hassinkaisuu;

    @Column(name=GenIT_KhHubiMikaisyouList.HASSINKAISUU)
    public Integer getHassinkaisuu() {
        return hassinkaisuu;
    }

    public void setHassinkaisuu(Integer pHassinkaisuu) {
        hassinkaisuu = pHassinkaisuu;
    }

    private BizDate fsthubbihasinymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHubiMikaisyouList.FSTHUBBIHASINYMD)
    public BizDate getFsthubbihasinymd() {
        return fsthubbihasinymd;
    }

    public void setFsthubbihasinymd(BizDate pFsthubbihasinymd) {
        fsthubbihasinymd = pFsthubbihasinymd;
    }

    private BizDate lasthubbihasinymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHubiMikaisyouList.LASTHUBBIHASINYMD)
    public BizDate getLasthubbihasinymd() {
        return lasthubbihasinymd;
    }

    public void setLasthubbihasinymd(BizDate pLasthubbihasinymd) {
        lasthubbihasinymd = pLasthubbihasinymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhHubiMikaisyouList.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhHubiMikaisyouList.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhHubiMikaisyouList.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}