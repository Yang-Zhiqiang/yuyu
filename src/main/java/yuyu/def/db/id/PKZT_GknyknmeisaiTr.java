package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_GknyknmeisaiTr;
import yuyu.def.db.mapping.GenZT_GknyknmeisaiTr;
import yuyu.def.db.meta.GenQZT_GknyknmeisaiTr;
import yuyu.def.db.meta.QZT_GknyknmeisaiTr;

/**
 * 外貨入出金明細テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GknyknmeisaiTr}</td><td colspan="3">外貨入出金明細テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztrdatakbn1</td><td>（取込用）データ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyubetucd</td><td>（取込用）種別コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcdkbn</td><td>（取込用）コード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsakuseiymd ztrsakuseiymd}</td><td>（取込用）作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrrenrakuymd ztrrenrakuymd}</td><td>（取込用）連絡日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrrenrakukaisuu ztrrenrakukaisuu}</td><td>（取込用）連絡回数</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrknjyymdfrom</td><td>（取込用）勘定日（自）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrknjyymdto</td><td>（取込用）勘定日（至）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrbankcd ztrbankcd}</td><td>（取込用）銀行番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbanknmej</td><td>（取込用）銀行名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsitencdtori</td><td>（取込用）支店コード（取次）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsitennmejtori</td><td>（取込用）支店名（英字）（取次）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrshitencd ztrshitencd}</td><td>（取込用）支店番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsitennmej</td><td>（取込用）支店名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtryokinkbn ztryokinkbn}</td><td>（取込用）預金種目区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrkouzano ztrkouzano}</td><td>（取込用）口座番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkznmej</td><td>（取込用）口座名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrzndktuukasyu ztrzndktuukasyu}</td><td>（取込用）残高通貨種類</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrzndkssketa</td><td>（取込用）残高小数桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrgktrhkmaezndk</td><td>（取込用）外貨取引前残高</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkasikosikbn</td><td>（取込用）貸越区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv86</td><td>（取込用）予備項目Ｖ８６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdatakbn2</td><td>（取込用）データ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdtrecordkbn1</td><td>（取込用）データレコード区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdtrecordkousei</td><td>（取込用）データレコード構成</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsyorino1 ztrsyorino1}</td><td>（取込用）処理通番１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrknjyymd</td><td>（取込用）勘定日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrksnymd</td><td>（取込用）起算日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztriribaraikbn</td><td>（取込用）入払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtrhkkbn</td><td>（取込用）取引区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtrhktuukasyu</td><td>（取込用）取引通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtrhkssketa</td><td>（取込用）取引小数桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrgktrhkgk</td><td>（取込用）外貨取引金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbanksyoukaino</td><td>（取込用）銀行照会番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtrhksyoukaino</td><td>（取込用）取引先照会番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtekiyounaiyouej</td><td>（取込用）摘要内容（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv103</td><td>（取込用）予備項目Ｖ１０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdatakbn3</td><td>（取込用）データ区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdtrecordkbn2</td><td>（取込用）データレコード区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdtkouseikbn</td><td>（取込用）データ構成区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtrkscd</td><td>（取込用）取消コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyorino2</td><td>（取込用）処理通番２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbanksyoukaino2</td><td>（取込用）銀行照会番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsimukeymd</td><td>（取込用）仕向日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsetujyuymd</td><td>（取込用）接受日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsoukinsyu</td><td>（取込用）送金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrvalueymd</td><td>（取込用）バリュー日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrskntuukasyu</td><td>（取込用）送金通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsknssketa</td><td>（取込用）送金小数桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrgksoukingk</td><td>（取込用）外貨送金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrirninnm</td><td>（取込用）依頼人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv40</td><td>（取込用）予備項目Ｖ４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdatakbn4</td><td>（取込用）データ区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdtrecordkbn3</td><td>（取込用）データレコード区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdourecordsuu1</td><td>（取込用）同種レコード数１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdourecordno1</td><td>（取込用）同種レコード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkahensuu1</td><td>（取込用）可変項目数１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkahenketa1</td><td>（取込用）可変項目桁数１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkahen1</td><td>（取込用）可変項目１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdatakbn5</td><td>（取込用）データ区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdtrecordkbn4</td><td>（取込用）データレコード区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdourecordsuu2</td><td>（取込用）同種レコード数２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdourecordno2</td><td>（取込用）同種レコード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkahensuu2</td><td>（取込用）可変項目数２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkahenketa2</td><td>（取込用）可変項目桁数２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkahen2</td><td>（取込用）可変項目２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdatakbn6</td><td>（取込用）データ区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdtrecordkbn5</td><td>（取込用）データレコード区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdourecordsuu3</td><td>（取込用）同種レコード数３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdourecordno3</td><td>（取込用）同種レコード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkahensuu3</td><td>（取込用）可変項目数３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkahenketa3</td><td>（取込用）可変項目桁数３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkahen3</td><td>（取込用）可変項目３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_GknyknmeisaiTr
 * @see     GenZT_GknyknmeisaiTr
 * @see     QZT_GknyknmeisaiTr
 * @see     GenQZT_GknyknmeisaiTr
 */
