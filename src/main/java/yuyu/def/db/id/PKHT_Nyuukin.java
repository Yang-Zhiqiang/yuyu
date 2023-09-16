package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.mapping.GenHT_Nyuukin;
import yuyu.def.db.meta.GenQHT_Nyuukin;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 入金テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_Nyuukin}</td><td colspan="3">入金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>soukinymd</td><td>送金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tyakkinymd</td><td>着金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyksyoriymd</td><td>入金処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyuukinsyoritime</td><td>入金処理日時</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyknsyubetu</td><td>入金種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyknsyubetuKbn C_NyknsyubetuKbn}</td></tr>
 *  <tr><td>soukincd</td><td>送金コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsgaku</td><td>領収金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rstuukasyu</td><td>領収通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>ryosyuymd</td><td>領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>rssyouno</td><td>領収証番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenhnknkbn</td><td>全額返金区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZenhnknKbn C_ZenhnknKbn}</td></tr>
 *  <tr><td>srgonyknumu</td><td>成立後入金有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>denrenno</td><td>伝票データ連番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>denrenno2</td><td>伝票データ連番２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>edano</td><td>枝番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>krkno</td><td>仮受番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dntcd</td><td>団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuukinhenkinsyorikbn</td><td>入金返金処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyuukinHenkinSyoriKbn C_NyuukinHenkinSyoriKbn}</td></tr>
 *  <tr><td>zenhnknrenno</td><td>全額返金連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_Nyuukin
 * @see     GenHT_Nyuukin
 * @see     QHT_Nyuukin
 * @see     GenQHT_Nyuukin
 */
public class PKHT_Nyuukin extends AbstractExDBPrimaryKey<HT_Nyuukin, PKHT_Nyuukin> {

    private static final long serialVersionUID = 1L;

    public PKHT_Nyuukin() {
    }

    public PKHT_Nyuukin(String pMosno, Integer pRenno) {
        mosno = pMosno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_Nyuukin> getEntityClass() {
        return HT_Nyuukin.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}