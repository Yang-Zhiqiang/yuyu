package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_FileRireki;
import yuyu.def.db.mapping.GenAT_FileRireki;
import yuyu.def.db.meta.GenQAT_FileRireki;
import yuyu.def.db.meta.QAT_FileRireki;

/**
 * ファイル履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileRireki}</td><td colspan="3">ファイル履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHistoryId historyId}</td><td>履歴ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fileNm</td><td>ファイル名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fileSize</td><td>ファイルサイズ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>fileContents</td><td>ファイル内容</td><td>&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTourokuTime tourokuTime}</td><td>登録時間</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getFileNmSuffix fileNmSuffix}</td><td>ファイル名サフィックス</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AT_FileRireki
 * @see     GenAT_FileRireki
 * @see     QAT_FileRireki
 * @see     GenQAT_FileRireki
 */
public class PKAT_FileRireki extends AbstractExDBPrimaryKey<AT_FileRireki, PKAT_FileRireki> {

    private static final long serialVersionUID = 1L;

    public PKAT_FileRireki() {
    }

    public PKAT_FileRireki(
        String pUniqueId,
        String pHistoryId,
        String pTourokuTime,
        Integer pFileNmSuffix
    ) {
        uniqueId = pUniqueId;
        historyId = pHistoryId;
        tourokuTime = pTourokuTime;
        fileNmSuffix = pFileNmSuffix;
    }

    @Transient
    @Override
    public Class<AT_FileRireki> getEntityClass() {
        return AT_FileRireki.class;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }
    private String historyId;

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String pHistoryId) {
        historyId = pHistoryId;
    }
    private String tourokuTime;

    public String getTourokuTime() {
        return tourokuTime;
    }

    public void setTourokuTime(String pTourokuTime) {
        tourokuTime = pTourokuTime;
    }
    private Integer fileNmSuffix;

    public Integer getFileNmSuffix() {
        return fileNmSuffix;
    }

    public void setFileNmSuffix(Integer pFileNmSuffix) {
        fileNmSuffix = pFileNmSuffix;
    }

}