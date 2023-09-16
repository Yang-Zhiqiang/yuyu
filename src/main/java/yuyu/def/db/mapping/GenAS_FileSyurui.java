package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_FileSyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.id.PKAS_FileSyurui;
import yuyu.def.db.meta.GenQAS_FileSyurui;
import yuyu.def.db.meta.QAS_FileSyurui;
import yuyu.def.db.type.UserType_C_FileSyuruiCdKbn;
import yuyu.def.db.type.UserType_C_FileSyuruiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * ファイル種類基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_FileSyurui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_FileSyurui}</td><td colspan="3">ファイル種類基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getFileSyuruiCd fileSyuruiCd}</td><td>ファイル種類コード</td><td align="center">{@link PKAS_FileSyurui ○}</td><td align="center">V</td><td>{@link C_FileSyuruiCdKbn}</td></tr>
 *  <tr><td>{@link #getFileSyuruiNm fileSyuruiNm}</td><td>ファイル種類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFileSyuruiKbn fileSyuruiKbn}</td><td>ファイル種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FileSyuruiKbn}</td></tr>
 *  <tr><td>{@link #getFileNmPattern fileNmPattern}</td><td>ファイル名パターン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDownloadFileNm downloadFileNm}</td><td>ダウンロードファイル名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFileType fileType}</td><td>ファイルタイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDataLayoutBeanClass dataLayoutBeanClass}</td><td>データレイアウトビーンクラス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreateEmptyFileUmuKbn createEmptyFileUmuKbn}</td><td>空ファイル出力有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 * </table>
 * @see     AS_FileSyurui
 * @see     PKAS_FileSyurui
 * @see     QAS_FileSyurui
 * @see     GenQAS_FileSyurui
 */
@MappedSuperclass
@Table(name=GenAS_FileSyurui.TABLE_NAME)
@IdClass(value=PKAS_FileSyurui.class)
@TypeDefs({
    @TypeDef(name="UserType_C_FileSyuruiCdKbn", typeClass=UserType_C_FileSyuruiCdKbn.class),
    @TypeDef(name="UserType_C_FileSyuruiKbn", typeClass=UserType_C_FileSyuruiKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenAS_FileSyurui extends AbstractExDBEntity<AS_FileSyurui, PKAS_FileSyurui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_FileSyurui";
    public static final String FILESYURUICD             = "fileSyuruiCd";
    public static final String FILESYURUINM             = "fileSyuruiNm";
    public static final String FILESYURUIKBN            = "fileSyuruiKbn";
    public static final String FILENMPATTERN            = "fileNmPattern";
    public static final String DOWNLOADFILENM           = "downloadFileNm";
    public static final String FILETYPE                 = "fileType";
    public static final String DATALAYOUTBEANCLASS      = "dataLayoutBeanClass";
    public static final String CREATEEMPTYFILEUMUKBN    = "createEmptyFileUmuKbn";

    private final PKAS_FileSyurui primaryKey;

    public GenAS_FileSyurui() {
        primaryKey = new PKAS_FileSyurui();
    }

    public GenAS_FileSyurui(C_FileSyuruiCdKbn pFileSyuruiCd) {
        primaryKey = new PKAS_FileSyurui(pFileSyuruiCd);
    }

    @Transient
    @Override
    public PKAS_FileSyurui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_FileSyurui> getMetaClass() {
        return QAS_FileSyurui.class;
    }

    @Id
    @Type(type="UserType_C_FileSyuruiCdKbn")
    @Column(name=GenAS_FileSyurui.FILESYURUICD)
    public C_FileSyuruiCdKbn getFileSyuruiCd() {
        return getPrimaryKey().getFileSyuruiCd();
    }

    public void setFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        getPrimaryKey().setFileSyuruiCd(pFileSyuruiCd);
    }

    private String fileSyuruiNm;

    @Column(name=GenAS_FileSyurui.FILESYURUINM)
    public String getFileSyuruiNm() {
        return fileSyuruiNm;
    }

    @Trim("both")
    public void setFileSyuruiNm(String pFileSyuruiNm) {
        fileSyuruiNm = pFileSyuruiNm;
    }

    private C_FileSyuruiKbn fileSyuruiKbn;

    @Type(type="UserType_C_FileSyuruiKbn")
    @Column(name=GenAS_FileSyurui.FILESYURUIKBN)
    public C_FileSyuruiKbn getFileSyuruiKbn() {
        return fileSyuruiKbn;
    }

    public void setFileSyuruiKbn(C_FileSyuruiKbn pFileSyuruiKbn) {
        fileSyuruiKbn = pFileSyuruiKbn;
    }

    private String fileNmPattern;

    @Column(name=GenAS_FileSyurui.FILENMPATTERN)
    public String getFileNmPattern() {
        return fileNmPattern;
    }

    @Trim("both")
    public void setFileNmPattern(String pFileNmPattern) {
        fileNmPattern = pFileNmPattern;
    }

    private String downloadFileNm;

    @Column(name=GenAS_FileSyurui.DOWNLOADFILENM)
    public String getDownloadFileNm() {
        return downloadFileNm;
    }

    public void setDownloadFileNm(String pDownloadFileNm) {
        downloadFileNm = pDownloadFileNm;
    }

    private String fileType;

    @Column(name=GenAS_FileSyurui.FILETYPE)
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String pFileType) {
        fileType = pFileType;
    }

    private String dataLayoutBeanClass;

    @Column(name=GenAS_FileSyurui.DATALAYOUTBEANCLASS)
    public String getDataLayoutBeanClass() {
        return dataLayoutBeanClass;
    }

    public void setDataLayoutBeanClass(String pDataLayoutBeanClass) {
        dataLayoutBeanClass = pDataLayoutBeanClass;
    }

    private C_UmuKbn createEmptyFileUmuKbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenAS_FileSyurui.CREATEEMPTYFILEUMUKBN)
    public C_UmuKbn getCreateEmptyFileUmuKbn() {
        return createEmptyFileUmuKbn;
    }

    public void setCreateEmptyFileUmuKbn(C_UmuKbn pCreateEmptyFileUmuKbn) {
        createEmptyFileUmuKbn = pCreateEmptyFileUmuKbn;
    }
}