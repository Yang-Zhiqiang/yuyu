CREATE TABLE ST_YuukoukykHtjynbknTmttd_Z (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     kakutyoujobcd                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 拡張ジョブコード */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     hknsyukigou                                        VARCHAR     (2)                                                                 ,  /* 保険種類記号 */
     haraikomikaisukbn                                  VARCHAR     (1)                                                                 ,  /* 払込回数区分 */
     hrkkeirokbn                                        VARCHAR     (1)                                                                 ,  /* 払込経路区分 */
     annaihuyouriyuukbn                                 VARCHAR     (2)                                                                 ,  /* 案内不要理由区分 */
     zennendkurikosid                                   DECIMAL     (11)                                                                ,  /* 前年度繰越Ｄ */
     zennendkurikosid$                                  VARCHAR     (10)                                                                ,  /* 前年度繰越Ｄ(通貨型) */
     tounendod                                          DECIMAL     (13)                                                                ,  /* 当年度Ｄ */
     tounendod$                                         VARCHAR     (10)                                                                ,  /* 当年度Ｄ(通貨型) */
     tndmatutumitated                                   DECIMAL     (11)                                                                ,  /* 当年度末積立Ｄ */
     tndmatutumitated$                                  VARCHAR     (10)                                                                ,  /* 当年度末積立Ｄ(通貨型) */
     tumitaterisoku                                     DECIMAL     (11)                                                                ,  /* 積立利息 */
     tumitaterisoku$                                    VARCHAR     (10)                                                                ,  /* 積立利息(通貨型) */
     hsys                                               DECIMAL     (13)                                                                ,  /* 保障Ｓ */
     hsys$                                              VARCHAR     (10)                                                                ,  /* 保障Ｓ(通貨型) */
     syuruicd1                                          VARCHAR     (1)                                                                 ,  /* 種類コード１ */
     syuruicd3                                          VARCHAR     (2)                                                                 ,  /* 種類コード３ */
     srutiwake                                          VARCHAR     (2)                                                                 ,  /* 数理用内訳 */
     srkijyunym                                         VARCHAR     (6)                                                       NOT NULL  ,  /* 数理用基準年月 */
     kbnkeiriyousegmentkbn                              VARCHAR     (2)                                                                 ,  /* 区分経理用セグメント区分 */
     kbnkeiriyourgnbnskkbn                              VARCHAR     (2)                                                                 ,  /* 区分経理用利源分析区分 */
     syuruicd2                                          VARCHAR     (1)                                                                 ,  /* 種類コード２ */
     mankitouraiym                                      VARCHAR     (6)                                                                 ,  /* 満期到来年月 */
     syukeiyakusyuruicd                                 VARCHAR     (2)                                                                 ,  /* 主契約種類コード */
     kyknendo                                           VARCHAR     (4)                                                                 ,  /* 契約年度 */
     daihyouyoteiriritu                                 DECIMAL     (5,4)                                                               ,  /* 代表予定利率 */
     haraikatakbn                                       VARCHAR     (2)                                                                 ,  /* 払方区分 */
     yobiv20                                            VARCHAR     (20)                                                                ,  /* 予備項目Ｖ２０ */
     srhaitoukinsyuukeiptnkbn                           VARCHAR     (2)                                                                 ,  /* 数理配当金集計パターン区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ST_YuukoukykHtjynbknTmttd_Z ADD CONSTRAINT PK_YuukoukykHtjynbknTmttd PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     kakutyoujobcd                                            , /* 拡張ジョブコード */
     syono                                                    , /* 証券番号 */
     srkijyunym                                                 /* 数理用基準年月 */
) ;
