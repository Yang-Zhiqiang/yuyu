package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_Nyknmeisai;
import yuyu.def.db.mapping.GenBT_Nyknmeisai;
import yuyu.def.db.meta.GenQBT_Nyknmeisai;
import yuyu.def.db.meta.QBT_Nyknmeisai;

/**
 * 入出金明細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_Nyknmeisai}</td><td colspan="3">入出金明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>hrkmdatakbn1</td><td>（振込用）データ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsyubetucd</td><td>（振込用）種別コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmcdkbn</td><td>（振込用）コード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmsakuseiymd6keta hrkmsakuseiymd6keta}</td><td>（振込用）作成日６桁</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmknjyymdfrom6keta</td><td>（振込用）勘定日（自）６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmknjyymdto6keta</td><td>（振込用）勘定日（至）６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmbankcd hrkmbankcd}</td><td>（振込用）銀行番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmbanknmkn</td><td>（振込用）銀行名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmshitencd hrkmshitencd}</td><td>（振込用）支店番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsitennmkn</td><td>（振込用）支店名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmyobiv3</td><td>（振込用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmyokinkbn hrkmyokinkbn}</td><td>（振込用）預金種目区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmkouzano hrkmkouzano}</td><td>（振込用）口座番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkznmkn</td><td>（振込用）口座名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkasikosikbn</td><td>（振込用）貸越区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtuutyousysykbn</td><td>（振込用）通帳・証書区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtrhkmaezndk</td><td>（振込用）取引前残高</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmyobiv63</td><td>（振込用）予備項目Ｖ６３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmrenno8 hrkmrenno8}</td><td>（振込用）連番８桁</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdatakbn2</td><td>（振込用）データ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmsyoukaino hrkmsyoukaino}</td><td>（振込用）照会番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmknjyymd6keta</td><td>（振込用）勘定日６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmazkrhrdsymd6keta</td><td>（振込用）預入・払出日６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmiribaraikbn</td><td>（振込用）入払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtrhkkbn</td><td>（振込用）取引区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtrhkgk</td><td>（振込用）取引金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtatenkengk</td><td>（振込用）うち他店券金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkknteijiymd6keta</td><td>（振込用）交換呈示日６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmhwtrhnknymd6keta</td><td>（振込用）不渡返還日６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtgtkgtkbn</td><td>（振込用）手形・小切手区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtgtkgtno</td><td>（振込用）手形・小切手番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmryoutenno</td><td>（振込用）僚店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmhrkmirnincd</td><td>（振込用）振込依頼人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmhrkmirninnm</td><td>（振込用）振込依頼人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsimukebanknmkn</td><td>（振込用）仕向銀行名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsimuketennmkn</td><td>（振込用）仕向店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtekiyounaiyou</td><td>（振込用）摘要内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmediinfo</td><td>（振込用）ＥＤＩ情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmyobiv1</td><td>（振込用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_Nyknmeisai
 * @see     GenBT_Nyknmeisai
 * @see     QBT_Nyknmeisai
 * @see     GenQBT_Nyknmeisai
 */
public class PKBT_Nyknmeisai extends AbstractExDBPrimaryKey<BT_Nyknmeisai, PKBT_Nyknmeisai> {

    private static final long serialVersionUID = 1L;

    public PKBT_Nyknmeisai() {
    }

    public PKBT_Nyknmeisai(
        String pHrkmsakuseiymd6keta,
        String pHrkmbankcd,
        String pHrkmshitencd,
        String pHrkmyokinkbn,
        String pHrkmkouzano,
        String pHrkmsyoukaino,
        String pHrkmrenno8
    ) {
        hrkmsakuseiymd6keta = pHrkmsakuseiymd6keta;
        hrkmbankcd = pHrkmbankcd;
        hrkmshitencd = pHrkmshitencd;
        hrkmyokinkbn = pHrkmyokinkbn;
        hrkmkouzano = pHrkmkouzano;
        hrkmsyoukaino = pHrkmsyoukaino;
        hrkmrenno8 = pHrkmrenno8;
    }

    @Transient
    @Override
    public Class<BT_Nyknmeisai> getEntityClass() {
        return BT_Nyknmeisai.class;
    }

    private String hrkmsakuseiymd6keta;

    public String getHrkmsakuseiymd6keta() {
        return hrkmsakuseiymd6keta;
    }

    public void setHrkmsakuseiymd6keta(String pHrkmsakuseiymd6keta) {
        hrkmsakuseiymd6keta = pHrkmsakuseiymd6keta;
    }
    private String hrkmbankcd;

    public String getHrkmbankcd() {
        return hrkmbankcd;
    }

    public void setHrkmbankcd(String pHrkmbankcd) {
        hrkmbankcd = pHrkmbankcd;
    }
    private String hrkmshitencd;

    public String getHrkmshitencd() {
        return hrkmshitencd;
    }

    public void setHrkmshitencd(String pHrkmshitencd) {
        hrkmshitencd = pHrkmshitencd;
    }
    private String hrkmyokinkbn;

    public String getHrkmyokinkbn() {
        return hrkmyokinkbn;
    }

    public void setHrkmyokinkbn(String pHrkmyokinkbn) {
        hrkmyokinkbn = pHrkmyokinkbn;
    }
    private String hrkmkouzano;

    public String getHrkmkouzano() {
        return hrkmkouzano;
    }

    public void setHrkmkouzano(String pHrkmkouzano) {
        hrkmkouzano = pHrkmkouzano;
    }
    private String hrkmsyoukaino;

    public String getHrkmsyoukaino() {
        return hrkmsyoukaino;
    }

    public void setHrkmsyoukaino(String pHrkmsyoukaino) {
        hrkmsyoukaino = pHrkmsyoukaino;
    }
    private String hrkmrenno8;

    public String getHrkmrenno8() {
        return hrkmrenno8;
    }

    public void setHrkmrenno8(String pHrkmrenno8) {
        hrkmrenno8 = pHrkmrenno8;
    }

}