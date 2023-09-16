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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_TanmatuSyuruiKbn;
import yuyu.def.db.entity.JT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.id.PKJT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.meta.GenQJT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.meta.QJT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.type.UserType_C_TanmatuSyuruiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金給付金迅速支払手続情報テーブル テーブルのマッピング情報クラスで、 {@link JT_SiJinsokuShrTtdkInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiJinsokuShrTtdkInfo}</td><td colspan="3">保険金給付金迅速支払手続情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">{@link PKJT_SiJinsokuShrTtdkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">{@link PKJT_SiJinsokuShrTtdkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknknshrsntkno hknknshrsntkno}</td><td>保険金支払処理選択番号</td><td align="center">{@link PKJT_SiJinsokuShrTtdkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">{@link PKJT_SiJinsokuShrTtdkInfo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKJT_SiJinsokuShrTtdkInfo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">{@link PKJT_SiJinsokuShrTtdkInfo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoruikeikaeigyoubisuu syoruikeikaeigyoubisuu}</td><td>書類受付経過営業日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyorikeikaeigyoubisuu syorikeikaeigyoubisuu}</td><td>処理経過営業日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getToritugisosikicd toritugisosikicd}</td><td>取次組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTanmatusyuruikbn tanmatusyuruikbn}</td><td>端末種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TanmatuSyuruiKbn}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiJinsokuShrTtdkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiJinsokuShrTtdkInfo
 * @see     PKJT_SiJinsokuShrTtdkInfo
 * @see     QJT_SiJinsokuShrTtdkInfo
 * @see     GenQJT_SiJinsokuShrTtdkInfo
 */
@MappedSuperclass
@Table(name=GenJT_SiJinsokuShrTtdkInfo.TABLE_NAME)
@IdClass(value=PKJT_SiJinsokuShrTtdkInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_TanmatuSyuruiKbn", typeClass=UserType_C_TanmatuSyuruiKbn.class)
})
public abstract class GenJT_SiJinsokuShrTtdkInfo extends AbstractExDBEntity<JT_SiJinsokuShrTtdkInfo, PKJT_SiJinsokuShrTtdkInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiJinsokuShrTtdkInfo";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String SYORICD                  = "syoricd";
    public static final String HKNKNSHRSNTKNO           = "hknknshrsntkno";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String DENYMD                   = "denymd";
    public static final String SYORUIKEIKAEIGYOUBISUU   = "syoruikeikaeigyoubisuu";
    public static final String SYORIKEIKAEIGYOUBISUU    = "syorikeikaeigyoubisuu";
    public static final String TORITUGISOSIKICD         = "toritugisosikicd";
    public static final String TANMATUSYURUIKBN         = "tanmatusyuruikbn";
    public static final String SYONO                    = "syono";
    public static final String KYKYMD                   = "kykymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiJinsokuShrTtdkInfo primaryKey;

    public GenJT_SiJinsokuShrTtdkInfo() {
        primaryKey = new PKJT_SiJinsokuShrTtdkInfo();
    }

    public GenJT_SiJinsokuShrTtdkInfo(
        String pSyorisosikicd,
        String pSyoricd,
        String pHknknshrsntkno,
        BizDate pSyoruiukeymd,
        BizDate pSyoriYmd,
        BizDate pDenymd,
        String pSyono
    ) {
        primaryKey = new PKJT_SiJinsokuShrTtdkInfo(
            pSyorisosikicd,
            pSyoricd,
            pHknknshrsntkno,
            pSyoruiukeymd,
            pSyoriYmd,
            pDenymd,
            pSyono
        );
    }

    @Transient
    @Override
    public PKJT_SiJinsokuShrTtdkInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiJinsokuShrTtdkInfo> getMetaClass() {
        return QJT_SiJinsokuShrTtdkInfo.class;
    }

    @Id
    @Column(name=GenJT_SiJinsokuShrTtdkInfo.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return getPrimaryKey().getSyorisosikicd();
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        getPrimaryKey().setSyorisosikicd(pSyorisosikicd);
    }

    @Id
    @Column(name=GenJT_SiJinsokuShrTtdkInfo.SYORICD)
    public String getSyoricd() {
        return getPrimaryKey().getSyoricd();
    }

    public void setSyoricd(String pSyoricd) {
        getPrimaryKey().setSyoricd(pSyoricd);
    }

    @Id
    @Column(name=GenJT_SiJinsokuShrTtdkInfo.HKNKNSHRSNTKNO)
    public String getHknknshrsntkno() {
        return getPrimaryKey().getHknknshrsntkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknknshrsntkno(String pHknknshrsntkno) {
        getPrimaryKey().setHknknshrsntkno(pHknknshrsntkno);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenJT_SiJinsokuShrTtdkInfo.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return getPrimaryKey().getSyoruiukeymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        getPrimaryKey().setSyoruiukeymd(pSyoruiukeymd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenJT_SiJinsokuShrTtdkInfo.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenJT_SiJinsokuShrTtdkInfo.DENYMD)
    public BizDate getDenymd() {
        return getPrimaryKey().getDenymd();
    }

    public void setDenymd(BizDate pDenymd) {
        getPrimaryKey().setDenymd(pDenymd);
    }

    private Integer syoruikeikaeigyoubisuu;

    @Column(name=GenJT_SiJinsokuShrTtdkInfo.SYORUIKEIKAEIGYOUBISUU)
    public Integer getSyoruikeikaeigyoubisuu() {
        return syoruikeikaeigyoubisuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruikeikaeigyoubisuu(Integer pSyoruikeikaeigyoubisuu) {
        syoruikeikaeigyoubisuu = pSyoruikeikaeigyoubisuu;
    }

    private Integer syorikeikaeigyoubisuu;

    @Column(name=GenJT_SiJinsokuShrTtdkInfo.SYORIKEIKAEIGYOUBISUU)
    public Integer getSyorikeikaeigyoubisuu() {
        return syorikeikaeigyoubisuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyorikeikaeigyoubisuu(Integer pSyorikeikaeigyoubisuu) {
        syorikeikaeigyoubisuu = pSyorikeikaeigyoubisuu;
    }

    private String toritugisosikicd;

    @Column(name=GenJT_SiJinsokuShrTtdkInfo.TORITUGISOSIKICD)
    public String getToritugisosikicd() {
        return toritugisosikicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setToritugisosikicd(String pToritugisosikicd) {
        toritugisosikicd = pToritugisosikicd;
    }

    private C_TanmatuSyuruiKbn tanmatusyuruikbn;

    @Type(type="UserType_C_TanmatuSyuruiKbn")
    @Column(name=GenJT_SiJinsokuShrTtdkInfo.TANMATUSYURUIKBN)
    public C_TanmatuSyuruiKbn getTanmatusyuruikbn() {
        return tanmatusyuruikbn;
    }

    public void setTanmatusyuruikbn(C_TanmatuSyuruiKbn pTanmatusyuruikbn) {
        tanmatusyuruikbn = pTanmatusyuruikbn;
    }

    @Id
    @Column(name=GenJT_SiJinsokuShrTtdkInfo.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiJinsokuShrTtdkInfo.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenJT_SiJinsokuShrTtdkInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiJinsokuShrTtdkInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiJinsokuShrTtdkInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}