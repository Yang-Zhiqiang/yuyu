package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NyknmeisaiTr;
import yuyu.def.db.mapping.GenZT_NyknmeisaiTr;
import yuyu.def.db.meta.GenQZT_NyknmeisaiTr;
import yuyu.def.db.meta.QZT_NyknmeisaiTr;

/**
 * 入出金明細テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NyknmeisaiTr}</td><td colspan="3">入出金明細テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztrdatakbn1</td><td>（取込用）データ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyubetucd</td><td>（取込用）種別コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcdkbn</td><td>（取込用）コード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsakuseiymd6keta ztrsakuseiymd6keta}</td><td>（取込用）作成日６桁</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrknjyymdfrom6keta</td><td>（取込用）勘定日（自）６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrknjyymdto6keta</td><td>（取込用）勘定日（至）６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrbankcd ztrbankcd}</td><td>（取込用）銀行番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbanknmkn</td><td>（取込用）銀行名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrshitencd ztrshitencd}</td><td>（取込用）支店番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsitennmkn</td><td>（取込用）支店名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv3</td><td>（取込用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtryokinkbn ztryokinkbn}</td><td>（取込用）預金種目区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrkouzano ztrkouzano}</td><td>（取込用）口座番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkznmkn</td><td>（取込用）口座名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkasikosikbn</td><td>（取込用）貸越区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtuutyousysykbn</td><td>（取込用）通帳・証書区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtrhkmaezndk</td><td>（取込用）取引前残高</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv63</td><td>（取込用）予備項目Ｖ６３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrrenno8 ztrrenno8}</td><td>（取込用）連番８桁</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdatakbn2</td><td>（取込用）データ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsyoukaino ztrsyoukaino}</td><td>（取込用）照会番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrknjyymd6keta</td><td>（取込用）勘定日６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrazkrhrdsymd6keta</td><td>（取込用）預入・払出日６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztriribaraikbn</td><td>（取込用）入払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtrhkkbn</td><td>（取込用）取引区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtrhkgk</td><td>（取込用）取引金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtatenkengk</td><td>（取込用）うち他店券金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkknteijiymd6keta</td><td>（取込用）交換呈示日６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhwtrhnknymd6keta</td><td>（取込用）不渡返還日６桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtgtkgtkbn</td><td>（取込用）手形・小切手区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtgtkgtno</td><td>（取込用）手形・小切手番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrryoutenno</td><td>（取込用）僚店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhrkmirnincd</td><td>（取込用）振込依頼人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhrkmirninnm</td><td>（取込用）振込依頼人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsimukebanknmkn</td><td>（取込用）仕向銀行名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsimuketennmkn</td><td>（取込用）仕向店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtekiyounaiyou</td><td>（取込用）摘要内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrediinfo</td><td>（取込用）ＥＤＩ情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv1</td><td>（取込用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_NyknmeisaiTr
 * @see     GenZT_NyknmeisaiTr
 * @see     QZT_NyknmeisaiTr
 * @see     GenQZT_NyknmeisaiTr
 */
public class PKZT_NyknmeisaiTr extends AbstractExDBPrimaryKey<ZT_NyknmeisaiTr, PKZT_NyknmeisaiTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_NyknmeisaiTr() {
    }

    public PKZT_NyknmeisaiTr(
        String pZtrsakuseiymd6keta,
        String pZtrbankcd,
        String pZtrshitencd,
        String pZtryokinkbn,
        String pZtrkouzano,
        String pZtrsyoukaino,
        String pZtrrenno8
    ) {
        ztrsakuseiymd6keta = pZtrsakuseiymd6keta;
        ztrbankcd = pZtrbankcd;
        ztrshitencd = pZtrshitencd;
        ztryokinkbn = pZtryokinkbn;
        ztrkouzano = pZtrkouzano;
        ztrsyoukaino = pZtrsyoukaino;
        ztrrenno8 = pZtrrenno8;
    }

    @Transient
    @Override
    public Class<ZT_NyknmeisaiTr> getEntityClass() {
        return ZT_NyknmeisaiTr.class;
    }

    private String ztrsakuseiymd6keta;

    public String getZtrsakuseiymd6keta() {
        return ztrsakuseiymd6keta;
    }

    public void setZtrsakuseiymd6keta(String pZtrsakuseiymd6keta) {
        ztrsakuseiymd6keta = pZtrsakuseiymd6keta;
    }
    private String ztrbankcd;

    public String getZtrbankcd() {
        return ztrbankcd;
    }

    public void setZtrbankcd(String pZtrbankcd) {
        ztrbankcd = pZtrbankcd;
    }
    private String ztrshitencd;

    public String getZtrshitencd() {
        return ztrshitencd;
    }

    public void setZtrshitencd(String pZtrshitencd) {
        ztrshitencd = pZtrshitencd;
    }
    private String ztryokinkbn;

    public String getZtryokinkbn() {
        return ztryokinkbn;
    }

    public void setZtryokinkbn(String pZtryokinkbn) {
        ztryokinkbn = pZtryokinkbn;
    }
    private String ztrkouzano;

    public String getZtrkouzano() {
        return ztrkouzano;
    }

    public void setZtrkouzano(String pZtrkouzano) {
        ztrkouzano = pZtrkouzano;
    }
    private String ztrsyoukaino;

    public String getZtrsyoukaino() {
        return ztrsyoukaino;
    }

    public void setZtrsyoukaino(String pZtrsyoukaino) {
        ztrsyoukaino = pZtrsyoukaino;
    }
    private String ztrrenno8;

    public String getZtrrenno8() {
        return ztrrenno8;
    }

    public void setZtrrenno8(String pZtrrenno8) {
        ztrrenno8 = pZtrrenno8;
    }

}