package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_GknyknmeisaiTr;
import yuyu.def.db.id.PKZT_GknyknmeisaiTr;
import yuyu.def.db.meta.GenQZT_GknyknmeisaiTr;
import yuyu.def.db.meta.QZT_GknyknmeisaiTr;

/**
 * 外貨入出金明細テーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_GknyknmeisaiTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GknyknmeisaiTr}</td><td colspan="3">外貨入出金明細テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrdatakbn1 ztrdatakbn1}</td><td>（取込用）データ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyubetucd ztrsyubetucd}</td><td>（取込用）種別コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcdkbn ztrcdkbn}</td><td>（取込用）コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsakuseiymd ztrsakuseiymd}</td><td>（取込用）作成日</td><td align="center">{@link PKZT_GknyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrenrakuymd ztrrenrakuymd}</td><td>（取込用）連絡日</td><td align="center">{@link PKZT_GknyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrenrakukaisuu ztrrenrakukaisuu}</td><td>（取込用）連絡回数</td><td align="center">{@link PKZT_GknyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrknjyymdfrom ztrknjyymdfrom}</td><td>（取込用）勘定日（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrknjyymdto ztrknjyymdto}</td><td>（取込用）勘定日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbankcd ztrbankcd}</td><td>（取込用）銀行番号</td><td align="center">{@link PKZT_GknyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbanknmej ztrbanknmej}</td><td>（取込用）銀行名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsitencdtori ztrsitencdtori}</td><td>（取込用）支店コード（取次）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsitennmejtori ztrsitennmejtori}</td><td>（取込用）支店名（英字）（取次）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrshitencd ztrshitencd}</td><td>（取込用）支店番号</td><td align="center">{@link PKZT_GknyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsitennmej ztrsitennmej}</td><td>（取込用）支店名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryokinkbn ztryokinkbn}</td><td>（取込用）預金種目区分</td><td align="center">{@link PKZT_GknyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkouzano ztrkouzano}</td><td>（取込用）口座番号</td><td align="center">{@link PKZT_GknyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkznmej ztrkznmej}</td><td>（取込用）口座名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrzndktuukasyu ztrzndktuukasyu}</td><td>（取込用）残高通貨種類</td><td align="center">{@link PKZT_GknyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrzndkssketa ztrzndkssketa}</td><td>（取込用）残高小数桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrgktrhkmaezndk ztrgktrhkmaezndk}</td><td>（取込用）外貨取引前残高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkasikosikbn ztrkasikosikbn}</td><td>（取込用）貸越区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv86 ztryobiv86}</td><td>（取込用）予備項目Ｖ８６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdatakbn2 ztrdatakbn2}</td><td>（取込用）データ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdtrecordkbn1 ztrdtrecordkbn1}</td><td>（取込用）データレコード区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdtrecordkousei ztrdtrecordkousei}</td><td>（取込用）データレコード構成</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyorino1 ztrsyorino1}</td><td>（取込用）処理通番１</td><td align="center">{@link PKZT_GknyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrknjyymd ztrknjyymd}</td><td>（取込用）勘定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrksnymd ztrksnymd}</td><td>（取込用）起算日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtriribaraikbn ztriribaraikbn}</td><td>（取込用）入払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtrhkkbn ztrtrhkkbn}</td><td>（取込用）取引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtrhktuukasyu ztrtrhktuukasyu}</td><td>（取込用）取引通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtrhkssketa ztrtrhkssketa}</td><td>（取込用）取引小数桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrgktrhkgk ztrgktrhkgk}</td><td>（取込用）外貨取引金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbanksyoukaino ztrbanksyoukaino}</td><td>（取込用）銀行照会番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtrhksyoukaino ztrtrhksyoukaino}</td><td>（取込用）取引先照会番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtekiyounaiyouej ztrtekiyounaiyouej}</td><td>（取込用）摘要内容（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv103 ztryobiv103}</td><td>（取込用）予備項目Ｖ１０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdatakbn3 ztrdatakbn3}</td><td>（取込用）データ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdtrecordkbn2 ztrdtrecordkbn2}</td><td>（取込用）データレコード区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdtkouseikbn ztrdtkouseikbn}</td><td>（取込用）データ構成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtrkscd ztrtrkscd}</td><td>（取込用）取消コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyorino2 ztrsyorino2}</td><td>（取込用）処理通番２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbanksyoukaino2 ztrbanksyoukaino2}</td><td>（取込用）銀行照会番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsimukeymd ztrsimukeymd}</td><td>（取込用）仕向日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsetujyuymd ztrsetujyuymd}</td><td>（取込用）接受日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsoukinsyu ztrsoukinsyu}</td><td>（取込用）送金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrvalueymd ztrvalueymd}</td><td>（取込用）バリュー日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrskntuukasyu ztrskntuukasyu}</td><td>（取込用）送金通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsknssketa ztrsknssketa}</td><td>（取込用）送金小数桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrgksoukingk ztrgksoukingk}</td><td>（取込用）外貨送金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrirninnm ztrirninnm}</td><td>（取込用）依頼人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv40 ztryobiv40}</td><td>（取込用）予備項目Ｖ４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdatakbn4 ztrdatakbn4}</td><td>（取込用）データ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdtrecordkbn3 ztrdtrecordkbn3}</td><td>（取込用）データレコード区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdourecordsuu1 ztrdourecordsuu1}</td><td>（取込用）同種レコード数１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdourecordno1 ztrdourecordno1}</td><td>（取込用）同種レコード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkahensuu1 ztrkahensuu1}</td><td>（取込用）可変項目数１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkahenketa1 ztrkahenketa1}</td><td>（取込用）可変項目桁数１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkahen1 ztrkahen1}</td><td>（取込用）可変項目１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdatakbn5 ztrdatakbn5}</td><td>（取込用）データ区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdtrecordkbn4 ztrdtrecordkbn4}</td><td>（取込用）データレコード区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdourecordsuu2 ztrdourecordsuu2}</td><td>（取込用）同種レコード数２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdourecordno2 ztrdourecordno2}</td><td>（取込用）同種レコード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkahensuu2 ztrkahensuu2}</td><td>（取込用）可変項目数２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkahenketa2 ztrkahenketa2}</td><td>（取込用）可変項目桁数２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkahen2 ztrkahen2}</td><td>（取込用）可変項目２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdatakbn6 ztrdatakbn6}</td><td>（取込用）データ区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdtrecordkbn5 ztrdtrecordkbn5}</td><td>（取込用）データレコード区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdourecordsuu3 ztrdourecordsuu3}</td><td>（取込用）同種レコード数３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdourecordno3 ztrdourecordno3}</td><td>（取込用）同種レコード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkahensuu3 ztrkahensuu3}</td><td>（取込用）可変項目数３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkahenketa3 ztrkahenketa3}</td><td>（取込用）可変項目桁数３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkahen3 ztrkahen3}</td><td>（取込用）可変項目３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_GknyknmeisaiTr
 * @see     PKZT_GknyknmeisaiTr
 * @see     QZT_GknyknmeisaiTr
 * @see     GenQZT_GknyknmeisaiTr
 */
