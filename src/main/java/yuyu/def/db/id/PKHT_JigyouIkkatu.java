package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.mapping.GenHT_JigyouIkkatu;
import yuyu.def.db.meta.GenQHT_JigyouIkkatu;
import yuyu.def.db.meta.QHT_JigyouIkkatu;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 事業一括テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_JigyouIkkatu}</td><td colspan="3">事業一括テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDaimosno daimosno}</td><td>代表申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosnrkumu</td><td>申込書入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kktnrkumu</td><td>告知書入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hjynrkumu</td><td>報状入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nyknnrkumu</td><td>入金入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nyknwarinrkumu</td><td>入金割当入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>itijiketnrkumu</td><td>１次決定入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>jiketteikbn</td><td>事業一括決定状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_JiketteiKbn C_JiketteiKbn}</td></tr>
 *  <tr><td>jgyiktsrkbn</td><td>事業一括成立区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeirituKbn C_SeirituKbn}</td></tr>
 *  <tr><td>jgyiktsrymd</td><td>事業一括成立日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_JigyouIkkatu
 * @see     GenHT_JigyouIkkatu
 * @see     QHT_JigyouIkkatu
 * @see     GenQHT_JigyouIkkatu
 */
public class PKHT_JigyouIkkatu extends AbstractExDBPrimaryKey<HT_JigyouIkkatu, PKHT_JigyouIkkatu> {

    private static final long serialVersionUID = 1L;

    public PKHT_JigyouIkkatu() {
    }

    public PKHT_JigyouIkkatu(String pDaimosno) {
        daimosno = pDaimosno;
    }

    @Transient
    @Override
    public Class<HT_JigyouIkkatu> getEntityClass() {
        return HT_JigyouIkkatu.class;
    }

    private String daimosno;

    public String getDaimosno() {
        return daimosno;
    }

    public void setDaimosno(String pDaimosno) {
        daimosno = pDaimosno;
    }

}