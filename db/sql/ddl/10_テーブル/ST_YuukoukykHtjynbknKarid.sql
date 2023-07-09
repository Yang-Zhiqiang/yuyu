CREATE TABLE ST_YuukoukykHtjynbknKarid (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     kakutyoujobcd                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 拡張ジョブコード */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     hknsyukigou                                        VARCHAR     (2)                                                                 ,  /* 保険種類記号 */
     haraikomikaisukbn                                  VARCHAR     (1)                                                                 ,  /* 払込回数区分 */
     hrkkeirokbn                                        VARCHAR     (1)                                                                 ,  /* 払込経路区分 */
     annaihuyouriyuukbn                                 VARCHAR     (2)                                                                 ,  /* 案内不要理由区分 */
     znnndkrkskrwratdruigk                              NUMBER      (11)                                                                ,  /* 前年度繰越仮割当Ｄ累計額 */
     znnndkrkskrwratdruigk$                             VARCHAR     (10)                                                                ,  /* 前年度繰越仮割当Ｄ累計額(通貨型) */
     tounendokariwariated                               NUMBER      (11)                                                                ,  /* 当年度仮割当Ｄ */
     tounendokariwariated$                              VARCHAR     (10)                                                                ,  /* 当年度仮割当Ｄ(通貨型) */
     tndmatukrkskrwratdruigk                            NUMBER      (11)                                                                ,  /* 当年度末仮割当Ｄ累計額 */
     tndmatukrkskrwratdruigk$                           VARCHAR     (10)                                                                ,  /* 当年度末仮割当Ｄ累計額(通貨型) */
     kariwariatedrisoku                                 NUMBER      (11)                                                                ,  /* 仮割当Ｄ利息 */
     kariwariatedrisoku$                                VARCHAR     (10)                                                                ,  /* 仮割当Ｄ利息(通貨型) */
     hsys                                               NUMBER      (13)                                                                ,  /* 保障Ｓ */
     hsys$                                              VARCHAR     (10)                                                                ,  /* 保障Ｓ(通貨型) */
     yobiv3                                             VARCHAR     (3)                                                                 ,  /* 予備項目Ｖ３ */
     srutiwake                                          VARCHAR     (2)                                                                 ,  /* 数理用内訳 */
     srkijyunym                                         VARCHAR     (6)                                                       NOT NULL  ,  /* 数理用基準年月 */
     kbnkeiriyousegmentkbn                              VARCHAR     (2)                                                                 ,  /* 区分経理用セグメント区分 */
     kbnkeiriyourgnbnskkbn                              VARCHAR     (2)                                                                 ,  /* 区分経理用利源分析区分 */
     seisikiwariatenendohyj                             VARCHAR     (1)                                                                 ,  /* 正式割当年度表示 */
     mankitouraiym                                      VARCHAR     (6)                                                                 ,  /* 満期到来年月 */
     syukeiyakusyuruicd                                 VARCHAR     (2)                                                                 ,  /* 主契約種類コード */
     kyknendo                                           VARCHAR     (4)                                                                 ,  /* 契約年度 */
     daihyouyoteiriritu                                 NUMBER      (5,4)                                                               ,  /* 代表予定利率 */
     haraikatakbn                                       VARCHAR     (2)                                                                 ,  /* 払方区分 */
     yobiv20                                            VARCHAR     (20)                                                                ,  /* 予備項目Ｖ２０ */
     srhaitoukinsyuukeiptnkbn                           VARCHAR     (2)                                                                 ,  /* 数理配当金集計パターン区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ST_YuukoukykHtjynbknKarid ADD CONSTRAINT PK_YuukoukykHtjynbknKarid PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     kakutyoujobcd                                            , /* 拡張ジョブコード */
     syono                                                    , /* 証券番号 */
     srkijyunym                                                 /* 数理用基準年月 */
) ;
