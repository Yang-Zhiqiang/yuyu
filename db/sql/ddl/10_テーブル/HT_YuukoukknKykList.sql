CREATE TABLE HT_YuukoukknKykList (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日                                         */
     daimosno                                           VARCHAR     (20)                                                                ,  /* 代表申込番号                                        */
     hhknnmkj                                           VARCHAR     (15)                                                                ,  /* 被保険者名（漢字）                                     */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字）                                      */
     syusyouhncd                                        VARCHAR     (4)                                                                 ,  /* 主契約商品コード                                      */
     syusyouhnnm                                        VARCHAR     (40)                                                                ,  /* 主契約商品名                                        */
     dntcd                                              VARCHAR     (8)                                                                 ,  /* 団体コード                                         */
     dntnm                                              VARCHAR     (30)                                                                ,  /* 団体名                                           */
     mosymd                                             VARCHAR     (8)                                                                 ,  /* 申込日                                           */
     ssyukeymd                                          VARCHAR     (8)                                                                 ,  /* 支社受付日                                         */
     kktkktymd                                          VARCHAR     (8)                                                                 ,  /* 告知書告知日                                        */
     hjkktymd                                           VARCHAR     (8)                                                                 ,  /* 報状告知日                                         */
     kthhbkbn                                           VARCHAR     (1)                                                                 ,  /* 決定保留不備区分                                      */
     srhhbkbn                                           VARCHAR     (1)                                                                 ,  /* 成立保留不備区分                                      */
     jimusrhkbn                                         VARCHAR     (2)                                                                 ,  /* 事務成立保留区分                                      */
     syssrhkbn                                          VARCHAR     (2)                                                                 ,  /* システム成立保留区分                                    */
     khnhbkbn                                           VARCHAR     (1)                                                                 ,  /* 基本不備区分                                        */
     ketteikbn                                          VARCHAR     (2)                                                                 ,  /* 決定状態区分                                        */
     rfstphrkkeiro                                      VARCHAR     (10)                                                                ,  /* （帳票用）初回保険料払込経路                                */
     fstphrkkeirokbn                                    VARCHAR     (2)                                                                 ,  /* 初回保険料払込経路区分                                   */
     keikakbn                                           VARCHAR     (1)                                                                 ,  /* 経過区分                                          */
     fstnyknrsymd                                       VARCHAR     (8)                                                                 ,  /* 初回入金領収日                                       */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_YuukoukknKykList ADD CONSTRAINT PK_YuukoukknKykList PRIMARY KEY (
     mosno                                                    , /* 申込番号                                           */
     tyouhyouymd                                                /* 帳票作成日                                          */
) ;
