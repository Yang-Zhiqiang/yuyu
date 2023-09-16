package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_Tuuka;
import yuyu.def.db.mapping.GenBM_Tuuka;
import yuyu.def.db.meta.GenQBM_Tuuka;
import yuyu.def.db.meta.QBM_Tuuka;

/**
 * 通貨マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Tuuka}</td><td colspan="3">通貨マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>ssketasuu</td><td>小数桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tuukasyumei</td><td>通貨種類正式名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuukasyuryk</td><td>通貨種類略称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Tuuka
 * @see     GenBM_Tuuka
 * @see     QBM_Tuuka
 * @see     GenQBM_Tuuka
 */
public class PKBM_Tuuka extends AbstractExDBPrimaryKey<BM_Tuuka, PKBM_Tuuka> {

    private static final long serialVersionUID = 1L;

    public PKBM_Tuuka() {
    }

    public PKBM_Tuuka(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    @Transient
    @Override
    public Class<BM_Tuuka> getEntityClass() {
        return BM_Tuuka.class;
    }

    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

}