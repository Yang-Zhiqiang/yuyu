package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.db.mapping.GenIW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.db.meta.GenQIW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.db.meta.QIW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 継続Ｐ翌月充当予定ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhKzkPYokuJyuutouYoteiWk}</td><td colspan="3">継続Ｐ翌月充当予定ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kykym</td><td>契約年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>hknkkn</td><td>保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hokenryou</td><td>保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IW_KhKzkPYokuJyuutouYoteiWk
 * @see     GenIW_KhKzkPYokuJyuutouYoteiWk
 * @see     QIW_KhKzkPYokuJyuutouYoteiWk
 * @see     GenQIW_KhKzkPYokuJyuutouYoteiWk
 */
public class PKIW_KhKzkPYokuJyuutouYoteiWk extends AbstractExDBPrimaryKey<IW_KhKzkPYokuJyuutouYoteiWk, PKIW_KhKzkPYokuJyuutouYoteiWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhKzkPYokuJyuutouYoteiWk() {
    }

    public PKIW_KhKzkPYokuJyuutouYoteiWk(String pKbnkey, String pSyono) {
        kbnkey = pKbnkey;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IW_KhKzkPYokuJyuutouYoteiWk> getEntityClass() {
        return IW_KhKzkPYokuJyuutouYoteiWk.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}