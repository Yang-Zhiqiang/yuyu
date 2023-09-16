package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_KhKeiyakuTorikesiWk;
import yuyu.def.db.mapping.GenIW_KhKeiyakuTorikesiWk;
import yuyu.def.db.meta.GenQIW_KhKeiyakuTorikesiWk;
import yuyu.def.db.meta.QIW_KhKeiyakuTorikesiWk;

/**
 * 契約取消ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhKeiyakuTorikesiWk}</td><td colspan="3">契約取消ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyktrkskbn</td><td>契約取消区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyktrksKbn C_KyktrksKbn}</td></tr>
 *  <tr><td>sibouymd</td><td>死亡日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kaijyokessaiymd</td><td>解除決裁日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kaijyotuutiymd</td><td>解除通知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hubikanryouymd</td><td>不備完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sinsagendokknkbn</td><td>審査限度期間区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinsaGendoKknKbn C_SinsaGendoKknKbn}</td></tr>
 *  <tr><td>rikoukityuutuudannissuu</td><td>履行期中断日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>soukinsakisiteikbn</td><td>送金先指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SoukinsakisiteiKbn C_SoukinsakisiteiKbn}</td></tr>
 *  <tr><td>soukinsakinmkn</td><td>送金先氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakinmkj</td><td>送金先氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakiyno</td><td>送金先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakiadr1kj</td><td>送金先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakiadr2kj</td><td>送金先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakiadr3kj</td><td>送金先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyksyaszknmkn</td><td>契約者相続人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyksyaszknmkj</td><td>契約者相続人氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyksyaszkyno</td><td>契約者相続人郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyksyaszkadr1kj</td><td>契約者相続人住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyksyaszkadr2kj</td><td>契約者相続人住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyksyaszkadr3kj</td><td>契約者相続人住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yenshrtkumu</td><td>円支払特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>inputshrhousiteikbn</td><td>入力用支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_InputShrhousiteiKbn C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzdoukbn</td><td>口座名義人同一区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kzdou C_Kzdou}</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykmnmeigibangou</td><td>契約者ＭＮ名義番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktmnmeigibangou</td><td>受取人ＭＮ名義番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>honninkakninkekkakbn</td><td>本人確認結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HonninKakninKekkaKbn C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>zenkaisyorikekkakbn</td><td>前回処理結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikekkaKbn C_SyorikekkaKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakikbn</td><td>送金先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SoukinsakiKbn C_SoukinsakiKbn}</td></tr>
 * </table>
 * @see     IW_KhKeiyakuTorikesiWk
 * @see     GenIW_KhKeiyakuTorikesiWk
 * @see     QIW_KhKeiyakuTorikesiWk
 * @see     GenQIW_KhKeiyakuTorikesiWk
 */
public class PKIW_KhKeiyakuTorikesiWk extends AbstractExDBPrimaryKey<IW_KhKeiyakuTorikesiWk, PKIW_KhKeiyakuTorikesiWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhKeiyakuTorikesiWk() {
    }

    public PKIW_KhKeiyakuTorikesiWk(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Transient
    @Override
    public Class<IW_KhKeiyakuTorikesiWk> getEntityClass() {
        return IW_KhKeiyakuTorikesiWk.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

}