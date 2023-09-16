package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.mapping.GenJT_SiRireki;
import yuyu.def.db.meta.GenQJT_SiRireki;
import yuyu.def.db.meta.QJT_SiRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiRireki}</td><td colspan="3">支払履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getShrsikibetukey shrsikibetukey}</td><td>支払識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuurirekino</td><td>請求履歴番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrkekkakbn</td><td>支払結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrKekkaKbn C_ShrKekkaKbn}</td></tr>
 *  <tr><td>shrsyoriymd</td><td>支払処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tyakkinymd</td><td>着金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrgkkei</td><td>支払額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zeitratkikbn</td><td>税取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZeitratkiKbn C_ZeitratkiKbn}</td></tr>
 *  <tr><td>torikesiflg</td><td>取消フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>torikesiymd</td><td>取消日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiRireki
 * @see     GenJT_SiRireki
 * @see     QJT_SiRireki
 * @see     GenQJT_SiRireki
 */
public class PKJT_SiRireki extends AbstractExDBPrimaryKey<JT_SiRireki, PKJT_SiRireki> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiRireki() {
    }

    public PKJT_SiRireki(
        String pSkno,
        String pSyono,
        String pShrsikibetukey
    ) {
        skno = pSkno;
        syono = pSyono;
        shrsikibetukey = pShrsikibetukey;
    }

    @Transient
    @Override
    public Class<JT_SiRireki> getEntityClass() {
        return JT_SiRireki.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String shrsikibetukey;

    public String getShrsikibetukey() {
        return shrsikibetukey;
    }

    public void setShrsikibetukey(String pShrsikibetukey) {
        shrsikibetukey = pShrsikibetukey;
    }

}