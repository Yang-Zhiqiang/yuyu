CREATE TABLE IT_BAK_HokenSyoukenHukaInfo (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     nksyuruinmsyouken                                  VARCHAR     (40)                                                                ,  /* 年金種類名称（証券用） */
     teikiikkatubaraitukisuu                            NUMBER      (2)                                                                 ,  /* 定期一括払月数 */
     znntikiktbriyhrkgktuktype                          VARCHAR     (3)                                                                 ,  /* 前納定期一括払円貨払込額通貨タイプ */
     znntikiktbriyenhrkgk                               NUMBER      (13)                                                                ,  /* 前納定期一括払円貨払込額 */
     znntikiktbriyenhrkgk$                              VARCHAR     (10)                                                                ,  /* 前納定期一括払円貨払込額(通貨型) */
     znnkai2                                            NUMBER      (2)                                                                 ,  /* 前納回数（２桁） */
     hutanhiyustmkyakkjrtmin                            NUMBER      (4,3)                                                               ,  /* ご負担費用説明欄解約控除率最小 */
     hutanhiyustmkyakkjrtmax                            NUMBER      (4,3)                                                               ,  /* ご負担費用説明欄解約控除率最大 */
     fstpznnkngktuktype                                 VARCHAR     (3)                                                                 ,  /* 初回Ｐご確認欄前納金額通貨タイプ */
     fstpznnkngk                                        NUMBER      (13)                                                                ,  /* 初回Ｐご確認欄前納金額 */
     fstpznnkngk$                                       VARCHAR     (10)                                                                ,  /* 初回Ｐご確認欄前納金額(通貨型) */
     dskjnkngkktuktype                                  VARCHAR     (3)                                                                 ,  /* ＤＳ基準金額通貨タイプ */
     dskjnkngk                                          NUMBER      (13)                                                                ,  /* ＤＳ基準金額 */
     dskjnkngk$                                         VARCHAR     (10)                                                                ,  /* ＤＳ基準金額(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     tikiktbriyhrkgktuktype                             VARCHAR     (3)                                                                 ,  /* 定期一括払円貨払込額通貨タイプ */
     tikiktbriyenhrkgk                                  NUMBER      (13)                                                                ,  /* 定期一括払円貨払込額 */
     tikiktbriyenhrkgk$                                 VARCHAR     (10)                                                                   /* 定期一括払円貨払込額(通貨型) */
)
;

ALTER TABLE IT_BAK_HokenSyoukenHukaInfo ADD CONSTRAINT PK_BAK_HokenSyoukenHukaInfo PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     tyouhyouymd                                                /* 帳票作成日 */
) ;
