package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFTy;
import yuyu.def.db.id.PKZT_HoyuuJyunzouZougenFTy;
import yuyu.def.db.meta.GenQZT_HoyuuJyunzouZougenFTy;
import yuyu.def.db.meta.QZT_HoyuuJyunzouZougenFTy;

/**
 * 保有純増増減Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_HoyuuJyunzouZougenFTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HoyuuJyunzouZougenFTy}</td><td colspan="3">保有純増増減Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_HoyuuJyunzouZougenFTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytantoukojincd ztytantoukojincd}</td><td>（中継用）担当者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantousyasetteiym ztytantousyasetteiym}</td><td>（中継用）担当者設定年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyousakikbn ztykeijyousakikbn}</td><td>（中継用）計上先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyousakisosiki ztykeijyousakisosiki}</td><td>（中継用）計上先組織</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenymd ztydenymd}</td><td>（中継用）伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyutiwakekbn ztyutiwakekbn}</td><td>（中継用）内訳区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantoukeiyakukbn ztytantoukeiyakukbn}</td><td>（中継用）担当契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkikbn ztykydatkikbn}</td><td>（中継用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisinbsyym ztysaisinbsyym}</td><td>（中継用）最新募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteisyuruikigou ztymaruteisyuruikigou}</td><td>（中継用）マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin3 ztyyobin3}</td><td>（中継用）予備項目Ｎ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv1 ztyyobiv1}</td><td>（中継用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x2 ztyyobiv1x2}</td><td>（中継用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyutksytioukbn ztykykniyutksytioukbn}</td><td>（中継用）契約内容特殊対応区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x3 ztyyobiv1x3}</td><td>（中継用）予備項目Ｖ１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteisyuuhyj ztyteisyuuhyj}</td><td>（中継用）定終表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibryourouhyj ztyitijibryourouhyj}</td><td>（中継用）一時払養老表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtihukahyj ztymrtihukahyj}</td><td>（中継用）マル定付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmrtihukahyj ztyseizonmrtihukahyj}</td><td>（中継用）生存マル定付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmrtihukahyj ztyteigenmrtihukahyj}</td><td>（中継用）逓減マル定付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysynymrtihukahyj ztysynymrtihukahyj}</td><td>（中継用）収入マル定付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivingneedstkykarihyj ztylivingneedstkykarihyj}</td><td>（中継用）リビングニーズ特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyreguardmrtihukahyj ztyreguardmrtihukahyj}</td><td>（中継用）リガードマル定付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyreguardmrsyuhukahyj ztyreguardmrsyuhukahyj}</td><td>（中継用）リガードマル終付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvguardmrtihukahyj ztyvguardmrtihukahyj}</td><td>（中継用）Ｖガードマル定付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykhukahyj ztykaigonktkykhukahyj}</td><td>（中継用）介護年金特約付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeisisttkyktkknsnp ztygoukeisisttkyktkknsnp}</td><td>（中継用）合計災疾特約月換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhsys ztyhsys}</td><td>（中継用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykensuun3 ztykensuun3}</td><td>（中継用）件数Ｎ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyhenkougohosyous ztyhenkougohosyous}</td><td>（中継用）変更後保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtns ztyhtns}</td><td>（中継用）被転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyharaikomip ztyharaikomip}</td><td>（中継用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakusiharaikngk ztykaiyakusiharaikngk}</td><td>（中継用）解約支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyanniskcd ztyanniskcd}</td><td>（中継用）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkankaisuu ztytenkankaisuu}</td><td>（中継用）転換回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikkounyknkaisuu ztysikkounyknkaisuu}</td><td>（中継用）失効入金回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2 ztyyobiv2}</td><td>（中継用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2keta ztyhhknnen2keta}</td><td>（中継用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm ztykjkyknm}</td><td>（中継用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinkihontikucd ztytsinkihontikucd}</td><td>（中継用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnkykhyj ztyhjnkykhyj}</td><td>（中継用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjncd ztyhjncd}</td><td>（中継用）法人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnjigyosyocd ztyhjnjigyosyocd}</td><td>（中継用）法人事業所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorisosikicd ztysyorisosikicd}</td><td>（中継用）処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytikusyokansisyakijyhyj ztytikusyokansisyakijyhyj}</td><td>（中継用）地区所管支社計上表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeizokutyuuihyouji ztykeizokutyuuihyouji}</td><td>（中継用）継続注意表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyohkkeiyakutyuuikbn ztytyohkkeiyakutyuuikbn}</td><td>（中継用）重複契約注意区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x4 ztyyobiv1x4}</td><td>（中継用）予備項目Ｖ１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydantaisyozokucd ztydantaisyozokucd}</td><td>（中継用）団体所属コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuperknkuseikatupackhyj ztysuperknkuseikatupackhyj}</td><td>（中継用）スーパー健康生活パック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikokykhyj ztyjikokykhyj}</td><td>（中継用）自己契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykikeiyakutyuuihyouji ztykikeiyakutyuuihyouji}</td><td>（中継用）既契約注意表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuuseis ztysyuuseis}</td><td>（中継用）修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyclubsumiseikaiinkykkbn ztyclubsumiseikaiinkykkbn}</td><td>（中継用）クラブスミセイ会員契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygatkihmkknrkmaekykhyj ztygatkihmkknrkmaekykhyj}</td><td>（中継用）Ｇ扱者訪問結果入力前契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygatkisetteikouhokykhyj ztygatkisetteikouhokykhyj}</td><td>（中継用）Ｇ扱者設定候補契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuu25keikahyj ztybosyuu25keikahyj}</td><td>（中継用）募集２５カ月経過表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteidaisyokudanhyj ztytokuteidaisyokudanhyj}</td><td>（中継用）特定大職団表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhoyuuikantsgkykhyj ztyhoyuuikantsgkykhyj}</td><td>（中継用）保有移管対象外契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokubeturuletikuhyj ztytokubeturuletikuhyj}</td><td>（中継用）特別ルール地区表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfieldtantousyaarihyj ztyfieldtantousyaarihyj}</td><td>（中継用）フィールド担当者有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x5 ztyyobiv1x5}</td><td>（中継用）予備項目Ｖ１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycatkihmkknrkmaekykhyj ztycatkihmkknrkmaekykhyj}</td><td>（中継用）Ｃ扱者訪問結果入力前契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycatkisetteikouhokykhyj ztycatkisetteikouhokykhyj}</td><td>（中継用）Ｃ扱者設定候補契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseppankeijyoukbn ztyseppankeijyoukbn}</td><td>（中継用）折半計上区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfollowtantousyakbn ztyfollowtantousyakbn}</td><td>（中継用）フォロー担当者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7 ztyyobiv7}</td><td>（中継用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouminaosikaisuuv2 ztyhosyouminaosikaisuuv2}</td><td>（中継用）保障見直回数Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnkttnknkbn ztybnkttnknkbn}</td><td>（中継用）分割転換区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkangosyono ztytenkangosyono}</td><td>（中継用）転換後証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyqpackhyj ztyqpackhyj}</td><td>（中継用）Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkangoqpackhyj ztytenkangoqpackhyj}</td><td>（中継用）転換後Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuruihnkutkbttrtkhyj ztysyuruihnkutkbttrtkhyj}</td><td>（中継用）種類変更特別取扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnkngsyuhnkutkbttrtkhyj ztytnkngsyuhnkutkbttrtkhyj}</td><td>（中継用）転換後種類変更特別取扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykibanhikitugikbn ztykibanhikitugikbn}</td><td>（中継用）基盤引継加算区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x6 ztyyobiv1x6}</td><td>（中継用）予備項目Ｖ１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumetucd ztysyoumetucd}</td><td>（中継用）消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym ztyjikaipjyuutouym}</td><td>（中継用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomarusyuuhukahyj ztykaigomarusyuuhukahyj}</td><td>（中継用）介護マル終付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x7 ztyyobiv1x7}</td><td>（中継用）予備項目Ｖ１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoritorikesihyj ztysyoritorikesihyj}</td><td>（中継用）処理取消表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtikousinkatakbn ztymrtikousinkatakbn}</td><td>（中継用）マル定更新型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenkbnv1 ztypmenkbnv1}</td><td>（中継用）Ｐ免区分Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakutkknsnp ztysyukeiyakutkknsnp}</td><td>（中継用）主契約月換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkansanp ztynenkansanp}</td><td>（中継用）年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai3bunyanenkansanp ztydai3bunyanenkansanp}</td><td>（中継用）第３分野年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynyuuintkykhukahyj ztynyuuintkykhukahyj}</td><td>（中継用）入院特約付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuuintkykhukahyj20ijyou ztynyuuintkykhukahyj20ijyou}</td><td>（中継用）２０日以上入院特約付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuuintkykhukahyj5ijyou ztynyuuintkykhukahyj5ijyou}</td><td>（中継用）５日以上入院特約付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyotkykhukahyj ztymarusyotkykhukahyj}</td><td>（中継用）マル初特約付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarujyuutkykhukahyj ztymarujyuutkykhukahyj}</td><td>（中継用）マル重特約付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakudaimaruitkykhukahyj ztykakudaimaruitkykhukahyj}</td><td>（中継用）拡大マル医系特約付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakunyuutkykhukahyj ztykakunyuutkykhukahyj}</td><td>（中継用）カク入特約付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruitkykhukahyj ztymaruitkykhukahyj}</td><td>（中継用）マル医特約付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdairiseikyuutkykarihyj ztystdairiseikyuutkykarihyj}</td><td>（中継用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykensuuyuuguukbn ztykensuuyuuguukbn}</td><td>（中継用）件数優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigosynyteikikbn ztykaigosynyteikikbn}</td><td>（中継用）（介護）収入定期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigosynyteikishrkskbn ztykaigosynyteikishrkskbn}</td><td>（中継用）（介護）収入定期支払回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygyousekibosyujisikakucd ztygyousekibosyujisikakucd}</td><td>（中継用）業績用募集時資格コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygyskboshtnsineiyksnkbn ztygyskboshtnsineiyksnkbn}</td><td>（中継用）業績用募集時発展新鋭躍進区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsynymrtihukahyj ztysiktsynymrtihukahyj}</td><td>（中継用）生活収入マル定付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsynyteikikbn ztysiktsynyteikikbn}</td><td>（中継用）生活収入定期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikatusyuunyuumrtis ztyseikatusyuunyuumrtis}</td><td>（中継用）生活収入マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtylivguardhukahyj ztylivguardhukahyj}</td><td>（中継用）ＬＩＶガード付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivguards ztylivguards}</td><td>（中継用）ＬＩＶガードＳ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrttekitkarihyj ztyknkuzusnzyrttekitkarihyj}</td><td>（中継用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybluekzjtkaisiymd ztybluekzjtkaisiymd}</td><td>（中継用）Ｂｌｕｅ継続状態開始年月日　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrtstkbn ztyknkuzusnzyrtstkbn}</td><td>（中継用）健康増進乗率用ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtkykarihyj ztykykdrtkykarihyj}</td><td>（中継用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicearihyj ztykzktourokuservicearihyj}</td><td>（中継用）家族登録サービス有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteituukakbn ztysiteituukakbn}</td><td>（中継用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_HoyuuJyunzouZougenFTy
 * @see     PKZT_HoyuuJyunzouZougenFTy
 * @see     QZT_HoyuuJyunzouZougenFTy
 * @see     GenQZT_HoyuuJyunzouZougenFTy
 */
