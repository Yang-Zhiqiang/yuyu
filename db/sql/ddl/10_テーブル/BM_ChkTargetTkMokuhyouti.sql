CREATE TABLE BM_ChkTargetTkMokuhyouti (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syusyouhnsdnofrom                                  NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                    NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至 */
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード */
     targettkmokuhyouti                                 NUMBER      (3)                                                       NOT NULL  ,  /* ターゲット特約目標値 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_ChkTargetTkMokuhyouti ADD CONSTRAINT PK_ChkTargetTkMokuhyouti PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至 */
     channelcd                                                , /* チャネルコード */
     targettkmokuhyouti                                         /* ターゲット特約目標値 */
) ;
