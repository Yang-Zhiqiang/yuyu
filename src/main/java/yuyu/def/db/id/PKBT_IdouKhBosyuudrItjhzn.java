package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_IdouKhBosyuudrItjhzn;
import yuyu.def.db.mapping.GenBT_IdouKhBosyuudrItjhzn;
import yuyu.def.db.meta.GenQBT_IdouKhBosyuudrItjhzn;
import yuyu.def.db.meta.QBT_IdouKhBosyuudrItjhzn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 異動契約保全募集代理店一時保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_IdouKhBosyuudrItjhzn}</td><td colspan="3">異動契約保全募集代理店一時保存テーブル</td></tr>
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
 * @see     BT_IdouKhBosyuudrItjhzn
 * @see     GenBT_IdouKhBosyuudrItjhzn
 * @see     QBT_IdouKhBosyuudrItjhzn
 * @see     GenQBT_IdouKhBosyuudrItjhzn
 */
public class PKBT_IdouKhBosyuudrItjhzn extends AbstractExDBPrimaryKey<BT_IdouKhBosyuudrItjhzn, PKBT_IdouKhBosyuudrItjhzn> {

    private static final long serialVersionUID = 1L;

    public PKBT_IdouKhBosyuudrItjhzn() {
    }

    public PKBT_IdouKhBosyuudrItjhzn(String pSyono, Integer pRenno3keta) {
        syono = pSyono;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<BT_IdouKhBosyuudrItjhzn> getEntityClass() {
        return BT_IdouKhBosyuudrItjhzn.class;
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