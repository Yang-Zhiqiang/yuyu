CREATE TABLE HT_GaikaHrkmNyknData_Z (
     densyskbn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 伝票用システム区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     itirenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 一連番号 */
     nykmosno                                           VARCHAR     (20)                                                                ,  /* 入金用申込番号 */
     syouhnno                                           VARCHAR     (2)                                                                 ,  /* 商品番号 */
     syubetucd                                          DECIMAL     (2)                                                                 ,  /* 種別コード */
     cdkbn                                              DECIMAL     (1)                                                                 ,  /* コード区分 */
     sakuseiymd                                         VARCHAR     (8)                                                                 ,  /* 作成年月日 */
     knjyymdfrom                                        VARCHAR     (8)                                                                 ,  /* 勘定日（自） */
     knjyymdto                                          VARCHAR     (8)                                                                 ,  /* 勘定日（至） */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     banknmkn                                           VARCHAR     (52)                                                                ,  /* 銀行名（カナ） */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     sitennmkn                                          VARCHAR     (52)                                                                ,  /* 支店名（カナ） */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kznmkn                                             VARCHAR     (82)                                                                ,  /* 口座名（カナ） */
     kasikosikbn                                        DECIMAL     (1)                                                                 ,  /* 貸越区分 */
     trhkmaezndk                                        DECIMAL     (13)                                                                ,  /* 取引前残高 */
     trhkmaezndk$                                       VARCHAR     (10)                                                                ,  /* 取引前残高(通貨型) */
     trhksakisyoukaino                                  VARCHAR     (32)                                                                ,  /* 取引先照会番号 */
     knjyymd                                            VARCHAR     (8)                                                                 ,  /* 勘定日 */
     ksnymd                                             VARCHAR     (8)                                                                 ,  /* 起算日 */
     iribaraikbn                                        DECIMAL     (1)                                                                 ,  /* 入払区分 */
     trhkkbn                                            DECIMAL     (2)                                                                 ,  /* 取引区分 */
     trhkkgk                                            DECIMAL     (13)                                                                ,  /* 取引金額 */
     trhkkgk$                                           VARCHAR     (10)                                                                ,  /* 取引金額(通貨型) */
     dengk                                              DECIMAL     (13)                                                                ,  /* 伝票金額 */
     dengk$                                             VARCHAR     (10)                                                                ,  /* 伝票金額(通貨型) */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類 */
     hrkmirninnm                                        VARCHAR     (194)                                                               ,  /* 振込依頼人名 */
     simukebanknmeiji                                   VARCHAR     (70)                                                                ,  /* 仕向銀行名（英字） */
     simuketennmeiji                                    VARCHAR     (35)                                                                ,  /* 仕向店名（英字） */
     tekiyounaiyoueiji                                  VARCHAR     (48)                                                                ,  /* 摘要内容（英字） */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     oyadrtensyoritarget                                VARCHAR     (1)                                                                 ,  /* 親代理店処理対象 */
     jidonykntargethyouji                               VARCHAR     (1)                                                                 ,  /* 自動入金対象表示 */
     mostokusokuumu                                     VARCHAR     (1)                                                                 ,  /* 申込書類督促有無 */
     syorizumiflg                                       VARCHAR     (1)                                                                 ,  /* 処理済フラグ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     hrkmnykndatarenmotoKbn                             VARCHAR     (1)                                                                 ,  /* 振込入金データ連携元区分 */
     nyuukinoyadrtennm                                  VARCHAR     (62)                                                                ,  /* 入金用親代理店名 */
     siteituuka                                         VARCHAR     (3)                                                                 ,  /* 指定通貨 */
     honkouzacd                                         VARCHAR     (3)                                                                 ,  /* 本口座コード */
     hrkmirninnm140                                     VARCHAR     (282)                                                                  /* 振込依頼人名（１４０桁） */
)
;

ALTER TABLE HT_GaikaHrkmNyknData_Z ADD CONSTRAINT PK_GaikaHrkmNyknData PRIMARY KEY (
     densyskbn                                                , /* 伝票用システム区分 */
     syoriYmd                                                 , /* 処理年月日 */
     itirenno                                                   /* 一連番号 */
) ;

CREATE INDEX IX1_GaikaHrkmNyknData ON HT_GaikaHrkmNyknData_Z (
     syoriYmd                                                   /* 処理年月日 */
) ;

CREATE INDEX IX2_GaikaHrkmNyknData ON HT_GaikaHrkmNyknData_Z (
     syorizumiflg                                               /* 処理済フラグ */
) ;

CREATE INDEX IX3_GaikaHrkmNyknData ON HT_GaikaHrkmNyknData_Z (
     densyskbn                                                , /* 伝票用システム区分 */
     syorizumiflg                                               /* 処理済フラグ */
) ;
