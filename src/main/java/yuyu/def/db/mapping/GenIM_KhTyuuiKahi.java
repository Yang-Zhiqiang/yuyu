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
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.db.entity.IM_KhTyuuiKahi;
import yuyu.def.db.id.PKIM_KhTyuuiKahi;
import yuyu.def.db.meta.GenQIM_KhTyuuiKahi;
import yuyu.def.db.meta.QIM_KhTyuuiKahi;
import yuyu.def.db.type.UserType_C_SyorikahiKbn;

/**
 * 契約保全注意取扱処理可否マスタ テーブルのマッピング情報クラスで、 {@link IM_KhTyuuiKahi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhTyuuiKahi}</td><td colspan="3">契約保全注意取扱処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKIM_KhTyuuiKahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorikahikbn syorikahikbn}</td><td>処理可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikahiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhTyuuiKahi
 * @see     PKIM_KhTyuuiKahi
 * @see     QIM_KhTyuuiKahi
 * @see     GenQIM_KhTyuuiKahi
 */
@MappedSuperclass
@Table(name=GenIM_KhTyuuiKahi.TABLE_NAME)
@IdClass(value=PKIM_KhTyuuiKahi.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SyorikahiKbn", typeClass=UserType_C_SyorikahiKbn.class)
})
public abstract class GenIM_KhTyuuiKahi extends AbstractExDBEntity<IM_KhTyuuiKahi, PKIM_KhTyuuiKahi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_KhTyuuiKahi";
    public static final String KINOUID                  = "kinouId";
    public static final String SYORIKAHIKBN             = "syorikahikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIM_KhTyuuiKahi primaryKey;

    public GenIM_KhTyuuiKahi() {
        primaryKey = new PKIM_KhTyuuiKahi();
    }

    public GenIM_KhTyuuiKahi(String pKinouId) {
        primaryKey = new PKIM_KhTyuuiKahi(pKinouId);
    }

    @Transient
    @Override
    public PKIM_KhTyuuiKahi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_KhTyuuiKahi> getMetaClass() {
        return QIM_KhTyuuiKahi.class;
    }

    @Id
    @Column(name=GenIM_KhTyuuiKahi.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    private C_SyorikahiKbn syorikahikbn;

    @Type(type="UserType_C_SyorikahiKbn")
    @Column(name=GenIM_KhTyuuiKahi.SYORIKAHIKBN)
    public C_SyorikahiKbn getSyorikahikbn() {
        return syorikahikbn;
    }

    public void setSyorikahikbn(C_SyorikahiKbn pSyorikahikbn) {
        syorikahikbn = pSyorikahikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIM_KhTyuuiKahi.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIM_KhTyuuiKahi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIM_KhTyuuiKahi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
