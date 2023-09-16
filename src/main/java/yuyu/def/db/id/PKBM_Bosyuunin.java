package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.def.db.mapping.GenBM_Bosyuunin;
import yuyu.def.db.meta.GenQBM_Bosyuunin;
import yuyu.def.db.meta.QBM_Bosyuunin;

/**
 * 募集人マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Bosyuunin}</td><td colspan="3">募集人マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuunm</td><td>募集人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanjibosyuuninnm</td><td>漢字募集人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>itakuymd</td><td>委託年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dairiten1cd</td><td>代理店コード（１）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairiten2cd</td><td>代理店コード（２）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairiten3cd</td><td>代理店コード（３）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitenkanrisosikicd1</td><td>代理店管理組織コード（１）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitenkanrisosikicd2</td><td>代理店管理組織コード（２）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitenkanrisosikicd3</td><td>代理店管理組織コード（３）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuukbn</td><td>募集人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BosyuuKbn C_BosyuuKbn}</td></tr>
 *  <tr><td>bosyuunintourokuymd</td><td>募集人登録年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bosyuukahikbn</td><td>募集可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BsKahiKbn C_BsKahiKbn}</td></tr>
 *  <tr><td>bosyuuningyouhaiymd</td><td>募集人業廃年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hngkhknskktrkymd</td><td>変額保険資格登録年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hngkhknskktrkmsuymd</td><td>変額保険資格登録抹消年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bosyuuseiymd</td><td>募集人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>itakukaiyakuymd</td><td>委託解約年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>daibosyuucd</td><td>代表募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuutrkno</td><td>募集人登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Bosyuunin
 * @see     GenBM_Bosyuunin
 * @see     QBM_Bosyuunin
 * @see     GenQBM_Bosyuunin
 */
public class PKBM_Bosyuunin extends AbstractExDBPrimaryKey<BM_Bosyuunin, PKBM_Bosyuunin> {

    private static final long serialVersionUID = 1L;

    public PKBM_Bosyuunin() {
    }

    public PKBM_Bosyuunin(String pBosyuucd) {
        bosyuucd = pBosyuucd;
    }

    @Transient
    @Override
    public Class<BM_Bosyuunin> getEntityClass() {
        return BM_Bosyuunin.class;
    }

    private String bosyuucd;

    public String getBosyuucd() {
        return bosyuucd;
    }

    public void setBosyuucd(String pBosyuucd) {
        bosyuucd = pBosyuucd;
    }

}