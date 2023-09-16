package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.def.db.mapping.GenAT_BatchLog;
import yuyu.def.db.meta.GenQAT_BatchLog;
import yuyu.def.db.meta.QAT_BatchLog;

/**
 * バッチログテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_BatchLog}</td><td colspan="3">バッチログテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBatchJobId batchJobId}</td><td>バッチジョブＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBatchLogEdaNo batchLogEdaNo}</td><td>バッチログ枝番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>logOutputTime</td><td>ログ出力時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>logLevelKbn</td><td>ログレベル区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LogLevelKbn C_LogLevelKbn}</td></tr>
 *  <tr><td>logNaiyou</td><td>ログ内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_BatchLog
 * @see     GenAT_BatchLog
 * @see     QAT_BatchLog
 * @see     GenQAT_BatchLog
 */
public class PKAT_BatchLog extends AbstractExDBPrimaryKey<AT_BatchLog, PKAT_BatchLog> {

    private static final long serialVersionUID = 1L;

    public PKAT_BatchLog() {
    }

    public PKAT_BatchLog(String pBatchJobId, Integer pBatchLogEdaNo) {
        batchJobId = pBatchJobId;
        batchLogEdaNo = pBatchLogEdaNo;
    }

    @Transient
    @Override
    public Class<AT_BatchLog> getEntityClass() {
        return AT_BatchLog.class;
    }

    private String batchJobId;

    public String getBatchJobId() {
        return batchJobId;
    }

    public void setBatchJobId(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }
    private Integer batchLogEdaNo;

    public Integer getBatchLogEdaNo() {
        return batchLogEdaNo;
    }

    public void setBatchLogEdaNo(Integer pBatchLogEdaNo) {
        batchLogEdaNo = pBatchLogEdaNo;
    }

}