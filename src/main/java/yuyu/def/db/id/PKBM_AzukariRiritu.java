package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_AzukariRiritu;
import yuyu.def.db.mapping.GenBM_AzukariRiritu;
import yuyu.def.db.meta.GenQBM_AzukariRiritu;
import yuyu.def.db.meta.QBM_AzukariRiritu;

/**
 * 預り利率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_AzukariRiritu}</td><td colspan="3">預り利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkyfromymd tkyfromymd}</td><td>適用日自</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkytoymd tkytoymd}</td><td>適用日至</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>azukaririritu</td><td>預り利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_AzukariRiritu
 * @see     GenBM_AzukariRiritu
 * @see     QBM_AzukariRiritu
 * @see     GenQBM_AzukariRiritu
 */
public class PKBM_AzukariRiritu extends AbstractExDBPrimaryKey<BM_AzukariRiritu, PKBM_AzukariRiritu> {

    private static final long serialVersionUID = 1L;

    public PKBM_AzukariRiritu() {
    }

    public PKBM_AzukariRiritu(
        C_Tuukasyu pTuukasyu,
        BizDate pTkyfromymd,
        BizDate pTkytoymd
    ) {
        tuukasyu = pTuukasyu;
        tkyfromymd = pTkyfromymd;
        tkytoymd = pTkytoymd;
    }

    @Transient
    @Override
    public Class<BM_AzukariRiritu> getEntityClass() {
        return BM_AzukariRiritu.class;
    }

    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }
    private BizDate tkyfromymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTkyfromymd() {
        return tkyfromymd;
    }

    public void setTkyfromymd(BizDate pTkyfromymd) {
        tkyfromymd = pTkyfromymd;
    }
    private BizDate tkytoymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTkytoymd() {
        return tkytoymd;
    }

    public void setTkytoymd(BizDate pTkytoymd) {
        tkytoymd = pTkytoymd;
    }

}