package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_GknyknmeisaiRn;
import yuyu.def.db.id.PKZT_GknyknmeisaiRn;
import yuyu.def.db.meta.GenQZT_GknyknmeisaiRn;
import yuyu.def.db.meta.QZT_GknyknmeisaiRn;

/**
 * 外貨入出金明細テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_GknyknmeisaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GknyknmeisaiRn}</td><td colspan="3">外貨入出金明細テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndatakbn1 zrndatakbn1}</td><td>（連携用）データ区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyubetucd zrnsyubetucd}</td><td>（連携用）種別コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncdkbn zrncdkbn}</td><td>（連携用）コード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseiymd zrnsakuseiymd}</td><td>（連携用）作成日</td><td align="center">{@link PKZT_GknyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenrakuymd zrnrenrakuymd}</td><td>（連携用）連絡日</td><td align="center">{@link PKZT_GknyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenrakukaisuu zrnrenrakukaisuu}</td><td>（連携用）連絡回数</td><td align="center">{@link PKZT_GknyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjyymdfrom zrnknjyymdfrom}</td><td>（連携用）勘定日（自）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjyymdto zrnknjyymdto}</td><td>（連携用）勘定日（至）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbankcd zrnbankcd}</td><td>（連携用）銀行番号</td><td align="center">{@link PKZT_GknyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbanknmej zrnbanknmej}</td><td>（連携用）銀行名（英字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsitencdtori zrnsitencdtori}</td><td>（連携用）支店コード（取次）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsitennmejtori zrnsitennmejtori}</td><td>（連携用）支店名（英字）（取次）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshitencd zrnshitencd}</td><td>（連携用）支店番号</td><td align="center">{@link PKZT_GknyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsitennmej zrnsitennmej}</td><td>（連携用）支店名（英字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokinkbn zrnyokinkbn}</td><td>（連携用）預金種目区分</td><td align="center">{@link PKZT_GknyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzano zrnkouzano}</td><td>（連携用）口座番号</td><td align="center">{@link PKZT_GknyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkznmej zrnkznmej}</td><td>（連携用）口座名（英字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzndktuukasyu zrnzndktuukasyu}</td><td>（連携用）残高通貨種類</td><td align="center">{@link PKZT_GknyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzndkssketa zrnzndkssketa}</td><td>（連携用）残高小数桁</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngktrhkmaezndk zrngktrhkmaezndk}</td><td>（連携用）外貨取引前残高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasikosikbn zrnkasikosikbn}</td><td>（連携用）貸越区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv86 zrnyobiv86}</td><td>（連携用）予備項目Ｖ８６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakbn2 zrndatakbn2}</td><td>（連携用）データ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndtrecordkbn1 zrndtrecordkbn1}</td><td>（連携用）データレコード区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndtrecordkousei zrndtrecordkousei}</td><td>（連携用）データレコード構成</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorino1 zrnsyorino1}</td><td>（連携用）処理通番１</td><td align="center">{@link PKZT_GknyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjyymd zrnknjyymd}</td><td>（連携用）勘定日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnksnymd zrnksnymd}</td><td>（連携用）起算日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrniribaraikbn zrniribaraikbn}</td><td>（連携用）入払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrhkkbn zrntrhkkbn}</td><td>（連携用）取引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrhktuukasyu zrntrhktuukasyu}</td><td>（連携用）取引通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrhkssketa zrntrhkssketa}</td><td>（連携用）取引小数桁</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngktrhkgk zrngktrhkgk}</td><td>（連携用）外貨取引金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbanksyoukaino zrnbanksyoukaino}</td><td>（連携用）銀行照会番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrhksyoukaino zrntrhksyoukaino}</td><td>（連携用）取引先照会番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyounaiyouej zrntekiyounaiyouej}</td><td>（連携用）摘要内容（英字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv103 zrnyobiv103}</td><td>（連携用）予備項目Ｖ１０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakbn3 zrndatakbn3}</td><td>（連携用）データ区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndtrecordkbn2 zrndtrecordkbn2}</td><td>（連携用）データレコード区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndtkouseikbn zrndtkouseikbn}</td><td>（連携用）データ構成区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkscd zrntrkscd}</td><td>（連携用）取消コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorino2 zrnsyorino2}</td><td>（連携用）処理通番２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbanksyoukaino2 zrnbanksyoukaino2}</td><td>（連携用）銀行照会番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimukeymd zrnsimukeymd}</td><td>（連携用）仕向日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetujyuymd zrnsetujyuymd}</td><td>（連携用）接受日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsoukinsyu zrnsoukinsyu}</td><td>（連携用）送金種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvalueymd zrnvalueymd}</td><td>（連携用）バリュー日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskntuukasyu zrnskntuukasyu}</td><td>（連携用）送金通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsknssketa zrnsknssketa}</td><td>（連携用）送金小数桁</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngksoukingk zrngksoukingk}</td><td>（連携用）外貨送金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnirninnm zrnirninnm}</td><td>（連携用）依頼人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv40 zrnyobiv40}</td><td>（連携用）予備項目Ｖ４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakbn4 zrndatakbn4}</td><td>（連携用）データ区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndtrecordkbn3 zrndtrecordkbn3}</td><td>（連携用）データレコード区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndourecordsuu1 zrndourecordsuu1}</td><td>（連携用）同種レコード数１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndourecordno1 zrndourecordno1}</td><td>（連携用）同種レコード番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkahensuu1 zrnkahensuu1}</td><td>（連携用）可変項目数１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkahenketa1 zrnkahenketa1}</td><td>（連携用）可変項目桁数１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkahen1 zrnkahen1}</td><td>（連携用）可変項目１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakbn5 zrndatakbn5}</td><td>（連携用）データ区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndtrecordkbn4 zrndtrecordkbn4}</td><td>（連携用）データレコード区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndourecordsuu2 zrndourecordsuu2}</td><td>（連携用）同種レコード数２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndourecordno2 zrndourecordno2}</td><td>（連携用）同種レコード番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkahensuu2 zrnkahensuu2}</td><td>（連携用）可変項目数２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkahenketa2 zrnkahenketa2}</td><td>（連携用）可変項目桁数２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkahen2 zrnkahen2}</td><td>（連携用）可変項目２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakbn6 zrndatakbn6}</td><td>（連携用）データ区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndtrecordkbn5 zrndtrecordkbn5}</td><td>（連携用）データレコード区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndourecordsuu3 zrndourecordsuu3}</td><td>（連携用）同種レコード数３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndourecordno3 zrndourecordno3}</td><td>（連携用）同種レコード番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkahensuu3 zrnkahensuu3}</td><td>（連携用）可変項目数３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkahenketa3 zrnkahenketa3}</td><td>（連携用）可変項目桁数３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkahen3 zrnkahen3}</td><td>（連携用）可変項目３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_GknyknmeisaiRn
 * @see     PKZT_GknyknmeisaiRn
 * @see     QZT_GknyknmeisaiRn
 * @see     GenQZT_GknyknmeisaiRn
 */