@MappedSuperclass
@Table(name=GenZT_HoyuuJyunzouZougenFTy.TABLE_NAME)
@IdClass(value=PKZT_HoyuuJyunzouZougenFTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_HoyuuJyunzouZougenFTy extends AbstractExDBEntity<ZT_HoyuuJyunzouZougenFTy, PKZT_HoyuuJyunzouZougenFTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HoyuuJyunzouZougenFTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYTANTOUKOJINCD         = "ztytantoukojincd";
    public static final String ZTYTANTOUSYASETTEIYM     = "ztytantousyasetteiym";
    public static final String ZTYKEIJYOUSAKIKBN        = "ztykeijyousakikbn";
    public static final String ZTYKEIJYOUSAKISOSIKI     = "ztykeijyousakisosiki";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYDENYMD                = "ztydenymd";
    public static final String ZTYUTIWAKEKBN            = "ztyutiwakekbn";
    public static final String ZTYTANTOUKEIYAKUKBN      = "ztytantoukeiyakukbn";
    public static final String ZTYKYDATKIKBN            = "ztykydatkikbn";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYSAISINBSYYM           = "ztysaisinbsyym";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYMARUTEISYURUIKIGOU    = "ztymaruteisyuruikigou";
    public static final String ZTYYOBIN3                = "ztyyobin3";
    public static final String ZTYYOBIV1                = "ztyyobiv1";
    public static final String ZTYYOBIV1X2              = "ztyyobiv1x2";
    public static final String ZTYKYKNIYUTKSYTIOUKBN    = "ztykykniyutksytioukbn";
    public static final String ZTYYOBIV1X3              = "ztyyobiv1x3";
    public static final String ZTYTEISYUUHYJ            = "ztyteisyuuhyj";
    public static final String ZTYITIJIBRYOUROUHYJ      = "ztyitijibryourouhyj";
    public static final String ZTYMRTIHUKAHYJ           = "ztymrtihukahyj";
    public static final String ZTYSEIZONMRTIHUKAHYJ     = "ztyseizonmrtihukahyj";
    public static final String ZTYTEIGENMRTIHUKAHYJ     = "ztyteigenmrtihukahyj";
    public static final String ZTYSYNYMRTIHUKAHYJ       = "ztysynymrtihukahyj";
    public static final String ZTYLIVINGNEEDSTKYKARIHYJ = "ztylivingneedstkykarihyj";
    public static final String ZTYREGUARDMRTIHUKAHYJ    = "ztyreguardmrtihukahyj";
    public static final String ZTYREGUARDMRSYUHUKAHYJ   = "ztyreguardmrsyuhukahyj";
    public static final String ZTYVGUARDMRTIHUKAHYJ     = "ztyvguardmrtihukahyj";
    public static final String ZTYKAIGONKTKYKHUKAHYJ    = "ztykaigonktkykhukahyj";
    public static final String ZTYGOUKEISISTTKYKTKKNSNP = "ztygoukeisisttkyktkknsnp";
    public static final String ZTYHSYS                  = "ztyhsys";
    public static final String ZTYKENSUUN3              = "ztykensuun3";
    public static final String ZTYHENKOUGOHOSYOUS       = "ztyhenkougohosyous";
    public static final String ZTYHTNS                  = "ztyhtns";
    public static final String ZTYHARAIKOMIP            = "ztyharaikomip";
    public static final String ZTYKAIYAKUSIHARAIKNGK    = "ztykaiyakusiharaikngk";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYANNISKCD              = "ztyanniskcd";
    public static final String ZTYTENKANKAISUU          = "ztytenkankaisuu";
    public static final String ZTYSIKKOUNYKNKAISUU      = "ztysikkounyknkaisuu";
    public static final String ZTYYOBIV2                = "ztyyobiv2";
    public static final String ZTYHHKNNEN2KETA          = "ztyhhknnen2keta";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYKJKYKNM               = "ztykjkyknm";
    public static final String ZTYTSINKIHONTIKUCD       = "ztytsinkihontikucd";
    public static final String ZTYHJNKYKHYJ             = "ztyhjnkykhyj";
    public static final String ZTYHJNCD                 = "ztyhjncd";
    public static final String ZTYHJNJIGYOSYOCD         = "ztyhjnjigyosyocd";
    public static final String ZTYSYORISOSIKICD         = "ztysyorisosikicd";
    public static final String ZTYTIKUSYOKANSISYAKIJYHYJ = "ztytikusyokansisyakijyhyj";
    public static final String ZTYKEIZOKUTYUUIHYOUJI    = "ztykeizokutyuuihyouji";
    public static final String ZTYTYOHKKEIYAKUTYUUIKBN  = "ztytyohkkeiyakutyuuikbn";
    public static final String ZTYYOBIV1X4              = "ztyyobiv1x4";
    public static final String ZTYDANTAISYOZOKUCD       = "ztydantaisyozokucd";
    public static final String ZTYSUPERKNKUSEIKATUPACKHYJ = "ztysuperknkuseikatupackhyj";
    public static final String ZTYJIKOKYKHYJ            = "ztyjikokykhyj";
    public static final String ZTYKIKEIYAKUTYUUIHYOUJI  = "ztykikeiyakutyuuihyouji";
    public static final String ZTYSYUUSEIS              = "ztysyuuseis";
    public static final String ZTYCLUBSUMISEIKAIINKYKKBN = "ztyclubsumiseikaiinkykkbn";
    public static final String ZTYGATKIHMKKNRKMAEKYKHYJ = "ztygatkihmkknrkmaekykhyj";
    public static final String ZTYGATKISETTEIKOUHOKYKHYJ = "ztygatkisetteikouhokykhyj";
    public static final String ZTYBOSYUU25KEIKAHYJ      = "ztybosyuu25keikahyj";
    public static final String ZTYTOKUTEIDAISYOKUDANHYJ = "ztytokuteidaisyokudanhyj";
    public static final String ZTYHOYUUIKANTSGKYKHYJ    = "ztyhoyuuikantsgkykhyj";
    public static final String ZTYTOKUBETURULETIKUHYJ   = "ztytokubeturuletikuhyj";
    public static final String ZTYFIELDTANTOUSYAARIHYJ  = "ztyfieldtantousyaarihyj";
    public static final String ZTYYOBIV1X5              = "ztyyobiv1x5";
    public static final String ZTYCATKIHMKKNRKMAEKYKHYJ = "ztycatkihmkknrkmaekykhyj";
    public static final String ZTYCATKISETTEIKOUHOKYKHYJ = "ztycatkisetteikouhokykhyj";
    public static final String ZTYSEPPANKEIJYOUKBN      = "ztyseppankeijyoukbn";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYFOLLOWTANTOUSYAKBN    = "ztyfollowtantousyakbn";
    public static final String ZTYYOBIV7                = "ztyyobiv7";
    public static final String ZTYHOSYOUMINAOSIKAISUUV2 = "ztyhosyouminaosikaisuuv2";
    public static final String ZTYBNKTTNKNKBN           = "ztybnkttnknkbn";
    public static final String ZTYTENKANGOSYONO         = "ztytenkangosyono";
    public static final String ZTYQPACKHYJ              = "ztyqpackhyj";
    public static final String ZTYTENKANGOQPACKHYJ      = "ztytenkangoqpackhyj";
    public static final String ZTYSYURUIHNKUTKBTTRTKHYJ = "ztysyuruihnkutkbttrtkhyj";
    public static final String ZTYTNKNGSYUHNKUTKBTTRTKHYJ = "ztytnkngsyuhnkutkbttrtkhyj";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYKIBANHIKITUGIKBN      = "ztykibanhikitugikbn";
    public static final String ZTYYOBIV1X6              = "ztyyobiv1x6";
    public static final String ZTYSYOUMETUCD            = "ztysyoumetucd";
    public static final String ZTYJIKAIPJYUUTOUYM       = "ztyjikaipjyuutouym";
    public static final String ZTYKAIGOMARUSYUUHUKAHYJ  = "ztykaigomarusyuuhukahyj";
    public static final String ZTYYOBIV1X7              = "ztyyobiv1x7";
    public static final String ZTYSYORITORIKESIHYJ      = "ztysyoritorikesihyj";
    public static final String ZTYMRTIKOUSINKATAKBN     = "ztymrtikousinkatakbn";
    public static final String ZTYPMENKBNV1             = "ztypmenkbnv1";
    public static final String ZTYSYUKEIYAKUTKKNSNP     = "ztysyukeiyakutkknsnp";
    public static final String ZTYNENKANSANP            = "ztynenkansanp";
    public static final String ZTYDAI3BUNYANENKANSANP   = "ztydai3bunyanenkansanp";
    public static final String ZTYNYUUINTKYKHUKAHYJ     = "ztynyuuintkykhukahyj";
    public static final String ZTYNYUUINTKYKHUKAHYJ20IJYOU = "ztynyuuintkykhukahyj20ijyou";
    public static final String ZTYNYUUINTKYKHUKAHYJ5IJYOU = "ztynyuuintkykhukahyj5ijyou";
    public static final String ZTYMARUSYOTKYKHUKAHYJ    = "ztymarusyotkykhukahyj";
    public static final String ZTYMARUJYUUTKYKHUKAHYJ   = "ztymarujyuutkykhukahyj";
    public static final String ZTYKAKUDAIMARUITKYKHUKAHYJ = "ztykakudaimaruitkykhukahyj";
    public static final String ZTYKAKUNYUUTKYKHUKAHYJ   = "ztykakunyuutkykhukahyj";
    public static final String ZTYMARUITKYKHUKAHYJ      = "ztymaruitkykhukahyj";
    public static final String ZTYSTDAIRISEIKYUUTKYKARIHYJ = "ztystdairiseikyuutkykarihyj";
    public static final String ZTYKENSUUYUUGUUKBN       = "ztykensuuyuuguukbn";
    public static final String ZTYKAIGOSYNYTEIKIKBN     = "ztykaigosynyteikikbn";
    public static final String ZTYKAIGOSYNYTEIKISHRKSKBN = "ztykaigosynyteikishrkskbn";
    public static final String ZTYGYOUSEKIBOSYUJISIKAKUCD = "ztygyousekibosyujisikakucd";
    public static final String ZTYGYSKBOSHTNSINEIYKSNKBN = "ztygyskboshtnsineiyksnkbn";
    public static final String ZTYSIKTSYNYMRTIHUKAHYJ   = "ztysiktsynymrtihukahyj";
    public static final String ZTYSIKTSYNYTEIKIKBN      = "ztysiktsynyteikikbn";
    public static final String ZTYSEIKATUSYUUNYUUMRTIS  = "ztyseikatusyuunyuumrtis";
    public static final String ZTYLIVGUARDHUKAHYJ       = "ztylivguardhukahyj";
    public static final String ZTYLIVGUARDS             = "ztylivguards";
    public static final String ZTYKNKUZUSNZYRTTEKITKARIHYJ = "ztyknkuzusnzyrttekitkarihyj";
    public static final String ZTYBLUEKZJTKAISIYMD      = "ztybluekzjtkaisiymd";
    public static final String ZTYKNKUZUSNZYRTSTKBN     = "ztyknkuzusnzyrtstkbn";
    public static final String ZTYKYKDRTKYKARIHYJ       = "ztykykdrtkykarihyj";
    public static final String ZTYKZKTOUROKUSERVICEARIHYJ = "ztykzktourokuservicearihyj";
    public static final String ZTYSITEITUUKAKBN         = "ztysiteituukakbn";

    private final PKZT_HoyuuJyunzouZougenFTy primaryKey;

    public GenZT_HoyuuJyunzouZougenFTy() {
        primaryKey = new PKZT_HoyuuJyunzouZougenFTy();
    }

    public GenZT_HoyuuJyunzouZougenFTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_HoyuuJyunzouZougenFTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_HoyuuJyunzouZougenFTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HoyuuJyunzouZougenFTy> getMetaClass() {
        return QZT_HoyuuJyunzouZougenFTy.class;
    }

    @Id
    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztytantoukojincd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTANTOUKOJINCD)
    public String getZtytantoukojincd() {
        return ztytantoukojincd;
    }

    public void setZtytantoukojincd(String pZtytantoukojincd) {
        ztytantoukojincd = pZtytantoukojincd;
    }

    private String ztytantousyasetteiym;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTANTOUSYASETTEIYM)
    public String getZtytantousyasetteiym() {
        return ztytantousyasetteiym;
    }

    public void setZtytantousyasetteiym(String pZtytantousyasetteiym) {
        ztytantousyasetteiym = pZtytantousyasetteiym;
    }

    private String ztykeijyousakikbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKEIJYOUSAKIKBN)
    public String getZtykeijyousakikbn() {
        return ztykeijyousakikbn;
    }

    public void setZtykeijyousakikbn(String pZtykeijyousakikbn) {
        ztykeijyousakikbn = pZtykeijyousakikbn;
    }

    private String ztykeijyousakisosiki;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKEIJYOUSAKISOSIKI)
    public String getZtykeijyousakisosiki() {
        return ztykeijyousakisosiki;
    }

    public void setZtykeijyousakisosiki(String pZtykeijyousakisosiki) {
        ztykeijyousakisosiki = pZtykeijyousakisosiki;
    }

    private String ztykeijyouym;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    private String ztydenymd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYDENYMD)
    public String getZtydenymd() {
        return ztydenymd;
    }

    public void setZtydenymd(String pZtydenymd) {
        ztydenymd = pZtydenymd;
    }

    private String ztyutiwakekbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYUTIWAKEKBN)
    public String getZtyutiwakekbn() {
        return ztyutiwakekbn;
    }

    public void setZtyutiwakekbn(String pZtyutiwakekbn) {
        ztyutiwakekbn = pZtyutiwakekbn;
    }

    private String ztytantoukeiyakukbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTANTOUKEIYAKUKBN)
    public String getZtytantoukeiyakukbn() {
        return ztytantoukeiyakukbn;
    }

    public void setZtytantoukeiyakukbn(String pZtytantoukeiyakukbn) {
        ztytantoukeiyakukbn = pZtytantoukeiyakukbn;
    }

    private String ztykydatkikbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKYDATKIKBN)
    public String getZtykydatkikbn() {
        return ztykydatkikbn;
    }

    public void setZtykydatkikbn(String pZtykydatkikbn) {
        ztykydatkikbn = pZtykydatkikbn;
    }

    private String ztysyono;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztybsyym;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztykykymd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztysaisinbsyym;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSAISINBSYYM)
    public String getZtysaisinbsyym() {
        return ztysaisinbsyym;
    }

    public void setZtysaisinbsyym(String pZtysaisinbsyym) {
        ztysaisinbsyym = pZtysaisinbsyym;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztymaruteisyuruikigou;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYMARUTEISYURUIKIGOU)
    public String getZtymaruteisyuruikigou() {
        return ztymaruteisyuruikigou;
    }

    public void setZtymaruteisyuruikigou(String pZtymaruteisyuruikigou) {
        ztymaruteisyuruikigou = pZtymaruteisyuruikigou;
    }

    private Integer ztyyobin3;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIN3)
    public Integer getZtyyobin3() {
        return ztyyobin3;
    }

    public void setZtyyobin3(Integer pZtyyobin3) {
        ztyyobin3 = pZtyyobin3;
    }

    private String ztyyobiv1;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIV1)
    public String getZtyyobiv1() {
        return ztyyobiv1;
    }

    public void setZtyyobiv1(String pZtyyobiv1) {
        ztyyobiv1 = pZtyyobiv1;
    }

    private String ztyyobiv1x2;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIV1X2)
    public String getZtyyobiv1x2() {
        return ztyyobiv1x2;
    }

    public void setZtyyobiv1x2(String pZtyyobiv1x2) {
        ztyyobiv1x2 = pZtyyobiv1x2;
    }

    private String ztykykniyutksytioukbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKYKNIYUTKSYTIOUKBN)
    public String getZtykykniyutksytioukbn() {
        return ztykykniyutksytioukbn;
    }

    public void setZtykykniyutksytioukbn(String pZtykykniyutksytioukbn) {
        ztykykniyutksytioukbn = pZtykykniyutksytioukbn;
    }

    private String ztyyobiv1x3;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIV1X3)
    public String getZtyyobiv1x3() {
        return ztyyobiv1x3;
    }

    public void setZtyyobiv1x3(String pZtyyobiv1x3) {
        ztyyobiv1x3 = pZtyyobiv1x3;
    }

    private String ztyteisyuuhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTEISYUUHYJ)
    public String getZtyteisyuuhyj() {
        return ztyteisyuuhyj;
    }

    public void setZtyteisyuuhyj(String pZtyteisyuuhyj) {
        ztyteisyuuhyj = pZtyteisyuuhyj;
    }

    private String ztyitijibryourouhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYITIJIBRYOUROUHYJ)
    public String getZtyitijibryourouhyj() {
        return ztyitijibryourouhyj;
    }

    public void setZtyitijibryourouhyj(String pZtyitijibryourouhyj) {
        ztyitijibryourouhyj = pZtyitijibryourouhyj;
    }

    private String ztymrtihukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYMRTIHUKAHYJ)
    public String getZtymrtihukahyj() {
        return ztymrtihukahyj;
    }

    public void setZtymrtihukahyj(String pZtymrtihukahyj) {
        ztymrtihukahyj = pZtymrtihukahyj;
    }

    private String ztyseizonmrtihukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSEIZONMRTIHUKAHYJ)
    public String getZtyseizonmrtihukahyj() {
        return ztyseizonmrtihukahyj;
    }

    public void setZtyseizonmrtihukahyj(String pZtyseizonmrtihukahyj) {
        ztyseizonmrtihukahyj = pZtyseizonmrtihukahyj;
    }

    private String ztyteigenmrtihukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTEIGENMRTIHUKAHYJ)
    public String getZtyteigenmrtihukahyj() {
        return ztyteigenmrtihukahyj;
    }

    public void setZtyteigenmrtihukahyj(String pZtyteigenmrtihukahyj) {
        ztyteigenmrtihukahyj = pZtyteigenmrtihukahyj;
    }

    private String ztysynymrtihukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSYNYMRTIHUKAHYJ)
    public String getZtysynymrtihukahyj() {
        return ztysynymrtihukahyj;
    }

    public void setZtysynymrtihukahyj(String pZtysynymrtihukahyj) {
        ztysynymrtihukahyj = pZtysynymrtihukahyj;
    }

    private String ztylivingneedstkykarihyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYLIVINGNEEDSTKYKARIHYJ)
    public String getZtylivingneedstkykarihyj() {
        return ztylivingneedstkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtylivingneedstkykarihyj(String pZtylivingneedstkykarihyj) {
        ztylivingneedstkykarihyj = pZtylivingneedstkykarihyj;
    }

    private String ztyreguardmrtihukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYREGUARDMRTIHUKAHYJ)
    public String getZtyreguardmrtihukahyj() {
        return ztyreguardmrtihukahyj;
    }

    public void setZtyreguardmrtihukahyj(String pZtyreguardmrtihukahyj) {
        ztyreguardmrtihukahyj = pZtyreguardmrtihukahyj;
    }

    private String ztyreguardmrsyuhukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYREGUARDMRSYUHUKAHYJ)
    public String getZtyreguardmrsyuhukahyj() {
        return ztyreguardmrsyuhukahyj;
    }

    public void setZtyreguardmrsyuhukahyj(String pZtyreguardmrsyuhukahyj) {
        ztyreguardmrsyuhukahyj = pZtyreguardmrsyuhukahyj;
    }

    private String ztyvguardmrtihukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYVGUARDMRTIHUKAHYJ)
    public String getZtyvguardmrtihukahyj() {
        return ztyvguardmrtihukahyj;
    }

    public void setZtyvguardmrtihukahyj(String pZtyvguardmrtihukahyj) {
        ztyvguardmrtihukahyj = pZtyvguardmrtihukahyj;
    }

    private String ztykaigonktkykhukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKAIGONKTKYKHUKAHYJ)
    public String getZtykaigonktkykhukahyj() {
        return ztykaigonktkykhukahyj;
    }

    public void setZtykaigonktkykhukahyj(String pZtykaigonktkykhukahyj) {
        ztykaigonktkykhukahyj = pZtykaigonktkykhukahyj;
    }

    private Long ztygoukeisisttkyktkknsnp;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYGOUKEISISTTKYKTKKNSNP)
    public Long getZtygoukeisisttkyktkknsnp() {
        return ztygoukeisisttkyktkknsnp;
    }

    public void setZtygoukeisisttkyktkknsnp(Long pZtygoukeisisttkyktkknsnp) {
        ztygoukeisisttkyktkknsnp = pZtygoukeisisttkyktkknsnp;
    }

    private Long ztyhsys;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHSYS)
    public Long getZtyhsys() {
        return ztyhsys;
    }

    public void setZtyhsys(Long pZtyhsys) {
        ztyhsys = pZtyhsys;
    }

    private BizNumber ztykensuun3;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKENSUUN3)
    public BizNumber getZtykensuun3() {
        return ztykensuun3;
    }

    public void setZtykensuun3(BizNumber pZtykensuun3) {
        ztykensuun3 = pZtykensuun3;
    }

    private Long ztyhenkougohosyous;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHENKOUGOHOSYOUS)
    public Long getZtyhenkougohosyous() {
        return ztyhenkougohosyous;
    }

    public void setZtyhenkougohosyous(Long pZtyhenkougohosyous) {
        ztyhenkougohosyous = pZtyhenkougohosyous;
    }

    private Long ztyhtns;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHTNS)
    public Long getZtyhtns() {
        return ztyhtns;
    }

    public void setZtyhtns(Long pZtyhtns) {
        ztyhtns = pZtyhtns;
    }

    private Long ztyharaikomip;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHARAIKOMIP)
    public Long getZtyharaikomip() {
        return ztyharaikomip;
    }

    public void setZtyharaikomip(Long pZtyharaikomip) {
        ztyharaikomip = pZtyharaikomip;
    }

    private Long ztykaiyakusiharaikngk;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKAIYAKUSIHARAIKNGK)
    public Long getZtykaiyakusiharaikngk() {
        return ztykaiyakusiharaikngk;
    }

    public void setZtykaiyakusiharaikngk(Long pZtykaiyakusiharaikngk) {
        ztykaiyakusiharaikngk = pZtykaiyakusiharaikngk;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyanniskcd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private String ztytenkankaisuu;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTENKANKAISUU)
    public String getZtytenkankaisuu() {
        return ztytenkankaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkankaisuu(String pZtytenkankaisuu) {
        ztytenkankaisuu = pZtytenkankaisuu;
    }

    private String ztysikkounyknkaisuu;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSIKKOUNYKNKAISUU)
    public String getZtysikkounyknkaisuu() {
        return ztysikkounyknkaisuu;
    }

    public void setZtysikkounyknkaisuu(String pZtysikkounyknkaisuu) {
        ztysikkounyknkaisuu = pZtysikkounyknkaisuu;
    }

    private String ztyyobiv2;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIV2)
    public String getZtyyobiv2() {
        return ztyyobiv2;
    }

    public void setZtyyobiv2(String pZtyyobiv2) {
        ztyyobiv2 = pZtyyobiv2;
    }

    private String ztyhhknnen2keta;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHHKNNEN2KETA)
    public String getZtyhhknnen2keta() {
        return ztyhhknnen2keta;
    }

    public void setZtyhhknnen2keta(String pZtyhhknnen2keta) {
        ztyhhknnen2keta = pZtyhhknnen2keta;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztykjkyknm;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKJKYKNM)
    public String getZtykjkyknm() {
        return ztykjkyknm;
    }

    public void setZtykjkyknm(String pZtykjkyknm) {
        ztykjkyknm = pZtykjkyknm;
    }

    private String ztytsinkihontikucd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTSINKIHONTIKUCD)
    public String getZtytsinkihontikucd() {
        return ztytsinkihontikucd;
    }

    public void setZtytsinkihontikucd(String pZtytsinkihontikucd) {
        ztytsinkihontikucd = pZtytsinkihontikucd;
    }

    private String ztyhjnkykhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHJNKYKHYJ)
    public String getZtyhjnkykhyj() {
        return ztyhjnkykhyj;
    }

    public void setZtyhjnkykhyj(String pZtyhjnkykhyj) {
        ztyhjnkykhyj = pZtyhjnkykhyj;
    }

    private String ztyhjncd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHJNCD)
    public String getZtyhjncd() {
        return ztyhjncd;
    }

    public void setZtyhjncd(String pZtyhjncd) {
        ztyhjncd = pZtyhjncd;
    }

    private String ztyhjnjigyosyocd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHJNJIGYOSYOCD)
    public String getZtyhjnjigyosyocd() {
        return ztyhjnjigyosyocd;
    }

    public void setZtyhjnjigyosyocd(String pZtyhjnjigyosyocd) {
        ztyhjnjigyosyocd = pZtyhjnjigyosyocd;
    }

    private String ztysyorisosikicd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSYORISOSIKICD)
    public String getZtysyorisosikicd() {
        return ztysyorisosikicd;
    }

    public void setZtysyorisosikicd(String pZtysyorisosikicd) {
        ztysyorisosikicd = pZtysyorisosikicd;
    }

    private String ztytikusyokansisyakijyhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTIKUSYOKANSISYAKIJYHYJ)
    public String getZtytikusyokansisyakijyhyj() {
        return ztytikusyokansisyakijyhyj;
    }

    public void setZtytikusyokansisyakijyhyj(String pZtytikusyokansisyakijyhyj) {
        ztytikusyokansisyakijyhyj = pZtytikusyokansisyakijyhyj;
    }

    private String ztykeizokutyuuihyouji;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKEIZOKUTYUUIHYOUJI)
    public String getZtykeizokutyuuihyouji() {
        return ztykeizokutyuuihyouji;
    }

    public void setZtykeizokutyuuihyouji(String pZtykeizokutyuuihyouji) {
        ztykeizokutyuuihyouji = pZtykeizokutyuuihyouji;
    }

    private String ztytyohkkeiyakutyuuikbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTYOHKKEIYAKUTYUUIKBN)
    public String getZtytyohkkeiyakutyuuikbn() {
        return ztytyohkkeiyakutyuuikbn;
    }

    public void setZtytyohkkeiyakutyuuikbn(String pZtytyohkkeiyakutyuuikbn) {
        ztytyohkkeiyakutyuuikbn = pZtytyohkkeiyakutyuuikbn;
    }

    private String ztyyobiv1x4;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIV1X4)
    public String getZtyyobiv1x4() {
        return ztyyobiv1x4;
    }

    public void setZtyyobiv1x4(String pZtyyobiv1x4) {
        ztyyobiv1x4 = pZtyyobiv1x4;
    }

    private String ztydantaisyozokucd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYDANTAISYOZOKUCD)
    public String getZtydantaisyozokucd() {
        return ztydantaisyozokucd;
    }

    public void setZtydantaisyozokucd(String pZtydantaisyozokucd) {
        ztydantaisyozokucd = pZtydantaisyozokucd;
    }

    private String ztysuperknkuseikatupackhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSUPERKNKUSEIKATUPACKHYJ)
    public String getZtysuperknkuseikatupackhyj() {
        return ztysuperknkuseikatupackhyj;
    }

    public void setZtysuperknkuseikatupackhyj(String pZtysuperknkuseikatupackhyj) {
        ztysuperknkuseikatupackhyj = pZtysuperknkuseikatupackhyj;
    }

    private String ztyjikokykhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYJIKOKYKHYJ)
    public String getZtyjikokykhyj() {
        return ztyjikokykhyj;
    }

    public void setZtyjikokykhyj(String pZtyjikokykhyj) {
        ztyjikokykhyj = pZtyjikokykhyj;
    }

    private String ztykikeiyakutyuuihyouji;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKIKEIYAKUTYUUIHYOUJI)
    public String getZtykikeiyakutyuuihyouji() {
        return ztykikeiyakutyuuihyouji;
    }

    public void setZtykikeiyakutyuuihyouji(String pZtykikeiyakutyuuihyouji) {
        ztykikeiyakutyuuihyouji = pZtykikeiyakutyuuihyouji;
    }

    private Long ztysyuuseis;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSYUUSEIS)
    public Long getZtysyuuseis() {
        return ztysyuuseis;
    }

    public void setZtysyuuseis(Long pZtysyuuseis) {
        ztysyuuseis = pZtysyuuseis;
    }

    private String ztyclubsumiseikaiinkykkbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYCLUBSUMISEIKAIINKYKKBN)
    public String getZtyclubsumiseikaiinkykkbn() {
        return ztyclubsumiseikaiinkykkbn;
    }

    public void setZtyclubsumiseikaiinkykkbn(String pZtyclubsumiseikaiinkykkbn) {
        ztyclubsumiseikaiinkykkbn = pZtyclubsumiseikaiinkykkbn;
    }

    private String ztygatkihmkknrkmaekykhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYGATKIHMKKNRKMAEKYKHYJ)
    public String getZtygatkihmkknrkmaekykhyj() {
        return ztygatkihmkknrkmaekykhyj;
    }

    public void setZtygatkihmkknrkmaekykhyj(String pZtygatkihmkknrkmaekykhyj) {
        ztygatkihmkknrkmaekykhyj = pZtygatkihmkknrkmaekykhyj;
    }

    private String ztygatkisetteikouhokykhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYGATKISETTEIKOUHOKYKHYJ)
    public String getZtygatkisetteikouhokykhyj() {
        return ztygatkisetteikouhokykhyj;
    }

    public void setZtygatkisetteikouhokykhyj(String pZtygatkisetteikouhokykhyj) {
        ztygatkisetteikouhokykhyj = pZtygatkisetteikouhokykhyj;
    }

    private String ztybosyuu25keikahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYBOSYUU25KEIKAHYJ)
    public String getZtybosyuu25keikahyj() {
        return ztybosyuu25keikahyj;
    }

    public void setZtybosyuu25keikahyj(String pZtybosyuu25keikahyj) {
        ztybosyuu25keikahyj = pZtybosyuu25keikahyj;
    }

    private String ztytokuteidaisyokudanhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTOKUTEIDAISYOKUDANHYJ)
    public String getZtytokuteidaisyokudanhyj() {
        return ztytokuteidaisyokudanhyj;
    }

    public void setZtytokuteidaisyokudanhyj(String pZtytokuteidaisyokudanhyj) {
        ztytokuteidaisyokudanhyj = pZtytokuteidaisyokudanhyj;
    }

    private String ztyhoyuuikantsgkykhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHOYUUIKANTSGKYKHYJ)
    public String getZtyhoyuuikantsgkykhyj() {
        return ztyhoyuuikantsgkykhyj;
    }

    public void setZtyhoyuuikantsgkykhyj(String pZtyhoyuuikantsgkykhyj) {
        ztyhoyuuikantsgkykhyj = pZtyhoyuuikantsgkykhyj;
    }

    private String ztytokubeturuletikuhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTOKUBETURULETIKUHYJ)
    public String getZtytokubeturuletikuhyj() {
        return ztytokubeturuletikuhyj;
    }

    public void setZtytokubeturuletikuhyj(String pZtytokubeturuletikuhyj) {
        ztytokubeturuletikuhyj = pZtytokubeturuletikuhyj;
    }

    private String ztyfieldtantousyaarihyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYFIELDTANTOUSYAARIHYJ)
    public String getZtyfieldtantousyaarihyj() {
        return ztyfieldtantousyaarihyj;
    }

    public void setZtyfieldtantousyaarihyj(String pZtyfieldtantousyaarihyj) {
        ztyfieldtantousyaarihyj = pZtyfieldtantousyaarihyj;
    }

    private String ztyyobiv1x5;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIV1X5)
    public String getZtyyobiv1x5() {
        return ztyyobiv1x5;
    }

    public void setZtyyobiv1x5(String pZtyyobiv1x5) {
        ztyyobiv1x5 = pZtyyobiv1x5;
    }

    private String ztycatkihmkknrkmaekykhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYCATKIHMKKNRKMAEKYKHYJ)
    public String getZtycatkihmkknrkmaekykhyj() {
        return ztycatkihmkknrkmaekykhyj;
    }

    public void setZtycatkihmkknrkmaekykhyj(String pZtycatkihmkknrkmaekykhyj) {
        ztycatkihmkknrkmaekykhyj = pZtycatkihmkknrkmaekykhyj;
    }

    private String ztycatkisetteikouhokykhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYCATKISETTEIKOUHOKYKHYJ)
    public String getZtycatkisetteikouhokykhyj() {
        return ztycatkisetteikouhokykhyj;
    }

    public void setZtycatkisetteikouhokykhyj(String pZtycatkisetteikouhokykhyj) {
        ztycatkisetteikouhokykhyj = pZtycatkisetteikouhokykhyj;
    }

    private String ztyseppankeijyoukbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSEPPANKEIJYOUKBN)
    public String getZtyseppankeijyoukbn() {
        return ztyseppankeijyoukbn;
    }

    public void setZtyseppankeijyoukbn(String pZtyseppankeijyoukbn) {
        ztyseppankeijyoukbn = pZtyseppankeijyoukbn;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztyfollowtantousyakbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYFOLLOWTANTOUSYAKBN)
    public String getZtyfollowtantousyakbn() {
        return ztyfollowtantousyakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyfollowtantousyakbn(String pZtyfollowtantousyakbn) {
        ztyfollowtantousyakbn = pZtyfollowtantousyakbn;
    }

    private String ztyyobiv7;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIV7)
    public String getZtyyobiv7() {
        return ztyyobiv7;
    }

    public void setZtyyobiv7(String pZtyyobiv7) {
        ztyyobiv7 = pZtyyobiv7;
    }

    private String ztyhosyouminaosikaisuuv2;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYHOSYOUMINAOSIKAISUUV2)
    public String getZtyhosyouminaosikaisuuv2() {
        return ztyhosyouminaosikaisuuv2;
    }

    public void setZtyhosyouminaosikaisuuv2(String pZtyhosyouminaosikaisuuv2) {
        ztyhosyouminaosikaisuuv2 = pZtyhosyouminaosikaisuuv2;
    }

    private String ztybnkttnknkbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYBNKTTNKNKBN)
    public String getZtybnkttnknkbn() {
        return ztybnkttnknkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtybnkttnknkbn(String pZtybnkttnknkbn) {
        ztybnkttnknkbn = pZtybnkttnknkbn;
    }

    private String ztytenkangosyono;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTENKANGOSYONO)
    public String getZtytenkangosyono() {
        return ztytenkangosyono;
    }

    public void setZtytenkangosyono(String pZtytenkangosyono) {
        ztytenkangosyono = pZtytenkangosyono;
    }

    private String ztyqpackhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYQPACKHYJ)
    public String getZtyqpackhyj() {
        return ztyqpackhyj;
    }

    public void setZtyqpackhyj(String pZtyqpackhyj) {
        ztyqpackhyj = pZtyqpackhyj;
    }

    private String ztytenkangoqpackhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTENKANGOQPACKHYJ)
    public String getZtytenkangoqpackhyj() {
        return ztytenkangoqpackhyj;
    }

    public void setZtytenkangoqpackhyj(String pZtytenkangoqpackhyj) {
        ztytenkangoqpackhyj = pZtytenkangoqpackhyj;
    }

    private String ztysyuruihnkutkbttrtkhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSYURUIHNKUTKBTTRTKHYJ)
    public String getZtysyuruihnkutkbttrtkhyj() {
        return ztysyuruihnkutkbttrtkhyj;
    }

    public void setZtysyuruihnkutkbttrtkhyj(String pZtysyuruihnkutkbttrtkhyj) {
        ztysyuruihnkutkbttrtkhyj = pZtysyuruihnkutkbttrtkhyj;
    }

    private String ztytnkngsyuhnkutkbttrtkhyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYTNKNGSYUHNKUTKBTTRTKHYJ)
    public String getZtytnkngsyuhnkutkbttrtkhyj() {
        return ztytnkngsyuhnkutkbttrtkhyj;
    }

    public void setZtytnkngsyuhnkutkbttrtkhyj(String pZtytnkngsyuhnkutkbttrtkhyj) {
        ztytnkngsyuhnkutkbttrtkhyj = pZtytnkngsyuhnkutkbttrtkhyj;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private String ztykibanhikitugikbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKIBANHIKITUGIKBN)
    public String getZtykibanhikitugikbn() {
        return ztykibanhikitugikbn;
    }

    public void setZtykibanhikitugikbn(String pZtykibanhikitugikbn) {
        ztykibanhikitugikbn = pZtykibanhikitugikbn;
    }

    private String ztyyobiv1x6;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIV1X6)
    public String getZtyyobiv1x6() {
        return ztyyobiv1x6;
    }

    public void setZtyyobiv1x6(String pZtyyobiv1x6) {
        ztyyobiv1x6 = pZtyyobiv1x6;
    }

    private String ztysyoumetucd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSYOUMETUCD)
    public String getZtysyoumetucd() {
        return ztysyoumetucd;
    }

    public void setZtysyoumetucd(String pZtysyoumetucd) {
        ztysyoumetucd = pZtysyoumetucd;
    }

    private String ztyjikaipjyuutouym;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYJIKAIPJYUUTOUYM)
    public String getZtyjikaipjyuutouym() {
        return ztyjikaipjyuutouym;
    }

    public void setZtyjikaipjyuutouym(String pZtyjikaipjyuutouym) {
        ztyjikaipjyuutouym = pZtyjikaipjyuutouym;
    }

    private String ztykaigomarusyuuhukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKAIGOMARUSYUUHUKAHYJ)
    public String getZtykaigomarusyuuhukahyj() {
        return ztykaigomarusyuuhukahyj;
    }

    public void setZtykaigomarusyuuhukahyj(String pZtykaigomarusyuuhukahyj) {
        ztykaigomarusyuuhukahyj = pZtykaigomarusyuuhukahyj;
    }

    private String ztyyobiv1x7;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYYOBIV1X7)
    public String getZtyyobiv1x7() {
        return ztyyobiv1x7;
    }

    public void setZtyyobiv1x7(String pZtyyobiv1x7) {
        ztyyobiv1x7 = pZtyyobiv1x7;
    }

    private String ztysyoritorikesihyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSYORITORIKESIHYJ)
    public String getZtysyoritorikesihyj() {
        return ztysyoritorikesihyj;
    }

    public void setZtysyoritorikesihyj(String pZtysyoritorikesihyj) {
        ztysyoritorikesihyj = pZtysyoritorikesihyj;
    }

    private String ztymrtikousinkatakbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYMRTIKOUSINKATAKBN)
    public String getZtymrtikousinkatakbn() {
        return ztymrtikousinkatakbn;
    }

    public void setZtymrtikousinkatakbn(String pZtymrtikousinkatakbn) {
        ztymrtikousinkatakbn = pZtymrtikousinkatakbn;
    }

    private String ztypmenkbnv1;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYPMENKBNV1)
    public String getZtypmenkbnv1() {
        return ztypmenkbnv1;
    }

    public void setZtypmenkbnv1(String pZtypmenkbnv1) {
        ztypmenkbnv1 = pZtypmenkbnv1;
    }

    private Long ztysyukeiyakutkknsnp;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSYUKEIYAKUTKKNSNP)
    public Long getZtysyukeiyakutkknsnp() {
        return ztysyukeiyakutkknsnp;
    }

    public void setZtysyukeiyakutkknsnp(Long pZtysyukeiyakutkknsnp) {
        ztysyukeiyakutkknsnp = pZtysyukeiyakutkknsnp;
    }

    private Long ztynenkansanp;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYNENKANSANP)
    public Long getZtynenkansanp() {
        return ztynenkansanp;
    }

    public void setZtynenkansanp(Long pZtynenkansanp) {
        ztynenkansanp = pZtynenkansanp;
    }

    private Long ztydai3bunyanenkansanp;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYDAI3BUNYANENKANSANP)
    public Long getZtydai3bunyanenkansanp() {
        return ztydai3bunyanenkansanp;
    }

    public void setZtydai3bunyanenkansanp(Long pZtydai3bunyanenkansanp) {
        ztydai3bunyanenkansanp = pZtydai3bunyanenkansanp;
    }

    private String ztynyuuintkykhukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYNYUUINTKYKHUKAHYJ)
    public String getZtynyuuintkykhukahyj() {
        return ztynyuuintkykhukahyj;
    }

    public void setZtynyuuintkykhukahyj(String pZtynyuuintkykhukahyj) {
        ztynyuuintkykhukahyj = pZtynyuuintkykhukahyj;
    }

    private String ztynyuuintkykhukahyj20ijyou;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYNYUUINTKYKHUKAHYJ20IJYOU)
    public String getZtynyuuintkykhukahyj20ijyou() {
        return ztynyuuintkykhukahyj20ijyou;
    }

    public void setZtynyuuintkykhukahyj20ijyou(String pZtynyuuintkykhukahyj20ijyou) {
        ztynyuuintkykhukahyj20ijyou = pZtynyuuintkykhukahyj20ijyou;
    }

    private String ztynyuuintkykhukahyj5ijyou;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYNYUUINTKYKHUKAHYJ5IJYOU)
    public String getZtynyuuintkykhukahyj5ijyou() {
        return ztynyuuintkykhukahyj5ijyou;
    }

    public void setZtynyuuintkykhukahyj5ijyou(String pZtynyuuintkykhukahyj5ijyou) {
        ztynyuuintkykhukahyj5ijyou = pZtynyuuintkykhukahyj5ijyou;
    }

    private String ztymarusyotkykhukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYMARUSYOTKYKHUKAHYJ)
    public String getZtymarusyotkykhukahyj() {
        return ztymarusyotkykhukahyj;
    }

    public void setZtymarusyotkykhukahyj(String pZtymarusyotkykhukahyj) {
        ztymarusyotkykhukahyj = pZtymarusyotkykhukahyj;
    }

    private String ztymarujyuutkykhukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYMARUJYUUTKYKHUKAHYJ)
    public String getZtymarujyuutkykhukahyj() {
        return ztymarujyuutkykhukahyj;
    }

    public void setZtymarujyuutkykhukahyj(String pZtymarujyuutkykhukahyj) {
        ztymarujyuutkykhukahyj = pZtymarujyuutkykhukahyj;
    }

    private String ztykakudaimaruitkykhukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKAKUDAIMARUITKYKHUKAHYJ)
    public String getZtykakudaimaruitkykhukahyj() {
        return ztykakudaimaruitkykhukahyj;
    }

    public void setZtykakudaimaruitkykhukahyj(String pZtykakudaimaruitkykhukahyj) {
        ztykakudaimaruitkykhukahyj = pZtykakudaimaruitkykhukahyj;
    }

    private String ztykakunyuutkykhukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKAKUNYUUTKYKHUKAHYJ)
    public String getZtykakunyuutkykhukahyj() {
        return ztykakunyuutkykhukahyj;
    }

    public void setZtykakunyuutkykhukahyj(String pZtykakunyuutkykhukahyj) {
        ztykakunyuutkykhukahyj = pZtykakunyuutkykhukahyj;
    }

    private String ztymaruitkykhukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYMARUITKYKHUKAHYJ)
    public String getZtymaruitkykhukahyj() {
        return ztymaruitkykhukahyj;
    }

    public void setZtymaruitkykhukahyj(String pZtymaruitkykhukahyj) {
        ztymaruitkykhukahyj = pZtymaruitkykhukahyj;
    }

    private String ztystdairiseikyuutkykarihyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZtystdairiseikyuutkykarihyj() {
        return ztystdairiseikyuutkykarihyj;
    }

    public void setZtystdairiseikyuutkykarihyj(String pZtystdairiseikyuutkykarihyj) {
        ztystdairiseikyuutkykarihyj = pZtystdairiseikyuutkykarihyj;
    }

    private String ztykensuuyuuguukbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKENSUUYUUGUUKBN)
    public String getZtykensuuyuuguukbn() {
        return ztykensuuyuuguukbn;
    }

    public void setZtykensuuyuuguukbn(String pZtykensuuyuuguukbn) {
        ztykensuuyuuguukbn = pZtykensuuyuuguukbn;
    }

    private String ztykaigosynyteikikbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKAIGOSYNYTEIKIKBN)
    public String getZtykaigosynyteikikbn() {
        return ztykaigosynyteikikbn;
    }

    public void setZtykaigosynyteikikbn(String pZtykaigosynyteikikbn) {
        ztykaigosynyteikikbn = pZtykaigosynyteikikbn;
    }

    private String ztykaigosynyteikishrkskbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKAIGOSYNYTEIKISHRKSKBN)
    public String getZtykaigosynyteikishrkskbn() {
        return ztykaigosynyteikishrkskbn;
    }

    public void setZtykaigosynyteikishrkskbn(String pZtykaigosynyteikishrkskbn) {
        ztykaigosynyteikishrkskbn = pZtykaigosynyteikishrkskbn;
    }

    private String ztygyousekibosyujisikakucd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYGYOUSEKIBOSYUJISIKAKUCD)
    public String getZtygyousekibosyujisikakucd() {
        return ztygyousekibosyujisikakucd;
    }

    public void setZtygyousekibosyujisikakucd(String pZtygyousekibosyujisikakucd) {
        ztygyousekibosyujisikakucd = pZtygyousekibosyujisikakucd;
    }

    private String ztygyskboshtnsineiyksnkbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYGYSKBOSHTNSINEIYKSNKBN)
    public String getZtygyskboshtnsineiyksnkbn() {
        return ztygyskboshtnsineiyksnkbn;
    }

    public void setZtygyskboshtnsineiyksnkbn(String pZtygyskboshtnsineiyksnkbn) {
        ztygyskboshtnsineiyksnkbn = pZtygyskboshtnsineiyksnkbn;
    }

    private String ztysiktsynymrtihukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSIKTSYNYMRTIHUKAHYJ)
    public String getZtysiktsynymrtihukahyj() {
        return ztysiktsynymrtihukahyj;
    }

    public void setZtysiktsynymrtihukahyj(String pZtysiktsynymrtihukahyj) {
        ztysiktsynymrtihukahyj = pZtysiktsynymrtihukahyj;
    }

    private String ztysiktsynyteikikbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSIKTSYNYTEIKIKBN)
    public String getZtysiktsynyteikikbn() {
        return ztysiktsynyteikikbn;
    }

    public void setZtysiktsynyteikikbn(String pZtysiktsynyteikikbn) {
        ztysiktsynyteikikbn = pZtysiktsynyteikikbn;
    }

    private Long ztyseikatusyuunyuumrtis;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSEIKATUSYUUNYUUMRTIS)
    public Long getZtyseikatusyuunyuumrtis() {
        return ztyseikatusyuunyuumrtis;
    }

    public void setZtyseikatusyuunyuumrtis(Long pZtyseikatusyuunyuumrtis) {
        ztyseikatusyuunyuumrtis = pZtyseikatusyuunyuumrtis;
    }

    private String ztylivguardhukahyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYLIVGUARDHUKAHYJ)
    public String getZtylivguardhukahyj() {
        return ztylivguardhukahyj;
    }

    public void setZtylivguardhukahyj(String pZtylivguardhukahyj) {
        ztylivguardhukahyj = pZtylivguardhukahyj;
    }

    private Long ztylivguards;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYLIVGUARDS)
    public Long getZtylivguards() {
        return ztylivguards;
    }

    public void setZtylivguards(Long pZtylivguards) {
        ztylivguards = pZtylivguards;
    }

    private String ztyknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZtyknkuzusnzyrttekitkarihyj() {
        return ztyknkuzusnzyrttekitkarihyj;
    }

    public void setZtyknkuzusnzyrttekitkarihyj(String pZtyknkuzusnzyrttekitkarihyj) {
        ztyknkuzusnzyrttekitkarihyj = pZtyknkuzusnzyrttekitkarihyj;
    }

    private String ztybluekzjtkaisiymd;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYBLUEKZJTKAISIYMD)
    public String getZtybluekzjtkaisiymd() {
        return ztybluekzjtkaisiymd;
    }

    public void setZtybluekzjtkaisiymd(String pZtybluekzjtkaisiymd) {
        ztybluekzjtkaisiymd = pZtybluekzjtkaisiymd;
    }

    private String ztyknkuzusnzyrtstkbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKNKUZUSNZYRTSTKBN)
    public String getZtyknkuzusnzyrtstkbn() {
        return ztyknkuzusnzyrtstkbn;
    }

    public void setZtyknkuzusnzyrtstkbn(String pZtyknkuzusnzyrtstkbn) {
        ztyknkuzusnzyrtstkbn = pZtyknkuzusnzyrtstkbn;
    }

    private String ztykykdrtkykarihyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKYKDRTKYKARIHYJ)
    public String getZtykykdrtkykarihyj() {
        return ztykykdrtkykarihyj;
    }

    public void setZtykykdrtkykarihyj(String pZtykykdrtkykarihyj) {
        ztykykdrtkykarihyj = pZtykykdrtkykarihyj;
    }

    private String ztykzktourokuservicearihyj;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYKZKTOUROKUSERVICEARIHYJ)
    public String getZtykzktourokuservicearihyj() {
        return ztykzktourokuservicearihyj;
    }

    public void setZtykzktourokuservicearihyj(String pZtykzktourokuservicearihyj) {
        ztykzktourokuservicearihyj = pZtykzktourokuservicearihyj;
    }

    private String ztysiteituukakbn;

    @Column(name=GenZT_HoyuuJyunzouZougenFTy.ZTYSITEITUUKAKBN)
    public String getZtysiteituukakbn() {
        return ztysiteituukakbn;
    }

    public void setZtysiteituukakbn(String pZtysiteituukakbn) {
        ztysiteituukakbn = pZtysiteituukakbn;
    }
}