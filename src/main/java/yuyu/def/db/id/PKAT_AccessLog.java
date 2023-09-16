package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.mapping.GenAT_AccessLog;
import yuyu.def.db.meta.GenQAT_AccessLog;
import yuyu.def.db.meta.QAT_AccessLog;

/**
 * アクセスログテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_AccessLog}</td><td colspan="3">アクセスログテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getLogId logId}</td><td>ログＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>timeStamp</td><td>アクセスログ出力時刻</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>syoriUserId</td><td>処理ユーザーＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ipAddress</td><td>ＩＰアドレス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sessionId</td><td>セッションＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>transactionId</td><td>トランザクションＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>logKindCd</td><td>ログ種別コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AccessLogSyubetuKbn C_AccessLogSyubetuKbn}</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>categoryId</td><td>カテゴリＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinouId</td><td>機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tanmatuType</td><td>端末タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>butsuriSosikiCd</td><td>物理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ronriSosikiCd</td><td>論理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tanmatuJyoutaiHyouji</td><td>端末状態表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>logData</td><td>ログデータ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syousaiKensuu</td><td>詳細ログ件数</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     AT_AccessLog
 * @see     GenAT_AccessLog
 * @see     QAT_AccessLog
 * @see     GenQAT_AccessLog
 */
public class PKAT_AccessLog extends AbstractExDBPrimaryKey<AT_AccessLog, PKAT_AccessLog> {

    private static final long serialVersionUID = 1L;

    public PKAT_AccessLog() {
    }

    public PKAT_AccessLog(String pLogId) {
        logId = pLogId;
    }

    @Transient
    @Override
    public Class<AT_AccessLog> getEntityClass() {
        return AT_AccessLog.class;
    }

    private String logId;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String pLogId) {
        logId = pLogId;
    }

}