@MappedSuperclass
@Table(name=GenZT_GknyknmeisaiRn.TABLE_NAME)
@IdClass(value=PKZT_GknyknmeisaiRn.class)
public abstract class GenZT_GknyknmeisaiRn extends AbstractExDBEntityForZDB<ZT_GknyknmeisaiRn, PKZT_GknyknmeisaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_GknyknmeisaiRn";
    public static final String ZRNDATAKBN1              = "zrndatakbn1";
    public static final String ZRNSYUBETUCD             = "zrnsyubetucd";
    public static final String ZRNCDKBN                 = "zrncdkbn";
    public static final String ZRNSAKUSEIYMD            = "zrnsakuseiymd";
    public static final String ZRNRENRAKUYMD            = "zrnrenrakuymd";
    public static final String ZRNRENRAKUKAISUU         = "zrnrenrakukaisuu";
    public static final String ZRNKNJYYMDFROM           = "zrnknjyymdfrom";
    public static final String ZRNKNJYYMDTO             = "zrnknjyymdto";
    public static final String ZRNBANKCD                = "zrnbankcd";
    public static final String ZRNBANKNMEJ              = "zrnbanknmej";
    public static final String ZRNSITENCDTORI           = "zrnsitencdtori";
    public static final String ZRNSITENNMEJTORI         = "zrnsitennmejtori";
    public static final String ZRNSHITENCD              = "zrnshitencd";
    public static final String ZRNSITENNMEJ             = "zrnsitennmej";
    public static final String ZRNYOKINKBN              = "zrnyokinkbn";
    public static final String ZRNKOUZANO               = "zrnkouzano";
    public static final String ZRNKZNMEJ                = "zrnkznmej";
    public static final String ZRNZNDKTUUKASYU          = "zrnzndktuukasyu";
    public static final String ZRNZNDKSSKETA            = "zrnzndkssketa";
    public static final String ZRNGKTRHKMAEZNDK         = "zrngktrhkmaezndk";
    public static final String ZRNKASIKOSIKBN           = "zrnkasikosikbn";
    public static final String ZRNYOBIV86               = "zrnyobiv86";
    public static final String ZRNDATAKBN2              = "zrndatakbn2";
    public static final String ZRNDTRECORDKBN1          = "zrndtrecordkbn1";
    public static final String ZRNDTRECORDKOUSEI        = "zrndtrecordkousei";
    public static final String ZRNSYORINO1              = "zrnsyorino1";
    public static final String ZRNKNJYYMD               = "zrnknjyymd";
    public static final String ZRNKSNYMD                = "zrnksnymd";
    public static final String ZRNIRIBARAIKBN           = "zrniribaraikbn";
    public static final String ZRNTRHKKBN               = "zrntrhkkbn";
    public static final String ZRNTRHKTUUKASYU          = "zrntrhktuukasyu";
    public static final String ZRNTRHKSSKETA            = "zrntrhkssketa";
    public static final String ZRNGKTRHKGK              = "zrngktrhkgk";
    public static final String ZRNBANKSYOUKAINO         = "zrnbanksyoukaino";
    public static final String ZRNTRHKSYOUKAINO         = "zrntrhksyoukaino";
    public static final String ZRNTEKIYOUNAIYOUEJ       = "zrntekiyounaiyouej";
    public static final String ZRNYOBIV103              = "zrnyobiv103";
    public static final String ZRNDATAKBN3              = "zrndatakbn3";
    public static final String ZRNDTRECORDKBN2          = "zrndtrecordkbn2";
    public static final String ZRNDTKOUSEIKBN           = "zrndtkouseikbn";
    public static final String ZRNTRKSCD                = "zrntrkscd";
    public static final String ZRNSYORINO2              = "zrnsyorino2";
    public static final String ZRNBANKSYOUKAINO2        = "zrnbanksyoukaino2";
    public static final String ZRNSIMUKEYMD             = "zrnsimukeymd";
    public static final String ZRNSETUJYUYMD            = "zrnsetujyuymd";
    public static final String ZRNSOUKINSYU             = "zrnsoukinsyu";
    public static final String ZRNVALUEYMD              = "zrnvalueymd";
    public static final String ZRNSKNTUUKASYU           = "zrnskntuukasyu";
    public static final String ZRNSKNSSKETA             = "zrnsknssketa";
    public static final String ZRNGKSOUKINGK            = "zrngksoukingk";
    public static final String ZRNIRNINNM               = "zrnirninnm";
    public static final String ZRNYOBIV40               = "zrnyobiv40";
    public static final String ZRNDATAKBN4              = "zrndatakbn4";
    public static final String ZRNDTRECORDKBN3          = "zrndtrecordkbn3";
    public static final String ZRNDOURECORDSUU1         = "zrndourecordsuu1";
    public static final String ZRNDOURECORDNO1          = "zrndourecordno1";
    public static final String ZRNKAHENSUU1             = "zrnkahensuu1";
    public static final String ZRNKAHENKETA1            = "zrnkahenketa1";
    public static final String ZRNKAHEN1                = "zrnkahen1";
    public static final String ZRNDATAKBN5              = "zrndatakbn5";
    public static final String ZRNDTRECORDKBN4          = "zrndtrecordkbn4";
    public static final String ZRNDOURECORDSUU2         = "zrndourecordsuu2";
    public static final String ZRNDOURECORDNO2          = "zrndourecordno2";
    public static final String ZRNKAHENSUU2             = "zrnkahensuu2";
    public static final String ZRNKAHENKETA2            = "zrnkahenketa2";
    public static final String ZRNKAHEN2                = "zrnkahen2";
    public static final String ZRNDATAKBN6              = "zrndatakbn6";
    public static final String ZRNDTRECORDKBN5          = "zrndtrecordkbn5";
    public static final String ZRNDOURECORDSUU3         = "zrndourecordsuu3";
    public static final String ZRNDOURECORDNO3          = "zrndourecordno3";
    public static final String ZRNKAHENSUU3             = "zrnkahensuu3";
    public static final String ZRNKAHENKETA3            = "zrnkahenketa3";
    public static final String ZRNKAHEN3                = "zrnkahen3";

    private final PKZT_GknyknmeisaiRn primaryKey;

    public GenZT_GknyknmeisaiRn() {
        primaryKey = new PKZT_GknyknmeisaiRn();
    }

    public GenZT_GknyknmeisaiRn(
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
        primaryKey = new PKZT_GknyknmeisaiRn(
            pZrnsakuseiymd,
            pZrnrenrakuymd,
            pZrnrenrakukaisuu,
            pZrnbankcd,
            pZrnshitencd,
            pZrnyokinkbn,
            pZrnkouzano,
            pZrnzndktuukasyu,
            pZrnsyorino1
        );
    }

    @Transient
    @Override
    public PKZT_GknyknmeisaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_GknyknmeisaiRn> getMetaClass() {
        return QZT_GknyknmeisaiRn.class;
    }

    private String zrndatakbn1;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDATAKBN1)
    public String getZrndatakbn1() {
        return zrndatakbn1;
    }

    public void setZrndatakbn1(String pZrndatakbn1) {
        zrndatakbn1 = pZrndatakbn1;
    }

    private String zrnsyubetucd;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNSYUBETUCD)
    public String getZrnsyubetucd() {
        return zrnsyubetucd;
    }

    public void setZrnsyubetucd(String pZrnsyubetucd) {
        zrnsyubetucd = pZrnsyubetucd;
    }

    private String zrncdkbn;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNCDKBN)
    public String getZrncdkbn() {
        return zrncdkbn;
    }

    public void setZrncdkbn(String pZrncdkbn) {
        zrncdkbn = pZrncdkbn;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiRn.ZRNSAKUSEIYMD)
    public String getZrnsakuseiymd() {
        return getPrimaryKey().getZrnsakuseiymd();
    }

    public void setZrnsakuseiymd(String pZrnsakuseiymd) {
        getPrimaryKey().setZrnsakuseiymd(pZrnsakuseiymd);
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiRn.ZRNRENRAKUYMD)
    public String getZrnrenrakuymd() {
        return getPrimaryKey().getZrnrenrakuymd();
    }

    public void setZrnrenrakuymd(String pZrnrenrakuymd) {
        getPrimaryKey().setZrnrenrakuymd(pZrnrenrakuymd);
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiRn.ZRNRENRAKUKAISUU)
    public String getZrnrenrakukaisuu() {
        return getPrimaryKey().getZrnrenrakukaisuu();
    }

    public void setZrnrenrakukaisuu(String pZrnrenrakukaisuu) {
        getPrimaryKey().setZrnrenrakukaisuu(pZrnrenrakukaisuu);
    }

    private String zrnknjyymdfrom;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKNJYYMDFROM)
    public String getZrnknjyymdfrom() {
        return zrnknjyymdfrom;
    }

    public void setZrnknjyymdfrom(String pZrnknjyymdfrom) {
        zrnknjyymdfrom = pZrnknjyymdfrom;
    }

    private String zrnknjyymdto;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKNJYYMDTO)
    public String getZrnknjyymdto() {
        return zrnknjyymdto;
    }

    public void setZrnknjyymdto(String pZrnknjyymdto) {
        zrnknjyymdto = pZrnknjyymdto;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiRn.ZRNBANKCD)
    public String getZrnbankcd() {
        return getPrimaryKey().getZrnbankcd();
    }

    public void setZrnbankcd(String pZrnbankcd) {
        getPrimaryKey().setZrnbankcd(pZrnbankcd);
    }

    private String zrnbanknmej;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNBANKNMEJ)
    public String getZrnbanknmej() {
        return zrnbanknmej;
    }

    public void setZrnbanknmej(String pZrnbanknmej) {
        zrnbanknmej = pZrnbanknmej;
    }

    private String zrnsitencdtori;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNSITENCDTORI)
    public String getZrnsitencdtori() {
        return zrnsitencdtori;
    }

    public void setZrnsitencdtori(String pZrnsitencdtori) {
        zrnsitencdtori = pZrnsitencdtori;
    }

    private String zrnsitennmejtori;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNSITENNMEJTORI)
    public String getZrnsitennmejtori() {
        return zrnsitennmejtori;
    }

    public void setZrnsitennmejtori(String pZrnsitennmejtori) {
        zrnsitennmejtori = pZrnsitennmejtori;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiRn.ZRNSHITENCD)
    public String getZrnshitencd() {
        return getPrimaryKey().getZrnshitencd();
    }

    public void setZrnshitencd(String pZrnshitencd) {
        getPrimaryKey().setZrnshitencd(pZrnshitencd);
    }

    private String zrnsitennmej;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNSITENNMEJ)
    public String getZrnsitennmej() {
        return zrnsitennmej;
    }

    public void setZrnsitennmej(String pZrnsitennmej) {
        zrnsitennmej = pZrnsitennmej;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiRn.ZRNYOKINKBN)
    public String getZrnyokinkbn() {
        return getPrimaryKey().getZrnyokinkbn();
    }

    public void setZrnyokinkbn(String pZrnyokinkbn) {
        getPrimaryKey().setZrnyokinkbn(pZrnyokinkbn);
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiRn.ZRNKOUZANO)
    public String getZrnkouzano() {
        return getPrimaryKey().getZrnkouzano();
    }

    public void setZrnkouzano(String pZrnkouzano) {
        getPrimaryKey().setZrnkouzano(pZrnkouzano);
    }

    private String zrnkznmej;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKZNMEJ)
    public String getZrnkznmej() {
        return zrnkznmej;
    }

    public void setZrnkznmej(String pZrnkznmej) {
        zrnkznmej = pZrnkznmej;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiRn.ZRNZNDKTUUKASYU)
    public String getZrnzndktuukasyu() {
        return getPrimaryKey().getZrnzndktuukasyu();
    }

    public void setZrnzndktuukasyu(String pZrnzndktuukasyu) {
        getPrimaryKey().setZrnzndktuukasyu(pZrnzndktuukasyu);
    }

    private String zrnzndkssketa;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNZNDKSSKETA)
    public String getZrnzndkssketa() {
        return zrnzndkssketa;
    }

    public void setZrnzndkssketa(String pZrnzndkssketa) {
        zrnzndkssketa = pZrnzndkssketa;
    }

    private String zrngktrhkmaezndk;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNGKTRHKMAEZNDK)
    public String getZrngktrhkmaezndk() {
        return zrngktrhkmaezndk;
    }

    public void setZrngktrhkmaezndk(String pZrngktrhkmaezndk) {
        zrngktrhkmaezndk = pZrngktrhkmaezndk;
    }

    private String zrnkasikosikbn;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKASIKOSIKBN)
    public String getZrnkasikosikbn() {
        return zrnkasikosikbn;
    }

    public void setZrnkasikosikbn(String pZrnkasikosikbn) {
        zrnkasikosikbn = pZrnkasikosikbn;
    }

    private String zrnyobiv86;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNYOBIV86)
    public String getZrnyobiv86() {
        return zrnyobiv86;
    }

    public void setZrnyobiv86(String pZrnyobiv86) {
        zrnyobiv86 = pZrnyobiv86;
    }

    private String zrndatakbn2;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDATAKBN2)
    public String getZrndatakbn2() {
        return zrndatakbn2;
    }

    public void setZrndatakbn2(String pZrndatakbn2) {
        zrndatakbn2 = pZrndatakbn2;
    }

    private String zrndtrecordkbn1;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDTRECORDKBN1)
    public String getZrndtrecordkbn1() {
        return zrndtrecordkbn1;
    }

    public void setZrndtrecordkbn1(String pZrndtrecordkbn1) {
        zrndtrecordkbn1 = pZrndtrecordkbn1;
    }

    private String zrndtrecordkousei;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDTRECORDKOUSEI)
    public String getZrndtrecordkousei() {
        return zrndtrecordkousei;
    }

    public void setZrndtrecordkousei(String pZrndtrecordkousei) {
        zrndtrecordkousei = pZrndtrecordkousei;
    }

    @Id
    @Column(name=GenZT_GknyknmeisaiRn.ZRNSYORINO1)
    public String getZrnsyorino1() {
        return getPrimaryKey().getZrnsyorino1();
    }

    public void setZrnsyorino1(String pZrnsyorino1) {
        getPrimaryKey().setZrnsyorino1(pZrnsyorino1);
    }

    private String zrnknjyymd;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKNJYYMD)
    public String getZrnknjyymd() {
        return zrnknjyymd;
    }

    public void setZrnknjyymd(String pZrnknjyymd) {
        zrnknjyymd = pZrnknjyymd;
    }

    private String zrnksnymd;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKSNYMD)
    public String getZrnksnymd() {
        return zrnksnymd;
    }

    public void setZrnksnymd(String pZrnksnymd) {
        zrnksnymd = pZrnksnymd;
    }

    private String zrniribaraikbn;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNIRIBARAIKBN)
    public String getZrniribaraikbn() {
        return zrniribaraikbn;
    }

    public void setZrniribaraikbn(String pZrniribaraikbn) {
        zrniribaraikbn = pZrniribaraikbn;
    }

    private String zrntrhkkbn;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNTRHKKBN)
    public String getZrntrhkkbn() {
        return zrntrhkkbn;
    }

    public void setZrntrhkkbn(String pZrntrhkkbn) {
        zrntrhkkbn = pZrntrhkkbn;
    }

    private String zrntrhktuukasyu;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNTRHKTUUKASYU)
    public String getZrntrhktuukasyu() {
        return zrntrhktuukasyu;
    }

    public void setZrntrhktuukasyu(String pZrntrhktuukasyu) {
        zrntrhktuukasyu = pZrntrhktuukasyu;
    }

    private String zrntrhkssketa;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNTRHKSSKETA)
    public String getZrntrhkssketa() {
        return zrntrhkssketa;
    }

    public void setZrntrhkssketa(String pZrntrhkssketa) {
        zrntrhkssketa = pZrntrhkssketa;
    }

    private String zrngktrhkgk;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNGKTRHKGK)
    public String getZrngktrhkgk() {
        return zrngktrhkgk;
    }

    public void setZrngktrhkgk(String pZrngktrhkgk) {
        zrngktrhkgk = pZrngktrhkgk;
    }

    private String zrnbanksyoukaino;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNBANKSYOUKAINO)
    public String getZrnbanksyoukaino() {
        return zrnbanksyoukaino;
    }

    public void setZrnbanksyoukaino(String pZrnbanksyoukaino) {
        zrnbanksyoukaino = pZrnbanksyoukaino;
    }

    private String zrntrhksyoukaino;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNTRHKSYOUKAINO)
    public String getZrntrhksyoukaino() {
        return zrntrhksyoukaino;
    }

    public void setZrntrhksyoukaino(String pZrntrhksyoukaino) {
        zrntrhksyoukaino = pZrntrhksyoukaino;
    }

    private String zrntekiyounaiyouej;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNTEKIYOUNAIYOUEJ)
    public String getZrntekiyounaiyouej() {
        return zrntekiyounaiyouej;
    }

    public void setZrntekiyounaiyouej(String pZrntekiyounaiyouej) {
        zrntekiyounaiyouej = pZrntekiyounaiyouej;
    }

    private String zrnyobiv103;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNYOBIV103)
    public String getZrnyobiv103() {
        return zrnyobiv103;
    }

    public void setZrnyobiv103(String pZrnyobiv103) {
        zrnyobiv103 = pZrnyobiv103;
    }

    private String zrndatakbn3;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDATAKBN3)
    public String getZrndatakbn3() {
        return zrndatakbn3;
    }

    public void setZrndatakbn3(String pZrndatakbn3) {
        zrndatakbn3 = pZrndatakbn3;
    }

    private String zrndtrecordkbn2;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDTRECORDKBN2)
    public String getZrndtrecordkbn2() {
        return zrndtrecordkbn2;
    }

    public void setZrndtrecordkbn2(String pZrndtrecordkbn2) {
        zrndtrecordkbn2 = pZrndtrecordkbn2;
    }

    private String zrndtkouseikbn;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDTKOUSEIKBN)
    public String getZrndtkouseikbn() {
        return zrndtkouseikbn;
    }

    public void setZrndtkouseikbn(String pZrndtkouseikbn) {
        zrndtkouseikbn = pZrndtkouseikbn;
    }

    private String zrntrkscd;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNTRKSCD)
    public String getZrntrkscd() {
        return zrntrkscd;
    }

    public void setZrntrkscd(String pZrntrkscd) {
        zrntrkscd = pZrntrkscd;
    }

    private String zrnsyorino2;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNSYORINO2)
    public String getZrnsyorino2() {
        return zrnsyorino2;
    }

    public void setZrnsyorino2(String pZrnsyorino2) {
        zrnsyorino2 = pZrnsyorino2;
    }

    private String zrnbanksyoukaino2;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNBANKSYOUKAINO2)
    public String getZrnbanksyoukaino2() {
        return zrnbanksyoukaino2;
    }

    public void setZrnbanksyoukaino2(String pZrnbanksyoukaino2) {
        zrnbanksyoukaino2 = pZrnbanksyoukaino2;
    }

    private String zrnsimukeymd;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNSIMUKEYMD)
    public String getZrnsimukeymd() {
        return zrnsimukeymd;
    }

    public void setZrnsimukeymd(String pZrnsimukeymd) {
        zrnsimukeymd = pZrnsimukeymd;
    }

    private String zrnsetujyuymd;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNSETUJYUYMD)
    public String getZrnsetujyuymd() {
        return zrnsetujyuymd;
    }

    public void setZrnsetujyuymd(String pZrnsetujyuymd) {
        zrnsetujyuymd = pZrnsetujyuymd;
    }

    private String zrnsoukinsyu;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNSOUKINSYU)
    public String getZrnsoukinsyu() {
        return zrnsoukinsyu;
    }

    public void setZrnsoukinsyu(String pZrnsoukinsyu) {
        zrnsoukinsyu = pZrnsoukinsyu;
    }

    private String zrnvalueymd;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNVALUEYMD)
    public String getZrnvalueymd() {
        return zrnvalueymd;
    }

    public void setZrnvalueymd(String pZrnvalueymd) {
        zrnvalueymd = pZrnvalueymd;
    }

    private String zrnskntuukasyu;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNSKNTUUKASYU)
    public String getZrnskntuukasyu() {
        return zrnskntuukasyu;
    }

    public void setZrnskntuukasyu(String pZrnskntuukasyu) {
        zrnskntuukasyu = pZrnskntuukasyu;
    }

    private String zrnsknssketa;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNSKNSSKETA)
    public String getZrnsknssketa() {
        return zrnsknssketa;
    }

    public void setZrnsknssketa(String pZrnsknssketa) {
        zrnsknssketa = pZrnsknssketa;
    }

    private String zrngksoukingk;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNGKSOUKINGK)
    public String getZrngksoukingk() {
        return zrngksoukingk;
    }

    public void setZrngksoukingk(String pZrngksoukingk) {
        zrngksoukingk = pZrngksoukingk;
    }

    private String zrnirninnm;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNIRNINNM)
    public String getZrnirninnm() {
        return zrnirninnm;
    }

    public void setZrnirninnm(String pZrnirninnm) {
        zrnirninnm = pZrnirninnm;
    }

    private String zrnyobiv40;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNYOBIV40)
    public String getZrnyobiv40() {
        return zrnyobiv40;
    }

    public void setZrnyobiv40(String pZrnyobiv40) {
        zrnyobiv40 = pZrnyobiv40;
    }

    private String zrndatakbn4;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDATAKBN4)
    public String getZrndatakbn4() {
        return zrndatakbn4;
    }

    public void setZrndatakbn4(String pZrndatakbn4) {
        zrndatakbn4 = pZrndatakbn4;
    }

    private String zrndtrecordkbn3;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDTRECORDKBN3)
    public String getZrndtrecordkbn3() {
        return zrndtrecordkbn3;
    }

    public void setZrndtrecordkbn3(String pZrndtrecordkbn3) {
        zrndtrecordkbn3 = pZrndtrecordkbn3;
    }

    private String zrndourecordsuu1;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDOURECORDSUU1)
    public String getZrndourecordsuu1() {
        return zrndourecordsuu1;
    }

    public void setZrndourecordsuu1(String pZrndourecordsuu1) {
        zrndourecordsuu1 = pZrndourecordsuu1;
    }

    private String zrndourecordno1;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDOURECORDNO1)
    public String getZrndourecordno1() {
        return zrndourecordno1;
    }

    public void setZrndourecordno1(String pZrndourecordno1) {
        zrndourecordno1 = pZrndourecordno1;
    }

    private String zrnkahensuu1;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKAHENSUU1)
    public String getZrnkahensuu1() {
        return zrnkahensuu1;
    }

    public void setZrnkahensuu1(String pZrnkahensuu1) {
        zrnkahensuu1 = pZrnkahensuu1;
    }

    private String zrnkahenketa1;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKAHENKETA1)
    public String getZrnkahenketa1() {
        return zrnkahenketa1;
    }

    public void setZrnkahenketa1(String pZrnkahenketa1) {
        zrnkahenketa1 = pZrnkahenketa1;
    }

    private String zrnkahen1;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKAHEN1)
    public String getZrnkahen1() {
        return zrnkahen1;
    }

    public void setZrnkahen1(String pZrnkahen1) {
        zrnkahen1 = pZrnkahen1;
    }

    private String zrndatakbn5;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDATAKBN5)
    public String getZrndatakbn5() {
        return zrndatakbn5;
    }

    public void setZrndatakbn5(String pZrndatakbn5) {
        zrndatakbn5 = pZrndatakbn5;
    }

    private String zrndtrecordkbn4;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDTRECORDKBN4)
    public String getZrndtrecordkbn4() {
        return zrndtrecordkbn4;
    }

    public void setZrndtrecordkbn4(String pZrndtrecordkbn4) {
        zrndtrecordkbn4 = pZrndtrecordkbn4;
    }

    private String zrndourecordsuu2;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDOURECORDSUU2)
    public String getZrndourecordsuu2() {
        return zrndourecordsuu2;
    }

    public void setZrndourecordsuu2(String pZrndourecordsuu2) {
        zrndourecordsuu2 = pZrndourecordsuu2;
    }

    private String zrndourecordno2;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDOURECORDNO2)
    public String getZrndourecordno2() {
        return zrndourecordno2;
    }

    public void setZrndourecordno2(String pZrndourecordno2) {
        zrndourecordno2 = pZrndourecordno2;
    }

    private String zrnkahensuu2;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKAHENSUU2)
    public String getZrnkahensuu2() {
        return zrnkahensuu2;
    }

    public void setZrnkahensuu2(String pZrnkahensuu2) {
        zrnkahensuu2 = pZrnkahensuu2;
    }

    private String zrnkahenketa2;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKAHENKETA2)
    public String getZrnkahenketa2() {
        return zrnkahenketa2;
    }

    public void setZrnkahenketa2(String pZrnkahenketa2) {
        zrnkahenketa2 = pZrnkahenketa2;
    }

    private String zrnkahen2;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKAHEN2)
    public String getZrnkahen2() {
        return zrnkahen2;
    }

    public void setZrnkahen2(String pZrnkahen2) {
        zrnkahen2 = pZrnkahen2;
    }

    private String zrndatakbn6;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDATAKBN6)
    public String getZrndatakbn6() {
        return zrndatakbn6;
    }

    public void setZrndatakbn6(String pZrndatakbn6) {
        zrndatakbn6 = pZrndatakbn6;
    }

    private String zrndtrecordkbn5;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDTRECORDKBN5)
    public String getZrndtrecordkbn5() {
        return zrndtrecordkbn5;
    }

    public void setZrndtrecordkbn5(String pZrndtrecordkbn5) {
        zrndtrecordkbn5 = pZrndtrecordkbn5;
    }

    private String zrndourecordsuu3;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDOURECORDSUU3)
    public String getZrndourecordsuu3() {
        return zrndourecordsuu3;
    }

    public void setZrndourecordsuu3(String pZrndourecordsuu3) {
        zrndourecordsuu3 = pZrndourecordsuu3;
    }

    private String zrndourecordno3;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNDOURECORDNO3)
    public String getZrndourecordno3() {
        return zrndourecordno3;
    }

    public void setZrndourecordno3(String pZrndourecordno3) {
        zrndourecordno3 = pZrndourecordno3;
    }

    private String zrnkahensuu3;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKAHENSUU3)
    public String getZrnkahensuu3() {
        return zrnkahensuu3;
    }

    public void setZrnkahensuu3(String pZrnkahensuu3) {
        zrnkahensuu3 = pZrnkahensuu3;
    }

    private String zrnkahenketa3;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKAHENKETA3)
    public String getZrnkahenketa3() {
        return zrnkahenketa3;
    }

    public void setZrnkahenketa3(String pZrnkahenketa3) {
        zrnkahenketa3 = pZrnkahenketa3;
    }

    private String zrnkahen3;

    @Column(name=GenZT_GknyknmeisaiRn.ZRNKAHEN3)
    public String getZrnkahen3() {
        return zrnkahen3;
    }

    public void setZrnkahen3(String pZrnkahen3) {
        zrnkahen3 = pZrnkahen3;
    }
}