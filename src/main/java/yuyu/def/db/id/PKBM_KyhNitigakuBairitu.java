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
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.BM_KyhNitigakuBairitu;
import yuyu.def.db.mapping.GenBM_KyhNitigakuBairitu;
import yuyu.def.db.meta.GenQBM_KyhNitigakuBairitu;
import yuyu.def.db.meta.QBM_KyhNitigakuBairitu;

/**
 * 給付日額倍率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KyhNitigakuBairitu}</td><td colspan="3">給付日額倍率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKatakbn katakbn}</td><td>型区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>kyhngbairitu</td><td>給付日額倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_KyhNitigakuBairitu
 * @see     GenBM_KyhNitigakuBairitu
 * @see     QBM_KyhNitigakuBairitu
 * @see     GenQBM_KyhNitigakuBairitu
 */
public class PKBM_KyhNitigakuBairitu extends AbstractExDBPrimaryKey<BM_KyhNitigakuBairitu, PKBM_KyhNitigakuBairitu> {

    private static final long serialVersionUID = 1L;

    public PKBM_KyhNitigakuBairitu() {
    }

    public PKBM_KyhNitigakuBairitu(
        String pSyouhncd,
        Integer pSyouhnsdno,
        C_KataKbn pKatakbn
    ) {
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        katakbn = pKatakbn;
    }

    @Transient
    @Override
    public Class<BM_KyhNitigakuBairitu> getEntityClass() {
        return BM_KyhNitigakuBairitu.class;
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
    private C_KataKbn katakbn;

    @org.hibernate.annotations.Type(type="UserType_C_KataKbn")
    public C_KataKbn getKatakbn() {
        return katakbn;
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        katakbn = pKatakbn;
    }

}