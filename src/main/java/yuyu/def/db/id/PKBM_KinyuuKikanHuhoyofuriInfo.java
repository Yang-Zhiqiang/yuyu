package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.mapping.GenBM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.meta.GenQBM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.meta.QBM_KinyuuKikanHuhoyofuriInfo;

/**
 * 金融機関普保預振情報マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KinyuuKikanHuhoyofuriInfo}</td><td colspan="3">金融機関普保預振情報マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yofurikyouteikaisiymd</td><td>預振協定開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yofurikyouteikaijyoymd</td><td>預振協定解除年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>itakusyakinyuucd</td><td>委託者金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>itakusyasitencd</td><td>委託者支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>itakusyayokinkbn</td><td>委託者預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>itakusyakouzano</td><td>委託者口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsrkeisanhoukbn</td><td>手数料計算方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TsrkeisanhouKbn C_TsrkeisanhouKbn}</td></tr>
 *  <tr><td>kinyuutesuuryou</td><td>金融機関手数料</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>itakusyacd</td><td>委託者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tapekoukankbn1</td><td>テープ交換区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TapekoukanKbn C_TapekoukanKbn}</td></tr>
 *  <tr><td>mdsisyacd</td><td>窓口支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zzkkyouteikaisiymd</td><td>全税共協定開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zzkkyouteikaijyoymd</td><td>全税共協定解除年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>csskyouteikaisiymd</td><td>ＣＳＳ協定開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>csskyouteikaijyoymd</td><td>ＣＳＳ協定解除年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>huhoyofuriinfokousinymd</td><td>普保預振情報更新年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BM_KinyuuKikanHuhoyofuriInfo
 * @see     GenBM_KinyuuKikanHuhoyofuriInfo
 * @see     QBM_KinyuuKikanHuhoyofuriInfo
 * @see     GenQBM_KinyuuKikanHuhoyofuriInfo
 */
public class PKBM_KinyuuKikanHuhoyofuriInfo extends AbstractExDBPrimaryKey<BM_KinyuuKikanHuhoyofuriInfo, PKBM_KinyuuKikanHuhoyofuriInfo> {

    private static final long serialVersionUID = 1L;

    public PKBM_KinyuuKikanHuhoyofuriInfo() {
    }

    public PKBM_KinyuuKikanHuhoyofuriInfo(String pBankcd) {
        bankcd = pBankcd;
    }

    @Transient
    @Override
    public Class<BM_KinyuuKikanHuhoyofuriInfo> getEntityClass() {
        return BM_KinyuuKikanHuhoyofuriInfo.class;
    }

    private String bankcd;

    public String getBankcd() {
        return bankcd;
    }

    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

}