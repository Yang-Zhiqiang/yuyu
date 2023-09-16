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
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.def.db.mapping.GenHM_TokuteiKankeiHoujin;
import yuyu.def.db.meta.GenQHM_TokuteiKankeiHoujin;
import yuyu.def.db.meta.QHM_TokuteiKankeiHoujin;

/**
 * 特定関係法人マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_TokuteiKankeiHoujin}</td><td colspan="3">特定関係法人マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkhjnkinyuucd tkhjnkinyuucd}</td><td>特定関係法人金融機関コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMeisaino meisaino}</td><td>明細番号</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>marukinhyouji</td><td>マル金表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tkhjnkjdrtennm</td><td>特定関係法人漢字代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitenbtno</td><td>代理店別通番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tkhjnnmkj</td><td>特定関係法人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tkhjnnmkn</td><td>特定関係法人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kosymd</td><td>更新日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     HM_TokuteiKankeiHoujin
 * @see     GenHM_TokuteiKankeiHoujin
 * @see     QHM_TokuteiKankeiHoujin
 * @see     GenQHM_TokuteiKankeiHoujin
 */
public class PKHM_TokuteiKankeiHoujin extends AbstractExDBPrimaryKey<HM_TokuteiKankeiHoujin, PKHM_TokuteiKankeiHoujin> {

    private static final long serialVersionUID = 1L;

    public PKHM_TokuteiKankeiHoujin() {
    }

    public PKHM_TokuteiKankeiHoujin(String pTkhjnkinyuucd, BizNumber pMeisaino) {
        tkhjnkinyuucd = pTkhjnkinyuucd;
        meisaino = pMeisaino;
    }

    @Transient
    @Override
    public Class<HM_TokuteiKankeiHoujin> getEntityClass() {
        return HM_TokuteiKankeiHoujin.class;
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

}