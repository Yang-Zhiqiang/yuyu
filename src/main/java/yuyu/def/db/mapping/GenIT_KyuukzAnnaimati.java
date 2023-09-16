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
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.IT_KyuukzAnnaimati;
import yuyu.def.db.id.PKIT_KyuukzAnnaimati;
import yuyu.def.db.meta.GenQIT_KyuukzAnnaimati;
import yuyu.def.db.meta.QIT_KyuukzAnnaimati;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 旧口座案内待ちテーブル テーブルのマッピング情報クラスで、 {@link IT_KyuukzAnnaimati} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KyuukzAnnaimati}</td><td colspan="3">旧口座案内待ちテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIT_KyuukzAnnaimati ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorizumiflg syorizumiflg}</td><td>処理済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syorizumiflg}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KyuukzAnnaimati
 * @see     PKIT_KyuukzAnnaimati
 * @see     QIT_KyuukzAnnaimati
 * @see     GenQIT_KyuukzAnnaimati
 */
@MappedSuperclass
@Table(name=GenIT_KyuukzAnnaimati.TABLE_NAME)
@IdClass(value=PKIT_KyuukzAnnaimati.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Syorizumiflg", typeClass=UserType_C_Syorizumiflg.class)
})
public abstract class GenIT_KyuukzAnnaimati extends AbstractExDBEntity<IT_KyuukzAnnaimati, PKIT_KyuukzAnnaimati> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KyuukzAnnaimati";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SYORIZUMIFLG             = "syorizumiflg";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KyuukzAnnaimati primaryKey;

    public GenIT_KyuukzAnnaimati() {
        primaryKey = new PKIT_KyuukzAnnaimati();
    }

    public GenIT_KyuukzAnnaimati(String pKouteikanriid) {
        primaryKey = new PKIT_KyuukzAnnaimati(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIT_KyuukzAnnaimati getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KyuukzAnnaimati> getMetaClass() {
        return QIT_KyuukzAnnaimati.class;
    }

    @Id
    @Column(name=GenIT_KyuukzAnnaimati.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIT_KyuukzAnnaimati.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_Syorizumiflg syorizumiflg;

    @Type(type="UserType_C_Syorizumiflg")
    @Column(name=GenIT_KyuukzAnnaimati.SYORIZUMIFLG)
    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KyuukzAnnaimati.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KyuukzAnnaimati.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KyuukzAnnaimati.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}