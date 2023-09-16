package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.mapping.GenIT_KhHubi;
import yuyu.def.db.meta.GenQIT_KhHubi;
import yuyu.def.db.meta.QIT_KhHubi;

/**
 * 契約保全不備テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHubi}</td><td colspan="3">契約保全不備テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimuttdknm</td><td>契約管理事務手続名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakinmkj</td><td>連絡先氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakuyno</td><td>連絡先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakiadr1kj</td><td>連絡先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakiadr2kj</td><td>連絡先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakiadr3kj</td><td>連絡先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakitelno</td><td>連絡先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakuarea</td><td>連絡欄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubianswerkjt</td><td>不備回答期日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sksreadymd</td><td>請求書読込日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hassinsakifsthubihasinymd1</td><td>発信先別初回不備発信日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hassinsakifsthubihasinymd2</td><td>発信先別初回不備発信日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hassinsakikaisuu1</td><td>発信先別発信回数１</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hassinsakikaisuu2</td><td>発信先別発信回数２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHubi
 * @see     GenIT_KhHubi
 * @see     QIT_KhHubi
 * @see     GenQIT_KhHubi
 */
public class PKIT_KhHubi extends AbstractExDBPrimaryKey<IT_KhHubi, PKIT_KhHubi> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhHubi() {
    }

    public PKIT_KhHubi(String pHubisikibetukey) {
        hubisikibetukey = pHubisikibetukey;
    }

    @Transient
    @Override
    public Class<IT_KhHubi> getEntityClass() {
        return IT_KhHubi.class;
    }

    private String hubisikibetukey;

    public String getHubisikibetukey() {
        return hubisikibetukey;
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        hubisikibetukey = pHubisikibetukey;
    }

}