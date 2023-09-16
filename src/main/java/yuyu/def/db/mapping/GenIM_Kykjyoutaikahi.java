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
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_Kykjyoutaikahi;
import yuyu.def.db.id.PKIM_Kykjyoutaikahi;
import yuyu.def.db.meta.GenQIM_Kykjyoutaikahi;
import yuyu.def.db.meta.QIM_Kykjyoutaikahi;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 契約状態処理可否マスタ テーブルのマッピング情報クラスで、 {@link IM_Kykjyoutaikahi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_Kykjyoutaikahi}</td><td colspan="3">契約状態処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKIM_Kykjyoutaikahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykjyoutai kykjyoutai}</td><td>契約状態</td><td align="center">{@link PKIM_Kykjyoutaikahi ○}</td><td align="center">V</td><td>{@link C_Kykjyoutai}</td></tr>
 *  <tr><td>{@link #getYuukoujyotaikahikbn yuukoujyotaikahikbn}</td><td>有効状態処理可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukoujyotaikahiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_Kykjyoutaikahi
 * @see     PKIM_Kykjyoutaikahi
 * @see     QIM_Kykjyoutaikahi
 * @see     GenQIM_Kykjyoutaikahi
 */
@MappedSuperclass
@Table(name=GenIM_Kykjyoutaikahi.TABLE_NAME)
@IdClass(value=PKIM_Kykjyoutaikahi.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Kykjyoutai", typeClass=UserType_C_Kykjyoutai.class),
    @TypeDef(name="UserType_C_YuukoujyotaikahiKbn", typeClass=UserType_C_YuukoujyotaikahiKbn.class)
})
public abstract class GenIM_Kykjyoutaikahi extends AbstractExDBEntity<IM_Kykjyoutaikahi, PKIM_Kykjyoutaikahi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_Kykjyoutaikahi";
    public static final String KINOUID                  = "kinouId";
    public static final String KYKJYOUTAI               = "kykjyoutai";
    public static final String YUUKOUJYOTAIKAHIKBN      = "yuukoujyotaikahikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIM_Kykjyoutaikahi primaryKey;

    public GenIM_Kykjyoutaikahi() {
        primaryKey = new PKIM_Kykjyoutaikahi();
    }

    public GenIM_Kykjyoutaikahi(String pKinouId, C_Kykjyoutai pKykjyoutai) {
        primaryKey = new PKIM_Kykjyoutaikahi(pKinouId, pKykjyoutai);
    }

    @Transient
    @Override
    public PKIM_Kykjyoutaikahi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_Kykjyoutaikahi> getMetaClass() {
        return QIM_Kykjyoutaikahi.class;
    }

    @Id
    @Column(name=GenIM_Kykjyoutaikahi.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Type(type="UserType_C_Kykjyoutai")
    @Column(name=GenIM_Kykjyoutaikahi.KYKJYOUTAI)
    public C_Kykjyoutai getKykjyoutai() {
        return getPrimaryKey().getKykjyoutai();
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        getPrimaryKey().setKykjyoutai(pKykjyoutai);
    }

    private C_YuukoujyotaikahiKbn yuukoujyotaikahikbn;

    @Type(type="UserType_C_YuukoujyotaikahiKbn")
    @Column(name=GenIM_Kykjyoutaikahi.YUUKOUJYOTAIKAHIKBN)
    public C_YuukoujyotaikahiKbn getYuukoujyotaikahikbn() {
        return yuukoujyotaikahikbn;
    }

    public void setYuukoujyotaikahikbn(C_YuukoujyotaikahiKbn pYuukoujyotaikahikbn) {
        yuukoujyotaikahikbn = pYuukoujyotaikahikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIM_Kykjyoutaikahi.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIM_Kykjyoutaikahi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIM_Kykjyoutaikahi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
