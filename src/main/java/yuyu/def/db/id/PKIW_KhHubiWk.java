package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_KhHubiWk;
import yuyu.def.db.mapping.GenIW_KhHubiWk;
import yuyu.def.db.meta.GenQIW_KhHubiWk;
import yuyu.def.db.meta.QIW_KhHubiWk;

/**
 * 契約保全不備ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhHubiWk}</td><td colspan="3">契約保全不備ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakinmkj</td><td>連絡先氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakuyno</td><td>連絡先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakiadr1kj</td><td>連絡先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakiadr2kj</td><td>連絡先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakiadr3kj</td><td>連絡先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakusakitelno</td><td>連絡先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renrakuarea</td><td>連絡欄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubianswerkjt</td><td>不備回答期日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhHubiWk
 * @see     GenIW_KhHubiWk
 * @see     QIW_KhHubiWk
 * @see     GenQIW_KhHubiWk
 */
public class PKIW_KhHubiWk extends AbstractExDBPrimaryKey<IW_KhHubiWk, PKIW_KhHubiWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhHubiWk() {
    }

    public PKIW_KhHubiWk(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Transient
    @Override
    public Class<IW_KhHubiWk> getEntityClass() {
        return IW_KhHubiWk.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

}