CREATE TABLE HT_SkLincTourokuInfo_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     kanyuusyano                                        DECIMAL     (12)                                                                ,  /* 加入者番号 */
     hhknnmkn                                           VARCHAR     (38)                                                                ,  /* 被保険者名（カナ） */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     hhknseiymd                                         VARCHAR     (8)                                                                 ,  /* 被保険者生年月日 */
     hhknadrlinckn                                      VARCHAR     (76)                                                                ,  /* 被保険者住所（ＬＩＮＣ用カナ） */
     kykkbn                                             VARCHAR     (2)                                                                 ,  /* 契約者区分 */
     kyknmkn                                            VARCHAR     (38)                                                                ,  /* 契約者名（カナ） */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     kyksei                                             VARCHAR     (1)                                                                 ,  /* 契約者性別 */
     kykseiymd                                          VARCHAR     (8)                                                                 ,  /* 契約者生年月日 */
     kykadrlinckn                                       VARCHAR     (76)                                                                ,  /* 契約者住所（ＬＩＮＣ用カナ） */
     trkmousideymd                                      VARCHAR     (8)                                                                 ,  /* 登録申出年月日 */
     kykytymd                                           VARCHAR     (8)                                                                 ,  /* 契約予定年月日 */
     sgnyung                                            DECIMAL     (13)                                                                ,  /* 災害入院給付金日額 */
     sgnyung$                                           VARCHAR     (10)                                                                ,  /* 災害入院給付金日額(通貨型) */
     sipnyung                                           DECIMAL     (13)                                                                ,  /* 疾病入院給付金日額 */
     sipnyung$                                          VARCHAR     (10)                                                                ,  /* 疾病入院給付金日額(通貨型) */
     sjnyung                                            DECIMAL     (13)                                                                ,  /* 成人病入院給付金日額 */
     sjnyung$                                           VARCHAR     (10)                                                                ,  /* 成人病入院給付金日額(通貨型) */
     sonotanyuinng                                      DECIMAL     (13)                                                                ,  /* その他入院給付金日額 */
     sonotanyuinng$                                     VARCHAR     (10)                                                                ,  /* その他入院給付金日額(通貨型) */
     hutuusb                                            DECIMAL     (13)                                                                ,  /* 普通死亡保険金額 */
     hutuusb$                                           VARCHAR     (10)                                                                ,  /* 普通死亡保険金額(通貨型) */
     sgsbksns                                           DECIMAL     (13)                                                                ,  /* 災害死亡時加算保険金額 */
     sgsbksns$                                          VARCHAR     (10)                                                                ,  /* 災害死亡時加算保険金額(通貨型) */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_SkLincTourokuInfo_Z ADD CONSTRAINT PK_SkLincTourokuInfo PRIMARY KEY (
     mosno                                                      /* 申込番号 */
) ;
