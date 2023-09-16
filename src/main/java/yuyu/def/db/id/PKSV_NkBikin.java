package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.SV_NkBikin;
import yuyu.def.db.mapping.GenSV_NkBikin;
import yuyu.def.db.meta.GenQSV_NkBikin;
import yuyu.def.db.meta.QSV_NkBikin;

/**
 * 年金備金ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_NkBikin}</td><td colspan="3">年金備金ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>seisikakymd</td><td>生死確認日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkkknsetymd</td><td>年金基金設定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nextnsymd</td><td>次回年金支払日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dairitencd1</td><td>代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teikihongk</td><td>定額年金基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teinkspan</td><td>定額年金年金期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teinksyu</td><td>定額年金年金種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinjimutesuuryoukbn</td><td>年金事務手数料区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinJimuTesuuryouKbn C_NenkinJimuTesuuryouKbn}</td></tr>
 *  <tr><td>nenkinkaisigoyoteiriritukbn</td><td>年金開始後予定利率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinkigousedaikbn</td><td>年金記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinKigouSedaiKbn C_NenkinKigouSedaiKbn}</td></tr>
 *  <tr><td>nenkinkbn</td><td>年金区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinKbn C_NenkinKbn}</td></tr>
 *  <tr><td>nkshrstartymd</td><td>年金支払開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkkknmanryouymd</td><td>年金期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkshrhsijiyuu</td><td>年金支払発生事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nkshrhsijiyuu C_Nkshrhsijiyuu}</td></tr>
 *  <tr><td>nksyoumetucd</td><td>年金消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NkSyoumetuCd C_NkSyoumetuCd}</td></tr>
 *  <tr><td>nksysyno</td><td>年金証書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bnshrkaisuu</td><td>分割支払回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Bnshrkaisuu C_Bnshrkaisuu}</td></tr>
 *  <tr><td>tyuuitratkikbn</td><td>注意取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TyuuitratkiKbn C_TyuuitratkiKbn}</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrymd</td><td>支払日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     SV_NkBikin
 * @see     GenSV_NkBikin
 * @see     QSV_NkBikin
 * @see     GenQSV_NkBikin
 */
public class PKSV_NkBikin extends AbstractExDBPrimaryKey<SV_NkBikin, PKSV_NkBikin> {

    private static final long serialVersionUID = 1L;

    public PKSV_NkBikin() {
    }

    public PKSV_NkBikin(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

    @Transient
    @Override
    public Class<SV_NkBikin> getEntityClass() {
        return SV_NkBikin.class;
    }

    private Integer renno8keta;

    public Integer getRenno8keta() {
        return renno8keta;
    }

    public void setRenno8keta(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

}