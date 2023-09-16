package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_HrkeIraiInfo;
import yuyu.def.db.mapping.GenIT_BAK_HrkeIraiInfo;
import yuyu.def.db.meta.GenQIT_BAK_HrkeIraiInfo;
import yuyu.def.db.meta.QIT_BAK_HrkeIraiInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 振替依頼情報バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_HrkeIraiInfo}</td><td colspan="3">振替依頼情報バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkeannaijkkbn</td><td>振替案内状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkeAnnaiJkKbn C_HrkeAnnaiJkKbn}</td></tr>
 *  <tr><td>hrkeyousiymd</td><td>振替用紙作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyksyoriymd</td><td>入金処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ryosyuymd</td><td>領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>rsgaku</td><td>領収金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>torikesiymd</td><td>取消日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyknaiyoukbn</td><td>入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyknaiyouKbn C_NyknaiyouKbn}</td></tr>
 *  <tr><td>hrkkigen</td><td>払込期限</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkiraikngk</td><td>払込依頼金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyutoukaisuuy</td><td>充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kzkpannaijiyuukbn</td><td>継続Ｐ案内事由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzkpannaijiyuuKbn C_KzkpannaijiyuuKbn}</td></tr>
 *  <tr><td>comment124keta</td><td>コメント（１２４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syorisosikicd</td><td>処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_HrkeIraiInfo
 * @see     GenIT_BAK_HrkeIraiInfo
 * @see     QIT_BAK_HrkeIraiInfo
 * @see     GenQIT_BAK_HrkeIraiInfo
 */
public class PKIT_BAK_HrkeIraiInfo extends AbstractExDBPrimaryKey<IT_BAK_HrkeIraiInfo, PKIT_BAK_HrkeIraiInfo> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_HrkeIraiInfo() {
    }

    public PKIT_BAK_HrkeIraiInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        henkousikibetukey = pHenkousikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_HrkeIraiInfo> getEntityClass() {
        return IT_BAK_HrkeIraiInfo.class;
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
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

}