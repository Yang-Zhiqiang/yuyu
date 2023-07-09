CREATE TABLE JT_SiJinsokuShrTtdkInfo (
     syorisosikicd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* 処理組織コード */
     syoricd                                            VARCHAR     (4)                                                       NOT NULL  ,  /* 処理コード */
     hknknshrsntkno                                     VARCHAR     (2)                                                       NOT NULL  ,  /* 保険金支払処理選択番号 */
     syoruiukeymd                                       VARCHAR     (8)                                                       NOT NULL  ,  /* 書類受付日 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     denymd                                             VARCHAR     (8)                                                       NOT NULL  ,  /* 伝票日付 */
     syoruikeikaeigyoubisuu                             NUMBER      (3)                                                                 ,  /* 書類受付経過営業日数 */
     syorikeikaeigyoubisuu                              NUMBER      (3)                                                                 ,  /* 処理経過営業日数 */
     toritugisosikicd                                   VARCHAR     (7)                                                                 ,  /* 取次組織コード */
     tanmatusyuruikbn                                   VARCHAR     (1)                                                                 ,  /* 端末種類区分 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE JT_SiJinsokuShrTtdkInfo ADD CONSTRAINT PK_SiJinsokuShrTtdkInfo PRIMARY KEY (
     syorisosikicd                                            , /* 処理組織コード */
     syoricd                                                  , /* 処理コード */
     hknknshrsntkno                                           , /* 保険金支払処理選択番号 */
     syoruiukeymd                                             , /* 書類受付日 */
     syoriYmd                                                 , /* 処理年月日 */
     denymd                                                   , /* 伝票日付 */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_SiJinsokuShrTtdkInfo ON JT_SiJinsokuShrTtdkInfo (
     syoriYmd                                                   /* 処理年月日 */
) ;
