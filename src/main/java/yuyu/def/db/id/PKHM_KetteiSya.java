package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.mapping.GenHM_KetteiSya;
import yuyu.def.db.meta.GenQHM_KetteiSya;
import yuyu.def.db.meta.QHM_KetteiSya;

/**
 * 決定者マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_KetteiSya}</td><td colspan="3">決定者マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKetsyacd ketsyacd}</td><td>決定者コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>palketsyacd</td><td>ＰＡＬ決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ketsyanm</td><td>決定者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mostenkenrankkbn</td><td>申込点検ランク区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MostenkenRankKbn C_MostenkenRankKbn}</td></tr>
 *  <tr><td>knksateirankkbn</td><td>環境査定ランク区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KnksateirankKbn C_KnksateirankKbn}</td></tr>
 *  <tr><td>knksateijygns</td><td>環境査定上限Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>imusateirankkbn</td><td>医務査定ランク区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ImusateirankKbn C_ImusateirankKbn}</td></tr>
 *  <tr><td>imusateijygns</td><td>医務査定上限Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_KetteiSya
 * @see     GenHM_KetteiSya
 * @see     QHM_KetteiSya
 * @see     GenQHM_KetteiSya
 */
public class PKHM_KetteiSya extends AbstractExDBPrimaryKey<HM_KetteiSya, PKHM_KetteiSya> {

    private static final long serialVersionUID = 1L;

    public PKHM_KetteiSya() {
    }

    public PKHM_KetteiSya(String pKetsyacd) {
        ketsyacd = pKetsyacd;
    }

    @Transient
    @Override
    public Class<HM_KetteiSya> getEntityClass() {
        return HM_KetteiSya.class;
    }

    private String ketsyacd;

    public String getKetsyacd() {
        return ketsyacd;
    }

    public void setKetsyacd(String pKetsyacd) {
        ketsyacd = pKetsyacd;
    }

}