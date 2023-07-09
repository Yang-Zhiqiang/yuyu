CREATE TABLE JT_Mouside (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     seikyuusyubetu                                     VARCHAR     (2)                                                                 ,  /* 請求種別                                          */
     nayoseyouhi                                        VARCHAR     (1)                                                                 ,  /* 名寄せ要否                                         */
     mousideninkbn                                      VARCHAR     (2)                                                                 ,  /* 申出人区分                                         */
     syuhiyouhi                                         VARCHAR     (1)                                                                 ,  /* 守秘要否                                          */
     mousideninnmkj                                     VARCHAR     (15)                                                                ,  /* 申出人名（漢字）                                      */
     uketorininsibouumukbn                              VARCHAR     (1)                                                                 ,  /* 受取人死亡有無区分                                     */
     kyksyasibouumukbn                                  VARCHAR     (1)                                                                 ,  /* 契約者死亡有無区分                                     */
     souhusakikbn                                       VARCHAR     (1)                                                                 ,  /* 送付先区分                                         */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号                                       */
     tsinadr1kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所１（漢字）                                    */
     tsinadr2kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所２（漢字）                                    */
     tsinadr3kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所３（漢字）                                    */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号                                       */
     pmenkbn                                            VARCHAR     (1)                                                                 ,  /* Ｐ免区分                                          */
     geninkbn                                           VARCHAR     (2)                                                                 ,  /* 原因区分                                          */
     jikosyosinymd                                      VARCHAR     (8)                                                                 ,  /* 事故（初診）日                                       */
     saigaigeninkbn                                     VARCHAR     (2)                                                                 ,  /* 災害原因区分                                        */
     sibouymd                                           VARCHAR     (8)                                                                 ,  /* 死亡日                                           */
     syougaikoteiymd                                    VARCHAR     (8)                                                                 ,  /* 障害固定日                                         */
     byoumeitourokuno                                   VARCHAR     (6)                                                                 ,  /* 病名登録番号                                        */
     tiryousakikbn                                      VARCHAR     (1)                                                                 ,  /* 治療先区分                                         */
     nyuuinymd                                          VARCHAR     (8)                                                                 ,  /* 入院日                                           */
     taiinymd                                           VARCHAR     (8)                                                                 ,  /* 退院日                                           */
     syujyutuymd                                        VARCHAR     (8)                                                                 ,  /* 手術日                                           */
     syujyututourokuno                                  VARCHAR     (9)                                                                 ,  /* 手術登録番号                                        */
     sensinkbn                                          VARCHAR     (1)                                                                 ,  /* 先進医療区分                                        */
     sindansyosksmaisuukbn                              VARCHAR     (1)                                                                 ,  /* 診断書作成枚数区分                                     */
     sindansyoskssiteikbn                               VARCHAR     (1)                                                                 ,  /* 診断書作成指定区分                                     */
     betukyksuu                                         NUMBER      (2)                                                                 ,  /* 別契約数                                          */
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

ALTER TABLE JT_Mouside ADD CONSTRAINT PK_Mouside PRIMARY KEY (
     skno                                                     , /* 請求番号                                           */
     syono                                                      /* 証券番号                                           */
) ;
