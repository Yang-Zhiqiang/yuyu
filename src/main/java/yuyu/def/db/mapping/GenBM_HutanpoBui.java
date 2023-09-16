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
import yuyu.def.db.entity.BM_HutanpoBui;
import yuyu.def.db.id.PKBM_HutanpoBui;
import yuyu.def.db.meta.GenQBM_HutanpoBui;
import yuyu.def.db.meta.QBM_HutanpoBui;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 不担保部位マスタ テーブルのマッピング情報クラスで、 {@link BM_HutanpoBui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_HutanpoBui}</td><td colspan="3">不担保部位マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHtnpbuicd htnpbuicd}</td><td>不担保部位コード</td><td align="center">{@link PKBM_HutanpoBui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpbuinm htnpbuinm}</td><td>不担保部位名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_HutanpoBui
 * @see     PKBM_HutanpoBui
 * @see     QBM_HutanpoBui
 * @see     GenQBM_HutanpoBui
 */
@MappedSuperclass
@Table(name=GenBM_HutanpoBui.TABLE_NAME)
@IdClass(value=PKBM_HutanpoBui.class)
public abstract class GenBM_HutanpoBui extends AbstractExDBEntity<BM_HutanpoBui, PKBM_HutanpoBui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_HutanpoBui";
    public static final String HTNPBUICD                = "htnpbuicd";
    public static final String HTNPBUINM                = "htnpbuinm";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_HutanpoBui primaryKey;

    public GenBM_HutanpoBui() {
        primaryKey = new PKBM_HutanpoBui();
    }

    public GenBM_HutanpoBui(String pHtnpbuicd) {
        primaryKey = new PKBM_HutanpoBui(pHtnpbuicd);
    }

    @Transient
    @Override
    public PKBM_HutanpoBui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_HutanpoBui> getMetaClass() {
        return QBM_HutanpoBui.class;
    }

    @Id
    @Column(name=GenBM_HutanpoBui.HTNPBUICD)
    @MaxLength(max=3)
    @AlphaDigit
    public String getHtnpbuicd() {
        return getPrimaryKey().getHtnpbuicd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtnpbuicd(String pHtnpbuicd) {
        getPrimaryKey().setHtnpbuicd(pHtnpbuicd);
    }

    private String htnpbuinm;

    @Column(name=GenBM_HutanpoBui.HTNPBUINM)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHtnpbuinm() {
        return htnpbuinm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHtnpbuinm(String pHtnpbuinm) {
        htnpbuinm = pHtnpbuinm;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_HutanpoBui.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_HutanpoBui.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
