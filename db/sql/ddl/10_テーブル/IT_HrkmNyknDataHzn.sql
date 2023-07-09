CREATE TABLE IT_HrkmNyknDataHzn (
     densyskbn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 伝票用システム区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     itirenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 一連番号 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     syubetucd                                          NUMBER      (2)                                                                 ,  /* 種別コード */
     cdkbn                                              NUMBER      (1)                                                                 ,  /* コード区分 */
     sakuseiymd                                         VARCHAR     (8)                                                                 ,  /* 作成年月日 */
     knjyymdfrom                                        VARCHAR     (8)                                                                 ,  /* 勘定日（自） */
     knjyymdto                                          VARCHAR     (8)                                                                 ,  /* 勘定日（至） */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     banknmkn                                           VARCHAR     (25)                                                                ,  /* 銀行名（カナ） */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     sitennmkn                                          VARCHAR     (25)                                                                ,  /* 支店名（カナ） */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kznmkn                                             VARCHAR     (40)                                                                ,  /* 口座名（カナ） */
     kasikosikbn                                        NUMBER      (1)                                                                 ,  /* 貸越区分 */
     tuutyousysykbn                                     NUMBER      (1)                                                                 ,  /* 通帳証書区分 */
     trhkmaezndk                                        NUMBER      (13)                                                                ,  /* 取引前残高 */
     trhkmaezndk$                                       VARCHAR     (10)                                                                ,  /* 取引前残高(通貨型) */
     syoukaino                                          VARCHAR     (8)                                                                 ,  /* 照会番号 */
     knjyymd                                            VARCHAR     (8)                                                                 ,  /* 勘定日 */
     azkrhrdsymd                                        VARCHAR     (8)                                                                 ,  /* 預入払出日 */
     iribaraikbn                                        NUMBER      (1)                                                                 ,  /* 入払区分 */
     trhkkbn                                            NUMBER      (2)                                                                 ,  /* 取引区分 */
     trhkkgk                                            NUMBER      (13)                                                                ,  /* 取引金額 */
     trhkkgk$                                           VARCHAR     (10)                                                                ,  /* 取引金額(通貨型) */
     tatenkengk                                         NUMBER      (13)                                                                ,  /* うち他店券金額 */
     tatenkengk$                                        VARCHAR     (10)                                                                ,  /* うち他店券金額(通貨型) */
     kknteijiymd                                        VARCHAR     (8)                                                                 ,  /* 交換呈示日 */
     hwtrhnknymd                                        VARCHAR     (8)                                                                 ,  /* 不渡返還日 */
     tgtkgtkbn                                          VARCHAR     (1)                                                                 ,  /* 手形小切手区分 */
     tgtkgtno                                           VARCHAR     (7)                                                                 ,  /* 手形小切手番号 */
     ryoutenno                                          VARCHAR     (3)                                                                 ,  /* 僚店番号 */
     hrkmirnincd                                        VARCHAR     (10)                                                                ,  /* 振込依頼人コード */
     hrkmirninnm                                        VARCHAR     (96)                                                                ,  /* 振込依頼人名 */
     simukebanknmkn                                     VARCHAR     (15)                                                                ,  /* 仕向銀行名（カナ） */
     simuketennmkn                                      VARCHAR     (15)                                                                ,  /* 仕向店名（カナ） */
     tekiyounaiyou                                      VARCHAR     (20)                                                                ,  /* 摘要内容 */
     ediinfo                                            VARCHAR     (20)                                                                ,  /* ＥＤＩ情報 */
     syorizumiflg                                       VARCHAR     (1)                                                                 ,  /* 処理済フラグ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_HrkmNyknDataHzn ADD CONSTRAINT PK_HrkmNyknDataHzn PRIMARY KEY (
     densyskbn                                                , /* 伝票用システム区分 */
     syoriYmd                                                 , /* 処理年月日 */
     itirenno                                                   /* 一連番号 */
) ;
