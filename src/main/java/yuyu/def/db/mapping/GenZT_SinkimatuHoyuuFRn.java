package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SinkimatuHoyuuFRn;
import yuyu.def.db.id.PKZT_SinkimatuHoyuuFRn;
import yuyu.def.db.meta.GenQZT_SinkimatuHoyuuFRn;
import yuyu.def.db.meta.QZT_SinkimatuHoyuuFRn;

/**
 * 新期末保有Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SinkimatuHoyuuFRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinkimatuHoyuuFRn}</td><td colspan="3">新期末保有Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_SinkimatuHoyuuFRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntantoukojincd zrntantoukojincd}</td><td>（連携用）担当者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantousyasetteiym zrntantousyasetteiym}</td><td>（連携用）担当者設定年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyousakikbn zrnkeijyousakikbn}</td><td>（連携用）計上先区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyousakisosiki zrnkeijyousakisosiki}</td><td>（連携用）計上先組織</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndenymd zrndenymd}</td><td>（連携用）伝票日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnutiwakekbn zrnutiwakekbn}</td><td>（連携用）内訳区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantoukeiyakukbn zrntantoukeiyakukbn}</td><td>（連携用）担当契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkikbn zrnkydatkikbn}</td><td>（連携用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisinbsyym zrnsaisinbsyym}</td><td>（連携用）最新募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteisyuruikigou zrnmaruteisyuruikigou}</td><td>（連携用）マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin3 zrnyobin3}</td><td>（連携用）予備項目Ｎ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x2 zrnyobiv1x2}</td><td>（連携用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyutksytioukbn zrnkykniyutksytioukbn}</td><td>（連携用）契約内容特殊対応区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x3 zrnyobiv1x3}</td><td>（連携用）予備項目Ｖ１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteisyuuhyj zrnteisyuuhyj}</td><td>（連携用）定終表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibryourouhyj zrnitijibryourouhyj}</td><td>（連携用）一時払養老表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtihukahyj zrnmrtihukahyj}</td><td>（連携用）マル定付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmrtihukahyj zrnseizonmrtihukahyj}</td><td>（連携用）生存マル定付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmrtihukahyj zrnteigenmrtihukahyj}</td><td>（連携用）逓減マル定付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsynymrtihukahyj zrnsynymrtihukahyj}</td><td>（連携用）収入マル定付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivingneedstkykarihyj zrnlivingneedstkykarihyj}</td><td>（連携用）リビングニーズ特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnreguardmrtihukahyj zrnreguardmrtihukahyj}</td><td>（連携用）リガードマル定付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnreguardmrsyuhukahyj zrnreguardmrsyuhukahyj}</td><td>（連携用）リガードマル終付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvguardmrtihukahyj zrnvguardmrtihukahyj}</td><td>（連携用）Ｖガードマル定付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykhukahyj zrnkaigonktkykhukahyj}</td><td>（連携用）介護年金特約付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeisisttkyktkknsnp zrngoukeisisttkyktkknsnp}</td><td>（連携用）合計災疾特約月換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhsys zrnhsys}</td><td>（連携用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkensuun3 zrnkensuun3}</td><td>（連携用）件数Ｎ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnhenkougohosyous zrnhenkougohosyous}</td><td>（連携用）変更後保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtns zrnhtns}</td><td>（連携用）被転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnharaikomip zrnharaikomip}</td><td>（連携用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakusiharaikngk zrnkaiyakusiharaikngk}</td><td>（連携用）解約支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnanniskcd zrnanniskcd}</td><td>（連携用）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkankaisuu zrntenkankaisuu}</td><td>（連携用）転換回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikkounyknkaisuu zrnsikkounyknkaisuu}</td><td>（連携用）失効入金回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2 zrnyobiv2}</td><td>（連携用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2keta zrnhhknnen2keta}</td><td>（連携用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm zrnkjkyknm}</td><td>（連携用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinkihontikucd zrntsinkihontikucd}</td><td>（連携用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnkykhyj zrnhjnkykhyj}</td><td>（連携用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjncd zrnhjncd}</td><td>（連携用）法人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnjigyosyocd zrnhjnjigyosyocd}</td><td>（連携用）法人事業所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorisosikicd zrnsyorisosikicd}</td><td>（連携用）処理組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntikusyokansisyakijyhyj zrntikusyokansisyakijyhyj}</td><td>（連携用）地区所管支社計上表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeizokutyuuihyouji zrnkeizokutyuuihyouji}</td><td>（連携用）継続注意表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyohkkeiyakutyuuikbn zrntyohkkeiyakutyuuikbn}</td><td>（連携用）重複契約注意区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x4 zrnyobiv1x4}</td><td>（連携用）予備項目Ｖ１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndantaisyozokucd zrndantaisyozokucd}</td><td>（連携用）団体所属コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuperknkuseikatupackhyj zrnsuperknkuseikatupackhyj}</td><td>（連携用）スーパー健康生活パック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikokykhyj zrnjikokykhyj}</td><td>（連携用）自己契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikeiyakutyuuihyouji zrnkikeiyakutyuuihyouji}</td><td>（連携用）既契約注意表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuuseis zrnsyuuseis}</td><td>（連携用）修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnclubsumiseikaiinkykkbn zrnclubsumiseikaiinkykkbn}</td><td>（連携用）クラブスミセイ会員契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngatkihmkknrkmaekykhyj zrngatkihmkknrkmaekykhyj}</td><td>（連携用）Ｇ扱者訪問結果入力前契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngatkisetteikouhokykhyj zrngatkisetteikouhokykhyj}</td><td>（連携用）Ｇ扱者設定候補契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuu25keikahyj zrnbosyuu25keikahyj}</td><td>（連携用）募集２５カ月経過表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteidaisyokudanhyj zrntokuteidaisyokudanhyj}</td><td>（連携用）特定大職団表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhoyuuikantsgkykhyj zrnhoyuuikantsgkykhyj}</td><td>（連携用）保有移管対象外契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokubeturuletikuhyj zrntokubeturuletikuhyj}</td><td>（連携用）特別ルール地区表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfieldtantousyaarihyj zrnfieldtantousyaarihyj}</td><td>（連携用）フィールド担当者有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x5 zrnyobiv1x5}</td><td>（連携用）予備項目Ｖ１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncatkihmkknrkmaekykhyj zrncatkihmkknrkmaekykhyj}</td><td>（連携用）Ｃ扱者訪問結果入力前契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncatkisetteikouhokykhyj zrncatkisetteikouhokykhyj}</td><td>（連携用）Ｃ扱者設定候補契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseppankeijyoukbn zrnseppankeijyoukbn}</td><td>（連携用）折半計上区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfollowtantousyakbn zrnfollowtantousyakbn}</td><td>（連携用）フォロー担当者区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7 zrnyobiv7}</td><td>（連携用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouminaosikaisuuv2 zrnhosyouminaosikaisuuv2}</td><td>（連携用）保障見直回数Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnkttnknkbn zrnbnkttnknkbn}</td><td>（連携用）分割転換区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkangosyono zrntenkangosyono}</td><td>（連携用）転換後証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnqpackhyj zrnqpackhyj}</td><td>（連携用）Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkangoqpackhyj zrntenkangoqpackhyj}</td><td>（連携用）転換後Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuruihnkutkbttrtkhyj zrnsyuruihnkutkbttrtkhyj}</td><td>（連携用）種類変更特別取扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnkngsyuhnkutkbttrtkhyj zrntnkngsyuhnkutkbttrtkhyj}</td><td>（連携用）転換後種類変更特別取扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkibanhikitugikbn zrnkibanhikitugikbn}</td><td>（連携用）基盤引継加算区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x6 zrnyobiv1x6}</td><td>（連携用）予備項目Ｖ１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumetucd zrnsyoumetucd}</td><td>（連携用）消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikaipjyuutouym zrnjikaipjyuutouym}</td><td>（連携用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomarusyuuhukahyj zrnkaigomarusyuuhukahyj}</td><td>（連携用）介護マル終付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x7 zrnyobiv1x7}</td><td>（連携用）予備項目Ｖ１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoritorikesihyj zrnsyoritorikesihyj}</td><td>（連携用）処理取消表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtikousinkatakbn zrnmrtikousinkatakbn}</td><td>（連携用）マル定更新型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbnv1 zrnpmenkbnv1}</td><td>（連携用）Ｐ免区分Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakutkknsnp zrnsyukeiyakutkknsnp}</td><td>（連携用）主契約月換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkansanp zrnnenkansanp}</td><td>（連携用）年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai3bunyanenkansanp zrndai3bunyanenkansanp}</td><td>（連携用）第３分野年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnyuuintkykhukahyj zrnnyuuintkykhukahyj}</td><td>（連携用）入院特約付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuuintkykhukahyj20ijyou zrnnyuuintkykhukahyj20ijyou}</td><td>（連携用）２０日以上入院特約付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuuintkykhukahyj5ijyou zrnnyuuintkykhukahyj5ijyou}</td><td>（連携用）５日以上入院特約付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyotkykhukahyj zrnmarusyotkykhukahyj}</td><td>（連携用）マル初特約付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarujyuutkykhukahyj zrnmarujyuutkykhukahyj}</td><td>（連携用）マル重特約付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakudaimaruitkykhukahyj zrnkakudaimaruitkykhukahyj}</td><td>（連携用）拡大マル医系特約付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakunyuutkykhukahyj zrnkakunyuutkykhukahyj}</td><td>（連携用）カク入特約付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruitkykhukahyj zrnmaruitkykhukahyj}</td><td>（連携用）マル医特約付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdairiseikyuutkykarihyj zrnstdairiseikyuutkykarihyj}</td><td>（連携用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkensuuyuuguukbn zrnkensuuyuuguukbn}</td><td>（連携用）件数優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigosynyteikikbn zrnkaigosynyteikikbn}</td><td>（連携用）（介護）収入定期区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigosynyteikishrkskbn zrnkaigosynyteikishrkskbn}</td><td>（連携用）（介護）収入定期支払回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngyousekibosyujisikakucd zrngyousekibosyujisikakucd}</td><td>（連携用）業績用募集時資格コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngyskboshtnsineiyksnkbn zrngyskboshtnsineiyksnkbn}</td><td>（連携用）業績用募集時発展新鋭躍進区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsynymrtihukahyj zrnsiktsynymrtihukahyj}</td><td>（連携用）生活収入マル定付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsynyteikikbn zrnsiktsynyteikikbn}</td><td>（連携用）生活収入定期区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikatusyuunyuumrtis zrnseikatusyuunyuumrtis}</td><td>（連携用）生活収入マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnlivguardhukahyj zrnlivguardhukahyj}</td><td>（連携用）ＬＩＶガード付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivguards zrnlivguards}</td><td>（連携用）ＬＩＶガードＳ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrttekitkarihyj zrnknkuzusnzyrttekitkarihyj}</td><td>（連携用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbluekzjtkaisiymd zrnbluekzjtkaisiymd}</td><td>（連携用）Ｂｌｕｅ継続状態開始年月日　</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrtstkbn zrnknkuzusnzyrtstkbn}</td><td>（連携用）健康増進乗率用ステータス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrtkykarihyj zrnkykdrtkykarihyj}</td><td>（連携用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicearihyj zrnkzktourokuservicearihyj}</td><td>（連携用）家族登録サービス有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteituukakbn zrnsiteituukakbn}</td><td>（連携用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinkimatuHoyuuFRn
 * @see     PKZT_SinkimatuHoyuuFRn
 * @see     QZT_SinkimatuHoyuuFRn
 * @see     GenQZT_SinkimatuHoyuuFRn
 */
