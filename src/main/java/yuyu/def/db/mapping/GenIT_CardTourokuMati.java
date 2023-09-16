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
import yuyu.def.db.entity.IT_CardTourokuMati;
import yuyu.def.db.id.PKIT_CardTourokuMati;
import yuyu.def.db.meta.GenQIT_CardTourokuMati;
import yuyu.def.db.meta.QIT_CardTourokuMati;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * カード情報登録待ちテーブル テーブルのマッピング情報クラスで、 {@link IT_CardTourokuMati} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_CardTourokuMati}</td><td colspan="3">カード情報登録待ちテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIT_CardTourokuMati ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorizumiflg syorizumiflg}</td><td>処理済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syorizumiflg}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_CardTourokuMati
 * @see     PKIT_CardTourokuMati
 * @see     QIT_CardTourokuMati
 * @see     GenQIT_CardTourokuMati
 */
@MappedSuperclass
@Table(name=GenIT_CardTourokuMati.TABLE_NAME)
@IdClass(value=PKIT_CardTourokuMati.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Syorizumiflg", typeClass=UserType_C_Syorizumiflg.class)
})
public abstract class GenIT_CardTourokuMati extends AbstractExDBEntity<IT_CardTourokuMati, PKIT_CardTourokuMati> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_CardTourokuMati";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String SYORIZUMIFLG             = "syorizumiflg";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_CardTourokuMati primaryKey;

    public GenIT_CardTourokuMati() {
        primaryKey = new PKIT_CardTourokuMati();
    }

    public GenIT_CardTourokuMati(String pKouteikanriid) {
        primaryKey = new PKIT_CardTourokuMati(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIT_CardTourokuMati getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_CardTourokuMati> getMetaClass() {
        return QIT_CardTourokuMati.class;
    }

    @Id
    @Column(name=GenIT_CardTourokuMati.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIT_CardTourokuMati.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String creditkessaiyouno;

    @Column(name=GenIT_CardTourokuMati.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    private C_Syorizumiflg syorizumiflg;

    @Type(type="UserType_C_Syorizumiflg")
    @Column(name=GenIT_CardTourokuMati.SYORIZUMIFLG)
    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_CardTourokuMati.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_CardTourokuMati.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_CardTourokuMati.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}