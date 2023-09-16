package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AT_FileRireki;
import yuyu.def.db.id.PKAT_FileRireki;
import yuyu.def.db.meta.GenQAT_FileRireki;
import yuyu.def.db.meta.QAT_FileRireki;

/**
 * ファイル履歴テーブル テーブルのマッピング情報クラスで、 {@link AT_FileRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileRireki}</td><td colspan="3">ファイル履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">{@link PKAT_FileRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHistoryId historyId}</td><td>履歴ＩＤ</td><td align="center">{@link PKAT_FileRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFileNm fileNm}</td><td>ファイル名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFileSize fileSize}</td><td>ファイルサイズ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getFileContents fileContents}</td><td>ファイル内容</td><td align="center">&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 *  <tr><td>{@link #getTourokuTime tourokuTime}</td><td>登録時間</td><td align="center">{@link PKAT_FileRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFileNmSuffix fileNmSuffix}</td><td>ファイル名サフィックス</td><td align="center">{@link PKAT_FileRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AT_FileRireki
 * @see     PKAT_FileRireki
 * @see     QAT_FileRireki
 * @see     GenQAT_FileRireki
 */
@MappedSuperclass
@Table(name=GenAT_FileRireki.TABLE_NAME)
@IdClass(value=PKAT_FileRireki.class)
public abstract class GenAT_FileRireki extends AbstractExDBEntity<AT_FileRireki, PKAT_FileRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_FileRireki";
    public static final String UNIQUEID                 = "uniqueId";
    public static final String HISTORYID                = "historyId";
    public static final String FILENM                   = "fileNm";
    public static final String FILESIZE                 = "fileSize";
    public static final String FILECONTENTS             = "fileContents";
    public static final String TOUROKUTIME              = "tourokuTime";
    public static final String FILENMSUFFIX             = "fileNmSuffix";

    private final PKAT_FileRireki primaryKey;

    public GenAT_FileRireki() {
        primaryKey = new PKAT_FileRireki();
    }

    public GenAT_FileRireki(
        String pUniqueId,
        String pHistoryId,
        String pTourokuTime,
        Integer pFileNmSuffix
    ) {
        primaryKey = new PKAT_FileRireki(
            pUniqueId,
            pHistoryId,
            pTourokuTime,
            pFileNmSuffix
        );
    }

    @Transient
    @Override
    public PKAT_FileRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_FileRireki> getMetaClass() {
        return QAT_FileRireki.class;
    }

    @Id
    @Column(name=GenAT_FileRireki.UNIQUEID)
    public String getUniqueId() {
        return getPrimaryKey().getUniqueId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        getPrimaryKey().setUniqueId(pUniqueId);
    }

    @Id
    @Column(name=GenAT_FileRireki.HISTORYID)
    public String getHistoryId() {
        return getPrimaryKey().getHistoryId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHistoryId(String pHistoryId) {
        getPrimaryKey().setHistoryId(pHistoryId);
    }

    private String fileNm;

    @Column(name=GenAT_FileRireki.FILENM)
    public String getFileNm() {
        return fileNm;
    }

    @Trim("both")
    public void setFileNm(String pFileNm) {
        fileNm = pFileNm;
    }

    private Long fileSize;

    @Column(name=GenAT_FileRireki.FILESIZE)
    public Long getFileSize() {
        return fileSize;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setFileSize(Long pFileSize) {
        fileSize = pFileSize;
    }

    private byte[] fileContents;

    @Column(name=GenAT_FileRireki.FILECONTENTS)
    public byte[] getFileContents() {
        return fileContents;
    }

    public void setFileContents(byte[] pFileContents) {
        fileContents = pFileContents;
    }

    @Id
    @Column(name=GenAT_FileRireki.TOUROKUTIME)
    public String getTourokuTime() {
        return getPrimaryKey().getTourokuTime();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTourokuTime(String pTourokuTime) {
        getPrimaryKey().setTourokuTime(pTourokuTime);
    }

    @Id
    @Column(name=GenAT_FileRireki.FILENMSUFFIX)
    public Integer getFileNmSuffix() {
        return getPrimaryKey().getFileNmSuffix();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setFileNmSuffix(Integer pFileNmSuffix) {
        getPrimaryKey().setFileNmSuffix(pFileNmSuffix);
    }
}
