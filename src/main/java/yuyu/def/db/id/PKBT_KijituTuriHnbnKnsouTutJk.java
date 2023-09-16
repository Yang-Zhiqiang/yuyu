package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.mapping.GenBT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.meta.GenQBT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.meta.QBT_KijituTuriHnbnKnsouTutJk;

/**
 * 期日到来本番検証用通知状況テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KijituTuriHnbnKnsouTutJk}</td><td colspan="3">期日到来本番検証用通知状況テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTysytno tysytno}</td><td>抽出番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nikaimeikoutuutiyouhi</td><td>２回目以降通知要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>tuutijkkbn</td><td>通知状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TuutiJkKbn C_TuutiJkKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_KijituTuriHnbnKnsouTutJk
 * @see     GenBT_KijituTuriHnbnKnsouTutJk
 * @see     QBT_KijituTuriHnbnKnsouTutJk
 * @see     GenQBT_KijituTuriHnbnKnsouTutJk
 */
public class PKBT_KijituTuriHnbnKnsouTutJk extends AbstractExDBPrimaryKey<BT_KijituTuriHnbnKnsouTutJk, PKBT_KijituTuriHnbnKnsouTutJk> {

    private static final long serialVersionUID = 1L;

    public PKBT_KijituTuriHnbnKnsouTutJk() {
    }

    public PKBT_KijituTuriHnbnKnsouTutJk(String pSubSystemId, Integer pTysytno) {
        subSystemId = pSubSystemId;
        tysytno = pTysytno;
    }

    @Transient
    @Override
    public Class<BT_KijituTuriHnbnKnsouTutJk> getEntityClass() {
        return BT_KijituTuriHnbnKnsouTutJk.class;
    }

    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }
    private Integer tysytno;

    public Integer getTysytno() {
        return tysytno;
    }

    public void setTysytno(Integer pTysytno) {
        tysytno = pTysytno;
    }

}