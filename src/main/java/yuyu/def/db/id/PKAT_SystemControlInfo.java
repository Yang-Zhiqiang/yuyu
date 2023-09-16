package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.def.db.mapping.GenAT_SystemControlInfo;
import yuyu.def.db.meta.GenQAT_SystemControlInfo;
import yuyu.def.db.meta.QAT_SystemControlInfo;

/**
 * システム制御情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_SystemControlInfo}</td><td colspan="3">システム制御情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSystemCtrlInfo systemCtrlInfo}</td><td>システム制御情報</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mqEmgcyStopStatus</td><td>ＭＱ緊急停止状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MqEmgcyStopStatusKbn C_MqEmgcyStopStatusKbn}</td></tr>
 *  <tr><td>onlineStatus</td><td>オンライン状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_SystemControlInfo
 * @see     GenAT_SystemControlInfo
 * @see     QAT_SystemControlInfo
 * @see     GenQAT_SystemControlInfo
 */
public class PKAT_SystemControlInfo extends AbstractExDBPrimaryKey<AT_SystemControlInfo, PKAT_SystemControlInfo> {

    private static final long serialVersionUID = 1L;

    public PKAT_SystemControlInfo() {
    }

    public PKAT_SystemControlInfo(String pSystemCtrlInfo) {
        systemCtrlInfo = pSystemCtrlInfo;
    }

    @Transient
    @Override
    public Class<AT_SystemControlInfo> getEntityClass() {
        return AT_SystemControlInfo.class;
    }

    private String systemCtrlInfo;

    public String getSystemCtrlInfo() {
        return systemCtrlInfo;
    }

    public void setSystemCtrlInfo(String pSystemCtrlInfo) {
        systemCtrlInfo = pSystemCtrlInfo;
    }

}