package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.def.db.mapping.GenBT_BuntanInfo;
import yuyu.def.db.meta.GenQBT_BuntanInfo;
import yuyu.def.db.meta.QBT_BuntanInfo;

/**
 * 分担情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_BuntanInfo}</td><td colspan="3">分担情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDairitensyouhincd dairitensyouhincd}</td><td>代理店商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTesuuryoubuntandrtencd tesuuryoubuntandrtencd}</td><td>手数料分担相手代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTesuuryoubuntanstartym tesuuryoubuntanstartym}</td><td>手数料分担開始年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>tesuuryoubuntanendym</td><td>手数料分担終了年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>tesuuryoubuntanwariai</td><td>手数料分担割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BT_BuntanInfo
 * @see     GenBT_BuntanInfo
 * @see     QBT_BuntanInfo
 * @see     GenQBT_BuntanInfo
 */
public class PKBT_BuntanInfo extends AbstractExDBPrimaryKey<BT_BuntanInfo, PKBT_BuntanInfo> {

    private static final long serialVersionUID = 1L;

    public PKBT_BuntanInfo() {
    }

    public PKBT_BuntanInfo(
        String pDrtencd,
        String pDairitensyouhincd,
        String pTesuuryoubuntandrtencd,
        BizDateYM pTesuuryoubuntanstartym
    ) {
        drtencd = pDrtencd;
        dairitensyouhincd = pDairitensyouhincd;
        tesuuryoubuntandrtencd = pTesuuryoubuntandrtencd;
        tesuuryoubuntanstartym = pTesuuryoubuntanstartym;
    }

    @Transient
    @Override
    public Class<BT_BuntanInfo> getEntityClass() {
        return BT_BuntanInfo.class;
    }

    private String drtencd;

    public String getDrtencd() {
        return drtencd;
    }

    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }
    private String dairitensyouhincd;

    public String getDairitensyouhincd() {
        return dairitensyouhincd;
    }

    public void setDairitensyouhincd(String pDairitensyouhincd) {
        dairitensyouhincd = pDairitensyouhincd;
    }
    private String tesuuryoubuntandrtencd;

    public String getTesuuryoubuntandrtencd() {
        return tesuuryoubuntandrtencd;
    }

    public void setTesuuryoubuntandrtencd(String pTesuuryoubuntandrtencd) {
        tesuuryoubuntandrtencd = pTesuuryoubuntandrtencd;
    }
    private BizDateYM tesuuryoubuntanstartym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getTesuuryoubuntanstartym() {
        return tesuuryoubuntanstartym;
    }

    public void setTesuuryoubuntanstartym(BizDateYM pTesuuryoubuntanstartym) {
        tesuuryoubuntanstartym = pTesuuryoubuntanstartym;
    }

}