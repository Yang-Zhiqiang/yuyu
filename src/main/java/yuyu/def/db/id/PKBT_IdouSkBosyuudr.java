package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.mapping.GenBT_IdouSkBosyuudr;
import yuyu.def.db.meta.GenQBT_IdouSkBosyuudr;
import yuyu.def.db.meta.QBT_IdouSkBosyuudr;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 異動新契約募集代理店テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_IdouSkBosyuudr}</td><td colspan="3">異動新契約募集代理店テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dairitencd1</td><td>代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bunwari1</td><td>分担割合１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dairitencd2</td><td>代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bunwari2</td><td>分担割合２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kanrisosikicd1</td><td>管理組織コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanrisosikicd2</td><td>管理組織コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_IdouSkBosyuudr
 * @see     GenBT_IdouSkBosyuudr
 * @see     QBT_IdouSkBosyuudr
 * @see     GenQBT_IdouSkBosyuudr
 */
public class PKBT_IdouSkBosyuudr extends AbstractExDBPrimaryKey<BT_IdouSkBosyuudr, PKBT_IdouSkBosyuudr> {

    private static final long serialVersionUID = 1L;

    public PKBT_IdouSkBosyuudr() {
    }

    public PKBT_IdouSkBosyuudr(String pMosno, Integer pRenno3keta) {
        mosno = pMosno;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<BT_IdouSkBosyuudr> getEntityClass() {
        return BT_IdouSkBosyuudr.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}