package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import yuyu.def.db.mapping.GenIT_KhHubiMikaisyouList;
import yuyu.def.db.meta.GenQIT_KhHubiMikaisyouList;
import yuyu.def.db.meta.QIT_KhHubiMikaisyouList;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全不備未解消リストテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHubiMikaisyouList}</td><td colspan="3">契約保全不備未解消リストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHassinsakikbn hassinsakikbn}</td><td>発信先区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HassinsakiKbn}</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sksreadymd</td><td>請求書読込日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>genponhnkykumu</td><td>原本返却有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hubitourokuktntnm</td><td>不備登録担当者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubisyouninktntnm</td><td>不備承認担当者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hassinkaisuu</td><td>発信回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>fsthubbihasinymd</td><td>初回不備発信日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lasthubbihasinymd</td><td>最終不備発信日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHubiMikaisyouList
 * @see     GenIT_KhHubiMikaisyouList
 * @see     QIT_KhHubiMikaisyouList
 * @see     GenQIT_KhHubiMikaisyouList
 */
public class PKIT_KhHubiMikaisyouList extends AbstractExDBPrimaryKey<IT_KhHubiMikaisyouList, PKIT_KhHubiMikaisyouList> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhHubiMikaisyouList() {
    }

    public PKIT_KhHubiMikaisyouList(
        String pJimutetuzukicd,
        String pSyono,
        C_HassinsakiKbn pHassinsakikbn
    ) {
        jimutetuzukicd = pJimutetuzukicd;
        syono = pSyono;
        hassinsakikbn = pHassinsakikbn;
    }

    @Transient
    @Override
    public Class<IT_KhHubiMikaisyouList> getEntityClass() {
        return IT_KhHubiMikaisyouList.class;
    }

    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private C_HassinsakiKbn hassinsakikbn;

    @org.hibernate.annotations.Type(type="UserType_C_HassinsakiKbn")
    public C_HassinsakiKbn getHassinsakikbn() {
        return hassinsakikbn;
    }

    public void setHassinsakikbn(C_HassinsakiKbn pHassinsakikbn) {
        hassinsakikbn = pHassinsakikbn;
    }

}