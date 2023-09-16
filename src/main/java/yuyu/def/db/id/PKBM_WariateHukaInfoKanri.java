package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_WariateHukaInfoKanri;
import yuyu.def.db.mapping.GenBM_WariateHukaInfoKanri;
import yuyu.def.db.meta.GenQBM_WariateHukaInfoKanri;
import yuyu.def.db.meta.QBM_WariateHukaInfoKanri;

/**
 * 割当不可情報管理マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_WariateHukaInfoKanri}</td><td colspan="3">割当不可情報管理マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getCurrenttskid currenttskid}</td><td>現在タスクID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nexttskid</td><td>次回タスクID</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wrthukatskid</td><td>割当不可タスクID</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wrthukakaijyotskid</td><td>割当不可解除用タスクID</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_WariateHukaInfoKanri
 * @see     GenBM_WariateHukaInfoKanri
 * @see     QBM_WariateHukaInfoKanri
 * @see     GenQBM_WariateHukaInfoKanri
 */
public class PKBM_WariateHukaInfoKanri extends AbstractExDBPrimaryKey<BM_WariateHukaInfoKanri, PKBM_WariateHukaInfoKanri> {

    private static final long serialVersionUID = 1L;

    public PKBM_WariateHukaInfoKanri() {
    }

    public PKBM_WariateHukaInfoKanri(
        String pSubSystemId,
        String pJimutetuzukicd,
        String pCurrenttskid,
        Integer pRenno
    ) {
        subSystemId = pSubSystemId;
        jimutetuzukicd = pJimutetuzukicd;
        currenttskid = pCurrenttskid;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<BM_WariateHukaInfoKanri> getEntityClass() {
        return BM_WariateHukaInfoKanri.class;
    }

    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }
    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }
    private String currenttskid;

    public String getCurrenttskid() {
        return currenttskid;
    }

    public void setCurrenttskid(String pCurrenttskid) {
        currenttskid = pCurrenttskid;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}