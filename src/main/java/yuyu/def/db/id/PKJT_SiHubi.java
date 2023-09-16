package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.mapping.GenJT_SiHubi;
import yuyu.def.db.meta.GenQJT_SiHubi;
import yuyu.def.db.meta.QJT_SiHubi;

/**
 * 支払不備テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiHubi}</td><td colspan="3">支払不備テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimutetuzukinm</td><td>事務手続名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakinmkj</td><td>連絡先氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakuyno</td><td>連絡先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakiadr1kj</td><td>連絡先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakiadr2kj</td><td>連絡先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakiadr3kj</td><td>連絡先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakitelno</td><td>連絡先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakuarea</td><td>連絡欄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hassinsakifsthubihasinymd1</td><td>発信先別初回不備発信日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hassinsakifsthubihasinymd2</td><td>発信先別初回不備発信日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hasinsakibetuhubihasinymd3</td><td>発信先別初回不備発信日３</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hassinsakikaisuu1</td><td>発信先別発信回数１</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hassinsakikaisuu2</td><td>発信先別発信回数２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hasinsakibetuhasinkaisuu3</td><td>発信先別発信回数３</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sisyacd</td><td>支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sisyanm</td><td>支社名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasesosikinmkj</td><td>問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasetelno</td><td>問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiHubi
 * @see     GenJT_SiHubi
 * @see     QJT_SiHubi
 * @see     GenQJT_SiHubi
 */
public class PKJT_SiHubi extends AbstractExDBPrimaryKey<JT_SiHubi, PKJT_SiHubi> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiHubi() {
    }

    public PKJT_SiHubi(String pHubisikibetukey) {
        hubisikibetukey = pHubisikibetukey;
    }

    @Transient
    @Override
    public Class<JT_SiHubi> getEntityClass() {
        return JT_SiHubi.class;
    }

    private String hubisikibetukey;

    public String getHubisikibetukey() {
        return hubisikibetukey;
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        hubisikibetukey = pHubisikibetukey;
    }

}