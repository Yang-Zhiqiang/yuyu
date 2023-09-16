package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.mapping.GenBM_Address;
import yuyu.def.db.meta.GenQBM_Address;
import yuyu.def.db.meta.QBM_Address;

/**
 * 住所マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Address}</td><td colspan="3">住所マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getPostalCd postalCd}</td><td>郵便番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKihontikucdsimo1 kihontikucdsimo1}</td><td>基本地区コード下１桁</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kihontikucdsyoumetukbn</td><td>基本地区コード消滅理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihontikucdSyoumetuKbn C_KihontikucdSyoumetuKbn}</td></tr>
 *  <tr><td>kjadrkyoutotuusyounmari</td><td>漢字住所（京都市内通称町名あり）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjtodouhukennmketasuu</td><td>漢字都道府県名桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kjsikugunnmketasuu</td><td>漢字市区郡名桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kjsikutyousonnmketasuu</td><td>漢字市区町村名桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kjtyousonnmketasuu</td><td>漢字町村名桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kjkyoutotuusyounmketasuu</td><td>漢字京都市内通称町名桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kjadrketasuu</td><td>漢字住所桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>knadrkyoutotuusyounmari</td><td>カナ住所（京都市内通称町名あり）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kntodouhukennmketasuu</td><td>カナ都道府県名桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>knsikugunnmketasuu</td><td>カナ市区郡名桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>knsikutyousonnmketasuu</td><td>カナ市区町村名桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kntyousonnmketasuu</td><td>カナ町村名桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>knkyoutotuusyounmketasuu</td><td>カナ京都市内通称町名桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>knadrketasuu</td><td>カナ住所桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>todouhukencd</td><td>都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TodouhukenKbn C_TodouhukenKbn}</td></tr>
 *  <tr><td>gyouseikukakucd</td><td>行政区画コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ikoumaekihontikucd</td><td>移行前基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newynohyouji</td><td>新郵便番号表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>adrkj</td><td>住所（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>adrkn</td><td>住所（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>adrknblankari</td><td>住所（カナ）（空白あり）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Address
 * @see     GenBM_Address
 * @see     QBM_Address
 * @see     GenQBM_Address
 */
public class PKBM_Address extends AbstractExDBPrimaryKey<BM_Address, PKBM_Address> {

    private static final long serialVersionUID = 1L;

    public PKBM_Address() {
    }

    public PKBM_Address(String pPostalCd, String pKihontikucdsimo1) {
        postalCd = pPostalCd;
        kihontikucdsimo1 = pKihontikucdsimo1;
    }

    @Transient
    @Override
    public Class<BM_Address> getEntityClass() {
        return BM_Address.class;
    }

    private String postalCd;

    public String getPostalCd() {
        return postalCd;
    }

    public void setPostalCd(String pPostalCd) {
        postalCd = pPostalCd;
    }
    private String kihontikucdsimo1;

    public String getKihontikucdsimo1() {
        return kihontikucdsimo1;
    }

    public void setKihontikucdsimo1(String pKihontikucdsimo1) {
        kihontikucdsimo1 = pKihontikucdsimo1;
    }

}