CREATE TABLE ZT_DrtenTsryInfoTy_Z (
     ztydairitencd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）代理店コード */
     ztybosyuunincd                                     VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）募集人コード */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztykeiyakukbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）契約区分 */
     ztytokuyakuno                                      VARCHAR     (2)                                                                 ,  /* （中継用）特約番号 */
     ztybsyym                                           VARCHAR     (6)                                                                 ,  /* （中継用）募集年月 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztykydatkibosyuucd                                 VARCHAR     (6)                                                                 ,  /* （中継用）共同扱募集人コード */
     ztyseiritujibumoncd                                VARCHAR     (5)                                                                 ,  /* （中継用）成立時部門コード */
     ztyseiritujiagutiknrcd                             VARCHAR     (12)                                                                ,  /* （中継用）成立時代理店内管理扱者コード */
     ztyyobiv1                                          VARCHAR     (1)                                                                 ,  /* （中継用）予備項目Ｖ１ */
     ztykydeigyouakojincd                               VARCHAR     (6)                                                                 ,  /* （中継用）共同扱営業員Ａ扱者個人コード */
     ztykydeigyoubkojincd                               VARCHAR     (6)                                                                 ,  /* （中継用）共同扱営業員Ｂ扱者個人コード */
     ztyskeihyj                                         VARCHAR     (1)                                                                 ,  /* （中継用）新契約表示 */
     ztydenymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）伝票日付 */
     ztykikaisyoriymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）機械処理年月日 */
     ztysyoricd                                         VARCHAR     (4)                                                                 ,  /* （中継用）処理コード */
     ztytyouseijiyuu                                    VARCHAR     (3)                                                                 ,  /* （中継用）調整事由 */
     ztynyknmonth                                       VARCHAR     (3)                                                                 ,  /* （中継用）入金月数 */
     ztysikibetujyunjyo                                 VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）識別順序 */
     ztytnsmacezugkukbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）たのしみＡｃｅ増額区分 */
     ztyacezugkkrykkaisiymd                             VARCHAR     (8)                                                                 ,  /* （中継用）Ａｃｅ増額効力開始年月日 */
     ztyyobiv4                                          VARCHAR     (4)                                                                 ,  /* （中継用）予備項目Ｖ４ */
     ztykykmfksnctrlkh                                  DECIMAL     (7)                                                       NOT NULL  ,  /* （中継用）契約ＭＦ更新ＣＴＲ（保全） */
     ztydairitenatkikeitaikbn                           VARCHAR     (1)                                                                 ,  /* （中継用）代理店扱形態区分 */
     ztyatkiwari                                        DECIMAL     (3,2)                                                               ,  /* （中継用）扱割合 */
     ztydairitenatkinin                                 DECIMAL     (1)                                                                 ,  /* （中継用）代理店扱人数 */
     ztytsrkeisansyukykhsyos                            DECIMAL     (11)                                                                ,  /* （中継用）手数料計算用主契約保障Ｓ */
     ztyhtns                                            DECIMAL     (11)                                                                ,  /* （中継用）被転換Ｓ */
     ztykijymods                                        DECIMAL     (7)                                                                 ,  /* （中継用）計上修正Ｓ */
     ztyksnbubunmods                                    DECIMAL     (7)                                                                 ,  /* （中継用）加算部分修正Ｓ */
     ztybfrkijymods                                     DECIMAL     (7)                                                                 ,  /* （中継用）変更前計上修正Ｓ */
     ztybfrksnbubunmods                                 DECIMAL     (7)                                                                 ,  /* （中継用）変更前加算部分修正Ｓ */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyhknsyuruikigousedaikbn                          VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号世代区分 */
     ztytksyukgu                                        VARCHAR     (2)                                                                 ,  /* （中継用）特約種類記号 */
     ztytksyukgusedaikbn                                VARCHAR     (1)                                                                 ,  /* （中継用）特約種類記号世代区分 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyannaifuyouriyuukbn                              VARCHAR     (2)                                                                 ,  /* （中継用）案内不要理由区分 */
     ztyhhknnen2keta                                    VARCHAR     (2)                                                                 ,  /* （中継用）被保険者年令（２桁） */
     ztyhknkkn                                          VARCHAR     (2)                                                                 ,  /* （中継用）保険期間 */
     ztyfstkeijyouhtkm                                  VARCHAR     (6)                                                                 ,  /* （中継用）初回計上判定項目 */
     ztytsrytsryhushrkbn                                VARCHAR     (1)                                                                 ,  /* （中継用）手数料不支払区分 */
     ztybfritijibrzugkp                                 DECIMAL     (11)                                                                ,  /* （中継用）変更前一時払増額Ｐ */
     ztymaruteisyuruikigou                              VARCHAR     (2)                                                                 ,  /* （中継用）マル定種類記号 */
     ztymrtihukakbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）マル定付加区分 */
     ztysznmrtihukakbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）生存マル定付加区分 */
     ztyteigenmrtihukakbn                               VARCHAR     (1)                                                                 ,  /* （中継用）逓減マル定付加区分 */
     ztysyunyumrtihukakbn                               VARCHAR     (1)                                                                 ,  /* （中継用）収入マル定付加区分 */
     ztykzkmrtihukakbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）家族マル定付加区分 */
     ztytoksipmrtihukakbn                               VARCHAR     (1)                                                                 ,  /* （中継用）特定疾病マル定付加区分 */
     ztytoksipmrsyhukakbn                               VARCHAR     (1)                                                                 ,  /* （中継用）特定疾病マル終付加区分 */
     ztymanskknmrtihukakbn                              VARCHAR     (1)                                                                 ,  /* （中継用）慢性疾患マル定付加区分 */
     ztykigsyunyumrtihukakbn                            VARCHAR     (1)                                                                 ,  /* （中継用）介護収入マル定付加区分 */
     ztykigteigenmrtihukakbn                            VARCHAR     (1)                                                                 ,  /* （中継用）介護逓減マル定付加区分 */
     ztykignktkhukakbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）介護年金特約付加区分 */
     ztykigmrtihukakbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）介護マル定付加区分 */
     ztymrtisyukguyobiv1                                VARCHAR     (1)                                                                 ,  /* （中継用）マル定種類記号予備項目Ｖ１ */
     ztymrtisyukguyobiv1x2                              VARCHAR     (1)                                                                 ,  /* （中継用）マル定種類記号予備項目Ｖ１＿２ */
     ztymrtisyukguyobiv1x3                              VARCHAR     (1)                                                                 ,  /* （中継用）マル定種類記号予備項目Ｖ１＿３ */
     ztymrtisyukguyobiv1x4                              VARCHAR     (1)                                                                 ,  /* （中継用）マル定種類記号予備項目Ｖ１＿４ */
     ztymrtisyukguyobiv1x5                              VARCHAR     (1)                                                                 ,  /* （中継用）マル定種類記号予備項目Ｖ１＿５ */
     ztyyobiv1x2                                        VARCHAR     (1)                                                                 ,  /* （中継用）予備項目Ｖ１＿２ */
     ztykyknm                                           VARCHAR     (38)                                                                ,  /* （中継用）契約者名 */
     ztykjkyknm                                         VARCHAR     (32)                                                                ,  /* （中継用）漢字契約者名 */
     ztyhhknmei                                         VARCHAR     (38)                                                                ,  /* （中継用）被保険者名 */
     ztyknjhhknmei                                      VARCHAR     (32)                                                                ,  /* （中継用）漢字被保険者名 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztyanniskcd                                        VARCHAR     (8)                                                                 ,  /* （中継用）案内先コード */
     ztykarikeijyoukbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）仮計上区分 */
     ztytuikakeijyouhyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）追加計上表示 */
     ztyksnhyj                                          VARCHAR     (1)                                                                 ,  /* （中継用）更新表示 */
     ztydai2ksnbubunmods                                DECIMAL     (7)                                                                 ,  /* （中継用）第２加算部分修正Ｓ */
     ztydai2bfrksnbubunmods                             DECIMAL     (7)                                                                 ,  /* （中継用）第２変更前加算部分修正Ｓ */
     ztyphrkkikn                                        VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ払込期間 */
     ztyjissyuup                                        DECIMAL     (11)                                                                ,  /* （中継用）実収Ｐ */
     ztygntikktgtiryoutkp                               DECIMAL     (11)                                                                ,  /* （中継用）限定告知型医療特約Ｐ */
     ztybfrgntikktgtiryoutkp                            DECIMAL     (11)                                                                ,  /* （中継用）変更前限定告知型医療特約Ｐ */
     ztydairitenkbtinfo1                                VARCHAR     (15)                                                                ,  /* （中継用）代理店個別情報１ */
     ztydairitenkbtinfo2                                VARCHAR     (15)                                                                ,  /* （中継用）代理店個別情報２ */
     ztydairitenkbtinfo3                                VARCHAR     (15)                                                                ,  /* （中継用）代理店個別情報３ */
     ztysisttkp                                         DECIMAL     (11)                                                                ,  /* （中継用）災疾特約Ｐ */
     ztyreguardtkp                                      DECIMAL     (11)                                                                ,  /* （中継用）リガード特約Ｐ */
     ztyvguardtkp                                       DECIMAL     (11)                                                                ,  /* （中継用）Ｖガード特約Ｐ */
     ztybfrsisttkp                                      DECIMAL     (11)                                                                ,  /* （中継用）変更前災疾特約Ｐ */
     ztybfrreguardtkp                                   DECIMAL     (11)                                                                ,  /* （中継用）変更前リガード特約Ｐ */
     ztybfrvguardtkp                                    DECIMAL     (11)                                                                ,  /* （中継用）変更前Ｖガード特約Ｐ */
     ztygtmtv                                           DECIMAL     (11)                                                                ,  /* （中継用）月末Ｖ */
     ztysyukeiyakup                                     DECIMAL     (11)                                                                ,  /* （中継用）主契約Ｐ */
     ztybfrsyup                                         DECIMAL     (11)                                                                ,  /* （中継用）変更前主契約Ｐ */
     ztydairitentsratkiwari                             DECIMAL     (3,2)                                                               ,  /* （中継用）代理店手数料扱割合 */
     ztyseirituymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）成立年月日 */
     ztysekininkaisiymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）責任開始年月日 */
     ztycifcd                                           VARCHAR     (15)                                                                ,  /* （中継用）ＣＩＦコード */
     ztybankboskykkbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）銀行募集契約区分 */
     ztykykjiqpackhyj                                   VARCHAR     (1)                                                                 ,  /* （中継用）契約時Ｑパック表示 */
     ztyitijibrzugkp                                    DECIMAL     (11)                                                                ,  /* （中継用）一時払増額Ｐ */
     ztytuuintokuyakup                                  DECIMAL     (11)                                                                ,  /* （中継用）通院特約Ｐ */
     ztybfrtuuintkp                                     DECIMAL     (11)                                                                ,  /* （中継用）変更前通院特約Ｐ */
     ztysougousonsyoutokuyakup                          DECIMAL     (11)                                                                ,  /* （中継用）総合損傷特約Ｐ */
     ztybfrsugusnsyutkp                                 DECIMAL     (11)                                                                ,  /* （中継用）変更前総合損傷特約Ｐ */
     ztyyoteiriritun5                                   DECIMAL     (5,4)                                                               ,  /* （中継用）予定利率Ｎ５ */
     ztyyouikunenkintokuyakup                           DECIMAL     (11)                                                                ,  /* （中継用）養育年金特約Ｐ */
     ztybfryoiknktkp                                    DECIMAL     (11)                                                                ,  /* （中継用）変更前養育年金特約Ｐ */
     ztygntikktgtiryoutkntgk                            DECIMAL     (11)                                                                ,  /* （中継用）限定告知型医療特約日額 */
     ztykyksyaskinmeino                                 VARCHAR     (10)                                                                ,  /* （中継用）契約者索引名番号 */
     ztyhhknsakuinmeino                                 VARCHAR     (10)                                                                ,  /* （中継用）被保険者索引名番号 */
     ztysinkykbosyuoyadrtencd                           VARCHAR     (7)                                                                 ,  /* （中継用）新契約募集時親代理店コード */
     ztysyouhizeiritu                                   DECIMAL     (5,3)                                                               ,  /* （中継用）消費税率 */
     ztymdhnaisyoumeicd                                 VARCHAR     (3)                                                                 ,  /* （中継用）窓販用愛称名コード */
     ztycoolingofhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）クーリングオフ表示 */
     ztysaimnkkykhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）才満期契約表示 */
     ztypjytoym                                         VARCHAR     (6)                                                                 ,  /* （中継用）Ｐ充当年月 */
     ztysskhntihrkkisukbn                               VARCHAR     (1)                                                                 ,  /* （中継用）成績判定用払込回数区分 */
     ztyphenkanarihyj                                   VARCHAR     (1)                                                                 ,  /* （中継用）Ｐ返還あり表示 */
     ztyhjnkykhyj                                       VARCHAR     (1)                                                                 ,  /* （中継用）法人契約表示 */
     ztybktgomeisaicalcjyun                             VARCHAR     (2)                                                                 ,  /* （中継用）分割後明細計算順 */
     ztyikkatubaraikbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）一括払区分 */
     ztyikkatubaraikaisuu                               VARCHAR     (2)                                                                 ,  /* （中継用）一括払回数 */
     ztyuktkid                                          VARCHAR     (11)                                                                ,  /* （中継用）受付管理ＩＤ */
     ztykigmrsytkp                                      DECIMAL     (11)                                                                ,  /* （中継用）介護マル終特約Ｐ */
     ztybfrkigmrsytkp                                   DECIMAL     (11)                                                                ,  /* （中継用）変更前介護マル終特約Ｐ */
     ztykigmrsytkphrkkkn                                VARCHAR     (2)                                                                 ,  /* （中継用）介護マル終特約Ｐ払込期間 */
     ztyyobiv5                                          VARCHAR     (5)                                                                 ,  /* （中継用）予備項目Ｖ５ */
     ztyphenkanbfrsyup                                  DECIMAL     (11)                                                                ,  /* （中継用）Ｐ返還用変更前主契約Ｐ */
     ztyyobin3                                          DECIMAL     (3)                                                                 ,  /* （中継用）予備項目Ｎ３ */
     ztytousyokykjikawaserate                           DECIMAL     (7,2)                                                               ,  /* （中継用）当初契約時為替レート */
     ztyyobin11                                         DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2                                       DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿２ */
     ztyyobin11x3                                       DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿３ */
     ztyyobin11x4                                       DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿４ */
     ztyyobin11x5                                       DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿５ */
     ztyyobin11x6                                       DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿６ */
     ztyyobin11x7                                       DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿７ */
     ztyyobin11x8                                       DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿８ */
     ztyshzirtstkjynymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）消費税率設定基準年月日 */
     ztykyksyaseiymd                                    VARCHAR     (8)                                                                 ,  /* （中継用）契約者生年月日 */
     ztytuukacd                                         VARCHAR     (3)                                                                 ,  /* （中継用）通貨コード */
     ztysyukeiyakupkyktuuka                             DECIMAL     (11)                                                                ,  /* （中継用）主契約Ｐ（契約通貨） */
     ztybfrsyupkyktuuka                                 DECIMAL     (11)                                                                ,  /* （中継用）変更前主契約Ｐ（契約通貨） */
     ztytekiyoukawaserate7keta                          DECIMAL     (7,2)                                                               ,  /* （中継用）適用為替レート（７桁） */
     ztyyobiv22                                         VARCHAR     (22)                                                                ,  /* （中継用）予備項目Ｖ２２ */
     ztyyobiv83                                         VARCHAR     (83)                                                                ,  /* （中継用）予備項目Ｖ８３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_DrtenTsryInfoTy_Z ADD CONSTRAINT PK_DrtenTsryInfoTy PRIMARY KEY (
     ztydairitencd                                            , /* （中継用）代理店コード */
     ztybosyuunincd                                           , /* （中継用）募集人コード */
     ztysyono                                                 , /* （中継用）証券番号 */
     ztykikaisyoriymd                                         , /* （中継用）機械処理年月日 */
     ztykykmfksnctrlkh                                        , /* （中継用）契約ＭＦ更新ＣＴＲ（保全） */
     ztysikibetujyunjyo                                         /* （中継用）識別順序 */
) ;
