package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.dba4editttdkkanryoutbl.EditTtdkKanryouTblDao;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_DseisansouhusakihnsyuKbn;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_KykdrtkykttdkKbn;
import yuyu.def.classification.C_KykniyuhenkouKbn;
import yuyu.def.classification.C_KzkTrkServicettdkKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_OsiraseinjihuyouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_TrkKzkHnkKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TrkkzkttdkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YenShrTkHnkKbn;
import yuyu.def.classification.C_YendthnkzeimuinfohskKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TeikikinKouza;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.bean.report.KhTtdkkanryouBean;
import yuyu.def.hozen.sorter.SortIT_AnsyuRireki;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全共通 手続完了TBL編集
 */
public class EditTtdkKanryouTbl {

    private static final String KBZENKAKUSPACE = "　";

    private static final String KBZENKAKUSPACE2 = "　　";

    private static final String KBZENKAKUSPACE3 = "　　　";

    private static final String KBZENKAKUSPACE4 = "　　　　";

    private static final String KBSAMA = "様";

    private static final String KBKAKUNINJIKOU = "＊＊確認事項＊＊";

    private static final String KBNEN = "年";

    private static final String KBSIBOUS = "死亡保険金";

    private static final String KBSBUKYHKN = "死亡給付金";

    private static final String KBHOKAN = "　大切に保管くださいますようお願いいたします。";

    private static final String KBIKORU = "＝";

    private static final String SAME = "※";

    private static final String KBPERCENT = "％";

    private static final String KBKAKKOSTART = "（";

    private static final String KBKAKKOEND = "）";

    private static final String KBUTITEN = "・";

    private static final String TARGETTKKB1 = "の目標値を";

    private static final String TARGETTKKB2 = "％から";

    private static final String TARGETTKKB3 = "％に変更しました。";

    private static final String TARGETTKKB4 = "を解約しました。";

    private static final String STDRSKTKYHUKAKB1 = "　被保険者代理人は、";

    private static final String STDRSKTKYHUKAKB2 =
        "　被保険者代理人は、代理請求時に約款上の所定要件を満たしていることが必要です。";

    private static final String STDRSKTKYHUKAKB3 = "　本特約の付加に伴う、保険料の変更はありません。";

    private static final String STDRSKTKYHUKAKB4 =
        "　詳しくは、「被保険者代理特約中途付加のしおり・約款」をご覧ください。";

    private static final String STDRSKTKYHUKAKB5 =
        "　特約中途付加のお申込みのときに「被保険者代理特約中途付加のしおり・約款」を同封していますので";

    private static final String STDRSKTKYHUKAKB6 = "　被保険者代理人は指定されていません。";

    private static final String STDRSKTKYHUKAKB7 = "です。";

    private static final String NKSHRTKYKHNKKB1 = "　年金支払特約を付加しました。";

    private static final String NKSHRTKYKHNKKB2 = "　死亡時年金受取人　　";

    private static final String NKSHRTKYKHNKKB4 = "支払時、会社所定の条件を満たさないと";

    private static final String NKSHRTKYKHNKKB5 = "　年金支払いができない場合があります。";

    private static final String NKSHRTKYKHNKKB6 =
        "　お申込みのときに「年金支払特約のしおり・約款」をお渡ししておりますので";

    private static final String NKSHRTKYKHNKKB7 = "　年金支払特約の年金支払期間を";

    private static final String NKSHRTKYKHNKKB8 = "年から";

    private static final String NKSHRTKYKHNKKB9 = "年に変更しました。";

    private static final String NKSHRTKYKHNKKB10 = "　年金支払特約を解約しました。";

    private static final String SEIYMDSEITSKB1 = "　被保険者の生年月日・性を";

    private static final String SEIYMDSEITSKB2 = "に訂正しました。";

    private static final String SEIYMDSEITSKB3 = "　被保険者の生年月日を";

    private static final String SEIYMDSEITSKB4 = "　被保険者の性を";

    private static final String SEIYMDSEITSKB5 = "　計算基準日：";

    private static final String SHRKZHNKKB1 = "　以下のとおり定期金支払口座を変更しました。";

    private static final String SHRKZHNKKB2 = "　※お客さま情報保護のため、口座番号の一部を＊にて表示しています。";

    private static final String SHRKZHNKKB3 = "　　円支払特約を付加しました。";

    private static final String SHRKZHNKKB4 = "　　円支払特約を解約しました。";

    private static final String SHRKZHNKKB5 = "　　送金先　銀行　　：";

    private static final String SHRKZHNKKB6 = "　　　　　　支店　　：";

    private static final String SHRKZHNKKB7 = "　　　　　　預金種目：";

    private static final String SHRKZHNKKB8 = "　　　　口座番号：";

    private static final String SHRKZHNKKB9 = "　　　　　　口座名義：";

    private static final String GENGKKB1 = "を";

    private static final String GENGKKB3 = "に減額しました。";

    private static final String GENGKKB4 = "　減額日（計算基準日）：";

    private static final String GENGKKB5 = "基準金額を";

    private static final String GENGKKB6 = "（減額後毎回円貨払込額　";

    private static final String GENGKKB7 = "）";

    private static final String GENGKKB8 = "＜お預り金内容＞";

    private static final String GENGKKB9 = "　個人年金保険料税制適格特約（’９０）が付加されているため、減額部分の解約返戻金およびその他の支払金は、当社";

    private static final String GENGKKB10 = "　所定の利率で利息をつけてすえ置いておき、年金支払開始日に年金額の増額に充てられます。";

    private static final String GENGKKB11 = "　減額部分の解約返戻金　　　　　　";

    private static final String GENGKKB12 = "　その他支払金（以下の合計）　　　";

    private static final String GENGKKB13 = "　　保険料（円貨払込額）　　　　　";

    private static final String GENGKKB14 = "　　その他精算金　　　　　　　　　";

    private static final String GENGKKB15 = "保険料を";

    private static final String HENKOUKB1 = "　特約中途付加のお申込みのときに「重度介護前払特約中途付加のしおり・約款」を同封していますので";

    private static final String TEKIYOUKB1 = "解約返戻金額";

    private static final String TEKIYOUKB2 = "減額部分の解約返戻金";

    private static final String TEKIYOUKB3 = "支払利息";

    private static final String TEKIYOUKB4 = "源泉徴収税額";

    private static final String TEKIYOUKB5 = "その他返戻金";

    private static final String TEKIYOUKB6 = "配当金";

    private static final String TEKIYOUKB7 = "その他支払金合計";

    private static final String TEKIYOUKB8 = "（明細）";

    private static final String TEKIYOUKB9 = "保険料（円貨払込額）";

    private static final String TEKIYOUKB10 = "その他精算金";

    private static final String TEKIYOUKB11 = "特別配当金";

    private static final String TEKIYOUKB12 = "お支払配当金額";

    private static final String TEKIYOUKB13 = "お支払配当金利息";

    private static final String TEKIYOUKB14 = "保険料";

    private static final String TEKIYOUKB15 = "解約返戻金";

    private static final String TEKIYOUKB16 = "返還金";

    private static final String BIKOUKB1 = "解約返戻金額＝（１）×（２）×（３）";

    private static final String BIKOUKB2 = "解約返戻金額＝（１）×（２）";

    private static final String BIKOUKB3 = "　（１）保険料積立金";

    private static final String BIKOUKB4 = "　（２）市場価格調整率";

    private static final String BIKOUKB5 = "　（３）適用為替レート：";

    private static final String BIKOUKB6 = "必要書類の受付日翌日から";

    private static final String BIKOUKB7 = "５営業日";

    private static final String BIKOUKB8 = "を超えた";

    private static final String BIKOUKB9 = "日分";

    private static final String BIKOUKB10 = "適用為替レート：";

    private static final String BIKOUKB11 = "　円";

    private static final String BIKOUKB12 = "外貨金額：";

    private static final String BIKOUKB13 = "為替レート：１";

    private static final String BIKOUKB14 = "換算基準日：";

    private static final String BIKOUKB15 = "円建変更時返戻金";

    private static final String BIKOUKB16 = "解約返戻金額＝（１）×（２）－（３）";

    private static final String BIKOUKB17 = "解約返戻金額＝（（１）×（２）－（３））×（４）";

    private static final String BIKOUKB18 = "　（３）解約控除額（※）";

    private static final String BIKOUKB19 = "　（４）適用為替レート：";

    private static final String BIKOUKB20 = "　（１）積立金相当額";

    private static final String BIKOUKB21 = "・解約返戻金額には以下の契約変更時返戻金（注）";

    private static final String BIKOUKB22 = "　を含みます。";

    private static final String BIKOUKB23 = "・その他支払金合計はその他支払金明細の合計額（円）";

    private static final String BIKOUKB24 = "　を外貨に換算した金額です。　（１）÷（２)";

    private static final String BIKOUKB25 = "　（１）その他支払金明細の合計額（円）";

    private static final String BIKOUKB26 = "　（２）適用為替レート：";

    private static final String BIKOUKB27 = "　（１）適用為替レート：";

    private static final String BIKOUKB28 = "　（２）解約返戻金";

    private static final String BIKOUKB29 = "　　上記解約返戻金には以下の契約変更時返戻金（注）";

    private static final String BIKOUKB30 = "・その他支払金合計はその他支払金明細の合計額です。";

    private static final String BIKOUKB33 = "・お支払配当金額はお支払配当金額（円）";

    private static final String BIKOUKB34 = "　（１）お支払配当金額（円）";

    private static final String BIKOUKB35 = "・減額部分の解約返戻金は解約返戻金（外貨）";

    private static final String BIKOUKB36 = "　を円貨に換算した金額です。　（１）×（２）";

    private static final String BIKOUKB37 = "　（２）減額部分の解約返戻金（外貨）";

    private static final String BIKOUKB38 = "・減額部分の解約返戻金は明細の合計額（外貨）";

    private static final String BIKOUKB39 = "　（２）減額部分の解約返戻金額明細の合計額（外貨）";

    private static final String BIKOUKB40 = "・返還金＝（１）×（２）";

    private static final String BIKOUKB41 = "　（２）返還金";

    private static final String BIKOUKB42 = "・解約返戻金額は解約返戻金額明細の合計額（外貨）";

    private static final String BIKOUKB43 = "　を円貨に換算した金額です。　（１）×（２）";

    private static final String BIKOUKB44 = "　（２）解約返戻金額明細の合計額（外貨）";

    private static final String ZEIMUKB1 = "の所得となります。";

    private static final String ZEIMUKB2 = "※ご契約期間中に契約者の変更がありました。";

    private static final String ZEIMUKB3 = "　確定申告については所轄の税務署にお問い合わせください。";

    private static final String ZEIMUKB4 = "※収入金額にはその他返戻金は含まれておりません。";

    private static final String HYOUDAIKB1 = "「お手続き完了のお知らせ」について";

    private static final String OSORASEKB1 = "【お支払内容について】";

    private static final String OSORASEKB2 = "　◆解約日は完備された手続書類を当社が受け付けた日となります。";

    private static final String OSORASEKB3 = "　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、";

    private static final String OSORASEKB4 = "　　市場金利の変動に応じた市場価格調整（※）を適用し計算するため、解約日の保険料積立金額から";

    private static final String OSORASEKB5 = "　　増減します。";

    private static final String OSORASEKB6 = "　　（※）市場価格調整について";

    private static final String OSORASEKB7 = "　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる";

    private static final String OSORASEKB8 = "　　　　　しくみをいいます。";

    private static final String OSORASEKB9 = "　　　　・一般的に市場金利が高くなると資産の価値が減少するため解約返戻金額は減少し、市場金利が";

    private static final String OSORASEKB10 = "　　　　　低くなると資産の価値が増加するため解約返戻金額も増加します。";

    private static final String OSORASEKB11 = "【適用為替レートについて】";

    private static final String OSORASEKB12 = "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて解約日時点の当社";

    private static final String OSORASEKB13 = "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて減額日時点の当社";

    private static final String OSORASEKB14 = "　　所定の為替レート（※１）で円貨に換算してお支払いしています。";

    private static final String OSORASEKB15 = "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。";

    private static final String OSORASEKB16 = "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電";

    private static final String OSORASEKB17 = "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の";

    private static final String OSORASEKB18 = "　　　　公示値とします。";

    private static final String OSORASEKB19 = "【解約返戻金に対する税務のご説明】";

    private static final String OSORASEKB20 = "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通";

    private static final String OSORASEKB21 = "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。";

    private static final String OSORASEKB22 = "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。";

    private static final String OSORASEKB23 = "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）";

    private static final String OSORASEKB24 = "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。";

    private static final String OSORASEKB25 = "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２";

    private static final String OSORASEKB26 = "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。";

    private static final String OSORASEKB27 = "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」";

    private static final String OSORASEKB28 = "　　は、確定申告の際の参考資料となりますので、大切に保管してください。";

    private static final String OSORASEKB29 = "　◆収入金額は、解約日の為替レートにて円換算した金額です。";

    private static final String OSORASEKB30 = "　◆収入金額は、減額日の為替レートにて円換算した金額です。";

    private static final String OSORASEKB31 = "　◆所轄の税務署あてに、支払調書を提出いたします。";

    private static final String OSORASEKB32 = "　◆「お手続き完了のお知らせ」は、確定申告の際の参考資料となりますので、大切に保管してください。";

    private static final String OSORASEKB33 = "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。";

    private static final String OSORASEKB34 = "　◆税法上、源泉分離課税の対象となりますので、お支払金額から差し引きしています。";

    private static final String OSORASEKB35 = "　　お支払金額明細に記載の源泉徴収税額は復興特別所得税を含んだ金額です。";

    private static final String OSORASEKB36 = "　◆解約返戻金額は、市場金利の変動に応じた市場価格調整（※）を適用し計算するため、市場金利の";

    private static final String OSORASEKB37 = "　　変動により解約日の積立金額から増減します。また、解約時等にかかる費用（解約控除）として、";

    private static final String OSORASEKB38 = "　　基準金額の一定割合（契約日からの経過年数に応じた所定の控除率）を差し引きます。";

    private static final String OSORASEKB39 = "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業";

    private static final String OSORASEKB40 = "　　　　日とします。";

    private static final String OSORASEKB41 = "　◆税法上、源泉分離課税の対象となりますが、お支払金額から差し引かれる税額はありません。";

    private static final String OSORASEKB42 = "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。";

    private static final String OSORASEKB43 = "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。";

    private static final String OSORASEKB44 = "　◆既払込保険料等は既に払い込まれた円貨払込額の合計額等です。";

    private static final String OSORASEKB45 = "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）";

    private static final String OSORASEKB46 = "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を減額日時点の当社所定の為替レート（※１）";

    private static final String OSORASEKB47 = "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。";

    private static final String OSORASEKB48 = "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。";

    private static final String OSORASEKB49 = "　◆解約返戻金は、解約返戻金を消滅日の当社所定の為替レートで円貨に換算した金額です。";

    private static final String OSORASEKB50 = "【保険料のご返金について】 ";

    private static final String OSORASEKB51 = "　当社から金融機関あてに次回の保険料（円貨払込額）の振替依頼は完了しています。行き違いに保険料（円";

    private static final String OSORASEKB52 = "　貨払込額）が振り替えられたときは、当社へ着金しだい振替口座へご返金させていただきます。";

    private static final String OSORASEKB53 = "　＊口座振替日　";

    private static final String OSORASEKB54 = "　＊口座振替依頼金額　";

    private static final String OSORASEKB55 = "から";

    private static final String OSORASEKB56 = "か月分を";

    private static final String OSORASEKB57 = "　　ご案内しています。";

    private static final String OSORASEKB58 = "　◆消滅日の属する年の所得となります。";

    private static final String OSORASEKB59 = "　◆ご契約当初１５年間の解約返戻金額は市場価格調整（※）を適用し計算するため、市場金利の変動に";

    private static final String OSORASEKB60 = "　　より、解約日の保険料積立金額から増減します。また、ご契約当初１０年間は、一時払保険料相当額";

    private static final String OSORASEKB61 = "　　に一定割合（契約日からの経過年数に応じた所定の控除率）を乗じた金額を差し引きます（解約";

    private static final String OSORASEKB62 = "　　控除）。";

    private static final String OSORASEKB63 = "か月分保険料は、当社からクレジットカ－ド発行会社あてに請求を完了して";

    private static final String OSORASEKB64 = "　　います。";

    private static final String OSORASEKB65 = "　＊ご請求金額　";

    private static final String OSORASEKB66 = "　・後日、クレジットカ－ドの決済（口座振替）が行われたときには、上記保険料は、当社へ着金しだい、";

    private static final String OSORASEKB67 = "　　【解約手続時の支払指定口座】へご返金いたします。何とぞご了承ください。";

    private static final String OSORASEKB68 = "　　別途ご返金いたします。何とぞご了承ください。";

    private static final String OSORASEKB69 = "　・今般の解約手続時のお支払金額は、上記保険料をいただくことを前提に計算した内容になっています。";

    private static final String OSORASEKB70 = "　・ご指定のクレジットカ－ド発行会社により、後日、ご精求金額の決済が行われることがありますが、こ";

    private static final String OSORASEKB71 = "　　の保険料の返金はできませんので、何とぞご了承ください。";

    private static final String OSORASEKB72 = "　・上記保険料は、今般の解約手続時のお支払金額【その他精算金】に含めてご返金しています。";

    private static final String OSORASEKB73 = "　・行き違いにより、後日、クレジットカ－ドの決済が行われることがあります。何とぞご了承ください。";

    private static final String OSORASEKB74 = "　◆既払込保険料等は既に払い込まれた保険料等の合計額です。";

    private static final String OSORASEKB75 = "　◆円貨支払いのご請求により、返還金を外貨（指定通貨または選択通貨）にかえて生年月日・性訂正日時点の";

    private static final String OSORASEKB76 = "　　当社所定の為替レート（※１）で円貨に換算してお支払いしています。";

    private static final String OSORASEKB77 = "　当社から金融機関あてに次回の保険料の振替依頼は完了しています。行き違いに保険料が振り替えられたと";

    private static final String OSORASEKB78 = "　きは、当社へ着金しだい振替口座へご返金させていただきます。";

    private static final String OSORASEKB79 = "　◆消滅日は保険料払込みの猶予期間満了日の翌日です。";

    private static final String MEIHENKB1 = "［税務に関するお知らせ］";

    private static final String MEIHENKB2 = "・この通知は確定申告の際の参考資料になります。";

    private static final String MEIHENKB3 = "・以下の金額で「保険契約者等の異動に関する調書」が作成されます。";

    private static final String MEIHENKB4 = "　　解約返戻金相当額：　　　　　";

    private static final String MEIHENKB5 = "　　既払込保険料等の総額：　　　";

    private static final String MEIHENKB6 = "　　直前契約者様の払込保険料等：";

    private static final String MEIHENKB7 = "　　※生命保険契約における契約者変更に伴う相続については、";

    private static final String MEIHENKB8 = "　　　解約返戻金相当額が権利の評価額とみなされます。";

    private static final String MEIHENKB9 = "　　　詳細については、税務署・税理士等にご確認ください。";

    private static final String MKHGKHNK1 = "目標額：";

    private static final String MKHGKHNK2 = "に変更しました。";

    private static final String MKHGKHNK3 = "目標額：目標額の設定を撤回しました。";

    private static final String MKHGKHNK4 = "変更日：";

    private static final String MKHGKHNK5 = "基準金額の";

    private static final String MKHGKHNK6 = "円建基準金額の";

    private static final String YENDTHNKKB1 = "（基準金額（※１）の";

    private static final String YENDTHNKKB2 = "％）";

    private static final String YENDTHNKKB3 = "（※１）基準金額は";

    private static final String YENDTHNKKB4 = "円";

    private static final String YENDTHNKKB5 = "です。";

    private static final String YENDTHNKKB6 = "（※２）到達日の解約返戻金額は";

    private static final String YENDTHNKKB7 = "（円換算に使用した為替レート：１";

    private static final String YENDTHNKKB8 = "（※３）円建終身保険の原資となる解約返戻金の円換算額は";

    private static final String YENDTHNKKB9 = "「変更請求日の解約返戻金額（";

    private static final String YENDTHNKKB10 = "お手続き方法などの詳細につきましては、裏面をご確認くださいますようお願いいたします。";

    private static final String YENDTHNKKB11 = "「一時払保険料（";

    private static final String YENDTHNKKB12 = "）の円換算額";

    private static final String YENDTHNKKB13 = "）」です。";

    private static final String YENDTHNKKB14 = "「円貨払込額（";

    private static final String YENDTHNKKB15 = "（※１）円建基準金額は";

    private static final String YENDTHNKKB16 = "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。";

    private static final String YENDTHNKKB17 = "到達日の解約返戻金の円換算額との差額を円建変更時返戻金額としてお支払いいたします。";

    private static final String YENDTHNKKB18 = "（円建基準金額（※１）の";

    private static final String YENDTHNKKB19 = "（※）基準金額は";

    private static final String YENDTHNKKB20 = "（※）円建変更後基準金額は";

    private static final String YENDTHNKKB21 = "「変更申出日の解約返戻金額（";

    private static final String TMTTKNITENKB1 = "●変更内容";

    private static final String TMTTKNITENKB2 = "積立金を指数連動部分から定率積立部分に移転します。";

    private static final String TMTTKNITENKB3 = "移転日　";

    private static final String TMTTKNITENKB4 = "●変更後の内容について";

    private static final String TMTTKNITENKB5 = "　・積立金移転後の積立金額は移転日以降にお送りします「ご契約内容のお知らせ」でご確認ください。";

    private static final String TMTTKNITENKB6 = "　・定率積立へ移転後は、積立金（定率積立部分）から積立金（指数連動部分）へ戻すことはできません。";

    private static final String TMTTKNITENKB7 = "積立金移転手続きを取消しします。";

    private static final String KAIYAKUKB1 = "※解約控除額：基準金額×控除率　（契約日からの経過年数";

    private static final String KAIYAKUKB2 = "年以上";

    private static final String KAIYAKUKB3 = "年未満";

    private static final String KAIYAKUKB4 = "につき";

    private static final String KAIYAKUKB5 = "（注）個人年金保険料税制適格特約（’９０）付加のため、契約変更時にお預かりしていた返戻金";

    private static final String KAIYAKUKB6 = "※解約控除額：一時払保険料相当額×控除率　（契約日からの経過年数";

    private static final String HAITOUKINSIHARAIKB1 = "＜ご連絡事項＞";

    private static final String HAITOUKINSIHARAIKB2 = "　配当金は円貨でお支払いします。";

    private static final String HAITOUKINSIHARAIKB3 = "　今回のお支払の結果、積立配当金残高は　";

    private static final String HAITOUKINSIHARAIKB4 = "　になりました。";

    private static final String HAITOUKINTUIBARAIKB1 = "※解約日時点の当社所定の為替レート";

    private static final String HAITOUKINTUIBARAIKB2 = "※書類完備日時点の当社所定の為替レート";

    private static final String KZKTOUROKU_KBNINIT = "00";

    private static final String KZKTOUROKU_KBNINIT_1 = "0";

    private static final String KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1 = "01";

    private static final String KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN2 = "02";

    private static final String KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN3= "03";

    private static final String KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN4 = "04";

    private static final String KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN5 = "05";

    private static final String KZKTOUROKU_AISTMSGKBN1 = "01";

    private static final String KZKTOUROKU_AISTMSGKBN2 = "02";

    private static final String KZKTOUROKU_AISTMSGKBN3 = "03";

    private static final String KZKTOUROKU_AISTMSGKBN4 = "04";

    private static final String KZKTOUROKU_AISTMSGKBN5 = "05";

    private static final String KZKTOUROKU_AISTMSGKBN6 = "06";

    private static final String KZKTOUROKU_AISTMSGKBN7 = "07";

    private static final String KZKTOUROKU_AISTMSGKBN8 = "08";

    private static final String KZKTOUROKU_AISTMSGKBN9 = "09";

    private static final String KZKTOUROKU_AISTMSGKBN10 = "10";

    private static final String KZKTOUROKU_AISTMSGKBN11 = "11";

    private static final String KZKTOUROKU_AISTMSGKBN21 = "21";

    private static final String KZKTOUROKU_AISTMSGKBN22 = "22";

    private static final String KZKTOUROKU_AISTMSGKBN23 = "23";

    private static final String KZKTOUROKU_AISTMSGKBN24 = "24";

    private static final String KZKTOUROKU_AISTMSGKBN25 = "25";

    private static final String KZKTOUROKU_AISTMSGKBN27 = "27";

    private static final String KZKTOUROKU_AISTMSGKBN28 = "28";

    private static final String KZKTOUROKU_AISTMSGKBN29 = "29";

    private static final String KZKTOUROKU_AISTMSGKBN31 = "31";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN1 = "01";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN2 = "02";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN3 = "03";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN4 = "04";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN5 = "05";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN6 = "06";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN7 = "07";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN8 = "08";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN9 = "09";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN10 = "10";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN11 = "11";

    private static final String KZKTOUROKU_TTDKNAIYOUKBN12 = "12";

    private static final String KZKTOUROKU_KZKTAISYOUKYKKBN1 = "1";

    private static final String KZKTOUROKU_KZKTAISYOUKYKKBN2 = "2";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN1 = "01";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN2 = "02";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN3 = "03";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN11 = "11";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN12 = "12";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN13 = "13";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN14 = "14";

    private static final String KZKTOUROKU_KYKDRMSGKBN3 = "03";

    private static final String KZKTOUROKU_KYKDRMSGKBN6 = "06";

    private static final String KZKTOUROKU_KYKDRMSGKBN7 = "07";

    private static final String KZKTOUROKU_HHKDRMSG1 = "01";

    private static final String KZKTOUROKU_HHKDRMSG2 = "02";

    private static final String KZKTOUROKU_HHKDRMSG11 = "11";

    private static final String KZKTOUROKU_DUHUBUTUMSG1 = "01";

    private static final String KZKTOUROKU_DUHUBUTUMSG2 = "02";

    private static final String KZKTOUROKU_DUHUBUTUMSG3 = "03";

    private static final String KZKTOUROKU_DUHUBUTUMSG4 = "04";

    private static final String KZKTOUROKU_DUHUBUTUMSG5 = "05";

    private static final String KZKTOUROKU_DUHUBUTUMSG6 = "06";

    private static final String KZKTOUROKU_DUHUBUTUMSG7 = "07";

    private static final String KZKTOUROKU_DUHUBUTUMSG8 = "08";

    private static final String KZKTOUROKU_DUHUBUTUMSG9 = "09";

    private static final String KZKTOUROKU_DUHUBUTUMSG11 = "11";

    private static final String KZKTOUROKU_DUHUBUTUMSG12 = "12";

    private static final String KZKTOUROKU_DUHUBUTUMSG50 = "50";

    private static final String KZKTOUROKU_HUNYUUHYOUJI0 = "0";

    private static final String KZKTOUROKU_HUNYUUHYOUJI1 = "1";

    @Inject
    private CreateReport createReport;

    @Inject
    private EditTtdkKanryouTblDao editTtdkKanryouTblDao;

    public EditTtdkKanryouTbl() {
        super();
    }

