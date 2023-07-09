CREATE TABLE IT_HokenSyoukenHukaInfo_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     nksyuruinmsyouken                                  VARCHAR     (82)                                                                ,  /* 年金種類名称（証券用） */
     teikiikkatubaraitukisuu                            DECIMAL     (2)                                                                 ,  /* 定期一括払月数 */
     znntikiktbriyhrkgktuktype                          VARCHAR     (3)                                                                 ,  /* 前納定期一括払円貨払込額通貨タイプ */
     znntikiktbriyenhrkgk                               DECIMAL     (13)                                                                ,  /* 前納定期一括払円貨払込額 */
     znntikiktbriyenhrkgk$                              VARCHAR     (10)                                                                ,  /* 前納定期一括払円貨払込額(通貨型) */
     znnkai2                                            DECIMAL     (2)                                                                 ,  /* 前納回数（２桁） */
     hutanhiyustmkyakkjrtmin                            DECIMAL     (4,3)                                                               ,  /* ご負担費用説明欄解約控除率最小 */
     hutanhiyustmkyakkjrtmax                            DECIMAL     (4,3)                                                               ,  /* ご負担費用説明欄解約控除率最大 */
     fstpznnkngktuktype                                 VARCHAR     (3)                                                                 ,  /* 初回Ｐご確認欄前納金額通貨タイプ */
     fstpznnkngk                                        DECIMAL     (13)                                                                ,  /* 初回Ｐご確認欄前納金額 */
     fstpznnkngk$                                       VARCHAR     (10)                                                                ,  /* 初回Ｐご確認欄前納金額(通貨型) */
     dskjnkngkktuktype                                  VARCHAR     (3)                                                                 ,  /* ＤＳ基準金額通貨タイプ */
     dskjnkngk                                          DECIMAL     (13)                                                                ,  /* ＤＳ基準金額 */
     dskjnkngk$                                         VARCHAR     (10)                                                                ,  /* ＤＳ基準金額(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     tikiktbriyhrkgktuktype                             VARCHAR     (3)                                                                 ,  /* 定期一括払円貨払込額通貨タイプ */
     tikiktbriyenhrkgk                                  DECIMAL     (13)                                                                ,  /* 定期一括払円貨払込額 */
     tikiktbriyenhrkgk$                                 VARCHAR     (10)                                                                   /* 定期一括払円貨払込額(通貨型) */
)
;

ALTER TABLE IT_HokenSyoukenHukaInfo_Z ADD CONSTRAINT PK_HokenSyoukenHukaInfo PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;

CREATE INDEX IX1_HokenSyoukenHukaInfo ON IT_HokenSyoukenHukaInfo_Z (
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;

CREATE INDEX IX2_HokenSyoukenHukaInfo ON IT_HokenSyoukenHukaInfo_Z (
     tyouhyouymd                                                /* 帳票作成日 */
) ;
