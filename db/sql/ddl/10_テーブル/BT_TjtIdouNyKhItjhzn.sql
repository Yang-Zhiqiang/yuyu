CREATE TABLE BT_TjtIdouNyKhItjhzn (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     recordsakujyohyouji                                NUMBER      (1)                                                                 ,  /* レコード削除表示 */
     youkyuuno                                          VARCHAR     (18)                                                                ,  /* 要求通番 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     kykjyoutai                                         VARCHAR     (2)                                                                 ,  /* 契約状態 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     yuukousyoumetukbn                                  VARCHAR     (1)                                                                 ,  /* 有効消滅区分 */
     syoumetujiyuu                                      VARCHAR     (2)                                                                 ,  /* 消滅事由 */
     syoumetuymd                                        VARCHAR     (8)                                                                 ,  /* 消滅日 */
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
     ttdktyuuikbn1                                      VARCHAR     (2)                                                                 ,  /* 手続注意区分１ */
     ttdktyuuikbn2                                      VARCHAR     (2)                                                                 ,  /* 手続注意区分２ */
     ttdktyuuikbn3                                      VARCHAR     (2)                                                                 ,  /* 手続注意区分３ */
     ttdktyuuikbn4                                      VARCHAR     (2)                                                                 ,  /* 手続注意区分４ */
     ttdktyuuikbn5                                      VARCHAR     (2)                                                                 ,  /* 手続注意区分５ */
     syouhnsdno                                         NUMBER      (2)                                                                 ,  /* 商品世代番号 */
     kaigomaehrtkykumukbn                               VARCHAR     (1)                                                                 ,  /* 介護前払特約有無区分 */
     pyennykntkykumukbn                                 VARCHAR     (1)                                                                 ,  /* 保険料円入金特約有無区分 */
     tsnyennyknkgk                                      NUMBER      (13)                                                                ,  /* 通算用円入金額 */
     tsnyennyknkgk$                                     VARCHAR     (10)                                                                ,  /* 通算用円入金額(通貨型) */
     skjmosno                                           VARCHAR     (20)                                                                ,  /* 新契約時申込番号 */
     houteityotkseisyouhnhyj                            VARCHAR     (1)                                                                 ,  /* 法定貯蓄性商品表示 */
     seiritujitrhkjikakkbn                              VARCHAR     (1)                                                                 ,  /* 成立時取引時確認区分 */
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

ALTER TABLE BT_TjtIdouNyKhItjhzn ADD CONSTRAINT PK_TjtIdouNyKhItjhzn PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     renno3keta                                                 /* 連番（３桁） */
) ;
