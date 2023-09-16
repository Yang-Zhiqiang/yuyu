package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_KhHaraikataHenkouWk;
import yuyu.def.db.mapping.GenIW_KhHaraikataHenkouWk;
import yuyu.def.db.meta.GenQIW_KhHaraikataHenkouWk;
import yuyu.def.db.meta.QIW_KhHaraikataHenkouWk;

/**
 * 払方変更ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhHaraikataHenkouWk}</td><td colspan="3">払方変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skssakuseiymd</td><td>請求書作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>newhrkkeiro</td><td>（変更後）払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>newhrkkaisuu</td><td>（変更後）払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>newtikiktbrisyuruikbn</td><td>（変更後）定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>henkouyoteiym</td><td>変更（予定）年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkykdoukbn</td><td>口座名義契約者同一人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzkykdouKbn C_KzkykdouKbn}</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardkaisyacd</td><td>カード会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ykkigenyy</td><td>有効期限（ＹＹ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ykkigenmm</td><td>有効期限（ＭＭ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditmeiginmkn</td><td>クレジットカード名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authorikakyhkbn</td><td>オーソリ確認要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthorikakyhKbn C_AuthorikakyhKbn}</td></tr>
 *  <tr><td>yykidouuktkkbn</td><td>予約異動受付区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YykidouuktkKbn C_YykidouuktkKbn}</td></tr>
 *  <tr><td>kyuukouzaannaikbn</td><td>旧口座案内区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyuukouzaAnnaiKbn C_KyuukouzaAnnaiKbn}</td></tr>
 *  <tr><td>kanryotuutioutkbn</td><td>完了通知出力区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KanryotuutioutKbn C_KanryotuutioutKbn}</td></tr>
 *  <tr><td>zenkaisyorikekkakbn</td><td>前回処理結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikekkaKbn C_SyorikekkaKbn}</td></tr>
 *  <tr><td>kyuukouzahurikaeymd</td><td>旧口座振替日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhHaraikataHenkouWk
 * @see     GenIW_KhHaraikataHenkouWk
 * @see     QIW_KhHaraikataHenkouWk
 * @see     GenQIW_KhHaraikataHenkouWk
 */
public class PKIW_KhHaraikataHenkouWk extends AbstractExDBPrimaryKey<IW_KhHaraikataHenkouWk, PKIW_KhHaraikataHenkouWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhHaraikataHenkouWk() {
    }

    public PKIW_KhHaraikataHenkouWk(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Transient
    @Override
    public Class<IW_KhHaraikataHenkouWk> getEntityClass() {
        return IW_KhHaraikataHenkouWk.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

}