    public IT_TtdkKan editTBL(KhozenCommonParam pKcp,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pKykSyouhnLst,
        IT_KykSya pKykSya,
        IT_HhknSya pHhknSya,
        EditTtdkKanryouParam pParam,
        IT_KhShrRireki pKhShrRireki,
        IT_KhHasseijiKazeiRireki pKhHasseijiKazeiRireki,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        BizDate pDispsyoriymd,
        C_HassouKbn pHassouKbn,
        C_SyoruiCdKbn pSyoruiCd) {

        if (pKykSyouhnLst == null || pKykSyouhnLst.size() == 0) {
            return null;
        }

        C_TetudukisyuKbn tetudukisyuKbn = pParam.getTetudukiSyu();

        String shskyNo = "";

        String shadr1Kj = "";

        String shadr2Kj = "";

        String shadr3Kj = "";

        String shsNmKj = "";

        C_Kaiyakujiyuu kaiyakuJiyuu = pParam.getKaiyakuJiyuu();

        BizDate kaiykymd = null;

        String mousideNaiyou1 = "";

        String mousideNaiyou2 = "";

        String mousideNaiyou3 = "";

        String mousideNaiyou4 = "";

        String mousideNaiyou5 = "";

        String mousideNaiyou6 = "";

        String mousideNaiyou7 = "";

        String mousideNaiyou8 = "";

        String mousideNaiyou9 = "";

        String mousideNaiyou10 = "";

        C_UmuKbn mousideNaiyouUmuKbn = C_UmuKbn.NONE;

        C_UmuKbn ttdknaiyouumukbn = C_UmuKbn.NONE;

        String ttdknaiyou1 = "";

        String ttdknaiyou2 = "";

        String ttdknaiyou3 = "";

        String ttdknaiyou4 = "";

        String ttdknaiyou5 = "";

        String ttdknaiyou6 = "";

        String ttdknaiyou7 = "";

        String ttdknaiyou8 = "";

        String ttdknaiyou9 = "";

        String ttdknaiyou10 = "";

        C_OsiraseinjihuyouKbn osiraseinjihuyouhyouji = C_OsiraseinjihuyouKbn.YOU;

        List<String> tekiyouLst = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            tekiyouLst.add("");
        }

