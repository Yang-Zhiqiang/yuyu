CREATE TABLE IT_KhAuthoriKekData_Z (
     ansyuusyskbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 案内収納用システム区分 */
     authorikkdatarenno                                 VARCHAR     (20)                                                      NOT NULL  ,  /* オーソリ結果データ連番 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     authorikanryoymd                                   VARCHAR     (8)                                                                 ,  /* オーソリ完了日 */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１ */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２ */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３ */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４ */
     creditcardykkigen                                  VARCHAR     (32)                                                                ,  /* クレジットカード有効期限 */
     authoritrkkbn                                      VARCHAR     (1)                                                                 ,  /* オーソリ登録区分 */
     torihikicd                                         VARCHAR     (1)                                                                 ,  /* 取引コード */
     authorigk                                          DECIMAL     (13)                                                                ,  /* オーソリ金額 */
     authorigk$                                         VARCHAR     (10)                                                                ,  /* オーソリ金額(通貨型) */
     syouninno                                          VARCHAR     (6)                                                                 ,  /* 承認番号 */
     tanmatusyorino                                     VARCHAR     (7)                                                                 ,  /* 端末処理通番 */
     authorijkkbn                                       VARCHAR     (1)                                                                 ,  /* オーソリ状況区分 */
     creditbrerrorcd                                    VARCHAR     (3)                                                                 ,  /* クレジット払エラーコード */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     authorikaisuu                                      DECIMAL     (2)                                                                 ,  /* オーソリ回数 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KhAuthoriKekData_Z ADD CONSTRAINT PK_KhAuthoriKekData PRIMARY KEY (
     ansyuusyskbn                                             , /* 案内収納用システム区分 */
     authorikkdatarenno                                         /* オーソリ結果データ連番 */
) ;

CREATE INDEX IX1_KhAuthoriKekData ON IT_KhAuthoriKekData_Z (
     syoriYmd                                                   /* 処理年月日 */
) ;
