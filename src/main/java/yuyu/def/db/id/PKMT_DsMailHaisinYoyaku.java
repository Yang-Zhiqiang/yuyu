package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import yuyu.def.db.mapping.GenMT_DsMailHaisinYoyaku;
import yuyu.def.db.meta.GenQMT_DsMailHaisinYoyaku;
import yuyu.def.db.meta.QMT_DsMailHaisinYoyaku;

/**
 * ＤＳメール配信予約テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsMailHaisinYoyaku}</td><td colspan="3">ＤＳメール配信予約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsmailhaisinyoyakuskbtkey dsmailhaisinyoyakuskbtkey}</td><td>ＤＳメール配信予約識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dsmailhaisinyoteiymd</td><td>ＤＳメール配信（予定）日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dssousinmailsyubetukbn</td><td>ＤＳ送信メール種別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsSousinMailSyubetuKbn C_DsSousinMailSyubetuKbn}</td></tr>
 *  <tr><td>dshaisinyoyakustatuskbn</td><td>ＤＳ配信予約ステータス区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsHaisinYoyakuStatusKbn C_DsHaisinYoyakuStatusKbn}</td></tr>
 *  <tr><td>dsmailhaisintourokuymd</td><td>ＤＳメール配信登録日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dsmailhaisinsyouninymd</td><td>ＤＳメール配信承認日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dsmailhaisintourokusyaid</td><td>ＤＳメール配信登録者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dsmailhaisinsyouninsyaid</td><td>ＤＳメール配信承認者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsMailHaisinYoyaku
 * @see     GenMT_DsMailHaisinYoyaku
 * @see     QMT_DsMailHaisinYoyaku
 * @see     GenQMT_DsMailHaisinYoyaku
 */
public class PKMT_DsMailHaisinYoyaku extends AbstractExDBPrimaryKey<MT_DsMailHaisinYoyaku, PKMT_DsMailHaisinYoyaku> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsMailHaisinYoyaku() {
    }

    public PKMT_DsMailHaisinYoyaku(String pDsmailhaisinyoyakuskbtkey) {
        dsmailhaisinyoyakuskbtkey = pDsmailhaisinyoyakuskbtkey;
    }

    @Transient
    @Override
    public Class<MT_DsMailHaisinYoyaku> getEntityClass() {
        return MT_DsMailHaisinYoyaku.class;
    }

    private String dsmailhaisinyoyakuskbtkey;

    public String getDsmailhaisinyoyakuskbtkey() {
        return dsmailhaisinyoyakuskbtkey;
    }

    public void setDsmailhaisinyoyakuskbtkey(String pDsmailhaisinyoyakuskbtkey) {
        dsmailhaisinyoyakuskbtkey = pDsmailhaisinyoyakuskbtkey;
    }

}