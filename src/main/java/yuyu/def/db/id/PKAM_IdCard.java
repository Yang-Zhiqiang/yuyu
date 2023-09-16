package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AM_IdCard;
import yuyu.def.db.mapping.GenAM_IdCard;
import yuyu.def.db.meta.GenQAM_IdCard;
import yuyu.def.db.meta.QAM_IdCard;

/**
 * ＩＤカードマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_IdCard}</td><td colspan="3">ＩＤカードマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tanmatusiyoukbn</td><td>端末使用区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>accesskbn</td><td>アクセス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>idnyuuryokusyanm</td><td>ＩＤ入力者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanjiidnyuuryokusyanm</td><td>漢字ＩＤ入力者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>idnyuuryokusyaseiymd</td><td>ＩＤ入力者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>idnyuuryokusyanyuusyaymd</td><td>ＩＤ入力者入社年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syozokusosikicd</td><td>所属組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syozokusisyacd</td><td>所属支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syozokusibucd</td><td>所属支部コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>idnyuuryokusyasikakucd</td><td>ＩＤ入力者資格コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>idsdpsouhuhyouji</td><td>ＩＤＳＤＰ送付表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>idcardsaisyuukousinymd</td><td>ＩＤカード最終更新年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>idcardmukouymd</td><td>ＩＤカード無効年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kaikeitantousyakbn</td><td>会計担当者区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syanaiyokintantousyakbn</td><td>社内預金担当者区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jinjimynosyoukaihyj</td><td>人事・マイナンバー照会可能表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukaiKanouHyj C_SyoukaiKanouHyj}</td></tr>
 *  <tr><td>eisyokumynosyoukaihyj</td><td>営職・マイナンバー照会可能表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukaiKanouHyj C_SyoukaiKanouHyj}</td></tr>
 *  <tr><td>hudousanmynosyoukaihyj</td><td>不動産・マイナンバー照会可能表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukaiKanouHyj C_SyoukaiKanouHyj}</td></tr>
 *  <tr><td>kohomynosyoukaihyj</td><td>個保・マイナンバー照会可能表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukaiKanouHyj C_SyoukaiKanouHyj}</td></tr>
 *  <tr><td>kihomynosyoukaihyj</td><td>企保・マイナンバー照会可能表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukaiKanouHyj C_SyoukaiKanouHyj}</td></tr>
 *  <tr><td>kikantantoukbn</td><td>機関担当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_IdCard
 * @see     GenAM_IdCard
 * @see     QAM_IdCard
 * @see     GenQAM_IdCard
 */
public class PKAM_IdCard extends AbstractExDBPrimaryKey<AM_IdCard, PKAM_IdCard> {

    private static final long serialVersionUID = 1L;

    public PKAM_IdCard() {
    }

    public PKAM_IdCard(String pIdkbn, String pIdcd) {
        idkbn = pIdkbn;
        idcd = pIdcd;
    }

    @Transient
    @Override
    public Class<AM_IdCard> getEntityClass() {
        return AM_IdCard.class;
    }

    private String idkbn;

    public String getIdkbn() {
        return idkbn;
    }

    public void setIdkbn(String pIdkbn) {
        idkbn = pIdkbn;
    }
    private String idcd;

    public String getIdcd() {
        return idcd;
    }

    public void setIdcd(String pIdcd) {
        idcd = pIdcd;
    }

}