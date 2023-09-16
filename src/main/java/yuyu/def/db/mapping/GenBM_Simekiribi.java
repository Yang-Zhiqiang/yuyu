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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_Simekiribi;
import yuyu.def.db.id.PKBM_Simekiribi;
import yuyu.def.db.meta.GenQBM_Simekiribi;
import yuyu.def.db.meta.QBM_Simekiribi;

/**
 * 締切日マスタ テーブルのマッピング情報クラスで、 {@link BM_Simekiribi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Simekiribi}</td><td colspan="3">締切日マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">{@link PKBM_Simekiribi ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMossimefromymd mossimefromymd}</td><td>申込締切日自</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMossimetoymd mossimetoymd}</td><td>申込締切日至</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosnrksimefromymd mosnrksimefromymd}</td><td>申込書入力締切日自</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosnrksimetoymd mosnrksimetoymd}</td><td>申込書入力締切日至</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKktsimefromymd kktsimefromymd}</td><td>告知締切日自</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKktsimetoymd kktsimetoymd}</td><td>告知締切日至</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHjysimefromymd hjysimefromymd}</td><td>報状締切日自</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHjysimetoymd hjysimetoymd}</td><td>報状締切日至</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyknsimefromymd nyknsimefromymd}</td><td>入金締切日自</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyknsimetoymd nyknsimetoymd}</td><td>入金締切日至</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyorisimefromymd syorisimefromymd}</td><td>処理締切日自</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyorisimetoymd syorisimetoymd}</td><td>処理締切日至</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Simekiribi
 * @see     PKBM_Simekiribi
 * @see     QBM_Simekiribi
 * @see     GenQBM_Simekiribi
 */
@MappedSuperclass
@Table(name=GenBM_Simekiribi.TABLE_NAME)
@IdClass(value=PKBM_Simekiribi.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class)
})
public abstract class GenBM_Simekiribi extends AbstractExDBEntity<BM_Simekiribi, PKBM_Simekiribi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Simekiribi";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String MOSSIMEFROMYMD           = "mossimefromymd";
    public static final String MOSSIMETOYMD             = "mossimetoymd";
    public static final String MOSNRKSIMEFROMYMD        = "mosnrksimefromymd";
    public static final String MOSNRKSIMETOYMD          = "mosnrksimetoymd";
    public static final String KKTSIMEFROMYMD           = "kktsimefromymd";
    public static final String KKTSIMETOYMD             = "kktsimetoymd";
    public static final String HJYSIMEFROMYMD           = "hjysimefromymd";
    public static final String HJYSIMETOYMD             = "hjysimetoymd";
    public static final String NYKNSIMEFROMYMD          = "nyknsimefromymd";
    public static final String NYKNSIMETOYMD            = "nyknsimetoymd";
    public static final String SYORISIMEFROMYMD         = "syorisimefromymd";
    public static final String SYORISIMETOYMD           = "syorisimetoymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_Simekiribi primaryKey;

    public GenBM_Simekiribi() {
        primaryKey = new PKBM_Simekiribi();
    }

    public GenBM_Simekiribi(BizDateYM pBosyuuym) {
        primaryKey = new PKBM_Simekiribi(pBosyuuym);
    }

    @Transient
    @Override
    public PKBM_Simekiribi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Simekiribi> getMetaClass() {
        return QBM_Simekiribi.class;
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenBM_Simekiribi.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return getPrimaryKey().getBosyuuym();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        getPrimaryKey().setBosyuuym(pBosyuuym);
    }

    private BizDate mossimefromymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.MOSSIMEFROMYMD)
    @ValidDate
    public BizDate getMossimefromymd() {
        return mossimefromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMossimefromymd(BizDate pMossimefromymd) {
        mossimefromymd = pMossimefromymd;
    }

    private BizDate mossimetoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.MOSSIMETOYMD)
    @ValidDate
    public BizDate getMossimetoymd() {
        return mossimetoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMossimetoymd(BizDate pMossimetoymd) {
        mossimetoymd = pMossimetoymd;
    }

    private BizDate mosnrksimefromymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.MOSNRKSIMEFROMYMD)
    @ValidDate
    public BizDate getMosnrksimefromymd() {
        return mosnrksimefromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosnrksimefromymd(BizDate pMosnrksimefromymd) {
        mosnrksimefromymd = pMosnrksimefromymd;
    }

    private BizDate mosnrksimetoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.MOSNRKSIMETOYMD)
    @ValidDate
    public BizDate getMosnrksimetoymd() {
        return mosnrksimetoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosnrksimetoymd(BizDate pMosnrksimetoymd) {
        mosnrksimetoymd = pMosnrksimetoymd;
    }

    private BizDate kktsimefromymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.KKTSIMEFROMYMD)
    @ValidDate
    public BizDate getKktsimefromymd() {
        return kktsimefromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktsimefromymd(BizDate pKktsimefromymd) {
        kktsimefromymd = pKktsimefromymd;
    }

    private BizDate kktsimetoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.KKTSIMETOYMD)
    @ValidDate
    public BizDate getKktsimetoymd() {
        return kktsimetoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktsimetoymd(BizDate pKktsimetoymd) {
        kktsimetoymd = pKktsimetoymd;
    }

    private BizDate hjysimefromymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.HJYSIMEFROMYMD)
    @ValidDate
    public BizDate getHjysimefromymd() {
        return hjysimefromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHjysimefromymd(BizDate pHjysimefromymd) {
        hjysimefromymd = pHjysimefromymd;
    }

    private BizDate hjysimetoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.HJYSIMETOYMD)
    @ValidDate
    public BizDate getHjysimetoymd() {
        return hjysimetoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHjysimetoymd(BizDate pHjysimetoymd) {
        hjysimetoymd = pHjysimetoymd;
    }

    private BizDate nyknsimefromymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.NYKNSIMEFROMYMD)
    @ValidDate
    public BizDate getNyknsimefromymd() {
        return nyknsimefromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNyknsimefromymd(BizDate pNyknsimefromymd) {
        nyknsimefromymd = pNyknsimefromymd;
    }

    private BizDate nyknsimetoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.NYKNSIMETOYMD)
    @ValidDate
    public BizDate getNyknsimetoymd() {
        return nyknsimetoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNyknsimetoymd(BizDate pNyknsimetoymd) {
        nyknsimetoymd = pNyknsimetoymd;
    }

    private BizDate syorisimefromymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.SYORISIMEFROMYMD)
    @ValidDate
    public BizDate getSyorisimefromymd() {
        return syorisimefromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyorisimefromymd(BizDate pSyorisimefromymd) {
        syorisimefromymd = pSyorisimefromymd;
    }

    private BizDate syorisimetoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Simekiribi.SYORISIMETOYMD)
    @ValidDate
    public BizDate getSyorisimetoymd() {
        return syorisimetoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyorisimetoymd(BizDate pSyorisimetoymd) {
        syorisimetoymd = pSyorisimetoymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_Simekiribi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_Simekiribi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
