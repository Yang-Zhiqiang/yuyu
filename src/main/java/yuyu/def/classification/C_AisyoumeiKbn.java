
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 愛称名区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AisyoumeiKbn</td><td colspan="3">愛称名区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="46">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_K2_MDHN}</td><td>&quot;701&quot;</td><td>ふるはーとＪロードグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_K2_SMBC}</td><td>&quot;702&quot;</td><td>笑顔の約束</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_K2_SINKIN}</td><td>&quot;704&quot;</td><td>しんきんらいふ終身Ｓ　ふるはーとＪロードグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_19_MDHN}</td><td>&quot;706&quot;</td><td>ふるはーとＪロードグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_19_SMBC}</td><td>&quot;707&quot;</td><td>笑顔の約束Ⅱ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_19_SINKIN}</td><td>&quot;709&quot;</td><td>しんきんらいふ終身Ｓ　ふるはーとＪロードグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_MDHN}</td><td>&quot;711&quot;</td><td>ふるはーとＦⅡ（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_MDHN}</td><td>&quot;716&quot;</td><td>ふるはーとＦⅡ（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_SMBC}</td><td>&quot;712&quot;</td><td>プラスつみたて終身保険（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_SMBC}</td><td>&quot;717&quot;</td><td>プラスつみたて終身保険（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_MIZUHO}</td><td>&quot;713&quot;</td><td>ふるはーとＦⅡ（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_MIZUHO}</td><td>&quot;718&quot;</td><td>ふるはーとＦⅡ（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_SINKIN}</td><td>&quot;714&quot;</td><td>しんきんらいふ終身Ｓ　ふるはーとＦⅡ（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_SINKIN}</td><td>&quot;719&quot;</td><td>しんきんらいふ終身Ｓ　ふるはーとＦⅡ（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_MDHN}</td><td>&quot;801&quot;</td><td>たのしみグローバル（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SMBC}</td><td>&quot;802&quot;</td><td>たのしみステップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_YUUSEI}</td><td>&quot;803&quot;</td><td>たのしみグローバルＹＯＵ（指数連動プラン）（仮）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SINKIN}</td><td>&quot;804&quot;</td><td>しんきんらいふ年金Ｓ　たのしみグローバル（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_MDHN}</td><td>&quot;806&quot;</td><td>たのしみグローバル（定率増加プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_SINKIN}</td><td>&quot;809&quot;</td><td>しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_MDHN}</td><td>&quot;811&quot;</td><td>たのしみ未来グローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_SMBC}</td><td>&quot;812&quot;</td><td>充実みらいグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_MIZUHO}</td><td>&quot;813&quot;</td><td>たのしみ未来ワールド</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_SINKIN}</td><td>&quot;814&quot;</td><td>しんきんらいふ年金Ｓ　たのしみ未来グローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_MDHN}</td><td>&quot;816&quot;</td><td>たのしみ未来グローバル＜学資積立プラン＞</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_SMBC}</td><td>&quot;817&quot;</td><td>充実みらいグローバル＜学資積立プラン＞</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_MIZUHO}</td><td>&quot;818&quot;</td><td>たのしみ未来ワールド＜学資積立プラン＞</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_SINKIN}</td><td>&quot;819&quot;</td><td>しんきんらいふ年金Ｓたのしみ未来グローバル＜学資積立プラン＞</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_MDHN}</td><td>&quot;821&quot;</td><td>たのしみグローバルⅡ（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_20_MDHN}</td><td>&quot;826&quot;</td><td>たのしみグローバルⅡ（定率増加プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TK_20_MDHN}</td><td>&quot;831&quot;</td><td>たのしみグローバルⅡ（定期支払プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SMBC}</td><td>&quot;822&quot;</td><td>たのしみステップⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_MIZUHO}</td><td>&quot;823&quot;</td><td>たのしみグローバルⅡ（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SINKIN}</td><td>&quot;824&quot;</td><td>しんきんらいふ年金Ｓ　たのしみグローバルⅡ（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_20_SINKIN}</td><td>&quot;829&quot;</td><td>しんきんらいふ年金Ｓ　たのしみグローバルⅡ（定率増加プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TK_20_SINKIN}</td><td>&quot;834&quot;</td><td>しんきんらいふ年金Ｓ　たのしみグローバルⅡ（定期支払プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHSY_MDHN}</td><td>&quot;981&quot;</td><td>ふるはーと外貨（即時保障型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHSY_SMBC}</td><td>&quot;982&quot;</td><td>充実外貨（即時保障型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHSY_SINKIN}</td><td>&quot;983&quot;</td><td>しんきん外貨（即時保障型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAITOSIUKTR_MDHN}</td><td>&quot;986&quot;</td><td>ふるはーと外貨（毎年受取型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAITOSIUKTR_SMBC}</td><td>&quot;987&quot;</td><td>充実外貨（毎年受取型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAITOSIUKTR_SINKIN}</td><td>&quot;988&quot;</td><td>しんきん外貨（毎年受取型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKUBLEND_MDHN}</td><td>&quot;991&quot;</td><td>ふるはーと外貨（変額ブレンド型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKUBLEND_SMBC}</td><td>&quot;992&quot;</td><td>充実外貨（変額ブレンド型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKUBLEND_SINKIN}</td><td>&quot;993&quot;</td><td>しんきん外貨（変額ブレンド型）</td></tr>
 *  <tr><td rowspan="46">{@link #PATTERN_SKSISYATOUKEI SKSISYATOUKEI}<br />(新契約支社統計用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_K2_MDHN}</td><td>&quot;701&quot;</td><td>Ｊロードグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_K2_SMBC}</td><td>&quot;702&quot;</td><td>笑顔の約束</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_K2_SINKIN}</td><td>&quot;704&quot;</td><td>Ｊロードグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_19_MDHN}</td><td>&quot;706&quot;</td><td>ＪロードグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_19_SMBC}</td><td>&quot;707&quot;</td><td>笑顔の約束Ⅱ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_19_SINKIN}</td><td>&quot;709&quot;</td><td>ＪロードグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_MDHN}</td><td>&quot;711&quot;</td><td>ふるはーとＦⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_MDHN}</td><td>&quot;716&quot;</td><td>ふるはーとＦⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_SMBC}</td><td>&quot;712&quot;</td><td>プラスつみたて終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_SMBC}</td><td>&quot;717&quot;</td><td>プラスつみたて終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_MIZUHO}</td><td>&quot;713&quot;</td><td>ふるはーとＦⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_MIZUHO}</td><td>&quot;718&quot;</td><td>ふるはーとＦⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_SINKIN}</td><td>&quot;714&quot;</td><td>ふるはーとＦⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_SINKIN}</td><td>&quot;719&quot;</td><td>ふるはーとＦⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_MDHN}</td><td>&quot;801&quot;</td><td>たのしみグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SMBC}</td><td>&quot;802&quot;</td><td>たのしみステップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_YUUSEI}</td><td>&quot;803&quot;</td><td>たのしみグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SINKIN}</td><td>&quot;804&quot;</td><td>たのしみグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_MDHN}</td><td>&quot;806&quot;</td><td>たのしみグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_SINKIN}</td><td>&quot;809&quot;</td><td>たのしみグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_MDHN}</td><td>&quot;811&quot;</td><td>たのしみ未来Ｇ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_SMBC}</td><td>&quot;812&quot;</td><td>充実みらいＧ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_MIZUHO}</td><td>&quot;813&quot;</td><td>たのしみ未来Ｗ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_SINKIN}</td><td>&quot;814&quot;</td><td>たのしみ未来Ｇ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_MDHN}</td><td>&quot;816&quot;</td><td>たのしみ未来Ｇ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_SMBC}</td><td>&quot;817&quot;</td><td>充実みらいＧ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_MIZUHO}</td><td>&quot;818&quot;</td><td>たのしみ未来Ｗ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_SINKIN}</td><td>&quot;819&quot;</td><td>たのしみ未来Ｇ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_MDHN}</td><td>&quot;821&quot;</td><td>たのしみグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_20_MDHN}</td><td>&quot;826&quot;</td><td>たのしみグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TK_20_MDHN}</td><td>&quot;831&quot;</td><td>たのしみグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SMBC}</td><td>&quot;822&quot;</td><td>たのしみステップⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_MIZUHO}</td><td>&quot;823&quot;</td><td>たのしみグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SINKIN}</td><td>&quot;824&quot;</td><td>たのしみグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_20_SINKIN}</td><td>&quot;829&quot;</td><td>たのしみグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TK_20_SINKIN}</td><td>&quot;834&quot;</td><td>たのしみグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHSY_MDHN}</td><td>&quot;981&quot;</td><td>ふるはーとＳ外貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHSY_SMBC}</td><td>&quot;982&quot;</td><td>充実クラブＳ外貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHSY_SINKIN}</td><td>&quot;983&quot;</td><td>しんきんＳ外貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAITOSIUKTR_MDHN}</td><td>&quot;986&quot;</td><td>ふるはーとＭ外貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAITOSIUKTR_SMBC}</td><td>&quot;987&quot;</td><td>充実クラブＭ外貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAITOSIUKTR_SINKIN}</td><td>&quot;988&quot;</td><td>しんきんＭ外貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKUBLEND_MDHN}</td><td>&quot;991&quot;</td><td>たのしみＢ外貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKUBLEND_SMBC}</td><td>&quot;992&quot;</td><td>充実たのしみＢ外貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKUBLEND_SINKIN}</td><td>&quot;993&quot;</td><td>たのしみライフＢ外貨</td></tr>
 *  <tr><td rowspan="46">{@link #PATTERN_SKMOUSIKOMI SKMOUSIKOMI}<br />(申込書入力用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_K2_MDHN}</td><td>&quot;701&quot;</td><td>ふるはーとＪロードグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_K2_SMBC}</td><td>&quot;702&quot;</td><td>笑顔の約束</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_K2_SINKIN}</td><td>&quot;704&quot;</td><td>しんきんらいふ終身Ｓ　ふるはーとＪロードグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_19_MDHN}</td><td>&quot;706&quot;</td><td>ふるはーとＪロードグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_19_SMBC}</td><td>&quot;707&quot;</td><td>笑顔の約束Ⅱ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASYUUSIN_19_SINKIN}</td><td>&quot;709&quot;</td><td>しんきんらいふ終身Ｓ　ふるはーとＪロードグローバルⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_MDHN}</td><td>&quot;711&quot;</td><td>ふるはーとＦⅡ（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_MDHN}</td><td>&quot;716&quot;</td><td>ふるはーとＦⅡ（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_SMBC}</td><td>&quot;712&quot;</td><td>プラスつみたて終身保険（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_SMBC}</td><td>&quot;717&quot;</td><td>プラスつみたて終身保険（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_MIZUHO}</td><td>&quot;713&quot;</td><td>ふるはーとＦⅡ（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_MIZUHO}</td><td>&quot;718&quot;</td><td>ふるはーとＦⅡ（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT_SINKIN}</td><td>&quot;714&quot;</td><td>しんきんらいふ終身Ｓ　ふるはーとＦⅡ（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT_SINKIN}</td><td>&quot;719&quot;</td><td>しんきんらいふ終身Ｓ　ふるはーとＦⅡ（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_MDHN}</td><td>&quot;801&quot;</td><td>たのしみグローバル（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SMBC}</td><td>&quot;802&quot;</td><td>たのしみステップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_YUUSEI}</td><td>&quot;803&quot;</td><td>たのしみグローバルＹＯＵ（指数連動プラン）（仮）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SINKIN}</td><td>&quot;804&quot;</td><td>しんきんらいふ年金Ｓ　たのしみグローバル（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_MDHN}</td><td>&quot;806&quot;</td><td>たのしみグローバル（定率増加プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_SINKIN}</td><td>&quot;809&quot;</td><td>しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_MDHN}</td><td>&quot;811&quot;</td><td>たのしみ未来グローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_SMBC}</td><td>&quot;812&quot;</td><td>充実みらいグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_MIZUHO}</td><td>&quot;813&quot;</td><td>たのしみ未来ワールド</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_SINKIN}</td><td>&quot;814&quot;</td><td>しんきんらいふ年金Ｓ　たのしみ未来グローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_MDHN}</td><td>&quot;816&quot;</td><td>たのしみ未来グローバル＜学資積立プラン＞</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_SMBC}</td><td>&quot;817&quot;</td><td>充実みらいグローバル＜学資積立プラン＞</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_MIZUHO}</td><td>&quot;818&quot;</td><td>たのしみ未来ワールド＜学資積立プラン＞</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK_GS_SINKIN}</td><td>&quot;819&quot;</td><td>しんきんらいふ年金Ｓたのしみ未来グローバル＜学資積立プラン＞</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_MDHN}</td><td>&quot;821&quot;</td><td>たのしみグローバルⅡ（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_20_MDHN}</td><td>&quot;826&quot;</td><td>たのしみグローバルⅡ（定率増加・定期支払プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TK_20_MDHN}</td><td>&quot;831&quot;</td><td>たのしみグローバルⅡ（定率増加・定期支払プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SMBC}</td><td>&quot;822&quot;</td><td>たのしみステップⅡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_MIZUHO}</td><td>&quot;823&quot;</td><td>たのしみグローバルⅡ（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SINKIN}</td><td>&quot;824&quot;</td><td>しんきんらいふ年金Ｓ　たのしみグローバルⅡ（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TR_20_SINKIN}</td><td>&quot;829&quot;</td><td>しんきんらいふ年金Ｓ　たのしみグローバルⅡ（定率増加・定期支払プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TK_20_SINKIN}</td><td>&quot;834&quot;</td><td>しんきんらいふ年金Ｓ　たのしみグローバルⅡ（定率増加・定期支払プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHSY_MDHN}</td><td>&quot;981&quot;</td><td>ふるはーと外貨（即時保障型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHSY_SMBC}</td><td>&quot;982&quot;</td><td>充実外貨（即時保障型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHSY_SINKIN}</td><td>&quot;983&quot;</td><td>しんきん外貨（即時保障型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAITOSIUKTR_MDHN}</td><td>&quot;986&quot;</td><td>ふるはーと外貨（毎年受取型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAITOSIUKTR_SMBC}</td><td>&quot;987&quot;</td><td>充実外貨（毎年受取型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAITOSIUKTR_SINKIN}</td><td>&quot;988&quot;</td><td>しんきん外貨（毎年受取型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKUBLEND_MDHN}</td><td>&quot;991&quot;</td><td>ふるはーと外貨（変額ブレンド型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKUBLEND_SMBC}</td><td>&quot;992&quot;</td><td>充実外貨（変額ブレンド型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKUBLEND_SINKIN}</td><td>&quot;993&quot;</td><td>しんきん外貨（変額ブレンド型）</td></tr>
 * </table>
 */
public class C_AisyoumeiKbn extends Classification<C_AisyoumeiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AisyoumeiKbn BLNK = new C_AisyoumeiKbn("0");

    public static final C_AisyoumeiKbn GAIKASYUUSIN_K2_MDHN = new C_AisyoumeiKbn("701");

    public static final C_AisyoumeiKbn GAIKASYUUSIN_K2_SMBC = new C_AisyoumeiKbn("702");

    public static final C_AisyoumeiKbn GAIKASYUUSIN_K2_SINKIN = new C_AisyoumeiKbn("704");

    public static final C_AisyoumeiKbn GAIKASYUUSIN_19_MDHN = new C_AisyoumeiKbn("706");

    public static final C_AisyoumeiKbn GAIKASYUUSIN_19_SMBC = new C_AisyoumeiKbn("707");

    public static final C_AisyoumeiKbn GAIKASYUUSIN_19_SINKIN = new C_AisyoumeiKbn("709");

    public static final C_AisyoumeiKbn TEIKAIYAKUHRKNSYSN_YENDT_MDHN = new C_AisyoumeiKbn("711");

    public static final C_AisyoumeiKbn TEIKAIYAKUHRKNSYSN_USDDT_MDHN = new C_AisyoumeiKbn("716");

    public static final C_AisyoumeiKbn TEIKAIYAKUHRKNSYSN_YENDT_SMBC = new C_AisyoumeiKbn("712");

    public static final C_AisyoumeiKbn TEIKAIYAKUHRKNSYSN_USDDT_SMBC = new C_AisyoumeiKbn("717");

    public static final C_AisyoumeiKbn TEIKAIYAKUHRKNSYSN_YENDT_MIZUHO = new C_AisyoumeiKbn("713");

    public static final C_AisyoumeiKbn TEIKAIYAKUHRKNSYSN_USDDT_MIZUHO = new C_AisyoumeiKbn("718");

    public static final C_AisyoumeiKbn TEIKAIYAKUHRKNSYSN_YENDT_SINKIN = new C_AisyoumeiKbn("714");

    public static final C_AisyoumeiKbn TEIKAIYAKUHRKNSYSN_USDDT_SINKIN = new C_AisyoumeiKbn("719");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_MDHN = new C_AisyoumeiKbn("801");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_SMBC = new C_AisyoumeiKbn("802");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_YUUSEI = new C_AisyoumeiKbn("803");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_SINKIN = new C_AisyoumeiKbn("804");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_TR_MDHN = new C_AisyoumeiKbn("806");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_TR_SINKIN = new C_AisyoumeiKbn("809");

    public static final C_AisyoumeiKbn GAIKARIRITUHENDOUNK_MDHN = new C_AisyoumeiKbn("811");

    public static final C_AisyoumeiKbn GAIKARIRITUHENDOUNK_SMBC = new C_AisyoumeiKbn("812");

    public static final C_AisyoumeiKbn GAIKARIRITUHENDOUNK_MIZUHO = new C_AisyoumeiKbn("813");

    public static final C_AisyoumeiKbn GAIKARIRITUHENDOUNK_SINKIN = new C_AisyoumeiKbn("814");

    public static final C_AisyoumeiKbn GAIKARIRITUHENDOUNK_GS_MDHN = new C_AisyoumeiKbn("816");

    public static final C_AisyoumeiKbn GAIKARIRITUHENDOUNK_GS_SMBC = new C_AisyoumeiKbn("817");

    public static final C_AisyoumeiKbn GAIKARIRITUHENDOUNK_GS_MIZUHO = new C_AisyoumeiKbn("818");

    public static final C_AisyoumeiKbn GAIKARIRITUHENDOUNK_GS_SINKIN = new C_AisyoumeiKbn("819");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_20_MDHN = new C_AisyoumeiKbn("821");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_TR_20_MDHN = new C_AisyoumeiKbn("826");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_TK_20_MDHN = new C_AisyoumeiKbn("831");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_20_SMBC = new C_AisyoumeiKbn("822");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_20_MIZUHO = new C_AisyoumeiKbn("823");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_20_SINKIN = new C_AisyoumeiKbn("824");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_TR_20_SINKIN = new C_AisyoumeiKbn("829");

    public static final C_AisyoumeiKbn GAIKAINDEXNK_TK_20_SINKIN = new C_AisyoumeiKbn("834");

    public static final C_AisyoumeiKbn SOKUJIHSY_MDHN = new C_AisyoumeiKbn("981");

    public static final C_AisyoumeiKbn SOKUJIHSY_SMBC = new C_AisyoumeiKbn("982");

    public static final C_AisyoumeiKbn SOKUJIHSY_SINKIN = new C_AisyoumeiKbn("983");

    public static final C_AisyoumeiKbn MAITOSIUKTR_MDHN = new C_AisyoumeiKbn("986");

    public static final C_AisyoumeiKbn MAITOSIUKTR_SMBC = new C_AisyoumeiKbn("987");

    public static final C_AisyoumeiKbn MAITOSIUKTR_SINKIN = new C_AisyoumeiKbn("988");

    public static final C_AisyoumeiKbn HENGAKUBLEND_MDHN = new C_AisyoumeiKbn("991");

    public static final C_AisyoumeiKbn HENGAKUBLEND_SMBC = new C_AisyoumeiKbn("992");

    public static final C_AisyoumeiKbn HENGAKUBLEND_SINKIN = new C_AisyoumeiKbn("993");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SKSISYATOUKEI = "2";

    public static final String PATTERN_SKMOUSIKOMI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GAIKASYUUSIN_K2_MDHN, "GAIKASYUUSIN_K2_MDHN", false);
        addPattern(PATTERN_DEFAULT, GAIKASYUUSIN_K2_SMBC, "GAIKASYUUSIN_K2_SMBC", false);
        addPattern(PATTERN_DEFAULT, GAIKASYUUSIN_K2_SINKIN, "GAIKASYUUSIN_K2_SINKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKASYUUSIN_19_MDHN, "GAIKASYUUSIN_19_MDHN", false);
        addPattern(PATTERN_DEFAULT, GAIKASYUUSIN_19_SMBC, "GAIKASYUUSIN_19_SMBC", false);
        addPattern(PATTERN_DEFAULT, GAIKASYUUSIN_19_SINKIN, "GAIKASYUUSIN_19_SINKIN", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN_YENDT_MDHN, "TEIKAIYAKUHRKNSYSN_YENDT_MDHN", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN_USDDT_MDHN, "TEIKAIYAKUHRKNSYSN_USDDT_MDHN", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN_YENDT_SMBC, "TEIKAIYAKUHRKNSYSN_YENDT_SMBC", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN_USDDT_SMBC, "TEIKAIYAKUHRKNSYSN_USDDT_SMBC", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN_YENDT_MIZUHO, "TEIKAIYAKUHRKNSYSN_YENDT_MIZUHO", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN_USDDT_MIZUHO, "TEIKAIYAKUHRKNSYSN_USDDT_MIZUHO", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN_YENDT_SINKIN, "TEIKAIYAKUHRKNSYSN_YENDT_SINKIN", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN_USDDT_SINKIN, "TEIKAIYAKUHRKNSYSN_USDDT_SINKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_MDHN, "GAIKAINDEXNK_MDHN", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_SMBC, "GAIKAINDEXNK_SMBC", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_YUUSEI, "GAIKAINDEXNK_YUUSEI", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_SINKIN, "GAIKAINDEXNK_SINKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_TR_MDHN, "GAIKAINDEXNK_TR_MDHN", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_TR_SINKIN, "GAIKAINDEXNK_TR_SINKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKARIRITUHENDOUNK_MDHN, "GAIKARIRITUHENDOUNK_MDHN", false);
        addPattern(PATTERN_DEFAULT, GAIKARIRITUHENDOUNK_SMBC, "GAIKARIRITUHENDOUNK_SMBC", false);
        addPattern(PATTERN_DEFAULT, GAIKARIRITUHENDOUNK_MIZUHO, "GAIKARIRITUHENDOUNK_MIZUHO", false);
        addPattern(PATTERN_DEFAULT, GAIKARIRITUHENDOUNK_SINKIN, "GAIKARIRITUHENDOUNK_SINKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKARIRITUHENDOUNK_GS_MDHN, "GAIKARIRITUHENDOUNK_GS_MDHN", false);
        addPattern(PATTERN_DEFAULT, GAIKARIRITUHENDOUNK_GS_SMBC, "GAIKARIRITUHENDOUNK_GS_SMBC", false);
        addPattern(PATTERN_DEFAULT, GAIKARIRITUHENDOUNK_GS_MIZUHO, "GAIKARIRITUHENDOUNK_GS_MIZUHO", false);
        addPattern(PATTERN_DEFAULT, GAIKARIRITUHENDOUNK_GS_SINKIN, "GAIKARIRITUHENDOUNK_GS_SINKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_20_MDHN, "GAIKAINDEXNK_20_MDHN", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_TR_20_MDHN, "GAIKAINDEXNK_TR_20_MDHN", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_TK_20_MDHN, "GAIKAINDEXNK_TK_20_MDHN", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_20_SMBC, "GAIKAINDEXNK_20_SMBC", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_20_MIZUHO, "GAIKAINDEXNK_20_MIZUHO", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_20_SINKIN, "GAIKAINDEXNK_20_SINKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_TR_20_SINKIN, "GAIKAINDEXNK_TR_20_SINKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_TK_20_SINKIN, "GAIKAINDEXNK_TK_20_SINKIN", false);
        addPattern(PATTERN_DEFAULT, SOKUJIHSY_MDHN, "SOKUJIHSY_MDHN", false);
        addPattern(PATTERN_DEFAULT, SOKUJIHSY_SMBC, "SOKUJIHSY_SMBC", false);
        addPattern(PATTERN_DEFAULT, SOKUJIHSY_SINKIN, "SOKUJIHSY_SINKIN", false);
        addPattern(PATTERN_DEFAULT, MAITOSIUKTR_MDHN, "MAITOSIUKTR_MDHN", false);
        addPattern(PATTERN_DEFAULT, MAITOSIUKTR_SMBC, "MAITOSIUKTR_SMBC", false);
        addPattern(PATTERN_DEFAULT, MAITOSIUKTR_SINKIN, "MAITOSIUKTR_SINKIN", false);
        addPattern(PATTERN_DEFAULT, HENGAKUBLEND_MDHN, "HENGAKUBLEND_MDHN", false);
        addPattern(PATTERN_DEFAULT, HENGAKUBLEND_SMBC, "HENGAKUBLEND_SMBC", false);
        addPattern(PATTERN_DEFAULT, HENGAKUBLEND_SINKIN, "HENGAKUBLEND_SINKIN", false);


        addPattern(PATTERN_SKSISYATOUKEI, BLNK, "BLNK", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKASYUUSIN_K2_MDHN, "GAIKASYUUSIN_K2_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKASYUUSIN_K2_SMBC, "GAIKASYUUSIN_K2_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKASYUUSIN_K2_SINKIN, "GAIKASYUUSIN_K2_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKASYUUSIN_19_MDHN, "GAIKASYUUSIN_19_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKASYUUSIN_19_SMBC, "GAIKASYUUSIN_19_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKASYUUSIN_19_SINKIN, "GAIKASYUUSIN_19_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, TEIKAIYAKUHRKNSYSN_YENDT_MDHN, "TEIKAIYAKUHRKNSYSN_YENDT_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, TEIKAIYAKUHRKNSYSN_USDDT_MDHN, "TEIKAIYAKUHRKNSYSN_USDDT_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, TEIKAIYAKUHRKNSYSN_YENDT_SMBC, "TEIKAIYAKUHRKNSYSN_YENDT_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, TEIKAIYAKUHRKNSYSN_USDDT_SMBC, "TEIKAIYAKUHRKNSYSN_USDDT_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, TEIKAIYAKUHRKNSYSN_YENDT_MIZUHO, "TEIKAIYAKUHRKNSYSN_YENDT_MIZUHO", false);
        addPattern(PATTERN_SKSISYATOUKEI, TEIKAIYAKUHRKNSYSN_USDDT_MIZUHO, "TEIKAIYAKUHRKNSYSN_USDDT_MIZUHO", false);
        addPattern(PATTERN_SKSISYATOUKEI, TEIKAIYAKUHRKNSYSN_YENDT_SINKIN, "TEIKAIYAKUHRKNSYSN_YENDT_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, TEIKAIYAKUHRKNSYSN_USDDT_SINKIN, "TEIKAIYAKUHRKNSYSN_USDDT_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_MDHN, "GAIKAINDEXNK_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_SMBC, "GAIKAINDEXNK_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_YUUSEI, "GAIKAINDEXNK_YUUSEI", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_SINKIN, "GAIKAINDEXNK_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_TR_MDHN, "GAIKAINDEXNK_TR_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_TR_SINKIN, "GAIKAINDEXNK_TR_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKARIRITUHENDOUNK_MDHN, "GAIKARIRITUHENDOUNK_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKARIRITUHENDOUNK_SMBC, "GAIKARIRITUHENDOUNK_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKARIRITUHENDOUNK_MIZUHO, "GAIKARIRITUHENDOUNK_MIZUHO", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKARIRITUHENDOUNK_SINKIN, "GAIKARIRITUHENDOUNK_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKARIRITUHENDOUNK_GS_MDHN, "GAIKARIRITUHENDOUNK_GS_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKARIRITUHENDOUNK_GS_SMBC, "GAIKARIRITUHENDOUNK_GS_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKARIRITUHENDOUNK_GS_MIZUHO, "GAIKARIRITUHENDOUNK_GS_MIZUHO", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKARIRITUHENDOUNK_GS_SINKIN, "GAIKARIRITUHENDOUNK_GS_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_20_MDHN, "GAIKAINDEXNK_20_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_TR_20_MDHN, "GAIKAINDEXNK_TR_20_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_TK_20_MDHN, "GAIKAINDEXNK_TK_20_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_20_SMBC, "GAIKAINDEXNK_20_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_20_MIZUHO, "GAIKAINDEXNK_20_MIZUHO", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_20_SINKIN, "GAIKAINDEXNK_20_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_TR_20_SINKIN, "GAIKAINDEXNK_TR_20_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, GAIKAINDEXNK_TK_20_SINKIN, "GAIKAINDEXNK_TK_20_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, SOKUJIHSY_MDHN, "SOKUJIHSY_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, SOKUJIHSY_SMBC, "SOKUJIHSY_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, SOKUJIHSY_SINKIN, "SOKUJIHSY_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, MAITOSIUKTR_MDHN, "MAITOSIUKTR_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, MAITOSIUKTR_SMBC, "MAITOSIUKTR_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, MAITOSIUKTR_SINKIN, "MAITOSIUKTR_SINKIN", false);
        addPattern(PATTERN_SKSISYATOUKEI, HENGAKUBLEND_MDHN, "HENGAKUBLEND_MDHN", false);
        addPattern(PATTERN_SKSISYATOUKEI, HENGAKUBLEND_SMBC, "HENGAKUBLEND_SMBC", false);
        addPattern(PATTERN_SKSISYATOUKEI, HENGAKUBLEND_SINKIN, "HENGAKUBLEND_SINKIN", false);


        addPattern(PATTERN_SKMOUSIKOMI, BLNK, "BLNK", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKASYUUSIN_K2_MDHN, "GAIKASYUUSIN_K2_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKASYUUSIN_K2_SMBC, "GAIKASYUUSIN_K2_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKASYUUSIN_K2_SINKIN, "GAIKASYUUSIN_K2_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKASYUUSIN_19_MDHN, "GAIKASYUUSIN_19_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKASYUUSIN_19_SMBC, "GAIKASYUUSIN_19_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKASYUUSIN_19_SINKIN, "GAIKASYUUSIN_19_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, TEIKAIYAKUHRKNSYSN_YENDT_MDHN, "TEIKAIYAKUHRKNSYSN_YENDT_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, TEIKAIYAKUHRKNSYSN_USDDT_MDHN, "TEIKAIYAKUHRKNSYSN_USDDT_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, TEIKAIYAKUHRKNSYSN_YENDT_SMBC, "TEIKAIYAKUHRKNSYSN_YENDT_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, TEIKAIYAKUHRKNSYSN_USDDT_SMBC, "TEIKAIYAKUHRKNSYSN_USDDT_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, TEIKAIYAKUHRKNSYSN_YENDT_MIZUHO, "TEIKAIYAKUHRKNSYSN_YENDT_MIZUHO", false);
        addPattern(PATTERN_SKMOUSIKOMI, TEIKAIYAKUHRKNSYSN_USDDT_MIZUHO, "TEIKAIYAKUHRKNSYSN_USDDT_MIZUHO", false);
        addPattern(PATTERN_SKMOUSIKOMI, TEIKAIYAKUHRKNSYSN_YENDT_SINKIN, "TEIKAIYAKUHRKNSYSN_YENDT_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, TEIKAIYAKUHRKNSYSN_USDDT_SINKIN, "TEIKAIYAKUHRKNSYSN_USDDT_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_MDHN, "GAIKAINDEXNK_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_SMBC, "GAIKAINDEXNK_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_YUUSEI, "GAIKAINDEXNK_YUUSEI", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_SINKIN, "GAIKAINDEXNK_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_TR_MDHN, "GAIKAINDEXNK_TR_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_TR_SINKIN, "GAIKAINDEXNK_TR_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKARIRITUHENDOUNK_MDHN, "GAIKARIRITUHENDOUNK_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKARIRITUHENDOUNK_SMBC, "GAIKARIRITUHENDOUNK_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKARIRITUHENDOUNK_MIZUHO, "GAIKARIRITUHENDOUNK_MIZUHO", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKARIRITUHENDOUNK_SINKIN, "GAIKARIRITUHENDOUNK_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKARIRITUHENDOUNK_GS_MDHN, "GAIKARIRITUHENDOUNK_GS_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKARIRITUHENDOUNK_GS_SMBC, "GAIKARIRITUHENDOUNK_GS_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKARIRITUHENDOUNK_GS_MIZUHO, "GAIKARIRITUHENDOUNK_GS_MIZUHO", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKARIRITUHENDOUNK_GS_SINKIN, "GAIKARIRITUHENDOUNK_GS_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_20_MDHN, "GAIKAINDEXNK_20_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_TR_20_MDHN, "GAIKAINDEXNK_TR_20_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_TK_20_MDHN, "GAIKAINDEXNK_TK_20_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_20_SMBC, "GAIKAINDEXNK_20_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_20_MIZUHO, "GAIKAINDEXNK_20_MIZUHO", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_20_SINKIN, "GAIKAINDEXNK_20_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_TR_20_SINKIN, "GAIKAINDEXNK_TR_20_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, GAIKAINDEXNK_TK_20_SINKIN, "GAIKAINDEXNK_TK_20_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, SOKUJIHSY_MDHN, "SOKUJIHSY_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, SOKUJIHSY_SMBC, "SOKUJIHSY_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, SOKUJIHSY_SINKIN, "SOKUJIHSY_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, MAITOSIUKTR_MDHN, "MAITOSIUKTR_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, MAITOSIUKTR_SMBC, "MAITOSIUKTR_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, MAITOSIUKTR_SINKIN, "MAITOSIUKTR_SINKIN", false);
        addPattern(PATTERN_SKMOUSIKOMI, HENGAKUBLEND_MDHN, "HENGAKUBLEND_MDHN", false);
        addPattern(PATTERN_SKMOUSIKOMI, HENGAKUBLEND_SMBC, "HENGAKUBLEND_SMBC", false);
        addPattern(PATTERN_SKMOUSIKOMI, HENGAKUBLEND_SINKIN, "HENGAKUBLEND_SINKIN", false);


        lock(C_AisyoumeiKbn.class);
    }

    private C_AisyoumeiKbn(String value) {
        super(value);
    }

    public static C_AisyoumeiKbn valueOf(String value) {
        return valueOf(C_AisyoumeiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AisyoumeiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AisyoumeiKbn.class, patternId, value);
    }
}
