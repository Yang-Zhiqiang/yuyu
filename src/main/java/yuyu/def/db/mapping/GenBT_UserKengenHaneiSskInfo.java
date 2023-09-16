package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HnsyaSosikiKengenKbn;
import yuyu.def.db.entity.BT_UserKengenHaneiSskInfo;
import yuyu.def.db.id.PKBT_UserKengenHaneiSskInfo;
import yuyu.def.db.meta.GenQBT_UserKengenHaneiSskInfo;
import yuyu.def.db.meta.QBT_UserKengenHaneiSskInfo;
import yuyu.def.db.type.UserType_C_HnsyaSosikiKengenKbn;

/**
 * ユーザー権限自動反映組織情報テーブル テーブルのマッピング情報クラスで、 {@link BT_UserKengenHaneiSskInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_UserKengenHaneiSskInfo}</td><td colspan="3">ユーザー権限自動反映組織情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSosikicdkami3 sosikicdkami3}</td><td>組織コード上３桁</td><td align="center">{@link PKBT_UserKengenHaneiSskInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHnsyasosikikengenkbn hnsyasosikikengenkbn}</td><td>本社組織権限区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HnsyaSosikiKengenKbn}</td></tr>
 * </table>
 * @see     BT_UserKengenHaneiSskInfo
 * @see     PKBT_UserKengenHaneiSskInfo
 * @see     QBT_UserKengenHaneiSskInfo
 * @see     GenQBT_UserKengenHaneiSskInfo
 */
@MappedSuperclass
@Table(name=GenBT_UserKengenHaneiSskInfo.TABLE_NAME)
@IdClass(value=PKBT_UserKengenHaneiSskInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_HnsyaSosikiKengenKbn", typeClass=UserType_C_HnsyaSosikiKengenKbn.class)
})
public abstract class GenBT_UserKengenHaneiSskInfo extends AbstractExDBEntity<BT_UserKengenHaneiSskInfo, PKBT_UserKengenHaneiSskInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_UserKengenHaneiSskInfo";
    public static final String SOSIKICDKAMI3            = "sosikicdkami3";
    public static final String HNSYASOSIKIKENGENKBN     = "hnsyasosikikengenkbn";

    private final PKBT_UserKengenHaneiSskInfo primaryKey;

    public GenBT_UserKengenHaneiSskInfo() {
        primaryKey = new PKBT_UserKengenHaneiSskInfo();
    }

    public GenBT_UserKengenHaneiSskInfo(String pSosikicdkami3) {
        primaryKey = new PKBT_UserKengenHaneiSskInfo(pSosikicdkami3);
    }

    @Transient
    @Override
    public PKBT_UserKengenHaneiSskInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_UserKengenHaneiSskInfo> getMetaClass() {
        return QBT_UserKengenHaneiSskInfo.class;
    }

    @Id
    @Column(name=GenBT_UserKengenHaneiSskInfo.SOSIKICDKAMI3)
    public String getSosikicdkami3() {
        return getPrimaryKey().getSosikicdkami3();
    }

    public void setSosikicdkami3(String pSosikicdkami3) {
        getPrimaryKey().setSosikicdkami3(pSosikicdkami3);
    }

    private C_HnsyaSosikiKengenKbn hnsyasosikikengenkbn;

    @Type(type="UserType_C_HnsyaSosikiKengenKbn")
    @Column(name=GenBT_UserKengenHaneiSskInfo.HNSYASOSIKIKENGENKBN)
    public C_HnsyaSosikiKengenKbn getHnsyasosikikengenkbn() {
        return hnsyasosikikengenkbn;
    }

    public void setHnsyasosikikengenkbn(C_HnsyaSosikiKengenKbn pHnsyasosikikengenkbn) {
        hnsyasosikikengenkbn = pHnsyasosikikengenkbn;
    }
}