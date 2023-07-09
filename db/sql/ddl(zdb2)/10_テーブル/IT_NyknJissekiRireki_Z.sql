CREATE TABLE IT_NyknJissekiRireki_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     jyutoustartym                                      VARCHAR     (6)                                                       NOT NULL  ,  /* 充当開始年月 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     jyutouendym                                        VARCHAR     (6)                                                                 ,  /* 充当終了年月 */
     rsgaku                                             DECIMAL     (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     rstuukasyu                                         VARCHAR     (3)                                                                 ,  /* 領収通貨種類 */
     ryosyukwsratekjymd                                 VARCHAR     (8)                                                                 ,  /* 領収為替レート基準日 */
     ryosyukwsrate                                      DECIMAL     (7,4)                                                               ,  /* 領収為替レート */
     hrkp                                               DECIMAL     (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     iktwaribikikgk                                     DECIMAL     (13)                                                                ,  /* 一括割引料 */
     iktwaribikikgk$                                    VARCHAR     (10)                                                                ,  /* 一括割引料(通貨型) */
     nyksyoriymd                                        VARCHAR     (8)                                                                 ,  /* 入金処理日 */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     nykdenno                                           VARCHAR     (20)                                                                ,  /* 入金伝票番号 */
     nykdenymd                                          VARCHAR     (8)                                                                 ,  /* 入金伝票日付 */
     nykkeiro                                           VARCHAR     (2)                                                                 ,  /* 入金経路 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     jyutoukaisuuy                                      DECIMAL     (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      DECIMAL     (2)                                                                 ,  /* 充当回数（月） */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     iktnyuukinnumu                                     VARCHAR     (1)                                                                 ,  /* 一括入金有無 */
     nyktrksflg                                         VARCHAR     (1)                                                                 ,  /* 入金取消フラグ */
     nyktrksymd                                         VARCHAR     (8)                                                                 ,  /* 入金取消処理日 */
     nyktrksdenno                                       VARCHAR     (20)                                                                ,  /* 入金取消伝票番号 */
     nyktrksdenymd                                      VARCHAR     (8)                                                                 ,  /* 入金取消伝票日付 */
     yenkansannyknkingk                                 DECIMAL     (13)                                                                ,  /* 円換算入金額 */
     yenkansannyknkingk$                                VARCHAR     (10)                                                                ,  /* 円換算入金額(通貨型) */
     yenkansantkykwsrateymd                             VARCHAR     (8)                                                                 ,  /* 円換算適用為替レート基準日 */
     yenkansantkykwsrate                                DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     ikkatuyoupkaisuu                                   DECIMAL     (2)                                                                 ,  /* 一括要Ｐ回数 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     creditkessaiyouno                                  VARCHAR     (26)                                                                   /* クレジットカード決済用番号 */
)
;

ALTER TABLE IT_NyknJissekiRireki_Z ADD CONSTRAINT PK_NyknJissekiRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     jyutoustartym                                            , /* 充当開始年月 */
     renno                                                      /* 連番 */
) ;

CREATE INDEX IX1_NyknJissekiRireki ON IT_NyknJissekiRireki_Z (
     jyutoustartym                                              /* 充当開始年月 */
) ;

CREATE INDEX IX2_NyknJissekiRireki ON IT_NyknJissekiRireki_Z (
     jyutouendym                                                /* 充当終了年月 */
) ;

CREATE INDEX IX3_NyknJissekiRireki ON IT_NyknJissekiRireki_Z (
     ryosyuymd                                                  /* 領収日 */
) ;

CREATE INDEX IX4_NyknJissekiRireki ON IT_NyknJissekiRireki_Z (
     syono                                                    , /* 証券番号 */
     jyutoustartym                                            , /* 充当開始年月 */
     renno                                                      /* 連番 */
) ;
