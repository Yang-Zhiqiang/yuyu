package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.def.db.mapping.GenHT_HrkmNyknSakujyo;
import yuyu.def.db.meta.GenQHT_HrkmNyknSakujyo;
import yuyu.def.db.meta.QHT_HrkmNyknSakujyo;

/**
 * 振込入金削除テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_HrkmNyknSakujyo}</td><td colspan="3">振込入金削除テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmdeldataskbtkey hrkmdeldataskbtkey}</td><td>振込入金削除データ識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkymd</td><td>登録日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyksyoriymd</td><td>入金処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>itirenno</td><td>一連番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nykmosno</td><td>入金用申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmirninnm</td><td>振込依頼人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trhkkgk</td><td>取引金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rstuukasyu</td><td>領収通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>knjyymd</td><td>勘定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmirnincd</td><td>振込依頼人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorizumiflg</td><td>処理済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syorizumiflg C_Syorizumiflg}</td></tr>
 *  <tr><td>hrkmnykndatarenmotoKbn</td><td>振込入金データ連携元区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkmnykndatarenmotoKbn C_HrkmnykndatarenmotoKbn}</td></tr>
 *  <tr><td>nyktyhyoutkbn</td><td>入金帳票出力先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyktyhyoutKbn C_NyktyhyoutKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_HrkmNyknSakujyo
 * @see     GenHT_HrkmNyknSakujyo
 * @see     QHT_HrkmNyknSakujyo
 * @see     GenQHT_HrkmNyknSakujyo
 */
public class PKHT_HrkmNyknSakujyo extends AbstractExDBPrimaryKey<HT_HrkmNyknSakujyo, PKHT_HrkmNyknSakujyo> {

    private static final long serialVersionUID = 1L;

    public PKHT_HrkmNyknSakujyo() {
    }

    public PKHT_HrkmNyknSakujyo(String pHrkmdeldataskbtkey) {
        hrkmdeldataskbtkey = pHrkmdeldataskbtkey;
    }

    @Transient
    @Override
    public Class<HT_HrkmNyknSakujyo> getEntityClass() {
        return HT_HrkmNyknSakujyo.class;
    }

    private String hrkmdeldataskbtkey;

    public String getHrkmdeldataskbtkey() {
        return hrkmdeldataskbtkey;
    }

    public void setHrkmdeldataskbtkey(String pHrkmdeldataskbtkey) {
        hrkmdeldataskbtkey = pHrkmdeldataskbtkey;
    }

}