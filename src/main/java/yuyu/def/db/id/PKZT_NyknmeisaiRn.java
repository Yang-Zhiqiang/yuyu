package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NyknmeisaiRn;
import yuyu.def.db.mapping.GenZT_NyknmeisaiRn;
import yuyu.def.db.meta.GenQZT_NyknmeisaiRn;
import yuyu.def.db.meta.QZT_NyknmeisaiRn;

/**
 * 入出金明細テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NyknmeisaiRn}</td><td colspan="3">入出金明細テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrndatakbn1</td><td>（連携用）データ区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyubetucd</td><td>（連携用）種別コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncdkbn</td><td>（連携用）コード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsakuseiymd6keta zrnsakuseiymd6keta}</td><td>（連携用）作成日６桁</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjyymdfrom6keta</td><td>（連携用）勘定日（自）６桁</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjyymdto6keta</td><td>（連携用）勘定日（至）６桁</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbankcd zrnbankcd}</td><td>（連携用）銀行番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbanknmkn</td><td>（連携用）銀行名（カナ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnshitencd zrnshitencd}</td><td>（連携用）支店番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsitennmkn</td><td>（連携用）支店名（カナ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv3</td><td>（連携用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnyokinkbn zrnyokinkbn}</td><td>（連携用）預金種目区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkouzano zrnkouzano}</td><td>（連携用）口座番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkznmkn</td><td>（連携用）口座名（カナ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasikosikbn</td><td>（連携用）貸越区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuutyousysykbn</td><td>（連携用）通帳・証書区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrhkmaezndk</td><td>（連携用）取引前残高</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv63</td><td>（連携用）予備項目Ｖ６３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrenno8 zrnrenno8}</td><td>（連携用）連番８桁</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakbn2</td><td>（連携用）データ区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyoukaino zrnsyoukaino}</td><td>（連携用）照会番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjyymd6keta</td><td>（連携用）勘定日６桁</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnazkrhrdsymd6keta</td><td>（連携用）預入・払出日６桁</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrniribaraikbn</td><td>（連携用）入払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrhkkbn</td><td>（連携用）取引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrhkgk</td><td>（連携用）取引金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntatenkengk</td><td>（連携用）うち他店券金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkknteijiymd6keta</td><td>（連携用）交換呈示日６桁</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhwtrhnknymd6keta</td><td>（連携用）不渡返還日６桁</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntgtkgtkbn</td><td>（連携用）手形・小切手区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntgtkgtno</td><td>（連携用）手形・小切手番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnryoutenno</td><td>（連携用）僚店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkmirnincd</td><td>（連携用）振込依頼人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkmirninnm</td><td>（連携用）振込依頼人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimukebanknmkn</td><td>（連携用）仕向銀行名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimuketennmkn</td><td>（連携用）仕向店名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyounaiyou</td><td>（連携用）摘要内容</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnediinfo</td><td>（連携用）EDI情報</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NyknmeisaiRn
 * @see     GenZT_NyknmeisaiRn
 * @see     QZT_NyknmeisaiRn
 * @see     GenQZT_NyknmeisaiRn
 */
public class PKZT_NyknmeisaiRn extends AbstractExDBPrimaryKey<ZT_NyknmeisaiRn, PKZT_NyknmeisaiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_NyknmeisaiRn() {
    }

    public PKZT_NyknmeisaiRn(
        String pZrnsakuseiymd6keta,
        String pZrnbankcd,
        String pZrnshitencd,
        String pZrnyokinkbn,
        String pZrnkouzano,
        String pZrnsyoukaino,
        String pZrnrenno8
    ) {
        zrnsakuseiymd6keta = pZrnsakuseiymd6keta;
        zrnbankcd = pZrnbankcd;
        zrnshitencd = pZrnshitencd;
        zrnyokinkbn = pZrnyokinkbn;
        zrnkouzano = pZrnkouzano;
        zrnsyoukaino = pZrnsyoukaino;
        zrnrenno8 = pZrnrenno8;
    }

    @Transient
    @Override
    public Class<ZT_NyknmeisaiRn> getEntityClass() {
        return ZT_NyknmeisaiRn.class;
    }

    private String zrnsakuseiymd6keta;

    public String getZrnsakuseiymd6keta() {
        return zrnsakuseiymd6keta;
    }

    public void setZrnsakuseiymd6keta(String pZrnsakuseiymd6keta) {
        zrnsakuseiymd6keta = pZrnsakuseiymd6keta;
    }
    private String zrnbankcd;

    public String getZrnbankcd() {
        return zrnbankcd;
    }

    public void setZrnbankcd(String pZrnbankcd) {
        zrnbankcd = pZrnbankcd;
    }
    private String zrnshitencd;

    public String getZrnshitencd() {
        return zrnshitencd;
    }

    public void setZrnshitencd(String pZrnshitencd) {
        zrnshitencd = pZrnshitencd;
    }
    private String zrnyokinkbn;

    public String getZrnyokinkbn() {
        return zrnyokinkbn;
    }

    public void setZrnyokinkbn(String pZrnyokinkbn) {
        zrnyokinkbn = pZrnyokinkbn;
    }
    private String zrnkouzano;

    public String getZrnkouzano() {
        return zrnkouzano;
    }

    public void setZrnkouzano(String pZrnkouzano) {
        zrnkouzano = pZrnkouzano;
    }
    private String zrnsyoukaino;

    public String getZrnsyoukaino() {
        return zrnsyoukaino;
    }

    public void setZrnsyoukaino(String pZrnsyoukaino) {
        zrnsyoukaino = pZrnsyoukaino;
    }
    private String zrnrenno8;

    public String getZrnrenno8() {
        return zrnrenno8;
    }

    public void setZrnrenno8(String pZrnrenno8) {
        zrnrenno8 = pZrnrenno8;
    }

}