package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;
import yuyu.def.db.mapping.GenIT_YykIdouNaiyoHrhnk;
import yuyu.def.db.meta.GenQIT_YykIdouNaiyoHrhnk;
import yuyu.def.db.meta.QIT_YykIdouNaiyoHrhnk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 予約異動受付内容（払方変更）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_YykIdouNaiyoHrhnk}</td><td colspan="3">予約異動受付内容（払方変更）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>newhrkkeiro</td><td>（変更後）払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>newhrkkaisuu</td><td>（変更後）払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>newtikiktbrisyuruikbn</td><td>（変更後）定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>hrkkeirohnkumu</td><td>払込経路変更有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hrkkaisuuhnkumu</td><td>払込回数変更有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tikiktbrisyuruihnkumu</td><td>定期一括払種類変更有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>haraikatahnkumu</td><td>払方変更有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>haraikatahnkuktknaiyoukbn</td><td>払方変更受付内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaraikatahnkuktknaiyouKbn C_HaraikatahnkuktknaiyouKbn}</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sinkeizkkbn</td><td>新規継続区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinkeizkKbn C_SinkeizkKbn}</td></tr>
 *  <tr><td>syuudaikocd</td><td>収納代行社コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syuudaikocd C_Syuudaikocd}</td></tr>
 *  <tr><td>cardkaisyacd</td><td>カード会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardykkigen</td><td>クレジットカード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditmeiginmkn</td><td>クレジットカード名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkykdoukbn</td><td>口座名義契約者同一人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzkykdouKbn C_KzkykdouKbn}</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardbrandkbn</td><td>カードブランド区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CardBrandKbn C_CardBrandKbn}</td></tr>
 *  <tr><td>creditkaiinnosimo4keta</td><td>クレジット会員番号（下４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_YykIdouNaiyoHrhnk
 * @see     GenIT_YykIdouNaiyoHrhnk
 * @see     QIT_YykIdouNaiyoHrhnk
 * @see     GenQIT_YykIdouNaiyoHrhnk
 */
public class PKIT_YykIdouNaiyoHrhnk extends AbstractExDBPrimaryKey<IT_YykIdouNaiyoHrhnk, PKIT_YykIdouNaiyoHrhnk> {

    private static final long serialVersionUID = 1L;

    public PKIT_YykIdouNaiyoHrhnk() {
    }

    public PKIT_YykIdouNaiyoHrhnk(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        henkousikibetukey = pHenkousikibetukey;
    }

    @Transient
    @Override
    public Class<IT_YykIdouNaiyoHrhnk> getEntityClass() {
        return IT_YykIdouNaiyoHrhnk.class;
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
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

}