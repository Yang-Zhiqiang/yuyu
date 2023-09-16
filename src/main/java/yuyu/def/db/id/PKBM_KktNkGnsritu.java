package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KktNkGnsritu;
import yuyu.def.db.mapping.GenBM_KktNkGnsritu;
import yuyu.def.db.meta.GenQBM_KktNkGnsritu;
import yuyu.def.db.meta.QBM_KktNkGnsritu;

/**
 * 確定年金原資率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KktNkGnsritu}</td><td colspan="3">確定年金原資率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getShrkkn shrkkn}</td><td>支払期間</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nkgnsritu</td><td>年金原資率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>nkgnsritu2</td><td>年金原資率２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_KktNkGnsritu
 * @see     GenBM_KktNkGnsritu
 * @see     QBM_KktNkGnsritu
 * @see     GenQBM_KktNkGnsritu
 */
public class PKBM_KktNkGnsritu extends AbstractExDBPrimaryKey<BM_KktNkGnsritu, PKBM_KktNkGnsritu> {

    private static final long serialVersionUID = 1L;

    public PKBM_KktNkGnsritu() {
    }

    public PKBM_KktNkGnsritu(
        String pRyouritusdno,
        C_Tuukasyu pTuukasyu,
        Integer pShrkkn
    ) {
        ryouritusdno = pRyouritusdno;
        tuukasyu = pTuukasyu;
        shrkkn = pShrkkn;
    }

    @Transient
    @Override
    public Class<BM_KktNkGnsritu> getEntityClass() {
        return BM_KktNkGnsritu.class;
    }

    private String ryouritusdno;

    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }
    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }
    private Integer shrkkn;

    public Integer getShrkkn() {
        return shrkkn;
    }

    public void setShrkkn(Integer pShrkkn) {
        shrkkn = pShrkkn;
    }

}