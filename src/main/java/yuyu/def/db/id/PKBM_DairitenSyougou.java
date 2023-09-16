package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BM_DairitenSyougou;
import yuyu.def.db.mapping.GenBM_DairitenSyougou;
import yuyu.def.db.meta.GenQBM_DairitenSyougou;
import yuyu.def.db.meta.QBM_DairitenSyougou;

/**
 * 代理店法人商号マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_DairitenSyougou}</td><td colspan="3">代理店法人商号マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanjihoujinsyougou</td><td>漢字法人商号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_DairitenSyougou
 * @see     GenBM_DairitenSyougou
 * @see     QBM_DairitenSyougou
 * @see     GenQBM_DairitenSyougou
 */
public class PKBM_DairitenSyougou extends AbstractExDBPrimaryKey<BM_DairitenSyougou, PKBM_DairitenSyougou> {

    private static final long serialVersionUID = 1L;

    public PKBM_DairitenSyougou() {
    }

    public PKBM_DairitenSyougou(String pDrtencd) {
        drtencd = pDrtencd;
    }

    @Transient
    @Override
    public Class<BM_DairitenSyougou> getEntityClass() {
        return BM_DairitenSyougou.class;
    }

    private String drtencd;

    public String getDrtencd() {
        return drtencd;
    }

    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

}