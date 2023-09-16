package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.mapping.GenIW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.meta.GenQIW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.meta.QIW_KhKzktrkKykDrHnkWk;

/**
 * 家族登録契約者代理特約変更ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhKzktrkKykDrHnkWk}</td><td colspan="3">家族登録契約者代理特約変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skssakuseiymd</td><td>請求書作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mousideninkbn</td><td>申出人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MousideninKbn C_MousideninKbn}</td></tr>
 *  <tr><td>teiseikbn</td><td>訂正区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TeiseiKbn C_TeiseiKbn}</td></tr>
 *  <tr><td>trkkzkttdkkbn1</td><td>登録家族手続区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TrkkzkttdkKbn C_TrkkzkttdkKbn}</td></tr>
 *  <tr><td>trkkzknmkn1</td><td>登録家族名（カナ）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzknmkj1</td><td>登録家族名（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzknmkjkhukakbn1</td><td>登録家族名漢字化不可区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>trkkzkseiymd1</td><td>登録家族生年月日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trkkzksei1</td><td>登録家族性別１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seibetu C_Seibetu}</td></tr>
 *  <tr><td>trkkzkyno1</td><td>登録家族郵便番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr1kj1</td><td>登録家族住所１（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr2kj1</td><td>登録家族住所２（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr3kj1</td><td>登録家族住所３（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktelno1</td><td>登録家族電話番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktdk1</td><td>登録家族続柄１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>trkkzkttdkkbn2</td><td>登録家族手続区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TrkkzkttdkKbn C_TrkkzkttdkKbn}</td></tr>
 *  <tr><td>trkkzknmkn2</td><td>登録家族名（カナ）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzknmkj2</td><td>登録家族名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzknmkjkhukakbn2</td><td>登録家族名漢字化不可区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>trkkzkseiymd2</td><td>登録家族生年月日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trkkzksei2</td><td>登録家族性別２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seibetu C_Seibetu}</td></tr>
 *  <tr><td>trkkzktdk2</td><td>登録家族続柄２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>trkkzkyno2</td><td>登録家族郵便番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr1kj2</td><td>登録家族住所１（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr2kj2</td><td>登録家族住所２（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr3kj2</td><td>登録家族住所３（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktelno2</td><td>登録家族電話番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdrtkykttdkkbn</td><td>契約者代理特約手続区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykdrtkykttdkKbn C_KykdrtkykttdkKbn}</td></tr>
 *  <tr><td>kykdrkbn</td><td>契約者代理人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>kykdairinmkn</td><td>契約者代理人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairinmkj</td><td>契約者代理人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdrnmkjkhukakbn</td><td>契約者代理人名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>kykdrseiymd</td><td>契約者代理人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykdryno</td><td>契約者代理人郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdradr1kj</td><td>契約者代理人住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdradr2kj</td><td>契約者代理人住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdradr3kj</td><td>契約者代理人住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>trkkzktsindousiteikbn1</td><td>登録家族通信先同一指定区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TsindousiteiKbn C_TsindousiteiKbn}</td></tr>
 *  <tr><td>trkkzktsindousiteikbn2</td><td>登録家族通信先同一指定区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TsindousiteiKbn C_TsindousiteiKbn}</td></tr>
 * </table>
 * @see     IW_KhKzktrkKykDrHnkWk
 * @see     GenIW_KhKzktrkKykDrHnkWk
 * @see     QIW_KhKzktrkKykDrHnkWk
 * @see     GenQIW_KhKzktrkKykDrHnkWk
 */
public class PKIW_KhKzktrkKykDrHnkWk extends AbstractExDBPrimaryKey<IW_KhKzktrkKykDrHnkWk, PKIW_KhKzktrkKykDrHnkWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhKzktrkKykDrHnkWk() {
    }

    public PKIW_KhKzktrkKykDrHnkWk(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Transient
    @Override
    public Class<IW_KhKzktrkKykDrHnkWk> getEntityClass() {
        return IW_KhKzktrkKykDrHnkWk.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

}