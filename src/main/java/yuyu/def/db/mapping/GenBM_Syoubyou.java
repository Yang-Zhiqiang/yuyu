package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoubyouCdTyuubunruiKbn;
import yuyu.def.db.entity.BM_Syoubyou;
import yuyu.def.db.id.PKBM_Syoubyou;
import yuyu.def.db.meta.GenQBM_Syoubyou;
import yuyu.def.db.meta.QBM_Syoubyou;
import yuyu.def.db.type.UserType_C_SyoubyouCdTyuubunruiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 傷病マスタ テーブルのマッピング情報クラスで、 {@link BM_Syoubyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Syoubyou}</td><td colspan="3">傷病マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoubyoucd syoubyoucd}</td><td>傷病コード</td><td align="center">{@link PKBM_Syoubyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoubyounm syoubyounm}</td><td>傷病名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoubyoucdtyuubunruikbn syoubyoucdtyuubunruikbn}</td><td>傷病コード中分類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoubyouCdTyuubunruiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Syoubyou
 * @see     PKBM_Syoubyou
 * @see     QBM_Syoubyou
 * @see     GenQBM_Syoubyou
 */
@MappedSuperclass
@Table(name=GenBM_Syoubyou.TABLE_NAME)
@IdClass(value=PKBM_Syoubyou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SyoubyouCdTyuubunruiKbn", typeClass=UserType_C_SyoubyouCdTyuubunruiKbn.class)
})
public abstract class GenBM_Syoubyou extends AbstractExDBEntity<BM_Syoubyou, PKBM_Syoubyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Syoubyou";
    public static final String SYOUBYOUCD               = "syoubyoucd";
    public static final String SYOUBYOUNM               = "syoubyounm";
    public static final String SYOUBYOUCDTYUUBUNRUIKBN  = "syoubyoucdtyuubunruikbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_Syoubyou primaryKey;

    public GenBM_Syoubyou() {
        primaryKey = new PKBM_Syoubyou();
    }

    public GenBM_Syoubyou(String pSyoubyoucd) {
        primaryKey = new PKBM_Syoubyou(pSyoubyoucd);
    }

    @Transient
    @Override
    public PKBM_Syoubyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Syoubyou> getMetaClass() {
        return QBM_Syoubyou.class;
    }

    @Id
    @Column(name=GenBM_Syoubyou.SYOUBYOUCD)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getSyoubyoucd() {
        return getPrimaryKey().getSyoubyoucd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoubyoucd(String pSyoubyoucd) {
        getPrimaryKey().setSyoubyoucd(pSyoubyoucd);
    }

    private String syoubyounm;

    @Column(name=GenBM_Syoubyou.SYOUBYOUNM)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoubyounm() {
        return syoubyounm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoubyounm(String pSyoubyounm) {
        syoubyounm = pSyoubyounm;
    }

    private C_SyoubyouCdTyuubunruiKbn syoubyoucdtyuubunruikbn;

    @Type(type="UserType_C_SyoubyouCdTyuubunruiKbn")
    @Column(name=GenBM_Syoubyou.SYOUBYOUCDTYUUBUNRUIKBN)
    public C_SyoubyouCdTyuubunruiKbn getSyoubyoucdtyuubunruikbn() {
        return syoubyoucdtyuubunruikbn;
    }

    public void setSyoubyoucdtyuubunruikbn(C_SyoubyouCdTyuubunruiKbn pSyoubyoucdtyuubunruikbn) {
        syoubyoucdtyuubunruikbn = pSyoubyoucdtyuubunruikbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_Syoubyou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_Syoubyou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}