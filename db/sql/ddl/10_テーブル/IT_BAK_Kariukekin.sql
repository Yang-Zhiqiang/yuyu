CREATE TABLE IT_BAK_Kariukekin (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     krkno                                              NUMBER      (5)                                                       NOT NULL  ,  /* 仮受番号 */
     krkkeijyoymd                                       VARCHAR     (8)                                                                 ,  /* 仮受計上処理日 */
     krkgk                                              NUMBER      (13)                                                                ,  /* 仮受金額 */
     krkgk$                                             VARCHAR     (10)                                                                ,  /* 仮受金額(通貨型) */
     hasseidenymd                                       VARCHAR     (8)                                                                 ,  /* 発生伝票日付 */
     seisandenymd                                       VARCHAR     (8)                                                                 ,  /* 精算伝票日付 */
     krkseisanzumiflg                                   VARCHAR     (1)                                                                 ,  /* 仮受精算済フラグ */
     krkriyuukbn                                        VARCHAR     (2)                                                                 ,  /* 仮受理由区分 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     nykkeiro                                           VARCHAR     (2)                                                                 ,  /* 入金経路 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuuy                                      NUMBER      (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      NUMBER      (2)                                                                 ,  /* 充当回数（月） */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     creditkessaiyouno                                  VARCHAR     (26)                                                                   /* クレジットカード決済用番号 */
)
;

ALTER TABLE IT_BAK_Kariukekin ADD CONSTRAINT PK_BAK_Kariukekin PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     krkno                                                      /* 仮受番号 */
) ;
