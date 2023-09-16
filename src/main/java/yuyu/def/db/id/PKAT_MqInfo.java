package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_MqInfo;
import yuyu.def.db.mapping.GenAT_MqInfo;
import yuyu.def.db.meta.GenQAT_MqInfo;
import yuyu.def.db.meta.QAT_MqInfo;

/**
 * ＭＱ情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_MqInfo}</td><td colspan="3">ＭＱ情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getServerType serverType}</td><td>サーバ種別</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mqOnlineStatus</td><td>ＭＱオンライン状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MqOnlineStatusKbn C_MqOnlineStatusKbn}</td></tr>
 *  <tr><td>mqEmgcyStopStatus</td><td>ＭＱ緊急停止状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MqEmgcyStopStatusKbn C_MqEmgcyStopStatusKbn}</td></tr>
 *  <tr><td>rkmAtesaki</td><td>連携元宛先</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>contextPath</td><td>コンテキストパス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_MqInfo
 * @see     GenAT_MqInfo
 * @see     QAT_MqInfo
 * @see     GenQAT_MqInfo
 */
public class PKAT_MqInfo extends AbstractExDBPrimaryKey<AT_MqInfo, PKAT_MqInfo> {

    private static final long serialVersionUID = 1L;

    public PKAT_MqInfo() {
    }

    public PKAT_MqInfo(String pServerType) {
        serverType = pServerType;
    }

    @Transient
    @Override
    public Class<AT_MqInfo> getEntityClass() {
        return AT_MqInfo.class;
    }

    private String serverType;

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String pServerType) {
        serverType = pServerType;
    }

}