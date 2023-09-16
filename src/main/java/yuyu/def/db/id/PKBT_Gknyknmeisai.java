package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_Gknyknmeisai;
import yuyu.def.db.mapping.GenBT_Gknyknmeisai;
import yuyu.def.db.meta.GenQBT_Gknyknmeisai;
import yuyu.def.db.meta.QBT_Gknyknmeisai;

/**
 * 外貨入出金明細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_Gknyknmeisai}</td><td colspan="3">外貨入出金明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>hrkmdatakbn1</td><td>（振込用）データ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsyubetucd</td><td>（振込用）種別コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmcdkbn</td><td>（振込用）コード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmsakuseiymd hrkmsakuseiymd}</td><td>（振込用）作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmrenrakuymd hrkmrenrakuymd}</td><td>（振込用）連絡日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmrenrakukaisuu hrkmrenrakukaisuu}</td><td>（振込用）連絡回数</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmknjyymdfrom</td><td>（振込用）勘定日（自）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmknjyymdto</td><td>（振込用）勘定日（至）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmbankcd hrkmbankcd}</td><td>（振込用）銀行番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmbanknmej</td><td>（振込用）銀行名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsitencdtori</td><td>（振込用）支店コード（取次）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsitennmejtori</td><td>（振込用）支店名（英字）（取次）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmshitencd hrkmshitencd}</td><td>（振込用）支店番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsitennmej</td><td>（振込用）支店名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmyokinkbn hrkmyokinkbn}</td><td>（振込用）預金種目区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmkouzano hrkmkouzano}</td><td>（振込用）口座番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkznmej</td><td>（振込用）口座名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmzndktuukasyu hrkmzndktuukasyu}</td><td>（振込用）残高通貨種類</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmzndkssketa</td><td>（振込用）残高小数桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmgktrhkmaezndk</td><td>（振込用）外貨取引前残高</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkasikosikbn</td><td>（振込用）貸越区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmyobiv86</td><td>（振込用）予備項目Ｖ８６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdatakbn2</td><td>（振込用）データ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdtrecordkbn1</td><td>（振込用）データレコード区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdtrecordkousei</td><td>（振込用）データレコード構成</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmsyorino1 hrkmsyorino1}</td><td>（振込用）処理通番１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmknjyymd</td><td>（振込用）勘定日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmksnymd</td><td>（振込用）起算日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmiribaraikbn</td><td>（振込用）入払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtrhkkbn</td><td>（振込用）取引区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtrhktuukasyu</td><td>（振込用）取引通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtrhkssketa</td><td>（振込用）取引小数桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmgktrhkgk</td><td>（振込用）外貨取引金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmbanksyoukaino</td><td>（振込用）銀行照会番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtrhksyoukaino</td><td>（振込用）取引先照会番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtekiyounaiyouej</td><td>（振込用）摘要内容（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmyobiv103</td><td>（振込用）予備項目Ｖ１０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdatakbn3</td><td>（振込用）データ区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdtrecordkbn2</td><td>（振込用）データレコード区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdtkouseikbn</td><td>（振込用）データ構成区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmtrkscd</td><td>（振込用）取消コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsyorino2</td><td>（振込用）処理通番２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmbanksyoukaino2</td><td>（振込用）銀行照会番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsimukeymd</td><td>（振込用）仕向日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsetujyuymd</td><td>（振込用）接受日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsoukinsyu</td><td>（振込用）送金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmvalueymd</td><td>（振込用）バリュー日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmskntuukasyu</td><td>（振込用）送金通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmsknssketa</td><td>（振込用）送金小数桁</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmgksoukingk</td><td>（振込用）外貨送金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmirninnmej</td><td>（振込用）依頼人名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmyobiv40</td><td>（振込用）予備項目Ｖ４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdatakbn4</td><td>（振込用）データ区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdtrecordkbn3</td><td>（振込用）データレコード区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdourecordsuu1</td><td>（振込用）同種レコード数１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdourecordno1</td><td>（振込用）同種レコード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkahensuu1</td><td>（振込用）可変項目数１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkahenketa1</td><td>（振込用）可変項目桁数１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkahen1</td><td>（振込用）可変項目１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdatakbn5</td><td>（振込用）データ区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdtrecordkbn4</td><td>（振込用）データレコード区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdourecordsuu2</td><td>（振込用）同種レコード数２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdourecordno2</td><td>（振込用）同種レコード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkahensuu2</td><td>（振込用）可変項目数２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkahenketa2</td><td>（振込用）可変項目桁数２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkahen2</td><td>（振込用）可変項目２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdatakbn6</td><td>（振込用）データ区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdtrecordkbn5</td><td>（振込用）データレコード区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdourecordsuu3</td><td>（振込用）同種レコード数３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmdourecordno3</td><td>（振込用）同種レコード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkahensuu3</td><td>（振込用）可変項目数３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkahenketa3</td><td>（振込用）可変項目桁数３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmkahen3</td><td>（振込用）可変項目３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_Gknyknmeisai
 * @see     GenBT_Gknyknmeisai
 * @see     QBT_Gknyknmeisai
 * @see     GenQBT_Gknyknmeisai
 */
public class PKBT_Gknyknmeisai extends AbstractExDBPrimaryKey<BT_Gknyknmeisai, PKBT_Gknyknmeisai> {

    private static final long serialVersionUID = 1L;

    public PKBT_Gknyknmeisai() {
    }

    public PKBT_Gknyknmeisai(
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
        hrkmsakuseiymd = pHrkmsakuseiymd;
        hrkmrenrakuymd = pHrkmrenrakuymd;
        hrkmrenrakukaisuu = pHrkmrenrakukaisuu;
        hrkmbankcd = pHrkmbankcd;
        hrkmshitencd = pHrkmshitencd;
        hrkmyokinkbn = pHrkmyokinkbn;
        hrkmkouzano = pHrkmkouzano;
        hrkmzndktuukasyu = pHrkmzndktuukasyu;
        hrkmsyorino1 = pHrkmsyorino1;
    }

    @Transient
    @Override
    public Class<BT_Gknyknmeisai> getEntityClass() {
        return BT_Gknyknmeisai.class;
    }

    private String hrkmsakuseiymd;

    public String getHrkmsakuseiymd() {
        return hrkmsakuseiymd;
    }

    public void setHrkmsakuseiymd(String pHrkmsakuseiymd) {
        hrkmsakuseiymd = pHrkmsakuseiymd;
    }
    private String hrkmrenrakuymd;

    public String getHrkmrenrakuymd() {
        return hrkmrenrakuymd;
    }

    public void setHrkmrenrakuymd(String pHrkmrenrakuymd) {
        hrkmrenrakuymd = pHrkmrenrakuymd;
    }
    private String hrkmrenrakukaisuu;

    public String getHrkmrenrakukaisuu() {
        return hrkmrenrakukaisuu;
    }

    public void setHrkmrenrakukaisuu(String pHrkmrenrakukaisuu) {
        hrkmrenrakukaisuu = pHrkmrenrakukaisuu;
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
    private String hrkmzndktuukasyu;

    public String getHrkmzndktuukasyu() {
        return hrkmzndktuukasyu;
    }

    public void setHrkmzndktuukasyu(String pHrkmzndktuukasyu) {
        hrkmzndktuukasyu = pHrkmzndktuukasyu;
    }
    private String hrkmsyorino1;

    public String getHrkmsyorino1() {
        return hrkmsyorino1;
    }

    public void setHrkmsyorino1(String pHrkmsyorino1) {
        hrkmsyorino1 = pHrkmsyorino1;
    }

}