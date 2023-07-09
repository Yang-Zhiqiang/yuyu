CREATE TABLE BT_HjybruikeigakuTeisei_Z (
     hjybruigkteiseitantositucd                         VARCHAR     (3)                                                       NOT NULL  ,  /* 補助簿累計額訂正担当室コード */
     kanjyoukmkcd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* 勘定科目コード */
     kasikatateiseigk                                   DECIMAL     (13)                                                                ,  /* 貸方訂正額 */
     kasikatateiseigk$                                  VARCHAR     (10)                                                                ,  /* 貸方訂正額(通貨型) */
     karikatateiseigk                                   DECIMAL     (13)                                                                ,  /* 借方訂正額 */
     karikatateiseigk$                                  VARCHAR     (10)                                                                ,  /* 借方訂正額(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_HjybruikeigakuTeisei_Z ADD CONSTRAINT PK_HjybruikeigakuTeisei PRIMARY KEY (
     hjybruigkteiseitantositucd                               , /* 補助簿累計額訂正担当室コード */
     kanjyoukmkcd                                               /* 勘定科目コード */
) ;
