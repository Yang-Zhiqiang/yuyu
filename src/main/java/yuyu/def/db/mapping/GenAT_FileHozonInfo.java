package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_FileStatusKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.id.PKAT_FileHozonInfo;
import yuyu.def.db.meta.GenQAT_FileHozonInfo;
import yuyu.def.db.meta.QAT_FileHozonInfo;
import yuyu.def.db.type.UserType_C_FileStatusKbn;
import yuyu.def.db.type.UserType_C_FileSyuruiCdKbn;

/**
 * ファイル保存情報テーブル テーブルのマッピング情報クラスで、 {@link AT_FileHozonInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileHozonInfo}</td><td colspan="3">ファイル保存情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">{@link PKAT_FileHozonInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFileNm fileNm}</td><td>ファイル名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFileSyuruiCd fileSyuruiCd}</td><td>ファイル種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FileSyuruiCdKbn}</td></tr>
 *  <tr><td>{@link #getFileStatusKbn fileStatusKbn}</td><td>ファイルステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FileStatusKbn}</td></tr>
 *  <tr><td>{@link #getHaitaKey haitaKey}</td><td>排他キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTourokuTime tourokuTime}</td><td>登録時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSakuseiKinouId sakuseiKinouId}</td><td>作成機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_FileHozonInfo
 * @see     PKAT_FileHozonInfo
 * @see     QAT_FileHozonInfo
 * @see     GenQAT_FileHozonInfo
 */
@MappedSuperclass
@Table(name=GenAT_FileHozonInfo.TABLE_NAME)
@IdClass(value=PKAT_FileHozonInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_FileStatusKbn", typeClass=UserType_C_FileStatusKbn.class),
    @TypeDef(name="UserType_C_FileSyuruiCdKbn", typeClass=UserType_C_FileSyuruiCdKbn.class)
})
public abstract class GenAT_FileHozonInfo extends AbstractExDBEntity<AT_FileHozonInfo, PKAT_FileHozonInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_FileHozonInfo";
    public static final String UNIQUEID                 = "uniqueId";
    public static final String FILENM                   = "fileNm";
    public static final String FILESYURUICD             = "fileSyuruiCd";
    public static final String FILESTATUSKBN            = "fileStatusKbn";
    public static final String HAITAKEY                 = "haitaKey";
    public static final String TOUROKUTIME              = "tourokuTime";
    public static final String SAKUSEIKINOUID           = "sakuseiKinouId";

    private final PKAT_FileHozonInfo primaryKey;

    public GenAT_FileHozonInfo() {
        primaryKey = new PKAT_FileHozonInfo();
    }

    public GenAT_FileHozonInfo(String pUniqueId) {
        primaryKey = new PKAT_FileHozonInfo(pUniqueId);
    }

    @Transient
    @Override
    public PKAT_FileHozonInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_FileHozonInfo> getMetaClass() {
        return QAT_FileHozonInfo.class;
    }

    @Id
    @Column(name=GenAT_FileHozonInfo.UNIQUEID)
    public String getUniqueId() {
        return getPrimaryKey().getUniqueId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        getPrimaryKey().setUniqueId(pUniqueId);
    }

    private String fileNm;

    @Column(name=GenAT_FileHozonInfo.FILENM)
    public String getFileNm() {
        return fileNm;
    }

    @Trim("both")
    public void setFileNm(String pFileNm) {
        fileNm = pFileNm;
    }

    private C_FileSyuruiCdKbn fileSyuruiCd;

    @Type(type="UserType_C_FileSyuruiCdKbn")
    @Column(name=GenAT_FileHozonInfo.FILESYURUICD)
    public C_FileSyuruiCdKbn getFileSyuruiCd() {
        return fileSyuruiCd;
    }

    public void setFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        fileSyuruiCd = pFileSyuruiCd;
    }

    private C_FileStatusKbn fileStatusKbn;

    @Type(type="UserType_C_FileStatusKbn")
    @Column(name=GenAT_FileHozonInfo.FILESTATUSKBN)
    public C_FileStatusKbn getFileStatusKbn() {
        return fileStatusKbn;
    }

    public void setFileStatusKbn(C_FileStatusKbn pFileStatusKbn) {
        fileStatusKbn = pFileStatusKbn;
    }

    private String haitaKey;

    @Column(name=GenAT_FileHozonInfo.HAITAKEY)
    public String getHaitaKey() {
        return haitaKey;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHaitaKey(String pHaitaKey) {
        haitaKey = pHaitaKey;
    }

    private String tourokuTime;

    @Column(name=GenAT_FileHozonInfo.TOUROKUTIME)
    public String getTourokuTime() {
        return tourokuTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTourokuTime(String pTourokuTime) {
        tourokuTime = pTourokuTime;
    }

    private String sakuseiKinouId;

    @Column(name=GenAT_FileHozonInfo.SAKUSEIKINOUID)
    public String getSakuseiKinouId() {
        return sakuseiKinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSakuseiKinouId(String pSakuseiKinouId) {
        sakuseiKinouId = pSakuseiKinouId;
    }
}