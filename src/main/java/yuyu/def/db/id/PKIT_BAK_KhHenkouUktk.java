package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktk;
import yuyu.def.db.mapping.GenIT_BAK_KhHenkouUktk;
import yuyu.def.db.meta.GenQIT_BAK_KhHenkouUktk;
import yuyu.def.db.meta.QIT_BAK_KhHenkouUktk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全変更受付バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhHenkouUktk}</td><td colspan="3">契約保全変更受付バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHozenhenkouuktkrenno hozenhenkouuktkrenno}</td><td>保全変更受付連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>uktkymd</td><td>受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tourokuroute</td><td>登録ルート</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TourokuRouteKbn C_TourokuRouteKbn}</td></tr>
 *  <tr><td>uktksyorikbn</td><td>受付処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktkSyoriKbn C_UktkSyoriKbn}</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoriyoteiymd</td><td>処理予定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>uktkjyoutaikbn</td><td>受付状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktkJyoutaiKbn C_UktkJyoutaiKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KhHenkouUktk
 * @see     GenIT_BAK_KhHenkouUktk
 * @see     QIT_BAK_KhHenkouUktk
 * @see     GenQIT_BAK_KhHenkouUktk
 */
public class PKIT_BAK_KhHenkouUktk extends AbstractExDBPrimaryKey<IT_BAK_KhHenkouUktk, PKIT_BAK_KhHenkouUktk> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KhHenkouUktk() {
    }

    public PKIT_BAK_KhHenkouUktk(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        Integer pHozenhenkouuktkrenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        hozenhenkouuktkrenno = pHozenhenkouuktkrenno;
    }

    @Transient
    @Override
    public Class<IT_BAK_KhHenkouUktk> getEntityClass() {
        return IT_BAK_KhHenkouUktk.class;
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
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private Integer hozenhenkouuktkrenno;

    public Integer getHozenhenkouuktkrenno() {
        return hozenhenkouuktkrenno;
    }

    public void setHozenhenkouuktkrenno(Integer pHozenhenkouuktkrenno) {
        hozenhenkouuktkrenno = pHozenhenkouuktkrenno;
    }

}