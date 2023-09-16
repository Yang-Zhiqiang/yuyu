package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_SequenceValue;
import yuyu.def.db.mapping.GenAT_SequenceValue;
import yuyu.def.db.meta.GenQAT_SequenceValue;
import yuyu.def.db.meta.QAT_SequenceValue;

/**
 * 連番値管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_SequenceValue}</td><td colspan="3">連番値管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getId id}</td><td>ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKeys keys}</td><td>キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>currentValue</td><td>現在値</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     AT_SequenceValue
 * @see     GenAT_SequenceValue
 * @see     QAT_SequenceValue
 * @see     GenQAT_SequenceValue
 */
public class PKAT_SequenceValue extends AbstractExDBPrimaryKey<AT_SequenceValue, PKAT_SequenceValue> {

    private static final long serialVersionUID = 1L;

    public PKAT_SequenceValue() {
    }

    public PKAT_SequenceValue(String pId, String pKeys) {
        id = pId;
        keys = pKeys;
    }

    @Transient
    @Override
    public Class<AT_SequenceValue> getEntityClass() {
        return AT_SequenceValue.class;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String pId) {
        id = pId;
    }
    private String keys;

    public String getKeys() {
        return keys;
    }

    public void setKeys(String pKeys) {
        keys = pKeys;
    }

}