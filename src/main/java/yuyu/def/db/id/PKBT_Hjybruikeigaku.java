package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_Hjybruikeigaku;
import yuyu.def.db.mapping.GenBT_Hjybruikeigaku;
import yuyu.def.db.meta.GenQBT_Hjybruikeigaku;
import yuyu.def.db.meta.QBT_Hjybruikeigaku;

/**
 * 補助簿累計額テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_Hjybruikeigaku}</td><td colspan="3">補助簿累計額テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHjybtantositucd hjybtantositucd}</td><td>補助簿統括担当室コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDenym denym}</td><td>伝票年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>karikatakmkkeigk</td><td>借方科目合計額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kasikatakmkkeigk</td><td>貸方科目合計額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>karikataruigk</td><td>借方年間累計額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kasikataruigk</td><td>貸方年間累計額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_Hjybruikeigaku
 * @see     GenBT_Hjybruikeigaku
 * @see     QBT_Hjybruikeigaku
 * @see     GenQBT_Hjybruikeigaku
 */
public class PKBT_Hjybruikeigaku extends AbstractExDBPrimaryKey<BT_Hjybruikeigaku, PKBT_Hjybruikeigaku> {

    private static final long serialVersionUID = 1L;

    public PKBT_Hjybruikeigaku() {
    }

    public PKBT_Hjybruikeigaku(
        String pHjybtantositucd,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        BizDateYM pDenym
    ) {
        hjybtantositucd = pHjybtantositucd;
        kanjyoukmkcd = pKanjyoukmkcd;
        denym = pDenym;
    }

    @Transient
    @Override
    public Class<BT_Hjybruikeigaku> getEntityClass() {
        return BT_Hjybruikeigaku.class;
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
    private BizDateYM denym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getDenym() {
        return denym;
    }

    public void setDenym(BizDateYM pDenym) {
        denym = pDenym;
    }

}