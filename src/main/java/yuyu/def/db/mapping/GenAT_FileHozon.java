package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AT_FileHozon;
import yuyu.def.db.id.PKAT_FileHozon;
import yuyu.def.db.meta.GenQAT_FileHozon;
import yuyu.def.db.meta.QAT_FileHozon;

/**
 * ファイル保存テーブル テーブルのマッピング情報クラスで、 {@link AT_FileHozon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileHozon}</td><td colspan="3">ファイル保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">{@link PKAT_FileHozon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFileContents fileContents}</td><td>ファイル内容</td><td align="center">&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 * </table>
 * @see     AT_FileHozon
 * @see     PKAT_FileHozon
 * @see     QAT_FileHozon
 * @see     GenQAT_FileHozon
 */
@MappedSuperclass
@Table(name=GenAT_FileHozon.TABLE_NAME)
@IdClass(value=PKAT_FileHozon.class)
public abstract class GenAT_FileHozon extends AbstractExDBEntity<AT_FileHozon, PKAT_FileHozon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_FileHozon";
    public static final String UNIQUEID                 = "uniqueId";
    public static final String FILECONTENTS             = "fileContents";

    private final PKAT_FileHozon primaryKey;

    public GenAT_FileHozon() {
        primaryKey = new PKAT_FileHozon();
    }

    public GenAT_FileHozon(String pUniqueId) {
        primaryKey = new PKAT_FileHozon(pUniqueId);
    }

    @Transient
    @Override
    public PKAT_FileHozon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_FileHozon> getMetaClass() {
        return QAT_FileHozon.class;
    }

    @Id
    @Column(name=GenAT_FileHozon.UNIQUEID)
    public String getUniqueId() {
        return getPrimaryKey().getUniqueId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        getPrimaryKey().setUniqueId(pUniqueId);
    }

    private byte[] fileContents;

    @Column(name=GenAT_FileHozon.FILECONTENTS)
    public byte[] getFileContents() {
        return fileContents;
    }

    public void setFileContents(byte[] pFileContents) {
        fileContents = pFileContents;
    }
}
