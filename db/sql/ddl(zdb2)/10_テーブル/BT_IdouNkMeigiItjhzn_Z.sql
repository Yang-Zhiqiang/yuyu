CREATE TABLE BT_IdouNkMeigiItjhzn_Z (
     nksysyno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 年金証書番号 */
     renno3keta                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     hhknnmkn                                           VARCHAR     (38)                                                                ,  /* 被保険者名（カナ） */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     hhknseiymd                                         VARCHAR     (8)                                                                 ,  /* 被保険者生年月日 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     hhknyno                                            VARCHAR     (7)                                                                 ,  /* 被保険者郵便番号 */
     hhknadr1kj                                         VARCHAR     (62)                                                                ,  /* 被保険者住所１（漢字） */
     hhknadr2kj                                         VARCHAR     (62)                                                                ,  /* 被保険者住所２（漢字） */
     hhknadr3kj                                         VARCHAR     (62)                                                                ,  /* 被保険者住所３（漢字） */
     hhkntelno                                          VARCHAR     (14)                                                                ,  /* 被保険者電話番号 */
     hhknsykgycd                                        VARCHAR     (3)                                                                 ,  /* 被保険者職業コード */
     nenkinuktnmkana                                    VARCHAR     (38)                                                                ,  /* 年金受取人名（カナ） */
     nenkinuktnmkanji                                   VARCHAR     (32)                                                                ,  /* 年金受取人名（漢字） */
     nenkinuktseiymd                                    VARCHAR     (8)                                                                 ,  /* 年金受取人生年月日 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（漢字） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     stdrsknmkn                                         VARCHAR     (38)                                                                ,  /* 指定代理請求人名（カナ） */
     stdrsknmkj                                         VARCHAR     (32)                                                                ,  /* 指定代理請求人名（漢字） */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_IdouNkMeigiItjhzn_Z ADD CONSTRAINT PK_IdouNkMeigiItjhzn PRIMARY KEY (
     nksysyno                                                 , /* 年金証書番号 */
     renno3keta                                                 /* 連番（３桁） */
) ;
