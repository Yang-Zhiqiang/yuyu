package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_SousaRirekiIvrInfo;
import yuyu.def.db.mapping.GenMT_SousaRirekiIvrInfo;
import yuyu.def.db.meta.GenQMT_SousaRirekiIvrInfo;
import yuyu.def.db.meta.QMT_SousaRirekiIvrInfo;

/**
 * 操作履歴ＩＶＲ情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_SousaRirekiIvrInfo}</td><td colspan="3">操作履歴ＩＶＲ情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTtdksikibetuid ttdksikibetuid}</td><td>手続識別ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyakusinymd</td><td>着信日時</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dsgyoumucd</td><td>ＤＳ業務コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsGyoumuCdKbn C_DsGyoumuCdKbn}</td></tr>
 *  <tr><td>syorinaiyoukbn</td><td>処理内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsSyoriNaiyouKbn C_DsSyoriNaiyouKbn}</td></tr>
 *  <tr><td>callid</td><td>コールＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dssyorikekkakbn</td><td>ＤＳ処理結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdkKekkaKbn C_TtdkKekkaKbn}</td></tr>
 *  <tr><td>setudankasyokbn</td><td>切断箇所区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SetudanKasyoKbn C_SetudanKasyoKbn}</td></tr>
 *  <tr><td>setudanriyuukbn</td><td>切断理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SetudanRiyuuKbn C_SetudanRiyuuKbn}</td></tr>
 *  <tr><td>tuuwatime</td><td>通話時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdkisihyouzikbn</td><td>手続意思表示区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdkIsihyouziKbn C_TtdkIsihyouziKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_SousaRirekiIvrInfo
 * @see     GenMT_SousaRirekiIvrInfo
 * @see     QMT_SousaRirekiIvrInfo
 * @see     GenQMT_SousaRirekiIvrInfo
 */
public class PKMT_SousaRirekiIvrInfo extends AbstractExDBPrimaryKey<MT_SousaRirekiIvrInfo, PKMT_SousaRirekiIvrInfo> {

    private static final long serialVersionUID = 1L;

    public PKMT_SousaRirekiIvrInfo() {
    }

    public PKMT_SousaRirekiIvrInfo(String pTtdksikibetuid) {
        ttdksikibetuid = pTtdksikibetuid;
    }

    @Transient
    @Override
    public Class<MT_SousaRirekiIvrInfo> getEntityClass() {
        return MT_SousaRirekiIvrInfo.class;
    }

    private String ttdksikibetuid;

    public String getTtdksikibetuid() {
        return ttdksikibetuid;
    }

    public void setTtdksikibetuid(String pTtdksikibetuid) {
        ttdksikibetuid = pTtdksikibetuid;
    }

}