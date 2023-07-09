CREATE TABLE BM_TokujyouSakugenRate_Z (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         DECIMAL     (2)                                                       NOT NULL  ,  /* 商品世代番号 */
     tkjyskgnkkn                                        VARCHAR     (2)                                                       NOT NULL  ,  /* 特条削減期間 */
     dai1hknnndskgnsrate                                DECIMAL     (3,2)                                                               ,  /* 第１保険年度削減支払割合 */
     dai2hknnndskgnsrate                                DECIMAL     (3,2)                                                               ,  /* 第２保険年度削減支払割合 */
     dai3hknnndskgnsrate                                DECIMAL     (3,2)                                                               ,  /* 第３保険年度削減支払割合 */
     dai4hknnndskgnsrate                                DECIMAL     (3,2)                                                               ,  /* 第４保険年度削減支払割合 */
     dai5hknnndskgnsrate                                DECIMAL     (3,2)                                                               ,  /* 第５保険年度削減支払割合 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_TokujyouSakugenRate_Z ADD CONSTRAINT PK_TokujyouSakugenRate PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     syouhnsdno                                               , /* 商品世代番号 */
     tkjyskgnkkn                                                /* 特条削減期間 */
) ;
