CREATE TABLE JM_SiinHantei_Z (
     siboukariuketukejigeninkbn                         VARCHAR     (2)                                                       NOT NULL  ,  /* 死亡仮受付時原因区分 */
     seikyuuuketukejigeninkbn                           VARCHAR     (2)                                                       NOT NULL  ,  /* 請求受付時原因区分 */
     kansensyouumukbn                                   VARCHAR     (1)                                                       NOT NULL  ,  /* 感染症有無区分 */
     saigaikanouseiumukbn                               VARCHAR     (1)                                                       NOT NULL  ,  /* 災害可能性有無区分 */
     husyounosiumukbn                                   VARCHAR     (1)                                                       NOT NULL  ,  /* 不詳の死有無区分 */
     sateikaksaigaikanouseikbn                          VARCHAR     (1)                                                       NOT NULL  ,  /* 査定回送要否確認（災害可能性）区分 */
     sateikakhusyousikbn                                VARCHAR     (1)                                                       NOT NULL  ,  /* 査定回送要否確認（不詳の死）区分 */
     siinkbn                                            VARCHAR     (1)                                                                 ,  /* 死因区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JM_SiinHantei_Z ADD CONSTRAINT PK_SiinHantei PRIMARY KEY (
     siboukariuketukejigeninkbn                               , /* 死亡仮受付時原因区分 */
     seikyuuuketukejigeninkbn                                 , /* 請求受付時原因区分 */
     kansensyouumukbn                                         , /* 感染症有無区分 */
     saigaikanouseiumukbn                                     , /* 災害可能性有無区分 */
     husyounosiumukbn                                         , /* 不詳の死有無区分 */
     sateikaksaigaikanouseikbn                                , /* 査定回送要否確認（災害可能性）区分 */
     sateikakhusyousikbn                                        /* 査定回送要否確認（不詳の死）区分 */
) ;
