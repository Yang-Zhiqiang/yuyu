CREATE TABLE ZT_DrtenTsryInfoRn_Z (
     zrndairitencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店コード */
     zrnbosyuunincd                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集人コード */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkeiyakukbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約区分 */
     zrntokuyakuno                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約番号 */
     zrnbsyym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集年月 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnkydatkibosyuucd                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）共同扱募集人コード */
     zrnseiritujibumoncd                                CHAR        (5)                                                       NOT NULL  ,  /* （連携用）成立時部門コード */
     zrnseiritujiagutiknrcd                             CHAR        (12)                                                      NOT NULL  ,  /* （連携用）成立時代理店内管理扱者コード */
     zrnyobiv1                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１ */
     zrnkydeigyouakojincd                               CHAR        (6)                                                       NOT NULL  ,  /* （連携用）共同扱営業員Ａ扱者個人コード */
     zrnkydeigyoubkojincd                               CHAR        (6)                                                       NOT NULL  ,  /* （連携用）共同扱営業員Ｂ扱者個人コード */
     zrnskeihyj                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）新契約表示 */
     zrndenymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）伝票日付 */
     zrnkikaisyoriymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）機械処理年月日 */
     zrnsyoricd                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）処理コード */
     zrntyouseijiyuu                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）調整事由 */
     zrnnyknmonth                                       CHAR        (3)                                                       NOT NULL  ,  /* （連携用）入金月数 */
     zrnsikibetujyunjyo                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）識別順序 */
     zrntnsmacezugkukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）たのしみＡｃｅ増額区分 */
     zrnacezugkkrykkaisiymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）Ａｃｅ増額効力開始年月日 */
     zrnyobiv4                                          CHAR        (4)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ４ */
     zrnkykmfksnctrlkh                                  DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）契約ＭＦ更新ＣＴＲ（保全） */
     zrndairitenatkikeitaikbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）代理店扱形態区分 */
     zrnatkiwari                                        DECIMAL     (3,2)                                                     NOT NULL  ,  /* （連携用）扱割合 */
     zrndairitenatkinin                                 DECIMAL     (1)                                                       NOT NULL  ,  /* （連携用）代理店扱人数 */
     zrntsrkeisansyukykhsyos                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）手数料計算用主契約保障Ｓ */
     zrnhtns                                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）被転換Ｓ */
     zrnkijymods                                        DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）計上修正Ｓ */
     zrnksnbubunmods                                    DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）加算部分修正Ｓ */
     zrnbfrkijymods                                     DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）変更前計上修正Ｓ */
     zrnbfrksnbubunmods                                 DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）変更前加算部分修正Ｓ */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分 */
     zrntksyukgu                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約種類記号 */
     zrntksyukgusedaikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約種類記号世代区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrnhhknnen2keta                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）被保険者年令（２桁） */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrnfstkeijyouhtkm                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）初回計上判定項目 */
     zrntsrytsryhushrkbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）手数料不支払区分 */
     zrnbfritijibrzugkp                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前一時払増額Ｐ */
     zrnmaruteisyuruikigou                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）マル定種類記号 */
     zrnmrtihukakbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル定付加区分 */
     zrnsznmrtihukakbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生存マル定付加区分 */
     zrnteigenmrtihukakbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）逓減マル定付加区分 */
     zrnsyunyumrtihukakbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）収入マル定付加区分 */
     zrnkzkmrtihukakbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）家族マル定付加区分 */
     zrntoksipmrtihukakbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特定疾病マル定付加区分 */
     zrntoksipmrsyhukakbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特定疾病マル終付加区分 */
     zrnmanskknmrtihukakbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）慢性疾患マル定付加区分 */
     zrnkigsyunyumrtihukakbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）介護収入マル定付加区分 */
     zrnkigteigenmrtihukakbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）介護逓減マル定付加区分 */
     zrnkignktkhukakbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）介護年金特約付加区分 */
     zrnkigmrtihukakbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）介護マル定付加区分 */
     zrnmrtisyukguyobiv1                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル定種類記号予備１ */
     zrnmrtisyukguyobiv1x2                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル定種類記号予備２ */
     zrnmrtisyukguyobiv1x3                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル定種類記号予備３ */
     zrnmrtisyukguyobiv1x4                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル定種類記号予備４ */
     zrnmrtisyukguyobiv1x5                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マル定種類記号予備５ */
     zrnyobiv1x2                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿２ */
     zrnkyknm                                           CHAR        (18)                                                      NOT NULL  ,  /* （連携用）契約者名 */
     zrnkjkyknm                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）漢字契約者名 */
     zrnhhknmei                                         CHAR        (18)                                                      NOT NULL  ,  /* （連携用）被保険者名 */
     zrnknjhhknmei                                      GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）漢字被保険者名 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnanniskcd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）案内先コード */
     zrnkarikeijyoukbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）仮計上区分 */
     zrntuikakeijyouhyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）追加計上表示 */
     zrnksnhyj                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）更新表示 */
     zrndai2ksnbubunmods                                DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）第２加算部分修正Ｓ */
     zrndai2bfrksnbubunmods                             DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）第２変更前加算部分修正Ｓ */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間 */
     zrnjissyuup                                        DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）実収Ｐ */
     zrngntikktgtiryoutkp                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）限定告知型医療特約Ｐ */
     zrnbfrgntikktgtiryoutkp                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前限定告知型医療特約Ｐ */
     zrndairitenkbtinfo1                                CHAR        (15)                                                      NOT NULL  ,  /* （連携用）代理店個別情報１ */
     zrndairitenkbtinfo2                                CHAR        (15)                                                      NOT NULL  ,  /* （連携用）代理店個別情報２ */
     zrndairitenkbtinfo3                                CHAR        (15)                                                      NOT NULL  ,  /* （連携用）代理店個別情報３ */
     zrnsisttkp                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）災疾特約Ｐ */
     zrnreguardtkp                                      DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）リガード特約Ｐ */
     zrnvguardtkp                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）Ｖガード特約Ｐ */
     zrnbfrsisttkp                                      DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前災疾特約Ｐ */
     zrnbfrreguardtkp                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前リガード特約Ｐ */
     zrnbfrvguardtkp                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前Ｖガード特約Ｐ */
     zrngtmtv                                           DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）月末Ｖ */
     zrnsyukeiyakup                                     DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）主契約Ｐ */
     zrnbfrsyup                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前主契約Ｐ */
     zrndairitentsratkiwari                             DECIMAL     (3,2)                                                     NOT NULL  ,  /* （連携用）代理店手数料扱割合 */
     zrnseirituymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）成立年月日 */
     zrnsekininkaisiymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）責任開始年月日 */
     zrncifcd                                           CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＣＩＦコード */
     zrnbankboskykkbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）銀行募集契約区分 */
     zrnkykjiqpackhyj                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約時Ｑパック表示 */
     zrnitijibrzugkp                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）一時払増額Ｐ */
     zrntuuintokuyakup                                  DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）通院特約Ｐ */
     zrnbfrtuuintkp                                     DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前通院特約Ｐ */
     zrnsougousonsyoutokuyakup                          DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）総合損傷特約Ｐ */
     zrnbfrsugusnsyutkp                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前総合損傷特約Ｐ */
     zrnyoteiriritun5                                   DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）予定利率Ｎ５ */
     zrnyouikunenkintokuyakup                           DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）養育年金特約Ｐ */
     zrnbfryoiknktkp                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前養育年金特約Ｐ */
     zrngntikktgtiryoutkntgk                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）限定告知型医療特約日額 */
     zrnkyksyaskinmeino                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）契約者索引名番号 */
     zrnhhknsakuinmeino                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）被保険者索引名番号 */
     zrnsinkykbosyuoyadrtencd                           CHAR        (7)                                                       NOT NULL  ,  /* （連携用）新契約募集時親代理店コード */
     zrnsyouhizeiritu                                   DECIMAL     (5,3)                                                     NOT NULL  ,  /* （連携用）消費税率 */
     zrnmdhnaisyoumeicd                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）窓販用愛称名コード */
     zrncoolingofhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）クーリングオフ表示 */
     zrnsaimnkkykhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）才満期契約表示 */
     zrnpjytoym                                         CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ｐ充当年月 */
     zrnsskhntihrkkisukbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）成績判定用払込回数区分 */
     zrnphenkanarihyj                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ返還あり表示 */
     zrnhjnkykhyj                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）法人契約表示 */
     zrnbktgomeisaicalcjyun                             CHAR        (2)                                                       NOT NULL  ,  /* （連携用）分割後明細計算順 */
     zrnikkatubaraikbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）一括払区分 */
     zrnikkatubaraikaisuu                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）一括払回数 */
     zrnuktkid                                          CHAR        (11)                                                      NOT NULL  ,  /* （連携用）受付管理ＩＤ */
     zrnkigmrsytkp                                      DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）介護マル終特約Ｐ */
     zrnbfrkigmrsytkp                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前介護マル終特約Ｐ */
     zrnkigmrsytkphrkkkn                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）介護マル終特約Ｐ払込期間 */
     zrnyobiv5                                          CHAR        (5)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ５ */
     zrnphenkanbfrsyup                                  DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）Ｐ返還用変更前主契約Ｐ */
     zrnyobin3                                          DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）予備項目Ｎ３ */
     zrntousyokykjikawaserate                           DECIMAL     (7,2)                                                     NOT NULL  ,  /* （連携用）当初契約時為替レート */
     zrnyobin11                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿２ */
     zrnyobin11x3                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿３ */
     zrnyobin11x4                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿４ */
     zrnyobin11x5                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿５ */
     zrnyobin11x6                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿６ */
     zrnyobin11x7                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿７ */
     zrnyobin11x8                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿８ */
     zrnshzirtstkjynymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）消費税率設定基準年月日 */
     zrnkyksyaseiymd                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約者生年月日 */
     zrntuukacd                                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）通貨コード */
     zrnsyukeiyakupkyktuuka                             DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）主契約Ｐ（契約通貨） */
     zrnbfrsyupkyktuuka                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更前主契約Ｐ（契約通貨） */
     zrntekiyoukawaserate7keta                          DECIMAL     (7,2)                                                     NOT NULL  ,  /* （連携用）適用為替レート（７桁） */
     zrnyobiv22                                         CHAR        (22)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２２ */
     zrnyobiv83                                         CHAR        (83)                                                      NOT NULL     /* （連携用）予備項目Ｖ８３ */
)
;

ALTER TABLE ZT_DrtenTsryInfoRn_Z ADD CONSTRAINT PK_DrtenTsryInfoRn PRIMARY KEY (
     zrndairitencd                                            , /* （連携用）代理店コード */
     zrnbosyuunincd                                           , /* （連携用）募集人コード */
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnkikaisyoriymd                                         , /* （連携用）機械処理年月日 */
     zrnkykmfksnctrlkh                                        , /* （連携用）契約ＭＦ更新ＣＴＲ（保全） */
     zrnsikibetujyunjyo                                         /* （連携用）識別順序 */
) ;
