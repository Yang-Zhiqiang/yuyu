CREATE TABLE HT_BosKouzaJyouhou (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     kzkykdoukbn                                        VARCHAR     (1)                                                                 ,  /* 口座名義契約者同一人区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kouzakakuniniraikbn                                VARCHAR     (1)                                                                 ,  /* 口座確認依頼区分 */
     kzhuritourokuhoukbn                                VARCHAR     (1)                                                                 ,  /* 口座振替登録方法区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_BosKouzaJyouhou ADD CONSTRAINT PK_BosKouzaJyouhou PRIMARY KEY (
     mosno                                                      /* 申込番号 */
) ;
