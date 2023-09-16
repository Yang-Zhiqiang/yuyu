package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_KhMeigiHenkouWk;
import yuyu.def.db.mapping.GenIW_KhMeigiHenkouWk;
import yuyu.def.db.meta.GenQIW_KhMeigiHenkouWk;
import yuyu.def.db.meta.QIW_KhMeigiHenkouWk;

/**
 * 名義変更ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhMeigiHenkouWk}</td><td colspan="3">名義変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skssakuseiymd</td><td>請求書作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>meigihnkjiyuu</td><td>名義変更事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Meigihnkjiyuu C_Meigihnkjiyuu}</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkjkhukakbn</td><td>契約者名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>kykseiymd</td><td>契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyksei</td><td>契約者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kyksei C_Kyksei}</td></tr>
 *  <tr><td>kkkyktdk</td><td>契約管理契約者続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>hhknnmkn</td><td>被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkjkhukakbn</td><td>被保険者名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>nenkinuktkbn</td><td>年金受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>sbuktnin</td><td>死亡受取人人数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sbuktkaijyokbn1</td><td>死亡受取人解除区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktkaijyoKbn C_UktkaijyoKbn}</td></tr>
 *  <tr><td>sbuktkbn1</td><td>死亡受取人区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>sbuktnmkn1</td><td>死亡受取人名（カナ）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkj1</td><td>死亡受取人名（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkjhukakbn1</td><td>死亡受取人名漢字化不可区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>sbuktseiymd1</td><td>死亡受取人生年月日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sbuktbnwari1</td><td>死亡受取人分割割合１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sbuktkaijyokbn2</td><td>死亡受取人解除区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktkaijyoKbn C_UktkaijyoKbn}</td></tr>
 *  <tr><td>sbuktkbn2</td><td>死亡受取人区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>sbuktnmkn2</td><td>死亡受取人名（カナ）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkj2</td><td>死亡受取人名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkjhukakbn2</td><td>死亡受取人名漢字化不可区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>sbuktseiymd2</td><td>死亡受取人生年月日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sbuktbnwari2</td><td>死亡受取人分割割合２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sbuktkaijyokbn3</td><td>死亡受取人解除区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktkaijyoKbn C_UktkaijyoKbn}</td></tr>
 *  <tr><td>sbuktkbn3</td><td>死亡受取人区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>sbuktnmkn3</td><td>死亡受取人名（カナ）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkj3</td><td>死亡受取人名（漢字）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkjhukakbn3</td><td>死亡受取人名漢字化不可区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>sbuktseiymd3</td><td>死亡受取人生年月日３</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sbuktbnwari3</td><td>死亡受取人分割割合３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sbuktkaijyokbn4</td><td>死亡受取人解除区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktkaijyoKbn C_UktkaijyoKbn}</td></tr>
 *  <tr><td>sbuktkbn4</td><td>死亡受取人区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>sbuktnmkn4</td><td>死亡受取人名（カナ）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkj4</td><td>死亡受取人名（漢字）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnmkjhukakbn4</td><td>死亡受取人名漢字化不可区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>sbuktseiymd4</td><td>死亡受取人生年月日４</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sbuktbnwari4</td><td>死亡受取人分割割合４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>stdrskkaijyokbn</td><td>指定代理請求人解除区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktkaijyoKbn C_UktkaijyoKbn}</td></tr>
 *  <tr><td>stdruktkbn</td><td>指定代理受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>stdrsknmkn</td><td>指定代理請求人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdrsknmkj</td><td>指定代理請求人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdrsknmkjhukakbn</td><td>指定代理請求人名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>shsnmkj</td><td>送付先氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shskyno</td><td>送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr1kj</td><td>送付先住所１（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr2kj</td><td>送付先住所２（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr3kj</td><td>送付先住所３（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>honninkakninkekkakbn</td><td>本人確認結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HonninKakninKekkaKbn C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>tyhysakuseiyhkbn</td><td>帳票作成要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TyhysakuseiyhKbn C_TyhysakuseiyhKbn}</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>zenkaisyorikekkakbn</td><td>前回処理結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikekkaKbn C_SyorikekkaKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>adrhenkouumu</td><td>住所変更有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai2tsintelno</td><td>第２通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldkyksibouymd</td><td>（旧）契約者死亡日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>stdrskseiymd</td><td>指定代理請求人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     IW_KhMeigiHenkouWk
 * @see     GenIW_KhMeigiHenkouWk
 * @see     QIW_KhMeigiHenkouWk
 * @see     GenQIW_KhMeigiHenkouWk
 */
public class PKIW_KhMeigiHenkouWk extends AbstractExDBPrimaryKey<IW_KhMeigiHenkouWk, PKIW_KhMeigiHenkouWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhMeigiHenkouWk() {
    }

    public PKIW_KhMeigiHenkouWk(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Transient
    @Override
    public Class<IW_KhMeigiHenkouWk> getEntityClass() {
        return IW_KhMeigiHenkouWk.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

}