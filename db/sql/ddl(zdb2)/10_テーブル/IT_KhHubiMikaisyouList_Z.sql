CREATE TABLE IT_KhHubiMikaisyouList_Z (
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     hassinsakikbn                                      VARCHAR     (1)                                                       NOT NULL  ,  /* 発信先区分 */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     sksreadymd                                         VARCHAR     (8)                                                                 ,  /* 請求書読込日 */
     genponhnkykumu                                     VARCHAR     (1)                                                                 ,  /* 原本返却有無 */
     hubitourokuktntnm                                  VARCHAR     (32)                                                                ,  /* 不備登録担当者名 */
     hubisyouninktntnm                                  VARCHAR     (32)                                                                ,  /* 不備承認担当者名 */
     hassinkaisuu                                       DECIMAL     (2)                                                                 ,  /* 発信回数 */
     fsthubbihasinymd                                   VARCHAR     (8)                                                                 ,  /* 初回不備発信日 */
     lasthubbihasinymd                                  VARCHAR     (8)                                                                 ,  /* 最終不備発信日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KhHubiMikaisyouList_Z ADD CONSTRAINT PK_KhHubiMikaisyouList PRIMARY KEY (
     jimutetuzukicd                                           , /* 事務手続コード */
     syono                                                    , /* 証券番号 */
     hassinsakikbn                                              /* 発信先区分 */
) ;
