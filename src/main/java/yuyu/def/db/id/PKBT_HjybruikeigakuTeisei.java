package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_HjybruikeigakuTeisei;
import yuyu.def.db.mapping.GenBT_HjybruikeigakuTeisei;
import yuyu.def.db.meta.GenQBT_HjybruikeigakuTeisei;
import yuyu.def.db.meta.QBT_HjybruikeigakuTeisei;

/**
 * 補助簿累計額訂正テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HjybruikeigakuTeisei}</td><td colspan="3">補助簿累計額訂正テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHjybruigkteiseitantositucd hjybruigkteiseitantositucd}</td><td>補助簿累計額訂正担当室コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>kasikatateiseigk</td><td>貸方訂正額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>karikatateiseigk</td><td>借方訂正額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_HjybruikeigakuTeisei
 * @see     GenBT_HjybruikeigakuTeisei
 * @see     QBT_HjybruikeigakuTeisei
 * @see     GenQBT_HjybruikeigakuTeisei
 */
public class PKBT_HjybruikeigakuTeisei extends AbstractExDBPrimaryKey<BT_HjybruikeigakuTeisei, PKBT_HjybruikeigakuTeisei> {

    private static final long serialVersionUID = 1L;

    public PKBT_HjybruikeigakuTeisei() {
    }

    public PKBT_HjybruikeigakuTeisei(String pHjybruigkteiseitantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {
        hjybruigkteiseitantositucd = pHjybruigkteiseitantositucd;
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    @Transient
    @Override
    public Class<BT_HjybruikeigakuTeisei> getEntityClass() {
        return BT_HjybruikeigakuTeisei.class;
    }

    private String hjybruigkteiseitantositucd;

    public String getHjybruigkteiseitantositucd() {
        return hjybruigkteiseitantositucd;
    }

    public void setHjybruigkteiseitantositucd(String pHjybruigkteiseitantositucd) {
        hjybruigkteiseitantositucd = pHjybruigkteiseitantositucd;
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