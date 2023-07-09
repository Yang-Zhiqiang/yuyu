CREATE TABLE JM_Byoumei_Z (
     byoumeitourokuno                                   VARCHAR     (6)                                                       NOT NULL  ,  /* 病名登録番号 */
     byoumeikj                                          VARCHAR     (202)                                                               ,  /* 病名（漢字） */
     byoumeizenkaku                                     VARCHAR     (202)                                                               ,  /* 病名全角 */
     byoumeikn                                          VARCHAR     (122)                                                               ,  /* 病名（カナ） */
     byoumeiknkensaku                                   VARCHAR     (122)                                                               ,  /* 病名（カナ）検索用 */
     byoumeicd                                          VARCHAR     (4)                                                                 ,  /* 病名コード */
     gaitoukbn1                                         VARCHAR     (1)                                                                 ,  /* 該当区分１ */
     gaitoukbn2                                         VARCHAR     (1)                                                                 ,  /* 該当区分２ */
     gaitoukbn3                                         VARCHAR     (1)                                                                 ,  /* 該当区分３ */
     gaitoukbn4                                         VARCHAR     (1)                                                                 ,  /* 該当区分４ */
     gaitoukbn5                                         VARCHAR     (1)                                                                 ,  /* 該当区分５ */
     tyuuimongon                                        VARCHAR     (72)                                                                ,  /* 注意文言 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JM_Byoumei_Z ADD CONSTRAINT PK_Byoumei PRIMARY KEY (
     byoumeitourokuno                                           /* 病名登録番号 */
) ;
