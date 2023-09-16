package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.mapping.GenBT_SkipKey;
import yuyu.def.db.meta.GenQBT_SkipKey;
import yuyu.def.db.meta.QBT_SkipKey;

/**
 * スキップキーテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SkipKey}</td><td colspan="3">スキップキーテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRecoverysikibetukey recoverysikibetukey}</td><td>リカバリ識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kakutyoujobcd</td><td>拡張ジョブコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tableid</td><td>テーブルＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterid</td><td>リカバリフィルタＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterkey1</td><td>リカバリフィルタキー１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterkey2</td><td>リカバリフィルタキー２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterkey3</td><td>リカバリフィルタキー３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterkey4</td><td>リカバリフィルタキー４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterkey5</td><td>リカバリフィルタキー５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_SkipKey
 * @see     GenBT_SkipKey
 * @see     QBT_SkipKey
 * @see     GenQBT_SkipKey
 */
public class PKBT_SkipKey extends AbstractExDBPrimaryKey<BT_SkipKey, PKBT_SkipKey> {

    private static final long serialVersionUID = 1L;

    public PKBT_SkipKey() {
    }

    public PKBT_SkipKey(String pRecoverysikibetukey) {
        recoverysikibetukey = pRecoverysikibetukey;
    }

    @Transient
    @Override
    public Class<BT_SkipKey> getEntityClass() {
        return BT_SkipKey.class;
    }

    private String recoverysikibetukey;

    public String getRecoverysikibetukey() {
        return recoverysikibetukey;
    }

    public void setRecoverysikibetukey(String pRecoverysikibetukey) {
        recoverysikibetukey = pRecoverysikibetukey;
    }

}