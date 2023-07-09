CREATE TABLE BT_TjtIdouNyNk_Z (
     nksysyno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 年金証書番号 */
     renno3keta                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     recordsakujyohyouji                                DECIMAL     (1)                                                                 ,  /* レコード削除表示 */
     youkyuuno                                          VARCHAR     (18)                                                                ,  /* 要求通番 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     nkshrstartymd                                      VARCHAR     (8)                                                                 ,  /* 年金支払開始日 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     nksyoumetucd                                       VARCHAR     (2)                                                                 ,  /* 年金消滅コード */
     syoumetuymd                                        VARCHAR     (8)                                                                 ,  /* 消滅日 */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     teinksyu                                           VARCHAR     (4)                                                                 ,  /* 定額年金年金種類 */
     tsnyounkgns                                        DECIMAL     (13)                                                                ,  /* 通算用年金原資 */
     tsnyounkgns$                                       VARCHAR     (10)                                                                ,  /* 通算用年金原資(通貨型) */
     nkukthhkndouhyouji                                 DECIMAL     (1)                                                                 ,  /* 年金受取人被保険者同一表示 */
     syouhnsdno                                         DECIMAL     (2)                                                                 ,  /* 商品世代番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_TjtIdouNyNk_Z ADD CONSTRAINT PK_TjtIdouNyNk PRIMARY KEY (
     nksysyno                                                 , /* 年金証書番号 */
     renno3keta                                                 /* 連番（３桁） */
) ;
