CREATE TABLE JT_KoudosgJytGtKahi (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     seikyuurirekino                                    NUMBER      (3)                                                       NOT NULL  ,  /* 請求履歴番号                                        */
     ryougansitumeikbn                                  VARCHAR     (1)                                                                 ,  /* 両眼失明区分                                        */
     ryougansitumeicomment                              VARCHAR     (40)                                                                ,  /* 両眼失明コメント                                      */
     gengososyakusousitukbn                             VARCHAR     (1)                                                                 ,  /* 言語・咀嚼機能喪失区分                                   */
     gengososyakusousitucomment                         VARCHAR     (40)                                                                ,  /* 言語・咀嚼機能喪失コメント                                 */
     ryoujyousiyoubousitukbn                            VARCHAR     (1)                                                                 ,  /* 両上肢用（亡）失区分                                    */
     ryoujyousiyoubousitucomt                           VARCHAR     (40)                                                                ,  /* 両上肢用（亡）失コメント                                  */
     ryoukasiyoubousitukbn                              VARCHAR     (1)                                                                 ,  /* 両下肢用（亡）失区分                                    */
     ryoukasiyoubousitucomt                             VARCHAR     (40)                                                                ,  /* 両下肢用（亡）失コメント                                  */
     ijyobosituikasiyositukbn                           VARCHAR     (1)                                                                 ,  /* １上肢亡失・１下肢用（亡）失区分                              */
     ijyobosituikasiyositucomt                          VARCHAR     (40)                                                                ,  /* １上肢亡失・１下肢用（亡）失コメント                            */
     ijyoyosituikasibositukbn                           VARCHAR     (1)                                                                 ,  /* １上肢用失・１下肢亡失区分                                 */
     ijyoyosituikasibositucomt                          VARCHAR     (40)                                                                ,  /* １上肢用失・１下肢亡失コメント                               */
     sysnjoujikaigokbn                                  VARCHAR     (1)                                                                 ,  /* 終身常時介護区分                                      */
     sysnjoujikaigocomment                              VARCHAR     (40)                                                                ,  /* 終身常時介護コメント                                    */
     hokoukbn                                           VARCHAR     (1)                                                                 ,  /* 歩行区分                                          */
     hokoucomment                                       VARCHAR     (40)                                                                ,  /* 歩行コメント                                        */
     ihukutyakudatukbn                                  VARCHAR     (1)                                                                 ,  /* 衣服着脱区分                                        */
     ihukutyakudatucomment                              VARCHAR     (40)                                                                ,  /* 衣服着脱コメント                                      */
     nyuuyokukbn                                        VARCHAR     (1)                                                                 ,  /* 入浴区分                                          */
     nyuuyokucomment                                    VARCHAR     (40)                                                                ,  /* 入浴コメント                                        */
     syokumotusessyukbn                                 VARCHAR     (1)                                                                 ,  /* 食物摂取区分                                        */
     syokumotusessyucomment                             VARCHAR     (40)                                                                ,  /* 食物摂取コメント                                      */
     hukitorisimatukbn                                  VARCHAR     (1)                                                                 ,  /* 拭き取り始末区分                                      */
     hukitorisimatucomment                              VARCHAR     (40)                                                                ,  /* 拭き取り始末コメント                                    */
     haibenhainyoukbn                                   VARCHAR     (1)                                                                 ,  /* 排便・排尿区分                                       */
     haibenhainyoucomment                               VARCHAR     (40)                                                                ,  /* 排便・排尿コメント                                     */
     kikyokbn                                           VARCHAR     (1)                                                                 ,  /* 起居区分                                          */
     kikyocomment                                       VARCHAR     (40)                                                                ,  /* 起居コメント                                        */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード                                       */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JT_KoudosgJytGtKahi ADD CONSTRAINT PK_KoudosgJytGtKahi PRIMARY KEY (
     skno                                                     , /* 請求番号                                           */
     syono                                                    , /* 証券番号                                           */
     seikyuurirekino                                            /* 請求履歴番号                                         */
) ;
