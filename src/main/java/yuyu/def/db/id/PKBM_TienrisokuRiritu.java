package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.BM_TienrisokuRiritu;
import yuyu.def.db.mapping.GenBM_TienrisokuRiritu;
import yuyu.def.db.meta.GenQBM_TienrisokuRiritu;
import yuyu.def.db.meta.QBM_TienrisokuRiritu;

/**
 * 遅延利息利率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_TienrisokuRiritu}</td><td colspan="3">遅延利息利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTekiyoukknfrom tekiyoukknfrom}</td><td>適用期間（自）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTekiyoukknkto tekiyoukknkto}</td><td>適用期間（至）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tienrisokuriritu</td><td>遅延利息利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_TienrisokuRiritu
 * @see     GenBM_TienrisokuRiritu
 * @see     QBM_TienrisokuRiritu
 * @see     GenQBM_TienrisokuRiritu
 */
public class PKBM_TienrisokuRiritu extends AbstractExDBPrimaryKey<BM_TienrisokuRiritu, PKBM_TienrisokuRiritu> {

    private static final long serialVersionUID = 1L;

    public PKBM_TienrisokuRiritu() {
    }

    public PKBM_TienrisokuRiritu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        tekiyoukknfrom = pTekiyoukknfrom;
        tekiyoukknkto = pTekiyoukknkto;
    }

    @Transient
    @Override
    public Class<BM_TienrisokuRiritu> getEntityClass() {
        return BM_TienrisokuRiritu.class;
    }

    private String tekiyoukknfrom;

    public String getTekiyoukknfrom() {
        return tekiyoukknfrom;
    }

    public void setTekiyoukknfrom(String pTekiyoukknfrom) {
        tekiyoukknfrom = pTekiyoukknfrom;
    }
    private String tekiyoukknkto;

    public String getTekiyoukknkto() {
        return tekiyoukknkto;
    }

    public void setTekiyoukknkto(String pTekiyoukknkto) {
        tekiyoukknkto = pTekiyoukknkto;
    }

}