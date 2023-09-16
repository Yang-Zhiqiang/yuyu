package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.mapping.GenAT_BatchJob;
import yuyu.def.db.meta.GenQAT_BatchJob;
import yuyu.def.db.meta.QAT_BatchJob;

/**
 * バッチジョブテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_BatchJob}</td><td colspan="3">バッチジョブテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBatchJobId batchJobId}</td><td>バッチジョブＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>batchId</td><td>バッチＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>batchKidouKbn</td><td>バッチ起動区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BatchKidouKbn C_BatchKidouKbn}</td></tr>
 *  <tr><td>batchJyoutaiKbn</td><td>バッチ状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BatchJyoutaiKbn C_BatchJyoutaiKbn}</td></tr>
 *  <tr><td>batchResultKbn</td><td>バッチ結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BatchResultKbn C_BatchResultKbn}</td></tr>
 *  <tr><td>batchSyoriYmd</td><td>バッチ処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>batchStartTime</td><td>バッチ開始時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>batchEndTime</td><td>バッチ終了時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>elapsedTime</td><td>経過時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>elapsedSeconds</td><td>経過秒数</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     AT_BatchJob
 * @see     GenAT_BatchJob
 * @see     QAT_BatchJob
 * @see     GenQAT_BatchJob
 */
public class PKAT_BatchJob extends AbstractExDBPrimaryKey<AT_BatchJob, PKAT_BatchJob> {

    private static final long serialVersionUID = 1L;

    public PKAT_BatchJob() {
    }

    public PKAT_BatchJob(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }

    @Transient
    @Override
    public Class<AT_BatchJob> getEntityClass() {
        return AT_BatchJob.class;
    }

    private String batchJobId;

    public String getBatchJobId() {
        return batchJobId;
    }

    public void setBatchJobId(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }

}