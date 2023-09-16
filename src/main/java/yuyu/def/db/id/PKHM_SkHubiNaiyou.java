package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.mapping.GenHM_SkHubiNaiyou;
import yuyu.def.db.meta.GenQHM_SkHubiNaiyou;
import yuyu.def.db.meta.QHM_SkHubiNaiyou;

/**
 * 新契約不備内容マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkHubiNaiyou}</td><td colspan="3">新契約不備内容マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkhubikoumokucd skhubikoumokucd}</td><td>新契約不備項目コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkhubinaiyoucd skhubinaiyoucd}</td><td>新契約不備内容コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skhubinaiyou</td><td>新契約不備内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skhubinaiyousentakumongon</td><td>新契約不備内容選択文言</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skseibisijinaiyoucd</td><td>新契約整備指示内容コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skhubirenrakunaiyoucd</td><td>新契約不備連絡内容コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hyoujikahikbn</td><td>表示可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 * </table>
 * @see     HM_SkHubiNaiyou
 * @see     GenHM_SkHubiNaiyou
 * @see     QHM_SkHubiNaiyou
 * @see     GenQHM_SkHubiNaiyou
 */
public class PKHM_SkHubiNaiyou extends AbstractExDBPrimaryKey<HM_SkHubiNaiyou, PKHM_SkHubiNaiyou> {

    private static final long serialVersionUID = 1L;

    public PKHM_SkHubiNaiyou() {
    }

    public PKHM_SkHubiNaiyou(String pSkhubikoumokucd, String pSkhubinaiyoucd) {
        skhubikoumokucd = pSkhubikoumokucd;
        skhubinaiyoucd = pSkhubinaiyoucd;
    }

    @Transient
    @Override
    public Class<HM_SkHubiNaiyou> getEntityClass() {
        return HM_SkHubiNaiyou.class;
    }

    private String skhubikoumokucd;

    public String getSkhubikoumokucd() {
        return skhubikoumokucd;
    }

    public void setSkhubikoumokucd(String pSkhubikoumokucd) {
        skhubikoumokucd = pSkhubikoumokucd;
    }
    private String skhubinaiyoucd;

    public String getSkhubinaiyoucd() {
        return skhubinaiyoucd;
    }

    public void setSkhubinaiyoucd(String pSkhubinaiyoucd) {
        skhubinaiyoucd = pSkhubinaiyoucd;
    }

}