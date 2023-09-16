package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.mapping.GenIT_YykIdouUktk;
import yuyu.def.db.meta.GenQIT_YykIdouUktk;
import yuyu.def.db.meta.QIT_YykIdouUktk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 予約異動受付テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_YykIdouUktk}</td><td colspan="3">予約異動受付テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yykidousyorikbn</td><td>予約異動処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YykidousyoriKbn C_YykidousyoriKbn}</td></tr>
 *  <tr><td>uktkymd</td><td>受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoriym</td><td>処理年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_YykIdouUktk
 * @see     GenIT_YykIdouUktk
 * @see     QIT_YykIdouUktk
 * @see     GenQIT_YykIdouUktk
 */
public class PKIT_YykIdouUktk extends AbstractExDBPrimaryKey<IT_YykIdouUktk, PKIT_YykIdouUktk> {

    private static final long serialVersionUID = 1L;

    public PKIT_YykIdouUktk() {
    }

    public PKIT_YykIdouUktk(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey,
        String pKinouId
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        henkousikibetukey = pHenkousikibetukey;
        kinouId = pKinouId;
    }

    @Transient
    @Override
    public Class<IT_YykIdouUktk> getEntityClass() {
        return IT_YykIdouUktk.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }
    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

}