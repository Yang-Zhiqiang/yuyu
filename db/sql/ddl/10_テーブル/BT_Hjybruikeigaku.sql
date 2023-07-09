CREATE TABLE BT_Hjybruikeigaku (
     hjybtantositucd                                    VARCHAR     (3)                                                       NOT NULL  ,  /* 補助簿統括担当室コード */
     kanjyoukmkcd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* 勘定科目コード */
     denym                                              VARCHAR     (6)                                                       NOT NULL  ,  /* 伝票年月 */
     karikatakmkkeigk                                   NUMBER      (13)                                                                ,  /* 借方科目合計額 */
     karikatakmkkeigk$                                  VARCHAR     (10)                                                                ,  /* 借方科目合計額(通貨型) */
     kasikatakmkkeigk                                   NUMBER      (13)                                                                ,  /* 貸方科目合計額 */
     kasikatakmkkeigk$                                  VARCHAR     (10)                                                                ,  /* 貸方科目合計額(通貨型) */
     karikataruigk                                      NUMBER      (13)                                                                ,  /* 借方年間累計額 */
     karikataruigk$                                     VARCHAR     (10)                                                                ,  /* 借方年間累計額(通貨型) */
     kasikataruigk                                      NUMBER      (13)                                                                ,  /* 貸方年間累計額 */
     kasikataruigk$                                     VARCHAR     (10)                                                                ,  /* 貸方年間累計額(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_Hjybruikeigaku ADD CONSTRAINT PK_Hjybruikeigaku PRIMARY KEY (
     hjybtantositucd                                          , /* 補助簿統括担当室コード */
     kanjyoukmkcd                                             , /* 勘定科目コード */
     denym                                                      /* 伝票年月 */
) ;
