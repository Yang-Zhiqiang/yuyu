package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.mapping.GenHM_SkSeibiSijiNaiyou;
import yuyu.def.db.meta.GenQHM_SkSeibiSijiNaiyou;
import yuyu.def.db.meta.QHM_SkSeibiSijiNaiyou;

/**
 * 新契約整備指示内容マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkSeibiSijiNaiyou}</td><td colspan="3">新契約整備指示内容マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkseibisijinaiyoucd skseibisijinaiyoucd}</td><td>新契約整備指示内容コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skseibisijinaiyou</td><td>新契約整備指示内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hyoujikahikbn</td><td>表示可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 * </table>
 * @see     HM_SkSeibiSijiNaiyou
 * @see     GenHM_SkSeibiSijiNaiyou
 * @see     QHM_SkSeibiSijiNaiyou
 * @see     GenQHM_SkSeibiSijiNaiyou
 */
public class PKHM_SkSeibiSijiNaiyou extends AbstractExDBPrimaryKey<HM_SkSeibiSijiNaiyou, PKHM_SkSeibiSijiNaiyou> {

    private static final long serialVersionUID = 1L;

    public PKHM_SkSeibiSijiNaiyou() {
    }

    public PKHM_SkSeibiSijiNaiyou(String pSkseibisijinaiyoucd) {
        skseibisijinaiyoucd = pSkseibisijinaiyoucd;
    }

    @Transient
    @Override
    public Class<HM_SkSeibiSijiNaiyou> getEntityClass() {
        return HM_SkSeibiSijiNaiyou.class;
    }

    private String skseibisijinaiyoucd;

    public String getSkseibisijinaiyoucd() {
        return skseibisijinaiyoucd;
    }

    public void setSkseibisijinaiyoucd(String pSkseibisijinaiyoucd) {
        skseibisijinaiyoucd = pSkseibisijinaiyoucd;
    }

}