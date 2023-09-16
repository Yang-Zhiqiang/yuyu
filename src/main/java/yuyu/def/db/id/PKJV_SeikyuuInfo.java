package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JV_SeikyuuInfo;
import yuyu.def.db.mapping.GenJV_SeikyuuInfo;
import yuyu.def.db.meta.GenQJV_SeikyuuInfo;
import yuyu.def.db.meta.QJV_SeikyuuInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求情報ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JV_SeikyuuInfo}</td><td colspan="3">請求情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyubetu</td><td>請求種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuuSyubetu C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>saisateikbn</td><td>再査定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SaisateiKbn C_SaisateiKbn}</td></tr>
 *  <tr><td>siboukaritrkymd</td><td>死亡仮受付登録日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sibouymd</td><td>死亡日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>geninkbn</td><td>原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GeninKbn C_GeninKbn}</td></tr>
 *  <tr><td>siinkbn</td><td>死因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SiinKbn C_SiinKbn}</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkn</td><td>被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>sbuktnin</td><td>死亡受取人人数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>uktkbn</td><td>受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>uktnmkj</td><td>受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktseiymd</td><td>受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>uktbnwari</td><td>受取人分割割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>initsbjiyensitihsytkhukaumu</td><td>初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>ttdktyuuinaiyou1</td><td>手続注意内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuinaiyou2</td><td>手続注意内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuinaiyou3</td><td>手続注意内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbn1</td><td>手続注意区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbnhsknaiyou1</td><td>手続注意区分補足内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbnsetymd1</td><td>手続注意区分設定日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdktyuuikbn2</td><td>手続注意区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbnhsknaiyou2</td><td>手続注意区分補足内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbnsetymd2</td><td>手続注意区分設定日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdktyuuikbn3</td><td>手続注意区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbnhsknaiyou3</td><td>手続注意区分補足内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbnsetymd3</td><td>手続注意区分設定日３</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdktyuuikbn4</td><td>手続注意区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbnhsknaiyou4</td><td>手続注意区分補足内容４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbnsetymd4</td><td>手続注意区分設定日４</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdktyuuikbn5</td><td>手続注意区分５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbnhsknaiyou5</td><td>手続注意区分補足内容５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbnsetymd5</td><td>手続注意区分設定日５</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seikyuusyakbn</td><td>請求者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuusyaKbn C_SeikyuusyaKbn}</td></tr>
 *  <tr><td>seikyuusyanmkn</td><td>請求者（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyanmkj</td><td>請求者（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hubikanryouymd</td><td>不備完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrkekkakbn</td><td>支払結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrKekkaKbn C_ShrKekkaKbn}</td></tr>
 *  <tr><td>saigaihigaitoukbn</td><td>災害非該当区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SaigaiHigaitouKbn C_SaigaiHigaitouKbn}</td></tr>
 *  <tr><td>shrsyoriymd</td><td>支払処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tyakkinymd</td><td>着金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrgkkei</td><td>支払額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrkwsrate</td><td>支払時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>shrkwsratekjnymd</td><td>支払時為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gaikaknsnkwsrate</td><td>外貨換算為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gaikaknsnkwsratekjymd</td><td>外貨換算為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hokenkngkgoukei</td><td>保険金額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>haitoukin</td><td>配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotahaitoukin</td><td>その他配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>misyuup</td><td>未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mikeikap</td><td>未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennouseisankgk</td><td>前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>azukarikingk</td><td>預り金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>krkgk</td><td>仮受金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrtienrsk</td><td>支払遅延利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenshrgk</td><td>円換算支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenhkgkgoukei</td><td>円換算保険金額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkahaitoukin</td><td>円貨配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkasonotahaitoukin</td><td>円貨その他配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkamisyuup</td><td>円貨未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkamikeikap</td><td>円貨未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkazennouseisankgk</td><td>円貨前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkaazukarikingk</td><td>円貨預り金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkakrkgk</td><td>円貨仮受金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenshrtienrsk</td><td>円換算支払遅延利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zitkazukarikingksiteituuka</td><td>税適預り金額（指定通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zitkazukarikingkyen</td><td>税適預り金額（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikaknsntkgk</td><td>外貨換算対象金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikaknsnkekkakgk</td><td>外貨換算結果金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkaknsntkgk</td><td>円貨換算対象金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkaknsnkekkakgk</td><td>円貨換算結果金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>inputshrhousiteikbn</td><td>入力用支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_InputShrhousiteiKbn C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>zeimukwsrate</td><td>税務用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zeimukwsratekjnymd</td><td>税務用為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zeitratkikbn</td><td>税取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZeitratkiKbn C_ZeitratkiKbn}</td></tr>
 * </table>
 * @see     JV_SeikyuuInfo
 * @see     GenJV_SeikyuuInfo
 * @see     QJV_SeikyuuInfo
 * @see     GenQJV_SeikyuuInfo
 */
public class PKJV_SeikyuuInfo extends AbstractExDBPrimaryKey<JV_SeikyuuInfo, PKJV_SeikyuuInfo> {

    private static final long serialVersionUID = 1L;

    public PKJV_SeikyuuInfo() {
    }

    public PKJV_SeikyuuInfo(String pSyono, String pSkno) {
        syono = pSyono;
        skno = pSkno;
    }

    @Transient
    @Override
    public Class<JV_SeikyuuInfo> getEntityClass() {
        return JV_SeikyuuInfo.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }

}