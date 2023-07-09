CREATE TABLE MT_BAK_DsKokyakuKanri (
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     dskokyakujtkbn                                     VARCHAR     (1)                                                                 ,  /* ＤＳ顧客状態区分 */
     dskokyakusakuseiymd                                VARCHAR     (8)                                                                 ,  /* ＤＳ顧客作成年月日 */
     dsteisiriyuukbn                                    VARCHAR     (1)                                                                 ,  /* ＤＳ停止理由区分 */
     dskokyakumukouymd                                  VARCHAR     (8)                                                                 ,  /* ＤＳ顧客無効年月日 */
     seisahuyouhyj                                      VARCHAR     (1)                                                                 ,  /* 精査不要表示 */
     dskokyakunmkn                                      VARCHAR     (30)                                                                ,  /* ＤＳ顧客名（カナ） */
     dskokyakunmkj                                      VARCHAR     (30)                                                                ,  /* ＤＳ顧客名（漢字） */
     dskokyakuseiymd                                    VARCHAR     (8)                                                                 ,  /* ＤＳ顧客生年月日 */
     dskokyakuyno                                       VARCHAR     (7)                                                                 ,  /* ＤＳ顧客郵便番号 */
     dskanyuukeirokbn                                   VARCHAR     (1)                                                                 ,  /* ＤＳ加入経路区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE MT_BAK_DsKokyakuKanri ADD CONSTRAINT PK_BAK_DsKokyakuKanri PRIMARY KEY (
     dskokno                                                  , /* ＤＳ顧客番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
