CREATE TABLE IT_BAK_TrkKzk_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     trkkzkkbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 登録家族区分 */
     trkkzksetteiymd                                    VARCHAR     (8)                                                                 ,  /* 登録家族設定年月日 */
     trkkzknmkn                                         VARCHAR     (38)                                                                ,  /* 登録家族名（カナ） */
     trkkzknmkj                                         VARCHAR     (32)                                                                ,  /* 登録家族名（漢字） */
     trkkzknmkjkhukakbn                                 VARCHAR     (1)                                                                 ,  /* 登録家族名漢字化不可区分 */
     trkkzkseiymd                                       VARCHAR     (8)                                                                 ,  /* 登録家族生年月日 */
     trkkzksei                                          VARCHAR     (1)                                                                 ,  /* 登録家族性別 */
     trkkzktdk                                          VARCHAR     (2)                                                                 ,  /* 登録家族続柄 */
     trkkzkyno                                          VARCHAR     (7)                                                                 ,  /* 登録家族郵便番号 */
     trkkzkadr1kj                                       VARCHAR     (62)                                                                ,  /* 登録家族住所１（漢字） */
     trkkzkadr2kj                                       VARCHAR     (62)                                                                ,  /* 登録家族住所２（漢字） */
     trkkzkadr3kj                                       VARCHAR     (62)                                                                ,  /* 登録家族住所３（漢字） */
     trkkzktelno                                        VARCHAR     (14)                                                                ,  /* 登録家族電話番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     trkkzktsindousiteikbn                              VARCHAR     (1)                                                                    /* 登録家族通信先同一指定区分 */
)
;

ALTER TABLE IT_BAK_TrkKzk_Z ADD CONSTRAINT PK_BAK_TrkKzk PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     trkkzkkbn                                                  /* 登録家族区分 */
) ;
