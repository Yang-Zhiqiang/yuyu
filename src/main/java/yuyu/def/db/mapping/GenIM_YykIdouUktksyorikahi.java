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
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_YykIdouUktksyorikahi;
import yuyu.def.db.id.PKIM_YykIdouUktksyorikahi;
import yuyu.def.db.meta.GenQIM_YykIdouUktksyorikahi;
import yuyu.def.db.meta.QIM_YykIdouUktksyorikahi;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 予約異動受付中処理可否マスタ テーブルのマッピング情報クラスで、 {@link IM_YykIdouUktksyorikahi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_YykIdouUktksyorikahi}</td><td colspan="3">予約異動受付中処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKIM_YykIdouUktksyorikahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYykuktkkinouid yykuktkkinouid}</td><td>予約受付中機能ＩＤ</td><td align="center">{@link PKIM_YykIdouUktksyorikahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYuukoujyotaikahikbn yuukoujyotaikahikbn}</td><td>有効状態処理可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukoujyotaikahiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_YykIdouUktksyorikahi
 * @see     PKIM_YykIdouUktksyorikahi
 * @see     QIM_YykIdouUktksyorikahi
 * @see     GenQIM_YykIdouUktksyorikahi
 */
@MappedSuperclass
@Table(name=GenIM_YykIdouUktksyorikahi.TABLE_NAME)
@IdClass(value=PKIM_YykIdouUktksyorikahi.class)
@TypeDefs({
    @TypeDef(name="UserType_C_YuukoujyotaikahiKbn", typeClass=UserType_C_YuukoujyotaikahiKbn.class)
})
public abstract class GenIM_YykIdouUktksyorikahi extends AbstractExDBEntity<IM_YykIdouUktksyorikahi, PKIM_YykIdouUktksyorikahi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_YykIdouUktksyorikahi";
    public static final String KINOUID                  = "kinouId";
    public static final String YYKUKTKKINOUID           = "yykuktkkinouid";
    public static final String YUUKOUJYOTAIKAHIKBN      = "yuukoujyotaikahikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIM_YykIdouUktksyorikahi primaryKey;

    public GenIM_YykIdouUktksyorikahi() {
        primaryKey = new PKIM_YykIdouUktksyorikahi();
    }

    public GenIM_YykIdouUktksyorikahi(String pKinouId, String pYykuktkkinouid) {
        primaryKey = new PKIM_YykIdouUktksyorikahi(pKinouId, pYykuktkkinouid);
    }

    @Transient
    @Override
    public PKIM_YykIdouUktksyorikahi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_YykIdouUktksyorikahi> getMetaClass() {
        return QIM_YykIdouUktksyorikahi.class;
    }

    @Id
    @Column(name=GenIM_YykIdouUktksyorikahi.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Column(name=GenIM_YykIdouUktksyorikahi.YYKUKTKKINOUID)
    public String getYykuktkkinouid() {
        return getPrimaryKey().getYykuktkkinouid();
    }

    public void setYykuktkkinouid(String pYykuktkkinouid) {
        getPrimaryKey().setYykuktkkinouid(pYykuktkkinouid);
    }

    private C_YuukoujyotaikahiKbn yuukoujyotaikahikbn;

    @Type(type="UserType_C_YuukoujyotaikahiKbn")
    @Column(name=GenIM_YykIdouUktksyorikahi.YUUKOUJYOTAIKAHIKBN)
    public C_YuukoujyotaikahiKbn getYuukoujyotaikahikbn() {
        return yuukoujyotaikahikbn;
    }

    public void setYuukoujyotaikahikbn(C_YuukoujyotaikahiKbn pYuukoujyotaikahikbn) {
        yuukoujyotaikahikbn = pYuukoujyotaikahikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIM_YykIdouUktksyorikahi.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIM_YykIdouUktksyorikahi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIM_YykIdouUktksyorikahi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
