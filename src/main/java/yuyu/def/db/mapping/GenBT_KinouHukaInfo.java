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
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.BT_KinouHukaInfo;
import yuyu.def.db.id.PKBT_KinouHukaInfo;
import yuyu.def.db.meta.GenQBT_KinouHukaInfo;
import yuyu.def.db.meta.QBT_KinouHukaInfo;
import yuyu.def.db.type.UserType_C_KahiKbn;

/**
 * 機能付加情報テーブル テーブルのマッピング情報クラスで、 {@link BT_KinouHukaInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KinouHukaInfo}</td><td colspan="3">機能付加情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKBT_KinouHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTjttrkskahi tjttrkskahi}</td><td>当日取消可否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getKensuuhyoujijyun kensuuhyoujijyun}</td><td>件数表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BT_KinouHukaInfo
 * @see     PKBT_KinouHukaInfo
 * @see     QBT_KinouHukaInfo
 * @see     GenQBT_KinouHukaInfo
 */
@MappedSuperclass
@Table(name=GenBT_KinouHukaInfo.TABLE_NAME)
@IdClass(value=PKBT_KinouHukaInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class)
})
public abstract class GenBT_KinouHukaInfo extends AbstractExDBEntity<BT_KinouHukaInfo, PKBT_KinouHukaInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_KinouHukaInfo";
    public static final String KINOUID                  = "kinouId";
    public static final String TJTTRKSKAHI              = "tjttrkskahi";
    public static final String KENSUUHYOUJIJYUN         = "kensuuhyoujijyun";

    private final PKBT_KinouHukaInfo primaryKey;

    public GenBT_KinouHukaInfo() {
        primaryKey = new PKBT_KinouHukaInfo();
    }

    public GenBT_KinouHukaInfo(String pKinouId) {
        primaryKey = new PKBT_KinouHukaInfo(pKinouId);
    }

    @Transient
    @Override
    public PKBT_KinouHukaInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_KinouHukaInfo> getMetaClass() {
        return QBT_KinouHukaInfo.class;
    }

    @Id
    @Column(name=GenBT_KinouHukaInfo.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    private C_KahiKbn tjttrkskahi;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenBT_KinouHukaInfo.TJTTRKSKAHI)
    public C_KahiKbn getTjttrkskahi() {
        return tjttrkskahi;
    }

    public void setTjttrkskahi(C_KahiKbn pTjttrkskahi) {
        tjttrkskahi = pTjttrkskahi;
    }

    private Integer kensuuhyoujijyun;

    @Column(name=GenBT_KinouHukaInfo.KENSUUHYOUJIJYUN)
    public Integer getKensuuhyoujijyun() {
        return kensuuhyoujijyun;
    }

    public void setKensuuhyoujijyun(Integer pKensuuhyoujijyun) {
        kensuuhyoujijyun = pKensuuhyoujijyun;
    }
}
