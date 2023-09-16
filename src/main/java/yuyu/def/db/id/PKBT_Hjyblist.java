package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_Hjyblist;
import yuyu.def.db.mapping.GenBT_Hjyblist;
import yuyu.def.db.meta.GenQBT_Hjyblist;
import yuyu.def.db.meta.QBT_Hjyblist;

/**
 * 補助簿リスト用テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_Hjyblist}</td><td colspan="3">補助簿リスト用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHjybtantositucd hjybtantositucd}</td><td>補助簿統括担当室コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyorisyokantantcd syorisyokantantcd}</td><td>処理所管担当室コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>karikatagk</td><td>借方金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kasikatagk</td><td>貸方金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_Hjyblist
 * @see     GenBT_Hjyblist
 * @see     QBT_Hjyblist
 * @see     GenQBT_Hjyblist
 */
public class PKBT_Hjyblist extends AbstractExDBPrimaryKey<BT_Hjyblist, PKBT_Hjyblist> {

    private static final long serialVersionUID = 1L;

    public PKBT_Hjyblist() {
    }

    public PKBT_Hjyblist(
        String pHjybtantositucd,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        String pSyorisyokantantcd,
        BizDate pDenymd
    ) {
        hjybtantositucd = pHjybtantositucd;
        kanjyoukmkcd = pKanjyoukmkcd;
        syorisyokantantcd = pSyorisyokantantcd;
        denymd = pDenymd;
    }

    @Transient
    @Override
    public Class<BT_Hjyblist> getEntityClass() {
        return BT_Hjyblist.class;
    }

    private String hjybtantositucd;

    public String getHjybtantositucd() {
        return hjybtantositucd;
    }

    public void setHjybtantositucd(String pHjybtantositucd) {
        hjybtantositucd = pHjybtantositucd;
    }
    private C_Kanjyoukmkcd kanjyoukmkcd;

    @org.hibernate.annotations.Type(type="UserType_C_Kanjyoukmkcd")
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }
    private String syorisyokantantcd;

    public String getSyorisyokantantcd() {
        return syorisyokantantcd;
    }

    public void setSyorisyokantantcd(String pSyorisyokantantcd) {
        syorisyokantantcd = pSyorisyokantantcd;
    }
    private BizDate denymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

}