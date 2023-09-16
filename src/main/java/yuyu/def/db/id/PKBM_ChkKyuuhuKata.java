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
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.BM_ChkKyuuhuKata;
import yuyu.def.db.mapping.GenBM_ChkKyuuhuKata;
import yuyu.def.db.meta.GenQBM_ChkKyuuhuKata;
import yuyu.def.db.meta.QBM_ChkKyuuhuKata;

/**
 * 給付型チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKyuuhuKata}</td><td colspan="3">給付型チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyhkatakbn kyhkatakbn}</td><td>給付型区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 * </table>
 * @see     BM_ChkKyuuhuKata
 * @see     GenBM_ChkKyuuhuKata
 * @see     QBM_ChkKyuuhuKata
 * @see     GenQBM_ChkKyuuhuKata
 */
public class PKBM_ChkKyuuhuKata extends AbstractExDBPrimaryKey<BM_ChkKyuuhuKata, PKBM_ChkKyuuhuKata> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkKyuuhuKata() {
    }

    public PKBM_ChkKyuuhuKata(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_KyhgndkataKbn pKyhkatakbn
    ) {
        syouhncd = pSyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        kyhkatakbn = pKyhkatakbn;
    }

    @Transient
    @Override
    public Class<BM_ChkKyuuhuKata> getEntityClass() {
        return BM_ChkKyuuhuKata.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer syusyouhnsdnofrom;

    public Integer getSyusyouhnsdnofrom() {
        return syusyouhnsdnofrom;
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
    }
    private Integer syusyouhnsdnoto;

    public Integer getSyusyouhnsdnoto() {
        return syusyouhnsdnoto;
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        syusyouhnsdnoto = pSyusyouhnsdnoto;
    }
    private C_KyhgndkataKbn kyhkatakbn;

    @org.hibernate.annotations.Type(type="UserType_C_KyhgndkataKbn")
    public C_KyhgndkataKbn getKyhkatakbn() {
        return kyhkatakbn;
    }

    public void setKyhkatakbn(C_KyhgndkataKbn pKyhkatakbn) {
        kyhkatakbn = pKyhkatakbn;
    }

}