public class PKZT_GknyknmeisaiTr extends AbstractExDBPrimaryKey<ZT_GknyknmeisaiTr, PKZT_GknyknmeisaiTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_GknyknmeisaiTr() {
    }

    public PKZT_GknyknmeisaiTr(
        String pZtrsakuseiymd,
        String pZtrrenrakuymd,
        String pZtrrenrakukaisuu,
        String pZtrbankcd,
        String pZtrshitencd,
        String pZtryokinkbn,
        String pZtrkouzano,
        String pZtrzndktuukasyu,
        String pZtrsyorino1
    ) {
        ztrsakuseiymd = pZtrsakuseiymd;
        ztrrenrakuymd = pZtrrenrakuymd;
        ztrrenrakukaisuu = pZtrrenrakukaisuu;
        ztrbankcd = pZtrbankcd;
        ztrshitencd = pZtrshitencd;
        ztryokinkbn = pZtryokinkbn;
        ztrkouzano = pZtrkouzano;
        ztrzndktuukasyu = pZtrzndktuukasyu;
        ztrsyorino1 = pZtrsyorino1;
    }

    @Transient
    @Override
    public Class<ZT_GknyknmeisaiTr> getEntityClass() {
        return ZT_GknyknmeisaiTr.class;
    }

    private String ztrsakuseiymd;

    public String getZtrsakuseiymd() {
        return ztrsakuseiymd;
    }

    public void setZtrsakuseiymd(String pZtrsakuseiymd) {
        ztrsakuseiymd = pZtrsakuseiymd;
    }
    private String ztrrenrakuymd;

    public String getZtrrenrakuymd() {
        return ztrrenrakuymd;
    }

    public void setZtrrenrakuymd(String pZtrrenrakuymd) {
        ztrrenrakuymd = pZtrrenrakuymd;
    }
    private String ztrrenrakukaisuu;

    public String getZtrrenrakukaisuu() {
        return ztrrenrakukaisuu;
    }

    public void setZtrrenrakukaisuu(String pZtrrenrakukaisuu) {
        ztrrenrakukaisuu = pZtrrenrakukaisuu;
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
    private String ztrzndktuukasyu;

    public String getZtrzndktuukasyu() {
        return ztrzndktuukasyu;
    }

    public void setZtrzndktuukasyu(String pZtrzndktuukasyu) {
        ztrzndktuukasyu = pZtrzndktuukasyu;
    }
    private String ztrsyorino1;

    public String getZtrsyorino1() {
        return ztrsyorino1;
    }

    public void setZtrsyorino1(String pZtrsyorino1) {
        ztrsyorino1 = pZtrsyorino1;
    }

}