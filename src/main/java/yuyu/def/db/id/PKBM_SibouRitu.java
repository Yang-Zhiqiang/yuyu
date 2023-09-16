package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.BM_SibouRitu;
import yuyu.def.db.mapping.GenBM_SibouRitu;
import yuyu.def.db.meta.GenQBM_SibouRitu;
import yuyu.def.db.meta.QBM_SibouRitu;

/**
 * 死亡率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SibouRitu}</td><td colspan="3">死亡率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeibetu seibetu}</td><td>性別</td><td align="center">○</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNenrei nenrei}</td><td>年齢</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sibouritu1</td><td>死亡率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sibouritu2</td><td>死亡率２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaiyakuritu1</td><td>解約率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_SibouRitu
 * @see     GenBM_SibouRitu
 * @see     QBM_SibouRitu
 * @see     GenQBM_SibouRitu
 */
public class PKBM_SibouRitu extends AbstractExDBPrimaryKey<BM_SibouRitu, PKBM_SibouRitu> {

    private static final long serialVersionUID = 1L;

    public PKBM_SibouRitu() {
    }

    public PKBM_SibouRitu(
        String pRyouritusdno,
        C_Seibetu pSeibetu,
        Integer pNenrei
    ) {
        ryouritusdno = pRyouritusdno;
        seibetu = pSeibetu;
        nenrei = pNenrei;
    }

    @Transient
    @Override
    public Class<BM_SibouRitu> getEntityClass() {
        return BM_SibouRitu.class;
    }

    private String ryouritusdno;

    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }
    private C_Seibetu seibetu;

    @org.hibernate.annotations.Type(type="UserType_C_Seibetu")
    public C_Seibetu getSeibetu() {
        return seibetu;
    }

    public void setSeibetu(C_Seibetu pSeibetu) {
        seibetu = pSeibetu;
    }
    private Integer nenrei;

    public Integer getNenrei() {
        return nenrei;
    }

    public void setNenrei(Integer pNenrei) {
        nenrei = pNenrei;
    }

}