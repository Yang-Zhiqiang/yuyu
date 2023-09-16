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
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_Syoumetukahi;
import yuyu.def.db.id.PKIM_Syoumetukahi;
import yuyu.def.db.meta.GenQIM_Syoumetukahi;
import yuyu.def.db.meta.QIM_Syoumetukahi;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 消滅状態処理可否マスタ テーブルのマッピング情報クラスで、 {@link IM_Syoumetukahi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_Syoumetukahi}</td><td colspan="3">消滅状態処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKIM_Syoumetukahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">{@link PKIM_Syoumetukahi ○}</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>{@link #getYuukoujyotaikahikbn yuukoujyotaikahikbn}</td><td>有効状態処理可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukoujyotaikahiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_Syoumetukahi
 * @see     PKIM_Syoumetukahi
 * @see     QIM_Syoumetukahi
 * @see     GenQIM_Syoumetukahi
 */
@MappedSuperclass
@Table(name=GenIM_Syoumetukahi.TABLE_NAME)
@IdClass(value=PKIM_Syoumetukahi.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Syoumetujiyuu", typeClass=UserType_C_Syoumetujiyuu.class),
    @TypeDef(name="UserType_C_YuukoujyotaikahiKbn", typeClass=UserType_C_YuukoujyotaikahiKbn.class)
})
public abstract class GenIM_Syoumetukahi extends AbstractExDBEntity<IM_Syoumetukahi, PKIM_Syoumetukahi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_Syoumetukahi";
    public static final String KINOUID                  = "kinouId";
    public static final String SYOUMETUJIYUU            = "syoumetujiyuu";
    public static final String YUUKOUJYOTAIKAHIKBN      = "yuukoujyotaikahikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIM_Syoumetukahi primaryKey;

    public GenIM_Syoumetukahi() {
        primaryKey = new PKIM_Syoumetukahi();
    }

    public GenIM_Syoumetukahi(String pKinouId, C_Syoumetujiyuu pSyoumetujiyuu) {
        primaryKey = new PKIM_Syoumetukahi(pKinouId, pSyoumetujiyuu);
    }

    @Transient
    @Override
    public PKIM_Syoumetukahi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_Syoumetukahi> getMetaClass() {
        return QIM_Syoumetukahi.class;
    }

    @Id
    @Column(name=GenIM_Syoumetukahi.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Type(type="UserType_C_Syoumetujiyuu")
    @Column(name=GenIM_Syoumetukahi.SYOUMETUJIYUU)
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return getPrimaryKey().getSyoumetujiyuu();
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        getPrimaryKey().setSyoumetujiyuu(pSyoumetujiyuu);
    }

    private C_YuukoujyotaikahiKbn yuukoujyotaikahikbn;

    @Type(type="UserType_C_YuukoujyotaikahiKbn")
    @Column(name=GenIM_Syoumetukahi.YUUKOUJYOTAIKAHIKBN)
    public C_YuukoujyotaikahiKbn getYuukoujyotaikahikbn() {
        return yuukoujyotaikahikbn;
    }

    public void setYuukoujyotaikahikbn(C_YuukoujyotaikahiKbn pYuukoujyotaikahikbn) {
        yuukoujyotaikahikbn = pYuukoujyotaikahikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIM_Syoumetukahi.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIM_Syoumetukahi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIM_Syoumetukahi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
