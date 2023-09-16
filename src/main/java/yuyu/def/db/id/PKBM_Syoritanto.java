package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_Syoritanto;
import yuyu.def.db.mapping.GenBM_Syoritanto;
import yuyu.def.db.meta.GenQBM_Syoritanto;
import yuyu.def.db.meta.QBM_Syoritanto;

/**
 * 処理担当マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Syoritanto}</td><td colspan="3">処理担当マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tantocd</td><td>担当コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TantouCdKbn C_TantouCdKbn}</td></tr>
 * </table>
 * @see     BM_Syoritanto
 * @see     GenBM_Syoritanto
 * @see     QBM_Syoritanto
 * @see     GenQBM_Syoritanto
 */
public class PKBM_Syoritanto extends AbstractExDBPrimaryKey<BM_Syoritanto, PKBM_Syoritanto> {

    private static final long serialVersionUID = 1L;

    public PKBM_Syoritanto() {
    }

    public PKBM_Syoritanto(String pSyoricd) {
        syoricd = pSyoricd;
    }

    @Transient
    @Override
    public Class<BM_Syoritanto> getEntityClass() {
        return BM_Syoritanto.class;
    }

    private String syoricd;

    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

}