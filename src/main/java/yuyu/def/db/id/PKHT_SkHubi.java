package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.mapping.GenHT_SkHubi;
import yuyu.def.db.meta.GenQHT_SkHubi;
import yuyu.def.db.meta.QHT_SkHubi;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約不備テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkHubi}</td><td colspan="3">新契約不備テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimutetuzukinm</td><td>事務手続名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rnrkskhaneikbn</td><td>連絡先反映区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_RnrkskhaneiKbn C_RnrkskhaneiKbn}</td></tr>
 *  <tr><td>utdskknnm1kj</td><td>打出機関名１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>utdskknnm2kj</td><td>打出機関名２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuutisakitantounmkj</td><td>通知先担当者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuutikyokasyanmkj</td><td>通知許可者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>commentarea</td><td>コメント欄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkHubi
 * @see     GenHT_SkHubi
 * @see     QHT_SkHubi
 * @see     GenQHT_SkHubi
 */
public class PKHT_SkHubi extends AbstractExDBPrimaryKey<HT_SkHubi, PKHT_SkHubi> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkHubi() {
    }

    public PKHT_SkHubi(String pMosno, String pHubisikibetukey) {
        mosno = pMosno;
        hubisikibetukey = pHubisikibetukey;
    }

    @Transient
    @Override
    public Class<HT_SkHubi> getEntityClass() {
        return HT_SkHubi.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private String hubisikibetukey;

    public String getHubisikibetukey() {
        return hubisikibetukey;
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        hubisikibetukey = pHubisikibetukey;
    }

}