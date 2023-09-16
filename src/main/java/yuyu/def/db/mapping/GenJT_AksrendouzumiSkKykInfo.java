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
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.db.entity.JT_AksrendouzumiSkKykInfo;
import yuyu.def.db.id.PKJT_AksrendouzumiSkKykInfo;
import yuyu.def.db.meta.GenQJT_AksrendouzumiSkKykInfo;
import yuyu.def.db.meta.QJT_AksrendouzumiSkKykInfo;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＡＫＳ連動済請求契約情報テーブル テーブルのマッピング情報クラスで、 {@link JT_AksrendouzumiSkKykInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_AksrendouzumiSkKykInfo}</td><td colspan="3">ＡＫＳ連動済請求契約情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_AksrendouzumiSkKykInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_AksrendouzumiSkKykInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyubetu seikyuusyubetu}</td><td>請求種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>{@link #getShrkekkakbn shrkekkakbn}</td><td>支払結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrKekkaKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSibouymd sibouymd}</td><td>死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGeninkbn geninkbn}</td><td>原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GeninKbn}</td></tr>
 *  <tr><td>{@link #getSyoruiimagerendousuu syoruiimagerendousuu}</td><td>書類イメージ連動数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getAnkenimgjygntyoukahyj ankenimgjygntyoukahyj}</td><td>案件イメージ上限数超過表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTiffhenkankekkakbn tiffhenkankekkakbn}</td><td>ＴＩＦＦ変換結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_AksrendouzumiSkKykInfo
 * @see     PKJT_AksrendouzumiSkKykInfo
 * @see     QJT_AksrendouzumiSkKykInfo
 * @see     GenQJT_AksrendouzumiSkKykInfo
 */
@MappedSuperclass
@Table(name=GenJT_AksrendouzumiSkKykInfo.TABLE_NAME)
@IdClass(value=PKJT_AksrendouzumiSkKykInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_GeninKbn", typeClass=UserType_C_GeninKbn.class),
    @TypeDef(name="UserType_C_SeikyuuSyubetu", typeClass=UserType_C_SeikyuuSyubetu.class),
    @TypeDef(name="UserType_C_ShrKekkaKbn", typeClass=UserType_C_ShrKekkaKbn.class)
})
public abstract class GenJT_AksrendouzumiSkKykInfo extends AbstractExDBEntity<JT_AksrendouzumiSkKykInfo, PKJT_AksrendouzumiSkKykInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_AksrendouzumiSkKykInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUUSYUBETU           = "seikyuusyubetu";
    public static final String SHRKEKKAKBN              = "shrkekkakbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SIBOUYMD                 = "sibouymd";
    public static final String GENINKBN                 = "geninkbn";
    public static final String SYORUIIMAGERENDOUSUU     = "syoruiimagerendousuu";
    public static final String ANKENIMGJYGNTYOUKAHYJ    = "ankenimgjygntyoukahyj";
    public static final String TIFFHENKANKEKKAKBN       = "tiffhenkankekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_AksrendouzumiSkKykInfo primaryKey;

    public GenJT_AksrendouzumiSkKykInfo() {
        primaryKey = new PKJT_AksrendouzumiSkKykInfo();
    }

    public GenJT_AksrendouzumiSkKykInfo(String pSkno, String pSyono) {
        primaryKey = new PKJT_AksrendouzumiSkKykInfo(pSkno, pSyono);
    }

    @Transient
    @Override
    public PKJT_AksrendouzumiSkKykInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_AksrendouzumiSkKykInfo> getMetaClass() {
        return QJT_AksrendouzumiSkKykInfo.class;
    }

    @Id
    @Column(name=GenJT_AksrendouzumiSkKykInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_AksrendouzumiSkKykInfo.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    @Type(type="UserType_C_SeikyuuSyubetu")
    @Column(name=GenJT_AksrendouzumiSkKykInfo.SEIKYUUSYUBETU)
    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private C_ShrKekkaKbn shrkekkakbn;

    @Type(type="UserType_C_ShrKekkaKbn")
    @Column(name=GenJT_AksrendouzumiSkKykInfo.SHRKEKKAKBN)
    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenJT_AksrendouzumiSkKykInfo.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private BizDate sibouymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_AksrendouzumiSkKykInfo.SIBOUYMD)
    @ValidDate
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    private C_GeninKbn geninkbn;

    @Type(type="UserType_C_GeninKbn")
    @Column(name=GenJT_AksrendouzumiSkKykInfo.GENINKBN)
    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    private Integer syoruiimagerendousuu;

    @Column(name=GenJT_AksrendouzumiSkKykInfo.SYORUIIMAGERENDOUSUU)
    public Integer getSyoruiimagerendousuu() {
        return syoruiimagerendousuu;
    }

    public void setSyoruiimagerendousuu(Integer pSyoruiimagerendousuu) {
        syoruiimagerendousuu = pSyoruiimagerendousuu;
    }

    private String ankenimgjygntyoukahyj;

    @Column(name=GenJT_AksrendouzumiSkKykInfo.ANKENIMGJYGNTYOUKAHYJ)
    public String getAnkenimgjygntyoukahyj() {
        return ankenimgjygntyoukahyj;
    }

    public void setAnkenimgjygntyoukahyj(String pAnkenimgjygntyoukahyj) {
        ankenimgjygntyoukahyj = pAnkenimgjygntyoukahyj;
    }

    private String tiffhenkankekkakbn;

    @Column(name=GenJT_AksrendouzumiSkKykInfo.TIFFHENKANKEKKAKBN)
    public String getTiffhenkankekkakbn() {
        return tiffhenkankekkakbn;
    }

    public void setTiffhenkankekkakbn(String pTiffhenkankekkakbn) {
        tiffhenkankekkakbn = pTiffhenkankekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenJT_AksrendouzumiSkKykInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_AksrendouzumiSkKykInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_AksrendouzumiSkKykInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}