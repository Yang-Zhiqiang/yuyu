CREATE TABLE JT_SateiSyouninRireki (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     sateisyouninskbtkey                                VARCHAR     (18)                                                      NOT NULL  ,  /* 査定承認識別キー */
     seikyuurirekino                                    NUMBER      (3)                                                                 ,  /* 請求履歴番号 */
     syorikekkakbn                                      VARCHAR     (3)                                                                 ,  /* 処理結果区分 */
     tennousakisousasyacd                               VARCHAR     (15)                                                                ,  /* 転送先操作者コード */
     hushrgeninkbn                                      VARCHAR     (2)                                                                 ,  /* 不支払原因区分 */
     higaitouriyuukbn                                   VARCHAR     (2)                                                                 ,  /* 非該当理由区分 */
     reportcomment                                      VARCHAR     (1248)                                                              ,  /* 帳票用コメント */
     sessyouyhkbn                                       VARCHAR     (1)                                                                 ,  /* 折衝要否区分 */
     sessyousisyacd                                     VARCHAR     (3)                                                                 ,  /* 折衝支社コード */
     kaiketuymd                                         VARCHAR     (8)                                                                 ,  /* 解決日 */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE JT_SateiSyouninRireki ADD CONSTRAINT PK_SateiSyouninRireki PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     sateisyouninskbtkey                                        /* 査定承認識別キー */
) ;
