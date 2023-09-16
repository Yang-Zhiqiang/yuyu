package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_AppIdentifier;
import yuyu.def.db.mapping.GenAT_AppIdentifier;
import yuyu.def.db.meta.GenQAT_AppIdentifier;
import yuyu.def.db.meta.QAT_AppIdentifier;

/**
 * アプリケーション識別子管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_AppIdentifier}</td><td colspan="3">アプリケーション識別子管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdentifier identifier}</td><td>識別子</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>touchTime</td><td>タッチ時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_AppIdentifier
 * @see     GenAT_AppIdentifier
 * @see     QAT_AppIdentifier
 * @see     GenQAT_AppIdentifier
 */
public class PKAT_AppIdentifier extends AbstractExDBPrimaryKey<AT_AppIdentifier, PKAT_AppIdentifier> {

    private static final long serialVersionUID = 1L;

    public PKAT_AppIdentifier() {
    }

    public PKAT_AppIdentifier(String pIdentifier) {
        identifier = pIdentifier;
    }

    @Transient
    @Override
    public Class<AT_AppIdentifier> getEntityClass() {
        return AT_AppIdentifier.class;
    }

    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String pIdentifier) {
        identifier = pIdentifier;
    }

}