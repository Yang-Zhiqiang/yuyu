CREATE TABLE BT_KijituTouraiHonbanKensyou_Z (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ */
     tysytno                                            DECIMAL     (3)                                                       NOT NULL  ,  /* 抽出番号 */
     datakanrino                                        VARCHAR     (20)                                                      NOT NULL  ,  /* データ管理番号 */
     tysytnaiyou1                                       VARCHAR     (125)                                                               ,  /* 抽出内容１ */
     tysytnaiyou2                                       VARCHAR     (125)                                                               ,  /* 抽出内容２ */
     tysytnaiyou3                                       VARCHAR     (125)                                                               ,  /* 抽出内容３ */
     tysytnaiyou4                                       VARCHAR     (125)                                                               ,  /* 抽出内容４ */
     tysytnaiyou5                                       VARCHAR     (125)                                                               ,  /* 抽出内容５ */
     tysytnaiyou6                                       VARCHAR     (125)                                                               ,  /* 抽出内容６ */
     tysytnaiyou7                                       VARCHAR     (125)                                                               ,  /* 抽出内容７ */
     tysytnaiyou8                                       VARCHAR     (125)                                                               ,  /* 抽出内容８ */
     tysytnaiyou9                                       VARCHAR     (125)                                                               ,  /* 抽出内容９ */
     tysytnaiyou10                                      VARCHAR     (125)                                                               ,  /* 抽出内容１０ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_KijituTouraiHonbanKensyou_Z ADD CONSTRAINT PK_KijituTouraiHonbanKensyou PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     subSystemId                                              , /* サブシステムＩＤ */
     tysytno                                                  , /* 抽出番号 */
     datakanrino                                                /* データ管理番号 */
) ;
