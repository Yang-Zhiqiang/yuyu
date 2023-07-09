CREATE TABLE IM_ZennouMkkpSampleList_Z (
     zennoutoukeilistkbn                                VARCHAR     (1)                                                       NOT NULL  ,  /* 前納統計リスト区分 */
     zennoukbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 前納区分 */
     kbnkeirisegcd                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 区分経理用セグメントコード */
     znnmkkpkssamplekslsttitle                          VARCHAR     (62)                                                                ,  /* 前納未経過Ｐ検証サンプルリストタイトル */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IM_ZennouMkkpSampleList_Z ADD CONSTRAINT PK_ZennouMkkpSampleList PRIMARY KEY (
     zennoutoukeilistkbn                                      , /* 前納統計リスト区分 */
     zennoukbn                                                , /* 前納区分 */
     kbnkeirisegcd                                              /* 区分経理用セグメントコード */
) ;
