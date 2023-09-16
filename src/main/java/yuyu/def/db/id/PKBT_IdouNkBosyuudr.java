package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_IdouNkBosyuudr;
import yuyu.def.db.mapping.GenBT_IdouNkBosyuudr;
import yuyu.def.db.meta.GenQBT_IdouNkBosyuudr;
import yuyu.def.db.meta.QBT_IdouNkBosyuudr;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;

/**
 * 異動年金支払募集代理店テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_IdouNkBosyuudr}</td><td colspan="3">異動年金支払募集代理店テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getNksysyno nksysyno}</td><td>年金証書番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dairitencd1</td><td>代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bunwari1</td><td>分担割合１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dairitencd2</td><td>代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bunwari2</td><td>分担割合２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kanrisosikicd1</td><td>管理組織コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanrisosikicd2</td><td>管理組織コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_IdouNkBosyuudr
 * @see     GenBT_IdouNkBosyuudr
 * @see     QBT_IdouNkBosyuudr
 * @see     GenQBT_IdouNkBosyuudr
 */
public class PKBT_IdouNkBosyuudr extends AbstractExDBPrimaryKey<BT_IdouNkBosyuudr, PKBT_IdouNkBosyuudr> {

    private static final long serialVersionUID = 1L;

    public PKBT_IdouNkBosyuudr() {
    }

    public PKBT_IdouNkBosyuudr(String pNksysyno, Integer pRenno3keta) {
        nksysyno = pNksysyno;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<BT_IdouNkBosyuudr> getEntityClass() {
        return BT_IdouNkBosyuudr.class;
    }

    private String nksysyno;

    public String getNksysyno() {
        return nksysyno;
    }

    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}