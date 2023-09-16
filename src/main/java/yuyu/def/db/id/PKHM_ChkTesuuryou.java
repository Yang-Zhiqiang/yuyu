package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HM_ChkTesuuryou;
import yuyu.def.db.mapping.GenHM_ChkTesuuryou;
import yuyu.def.db.meta.GenQHM_ChkTesuuryou;
import yuyu.def.db.meta.QHM_ChkTesuuryou;

/**
 * 手数料チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_ChkTesuuryou}</td><td colspan="3">手数料チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkmtsry</td><td>振込手数料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     HM_ChkTesuuryou
 * @see     GenHM_ChkTesuuryou
 * @see     QHM_ChkTesuuryou
 * @see     GenQHM_ChkTesuuryou
 */
public class PKHM_ChkTesuuryou extends AbstractExDBPrimaryKey<HM_ChkTesuuryou, PKHM_ChkTesuuryou> {

    private static final long serialVersionUID = 1L;

    public PKHM_ChkTesuuryou() {
    }

    public PKHM_ChkTesuuryou(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<HM_ChkTesuuryou> getEntityClass() {
        return HM_ChkTesuuryou.class;
    }

    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}