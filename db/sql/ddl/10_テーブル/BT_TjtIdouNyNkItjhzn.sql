CREATE TABLE BT_TjtIdouNyNkItjhzn (
     nksysyno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 年金証書番号 */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     recordsakujyohyouji                                NUMBER      (1)                                                                 ,  /* レコード削除表示 */
     youkyuuno                                          VARCHAR     (18)                                                                ,  /* 要求通番 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     nkshrstartymd                                      VARCHAR     (8)                                                                 ,  /* 年金支払開始日 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     nksyoumetucd                                       VARCHAR     (2)                                                                 ,  /* 年金消滅コード */
     syoumetuymd                                        VARCHAR     (8)                                                                 ,  /* 消滅日 */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     teinksyu                                           VARCHAR     (4)                                                                 ,  /* 定額年金年金種類 */
     tsnyounkgns                                        NUMBER      (13)                                                                ,  /* 通算用年金原資 */
     tsnyounkgns$                                       VARCHAR     (10)                                                                ,  /* 通算用年金原資(通貨型) */
     nkukthhkndouhyouji                                 NUMBER      (1)                                                                 ,  /* 年金受取人被保険者同一表示 */
     syouhnsdno                                         NUMBER      (2)                                                                 ,  /* 商品世代番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_TjtIdouNyNkItjhzn ADD CONSTRAINT PK_TjtIdouNyNkItjhzn PRIMARY KEY (
     nksysyno                                                 , /* 年金証書番号 */
     renno3keta                                                 /* 連番（３桁） */
) ;
