package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_BatchLogReport;
import yuyu.def.db.mapping.GenAT_BatchLogReport;
import yuyu.def.db.meta.GenQAT_BatchLogReport;
import yuyu.def.db.meta.QAT_BatchLogReport;

/**
 * バッチログレポートテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_BatchLogReport}</td><td colspan="3">バッチログレポートテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBatchJobId batchJobId}</td><td>バッチジョブＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getReportKey reportKey}</td><td>帳票キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyouhyouJoinKey</td><td>帳票結合キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>batchSyoriYmd</td><td>バッチ処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     AT_BatchLogReport
 * @see     GenAT_BatchLogReport
 * @see     QAT_BatchLogReport
 * @see     GenQAT_BatchLogReport
 */
public class PKAT_BatchLogReport extends AbstractExDBPrimaryKey<AT_BatchLogReport, PKAT_BatchLogReport> {

    private static final long serialVersionUID = 1L;

    public PKAT_BatchLogReport() {
    }

    public PKAT_BatchLogReport(String pBatchJobId, String pReportKey) {
        batchJobId = pBatchJobId;
        reportKey = pReportKey;
    }

    @Transient
    @Override
    public Class<AT_BatchLogReport> getEntityClass() {
        return AT_BatchLogReport.class;
    }

    private String batchJobId;

    public String getBatchJobId() {
        return batchJobId;
    }

    public void setBatchJobId(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }
    private String reportKey;

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }

}