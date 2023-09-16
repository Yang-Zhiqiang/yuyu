package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HM_SiinBunrui;
import yuyu.def.db.mapping.GenHM_SiinBunrui;
import yuyu.def.db.meta.GenQHM_SiinBunrui;
import yuyu.def.db.meta.QHM_SiinBunrui;

/**
 * 死因分類マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SiinBunrui}</td><td colspan="3">死因分類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSiincd siincd}</td><td>死因コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siintyuubunnruicd</td><td>死因中分類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyuusiincd</td><td>中死因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daisiincd</td><td>大死因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_SiinBunrui
 * @see     GenHM_SiinBunrui
 * @see     QHM_SiinBunrui
 * @see     GenQHM_SiinBunrui
 */
public class PKHM_SiinBunrui extends AbstractExDBPrimaryKey<HM_SiinBunrui, PKHM_SiinBunrui> {

    private static final long serialVersionUID = 1L;

    public PKHM_SiinBunrui() {
    }

    public PKHM_SiinBunrui(String pSiincd) {
        siincd = pSiincd;
    }

    @Transient
    @Override
    public Class<HM_SiinBunrui> getEntityClass() {
        return HM_SiinBunrui.class;
    }

    private String siincd;

    public String getSiincd() {
        return siincd;
    }

    public void setSiincd(String pSiincd) {
        siincd = pSiincd;
    }

}