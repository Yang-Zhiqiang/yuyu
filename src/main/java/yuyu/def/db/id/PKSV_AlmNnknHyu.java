package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.SV_AlmNnknHyu;
import yuyu.def.db.mapping.GenSV_AlmNnknHyu;
import yuyu.def.db.meta.GenQSV_AlmNnknHyu;
import yuyu.def.db.meta.QSV_AlmNnknHyu;

/**
 * ＡＬＭ用年金保有明細ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_AlmNnknHyu}</td><td colspan="3">ＡＬＭ用年金保有明細ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sznjk</td><td>生存状況</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sznjk C_Sznjk}</td></tr>
 *  <tr><td>seisikakymd</td><td>生死確認日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkkknsetymd</td><td>年金基金設定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dairitencd1</td><td>代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanritodoufukencd</td><td>代理店管理都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teikihongk</td><td>定額年金基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teinkkikingk</td><td>定額年金年金基金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teinkspan</td><td>定額年金年金期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teinksyu</td><td>定額年金年金種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigoyoteiriritukbn</td><td>年金開始後予定利率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinkigousedaikbn</td><td>年金記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinKigouSedaiKbn C_NenkinKigouSedaiKbn}</td></tr>
 *  <tr><td>nenkinkbn</td><td>年金区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinKbn C_NenkinKbn}</td></tr>
 *  <tr><td>nkshrstartymd</td><td>年金支払開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkkknmanryouymd</td><td>年金期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nenkinjimutesuuryoukbn</td><td>年金事務手数料区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinJimuTesuuryouKbn C_NenkinJimuTesuuryouKbn}</td></tr>
 *  <tr><td>nksyoumetucd</td><td>年金消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NkSyoumetuCd C_NkSyoumetuCd}</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nksysyno</td><td>年金証書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd1</td><td>募集人コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ukehidouitukbn</td><td>受被同一区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UkehiDouKbn C_UkehiDouKbn}</td></tr>
 *  <tr><td>nkuktsakuinnmno</td><td>年金受取人索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     SV_AlmNnknHyu
 * @see     GenSV_AlmNnknHyu
 * @see     QSV_AlmNnknHyu
 * @see     GenQSV_AlmNnknHyu
 */
public class PKSV_AlmNnknHyu extends AbstractExDBPrimaryKey<SV_AlmNnknHyu, PKSV_AlmNnknHyu> {

    private static final long serialVersionUID = 1L;

    public PKSV_AlmNnknHyu() {
    }

    public PKSV_AlmNnknHyu(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

    @Transient
    @Override
    public Class<SV_AlmNnknHyu> getEntityClass() {
        return SV_AlmNnknHyu.class;
    }

    private Integer renno8keta;

    public Integer getRenno8keta() {
        return renno8keta;
    }

    public void setRenno8keta(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

}