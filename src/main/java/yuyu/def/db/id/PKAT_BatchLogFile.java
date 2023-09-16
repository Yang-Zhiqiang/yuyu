package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_BatchLogFile;
import yuyu.def.db.mapping.GenAT_BatchLogFile;
import yuyu.def.db.meta.GenQAT_BatchLogFile;
import yuyu.def.db.meta.QAT_BatchLogFile;

/**
 * バッチログファイルテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_BatchLogFile}</td><td colspan="3">バッチログファイルテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBatchJobId batchJobId}</td><td>バッチジョブＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>batchSyoriYmd</td><td>バッチ処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     AT_BatchLogFile
 * @see     GenAT_BatchLogFile
 * @see     QAT_BatchLogFile
 * @see     GenQAT_BatchLogFile
 */
public class PKAT_BatchLogFile extends AbstractExDBPrimaryKey<AT_BatchLogFile, PKAT_BatchLogFile> {

    private static final long serialVersionUID = 1L;

    public PKAT_BatchLogFile() {
    }

    public PKAT_BatchLogFile(String pBatchJobId, String pUniqueId) {
        batchJobId = pBatchJobId;
        uniqueId = pUniqueId;
    }

    @Transient
    @Override
    public Class<AT_BatchLogFile> getEntityClass() {
        return AT_BatchLogFile.class;
    }

    private String batchJobId;

    public String getBatchJobId() {
        return batchJobId;
    }

    public void setBatchJobId(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }
    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

}