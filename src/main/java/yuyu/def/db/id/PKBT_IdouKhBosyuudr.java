package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.mapping.GenBT_IdouKhBosyuudr;
import yuyu.def.db.meta.GenQBT_IdouKhBosyuudr;
import yuyu.def.db.meta.QBT_IdouKhBosyuudr;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 異動契約保全募集代理店テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_IdouKhBosyuudr}</td><td colspan="3">異動契約保全募集代理店テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dairitencd1</td><td>代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bunwari1</td><td>分担割合１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dairitencd2</td><td>代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bunwari2</td><td>分担割合２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kanrisosikicd1</td><td>管理組織コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanrisosikicd2</td><td>管理組織コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_IdouKhBosyuudr
 * @see     GenBT_IdouKhBosyuudr
 * @see     QBT_IdouKhBosyuudr
 * @see     GenQBT_IdouKhBosyuudr
 */
public class PKBT_IdouKhBosyuudr extends AbstractExDBPrimaryKey<BT_IdouKhBosyuudr, PKBT_IdouKhBosyuudr> {

    private static final long serialVersionUID = 1L;

    public PKBT_IdouKhBosyuudr() {
    }

    public PKBT_IdouKhBosyuudr(String pSyono, Integer pRenno3keta) {
        syono = pSyono;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<BT_IdouKhBosyuudr> getEntityClass() {
        return BT_IdouKhBosyuudr.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}