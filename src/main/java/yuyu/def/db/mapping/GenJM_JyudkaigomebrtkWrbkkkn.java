package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.JM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.id.PKJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.meta.GenQJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.meta.QJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.type.UserType_C_Seibetu;

/**
 * 重度介護前払特約割引期間マスタ テーブルのマッピング情報クラスで、 {@link JM_JyudkaigomebrtkWrbkkkn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_JyudkaigomebrtkWrbkkkn}</td><td colspan="3">重度介護前払特約割引期間マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">{@link PKJM_JyudkaigomebrtkWrbkkkn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSeibetu seibetu}</td><td>性別</td><td align="center">{@link PKJM_JyudkaigomebrtkWrbkkkn ○}</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getWaribikikikan waribikikikan}</td><td>割引期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     JM_JyudkaigomebrtkWrbkkkn
 * @see     PKJM_JyudkaigomebrtkWrbkkkn
 * @see     QJM_JyudkaigomebrtkWrbkkkn
 * @see     GenQJM_JyudkaigomebrtkWrbkkkn
 */
@MappedSuperclass
@Table(name=GenJM_JyudkaigomebrtkWrbkkkn.TABLE_NAME)
@IdClass(value=PKJM_JyudkaigomebrtkWrbkkkn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class)
})
public abstract class GenJM_JyudkaigomebrtkWrbkkkn extends AbstractExDBEntity<JM_JyudkaigomebrtkWrbkkkn, PKJM_JyudkaigomebrtkWrbkkkn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_JyudkaigomebrtkWrbkkkn";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String SEIBETU                  = "seibetu";
    public static final String WARIBIKIKIKAN            = "waribikikikan";

    private final PKJM_JyudkaigomebrtkWrbkkkn primaryKey;

    public GenJM_JyudkaigomebrtkWrbkkkn() {
        primaryKey = new PKJM_JyudkaigomebrtkWrbkkkn();
    }

    public GenJM_JyudkaigomebrtkWrbkkkn(Integer pHhknnen, C_Seibetu pSeibetu) {
        primaryKey = new PKJM_JyudkaigomebrtkWrbkkkn(pHhknnen, pSeibetu);
    }

    @Transient
    @Override
    public PKJM_JyudkaigomebrtkWrbkkkn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_JyudkaigomebrtkWrbkkkn> getMetaClass() {
        return QJM_JyudkaigomebrtkWrbkkkn.class;
    }

    @Id
    @Column(name=GenJM_JyudkaigomebrtkWrbkkkn.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return getPrimaryKey().getHhknnen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        getPrimaryKey().setHhknnen(pHhknnen);
    }

    @Id
    @Type(type="UserType_C_Seibetu")
    @Column(name=GenJM_JyudkaigomebrtkWrbkkkn.SEIBETU)
    public C_Seibetu getSeibetu() {
        return getPrimaryKey().getSeibetu();
    }

    public void setSeibetu(C_Seibetu pSeibetu) {
        getPrimaryKey().setSeibetu(pSeibetu);
    }

    private BizNumber waribikikikan;

    @Type(type="BizNumberType")
    @Column(name=GenJM_JyudkaigomebrtkWrbkkkn.WARIBIKIKIKAN)
    public BizNumber getWaribikikikan() {
        return waribikikikan;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setWaribikikikan(BizNumber pWaribikikikan) {
        waribikikikan = pWaribikikikan;
    }
}