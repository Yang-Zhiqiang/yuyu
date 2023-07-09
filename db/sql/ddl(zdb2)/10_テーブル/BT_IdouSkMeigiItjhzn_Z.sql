CREATE TABLE BT_IdouSkMeigiItjhzn_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
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
     kyknmkn                                            VARCHAR     (38)                                                                ,  /* 契約者名（カナ） */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     kykseiymd                                          VARCHAR     (8)                                                                 ,  /* 契約者生年月日 */
     nenkinuktnmkana                                    VARCHAR     (38)                                                                ,  /* 年金受取人名（カナ） */
     nenkinuktnmkanji                                   VARCHAR     (32)                                                                ,  /* 年金受取人名（漢字） */
     nenkinuktseiymd                                    VARCHAR     (8)                                                                 ,  /* 年金受取人生年月日 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（漢字） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     sbuktnmkn1                                         VARCHAR     (38)                                                                ,  /* 死亡受取人名（カナ）１ */
     sbuktnmkj1                                         VARCHAR     (32)                                                                ,  /* 死亡受取人名（漢字）１ */
     sbuktnmkn2                                         VARCHAR     (38)                                                                ,  /* 死亡受取人名（カナ）２ */
     sbuktnmkj2                                         VARCHAR     (32)                                                                ,  /* 死亡受取人名（漢字）２ */
     sbuktnmkn3                                         VARCHAR     (38)                                                                ,  /* 死亡受取人名（カナ）３ */
     sbuktnmkj3                                         VARCHAR     (32)                                                                ,  /* 死亡受取人名（漢字）３ */
     sbuktnmkn4                                         VARCHAR     (38)                                                                ,  /* 死亡受取人名（カナ）４ */
     sbuktnmkj4                                         VARCHAR     (32)                                                                ,  /* 死亡受取人名（漢字）４ */
     stdrsknmkn                                         VARCHAR     (38)                                                                ,  /* 指定代理請求人名（カナ） */
     stdrsknmkj                                         VARCHAR     (32)                                                                ,  /* 指定代理請求人名（漢字） */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (62)                                                                ,  /* 口座名義人氏名（カナ） */
     kzkykdoukbn                                        VARCHAR     (1)                                                                 ,  /* 口座名義契約者同一人区分 */
     kykdairinmkn                                       VARCHAR     (38)                                                                ,  /* 契約者代理人名（カナ） */
     kykdairinmkj                                       VARCHAR     (32)                                                                ,  /* 契約者代理人名（漢字） */
     kzktourokunmkn1                                    VARCHAR     (38)                                                                ,  /* 家族登録名（カナ）１ */
     kzktourokunmkj1                                    VARCHAR     (32)                                                                ,  /* 家族登録名（漢字）１ */
     kzktourokunmkn2                                    VARCHAR     (38)                                                                ,  /* 家族登録名（カナ）２ */
     kzktourokunmkj2                                    VARCHAR     (32)                                                                   /* 家族登録名（漢字）２ */
)
;

ALTER TABLE BT_IdouSkMeigiItjhzn_Z ADD CONSTRAINT PK_IdouSkMeigiItjhzn PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     renno3keta                                                 /* 連番（３桁） */
) ;
