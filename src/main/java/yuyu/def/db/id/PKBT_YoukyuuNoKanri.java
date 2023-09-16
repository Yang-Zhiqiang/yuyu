package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;
import yuyu.def.db.mapping.GenBT_YoukyuuNoKanri;
import yuyu.def.db.meta.GenQBT_YoukyuuNoKanri;
import yuyu.def.db.meta.QBT_YoukyuuNoKanri;

/**
 * 要求通番管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_YoukyuuNoKanri}</td><td colspan="3">要求通番管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getYoukyuuno youkyuuno}</td><td>要求通番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>huho2kyknokbn</td><td>普保Ⅱ契約番号区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Huho2kyknoKbn C_Huho2kyknoKbn}</td></tr>
 *  <tr><td>huho2kykno</td><td>普保Ⅱ契約番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mqkousinmqsyorikekkakbn</td><td>（ＭＱ更新用）ＭＱ処理結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MQSyorikekkaKbn C_MQSyorikekkaKbn}</td></tr>
 *  <tr><td>mqkousinacserrcd</td><td>（ＭＱ更新用）ＡＣＳ基盤エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mqtrksiraimqsyorikekkakbn</td><td>（ＭＱ取消依頼用）ＭＱ処理結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MQSyorikekkaKbn C_MQSyorikekkaKbn}</td></tr>
 *  <tr><td>mqtrksiraiacserrcd</td><td>（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknaiyouhaneierrkbn</td><td>契約内容反映エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyknaiyouhaneiErrKbn C_KyknaiyouhaneiErrKbn}</td></tr>
 *  <tr><td>trkskekkakbn</td><td>取消結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TorikesiKekkaKbn C_TorikesiKekkaKbn}</td></tr>
 *  <tr><td>jdtrkspaltrkszankbn</td><td>自動取消用ＰＡＬ取消残区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_JdTrksPalTrksZanKbn C_JdTrksPalTrksZanKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_YoukyuuNoKanri
 * @see     GenBT_YoukyuuNoKanri
 * @see     QBT_YoukyuuNoKanri
 * @see     GenQBT_YoukyuuNoKanri
 */
public class PKBT_YoukyuuNoKanri extends AbstractExDBPrimaryKey<BT_YoukyuuNoKanri, PKBT_YoukyuuNoKanri> {

    private static final long serialVersionUID = 1L;

    public PKBT_YoukyuuNoKanri() {
    }

    public PKBT_YoukyuuNoKanri(String pYoukyuuno) {
        youkyuuno = pYoukyuuno;
    }

    @Transient
    @Override
    public Class<BT_YoukyuuNoKanri> getEntityClass() {
        return BT_YoukyuuNoKanri.class;
    }

    private String youkyuuno;

    public String getYoukyuuno() {
        return youkyuuno;
    }

    public void setYoukyuuno(String pYoukyuuno) {
        youkyuuno = pYoukyuuno;
    }

}