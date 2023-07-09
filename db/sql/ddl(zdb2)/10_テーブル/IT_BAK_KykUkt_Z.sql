CREATE TABLE IT_BAK_KykUkt_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     uktsyukbn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 受取人種類区分 */
     uktsyurenno                                        DECIMAL     (2)                                                       NOT NULL  ,  /* 受取人種類別連番 */
     kokno                                              VARCHAR     (10)                                                                ,  /* 顧客番号 */
     uktkbn                                             VARCHAR     (2)                                                                 ,  /* 受取人区分 */
     uktnmkn                                            VARCHAR     (38)                                                                ,  /* 受取人名（カナ） */
     uktnmkj                                            VARCHAR     (32)                                                                ,  /* 受取人名（漢字） */
     uktnmkjkhukakbn                                    VARCHAR     (1)                                                                 ,  /* 受取人名漢字化不可区分 */
     uktseiymd                                          VARCHAR     (8)                                                                 ,  /* 受取人生年月日 */
     ukttdk                                             VARCHAR     (2)                                                                 ,  /* 受取人続柄 */
     uktbnwari                                          DECIMAL     (3)                                                                 ,  /* 受取人分割割合 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_BAK_KykUkt_Z ADD CONSTRAINT PK_BAK_KykUkt PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     uktsyukbn                                                , /* 受取人種類区分 */
     uktsyurenno                                                /* 受取人種類別連番 */
) ;
