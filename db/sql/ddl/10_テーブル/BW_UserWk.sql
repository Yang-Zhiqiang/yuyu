CREATE TABLE BW_UserWk (
     userId                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ユーザーＩＤ                                        */
     userNm                                             VARCHAR     (15)                                                      NOT NULL  ,  /* ユーザー名                                         */
     userGroupCd                                        VARCHAR     (30)                                                                ,  /* ユーザーグループコード                                   */
     specialUserKbn                                     VARCHAR     (1)                                                                 ,  /* 特別ユーザー区分                                      */
     password                                           VARCHAR     (128)                                                               ,  /* パスワード                                         */
     passwordSetteiYmd                                  VARCHAR     (8)                                                                 ,  /* パスワード設定年月日                                    */
     passwordYuukouKigenYmd                             VARCHAR     (8)                                                                 ,  /* パスワード有効期限年月日                                  */
     passwordYuukouCountY                               NUMBER      (2)                                                                 ,  /* パスワード有効年数                                     */
     passwordYuukouCountM                               NUMBER      (2)                                                                 ,  /* パスワード有効月数                                     */
     passwordYuukouCountD                               NUMBER      (2)                                                                 ,  /* パスワード有効日数                                     */
     passwordYuukouKikanKbn                             VARCHAR     (1)                                                                 ,  /* パスワード有効期間区分                                   */
     passwordHenkouKyokaKbn                             VARCHAR     (1)                                                                 ,  /* パスワード変更許可区分                                   */
     passwordHenkouYoukyuuKbn                           VARCHAR     (1)                                                                 ,  /* パスワード変更要求区分                                   */
     loginKyokaKbn                                      VARCHAR     (1)                                                                 ,  /* ログイン許可区分                                      */
     loginErrorCount                                    NUMBER      (2)                                                                 ,  /* ログインエラー回数                                     */
     lastLoginTime                                      VARCHAR     (17)                                                                ,  /* 最終ログイン時間                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BW_UserWk ADD CONSTRAINT PK_UserWk PRIMARY KEY (
     userId                                                     /* ユーザーＩＤ                                         */
) ;
