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
import yuyu.def.db.entity.BM_Syokugyou;
import yuyu.def.db.id.PKBM_Syokugyou;
import yuyu.def.db.meta.GenQBM_Syokugyou;
import yuyu.def.db.meta.QBM_Syokugyou;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 職業マスタ テーブルのマッピング情報クラスで、 {@link BM_Syokugyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Syokugyou}</td><td colspan="3">職業マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyokugyoucd syokugyoucd}</td><td>職業コード</td><td align="center">{@link PKBM_Syokugyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyokugyounm syokugyounm}</td><td>職業名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Syokugyou
 * @see     PKBM_Syokugyou
 * @see     QBM_Syokugyou
 * @see     GenQBM_Syokugyou
 */
@MappedSuperclass
@Table(name=GenBM_Syokugyou.TABLE_NAME)
@IdClass(value=PKBM_Syokugyou.class)
public abstract class GenBM_Syokugyou extends AbstractExDBEntity<BM_Syokugyou, PKBM_Syokugyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Syokugyou";
    public static final String SYOKUGYOUCD              = "syokugyoucd";
    public static final String SYOKUGYOUNM              = "syokugyounm";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_Syokugyou primaryKey;

    public GenBM_Syokugyou() {
        primaryKey = new PKBM_Syokugyou();
    }

    public GenBM_Syokugyou(String pSyokugyoucd) {
        primaryKey = new PKBM_Syokugyou(pSyokugyoucd);
    }

    @Transient
    @Override
    public PKBM_Syokugyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Syokugyou> getMetaClass() {
        return QBM_Syokugyou.class;
    }

    @Id
    @Column(name=GenBM_Syokugyou.SYOKUGYOUCD)
    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    public String getSyokugyoucd() {
        return getPrimaryKey().getSyokugyoucd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyokugyoucd(String pSyokugyoucd) {
        getPrimaryKey().setSyokugyoucd(pSyokugyoucd);
    }

    private String syokugyounm;

    @Column(name=GenBM_Syokugyou.SYOKUGYOUNM)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyokugyounm() {
        return syokugyounm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSyokugyounm(String pSyokugyounm) {
        syokugyounm = pSyokugyounm;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_Syokugyou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_Syokugyou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}