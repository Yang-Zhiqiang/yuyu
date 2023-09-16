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
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_NengappiKbn;
import yuyu.def.db.entity.AS_FileHozonKikan;
import yuyu.def.db.id.PKAS_FileHozonKikan;
import yuyu.def.db.meta.GenQAS_FileHozonKikan;
import yuyu.def.db.meta.QAS_FileHozonKikan;
import yuyu.def.db.type.UserType_C_FileSyuruiCdKbn;
import yuyu.def.db.type.UserType_C_NengappiKbn;

/**
 * ファイル保存期間基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_FileHozonKikan} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_FileHozonKikan}</td><td colspan="3">ファイル保存期間基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getFileSyuruiCd fileSyuruiCd}</td><td>ファイル種類コード</td><td align="center">{@link PKAS_FileHozonKikan ○}</td><td align="center">V</td><td>{@link C_FileSyuruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHozonKikan hozonKikan}</td><td>保存期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNengappiKbn nengappiKbn}</td><td>年月日区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NengappiKbn}</td></tr>
 * </table>
 * @see     AS_FileHozonKikan
 * @see     PKAS_FileHozonKikan
 * @see     QAS_FileHozonKikan
 * @see     GenQAS_FileHozonKikan
 */
@MappedSuperclass
@Table(name=GenAS_FileHozonKikan.TABLE_NAME)
@IdClass(value=PKAS_FileHozonKikan.class)
@TypeDefs({
    @TypeDef(name="UserType_C_FileSyuruiCdKbn", typeClass=UserType_C_FileSyuruiCdKbn.class),
    @TypeDef(name="UserType_C_NengappiKbn", typeClass=UserType_C_NengappiKbn.class)
})
public abstract class GenAS_FileHozonKikan extends AbstractExDBEntity<AS_FileHozonKikan, PKAS_FileHozonKikan> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_FileHozonKikan";
    public static final String FILESYURUICD             = "fileSyuruiCd";
    public static final String HOZONKIKAN               = "hozonKikan";
    public static final String NENGAPPIKBN              = "nengappiKbn";

    private final PKAS_FileHozonKikan primaryKey;

    public GenAS_FileHozonKikan() {
        primaryKey = new PKAS_FileHozonKikan();
    }

    public GenAS_FileHozonKikan(C_FileSyuruiCdKbn pFileSyuruiCd) {
        primaryKey = new PKAS_FileHozonKikan(pFileSyuruiCd);
    }

    @Transient
    @Override
    public PKAS_FileHozonKikan getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_FileHozonKikan> getMetaClass() {
        return QAS_FileHozonKikan.class;
    }

    @Id
    @Type(type="UserType_C_FileSyuruiCdKbn")
    @Column(name=GenAS_FileHozonKikan.FILESYURUICD)
    public C_FileSyuruiCdKbn getFileSyuruiCd() {
        return getPrimaryKey().getFileSyuruiCd();
    }

    public void setFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        getPrimaryKey().setFileSyuruiCd(pFileSyuruiCd);
    }

    private Integer hozonKikan;

    @Column(name=GenAS_FileHozonKikan.HOZONKIKAN)
    public Integer getHozonKikan() {
        return hozonKikan;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHozonKikan(Integer pHozonKikan) {
        hozonKikan = pHozonKikan;
    }

    private C_NengappiKbn nengappiKbn;

    @Type(type="UserType_C_NengappiKbn")
    @Column(name=GenAS_FileHozonKikan.NENGAPPIKBN)
    public C_NengappiKbn getNengappiKbn() {
        return nengappiKbn;
    }

    public void setNengappiKbn(C_NengappiKbn pNengappiKbn) {
        nengappiKbn = pNengappiKbn;
    }
}