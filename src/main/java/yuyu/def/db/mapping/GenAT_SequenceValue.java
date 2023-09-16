package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AT_SequenceValue;
import yuyu.def.db.id.PKAT_SequenceValue;
import yuyu.def.db.meta.GenQAT_SequenceValue;
import yuyu.def.db.meta.QAT_SequenceValue;

/**
 * 連番値管理テーブル テーブルのマッピング情報クラスで、 {@link AT_SequenceValue} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_SequenceValue}</td><td colspan="3">連番値管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getId id}</td><td>ＩＤ</td><td align="center">{@link PKAT_SequenceValue ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeys keys}</td><td>キー</td><td align="center">{@link PKAT_SequenceValue ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCurrentValue currentValue}</td><td>現在値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     AT_SequenceValue
 * @see     PKAT_SequenceValue
 * @see     QAT_SequenceValue
 * @see     GenQAT_SequenceValue
 */
@MappedSuperclass
@Table(name=GenAT_SequenceValue.TABLE_NAME)
@IdClass(value=PKAT_SequenceValue.class)
public abstract class GenAT_SequenceValue extends AbstractExDBEntity<AT_SequenceValue, PKAT_SequenceValue> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_SequenceValue";
    public static final String ID                       = "id";
    public static final String KEYS                     = "keys";
    public static final String CURRENTVALUE             = "currentValue";

    private final PKAT_SequenceValue primaryKey;

    public GenAT_SequenceValue() {
        primaryKey = new PKAT_SequenceValue();
    }

    public GenAT_SequenceValue(String pId, String pKeys) {
        primaryKey = new PKAT_SequenceValue(pId, pKeys);
    }

    @Transient
    @Override
    public PKAT_SequenceValue getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_SequenceValue> getMetaClass() {
        return QAT_SequenceValue.class;
    }

    @Id
    @Column(name=GenAT_SequenceValue.ID)
    public String getId() {
        return getPrimaryKey().getId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setId(String pId) {
        getPrimaryKey().setId(pId);
    }

    @Id
    @Column(name=GenAT_SequenceValue.KEYS)
    public String getKeys() {
        return getPrimaryKey().getKeys();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKeys(String pKeys) {
        getPrimaryKey().setKeys(pKeys);
    }

    private Long currentValue;

    @Column(name=GenAT_SequenceValue.CURRENTVALUE)
    public Long getCurrentValue() {
        return currentValue;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCurrentValue(Long pCurrentValue) {
        currentValue = pCurrentValue;
    }
}
