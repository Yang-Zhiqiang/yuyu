package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_JigyouIkkatuNyuukin;
import yuyu.def.db.mapping.GenHT_JigyouIkkatuNyuukin;
import yuyu.def.db.meta.GenQHT_JigyouIkkatuNyuukin;
import yuyu.def.db.meta.QHT_JigyouIkkatuNyuukin;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 事業一括入金テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_JigyouIkkatuNyuukin}</td><td colspan="3">事業一括入金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDaimosno daimosno}</td><td>代表申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>soukinymd</td><td>送金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>soukincd</td><td>送金コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsgaku</td><td>領収金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>ryosyuymd</td><td>領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>rssyouno</td><td>領収証番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenhnknkbn</td><td>全額返金区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZenhnknKbn C_ZenhnknKbn}</td></tr>
 *  <tr><td>srgonyknumu</td><td>成立後入金有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>krkno</td><td>仮受番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dntcd</td><td>団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_JigyouIkkatuNyuukin
 * @see     GenHT_JigyouIkkatuNyuukin
 * @see     QHT_JigyouIkkatuNyuukin
 * @see     GenQHT_JigyouIkkatuNyuukin
 */
public class PKHT_JigyouIkkatuNyuukin extends AbstractExDBPrimaryKey<HT_JigyouIkkatuNyuukin, PKHT_JigyouIkkatuNyuukin> {

    private static final long serialVersionUID = 1L;

    public PKHT_JigyouIkkatuNyuukin() {
    }

    public PKHT_JigyouIkkatuNyuukin(String pDaimosno, Integer pRenno) {
        daimosno = pDaimosno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_JigyouIkkatuNyuukin> getEntityClass() {
        return HT_JigyouIkkatuNyuukin.class;
    }

    private String daimosno;

    public String getDaimosno() {
        return daimosno;
    }

    public void setDaimosno(String pDaimosno) {
        daimosno = pDaimosno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}