@MappedSuperclass
@Table(name=GenZT_SinkimatuHoyuuFRn.TABLE_NAME)
@IdClass(value=PKZT_SinkimatuHoyuuFRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SinkimatuHoyuuFRn extends AbstractExDBEntityForZDB<ZT_SinkimatuHoyuuFRn, PKZT_SinkimatuHoyuuFRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SinkimatuHoyuuFRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNTANTOUKOJINCD         = "zrntantoukojincd";
    public static final String ZRNTANTOUSYASETTEIYM     = "zrntantousyasetteiym";
    public static final String ZRNKEIJYOUSAKIKBN        = "zrnkeijyousakikbn";
    public static final String ZRNKEIJYOUSAKISOSIKI     = "zrnkeijyousakisosiki";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNDENYMD                = "zrndenymd";
    public static final String ZRNUTIWAKEKBN            = "zrnutiwakekbn";
    public static final String ZRNTANTOUKEIYAKUKBN      = "zrntantoukeiyakukbn";
    public static final String ZRNKYDATKIKBN            = "zrnkydatkikbn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNSAISINBSYYM           = "zrnsaisinbsyym";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNMARUTEISYURUIKIGOU    = "zrnmaruteisyuruikigou";
    public static final String ZRNYOBIN3                = "zrnyobin3";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNYOBIV1X2              = "zrnyobiv1x2";
    public static final String ZRNKYKNIYUTKSYTIOUKBN    = "zrnkykniyutksytioukbn";
    public static final String ZRNYOBIV1X3              = "zrnyobiv1x3";
    public static final String ZRNTEISYUUHYJ            = "zrnteisyuuhyj";
    public static final String ZRNITIJIBRYOUROUHYJ      = "zrnitijibryourouhyj";
    public static final String ZRNMRTIHUKAHYJ           = "zrnmrtihukahyj";
    public static final String ZRNSEIZONMRTIHUKAHYJ     = "zrnseizonmrtihukahyj";
    public static final String ZRNTEIGENMRTIHUKAHYJ     = "zrnteigenmrtihukahyj";
    public static final String ZRNSYNYMRTIHUKAHYJ       = "zrnsynymrtihukahyj";
    public static final String ZRNLIVINGNEEDSTKYKARIHYJ = "zrnlivingneedstkykarihyj";
    public static final String ZRNREGUARDMRTIHUKAHYJ    = "zrnreguardmrtihukahyj";
    public static final String ZRNREGUARDMRSYUHUKAHYJ   = "zrnreguardmrsyuhukahyj";
    public static final String ZRNVGUARDMRTIHUKAHYJ     = "zrnvguardmrtihukahyj";
    public static final String ZRNKAIGONKTKYKHUKAHYJ    = "zrnkaigonktkykhukahyj";
    public static final String ZRNGOUKEISISTTKYKTKKNSNP = "zrngoukeisisttkyktkknsnp";
    public static final String ZRNHSYS                  = "zrnhsys";
    public static final String ZRNKENSUUN3              = "zrnkensuun3";
    public static final String ZRNHENKOUGOHOSYOUS       = "zrnhenkougohosyous";
    public static final String ZRNHTNS                  = "zrnhtns";
    public static final String ZRNHARAIKOMIP            = "zrnharaikomip";
    public static final String ZRNKAIYAKUSIHARAIKNGK    = "zrnkaiyakusiharaikngk";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNANNISKCD              = "zrnanniskcd";
    public static final String ZRNTENKANKAISUU          = "zrntenkankaisuu";
    public static final String ZRNSIKKOUNYKNKAISUU      = "zrnsikkounyknkaisuu";
    public static final String ZRNYOBIV2                = "zrnyobiv2";
    public static final String ZRNHHKNNEN2KETA          = "zrnhhknnen2keta";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNKJKYKNM               = "zrnkjkyknm";
    public static final String ZRNTSINKIHONTIKUCD       = "zrntsinkihontikucd";
    public static final String ZRNHJNKYKHYJ             = "zrnhjnkykhyj";
    public static final String ZRNHJNCD                 = "zrnhjncd";
    public static final String ZRNHJNJIGYOSYOCD         = "zrnhjnjigyosyocd";
    public static final String ZRNSYORISOSIKICD         = "zrnsyorisosikicd";
    public static final String ZRNTIKUSYOKANSISYAKIJYHYJ = "zrntikusyokansisyakijyhyj";
    public static final String ZRNKEIZOKUTYUUIHYOUJI    = "zrnkeizokutyuuihyouji";
    public static final String ZRNTYOHKKEIYAKUTYUUIKBN  = "zrntyohkkeiyakutyuuikbn";
    public static final String ZRNYOBIV1X4              = "zrnyobiv1x4";
    public static final String ZRNDANTAISYOZOKUCD       = "zrndantaisyozokucd";
    public static final String ZRNSUPERKNKUSEIKATUPACKHYJ = "zrnsuperknkuseikatupackhyj";
    public static final String ZRNJIKOKYKHYJ            = "zrnjikokykhyj";
    public static final String ZRNKIKEIYAKUTYUUIHYOUJI  = "zrnkikeiyakutyuuihyouji";
    public static final String ZRNSYUUSEIS              = "zrnsyuuseis";
    public static final String ZRNCLUBSUMISEIKAIINKYKKBN = "zrnclubsumiseikaiinkykkbn";
    public static final String ZRNGATKIHMKKNRKMAEKYKHYJ = "zrngatkihmkknrkmaekykhyj";
    public static final String ZRNGATKISETTEIKOUHOKYKHYJ = "zrngatkisetteikouhokykhyj";
    public static final String ZRNBOSYUU25KEIKAHYJ      = "zrnbosyuu25keikahyj";
    public static final String ZRNTOKUTEIDAISYOKUDANHYJ = "zrntokuteidaisyokudanhyj";
    public static final String ZRNHOYUUIKANTSGKYKHYJ    = "zrnhoyuuikantsgkykhyj";
    public static final String ZRNTOKUBETURULETIKUHYJ   = "zrntokubeturuletikuhyj";
    public static final String ZRNFIELDTANTOUSYAARIHYJ  = "zrnfieldtantousyaarihyj";
    public static final String ZRNYOBIV1X5              = "zrnyobiv1x5";
    public static final String ZRNCATKIHMKKNRKMAEKYKHYJ = "zrncatkihmkknrkmaekykhyj";
    public static final String ZRNCATKISETTEIKOUHOKYKHYJ = "zrncatkisetteikouhokykhyj";
    public static final String ZRNSEPPANKEIJYOUKBN      = "zrnseppankeijyoukbn";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNFOLLOWTANTOUSYAKBN    = "zrnfollowtantousyakbn";
    public static final String ZRNYOBIV7                = "zrnyobiv7";
    public static final String ZRNHOSYOUMINAOSIKAISUUV2 = "zrnhosyouminaosikaisuuv2";
    public static final String ZRNBNKTTNKNKBN           = "zrnbnkttnknkbn";
    public static final String ZRNTENKANGOSYONO         = "zrntenkangosyono";
    public static final String ZRNQPACKHYJ              = "zrnqpackhyj";
    public static final String ZRNTENKANGOQPACKHYJ      = "zrntenkangoqpackhyj";
    public static final String ZRNSYURUIHNKUTKBTTRTKHYJ = "zrnsyuruihnkutkbttrtkhyj";
    public static final String ZRNTNKNGSYUHNKUTKBTTRTKHYJ = "zrntnkngsyuhnkutkbttrtkhyj";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNKIBANHIKITUGIKBN      = "zrnkibanhikitugikbn";
    public static final String ZRNYOBIV1X6              = "zrnyobiv1x6";
    public static final String ZRNSYOUMETUCD            = "zrnsyoumetucd";
    public static final String ZRNJIKAIPJYUUTOUYM       = "zrnjikaipjyuutouym";
    public static final String ZRNKAIGOMARUSYUUHUKAHYJ  = "zrnkaigomarusyuuhukahyj";
    public static final String ZRNYOBIV1X7              = "zrnyobiv1x7";
    public static final String ZRNSYORITORIKESIHYJ      = "zrnsyoritorikesihyj";
    public static final String ZRNMRTIKOUSINKATAKBN     = "zrnmrtikousinkatakbn";
    public static final String ZRNPMENKBNV1             = "zrnpmenkbnv1";
    public static final String ZRNSYUKEIYAKUTKKNSNP     = "zrnsyukeiyakutkknsnp";
    public static final String ZRNNENKANSANP            = "zrnnenkansanp";
    public static final String ZRNDAI3BUNYANENKANSANP   = "zrndai3bunyanenkansanp";
    public static final String ZRNNYUUINTKYKHUKAHYJ     = "zrnnyuuintkykhukahyj";
    public static final String ZRNNYUUINTKYKHUKAHYJ20IJYOU = "zrnnyuuintkykhukahyj20ijyou";
    public static final String ZRNNYUUINTKYKHUKAHYJ5IJYOU = "zrnnyuuintkykhukahyj5ijyou";
    public static final String ZRNMARUSYOTKYKHUKAHYJ    = "zrnmarusyotkykhukahyj";
    public static final String ZRNMARUJYUUTKYKHUKAHYJ   = "zrnmarujyuutkykhukahyj";
    public static final String ZRNKAKUDAIMARUITKYKHUKAHYJ = "zrnkakudaimaruitkykhukahyj";
    public static final String ZRNKAKUNYUUTKYKHUKAHYJ   = "zrnkakunyuutkykhukahyj";
    public static final String ZRNMARUITKYKHUKAHYJ      = "zrnmaruitkykhukahyj";
    public static final String ZRNSTDAIRISEIKYUUTKYKARIHYJ = "zrnstdairiseikyuutkykarihyj";
    public static final String ZRNKENSUUYUUGUUKBN       = "zrnkensuuyuuguukbn";
    public static final String ZRNKAIGOSYNYTEIKIKBN     = "zrnkaigosynyteikikbn";
    public static final String ZRNKAIGOSYNYTEIKISHRKSKBN = "zrnkaigosynyteikishrkskbn";
    public static final String ZRNGYOUSEKIBOSYUJISIKAKUCD = "zrngyousekibosyujisikakucd";
    public static final String ZRNGYSKBOSHTNSINEIYKSNKBN = "zrngyskboshtnsineiyksnkbn";
    public static final String ZRNSIKTSYNYMRTIHUKAHYJ   = "zrnsiktsynymrtihukahyj";
    public static final String ZRNSIKTSYNYTEIKIKBN      = "zrnsiktsynyteikikbn";
    public static final String ZRNSEIKATUSYUUNYUUMRTIS  = "zrnseikatusyuunyuumrtis";
    public static final String ZRNLIVGUARDHUKAHYJ       = "zrnlivguardhukahyj";
    public static final String ZRNLIVGUARDS             = "zrnlivguards";
    public static final String ZRNKNKUZUSNZYRTTEKITKARIHYJ = "zrnknkuzusnzyrttekitkarihyj";
    public static final String ZRNBLUEKZJTKAISIYMD      = "zrnbluekzjtkaisiymd";
    public static final String ZRNKNKUZUSNZYRTSTKBN     = "zrnknkuzusnzyrtstkbn";
    public static final String ZRNKYKDRTKYKARIHYJ       = "zrnkykdrtkykarihyj";
    public static final String ZRNKZKTOUROKUSERVICEARIHYJ = "zrnkzktourokuservicearihyj";
    public static final String ZRNSITEITUUKAKBN         = "zrnsiteituukakbn";

    private final PKZT_SinkimatuHoyuuFRn primaryKey;

    public GenZT_SinkimatuHoyuuFRn() {
        primaryKey = new PKZT_SinkimatuHoyuuFRn();
    }

    public GenZT_SinkimatuHoyuuFRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_SinkimatuHoyuuFRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_SinkimatuHoyuuFRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SinkimatuHoyuuFRn> getMetaClass() {
        return QZT_SinkimatuHoyuuFRn.class;
    }

    @Id
    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrntantoukojincd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTANTOUKOJINCD)
    public String getZrntantoukojincd() {
        return zrntantoukojincd;
    }

    public void setZrntantoukojincd(String pZrntantoukojincd) {
        zrntantoukojincd = pZrntantoukojincd;
    }

    private String zrntantousyasetteiym;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTANTOUSYASETTEIYM)
    public String getZrntantousyasetteiym() {
        return zrntantousyasetteiym;
    }

    public void setZrntantousyasetteiym(String pZrntantousyasetteiym) {
        zrntantousyasetteiym = pZrntantousyasetteiym;
    }

    private String zrnkeijyousakikbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKEIJYOUSAKIKBN)
    public String getZrnkeijyousakikbn() {
        return zrnkeijyousakikbn;
    }

    public void setZrnkeijyousakikbn(String pZrnkeijyousakikbn) {
        zrnkeijyousakikbn = pZrnkeijyousakikbn;
    }

    private String zrnkeijyousakisosiki;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKEIJYOUSAKISOSIKI)
    public String getZrnkeijyousakisosiki() {
        return zrnkeijyousakisosiki;
    }

    public void setZrnkeijyousakisosiki(String pZrnkeijyousakisosiki) {
        zrnkeijyousakisosiki = pZrnkeijyousakisosiki;
    }

    private String zrnkeijyouym;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return zrnkeijyouym;
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        zrnkeijyouym = pZrnkeijyouym;
    }

    private String zrndenymd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNDENYMD)
    public String getZrndenymd() {
        return zrndenymd;
    }

    public void setZrndenymd(String pZrndenymd) {
        zrndenymd = pZrndenymd;
    }

    private String zrnutiwakekbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNUTIWAKEKBN)
    public String getZrnutiwakekbn() {
        return zrnutiwakekbn;
    }

    public void setZrnutiwakekbn(String pZrnutiwakekbn) {
        zrnutiwakekbn = pZrnutiwakekbn;
    }

    private String zrntantoukeiyakukbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTANTOUKEIYAKUKBN)
    public String getZrntantoukeiyakukbn() {
        return zrntantoukeiyakukbn;
    }

    public void setZrntantoukeiyakukbn(String pZrntantoukeiyakukbn) {
        zrntantoukeiyakukbn = pZrntantoukeiyakukbn;
    }

    private String zrnkydatkikbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKYDATKIKBN)
    public String getZrnkydatkikbn() {
        return zrnkydatkikbn;
    }

    public void setZrnkydatkikbn(String pZrnkydatkikbn) {
        zrnkydatkikbn = pZrnkydatkikbn;
    }

    private String zrnsyono;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnbsyym;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnkykymd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnsaisinbsyym;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSAISINBSYYM)
    public String getZrnsaisinbsyym() {
        return zrnsaisinbsyym;
    }

    public void setZrnsaisinbsyym(String pZrnsaisinbsyym) {
        zrnsaisinbsyym = pZrnsaisinbsyym;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnmaruteisyuruikigou;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNMARUTEISYURUIKIGOU)
    public String getZrnmaruteisyuruikigou() {
        return zrnmaruteisyuruikigou;
    }

    public void setZrnmaruteisyuruikigou(String pZrnmaruteisyuruikigou) {
        zrnmaruteisyuruikigou = pZrnmaruteisyuruikigou;
    }

    private Integer zrnyobin3;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIN3)
    public Integer getZrnyobin3() {
        return zrnyobin3;
    }

    public void setZrnyobin3(Integer pZrnyobin3) {
        zrnyobin3 = pZrnyobin3;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrnyobiv1x2;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIV1X2)
    public String getZrnyobiv1x2() {
        return zrnyobiv1x2;
    }

    public void setZrnyobiv1x2(String pZrnyobiv1x2) {
        zrnyobiv1x2 = pZrnyobiv1x2;
    }

    private String zrnkykniyutksytioukbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKYKNIYUTKSYTIOUKBN)
    public String getZrnkykniyutksytioukbn() {
        return zrnkykniyutksytioukbn;
    }

    public void setZrnkykniyutksytioukbn(String pZrnkykniyutksytioukbn) {
        zrnkykniyutksytioukbn = pZrnkykniyutksytioukbn;
    }

    private String zrnyobiv1x3;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIV1X3)
    public String getZrnyobiv1x3() {
        return zrnyobiv1x3;
    }

    public void setZrnyobiv1x3(String pZrnyobiv1x3) {
        zrnyobiv1x3 = pZrnyobiv1x3;
    }

    private String zrnteisyuuhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTEISYUUHYJ)
    public String getZrnteisyuuhyj() {
        return zrnteisyuuhyj;
    }

    public void setZrnteisyuuhyj(String pZrnteisyuuhyj) {
        zrnteisyuuhyj = pZrnteisyuuhyj;
    }

    private String zrnitijibryourouhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNITIJIBRYOUROUHYJ)
    public String getZrnitijibryourouhyj() {
        return zrnitijibryourouhyj;
    }

    public void setZrnitijibryourouhyj(String pZrnitijibryourouhyj) {
        zrnitijibryourouhyj = pZrnitijibryourouhyj;
    }

    private String zrnmrtihukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNMRTIHUKAHYJ)
    public String getZrnmrtihukahyj() {
        return zrnmrtihukahyj;
    }

    public void setZrnmrtihukahyj(String pZrnmrtihukahyj) {
        zrnmrtihukahyj = pZrnmrtihukahyj;
    }

    private String zrnseizonmrtihukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSEIZONMRTIHUKAHYJ)
    public String getZrnseizonmrtihukahyj() {
        return zrnseizonmrtihukahyj;
    }

    public void setZrnseizonmrtihukahyj(String pZrnseizonmrtihukahyj) {
        zrnseizonmrtihukahyj = pZrnseizonmrtihukahyj;
    }

    private String zrnteigenmrtihukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTEIGENMRTIHUKAHYJ)
    public String getZrnteigenmrtihukahyj() {
        return zrnteigenmrtihukahyj;
    }

    public void setZrnteigenmrtihukahyj(String pZrnteigenmrtihukahyj) {
        zrnteigenmrtihukahyj = pZrnteigenmrtihukahyj;
    }

    private String zrnsynymrtihukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSYNYMRTIHUKAHYJ)
    public String getZrnsynymrtihukahyj() {
        return zrnsynymrtihukahyj;
    }

    public void setZrnsynymrtihukahyj(String pZrnsynymrtihukahyj) {
        zrnsynymrtihukahyj = pZrnsynymrtihukahyj;
    }

    private String zrnlivingneedstkykarihyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNLIVINGNEEDSTKYKARIHYJ)
    public String getZrnlivingneedstkykarihyj() {
        return zrnlivingneedstkykarihyj;
    }

    public void setZrnlivingneedstkykarihyj(String pZrnlivingneedstkykarihyj) {
        zrnlivingneedstkykarihyj = pZrnlivingneedstkykarihyj;
    }

    private String zrnreguardmrtihukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNREGUARDMRTIHUKAHYJ)
    public String getZrnreguardmrtihukahyj() {
        return zrnreguardmrtihukahyj;
    }

    public void setZrnreguardmrtihukahyj(String pZrnreguardmrtihukahyj) {
        zrnreguardmrtihukahyj = pZrnreguardmrtihukahyj;
    }

    private String zrnreguardmrsyuhukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNREGUARDMRSYUHUKAHYJ)
    public String getZrnreguardmrsyuhukahyj() {
        return zrnreguardmrsyuhukahyj;
    }

    public void setZrnreguardmrsyuhukahyj(String pZrnreguardmrsyuhukahyj) {
        zrnreguardmrsyuhukahyj = pZrnreguardmrsyuhukahyj;
    }

    private String zrnvguardmrtihukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNVGUARDMRTIHUKAHYJ)
    public String getZrnvguardmrtihukahyj() {
        return zrnvguardmrtihukahyj;
    }

    public void setZrnvguardmrtihukahyj(String pZrnvguardmrtihukahyj) {
        zrnvguardmrtihukahyj = pZrnvguardmrtihukahyj;
    }

    private String zrnkaigonktkykhukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKAIGONKTKYKHUKAHYJ)
    public String getZrnkaigonktkykhukahyj() {
        return zrnkaigonktkykhukahyj;
    }

    public void setZrnkaigonktkykhukahyj(String pZrnkaigonktkykhukahyj) {
        zrnkaigonktkykhukahyj = pZrnkaigonktkykhukahyj;
    }

    private Long zrngoukeisisttkyktkknsnp;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNGOUKEISISTTKYKTKKNSNP)
    public Long getZrngoukeisisttkyktkknsnp() {
        return zrngoukeisisttkyktkknsnp;
    }

    public void setZrngoukeisisttkyktkknsnp(Long pZrngoukeisisttkyktkknsnp) {
        zrngoukeisisttkyktkknsnp = pZrngoukeisisttkyktkknsnp;
    }

    private Long zrnhsys;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHSYS)
    public Long getZrnhsys() {
        return zrnhsys;
    }

    public void setZrnhsys(Long pZrnhsys) {
        zrnhsys = pZrnhsys;
    }

    private BizNumber zrnkensuun3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKENSUUN3)
    public BizNumber getZrnkensuun3() {
        return zrnkensuun3;
    }

    public void setZrnkensuun3(BizNumber pZrnkensuun3) {
        zrnkensuun3 = pZrnkensuun3;
    }

    private Long zrnhenkougohosyous;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHENKOUGOHOSYOUS)
    public Long getZrnhenkougohosyous() {
        return zrnhenkougohosyous;
    }

    public void setZrnhenkougohosyous(Long pZrnhenkougohosyous) {
        zrnhenkougohosyous = pZrnhenkougohosyous;
    }

    private Long zrnhtns;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHTNS)
    public Long getZrnhtns() {
        return zrnhtns;
    }

    public void setZrnhtns(Long pZrnhtns) {
        zrnhtns = pZrnhtns;
    }

    private Long zrnharaikomip;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHARAIKOMIP)
    public Long getZrnharaikomip() {
        return zrnharaikomip;
    }

    public void setZrnharaikomip(Long pZrnharaikomip) {
        zrnharaikomip = pZrnharaikomip;
    }

    private Long zrnkaiyakusiharaikngk;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKAIYAKUSIHARAIKNGK)
    public Long getZrnkaiyakusiharaikngk() {
        return zrnkaiyakusiharaikngk;
    }

    public void setZrnkaiyakusiharaikngk(Long pZrnkaiyakusiharaikngk) {
        zrnkaiyakusiharaikngk = pZrnkaiyakusiharaikngk;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnanniskcd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNANNISKCD)
    public String getZrnanniskcd() {
        return zrnanniskcd;
    }

    public void setZrnanniskcd(String pZrnanniskcd) {
        zrnanniskcd = pZrnanniskcd;
    }

    private String zrntenkankaisuu;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTENKANKAISUU)
    public String getZrntenkankaisuu() {
        return zrntenkankaisuu;
    }

    public void setZrntenkankaisuu(String pZrntenkankaisuu) {
        zrntenkankaisuu = pZrntenkankaisuu;
    }

    private String zrnsikkounyknkaisuu;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSIKKOUNYKNKAISUU)
    public String getZrnsikkounyknkaisuu() {
        return zrnsikkounyknkaisuu;
    }

    public void setZrnsikkounyknkaisuu(String pZrnsikkounyknkaisuu) {
        zrnsikkounyknkaisuu = pZrnsikkounyknkaisuu;
    }

    private String zrnyobiv2;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIV2)
    public String getZrnyobiv2() {
        return zrnyobiv2;
    }

    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }

    private String zrnhhknnen2keta;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHHKNNEN2KETA)
    public String getZrnhhknnen2keta() {
        return zrnhhknnen2keta;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2keta(String pZrnhhknnen2keta) {
        zrnhhknnen2keta = pZrnhhknnen2keta;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnkjkyknm;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKJKYKNM)
    public String getZrnkjkyknm() {
        return zrnkjkyknm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm(String pZrnkjkyknm) {
        zrnkjkyknm = pZrnkjkyknm;
    }

    private String zrntsinkihontikucd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTSINKIHONTIKUCD)
    public String getZrntsinkihontikucd() {
        return zrntsinkihontikucd;
    }

    public void setZrntsinkihontikucd(String pZrntsinkihontikucd) {
        zrntsinkihontikucd = pZrntsinkihontikucd;
    }

    private String zrnhjnkykhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHJNKYKHYJ)
    public String getZrnhjnkykhyj() {
        return zrnhjnkykhyj;
    }

    public void setZrnhjnkykhyj(String pZrnhjnkykhyj) {
        zrnhjnkykhyj = pZrnhjnkykhyj;
    }

    private String zrnhjncd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHJNCD)
    public String getZrnhjncd() {
        return zrnhjncd;
    }

    public void setZrnhjncd(String pZrnhjncd) {
        zrnhjncd = pZrnhjncd;
    }

    private String zrnhjnjigyosyocd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHJNJIGYOSYOCD)
    public String getZrnhjnjigyosyocd() {
        return zrnhjnjigyosyocd;
    }

    public void setZrnhjnjigyosyocd(String pZrnhjnjigyosyocd) {
        zrnhjnjigyosyocd = pZrnhjnjigyosyocd;
    }

    private String zrnsyorisosikicd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSYORISOSIKICD)
    public String getZrnsyorisosikicd() {
        return zrnsyorisosikicd;
    }

    public void setZrnsyorisosikicd(String pZrnsyorisosikicd) {
        zrnsyorisosikicd = pZrnsyorisosikicd;
    }

    private String zrntikusyokansisyakijyhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTIKUSYOKANSISYAKIJYHYJ)
    public String getZrntikusyokansisyakijyhyj() {
        return zrntikusyokansisyakijyhyj;
    }

    public void setZrntikusyokansisyakijyhyj(String pZrntikusyokansisyakijyhyj) {
        zrntikusyokansisyakijyhyj = pZrntikusyokansisyakijyhyj;
    }

    private String zrnkeizokutyuuihyouji;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKEIZOKUTYUUIHYOUJI)
    public String getZrnkeizokutyuuihyouji() {
        return zrnkeizokutyuuihyouji;
    }

    public void setZrnkeizokutyuuihyouji(String pZrnkeizokutyuuihyouji) {
        zrnkeizokutyuuihyouji = pZrnkeizokutyuuihyouji;
    }

    private String zrntyohkkeiyakutyuuikbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTYOHKKEIYAKUTYUUIKBN)
    public String getZrntyohkkeiyakutyuuikbn() {
        return zrntyohkkeiyakutyuuikbn;
    }

    public void setZrntyohkkeiyakutyuuikbn(String pZrntyohkkeiyakutyuuikbn) {
        zrntyohkkeiyakutyuuikbn = pZrntyohkkeiyakutyuuikbn;
    }

    private String zrnyobiv1x4;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIV1X4)
    public String getZrnyobiv1x4() {
        return zrnyobiv1x4;
    }

    public void setZrnyobiv1x4(String pZrnyobiv1x4) {
        zrnyobiv1x4 = pZrnyobiv1x4;
    }

    private String zrndantaisyozokucd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNDANTAISYOZOKUCD)
    public String getZrndantaisyozokucd() {
        return zrndantaisyozokucd;
    }

    public void setZrndantaisyozokucd(String pZrndantaisyozokucd) {
        zrndantaisyozokucd = pZrndantaisyozokucd;
    }

    private String zrnsuperknkuseikatupackhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSUPERKNKUSEIKATUPACKHYJ)
    public String getZrnsuperknkuseikatupackhyj() {
        return zrnsuperknkuseikatupackhyj;
    }

    public void setZrnsuperknkuseikatupackhyj(String pZrnsuperknkuseikatupackhyj) {
        zrnsuperknkuseikatupackhyj = pZrnsuperknkuseikatupackhyj;
    }

    private String zrnjikokykhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNJIKOKYKHYJ)
    public String getZrnjikokykhyj() {
        return zrnjikokykhyj;
    }

    public void setZrnjikokykhyj(String pZrnjikokykhyj) {
        zrnjikokykhyj = pZrnjikokykhyj;
    }

    private String zrnkikeiyakutyuuihyouji;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKIKEIYAKUTYUUIHYOUJI)
    public String getZrnkikeiyakutyuuihyouji() {
        return zrnkikeiyakutyuuihyouji;
    }

    public void setZrnkikeiyakutyuuihyouji(String pZrnkikeiyakutyuuihyouji) {
        zrnkikeiyakutyuuihyouji = pZrnkikeiyakutyuuihyouji;
    }

    private Long zrnsyuuseis;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSYUUSEIS)
    public Long getZrnsyuuseis() {
        return zrnsyuuseis;
    }

    public void setZrnsyuuseis(Long pZrnsyuuseis) {
        zrnsyuuseis = pZrnsyuuseis;
    }

    private String zrnclubsumiseikaiinkykkbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNCLUBSUMISEIKAIINKYKKBN)
    public String getZrnclubsumiseikaiinkykkbn() {
        return zrnclubsumiseikaiinkykkbn;
    }

    public void setZrnclubsumiseikaiinkykkbn(String pZrnclubsumiseikaiinkykkbn) {
        zrnclubsumiseikaiinkykkbn = pZrnclubsumiseikaiinkykkbn;
    }

    private String zrngatkihmkknrkmaekykhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNGATKIHMKKNRKMAEKYKHYJ)
    public String getZrngatkihmkknrkmaekykhyj() {
        return zrngatkihmkknrkmaekykhyj;
    }

    public void setZrngatkihmkknrkmaekykhyj(String pZrngatkihmkknrkmaekykhyj) {
        zrngatkihmkknrkmaekykhyj = pZrngatkihmkknrkmaekykhyj;
    }

    private String zrngatkisetteikouhokykhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNGATKISETTEIKOUHOKYKHYJ)
    public String getZrngatkisetteikouhokykhyj() {
        return zrngatkisetteikouhokykhyj;
    }

    public void setZrngatkisetteikouhokykhyj(String pZrngatkisetteikouhokykhyj) {
        zrngatkisetteikouhokykhyj = pZrngatkisetteikouhokykhyj;
    }

    private String zrnbosyuu25keikahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNBOSYUU25KEIKAHYJ)
    public String getZrnbosyuu25keikahyj() {
        return zrnbosyuu25keikahyj;
    }

    public void setZrnbosyuu25keikahyj(String pZrnbosyuu25keikahyj) {
        zrnbosyuu25keikahyj = pZrnbosyuu25keikahyj;
    }

    private String zrntokuteidaisyokudanhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTOKUTEIDAISYOKUDANHYJ)
    public String getZrntokuteidaisyokudanhyj() {
        return zrntokuteidaisyokudanhyj;
    }

    public void setZrntokuteidaisyokudanhyj(String pZrntokuteidaisyokudanhyj) {
        zrntokuteidaisyokudanhyj = pZrntokuteidaisyokudanhyj;
    }

    private String zrnhoyuuikantsgkykhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHOYUUIKANTSGKYKHYJ)
    public String getZrnhoyuuikantsgkykhyj() {
        return zrnhoyuuikantsgkykhyj;
    }

    public void setZrnhoyuuikantsgkykhyj(String pZrnhoyuuikantsgkykhyj) {
        zrnhoyuuikantsgkykhyj = pZrnhoyuuikantsgkykhyj;
    }

    private String zrntokubeturuletikuhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTOKUBETURULETIKUHYJ)
    public String getZrntokubeturuletikuhyj() {
        return zrntokubeturuletikuhyj;
    }

    public void setZrntokubeturuletikuhyj(String pZrntokubeturuletikuhyj) {
        zrntokubeturuletikuhyj = pZrntokubeturuletikuhyj;
    }

    private String zrnfieldtantousyaarihyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNFIELDTANTOUSYAARIHYJ)
    public String getZrnfieldtantousyaarihyj() {
        return zrnfieldtantousyaarihyj;
    }

    public void setZrnfieldtantousyaarihyj(String pZrnfieldtantousyaarihyj) {
        zrnfieldtantousyaarihyj = pZrnfieldtantousyaarihyj;
    }

    private String zrnyobiv1x5;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIV1X5)
    public String getZrnyobiv1x5() {
        return zrnyobiv1x5;
    }

    public void setZrnyobiv1x5(String pZrnyobiv1x5) {
        zrnyobiv1x5 = pZrnyobiv1x5;
    }

    private String zrncatkihmkknrkmaekykhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNCATKIHMKKNRKMAEKYKHYJ)
    public String getZrncatkihmkknrkmaekykhyj() {
        return zrncatkihmkknrkmaekykhyj;
    }

    public void setZrncatkihmkknrkmaekykhyj(String pZrncatkihmkknrkmaekykhyj) {
        zrncatkihmkknrkmaekykhyj = pZrncatkihmkknrkmaekykhyj;
    }

    private String zrncatkisetteikouhokykhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNCATKISETTEIKOUHOKYKHYJ)
    public String getZrncatkisetteikouhokykhyj() {
        return zrncatkisetteikouhokykhyj;
    }

    public void setZrncatkisetteikouhokykhyj(String pZrncatkisetteikouhokykhyj) {
        zrncatkisetteikouhokykhyj = pZrncatkisetteikouhokykhyj;
    }

    private String zrnseppankeijyoukbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSEPPANKEIJYOUKBN)
    public String getZrnseppankeijyoukbn() {
        return zrnseppankeijyoukbn;
    }

    public void setZrnseppankeijyoukbn(String pZrnseppankeijyoukbn) {
        zrnseppankeijyoukbn = pZrnseppankeijyoukbn;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private String zrnfollowtantousyakbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNFOLLOWTANTOUSYAKBN)
    public String getZrnfollowtantousyakbn() {
        return zrnfollowtantousyakbn;
    }

    public void setZrnfollowtantousyakbn(String pZrnfollowtantousyakbn) {
        zrnfollowtantousyakbn = pZrnfollowtantousyakbn;
    }

    private String zrnyobiv7;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIV7)
    public String getZrnyobiv7() {
        return zrnyobiv7;
    }

    public void setZrnyobiv7(String pZrnyobiv7) {
        zrnyobiv7 = pZrnyobiv7;
    }

    private String zrnhosyouminaosikaisuuv2;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNHOSYOUMINAOSIKAISUUV2)
    public String getZrnhosyouminaosikaisuuv2() {
        return zrnhosyouminaosikaisuuv2;
    }

    public void setZrnhosyouminaosikaisuuv2(String pZrnhosyouminaosikaisuuv2) {
        zrnhosyouminaosikaisuuv2 = pZrnhosyouminaosikaisuuv2;
    }

    private String zrnbnkttnknkbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNBNKTTNKNKBN)
    public String getZrnbnkttnknkbn() {
        return zrnbnkttnknkbn;
    }

    public void setZrnbnkttnknkbn(String pZrnbnkttnknkbn) {
        zrnbnkttnknkbn = pZrnbnkttnknkbn;
    }

    private String zrntenkangosyono;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTENKANGOSYONO)
    public String getZrntenkangosyono() {
        return zrntenkangosyono;
    }

    public void setZrntenkangosyono(String pZrntenkangosyono) {
        zrntenkangosyono = pZrntenkangosyono;
    }

    private String zrnqpackhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNQPACKHYJ)
    public String getZrnqpackhyj() {
        return zrnqpackhyj;
    }

    public void setZrnqpackhyj(String pZrnqpackhyj) {
        zrnqpackhyj = pZrnqpackhyj;
    }

    private String zrntenkangoqpackhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTENKANGOQPACKHYJ)
    public String getZrntenkangoqpackhyj() {
        return zrntenkangoqpackhyj;
    }

    public void setZrntenkangoqpackhyj(String pZrntenkangoqpackhyj) {
        zrntenkangoqpackhyj = pZrntenkangoqpackhyj;
    }

    private String zrnsyuruihnkutkbttrtkhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSYURUIHNKUTKBTTRTKHYJ)
    public String getZrnsyuruihnkutkbttrtkhyj() {
        return zrnsyuruihnkutkbttrtkhyj;
    }

    public void setZrnsyuruihnkutkbttrtkhyj(String pZrnsyuruihnkutkbttrtkhyj) {
        zrnsyuruihnkutkbttrtkhyj = pZrnsyuruihnkutkbttrtkhyj;
    }

    private String zrntnkngsyuhnkutkbttrtkhyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNTNKNGSYUHNKUTKBTTRTKHYJ)
    public String getZrntnkngsyuhnkutkbttrtkhyj() {
        return zrntnkngsyuhnkutkbttrtkhyj;
    }

    public void setZrntnkngsyuhnkutkbttrtkhyj(String pZrntnkngsyuhnkutkbttrtkhyj) {
        zrntnkngsyuhnkutkbttrtkhyj = pZrntnkngsyuhnkutkbttrtkhyj;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private String zrnkibanhikitugikbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKIBANHIKITUGIKBN)
    public String getZrnkibanhikitugikbn() {
        return zrnkibanhikitugikbn;
    }

    public void setZrnkibanhikitugikbn(String pZrnkibanhikitugikbn) {
        zrnkibanhikitugikbn = pZrnkibanhikitugikbn;
    }

    private String zrnyobiv1x6;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIV1X6)
    public String getZrnyobiv1x6() {
        return zrnyobiv1x6;
    }

    public void setZrnyobiv1x6(String pZrnyobiv1x6) {
        zrnyobiv1x6 = pZrnyobiv1x6;
    }

    private String zrnsyoumetucd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSYOUMETUCD)
    public String getZrnsyoumetucd() {
        return zrnsyoumetucd;
    }

    public void setZrnsyoumetucd(String pZrnsyoumetucd) {
        zrnsyoumetucd = pZrnsyoumetucd;
    }

    private String zrnjikaipjyuutouym;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNJIKAIPJYUUTOUYM)
    public String getZrnjikaipjyuutouym() {
        return zrnjikaipjyuutouym;
    }

    public void setZrnjikaipjyuutouym(String pZrnjikaipjyuutouym) {
        zrnjikaipjyuutouym = pZrnjikaipjyuutouym;
    }

    private String zrnkaigomarusyuuhukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKAIGOMARUSYUUHUKAHYJ)
    public String getZrnkaigomarusyuuhukahyj() {
        return zrnkaigomarusyuuhukahyj;
    }

    public void setZrnkaigomarusyuuhukahyj(String pZrnkaigomarusyuuhukahyj) {
        zrnkaigomarusyuuhukahyj = pZrnkaigomarusyuuhukahyj;
    }

    private String zrnyobiv1x7;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNYOBIV1X7)
    public String getZrnyobiv1x7() {
        return zrnyobiv1x7;
    }

    public void setZrnyobiv1x7(String pZrnyobiv1x7) {
        zrnyobiv1x7 = pZrnyobiv1x7;
    }

    private String zrnsyoritorikesihyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSYORITORIKESIHYJ)
    public String getZrnsyoritorikesihyj() {
        return zrnsyoritorikesihyj;
    }

    public void setZrnsyoritorikesihyj(String pZrnsyoritorikesihyj) {
        zrnsyoritorikesihyj = pZrnsyoritorikesihyj;
    }

    private String zrnmrtikousinkatakbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNMRTIKOUSINKATAKBN)
    public String getZrnmrtikousinkatakbn() {
        return zrnmrtikousinkatakbn;
    }

    public void setZrnmrtikousinkatakbn(String pZrnmrtikousinkatakbn) {
        zrnmrtikousinkatakbn = pZrnmrtikousinkatakbn;
    }

    private String zrnpmenkbnv1;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNPMENKBNV1)
    public String getZrnpmenkbnv1() {
        return zrnpmenkbnv1;
    }

    public void setZrnpmenkbnv1(String pZrnpmenkbnv1) {
        zrnpmenkbnv1 = pZrnpmenkbnv1;
    }

    private Long zrnsyukeiyakutkknsnp;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSYUKEIYAKUTKKNSNP)
    public Long getZrnsyukeiyakutkknsnp() {
        return zrnsyukeiyakutkknsnp;
    }

    public void setZrnsyukeiyakutkknsnp(Long pZrnsyukeiyakutkknsnp) {
        zrnsyukeiyakutkknsnp = pZrnsyukeiyakutkknsnp;
    }

    private Long zrnnenkansanp;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNNENKANSANP)
    public Long getZrnnenkansanp() {
        return zrnnenkansanp;
    }

    public void setZrnnenkansanp(Long pZrnnenkansanp) {
        zrnnenkansanp = pZrnnenkansanp;
    }

    private Long zrndai3bunyanenkansanp;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNDAI3BUNYANENKANSANP)
    public Long getZrndai3bunyanenkansanp() {
        return zrndai3bunyanenkansanp;
    }

    public void setZrndai3bunyanenkansanp(Long pZrndai3bunyanenkansanp) {
        zrndai3bunyanenkansanp = pZrndai3bunyanenkansanp;
    }

    private String zrnnyuuintkykhukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNNYUUINTKYKHUKAHYJ)
    public String getZrnnyuuintkykhukahyj() {
        return zrnnyuuintkykhukahyj;
    }

    public void setZrnnyuuintkykhukahyj(String pZrnnyuuintkykhukahyj) {
        zrnnyuuintkykhukahyj = pZrnnyuuintkykhukahyj;
    }

    private String zrnnyuuintkykhukahyj20ijyou;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNNYUUINTKYKHUKAHYJ20IJYOU)
    public String getZrnnyuuintkykhukahyj20ijyou() {
        return zrnnyuuintkykhukahyj20ijyou;
    }

    public void setZrnnyuuintkykhukahyj20ijyou(String pZrnnyuuintkykhukahyj20ijyou) {
        zrnnyuuintkykhukahyj20ijyou = pZrnnyuuintkykhukahyj20ijyou;
    }

    private String zrnnyuuintkykhukahyj5ijyou;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNNYUUINTKYKHUKAHYJ5IJYOU)
    public String getZrnnyuuintkykhukahyj5ijyou() {
        return zrnnyuuintkykhukahyj5ijyou;
    }

    public void setZrnnyuuintkykhukahyj5ijyou(String pZrnnyuuintkykhukahyj5ijyou) {
        zrnnyuuintkykhukahyj5ijyou = pZrnnyuuintkykhukahyj5ijyou;
    }

    private String zrnmarusyotkykhukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNMARUSYOTKYKHUKAHYJ)
    public String getZrnmarusyotkykhukahyj() {
        return zrnmarusyotkykhukahyj;
    }

    public void setZrnmarusyotkykhukahyj(String pZrnmarusyotkykhukahyj) {
        zrnmarusyotkykhukahyj = pZrnmarusyotkykhukahyj;
    }

    private String zrnmarujyuutkykhukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNMARUJYUUTKYKHUKAHYJ)
    public String getZrnmarujyuutkykhukahyj() {
        return zrnmarujyuutkykhukahyj;
    }

    public void setZrnmarujyuutkykhukahyj(String pZrnmarujyuutkykhukahyj) {
        zrnmarujyuutkykhukahyj = pZrnmarujyuutkykhukahyj;
    }

    private String zrnkakudaimaruitkykhukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKAKUDAIMARUITKYKHUKAHYJ)
    public String getZrnkakudaimaruitkykhukahyj() {
        return zrnkakudaimaruitkykhukahyj;
    }

    public void setZrnkakudaimaruitkykhukahyj(String pZrnkakudaimaruitkykhukahyj) {
        zrnkakudaimaruitkykhukahyj = pZrnkakudaimaruitkykhukahyj;
    }

    private String zrnkakunyuutkykhukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKAKUNYUUTKYKHUKAHYJ)
    public String getZrnkakunyuutkykhukahyj() {
        return zrnkakunyuutkykhukahyj;
    }

    public void setZrnkakunyuutkykhukahyj(String pZrnkakunyuutkykhukahyj) {
        zrnkakunyuutkykhukahyj = pZrnkakunyuutkykhukahyj;
    }

    private String zrnmaruitkykhukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNMARUITKYKHUKAHYJ)
    public String getZrnmaruitkykhukahyj() {
        return zrnmaruitkykhukahyj;
    }

    public void setZrnmaruitkykhukahyj(String pZrnmaruitkykhukahyj) {
        zrnmaruitkykhukahyj = pZrnmaruitkykhukahyj;
    }

    private String zrnstdairiseikyuutkykarihyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZrnstdairiseikyuutkykarihyj() {
        return zrnstdairiseikyuutkykarihyj;
    }

    public void setZrnstdairiseikyuutkykarihyj(String pZrnstdairiseikyuutkykarihyj) {
        zrnstdairiseikyuutkykarihyj = pZrnstdairiseikyuutkykarihyj;
    }

    private String zrnkensuuyuuguukbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKENSUUYUUGUUKBN)
    public String getZrnkensuuyuuguukbn() {
        return zrnkensuuyuuguukbn;
    }

    public void setZrnkensuuyuuguukbn(String pZrnkensuuyuuguukbn) {
        zrnkensuuyuuguukbn = pZrnkensuuyuuguukbn;
    }

    private String zrnkaigosynyteikikbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKAIGOSYNYTEIKIKBN)
    public String getZrnkaigosynyteikikbn() {
        return zrnkaigosynyteikikbn;
    }

    public void setZrnkaigosynyteikikbn(String pZrnkaigosynyteikikbn) {
        zrnkaigosynyteikikbn = pZrnkaigosynyteikikbn;
    }

    private String zrnkaigosynyteikishrkskbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKAIGOSYNYTEIKISHRKSKBN)
    public String getZrnkaigosynyteikishrkskbn() {
        return zrnkaigosynyteikishrkskbn;
    }

    public void setZrnkaigosynyteikishrkskbn(String pZrnkaigosynyteikishrkskbn) {
        zrnkaigosynyteikishrkskbn = pZrnkaigosynyteikishrkskbn;
    }

    private String zrngyousekibosyujisikakucd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNGYOUSEKIBOSYUJISIKAKUCD)
    public String getZrngyousekibosyujisikakucd() {
        return zrngyousekibosyujisikakucd;
    }

    public void setZrngyousekibosyujisikakucd(String pZrngyousekibosyujisikakucd) {
        zrngyousekibosyujisikakucd = pZrngyousekibosyujisikakucd;
    }

    private String zrngyskboshtnsineiyksnkbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNGYSKBOSHTNSINEIYKSNKBN)
    public String getZrngyskboshtnsineiyksnkbn() {
        return zrngyskboshtnsineiyksnkbn;
    }

    public void setZrngyskboshtnsineiyksnkbn(String pZrngyskboshtnsineiyksnkbn) {
        zrngyskboshtnsineiyksnkbn = pZrngyskboshtnsineiyksnkbn;
    }

    private String zrnsiktsynymrtihukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSIKTSYNYMRTIHUKAHYJ)
    public String getZrnsiktsynymrtihukahyj() {
        return zrnsiktsynymrtihukahyj;
    }

    public void setZrnsiktsynymrtihukahyj(String pZrnsiktsynymrtihukahyj) {
        zrnsiktsynymrtihukahyj = pZrnsiktsynymrtihukahyj;
    }

    private String zrnsiktsynyteikikbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSIKTSYNYTEIKIKBN)
    public String getZrnsiktsynyteikikbn() {
        return zrnsiktsynyteikikbn;
    }

    public void setZrnsiktsynyteikikbn(String pZrnsiktsynyteikikbn) {
        zrnsiktsynyteikikbn = pZrnsiktsynyteikikbn;
    }

    private Long zrnseikatusyuunyuumrtis;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSEIKATUSYUUNYUUMRTIS)
    public Long getZrnseikatusyuunyuumrtis() {
        return zrnseikatusyuunyuumrtis;
    }

    public void setZrnseikatusyuunyuumrtis(Long pZrnseikatusyuunyuumrtis) {
        zrnseikatusyuunyuumrtis = pZrnseikatusyuunyuumrtis;
    }

    private String zrnlivguardhukahyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNLIVGUARDHUKAHYJ)
    public String getZrnlivguardhukahyj() {
        return zrnlivguardhukahyj;
    }

    public void setZrnlivguardhukahyj(String pZrnlivguardhukahyj) {
        zrnlivguardhukahyj = pZrnlivguardhukahyj;
    }

    private Long zrnlivguards;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNLIVGUARDS)
    public Long getZrnlivguards() {
        return zrnlivguards;
    }

    public void setZrnlivguards(Long pZrnlivguards) {
        zrnlivguards = pZrnlivguards;
    }

    private String zrnknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZrnknkuzusnzyrttekitkarihyj() {
        return zrnknkuzusnzyrttekitkarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnknkuzusnzyrttekitkarihyj(String pZrnknkuzusnzyrttekitkarihyj) {
        zrnknkuzusnzyrttekitkarihyj = pZrnknkuzusnzyrttekitkarihyj;
    }

    private String zrnbluekzjtkaisiymd;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNBLUEKZJTKAISIYMD)
    public String getZrnbluekzjtkaisiymd() {
        return zrnbluekzjtkaisiymd;
    }

    public void setZrnbluekzjtkaisiymd(String pZrnbluekzjtkaisiymd) {
        zrnbluekzjtkaisiymd = pZrnbluekzjtkaisiymd;
    }

    private String zrnknkuzusnzyrtstkbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKNKUZUSNZYRTSTKBN)
    public String getZrnknkuzusnzyrtstkbn() {
        return zrnknkuzusnzyrtstkbn;
    }

    public void setZrnknkuzusnzyrtstkbn(String pZrnknkuzusnzyrtstkbn) {
        zrnknkuzusnzyrtstkbn = pZrnknkuzusnzyrtstkbn;
    }

    private String zrnkykdrtkykarihyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKYKDRTKYKARIHYJ)
    public String getZrnkykdrtkykarihyj() {
        return zrnkykdrtkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykdrtkykarihyj(String pZrnkykdrtkykarihyj) {
        zrnkykdrtkykarihyj = pZrnkykdrtkykarihyj;
    }

    private String zrnkzktourokuservicearihyj;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNKZKTOUROKUSERVICEARIHYJ)
    public String getZrnkzktourokuservicearihyj() {
        return zrnkzktourokuservicearihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzktourokuservicearihyj(String pZrnkzktourokuservicearihyj) {
        zrnkzktourokuservicearihyj = pZrnkzktourokuservicearihyj;
    }

    private String zrnsiteituukakbn;

    @Column(name=GenZT_SinkimatuHoyuuFRn.ZRNSITEITUUKAKBN)
    public String getZrnsiteituukakbn() {
        return zrnsiteituukakbn;
    }

    public void setZrnsiteituukakbn(String pZrnsiteituukakbn) {
        zrnsiteituukakbn = pZrnsiteituukakbn;
    }
}