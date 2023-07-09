CREATE TABLE IT_KykSya_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kokno                                              VARCHAR     (10)                                                                ,  /* 顧客番号 */
     kyksakuinmeino                                     VARCHAR     (10)                                                                ,  /* 契約者索引名番号 */
     kyknmkn                                            VARCHAR     (38)                                                                ,  /* 契約者名（カナ） */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     kyknmkjkhukakbn                                    VARCHAR     (1)                                                                 ,  /* 契約者名漢字化不可区分 */
     kykseiymd                                          VARCHAR     (8)                                                                 ,  /* 契約者生年月日 */
     kyksei                                             VARCHAR     (1)                                                                 ,  /* 契約者性別 */
     kkkyktdk                                           VARCHAR     (2)                                                                 ,  /* 契約管理契約者続柄 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kn                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（カナ） */
     tsinadr1kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kn                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（カナ） */
     tsinadr2kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kn                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（カナ） */
     tsinadr3kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（漢字） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     dai2tsintelno                                      VARCHAR     (14)                                                                ,  /* 第２通信先電話番号 */
     tsinmailaddress                                    VARCHAR     (40)                                                                ,  /* 通信先メールアドレス */
     kinmusakinm                                        VARCHAR     (52)                                                                ,  /* 勤務先名 */
     hjndaiykkbn                                        VARCHAR     (2)                                                                 ,  /* 法人代表者役職区分 */
     hjndaiyknm                                         VARCHAR     (62)                                                                ,  /* 法人代表者役職名 */
     hjndainmkn                                         VARCHAR     (62)                                                                ,  /* 法人代表者名（カナ） */
     hjndainmkj                                         VARCHAR     (62)                                                                ,  /* 法人代表者名（漢字） */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KykSya_Z ADD CONSTRAINT PK_KykSya PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_KykSya ON IT_KykSya_Z (
     kyknmkn                                                    /* 契約者名（カナ） */
) ;

CREATE INDEX IX2_KykSya ON IT_KykSya_Z (
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX3_KykSya ON IT_KykSya_Z (
     kykseiymd                                                  /* 契約者生年月日 */
) ;

CREATE INDEX IX4_KykSya ON IT_KykSya_Z (
     tsinyno                                                    /* 通信先郵便番号 */
) ;

CREATE INDEX IX5_KykSya ON IT_KykSya_Z (
     tsintelno                                                  /* 通信先電話番号 */
) ;
