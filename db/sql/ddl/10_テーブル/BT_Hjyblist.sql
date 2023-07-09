CREATE TABLE BT_Hjyblist (
     hjybtantositucd                                    VARCHAR     (3)                                                       NOT NULL  ,  /* 補助簿統括担当室コード */
     kanjyoukmkcd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* 勘定科目コード */
     syorisyokantantcd                                  VARCHAR     (3)                                                       NOT NULL  ,  /* 処理所管担当室コード */
     denymd                                             VARCHAR     (8)                                                       NOT NULL  ,  /* 伝票日付 */
     karikatagk                                         NUMBER      (13)                                                                ,  /* 借方金額 */
     karikatagk$                                        VARCHAR     (10)                                                                ,  /* 借方金額(通貨型) */
     kasikatagk                                         NUMBER      (13)                                                                ,  /* 貸方金額 */
     kasikatagk$                                        VARCHAR     (10)                                                                ,  /* 貸方金額(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_Hjyblist ADD CONSTRAINT PK_Hjyblist PRIMARY KEY (
     hjybtantositucd                                          , /* 補助簿統括担当室コード */
     kanjyoukmkcd                                             , /* 勘定科目コード */
     syorisyokantantcd                                        , /* 処理所管担当室コード */
     denymd                                                     /* 伝票日付 */
) ;

CREATE INDEX IX1_Hjyblist ON BT_Hjyblist (
     denymd                                                     /* 伝票日付 */
) ;
