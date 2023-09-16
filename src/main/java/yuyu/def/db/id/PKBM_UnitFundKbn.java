package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_UnitFundKbn;
import yuyu.def.db.mapping.GenBM_UnitFundKbn;
import yuyu.def.db.meta.GenQBM_UnitFundKbn;
import yuyu.def.db.meta.QBM_UnitFundKbn;

/**
 * ユニットファンド区分マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_UnitFundKbn}</td><td colspan="3">ユニットファンド区分マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>unitfundkbn</td><td>ユニットファンド区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UnitFundKbn C_UnitFundKbn}</td></tr>
 * </table>
 * @see     BM_UnitFundKbn
 * @see     GenBM_UnitFundKbn
 * @see     QBM_UnitFundKbn
 * @see     GenQBM_UnitFundKbn
 */
public class PKBM_UnitFundKbn extends AbstractExDBPrimaryKey<BM_UnitFundKbn, PKBM_UnitFundKbn> {

    private static final long serialVersionUID = 1L;

    public PKBM_UnitFundKbn() {
    }

    public PKBM_UnitFundKbn(
        String pSyouhncd,
        Integer pSyouhnsdno,
        C_Tuukasyu pTuukasyu,
        Integer pRenno
    ) {
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        tuukasyu = pTuukasyu;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<BM_UnitFundKbn> getEntityClass() {
        return BM_UnitFundKbn.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer syouhnsdno;

    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }
    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}