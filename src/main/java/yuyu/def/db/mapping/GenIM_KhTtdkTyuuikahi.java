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
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.IM_KhTtdkTyuuikahi;
import yuyu.def.db.id.PKIM_KhTtdkTyuuikahi;
import yuyu.def.db.meta.GenQIM_KhTtdkTyuuikahi;
import yuyu.def.db.meta.QIM_KhTtdkTyuuikahi;
import yuyu.def.db.type.UserType_C_SyorikahiKbn;
import yuyu.def.db.type.UserType_C_TtdktyuuiKbn;

/**
 * 契約保全手続注意処理可否マスタ テーブルのマッピング情報クラスで、 {@link IM_KhTtdkTyuuikahi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhTtdkTyuuikahi}</td><td colspan="3">契約保全手続注意処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKIM_KhTtdkTyuuikahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn ttdktyuuikbn}</td><td>手続注意区分</td><td align="center">{@link PKIM_KhTtdkTyuuikahi ○}</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getSyorikahikbn syorikahikbn}</td><td>処理可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikahiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhTtdkTyuuikahi
 * @see     PKIM_KhTtdkTyuuikahi
 * @see     QIM_KhTtdkTyuuikahi
 * @see     GenQIM_KhTtdkTyuuikahi
 */
@MappedSuperclass
@Table(name=GenIM_KhTtdkTyuuikahi.TABLE_NAME)
@IdClass(value=PKIM_KhTtdkTyuuikahi.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SyorikahiKbn", typeClass=UserType_C_SyorikahiKbn.class),
    @TypeDef(name="UserType_C_TtdktyuuiKbn", typeClass=UserType_C_TtdktyuuiKbn.class)
})
public abstract class GenIM_KhTtdkTyuuikahi extends AbstractExDBEntity<IM_KhTtdkTyuuikahi, PKIM_KhTtdkTyuuikahi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_KhTtdkTyuuikahi";
    public static final String KINOUID                  = "kinouId";
    public static final String TTDKTYUUIKBN             = "ttdktyuuikbn";
    public static final String SYORIKAHIKBN             = "syorikahikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIM_KhTtdkTyuuikahi primaryKey;

    public GenIM_KhTtdkTyuuikahi() {
        primaryKey = new PKIM_KhTtdkTyuuikahi();
    }

    public GenIM_KhTtdkTyuuikahi(String pKinouId, C_TtdktyuuiKbn pTtdktyuuikbn) {
        primaryKey = new PKIM_KhTtdkTyuuikahi(pKinouId, pTtdktyuuikbn);
    }

    @Transient
    @Override
    public PKIM_KhTtdkTyuuikahi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_KhTtdkTyuuikahi> getMetaClass() {
        return QIM_KhTtdkTyuuikahi.class;
    }

    @Id
    @Column(name=GenIM_KhTtdkTyuuikahi.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenIM_KhTtdkTyuuikahi.TTDKTYUUIKBN)
    public C_TtdktyuuiKbn getTtdktyuuikbn() {
        return getPrimaryKey().getTtdktyuuikbn();
    }

    public void setTtdktyuuikbn(C_TtdktyuuiKbn pTtdktyuuikbn) {
        getPrimaryKey().setTtdktyuuikbn(pTtdktyuuikbn);
    }

    private C_SyorikahiKbn syorikahikbn;

    @Type(type="UserType_C_SyorikahiKbn")
    @Column(name=GenIM_KhTtdkTyuuikahi.SYORIKAHIKBN)
    public C_SyorikahiKbn getSyorikahikbn() {
        return syorikahikbn;
    }

    public void setSyorikahikbn(C_SyorikahiKbn pSyorikahikbn) {
        syorikahikbn = pSyorikahikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIM_KhTtdkTyuuikahi.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIM_KhTtdkTyuuikahi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIM_KhTtdkTyuuikahi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
