package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFRn;
import yuyu.def.db.mapping.GenZT_HoyuuJyunzouZougenFRn;
import yuyu.def.db.meta.GenQZT_HoyuuJyunzouZougenFRn;
import yuyu.def.db.meta.QZT_HoyuuJyunzouZougenFRn;

/**
 * 保有純増増減Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HoyuuJyunzouZougenFRn}</td><td colspan="3">保有純増増減Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrntantoukojincd</td><td>（連携用）担当者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantousyasetteiym</td><td>（連携用）担当者設定年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeijyousakikbn</td><td>（連携用）計上先区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeijyousakisosiki</td><td>（連携用）計上先組織</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeijyouym</td><td>（連携用）計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndenymd</td><td>（連携用）伝票日付</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnutiwakekbn</td><td>（連携用）内訳区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantoukeiyakukbn</td><td>（連携用）担当契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkydatkikbn</td><td>（連携用）共同扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaisinbsyym</td><td>（連携用）最新募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmaruteisyuruikigou</td><td>（連携用）マル定種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin3</td><td>（連携用）予備項目Ｎ３</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x2</td><td>（連携用）予備項目Ｖ１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykniyutksytioukbn</td><td>（連携用）契約内容特殊対応区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x3</td><td>（連携用）予備項目Ｖ１＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteisyuuhyj</td><td>（連携用）定終表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitijibryourouhyj</td><td>（連携用）一時払養老表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrtihukahyj</td><td>（連携用）マル定付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseizonmrtihukahyj</td><td>（連携用）生存マル定付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteigenmrtihukahyj</td><td>（連携用）逓減マル定付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsynymrtihukahyj</td><td>（連携用）収入マル定付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlivingneedstkykarihyj</td><td>（連携用）リビングニーズ特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnreguardmrtihukahyj</td><td>（連携用）リガードマル定付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnreguardmrsyuhukahyj</td><td>（連携用）リガードマル終付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnvguardmrtihukahyj</td><td>（連携用）Ｖガードマル定付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigonktkykhukahyj</td><td>（連携用）介護年金特約付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngoukeisisttkyktkknsnp</td><td>（連携用）合計災疾特約月換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhsys</td><td>（連携用）保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkensuun3</td><td>（連携用）件数Ｎ３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnhenkougohosyous</td><td>（連携用）変更後保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhtns</td><td>（連携用）被転換Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnharaikomip</td><td>（連携用）払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyakusiharaikngk</td><td>（連携用）解約支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnanniskcd</td><td>（連携用）案内先コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkankaisuu</td><td>（連携用）転換回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsikkounyknkaisuu</td><td>（連携用）失効入金回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv2</td><td>（連携用）予備項目Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2keta</td><td>（連携用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkyknm</td><td>（連携用）漢字契約者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsinkihontikucd</td><td>（連携用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjnkykhyj</td><td>（連携用）法人契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjncd</td><td>（連携用）法人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjnjigyosyocd</td><td>（連携用）法人事業所コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorisosikicd</td><td>（連携用）処理組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntikusyokansisyakijyhyj</td><td>（連携用）地区所管支社計上表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeizokutyuuihyouji</td><td>（連携用）継続注意表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyohkkeiyakutyuuikbn</td><td>（連携用）重複契約注意区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x4</td><td>（連携用）予備項目Ｖ１＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndantaisyozokucd</td><td>（連携用）団体所属コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuperknkuseikatupackhyj</td><td>（連携用）スーパー健康生活パック表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjikokykhyj</td><td>（連携用）自己契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkikeiyakutyuuihyouji</td><td>（連携用）既契約注意表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuuseis</td><td>（連携用）修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnclubsumiseikaiinkykkbn</td><td>（連携用）クラブスミセイ会員契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngatkihmkknrkmaekykhyj</td><td>（連携用）Ｇ扱者訪問結果入力前契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngatkisetteikouhokykhyj</td><td>（連携用）Ｇ扱者設定候補契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuu25keikahyj</td><td>（連携用）募集２５カ月経過表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuteidaisyokudanhyj</td><td>（連携用）特定大職団表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhoyuuikantsgkykhyj</td><td>（連携用）保有移管対象外契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokubeturuletikuhyj</td><td>（連携用）特別ルール地区表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfieldtantousyaarihyj</td><td>（連携用）フィールド担当者有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x5</td><td>（連携用）予備項目Ｖ１＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncatkihmkknrkmaekykhyj</td><td>（連携用）Ｃ扱者訪問結果入力前契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncatkisetteikouhokykhyj</td><td>（連携用）Ｃ扱者設定候補契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseppankeijyoukbn</td><td>（連携用）折半計上区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv6</td><td>（連携用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfollowtantousyakbn</td><td>（連携用）フォロー担当者区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv7</td><td>（連携用）予備項目Ｖ７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouminaosikaisuuv2</td><td>（連携用）保障見直回数Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnkttnknkbn</td><td>（連携用）分割転換区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkangosyono</td><td>（連携用）転換後証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnqpackhyj</td><td>（連携用）Ｑパック表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkangoqpackhyj</td><td>（連携用）転換後Ｑパック表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuruihnkutkbttrtkhyj</td><td>（連携用）種類変更特別取扱表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntnkngsyuhnkutkbttrtkhyj</td><td>（連携用）転換後種類変更特別取扱表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkibanhikitugikbn</td><td>（連携用）基盤引継加算区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x6</td><td>（連携用）予備項目Ｖ１＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoumetucd</td><td>（連携用）消滅コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjikaipjyuutouym</td><td>（連携用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigomarusyuuhukahyj</td><td>（連携用）介護マル終付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x7</td><td>（連携用）予備項目Ｖ１＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoritorikesihyj</td><td>（連携用）処理取消表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrtikousinkatakbn</td><td>（連携用）マル定更新型区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpmenkbnv1</td><td>（連携用）Ｐ免区分Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukeiyakutkknsnp</td><td>（連携用）主契約月換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnenkansanp</td><td>（連携用）年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndai3bunyanenkansanp</td><td>（連携用）第３分野年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnyuuintkykhukahyj</td><td>（連携用）入院特約付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuuintkykhukahyj20ijyou</td><td>（連携用）２０日以上入院特約付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuuintkykhukahyj5ijyou</td><td>（連携用）５日以上入院特約付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmarusyotkykhukahyj</td><td>（連携用）マル初特約付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmarujyuutkykhukahyj</td><td>（連携用）マル重特約付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkakudaimaruitkykhukahyj</td><td>（連携用）拡大マル医系特約付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkakunyuutkykhukahyj</td><td>（連携用）カク入特約付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmaruitkykhukahyj</td><td>（連携用）マル医特約付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdairiseikyuutkykarihyj</td><td>（連携用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkensuuyuuguukbn</td><td>（連携用）件数優遇区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigosynyteikikbn</td><td>（連携用）（介護）収入定期区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigosynyteikishrkskbn</td><td>（連携用）（介護）収入定期支払回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngyousekibosyujisikakucd</td><td>（連携用）業績用募集時資格コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngyskboshtnsineiyksnkbn</td><td>（連携用）業績用募集時発展新鋭躍進区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsynymrtihukahyj</td><td>（連携用）生活収入マル定付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiktsynyteikikbn</td><td>（連携用）生活収入定期区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseikatusyuunyuumrtis</td><td>（連携用）生活収入マル定Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnlivguardhukahyj</td><td>（連携用）ＬＩＶガード付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlivguards</td><td>（連携用）ＬＩＶガードＳ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnknkuzusnzyrttekitkarihyj</td><td>（連携用）健康増進乗率適用特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbluekzjtkaisiymd</td><td>（連携用）Ｂｌｕｅ継続状態開始年月日　</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknkuzusnzyrtstkbn</td><td>（連携用）健康増進乗率用ステータス区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdrtkykarihyj</td><td>（連携用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktourokuservicearihyj</td><td>（連携用）家族登録サービス有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiteituukakbn</td><td>（連携用）指定通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_HoyuuJyunzouZougenFRn
 * @see     GenZT_HoyuuJyunzouZougenFRn
 * @see     QZT_HoyuuJyunzouZougenFRn
 * @see     GenQZT_HoyuuJyunzouZougenFRn
 */
public class PKZT_HoyuuJyunzouZougenFRn extends AbstractExDBPrimaryKey<ZT_HoyuuJyunzouZougenFRn, PKZT_HoyuuJyunzouZougenFRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_HoyuuJyunzouZougenFRn() {
    }

    public PKZT_HoyuuJyunzouZougenFRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_HoyuuJyunzouZougenFRn> getEntityClass() {
        return ZT_HoyuuJyunzouZougenFRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}