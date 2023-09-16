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
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.id.PKIM_Syorijtkahi;
import yuyu.def.db.meta.GenQIM_Syorijtkahi;
import yuyu.def.db.meta.QIM_Syorijtkahi;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 処理状態処理可否マスタ テーブルのマッピング情報クラスで、 {@link IM_Syorijtkahi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_Syorijtkahi}</td><td colspan="3">処理状態処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKIM_Syorijtkahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorijimuttdkcd syorijimuttdkcd}</td><td>処理中事務手続コード</td><td align="center">{@link PKIM_Syorijtkahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoritaskid syoritaskid}</td><td>処理中タスクＩＤ</td><td align="center">{@link PKIM_Syorijtkahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYuukoujyotaikahikbn yuukoujyotaikahikbn}</td><td>有効状態処理可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukoujyotaikahiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_Syorijtkahi
 * @see     PKIM_Syorijtkahi
 * @see     QIM_Syorijtkahi
 * @see     GenQIM_Syorijtkahi
 */
@MappedSuperclass
@Table(name=GenIM_Syorijtkahi.TABLE_NAME)
@IdClass(value=PKIM_Syorijtkahi.class)
@TypeDefs({
    @TypeDef(name="UserType_C_YuukoujyotaikahiKbn", typeClass=UserType_C_YuukoujyotaikahiKbn.class)
})
public abstract class GenIM_Syorijtkahi extends AbstractExDBEntity<IM_Syorijtkahi, PKIM_Syorijtkahi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_Syorijtkahi";
    public static final String KINOUID                  = "kinouId";
    public static final String SYORIJIMUTTDKCD          = "syorijimuttdkcd";
    public static final String SYORITASKID              = "syoritaskid";
    public static final String YUUKOUJYOTAIKAHIKBN      = "yuukoujyotaikahikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIM_Syorijtkahi primaryKey;

    public GenIM_Syorijtkahi() {
        primaryKey = new PKIM_Syorijtkahi();
    }

    public GenIM_Syorijtkahi(
        String pKinouId,
        String pSyorijimuttdkcd,
        String pSyoritaskid
    ) {
        primaryKey = new PKIM_Syorijtkahi(
            pKinouId,
            pSyorijimuttdkcd,
            pSyoritaskid
        );
    }

    @Transient
    @Override
    public PKIM_Syorijtkahi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_Syorijtkahi> getMetaClass() {
        return QIM_Syorijtkahi.class;
    }

    @Id
    @Column(name=GenIM_Syorijtkahi.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Column(name=GenIM_Syorijtkahi.SYORIJIMUTTDKCD)
    public String getSyorijimuttdkcd() {
        return getPrimaryKey().getSyorijimuttdkcd();
    }

    public void setSyorijimuttdkcd(String pSyorijimuttdkcd) {
        getPrimaryKey().setSyorijimuttdkcd(pSyorijimuttdkcd);
    }

    @Id
    @Column(name=GenIM_Syorijtkahi.SYORITASKID)
    public String getSyoritaskid() {
        return getPrimaryKey().getSyoritaskid();
    }

    public void setSyoritaskid(String pSyoritaskid) {
        getPrimaryKey().setSyoritaskid(pSyoritaskid);
    }

    private C_YuukoujyotaikahiKbn yuukoujyotaikahikbn;

    @Type(type="UserType_C_YuukoujyotaikahiKbn")
    @Column(name=GenIM_Syorijtkahi.YUUKOUJYOTAIKAHIKBN)
    public C_YuukoujyotaikahiKbn getYuukoujyotaikahikbn() {
        return yuukoujyotaikahikbn;
    }

    public void setYuukoujyotaikahikbn(C_YuukoujyotaikahiKbn pYuukoujyotaikahikbn) {
        yuukoujyotaikahikbn = pYuukoujyotaikahikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIM_Syorijtkahi.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIM_Syorijtkahi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIM_Syorijtkahi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
