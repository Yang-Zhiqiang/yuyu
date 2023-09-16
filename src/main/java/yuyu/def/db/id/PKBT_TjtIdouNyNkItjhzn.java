package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_TjtIdouNyNkItjhzn;
import yuyu.def.db.mapping.GenBT_TjtIdouNyNkItjhzn;
import yuyu.def.db.meta.GenQBT_TjtIdouNyNkItjhzn;
import yuyu.def.db.meta.QBT_TjtIdouNyNkItjhzn;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;

/**
 * 当日異動内容年金支払一時保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TjtIdouNyNkItjhzn}</td><td colspan="3">当日異動内容年金支払一時保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getNksysyno nksysyno}</td><td>年金証書番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>recordsakujyohyouji</td><td>レコード削除表示</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>youkyuuno</td><td>要求通番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkshrstartymd</td><td>年金支払開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nksyoumetucd</td><td>年金消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NkSyoumetuCd C_NkSyoumetuCd}</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>teinksyu</td><td>定額年金年金種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsnyounkgns</td><td>通算用年金原資</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nkukthhkndouhyouji</td><td>年金受取人被保険者同一表示</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_TjtIdouNyNkItjhzn
 * @see     GenBT_TjtIdouNyNkItjhzn
 * @see     QBT_TjtIdouNyNkItjhzn
 * @see     GenQBT_TjtIdouNyNkItjhzn
 */
public class PKBT_TjtIdouNyNkItjhzn extends AbstractExDBPrimaryKey<BT_TjtIdouNyNkItjhzn, PKBT_TjtIdouNyNkItjhzn> {

    private static final long serialVersionUID = 1L;

    public PKBT_TjtIdouNyNkItjhzn() {
    }

    public PKBT_TjtIdouNyNkItjhzn(String pNksysyno, Integer pRenno3keta) {
        nksysyno = pNksysyno;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<BT_TjtIdouNyNkItjhzn> getEntityClass() {
        return BT_TjtIdouNyNkItjhzn.class;
    }

    private String nksysyno;

    public String getNksysyno() {
        return nksysyno;
    }

    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}