CREATE TABLE DT_WfSentakujyotaiHozon (
     userId                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ユーザーＩＤ */
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ */
     jimutetuzukicd                                     VARCHAR     (19)                                                                ,  /* 事務手続コード */
     skeiJimuKbnHzn                                     VARCHAR     (500)                                                               ,  /* 新契約事務区分＿保存用 */
     mosUketukeKbnHzn                                   VARCHAR     (500)                                                               ,  /* 申込受付区分＿保存用 */
     hokensyuruinohozon                                 VARCHAR     (500)                                                               ,  /* 保険種類番号＿保存用 */
     dairitencd1                                        VARCHAR     (7)                                                                 ,  /* 代理店コード１ */
     dairitencd2                                        VARCHAR     (7)                                                                 ,  /* 代理店コード２ */
     drtencd3                                           VARCHAR     (7)                                                                 ,  /* 代理店コード３ */
     drtencd4                                           VARCHAR     (7)                                                                 ,  /* 代理店コード４ */
     drtencd5                                           VARCHAR     (7)                                                                 ,  /* 代理店コード５ */
     koDairitenTaisyouKbn                               CHAR        (1)                                                                 ,  /* 子代理店対象区分 */
     jimuyoucd                                          VARCHAR     (3)                                                                 ,  /* 事務用コード */
     jmycdMisetteiKbn                                   CHAR        (1)                                                                 ,  /* 事務用コード未設定区分 */
     djmskmKeiyakuKbn                                   CHAR        (1)                                                                 ,  /* 同時申込契約区分 */
     mosYmdFrom                                         VARCHAR     (8)                                                                 ,  /* 申込年月日（自） */
     mosYmdTo                                           VARCHAR     (8)                                                                 ,  /* 申込年月日（至） */
     jimustartYmdFrom                                   VARCHAR     (8)                                                                 ,  /* 事務開始年月日（自） */
     jimustartYmdTo                                     VARCHAR     (8)                                                                 ,  /* 事務開始年月日（至） */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     nksysyno                                           VARCHAR     (20)                                                                ,  /* 年金証書番号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE DT_WfSentakujyotaiHozon ADD CONSTRAINT DT_WfSentakujyotaiHozonPk PRIMARY KEY (
     userId                                                   , /* ユーザーＩＤ */
     subSystemId                                                /* サブシステムＩＤ */
) ;
