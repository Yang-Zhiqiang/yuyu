package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BT_HknBosyuRiyouInfo;
import yuyu.def.db.mapping.GenBT_HknBosyuRiyouInfo;
import yuyu.def.db.meta.GenQBT_HknBosyuRiyouInfo;
import yuyu.def.db.meta.QBT_HknBosyuRiyouInfo;

/**
 * 保険募集システム利用情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HknBosyuRiyouInfo}</td><td colspan="3">保険募集システム利用情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwriyoukbn</td><td>ＧＷ利用区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GwriyouKbn C_GwriyouKbn}</td></tr>
 *  <tr><td>gwkykrendouumukbn</td><td>ＧＷ契約データ連動有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gwtsryrendouumukbn</td><td>ＧＷ手数料データ連動有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gwmisyuurendouumukbn</td><td>ＧＷ未収データ連動有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>issriyoukbn</td><td>ＩＳＳ利用区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IssriyouKbn C_IssriyouKbn}</td></tr>
 *  <tr><td>gwtkyyoteiymd</td><td>ＧＷ適用予定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gwsousinsikibetusi</td><td>ＧＷ送信識別子</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwtsrykbn</td><td>ＧＷ手数料区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GwtsryKbn C_GwtsryKbn}</td></tr>
 *  <tr><td>internetstzkriyoukbn</td><td>インターネット接続利用区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_InternetstzkriyouKbn C_InternetstzkriyouKbn}</td></tr>
 *  <tr><td>hokenbossysriyoukbn</td><td>保険募集システム利用区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HokenbossysriyouKbn C_HokenbossysriyouKbn}</td></tr>
 *  <tr><td>lphteikeitiginkbn</td><td>ＬＰＨ提携地銀区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LphteikeitiginKbn C_LphteikeitiginKbn}</td></tr>
 *  <tr><td>tmbosyuukbn</td><td>対面募集区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TmbosyuuKbn C_TmbosyuuKbn}</td></tr>
 *  <tr><td>hitmbosyuukbn</td><td>非対面募集区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HitmbosyuuKbn C_HitmbosyuuKbn}</td></tr>
 *  <tr><td>kansyoutuutisakuseiyhkbn</td><td>代理店勧奨通知作成要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>fatcakakuninyhkbn</td><td>FATCA確認要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_HknBosyuRiyouInfo
 * @see     GenBT_HknBosyuRiyouInfo
 * @see     QBT_HknBosyuRiyouInfo
 * @see     GenQBT_HknBosyuRiyouInfo
 */
public class PKBT_HknBosyuRiyouInfo extends AbstractExDBPrimaryKey<BT_HknBosyuRiyouInfo, PKBT_HknBosyuRiyouInfo> {

    private static final long serialVersionUID = 1L;

    public PKBT_HknBosyuRiyouInfo() {
    }

    public PKBT_HknBosyuRiyouInfo(String pDrtencd) {
        drtencd = pDrtencd;
    }

    @Transient
    @Override
    public Class<BT_HknBosyuRiyouInfo> getEntityClass() {
        return BT_HknBosyuRiyouInfo.class;
    }

    private String drtencd;

    public String getDrtencd() {
        return drtencd;
    }

    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

}