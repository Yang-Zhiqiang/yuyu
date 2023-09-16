package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_GknyknmeisaiRn;
import yuyu.def.db.mapping.GenZT_GknyknmeisaiRn;
import yuyu.def.db.meta.GenQZT_GknyknmeisaiRn;
import yuyu.def.db.meta.QZT_GknyknmeisaiRn;

/**
 * 外貨入出金明細テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GknyknmeisaiRn}</td><td colspan="3">外貨入出金明細テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrndatakbn1</td><td>（連携用）データ区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyubetucd</td><td>（連携用）種別コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncdkbn</td><td>（連携用）コード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsakuseiymd zrnsakuseiymd}</td><td>（連携用）作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrenrakuymd zrnrenrakuymd}</td><td>（連携用）連絡日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrenrakukaisuu zrnrenrakukaisuu}</td><td>（連携用）連絡回数</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjyymdfrom</td><td>（連携用）勘定日（自）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjyymdto</td><td>（連携用）勘定日（至）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbankcd zrnbankcd}</td><td>（連携用）銀行番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbanknmej</td><td>（連携用）銀行名（英字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsitencdtori</td><td>（連携用）支店コード（取次）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsitennmejtori</td><td>（連携用）支店名（英字）（取次）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnshitencd zrnshitencd}</td><td>（連携用）支店番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsitennmej</td><td>（連携用）支店名（英字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnyokinkbn zrnyokinkbn}</td><td>（連携用）預金種目区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkouzano zrnkouzano}</td><td>（連携用）口座番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkznmej</td><td>（連携用）口座名（英字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnzndktuukasyu zrnzndktuukasyu}</td><td>（連携用）残高通貨種類</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzndkssketa</td><td>（連携用）残高小数桁</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngktrhkmaezndk</td><td>（連携用）外貨取引前残高</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasikosikbn</td><td>（連携用）貸越区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv86</td><td>（連携用）予備項目Ｖ８６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakbn2</td><td>（連携用）データ区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndtrecordkbn1</td><td>（連携用）データレコード区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndtrecordkousei</td><td>（連携用）データレコード構成</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyorino1 zrnsyorino1}</td><td>（連携用）処理通番１</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjyymd</td><td>（連携用）勘定日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnksnymd</td><td>（連携用）起算日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrniribaraikbn</td><td>（連携用）入払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrhkkbn</td><td>（連携用）取引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrhktuukasyu</td><td>（連携用）取引通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrhkssketa</td><td>（連携用）取引小数桁</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngktrhkgk</td><td>（連携用）外貨取引金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbanksyoukaino</td><td>（連携用）銀行照会番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrhksyoukaino</td><td>（連携用）取引先照会番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyounaiyouej</td><td>（連携用）摘要内容（英字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv103</td><td>（連携用）予備項目Ｖ１０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakbn3</td><td>（連携用）データ区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndtrecordkbn2</td><td>（連携用）データレコード区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndtkouseikbn</td><td>（連携用）データ構成区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkscd</td><td>（連携用）取消コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorino2</td><td>（連携用）処理通番２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbanksyoukaino2</td><td>（連携用）銀行照会番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimukeymd</td><td>（連携用）仕向日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsetujyuymd</td><td>（連携用）接受日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsoukinsyu</td><td>（連携用）送金種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnvalueymd</td><td>（連携用）バリュー日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskntuukasyu</td><td>（連携用）送金通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsknssketa</td><td>（連携用）送金小数桁</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngksoukingk</td><td>（連携用）外貨送金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnirninnm</td><td>（連携用）依頼人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv40</td><td>（連携用）予備項目Ｖ４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakbn4</td><td>（連携用）データ区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndtrecordkbn3</td><td>（連携用）データレコード区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndourecordsuu1</td><td>（連携用）同種レコード数１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndourecordno1</td><td>（連携用）同種レコード番号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkahensuu1</td><td>（連携用）可変項目数１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkahenketa1</td><td>（連携用）可変項目桁数１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkahen1</td><td>（連携用）可変項目１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakbn5</td><td>（連携用）データ区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndtrecordkbn4</td><td>（連携用）データレコード区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndourecordsuu2</td><td>（連携用）同種レコード数２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndourecordno2</td><td>（連携用）同種レコード番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkahensuu2</td><td>（連携用）可変項目数２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkahenketa2</td><td>（連携用）可変項目桁数２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkahen2</td><td>（連携用）可変項目２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakbn6</td><td>（連携用）データ区分６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndtrecordkbn5</td><td>（連携用）データレコード区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndourecordsuu3</td><td>（連携用）同種レコード数３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndourecordno3</td><td>（連携用）同種レコード番号３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkahensuu3</td><td>（連携用）可変項目数３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkahenketa3</td><td>（連携用）可変項目桁数３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkahen3</td><td>（連携用）可変項目３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_GknyknmeisaiRn
 * @see     GenZT_GknyknmeisaiRn
 * @see     QZT_GknyknmeisaiRn
 * @see     GenQZT_GknyknmeisaiRn
 */
public class PKZT_GknyknmeisaiRn extends AbstractExDBPrimaryKey<ZT_GknyknmeisaiRn, PKZT_GknyknmeisaiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_GknyknmeisaiRn() {
    }

    public PKZT_GknyknmeisaiRn(
        String pZrnsakuseiymd,
        String pZrnrenrakuymd,
        String pZrnrenrakukaisuu,
        String pZrnbankcd,
        String pZrnshitencd,
        String pZrnyokinkbn,
        String pZrnkouzano,
        String pZrnzndktuukasyu,
        String pZrnsyorino1
    ) {
        zrnsakuseiymd = pZrnsakuseiymd;
        zrnrenrakuymd = pZrnrenrakuymd;
        zrnrenrakukaisuu = pZrnrenrakukaisuu;
        zrnbankcd = pZrnbankcd;
        zrnshitencd = pZrnshitencd;
        zrnyokinkbn = pZrnyokinkbn;
        zrnkouzano = pZrnkouzano;
        zrnzndktuukasyu = pZrnzndktuukasyu;
        zrnsyorino1 = pZrnsyorino1;
    }

    @Transient
    @Override
    public Class<ZT_GknyknmeisaiRn> getEntityClass() {
        return ZT_GknyknmeisaiRn.class;
    }

    private String zrnsakuseiymd;

    public String getZrnsakuseiymd() {
        return zrnsakuseiymd;
    }

    public void setZrnsakuseiymd(String pZrnsakuseiymd) {
        zrnsakuseiymd = pZrnsakuseiymd;
    }
    private String zrnrenrakuymd;

    public String getZrnrenrakuymd() {
        return zrnrenrakuymd;
    }

    public void setZrnrenrakuymd(String pZrnrenrakuymd) {
        zrnrenrakuymd = pZrnrenrakuymd;
    }
    private String zrnrenrakukaisuu;

    public String getZrnrenrakukaisuu() {
        return zrnrenrakukaisuu;
    }

    public void setZrnrenrakukaisuu(String pZrnrenrakukaisuu) {
        zrnrenrakukaisuu = pZrnrenrakukaisuu;
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
    private String zrnzndktuukasyu;

    public String getZrnzndktuukasyu() {
        return zrnzndktuukasyu;
    }

    public void setZrnzndktuukasyu(String pZrnzndktuukasyu) {
        zrnzndktuukasyu = pZrnzndktuukasyu;
    }
    private String zrnsyorino1;

    public String getZrnsyorino1() {
        return zrnsyorino1;
    }

    public void setZrnsyorino1(String pZrnsyorino1) {
        zrnsyorino1 = pZrnsyorino1;
    }

}