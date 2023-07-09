CREATE TABLE ZT_HoyuuJyunzouZougenFRn_Z (
     zrnsequenceno                                      DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）シーケンス番号 */
     zrntantoukojincd                                   CHAR        (6)                                                       NOT NULL  ,  /* （連携用）担当者個人コード */
     zrntantousyasetteiym                               CHAR        (6)                                                       NOT NULL  ,  /* （連携用）担当者設定年月 */
     zrnkeijyousakikbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）計上先区分 */
     zrnkeijyousakisosiki                               CHAR        (7)                                                       NOT NULL  ,  /* （連携用）計上先組織 */
     zrnkeijyouym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）計上年月 */
     zrndenymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）伝票日付 */
     zrnutiwakekbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）内訳区分 */
     zrntantoukeiyakukbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）担当契約区分 */
     zrnkydatkikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）共同扱区分 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnbsyym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集年月 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnsaisinbsyym                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）最新募集年月 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnmaruteisyuruikigou                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）マル定種類記号 */
     zrnyobin3                                          DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）予備項目Ｎ３ */
     zrnyobiv1                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１ */
     zrnyobiv1x2                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿２ */
     zrnkykniyutksytioukbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約内容特殊対応区分 */
     zrnyobiv1x3                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿３ */
     zrnteisyuuhyj                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）定終表示 */
     zrnitijibryourouhyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）一時払養老表示 */
     zrnmrtihukahyj                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル定付加表示 */
     zrnseizonmrtihukahyj                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生存マル定付加表示 */
     zrnteigenmrtihukahyj                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）逓減マル定付加表示 */
     zrnsynymrtihukahyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）収入マル定付加表示 */
     zrnlivingneedstkykarihyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）リビングニーズ特約有表示 */
     zrnreguardmrtihukahyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）リガードマル定付加表示 */
     zrnreguardmrsyuhukahyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）リガードマル終付加表示 */
     zrnvguardmrtihukahyj                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｖガードマル定付加表示 */
     zrnkaigonktkykhukahyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）介護年金特約付加表示 */
     zrngoukeisisttkyktkknsnp                           DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）合計災疾特約月換算Ｐ */
     zrnhsys                                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）保障Ｓ */
     zrnkensuun3                                        DECIMAL     (3,1)                                                     NOT NULL  ,  /* （連携用）件数Ｎ３ */
     zrnhenkougohosyous                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更後保障Ｓ */
     zrnhtns                                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）被転換Ｓ */
     zrnharaikomip                                      DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）払込Ｐ */
     zrnkaiyakusiharaikngk                              DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）解約支払金額 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrnanniskcd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）案内先コード */
     zrntenkankaisuu                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）転換回数 */
     zrnsikkounyknkaisuu                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）失効入金回数 */
     zrnyobiv2                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ２ */
     zrnhhknnen2keta                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）被保険者年令（２桁） */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnkjkyknm                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）漢字契約者名 */
     zrntsinkihontikucd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）通信先基本地区コード */
     zrnhjnkykhyj                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）法人契約表示 */
     zrnhjncd                                           CHAR        (9)                                                       NOT NULL  ,  /* （連携用）法人コード */
     zrnhjnjigyosyocd                                   CHAR        (3)                                                       NOT NULL  ,  /* （連携用）法人事業所コード */
     zrnsyorisosikicd                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）処理組織コード */
     zrntikusyokansisyakijyhyj                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）地区所管支社計上表示 */
     zrnkeizokutyuuihyouji                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）継続注意表示 */
     zrntyohkkeiyakutyuuikbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）重複契約注意区分 */
     zrnyobiv1x4                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿４ */
     zrndantaisyozokucd                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）団体所属コード */
     zrnsuperknkuseikatupackhyj                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）スーパー健康生活パック表示 */
     zrnjikokykhyj                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）自己契約表示 */
     zrnkikeiyakutyuuihyouji                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）既契約注意表示 */
     zrnsyuuseis                                        DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）修正Ｓ */
     zrnclubsumiseikaiinkykkbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）クラブスミセイ会員契約区分 */
     zrngatkihmkknrkmaekykhyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｇ扱者訪問結果入力前契約表示 */
     zrngatkisetteikouhokykhyj                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｇ扱者設定候補契約表示 */
     zrnbosyuu25keikahyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）募集２５カ月経過表示 */
     zrntokuteidaisyokudanhyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特定大職団表示 */
     zrnhoyuuikantsgkykhyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保有移管対象外契約表示 */
     zrntokubeturuletikuhyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特別ルール地区表示 */
     zrnfieldtantousyaarihyj                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）フィールド担当者有表示 */
     zrnyobiv1x5                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿５ */
     zrncatkihmkknrkmaekykhyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｃ扱者訪問結果入力前契約表示 */
     zrncatkisetteikouhokykhyj                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｃ扱者設定候補契約表示 */
     zrnseppankeijyoukbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）折半計上区分 */
     zrnyobiv6                                          CHAR        (6)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ６ */
     zrnfollowtantousyakbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）フォロー担当者区分 */
     zrnyobiv7                                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ７ */
     zrnhosyouminaosikaisuuv2                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保障見直回数Ｖ２ */
     zrnbnkttnknkbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）分割転換区分 */
     zrntenkangosyono                                   CHAR        (11)                                                      NOT NULL  ,  /* （連携用）転換後証券番号 */
     zrnqpackhyj                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｑパック表示 */
     zrntenkangoqpackhyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）転換後Ｑパック表示 */
     zrnsyuruihnkutkbttrtkhyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）種類変更特別取扱表示 */
     zrntnkngsyuhnkutkbttrtkhyj                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）転換後種類変更特別取扱表示 */
     zrnyobin11                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１ */
     zrnkibanhikitugikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）基盤引継加算区分 */
     zrnyobiv1x6                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿６ */
     zrnsyoumetucd                                      CHAR        (4)                                                       NOT NULL  ,  /* （連携用）消滅コード */
     zrnjikaipjyuutouym                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）次回Ｐ充当年月 */
     zrnkaigomarusyuuhukahyj                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）介護マル終付加表示 */
     zrnyobiv1x7                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿７ */
     zrnsyoritorikesihyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）処理取消表示 */
     zrnmrtikousinkatakbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル定更新型区分 */
     zrnpmenkbnv1                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ免区分Ｖ１ */
     zrnsyukeiyakutkknsnp                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）主契約月換算Ｐ */
     zrnnenkansanp                                      DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）年換算Ｐ */
     zrndai3bunyanenkansanp                             DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）第３分野年換算Ｐ */
     zrnnyuuintkykhukahyj                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）入院特約付加表示 */
     zrnnyuuintkykhukahyj20ijyou                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）２０日以上入院特約付加表示 */
     zrnnyuuintkykhukahyj5ijyou                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）５日以上入院特約付加表示 */
     zrnmarusyotkykhukahyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル初特約付加表示 */
     zrnmarujyuutkykhukahyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル重特約付加表示 */
     zrnkakudaimaruitkykhukahyj                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）拡大マル医系特約付加表示 */
     zrnkakunyuutkykhukahyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）カク入特約付加表示 */
     zrnmaruitkykhukahyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル医特約付加表示 */
     zrnstdairiseikyuutkykarihyj                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）指定代理請求特約有表示 */
     zrnkensuuyuuguukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）件数優遇区分 */
     zrnkaigosynyteikikbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）（介護）収入定期区分 */
     zrnkaigosynyteikishrkskbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）（介護）収入定期支払回数区分 */
     zrngyousekibosyujisikakucd                         CHAR        (5)                                                       NOT NULL  ,  /* （連携用）業績用募集時資格コード */
     zrngyskboshtnsineiyksnkbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）業績用募集時発展新鋭躍進区分 */
     zrnsiktsynymrtihukahyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生活収入マル定付加表示 */
     zrnsiktsynyteikikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生活収入定期区分 */
     zrnseikatusyuunyuumrtis                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）生活収入マル定Ｓ */
     zrnlivguardhukahyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＬＩＶガード付加表示 */
     zrnlivguards                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）ＬＩＶガードＳ */
     zrnknkuzusnzyrttekitkarihyj                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）健康増進乗率適用特約有表示 */
     zrnbluekzjtkaisiymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）Ｂｌｕｅ継続状態開始年月日　 */
     zrnknkuzusnzyrtstkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）健康増進乗率用ステータス区分 */
     zrnkykdrtkykarihyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者代理特約有表示 */
     zrnkzktourokuservicearihyj                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）家族登録サービス有表示 */
     zrnyobiv1x11                                       CHAR        (1)                                                       NOT NULL     /* （連携用）予備項目Ｖ１＿１１ */
)
;

ALTER TABLE ZT_HoyuuJyunzouZougenFRn_Z ADD CONSTRAINT PK_HoyuuJyunzouZougenFRn PRIMARY KEY (
     zrnsequenceno                                              /* （連携用）シーケンス番号 */
) ;
