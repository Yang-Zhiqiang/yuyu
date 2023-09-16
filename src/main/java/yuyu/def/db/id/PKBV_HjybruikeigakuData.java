package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BV_HjybruikeigakuData;
import yuyu.def.db.mapping.GenBV_HjybruikeigakuData;
import yuyu.def.db.meta.GenQBV_HjybruikeigakuData;
import yuyu.def.db.meta.QBV_HjybruikeigakuData;

/**
 * 補助簿累計額情報ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BV_HjybruikeigakuData}</td><td colspan="3">補助簿累計額情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHjybtantositucd hjybtantositucd}</td><td>補助簿統括担当室コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>denym</td><td>伝票年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kasikataruigk</td><td>貸方年間累計額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>karikataruigk</td><td>借方年間累計額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kasikatateiseigk</td><td>貸方訂正額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>karikatateiseigk</td><td>借方訂正額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hjybruigkteiseiumukbn</td><td>補助簿累計額訂正有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 * </table>
 * @see     BV_HjybruikeigakuData
 * @see     GenBV_HjybruikeigakuData
 * @see     QBV_HjybruikeigakuData
 * @see     GenQBV_HjybruikeigakuData
 */
public class PKBV_HjybruikeigakuData extends AbstractExDBPrimaryKey<BV_HjybruikeigakuData, PKBV_HjybruikeigakuData> {

    private static final long serialVersionUID = 1L;

    public PKBV_HjybruikeigakuData() {
    }

    public PKBV_HjybruikeigakuData(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {
        hjybtantositucd = pHjybtantositucd;
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    @Transient
    @Override
    public Class<BV_HjybruikeigakuData> getEntityClass() {
        return BV_HjybruikeigakuData.class;
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

}