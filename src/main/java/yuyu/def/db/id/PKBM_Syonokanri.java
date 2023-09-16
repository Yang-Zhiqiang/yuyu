package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_Syonokanri;
import yuyu.def.db.mapping.GenBM_Syonokanri;
import yuyu.def.db.meta.GenQBM_Syonokanri;
import yuyu.def.db.meta.QBM_Syonokanri;

/**
 * 証券番号管理マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Syonokanri}</td><td colspan="3">証券番号管理マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeirekinen2keta seirekinen2keta}</td><td>西暦年（２桁）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBosyuusosikicd bosyuusosikicd}</td><td>募集組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyonorenno syonorenno}</td><td>証券番号連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saibanymd</td><td>採番日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Syonokanri
 * @see     GenBM_Syonokanri
 * @see     QBM_Syonokanri
 * @see     GenQBM_Syonokanri
 */
public class PKBM_Syonokanri extends AbstractExDBPrimaryKey<BM_Syonokanri, PKBM_Syonokanri> {

    private static final long serialVersionUID = 1L;

    public PKBM_Syonokanri() {
    }

    public PKBM_Syonokanri(
        String pSeirekinen2keta,
        String pBosyuusosikicd,
        Integer pSyonorenno
    ) {
        seirekinen2keta = pSeirekinen2keta;
        bosyuusosikicd = pBosyuusosikicd;
        syonorenno = pSyonorenno;
    }

    @Transient
    @Override
    public Class<BM_Syonokanri> getEntityClass() {
        return BM_Syonokanri.class;
    }

    private String seirekinen2keta;

    public String getSeirekinen2keta() {
        return seirekinen2keta;
    }

    public void setSeirekinen2keta(String pSeirekinen2keta) {
        seirekinen2keta = pSeirekinen2keta;
    }
    private String bosyuusosikicd;

    public String getBosyuusosikicd() {
        return bosyuusosikicd;
    }

    public void setBosyuusosikicd(String pBosyuusosikicd) {
        bosyuusosikicd = pBosyuusosikicd;
    }
    private Integer syonorenno;

    public Integer getSyonorenno() {
        return syonorenno;
    }

    public void setSyonorenno(Integer pSyonorenno) {
        syonorenno = pSyonorenno;
    }

}