package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AT_AppIdentifier;
import yuyu.def.db.id.PKAT_AppIdentifier;
import yuyu.def.db.meta.GenQAT_AppIdentifier;
import yuyu.def.db.meta.QAT_AppIdentifier;

/**
 * アプリケーション識別子管理テーブル テーブルのマッピング情報クラスで、 {@link AT_AppIdentifier} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_AppIdentifier}</td><td colspan="3">アプリケーション識別子管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIdentifier identifier}</td><td>識別子</td><td align="center">{@link PKAT_AppIdentifier ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTouchTime touchTime}</td><td>タッチ時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_AppIdentifier
 * @see     PKAT_AppIdentifier
 * @see     QAT_AppIdentifier
 * @see     GenQAT_AppIdentifier
 */
@MappedSuperclass
@Table(name=GenAT_AppIdentifier.TABLE_NAME)
@IdClass(value=PKAT_AppIdentifier.class)
public abstract class GenAT_AppIdentifier extends AbstractExDBEntity<AT_AppIdentifier, PKAT_AppIdentifier> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_AppIdentifier";
    public static final String IDENTIFIER               = "identifier";
    public static final String TOUCHTIME                = "touchTime";

    private final PKAT_AppIdentifier primaryKey;

    public GenAT_AppIdentifier() {
        primaryKey = new PKAT_AppIdentifier();
    }

    public GenAT_AppIdentifier(String pIdentifier) {
        primaryKey = new PKAT_AppIdentifier(pIdentifier);
    }

    @Transient
    @Override
    public PKAT_AppIdentifier getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_AppIdentifier> getMetaClass() {
        return QAT_AppIdentifier.class;
    }

    @Id
    @Column(name=GenAT_AppIdentifier.IDENTIFIER)
    public String getIdentifier() {
        return getPrimaryKey().getIdentifier();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIdentifier(String pIdentifier) {
        getPrimaryKey().setIdentifier(pIdentifier);
    }

    private String touchTime;

    @Column(name=GenAT_AppIdentifier.TOUCHTIME)
    public String getTouchTime() {
        return touchTime;
    }

    public void setTouchTime(String pTouchTime) {
        touchTime = pTouchTime;
    }
}
