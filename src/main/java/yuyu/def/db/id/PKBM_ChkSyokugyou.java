package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BM_ChkSyokugyou;
import yuyu.def.db.mapping.GenBM_ChkSyokugyou;
import yuyu.def.db.meta.GenQBM_ChkSyokugyou;
import yuyu.def.db.meta.QBM_ChkSyokugyou;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * 職業制限チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkSyokugyou}</td><td colspan="3">職業制限チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyokugyoucd syokugyoucd}</td><td>職業コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gndntgk</td><td>限度日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gnds</td><td>限度Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkSyokugyou
 * @see     GenBM_ChkSyokugyou
 * @see     QBM_ChkSyokugyou
 * @see     GenQBM_ChkSyokugyou
 */
public class PKBM_ChkSyokugyou extends AbstractExDBPrimaryKey<BM_ChkSyokugyou, PKBM_ChkSyokugyou> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkSyokugyou() {
    }

    public PKBM_ChkSyokugyou(String pSyokugyoucd) {
        syokugyoucd = pSyokugyoucd;
    }

    @Transient
    @Override
    public Class<BM_ChkSyokugyou> getEntityClass() {
        return BM_ChkSyokugyou.class;
    }

    private String syokugyoucd;

    public String getSyokugyoucd() {
        return syokugyoucd;
    }

    public void setSyokugyoucd(String pSyokugyoucd) {
        syokugyoucd = pSyokugyoucd;
    }

}