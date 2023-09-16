package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.db.mapping.GenHT_MosMikakuteiSyorui;
import yuyu.def.db.meta.GenQHT_MosMikakuteiSyorui;
import yuyu.def.db.meta.QHT_MosMikakuteiSyorui;

/**
 * 申込未確定書類テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MosMikakuteiSyorui}</td><td colspan="3">申込未確定書類テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDocumentid documentid}</td><td>ドキュメントＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MosMikakuteiSyorui
 * @see     GenHT_MosMikakuteiSyorui
 * @see     QHT_MosMikakuteiSyorui
 * @see     GenQHT_MosMikakuteiSyorui
 */
public class PKHT_MosMikakuteiSyorui extends AbstractExDBPrimaryKey<HT_MosMikakuteiSyorui, PKHT_MosMikakuteiSyorui> {

    private static final long serialVersionUID = 1L;

    public PKHT_MosMikakuteiSyorui() {
    }

    public PKHT_MosMikakuteiSyorui(String pDocumentid) {
        documentid = pDocumentid;
    }

    @Transient
    @Override
    public Class<HT_MosMikakuteiSyorui> getEntityClass() {
        return HT_MosMikakuteiSyorui.class;
    }

    private String documentid;

    public String getDocumentid() {
        return documentid;
    }

    public void setDocumentid(String pDocumentid) {
        documentid = pDocumentid;
    }

}