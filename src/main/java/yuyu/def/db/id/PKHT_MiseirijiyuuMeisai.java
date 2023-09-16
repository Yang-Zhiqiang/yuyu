package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_MiseirijiyuuMeisai;
import yuyu.def.db.mapping.GenHT_MiseirijiyuuMeisai;
import yuyu.def.db.meta.GenQHT_MiseirijiyuuMeisai;
import yuyu.def.db.meta.QHT_MiseirijiyuuMeisai;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 未整理事由別明細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MiseirijiyuuMeisai}</td><td colspan="3">未整理事由別明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sknnkaisiymd</td><td>責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>miseirijiyuukbn</td><td>未整理事由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>miseirijiyuudetailkbn</td><td>未整理事由詳細区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuukinjoutaikbn</td><td>入金状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyuukinjyoutaiKbn C_NyuukinjyoutaiKbn}</td></tr>
 *  <tr><td>syoruikbn1</td><td>書類区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruikbn2</td><td>書類区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruikbn3</td><td>書類区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruikbn4</td><td>書類区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruikbn5</td><td>書類区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruikbn6</td><td>書類区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruikbn7</td><td>書類区分７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruikbn8</td><td>書類区分８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruikbn9</td><td>書類区分９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruikbn10</td><td>書類区分１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruihubikensuu</td><td>書類不備件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syokaidenymd</td><td>初回伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syokairsymd</td><td>初回領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>rsgakuen</td><td>領収金額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rsgakugaika</td><td>領収金額（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rstuukasyu</td><td>領収通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>krkhuho2syoukai</td><td>仮受金（普保Ⅱ初回）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>krkhuho2kobetu</td><td>仮受金（普保Ⅱ個別）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>krkdai1kaikeijyougkyen</td><td>仮受金（第１回）計上額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>krkdai1kaikeijyougkgaika</td><td>仮受金（第１回）計上額（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>krkdai1kaituukasyu</td><td>仮受金（第１回）通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MiseirijiyuuMeisai
 * @see     GenHT_MiseirijiyuuMeisai
 * @see     QHT_MiseirijiyuuMeisai
 * @see     GenQHT_MiseirijiyuuMeisai
 */
public class PKHT_MiseirijiyuuMeisai extends AbstractExDBPrimaryKey<HT_MiseirijiyuuMeisai, PKHT_MiseirijiyuuMeisai> {

    private static final long serialVersionUID = 1L;

    public PKHT_MiseirijiyuuMeisai() {
    }

    public PKHT_MiseirijiyuuMeisai(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_MiseirijiyuuMeisai> getEntityClass() {
        return HT_MiseirijiyuuMeisai.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}