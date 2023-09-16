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
import yuyu.def.db.entity.BM_Syonokanri;
import yuyu.def.db.id.PKBM_Syonokanri;
import yuyu.def.db.meta.GenQBM_Syonokanri;
import yuyu.def.db.meta.QBM_Syonokanri;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 証券番号管理マスタ テーブルのマッピング情報クラスで、 {@link BM_Syonokanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Syonokanri}</td><td colspan="3">証券番号管理マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSeirekinen2keta seirekinen2keta}</td><td>西暦年（２桁）</td><td align="center">{@link PKBM_Syonokanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuusosikicd bosyuusosikicd}</td><td>募集組織コード</td><td align="center">{@link PKBM_Syonokanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyonorenno syonorenno}</td><td>証券番号連番</td><td align="center">{@link PKBM_Syonokanri ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaibanymd saibanymd}</td><td>採番日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Syonokanri
 * @see     PKBM_Syonokanri
 * @see     QBM_Syonokanri
 * @see     GenQBM_Syonokanri
 */
@MappedSuperclass
@Table(name=GenBM_Syonokanri.TABLE_NAME)
@IdClass(value=PKBM_Syonokanri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenBM_Syonokanri extends AbstractExDBEntity<BM_Syonokanri, PKBM_Syonokanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Syonokanri";
    public static final String SEIREKINEN2KETA          = "seirekinen2keta";
    public static final String BOSYUUSOSIKICD           = "bosyuusosikicd";
    public static final String SYONORENNO               = "syonorenno";
    public static final String SYONO                    = "syono";
    public static final String MOSNO                    = "mosno";
    public static final String SAIBANYMD                = "saibanymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_Syonokanri primaryKey;

    public GenBM_Syonokanri() {
        primaryKey = new PKBM_Syonokanri();
    }

    public GenBM_Syonokanri(
        String pSeirekinen2keta,
        String pBosyuusosikicd,
        Integer pSyonorenno
    ) {
        primaryKey = new PKBM_Syonokanri(
            pSeirekinen2keta,
            pBosyuusosikicd,
            pSyonorenno
        );
    }

    @Transient
    @Override
    public PKBM_Syonokanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Syonokanri> getMetaClass() {
        return QBM_Syonokanri.class;
    }

    @Id
    @Column(name=GenBM_Syonokanri.SEIREKINEN2KETA)
    public String getSeirekinen2keta() {
        return getPrimaryKey().getSeirekinen2keta();
    }

    public void setSeirekinen2keta(String pSeirekinen2keta) {
        getPrimaryKey().setSeirekinen2keta(pSeirekinen2keta);
    }

    @Id
    @Column(name=GenBM_Syonokanri.BOSYUUSOSIKICD)
    public String getBosyuusosikicd() {
        return getPrimaryKey().getBosyuusosikicd();
    }

    public void setBosyuusosikicd(String pBosyuusosikicd) {
        getPrimaryKey().setBosyuusosikicd(pBosyuusosikicd);
    }

    @Id
    @Column(name=GenBM_Syonokanri.SYONORENNO)
    public Integer getSyonorenno() {
        return getPrimaryKey().getSyonorenno();
    }

    public void setSyonorenno(Integer pSyonorenno) {
        getPrimaryKey().setSyonorenno(pSyonorenno);
    }

    private String syono;

    @Column(name=GenBM_Syonokanri.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String mosno;

    @Column(name=GenBM_Syonokanri.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private BizDate saibanymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Syonokanri.SAIBANYMD)
    public BizDate getSaibanymd() {
        return saibanymd;
    }

    public void setSaibanymd(BizDate pSaibanymd) {
        saibanymd = pSaibanymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_Syonokanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_Syonokanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}