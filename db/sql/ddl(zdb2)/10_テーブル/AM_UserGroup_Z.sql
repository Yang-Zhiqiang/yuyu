CREATE TABLE AM_UserGroup_Z (
     userGroupCd                                        VARCHAR     (30)                                                      NOT NULL  ,  /* ユーザーグループコード */
     userGroupNm                                        VARCHAR     (62)                                                                ,  /* ユーザーグループ名 */
     userGroupSetumei                                   VARCHAR     (202)                                                               ,  /* ユーザーグループ説明 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AM_UserGroup_Z ADD CONSTRAINT AM_UserGroupPk PRIMARY KEY (
     userGroupCd                                                /* ユーザーグループコード */
) ;
