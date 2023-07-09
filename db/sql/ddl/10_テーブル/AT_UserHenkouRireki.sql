CREATE TABLE AT_UserHenkouRireki (
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ                                        */
     userId                                             VARCHAR     (30)                                                                ,  /* ユーザーＩＤ                                        */
     rirekiSyuruiKbn                                    VARCHAR     (1)                                                                 ,  /* 履歴種類区分                                        */
     userNm                                             VARCHAR     (15)                                                                ,  /* ユーザー名                                         */
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
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_UserHenkouRireki ADD CONSTRAINT AT_UserHenkouRirekiPk PRIMARY KEY (
     uniqueId                                                   /* ユニークＩＤ                                         */
) ;

CREATE INDEX AT_UserHenkouRirekiIdx1 ON AT_UserHenkouRireki (
     userId                                                     /* ユーザーＩＤ                                         */
) ;
