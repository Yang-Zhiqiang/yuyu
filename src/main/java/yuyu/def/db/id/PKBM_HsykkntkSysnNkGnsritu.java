package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.mapping.GenBM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.meta.GenQBM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.meta.QBM_HsykkntkSysnNkGnsritu;

/**
 * 保証期間付終身年金原資率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_HsykkntkSysnNkGnsritu}</td><td colspan="3">保証期間付終身年金原資率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeibetu seibetu}</td><td>性別</td><td align="center">○</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNkshrstartnen nkshrstartnen}</td><td>年金支払開始年齢</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hsykkn</td><td>保証期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nkgnsritu</td><td>年金原資率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_HsykkntkSysnNkGnsritu
 * @see     GenBM_HsykkntkSysnNkGnsritu
 * @see     QBM_HsykkntkSysnNkGnsritu
 * @see     GenQBM_HsykkntkSysnNkGnsritu
 */
public class PKBM_HsykkntkSysnNkGnsritu extends AbstractExDBPrimaryKey<BM_HsykkntkSysnNkGnsritu, PKBM_HsykkntkSysnNkGnsritu> {

    private static final long serialVersionUID = 1L;

    public PKBM_HsykkntkSysnNkGnsritu() {
    }

    public PKBM_HsykkntkSysnNkGnsritu(
        String pRyouritusdno,
        C_Tuukasyu pTuukasyu,
        C_Seibetu pSeibetu,
        Integer pNkshrstartnen
    ) {
        ryouritusdno = pRyouritusdno;
        tuukasyu = pTuukasyu;
        seibetu = pSeibetu;
        nkshrstartnen = pNkshrstartnen;
    }

    @Transient
    @Override
    public Class<BM_HsykkntkSysnNkGnsritu> getEntityClass() {
        return BM_HsykkntkSysnNkGnsritu.class;
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
    private C_Seibetu seibetu;

    @org.hibernate.annotations.Type(type="UserType_C_Seibetu")
    public C_Seibetu getSeibetu() {
        return seibetu;
    }

    public void setSeibetu(C_Seibetu pSeibetu) {
        seibetu = pSeibetu;
    }
    private Integer nkshrstartnen;

    public Integer getNkshrstartnen() {
        return nkshrstartnen;
    }

    public void setNkshrstartnen(Integer pNkshrstartnen) {
        nkshrstartnen = pNkshrstartnen;
    }

}