        List<C_HugouKbn> kngkmeisaihugouLst = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            kngkmeisaihugouLst.add(C_HugouKbn.SEI);
        }

        List<BizCurrency> kngkMeisaiLst   = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            kngkMeisaiLst.add(BizCurrency.valueOf(0));
        }

        List<C_Tuukasyu> kngkmisituukasyuLst   = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            kngkmisituukasyuLst.add(C_Tuukasyu.BLNK);
        }

        List<String> bikouLst = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            bikouLst.add("");
        }

        String dSeisanShrTtdkNm = pParam.getDseisantetudukimeiKbn().getContent();

        C_DseisansouhusakihnsyuKbn dSeisanSouhusakiHnsyuKbn = pParam.getDseisansouhusakihnsyuKbn();

        C_YouhiKbn atesakiHensyuYh = C_YouhiKbn.YOU;

        C_ZeitratkiKbn dseisanzeitratkiKbn = pParam.getDseisanzeitratkiKbn();

        C_Syoumetujiyuu syoumetujiyuu = pKykSyouhnLst.get(0).getSyoumetujiyuu();

        String shrnaiyouhskmongon1 = "";

        String shrnaiyouhskmongon2 = "";

        String shrTuukaNm = "";

        C_SyoruiCdKbn syoruiCd = pSyoruiCd;

        C_HassouKbn hassouKbn = pHassouKbn;

        C_TantousituKbn tantousituKbn = C_TantousituKbn.BLNK;

        C_Tantositucd tantousitucd = C_Tantositucd.BLNK0;

        String ccSosikiCd = YuyuBizConfig.getInstance().getCallcentersosikicd();

        BizCurrency synykngk = BizCurrency.valueOf(0);

        BizCurrency htykeihi = BizCurrency.valueOf(0);

        BizCurrency shrkykhtykeihi = BizCurrency.valueOf(0);

        BizCurrency gsbnrkztsaeki = BizCurrency.valueOf(0);

        List<String> zeimumongonLst   = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            zeimumongonLst.add("");
        }

        C_ZeimuNaiyouHnsyuCtrlKbn zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.BLNK;

        C_UmuKbn zeimumongonoutkbn = C_UmuKbn.NONE;

        String osirasemongonhyoudai = "";

        List<String> osirasemongonLst   = new ArrayList<>();

        for (int i = 0; i < 35; i++) {
            osirasemongonLst.add("");
        }

        Integer kykhnkkaisuu = 0;

        C_KykniyuhenkouKbn kykniyuhnkkbn = C_KykniyuhenkouKbn.BLNK;

        BizDate kykniyuhnkymd   = null;

        String kykniyuhnkinfo = "";

        C_HugouKbn kykniyuhnkgkhugou1   = C_HugouKbn.SEI;

        BizCurrency kykniyuhnkkngk1 = BizCurrency.valueOf(0);

        C_Tuukasyu kykniyuhnkkngktuksyu1 = C_Tuukasyu.BLNK;

        C_HugouKbn kykniyuhnkkngkhugou2   = C_HugouKbn.SEI;

        BizCurrency kykniyuhnkkngk2 = BizCurrency.valueOf(0);

        C_Tuukasyu kykniyuhnkkngktuksyu2 = C_Tuukasyu.BLNK;

        String toritugisyasyozokunm = "";

        String toritugisyakjncd   = "";

        String toritugisyanm = "";

        C_UmuKbn gsbunritaisyouFlg = pParam.getGsbunritaisyouFlg();

        C_TrkKzkKbn trkkzkkbn1 = C_TrkKzkKbn.BLNK;

        String trkkzknmkj1 = "";

        BizDate trkkzkseiymd1 = null;

        String trkkzkyno1 = "";

        String trkkzkadr1kj1 = "";

        String trkkzkadr2kj1 = "";

        String trkkzkadr3kj1 = "";

        String trkkzktelno1 = "";

        C_TrkKzkKbn trkkzkkbn2 = C_TrkKzkKbn.BLNK;

        String trkkzknmkj2 = "";

        BizDate trkkzkseiymd2 = null;

        String trkkzkyno2 = "";

        String trkkzkadr1kj2 = "";

        String trkkzkadr2kj2 = "";

        String trkkzkadr3kj2 = "";

        String trkkzktelno2 = "";

        String kykomttutkbn = KZKTOUROKU_KBNINIT;

        String kykurtutkbn = KZKTOUROKU_KBNINIT;

        String kzkomttutkbn1 = KZKTOUROKU_KBNINIT;

        String kzkurtutkbn1 = KZKTOUROKU_KBNINIT;

        String kzkomttutkbn2 = KZKTOUROKU_KBNINIT;

        String kzkurtutkbn2 = KZKTOUROKU_KBNINIT;

        String hhkomttutkbn = KZKTOUROKU_KBNINIT;

        String kykdromttutkbn = KZKTOUROKU_KBNINIT;

        String kykaistmsgkbn = KZKTOUROKU_KBNINIT;

        String kzkaistmsgkbn1 = KZKTOUROKU_KBNINIT;

        String kzkaistmsgkbn2 = KZKTOUROKU_KBNINIT;

        String hhkaistmsgkbn = KZKTOUROKU_KBNINIT;

        String sakujyokzknmkj = "";

        String ttdknaiyoukbn = KZKTOUROKU_KBNINIT;

        String kzktaisyoukykkbn = KZKTOUROKU_KBNINIT_1;

        String moshnkniymsgkbn1 = KZKTOUROKU_KBNINIT;

        String kykmoshnkniymsg2 = KZKTOUROKU_KBNINIT;

        String kzkmoshnkniymsg21 = KZKTOUROKU_KBNINIT;

        String kzkmoshnkniymsg22 = KZKTOUROKU_KBNINIT;

        String kykdrmsgkbn = KZKTOUROKU_KBNINIT;

        String kykhhkdrmsg = KZKTOUROKU_KBNINIT;

        String kzkhhkdrmsg1 = KZKTOUROKU_KBNINIT;

        String kzkhhkdrmsg2 = KZKTOUROKU_KBNINIT;

        String duhubutumsg1 = KZKTOUROKU_KBNINIT;

        String duhubutumsg2 = KZKTOUROKU_KBNINIT;

        String duhubutumsg3 = KZKTOUROKU_KBNINIT;

        String duhubutumsg4 = KZKTOUROKU_KBNINIT;

        String duhubutumsg5 = KZKTOUROKU_KBNINIT;

        String duhubutumsg6 = KZKTOUROKU_KBNINIT;

        String duhubutumsg7 = KZKTOUROKU_KBNINIT;

        String yakkankiyakuhunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI0;

        String kyktrktrshuunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI0;

        String kzktrktrshuunyuuhyouji1 = KZKTOUROKU_HUNYUUHYOUJI0;

        String kzktrktrshuunyuuhyouji2 = KZKTOUROKU_HUNYUUHYOUJI0;

        String kykdrhuunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI0;

        String hhkdrhuunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI0;

        C_UmuKbn hnsnhutouhuunyuuhyouji = C_UmuKbn.NONE;

        String bankCd = "";

        String sitenCd = "";

        String bankNmKj = "";

        String sitenNmKj = "";

        C_YokinKbn yokinKbn = C_YokinKbn.BLNK;

        C_KouzasyuruiKbn kzsyuruikbn = C_KouzasyuruiKbn.BLNK;

        String kouzaNo = "";

        String kzMeigiNmKn = "";

        String kykdairinmkj2 = "";

        if (C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR.eq(syoruiCd)) {

            if (C_MousideninKbn.TRKKZK1.eq(pParam.getMousideninKbn()) &&
                C_TrkKzkHnkKbn.HENKOU.eq(pParam.getTrkKzkHnkNiyuKbn1())) {

                return null;
            }
            else if (C_MousideninKbn.TRKKZK2.eq(pParam.getMousideninKbn()) &&
                C_TrkKzkHnkKbn.HENKOU.eq(pParam.getTrkKzkHnkNiyuKbn2())) {

                return null;
            }
        }

        int syouhnhanteiKbn = SyouhinUtil.hantei(pKykSyouhnLst.get(0).getSyouhncd());

        IT_TtdkKan ttdkKan = pKykKihon.createTtdkKan();

        String henkousikibetuKey = pKcp.getSikibetuKey(pKykKihon.getSyono());

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(henkousikibetuKey);

        List<IT_KykSyaHenkouRireki> kykSyaHenkouRirekiLst = khTtdkRireki.getKykSyaHenkouRirekis();

        IT_KhTtdkTyuui khTtdkTyuui = pKykKihon.getKhTtdkTyuui();

        List<IT_TrkKzk> trkKzksList = pKykKihon.getTrkKzks();

        for (IT_TrkKzk trkKzk : trkKzksList) {
            if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {
                trkkzkkbn1 = trkKzk.getTrkkzkkbn();

                trkkzknmkj1 = trkKzk.getTrkkzknmkj();

                trkkzkseiymd1 = trkKzk.getTrkkzkseiymd();

                trkkzkyno1 = trkKzk.getTrkkzkyno();

                trkkzkadr1kj1 = trkKzk.getTrkkzkadr1kj();

                trkkzkadr2kj1 = trkKzk.getTrkkzkadr2kj();

                trkkzkadr3kj1 = trkKzk.getTrkkzkadr3kj();

                trkkzktelno1 = trkKzk.getTrkkzktelno();

            }
            else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {
                trkkzkkbn2 = trkKzk.getTrkkzkkbn();

                trkkzknmkj2 = trkKzk.getTrkkzknmkj();

                trkkzkseiymd2 = trkKzk.getTrkkzkseiymd();

                trkkzkyno2 = trkKzk.getTrkkzkyno();

                trkkzkadr1kj2 = trkKzk.getTrkkzkadr1kj();

                trkkzkadr2kj2 = trkKzk.getTrkkzkadr2kj();

                trkkzkadr3kj2 = trkKzk.getTrkkzkadr3kj();

                trkkzktelno2 = trkKzk.getTrkkzktelno();

            }
        }

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

        GetKhKykdrInfoBean khKykdrInfoBean = getKhKykdrInfo.exec(pKykKihon);

        if ((C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR.eq(syoruiCd) ||
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI.eq(syoruiCd)) &&
            C_DseisansouhusakihnsyuKbn.HENSYUUNASI.eq(dSeisanSouhusakiHnsyuKbn)) {

            atesakiHensyuYh = C_YouhiKbn.HUYOU;
        }

        if (C_YouhiKbn.YOU.eq(atesakiHensyuYh)) {

            if (C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCd)) {

                if (C_Kaiyakujiyuu.TUUJYOU.eq(kaiyakuJiyuu) || C_Kaiyakujiyuu.SKS.eq(kaiyakuJiyuu)) {

                    if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {

                        shskyNo = khKykdrInfoBean.getKykdryNo();

                        shadr1Kj = khKykdrInfoBean.getKykdradr1();

                        shadr2Kj = khKykdrInfoBean.getKykdradr2();

                        shadr3Kj = khKykdrInfoBean.getKykdradr3();
                    }
                    else {

                        shskyNo = pKykSya.getTsinyno();

                        shadr1Kj = pKykSya.getTsinadr1kj();

                        shadr2Kj = pKykSya.getTsinadr2kj();

                        shadr3Kj = pKykSya.getTsinadr3kj();
                    }
                }
                else if(C_Kaiyakujiyuu.KYKSB.eq(kaiyakuJiyuu)) {

                    shskyNo = pParam.getShsyno();

                    shadr1Kj = pParam.getShsadr1kj();

                    shadr2Kj = pParam.getShsadr2kj();

                    shadr3Kj = pParam.getShsadr3kj();
                }
            }
            else if (C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR.eq(syoruiCd) && C_Kaiyakujiyuu.SKS.eq(kaiyakuJiyuu)) {

                if (!BizUtil.isBlank(pParam.getShsyno())) {

                    shskyNo = pParam.getShsyno();

                    shadr1Kj = pParam.getShsadr1kj();

                    shadr2Kj = pParam.getShsadr2kj();

                    shadr3Kj = pParam.getShsadr3kj();
                }

            }

            else if (C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR.eq(syoruiCd)) {

                if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {

                    shskyNo = khKykdrInfoBean.getKykdryNo();

                    shadr1Kj = khKykdrInfoBean.getKykdradr1();

                    shadr2Kj = khKykdrInfoBean.getKykdradr2();

                    shadr3Kj = khKykdrInfoBean.getKykdradr3();
                }
                else {
                    shskyNo = pKykSya.getTsinyno();

                    shadr1Kj = pKykSya.getTsinadr1kj();

                    shadr2Kj = pKykSya.getTsinadr2kj();

                    shadr3Kj = pKykSya.getTsinadr3kj();
                }

            }
            else {

                if (!BizUtil.isBlank(pParam.getShsyno())) {

                    shskyNo = pParam.getShsyno();

                    shadr1Kj = pParam.getShsadr1kj();

                    shadr2Kj = pParam.getShsadr2kj();

                    shadr3Kj = pParam.getShsadr3kj();
                }
                else {

                    if (C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR.eq(syoruiCd) ||
                        C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR.eq(syoruiCd) ||
                        C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3.eq(syoruiCd) ||
                        C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2.eq(syoruiCd)) {

                        shskyNo = pKykSya.getTsinyno();

                        shadr1Kj = pKykSya.getTsinadr1kj();

                        shadr2Kj = pKykSya.getTsinadr2kj();

                        shadr3Kj = pKykSya.getTsinadr3kj();
                    }
                    else {

                        if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {

                            shskyNo = khKykdrInfoBean.getKykdryNo();

                            shadr1Kj = khKykdrInfoBean.getKykdradr1();

                            shadr2Kj = khKykdrInfoBean.getKykdradr2();

                            shadr3Kj = khKykdrInfoBean.getKykdradr3();
                        }
                        else {

                            shskyNo = pKykSya.getTsinyno();

                            shadr1Kj = pKykSya.getTsinadr1kj();

                            shadr2Kj = pKykSya.getTsinadr2kj();

                            shadr3Kj = pKykSya.getTsinadr3kj();
                        }
                    }
                }
            }

            if (C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCd)) {

                if (C_Kaiyakujiyuu.TUUJYOU.eq(kaiyakuJiyuu) || C_Kaiyakujiyuu.SKS.eq(kaiyakuJiyuu)) {

                    if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {

                        shsNmKj = khKykdrInfoBean.getKkdairinmKj();
                    }
                    else {

                        shsNmKj = pKykSya.getKyknmkj();
                    }
                }
                else if (C_Kaiyakujiyuu.KYKSB.eq(kaiyakuJiyuu)) {

                    shsNmKj = pParam.getShsnmkj();
                }

            }
            else if (C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR.eq(syoruiCd) && C_Kaiyakujiyuu.SKS.eq(kaiyakuJiyuu)) {

                if (!BizUtil.isBlank(pParam.getShsnmkj())) {

                    shsNmKj = pParam.getShsnmkj();
                }
            }
            else if (C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR.eq(syoruiCd)) {

                if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {

                    shsNmKj = khKykdrInfoBean.getKkdairinmKj();
                }
                else {

                    shsNmKj = pKykSya.getKyknmkj();
                }
            }

            else {

                if (!BizUtil.isBlank(pParam.getShsnmkj())) {

                    shsNmKj = pParam.getShsnmkj();
                }
                else {

                    if (C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR.eq(syoruiCd) ||
                        C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR.eq(syoruiCd) ||
                        C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3.eq(syoruiCd) ||
                        C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2.eq(syoruiCd)) {

                        shsNmKj = pKykSya.getKyknmkj();
                    }
                    else {

                        if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {

                            shsNmKj = khKykdrInfoBean.getKkdairinmKj();
                        }
                        else {

                            shsNmKj = pKykSya.getKyknmkj();
                        }
                    }
                }
            }
        }
        String sosikiCd = "";

        if (C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR.eq(syoruiCd) ||
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI.eq(syoruiCd)) {

            if (C_DseisantetudukimeiKbn.KAIYAKU.eq(pParam.getDseisantetudukimeiKbn()) &&
                C_Kaiyakujiyuu.SKS.eq(kaiyakuJiyuu)) {

                tantousitucd = C_Tantositucd.HOZENSIHARAISV;

                sosikiCd = tantousitucd + "0000";
            }
            else if (C_DseisantetudukimeiKbn.SIBOU.eq(pParam.getDseisantetudukimeiKbn()) &&
                (C_Syoumetujiyuu.SBKAIJO.eq(syoumetujiyuu) ||
                    C_Syoumetujiyuu.MENSEKI.eq(syoumetujiyuu))) {

                tantousitucd = C_Tantositucd.SIHARAIGYOUMU;

                sosikiCd = tantousitucd + "0000";
            }
            else {

                sosikiCd = ccSosikiCd;
            }
        }
        else if (C_Kaiyakujiyuu.SKS.eq(kaiyakuJiyuu)
            || C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR.eq(syoruiCd)
            || C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR.eq(syoruiCd)
            || C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR.eq(syoruiCd)) {

            sosikiCd = pKcp.getTmSosikiCd();
        }
        else {

            sosikiCd = ccSosikiCd;
        }

        String hknkaisyanmkj = YuyuBizConfig.getInstance().getHokenKaisyaNmKanji();

        BzGetSosikiMadogutiInfo getSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean sosikiCdGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(sosikiCd);

        String toiawaseSosikiNmKj = sosikiCdGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm();

        String toiawaSeyNo = sosikiCdGetSosikiMadogutiInfoKekkaBean.getPostalCd();

        String toiawaseAdr1Kj = sosikiCdGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1();

        String toiawaseAdr2Kj = sosikiCdGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2();

        String toiawaseAdr3Kj = sosikiCdGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3();

        String toiawasekaisyanmkj = hknkaisyanmkj;

        String toiawaseTelNo = sosikiCdGetSosikiMadogutiInfoKekkaBean.getTelno();

        String toiawaseTelUktkKanou1 = "";

        String toiawaseTelUktkKanou2 = "";

        if (ccSosikiCd.equals(sosikiCd)) {

            toiawaseTelUktkKanou1 = YuyuBizConfig.getInstance().getUketimecallcenter1();

            toiawaseTelUktkKanou2 = YuyuBizConfig.getInstance().getUketimecallcenter2();
        }
        else {

            toiawaseTelUktkKanou1 = YuyuBizConfig.getInstance().getUketimetantousitu1();

            toiawaseTelUktkKanou2 = YuyuBizConfig.getInstance().getUketimetantousitu2();
        }
        if (C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCd) ||
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR.eq(syoruiCd) ||
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI.eq(syoruiCd)) {

            tantousituKbn = C_TantousituKbn.HOZENSIHARAISV;
        }
        else if (C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR.eq(syoruiCd)
            || C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR.eq(syoruiCd)
            || C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR.eq(syoruiCd)) {

            tantousituKbn = C_TantousituKbn.DAIRITENJIMUSV;
        }
        else if (C_SyoruiCdKbn.KK_DSHR_TTDKKR.eq(syoruiCd)) {

            tantousituKbn = C_TantousituKbn.SYUUNOUSV;
        }
        else {

            tantousituKbn = C_TantousituKbn.HOZENHENKOUSV;
        }

        ttdkKan.setSyono(pKykKihon.getSyono());

        ttdkKan.setHenkousikibetukey(pKcp.getSikibetuKey(pKykKihon.getSyono()));

        ttdkKan.setSyoruiCd(syoruiCd);

        ttdkKan.setTyouhyouymd(pDispsyoriymd);

        ttdkKan.setHassoukbn(hassouKbn);

        ttdkKan.setTantousitukbn(tantousituKbn);

        ttdkKan.setSyoukendhumukbn(pParam.getSyokenDoufuUmu());

        ttdkKan.setShskyno(shskyNo);

        ttdkKan.setShsadr1kj(shadr1Kj);

        ttdkKan.setShsadr2kj(shadr2Kj);

        ttdkKan.setShsadr3kj(shadr3Kj);

        ttdkKan.setShsnmkj(shsNmKj);

        ttdkKan.setToiawasesosikinmkj(toiawaseSosikiNmKj);

        ttdkKan.setToiawaseyno(toiawaSeyNo);

        ttdkKan.setToiawaseadr1kj(toiawaseAdr1Kj);

        ttdkKan.setToiawaseadr2kj(toiawaseAdr2Kj);

        ttdkKan.setToiawaseadr3kj(toiawaseAdr3Kj);

        ttdkKan.setToiawasekaisyanmkj(toiawasekaisyanmkj);

        ttdkKan.setToiawasetelno(toiawaseTelNo);

        ttdkKan.setToiawaseteluktkkanou1(toiawaseTelUktkKanou1);

        ttdkKan.setToiawaseteluktkkanou2(toiawaseTelUktkKanou2);

        ttdkKan.setShrumu(pParam.getSiharaiUmu());

        ttdkKan.setSyorikbn(pParam.getSyorikbn());

        ttdkKan.setKyknmkj(pKykSya.getKyknmkj());

        ttdkKan.setKykymd(pKykSyouhnLst.get(0).getKykymd());

        ttdkKan.setSyouhnnm(pKykSyouhnLst.get(0).getSyouhnZokusei().getSyouhnnmsyouken());

        ttdkKan.setHhknnmkj(pHhknSya.getHhknnmkj());

        ttdkKan.setKaiyakujiyuu(kaiyakuJiyuu);

        ttdkKan.setGyoumuKousinKinou(pKcp.getFunctionId());

        ttdkKan.setGyoumuKousinsyaId(pKcp.getUserID());

        if (C_UmuKbn.ARI.eq(pParam.getYuuyokknTyoukaUmu())){
            ttdkKan.setTetudukisyukbn(C_TetudukisyuKbn.HARAIMODOSISHR);
        } else {
            ttdkKan.setTetudukisyukbn(tetudukisyuKbn);
        }

        ttdkKan.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        if (C_SyoruiCdKbn.KK_NKTKYKHNK_TTDKKR.eq(syoruiCd)) {

            String nkSyuruiNm = C_Nenkinsyu.getContentByValue(C_Nenkinsyu.PATTERN_DEFAULT,
                pKykSyouhnLst.get(0).getNksyukbn().getValue());

            if (C_TetudukisyuKbn.NKTKYKHUKA.eq(tetudukisyuKbn)) {

                String uktNmKj = "";

                if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getSbhkuktumu())) {

                    uktNmKj = KBSIBOUS;
                }
                else if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getSbkyuuhukinuktumu())) {

                    uktNmKj = KBSBUKYHKN;
                }

                mousideNaiyou1 = NKSHRTKYKHNKKB1;

                mousideNaiyou2 = KBZENKAKUSPACE +
                    ConvertUtil.toZenAll(pKykSyouhnLst.get(0).getNenkinkkn().toString(), 0, 0) +
                    KBNEN +
                    nkSyuruiNm;

                mousideNaiyou3 = NKSHRTKYKHNKKB2 + KBZENKAKUSPACE + KBZENKAKUSPACE + uktNmKj + KBSAMA;

                mousideNaiyou4 = KBZENKAKUSPACE + uktNmKj + NKSHRTKYKHNKKB4;

                mousideNaiyou5 = NKSHRTKYKHNKKB5;

                mousideNaiyou6 = KBKAKUNINJIKOU;

                mousideNaiyou7 = NKSHRTKYKHNKKB6;

                mousideNaiyou8 = KBHOKAN;
            }
            else if (C_TetudukisyuKbn.NKTKYKHENKOU.eq(tetudukisyuKbn)) {

                String bfrNkSyuruiNm = C_Nenkinsyu.getContentByValue(C_Nenkinsyu.PATTERN_DEFAULT,
                    pParam.getBfrNenkinsyu().getValue());

                mousideNaiyou1 = NKSHRTKYKHNKKB7 + bfrNkSyuruiNm +
                    ConvertUtil.toZenAll(pParam.getBfrNenkinkkn().toString(), 0, 0) +
                    NKSHRTKYKHNKKB8 + nkSyuruiNm +
                    ConvertUtil.toZenAll(pKykSyouhnLst.get(0).getNenkinkkn().toString(), 0, 0) +
                    NKSHRTKYKHNKKB9;
            }
            else if (C_TetudukisyuKbn.NKTKYKKAIYAKU.eq(tetudukisyuKbn)) {

                mousideNaiyou1 = NKSHRTKYKHNKKB10;
            }

            mousideNaiyouUmuKbn = C_UmuKbn.ARI;
        }
        else if (C_SyoruiCdKbn.KK_TARGETHNK_TTDKKR.eq(syoruiCd)) {

            String targetTkNm = C_TargetTkKbn.getContentByValue(C_TargetTkKbn.PATTERN_DEFAULT,
                pKykSonotaTkyk.getTargettkkbn().getValue());

            if (C_TetudukisyuKbn.TARGETSYUUSINHENKOU.eq(tetudukisyuKbn) ||
                C_TetudukisyuKbn.TARGETNKHENKOU.eq(tetudukisyuKbn)) {

                mousideNaiyou1 = KBZENKAKUSPACE + targetTkNm + TARGETTKKB1 +
                    ConvertUtil.toZenAll(pParam.getBfrTargettkmokuhyouti().toString(), 0, 0) +
                    TARGETTKKB2 +
                    ConvertUtil.toZenAll(pKykSonotaTkyk.getTargettkmokuhyouti().toString(), 0, 0) +
                    TARGETTKKB3;
            }
            else {

                mousideNaiyou1 = KBZENKAKUSPACE + targetTkNm + TARGETTKKB4;
            }

            mousideNaiyouUmuKbn = C_UmuKbn.ARI;
        }
        else if (C_SyoruiCdKbn.KK_STDRHNK_TTDKKR.eq(syoruiCd)) {

            if (C_UktKbn.NASI.eq(pParam.getStdruktkbn())) {

                ttdknaiyou1 = STDRSKTKYHUKAKB6;
            }
            else if (C_KjkhukaKbn.BLNK.eq(pParam.getStdrskKjkhuka())) {

                ttdknaiyou1 = STDRSKTKYHUKAKB1 + pParam.getStdrsknmkj() +
                    KBZENKAKUSPACE + KBSAMA + STDRSKTKYHUKAKB7;
            }
            else {

                ttdknaiyou1 = STDRSKTKYHUKAKB1 + pParam.getStdrsknmkn() +
                    KBZENKAKUSPACE + KBSAMA + STDRSKTKYHUKAKB7;
            }

            ttdknaiyou2 = STDRSKTKYHUKAKB2;

            ttdknaiyou3 = STDRSKTKYHUKAKB3;

            ttdknaiyou4 = STDRSKTKYHUKAKB4;

            ttdknaiyou6 = KBKAKUNINJIKOU;

            ttdknaiyou7 = STDRSKTKYHUKAKB5;

            ttdknaiyou8 = KBHOKAN;

            ttdknaiyouumukbn = C_UmuKbn.ARI;
        }
        else if (C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR.eq(syoruiCd) ||
            C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI.eq(syoruiCd)) {

            String seiYMD = FixedDateFormatter.formatYMDZenkakuWarekiKanji(pHhknSya.getHhknseiymd());

            String seibetuNm = C_Seibetu.getContentByValue(C_Seibetu.PATTERN_DEFAULT,
                pHhknSya.getHhknsei().getValue());

            if (C_UmuKbn.ARI.eq(pParam.getHhknseiymdHnUmu()) && C_UmuKbn.ARI.eq(pParam.getHhknseiHnUmu())) {

                ttdknaiyou1 = SEIYMDSEITSKB1 + seiYMD + KBZENKAKUSPACE + seibetuNm + SEIYMDSEITSKB2;
            }
            else if (C_UmuKbn.ARI.eq(pParam.getHhknseiymdHnUmu()) && C_UmuKbn.NONE.eq(pParam.getHhknseiHnUmu())) {

                ttdknaiyou1 = SEIYMDSEITSKB3 + seiYMD + SEIYMDSEITSKB2;
            }
            else if (C_UmuKbn.ARI.eq(pParam.getHhknseiHnUmu())) {

                ttdknaiyou1 = SEIYMDSEITSKB4 + seibetuNm + SEIYMDSEITSKB2;
            }

            if (C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI.eq(syoruiCd)) {
                String calcKijyunYMD = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pParam.getCalckijyunYMD());

                ttdknaiyou2 = SEIYMDSEITSKB5 + calcKijyunYMD;
            }

            ttdknaiyouumukbn = C_UmuKbn.ARI;
        }
        else if (C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.eq(syoruiCd) || C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR.eq(syoruiCd)) {

            String calcKijyunYMD = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pParam.getCalckijyunYMD());

            String kihonSsyurui = C_KihonssyuruiKbn.getContentByValue(C_KihonssyuruiKbn.PATTERN_REPORT, pKykSyouhnLst.get(0).getSyouhnZokusei().getKihonssyuruikbn().getValue());

            String kihonS = ViewReport.editCommaTuuka(pKykSyouhnLst.get(0).getKihons(), BizUtil.ZERO_FILL);

            String kjnkngk = ViewReport.editCommaTuuka(pKykSyouhnLst.get(0).getPharaikomisougaku(), BizUtil.ZERO_FILL);

            String hokenryou = ViewReport.editCommaTuuka(pKykSyouhnLst.get(0).getHokenryou(), BizUtil.ZERO_FILL);

            String zitkazukarikingk = ConvertUtil.convZenHan(
                IDataConvert.iCONVERT_H2Z_ALL,
                String.format("%21s",
                    ViewReport.editCommaTuuka(pKhShrRireki.getZitkazukarikingksiteituuka(), BizUtil.ZERO_FILL)));

            String sonotashrkngk = ConvertUtil.convZenHan(
                IDataConvert.iCONVERT_H2Z_ALL,
                String.format("%19s",
                    ViewReport.editCommaTuuka(pKhShrRireki.getZitkazukarikingkyen(), BizUtil.ZERO_FILL)));

            BizCurrency mikeikapSyoukei = pKhShrRireki.getYenmikeikap().add(pKhShrRireki.getYenzennomikeikap());

            String mikeikap = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,
                String.format("%19s", ViewReport.editCommaTuuka(mikeikapSyoukei, BizUtil.ZERO_FILL)));

            BizCurrency sonotaseisanSyoukei = pKhShrRireki.getYenkansanhaitoukin().add(
                pKhShrRireki.getYensonotahaitoukin());

            String sonotaseisan = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,
                String.format("%19s", ViewReport.editCommaTuuka(sonotaseisanSyoukei, BizUtil.ZERO_FILL)));

            if (C_GengkhouKbn.SD.eq(pParam.getGengkhou())) {

                ttdknaiyou1 =  KBZENKAKUSPACE + kihonSsyurui+ GENGKKB1 + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, kihonS) + GENGKKB3;

                ttdknaiyou2 = GENGKKB4 + calcKijyunYMD;
            }
            else if (C_GengkhouKbn.PD.eq(pParam.getGengkhou())) {

                if (C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(pKykSonotaTkyk.getYennyknsyuruikbn())) {

                    ttdknaiyou1 = GENGKKB5 + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, kjnkngk) + GENGKKB3;

                    ttdknaiyou2 = GENGKKB6 + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, hokenryou) + GENGKKB7;

                    ttdknaiyou3 = GENGKKB4 + calcKijyunYMD;
                }
                else {

                    ttdknaiyou1 = GENGKKB15 + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, hokenryou) + GENGKKB3;

                    ttdknaiyou2 = KBKAKKOSTART + KBZENKAKUSPACE + kihonSsyurui + GENGKKB1
                        + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, kihonS) + GENGKKB3 + KBKAKKOEND;

                    ttdknaiyou3 = GENGKKB4 + calcKijyunYMD;
                }
            }
            if (C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR.eq(syoruiCd)) {

                ttdknaiyou4 = GENGKKB8;

                ttdknaiyou5 = GENGKKB9;

                ttdknaiyou6 = GENGKKB10;

                ttdknaiyou7 = GENGKKB11 + zitkazukarikingk;

                if (pKhShrRireki.getZitkazukarikingkyen().compareTo(
                    BizCurrency.valueOf(0, pKhShrRireki.getZitkazukarikingkyen().getType())) > 0) {

                    ttdknaiyou8 = GENGKKB12 + sonotashrkngk;

                    if (mikeikapSyoukei.compareTo(BizCurrency.valueOf(0, mikeikapSyoukei.getType())) > 0) {

                        ttdknaiyou9 = GENGKKB13 + mikeikap;

                        if (sonotaseisanSyoukei.compareTo(BizCurrency.valueOf(0, sonotaseisanSyoukei.getType())) > 0) {

                            ttdknaiyou10 = GENGKKB14 + sonotaseisan;
                        }
                    }
                    else if (sonotaseisanSyoukei.compareTo(BizCurrency.valueOf(0, sonotaseisanSyoukei.getType())) > 0) {

                        ttdknaiyou9 = GENGKKB14 + sonotaseisan;
                    }
                }
            }

            ttdknaiyouumukbn = C_UmuKbn.ARI;
        }
        else if (C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR.eq(syoruiCd)) {

            if (C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA.eq(pParam.getTetudukiSyu())) {

                ttdknaiyou1 = KBZENKAKUSPACE + KBKAKUNINJIKOU;

                ttdknaiyou2 = HENKOUKB1;

                ttdknaiyou3 = KBHOKAN;
            }
        }
        else if (C_SyoruiCdKbn.KK_SHRKZHNK_TTDKKR.eq(syoruiCd)) {

            IT_TeikikinKouza teikikinKouza = pKcp.getTeikikinKouza(pKykKihon.getSyono());

            kzMeigiNmKn = teikikinKouza.getKzmeiginmkn();

            bankCd = teikikinKouza.getBankcd();

            sitenCd = teikikinKouza.getSitencd();

            yokinKbn = teikikinKouza.getYokinkbn();

            BzGetBankData getBankData = SWAKInjector.getInstance(BzGetBankData.class);

            BzGetBankDataBean getBankDataBean = getBankData.exec(bankCd, sitenCd, null);

            bankNmKj = getBankDataBean.getBankNmKj();

            sitenNmKj = getBankDataBean.getSitenNmKj();

            kouzaNo = KhozenEdit.editKouzaNo(teikikinKouza.getKouzano());

            mousideNaiyouUmuKbn = C_UmuKbn.ARI;

            mousideNaiyou1 = SHRKZHNKKB1;

            mousideNaiyou2 = SHRKZHNKKB2;

            mousideNaiyou3 = SHRKZHNKKB5 + bankNmKj;

            mousideNaiyou4 = SHRKZHNKKB6 + sitenNmKj;

            mousideNaiyou6 = SHRKZHNKKB9 + kzMeigiNmKn;

            if (C_KouzasyuruiKbn.YENKOUZA.eq(teikikinKouza.getKzsyuruikbn())) {

                String yokinNm = C_YokinKbn.getContentByValue(C_YokinKbn.PATTERN_DEFAULT, yokinKbn.getValue());

                mousideNaiyou5 = SHRKZHNKKB7 + yokinNm + SHRKZHNKKB8 + kouzaNo;
            }
            else if (C_KouzasyuruiKbn.GAIKAKOUZA.eq(teikikinKouza.getKzsyuruikbn())) {

                mousideNaiyou5 = KBZENKAKUSPACE + SHRKZHNKKB8 + kouzaNo;
            }

            if (C_YenShrTkHnkKbn.TOKUYAKUHUKA.eq(pParam.getYenShrTkHnkKbn())) {

                mousideNaiyou7 = KBKAKUNINJIKOU;

                mousideNaiyou8 = SHRKZHNKKB3;

                mousideNaiyou9 = STDRSKTKYHUKAKB5;

                mousideNaiyou10 = KBHOKAN;
            }
            else if (C_YenShrTkHnkKbn.KAIYAKU.eq(pParam.getYenShrTkHnkKbn())) {

                mousideNaiyou7 = KBKAKUNINJIKOU;

                mousideNaiyou8 = SHRKZHNKKB4;
            }

            ttdkKan.setBankcd(bankCd);

            ttdkKan.setSitencd(sitenCd);

            ttdkKan.setBanknmkj(bankNmKj);

            ttdkKan.setSitennmkj(sitenNmKj);

            ttdkKan.setYokinkbn(yokinKbn);

            ttdkKan.setKouzano(kouzaNo);

            ttdkKan.setKzmeiginmkn(kzMeigiNmKn);
        }
        else if (C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR.eq(syoruiCd) && kykSyaHenkouRirekiLst.size() != 0) {

            if (C_Meigihnkjiyuu.KYKSB.eq(kykSyaHenkouRirekiLst.get(0).getMeigihnkjiyuu()) &&
                kykSyaHenkouRirekiLst.get(0).getYenkaiyakuhrstgk().compareTo(BizCurrency.valueOf(1000000)) > 0) {

                String kaiyakuHrstgk = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, String.format("%20s",
                    ViewReport.editCommaTuuka(kykSyaHenkouRirekiLst.get(0).getYenkaiyakuhrstgk(), BizUtil.ZERO_FILL)));

                String kihrkmpsGk = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, String.format("%20s",
                    ViewReport.editCommaTuuka(kykSyaHenkouRirekiLst.get(0).getKihrkmpsgk(), BizUtil.ZERO_FILL)));

                String oldkykKihrkmp = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, String.format("%20s",
                    ViewReport.editCommaTuuka(kykSyaHenkouRirekiLst.get(0).getOldkykkihrkmp(), BizUtil.ZERO_FILL)));

                ttdknaiyou1 = MEIHENKB1;

                ttdknaiyou2 = MEIHENKB2;

                ttdknaiyou3 = MEIHENKB3;

                ttdknaiyou4 = MEIHENKB4 + kaiyakuHrstgk;

                ttdknaiyou5 = MEIHENKB5 + kihrkmpsGk;

                ttdknaiyou6 = MEIHENKB6 + oldkykKihrkmp;

                ttdknaiyou8 = MEIHENKB7;

                ttdknaiyou9 = MEIHENKB8;

                ttdknaiyou10 = MEIHENKB9;

            }
        }
        else if (C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR.eq(syoruiCd)) {

            if (!C_TargetTkMokuhyoutiKbn.NOTARGET.eq(pParam.getTargetTkMkhtKbn())) {
                String kigkmongon = "";

                if (C_TargetTkKbn.SYUUSIN.eq(pParam.getTargetTkKbn())) {
                    kigkmongon = MKHGKHNK5;
                }
                else if (C_TargetTkKbn.NENKIN.eq(pParam.getTargetTkKbn())) {
                    kigkmongon = MKHGKHNK6;
                }
                ttdknaiyou1 = MKHGKHNK1 + kigkmongon + pParam.getTargetTkMkhtKbn().getContent() + MKHGKHNK2;
            }
            else {
                ttdknaiyou1 = MKHGKHNK3;
            }
            ttdknaiyou2 = MKHGKHNK4 + FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pParam.getTargetTkKykHenkouYmd());
            ttdknaiyouumukbn = C_UmuKbn.ARI;
        }
        else if (C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR.eq(syoruiCd)) {

            ttdknaiyou1 = TMTTKNITENKB1;
            if (C_Tmttknitenkbn.ITEN.eq(pParam.getTmttknitenkbn())) {
                String tmttknitenYMD = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pParam.getTmttknitenYmd());

                ttdknaiyou2 = TMTTKNITENKB2;
                ttdknaiyou3 = TMTTKNITENKB3 + tmttknitenYMD;
                ttdknaiyou5 = TMTTKNITENKB4;
                ttdknaiyou6 = TMTTKNITENKB5;
                ttdknaiyou7 = TMTTKNITENKB6;
            }
            else if (C_Tmttknitenkbn.ITEN_TORIKESI.eq(pParam.getTmttknitenkbn())) {
                ttdknaiyou2 = TMTTKNITENKB7;
            }
        }
        else if (C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR.eq(syoruiCd) ||
            C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR.eq(syoruiCd) ||
            C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3.eq(syoruiCd) ||
            C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2.eq(syoruiCd) ||
            C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR.eq(syoruiCd)||
            C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR_2.eq(syoruiCd)) {

            String targettokuyakumkhgk = "";
            String targettkykkijyungk = "";

            if (C_TetudukisyuKbn.MKHGKTTTYENDTHNK.eq(pParam.getTetudukiSyu()) ||
                C_TetudukisyuKbn.MKHGKTTTYENDTHNK_NEN.eq(pParam.getTetudukiSyu())) {
                KeisanTargetMokuhyougk keisanTargetMokuhyougk = SWAKInjector.getInstance(KeisanTargetMokuhyougk.class);

                targettokuyakumkhgk = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.editCommaTuuka(
                    keisanTargetMokuhyougk.exec(pParam.getBfrTargetTkKjnKngk(), pParam.getBfrTargettkmokuhyouti()),
                    BizUtil.ZERO_FILL));

                targettkykkijyungk = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,
                    ViewReport.editCommaTuuka(pParam.getBfrTargetTkKjnKngk(), BizUtil.ZERO_FILL));
            }

            String bfrKeiyakutuukamei = C_Tuukasyu.getContentByValue(C_Tuukasyu.PATTERN_DEFAULT, pParam.getBfrTuukasyu().getValue());

            String yendtHnkjikaiyakuhrGaika = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.editCommaTuuka
                (pParam.getYendtHnkjikaiyakuhrGaika(), BizUtil.ZERO_FILL));

            String yendtHnkjikaiyakuhrYen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.editCommaTuuka
                (pParam.getYendtHnkjikaiyakuhrYen(), BizUtil.ZERO_FILL));

            String newKaiyakuhr = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.editCommaTuuka
                (pParam.getNewKaiyakuhr(), BizUtil.ZERO_FILL));

            String bfrHrkP = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.editCommaTuuka
                (pParam.getBfrHrkP(), BizUtil.ZERO_FILL));

            String nyknKawaserateZn = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,
                BizUtil.comma(pParam.getNyknKawaserate().toString(), BizUtil.ZERO_FILL, 2));

            String yendtHnkjiKawaserateZn = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,
                BizUtil.comma(pParam.getYendtHnkjiKawaserate().toString(), BizUtil.ZERO_FILL, 2));

            kykniyuhnkymd = pParam.getKykniyuhnkymd();

            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                kykniyuhnkkbn = C_KykniyuhenkouKbn.YENDTSYSN;
            }
            else if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                if (pParam.getTmttknitenYmd() != null) {

                    kykniyuhnkkbn = C_KykniyuhenkouKbn.YENDTNNKN_TMTTKINITENKEIIARI;
                }
                else {

                    kykniyuhnkkbn = C_KykniyuhenkouKbn.YENDTNNKN_TMTTKINITENKEIINASI;
                }
            }

            if (C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR.eq(syoruiCd)||
                C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR_2.eq(syoruiCd)) {

                kykniyuhnkinfo = yendtHnkjikaiyakuhrYen + KBKAKKOSTART + SAME + KBKAKKOEND;
            }
            else if (C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2.eq(syoruiCd)) {

                kykniyuhnkinfo = targettokuyakumkhgk
                    + YENDTHNKKB18
                    + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, pParam.getBfrTargettkmokuhyouti()
                        .toString()) + YENDTHNKKB2;
            }
            else {

                kykniyuhnkinfo = targettokuyakumkhgk
                    + YENDTHNKKB1
                    + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, pParam.getBfrTargettkmokuhyouti()
                        .toString()) + YENDTHNKKB2;
            }

            if (C_TetudukisyuKbn.MKHGKTTTYENDTHNK.eq(pParam.getTetudukiSyu()) ||
                C_TetudukisyuKbn.MKHGKTTTYENDTHNK_NEN.eq(pParam.getTetudukiSyu())) {

                kykniyuhnkkngk1 = pParam.getYendtHnkjikaiyakuhrYen();
                kykniyuhnkkngktuksyu1 = C_Tuukasyu.JPY;

                if (pParam.getYendthnkHr().compareTo(
                    BizCurrency.valueOf(0, pParam.getYendthnkHr().getType())) > 0) {
                    kykniyuhnkkngk2 = pParam.getYendthnkHr();

                    kykniyuhnkkngktuksyu2 = C_Tuukasyu.JPY;
                }
            }

            if (C_TetudukisyuKbn.MKHGKTTTYENDTHNK.eq(pParam.getTetudukiSyu()) ||
                C_TetudukisyuKbn.MKHGKTTTYENDTHNK_NEN.eq(pParam.getTetudukiSyu())) {
                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                    if (C_UmuKbn.ARI.eq(pParam.getGengakukeiiUmu())) {
                        if (C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2.eq(syoruiCd)) {

                            ttdknaiyou1 = YENDTHNKKB15 + targettkykkijyungk + YENDTHNKKB5;
                        }
                        else {

                            ttdknaiyou1 = YENDTHNKKB3 + targettkykkijyungk + YENDTHNKKB5;
                        }
                    }
                    else if (C_UmuKbn.NONE.eq(pParam.getGengakukeiiUmu())) {
                        if (C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2.eq(syoruiCd)) {

                            ttdknaiyou1 = YENDTHNKKB15 + YENDTHNKKB14 + targettkykkijyungk + YENDTHNKKB13;
                        }
                        else {

                            ttdknaiyou1 = YENDTHNKKB3 + YENDTHNKKB14 + targettkykkijyungk + YENDTHNKKB13;
                        }
                    }
                    ttdknaiyou2 = YENDTHNKKB6 + yendtHnkjikaiyakuhrGaika + YENDTHNKKB5;

                    ttdknaiyou3 = KBZENKAKUSPACE3 + YENDTHNKKB7 + bfrKeiyakutuukamei + KBIKORU + yendtHnkjiKawaserateZn + YENDTHNKKB4
                        + KBKAKKOEND;

                    if (C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR.eq(syoruiCd)) {

                        ttdknaiyou4 = YENDTHNKKB8 + newKaiyakuhr + YENDTHNKKB5;

                        ttdknaiyou5 = KBZENKAKUSPACE4 + YENDTHNKKB17;

                        ttdknaiyou6 = KBZENKAKUSPACE4 + YENDTHNKKB10;

                        ttdknaiyou8 = YENDTHNKKB16;
                    }
                    else {

                        ttdknaiyou5 = YENDTHNKKB16;
                    }
                }
                else {
                    if (C_UmuKbn.ARI.eq(pParam.getGengakukeiiUmu())) {
                        if (C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2.eq(syoruiCd)) {

                            ttdknaiyou1 = YENDTHNKKB15 + targettkykkijyungk + YENDTHNKKB5;
                        }
                        else {

                            ttdknaiyou1 = YENDTHNKKB3 + targettkykkijyungk + YENDTHNKKB5;
                        }

                        ttdknaiyou2 = KBZENKAKUSPACE3 + YENDTHNKKB7 + bfrKeiyakutuukamei + KBIKORU + nyknKawaserateZn + YENDTHNKKB4
                            + KBKAKKOEND;
                    }
                    else if (C_UmuKbn.NONE.eq(pParam.getGengakukeiiUmu())) {
                        if (C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2.eq(syoruiCd)) {

                            ttdknaiyou1 = YENDTHNKKB15 + YENDTHNKKB11 + bfrHrkP + YENDTHNKKB12;
                        }
                        else {

                            ttdknaiyou1 = YENDTHNKKB3 + YENDTHNKKB11 + bfrHrkP + YENDTHNKKB12;
                        }

                        ttdknaiyou2 = KBZENKAKUSPACE3 + KBKAKKOSTART + targettkykkijyungk + YENDTHNKKB13 + YENDTHNKKB7
                            + bfrKeiyakutuukamei + KBIKORU + nyknKawaserateZn + YENDTHNKKB4 + KBKAKKOEND;
                    }

                    ttdknaiyou3 = YENDTHNKKB6 + yendtHnkjikaiyakuhrGaika + YENDTHNKKB5;

                    ttdknaiyou4 = KBZENKAKUSPACE3 + YENDTHNKKB7 + bfrKeiyakutuukamei + KBIKORU + yendtHnkjiKawaserateZn + YENDTHNKKB4
                        + KBKAKKOEND;

                    if (C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR.eq(syoruiCd)) {
                        ttdknaiyou5 = YENDTHNKKB8 + newKaiyakuhr + YENDTHNKKB5;

                        ttdknaiyou6 = KBZENKAKUSPACE4 + YENDTHNKKB17;

                        ttdknaiyou7 = KBZENKAKUSPACE4 + YENDTHNKKB10;

                        ttdknaiyou9 = YENDTHNKKB16;
                    }
                    else {

                        ttdknaiyou6 = YENDTHNKKB16;
                    }
                }
            }
            else if (C_TetudukisyuKbn.YENDTHNKNINI_NEN.eq(pParam.getTetudukiSyu())) {

                ttdknaiyou1 = YENDTHNKKB19 + YENDTHNKKB9 + yendtHnkjikaiyakuhrGaika + YENDTHNKKB12;

                ttdknaiyou2 = KBZENKAKUSPACE2 + KBKAKKOSTART + yendtHnkjikaiyakuhrYen + YENDTHNKKB13 + YENDTHNKKB7
                    + bfrKeiyakutuukamei + KBIKORU + yendtHnkjiKawaserateZn + YENDTHNKKB4 + KBKAKKOEND;

                ttdknaiyou4 = YENDTHNKKB16;
            }

            else if (C_TetudukisyuKbn.YENDTHNKNINI.eq(pParam.getTetudukiSyu())) {

                ttdknaiyou1 = YENDTHNKKB20 + YENDTHNKKB21 + yendtHnkjikaiyakuhrGaika + YENDTHNKKB12;

                ttdknaiyou2 = KBZENKAKUSPACE2 + KBKAKKOSTART + yendtHnkjikaiyakuhrYen + YENDTHNKKB13 + YENDTHNKKB7
                    + bfrKeiyakutuukamei + KBIKORU + yendtHnkjiKawaserateZn + YENDTHNKKB4 + KBKAKKOEND;

                ttdknaiyou4 = YENDTHNKKB16;
            }

            if (C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR.eq(syoruiCd)) {
                toritugisyasyozokunm = C_TantousituKbn.getContentByValue(C_TantousituKbn.PATTERN_DEFAULT, C_TantousituKbn.DAIRITENJIMUSV.getValue());

                hnsnhutouhuunyuuhyouji = C_UmuKbn.ARI;
            }
        }

        ttdkKan.setKykniyuhnkkbn(kykniyuhnkkbn);

        ttdkKan.setKykniyuhnkymd(kykniyuhnkymd);

        ttdkKan.setKykniyuhnkinfo(kykniyuhnkinfo);

        ttdkKan.setKykniyuhnkgkhugou1(kykniyuhnkgkhugou1);

        ttdkKan.setKykniyuhnkkngk1(kykniyuhnkkngk1);

        ttdkKan.setKykniyuhnkkngktuksyu1(kykniyuhnkkngktuksyu1);

        ttdkKan.setKykniyuhnkkngkhugou2(kykniyuhnkkngkhugou2);

        ttdkKan.setKykniyuhnkkngk2(kykniyuhnkkngk2);

        ttdkKan.setKykniyuhnkkngktuksyu2(kykniyuhnkkngktuksyu2);

        ttdkKan.setTtdknaiyouumukbn(ttdknaiyouumukbn);

        ttdkKan.setTtdknaiyou1(ttdknaiyou1);

        ttdkKan.setTtdknaiyou2(ttdknaiyou2);

        ttdkKan.setTtdknaiyou3(ttdknaiyou3);

        ttdkKan.setTtdknaiyou4(ttdknaiyou4);

        ttdkKan.setTtdknaiyou5(ttdknaiyou5);

        ttdkKan.setTtdknaiyou6(ttdknaiyou6);

        ttdkKan.setTtdknaiyou7(ttdknaiyou7);

        ttdkKan.setTtdknaiyou8(ttdknaiyou8);

        ttdkKan.setTtdknaiyou9(ttdknaiyou9);

        ttdkKan.setTtdknaiyou10(ttdknaiyou10);

        ttdkKan.setDocumentid(pParam.getDocumentId());

        ttdkKan.setSksmongonkbn1(pParam.getSksmongonKbn1());

        ttdkKan.setSksmongonkbn2(pParam.getSksmongonKbn2());

        ttdkKan.setToritugisyasyozokunm(toritugisyasyozokunm);

        ttdkKan.setToritugisyakjncd(toritugisyakjncd);

        ttdkKan.setToritugisyanm(toritugisyanm);

        ttdkKan.setHozonKikan(pParam.getHozonKikanY());

        ttdkKan.setTsintelno(pKykSya.getTsintelno());

        ttdkKan.setHnsnhutouhuunyuuhyouji(hnsnhutouhuunyuuhyouji.getValue());

        if (C_UmuKbn.ARI.eq(pParam.getSiharaiUmu()) && pKhShrRireki != null) {
            BzGetBankData getBankData = SWAKInjector.getInstance(BzGetBankData.class);

            BzGetBankDataBean getBankDataBean =
                getBankData.exec(pKhShrRireki.getBankcd(), pKhShrRireki.getSitencd(), BizDate.getSysDate());

            bankNmKj = "";

            sitenNmKj = "";

            if (C_BankmasterUmuKbn.NONE.eq(getBankDataBean.getBankmasterUmuKbn())) {

                bankNmKj = "";

                sitenNmKj = "";
            }
            else {

                bankNmKj = getBankDataBean.getBankNmKj();

                sitenNmKj = getBankDataBean.getReportSitenNm();
            }

            String kzNo = KhozenEdit.editKouzaNo(pKhShrRireki.getBankcd(),pKhShrRireki.getKouzano());

            yokinKbn = C_YokinKbn.BLNK;

            if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pKhShrRireki.getBankcd())) {

                yokinKbn = C_YokinKbn.BLNK;
            }
            else {

                yokinKbn = pKhShrRireki.getYokinkbn();
            }

            bankCd = pKhShrRireki.getBankcd();

            sitenCd = pKhShrRireki.getSitencd();

            kzsyuruikbn = pKhShrRireki.getKzsyuruikbn();

            kzMeigiNmKn = pKhShrRireki.getKzmeiginmkn();

            if ((C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR.eq(syoruiCd) ||
                C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI.eq(syoruiCd)) &&
                C_Kaiyakujiyuu.SKS.eq(kaiyakuJiyuu)) {

                bankCd = "";

                sitenCd = "";

                bankNmKj = "";

                sitenNmKj = "";

                yokinKbn = C_YokinKbn.BLNK;

                kzsyuruikbn = C_KouzasyuruiKbn.BLNK;

                kzNo = "";

                kzMeigiNmKn = "";
            }

            shrTuukaNm = C_Tuukasyu.getContentByValue(C_Tuukasyu.PATTERN_DEFAULT,
                pKhShrRireki.getShrtuukasyu().getValue());

            String Keiyakutuukamei = C_Tuukasyu.getContentByValue(C_Tuukasyu.PATTERN_DEFAULT,
                pKhShrRireki.getKyktuukasyu().getValue());

            int index = 0;
            int bikouIndex = 0;

            NaibuKoumokudtlBean naibuKoumokudtlBean = SWAKInjector.getInstance(NaibuKoumokudtlBean.class);
            KngkMeisaiBean kngkMeisaiBeanMae = SWAKInjector.getInstance(KngkMeisaiBean.class);

            if (C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.eq(syoruiCd)) {
                BizCurrency mikeikapSyoukei = pKhShrRireki.getYenmikeikap().add(pKhShrRireki.getYenzennomikeikap());

                String shrkwsrateZn = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,
                    BizUtil.comma(pKhShrRireki.getShrkwsrate().toString(), BizUtil.ZERO_FILL, 2));

                String  gaikashrkwsrateZn = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,
                    BizUtil.comma(pKhShrRireki.getGaikashrkwsrate().toString(), BizUtil.ZERO_FILL, 2));

                if (C_Tuukasyu.JPY.eq(pKykSyouhnLst.get(0).getKyktuukasyu())) {

                    tekiyouLst.set(index, TEKIYOUKB2);
                    kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei());
                    kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                    naibuKoumokudtlBean.setKhShrRireki(pKhShrRireki);
                    kngkMeisaiBeanMae.setIndex(index);
                    kngkMeisaiBeanMae.setTekiyouLst(tekiyouLst);
                    kngkMeisaiBeanMae.setKngkmeisaihugouLst(kngkmeisaihugouLst);
                    kngkMeisaiBeanMae.setKngkMeisaiLst(kngkMeisaiLst);
                    kngkMeisaiBeanMae.setKngkmisituukasyuLst(kngkmisituukasyuLst);
                    naibuKoumokudtlBean.setKngkMeisaiBean(kngkMeisaiBeanMae);

                    KngkMeisaiBean kngkMeisaiBean = EditYenddtl(naibuKoumokudtlBean);

                    index = kngkMeisaiBean.getIndex();
                }
                else {

                    if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getHeijyunbaraiumu())
                        && !C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(pKykSonotaTkyk.getYennyknsyuruikbn())) {

                        if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                            tekiyouLst.set(index, TEKIYOUKB2);
                            kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukakaiyakuhrkngkkei());
                            kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                            naibuKoumokudtlBean.setKhShrRireki(pKhShrRireki);
                            kngkMeisaiBeanMae.setIndex(index);
                            kngkMeisaiBeanMae.setTekiyouLst(tekiyouLst);
                            kngkMeisaiBeanMae.setKngkmeisaihugouLst(kngkmeisaihugouLst);
                            kngkMeisaiBeanMae.setKngkMeisaiLst(kngkMeisaiLst);
                            kngkMeisaiBeanMae.setKngkmisituukasyuLst(kngkmisituukasyuLst);
                            naibuKoumokudtlBean.setKngkMeisaiBean(kngkMeisaiBeanMae);
                            naibuKoumokudtlBean.setSyushrgkkeiHnykSyuruiKbn(pKhShrRireki.getSyushrgkkeisyukbn().getContent());

                            KngkMeisaiBean kngkMeisaiBean = EditHijnGaikagkdtyenShrdtl(naibuKoumokudtlBean);
                            index = kngkMeisaiBean.getIndex();
                        }
                        else {

                            tekiyouLst.set(index, TEKIYOUKB2);
                            kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei());
                            kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                            naibuKoumokudtlBean.setKhShrRireki(pKhShrRireki);
                            kngkMeisaiBeanMae.setIndex(index);
                            kngkMeisaiBeanMae.setTekiyouLst(tekiyouLst);
                            kngkMeisaiBeanMae.setKngkmeisaihugouLst(kngkmeisaihugouLst);
                            kngkMeisaiBeanMae.setKngkMeisaiLst(kngkMeisaiLst);
                            kngkMeisaiBeanMae.setKngkmisituukasyuLst(kngkmisituukasyuLst);
                            naibuKoumokudtlBean.setKngkMeisaiBean(kngkMeisaiBeanMae);
                            KngkMeisaiBean kngkMeisaiBean = EditHijnGaikagkdtgaikaShrdtl(naibuKoumokudtlBean);
                            index = kngkMeisaiBean.getIndex();
                        }
                    }
                    else {

                        tekiyouLst.set(index, TEKIYOUKB2);
                        kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukakaiyakuhrkngkkei());
                        kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                        if (pKhShrRireki.getShrtuukasonotashrkngk().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getShrtuukasonotashrkngk().getType())) > 0) {

                            index = index + 1;
                            tekiyouLst.set(index, TEKIYOUKB7);
                            kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasonotashrkngk());
                            kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());
                            index = index + 1;
                            tekiyouLst.set(index, TEKIYOUKB8);

                            if (mikeikapSyoukei.compareTo(BizCurrency.valueOf(0, mikeikapSyoukei.getType())) > 0) {

                                index = index + 1;
                                tekiyouLst.set(index, KBUTITEN + TEKIYOUKB9);
                                kngkMeisaiLst.set(index, mikeikapSyoukei);
                                kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                            }

                            if (pKhShrRireki.getYenkansanhaitoukin().compareTo(
                                BizCurrency.valueOf(0, pKhShrRireki.getYenkansanhaitoukin().getType())) > 0) {

                                index = index + 1;
                                tekiyouLst.set(index, KBUTITEN + TEKIYOUKB6);
                                kngkMeisaiLst.set(index, pKhShrRireki.getYenkansanhaitoukin());
                                kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                            }

                            if (pKhShrRireki.getYensonotahaitoukin().compareTo(
                                BizCurrency.valueOf(0, pKhShrRireki.getYensonotahaitoukin().getType())) > 0) {

                                index = index + 1;
                                tekiyouLst.set(index, KBUTITEN + TEKIYOUKB11);
                                kngkMeisaiLst.set(index, pKhShrRireki.getYensonotahaitoukin());
                                kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                            }

                            index = index + 1;
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getHeijyunbaraiumu())
                    && !C_Tuukasyu.JPY.eq(pKykSyouhnLst.get(0).getKyktuukasyu())) {

                    if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                        if (C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(pKykSonotaTkyk.getYennyknsyuruikbn())) {

                            bikouLst.set(bikouIndex, BIKOUKB35);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB36);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB27 + shrkwsrateZn + BIKOUKB11);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB37);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE
                                + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.editCommaTuuka(
                                    pKhShrRireki.getKaiyakuhrkngkkeisiteituuka(), BizUtil.ZERO_FILL)));
                            bikouIndex = bikouIndex + 1;

                            if (pKhShrRireki.getShrtuukasonotashrkngk().compareTo(
                                BizCurrency.valueOf(0, pKhShrRireki.getShrtuukasonotashrkngk().getType())) > 0) {

                                bikouLst.set(bikouIndex, BIKOUKB30);
                                bikouIndex = bikouIndex + 1;
                            }
                        }
                        else {
                            bikouLst.set(bikouIndex, BIKOUKB38);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB36);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB27 + shrkwsrateZn + BIKOUKB11);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB39);

                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE
                                + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.editCommaTuuka(
                                    pKhShrRireki.getKaiyakuhrkngkkeisiteituuka(), BizUtil.ZERO_FILL)));
                        }
                    }
                    else {
                        if (pKhShrRireki.getShrtuukasonotashrkngk().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getShrtuukasonotashrkngk().getType())) > 0) {

                            bikouLst.set(bikouIndex, BIKOUKB23);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB24);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB25);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE
                                + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.editCommaTuuka(
                                    pKhShrRireki.getSonotashrkngkyen(), BizUtil.ZERO_FILL)));
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB26 + gaikashrkwsrateZn + BIKOUKB11);
                        }
                    }
                }
                else {
                    if (!pKykSyouhnLst.get(0).getKyktuukasyu().eq(pKhShrRireki.getShrtuukasyu())) {
                        bikouLst.set(0, ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.editCommaTuuka
                            (pKhShrRireki.getSyushrgkkei(), BizUtil.ZERO_FILL)));
                    }
                }

                if (bikouIndex > index) {

                    index = bikouIndex;
                }

                if (pKhShrRireki.getShrtuukagstszeigk().compareTo(
                    BizCurrency.valueOf(0, pKhShrRireki.getShrtuukagstszeigk().getType())) > 0) {
                    index = index +1;
                    tekiyouLst.set(index, TEKIYOUKB4);
                    kngkmeisaihugouLst.set(index, C_HugouKbn.HU);
                    kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukagstszeigk());
                    kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());
                }

                if (pKhShrRireki.getShrtuukashrtienrsk().compareTo(
                    BizCurrency.valueOf(0, pKhShrRireki.getShrtuukashrtienrsk().getType())) > 0) {

                    index = index + 1;

                    tekiyouLst.set(index, TEKIYOUKB3);

                    kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukashrtienrsk());

                    kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                    bikouLst.set(index, BIKOUKB6 + BIKOUKB7 + BIKOUKB8 +
                        ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, pKhShrRireki.getTienrsknissuu().toString()) +
                        BIKOUKB9);
                }

                if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getItijibrumu())) {

                    if(C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                        if (!C_Tuukasyu.JPY.eq(pKykSyouhnLst.get(0).getKyktuukasyu())) {
                            index = index + 1;
                            bikouLst.set(index, BIKOUKB10
                                + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, BizUtil.comma(pKhShrRireki.getShrkwsrate().toString(), BizUtil.ZERO_FILL, 2))
                                + BIKOUKB11);
                        }
                    }
                }
            }

            else if (C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCd) ||
                C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR.eq(syoruiCd)) {

                kaiykymd = pParam.getCalckijyunYMD();

                BizCurrency ptumitatekin = pKhShrRireki.getKhShrRirekiDetails().get(0).getShrtstmttkin();

                BizNumber sjkkktyouseiritu = pKhShrRireki.getKhShrRirekiDetails().get(0).getKaiyakusjkkktyouseiritu().multiply(100);

                BizCurrency kaiyakukjgk = pKhShrRireki.getKhShrRirekiDetails().get(0).getKaiyakukjgk();

                BizCurrency kykhkjihenreikin = pKhShrRireki.getZitkazukarikingksiteituuka();

                BizCurrency sonotashrgksum = pKhShrRireki.getSonotashrkngkyen();

                BizCurrency kaiyakuhr = pKhShrRireki.getKaiyakuhrkngkkeisiteituuka();

                BizCurrency mikeikapSyoukei = pKhShrRireki.getYenmikeikap().add(pKhShrRireki.getYenzennomikeikap());

                BizCurrency seisankinSyoukei = pKhShrRireki.getZitkazukarikingkyen().add(pKhShrRireki.getYenkrkgk());

                String ptumitatekinzen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.
                    editCommaTuuka(ptumitatekin, BizUtil.ZERO_FILL));

                String sjkkktyouseirituzen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, BizUtil.
                    comma(sjkkktyouseiritu.toString(), BizUtil.ZERO_FILL, 8));

                String kaiyakukjgkzen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.
                    editCommaTuuka(kaiyakukjgk, BizUtil.ZERO_FILL));

                String shrkwsratezen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, BizUtil.
                    comma(pKhShrRireki.getShrkwsrate().toString(), BizUtil.ZERO_FILL, 2));

                String gaikashrkwsratezen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, BizUtil.
                    comma(pKhShrRireki.getGaikashrkwsrate().toString(), BizUtil.ZERO_FILL, 2));

                String kykhkjihenreikinzen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.
                    editCommaTuuka(kykhkjihenreikin, BizUtil.ZERO_FILL));

                String sonotashrgksumzen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.
                    editCommaTuuka(sonotashrgksum, BizUtil.ZERO_FILL));

                String kaiyakuhrzen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.
                    editCommaTuuka(kaiyakuhr, BizUtil.ZERO_FILL));

                if (C_Tuukasyu.JPY.eq(pKykSyouhnLst.get(0).getKyktuukasyu())) {

                    tekiyouLst.set(index, TEKIYOUKB1);
                    kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei());
                    kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                    naibuKoumokudtlBean.setKhShrRireki(pKhShrRireki);
                    kngkMeisaiBeanMae.setIndex(index);
                    kngkMeisaiBeanMae.setTekiyouLst(tekiyouLst);
                    kngkMeisaiBeanMae.setKngkmeisaihugouLst(kngkmeisaihugouLst);
                    kngkMeisaiBeanMae.setKngkMeisaiLst(kngkMeisaiLst);
                    kngkMeisaiBeanMae.setKngkmisituukasyuLst(kngkmisituukasyuLst);
                    naibuKoumokudtlBean.setKngkMeisaiBean(kngkMeisaiBeanMae);

                    KngkMeisaiBean kngkMeisaiBean = EditYenddtl(naibuKoumokudtlBean);

                    index = kngkMeisaiBean.getIndex();
                }
                else {

                    if (C_UmuKbn.ARI.eq(pParam.getYuuyokknTyoukaUmu())) {

                        tekiyouLst.set(index, TEKIYOUKB1);
                        kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukakaiyakuhrkngkkei());
                        kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                        if (pKhShrRireki.getYenkansanhaitoukin().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getYenkansanhaitoukin().getType())) > 0) {

                            index = index + 1;
                            tekiyouLst.set(index, TEKIYOUKB6);
                            kngkMeisaiLst.set(index, pKhShrRireki.getYenkansanhaitoukin());
                            kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                        }

                        if (pKhShrRireki.getYensonotahaitoukin().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getYensonotahaitoukin().getType())) > 0) {

                            index = index + 1;
                            tekiyouLst.set(index, TEKIYOUKB11);
                            kngkMeisaiLst.set(index, pKhShrRireki.getYensonotahaitoukin());
                            kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                        }

                        if (seisankinSyoukei.compareTo(BizCurrency.valueOf(0, seisankinSyoukei.getType())) > 0) {

                            index = index + 1;
                            tekiyouLst.set(index, TEKIYOUKB10);
                            kngkMeisaiLst.set(index, seisankinSyoukei);
                            kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                        }
                    }

                    else if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getHeijyunbaraiumu())
                        && !C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(pKykSonotaTkyk.getYennyknsyuruikbn())) {

                        if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                            tekiyouLst.set(index, TEKIYOUKB1);
                            kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukakaiyakuhrkngkkei());
                            kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                            naibuKoumokudtlBean.setKhShrRireki(pKhShrRireki);
                            kngkMeisaiBeanMae.setIndex(index);
                            kngkMeisaiBeanMae.setTekiyouLst(tekiyouLst);
                            kngkMeisaiBeanMae.setKngkmeisaihugouLst(kngkmeisaihugouLst);
                            kngkMeisaiBeanMae.setKngkMeisaiLst(kngkMeisaiLst);
                            kngkMeisaiBeanMae.setKngkmisituukasyuLst(kngkmisituukasyuLst);
                            naibuKoumokudtlBean.setKngkMeisaiBean(kngkMeisaiBeanMae);
                            naibuKoumokudtlBean.setSyushrgkkeiHnykSyuruiKbn(pKhShrRireki.getSyushrgkkeisyukbn().getContent());

                            KngkMeisaiBean kngkMeisaiBean = EditHijnGaikagkdtyenShrdtl(naibuKoumokudtlBean);
                            index = kngkMeisaiBean.getIndex();
                        }
                        else {
                            tekiyouLst.set(index, TEKIYOUKB1);
                            kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei());
                            kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                            naibuKoumokudtlBean.setKhShrRireki(pKhShrRireki);
                            kngkMeisaiBeanMae.setIndex(index);
                            kngkMeisaiBeanMae.setTekiyouLst(tekiyouLst);
                            kngkMeisaiBeanMae.setKngkmeisaihugouLst(kngkmeisaihugouLst);
                            kngkMeisaiBeanMae.setKngkMeisaiLst(kngkMeisaiLst);
                            kngkMeisaiBeanMae.setKngkmisituukasyuLst(kngkmisituukasyuLst);
                            naibuKoumokudtlBean.setKngkMeisaiBean(kngkMeisaiBeanMae);

                            KngkMeisaiBean kngkMeisaiBean = EditHijnGaikagkdtgaikaShrdtl(naibuKoumokudtlBean);
                            index = kngkMeisaiBean.getIndex();
                        }
                    }
                    else {

                        tekiyouLst.set(index, TEKIYOUKB1);
                        kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukakaiyakuhrkngkkei());
                        kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                        if (pKhShrRireki.getShrtuukasonotashrkngk().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getShrtuukasonotashrkngk().getType())) > 0) {

                            index = index + 1;
                            tekiyouLst.set(index, TEKIYOUKB7);
                            kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasonotashrkngk());
                            kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());
                            index = index + 1;
                            tekiyouLst.set(index, TEKIYOUKB8);

                            if (mikeikapSyoukei.compareTo(BizCurrency.valueOf(0, mikeikapSyoukei.getType())) > 0) {

                                index = index + 1;
                                tekiyouLst.set(index, KBUTITEN + TEKIYOUKB9);
                                kngkMeisaiLst.set(index, mikeikapSyoukei);
                                kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                            }

                            if (seisankinSyoukei.compareTo(BizCurrency.valueOf(0, seisankinSyoukei.getType())) > 0) {

                                index = index + 1;
                                tekiyouLst.set(index, KBUTITEN + TEKIYOUKB10);
                                kngkMeisaiLst.set(index, seisankinSyoukei);
                                kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                            }

                            if (pKhShrRireki.getYenkansanhaitoukin().compareTo(
                                BizCurrency.valueOf(0, pKhShrRireki.getYenkansanhaitoukin().getType())) > 0) {

                                index = index + 1;
                                tekiyouLst.set(index, KBUTITEN + TEKIYOUKB6);
                                kngkMeisaiLst.set(index, pKhShrRireki.getYenkansanhaitoukin());
                                kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                            }

                            if (pKhShrRireki.getYensonotahaitoukin().compareTo(
                                BizCurrency.valueOf(0, pKhShrRireki.getYensonotahaitoukin().getType())) > 0) {

                                index = index + 1;
                                tekiyouLst.set(index, KBUTITEN + TEKIYOUKB11);
                                kngkMeisaiLst.set(index, pKhShrRireki.getYensonotahaitoukin());
                                kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                            }
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getItijibrumu())) {

                    if (C_Tuukasyu.JPY.eq(pKykSyouhnLst.get(0).getKyktuukasyu())) {
                        if (pKhShrRireki.getYenkansanhaitoukin().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getYenkansanhaitoukin().getType())) > 0) {

                            bikouIndex = bikouIndex + 1;
                        }

                        if (pKhShrRireki.getYensonotahaitoukin().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getYensonotahaitoukin().getType())) > 0) {

                            bikouIndex = bikouIndex + 1;
                        }

                        if (pKhShrRireki.getYenkansansonotaseisangk().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getYenkansansonotaseisangk().getType())) > 0) {

                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, SAME + BIKOUKB15);
                        }
                    }
                    else {
                        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                            syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                            if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                                bikouLst.set(bikouIndex, BIKOUKB16);
                            }
                            else {

                                bikouLst.set(bikouIndex, BIKOUKB17);
                            }

                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB20);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + ptumitatekinzen);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB4);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + sjkkktyouseirituzen + KBPERCENT);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB18);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + kaiyakukjgkzen);

                            if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB19 + shrkwsratezen + BIKOUKB11);
                            }
                        }
                        else if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
                            if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                                bikouLst.set(bikouIndex, BIKOUKB2);
                            }
                            else {

                                bikouLst.set(bikouIndex, BIKOUKB1);
                            }

                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB3);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + ptumitatekinzen);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB4);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + sjkkktyouseirituzen + KBPERCENT);

                            if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB5 + shrkwsratezen + BIKOUKB11);
                            }
                        }
                        else if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                            if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                                bikouLst.set(bikouIndex, BIKOUKB16);
                            }
                            else {

                                bikouLst.set(bikouIndex, BIKOUKB17);
                            }

                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB3);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + ptumitatekinzen);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB4);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + sjkkktyouseirituzen + KBPERCENT);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, BIKOUKB18);
                            bikouIndex = bikouIndex + 1;
                            bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + kaiyakukjgkzen);

                            if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB19 + shrkwsratezen + BIKOUKB11);
                            }
                        }
                    }
                }
                else {
                    if (!C_Tuukasyu.JPY.eq(pKykSyouhnLst.get(0).getKyktuukasyu())) {

                        if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                            if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN
                                || C_UmuKbn.ARI.eq(pParam.getYuuyokknTyoukaUmu())) {

                                bikouLst.set(bikouIndex, KBUTITEN + BIKOUKB2);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB27 + shrkwsratezen + BIKOUKB11);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB28);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + kaiyakuhrzen);

                                if (kykhkjihenreikin.compareTo(BizCurrency.valueOf(0, kykhkjihenreikin.getType())) > 0) {

                                    bikouIndex = bikouIndex + 1;
                                    bikouLst.set(bikouIndex, BIKOUKB29);
                                    bikouIndex = bikouIndex + 1;
                                    bikouLst.set(bikouIndex, KBZENKAKUSPACE + BIKOUKB22);
                                    bikouIndex = bikouIndex + 1;
                                    bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + kykhkjihenreikinzen);
                                }

                                if (pKhShrRireki.getShrtuukasonotashrkngk().compareTo(
                                    BizCurrency.valueOf(0, pKhShrRireki.getShrtuukasonotashrkngk().getType())) > 0
                                    && C_UmuKbn.NONE.eq(pParam.getYuuyokknTyoukaUmu())) {

                                    bikouIndex = bikouIndex + 1;
                                    bikouLst.set(bikouIndex, BIKOUKB30);
                                }

                            }
                            else {

                                bikouLst.set(bikouIndex, BIKOUKB42);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB43);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB27 + shrkwsratezen + BIKOUKB11);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB44);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + kaiyakuhrzen);

                            }

                        }
                        else {
                            if (kykhkjihenreikin.compareTo(BizCurrency.valueOf(0, kykhkjihenreikin.getType())) > 0) {

                                bikouLst.set(bikouIndex, BIKOUKB21);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB22);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + kykhkjihenreikinzen);
                            }
                            if (sonotashrgksum.compareTo(BizCurrency.valueOf(0, sonotashrgksum.getType())) > 0) {
                                if (kykhkjihenreikin.compareTo(BizCurrency.valueOf(0, kykhkjihenreikin.getType())) > 0) {

                                    bikouIndex = bikouIndex + 1;
                                }

                                bikouLst.set(bikouIndex, BIKOUKB23);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB24);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB25);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, KBZENKAKUSPACE + KBZENKAKUSPACE + KBZENKAKUSPACE + sonotashrgksumzen);
                                bikouIndex = bikouIndex + 1;
                                bikouLst.set(bikouIndex, BIKOUKB26 + gaikashrkwsratezen + BIKOUKB11);
                            }
                        }
                    }
                }

                if (bikouIndex > index) {

                    index = bikouIndex;
                }

                if (pKhShrRireki.getShrtuukagstszeigk().compareTo(
                    BizCurrency.valueOf(0, pKhShrRireki.getShrtuukagstszeigk().getType())) > 0) {

                    index = index + 1;
                    tekiyouLst.set(index, TEKIYOUKB4);
                    kngkmeisaihugouLst.set(index, C_HugouKbn.HU);
                    kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukagstszeigk());
                    kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());
                }

                if (pKhShrRireki.getShrtuukashrtienrsk().compareTo(
                    BizCurrency.valueOf(0, pKhShrRireki.getShrtuukashrtienrsk().getType())) > 0) {

                    index = index + 1;
                    tekiyouLst.set(index, TEKIYOUKB3);
                    kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukashrtienrsk());
                    kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());
                    bikouLst.set(index, BIKOUKB6 + BIKOUKB7 + BIKOUKB8 +
                        ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, pKhShrRireki.getTienrsknissuu().toString()) +
                        BIKOUKB9);
                }

                if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getItijibrumu()) &&
                    C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getKaiyakukoujyoritutekiumu())) {

                    int keikanensuu = BizDateUtil.calcDifference(pKykSyouhnLst.get(0).getKykymd(),
                        pKhShrRireki.getKouryokuhasseiymd()).getYears();

                    int keikanensuumiman = keikanensuu + 1;

                    int kaiyakukoujyoritutekikkn = pKykSyouhnLst.get(0).getSyouhnZokusei().getKaiyakukoujyoritutekikkn();

                    String kaiyakukoujyorituzen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, BizUtil.comma
                        (pKhShrRireki.getKhShrRirekiDetails().get(0).getKaiyakukoujyoritu().multiply(100).toString(), BizUtil.ZERO_FILL, 2));
                    String keikanensuuzen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, String.valueOf(keikanensuu));
                    String keikanensuumimanzen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, String.valueOf(keikanensuumiman));

                    String kaiyakukoujyoritutekikknzen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, String.valueOf(kaiyakukoujyoritutekikkn));

                    if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                        if (keikanensuu == 0) {
                            shrnaiyouhskmongon1 = KAIYAKUKB1 + keikanensuumimanzen + KAIYAKUKB3 + KAIYAKUKB4 + kaiyakukoujyorituzen +
                                KBPERCENT + KBKAKKOEND;
                        }
                        else {
                            shrnaiyouhskmongon1 = KAIYAKUKB1 + keikanensuuzen + KAIYAKUKB2 + keikanensuumimanzen + KAIYAKUKB3 + KAIYAKUKB4 +
                                kaiyakukoujyorituzen + KBPERCENT + KBKAKKOEND;
                        }
                    }

                    else if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                        if (keikanensuu == 0) {
                            shrnaiyouhskmongon1 = KAIYAKUKB6 + keikanensuumimanzen + KAIYAKUKB3 + KAIYAKUKB4 + kaiyakukoujyorituzen +
                                KBPERCENT + KBKAKKOEND;
                        }
                        else if (keikanensuu < kaiyakukoujyoritutekikkn) {
                            shrnaiyouhskmongon1 = KAIYAKUKB6 + keikanensuuzen + KAIYAKUKB2 + keikanensuumimanzen + KAIYAKUKB3 + KAIYAKUKB4 +
                                kaiyakukoujyorituzen + KBPERCENT + KBKAKKOEND;
                        }
                        else {
                            shrnaiyouhskmongon1 = KAIYAKUKB6 + kaiyakukoujyoritutekikknzen + KAIYAKUKB2 + KAIYAKUKB4 + kaiyakukoujyorituzen +
                                KBPERCENT + KBKAKKOEND;
                        }
                    }
                }
                else if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getHeijyunbaraiumu())) {
                    if (kykhkjihenreikin.compareTo(BizCurrency.valueOf(0, kykhkjihenreikin.getType())) > 0) {
                        shrnaiyouhskmongon1 = KAIYAKUKB5;
                    }
                }
            }
            if (C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR.eq(syoruiCd)
                || C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR.eq(syoruiCd)
                || C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR.eq(syoruiCd)) {

                String siharaigakusyoukeisyurui = C_SyuShrgkSyoukeiKbn.getContentByValue(
                    C_SyuShrgkSyoukeiKbn.PATTERN_DEFAULT,
                    pKhShrRireki.getSyushrgkkeisyukbn().getValue());

                tekiyouLst.set(index, siharaigakusyoukeisyurui);

                kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                if (C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(pParam.getSyorikbn())) {

                    kngkMeisaiLst.set(index, pKhShrRireki.getSyushrgkkei());

                    if (pKhShrRireki.getYenkrkgk().compareTo(
                        BizCurrency.valueOf(0, pKhShrRireki.getYenkrkgk().getType())) > 0) {

                        index = index + 1;
                        tekiyouLst.set(index, TEKIYOUKB10);
                        kngkMeisaiLst.set(index, pKhShrRireki.getYenkrkgk());
                        kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                    }
                }
                else if (C_SyoriKbn.SBKAIJO.eq(pParam.getSyorikbn())
                    || C_SyoriKbn.SBMENSEKI.eq(pParam.getSyorikbn())) {

                    BizCurrency mikeikapSyoukei = pKhShrRireki.getYenmikeikap().add(pKhShrRireki.getYenzennomikeikap());

                    BizCurrency seisankinSyoukei = pKhShrRireki.getZitkazukarikingkyen().add(pKhShrRireki.getYenkrkgk());

                    if(C_Tuukasyu.JPY.eq(pKhShrRireki.getKyktuukasyu())){

                        kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei());

                        naibuKoumokudtlBean.setKhShrRireki(pKhShrRireki);
                        kngkMeisaiBeanMae.setIndex(index);
                        kngkMeisaiBeanMae.setTekiyouLst(tekiyouLst);
                        kngkMeisaiBeanMae.setKngkmeisaihugouLst(kngkmeisaihugouLst);
                        kngkMeisaiBeanMae.setKngkMeisaiLst(kngkMeisaiLst);
                        kngkMeisaiBeanMae.setKngkmisituukasyuLst(kngkmisituukasyuLst);
                        naibuKoumokudtlBean.setKngkMeisaiBean(kngkMeisaiBeanMae);

                        KngkMeisaiBean kngkMeisaiBean = EditYenddtl(naibuKoumokudtlBean);
                        index = kngkMeisaiBean.getIndex();
                    }
                    else {
                        if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getHeijyunbaraiumu())
                            && !C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(pKykSonotaTkyk.getYennyknsyuruikbn())) {

                            if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                                kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukakaiyakuhrkngkkei());

                                naibuKoumokudtlBean.setKhShrRireki(pKhShrRireki);
                                kngkMeisaiBeanMae.setIndex(index);
                                kngkMeisaiBeanMae.setTekiyouLst(tekiyouLst);
                                kngkMeisaiBeanMae.setKngkmeisaihugouLst(kngkmeisaihugouLst);
                                kngkMeisaiBeanMae.setKngkMeisaiLst(kngkMeisaiLst);
                                kngkMeisaiBeanMae.setKngkmisituukasyuLst(kngkmisituukasyuLst);
                                naibuKoumokudtlBean.setKngkMeisaiBean(kngkMeisaiBeanMae);
                                naibuKoumokudtlBean.setSyushrgkkeiHnykSyuruiKbn(siharaigakusyoukeisyurui);

                                KngkMeisaiBean kngkMeisaiBean = EditHijnGaikagkdtyenShrdtl(naibuKoumokudtlBean);
                                index = kngkMeisaiBean.getIndex();
                            }
                            else {
                                kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei()
                                    .add(pKhShrRireki.getZitkazukarikingksiteituuka()));

                                naibuKoumokudtlBean.setKhShrRireki(pKhShrRireki);
                                kngkMeisaiBeanMae.setIndex(index);
                                kngkMeisaiBeanMae.setTekiyouLst(tekiyouLst);
                                kngkMeisaiBeanMae.setKngkmeisaihugouLst(kngkmeisaihugouLst);
                                kngkMeisaiBeanMae.setKngkMeisaiLst(kngkMeisaiLst);
                                kngkMeisaiBeanMae.setKngkmisituukasyuLst(kngkmisituukasyuLst);
                                naibuKoumokudtlBean.setKngkMeisaiBean(kngkMeisaiBeanMae);

                                KngkMeisaiBean kngkMeisaiBean = EditHijnGaikagkdtgaikaShrdtl(naibuKoumokudtlBean);
                                index = kngkMeisaiBean.getIndex();
                            }
                        }
                        else {

                            if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                                kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukakaiyakuhrkngkkei());
                            }
                            else {

                                kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei()
                                    .add(pKhShrRireki.getZitkazukarikingksiteituuka()));
                            }
                            if (pKhShrRireki.getShrtuukasonotashrkngk().compareTo(
                                BizCurrency.valueOf(0, pKhShrRireki.getShrtuukasonotashrkngk().getType())) > 0) {

                                index = index + 1;
                                tekiyouLst.set(index, TEKIYOUKB7);
                                kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasonotashrkngk());
                                kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());
                                index = index + 1;
                                tekiyouLst.set(index, TEKIYOUKB8);

                                if (mikeikapSyoukei.compareTo(BizCurrency.valueOf(0, mikeikapSyoukei.getType())) > 0) {

                                    index = index + 1;
                                    tekiyouLst.set(index, KBUTITEN + TEKIYOUKB9);
                                    kngkMeisaiLst.set(index, mikeikapSyoukei);
                                    kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                                }

                                if (seisankinSyoukei.compareTo(BizCurrency.valueOf(0, seisankinSyoukei.getType())) > 0) {

                                    index = index + 1;
                                    tekiyouLst.set(index, KBUTITEN + TEKIYOUKB10);
                                    kngkMeisaiLst.set(index, seisankinSyoukei);
                                    kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                                }

                                if (pKhShrRireki.getYenkansanhaitoukin().compareTo(
                                    BizCurrency.valueOf(0, pKhShrRireki.getYenkansanhaitoukin().getType())) > 0) {

                                    index = index + 1;
                                    tekiyouLst.set(index, KBUTITEN + TEKIYOUKB6);
                                    kngkMeisaiLst.set(index, pKhShrRireki.getYenkansanhaitoukin());
                                    kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                                }

                                if (pKhShrRireki.getYensonotahaitoukin().compareTo(
                                    BizCurrency.valueOf(0, pKhShrRireki.getYensonotahaitoukin().getType())) > 0) {

                                    index = index + 1;
                                    tekiyouLst.set(index, KBUTITEN + TEKIYOUKB11);
                                    kngkMeisaiLst.set(index, pKhShrRireki.getYensonotahaitoukin());
                                    kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                                }
                            }
                        }
                    }

                    String sinsagendokkn = C_SinsaGendoKknKbn.getContentByValue(
                        C_SinsaGendoKknKbn.PATTERN_DEFAULT,
                        pKhShrRireki.getSinsagendokknkbn().getValue());

                    if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getKyktuukasyu()) &&
                        C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                        String shrkwsratekjnymd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pKhShrRireki.getShrkwsratekjnymd());

                        String syushrgkkei = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.editCommaTuuka
                            (pKhShrRireki.getKaiyakuhrkngkkeisiteituuka(), BizUtil.ZERO_FILL));

                        bikouLst.set(bikouIndex, BIKOUKB12 + syushrgkkei);
                        bikouIndex = bikouIndex + 1;
                        bikouLst.set(bikouIndex, BIKOUKB13 + Keiyakutuukamei + KBZENKAKUSPACE + KBIKORU + KBZENKAKUSPACE +
                            ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, BizUtil.comma(pKhShrRireki.getShrkwsrate().toString(), BizUtil.ZERO_FILL, 2)) +
                            BIKOUKB11);
                        bikouIndex = bikouIndex + 1;
                        bikouLst.set(bikouIndex, BIKOUKB14 + shrkwsratekjnymd);
                    }

                    if (pKhShrRireki.getShrtuukashrtienrsk().compareTo(
                        BizCurrency.valueOf(0, pKhShrRireki.getShrtuukashrtienrsk().getType())) > 0) {
                        BizCurrency kngkMeisai = pKhShrRireki.getShrtuukashrtienrsk();

                        if (bikouIndex > index) {

                            index = bikouIndex;
                        }
                        index = index + 1;

                        tekiyouLst.set(index, TEKIYOUKB3);

                        kngkMeisaiLst.set(index, kngkMeisai);

                        kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                        bikouLst.set(index, BIKOUKB6 + sinsagendokkn + BIKOUKB8 +
                            ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, pKhShrRireki.getTienrsknissuu().toString()) +
                            BIKOUKB9);
                    }
                }
            }
            if (C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR.eq(syoruiCd)) {
                tekiyouLst.set(index, TEKIYOUKB5);

                kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei());

                kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                bikouLst.set(index, BIKOUKB15);

                index = index + 1;

                if (pKhShrRireki.getShrtuukashrtienrsk().compareTo(
                    BizCurrency.valueOf(0, pKhShrRireki.getShrtuukashrtienrsk().getType())) > 0) {
                    tekiyouLst.set(index, TEKIYOUKB3);

                    kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukashrtienrsk());

                    kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                    bikouLst.set(index, BIKOUKB6 + BIKOUKB7 + BIKOUKB8 +
                        ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, pKhShrRireki.getTienrsknissuu().toString()) +
                        BIKOUKB9);
                }
            }

            if (C_SyoruiCdKbn.KK_DSHR_TTDKKR.eq(syoruiCd)) {
                tekiyouLst.set(index, TEKIYOUKB6);

                kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei());

                kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                index = index + 1;

                if (pKhShrRireki.getShrtuukashrtienrsk().compareTo(
                    BizCurrency.valueOf(0, pKhShrRireki.getShrtuukashrtienrsk().getType())) > 0) {
                    tekiyouLst.set(index, TEKIYOUKB3);

                    kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukashrtienrsk());

                    kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                    bikouLst.set(index, BIKOUKB6 + BIKOUKB7 + BIKOUKB8 +
                        ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, pKhShrRireki.getTienrsknissuu().toString()) +
                        BIKOUKB9);
                }

            }

            if (C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR.eq(syoruiCd) ||
                C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI.eq(syoruiCd)) {

                tekiyouLst.set(index, TEKIYOUKB12);
                kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei());
                kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());
                index = index + 1;

                tekiyouLst.set(index, TEKIYOUKB8);
                index = index + 1;

                tekiyouLst.set(index, KBUTITEN + TEKIYOUKB6);
                kngkMeisaiLst.set(index, pKhShrRireki.getYenkansanhaitoukin());
                kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                index = index + 1;

                if (pKhShrRireki.getYensonotahaitoukin().compareTo(BizCurrency.valueOf(0,
                    pKhShrRireki.getYensonotahaitoukin().getType())) > 0) {

                    tekiyouLst.set(index, KBUTITEN + TEKIYOUKB11);
                    kngkMeisaiLst.set(index, pKhShrRireki.getYensonotahaitoukin());
                    kngkmisituukasyuLst.set(index, C_Tuukasyu.JPY);
                    index = index + 1;
                }
                else {

                    if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                        index = index + 1;
                    }
                }

                if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                    index = index + 1;
                }

                if (pKhShrRireki.getShrtuukagstszeigk().compareTo(BizCurrency.valueOf(0,
                    pKhShrRireki.getShrtuukagstszeigk().getType())) > 0) {

                    tekiyouLst.set(index, TEKIYOUKB4);
                    kngkmeisaihugouLst.set(index, C_HugouKbn.HU);
                    kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukagstszeigk());
                    kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());
                    index = index + 1;
                }

                if (pKhShrRireki.getShrtuukashrtienrsk().compareTo(BizCurrency.valueOf(0,
                    pKhShrRireki.getShrtuukashrtienrsk().getType())) > 0) {

                    tekiyouLst.set(index, TEKIYOUKB13);
                    kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukashrtienrsk());
                    kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());
                }

                if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                    BizCurrency yenSyushrgkkei = pKhShrRireki.getYensyushrgkkei();
                    BizNumber gaikashrkwsrate = pKhShrRireki.getGaikashrkwsrate();

                    String yenSyushrgkkeiZenkaku = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.
                        editCommaTuuka(yenSyushrgkkei, BizUtil.ZERO_FILL));

                    String gaikashrkwsrateZenkaku = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, BizUtil.
                        comma(gaikashrkwsrate.toString(), BizUtil.ZERO_FILL, 2));

                    bikouLst.set(bikouIndex++, BIKOUKB33);
                    bikouLst.set(bikouIndex++, BIKOUKB24);
                    bikouLst.set(bikouIndex++, BIKOUKB34);
                    bikouLst.set(bikouIndex++, KBZENKAKUSPACE3 + yenSyushrgkkeiZenkaku);
                    bikouLst.set(bikouIndex, BIKOUKB26 + gaikashrkwsrateZenkaku + BIKOUKB11 + KBKAKKOSTART + SAME +
                        KBKAKKOEND);
                }

                if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                    if (C_DseisantetudukimeiKbn.KAIYAKU.eq(pParam.getDseisantetudukimeiKbn())) {

                        shrnaiyouhskmongon1 = HAITOUKINTUIBARAIKB1;
                    }
                    else if (C_DseisantetudukimeiKbn.SIBOU.eq(pParam.getDseisantetudukimeiKbn())) {

                        shrnaiyouhskmongon1 = HAITOUKINTUIBARAIKB2;
                    }
                }
            }
            if (C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI.eq(syoruiCd)) {

                tekiyouLst.set(index, TEKIYOUKB16);
                kngkMeisaiLst.set(index, pKhShrRireki.getShrtuukasyushrgkkei());
                kngkmisituukasyuLst.set(index, pKhShrRireki.getShrtuukasyu());

                if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getKyktuukasyu()) && C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                    BizCurrency syushrgkkei = pKhShrRireki.getSyushrgkkei();
                    BizNumber gaikashrkwsrate = pKhShrRireki.getShrkwsrate();

                    String syushrgkkeiZenkaku = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, ViewReport.
                        editCommaTuuka(syushrgkkei, BizUtil.ZERO_FILL));

                    String gaikashrkwsrateZenkaku = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, BizUtil.
                        comma(gaikashrkwsrate.toString(), BizUtil.ZERO_FILL, 2));

                    bikouLst.set(bikouIndex++, BIKOUKB40);
                    bikouLst.set(bikouIndex++, BIKOUKB27 + gaikashrkwsrateZenkaku + BIKOUKB11);
                    bikouLst.set(bikouIndex++, BIKOUKB41);
                    bikouLst.set(bikouIndex, KBZENKAKUSPACE3 + syushrgkkeiZenkaku);
                }
            }

            String siharainen = "";
            if (C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCd)
                && C_UmuKbn.ARI.eq(pParam.getYuuyokknTyoukaUmu())) {
                siharainen = FixedDateFormatter.formatYZenkakuSeirekiKanji(pKykSyouhnLst.get(0).getSyoumetuymd());
            } else {
                siharainen = FixedDateFormatter.formatYZenkakuSeirekiKanji(pKhShrRireki.getShrymd());
            }

            index = 0;

            int indexzeimu = 0;

            if (C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.eq(syoruiCd)) {

                zeimumongonLst.set(indexzeimu++, SAME + siharainen + ZEIMUKB1);

                zeimumongonoutkbn = C_UmuKbn.ARI;

                osirasemongonhyoudai = HYOUDAIKB1;

                kykhnkkaisuu = pKhShrRireki.getKykhnkkaisuu();

                if (C_UmuKbn.ARI.eq(gsbunritaisyouFlg)) {

                    zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI;

                    htykeihi = pKhShrRireki.getYenhtykeihi();

                    gsbnrkztsaeki = pKhShrRireki.getYenkztgk();

                }

                else {

                    synykngk = pKhShrRireki.getYensynykngk();

                    htykeihi = pKhShrRireki.getYenhtykeihi();

                    if (kykhnkkaisuu == 0) {

                        zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI;

                    }

                    else if (kykhnkkaisuu > 0) {

                        zeimumongonLst.set(indexzeimu++, ZEIMUKB2);

                        zeimumongonLst.set(indexzeimu++, ZEIMUKB3);

                        zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI;

                        shrkykhtykeihi = pKhShrRireki.getYenshrkykhtykeihi();

                    }
                }

                if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {
                    if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getKyktuukasyu())) {

                        osirasemongonLst.set(index++, OSORASEKB11);

                        osirasemongonLst.set(index++, OSORASEKB13);

                        osirasemongonLst.set(index++, OSORASEKB14);

                        osirasemongonLst.set(index++, OSORASEKB15);

                        osirasemongonLst.set(index++, OSORASEKB39);

                        osirasemongonLst.set(index++, OSORASEKB40);

                        osirasemongonLst.set(index++, OSORASEKB16);

                        osirasemongonLst.set(index++, OSORASEKB17);

                        osirasemongonLst.set(index++, OSORASEKB18);

                        osirasemongonLst.set(index++, OSORASEKB43);

                        index = index + 1;

                    }

                    osirasemongonLst.set(index++, OSORASEKB19);

                }
                else {

                    if (pKhShrRireki.getSonotashrkngkyen().compareTo(
                        BizCurrency.valueOf(0, pKhShrRireki.getSonotashrkngkyen().getType())) > 0) {

                        osirasemongonLst.set(index++, OSORASEKB11);
                        osirasemongonLst.set(index++, OSORASEKB46);
                        osirasemongonLst.set(index++, OSORASEKB47);
                        osirasemongonLst.set(index++, OSORASEKB48);
                        osirasemongonLst.set(index++, OSORASEKB39);
                        osirasemongonLst.set(index++, OSORASEKB40);
                        osirasemongonLst.set(index++, OSORASEKB16);
                        osirasemongonLst.set(index++, OSORASEKB17);
                        osirasemongonLst.set(index++, OSORASEKB18);
                        osirasemongonLst.set(index++, OSORASEKB42);

                        index = index + 1;
                    }
                    osirasemongonLst.set(index++, OSORASEKB19);
                    osirasemongonLst.set(index++, OSORASEKB20);
                    osirasemongonLst.set(index++, OSORASEKB21);

                }

                if (C_UmuKbn.ARI.eq(pKhShrRireki.getGsbunritaisyou())) {
                    if (pKhShrRireki.getShrtuukagstszeigk().compareTo(
                        BizCurrency.valueOf(0, pKhShrRireki.getShrtuukagstszeigk().getType())) > 0) {

                        osirasemongonLst.set(index++, OSORASEKB34);
                        osirasemongonLst.set(index++, OSORASEKB35);
                    }
                    else if(pKhShrRireki.getShrtuukagstszeigk().compareTo(
                        BizCurrency.valueOf(0, pKhShrRireki.getShrtuukagstszeigk().getType())) == 0){

                        osirasemongonLst.set(index++, OSORASEKB41);
                    }
                }
                else {
                    if (pKhShrRireki.getKykhnkkaisuu() == 0) {

                        osirasemongonLst.set(index++, OSORASEKB22);

                        osirasemongonLst.set(index++, OSORASEKB23);

                        osirasemongonLst.set(index++, OSORASEKB24);

                        osirasemongonLst.set(index++, OSORASEKB25);

                        osirasemongonLst.set(index++, OSORASEKB26);

                        osirasemongonLst.set(index++, OSORASEKB27);

                        osirasemongonLst.set(index++, OSORASEKB28);

                    }

                    else if (pKhShrRireki.getKykhnkkaisuu() > 0) {

                        osirasemongonLst.set(index++, OSORASEKB32);

                    }

                    if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                        osirasemongonLst.set(index++, OSORASEKB30);
                    }

                    if (pKhShrRireki.getKykhnkkaisuu() > 0) {

                        if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getHeijyunbaraiumu())){

                            if (C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(pKykSonotaTkyk.getYennyknsyuruikbn())) {

                                osirasemongonLst.set(index++, OSORASEKB44);
                            }
                            else {

                                osirasemongonLst.set(index++, OSORASEKB74);
                            }
                        }
                    }

                    if (!C_HtsiryosyuKbn.BLNK.eq(pKhShrRireki.getShrtysysyuruikbn())) {

                        osirasemongonLst.set(index++, OSORASEKB31);
                    }
                }
            }

            if (C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCd)
                || C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR.eq(syoruiCd)) {

                if (C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCd)) {

                    if (C_UmuKbn.ARI.eq(gsbunritaisyouFlg)
                        || !C_Kaiyakujiyuu.KYKSB.eq(kaiyakuJiyuu)) {

                        zeimumongonLst.set(indexzeimu++, SAME + siharainen + ZEIMUKB1);

                        zeimumongonoutkbn = C_UmuKbn.ARI;

                        if (pKhShrRireki.getShrtuukasonotaseisangk().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getShrtuukasonotaseisangk().getType())) > 0) {

                            zeimumongonLst.set(indexzeimu++, ZEIMUKB4);

                        }

                        if (C_UmuKbn.ARI.eq(gsbunritaisyouFlg)) {

                            zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI;

                            htykeihi = pKhShrRireki.getYenhtykeihi();

                            gsbnrkztsaeki = pKhShrRireki.getYenkztgk();

                        }

                        else {

                            if (pKhShrRireki.getKykhnkkaisuu() == 0) {

                                zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI;

                                htykeihi = pKhShrRireki.getYenhtykeihi();

                                synykngk = pKhShrRireki.getYensynykngk();

                            }

                            else if (pKhShrRireki.getKykhnkkaisuu() > 0) {

                                zeimumongonLst.set(indexzeimu++, ZEIMUKB2);

                                zeimumongonLst.set(indexzeimu++, ZEIMUKB3);

                                zeimuNaiyouHnsyuCtrlKbn =  C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI;

                                htykeihi = pKhShrRireki.getYenhtykeihi();

                                shrkykhtykeihi = pKhShrRireki.getYenshrkykhtykeihi();

                                synykngk = pKhShrRireki.getYensynykngk();

                            }
                        }
                    }

                    else {
                        zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU;

                        synykngk = pKhShrRireki.getYensynykngk();

                    }
                }

                kykhnkkaisuu = pKhShrRireki.getKykhnkkaisuu();

                osirasemongonhyoudai = HYOUDAIKB1;

                osirasemongonLst.set(index++, OSORASEKB1);

                if (C_UmuKbn.ARI.eq(pParam.getYuuyokknTyoukaUmu())) {
                    if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getKyktuukasyu())) {

                        osirasemongonLst.set(index++, OSORASEKB49);
                    }
                    if(syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                        osirasemongonLst.set(index++, OSORASEKB79);
                    }
                }
                else {

                    osirasemongonLst.set(index++, OSORASEKB2);
                }

                if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getKyktuukasyu())) {

                    if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {

                        osirasemongonLst.set(index++, OSORASEKB3);

                        osirasemongonLst.set(index++, OSORASEKB4);

                        osirasemongonLst.set(index++, OSORASEKB5);

                    }

                    if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                        osirasemongonLst.set(index++, OSORASEKB36);

                        osirasemongonLst.set(index++, OSORASEKB37);

                        osirasemongonLst.set(index++, OSORASEKB38);

                    }

                    if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                        osirasemongonLst.set(index++, OSORASEKB59);

                        osirasemongonLst.set(index++, OSORASEKB60);

                        osirasemongonLst.set(index++, OSORASEKB61);

                        osirasemongonLst.set(index++, OSORASEKB62);

                    }

                    if (C_UmuKbn.ARI.eq(pKykSyouhnLst.get(0).getSyouhnZokusei().getMvatekiumu())) {

                        osirasemongonLst.set(index++, OSORASEKB6);

                        osirasemongonLst.set(index++, OSORASEKB7);

                        osirasemongonLst.set(index++, OSORASEKB8);

                        osirasemongonLst.set(index++, OSORASEKB9);

                        osirasemongonLst.set(index++, OSORASEKB10);

                    }

                    if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                        if (C_UmuKbn.NONE.eq(pParam.getYuuyokknTyoukaUmu())) {
                            index = index + 1;

                            osirasemongonLst.set(index++, OSORASEKB11);

                            osirasemongonLst.set(index++, OSORASEKB12);

                            osirasemongonLst.set(index++, OSORASEKB14);

                            osirasemongonLst.set(index++, OSORASEKB15);

                            osirasemongonLst.set(index++, OSORASEKB39);

                            osirasemongonLst.set(index++, OSORASEKB40);

                            osirasemongonLst.set(index++, OSORASEKB16);

                            osirasemongonLst.set(index++, OSORASEKB17);

                            osirasemongonLst.set(index++, OSORASEKB18);

                            osirasemongonLst.set(index++, OSORASEKB43);
                        }
                    }

                    if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())
                        && pKhShrRireki.getSonotashrkngkyen().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getSonotashrkngkyen().getType())) > 0) {

                        index = index + 1;

                        osirasemongonLst.set(index++, OSORASEKB11);

                        osirasemongonLst.set(index++, OSORASEKB45);

                        osirasemongonLst.set(index++, OSORASEKB47);

                        osirasemongonLst.set(index++, OSORASEKB48);

                        osirasemongonLst.set(index++, OSORASEKB39);

                        osirasemongonLst.set(index++, OSORASEKB40);

                        osirasemongonLst.set(index++, OSORASEKB16);

                        osirasemongonLst.set(index++, OSORASEKB17);

                        osirasemongonLst.set(index++, OSORASEKB18);

                        osirasemongonLst.set(index++, OSORASEKB42);

                    }

                    if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN
                        || syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                        SortIT_AnsyuRireki sortIT_AnsyuRireki = SWAKInjector.getInstance(SortIT_AnsyuRireki.class);

                        IT_AnsyuKihon ansyuKihon = pKcp.getAnsyuuKihon(pKykKihon.getSyono());

                        List<IT_AnsyuRireki> ansyuRirekiLst = ansyuKihon.getAnsyuRirekis();

                        if (ansyuRirekiLst.size() != 0) {

                            ansyuRirekiLst = sortIT_AnsyuRireki
                                .OrderIT_AnsyuRirekiByAnnaisakuseiymdJyuutouymAnnainoDesc(ansyuRirekiLst);

                            IT_AnsyuRireki ansyuRireki = ansyuRirekiLst.get(0);

                            if (C_Hrkkeiro.KOUHURI.eq(ansyuRireki.getHrkkeiro())) {
                                if (C_AnnaijkKbn.ANNAI.eq(ansyuRireki.getAnnaijkkbn())) {

                                    KzHurikaeInfoSyoriKekkaBean kzHurikaeInfoSyoriKekkaBean = KzhurikenInfo(ansyuRireki, ansyuRirekiLst);
                                    String kzhurikaeymdZen = kzHurikaeInfoSyoriKekkaBean.getKzhurikaeymdZen();
                                    String kzhurikaeIraiZen = kzHurikaeInfoSyoriKekkaBean.getKzhurikaeiraikngkZen();
                                    String jyuutouymZen = kzHurikaeInfoSyoriKekkaBean.getJyuutouymZen();
                                    String jyutoukaisuumZen = kzHurikaeInfoSyoriKekkaBean.getJyutoukaisuumZen();

                                    index = index + 1;
                                    osirasemongonLst.set(index++, OSORASEKB50);
                                    osirasemongonLst.set(index++, OSORASEKB51);
                                    osirasemongonLst.set(index++, OSORASEKB52);
                                    osirasemongonLst.set(index++, OSORASEKB53 + kzhurikaeymdZen);
                                    osirasemongonLst.set(index++, OSORASEKB54 + kzhurikaeIraiZen + KBZENKAKUSPACE
                                        + jyuutouymZen + OSORASEKB55 + jyutoukaisuumZen + OSORASEKB56);
                                    osirasemongonLst.set(index++, OSORASEKB57);
                                }
                            }
                            else if (C_Hrkkeiro.CREDIT.eq(ansyuRireki.getHrkkeiro())) {

                                C_AnnaijkKbn annaijkKbn = ansyuRireki.getAnnaijkkbn();
                                BizDate annaisakuseiYmd = ansyuRireki.getAnnaisakuseiymd();
                                BizCurrency seikyuuKngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                BizDateYM jyuutouYm = null;
                                Integer jyutouKaisuum = 0;

                                for (IT_AnsyuRireki ansyuRirekiLoopYou : ansyuRirekiLst) {
                                    if (ansyuRirekiLoopYou.getAnnaijkkbn().eq(annaijkKbn) &&
                                        BizDateUtil.compareYmd(ansyuRirekiLoopYou.getAnnaisakuseiymd(),
                                            annaisakuseiYmd) == BizDateUtil.COMPARE_EQUAL) {
                                        seikyuuKngk = seikyuuKngk.add(ansyuRirekiLoopYou.getRsgaku());

                                        jyuutouYm = ansyuRirekiLoopYou.getJyuutouym();

                                        jyutouKaisuum = jyutouKaisuum + ansyuRirekiLoopYou.getJyutoukaisuum();
                                    }
                                }

                                String seikyuukngkZen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,ViewReport.editCommaTuuka(seikyuuKngk, BizUtil.ZERO_FILL));
                                String jyuutouymZen = null;
                                if (jyuutouYm != null) {
                                    jyuutouymZen = FixedDateFormatter.formatYMZenkakuSeirekiKanji(jyuutouYm.getFirstDay());
                                }
                                String jyutoukaisuumZen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, jyutouKaisuum.toString());

                                if (C_AnnaijkKbn.ANNAI.eq(ansyuRireki.getAnnaijkkbn())) {

                                    index = index + 1;

                                    osirasemongonLst.set(index++, OSORASEKB50);

                                    osirasemongonLst.set(index++, KBZENKAKUSPACE + KBUTITEN + jyuutouymZen
                                        + OSORASEKB55 + jyutoukaisuumZen + OSORASEKB63);

                                    osirasemongonLst.set(index++, OSORASEKB64);

                                    osirasemongonLst.set(index++, OSORASEKB65 + seikyuukngkZen);

                                    osirasemongonLst.set(index++, OSORASEKB66);

                                    if (C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                                        osirasemongonLst.set(index++, OSORASEKB67);

                                    }
                                    else {

                                        osirasemongonLst.set(index++, OSORASEKB68);

                                    }

                                }
                                else if (C_AnnaijkKbn.NYUUKIN.eq(ansyuRireki.getAnnaijkkbn())) {

                                    boolean creditAnnaiyouMongonoutFlg = false;

                                    boolean kaiyakujiKrkariFlg = false;

                                    if (BizDateUtil.compareYm(ansyuRireki.getNyksyoriymd().getBizDateYM(), pParam
                                        .getKouryokuYMD().getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {
                                    }
                                    else if (BizDateUtil.compareYm(ansyuRireki.getNyksyoriymd().getBizDateYM(),
                                        pKhShrRireki.getShrsyoriymd().getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {
                                    }
                                    else {
                                        creditAnnaiyouMongonoutFlg = true;

                                        if (BizDateUtil.compareYmd(pKhShrRireki.getShrsyoriymd(),
                                            ansyuRireki.getNyksyoriymd()) == BizDateUtil.COMPARE_GREATER  &&
                                            C_UmuKbn.ARI.eq(ansyuRireki.getKrkkeijyoflg())) {

                                            List<IT_Kariukekin> itKariukekinList = pKykKihon.getKariukekins();

                                            for (IT_Kariukekin itKariukekin : itKariukekinList) {
                                                if ((IKhozenCommonConstants.KINOUID_KAIYAKU.equals(itKariukekin.getGyoumuKousinKinou()) ||
                                                    IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(itKariukekin.getGyoumuKousinKinou())) &&
                                                    ansyuRireki.getKrkno().equals(itKariukekin.getKrkno()) &&
                                                    C_Krkseisanzumiflg.SUMI.eq(itKariukekin.getKrkseisanzumiflg())) {
                                                    kaiyakujiKrkariFlg = true;
                                                }
                                            }
                                        }
                                    }

                                    if (creditAnnaiyouMongonoutFlg) {

                                        index = index + 1;

                                        osirasemongonLst.set(index++, OSORASEKB50);

                                        osirasemongonLst.set(index++, KBZENKAKUSPACE + KBUTITEN + jyuutouymZen
                                            + OSORASEKB55 + jyutoukaisuumZen + OSORASEKB63);

                                        osirasemongonLst.set(index++, OSORASEKB64);

                                        osirasemongonLst.set(index++, OSORASEKB65 + seikyuukngkZen);

                                        if (kaiyakujiKrkariFlg) {

                                            osirasemongonLst.set(index++, OSORASEKB72);

                                            osirasemongonLst.set(index++, OSORASEKB73);

                                        }
                                        else {

                                            osirasemongonLst.set(index++, OSORASEKB69);

                                            osirasemongonLst.set(index++, OSORASEKB70);

                                            osirasemongonLst.set(index++, OSORASEKB71);

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else {
                    if (syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                        SortIT_AnsyuRireki sortIT_AnsyuRireki = SWAKInjector.getInstance(SortIT_AnsyuRireki.class);

                        IT_AnsyuKihon ansyuKihon = pKcp.getAnsyuuKihon(pKykKihon.getSyono());

                        List<IT_AnsyuRireki> ansyuRirekiLst = ansyuKihon.getAnsyuRirekis();

                        if (ansyuRirekiLst.size() != 0) {

                            ansyuRirekiLst = sortIT_AnsyuRireki
                                .OrderIT_AnsyuRirekiByAnnaisakuseiymdJyuutouymAnnainoDesc(ansyuRirekiLst);

                            IT_AnsyuRireki ansyuRireki = ansyuRirekiLst.get(0);

                            if (C_Hrkkeiro.KOUHURI.eq(ansyuRireki.getHrkkeiro())) {

                                if (C_AnnaijkKbn.ANNAI.eq(ansyuRireki.getAnnaijkkbn())) {

                                    KzHurikaeInfoSyoriKekkaBean kzHurikaeInfoSyoriKekkaBean = KzhurikenInfo(ansyuRireki, ansyuRirekiLst);
                                    String kzhurikaeymdZen = kzHurikaeInfoSyoriKekkaBean.getKzhurikaeymdZen();
                                    String kzhurikaeIraiZen = kzHurikaeInfoSyoriKekkaBean.getKzhurikaeiraikngkZen();
                                    String jyuutouymZen = kzHurikaeInfoSyoriKekkaBean.getJyuutouymZen();
                                    String jyutoukaisuumZen = kzHurikaeInfoSyoriKekkaBean.getJyutoukaisuumZen();

                                    index = index + 1;

                                    osirasemongonLst.set(index++, OSORASEKB50);
                                    osirasemongonLst.set(index++, OSORASEKB77);
                                    osirasemongonLst.set(index++, OSORASEKB78);
                                    osirasemongonLst.set(index++, OSORASEKB53 + kzhurikaeymdZen);
                                    osirasemongonLst.set(index++, OSORASEKB54 + kzhurikaeIraiZen + KBZENKAKUSPACE
                                        + jyuutouymZen + OSORASEKB55 + jyutoukaisuumZen + OSORASEKB56);
                                    osirasemongonLst.set(index++, OSORASEKB57);
                                }
                            }
                        }
                    }
                }

                if (C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCd)) {

                    index = index + 1;

                    osirasemongonLst.set(index++, OSORASEKB19);

                    if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getKyktuukasyu()) && !C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                        osirasemongonLst.set(index++, OSORASEKB20);

                        osirasemongonLst.set(index++, OSORASEKB21);

                    }

                    if (C_UmuKbn.ARI.eq(pKhShrRireki.getGsbunritaisyou())) {
                        if (pKhShrRireki.getShrtuukagstszeigk().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getShrtuukagstszeigk().getType())) > 0) {

                            osirasemongonLst.set(index++, OSORASEKB34);
                            osirasemongonLst.set(index++, OSORASEKB35);
                        }
                        else if(pKhShrRireki.getShrtuukagstszeigk().compareTo(
                            BizCurrency.valueOf(0, pKhShrRireki.getShrtuukagstszeigk().getType())) == 0){

                            osirasemongonLst.set(index++, OSORASEKB41);
                        }
                    }

                    else {

                        if (!C_Kaiyakujiyuu.KYKSB.eq(kaiyakuJiyuu)) {

                            if ((syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN
                                || syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN)
                                && C_UmuKbn.ARI.eq(pParam.getYuuyokknTyoukaUmu())) {

                                osirasemongonLst.set(index++, OSORASEKB58);

                            }

                            if (pKhShrRireki.getKykhnkkaisuu() == 0) {

                                osirasemongonLst.set(index++, OSORASEKB22);

                                osirasemongonLst.set(index++, OSORASEKB23);

                                osirasemongonLst.set(index++, OSORASEKB24);

                                osirasemongonLst.set(index++, OSORASEKB25);

                                osirasemongonLst.set(index++, OSORASEKB26);

                                osirasemongonLst.set(index++, OSORASEKB27);

                                osirasemongonLst.set(index++, OSORASEKB28);

                            }

                            else if (pKhShrRireki.getKykhnkkaisuu() > 0) {

                                osirasemongonLst.set(index++, OSORASEKB32);

                            }
                        }

                        if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                            osirasemongonLst.set(index++, OSORASEKB29);

                        }

                        if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN &&
                            pKhShrRireki.getKykhnkkaisuu() > 0) {

                            if (C_UmuKbn.NONE.eq(pParam.getYuuyokknTyoukaUmu())) {

                                osirasemongonLst.set(index++, OSORASEKB44);

                            }
                        }

                        if (syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                            pKhShrRireki.getKykhnkkaisuu() > 0) {

                            if (C_UmuKbn.NONE.eq(pParam.getYuuyokknTyoukaUmu())) {

                                osirasemongonLst.set(index++, OSORASEKB74);
                            }
                        }

                        if (C_Kaiyakujiyuu.KYKSB.eq(kaiyakuJiyuu)) {

                            osirasemongonLst.set(index++, OSORASEKB33);

                        }

                        if (!C_HtsiryosyuKbn.BLNK.eq(pKhShrRireki.getShrtysysyuruikbn()) ||
                            C_UmuKbn.ARI.eq(pParam.getPminyuuSyoumetuShrtyousyoOutZumiFlg())) {

                            osirasemongonLst.set(index++, OSORASEKB31);

                        }
                    }
                }
            }

            if ((C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR.eq(syoruiCd) ||
                C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR.eq(syoruiCd)) &&
                C_SoukinsakisiteiKbn.KYK.eq(pParam.getSoukinsakisiteikbn())) {

                synykngk = pKhShrRireki.getYensynykngk();

                htykeihi = pKhShrRireki.getYenhtykeihi();

                kykhnkkaisuu = pKhShrRireki.getKykhnkkaisuu();

                if (pKhShrRireki.getKykhnkkaisuu() == 0) {

                    zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI;
                }

                else if (pKhShrRireki.getKykhnkkaisuu() > 0) {

                    zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI;

                    shrkykhtykeihi = pKhShrRireki.getYenshrkykhtykeihi();
                }
            }

            else if (C_SyoruiCdKbn.KK_DSHR_TTDKKR.eq(syoruiCd)) {
                String tmttHtkinZndk = ViewReport.editCommaTuuka(pParam.getTmtthtkinzndk(), BizUtil.ZERO_FILL);

                osirasemongonLst.set(index++, HAITOUKINSIHARAIKB1);

                osirasemongonLst.set(index++, HAITOUKINSIHARAIKB2);

                osirasemongonLst.set(index++, HAITOUKINSIHARAIKB3 + tmttHtkinZndk + HAITOUKINSIHARAIKB4);

            }

            if (C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR.eq(syoruiCd)) {

                if ((C_DseisantetudukimeiKbn.KAIYAKU.eq(pParam.getDseisantetudukimeiKbn()) && C_Kaiyakujiyuu.KYKSB
                    .eq(kaiyakuJiyuu)) ||
                    (C_DseisantetudukimeiKbn.SIBOU.eq(pParam.getDseisantetudukimeiKbn()) &&
                        (C_Syoumetujiyuu.SIBOU.eq(syoumetujiyuu) ||
                            C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(syoumetujiyuu) ||
                            C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU.eq(syoumetujiyuu) ||
                            C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI.eq(syoumetujiyuu)) &&
                            !C_ZeitratkiKbn.ITIJI.eq(dseisanzeitratkiKbn))) {

                    zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU;
                    synykngk = pKhShrRireki.getYensynykngk();

                }
                else {

                    if (pKhShrRireki.getKykhnkkaisuu() == 0) {

                        zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI;
                        synykngk = pKhShrRireki.getYensynykngk();
                        htykeihi = pKhShrRireki.getYenhtykeihi();

                        zeimumongonoutkbn = C_UmuKbn.ARI;
                        zeimumongonLst.set(indexzeimu++, SAME + siharainen + ZEIMUKB1);

                    }
                    else {

                        zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI;
                        synykngk = pKhShrRireki.getYensynykngk();
                        htykeihi = pKhShrRireki.getYenhtykeihi();
                        shrkykhtykeihi = pKhShrRireki.getYenshrkykhtykeihi();

                        zeimumongonoutkbn = C_UmuKbn.ARI;
                        zeimumongonLst.set(indexzeimu++, SAME + siharainen + ZEIMUKB1);
                        zeimumongonLst.set(indexzeimu++, ZEIMUKB2);
                        zeimumongonLst.set(indexzeimu++, ZEIMUKB3);
                        zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI;
                    }
                }

                kykhnkkaisuu = pKhShrRireki.getKykhnkkaisuu();

            }
            else if(C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI.eq(syoruiCd)) {

                if (!C_Tuukasyu.JPY.eq(pKhShrRireki.getKyktuukasyu()) &&
                    C_Tuukasyu.JPY.eq(pKhShrRireki.getShrtuukasyu())) {

                    osiraseinjihuyouhyouji = C_OsiraseinjihuyouKbn.YOU;

                    osirasemongonhyoudai = HYOUDAIKB1;

                    osirasemongonLst.set(index++, OSORASEKB11);

                    osirasemongonLst.set(index++, OSORASEKB75);

                    osirasemongonLst.set(index++, OSORASEKB76);

                    osirasemongonLst.set(index++, OSORASEKB15);

                    osirasemongonLst.set(index++, OSORASEKB39);

                    osirasemongonLst.set(index++, OSORASEKB40);

                    osirasemongonLst.set(index++, OSORASEKB16);

                    osirasemongonLst.set(index++, OSORASEKB17);

                    osirasemongonLst.set(index++, OSORASEKB18);

                    osirasemongonLst.set(index++, OSORASEKB43);
                }
                else {
                    osiraseinjihuyouhyouji = C_OsiraseinjihuyouKbn.HUYOU;
                }
            }

            if (C_UmuKbn.ARI.eq(pParam.getYuuyokknTyoukaUmu())) {

                ttdkKan.setSyoruiCd(C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR);
            }

            ttdkKan.setYenshrtktekiumu(pKhShrRireki.getYenshrtkumu());

            ttdkKan.setShrymd(pKhShrRireki.getShrymd());

            ttdkKan.setCalckijyunymd(pParam.getCalckijyunYMD());

            ttdkKan.setKaiykymd(kaiykymd);

            ttdkKan.setDseisanshrttdknm(dSeisanShrTtdkNm);

            ttdkKan.setShrtuukasyu(pKhShrRireki.getShrtuukasyu());

            ttdkKan.setShrtuukasyuryk(shrTuukaNm);

            ttdkKan.setShrgkkei(pKhShrRireki.getShrtuukashrgkgoukei());

            ttdkKan.setHnkngk(pKhShrRireki.getShrtuukashrgkgoukei());

            ttdkKan.setHnkntuukasyu(pKhShrRireki.getShrtuukasyu());

            ttdkKan.setHnknymd(pKhShrRireki.getShrymd());

            ttdkKan.setShrtienrsk(pKhShrRireki.getShrtuukashrtienrsk());

            ttdkKan.setBankcd(bankCd);

            ttdkKan.setSitencd(sitenCd);

            ttdkKan.setBanknmkj(bankNmKj);

            ttdkKan.setSitennmkj(sitenNmKj);

            ttdkKan.setYokinkbn(yokinKbn);

            ttdkKan.setKzsyuruikbn(kzsyuruikbn);

            ttdkKan.setKouzano(kzNo);

            ttdkKan.setKzmeiginmkn(kzMeigiNmKn);

            ttdkKan.setSoukinsakisiteikbn(pParam.getSoukinsakisiteikbn());

            ttdkKan.setHtsiryosyukbn(pKhShrRireki.getShrtysysyuruikbn());

            ttdkKan.setTekiyou1(tekiyouLst.get(0));

            ttdkKan.setTekiyou2(tekiyouLst.get(1));

            ttdkKan.setTekiyou3(tekiyouLst.get(2));

            ttdkKan.setTekiyou4(tekiyouLst.get(3));

            ttdkKan.setTekiyou5(tekiyouLst.get(4));

            ttdkKan.setTekiyou6(tekiyouLst.get(5));

            ttdkKan.setTekiyou7(tekiyouLst.get(6));

            ttdkKan.setTekiyou8(tekiyouLst.get(7));

            ttdkKan.setTekiyou9(tekiyouLst.get(8));

            ttdkKan.setTekiyou10(tekiyouLst.get(9));

            ttdkKan.setShrkngkmeisaihugou1(kngkmeisaihugouLst.get(0));

            ttdkKan.setShrkngkmeisaihugou2(kngkmeisaihugouLst.get(1));

            ttdkKan.setShrkngkmeisaihugou3(kngkmeisaihugouLst.get(2));

            ttdkKan.setShrkngkmeisaihugou4(kngkmeisaihugouLst.get(3));

            ttdkKan.setShrkngkmeisaihugou5(kngkmeisaihugouLst.get(4));

            ttdkKan.setShrkngkmeisaihugou6(kngkmeisaihugouLst.get(5));

            ttdkKan.setShrkngkmeisaihugou7(kngkmeisaihugouLst.get(6));

            ttdkKan.setShrkngkmeisaihugou8(kngkmeisaihugouLst.get(7));

            ttdkKan.setShrkngkmeisaihugou9(kngkmeisaihugouLst.get(8));

            ttdkKan.setShrkngkmeisaihugou10(kngkmeisaihugouLst.get(9));

            ttdkKan.setKngkmeisai1(kngkMeisaiLst.get(0));

            ttdkKan.setKngkmeisai2(kngkMeisaiLst.get(1));

            ttdkKan.setKngkmeisai3(kngkMeisaiLst.get(2));

            ttdkKan.setKngkmeisai4(kngkMeisaiLst.get(3));

            ttdkKan.setKngkmeisai5(kngkMeisaiLst.get(4));

            ttdkKan.setKngkmeisai6(kngkMeisaiLst.get(5));

            ttdkKan.setKngkmeisai7(kngkMeisaiLst.get(6));

            ttdkKan.setKngkmeisai8(kngkMeisaiLst.get(7));

            ttdkKan.setKngkmeisai9(kngkMeisaiLst.get(8));

            ttdkKan.setKngkmeisai10(kngkMeisaiLst.get(9));

            ttdkKan.setKngkmisituukasyu1(kngkmisituukasyuLst.get(0));

            ttdkKan.setKngkmisituukasyu2(kngkmisituukasyuLst.get(1));

            ttdkKan.setKngkmisituukasyu3(kngkmisituukasyuLst.get(2));

            ttdkKan.setKngkmisituukasyu4(kngkmisituukasyuLst.get(3));

            ttdkKan.setKngkmisituukasyu5(kngkmisituukasyuLst.get(4));

            ttdkKan.setKngkmisituukasyu6(kngkmisituukasyuLst.get(5));

            ttdkKan.setKngkmisituukasyu7(kngkmisituukasyuLst.get(6));

            ttdkKan.setKngkmisituukasyu8(kngkmisituukasyuLst.get(7));

            ttdkKan.setKngkmisituukasyu9(kngkmisituukasyuLst.get(8));

            ttdkKan.setKngkmisituukasyu10(kngkmisituukasyuLst.get(9));

            ttdkKan.setBikou1(bikouLst.get(0));

            ttdkKan.setBikou2(bikouLst.get(1));

            ttdkKan.setBikou3(bikouLst.get(2));

            ttdkKan.setBikou4(bikouLst.get(3));

            ttdkKan.setBikou5(bikouLst.get(4));

            ttdkKan.setBikou6(bikouLst.get(5));

            ttdkKan.setBikou7(bikouLst.get(6));

            ttdkKan.setBikou8(bikouLst.get(7));

            ttdkKan.setBikou9(bikouLst.get(8));

            ttdkKan.setBikou10(bikouLst.get(9));

            ttdkKan.setShrnaiyouhskmongon1(shrnaiyouhskmongon1);

            ttdkKan.setShrnaiyouhskmongon2(shrnaiyouhskmongon2);

            ttdkKan.setSynykngk(synykngk);

            ttdkKan.setHtykeihi(htykeihi);

            ttdkKan.setShrkykhtykeihi(shrkykhtykeihi);

            ttdkKan.setGsbnrkztsaeki(gsbnrkztsaeki);

            ttdkKan.setZeimumongon1(zeimumongonLst.get(0));

            ttdkKan.setZeimumongon2(zeimumongonLst.get(1));

            ttdkKan.setZeimumongon3(zeimumongonLst.get(2));

            ttdkKan.setZeimumongon4(zeimumongonLst.get(3));

            ttdkKan.setZeimumongon5(zeimumongonLst.get(4));

            ttdkKan.setZeimunaiyouhensyuctrlkbn(zeimuNaiyouHnsyuCtrlKbn);

            ttdkKan.setZeimumongonoutkbn(zeimumongonoutkbn);

            ttdkKan.setOsirasemongonhyoudai(osirasemongonhyoudai);

            ttdkKan.setOsirasemongon1(osirasemongonLst.get(0));

            ttdkKan.setOsirasemongon2(osirasemongonLst.get(1));

            ttdkKan.setOsirasemongon3(osirasemongonLst.get(2));

            ttdkKan.setOsirasemongon4(osirasemongonLst.get(3));

            ttdkKan.setOsirasemongon5(osirasemongonLst.get(4));

            ttdkKan.setOsirasemongon6(osirasemongonLst.get(5));

            ttdkKan.setOsirasemongon7(osirasemongonLst.get(6));

            ttdkKan.setOsirasemongon8(osirasemongonLst.get(7));

            ttdkKan.setOsirasemongon9(osirasemongonLst.get(8));

            ttdkKan.setOsirasemongon10(osirasemongonLst.get(9));

            ttdkKan.setOsirasemongon11(osirasemongonLst.get(10));

            ttdkKan.setOsirasemongon12(osirasemongonLst.get(11));

            ttdkKan.setOsirasemongon13(osirasemongonLst.get(12));

            ttdkKan.setOsirasemongon14(osirasemongonLst.get(13));

            ttdkKan.setOsirasemongon15(osirasemongonLst.get(14));

            ttdkKan.setOsirasemongon16(osirasemongonLst.get(15));

            ttdkKan.setOsirasemongon17(osirasemongonLst.get(16));

            ttdkKan.setOsirasemongon18(osirasemongonLst.get(17));

            ttdkKan.setOsirasemongon19(osirasemongonLst.get(18));

            ttdkKan.setOsirasemongon20(osirasemongonLst.get(19));

            ttdkKan.setOsirasemongon21(osirasemongonLst.get(20));

            ttdkKan.setOsirasemongon22(osirasemongonLst.get(21));

            ttdkKan.setOsirasemongon23(osirasemongonLst.get(22));

            ttdkKan.setOsirasemongon24(osirasemongonLst.get(23));

            ttdkKan.setOsirasemongon25(osirasemongonLst.get(24));

            ttdkKan.setOsirasemongon26(osirasemongonLst.get(25));

            ttdkKan.setOsirasemongon27(osirasemongonLst.get(26));

            ttdkKan.setOsirasemongon28(osirasemongonLst.get(27));

            ttdkKan.setOsirasemongon29(osirasemongonLst.get(28));

            ttdkKan.setOsirasemongon30(osirasemongonLst.get(29));

            ttdkKan.setOsirasemongon31(osirasemongonLst.get(30));

            ttdkKan.setOsirasemongon32(osirasemongonLst.get(31));

            ttdkKan.setOsirasemongon33(osirasemongonLst.get(32));

            ttdkKan.setOsirasemongon34(osirasemongonLst.get(33));

            ttdkKan.setOsirasemongon35(osirasemongonLst.get(34));

            ttdkKan.setOsiraseinjihuyouhyouji(osiraseinjihuyouhyouji.getValue());

            ttdkKan.setKykhnkkaisuu(kykhnkkaisuu);

            ttdkKan.setYuuyokkntyoukaumu(pParam.getYuuyokknTyoukaUmu());

        }
        else if (pKhHasseijiKazeiRireki != null) {

            String hasseiymd =
                FixedDateFormatter.formatYZenkakuSeirekiKanji(pKhHasseijiKazeiRireki.getKouryokuhasseiymd());

            int indexZeimu = 0;

            C_YendthnkzeimuinfohskKbn yendthnkzeimuinfohskKbn = C_YendthnkzeimuinfohskKbn.BLNK;

            zeimumongonLst.set(indexZeimu++, SAME + hasseiymd + ZEIMUKB1);

            zeimumongonoutkbn = C_UmuKbn.ARI;

            kykhnkkaisuu = pKhHasseijiKazeiRireki.getKykhnkkaisuu();

            htykeihi = pKhHasseijiKazeiRireki.getYenhtykeihi();

            synykngk = pKhHasseijiKazeiRireki.getYenkansansyukngkgoukei();

            gsbnrkztsaeki = pKhHasseijiKazeiRireki.getYenkztgk();

            C_HtsiryosyuKbn htsiryosyuKbn = pKhHasseijiKazeiRireki.getShrtysysyuruikbn();

            if (kykhnkkaisuu > 0) {

                zeimumongonLst.set(indexZeimu++, ZEIMUKB2);

                zeimumongonLst.set(indexZeimu++, ZEIMUKB3);

                zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI_HASSEIJI;

                shrkykhtykeihi = pKhHasseijiKazeiRireki.getYenshrkykhtykeihi();

                if (C_HtsiryosyuKbn.BLNK.eq(htsiryosyuKbn)) {

                    yendthnkzeimuinfohskKbn = C_YendthnkzeimuinfohskKbn.SHRTYSYTSG_KYKHNKARI;
                }
                else {

                    yendthnkzeimuinfohskKbn = C_YendthnkzeimuinfohskKbn.SHRTYSYTS_KYKHNKARI;
                }
            }
            else {

                zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI;

                if (C_HtsiryosyuKbn.BLNK.eq(htsiryosyuKbn)) {

                    yendthnkzeimuinfohskKbn = C_YendthnkzeimuinfohskKbn.SHRTYSYTSG_KYKHNKNASI;
                }
                else {

                    yendthnkzeimuinfohskKbn = C_YendthnkzeimuinfohskKbn.SHRTYSYTS_KYKHNKNASI;
                }
            }

            ttdkKan.setCalckijyunymd(pParam.getCalckijyunYMD());
            ttdkKan.setHtsiryosyukbn(htsiryosyuKbn);
            ttdkKan.setSynykngk(synykngk);
            ttdkKan.setHtykeihi(htykeihi);
            ttdkKan.setShrkykhtykeihi(shrkykhtykeihi);
            ttdkKan.setGsbnrkztsaeki(gsbnrkztsaeki);
            ttdkKan.setZeimumongon1(zeimumongonLst.get(0));
            ttdkKan.setZeimumongon2(zeimumongonLst.get(1));
            ttdkKan.setZeimumongon3(zeimumongonLst.get(2));
            ttdkKan.setZeimumongon4(zeimumongonLst.get(3));
            ttdkKan.setZeimumongon5(zeimumongonLst.get(4));
            ttdkKan.setZeimunaiyouhensyuctrlkbn(zeimuNaiyouHnsyuCtrlKbn);
            ttdkKan.setZeimumongonoutkbn(zeimumongonoutkbn);
            ttdkKan.setYendthnkzeimuinfohskkbn(yendthnkzeimuinfohskKbn);
            ttdkKan.setKykhnkkaisuu(kykhnkkaisuu);
        }

        if (C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR.eq(syoruiCd)) {

            ttdkKan.setTrkkzkkbn1(trkkzkkbn1);

            ttdkKan.setTrkkzknmkj1(trkkzknmkj1);

            ttdkKan.setTrkkzkseiymd1(trkkzkseiymd1);

            ttdkKan.setTrkkzkyno1(trkkzkyno1);

            ttdkKan.setTrkkzkadr1kj1(trkkzkadr1kj1);

            ttdkKan.setTrkkzkadr2kj1(trkkzkadr2kj1);

            ttdkKan.setTrkkzkadr3kj1(trkkzkadr3kj1);

            ttdkKan.setTrkkzktelno1(trkkzktelno1);

            ttdkKan.setTrkkzkkbn2(trkkzkkbn2);

            ttdkKan.setTrkkzknmkj2(trkkzknmkj2);

            ttdkKan.setTrkkzkseiymd2(trkkzkseiymd2);

            ttdkKan.setTrkkzkyno2(trkkzkyno2);

            ttdkKan.setTrkkzkadr1kj2(trkkzkadr1kj2);

            ttdkKan.setTrkkzkadr2kj2(trkkzkadr2kj2);

            ttdkKan.setTrkkzkadr3kj2(trkkzkadr3kj2);

            ttdkKan.setTrkkzktelno2(trkkzktelno2);

            ttdkKan.setKykdairinmkj(pParam.getKykdairinmkj());

            if (C_MousideninKbn.KYKHONNIN.eq(pParam.getMousideninKbn())) {

                if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())||
                        C_UktKbn.TOUROKUKAZOKU1.eq(pParam.getStdruktkbn())||
                        C_UktKbn.TOUROKUKAZOKU2.eq(pParam.getStdruktkbn())) {

                        kykomttutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN2;
                    }
                    else {

                        kykomttutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN3;

                    }
                }
                else {

                    kykomttutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN2;
                }
            }
            else if (C_MousideninKbn.TRKKZK1.eq(pParam.getMousideninKbn()) ||
                C_MousideninKbn.TRKKZK2.eq(pParam.getMousideninKbn())) {

                if (C_KzkTrkServicettdkKbn.HENKOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    if (C_TrkkzkttdkKbn.SAKUJYO.eq(pParam.getTrkkzkttdkKbn1()) ||
                        C_TrkkzkttdkKbn.SAKUJYO.eq(pParam.getTrkkzkttdkKbn2())) {

                        kykomttutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN2;
                    }
                }
                else if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    kykomttutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN3;
                }
            }
            else if (C_MousideninKbn.HHKNHONNIN.eq(pParam.getMousideninKbn())) {

                if (C_KzkTrkServicettdkKbn.HENKOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    kykomttutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN2;
                }
                else if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    kykomttutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN3;
                }
            }

            if (KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN2.equals(kykomttutkbn)) {

                if (C_KzkTrkServicettdkKbn.TOUROKU.eq(pParam.getTrkKzkServicettdkKbn()) ||
                    C_KzkTrkServicettdkKbn.HENKOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    if (!C_TrkKzkKbn.BLNK.eq(trkkzkkbn1) && !C_TrkKzkKbn.BLNK.eq(trkkzkkbn2)) {

                        kykurtutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                    }
                    else {

                        kykurtutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN2;
                    }
                }
                else if (C_KzkTrkServicettdkKbn.BLNK.eq(pParam.getTrkKzkServicettdkKbn())||
                    C_KzkTrkServicettdkKbn.SYUURYOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    kykurtutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN3;
                }
            }

            if (C_MousideninKbn.KYKHONNIN.eq(pParam.getMousideninKbn())) {

                kykaistmsgkbn = KZKTOUROKU_AISTMSGKBN4;
            }
            else if (C_MousideninKbn.TRKKZK1.eq(pParam.getMousideninKbn()) ||
                C_MousideninKbn.TRKKZK2.eq(pParam.getMousideninKbn())) {

                if (!KZKTOUROKU_KBNINIT.equals(kykomttutkbn)){

                    kykaistmsgkbn = KZKTOUROKU_AISTMSGKBN5;
                }

            }
            else if (C_MousideninKbn.HHKNHONNIN.eq(pParam.getMousideninKbn())) {

                kykaistmsgkbn = KZKTOUROKU_AISTMSGKBN6;
            }

            ttdkKan.setKykomttutkbn(kykomttutkbn);
            ttdkKan.setKykurtutkbn(kykurtutkbn);
            ttdkKan.setKykaistmsgkbn(kykaistmsgkbn);

            List<C_TuutisakuseitaisyouKbn> douhuutaisyouTuukbnLst = new ArrayList<>();
            List<C_TrkKzkKbn> douhuutaisyouTrkkzkkbnLst = new ArrayList<>();

            if (pParam.getDouhuuTaisyouList().size() != 0) {

                ttdkKan.setKzktaisyoukykkbn(KZKTOUROKU_KZKTAISYOUKYKKBN2);

                for (DouhuuTaisyouBean douhuuTaisyouBean : pParam.getDouhuuTaisyouList()) {

                    douhuutaisyouTuukbnLst.add(douhuuTaisyouBean.getTuutiSakuseiTaisyouKbn());
                    douhuutaisyouTrkkzkkbnLst.add(douhuuTaisyouBean.getTrkKzkKbn());

                    if (C_TuutisakuseitaisyouKbn.OLDTRKKZK1.eq(douhuuTaisyouBean.getTuutiSakuseiTaisyouKbn())) {

                        trkkzknmkj1 = douhuuTaisyouBean.getNmkj();
                    }
                    if (C_TuutisakuseitaisyouKbn.OLDTRKKZK2.eq(douhuuTaisyouBean.getTuutiSakuseiTaisyouKbn())) {

                        trkkzknmkj2 = douhuuTaisyouBean.getNmkj();
                    }
                    if (C_TuutisakuseitaisyouKbn.OLDKYKDRN.eq(douhuuTaisyouBean.getTuutiSakuseiTaisyouKbn())){

                        kykdairinmkj2 = douhuuTaisyouBean.getNmkj();
                    }
                }
            }

            if (douhuutaisyouTrkkzkkbnLst.contains(C_TrkKzkKbn.TRKKZK1)) {

                if (C_MousideninKbn.KYKHONNIN.eq(pParam.getMousideninKbn())) {

                    if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                        if (C_TrkKzkHnkKbn.SAKUJYO.eq(pParam.getTrkKzkHnkNiyuKbn1())) {

                            if (C_UktKbn.TOUROKUKAZOKU1.eq(pParam.getStdruktkbn())) {

                                kzkomttutkbn1 = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN3;

                                if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())) {

                                    if (C_UktKbn.TOUROKUKAZOKU1.eq(pParam.getBfrKykdairinKbn())) {

                                        kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN28;
                                    }
                                    else {

                                        kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN27;
                                    }
                                }
                                else {

                                    kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN27;
                                }
                            }
                            else {

                                kzkomttutkbn1 = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN4;

                                if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())) {

                                    if (C_UktKbn.TOUROKUKAZOKU1.eq(pParam.getBfrKykdairinKbn())) {

                                        kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN22;
                                    }
                                    else {

                                        kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN23;
                                    }
                                }
                                else {

                                    kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN23;
                                }
                            }
                        }
                    }
                    else if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())) {

                        if (C_UktKbn.TOUROKUKAZOKU1.eq(pParam.getBfrKykdairinKbn())) {

                            kzkomttutkbn1 = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN3;

                            if (C_MousideninKbn.KYKHONNIN.eq(pParam.getMousideninKbn())) {

                                if (C_KzkTrkServicettdkKbn.HENKOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                                    if (C_TrkKzkHnkKbn.SAKUJYO.eq(pParam.getTrkKzkHnkNiyuKbn1())) {

                                        if (C_UktKbn.TOUROKUKAZOKU1.eq(pParam.getStdruktkbn())) {

                                            kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN31;
                                        }
                                        else {

                                            kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN29;
                                        }
                                    }
                                    else {

                                        kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN29;
                                    }
                                }
                                else if(C_KzkTrkServicettdkKbn.BLNK.eq(pParam.getTrkKzkServicettdkKbn())){

                                    kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN29;
                                }
                            }
                        }
                    }
                }

                if (C_MousideninKbn.TRKKZK1.eq(pParam.getMousideninKbn())) {

                    if (C_TrkKzkHnkKbn.SAKUJYO.eq(pParam.getTrkKzkHnkNiyuKbn1())) {

                        kzkomttutkbn1 = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN4;
                        kzkaistmsgkbn1 = KZKTOUROKU_AISTMSGKBN11;
                    }
                }
            }

            if (douhuutaisyouTrkkzkkbnLst.contains(C_TrkKzkKbn.TRKKZK2)) {

                if (C_MousideninKbn.KYKHONNIN.eq(pParam.getMousideninKbn())) {

                    if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                        if (C_TrkKzkHnkKbn.SAKUJYO.eq(pParam.getTrkKzkHnkNiyuKbn2())) {

                            if (C_UktKbn.TOUROKUKAZOKU2.eq(pParam.getStdruktkbn())) {

                                kzkomttutkbn2 = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN3;

                                if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())) {

                                    if (C_UktKbn.TOUROKUKAZOKU2.eq(pParam.getBfrKykdairinKbn())) {

                                        kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN28;
                                    }
                                    else {

                                        kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN27;
                                    }
                                }
                                else {

                                    kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN27;
                                }
                            }
                            else {

                                kzkomttutkbn2 = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN4;

                                if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())) {

                                    if (C_UktKbn.TOUROKUKAZOKU2.eq(pParam.getBfrKykdairinKbn())) {

                                        kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN22;
                                    }
                                    else {

                                        kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN23;
                                    }
                                }
                                else {

                                    kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN23;
                                }
                            }
                        }
                    }
                    else if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())) {

                        if (C_UktKbn.TOUROKUKAZOKU2.eq(pParam.getBfrKykdairinKbn())){

                            kzkomttutkbn2 = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN3;

                            if (C_MousideninKbn.KYKHONNIN.eq(pParam.getMousideninKbn())) {

                                if (C_KzkTrkServicettdkKbn.HENKOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                                    if (C_TrkKzkHnkKbn.SAKUJYO.eq(pParam.getTrkKzkHnkNiyuKbn2())) {

                                        if (C_UktKbn.TOUROKUKAZOKU2.eq(pParam.getStdruktkbn())) {

                                            kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN31;
                                        }
                                        else {

                                            kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN29;
                                        }
                                    }
                                    else {

                                        kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN29;
                                    }
                                }
                                else if(C_KzkTrkServicettdkKbn.BLNK.eq(pParam.getTrkKzkServicettdkKbn())){

                                    kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN29;
                                }
                            }
                        }
                    }
                }

                if (C_MousideninKbn.TRKKZK2.eq(pParam.getMousideninKbn())) {

                    if (C_TrkKzkHnkKbn.SAKUJYO.eq(pParam.getTrkKzkHnkNiyuKbn2())) {

                        kzkomttutkbn2 = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN4;
                        kzkaistmsgkbn2 = KZKTOUROKU_AISTMSGKBN11;
                    }
                }
            }

            ttdkKan.setKzkomttutkbn1(kzkomttutkbn1);
            ttdkKan.setKzkomttutkbn2(kzkomttutkbn2);
            ttdkKan.setKzkaistmsgkbn1(kzkaistmsgkbn1);
            ttdkKan.setKzkaistmsgkbn2(kzkaistmsgkbn2);
            ttdkKan.setTrkkzknmkj1(trkkzknmkj1);
            ttdkKan.setTrkkzknmkj2(trkkzknmkj2);

            if (C_MousideninKbn.HHKNHONNIN.eq(pParam.getMousideninKbn())) {

                if (C_KzkTrkServicettdkKbn.HENKOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    hhkomttutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                    hhkaistmsgkbn = KZKTOUROKU_AISTMSGKBN24;
                }
                else if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    hhkomttutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN2;
                    hhkaistmsgkbn = KZKTOUROKU_AISTMSGKBN25;
                }
            }

            ttdkKan.setHhkomttutkbn(hhkomttutkbn);
            ttdkKan.setHhkaistmsgkbn(hhkaistmsgkbn);

            if (douhuutaisyouTuukbnLst.contains(C_TuutisakuseitaisyouKbn.OLDKYKDRN)) {

                kykdromttutkbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;

                ttdkKan.setKykdairiomttutkbn(kykdromttutkbn);
                ttdkKan.setKykdairinmkj2(kykdairinmkj2);
            }

            if (C_MousideninKbn.HHKNHONNIN.eq(pParam.getMousideninKbn())) {

                if (C_KzkTrkServicettdkKbn.HENKOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    if (C_TrkkzkttdkKbn.SAKUJYO.eq(pParam.getTrkkzkttdkKbn1())) {
                        sakujyokzknmkj = pParam.getSakujyoTrkKzknm1();

                    }
                    if (C_TrkkzkttdkKbn.SAKUJYO.eq(pParam.getTrkkzkttdkKbn2())) {
                        sakujyokzknmkj = pParam.getSakujyoTrkKzknm2();
                    }

                }

            }

            ttdkKan.setSakujyokzknmkj(sakujyokzknmkj);

            if (!KZKTOUROKU_KBNINIT.equals(kykomttutkbn)) {

                if (C_KzkTrkServicettdkKbn.TOUROKU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pParam.getKykdrtkykttdkKbn())) {

                        ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN7;
                    }
                    if (C_KykdrtkykttdkKbn.HENKOU.eq(pParam.getKykdrtkykttdkKbn()) ||
                        C_KykdrtkykttdkKbn.BLNK.eq(pParam.getKykdrtkykttdkKbn())) {

                        if (!BizUtil.isBlank(pParam.getKykdairinmkj())) {

                            ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN8;
                        }
                        else {

                            ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN1;
                        }
                    }
                }
                if (C_KzkTrkServicettdkKbn.HENKOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pParam.getKykdrtkykttdkKbn())) {

                        ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN9;
                    }
                    if (C_KykdrtkykttdkKbn.HENKOU.eq(pParam.getKykdrtkykttdkKbn()) ||
                        C_KykdrtkykttdkKbn.BLNK.eq(pParam.getKykdrtkykttdkKbn())) {

                        if (!BizUtil.isBlank(pParam.getKykdairinmkj())) {

                            ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN10;
                        }
                        else {

                            ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN2;
                        }
                    }
                    if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())) {

                        ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN11;
                    }
                }
                if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    if (C_KykdrtkykttdkKbn.BLNK.eq(pParam.getKykdrtkykttdkKbn())) {

                        ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN3;
                    }
                    if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())) {

                        ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN12;
                    }
                }
                if (C_KzkTrkServicettdkKbn.BLNK.eq(pParam.getTrkKzkServicettdkKbn())) {

                    if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pParam.getKykdrtkykttdkKbn())) {

                        ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN4;
                    }
                    if (C_KykdrtkykttdkKbn.HENKOU.eq(pParam.getKykdrtkykttdkKbn()) ||
                        C_KykdrtkykttdkKbn.BLNK.eq(pParam.getKykdrtkykttdkKbn())) {

                        if (!BizUtil.isBlank(pParam.getKykdairinmkj())) {

                            ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN5;
                        }
                    }
                    if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())) {

                        ttdknaiyoukbn = KZKTOUROKU_TTDKNAIYOUKBN6;
                    }
                }
            }

            ttdkKan.setTtdknaiyoukbn(ttdknaiyoukbn);

            if (!KZKTOUROKU_KBNINIT.equals(kykurtutkbn)) {

                moshnkniymsgkbn1 = KZKTOUROKU_MOSHNKNIYMSGKBN1;
            }

            if(!KZKTOUROKU_KBNINIT.equals(kykomttutkbn)){

                if (C_KzkTrkServicettdkKbn.TOUROKU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    kykmoshnkniymsg2 = KZKTOUROKU_MOSHNKNIYMSGKBN1;
                }
                if (C_KzkTrkServicettdkKbn.HENKOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    kykmoshnkniymsg2 = KZKTOUROKU_MOSHNKNIYMSGKBN2;
                }
                if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(pParam.getTrkKzkServicettdkKbn())) {

                    kykmoshnkniymsg2 = KZKTOUROKU_MOSHNKNIYMSGKBN3;
                }
            }

            if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pParam.getKykdrtkykttdkKbn())) {

                kykdrmsgkbn = KZKTOUROKU_KYKDRMSGKBN3;
            }
            if (C_KykdrtkykttdkKbn.HENKOU.eq(pParam.getKykdrtkykttdkKbn()) ||
                C_KykdrtkykttdkKbn.BLNK.eq(pParam.getKykdrtkykttdkKbn())) {

                if (!BizUtil.isBlank(pParam.getKykdairinmkj())) {

                    kykdrmsgkbn = KZKTOUROKU_KYKDRMSGKBN6;
                }
            }
            if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pParam.getKykdrtkykttdkKbn())) {

                kykdrmsgkbn = KZKTOUROKU_KYKDRMSGKBN7;
            }

            ttdkKan.setMoshnkniymsgkbn1(moshnkniymsgkbn1);
            ttdkKan.setKykmoshnkniymsg2(kykmoshnkniymsg2);
            ttdkKan.setKykdrmsgkbn(kykdrmsgkbn);

            if (!BizUtil.isBlank(pParam.getStdrsknmkj())) {

                kykhhkdrmsg = KZKTOUROKU_HHKDRMSG1;
            }

            if (C_UktKbn.TOUROKUKAZOKU1.eq(pParam.getStdruktkbn())) {

                if (C_TrkKzkHnkKbn.SAKUJYO.eq(pParam.getTrkKzkHnkNiyuKbn1())) {

                    kykhhkdrmsg = KZKTOUROKU_HHKDRMSG2;
                }
            }
            if (C_UktKbn.TOUROKUKAZOKU2.eq(pParam.getStdruktkbn())) {

                if (C_TrkKzkHnkKbn.SAKUJYO.eq(pParam.getTrkKzkHnkNiyuKbn2())) {

                    kykhhkdrmsg = KZKTOUROKU_HHKDRMSG2;
                }
            }

            ttdkKan.setKykhhkdrmsg(kykhhkdrmsg);
            ttdkKan.setHhkdrnmkj(pParam.getStdrsknmkj());

            List<C_TuutisakuseitaisyouKbn> tyokusouTuutiSakuseiKbnLst = new ArrayList<>();

            if (pParam.getTyokusouTaisyouList().size() != 0) {

                for (TyokusouTaisyouBean tyokusouTaisyouBean : pParam.getTyokusouTaisyouList()){

                    tyokusouTuutiSakuseiKbnLst.add(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn());
                }
            }

            Set<String> duhubutuMsgSet = new LinkedHashSet<String>();

            if (C_KzkTrkServicettdkKbn.TOUROKU.eq(pParam.getTrkKzkServicettdkKbn()) ||
                C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pParam.getKykdrtkykttdkKbn())) {

                yakkankiyakuhunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI1;
                duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG1);
            }

            if (C_TrkKzkHnkKbn.TOUROKU.eq(pParam.getTrkKzkHnkNiyuKbn1())) {

                if (!tyokusouTuutiSakuseiKbnLst.contains(C_TuutisakuseitaisyouKbn.TRKKZK1)) {

                    kzktrktrshuunyuuhyouji1 = KZKTOUROKU_HUNYUUHYOUJI1;
                    duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG4);
                }
            }

            if (C_TrkKzkHnkKbn.TOUROKU.eq(pParam.getTrkKzkHnkNiyuKbn2())) {

                if (!tyokusouTuutiSakuseiKbnLst.contains(C_TuutisakuseitaisyouKbn.TRKKZK2)){

                    kzktrktrshuunyuuhyouji2 = KZKTOUROKU_HUNYUUHYOUJI1;
                    duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG4);
                }
            }

            if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pParam.getKykdrtkykttdkKbn()) ||
                C_KykdrtkykttdkKbn.HENKOU.eq(pParam.getKykdrtkykttdkKbn())) {

                if (C_UktKbn.TOUROKUKAZOKU1.eq(pParam.getAftKykdairinKbn())) {

                    if (!tyokusouTuutiSakuseiKbnLst.contains(C_TuutisakuseitaisyouKbn.TRKKZK1)) {

                        kykdrhuunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI1;

                        duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG7);
                    }
                }
                if (C_UktKbn.TOUROKUKAZOKU2.eq(pParam.getAftKykdairinKbn())) {

                    if (!tyokusouTuutiSakuseiKbnLst.contains(C_TuutisakuseitaisyouKbn.TRKKZK2)) {

                        kykdrhuunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI1;

                        duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG7);
                    }
                }
            }

            if (C_KykdrtkykttdkKbn.BLNK.eq(pParam.getKykdrtkykttdkKbn())) {

                if (C_UktKbn.TOUROKUKAZOKU1.eq(pParam.getAftKykdairinKbn()) &&
                    C_TrkKzkHnkKbn.TOUROKU.eq(pParam.getTrkKzkHnkNiyuKbn1())) {

                    if (!tyokusouTuutiSakuseiKbnLst.contains(C_TuutisakuseitaisyouKbn.TRKKZK1)) {

                        kykdrhuunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI1;
                        duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG7);
                    }
                }

                if (C_UktKbn.TOUROKUKAZOKU2.eq(pParam.getAftKykdairinKbn()) &&
                    C_TrkKzkHnkKbn.TOUROKU.eq(pParam.getTrkKzkHnkNiyuKbn2())) {

                    if (!tyokusouTuutiSakuseiKbnLst.contains(C_TuutisakuseitaisyouKbn.TRKKZK2)) {

                        kykdrhuunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI1;
                        duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG7);
                    }
                }
            }

            if (C_UktKbn.TOUROKUKAZOKU1.eq(pParam.getStdruktkbn()) &&
                C_TrkKzkHnkKbn.TOUROKU.eq(pParam.getTrkKzkHnkNiyuKbn1())) {

                if (!tyokusouTuutiSakuseiKbnLst.contains(C_TuutisakuseitaisyouKbn.TRKKZK1)) {

                    hhkdrhuunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI1;
                    duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG9);
                }
            }

            if (C_UktKbn.TOUROKUKAZOKU2.eq(pParam.getStdruktkbn()) &&
                C_TrkKzkHnkKbn.TOUROKU.eq(pParam.getTrkKzkHnkNiyuKbn2())) {

                if (!tyokusouTuutiSakuseiKbnLst.contains(C_TuutisakuseitaisyouKbn.TRKKZK2)) {

                    hhkdrhuunyuuhyouji = KZKTOUROKU_HUNYUUHYOUJI1;
                    duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG9);
                }
            }

            if (douhuutaisyouTuukbnLst.contains(C_TuutisakuseitaisyouKbn.HHKN)) {

                duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG12);
            }

            if (douhuutaisyouTuukbnLst.contains(C_TuutisakuseitaisyouKbn.OLDTRKKZK1) ||
                douhuutaisyouTuukbnLst.contains(C_TuutisakuseitaisyouKbn.OLDTRKKZK2)) {

                duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG3);
            }

            if (douhuutaisyouTuukbnLst.contains(C_TuutisakuseitaisyouKbn.OLDKYKDRN)) {

                duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG6);
            }

            if (duhubutuMsgSet.size() == 0 &&
                pParam.getTyokusouTaisyouList().size() != 0) {

                duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG11);
            }

            if (pParam.getTyokusouTaisyouList().size() != 0) {

                duhubutuMsgSet.add(KZKTOUROKU_DUHUBUTUMSG50);
            }

            if (duhubutuMsgSet.size() > 0) {

                Iterator<String> iterator = duhubutuMsgSet.iterator();

                int i = 0;

                while  (iterator.hasNext()) {

                    String duhubutuMsg = iterator.next();

                    if (i == 0) {

                        duhubutumsg1 = duhubutuMsg;
                    }
                    else if (i == 1) {

                        duhubutumsg2 = duhubutuMsg;
                    }
                    else if (i == 2) {

                        duhubutumsg3 = duhubutuMsg;
                    }
                    else if (i == 3) {

                        duhubutumsg4 = duhubutuMsg;
                    }
                    else if (i == 4) {

                        duhubutumsg5 = duhubutuMsg;
                    }
                    else if (i == 5) {

                        duhubutumsg6 = duhubutuMsg;
                    }
                    else if (i == 6) {

                        duhubutumsg7 = duhubutuMsg;
                    }

                    i++;
                }
            }

            ttdkKan.setDuhubutumsg1(duhubutumsg1);

            ttdkKan.setDuhubutumsg2(duhubutumsg2);

            ttdkKan.setDuhubutumsg3(duhubutumsg3);

            ttdkKan.setDuhubutumsg4(duhubutumsg4);

            ttdkKan.setDuhubutumsg5(duhubutumsg5);

            ttdkKan.setDuhubutumsg6(duhubutumsg6);

            ttdkKan.setDuhubutumsg7(duhubutumsg7);

            ttdkKan.setYakkankiyakuhunyuuhyouji(yakkankiyakuhunyuuhyouji);

            ttdkKan.setKyktrktrshuunyuuhyouji(kyktrktrshuunyuuhyouji);

            ttdkKan.setKzktrktrshuunyuuhyouji1(kzktrktrshuunyuuhyouji1);

            ttdkKan.setKzktrktrshuunyuuhyouji2(kzktrktrshuunyuuhyouji2);

            ttdkKan.setKykdrhuunyuuhyouji(kykdrhuunyuuhyouji);

            ttdkKan.setHhkdrhuunyuuhyouji(hhkdrhuunyuuhyouji);
        }

        BizPropertyInitializer.initialize(ttdkKan);

        return ttdkKan;
    }

    public ReportServicesBean editBean(C_SyoruiCdKbn pSyoruiCdKbn, KhozenCommonParam pKcp,
        IT_TtdkKan pTtdkKan, IT_KykSya pKykSya) {

        if (pTtdkKan == null) {
            return null;
        }

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
            pKcp.getCategoryId(),
            pKcp.getFunctionId(),
            pSyoruiCdKbn);

        reportServicesBean.setKensakuKeys(pTtdkKan.getSyono());

        String tyouhyouymd1 = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pTtdkKan.getTyouhyouymd());

        String siharaihi = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pTtdkKan.getShrymd());

        String keisankijyunbi = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pTtdkKan.getCalckijyunymd());

        String kaiyakubi = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pTtdkKan.getKaiykymd());

        String henkinhi = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pTtdkKan.getHnknymd());

        String kazeinendo = FixedDateFormatter.formatYZenkakuSeirekiKanji(pTtdkKan.getShrymd());

        String henkintuukasyuruimei = C_Tuukasyu.getContentByValue(C_Tuukasyu.PATTERN_DEFAULT, pTtdkKan
            .getHnkntuukasyu().getValue());


        String[] hensyuugoAdr = ViewReport.editAdrDisp(24, pTtdkKan.getShsadr1kj(), pTtdkKan.getShsadr2kj(), pTtdkKan.getShsadr3kj());

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;

        if (C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR.eq(pSyoruiCdKbn)) {

            syoruiCdKbn = C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR;
        }
        else{

            syoruiCdKbn = pSyoruiCdKbn;
        }

        KhTtdkkanryouBean khTtdkkanryouBean = SWAKInjector.getInstance(KhTtdkkanryouBean.class);

        BzKokyakuAtesakiBean kokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);

        khTtdkkanryouBean.setIrTyouhyousakuseiymd(tyouhyouymd1);

        khTtdkkanryouBean.setIrTetudukisyukbn(pTtdkKan.getTetudukisyukbn());

        khTtdkkanryouBean.setIrSyoruicd(syoruiCdKbn);

        khTtdkkanryouBean.setIrSyono(pTtdkKan.getSyono());

        khTtdkkanryouBean.setIrSyorikbn(pTtdkKan.getSyorikbn());

        khTtdkkanryouBean.setIrKyknmkj(pTtdkKan.getKyknmkj());

        khTtdkkanryouBean.setIrHhknnmkj(pTtdkKan.getHhknnmkj());

        khTtdkkanryouBean.setIrShrymd(siharaihi);

        khTtdkkanryouBean.setIrShrtienrsk(pTtdkKan.getShrtienrsk());

        khTtdkkanryouBean.setIrShrgk(pTtdkKan.getShrgkkei());

        khTtdkkanryouBean.setIrCalckijyunymd(keisankijyunbi);

        khTtdkkanryouBean.setIrKaiykymd(kaiyakubi);

        khTtdkkanryouBean.setIrTekiyou1(pTtdkKan.getTekiyou1());

        if (!C_Tuukasyu.BLNK.eq(pTtdkKan.getKngkmisituukasyu1())) {
            khTtdkkanryouBean.setIrKngkmeisai1(doKingakuHenkan(pTtdkKan.getShrkngkmeisaihugou1(), pTtdkKan.getKngkmeisai1()));

            khTtdkkanryouBean.setIrKngkmisituukasyunm1(pTtdkKan.getKngkmisituukasyu1().getContent());
        }

        khTtdkkanryouBean.setIrBikou1(pTtdkKan.getBikou1());

        khTtdkkanryouBean.setIrTekiyou2(pTtdkKan.getTekiyou2());

        if (!C_Tuukasyu.BLNK.eq(pTtdkKan.getKngkmisituukasyu2())) {
            khTtdkkanryouBean.setIrKngkmeisai2(doKingakuHenkan(pTtdkKan.getShrkngkmeisaihugou2(), pTtdkKan.getKngkmeisai2()));

            khTtdkkanryouBean.setIrKngkmisituukasyunm2(pTtdkKan.getKngkmisituukasyu2().getContent());
        }

        khTtdkkanryouBean.setIrBikou2(pTtdkKan.getBikou2());

        khTtdkkanryouBean.setIrTekiyou3(pTtdkKan.getTekiyou3());

        if (!C_Tuukasyu.BLNK.eq(pTtdkKan.getKngkmisituukasyu3())) {
            khTtdkkanryouBean.setIrKngkmeisai3(doKingakuHenkan(pTtdkKan.getShrkngkmeisaihugou3(), pTtdkKan.getKngkmeisai3()));

            khTtdkkanryouBean.setIrKngkmisituukasyunm3(pTtdkKan.getKngkmisituukasyu3().getContent());
        }

        khTtdkkanryouBean.setIrBikou3(pTtdkKan.getBikou3());

        khTtdkkanryouBean.setIrTekiyou4(pTtdkKan.getTekiyou4());

        if (!C_Tuukasyu.BLNK.eq(pTtdkKan.getKngkmisituukasyu4())) {
            khTtdkkanryouBean.setIrKngkmeisai4(doKingakuHenkan(pTtdkKan.getShrkngkmeisaihugou4(), pTtdkKan.getKngkmeisai4()));

            khTtdkkanryouBean.setIrKngkmisituukasyunm4(pTtdkKan.getKngkmisituukasyu4().getContent());
        }

        khTtdkkanryouBean.setIrBikou4(pTtdkKan.getBikou4());

        khTtdkkanryouBean.setIrTekiyou5(pTtdkKan.getTekiyou5());

        if (!C_Tuukasyu.BLNK.eq(pTtdkKan.getKngkmisituukasyu5())) {
            khTtdkkanryouBean.setIrKngkmeisai5(doKingakuHenkan(pTtdkKan.getShrkngkmeisaihugou5(), pTtdkKan.getKngkmeisai5()));

            khTtdkkanryouBean.setIrKngkmisituukasyunm5(pTtdkKan.getKngkmisituukasyu5().getContent());
        }

        khTtdkkanryouBean.setIrBikou5(pTtdkKan.getBikou5());

        khTtdkkanryouBean.setIrTekiyou6(pTtdkKan.getTekiyou6());

        if (!C_Tuukasyu.BLNK.eq(pTtdkKan.getKngkmisituukasyu6())) {
            khTtdkkanryouBean.setIrKngkmeisai6(doKingakuHenkan(pTtdkKan.getShrkngkmeisaihugou6(), pTtdkKan.getKngkmeisai6()));

            khTtdkkanryouBean.setIrKngkmisituukasyunm6(pTtdkKan.getKngkmisituukasyu6().getContent());
        }

        khTtdkkanryouBean.setIrBikou6(pTtdkKan.getBikou6());

        khTtdkkanryouBean.setIrTekiyou7(pTtdkKan.getTekiyou7());

        if (!C_Tuukasyu.BLNK.eq(pTtdkKan.getKngkmisituukasyu7())) {
            khTtdkkanryouBean.setIrKngkmeisai7(doKingakuHenkan(pTtdkKan.getShrkngkmeisaihugou7(), pTtdkKan.getKngkmeisai7()));

            khTtdkkanryouBean.setIrKngkmisituukasyunm7(pTtdkKan.getKngkmisituukasyu7().getContent());
        }

        khTtdkkanryouBean.setIrBikou7(pTtdkKan.getBikou7());

        khTtdkkanryouBean.setIrTekiyou8(pTtdkKan.getTekiyou8());

        if (!C_Tuukasyu.BLNK.eq(pTtdkKan.getKngkmisituukasyu8())) {
            khTtdkkanryouBean.setIrKngkmeisai8(doKingakuHenkan(pTtdkKan.getShrkngkmeisaihugou8(), pTtdkKan.getKngkmeisai8()));

            khTtdkkanryouBean.setIrKngkmisituukasyunm8(pTtdkKan.getKngkmisituukasyu8().getContent());
        }

        khTtdkkanryouBean.setIrBikou8(pTtdkKan.getBikou8());

        khTtdkkanryouBean.setIrTekiyou9(pTtdkKan.getTekiyou9());

        if (!C_Tuukasyu.BLNK.eq(pTtdkKan.getKngkmisituukasyu9())) {
            khTtdkkanryouBean.setIrKngkmeisai9(doKingakuHenkan(pTtdkKan.getShrkngkmeisaihugou9(), pTtdkKan.getKngkmeisai9()));

            khTtdkkanryouBean.setIrKngkmisituukasyunm9(pTtdkKan.getKngkmisituukasyu9().getContent());
        }

        khTtdkkanryouBean.setIrBikou9(pTtdkKan.getBikou9());

        khTtdkkanryouBean.setIrTekiyou10(pTtdkKan.getTekiyou10());

        if (!C_Tuukasyu.BLNK.eq(pTtdkKan.getKngkmisituukasyu10())) {
            khTtdkkanryouBean.setIrKngkmeisai10(doKingakuHenkan(pTtdkKan.getShrkngkmeisaihugou10(), pTtdkKan.getKngkmeisai10()));

            khTtdkkanryouBean.setIrKngkmisituukasyunm10(pTtdkKan.getKngkmisituukasyu10().getContent());
        }

        khTtdkkanryouBean.setIrBikou10(pTtdkKan.getBikou10());

        khTtdkkanryouBean.setIrShrtuukasyuryk(pTtdkKan.getShrtuukasyuryk());

        khTtdkkanryouBean.setIrSynykngk(pTtdkKan.getSynykngk());

        khTtdkkanryouBean.setIrHtykeihi(pTtdkKan.getHtykeihi());

        khTtdkkanryouBean.setIrShrkyksyahtykeihi(pTtdkKan.getShrkykhtykeihi());

        khTtdkkanryouBean.setIrGsbnrkztsaeki(pTtdkKan.getGsbnrkztsaeki());

        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(pTtdkKan.getZeimunaiyouhensyuctrlkbn());

        khTtdkkanryouBean.setIrBanknmkj(pTtdkKan.getBanknmkj());

        khTtdkkanryouBean.setIrSitennmkj(pTtdkKan.getSitennmkj());

        khTtdkkanryouBean.setIrYokinkbn(pTtdkKan.getYokinkbn());

        khTtdkkanryouBean.setIrKouzano(pTtdkKan.getKouzano());

        khTtdkkanryouBean.setIrKzmeiginmkn(pTtdkKan.getKzmeiginmkn());

        khTtdkkanryouBean.setIrHtsiryosyukbn(pTtdkKan.getHtsiryosyukbn());

        khTtdkkanryouBean.setIrSoukinsakisiteikbn(pTtdkKan.getSoukinsakisiteikbn());

        khTtdkkanryouBean.setIrKazeinendo(kazeinendo);

        khTtdkkanryouBean.setIrKaiyakujiyuu(pTtdkKan.getKaiyakujiyuu());

        khTtdkkanryouBean.setIrShrumu(pTtdkKan.getShrumu());

        khTtdkkanryouBean.setIrYenshrtktekiumu(pTtdkKan.getYenshrtktekiumu());

        khTtdkkanryouBean.setIrBankcd(pTtdkKan.getBankcd());

        khTtdkkanryouBean.setIrHnkngkkngk(pTtdkKan.getHnkngk());

        khTtdkkanryouBean.setIrHnkntuukasyunm(henkintuukasyuruimei);

        khTtdkkanryouBean.setIrHnknymd(henkinhi);

        khTtdkkanryouBean.setIrZeimumongon1(pTtdkKan.getZeimumongon1());

        khTtdkkanryouBean.setIrZeimumongon2(pTtdkKan.getZeimumongon2());

        khTtdkkanryouBean.setIrZeimumongon3(pTtdkKan.getZeimumongon3());

        khTtdkkanryouBean.setIrZeimumongon4(pTtdkKan.getZeimumongon4());

        khTtdkkanryouBean.setIrZeimumongon5(pTtdkKan.getZeimumongon5());

        khTtdkkanryouBean.setIrOsirasemongon1(pTtdkKan.getOsirasemongon1());

        khTtdkkanryouBean.setIrOsirasemongon2(pTtdkKan.getOsirasemongon2());

        khTtdkkanryouBean.setIrOsirasemongon3(pTtdkKan.getOsirasemongon3());

        khTtdkkanryouBean.setIrOsirasemongon4(pTtdkKan.getOsirasemongon4());

        khTtdkkanryouBean.setIrOsirasemongon5(pTtdkKan.getOsirasemongon5());

        khTtdkkanryouBean.setIrOsirasemongon6(pTtdkKan.getOsirasemongon6());

        khTtdkkanryouBean.setIrOsirasemongon7(pTtdkKan.getOsirasemongon7());

        khTtdkkanryouBean.setIrOsirasemongon8(pTtdkKan.getOsirasemongon8());

        khTtdkkanryouBean.setIrOsirasemongon9(pTtdkKan.getOsirasemongon9());

        khTtdkkanryouBean.setIrOsirasemongon10(pTtdkKan.getOsirasemongon10());

        khTtdkkanryouBean.setIrOsirasemongon11(pTtdkKan.getOsirasemongon11());

        khTtdkkanryouBean.setIrOsirasemongon12(pTtdkKan.getOsirasemongon12());

        khTtdkkanryouBean.setIrOsirasemongon13(pTtdkKan.getOsirasemongon13());

        khTtdkkanryouBean.setIrOsirasemongon14(pTtdkKan.getOsirasemongon14());

        khTtdkkanryouBean.setIrOsirasemongon15(pTtdkKan.getOsirasemongon15());

        khTtdkkanryouBean.setIrOsirasemongon16(pTtdkKan.getOsirasemongon16());

        khTtdkkanryouBean.setIrOsirasemongon17(pTtdkKan.getOsirasemongon17());

        khTtdkkanryouBean.setIrOsirasemongon18(pTtdkKan.getOsirasemongon18());

        khTtdkkanryouBean.setIrOsirasemongon19(pTtdkKan.getOsirasemongon19());

        khTtdkkanryouBean.setIrOsirasemongon20(pTtdkKan.getOsirasemongon20());

        khTtdkkanryouBean.setIrOsirasemongon21(pTtdkKan.getOsirasemongon21());

        khTtdkkanryouBean.setIrOsirasemongon22(pTtdkKan.getOsirasemongon22());

        khTtdkkanryouBean.setIrOsirasemongon23(pTtdkKan.getOsirasemongon23());

        khTtdkkanryouBean.setIrOsirasemongon24(pTtdkKan.getOsirasemongon24());

        khTtdkkanryouBean.setIrOsirasemongon25(pTtdkKan.getOsirasemongon25());

        khTtdkkanryouBean.setIrOsirasemongon26(pTtdkKan.getOsirasemongon26());

        khTtdkkanryouBean.setIrOsirasemongon27(pTtdkKan.getOsirasemongon27());

        khTtdkkanryouBean.setIrOsirasemongon28(pTtdkKan.getOsirasemongon28());

        khTtdkkanryouBean.setIrOsirasemongon29(pTtdkKan.getOsirasemongon29());

        khTtdkkanryouBean.setIrOsirasemongon30(pTtdkKan.getOsirasemongon30());

        khTtdkkanryouBean.setIrOsirasemongon31(pTtdkKan.getOsirasemongon31());

        khTtdkkanryouBean.setIrOsirasemongon32(pTtdkKan.getOsirasemongon32());

        khTtdkkanryouBean.setIrOsirasemongon33(pTtdkKan.getOsirasemongon33());

        khTtdkkanryouBean.setIrOsirasemongon34(pTtdkKan.getOsirasemongon34());

        khTtdkkanryouBean.setIrOsirasemongon35(pTtdkKan.getOsirasemongon35());

        khTtdkkanryouBean.setIrShrnaiyouhskmongon1(pTtdkKan.getShrnaiyouhskmongon1());

        khTtdkkanryouBean.setIrYuuyokkntyoukaumu(pTtdkKan.getYuuyokkntyoukaumu());

        kokyakuAtesakiBean.setIrTyouhyousakuseiymd(tyouhyouymd1);

        kokyakuAtesakiBean.setIrShsyno(pTtdkKan.getShskyno());

        kokyakuAtesakiBean.setIrShadr1kj(hensyuugoAdr[0]);

        kokyakuAtesakiBean.setIrShadr2kj(hensyuugoAdr[1]);

        kokyakuAtesakiBean.setIrShadr3kj(hensyuugoAdr[2]);

        kokyakuAtesakiBean.setIrShsnmkj(pTtdkKan.getShsnmkj());

        kokyakuAtesakiBean.setIrHknkisynm(pTtdkKan.getToiawasekaisyanmkj());

        kokyakuAtesakiBean.setIrToiawasesosiki(pTtdkKan.getToiawasesosikinmkj());

        kokyakuAtesakiBean.setIrToiawasetantounm("");

        kokyakuAtesakiBean.setIrToiawaseyno(pTtdkKan.getToiawaseyno());

        kokyakuAtesakiBean.setIrToiawaseadr1kj(pTtdkKan.getToiawaseadr1kj());

        kokyakuAtesakiBean.setIrToiawaseadr2kj(pTtdkKan.getToiawaseadr2kj());

        kokyakuAtesakiBean.setIrToiawaseadr3kj(pTtdkKan.getToiawaseadr3kj());

        kokyakuAtesakiBean.setIrToiawasetelno(pTtdkKan.getToiawasetelno());

        kokyakuAtesakiBean.setIrToiawaseteluktkkanou1(pTtdkKan.getToiawaseteluktkkanou1());

        kokyakuAtesakiBean.setIrToiawaseteluktkkanou2(pTtdkKan.getToiawaseteluktkkanou2());

        reportServicesBean.addParamObjects(new Object[] { khTtdkkanryouBean, kokyakuAtesakiBean });

        return reportServicesBean;
    }

    private BizCurrency doKingakuHenkan(C_HugouKbn pHugouKbn, BizCurrency pTaisyoukgk) {

        BizCurrency henkankgk = pTaisyoukgk;

        if (C_HugouKbn.HU.eq(pHugouKbn)){

            henkankgk = henkankgk.multiply(-1);

        }

        return henkankgk;

    }

    private KngkMeisaiBean EditYenddtl(NaibuKoumokudtlBean pNaibuKoumokudtlBean) {

        BizCurrency mikeikapkeikYen = pNaibuKoumokudtlBean.getKhShrRireki().getYenmikeikap().add(pNaibuKoumokudtlBean.getKhShrRireki().getYenzennomikeikap());
        BizCurrency sonotaSeisankinkYen = pNaibuKoumokudtlBean.getKhShrRireki().getZitkazukarikingkyen().add(pNaibuKoumokudtlBean.getKhShrRireki().getYenkrkgk());
        KngkMeisaiBean kngkMeisaiBean = pNaibuKoumokudtlBean.getKngkMeisaiBean();

        if (mikeikapkeikYen.compareTo(BizCurrency.valueOf(0, mikeikapkeikYen.getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB14);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),mikeikapkeikYen);
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getShrtuukasyu());
        }
        if (sonotaSeisankinkYen.compareTo(BizCurrency.valueOf(0, sonotaSeisankinkYen.getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB10);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),sonotaSeisankinkYen);
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),C_Tuukasyu.JPY);
        }
        if (pNaibuKoumokudtlBean.getKhShrRireki().getYenkansanhaitoukin().compareTo(
            BizCurrency.valueOf(0, pNaibuKoumokudtlBean.getKhShrRireki().getYenkansanhaitoukin().getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB6);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getYenkansanhaitoukin());
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),C_Tuukasyu.JPY);
        }

        if (pNaibuKoumokudtlBean.getKhShrRireki().getYensonotahaitoukin().compareTo(
            BizCurrency.valueOf(0, pNaibuKoumokudtlBean.getKhShrRireki().getYensonotahaitoukin().getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB11);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getYensonotahaitoukin());
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),C_Tuukasyu.JPY);
        }
        if (pNaibuKoumokudtlBean.getKhShrRireki().getShrtuukasonotaseisangk().compareTo(
            BizCurrency.valueOf(0, pNaibuKoumokudtlBean.getKhShrRireki().getShrtuukasonotaseisangk().getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB5 + SAME);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getShrtuukasonotaseisangk());
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getShrtuukasyu());
        }
        return kngkMeisaiBean;
    }

    private KngkMeisaiBean EditHijnGaikagkdtyenShrdtl(NaibuKoumokudtlBean pNaibuKoumokudtlBean) {

        BizCurrency mikeikapkeikGaika = pNaibuKoumokudtlBean.getKhShrRireki().getMikeikap().add(pNaibuKoumokudtlBean.getKhShrRireki().getZennomikeikap());
        BizCurrency sonotaSeisankinkYen = pNaibuKoumokudtlBean.getKhShrRireki().getZitkazukarikingkyen().add(pNaibuKoumokudtlBean.getKhShrRireki().getYenkrkgk());
        KngkMeisaiBean kngkMeisaiBean = pNaibuKoumokudtlBean.getKngkMeisaiBean();

        kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
        kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB8);
        kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
        kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),KBUTITEN + pNaibuKoumokudtlBean.getSyushrgkkeiHnykSyuruiKbn());
        kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getSyushrgkkei());
        kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getKyktuukasyu());


        if (mikeikapkeikGaika.compareTo(BizCurrency.valueOf(0, mikeikapkeikGaika.getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),KBUTITEN + TEKIYOUKB14);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),mikeikapkeikGaika);
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getKyktuukasyu());
        }
        if (sonotaSeisankinkYen.compareTo(BizCurrency.valueOf(0, sonotaSeisankinkYen.getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB10);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),sonotaSeisankinkYen);
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),C_Tuukasyu.JPY);
        }
        if (pNaibuKoumokudtlBean.getKhShrRireki().getYenkansanhaitoukin().compareTo(
            BizCurrency.valueOf(0, pNaibuKoumokudtlBean.getKhShrRireki().getYenkansanhaitoukin().getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB6);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getYenkansanhaitoukin());
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),C_Tuukasyu.JPY);
        }
        if (pNaibuKoumokudtlBean.getKhShrRireki().getYensonotahaitoukin().compareTo(
            BizCurrency.valueOf(0, pNaibuKoumokudtlBean.getKhShrRireki().getYensonotahaitoukin().getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB11);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getYensonotahaitoukin());
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),C_Tuukasyu.JPY);
        }
        return kngkMeisaiBean;
    }

    private KngkMeisaiBean EditHijnGaikagkdtgaikaShrdtl(NaibuKoumokudtlBean pNaibuKoumokudtlBean) {

        BizCurrency mikeikapkeikGaika = pNaibuKoumokudtlBean.getKhShrRireki().getMikeikap().add(pNaibuKoumokudtlBean.getKhShrRireki().getZennomikeikap());
        BizCurrency sonotaSeisankinkYen = pNaibuKoumokudtlBean.getKhShrRireki().getZitkazukarikingkyen().add(pNaibuKoumokudtlBean.getKhShrRireki().getYenkrkgk());
        KngkMeisaiBean kngkMeisaiBean = pNaibuKoumokudtlBean.getKngkMeisaiBean();

        if (mikeikapkeikGaika.compareTo(BizCurrency.valueOf(0, mikeikapkeikGaika.getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB14);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),mikeikapkeikGaika);
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getKyktuukasyu());
        }
        if(pNaibuKoumokudtlBean.getKhShrRireki().getShrtuukasonotashrkngk().compareTo(
            BizCurrency.valueOf(0, pNaibuKoumokudtlBean.getKhShrRireki().getShrtuukasonotashrkngk().getType())) > 0) {

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB7);
            kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getShrtuukasonotashrkngk());
            kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getShrtuukasyu());

            kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
            kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),TEKIYOUKB8);

            if (sonotaSeisankinkYen.compareTo(BizCurrency.valueOf(0, sonotaSeisankinkYen.getType())) > 0) {

                kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
                kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),KBUTITEN + TEKIYOUKB10);
                kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),sonotaSeisankinkYen);
                kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),C_Tuukasyu.JPY);
            }
            if (pNaibuKoumokudtlBean.getKhShrRireki().getYenkansanhaitoukin().compareTo(
                BizCurrency.valueOf(0, pNaibuKoumokudtlBean.getKhShrRireki().getYenkansanhaitoukin().getType())) > 0) {

                kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
                kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),KBUTITEN + TEKIYOUKB6);
                kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getYenkansanhaitoukin());
                kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),C_Tuukasyu.JPY);
            }
            if (pNaibuKoumokudtlBean.getKhShrRireki().getYensonotahaitoukin().compareTo(
                BizCurrency.valueOf(0, pNaibuKoumokudtlBean.getKhShrRireki().getYensonotahaitoukin().getType())) > 0) {

                kngkMeisaiBean.setIndex(kngkMeisaiBean.getIndex() + 1);
                kngkMeisaiBean.getTekiyouLst().set(kngkMeisaiBean.getIndex(),KBUTITEN + TEKIYOUKB11);
                kngkMeisaiBean.getKngkMeisaiLst().set(kngkMeisaiBean.getIndex(),pNaibuKoumokudtlBean.getKhShrRireki().getYensonotahaitoukin());
                kngkMeisaiBean.getKngkmisituukasyuLst().set(kngkMeisaiBean.getIndex(),C_Tuukasyu.JPY);
            }
        }
        return kngkMeisaiBean;
    }

    private KzHurikaeInfoSyoriKekkaBean KzhurikenInfo(IT_AnsyuRireki pAnsyuRireki,List<IT_AnsyuRireki> pAnsyuRirekiList) {

        KzHurikaeInfoSyoriKekkaBean KzHurikaeInfoSyoriKekkaBean = SWAKInjector.getInstance(KzHurikaeInfoSyoriKekkaBean.class);

        String kzhurikaeymdZen = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pAnsyuRireki.getHurikaeymd());

        C_AnnaijkKbn annaijkKbn = pAnsyuRireki.getAnnaijkkbn();

        BizCurrency kzhurikaeIrai = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizDateYM jyuutouym = null;

        Integer jyutoukaisuum = 0;

        for (IT_AnsyuRireki ansyuRirekiLoopYou : pAnsyuRirekiList) {

            if (ansyuRirekiLoopYou.getAnnaijkkbn().eq(annaijkKbn)) {

                kzhurikaeIrai = kzhurikaeIrai.add(ansyuRirekiLoopYou.getRsgaku());

                jyuutouym = ansyuRirekiLoopYou.getJyuutouym();

                jyutoukaisuum = jyutoukaisuum + ansyuRirekiLoopYou.getJyutoukaisuum();
            }
        }

        String kzhurikaeIraiZen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,
            ViewReport.editCommaTuuka(kzhurikaeIrai, BizUtil.ZERO_FILL));

        String jyuutouymZen = "";
        if (jyuutouym != null) {
            jyuutouymZen = FixedDateFormatter.formatYMZenkakuSeirekiKanji(jyuutouym.getFirstDay());
        }
        String jyutoukaisuumZen = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, jyutoukaisuum.toString());

        KzHurikaeInfoSyoriKekkaBean.setKzhurikaeiraikngkZen(kzhurikaeIraiZen);
        KzHurikaeInfoSyoriKekkaBean.setJyuutouymZen(jyuutouymZen);
        KzHurikaeInfoSyoriKekkaBean.setJyutoukaisuumZen(jyutoukaisuumZen);
        KzHurikaeInfoSyoriKekkaBean.setKzhurikaeymdZen(kzhurikaeymdZen);

        return KzHurikaeInfoSyoriKekkaBean;

    }
}
