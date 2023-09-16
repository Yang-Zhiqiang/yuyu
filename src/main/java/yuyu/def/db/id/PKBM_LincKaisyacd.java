package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_LincKaisyacd;
import yuyu.def.db.mapping.GenBM_LincKaisyacd;
import yuyu.def.db.meta.GenQBM_LincKaisyacd;
import yuyu.def.db.meta.QBM_LincKaisyacd;

/**
 * ＬＩＮＣ会社コードマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_LincKaisyacd}</td><td colspan="3">ＬＩＮＣ会社コードマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getLinckaisyacdnum linckaisyacdnum}</td><td>ＬＩＮＣ会社コード（数字）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckaisyanm</td><td>ＬＩＮＣ会社名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_LincKaisyacd
 * @see     GenBM_LincKaisyacd
 * @see     QBM_LincKaisyacd
 * @see     GenQBM_LincKaisyacd
 */
public class PKBM_LincKaisyacd extends AbstractExDBPrimaryKey<BM_LincKaisyacd, PKBM_LincKaisyacd> {

    private static final long serialVersionUID = 1L;

    public PKBM_LincKaisyacd() {
    }

    public PKBM_LincKaisyacd(String pLinckaisyacdnum) {
        linckaisyacdnum = pLinckaisyacdnum;
    }

    @Transient
    @Override
    public Class<BM_LincKaisyacd> getEntityClass() {
        return BM_LincKaisyacd.class;
    }

    private String linckaisyacdnum;

    public String getLinckaisyacdnum() {
        return linckaisyacdnum;
    }

    public void setLinckaisyacdnum(String pLinckaisyacdnum) {
        linckaisyacdnum = pLinckaisyacdnum;
    }

}