@MappedSuperclass
@Table(name=GenZT_GknyknmeisaiTr.TABLE_NAME)
@IdClass(value=PKZT_GknyknmeisaiTr.class)
public abstract class GenZT_GknyknmeisaiTr extends AbstractExDBEntity<ZT_GknyknmeisaiTr, PKZT_GknyknmeisaiTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_GknyknmeisaiTr";
    public static final String ZTRDATAKBN1              = "ztrdatakbn1";
    public static final String ZTRSYUBETUCD             = "ztrsyubetucd";
    public static final String ZTRCDKBN                 = "ztrcdkbn";
    public static final String ZTRSAKUSEIYMD            = "ztrsakuseiymd";
    public static final String ZTRRENRAKUYMD            = "ztrrenrakuymd";
    public static final String ZTRRENRAKUKAISUU         = "ztrrenrakukaisuu";
    public static final String ZTRKNJYYMDFROM           = "ztrknjyymdfrom";
    public static final String ZTRKNJYYMDTO             = "ztrknjyymdto";
    public static final String ZTRBANKCD                = "ztrbankcd";
    public static final String ZTRBANKNMEJ              = "ztrbanknmej";
    public static final String ZTRSITENCDTORI           = "ztrsitencdtori";
    public static final String ZTRSITENNMEJTORI         = "ztrsitennmejtori";
    public static final String ZTRSHITENCD              = "ztrshitencd";
    public static final String ZTRSITENNMEJ             = "ztrsitennmej";
    public static final String ZTRYOKINKBN              = "ztryokinkbn";
    public static final String ZTRKOUZANO               = "ztrkouzano";
    public static final String ZTRKZNMEJ                = "ztrkznmej";
    public static final String ZTRZNDKTUUKASYU          = "ztrzndktuukasyu";
    public static final String ZTRZNDKSSKETA            = "ztrzndkssketa";
    public static final String ZTRGKTRHKMAEZNDK         = "ztrgktrhkmaezndk";
    public static final String ZTRKASIKOSIKBN           = "ztrkasikosikbn";
    public static final String ZTRYOBIV86               = "ztryobiv86";
    public static final String ZTRDATAKBN2              = "ztrdatakbn2";
    public static final String ZTRDTRECORDKBN1          = "ztrdtrecordkbn1";
    public static final String ZTRDTRECORDKOUSEI        = "ztrdtrecordkousei";
    public static final String ZTRSYORINO1              = "ztrsyorino1";
    public static final String ZTRKNJYYMD               = "ztrknjyymd";
    public static final String ZTRKSNYMD                = "ztrksnymd";
    public static final String ZTRIRIBARAIKBN           = "ztriribaraikbn";
    public static final String ZTRTRHKKBN               = "ztrtrhkkbn";
    public static final String ZTRTRHKTUUKASYU          = "ztrtrhktuukasyu";
    public static final String ZTRTRHKSSKETA            = "ztrtrhkssketa";
    public static final String ZTRGKTRHKGK              = "ztrgktrhkgk";
    public static final String ZTRBANKSYOUKAINO         = "ztrbanksyoukaino";
    public static final String ZTRTRHKSYOUKAINO         = "ztrtrhksyoukaino";
    public static final String ZTRTEKIYOUNAIYOUEJ       = "ztrtekiyounaiyouej";
    public static final String ZTRYOBIV103              = "ztryobiv103";
    public static final String ZTRDATAKBN3              = "ztrdatakbn3";
    public static final String ZTRDTRECORDKBN2          = "ztrdtrecordkbn2";
    public static final String ZTRDTKOUSEIKBN           = "ztrdtkouseikbn";
    public static final String ZTRTRKSCD                = "ztrtrkscd";
    public static final String ZTRSYORINO2              = "ztrsyorino2";
    public static final String ZTRBANKSYOUKAINO2        = "ztrbanksyoukaino2";
    public static final String ZTRSIMUKEYMD             = "ztrsimukeymd";
    public static final String ZTRSETUJYUYMD            = "ztrsetujyuymd";
    public static final String ZTRSOUKINSYU             = "ztrsoukinsyu";
    public static final String ZTRVALUEYMD              = "ztrvalueymd";
    public static final String ZTRSKNTUUKASYU           = "ztrskntuukasyu";
    public static final String ZTRSKNSSKETA             = "ztrsknssketa";
    public static final String ZTRGKSOUKINGK            = "ztrgksoukingk";
    public static final String ZTRIRNINNM               = "ztrirninnm";
    public static final String ZTRYOBIV40               = "ztryobiv40";
    public static final String ZTRDATAKBN4              = "ztrdatakbn4";
    public static final String ZTRDTRECORDKBN3          = "ztrdtrecordkbn3";
    public static final String ZTRDOURECORDSUU1         = "ztrdourecordsuu1";
    public static final String ZTRDOURECORDNO1          = "ztrdourecordno1";
    public static final String ZTRKAHENSUU1             = "ztrkahensuu1";
    public static final String ZTRKAHENKETA1            = "ztrkahenketa1";
    public static final String ZTRKAHEN1                = "ztrkahen1";
    public static final String ZTRDATAKBN5              = "ztrdatakbn5";
    public static final String ZTRDTRECORDKBN4          = "ztrdtrecordkbn4";
    public static final String ZTRDOURECORDSUU2         = "ztrdourecordsuu2";
    public static final String ZTRDOURECORDNO2          = "ztrdourecordno2";
    public static final String ZTRKAHENSUU2             = "ztrkahensuu2";
    public static final String ZTRKAHENKETA2            = "ztrkahenketa2";
    public static final String ZTRKAHEN2                = "ztrkahen2";
    public static final String ZTRDATAKBN6              = "ztrdatakbn6";
    public static final String ZTRDTRECORDKBN5          = "ztrdtrecordkbn5";
    public static final String ZTRDOURECORDSUU3         = "ztrdourecordsuu3";
    public static final String ZTRDOURECORDNO3          = "ztrdourecordno3";
    public static final String ZTRKAHENSUU3             = "ztrkahensuu3";
    public static final String ZTRKAHENKETA3            = "ztrkahenketa3";
    public static final String ZTRKAHEN3                = "ztrkahen3";

    private final PKZT_GknyknmeisaiTr primaryKey;

    public GenZT_GknyknmeisaiTr() {
        primaryKey = new PKZT_GknyknmeisaiTr();
    }

    public GenZT_GknyknmeisaiTr(
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
        primaryKey = new PKZT_GknyknmeisaiTr(
            pZtrsakuseiymd,
            pZtrrenrakuymd,
            pZtrrenrakukaisuu,
            pZtrbankcd,
            pZtrshitencd,
            pZtryokinkbn,
            pZtrkouzano,
            pZtrzndktuukasyu,
            pZtrsyorino1
        );
    }

    @Transient
    @Override
    public PKZT_GknyknmeisaiTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_GknyknmeisaiTr> getMetaClass() {
        return QZT_GknyknmeisaiTr.class;
    }

    private String ztrdatakbn1;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDATAKBN1)
    public String getZtrdatakbn1() {
        return ztrdatakbn1;
    }

    public void setZtrdatakbn1(String pZtrdatakbn1) {
        ztrdatakbn1 = pZtrdatakbn1;
    }

    private String ztrsyubetucd;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRSYUBETUCD)
    public String getZtrsyubetucd() {
        return ztrsyubetucd;
    }

    public void setZtrsyubetucd(String pZtrsyubetucd) {
        ztrsyubetucd = pZtrsyubetucd;
    }

    private String ztrcdkbn;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRCDKBN)
    public String getZtrcdkbn() {
        return ztrcdkbn;
    }

    public void setZtrcdkbn(String pZtrcdkbn) {
        ztrcdkbn = pZtrcdkbn;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiTr.ZTRSAKUSEIYMD)
    public String getZtrsakuseiymd() {
        return getPrimaryKey().getZtrsakuseiymd();
    }

    public void setZtrsakuseiymd(String pZtrsakuseiymd) {
        getPrimaryKey().setZtrsakuseiymd(pZtrsakuseiymd);
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiTr.ZTRRENRAKUYMD)
    public String getZtrrenrakuymd() {
        return getPrimaryKey().getZtrrenrakuymd();
    }

    public void setZtrrenrakuymd(String pZtrrenrakuymd) {
        getPrimaryKey().setZtrrenrakuymd(pZtrrenrakuymd);
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiTr.ZTRRENRAKUKAISUU)
    public String getZtrrenrakukaisuu() {
        return getPrimaryKey().getZtrrenrakukaisuu();
    }

    public void setZtrrenrakukaisuu(String pZtrrenrakukaisuu) {
        getPrimaryKey().setZtrrenrakukaisuu(pZtrrenrakukaisuu);
    }

    private String ztrknjyymdfrom;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKNJYYMDFROM)
    public String getZtrknjyymdfrom() {
        return ztrknjyymdfrom;
    }

    public void setZtrknjyymdfrom(String pZtrknjyymdfrom) {
        ztrknjyymdfrom = pZtrknjyymdfrom;
    }

    private String ztrknjyymdto;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKNJYYMDTO)
    public String getZtrknjyymdto() {
        return ztrknjyymdto;
    }

    public void setZtrknjyymdto(String pZtrknjyymdto) {
        ztrknjyymdto = pZtrknjyymdto;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiTr.ZTRBANKCD)
    public String getZtrbankcd() {
        return getPrimaryKey().getZtrbankcd();
    }

    public void setZtrbankcd(String pZtrbankcd) {
        getPrimaryKey().setZtrbankcd(pZtrbankcd);
    }

    private String ztrbanknmej;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRBANKNMEJ)
    public String getZtrbanknmej() {
        return ztrbanknmej;
    }

    public void setZtrbanknmej(String pZtrbanknmej) {
        ztrbanknmej = pZtrbanknmej;
    }

    private String ztrsitencdtori;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRSITENCDTORI)
    public String getZtrsitencdtori() {
        return ztrsitencdtori;
    }

    public void setZtrsitencdtori(String pZtrsitencdtori) {
        ztrsitencdtori = pZtrsitencdtori;
    }

    private String ztrsitennmejtori;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRSITENNMEJTORI)
    public String getZtrsitennmejtori() {
        return ztrsitennmejtori;
    }

    public void setZtrsitennmejtori(String pZtrsitennmejtori) {
        ztrsitennmejtori = pZtrsitennmejtori;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiTr.ZTRSHITENCD)
    public String getZtrshitencd() {
        return getPrimaryKey().getZtrshitencd();
    }

    public void setZtrshitencd(String pZtrshitencd) {
        getPrimaryKey().setZtrshitencd(pZtrshitencd);
    }

    private String ztrsitennmej;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRSITENNMEJ)
    public String getZtrsitennmej() {
        return ztrsitennmej;
    }

    public void setZtrsitennmej(String pZtrsitennmej) {
        ztrsitennmej = pZtrsitennmej;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiTr.ZTRYOKINKBN)
    public String getZtryokinkbn() {
        return getPrimaryKey().getZtryokinkbn();
    }

    public void setZtryokinkbn(String pZtryokinkbn) {
        getPrimaryKey().setZtryokinkbn(pZtryokinkbn);
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiTr.ZTRKOUZANO)
    public String getZtrkouzano() {
        return getPrimaryKey().getZtrkouzano();
    }

    public void setZtrkouzano(String pZtrkouzano) {
        getPrimaryKey().setZtrkouzano(pZtrkouzano);
    }

    private String ztrkznmej;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKZNMEJ)
    public String getZtrkznmej() {
        return ztrkznmej;
    }

    public void setZtrkznmej(String pZtrkznmej) {
        ztrkznmej = pZtrkznmej;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiTr.ZTRZNDKTUUKASYU)
    public String getZtrzndktuukasyu() {
        return getPrimaryKey().getZtrzndktuukasyu();
    }

    public void setZtrzndktuukasyu(String pZtrzndktuukasyu) {
        getPrimaryKey().setZtrzndktuukasyu(pZtrzndktuukasyu);
    }

    private String ztrzndkssketa;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRZNDKSSKETA)
    public String getZtrzndkssketa() {
        return ztrzndkssketa;
    }

    public void setZtrzndkssketa(String pZtrzndkssketa) {
        ztrzndkssketa = pZtrzndkssketa;
    }

    private String ztrgktrhkmaezndk;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRGKTRHKMAEZNDK)
    public String getZtrgktrhkmaezndk() {
        return ztrgktrhkmaezndk;
    }

    public void setZtrgktrhkmaezndk(String pZtrgktrhkmaezndk) {
        ztrgktrhkmaezndk = pZtrgktrhkmaezndk;
    }

    private String ztrkasikosikbn;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKASIKOSIKBN)
    public String getZtrkasikosikbn() {
        return ztrkasikosikbn;
    }

    public void setZtrkasikosikbn(String pZtrkasikosikbn) {
        ztrkasikosikbn = pZtrkasikosikbn;
    }

    private String ztryobiv86;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRYOBIV86)
    public String getZtryobiv86() {
        return ztryobiv86;
    }

    public void setZtryobiv86(String pZtryobiv86) {
        ztryobiv86 = pZtryobiv86;
    }

    private String ztrdatakbn2;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDATAKBN2)
    public String getZtrdatakbn2() {
        return ztrdatakbn2;
    }

    public void setZtrdatakbn2(String pZtrdatakbn2) {
        ztrdatakbn2 = pZtrdatakbn2;
    }

    private String ztrdtrecordkbn1;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDTRECORDKBN1)
    public String getZtrdtrecordkbn1() {
        return ztrdtrecordkbn1;
    }

    public void setZtrdtrecordkbn1(String pZtrdtrecordkbn1) {
        ztrdtrecordkbn1 = pZtrdtrecordkbn1;
    }

    private String ztrdtrecordkousei;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDTRECORDKOUSEI)
    public String getZtrdtrecordkousei() {
        return ztrdtrecordkousei;
    }

    public void setZtrdtrecordkousei(String pZtrdtrecordkousei) {
        ztrdtrecordkousei = pZtrdtrecordkousei;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiTr.ZTRSYORINO1)
    public String getZtrsyorino1() {
        return getPrimaryKey().getZtrsyorino1();
    }

    public void setZtrsyorino1(String pZtrsyorino1) {
        getPrimaryKey().setZtrsyorino1(pZtrsyorino1);
    }

    private String ztrknjyymd;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKNJYYMD)
    public String getZtrknjyymd() {
        return ztrknjyymd;
    }

    public void setZtrknjyymd(String pZtrknjyymd) {
        ztrknjyymd = pZtrknjyymd;
    }

    private String ztrksnymd;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKSNYMD)
    public String getZtrksnymd() {
        return ztrksnymd;
    }

    public void setZtrksnymd(String pZtrksnymd) {
        ztrksnymd = pZtrksnymd;
    }

    private String ztriribaraikbn;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRIRIBARAIKBN)
    public String getZtriribaraikbn() {
        return ztriribaraikbn;
    }

    public void setZtriribaraikbn(String pZtriribaraikbn) {
        ztriribaraikbn = pZtriribaraikbn;
    }

    private String ztrtrhkkbn;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRTRHKKBN)
    public String getZtrtrhkkbn() {
        return ztrtrhkkbn;
    }

    public void setZtrtrhkkbn(String pZtrtrhkkbn) {
        ztrtrhkkbn = pZtrtrhkkbn;
    }

    private String ztrtrhktuukasyu;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRTRHKTUUKASYU)
    public String getZtrtrhktuukasyu() {
        return ztrtrhktuukasyu;
    }

    public void setZtrtrhktuukasyu(String pZtrtrhktuukasyu) {
        ztrtrhktuukasyu = pZtrtrhktuukasyu;
    }

    private String ztrtrhkssketa;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRTRHKSSKETA)
    public String getZtrtrhkssketa() {
        return ztrtrhkssketa;
    }

    public void setZtrtrhkssketa(String pZtrtrhkssketa) {
        ztrtrhkssketa = pZtrtrhkssketa;
    }

    private String ztrgktrhkgk;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRGKTRHKGK)
    public String getZtrgktrhkgk() {
        return ztrgktrhkgk;
    }

    public void setZtrgktrhkgk(String pZtrgktrhkgk) {
        ztrgktrhkgk = pZtrgktrhkgk;
    }

    private String ztrbanksyoukaino;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRBANKSYOUKAINO)
    public String getZtrbanksyoukaino() {
        return ztrbanksyoukaino;
    }

    public void setZtrbanksyoukaino(String pZtrbanksyoukaino) {
        ztrbanksyoukaino = pZtrbanksyoukaino;
    }

    private String ztrtrhksyoukaino;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRTRHKSYOUKAINO)
    public String getZtrtrhksyoukaino() {
        return ztrtrhksyoukaino;
    }

    public void setZtrtrhksyoukaino(String pZtrtrhksyoukaino) {
        ztrtrhksyoukaino = pZtrtrhksyoukaino;
    }

    private String ztrtekiyounaiyouej;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRTEKIYOUNAIYOUEJ)
    public String getZtrtekiyounaiyouej() {
        return ztrtekiyounaiyouej;
    }

    public void setZtrtekiyounaiyouej(String pZtrtekiyounaiyouej) {
        ztrtekiyounaiyouej = pZtrtekiyounaiyouej;
    }

    private String ztryobiv103;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRYOBIV103)
    public String getZtryobiv103() {
        return ztryobiv103;
    }

    public void setZtryobiv103(String pZtryobiv103) {
        ztryobiv103 = pZtryobiv103;
    }

    private String ztrdatakbn3;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDATAKBN3)
    public String getZtrdatakbn3() {
        return ztrdatakbn3;
    }

    public void setZtrdatakbn3(String pZtrdatakbn3) {
        ztrdatakbn3 = pZtrdatakbn3;
    }

    private String ztrdtrecordkbn2;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDTRECORDKBN2)
    public String getZtrdtrecordkbn2() {
        return ztrdtrecordkbn2;
    }

    public void setZtrdtrecordkbn2(String pZtrdtrecordkbn2) {
        ztrdtrecordkbn2 = pZtrdtrecordkbn2;
    }

    private String ztrdtkouseikbn;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDTKOUSEIKBN)
    public String getZtrdtkouseikbn() {
        return ztrdtkouseikbn;
    }

    public void setZtrdtkouseikbn(String pZtrdtkouseikbn) {
        ztrdtkouseikbn = pZtrdtkouseikbn;
    }

    private String ztrtrkscd;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRTRKSCD)
    public String getZtrtrkscd() {
        return ztrtrkscd;
    }

    public void setZtrtrkscd(String pZtrtrkscd) {
        ztrtrkscd = pZtrtrkscd;
    }

    private String ztrsyorino2;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRSYORINO2)
    public String getZtrsyorino2() {
        return ztrsyorino2;
    }

    public void setZtrsyorino2(String pZtrsyorino2) {
        ztrsyorino2 = pZtrsyorino2;
    }

    private String ztrbanksyoukaino2;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRBANKSYOUKAINO2)
    public String getZtrbanksyoukaino2() {
        return ztrbanksyoukaino2;
    }

    public void setZtrbanksyoukaino2(String pZtrbanksyoukaino2) {
        ztrbanksyoukaino2 = pZtrbanksyoukaino2;
    }

    private String ztrsimukeymd;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRSIMUKEYMD)
    public String getZtrsimukeymd() {
        return ztrsimukeymd;
    }

    public void setZtrsimukeymd(String pZtrsimukeymd) {
        ztrsimukeymd = pZtrsimukeymd;
    }

    private String ztrsetujyuymd;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRSETUJYUYMD)
    public String getZtrsetujyuymd() {
        return ztrsetujyuymd;
    }

    public void setZtrsetujyuymd(String pZtrsetujyuymd) {
        ztrsetujyuymd = pZtrsetujyuymd;
    }

    private String ztrsoukinsyu;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRSOUKINSYU)
    public String getZtrsoukinsyu() {
        return ztrsoukinsyu;
    }

    public void setZtrsoukinsyu(String pZtrsoukinsyu) {
        ztrsoukinsyu = pZtrsoukinsyu;
    }

    private String ztrvalueymd;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRVALUEYMD)
    public String getZtrvalueymd() {
        return ztrvalueymd;
    }

    public void setZtrvalueymd(String pZtrvalueymd) {
        ztrvalueymd = pZtrvalueymd;
    }

    private String ztrskntuukasyu;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRSKNTUUKASYU)
    public String getZtrskntuukasyu() {
        return ztrskntuukasyu;
    }

    public void setZtrskntuukasyu(String pZtrskntuukasyu) {
        ztrskntuukasyu = pZtrskntuukasyu;
    }

    private String ztrsknssketa;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRSKNSSKETA)
    public String getZtrsknssketa() {
        return ztrsknssketa;
    }

    public void setZtrsknssketa(String pZtrsknssketa) {
        ztrsknssketa = pZtrsknssketa;
    }

    private String ztrgksoukingk;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRGKSOUKINGK)
    public String getZtrgksoukingk() {
        return ztrgksoukingk;
    }

    public void setZtrgksoukingk(String pZtrgksoukingk) {
        ztrgksoukingk = pZtrgksoukingk;
    }

    private String ztrirninnm;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRIRNINNM)
    public String getZtrirninnm() {
        return ztrirninnm;
    }

    public void setZtrirninnm(String pZtrirninnm) {
        ztrirninnm = pZtrirninnm;
    }

    private String ztryobiv40;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRYOBIV40)
    public String getZtryobiv40() {
        return ztryobiv40;
    }

    public void setZtryobiv40(String pZtryobiv40) {
        ztryobiv40 = pZtryobiv40;
    }

    private String ztrdatakbn4;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDATAKBN4)
    public String getZtrdatakbn4() {
        return ztrdatakbn4;
    }

    public void setZtrdatakbn4(String pZtrdatakbn4) {
        ztrdatakbn4 = pZtrdatakbn4;
    }

    private String ztrdtrecordkbn3;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDTRECORDKBN3)
    public String getZtrdtrecordkbn3() {
        return ztrdtrecordkbn3;
    }

    public void setZtrdtrecordkbn3(String pZtrdtrecordkbn3) {
        ztrdtrecordkbn3 = pZtrdtrecordkbn3;
    }

    private String ztrdourecordsuu1;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDOURECORDSUU1)
    public String getZtrdourecordsuu1() {
        return ztrdourecordsuu1;
    }

    public void setZtrdourecordsuu1(String pZtrdourecordsuu1) {
        ztrdourecordsuu1 = pZtrdourecordsuu1;
    }

    private String ztrdourecordno1;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDOURECORDNO1)
    public String getZtrdourecordno1() {
        return ztrdourecordno1;
    }

    public void setZtrdourecordno1(String pZtrdourecordno1) {
        ztrdourecordno1 = pZtrdourecordno1;
    }

    private String ztrkahensuu1;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKAHENSUU1)
    public String getZtrkahensuu1() {
        return ztrkahensuu1;
    }

    public void setZtrkahensuu1(String pZtrkahensuu1) {
        ztrkahensuu1 = pZtrkahensuu1;
    }

    private String ztrkahenketa1;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKAHENKETA1)
    public String getZtrkahenketa1() {
        return ztrkahenketa1;
    }

    public void setZtrkahenketa1(String pZtrkahenketa1) {
        ztrkahenketa1 = pZtrkahenketa1;
    }

    private String ztrkahen1;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKAHEN1)
    public String getZtrkahen1() {
        return ztrkahen1;
    }

    public void setZtrkahen1(String pZtrkahen1) {
        ztrkahen1 = pZtrkahen1;
    }

    private String ztrdatakbn5;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDATAKBN5)
    public String getZtrdatakbn5() {
        return ztrdatakbn5;
    }

    public void setZtrdatakbn5(String pZtrdatakbn5) {
        ztrdatakbn5 = pZtrdatakbn5;
    }

    private String ztrdtrecordkbn4;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDTRECORDKBN4)
    public String getZtrdtrecordkbn4() {
        return ztrdtrecordkbn4;
    }

    public void setZtrdtrecordkbn4(String pZtrdtrecordkbn4) {
        ztrdtrecordkbn4 = pZtrdtrecordkbn4;
    }

    private String ztrdourecordsuu2;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDOURECORDSUU2)
    public String getZtrdourecordsuu2() {
        return ztrdourecordsuu2;
    }

    public void setZtrdourecordsuu2(String pZtrdourecordsuu2) {
        ztrdourecordsuu2 = pZtrdourecordsuu2;
    }

    private String ztrdourecordno2;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDOURECORDNO2)
    public String getZtrdourecordno2() {
        return ztrdourecordno2;
    }

    public void setZtrdourecordno2(String pZtrdourecordno2) {
        ztrdourecordno2 = pZtrdourecordno2;
    }

    private String ztrkahensuu2;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKAHENSUU2)
    public String getZtrkahensuu2() {
        return ztrkahensuu2;
    }

    public void setZtrkahensuu2(String pZtrkahensuu2) {
        ztrkahensuu2 = pZtrkahensuu2;
    }

    private String ztrkahenketa2;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKAHENKETA2)
    public String getZtrkahenketa2() {
        return ztrkahenketa2;
    }

    public void setZtrkahenketa2(String pZtrkahenketa2) {
        ztrkahenketa2 = pZtrkahenketa2;
    }

    private String ztrkahen2;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKAHEN2)
    public String getZtrkahen2() {
        return ztrkahen2;
    }

    public void setZtrkahen2(String pZtrkahen2) {
        ztrkahen2 = pZtrkahen2;
    }

    private String ztrdatakbn6;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDATAKBN6)
    public String getZtrdatakbn6() {
        return ztrdatakbn6;
    }

    public void setZtrdatakbn6(String pZtrdatakbn6) {
        ztrdatakbn6 = pZtrdatakbn6;
    }

    private String ztrdtrecordkbn5;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDTRECORDKBN5)
    public String getZtrdtrecordkbn5() {
        return ztrdtrecordkbn5;
    }

    public void setZtrdtrecordkbn5(String pZtrdtrecordkbn5) {
        ztrdtrecordkbn5 = pZtrdtrecordkbn5;
    }

    private String ztrdourecordsuu3;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDOURECORDSUU3)
    public String getZtrdourecordsuu3() {
        return ztrdourecordsuu3;
    }

    public void setZtrdourecordsuu3(String pZtrdourecordsuu3) {
        ztrdourecordsuu3 = pZtrdourecordsuu3;
    }

    private String ztrdourecordno3;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRDOURECORDNO3)
    public String getZtrdourecordno3() {
        return ztrdourecordno3;
    }

    public void setZtrdourecordno3(String pZtrdourecordno3) {
        ztrdourecordno3 = pZtrdourecordno3;
    }

    private String ztrkahensuu3;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKAHENSUU3)
    public String getZtrkahensuu3() {
        return ztrkahensuu3;
    }

    public void setZtrkahensuu3(String pZtrkahensuu3) {
        ztrkahensuu3 = pZtrkahensuu3;
    }

    private String ztrkahenketa3;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKAHENKETA3)
    public String getZtrkahenketa3() {
        return ztrkahenketa3;
    }

    public void setZtrkahenketa3(String pZtrkahenketa3) {
        ztrkahenketa3 = pZtrkahenketa3;
    }

    private String ztrkahen3;

    @Column(name=GenZT_GknyknmeisaiTr.ZTRKAHEN3)
    public String getZtrkahen3() {
        return ztrkahen3;
    }

    public void setZtrkahen3(String pZtrkahen3) {
        ztrkahen3 = pZtrkahen3;
    }
}
