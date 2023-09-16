package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.BT_TestKykData;
import yuyu.def.db.id.PKBT_TestKykData;
import yuyu.def.db.meta.GenQBT_TestKykData;
import yuyu.def.db.meta.QBT_TestKykData;

/**
 * テスト用契約データ抽出テーブル テーブルのマッピング情報クラスで、 {@link BT_TestKykData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TestKykData}</td><td colspan="3">テスト用契約データ抽出テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">{@link PKBT_TestKykData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFileNm fileNm}</td><td>ファイル名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTestfilecontents testfilecontents}</td><td>テスト用ファイル内容</td><td align="center">&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 * </table>
 * @see     BT_TestKykData
 * @see     PKBT_TestKykData
 * @see     QBT_TestKykData
 * @see     GenQBT_TestKykData
 */
@MappedSuperclass
@Table(name=GenBT_TestKykData.TABLE_NAME)
@IdClass(value=PKBT_TestKykData.class)
public abstract class GenBT_TestKykData extends AbstractExDBEntity<BT_TestKykData, PKBT_TestKykData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_TestKykData";
    public static final String UNIQUEID                 = "uniqueId";
    public static final String FILENM                   = "fileNm";
    public static final String TESTFILECONTENTS         = "testfilecontents";

    private final PKBT_TestKykData primaryKey;

    public GenBT_TestKykData() {
        primaryKey = new PKBT_TestKykData();
    }

    public GenBT_TestKykData(String pUniqueId) {
        primaryKey = new PKBT_TestKykData(pUniqueId);
    }

    @Transient
    @Override
    public PKBT_TestKykData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_TestKykData> getMetaClass() {
        return QBT_TestKykData.class;
    }

    @Id
    @Column(name=GenBT_TestKykData.UNIQUEID)
    public String getUniqueId() {
        return getPrimaryKey().getUniqueId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        getPrimaryKey().setUniqueId(pUniqueId);
    }

    private String fileNm;

    @Column(name=GenBT_TestKykData.FILENM)
    public String getFileNm() {
        return fileNm;
    }

    @Trim("both")
    public void setFileNm(String pFileNm) {
        fileNm = pFileNm;
    }

    private byte[] testfilecontents;

    @Column(name=GenBT_TestKykData.TESTFILECONTENTS)
    public byte[] getTestfilecontents() {
        return testfilecontents;
    }

    public void setTestfilecontents(byte[] pTestfilecontents) {
        testfilecontents = pTestfilecontents;
    }
}