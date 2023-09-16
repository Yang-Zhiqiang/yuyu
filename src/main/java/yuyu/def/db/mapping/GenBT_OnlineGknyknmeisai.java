package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.BT_OnlineGknyknmeisai;
import yuyu.def.db.id.PKBT_OnlineGknyknmeisai;
import yuyu.def.db.meta.GenQBT_OnlineGknyknmeisai;
import yuyu.def.db.meta.QBT_OnlineGknyknmeisai;

/**
 * オンライン外貨入出金明細テーブル テーブルのマッピング情報クラスで、 {@link BT_OnlineGknyknmeisai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_OnlineGknyknmeisai}</td><td colspan="3">オンライン外貨入出金明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHrkmdatakbn1 hrkmdatakbn1}</td><td>（振込用）データ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsyubetucd hrkmsyubetucd}</td><td>（振込用）種別コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmcdkbn hrkmcdkbn}</td><td>（振込用）コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsakuseiymd hrkmsakuseiymd}</td><td>（振込用）作成日</td><td align="center">{@link PKBT_OnlineGknyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmrenrakuymd hrkmrenrakuymd}</td><td>（振込用）連絡日</td><td align="center">{@link PKBT_OnlineGknyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmrenrakukaisuu hrkmrenrakukaisuu}</td><td>（振込用）連絡回数</td><td align="center">{@link PKBT_OnlineGknyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmknjyymdfrom hrkmknjyymdfrom}</td><td>（振込用）勘定日（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmknjyymdto hrkmknjyymdto}</td><td>（振込用）勘定日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmbankcd hrkmbankcd}</td><td>（振込用）銀行番号</td><td align="center">{@link PKBT_OnlineGknyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmbanknmej hrkmbanknmej}</td><td>（振込用）銀行名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsitencdtori hrkmsitencdtori}</td><td>（振込用）支店コード（取次）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsitennmejtori hrkmsitennmejtori}</td><td>（振込用）支店名（英字）（取次）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmshitencd hrkmshitencd}</td><td>（振込用）支店番号</td><td align="center">{@link PKBT_OnlineGknyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsitennmej hrkmsitennmej}</td><td>（振込用）支店名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmyokinkbn hrkmyokinkbn}</td><td>（振込用）預金種目区分</td><td align="center">{@link PKBT_OnlineGknyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkouzano hrkmkouzano}</td><td>（振込用）口座番号</td><td align="center">{@link PKBT_OnlineGknyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkznmej hrkmkznmej}</td><td>（振込用）口座名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmzndktuukasyu hrkmzndktuukasyu}</td><td>（振込用）残高通貨種類</td><td align="center">{@link PKBT_OnlineGknyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmzndkssketa hrkmzndkssketa}</td><td>（振込用）残高小数桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmgktrhkmaezndk hrkmgktrhkmaezndk}</td><td>（振込用）外貨取引前残高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkasikosikbn hrkmkasikosikbn}</td><td>（振込用）貸越区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmyobiv86 hrkmyobiv86}</td><td>（振込用）予備項目Ｖ８６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdatakbn2 hrkmdatakbn2}</td><td>（振込用）データ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdtrecordkbn1 hrkmdtrecordkbn1}</td><td>（振込用）データレコード区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdtrecordkousei hrkmdtrecordkousei}</td><td>（振込用）データレコード構成</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsyorino1 hrkmsyorino1}</td><td>（振込用）処理通番１</td><td align="center">{@link PKBT_OnlineGknyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmknjyymd hrkmknjyymd}</td><td>（振込用）勘定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmksnymd hrkmksnymd}</td><td>（振込用）起算日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmiribaraikbn hrkmiribaraikbn}</td><td>（振込用）入払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtrhkkbn hrkmtrhkkbn}</td><td>（振込用）取引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtrhktuukasyu hrkmtrhktuukasyu}</td><td>（振込用）取引通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtrhkssketa hrkmtrhkssketa}</td><td>（振込用）取引小数桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmgktrhkgk hrkmgktrhkgk}</td><td>（振込用）外貨取引金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmbanksyoukaino hrkmbanksyoukaino}</td><td>（振込用）銀行照会番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtrhksyoukaino hrkmtrhksyoukaino}</td><td>（振込用）取引先照会番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtekiyounaiyouej hrkmtekiyounaiyouej}</td><td>（振込用）摘要内容（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmyobiv103 hrkmyobiv103}</td><td>（振込用）予備項目Ｖ１０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdatakbn3 hrkmdatakbn3}</td><td>（振込用）データ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdtrecordkbn2 hrkmdtrecordkbn2}</td><td>（振込用）データレコード区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdtkouseikbn hrkmdtkouseikbn}</td><td>（振込用）データ構成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtrkscd hrkmtrkscd}</td><td>（振込用）取消コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsyorino2 hrkmsyorino2}</td><td>（振込用）処理通番２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmbanksyoukaino2 hrkmbanksyoukaino2}</td><td>（振込用）銀行照会番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsimukeymd hrkmsimukeymd}</td><td>（振込用）仕向日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsetujyuymd hrkmsetujyuymd}</td><td>（振込用）接受日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsoukinsyu hrkmsoukinsyu}</td><td>（振込用）送金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmvalueymd hrkmvalueymd}</td><td>（振込用）バリュー日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmskntuukasyu hrkmskntuukasyu}</td><td>（振込用）送金通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsknssketa hrkmsknssketa}</td><td>（振込用）送金小数桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmgksoukingk hrkmgksoukingk}</td><td>（振込用）外貨送金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmirninnmej hrkmirninnmej}</td><td>（振込用）依頼人名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmyobiv40 hrkmyobiv40}</td><td>（振込用）予備項目Ｖ４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdatakbn4 hrkmdatakbn4}</td><td>（振込用）データ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdtrecordkbn3 hrkmdtrecordkbn3}</td><td>（振込用）データレコード区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdourecordsuu1 hrkmdourecordsuu1}</td><td>（振込用）同種レコード数１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdourecordno1 hrkmdourecordno1}</td><td>（振込用）同種レコード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkahensuu1 hrkmkahensuu1}</td><td>（振込用）可変項目数１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkahenketa1 hrkmkahenketa1}</td><td>（振込用）可変項目桁数１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkahen1 hrkmkahen1}</td><td>（振込用）可変項目１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdatakbn5 hrkmdatakbn5}</td><td>（振込用）データ区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdtrecordkbn4 hrkmdtrecordkbn4}</td><td>（振込用）データレコード区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdourecordsuu2 hrkmdourecordsuu2}</td><td>（振込用）同種レコード数２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdourecordno2 hrkmdourecordno2}</td><td>（振込用）同種レコード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkahensuu2 hrkmkahensuu2}</td><td>（振込用）可変項目数２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkahenketa2 hrkmkahenketa2}</td><td>（振込用）可変項目桁数２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkahen2 hrkmkahen2}</td><td>（振込用）可変項目２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdatakbn6 hrkmdatakbn6}</td><td>（振込用）データ区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdtrecordkbn5 hrkmdtrecordkbn5}</td><td>（振込用）データレコード区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdourecordsuu3 hrkmdourecordsuu3}</td><td>（振込用）同種レコード数３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdourecordno3 hrkmdourecordno3}</td><td>（振込用）同種レコード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkahensuu3 hrkmkahensuu3}</td><td>（振込用）可変項目数３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkahenketa3 hrkmkahenketa3}</td><td>（振込用）可変項目桁数３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkahen3 hrkmkahen3}</td><td>（振込用）可変項目３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmrensakuseiymd hrkmrensakuseiymd}</td><td>（振込用）連動元作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_OnlineGknyknmeisai
 * @see     PKBT_OnlineGknyknmeisai
 * @see     QBT_OnlineGknyknmeisai
 * @see     GenQBT_OnlineGknyknmeisai
 */
