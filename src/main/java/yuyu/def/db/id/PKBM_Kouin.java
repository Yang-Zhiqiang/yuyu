package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_Kouin;
import yuyu.def.db.mapping.GenBM_Kouin;
import yuyu.def.db.meta.GenQBM_Kouin;
import yuyu.def.db.meta.QBM_Kouin;

/**
 * 行員マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Kouin}</td><td colspan="3">行員マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinyuucd kinyuucd}</td><td>金融機関コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouincd kouincd}</td><td>行員コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd</td><td>募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Kouin
 * @see     GenBM_Kouin
 * @see     QBM_Kouin
 * @see     GenQBM_Kouin
 */
public class PKBM_Kouin extends AbstractExDBPrimaryKey<BM_Kouin, PKBM_Kouin> {

    private static final long serialVersionUID = 1L;

    public PKBM_Kouin() {
    }

    public PKBM_Kouin(String pKinyuucd, String pKouincd) {
        kinyuucd = pKinyuucd;
        kouincd = pKouincd;
    }

    @Transient
    @Override
    public Class<BM_Kouin> getEntityClass() {
        return BM_Kouin.class;
    }

    private String kinyuucd;

    public String getKinyuucd() {
        return kinyuucd;
    }

    public void setKinyuucd(String pKinyuucd) {
        kinyuucd = pKinyuucd;
    }
    private String kouincd;

    public String getKouincd() {
        return kouincd;
    }

    public void setKouincd(String pKouincd) {
        kouincd = pKouincd;
    }

}