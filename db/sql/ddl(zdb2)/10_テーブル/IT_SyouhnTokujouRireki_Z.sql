CREATE TABLE IT_SyouhnTokujouRireki_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     syutkkbn                                           VARCHAR     (1)                                                       NOT NULL  ,  /* 主契約特約区分 */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         DECIMAL     (2)                                                       NOT NULL  ,  /* 商品世代番号 */
     kyksyouhnrenno                                     DECIMAL     (2)                                                       NOT NULL  ,  /* 契約商品連番 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     tkjyhyouten                                        VARCHAR     (3)                                                                 ,  /* 特条標点 */
     tkjyp                                              DECIMAL     (13)                                                                ,  /* 特条保険料 */
     tkjyp$                                             VARCHAR     (10)                                                                ,  /* 特条保険料(通貨型) */
     tkjyskgnkkn                                        VARCHAR     (2)                                                                 ,  /* 特条削減期間 */
     htnpbuicd1                                         VARCHAR     (3)                                                                 ,  /* 不担保部位コード１ */
     htnpkkn1                                           VARCHAR     (2)                                                                 ,  /* 不担保期間１ */
     htnpbuicd2                                         VARCHAR     (3)                                                                 ,  /* 不担保部位コード２ */
     htnpkkn2                                           VARCHAR     (2)                                                                 ,  /* 不担保期間２ */
     htnpbuicd3                                         VARCHAR     (3)                                                                 ,  /* 不担保部位コード３ */
     htnpkkn3                                           VARCHAR     (2)                                                                 ,  /* 不担保期間３ */
     htnpbuicd4                                         VARCHAR     (3)                                                                 ,  /* 不担保部位コード４ */
     htnpkkn4                                           VARCHAR     (2)                                                                 ,  /* 不担保期間４ */
     tokkoudosghtnpkbn                                  VARCHAR     (1)                                                                 ,  /* 特定高度障害不担保区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_SyouhnTokujouRireki_Z ADD CONSTRAINT PK_SyouhnTokujouRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     syutkkbn                                                 , /* 主契約特約区分 */
     syouhncd                                                 , /* 商品コード */
     syouhnsdno                                               , /* 商品世代番号 */
     kyksyouhnrenno                                           , /* 契約商品連番 */
     henkousikibetukey                                          /* 変更識別キー */
) ;

CREATE INDEX IX1_SyouhnTokujouRireki ON IT_SyouhnTokujouRireki_Z (
     syono                                                    , /* 証券番号 */
     syutkkbn                                                 , /* 主契約特約区分 */
     syouhncd                                                 , /* 商品コード */
     syouhnsdno                                               , /* 商品世代番号 */
     kyksyouhnrenno                                           , /* 契約商品連番 */
     henkousikibetukey                                          /* 変更識別キー */
) ;
