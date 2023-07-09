CREATE TABLE BM_KanjyouKamoku_Z (
     kanjyoukmkcd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* 勘定科目コード */
     denkanjokamokucd                                   VARCHAR     (5)                                                                 ,  /* 伝票用勘定科目コード */
     kanjyoukmknm                                       VARCHAR     (42)                                                                ,  /* 勘定科目名 */
     jigyouhiutiwakecd                                  VARCHAR     (7)                                                                 ,  /* 事業費内訳コード */
     jigyouhiutiwakenm                                  VARCHAR     (42)                                                                ,  /* 事業費内訳名 */
     hjybyouhyj                                         VARCHAR     (1)                                                                 ,  /* 補助簿要表示 */
     hjybtantositucd                                    VARCHAR     (3)                                                                 ,  /* 補助簿統括担当室コード */
     kanjyoukmkgroupkbn                                 VARCHAR     (1)                                                                 ,  /* 勘定科目グループ区分 */
     kbnkeiriyouhi                                      VARCHAR     (1)                                                                 ,  /* 区分経理要否 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     hjybruigkteiseiumukbn                              VARCHAR     (1)                                                                    /* 補助簿累計額訂正有無区分 */
)
;

ALTER TABLE BM_KanjyouKamoku_Z ADD CONSTRAINT PK_KanjyouKamoku PRIMARY KEY (
     kanjyoukmkcd                                               /* 勘定科目コード */
) ;