@MappedSuperclass
@Table(name=GenBT_OnlineGknyknmeisai.TABLE_NAME)
@IdClass(value=PKBT_OnlineGknyknmeisai.class)
public abstract class GenBT_OnlineGknyknmeisai extends AbstractExDBEntity<BT_OnlineGknyknmeisai, PKBT_OnlineGknyknmeisai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_OnlineGknyknmeisai";
    public static final String HRKMDATAKBN1             = "hrkmdatakbn1";
    public static final String HRKMSYUBETUCD            = "hrkmsyubetucd";
    public static final String HRKMCDKBN                = "hrkmcdkbn";
    public static final String HRKMSAKUSEIYMD           = "hrkmsakuseiymd";
    public static final String HRKMRENRAKUYMD           = "hrkmrenrakuymd";
    public static final String HRKMRENRAKUKAISUU        = "hrkmrenrakukaisuu";
    public static final String HRKMKNJYYMDFROM          = "hrkmknjyymdfrom";
    public static final String HRKMKNJYYMDTO            = "hrkmknjyymdto";
    public static final String HRKMBANKCD               = "hrkmbankcd";
    public static final String HRKMBANKNMEJ             = "hrkmbanknmej";
    public static final String HRKMSITENCDTORI          = "hrkmsitencdtori";
    public static final String HRKMSITENNMEJTORI        = "hrkmsitennmejtori";
    public static final String HRKMSHITENCD             = "hrkmshitencd";
    public static final String HRKMSITENNMEJ            = "hrkmsitennmej";
    public static final String HRKMYOKINKBN             = "hrkmyokinkbn";
    public static final String HRKMKOUZANO              = "hrkmkouzano";
    public static final String HRKMKZNMEJ               = "hrkmkznmej";
    public static final String HRKMZNDKTUUKASYU         = "hrkmzndktuukasyu";
    public static final String HRKMZNDKSSKETA           = "hrkmzndkssketa";
    public static final String HRKMGKTRHKMAEZNDK        = "hrkmgktrhkmaezndk";
    public static final String HRKMKASIKOSIKBN          = "hrkmkasikosikbn";
    public static final String HRKMYOBIV86              = "hrkmyobiv86";
    public static final String HRKMDATAKBN2             = "hrkmdatakbn2";
    public static final String HRKMDTRECORDKBN1         = "hrkmdtrecordkbn1";
    public static final String HRKMDTRECORDKOUSEI       = "hrkmdtrecordkousei";
    public static final String HRKMSYORINO1             = "hrkmsyorino1";
    public static final String HRKMKNJYYMD              = "hrkmknjyymd";
    public static final String HRKMKSNYMD               = "hrkmksnymd";
    public static final String HRKMIRIBARAIKBN          = "hrkmiribaraikbn";
    public static final String HRKMTRHKKBN              = "hrkmtrhkkbn";
    public static final String HRKMTRHKTUUKASYU         = "hrkmtrhktuukasyu";
    public static final String HRKMTRHKSSKETA           = "hrkmtrhkssketa";
    public static final String HRKMGKTRHKGK             = "hrkmgktrhkgk";
    public static final String HRKMBANKSYOUKAINO        = "hrkmbanksyoukaino";
    public static final String HRKMTRHKSYOUKAINO        = "hrkmtrhksyoukaino";
    public static final String HRKMTEKIYOUNAIYOUEJ      = "hrkmtekiyounaiyouej";
    public static final String HRKMYOBIV103             = "hrkmyobiv103";
    public static final String HRKMDATAKBN3             = "hrkmdatakbn3";
    public static final String HRKMDTRECORDKBN2         = "hrkmdtrecordkbn2";
    public static final String HRKMDTKOUSEIKBN          = "hrkmdtkouseikbn";
    public static final String HRKMTRKSCD               = "hrkmtrkscd";
    public static final String HRKMSYORINO2             = "hrkmsyorino2";
    public static final String HRKMBANKSYOUKAINO2       = "hrkmbanksyoukaino2";
    public static final String HRKMSIMUKEYMD            = "hrkmsimukeymd";
    public static final String HRKMSETUJYUYMD           = "hrkmsetujyuymd";
    public static final String HRKMSOUKINSYU            = "hrkmsoukinsyu";
    public static final String HRKMVALUEYMD             = "hrkmvalueymd";
    public static final String HRKMSKNTUUKASYU          = "hrkmskntuukasyu";
    public static final String HRKMSKNSSKETA            = "hrkmsknssketa";
    public static final String HRKMGKSOUKINGK           = "hrkmgksoukingk";
    public static final String HRKMIRNINNMEJ            = "hrkmirninnmej";
    public static final String HRKMYOBIV40              = "hrkmyobiv40";
    public static final String HRKMDATAKBN4             = "hrkmdatakbn4";
    public static final String HRKMDTRECORDKBN3         = "hrkmdtrecordkbn3";
    public static final String HRKMDOURECORDSUU1        = "hrkmdourecordsuu1";
    public static final String HRKMDOURECORDNO1         = "hrkmdourecordno1";
    public static final String HRKMKAHENSUU1            = "hrkmkahensuu1";
    public static final String HRKMKAHENKETA1           = "hrkmkahenketa1";
    public static final String HRKMKAHEN1               = "hrkmkahen1";
    public static final String HRKMDATAKBN5             = "hrkmdatakbn5";
    public static final String HRKMDTRECORDKBN4         = "hrkmdtrecordkbn4";
    public static final String HRKMDOURECORDSUU2        = "hrkmdourecordsuu2";
    public static final String HRKMDOURECORDNO2         = "hrkmdourecordno2";
    public static final String HRKMKAHENSUU2            = "hrkmkahensuu2";
    public static final String HRKMKAHENKETA2           = "hrkmkahenketa2";
    public static final String HRKMKAHEN2               = "hrkmkahen2";
    public static final String HRKMDATAKBN6             = "hrkmdatakbn6";
    public static final String HRKMDTRECORDKBN5         = "hrkmdtrecordkbn5";
    public static final String HRKMDOURECORDSUU3        = "hrkmdourecordsuu3";
    public static final String HRKMDOURECORDNO3         = "hrkmdourecordno3";
    public static final String HRKMKAHENSUU3            = "hrkmkahensuu3";
    public static final String HRKMKAHENKETA3           = "hrkmkahenketa3";
    public static final String HRKMKAHEN3               = "hrkmkahen3";
    public static final String HRKMRENSAKUSEIYMD        = "hrkmrensakuseiymd";

    private final PKBT_OnlineGknyknmeisai primaryKey;

    public GenBT_OnlineGknyknmeisai() {
        primaryKey = new PKBT_OnlineGknyknmeisai();
    }

    public GenBT_OnlineGknyknmeisai(
        String pHrkmsakuseiymd,
        String pHrkmrenrakuymd,
        String pHrkmrenrakukaisuu,
        String pHrkmbankcd,
        String pHrkmshitencd,
        String pHrkmyokinkbn,
        String pHrkmkouzano,
        String pHrkmzndktuukasyu,
        String pHrkmsyorino1
    ) {
        primaryKey = new PKBT_OnlineGknyknmeisai(
            pHrkmsakuseiymd,
            pHrkmrenrakuymd,
            pHrkmrenrakukaisuu,
            pHrkmbankcd,
            pHrkmshitencd,
            pHrkmyokinkbn,
            pHrkmkouzano,
            pHrkmzndktuukasyu,
            pHrkmsyorino1
        );
    }

    @Transient
    @Override
    public PKBT_OnlineGknyknmeisai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_OnlineGknyknmeisai> getMetaClass() {
        return QBT_OnlineGknyknmeisai.class;
    }

    private String hrkmdatakbn1;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDATAKBN1)
    public String getHrkmdatakbn1() {
        return hrkmdatakbn1;
    }

    public void setHrkmdatakbn1(String pHrkmdatakbn1) {
        hrkmdatakbn1 = pHrkmdatakbn1;
    }

    private String hrkmsyubetucd;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSYUBETUCD)
    public String getHrkmsyubetucd() {
        return hrkmsyubetucd;
    }

    public void setHrkmsyubetucd(String pHrkmsyubetucd) {
        hrkmsyubetucd = pHrkmsyubetucd;
    }

    private String hrkmcdkbn;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMCDKBN)
    public String getHrkmcdkbn() {
        return hrkmcdkbn;
    }

    public void setHrkmcdkbn(String pHrkmcdkbn) {
        hrkmcdkbn = pHrkmcdkbn;
    }

    @Id
    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSAKUSEIYMD)
    public String getHrkmsakuseiymd() {
        return getPrimaryKey().getHrkmsakuseiymd();
    }

    public void setHrkmsakuseiymd(String pHrkmsakuseiymd) {
        getPrimaryKey().setHrkmsakuseiymd(pHrkmsakuseiymd);
    }

    @Id
    @Column(name=GenBT_OnlineGknyknmeisai.HRKMRENRAKUYMD)
    public String getHrkmrenrakuymd() {
        return getPrimaryKey().getHrkmrenrakuymd();
    }

    public void setHrkmrenrakuymd(String pHrkmrenrakuymd) {
        getPrimaryKey().setHrkmrenrakuymd(pHrkmrenrakuymd);
    }

    @Id
    @Column(name=GenBT_OnlineGknyknmeisai.HRKMRENRAKUKAISUU)
    public String getHrkmrenrakukaisuu() {
        return getPrimaryKey().getHrkmrenrakukaisuu();
    }

    public void setHrkmrenrakukaisuu(String pHrkmrenrakukaisuu) {
        getPrimaryKey().setHrkmrenrakukaisuu(pHrkmrenrakukaisuu);
    }

    private String hrkmknjyymdfrom;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKNJYYMDFROM)
    public String getHrkmknjyymdfrom() {
        return hrkmknjyymdfrom;
    }

    public void setHrkmknjyymdfrom(String pHrkmknjyymdfrom) {
        hrkmknjyymdfrom = pHrkmknjyymdfrom;
    }

    private String hrkmknjyymdto;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKNJYYMDTO)
    public String getHrkmknjyymdto() {
        return hrkmknjyymdto;
    }

    public void setHrkmknjyymdto(String pHrkmknjyymdto) {
        hrkmknjyymdto = pHrkmknjyymdto;
    }

    @Id
    @Column(name=GenBT_OnlineGknyknmeisai.HRKMBANKCD)
    public String getHrkmbankcd() {
        return getPrimaryKey().getHrkmbankcd();
    }

    public void setHrkmbankcd(String pHrkmbankcd) {
        getPrimaryKey().setHrkmbankcd(pHrkmbankcd);
    }

    private String hrkmbanknmej;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMBANKNMEJ)
    public String getHrkmbanknmej() {
        return hrkmbanknmej;
    }

    public void setHrkmbanknmej(String pHrkmbanknmej) {
        hrkmbanknmej = pHrkmbanknmej;
    }

    private String hrkmsitencdtori;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSITENCDTORI)
    public String getHrkmsitencdtori() {
        return hrkmsitencdtori;
    }

    public void setHrkmsitencdtori(String pHrkmsitencdtori) {
        hrkmsitencdtori = pHrkmsitencdtori;
    }

    private String hrkmsitennmejtori;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSITENNMEJTORI)
    public String getHrkmsitennmejtori() {
        return hrkmsitennmejtori;
    }

    public void setHrkmsitennmejtori(String pHrkmsitennmejtori) {
        hrkmsitennmejtori = pHrkmsitennmejtori;
    }

    @Id
    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSHITENCD)
    public String getHrkmshitencd() {
        return getPrimaryKey().getHrkmshitencd();
    }

    public void setHrkmshitencd(String pHrkmshitencd) {
        getPrimaryKey().setHrkmshitencd(pHrkmshitencd);
    }

    private String hrkmsitennmej;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSITENNMEJ)
    public String getHrkmsitennmej() {
        return hrkmsitennmej;
    }

    public void setHrkmsitennmej(String pHrkmsitennmej) {
        hrkmsitennmej = pHrkmsitennmej;
    }

    @Id
    @Column(name=GenBT_OnlineGknyknmeisai.HRKMYOKINKBN)
    public String getHrkmyokinkbn() {
        return getPrimaryKey().getHrkmyokinkbn();
    }

    public void setHrkmyokinkbn(String pHrkmyokinkbn) {
        getPrimaryKey().setHrkmyokinkbn(pHrkmyokinkbn);
    }

    @Id
    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKOUZANO)
    public String getHrkmkouzano() {
        return getPrimaryKey().getHrkmkouzano();
    }

    public void setHrkmkouzano(String pHrkmkouzano) {
        getPrimaryKey().setHrkmkouzano(pHrkmkouzano);
    }

    private String hrkmkznmej;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKZNMEJ)
    public String getHrkmkznmej() {
        return hrkmkznmej;
    }

    public void setHrkmkznmej(String pHrkmkznmej) {
        hrkmkznmej = pHrkmkznmej;
    }

    @Id
    @Column(name=GenBT_OnlineGknyknmeisai.HRKMZNDKTUUKASYU)
    public String getHrkmzndktuukasyu() {
        return getPrimaryKey().getHrkmzndktuukasyu();
    }

    public void setHrkmzndktuukasyu(String pHrkmzndktuukasyu) {
        getPrimaryKey().setHrkmzndktuukasyu(pHrkmzndktuukasyu);
    }

    private String hrkmzndkssketa;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMZNDKSSKETA)
    public String getHrkmzndkssketa() {
        return hrkmzndkssketa;
    }

    public void setHrkmzndkssketa(String pHrkmzndkssketa) {
        hrkmzndkssketa = pHrkmzndkssketa;
    }

    private String hrkmgktrhkmaezndk;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMGKTRHKMAEZNDK)
    public String getHrkmgktrhkmaezndk() {
        return hrkmgktrhkmaezndk;
    }

    public void setHrkmgktrhkmaezndk(String pHrkmgktrhkmaezndk) {
        hrkmgktrhkmaezndk = pHrkmgktrhkmaezndk;
    }

    private String hrkmkasikosikbn;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKASIKOSIKBN)
    public String getHrkmkasikosikbn() {
        return hrkmkasikosikbn;
    }

    public void setHrkmkasikosikbn(String pHrkmkasikosikbn) {
        hrkmkasikosikbn = pHrkmkasikosikbn;
    }

    private String hrkmyobiv86;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMYOBIV86)
    public String getHrkmyobiv86() {
        return hrkmyobiv86;
    }

    public void setHrkmyobiv86(String pHrkmyobiv86) {
        hrkmyobiv86 = pHrkmyobiv86;
    }

    private String hrkmdatakbn2;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDATAKBN2)
    public String getHrkmdatakbn2() {
        return hrkmdatakbn2;
    }

    public void setHrkmdatakbn2(String pHrkmdatakbn2) {
        hrkmdatakbn2 = pHrkmdatakbn2;
    }

    private String hrkmdtrecordkbn1;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDTRECORDKBN1)
    public String getHrkmdtrecordkbn1() {
        return hrkmdtrecordkbn1;
    }

    public void setHrkmdtrecordkbn1(String pHrkmdtrecordkbn1) {
        hrkmdtrecordkbn1 = pHrkmdtrecordkbn1;
    }

    private String hrkmdtrecordkousei;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDTRECORDKOUSEI)
    public String getHrkmdtrecordkousei() {
        return hrkmdtrecordkousei;
    }

    public void setHrkmdtrecordkousei(String pHrkmdtrecordkousei) {
        hrkmdtrecordkousei = pHrkmdtrecordkousei;
    }

    @Id
    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSYORINO1)
    public String getHrkmsyorino1() {
        return getPrimaryKey().getHrkmsyorino1();
    }

    public void setHrkmsyorino1(String pHrkmsyorino1) {
        getPrimaryKey().setHrkmsyorino1(pHrkmsyorino1);
    }

    private String hrkmknjyymd;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKNJYYMD)
    public String getHrkmknjyymd() {
        return hrkmknjyymd;
    }

    public void setHrkmknjyymd(String pHrkmknjyymd) {
        hrkmknjyymd = pHrkmknjyymd;
    }

    private String hrkmksnymd;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKSNYMD)
    public String getHrkmksnymd() {
        return hrkmksnymd;
    }

    public void setHrkmksnymd(String pHrkmksnymd) {
        hrkmksnymd = pHrkmksnymd;
    }

    private String hrkmiribaraikbn;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMIRIBARAIKBN)
    public String getHrkmiribaraikbn() {
        return hrkmiribaraikbn;
    }

    public void setHrkmiribaraikbn(String pHrkmiribaraikbn) {
        hrkmiribaraikbn = pHrkmiribaraikbn;
    }

    private String hrkmtrhkkbn;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMTRHKKBN)
    public String getHrkmtrhkkbn() {
        return hrkmtrhkkbn;
    }

    public void setHrkmtrhkkbn(String pHrkmtrhkkbn) {
        hrkmtrhkkbn = pHrkmtrhkkbn;
    }

    private String hrkmtrhktuukasyu;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMTRHKTUUKASYU)
    public String getHrkmtrhktuukasyu() {
        return hrkmtrhktuukasyu;
    }

    public void setHrkmtrhktuukasyu(String pHrkmtrhktuukasyu) {
        hrkmtrhktuukasyu = pHrkmtrhktuukasyu;
    }

    private String hrkmtrhkssketa;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMTRHKSSKETA)
    public String getHrkmtrhkssketa() {
        return hrkmtrhkssketa;
    }

    public void setHrkmtrhkssketa(String pHrkmtrhkssketa) {
        hrkmtrhkssketa = pHrkmtrhkssketa;
    }

    private String hrkmgktrhkgk;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMGKTRHKGK)
    public String getHrkmgktrhkgk() {
        return hrkmgktrhkgk;
    }

    public void setHrkmgktrhkgk(String pHrkmgktrhkgk) {
        hrkmgktrhkgk = pHrkmgktrhkgk;
    }

    private String hrkmbanksyoukaino;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMBANKSYOUKAINO)
    public String getHrkmbanksyoukaino() {
        return hrkmbanksyoukaino;
    }

    public void setHrkmbanksyoukaino(String pHrkmbanksyoukaino) {
        hrkmbanksyoukaino = pHrkmbanksyoukaino;
    }

    private String hrkmtrhksyoukaino;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMTRHKSYOUKAINO)
    public String getHrkmtrhksyoukaino() {
        return hrkmtrhksyoukaino;
    }

    public void setHrkmtrhksyoukaino(String pHrkmtrhksyoukaino) {
        hrkmtrhksyoukaino = pHrkmtrhksyoukaino;
    }

    private String hrkmtekiyounaiyouej;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMTEKIYOUNAIYOUEJ)
    public String getHrkmtekiyounaiyouej() {
        return hrkmtekiyounaiyouej;
    }

    public void setHrkmtekiyounaiyouej(String pHrkmtekiyounaiyouej) {
        hrkmtekiyounaiyouej = pHrkmtekiyounaiyouej;
    }

    private String hrkmyobiv103;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMYOBIV103)
    public String getHrkmyobiv103() {
        return hrkmyobiv103;
    }

    public void setHrkmyobiv103(String pHrkmyobiv103) {
        hrkmyobiv103 = pHrkmyobiv103;
    }

    private String hrkmdatakbn3;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDATAKBN3)
    public String getHrkmdatakbn3() {
        return hrkmdatakbn3;
    }

    public void setHrkmdatakbn3(String pHrkmdatakbn3) {
        hrkmdatakbn3 = pHrkmdatakbn3;
    }

    private String hrkmdtrecordkbn2;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDTRECORDKBN2)
    public String getHrkmdtrecordkbn2() {
        return hrkmdtrecordkbn2;
    }

    public void setHrkmdtrecordkbn2(String pHrkmdtrecordkbn2) {
        hrkmdtrecordkbn2 = pHrkmdtrecordkbn2;
    }

    private String hrkmdtkouseikbn;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDTKOUSEIKBN)
    public String getHrkmdtkouseikbn() {
        return hrkmdtkouseikbn;
    }

    public void setHrkmdtkouseikbn(String pHrkmdtkouseikbn) {
        hrkmdtkouseikbn = pHrkmdtkouseikbn;
    }

    private String hrkmtrkscd;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMTRKSCD)
    public String getHrkmtrkscd() {
        return hrkmtrkscd;
    }

    public void setHrkmtrkscd(String pHrkmtrkscd) {
        hrkmtrkscd = pHrkmtrkscd;
    }

    private String hrkmsyorino2;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSYORINO2)
    public String getHrkmsyorino2() {
        return hrkmsyorino2;
    }

    public void setHrkmsyorino2(String pHrkmsyorino2) {
        hrkmsyorino2 = pHrkmsyorino2;
    }

    private String hrkmbanksyoukaino2;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMBANKSYOUKAINO2)
    public String getHrkmbanksyoukaino2() {
        return hrkmbanksyoukaino2;
    }

    public void setHrkmbanksyoukaino2(String pHrkmbanksyoukaino2) {
        hrkmbanksyoukaino2 = pHrkmbanksyoukaino2;
    }

    private String hrkmsimukeymd;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSIMUKEYMD)
    public String getHrkmsimukeymd() {
        return hrkmsimukeymd;
    }

    public void setHrkmsimukeymd(String pHrkmsimukeymd) {
        hrkmsimukeymd = pHrkmsimukeymd;
    }

    private String hrkmsetujyuymd;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSETUJYUYMD)
    public String getHrkmsetujyuymd() {
        return hrkmsetujyuymd;
    }

    public void setHrkmsetujyuymd(String pHrkmsetujyuymd) {
        hrkmsetujyuymd = pHrkmsetujyuymd;
    }

    private String hrkmsoukinsyu;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSOUKINSYU)
    public String getHrkmsoukinsyu() {
        return hrkmsoukinsyu;
    }

    public void setHrkmsoukinsyu(String pHrkmsoukinsyu) {
        hrkmsoukinsyu = pHrkmsoukinsyu;
    }

    private String hrkmvalueymd;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMVALUEYMD)
    public String getHrkmvalueymd() {
        return hrkmvalueymd;
    }

    public void setHrkmvalueymd(String pHrkmvalueymd) {
        hrkmvalueymd = pHrkmvalueymd;
    }

    private String hrkmskntuukasyu;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSKNTUUKASYU)
    public String getHrkmskntuukasyu() {
        return hrkmskntuukasyu;
    }

    public void setHrkmskntuukasyu(String pHrkmskntuukasyu) {
        hrkmskntuukasyu = pHrkmskntuukasyu;
    }

    private String hrkmsknssketa;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMSKNSSKETA)
    public String getHrkmsknssketa() {
        return hrkmsknssketa;
    }

    public void setHrkmsknssketa(String pHrkmsknssketa) {
        hrkmsknssketa = pHrkmsknssketa;
    }

    private String hrkmgksoukingk;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMGKSOUKINGK)
    public String getHrkmgksoukingk() {
        return hrkmgksoukingk;
    }

    public void setHrkmgksoukingk(String pHrkmgksoukingk) {
        hrkmgksoukingk = pHrkmgksoukingk;
    }

    private String hrkmirninnmej;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMIRNINNMEJ)
    public String getHrkmirninnmej() {
        return hrkmirninnmej;
    }

    public void setHrkmirninnmej(String pHrkmirninnmej) {
        hrkmirninnmej = pHrkmirninnmej;
    }

    private String hrkmyobiv40;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMYOBIV40)
    public String getHrkmyobiv40() {
        return hrkmyobiv40;
    }

    public void setHrkmyobiv40(String pHrkmyobiv40) {
        hrkmyobiv40 = pHrkmyobiv40;
    }

    private String hrkmdatakbn4;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDATAKBN4)
    public String getHrkmdatakbn4() {
        return hrkmdatakbn4;
    }

    public void setHrkmdatakbn4(String pHrkmdatakbn4) {
        hrkmdatakbn4 = pHrkmdatakbn4;
    }

    private String hrkmdtrecordkbn3;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDTRECORDKBN3)
    public String getHrkmdtrecordkbn3() {
        return hrkmdtrecordkbn3;
    }

    public void setHrkmdtrecordkbn3(String pHrkmdtrecordkbn3) {
        hrkmdtrecordkbn3 = pHrkmdtrecordkbn3;
    }

    private String hrkmdourecordsuu1;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDOURECORDSUU1)
    public String getHrkmdourecordsuu1() {
        return hrkmdourecordsuu1;
    }

    public void setHrkmdourecordsuu1(String pHrkmdourecordsuu1) {
        hrkmdourecordsuu1 = pHrkmdourecordsuu1;
    }

    private String hrkmdourecordno1;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDOURECORDNO1)
    public String getHrkmdourecordno1() {
        return hrkmdourecordno1;
    }

    public void setHrkmdourecordno1(String pHrkmdourecordno1) {
        hrkmdourecordno1 = pHrkmdourecordno1;
    }

    private String hrkmkahensuu1;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKAHENSUU1)
    public String getHrkmkahensuu1() {
        return hrkmkahensuu1;
    }

    public void setHrkmkahensuu1(String pHrkmkahensuu1) {
        hrkmkahensuu1 = pHrkmkahensuu1;
    }

    private String hrkmkahenketa1;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKAHENKETA1)
    public String getHrkmkahenketa1() {
        return hrkmkahenketa1;
    }

    public void setHrkmkahenketa1(String pHrkmkahenketa1) {
        hrkmkahenketa1 = pHrkmkahenketa1;
    }

    private String hrkmkahen1;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKAHEN1)
    public String getHrkmkahen1() {
        return hrkmkahen1;
    }

    public void setHrkmkahen1(String pHrkmkahen1) {
        hrkmkahen1 = pHrkmkahen1;
    }

    private String hrkmdatakbn5;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDATAKBN5)
    public String getHrkmdatakbn5() {
        return hrkmdatakbn5;
    }

    public void setHrkmdatakbn5(String pHrkmdatakbn5) {
        hrkmdatakbn5 = pHrkmdatakbn5;
    }

    private String hrkmdtrecordkbn4;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDTRECORDKBN4)
    public String getHrkmdtrecordkbn4() {
        return hrkmdtrecordkbn4;
    }

    public void setHrkmdtrecordkbn4(String pHrkmdtrecordkbn4) {
        hrkmdtrecordkbn4 = pHrkmdtrecordkbn4;
    }

    private String hrkmdourecordsuu2;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDOURECORDSUU2)
    public String getHrkmdourecordsuu2() {
        return hrkmdourecordsuu2;
    }

    public void setHrkmdourecordsuu2(String pHrkmdourecordsuu2) {
        hrkmdourecordsuu2 = pHrkmdourecordsuu2;
    }

    private String hrkmdourecordno2;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDOURECORDNO2)
    public String getHrkmdourecordno2() {
        return hrkmdourecordno2;
    }

    public void setHrkmdourecordno2(String pHrkmdourecordno2) {
        hrkmdourecordno2 = pHrkmdourecordno2;
    }

    private String hrkmkahensuu2;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKAHENSUU2)
    public String getHrkmkahensuu2() {
        return hrkmkahensuu2;
    }

    public void setHrkmkahensuu2(String pHrkmkahensuu2) {
        hrkmkahensuu2 = pHrkmkahensuu2;
    }

    private String hrkmkahenketa2;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKAHENKETA2)
    public String getHrkmkahenketa2() {
        return hrkmkahenketa2;
    }

    public void setHrkmkahenketa2(String pHrkmkahenketa2) {
        hrkmkahenketa2 = pHrkmkahenketa2;
    }

    private String hrkmkahen2;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKAHEN2)
    public String getHrkmkahen2() {
        return hrkmkahen2;
    }

    public void setHrkmkahen2(String pHrkmkahen2) {
        hrkmkahen2 = pHrkmkahen2;
    }

    private String hrkmdatakbn6;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDATAKBN6)
    public String getHrkmdatakbn6() {
        return hrkmdatakbn6;
    }

    public void setHrkmdatakbn6(String pHrkmdatakbn6) {
        hrkmdatakbn6 = pHrkmdatakbn6;
    }

    private String hrkmdtrecordkbn5;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDTRECORDKBN5)
    public String getHrkmdtrecordkbn5() {
        return hrkmdtrecordkbn5;
    }

    public void setHrkmdtrecordkbn5(String pHrkmdtrecordkbn5) {
        hrkmdtrecordkbn5 = pHrkmdtrecordkbn5;
    }

    private String hrkmdourecordsuu3;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDOURECORDSUU3)
    public String getHrkmdourecordsuu3() {
        return hrkmdourecordsuu3;
    }

    public void setHrkmdourecordsuu3(String pHrkmdourecordsuu3) {
        hrkmdourecordsuu3 = pHrkmdourecordsuu3;
    }

    private String hrkmdourecordno3;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMDOURECORDNO3)
    public String getHrkmdourecordno3() {
        return hrkmdourecordno3;
    }

    public void setHrkmdourecordno3(String pHrkmdourecordno3) {
        hrkmdourecordno3 = pHrkmdourecordno3;
    }

    private String hrkmkahensuu3;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKAHENSUU3)
    public String getHrkmkahensuu3() {
        return hrkmkahensuu3;
    }

    public void setHrkmkahensuu3(String pHrkmkahensuu3) {
        hrkmkahensuu3 = pHrkmkahensuu3;
    }

    private String hrkmkahenketa3;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKAHENKETA3)
    public String getHrkmkahenketa3() {
        return hrkmkahenketa3;
    }

    public void setHrkmkahenketa3(String pHrkmkahenketa3) {
        hrkmkahenketa3 = pHrkmkahenketa3;
    }

    private String hrkmkahen3;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMKAHEN3)
    public String getHrkmkahen3() {
        return hrkmkahen3;
    }

    public void setHrkmkahen3(String pHrkmkahen3) {
        hrkmkahen3 = pHrkmkahen3;
    }

    private String hrkmrensakuseiymd;

    @Column(name=GenBT_OnlineGknyknmeisai.HRKMRENSAKUSEIYMD)
    public String getHrkmrensakuseiymd() {
        return hrkmrensakuseiymd;
    }

    public void setHrkmrensakuseiymd(String pHrkmrensakuseiymd) {
        hrkmrensakuseiymd = pHrkmrensakuseiymd;
    }
}