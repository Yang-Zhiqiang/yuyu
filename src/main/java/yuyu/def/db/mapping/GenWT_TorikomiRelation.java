package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.db.id.PKWT_TorikomiRelation;
import yuyu.def.db.meta.GenQWT_TorikomiRelation;
import yuyu.def.db.meta.QWT_TorikomiRelation;

/**
 * 取込関連テーブル テーブルのマッピング情報クラスで、 {@link WT_TorikomiRelation} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_TorikomiRelation}</td><td colspan="3">取込関連テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIwfImageId iwfImageId}</td><td>IWFイメージＩＤ</td><td align="center">{@link PKWT_TorikomiRelation ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKey gyoumuKey}</td><td>業務キー</td><td align="center">{@link PKWT_TorikomiRelation ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_TorikomiRelation
 * @see     PKWT_TorikomiRelation
 * @see     QWT_TorikomiRelation
 * @see     GenQWT_TorikomiRelation
 */
@MappedSuperclass
@Table(name=GenWT_TorikomiRelation.TABLE_NAME)
@IdClass(value=PKWT_TorikomiRelation.class)
public abstract class GenWT_TorikomiRelation extends AbstractExDBEntity<WT_TorikomiRelation, PKWT_TorikomiRelation> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_TorikomiRelation";
    public static final String IWFIMAGEID               = "iwfImageId";
    public static final String GYOUMUKEY                = "gyoumuKey";

    private final PKWT_TorikomiRelation primaryKey;

    public GenWT_TorikomiRelation() {
        primaryKey = new PKWT_TorikomiRelation();
    }

    public GenWT_TorikomiRelation(String pGyoumuKey, String pIwfImageId) {
        primaryKey = new PKWT_TorikomiRelation(pGyoumuKey, pIwfImageId);
    }

    @Transient
    @Override
    public PKWT_TorikomiRelation getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_TorikomiRelation> getMetaClass() {
        return QWT_TorikomiRelation.class;
    }

    @Id
    @Column(name=GenWT_TorikomiRelation.IWFIMAGEID)
    public String getIwfImageId() {
        return getPrimaryKey().getIwfImageId();
    }

    public void setIwfImageId(String pIwfImageId) {
        getPrimaryKey().setIwfImageId(pIwfImageId);
    }

    @Id
    @Column(name=GenWT_TorikomiRelation.GYOUMUKEY)
    public String getGyoumuKey() {
        return getPrimaryKey().getGyoumuKey();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setGyoumuKey(String pGyoumuKey) {
        getPrimaryKey().setGyoumuKey(pGyoumuKey);
    }
}