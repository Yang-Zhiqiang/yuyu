package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_KhTmttknitenWk;
import yuyu.def.db.mapping.GenIW_KhTmttknitenWk;
import yuyu.def.db.meta.GenQIW_KhTmttknitenWk;
import yuyu.def.db.meta.QIW_KhTmttknitenWk;

/**
 * 積立金移転ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhTmttknitenWk}</td><td colspan="3">積立金移転ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skssakuseiymd</td><td>請求書作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tmttknitenkbn</td><td>積立金移転区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tmttknitenkbn C_Tmttknitenkbn}</td></tr>
 *  <tr><td>uktkkigenymd</td><td>受付期限日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tmttknitenymd</td><td>積立金移転日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>honninkakninkekkakbn</td><td>本人確認結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HonninKakninKekkaKbn C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>zenkaisyorikekkakbn</td><td>前回処理結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikekkaKbn C_SyorikekkaKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhTmttknitenWk
 * @see     GenIW_KhTmttknitenWk
 * @see     QIW_KhTmttknitenWk
 * @see     GenQIW_KhTmttknitenWk
 */
public class PKIW_KhTmttknitenWk extends AbstractExDBPrimaryKey<IW_KhTmttknitenWk, PKIW_KhTmttknitenWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhTmttknitenWk() {
    }

    public PKIW_KhTmttknitenWk(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Transient
    @Override
    public Class<IW_KhTmttknitenWk> getEntityClass() {
        return IW_KhTmttknitenWk.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

}