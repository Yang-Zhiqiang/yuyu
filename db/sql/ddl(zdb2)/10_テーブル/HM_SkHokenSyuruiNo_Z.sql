CREATE TABLE HM_SkHokenSyuruiNo_Z (
     hknsyuruino                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 保険種類番号 */
     hknsyuruinosd                                      DECIMAL     (3)                                                       NOT NULL  ,  /* 保険種類番号世代 */
     hyoujifromymd                                      VARCHAR     (8)                                                                 ,  /* 表示日自 */
     hyoujitoymd                                        VARCHAR     (8)                                                                 ,  /* 表示日至 */
     hknsyuruinm                                        VARCHAR     (82)                                                                ,  /* 保険種類名 */
     hknsyuruiworklist                                  VARCHAR     (18)                                                                ,  /* 保険種類名（ワークリスト用） */
     inputctrlsyouhncd                                  VARCHAR     (4)                                                                 ,  /* 入力制御用商品コード */
     inputctrlsyouhnsdno                                DECIMAL     (2)                                                                 ,  /* 入力制御用商品世代番号 */
     dai1hknkknselect                                   VARCHAR     (100)                                                               ,  /* 第１保険期間選択肢 */
     targettkmkhtselect                                 VARCHAR     (100)                                                               ,  /* ターゲット特約目標値選択肢 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     syohnsortno                                        DECIMAL     (3)                                                                 ,  /* 商品ソート番号 */
     hknsyuruinmsyanaidisp                              VARCHAR     (82)                                                                ,  /* 保険種類名（社内表示用） */
     daihyouhknsyuruino                                 VARCHAR     (3)                                                                    /* 代表保険種類番号 */
)
;

ALTER TABLE HM_SkHokenSyuruiNo_Z ADD CONSTRAINT PK_SkHokenSyuruiNo PRIMARY KEY (
     hknsyuruino                                              , /* 保険種類番号 */
     hknsyuruinosd                                              /* 保険種類番号世代 */
) ;
