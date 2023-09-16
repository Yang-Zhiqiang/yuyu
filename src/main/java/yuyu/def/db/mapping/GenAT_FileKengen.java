package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AT_FileKengen;
import yuyu.def.db.id.PKAT_FileKengen;
import yuyu.def.db.meta.GenQAT_FileKengen;
import yuyu.def.db.meta.QAT_FileKengen;
import yuyu.def.db.type.UserType_C_FileSyuruiCdKbn;

/**
 * ファイル権限テーブル テーブルのマッピング情報クラスで、 {@link AT_FileKengen} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileKengen}</td><td colspan="3">ファイル権限テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">{@link PKAT_FileKengen ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFileSyuruiCd fileSyuruiCd}</td><td>ファイル種類コード</td><td align="center">{@link PKAT_FileKengen ○}</td><td align="center">V</td><td>{@link C_FileSyuruiCdKbn}</td></tr>
 * </table>
 * @see     AT_FileKengen
 * @see     PKAT_FileKengen
 * @see     QAT_FileKengen
 * @see     GenQAT_FileKengen
 */
@MappedSuperclass
@Table(name=GenAT_FileKengen.TABLE_NAME)
@IdClass(value=PKAT_FileKengen.class)
@TypeDefs({
    @TypeDef(name="UserType_C_FileSyuruiCdKbn", typeClass=UserType_C_FileSyuruiCdKbn.class)
})
public abstract class GenAT_FileKengen extends AbstractExDBEntity<AT_FileKengen, PKAT_FileKengen> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_FileKengen";
    public static final String ROLECD                   = "roleCd";
    public static final String FILESYURUICD             = "fileSyuruiCd";

    private final PKAT_FileKengen primaryKey;

    public GenAT_FileKengen() {
        primaryKey = new PKAT_FileKengen();
    }

    public GenAT_FileKengen(String pRoleCd, C_FileSyuruiCdKbn pFileSyuruiCd) {
        primaryKey = new PKAT_FileKengen(pRoleCd, pFileSyuruiCd);
    }

    @Transient
    @Override
    public PKAT_FileKengen getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_FileKengen> getMetaClass() {
        return QAT_FileKengen.class;
    }

    @Id
    @Column(name=GenAT_FileKengen.ROLECD)
    @MaxLength(max=30)
    @AlphaDigit
    public String getRoleCd() {
        return getPrimaryKey().getRoleCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRoleCd(String pRoleCd) {
        getPrimaryKey().setRoleCd(pRoleCd);
    }

    @Id
    @Type(type="UserType_C_FileSyuruiCdKbn")
    @Column(name=GenAT_FileKengen.FILESYURUICD)
    public C_FileSyuruiCdKbn getFileSyuruiCd() {
        return getPrimaryKey().getFileSyuruiCd();
    }

    public void setFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        getPrimaryKey().setFileSyuruiCd(pFileSyuruiCd);
    }
}