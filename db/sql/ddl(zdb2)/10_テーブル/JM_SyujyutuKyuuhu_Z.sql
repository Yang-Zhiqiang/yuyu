CREATE TABLE JM_SyujyutuKyuuhu_Z (
     syujyutubunruicd                                   VARCHAR     (3)                                                       NOT NULL  ,  /* 手術分類コード */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         DECIMAL     (2)                                                       NOT NULL  ,  /* 商品世代番号 */
     kyuuhucd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 給付コード */
     syujyututekiyoukkanfrom                            VARCHAR     (8)                                                       NOT NULL  ,  /* 手術適用期間（自） */
     syujyututekiyoukkanto                              VARCHAR     (8)                                                       NOT NULL  ,  /* 手術適用期間（至） */
     syujyutukyhbairitu                                 DECIMAL     (3)                                                                 ,  /* 手術給付倍率 */
     kyuuhugendokikan                                   DECIMAL     (3)                                                                 ,  /* 給付限度期間 */
     syujyutusyurui                                     VARCHAR     (102)                                                               ,  /* 手術種類 */
     tokusyusyujyutukbn                                 VARCHAR     (1)                                                                 ,  /* 特殊手術区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JM_SyujyutuKyuuhu_Z ADD CONSTRAINT PK_SyujyutuKyuuhu PRIMARY KEY (
     syujyutubunruicd                                         , /* 手術分類コード */
     syouhncd                                                 , /* 商品コード */
     syouhnsdno                                               , /* 商品世代番号 */
     kyuuhucd                                                 , /* 給付コード */
     syujyututekiyoukkanfrom                                  , /* 手術適用期間（自） */
     syujyututekiyoukkanto                                      /* 手術適用期間（至） */
) ;
