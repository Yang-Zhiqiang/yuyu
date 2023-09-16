package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HM_SkHubiRenrakuNaiyou;
import yuyu.def.db.mapping.GenHM_SkHubiRenrakuNaiyou;
import yuyu.def.db.meta.GenQHM_SkHubiRenrakuNaiyou;
import yuyu.def.db.meta.QHM_SkHubiRenrakuNaiyou;

/**
 * 新契約不備連絡内容マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkHubiRenrakuNaiyou}</td><td colspan="3">新契約不備連絡内容マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkhubirenrakunaiyoucd skhubirenrakunaiyoucd}</td><td>新契約不備連絡内容コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skhubirenrakunaiyou</td><td>新契約不備連絡内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyoubunflg</td><td>長文フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 * </table>
 * @see     HM_SkHubiRenrakuNaiyou
 * @see     GenHM_SkHubiRenrakuNaiyou
 * @see     QHM_SkHubiRenrakuNaiyou
 * @see     GenQHM_SkHubiRenrakuNaiyou
 */
public class PKHM_SkHubiRenrakuNaiyou extends AbstractExDBPrimaryKey<HM_SkHubiRenrakuNaiyou, PKHM_SkHubiRenrakuNaiyou> {

    private static final long serialVersionUID = 1L;

    public PKHM_SkHubiRenrakuNaiyou() {
    }

    public PKHM_SkHubiRenrakuNaiyou(String pSkhubirenrakunaiyoucd) {
        skhubirenrakunaiyoucd = pSkhubirenrakunaiyoucd;
    }

    @Transient
    @Override
    public Class<HM_SkHubiRenrakuNaiyou> getEntityClass() {
        return HM_SkHubiRenrakuNaiyou.class;
    }

    private String skhubirenrakunaiyoucd;

    public String getSkhubirenrakunaiyoucd() {
        return skhubirenrakunaiyoucd;
    }

    public void setSkhubirenrakunaiyoucd(String pSkhubirenrakunaiyoucd) {
        skhubirenrakunaiyoucd = pSkhubirenrakunaiyoucd;
    }

}