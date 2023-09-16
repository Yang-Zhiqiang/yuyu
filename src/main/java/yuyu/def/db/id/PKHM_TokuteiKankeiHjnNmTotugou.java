package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.mapping.GenHM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.meta.GenQHM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.meta.QHM_TokuteiKankeiHjnNmTotugou;

/**
 * 特定関係法人名突合マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_TokuteiKankeiHjnNmTotugou}</td><td colspan="3">特定関係法人名突合マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkhjnkinyuucd tkhjnkinyuucd}</td><td>特定関係法人金融機関コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMeisaino meisaino}</td><td>明細番号</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>totugoutkhjnnmkj</td><td>突合用特定関係法人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_TokuteiKankeiHjnNmTotugou
 * @see     GenHM_TokuteiKankeiHjnNmTotugou
 * @see     QHM_TokuteiKankeiHjnNmTotugou
 * @see     GenQHM_TokuteiKankeiHjnNmTotugou
 */
public class PKHM_TokuteiKankeiHjnNmTotugou extends AbstractExDBPrimaryKey<HM_TokuteiKankeiHjnNmTotugou, PKHM_TokuteiKankeiHjnNmTotugou> {

    private static final long serialVersionUID = 1L;

    public PKHM_TokuteiKankeiHjnNmTotugou() {
    }

    public PKHM_TokuteiKankeiHjnNmTotugou(
        String pTkhjnkinyuucd,
        BizNumber pMeisaino,
        Integer pRenno
    ) {
        tkhjnkinyuucd = pTkhjnkinyuucd;
        meisaino = pMeisaino;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HM_TokuteiKankeiHjnNmTotugou> getEntityClass() {
        return HM_TokuteiKankeiHjnNmTotugou.class;
    }

    private String tkhjnkinyuucd;

    public String getTkhjnkinyuucd() {
        return tkhjnkinyuucd;
    }

    public void setTkhjnkinyuucd(String pTkhjnkinyuucd) {
        tkhjnkinyuucd = pTkhjnkinyuucd;
    }
    private BizNumber meisaino;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getMeisaino() {
        return meisaino;
    }

    public void setMeisaino(BizNumber pMeisaino) {
        meisaino = pMeisaino;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}