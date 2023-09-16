package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_DairitenItakuSyouhn;
import yuyu.def.db.mapping.GenBT_DairitenItakuSyouhn;
import yuyu.def.db.meta.GenQBT_DairitenItakuSyouhn;
import yuyu.def.db.meta.QBT_DairitenItakuSyouhn;

/**
 * 代理店委託商品情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_DairitenItakuSyouhn}</td><td colspan="3">代理店委託商品情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrtsyouhinsikibetukbnstr drtsyouhinsikibetukbnstr}</td><td>代理店商品識別区分（文字列）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrthrkhouhoukbn drthrkhouhoukbn}</td><td>代理店払込方法区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrtplannmkbn drtplannmkbn}</td><td>代理店プラン名区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getItakuhknhnbkaisiymd itakuhknhnbkaisiymd}</td><td>委託保険販売開始年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>itakuhknhnbsyuuryouymd</td><td>委託保険販売終了年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BT_DairitenItakuSyouhn
 * @see     GenBT_DairitenItakuSyouhn
 * @see     QBT_DairitenItakuSyouhn
 * @see     GenQBT_DairitenItakuSyouhn
 */
public class PKBT_DairitenItakuSyouhn extends AbstractExDBPrimaryKey<BT_DairitenItakuSyouhn, PKBT_DairitenItakuSyouhn> {

    private static final long serialVersionUID = 1L;

    public PKBT_DairitenItakuSyouhn() {
    }

    public PKBT_DairitenItakuSyouhn(
        String pDrtencd,
        String pDrtsyouhinsikibetukbnstr,
        String pDrthrkhouhoukbn,
        String pDrtplannmkbn,
        BizDate pItakuhknhnbkaisiymd
    ) {
        drtencd = pDrtencd;
        drtsyouhinsikibetukbnstr = pDrtsyouhinsikibetukbnstr;
        drthrkhouhoukbn = pDrthrkhouhoukbn;
        drtplannmkbn = pDrtplannmkbn;
        itakuhknhnbkaisiymd = pItakuhknhnbkaisiymd;
    }

    @Transient
    @Override
    public Class<BT_DairitenItakuSyouhn> getEntityClass() {
        return BT_DairitenItakuSyouhn.class;
    }

    private String drtencd;

    public String getDrtencd() {
        return drtencd;
    }

    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }
    private String drtsyouhinsikibetukbnstr;

    public String getDrtsyouhinsikibetukbnstr() {
        return drtsyouhinsikibetukbnstr;
    }

    public void setDrtsyouhinsikibetukbnstr(String pDrtsyouhinsikibetukbnstr) {
        drtsyouhinsikibetukbnstr = pDrtsyouhinsikibetukbnstr;
    }
    private String drthrkhouhoukbn;

    public String getDrthrkhouhoukbn() {
        return drthrkhouhoukbn;
    }

    public void setDrthrkhouhoukbn(String pDrthrkhouhoukbn) {
        drthrkhouhoukbn = pDrthrkhouhoukbn;
    }
    private String drtplannmkbn;

    public String getDrtplannmkbn() {
        return drtplannmkbn;
    }

    public void setDrtplannmkbn(String pDrtplannmkbn) {
        drtplannmkbn = pDrtplannmkbn;
    }
    private BizDate itakuhknhnbkaisiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getItakuhknhnbkaisiymd() {
        return itakuhknhnbkaisiymd;
    }

    public void setItakuhknhnbkaisiymd(BizDate pItakuhknhnbkaisiymd) {
        itakuhknhnbkaisiymd = pItakuhknhnbkaisiymd;
    }

}