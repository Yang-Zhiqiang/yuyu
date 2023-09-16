package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.mapping.GenIT_KykDairiten;
import yuyu.def.db.meta.GenQIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約代理店テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KykDairiten}</td><td colspan="3">契約代理店テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrtenrenno drtenrenno}</td><td>代理店連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>drtencd</td><td>代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanrisosikicd</td><td>代理店管理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyousekikeijyousakisosikicd</td><td>業績計上先組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd</td><td>募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daibosyuucd</td><td>代表募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenbunumu</td><td>代理店分担有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kanjidrtflg</td><td>幹事代理店フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kanjidrtflg C_Kanjidrtflg}</td></tr>
 *  <tr><td>bunwari</td><td>分担割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ikanymd</td><td>移管日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bsyujoyadrtencd</td><td>募集時親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bsyujdrtencd</td><td>募集時代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bsyujbosyuutrkno</td><td>募集時募集人登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KykDairiten
 * @see     GenIT_KykDairiten
 * @see     QIT_KykDairiten
 * @see     GenQIT_KykDairiten
 */
public class PKIT_KykDairiten extends AbstractExDBPrimaryKey<IT_KykDairiten, PKIT_KykDairiten> {

    private static final long serialVersionUID = 1L;

    public PKIT_KykDairiten() {
    }

    public PKIT_KykDairiten(
        String pKbnkey,
        String pSyono,
        Integer pDrtenrenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        drtenrenno = pDrtenrenno;
    }

    @Transient
    @Override
    public Class<IT_KykDairiten> getEntityClass() {
        return IT_KykDairiten.class;
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
    private Integer drtenrenno;

    public Integer getDrtenrenno() {
        return drtenrenno;
    }

    public void setDrtenrenno(Integer pDrtenrenno) {
        drtenrenno = pDrtenrenno;
    }

}