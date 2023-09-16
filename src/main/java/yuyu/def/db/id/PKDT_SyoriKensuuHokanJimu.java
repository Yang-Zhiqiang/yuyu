package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import yuyu.def.db.mapping.GenDT_SyoriKensuuHokanJimu;
import yuyu.def.db.meta.GenQDT_SyoriKensuuHokanJimu;
import yuyu.def.db.meta.QDT_SyoriKensuuHokanJimu;

/**
 * 処理件数保管（事務手続別）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DT_SyoriKensuuHokanJimu}</td><td colspan="3">処理件数保管（事務手続別）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKensuuHokanYmd kensuuHokanYmd}</td><td>件数保管日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getAccountId accountId}</td><td>アカウントＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenjituzanKensuu</td><td>前日残件数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zanKensuu</td><td>残件数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kanryoKensuu</td><td>完了件数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>taskKanryouKensuuarihyouji</td><td>タスク完了件数有表示</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 * </table>
 * @see     DT_SyoriKensuuHokanJimu
 * @see     GenDT_SyoriKensuuHokanJimu
 * @see     QDT_SyoriKensuuHokanJimu
 * @see     GenQDT_SyoriKensuuHokanJimu
 */
public class PKDT_SyoriKensuuHokanJimu extends AbstractExDBPrimaryKey<DT_SyoriKensuuHokanJimu, PKDT_SyoriKensuuHokanJimu> {

    private static final long serialVersionUID = 1L;

    public PKDT_SyoriKensuuHokanJimu() {
    }

    public PKDT_SyoriKensuuHokanJimu(
        BizDate pKensuuHokanYmd,
        String pJimutetuzukicd,
        String pAccountId
    ) {
        kensuuHokanYmd = pKensuuHokanYmd;
        jimutetuzukicd = pJimutetuzukicd;
        accountId = pAccountId;
    }

    @Transient
    @Override
    public Class<DT_SyoriKensuuHokanJimu> getEntityClass() {
        return DT_SyoriKensuuHokanJimu.class;
    }

    private BizDate kensuuHokanYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKensuuHokanYmd() {
        return kensuuHokanYmd;
    }

    public void setKensuuHokanYmd(BizDate pKensuuHokanYmd) {
        kensuuHokanYmd = pKensuuHokanYmd;
    }
    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }
    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String pAccountId) {
        accountId = pAccountId;
    }

}