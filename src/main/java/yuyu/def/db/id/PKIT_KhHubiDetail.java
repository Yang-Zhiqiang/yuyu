package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KhHubiDetail;
import yuyu.def.db.mapping.GenIT_KhHubiDetail;
import yuyu.def.db.meta.GenQIT_KhHubiDetail;
import yuyu.def.db.meta.QIT_KhHubiDetail;

/**
 * 契約保全不備詳細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHubiDetail}</td><td colspan="3">契約保全不備詳細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hubisyoruicd</td><td>不備書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>hubisyoruinm</td><td>不備書類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubinaiyoucd</td><td>不備内容コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubinaiyoumsg</td><td>不備内容メッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>genponhnkykumu</td><td>原本返却有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>trkymd</td><td>登録日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hasinymd</td><td>発信日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kaisyouymd</td><td>解消日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hassinsakikbn</td><td>発信先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassinsakiKbn C_HassinsakiKbn}</td></tr>
 *  <tr><td>hasinkyokakbn</td><td>発信許可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HasinkyokaKbn C_HasinkyokaKbn}</td></tr>
 *  <tr><td>hubitourokuktntid</td><td>不備登録担当者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubisyouninktntid</td><td>不備承認担当者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHubiDetail
 * @see     GenIT_KhHubiDetail
 * @see     QIT_KhHubiDetail
 * @see     GenQIT_KhHubiDetail
 */
public class PKIT_KhHubiDetail extends AbstractExDBPrimaryKey<IT_KhHubiDetail, PKIT_KhHubiDetail> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhHubiDetail() {
    }

    public PKIT_KhHubiDetail(String pHubisikibetukey, Integer pRenno3keta) {
        hubisikibetukey = pHubisikibetukey;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<IT_KhHubiDetail> getEntityClass() {
        return IT_KhHubiDetail.class;
    }

    private String hubisikibetukey;

    public String getHubisikibetukey() {
        return hubisikibetukey;
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        hubisikibetukey = pHubisikibetukey;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}