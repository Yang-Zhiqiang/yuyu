CREATE TABLE HT_SkSyuunouKekkaData_Z (
     ansyuusyskbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 案内収納用システム区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     jyuutouym                                          VARCHAR     (6)                                                       NOT NULL  ,  /* 充当年月 */
     jyutoukaisuuy                                      DECIMAL     (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      DECIMAL     (2)                                                                 ,  /* 充当回数（月） */
     rsgaku                                             DECIMAL     (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     hurikaeymd                                         VARCHAR     (8)                                                                 ,  /* 振替日 */
     syuudaikocd                                        VARCHAR     (2)                                                                 ,  /* 収納代行社コード */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (62)                                                                ,  /* 口座名義人氏名（カナ） */
     hurihunokbn                                        VARCHAR     (1)                                                                 ,  /* 振替不能理由区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_SkSyuunouKekkaData_Z ADD CONSTRAINT PK_SkSyuunouKekkaData PRIMARY KEY (
     ansyuusyskbn                                             , /* 案内収納用システム区分 */
     syoriYmd                                                 , /* 処理年月日 */
     mosno                                                    , /* 申込番号 */
     jyuutouym                                                  /* 充当年月 */
) ;
