CREATE TABLE BT_TjtIdouNySk (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     recordsakujyohyouji                                NUMBER      (1)                                                                 ,  /* レコード削除表示 */
     youkyuuno                                          VARCHAR     (18)                                                                ,  /* 要求通番 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     mosymd                                             VARCHAR     (8)                                                                 ,  /* 申込日 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     sknnkaisiymd                                       VARCHAR     (8)                                                                 ,  /* 責任開始日 */
     seiritukbn                                         VARCHAR     (2)                                                                 ,  /* 成立区分 */
     srsyoriymd                                         VARCHAR     (8)                                                                 ,  /* 成立処理日 */
     mfrenflg                                           VARCHAR     (1)                                                                 ,  /* ＭＦ連動済フラグ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     tsntuukasyu                                        VARCHAR     (3)                                                                 ,  /* 通算用通貨種類 */
     tsnyousibous                                       NUMBER      (13)                                                                ,  /* 通算用死亡Ｓ */
     tsnyousibous$                                      VARCHAR     (10)                                                                ,  /* 通算用死亡Ｓ(通貨型) */
     tsnyouitijip                                       NUMBER      (13)                                                                ,  /* 通算用一時払Ｐ */
     tsnyouitijip$                                      VARCHAR     (10)                                                                ,  /* 通算用一時払Ｐ(通貨型) */
     tsnyounkgns                                        NUMBER      (13)                                                                ,  /* 通算用年金原資 */
     tsnyounkgns$                                       VARCHAR     (10)                                                                ,  /* 通算用年金原資(通貨型) */
     hrkkkn                                             NUMBER      (2)                                                                 ,  /* 払込期間 */
     sntkhoukbn                                         VARCHAR     (2)                                                                 ,  /* 選択方法区分 */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     kykhhkndouhyouji                                   NUMBER      (1)                                                                 ,  /* 契約者被保険者同一表示 */
     mossyoumetukbn                                     VARCHAR     (1)                                                                 ,  /* 申込消滅区分 */
     syouhnsdno                                         NUMBER      (2)                                                                 ,  /* 商品世代番号 */
     kaigomaehrtkykumukbn                               VARCHAR     (1)                                                                 ,  /* 介護前払特約有無区分 */
     pyennykntkykumukbn                                 VARCHAR     (1)                                                                 ,  /* 保険料円入金特約有無区分 */
     tsnyennyknkgk                                      NUMBER      (13)                                                                ,  /* 通算用円入金額 */
     tsnyennyknkgk$                                     VARCHAR     (10)                                                                ,  /* 通算用円入金額(通貨型) */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_TjtIdouNySk ADD CONSTRAINT PK_TjtIdouNySk PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     renno3keta                                                 /* 連番（３桁） */
) ;
