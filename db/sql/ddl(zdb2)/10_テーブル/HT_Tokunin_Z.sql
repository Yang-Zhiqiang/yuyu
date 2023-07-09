CREATE TABLE HT_Tokunin_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     spgndtknkbn                                        VARCHAR     (1)                                                                 ,  /* ＳＰ限度特認区分 */
     nenkkntknkbn                                       VARCHAR     (1)                                                                 ,  /* 年齢期間特認区分 */
     tsngndtknkbn                                       VARCHAR     (1)                                                                 ,  /* 通算限度特認区分 */
     sentakuinfotknkbn                                  VARCHAR     (1)                                                                 ,  /* 選択情報特認区分 */
     syorisimetknkbn                                    VARCHAR     (1)                                                                 ,  /* 処理締切日特認区分 */
     kzmeigitknkbn                                      VARCHAR     (1)                                                                 ,  /* 口座名義人特認区分 */
     massitknkbn                                        VARCHAR     (1)                                                                 ,  /* 末子特認区分 */
     kakoymdkyytknkbn                                   VARCHAR     (1)                                                                 ,  /* 過去日付許容特認区分 */
     saiteiptknkbn                                      VARCHAR     (1)                                                                 ,  /* 最低P特認区分 */
     yoteiriritutknkbn                                  VARCHAR     (1)                                                                 ,  /* 予定利率特認区分 */
     nenreiuptknkbn                                     VARCHAR     (1)                                                                 ,  /* 年齢アップ特認区分 */
     signalkaihikbn                                     VARCHAR     (1)                                                                 ,  /* シグナル回避区分 */
     sonotatknkbn                                       VARCHAR     (1)                                                                 ,  /* その他特認区分 */
     ketsyacd                                           VARCHAR     (15)                                                                ,  /* 決定者コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     ikkatuyouptknkbn                                   VARCHAR     (1)                                                                    /* 一括要Ｐ特認区分 */
)
;

ALTER TABLE HT_Tokunin_Z ADD CONSTRAINT PK_Tokunin PRIMARY KEY (
     mosno                                                      /* 申込番号 */
) ;
