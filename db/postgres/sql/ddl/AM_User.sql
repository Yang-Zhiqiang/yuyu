CREATE TABLE AM_User (
     userId                                             varchar     (30)                                                      NOT NULL  ,  /* ユーザーID                                        */
     userNm                                             varchar     (30)                                                                ,  /* ユーザー名                                         */
     specialUserKbn                                     varchar     (1)                                                                 ,  /* 特別ユーザー区分                                      */
     password                                           varchar     (128)                                                               ,  /* パスワード                                         */
     passwordSetteiYmd                                  varchar     (8)                                                                 ,  /* パスワード設定年月日                                    */
     passwordYuukouKigenYmd                             varchar     (8)                                                                 ,  /* パスワード有効期限年月日                                  */
     passwordYuukouCountY                               decimal     (2)                                                                 ,  /* パスワード有効年数                                     */
     passwordYuukouCountM                               decimal     (2)                                                                 ,  /* パスワード有効月数                                     */
     passwordYuukouCountD                               decimal     (2)                                                                 ,  /* パスワード有効日数                                     */
     passwordYuukouKikanKbn                             varchar     (1)                                                                 ,  /* パスワード有効期間区分                                   */
     passwordHenkouKyokaKbn                             varchar     (1)                                                                 ,  /* パスワード変更許可区分                                   */
     passwordHenkouYoukyuuKbn                           varchar     (1)                                                                 ,  /* パスワード変更要求区分                                   */
     loginKyokaKbn                                      varchar     (1)                                                                 ,  /* ログイン許可区分                                      */
     loginErrorCount                                    decimal     (2)                                                                 ,  /* ログインエラー回数                                     */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AM_User ADD CONSTRAINT AM_UserPk PRIMARY KEY (
     userId                                                     /* ユーザーID                                         */
) ;
