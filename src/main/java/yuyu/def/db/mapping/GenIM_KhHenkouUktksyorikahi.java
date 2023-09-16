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
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_KhHenkouUktksyorikahi;
import yuyu.def.db.id.PKIM_KhHenkouUktksyorikahi;
import yuyu.def.db.meta.GenQIM_KhHenkouUktksyorikahi;
import yuyu.def.db.meta.QIM_KhHenkouUktksyorikahi;
import yuyu.def.db.type.UserType_C_UktkSyoriKbn;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 契約保全変更受付中処理可否マスタ テーブルのマッピング情報クラスで、 {@link IM_KhHenkouUktksyorikahi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhHenkouUktksyorikahi}</td><td colspan="3">契約保全変更受付中処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKIM_KhHenkouUktksyorikahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktksyorikbn uktksyorikbn}</td><td>受付処理区分</td><td align="center">{@link PKIM_KhHenkouUktksyorikahi ○}</td><td align="center">V</td><td>{@link C_UktkSyoriKbn}</td></tr>
 *  <tr><td>{@link #getYuukoujyotaikahikbn yuukoujyotaikahikbn}</td><td>有効状態処理可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukoujyotaikahiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhHenkouUktksyorikahi
 * @see     PKIM_KhHenkouUktksyorikahi
 * @see     QIM_KhHenkouUktksyorikahi
 * @see     GenQIM_KhHenkouUktksyorikahi
 */
@MappedSuperclass
@Table(name=GenIM_KhHenkouUktksyorikahi.TABLE_NAME)
@IdClass(value=PKIM_KhHenkouUktksyorikahi.class)
@TypeDefs({
    @TypeDef(name="UserType_C_UktkSyoriKbn", typeClass=UserType_C_UktkSyoriKbn.class),
    @TypeDef(name="UserType_C_YuukoujyotaikahiKbn", typeClass=UserType_C_YuukoujyotaikahiKbn.class)
})
public abstract class GenIM_KhHenkouUktksyorikahi extends AbstractExDBEntity<IM_KhHenkouUktksyorikahi, PKIM_KhHenkouUktksyorikahi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_KhHenkouUktksyorikahi";
    public static final String KINOUID                  = "kinouId";
    public static final String UKTKSYORIKBN             = "uktksyorikbn";
    public static final String YUUKOUJYOTAIKAHIKBN      = "yuukoujyotaikahikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIM_KhHenkouUktksyorikahi primaryKey;

    public GenIM_KhHenkouUktksyorikahi() {
        primaryKey = new PKIM_KhHenkouUktksyorikahi();
    }

    public GenIM_KhHenkouUktksyorikahi(String pKinouId, C_UktkSyoriKbn pUktksyorikbn) {
        primaryKey = new PKIM_KhHenkouUktksyorikahi(pKinouId, pUktksyorikbn);
    }

    @Transient
    @Override
    public PKIM_KhHenkouUktksyorikahi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_KhHenkouUktksyorikahi> getMetaClass() {
        return QIM_KhHenkouUktksyorikahi.class;
    }

    @Id
    @Column(name=GenIM_KhHenkouUktksyorikahi.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Type(type="UserType_C_UktkSyoriKbn")
    @Column(name=GenIM_KhHenkouUktksyorikahi.UKTKSYORIKBN)
    public C_UktkSyoriKbn getUktksyorikbn() {
        return getPrimaryKey().getUktksyorikbn();
    }

    public void setUktksyorikbn(C_UktkSyoriKbn pUktksyorikbn) {
        getPrimaryKey().setUktksyorikbn(pUktksyorikbn);
    }

    private C_YuukoujyotaikahiKbn yuukoujyotaikahikbn;

    @Type(type="UserType_C_YuukoujyotaikahiKbn")
    @Column(name=GenIM_KhHenkouUktksyorikahi.YUUKOUJYOTAIKAHIKBN)
    public C_YuukoujyotaikahiKbn getYuukoujyotaikahikbn() {
        return yuukoujyotaikahikbn;
    }

    public void setYuukoujyotaikahikbn(C_YuukoujyotaikahiKbn pYuukoujyotaikahikbn) {
        yuukoujyotaikahikbn = pYuukoujyotaikahikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIM_KhHenkouUktksyorikahi.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIM_KhHenkouUktksyorikahi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIM_KhHenkouUktksyorikahi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}