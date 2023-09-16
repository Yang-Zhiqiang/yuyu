package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_SousaRireki;
import yuyu.def.db.mapping.GenMT_SousaRireki;
import yuyu.def.db.meta.GenQMT_SousaRireki;
import yuyu.def.db.meta.QMT_SousaRireki;

/**
 * 操作履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_SousaRireki}</td><td colspan="3">操作履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTtdksikibetuid ttdksikibetuid}</td><td>手続識別ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskokno</td><td>ＤＳ顧客番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdkstartymd</td><td>手続開始日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdkstarttime</td><td>手続開始時刻</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdkendymd</td><td>手続終了日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdkendtime</td><td>手続終了時刻</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdkkinoukbn</td><td>手続機能区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdkKinouKbn C_TtdkKinouKbn}</td></tr>
 *  <tr><td>sousarirekijkkbn</td><td>操作履歴状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SousaRirekiJkKbn C_SousaRirekiJkKbn}</td></tr>
 *  <tr><td>sousarirekikekkakbn</td><td>操作履歴結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdkKekkaKbn C_TtdkKekkaKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_SousaRireki
 * @see     GenMT_SousaRireki
 * @see     QMT_SousaRireki
 * @see     GenQMT_SousaRireki
 */
public class PKMT_SousaRireki extends AbstractExDBPrimaryKey<MT_SousaRireki, PKMT_SousaRireki> {

    private static final long serialVersionUID = 1L;

    public PKMT_SousaRireki() {
    }

    public PKMT_SousaRireki(String pTtdksikibetuid) {
        ttdksikibetuid = pTtdksikibetuid;
    }

    @Transient
    @Override
    public Class<MT_SousaRireki> getEntityClass() {
        return MT_SousaRireki.class;
    }

    private String ttdksikibetuid;

    public String getTtdksikibetuid() {
        return ttdksikibetuid;
    }

    public void setTtdksikibetuid(String pTtdksikibetuid) {
        ttdksikibetuid = pTtdksikibetuid;
    }

}