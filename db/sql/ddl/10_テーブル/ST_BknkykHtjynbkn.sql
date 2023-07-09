CREATE TABLE ST_BknkykHtjynbkn (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     kakutyoujobcd                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 拡張ジョブコード */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     hknsyukigou                                        VARCHAR     (2)                                                                 ,  /* 保険種類記号 */
     haraikomikaisukbn                                  VARCHAR     (1)                                                                 ,  /* 払込回数区分 */
     hrkkeirokbn                                        VARCHAR     (1)                                                                 ,  /* 払込経路区分 */
     annaihuyouriyuukbn                                 VARCHAR     (2)                                                                 ,  /* 案内不要理由区分 */
     bikinkbn                                           VARCHAR     (1)                                                                 ,  /* 備金区分 */
     bikinnendokbn                                      VARCHAR     (1)                                                                 ,  /* 備金年度区分 */
     seisand                                            NUMBER      (13)                                                                ,  /* 精算Ｄ */
     seisand$                                           VARCHAR     (10)                                                                ,  /* 精算Ｄ(通貨型) */
     tumitaterisoku                                     NUMBER      (11)                                                                ,  /* 積立利息 */
     tumitaterisoku$                                    VARCHAR     (10)                                                                ,  /* 積立利息(通貨型) */
     syuruicd1                                          VARCHAR     (1)                                                                 ,  /* 種類コード１ */
     syuruicd3                                          VARCHAR     (2)                                                                 ,  /* 種類コード３ */
     srkijyunym                                         VARCHAR     (6)                                                       NOT NULL  ,  /* 数理用基準年月 */
     kbnkeiriyousegmentkbn                              VARCHAR     (2)                                                                 ,  /* 区分経理用セグメント区分 */
     kbnkeiriyourgnbnskkbn                              VARCHAR     (2)                                                                 ,  /* 区分経理用利源分析区分 */
     syuruicd2                                          VARCHAR     (1)                                                                 ,  /* 種類コード２ */
     kariwariatedganrikin                               NUMBER      (11)                                                                ,  /* 仮割当Ｄ元利金 */
     kariwariatedganrikin$                              VARCHAR     (10)                                                                ,  /* 仮割当Ｄ元利金(通貨型) */
     kariwariatedrisoku                                 NUMBER      (11)                                                                ,  /* 仮割当Ｄ利息 */
     kariwariatedrisoku$                                VARCHAR     (10)                                                                ,  /* 仮割当Ｄ利息(通貨型) */
     syukeiyakusyuruicd                                 VARCHAR     (2)                                                                 ,  /* 主契約種類コード */
     kyknendo                                           VARCHAR     (4)                                                                 ,  /* 契約年度 */
     daihyouyoteiriritu                                 NUMBER      (5,4)                                                               ,  /* 代表予定利率 */
     haraikatakbn                                       VARCHAR     (2)                                                                 ,  /* 払方区分 */
     yobiv32                                            VARCHAR     (32)                                                                ,  /* 予備項目Ｖ３２ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ST_BknkykHtjynbkn ADD CONSTRAINT PK_BknkykHtjynbkn PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     kakutyoujobcd                                            , /* 拡張ジョブコード */
     syono                                                    , /* 証券番号 */
     srkijyunym                                                 /* 数理用基準年月 */
) ;
