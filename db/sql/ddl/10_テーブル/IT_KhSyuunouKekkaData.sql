CREATE TABLE IT_KhSyuunouKekkaData (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     ansyuusyskbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 案内収納用システム区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     hurikaeymd                                         VARCHAR     (8)                                                                 ,  /* 振替日 */
     jyuutouym                                          VARCHAR     (6)                                                       NOT NULL  ,  /* 充当年月 */
     rsgaku                                             NUMBER      (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     jyutoukaisuuy                                      NUMBER      (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      NUMBER      (2)                                                                 ,  /* 充当回数（月） */
     dantaikobetukbn                                    VARCHAR     (1)                                                                 ,  /* 団体個別区分 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     kzhurikaetkbtannaihyj                              VARCHAR     (1)                                                                 ,  /* 口座振替特別案内表示 */
     hurihunokbn                                        VARCHAR     (1)                                                                 ,  /* 振替不能理由区分 */
     syuudaikocd                                        VARCHAR     (2)                                                                 ,  /* 収納代行社コード */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhSyuunouKekkaData ADD CONSTRAINT PK_KhSyuunouKekkaData PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     ansyuusyskbn                                             , /* 案内収納用システム区分 */
     syoriYmd                                                 , /* 処理年月日 */
     syono                                                    , /* 証券番号 */
     jyuutouym                                                  /* 充当年月 */
) ;
