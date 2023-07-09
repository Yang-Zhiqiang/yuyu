CREATE TABLE JM_SkNaiyouChk (
     sknaiyouchkkbn                                     VARCHAR     (5)                                                       NOT NULL  ,  /* 請求内容チェック区分 */
     yobidasimototaskkbn                                VARCHAR     (2)                                                       NOT NULL  ,  /* 呼出元タスク区分 */
     msgsyubetu                                         VARCHAR     (1)                                                                 ,  /* メッセージ種別 */
     sateikaisouyouhikbn                                VARCHAR     (1)                                                                 ,  /* 査定回送要否区分 */
     keisankahikbn                                      VARCHAR     (1)                                                                 ,  /* 計算可否区分 */
     messageId                                          VARCHAR     (7)                                                                 ,  /* メッセージＩＤ */
     msghikisuunaiyoukbn1                               VARCHAR     (1)                                                                 ,  /* メッセージ引数内容区分１ */
     msghikisuu1                                        VARCHAR     (50)                                                                ,  /* メッセージ引数１ */
     msghikisuunaiyoukbn2                               VARCHAR     (1)                                                                 ,  /* メッセージ引数内容区分２ */
     msghikisuu2                                        VARCHAR     (50)                                                                ,  /* メッセージ引数２ */
     msghikisuunaiyoukbn3                               VARCHAR     (1)                                                                 ,  /* メッセージ引数内容区分３ */
     msghikisuu3                                        VARCHAR     (50)                                                                ,  /* メッセージ引数３ */
     msghikisuunaiyoukbn4                               VARCHAR     (1)                                                                 ,  /* メッセージ引数内容区分４ */
     msghikisuu4                                        VARCHAR     (50)                                                                ,  /* メッセージ引数４ */
     msghikisuunaiyoukbn5                               VARCHAR     (1)                                                                 ,  /* メッセージ引数内容区分５ */
     msghikisuu5                                        VARCHAR     (50)                                                                ,  /* メッセージ引数５ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE JM_SkNaiyouChk ADD CONSTRAINT PK_SkNaiyouChk PRIMARY KEY (
     sknaiyouchkkbn                                           , /* 請求内容チェック区分 */
     yobidasimototaskkbn                                        /* 呼出元タスク区分 */
) ;
