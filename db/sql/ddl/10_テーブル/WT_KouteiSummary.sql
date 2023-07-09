CREATE TABLE WT_KouteiSummary (
     gyoumuKey                                          VARCHAR     (20)                                                      NOT NULL  ,  /* 業務キー */
     flowId                                             VARCHAR     (19)                                                                ,  /* フローＩＤ */
     lastSyoriTime                                      VARCHAR     (17)                                                                ,  /* 最終処理時間 */
     syokaiAccountId                                    VARCHAR     (30)                                                                ,  /* 初回アカウントＩＤ */
     zenkaiAccountId                                    VARCHAR     (30)                                                                ,  /* 前回アカウントＩＤ */
     zenkaiNodeNm                                       VARCHAR     (50)                                                                ,  /* 前回ノード名 */
     zenkaiTaskLocalNm                                  VARCHAR     (50)                                                                ,  /* 前回タスクローカル名 */
     nodeNm                                             VARCHAR     (50)                                                                ,  /* ノード名 */
     genzaiAccountId                                    VARCHAR     (30)                                                                ,  /* 現在アカウントＩＤ */
     genzaiTaskLocalNm                                  VARCHAR     (50)                                                                ,  /* 現在タスクローカル名 */
     iwfKouteiKaisiYmd                                  VARCHAR     (8)                                                                 ,  /* IWF工程開始日 */
     kouteiKanryouYmd                                   VARCHAR     (8)                                                                 ,  /* 工程完了日 */
     syoriStatus                                        VARCHAR     (4)                                                                 ,  /* 処理状態 */
     extParam1                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ１ */
     extParam2                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ２ */
     extParam3                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ３ */
     extParam4                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ４ */
     extParam5                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ５ */
     extParam6                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ６ */
     extParam7                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ７ */
     extParam8                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ８ */
     extParam9                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ９ */
     extParam10                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１０ */
     extParam11                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１１ */
     extParam12                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１２ */
     extParam13                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１３ */
     extParam14                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１４ */
     extParam15                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１５ */
     extParam16                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１６ */
     extParam17                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１７ */
     extParam18                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１８ */
     extParam19                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１９ */
     extParam20                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ２０ */
     extParam21                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ２１ */
     extParam22                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ２２ */
     extParam23                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ２３ */
     extParam24                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ２４ */
     extParam25                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ２５ */
     extParam26                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ２６ */
     extParam27                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ２７ */
     extParam28                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ２８ */
     extParam29                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ２９ */
     extParam30                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ３０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE WT_KouteiSummary ADD CONSTRAINT PK_KouteiSummary PRIMARY KEY (
     gyoumuKey                                                  /* 業務キー */
) ;

CREATE INDEX WT_KouteiSummaryIdx1 ON WT_KouteiSummary (
     syoriStatus                                              , /* 処理状態 */
     gyoumuKey                                                  /* 業務キー */
) ;

CREATE INDEX WT_KouteiSummaryIdx2 ON WT_KouteiSummary (
     flowId                                                   , /* フローＩＤ */
     genzaiAccountId                                            /* 現在アカウントＩＤ */
) ;

CREATE INDEX WT_KouteiSummaryIdx3 ON WT_KouteiSummary (
     extParam12                                                 /* 拡張パラメータ１２ */
) ;

CREATE INDEX WT_KouteiSummaryIdx4 ON WT_KouteiSummary (
     extParam13                                                 /* 拡張パラメータ１３ */
) ;

CREATE INDEX WT_KouteiSummaryIdx5 ON WT_KouteiSummary (
     extParam14                                                 /* 拡張パラメータ１４ */
) ;

CREATE INDEX WT_KouteiSummaryIdx6 ON WT_KouteiSummary (
     flowId                                                   , /* フローＩＤ */
     nodeNm                                                   , /* ノード名 */
     extParam10                                                 /* 拡張パラメータ１０ */
) ;

CREATE INDEX WT_KouteiSummaryIdx7 ON WT_KouteiSummary (
     flowId                                                   , /* フローＩＤ */
     nodeNm                                                   , /* ノード名 */
     extParam11                                                 /* 拡張パラメータ１１ */
) ;

CREATE INDEX WT_KouteiSummaryIdx8 ON WT_KouteiSummary (
     flowId                                                   , /* フローＩＤ */
     kouteiKanryouYmd                                           /* 工程完了日 */
) ;

CREATE INDEX WT_KouteiSummaryIdx9 ON WT_KouteiSummary (
     flowId                                                   , /* フローＩＤ */
     extParam11                                                 /* 拡張パラメータ１１ */
) ;

CREATE INDEX WT_KouteiSummaryIdx10 ON WT_KouteiSummary (
     flowId                                                   , /* フローＩＤ */
     lastSyoriTime                                              /* 最終処理時間 */
) ;
