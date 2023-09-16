package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_KhHubiDetailWk;
import yuyu.def.db.mapping.GenIW_KhHubiDetailWk;
import yuyu.def.db.meta.GenQIW_KhHubiDetailWk;
import yuyu.def.db.meta.QIW_KhHubiDetailWk;

/**
 * 契約保全不備詳細ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhHubiDetailWk}</td><td colspan="3">契約保全不備詳細ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hubisyoruicd</td><td>不備書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>hubisyoruinm</td><td>不備書類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubinaiyoucd</td><td>不備内容コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubinaiyoumsg</td><td>不備内容メッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>genponhnkykumu</td><td>原本返却有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hassinsakikbn</td><td>発信先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassinsakiKbn C_HassinsakiKbn}</td></tr>
 *  <tr><td>hubitourokuktntid</td><td>不備登録担当者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkymd</td><td>登録日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     IW_KhHubiDetailWk
 * @see     GenIW_KhHubiDetailWk
 * @see     QIW_KhHubiDetailWk
 * @see     GenQIW_KhHubiDetailWk
 */
public class PKIW_KhHubiDetailWk extends AbstractExDBPrimaryKey<IW_KhHubiDetailWk, PKIW_KhHubiDetailWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhHubiDetailWk() {
    }

    public PKIW_KhHubiDetailWk(String pKouteikanriid, Integer pRenno3keta) {
        kouteikanriid = pKouteikanriid;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<IW_KhHubiDetailWk> getEntityClass() {
        return IW_KhHubiDetailWk.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}