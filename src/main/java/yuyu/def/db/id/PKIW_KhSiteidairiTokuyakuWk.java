package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.mapping.GenIW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.meta.GenQIW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.meta.QIW_KhSiteidairiTokuyakuWk;

/**
 * 指定代理請求特約中途付加ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhSiteidairiTokuyakuWk}</td><td colspan="3">指定代理請求特約中途付加ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skssakuseiymd</td><td>請求書作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
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
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>zenkaisyorikekkakbn</td><td>前回処理結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikekkaKbn C_SyorikekkaKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdrskseiymd</td><td>指定代理請求人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     IW_KhSiteidairiTokuyakuWk
 * @see     GenIW_KhSiteidairiTokuyakuWk
 * @see     QIW_KhSiteidairiTokuyakuWk
 * @see     GenQIW_KhSiteidairiTokuyakuWk
 */
public class PKIW_KhSiteidairiTokuyakuWk extends AbstractExDBPrimaryKey<IW_KhSiteidairiTokuyakuWk, PKIW_KhSiteidairiTokuyakuWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhSiteidairiTokuyakuWk() {
    }

    public PKIW_KhSiteidairiTokuyakuWk(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Transient
    @Override
    public Class<IW_KhSiteidairiTokuyakuWk> getEntityClass() {
        return IW_KhSiteidairiTokuyakuWk.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

}