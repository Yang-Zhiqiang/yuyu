CREATE TABLE AM_UserGroup (
     userGroupCd                                        VARCHAR     (30)                                                      NOT NULL  ,  /* ユーザーグループコード */
     userGroupNm                                        VARCHAR     (30)                                                                ,  /* ユーザーグループ名 */
     userGroupSetumei                                   VARCHAR     (100)                                                               ,  /* ユーザーグループ説明 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE AM_UserGroup ADD CONSTRAINT AM_UserGroupPk PRIMARY KEY (
     userGroupCd                                                /* ユーザーグループコード */
) ;
