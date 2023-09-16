package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.JM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.mapping.GenJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.meta.GenQJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.meta.QJM_JyudkaigomebrtkWrbkkkn;

/**
 * 重度介護前払特約割引期間マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_JyudkaigomebrtkWrbkkkn}</td><td colspan="3">重度介護前払特約割引期間マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeibetu seibetu}</td><td>性別</td><td align="center">○</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>waribikikikan</td><td>割引期間</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     JM_JyudkaigomebrtkWrbkkkn
 * @see     GenJM_JyudkaigomebrtkWrbkkkn
 * @see     QJM_JyudkaigomebrtkWrbkkkn
 * @see     GenQJM_JyudkaigomebrtkWrbkkkn
 */
public class PKJM_JyudkaigomebrtkWrbkkkn extends AbstractExDBPrimaryKey<JM_JyudkaigomebrtkWrbkkkn, PKJM_JyudkaigomebrtkWrbkkkn> {

    private static final long serialVersionUID = 1L;

    public PKJM_JyudkaigomebrtkWrbkkkn() {
    }

    public PKJM_JyudkaigomebrtkWrbkkkn(Integer pHhknnen, C_Seibetu pSeibetu) {
        hhknnen = pHhknnen;
        seibetu = pSeibetu;
    }

    @Transient
    @Override
    public Class<JM_JyudkaigomebrtkWrbkkkn> getEntityClass() {
        return JM_JyudkaigomebrtkWrbkkkn.class;
    }

    private Integer hhknnen;

    public Integer getHhknnen() {
        return hhknnen;
    }

    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }
    private C_Seibetu seibetu;

    @org.hibernate.annotations.Type(type="UserType_C_Seibetu")
    public C_Seibetu getSeibetu() {
        return seibetu;
    }

    public void setSeibetu(C_Seibetu pSeibetu) {
        seibetu = pSeibetu;
    }

}