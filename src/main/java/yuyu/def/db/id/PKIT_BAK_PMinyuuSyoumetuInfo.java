package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_PMinyuuSyoumetuInfo;
import yuyu.def.db.mapping.GenIT_BAK_PMinyuuSyoumetuInfo;
import yuyu.def.db.meta.GenQIT_BAK_PMinyuuSyoumetuInfo;
import yuyu.def.db.meta.QIT_BAK_PMinyuuSyoumetuInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * Ｐ未入消滅情報バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_PMinyuuSyoumetuInfo}</td><td colspan="3">Ｐ未入消滅情報バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoriym</td><td>処理年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jidousoukinhukariyuu</td><td>自動送金不可理由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_JidousoukinHukaRiyuuKbn C_JidousoukinHukaRiyuuKbn}</td></tr>
 *  <tr><td>ttdktyuuihanteikekka</td><td>手続注意判定結果</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikahiKbn C_SyorikahiKbn}</td></tr>
 *  <tr><td>stknsetkbn</td><td>質権設定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_StknsetKbn C_StknsetKbn}</td></tr>
 *  <tr><td>shrgkkei</td><td>支払額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrkwsrate</td><td>支払時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>shrtuukakaiyakuhrkngkkei</td><td>支払通貨解約返戻金額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakuhrkngkkeisiteituuka</td><td>解約返戻金額合計（指定通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotaseisan</td><td>その他精算金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkansanhaitoukin</td><td>円換算配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yensonotahaitoukin</td><td>円換算その他配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrtuukagstszeigk</td><td>支払通貨源泉徴収税額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zitkazukarikingksiteituuka</td><td>税適預り金額（指定通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zitkazukarikingkyen</td><td>税適預り金額（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakuhrknsiteituuka</td><td>解約返戻金（指定通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakuhryen</td><td>解約返戻金（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkrkgk</td><td>円換算仮受金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_PMinyuuSyoumetuInfo
 * @see     GenIT_BAK_PMinyuuSyoumetuInfo
 * @see     QIT_BAK_PMinyuuSyoumetuInfo
 * @see     GenQIT_BAK_PMinyuuSyoumetuInfo
 */
public class PKIT_BAK_PMinyuuSyoumetuInfo extends AbstractExDBPrimaryKey<IT_BAK_PMinyuuSyoumetuInfo, PKIT_BAK_PMinyuuSyoumetuInfo> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_PMinyuuSyoumetuInfo() {
    }

    public PKIT_BAK_PMinyuuSyoumetuInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_PMinyuuSyoumetuInfo> getEntityClass() {
        return IT_BAK_PMinyuuSyoumetuInfo.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }

}