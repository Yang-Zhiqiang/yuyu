package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BT_MdhnBank;
import yuyu.def.db.mapping.GenBT_MdhnBank;
import yuyu.def.db.meta.GenQBT_MdhnBank;
import yuyu.def.db.meta.QBT_MdhnBank;

/**
 * 窓販銀行テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_MdhnBank}</td><td colspan="3">窓販銀行テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mdhnbankcd</td><td>窓販銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mdhnhontensitenkbn</td><td>窓販本店支店区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MdhnhontensitenKbn C_MdhnhontensitenKbn}</td></tr>
 *  <tr><td>mdhnsitencd</td><td>窓販支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mdhncifcdknrkbn</td><td>窓販ＣＩＦコード管理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MdhncifcdknrKbn C_MdhncifcdknrKbn}</td></tr>
 *  <tr><td>tkrtkkinyuukntkykbn</td><td>特例地域金融機関適用区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkrtkkinyuukntkyKbn C_TkrtkkinyuukntkyKbn}</td></tr>
 *  <tr><td>tkrtkkinyuukntkyymd</td><td>特例地域金融機関適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kydsskkinyuukntkykbn</td><td>協同組織金融機関適用区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KydsskkinyuukntkyKbn C_KydsskkinyuukntkyKbn}</td></tr>
 *  <tr><td>kydsskkinyuukntkyymd</td><td>協同組織金融機関適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mdhntyhyhrtkkbn</td><td>窓販帳票配列区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MdhntyhyhrtkKbn C_MdhntyhyhrtkKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_MdhnBank
 * @see     GenBT_MdhnBank
 * @see     QBT_MdhnBank
 * @see     GenQBT_MdhnBank
 */
public class PKBT_MdhnBank extends AbstractExDBPrimaryKey<BT_MdhnBank, PKBT_MdhnBank> {

    private static final long serialVersionUID = 1L;

    public PKBT_MdhnBank() {
    }

    public PKBT_MdhnBank(String pDrtencd) {
        drtencd = pDrtencd;
    }

    @Transient
    @Override
    public Class<BT_MdhnBank> getEntityClass() {
        return BT_MdhnBank.class;
    }

    private String drtencd;

    public String getDrtencd() {
        return drtencd;
    }

    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

}