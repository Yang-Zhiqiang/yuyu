package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.mapping.GenHT_SkHubiDetail;
import yuyu.def.db.meta.GenQHT_SkHubiDetail;
import yuyu.def.db.meta.QHT_SkHubiDetail;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約不備詳細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkHubiDetail}</td><td colspan="3">新契約不備詳細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>skhubikoumokucd</td><td>新契約不備項目コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skhubinaiyoucd</td><td>新契約不備内容コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skseibisijinaiyoucd</td><td>新契約整備指示内容コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyoubunflg</td><td>長文フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>skrenrakujikou</td><td>新契約連絡事項</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkymd</td><td>登録日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hasinymd</td><td>発信日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kaisyouymd</td><td>解消日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hassinsakikbn</td><td>発信先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassinsakiKbn C_HassinsakiKbn}</td></tr>
 *  <tr><td>hasinkyokakbn</td><td>発信許可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HasinkyokaKbn C_HasinkyokaKbn}</td></tr>
 *  <tr><td>hubiitiransksymd</td><td>不備一覧作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkHubiDetail
 * @see     GenHT_SkHubiDetail
 * @see     QHT_SkHubiDetail
 * @see     GenQHT_SkHubiDetail
 */
public class PKHT_SkHubiDetail extends AbstractExDBPrimaryKey<HT_SkHubiDetail, PKHT_SkHubiDetail> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkHubiDetail() {
    }

    public PKHT_SkHubiDetail(
        String pMosno,
        String pHubisikibetukey,
        Integer pRenno3keta
    ) {
        mosno = pMosno;
        hubisikibetukey = pHubisikibetukey;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<HT_SkHubiDetail> getEntityClass() {
        return HT_SkHubiDetail.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
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