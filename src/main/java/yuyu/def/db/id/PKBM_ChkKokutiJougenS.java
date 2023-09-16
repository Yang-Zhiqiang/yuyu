package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkKokutiJougenS;
import yuyu.def.db.mapping.GenBM_ChkKokutiJougenS;
import yuyu.def.db.meta.GenQBM_ChkKokutiJougenS;
import yuyu.def.db.meta.QBM_ChkKokutiJougenS;

/**
 * 告知上限Ｓチェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKokutiJougenS}</td><td colspan="3">告知上限Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMoskbnfrom moskbnfrom}</td><td>申込区分自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMoskbnto moskbnto}</td><td>申込区分至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>saikous</td><td>最高Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkKokutiJougenS
 * @see     GenBM_ChkKokutiJougenS
 * @see     QBM_ChkKokutiJougenS
 * @see     GenQBM_ChkKokutiJougenS
 */
public class PKBM_ChkKokutiJougenS extends AbstractExDBPrimaryKey<BM_ChkKokutiJougenS, PKBM_ChkKokutiJougenS> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkKokutiJougenS() {
    }

    public PKBM_ChkKokutiJougenS(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        Integer pMoskbnfrom,
        Integer pMoskbnto
    ) {
        syouhncd = pSyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        hhknfromnen = pHhknfromnen;
        hhkntonen = pHhkntonen;
        moskbnfrom = pMoskbnfrom;
        moskbnto = pMoskbnto;
    }

    @Transient
    @Override
    public Class<BM_ChkKokutiJougenS> getEntityClass() {
        return BM_ChkKokutiJougenS.class;
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
    private BizNumber hhknfromnen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHhknfromnen() {
        return hhknfromnen;
    }

    public void setHhknfromnen(BizNumber pHhknfromnen) {
        hhknfromnen = pHhknfromnen;
    }
    private BizNumber hhkntonen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHhkntonen() {
        return hhkntonen;
    }

    public void setHhkntonen(BizNumber pHhkntonen) {
        hhkntonen = pHhkntonen;
    }
    private Integer moskbnfrom;

    public Integer getMoskbnfrom() {
        return moskbnfrom;
    }

    public void setMoskbnfrom(Integer pMoskbnfrom) {
        moskbnfrom = pMoskbnfrom;
    }
    private Integer moskbnto;

    public Integer getMoskbnto() {
        return moskbnto;
    }

    public void setMoskbnto(Integer pMoskbnto) {
        moskbnto = pMoskbnto;
    }

}