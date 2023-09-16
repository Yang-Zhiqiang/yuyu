package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_IdouSkBosyuudrItjhzn;
import yuyu.def.db.mapping.GenBT_IdouSkBosyuudrItjhzn;
import yuyu.def.db.meta.GenQBT_IdouSkBosyuudrItjhzn;
import yuyu.def.db.meta.QBT_IdouSkBosyuudrItjhzn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 異動新契約募集代理店一時保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_IdouSkBosyuudrItjhzn}</td><td colspan="3">異動新契約募集代理店一時保存テーブル</td></tr>
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
 * @see     BT_IdouSkBosyuudrItjhzn
 * @see     GenBT_IdouSkBosyuudrItjhzn
 * @see     QBT_IdouSkBosyuudrItjhzn
 * @see     GenQBT_IdouSkBosyuudrItjhzn
 */
public class PKBT_IdouSkBosyuudrItjhzn extends AbstractExDBPrimaryKey<BT_IdouSkBosyuudrItjhzn, PKBT_IdouSkBosyuudrItjhzn> {

    private static final long serialVersionUID = 1L;

    public PKBT_IdouSkBosyuudrItjhzn() {
    }

    public PKBT_IdouSkBosyuudrItjhzn(String pMosno, Integer pRenno3keta) {
        mosno = pMosno;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<BT_IdouSkBosyuudrItjhzn> getEntityClass() {
        return BT_IdouSkBosyuudrItjhzn.class;
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