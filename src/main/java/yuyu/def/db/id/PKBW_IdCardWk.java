package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.mapping.GenBW_IdCardWk;
import yuyu.def.db.meta.GenQBW_IdCardWk;
import yuyu.def.db.meta.QBW_IdCardWk;

/**
 * ＩＤカードマスタワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_IdCardWk}</td><td colspan="3">ＩＤカードマスタワークテーブル</td></tr>
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
 * @see     BW_IdCardWk
 * @see     GenBW_IdCardWk
 * @see     QBW_IdCardWk
 * @see     GenQBW_IdCardWk
 */
public class PKBW_IdCardWk extends AbstractExDBPrimaryKey<BW_IdCardWk, PKBW_IdCardWk> {

    private static final long serialVersionUID = 1L;

    public PKBW_IdCardWk() {
    }

    public PKBW_IdCardWk(String pIdkbn, String pIdcd) {
        idkbn = pIdkbn;
        idcd = pIdcd;
    }

    @Transient
    @Override
    public Class<BW_IdCardWk> getEntityClass() {
        return BW_IdCardWk.class;
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