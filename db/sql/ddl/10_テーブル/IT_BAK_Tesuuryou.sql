CREATE TABLE IT_BAK_Tesuuryou (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     tsrysyorikbn                                       VARCHAR     (3)                                                       NOT NULL  ,  /* 手数料処理区分 */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     kouryokuhasseiym                                   VARCHAR     (6)                                                                 ,  /* 効力発生年月 */
     nyknkaisuuy                                        NUMBER      (2)                                                                 ,  /* 入金回数（年） */
     nyknkaisuum                                        NUMBER      (2)                                                                 ,  /* 入金回数（月） */
     mikeikapariflg                                     VARCHAR     (1)                                                                 ,  /* 未経過Ｐ有フラグ */
     misyuupariflg                                      VARCHAR     (1)                                                                 ,  /* 未収Ｐ有フラグ */
     mikeikap                                           NUMBER      (13)                                                                ,  /* 未経過保険料 */
     mikeikap$                                          VARCHAR     (10)                                                                ,  /* 未経過保険料(通貨型) */
     seisekiym                                          VARCHAR     (6)                                                                 ,  /* 成績計上年月 */
     iktp                                               NUMBER      (13)                                                                ,  /* 一括払保険料 */
     iktp$                                              VARCHAR     (10)                                                                ,  /* 一括払保険料(通貨型) */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     hrkp                                               NUMBER      (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     haitounendo                                        VARCHAR     (4)                                                                 ,  /* 配当年度 */
     cifcd                                              VARCHAR     (15)                                                                ,  /* ＣＩＦコード */
     smbckanriid                                        VARCHAR     (11)                                                                ,  /* ＳＭＢＣ受付管理ＩＤ */
     boskykjyoutai                                      VARCHAR     (1)                                                                 ,  /* 募集契約状態 */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     nyknymd                                            VARCHAR     (8)                                                                 ,  /* 入金日 */
     yenkansantkykwsrate                                NUMBER      (7,4)                                                               ,  /* 円換算適用為替レート */
     yenkansantkykwsrateymd                             VARCHAR     (8)                                                                 ,  /* 円換算適用為替レート基準日 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_BAK_Tesuuryou ADD CONSTRAINT PK_BAK_Tesuuryou PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     tsrysyorikbn                                             , /* 手数料処理区分 */
     renno                                                      /* 連番 */
) ;
